package com.refactor.adapter.xml;

public class XMLBuilderTest extends AbstractBuilderTest {

	protected OutputBuilder createOutputBuilder(String rootName) {
		return new XMLBuilder(rootName);
	}
}
