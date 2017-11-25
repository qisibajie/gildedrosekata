package com.refactor.adapter.xml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public abstract class AbstractBuilderTest {
	protected PrettyPrinter prettyPrint;
	protected OutputBuilder builder;

	protected abstract OutputBuilder createOutputBuilder(String rootName);

	@Before
	public void setUp() {
		prettyPrint = new PrettyPrinter();
	}

	@Test
	public void testAddAboveRoot() {
		builder = createOutputBuilder("orders");
		builder.addBelow("order");
		try {
			builder.addAbove("customer");
			fail("expecting java.lang.RuntimeException");
		} catch (RuntimeException re) {
		}
	}

	@Test
	public void testAddBelow() {
		String expected = "<orders>" + "<order>" + "</order>" + "</orders>";
		builder = createOutputBuilder("orders");
		builder.addBelow("order");
		assertXMLEquals("built xml", expected, builder.toString());
	}

	@Test
	public void testAddBelowWithAttribute() {
		String expected = "<orders>" + "<order number='123'>" + "</order>"
				+ "</orders>";
		builder = createOutputBuilder("orders");
		builder.addBelow("order");
		builder.addAttribute("number", "123");
		assertXMLEquals("built xml", expected, builder.toString());
	}

	@Test
	public void testAddBesideAndAbove() {
		String expected = "<orders>" + "<order>" + "<item/>" + "<item/>"
				+ "<item/>" + "</order>" + "<order/>" + "</orders>";
		builder = createOutputBuilder("orders");
		builder.addBelow("order");
		builder.addBelow("item");
		builder.addBeside("item");
		builder.addBeside("item");
		builder.addAbove("order");
		assertXMLEquals("beside & above", expected, builder.toString());
	}

	@Test
	public void testAddBesideRoot() {
		builder = createOutputBuilder("orders");
		try {
			builder.addBeside("customer");
			fail("expecting java.lang.RuntimeException");
		} catch (RuntimeException re) {
		}
	}

	@Test
	public void testAddValue() {
		String expected = "<orders>" + "<order>" + "123" + "</order>"
				+ "</orders>";
		builder = createOutputBuilder("orders");
		builder.addBelow("order");
		builder.addValue("123");
		assertXMLEquals("built xml", expected, builder.toString());
	}

	@Test
	public void testOneElementTree() {
		String expected = "<orders>" + "</orders>";
		builder = createOutputBuilder("orders");
		assertXMLEquals("one element tree", expected, builder.toString());
	}

	@Test
	public void testStartNewBuild() {
		String expected = "<fruits>" + "<apple>" + "</apple>" + "</fruits>";
		builder = createOutputBuilder("orders");
		builder.addBelow("order");
		builder.startNewBuild("fruits");
		builder.addBelow("apple");
		assertXMLEquals("start new build", expected, builder.toString());
	}

	@Test
	public void testValueAndChild() {
		String expected = "<flavor>" + "this flavor is really good" + "<grape>"
				+ "</grape>" + "</flavor>";
		builder = createOutputBuilder("flavor");
		builder.addValue("this flavor is really good");
		builder.addBelow("grape");
		assertXMLEquals("value and child", expected, builder.toString());
	}

	public void assertXMLEquals(String testName, String expected, String result) {
		assertEquals(testName, prettyPrint.format(expected),
				prettyPrint.format(result));
	}
}
