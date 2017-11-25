package com.refactor.adapter.xml;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Stack;

import org.apache.xerces.dom.DocumentImpl;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DOMBuilder extends AbstractBuilder {
	private Document doc;
	private Element root;
	private Element parent;
	private Element current;

	public DOMBuilder(String rootName) {
		init(rootName);
	}

	public void addAbove(String uncle) {
		if (current == root)
			throw new RuntimeException(CANNOT_ADD_ABOVE_ROOT);
		history.pop();
		boolean atRootNode = (history.size() == 1);
		if (atRootNode)
			throw new RuntimeException(CANNOT_ADD_ABOVE_ROOT);
		history.pop();
		current = (Element) history.peek();
		addBelow(uncle);
	}

	public void addGrandfather(String grandfather) {
		if (current == root)
			throw new RuntimeException(CANNOT_ADD_ABOVE_ROOT);
		history.pop();
		boolean atRootNode = (history.size() == 1);
		if (atRootNode)
			throw new RuntimeException(CANNOT_ADD_ABOVE_ROOT);
		history.pop();
		history.pop();
		current = (Element) history.peek();
		addBelow(grandfather);
	}

	public void addAttribute(String name, String value) {
		current.setAttribute(name, value);
	}

	public void addBelow(String child) {
		Element childNode = doc.createElement(child);
		current.appendChild(childNode);
		parent = current;
		current = childNode;
		history.push(current);
	}

	public void addBeside(String sibling) {
		if (current == root)
			throw new RuntimeException(CANNOT_ADD_BESIDE_ROOT);
		Element siblingNode = doc.createElement(sibling);
		parent.appendChild(siblingNode);
		current = siblingNode;
		history.pop();
		history.push(current);
	}

	public void addValue(String value) {
		current.appendChild(doc.createTextNode(value));
	}

	public Document getDocument() {
		return doc;
	}

	protected void init(String rootName) {
		doc = new DocumentImpl();
		root = doc.createElement(rootName);
		doc.appendChild(root);
		current = root;
		parent = root;
		history = new Stack();
		history.push(current);
	}

	public void startNewBuild(String rootName) {
		init(rootName);
	}

	public String toString() {
		OutputFormat format = new OutputFormat(doc);
		StringWriter stringOut = new StringWriter();
		XMLSerializer serial = new XMLSerializer(stringOut, format);
		try {
			serial.asDOMSerializer();
			serial.serialize(doc.getDocumentElement());
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return ioe.getMessage();
		}
		return stringOut.toString();
	}
}
