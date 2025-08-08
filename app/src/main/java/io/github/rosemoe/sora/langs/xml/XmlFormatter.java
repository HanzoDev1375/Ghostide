package io.github.rosemoe.sora.langs.xml;

import android.content.Context;
import android.util.Log;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class XmlFormatter {

  private static final String TAG = "LayoutFormatter";
  private static final String XML_HEADER = "<!-- Created with Ghost IDE -->\n";
  private int indentSize = 2;
  private boolean showHeader = true;
  private final Context context;

  // Patterns for attribute categorization
  private static final Pattern ANDROID_ATTR = Pattern.compile("^android:.+");
  private static final Pattern APP_ATTR = Pattern.compile("^app:.+");
  private static final Pattern TOOLS_ATTR = Pattern.compile("^tools:.+");
  private static final Pattern STYLE_ATTR = Pattern.compile("^style$");

  // Attribute group order
  private static final String[] ATTR_GROUP_ORDER = {
    "xmlns", "android", "app", "tools", "style", "other"
  };

  public static class FormatResult {
    public boolean success;
    public String formatted;
    public long originalSize;
    public long formattedSize;
    public String error;
    public long time;

    public double getRatio() {
      return originalSize == 0 ? 0 : ((double) (formattedSize - originalSize) / originalSize) * 100;
    }
  }

  public XmlFormatter(Context ctx) {
    this.context = ctx;
  }

  public FormatResult format(String xml) {
    FormatResult res = new FormatResult();
    long start = System.currentTimeMillis();

    try {
      res.originalSize = xml.getBytes().length;
      XmlElement root = parseXml(xml);
      res.formatted = formatElement(root, 0);
      res.formattedSize = res.formatted.getBytes().length;
      res.success = true;
    } catch (Exception e) {
      res.success = false;
      res.error = e.getMessage();
      Log.e(TAG, "Format error", e);
    } finally {
      res.time = System.currentTimeMillis() - start;
    }

    return res;
  }

  private XmlElement parseXml(String xml) throws XmlPullParserException, IOException {
    XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
    parser.setInput(new StringReader(xml));

    XmlElement root = null;
    Stack<XmlElement> stack = new Stack<>();

    int event = parser.getEventType();
    while (event != XmlPullParser.END_DOCUMENT) {
      switch (event) {
        case XmlPullParser.START_TAG:
          XmlElement el = new XmlElement(parser.getName());

          // Process attributes with regex
          for (int i = 0; i < parser.getAttributeCount(); i++) {
            String name = parser.getAttributeName(i);
            String value = parser.getAttributeValue(i);
            el.attrs.put(name, value);
          }

          if (root == null) root = el;
          else if (!stack.isEmpty()) stack.peek().children.add(el);

          stack.push(el);
          break;

        case XmlPullParser.TEXT:
          if (!stack.isEmpty()) {
            String text = parser.getText().trim();
            if (!text.isEmpty()) stack.peek().text = text;
          }
          break;

        case XmlPullParser.END_TAG:
          if (!stack.isEmpty()) stack.pop();
          break;
      }
      event = parser.next();
    }

    return root;
  }

  private String formatElement(XmlElement el, int level) {
    StringBuilder sb = new StringBuilder();
    String indent = " ".repeat(level * indentSize);
    String childIndent = " ".repeat((level + 1) * indentSize);

    // Start tag
    sb.append(indent).append("<").append(el.name);

    // Sort and group attributes
    Map<String, Map<String, String>> grouped = groupAttributes(el.attrs);

    // Add attributes by group order
    for (String group : ATTR_GROUP_ORDER) {
      if (grouped.containsKey(group)) {
        for (Map.Entry<String, String> attr : grouped.get(group).entrySet()) {
          sb.append("\n")
              .append(childIndent)
              .append(attr.getKey())
              .append("=\"")
              .append(escapeXml(attr.getValue()))
              .append("\"");
        }
      }
    }

    // Handle content
    boolean hasText = !el.text.isEmpty();
    boolean hasChildren = !el.children.isEmpty();

    if (!hasText && !hasChildren) {
      sb.append(" />");
      return sb.toString();
    }

    sb.append(">");

    if (hasText && !hasChildren) {
      sb.append(escapeXml(el.text));
    } else if (hasText) {
      sb.append("\n").append(childIndent).append(escapeXml(el.text));
    }

    if (hasChildren) {
      sb.append("\n");
      for (XmlElement child : el.children) {
        sb.append(formatElement(child, level + 1)).append("\n");
      }
      sb.append(indent);
    }

    sb.append("</").append(el.name).append(">");

    return sb.toString();
  }

  private Map<String, Map<String, String>> groupAttributes(Map<String, String> attrs) {
    Map<String, Map<String, String>> groups = new LinkedHashMap<>();

    for (Map.Entry<String, String> attr : attrs.entrySet()) {
      String name = attr.getKey();
      String group = "other";

      if (STYLE_ATTR.matcher(name).matches()) {
        group = "style";
      } else if (ANDROID_ATTR.matcher(name).matches()) {
        group = "android";
      } else if (APP_ATTR.matcher(name).matches()) {
        group = "app";
      } else if (TOOLS_ATTR.matcher(name).matches()) {
        group = "tools";
      } else if (name.equals("xmlns") || name.startsWith("xmlns:")) {
        group = "xmlns";
      }

      groups.computeIfAbsent(group, k -> new LinkedHashMap<>()).put(name, attr.getValue());
    }

    // Sort each group alphabetically
    for (Map<String, String> group : groups.values()) {
      if (group.size() > 1) {
        List<String> keys = new ArrayList<>(group.keySet());
        Collections.sort(keys);
        Map<String, String> sorted = new LinkedHashMap<>();
        for (String key : keys) {
          sorted.put(key, group.get(key));
        }
        group.clear();
        group.putAll(sorted);
      }
    }

    return groups;
  }

  private static class XmlElement {
    String name;
    Map<String, String> attrs = new LinkedHashMap<>();
    List<XmlElement> children = new ArrayList<>();
    String text = "";

    XmlElement(String name) {
      this.name = name;
    }
  }

  private static String escapeXml(String input) {
    if (input == null) return "";
    return input
        .replace("&", "&amp;")
        .replace("<", "&lt;")
        .replace(">", "&gt;")
        .replace("\"", "&quot;")
        .replace("'", "&apos;");
  }

  // Helper methods for file operations...
  public static String format(Context ctx, String xml) {
    return new XmlFormatter(ctx).format(xml).formatted;
  }
}
