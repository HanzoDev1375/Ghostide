package com.mcal.uidesigner.common;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

public class PositionalXMLReader {
    public static final String COLUMN = "column";
    public static final String LINE = "line";

    public static Document readXML(InputStream is) throws IOException, SAXException {
        try {
            XMLReader reader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            reader.setFeature("http://xml.org/sax/features/namespaces", false);
            reader.setFeature("http://xml.org/sax/features/namespace-prefixes", false);
            final Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            final Stack<Element> elementStack = new Stack<>();
            final StringBuilder textBuffer = new StringBuilder();
            reader.setContentHandler(new DefaultHandler() {
                private Locator locator;

                @Override
                public void setDocumentLocator(Locator locator) {
                    this.locator = locator;
                }

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) {
                    addTextIfNeeded();
                    Element el = doc.createElement(qName);
                    for (int i = 0; i < attributes.getLength(); i++) {
                        el.setAttribute(attributes.getQName(i), attributes.getValue(i));
                    }
                    el.setUserData(PositionalXMLReader.LINE, String.valueOf(locator.getLineNumber()), null);
                    el.setUserData(PositionalXMLReader.COLUMN, String.valueOf(locator.getColumnNumber() + 1), null);
                    elementStack.push(el);
                }

                @Override
                public void endElement(String uri, String localName, String qName) {
                    addTextIfNeeded();
                    Element closedEl = elementStack.pop();
                    if (elementStack.isEmpty()) {
                        doc.appendChild(closedEl);
                    } else {
                        elementStack.peek().appendChild(closedEl);
                    }
                }

                @Override
                public void characters(char[] ch, int start, int length) {
                    textBuffer.append(ch, start, length);
                }

                private void addTextIfNeeded() {
                    if (textBuffer.length() > 0) {
                        elementStack.peek().appendChild(doc.createTextNode(textBuffer.toString()));
                        textBuffer.delete(0, textBuffer.length());
                    }
                }
            });
            reader.parse(new InputSource(is));
            return doc;
        } catch (ParserConfigurationException e) {
            throw new RuntimeException("Can't create SAX parser / DOM builder.", e);
        }
    }
}
