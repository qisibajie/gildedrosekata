package com.refactor.adapter.xml;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class DOMBuilderTest extends AbstractBuilderTest {
	protected OutputBuilder createOutputBuilder(String rootName) {
		return new DOMBuilder(rootName);
	}

	@Test
	public void testDocument() {
		String expectedRootName = "orders";
		DOMBuilder builder = new DOMBuilder(expectedRootName);
		builder.addBelow("order");
		builder.addAttribute("num", "123");
		builder.addBelow("item");
		builder.addValue("bird feeder");
		Document doc = builder.getDocument();
		Node root = doc.getFirstChild();
		String rootName = root.getNodeName();
		assertEquals("root name", expectedRootName, rootName);
		String firstChildName = root.getFirstChild().getNodeName();
		assertEquals("first child", "order", firstChildName);
	}
}
