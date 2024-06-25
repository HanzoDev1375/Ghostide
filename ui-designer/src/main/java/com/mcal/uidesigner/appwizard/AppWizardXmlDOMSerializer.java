package com.mcal.uidesigner.appwizard;

import androidx.annotation.NonNull;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

public class AppWizardXmlDOMSerializer {
    private final String indent = "\t";
    private final String lineSeparator = "\n";

    public String serialize(Document document) {
        StringWriter writer = new StringWriter();
        try {
            serialize(document, writer);
            return writer.toString();
        } catch (IOException e) {
            return "";
        }
    }

    public void serialize(Document doc, OutputStream out) throws IOException {
        serialize(doc, new OutputStreamWriter(out, StandardCharsets.UTF_8));
    }

    public void serialize(Document doc, File file) throws IOException {
        serialize(doc, new FileWriter(file));
    }

    public void serialize(@NonNull Document doc, Writer writer) throws IOException {
        doc.normalize();
        serializeNode(doc, writer, 0, "");
        writer.flush();
    }

    private void serializeNode(@NonNull Node node, Writer writer, int depth, String indentation) throws IOException {
        switch (node.getNodeType()) {
            case 1:
                String name = node.getNodeName();
                writer.write(indentation + "<" + name);
                String attributeSeparator = lineSeparator + indentation + indent;
                NamedNodeMap attributes = node.getAttributes();
                for (int i = 0; i < attributes.getLength(); i++) {
                    Attr current = (Attr) attributes.item(i);
                    if (!"xmlns:android".equals(current.getName())) {
                        writer.write(attributeSeparator);
                        writer.write(current.getNodeName());
                        writer.write("=\"");
                        print(writer, current.getNodeValue());
                        writer.write("\"");
                    }
                }
                NodeList children = node.getChildNodes();
                if (children == null || children.getLength() <= 0) {
                    writer.write("/>");
                } else {
                    writer.write(">");
                    writer.write(lineSeparator);
                    writer.write(lineSeparator);
                    for (int i2 = 0; i2 < children.getLength(); i2++) {
                        if (children.item(i2).getNodeType() == 1) {
                            serializeNode(children.item(i2), writer, depth + 1, indentation + indent);
                        }
                    }
                    writer.write(indentation);
                    writer.write("</" + name + ">");
                }
                writer.write(lineSeparator);
                writer.write(lineSeparator);
                return;
            case 9:
                writer.write("<?xml version=\"");
                writer.write(((Document) node).getXmlVersion());
                writer.write("\" encoding=\"utf-8\"");
                writer.write("?>");
                writer.write(lineSeparator);
                NodeList nodes = node.getChildNodes();
                if (nodes != null) {
                    for (int i = 0; i < nodes.getLength(); i++) {
                        serializeNode(nodes.item(i), writer, 0, "");
                    }
                    return;
                }
                return;
            default:
        }
    }

    private void print(Writer writer, String s) throws IOException {
        if (s != null) {
            int len = s.length();
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                switch (c) {
                    case '\r':
                        writer.write("&#xD;");
                        break;
                    case '&':
                        writer.write("&amp;");
                        break;
                    case '<':
                        writer.write("&lt;");
                        break;
                    case '>':
                        writer.write("&gt;");
                        break;
                    default:
                        writer.write(c);
                        break;
                }
            }
        }
    }
}
