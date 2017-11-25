package com.refactor.adapter.xml;

public interface OutputBuilder {
	void addAbove(String uncle);

	void addAttribute(String name, String value);

	void addBelow(String child);

	void addGrandfather(String grandfather);

	void addBeside(String sibling);

	void addValue(String value);

	void startNewBuild(String rootName);

	String toString();
}
