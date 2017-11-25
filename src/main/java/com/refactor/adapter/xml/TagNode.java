package com.refactor.adapter.xml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TagNode {
	private String name = "";
	private StringBuffer attributes;
	private List children;
	private String value = "";

	public TagNode(String name) {
		this.name = name;
		attributes = new StringBuffer("");
	}

	public void add(TagNode childNode) {
		children().add(childNode);
	}

	public void addAttribute(String attribute, String value) {
		attributes.append(" ");
		attributes.append(attribute);
		attributes.append("='");
		attributes.append(value);
		attributes.append("'");
	}

	public void addValue(String value) {
		this.value = value;
	}

	public List children() {
		if (children == null)
			children = new ArrayList();
		return children;
	}

	public String toString() {
		return toStringHelper(new StringBuffer(""));
	}

	protected String toStringHelper(StringBuffer result) {
		writeOpenTagTo(result);
		writeValueTo(result);
		writeChildrenTo(result);
		writeEndTagTo(result);
		return result.toString();
	}

	protected void writeChildrenTo(StringBuffer result) {
		Iterator it = children().iterator();
		while (it.hasNext()) {
			TagNode node = (TagNode) it.next();
			node.toStringHelper(result);
		}
	}

	private void writeValueTo(StringBuffer result) {
		if (!value.equals(""))
			result.append(value);
	}

	protected void writeEndTagTo(StringBuffer result) {
		result.append("</");
		result.append(name);
		result.append(">");
	}

	protected void writeOpenTagTo(StringBuffer result) {
		result.append("<");
		result.append(name);
		result.append(attributes.toString());
		result.append(">");
	}
}
