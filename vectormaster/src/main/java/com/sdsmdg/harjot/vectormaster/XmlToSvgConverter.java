package com.sdsmdg.harjot.vectormaster;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

// code by Bobur-777 && Ninjacoder

public class XmlToSvgConverter {

  public static String xml2svg(String xml, boolean usingwidth, boolean usingheight)
      throws Exception {
    // Parse the XML content
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.parse(new ByteArrayInputStream(xml.getBytes()));

    // Retrieve vector attributes
    Element vector = (Element) doc.getElementsByTagName("vector").item(0);
    String width = vector.getAttribute("android:width").replace("dp", "");
    String height = vector.getAttribute("android:height").replace("dp", "");
    String viewportWidth = vector.getAttribute("android:viewportWidth");
    String viewportHeight = vector.getAttribute("android:viewportHeight");

    // Start building the SVG with DOCTYPE and version
    StringBuilder svg = new StringBuilder();
    svg.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n")
        .append("<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" ")
        .append("\"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n")
        .append("<svg xmlns=\"http://www.w3.org/2000/svg\" ");
    if (usingwidth) svg.append(" width=\"").append(width).append("\" ");
    if (usingheight) svg.append("height=\"").append(height).append("\" ");
    svg.append("viewBox=\"0 0 ")
        .append(viewportWidth)
        .append(" ")
        .append(viewportHeight)
        .append("\">\n");

    // Retrieve and convert paths
    NodeList paths = doc.getElementsByTagName("path");
    for (int i = 0; i < paths.getLength(); i++) {
      Element path = (Element) paths.item(i);
      String pathData = path.getAttribute("android:pathData");
      String fillColor = path.getAttribute("android:fillColor");
      String strokeColor = path.getAttribute("android:strokeColor");
      String strokeWidth = path.getAttribute("android:strokeWidth");
      String shadowColor = path.getAttribute("android:shadowColor");
      String shadowDx = path.getAttribute("android:shadowDx");
      String shadowDy = path.getAttribute("android:shadowDy");
      String shadowRadius = path.getAttribute("android:shadowRadius");

      svg.append("<path d=\"").append(pathData).append("\" ");
      if (isHexColor(fillColor)) {
        svg.append("fill=\"").append(fillColor).append("\"");
      } else {
        svg.append("fill=\"").append("#fff").append("\"");
      }

      if (isHexColor(strokeColor)) {
        svg.append(" stroke=\"").append(strokeColor).append("\"");
      }else svg.append(" stroke=\"").append("#000").append("\"");
      if (!strokeWidth.isEmpty()) {
        svg.append(" stroke-width=\"").append(strokeWidth).append("\"");
      }

      // اضافه کردن سایه
      if (isHexColor(shadowColor)) {
        svg.append(" filter=\"url(#shadow)\"");
        svg.append("\n<defs>")
            .append("<filter id=\"shadow\">")
            .append("<feDropShadow dx=\"")
            .append(shadowDx)
            .append("\" dy=\"")
            .append(shadowDy)
            .append("\" stdDeviation=\"")
            .append(shadowRadius)
            .append("\" flood-color=\"")
            .append(shadowColor)
            .append("\" />")
            .append("</filter>")
            .append("</defs>\n");
      }
      svg.append("/>\n");
    }

    svg.append("</svg>");
    return svg.toString();
  }

  public static String xml2svg(String code) throws Exception {
    return xml2svg(code, false, false);
  }

  private static boolean isHexColor(String code) {
    String regexHex = "#[a-fA-F0-9]{3,8}";
    Pattern pattern = Pattern.compile(regexHex);
    Matcher matcher = pattern.matcher(code);
    return matcher.find();
  }
}
