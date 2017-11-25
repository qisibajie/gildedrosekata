package com.refactor.adapter.xml;

import java.io.StringReader;
import java.util.StringTokenizer;

import org.apache.xerces.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class PrettyPrinter extends DefaultHandler {
	private String result;
	private int count;
	private boolean startElement;
	private boolean charFlags = false;
	private boolean firstItem = false;

	public PrettyPrinter() {
	}

	public void characters(char[] buf, int start, int length) {
		String resultData = new String(buf, start, length);
		if (firstItem) {
			insertTabs();
			charFlags = true;
			firstItem = false;
		}
		resultData = resultData.replaceAll("&", "&amp;");
		result += resultData;
	}

	public void endElement(String uri, String localName, String qName) {
		adjustWithPreviousText();
		if (!startElement)
			count--;

		insertTabs();
		startElement = false;
		result += "</" + localName + ">\n";
	}

	public String format(String inputXML) {
		result = "\n";
		count = 0;
		startElement = false;
		inputXML = stripTabs(inputXML).replaceAll("& ", "&amp; ");
		try {
			XMLReader reader = new SAXParser();
			InputSource source = new InputSource(new StringReader(inputXML));
			reader.setContentHandler(this);
			reader.parse(source);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private void insertTabs() {
		for (int x = 0; x < count; x++)
			result += "\t";
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		firstItem = true;
		adjustWithPreviousText();
		if (startElement)
			count++;
		insertTabs();
		result += "<" + localName;
		int len;
		if ((len = attributes.getLength()) > 0) {
			result += " ";
			for (int i = 0; i < len; i++) {
				String value = attributes.getValue(i);
				value = value.replaceAll("& ", "&amp; ");
				result += (attributes.getLocalName(i) + "='" + value + "'");
				if (i < (len - 1))
					result += " ";
			}
		}
		startElement = true;
		result += ">\n";
	}

	public void adjustWithPreviousText() {
		if (charFlags == true) {
			charFlags = false;
			result += "\n";
		}
	}

	private String stripTabs(String rawText) {
		StringTokenizer tok = new StringTokenizer(rawText, "\t");
		StringBuffer result = new StringBuffer();
		while (tok.hasMoreElements())
			result.append(tok.nextToken());
		return result.toString();
	}
}
