package com.refactor.adapter.xml;

import com.refactor.adapter.xml.AbstractBuilder;

import java.util.Stack;

public class XMLBuilder extends AbstractBuilder {
	private TagNode root;
	private TagNode parent;
	private TagNode current;

	public XMLBuilder(String rootName) {
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
		current = (TagNode) history.peek();
		addBelow(uncle);
	}

	public void addGrandfather(String uncle) {
		if (current == root)
			throw new RuntimeException(CANNOT_ADD_ABOVE_ROOT);
		history.pop();
		boolean atRootNode = (history.size() == 1);
		if (atRootNode)
			throw new RuntimeException(CANNOT_ADD_ABOVE_ROOT);
		history.pop();
		history.pop();
		current = (TagNode) history.peek();
		addBelow(uncle);
	}

	public void addAttribute(String name, String value) {
		current.addAttribute(name, value);
	}

	public void addBelow(String child) {
		TagNode childNode = new TagNode(child);
		current.add(childNode);
		parent = current;
		current = childNode;
		history.push(current);
	}

	public void addBeside(String sibling) {
		if (current == root)
			throw new RuntimeException(CANNOT_ADD_BESIDE_ROOT);
		TagNode siblingNode = new TagNode(sibling);
		parent.add(siblingNode);
		current = siblingNode;
		history.pop();
		history.push(current);
	}

	public void addValue(String value) {
		current.addValue(value);
	}

	protected void init(String rootName) {
		root = new TagNode(rootName);
		current = root;
		parent = root;
		history = new Stack();
		history.push(current);
	}

	public void startNewBuild(String rootName) {
		init(rootName);
	}

	public String toString() {
		return root.toString();
	}
}
