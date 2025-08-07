package io.github.rosemoe.sora.langs.svg;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * مرتب کننده حرفه ی SVG برای اندروید استفاده از Android XML Pull Parser برای عملکرد بهتر
 *
 * @author Ghost
 * @version 3.0
 */
public class AndroidSVGFormatter {

  private static final String TAG = "SVGFormatter";

  private int indentSize;
  private Context context;

  // ترتیب attributes برای SVG
  private static final String[] SVG_ATTR_ORDER = {
    "id",
    "class",
    "x",
    "y",
    "cx",
    "cy",
    "r",
    "rx",
    "ry",
    "x1",
    "y1",
    "x2",
    "y2",
    "width",
    "height",
    "viewBox",
    "xmlns",
    "xmlns:xlink",
    "fill",
    "stroke",
    "stroke-width",
    "stroke-opacity",
    "fill-opacity",
    "opacity",
    "d",
    "transform",
    "style",
    "points",
    "href",
    "xlink:href"
  };

  // کلاس برای نگهداری اطلاعات Element
  public static class SVGElement {
    public String name;
    public Map<String, String> attributes;
    public List<SVGElement> children;
    public String text;

    public SVGElement(String name) {
      this.name = name;
      this.attributes = new LinkedHashMap<>();
      this.children = new ArrayList<>();
      this.text = "";
    }
  }

  // کلاس برای آمار فرمت کردن
  public static class FormattingResult {
    public boolean success;
    public String formattedContent;
    public long originalSize;
    public long formattedSize;
    public String errorMessage;
    public long processingTime;

    public double getCompressionRatio() {
      if (originalSize == 0) return 0;
      return ((double) (formattedSize - originalSize) / originalSize) * 100;
    }
  }

  public AndroidSVGFormatter(Context context, int indentSize) {
    this.context = context;
    this.indentSize = indentSize;
  }

  public AndroidSVGFormatter(Context context) {
    this(context, 4); // پیشفرض 2 فاصله
  }

  /** فرمت کردن محتوای SVG */
  public FormattingResult formatSVGContent(String svgContent) {
    FormattingResult result = new FormattingResult();
    long startTime = System.currentTimeMillis();

    try {
      result.originalSize = svgContent.getBytes("UTF-8").length;

      Log.d(TAG, "شروع پردازش SVG با اندازه: " + result.originalSize + " bytes");

      // پارس کردن SVG
      SVGElement rootElement = parseXML(svgContent);

      if (rootElement == null) {
        throw new Exception("خطا در پارس کردن SVG");
      }

      // تمیز کردن و بهبود
      cleanElement(rootElement);

      // تولید خروجی فرمت شده
      result.formattedContent = elementToString(rootElement, 0);
      result.formattedSize = result.formattedContent.getBytes("UTF-8").length;
      result.success = true;

      Log.d(TAG, "پردازش موفق - اندازه نهایی: " + result.formattedSize + " bytes");

    } catch (Exception e) {
      result.success = false;
      result.errorMessage = e.getMessage();
      Log.e(TAG, "خطا در فرمت کردن SVG: " + e.getMessage(), e);
    } finally {
      result.processingTime = System.currentTimeMillis() - startTime;
    }

    return result;
  }

  /** پارس کردن XML با استفاده از Android Pull Parser */
  private SVGElement parseXML(String xmlContent) throws XmlPullParserException, IOException {
    XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
    factory.setNamespaceAware(true);
    XmlPullParser parser = factory.newPullParser();

    parser.setInput(new StringReader(xmlContent));

    SVGElement root = null;
    Stack<SVGElement> elementStack = new Stack<>();

    int eventType = parser.getEventType();
    while (eventType != XmlPullParser.END_DOCUMENT) {

      switch (eventType) {
        case XmlPullParser.START_TAG:
          String tagName = parser.getName();
          SVGElement element = new SVGElement(tagName);

          // اضافه کردن attributes
          for (int i = 0; i < parser.getAttributeCount(); i++) {
            String attrName = parser.getAttributeName(i);
            String attrValue = parser.getAttributeValue(i);
            element.attributes.put(attrName, attrValue);
          }

          if (root == null) {
            root = element;
          } else if (!elementStack.isEmpty()) {
            elementStack.peek().children.add(element);
          }

          elementStack.push(element);
          break;

        case XmlPullParser.TEXT:
          if (!elementStack.isEmpty()) {
            String text = parser.getText().trim();
            if (!text.isEmpty()) {
              elementStack.peek().text += text;
            }
          }
          break;

        case XmlPullParser.END_TAG:
          if (!elementStack.isEmpty()) {
            elementStack.pop();
          }
          break;
      }

      eventType = parser.next();
    }

    return root;
  }

  /** تمیز کردن element و فرزندانش */
  private void cleanElement(SVGElement element) {
    // مرتبسازی attributes
    element.attributes = sortAttributes(element.attributes);

    // تمیز کردن style
    if (element.attributes.containsKey("style")) {
      String cleanStyle = cleanStyleAttribute(element.attributes.get("style"));
      element.attributes.put("style", cleanStyle);
    }

    // تمیز کردن path data
    if (element.attributes.containsKey("d")) {
      String cleanPath = cleanPathData(element.attributes.get("d"));
      element.attributes.put("d", cleanPath);
    }

    // پردازش فرزندان
    for (SVGElement child : element.children) {
      cleanElement(child);
    }
  }

  /** مرتبسازی attributes */
  private Map<String, String> sortAttributes(Map<String, String> attributes) {
    Map<String, String> sorted = new LinkedHashMap<>();

    // اول attributes مهم
    for (String attrName : SVG_ATTR_ORDER) {
      if (attributes.containsKey(attrName)) {
        sorted.put(attrName, attributes.get(attrName));
      }
    }

    // بقیه attributes به ترتیب الفبا
    List<String> remainingKeys = new ArrayList<>();
    for (String key : attributes.keySet()) {
      if (!sorted.containsKey(key)) {
        remainingKeys.add(key);
      }
    }

    Collections.sort(remainingKeys);
    for (String key : remainingKeys) {
      sorted.put(key, attributes.get(key));
    }

    return sorted;
  }

  /** تمیز کردن style attribute */
  private String cleanStyleAttribute(String style) {
    if (style == null || style.trim().isEmpty()) {
      return style;
    }

    String[] properties = style.split(";");
    List<String> cleanProperties = new ArrayList<>();

    for (String property : properties) {
      property = property.trim();
      if (!property.isEmpty() && property.contains(":")) {
        String[] parts = property.split(":", 2);
        if (parts.length == 2) {
          String key = parts[0].trim();
          String value = parts[1].trim();
          cleanProperties.add(key + ":" + value);
        }
      }
    }

    return String.join("; ", cleanProperties);
  }

  /** تمیز کردن path data */
  private String cleanPathData(String pathData) {
    if (pathData == null || pathData.trim().isEmpty()) {
      return pathData;
    }

    // اضافه کردن فاصله بعد از commands
    Pattern commandPattern = Pattern.compile("([MmLlHhVvCcSsQqTtAaZz])");
    Matcher matcher = commandPattern.matcher(pathData);
    pathData = matcher.replaceAll(" $1 ");

    // تمیز کردن فاصل ههای اضافی
    pathData = pathData.replaceAll("\\s+", " ");
    pathData = pathData.replaceAll("\\s*,\\s*", ",");

    // حذف فاصله قبل از اعداد منفی
    pathData = pathData.replaceAll("\\s+(-\\d)", "$1");

    return pathData.trim();
  }

  /** تبدیل element به string فرمت شده */
  private String elementToString(SVGElement element, int level) {
    StringBuilder result = new StringBuilder();
    String indent = getIndent(level);
    String childIndent = getIndent(level + 1);

    // شروع تگ باز
    result.append(indent).append("<").append(element.name);

    // attributes
    int attrCount = element.attributes.size();
    int i = 0;
    for (Map.Entry<String, String> attr : element.attributes.entrySet()) {
      result
          .append("\n")
          .append(childIndent)
          .append(attr.getKey())
          .append("=\"")
          .append(escapeXML(attr.getValue()))
          .append("\"");
      i++;
    }

    // بررسی محتوا
    boolean hasText = !element.text.isEmpty();
    boolean hasChildren = !element.children.isEmpty();

    if (!hasText && !hasChildren) {
      // تگ خودبسته
      result.append(" />");
      return result.toString();
    }

    // بستن تگ باز
    result.append(">");

    // محتوای متنی
    if (hasText && !hasChildren) {
      result.append(escapeXML(element.text));
    } else if (hasText) {
      result.append("\n").append(getIndent(level + 1)).append(escapeXML(element.text));
    }

    // فرزندان
    if (hasChildren) {
      result.append("\n");
      for (SVGElement child : element.children) {
        result.append(elementToString(child, level + 1)).append("\n");
      }
      result.append(indent);
    }

    // تگ بسته
    result.append("</").append(element.name).append(">");

    return result.toString();
  }

  /** تولید indent */
  private String getIndent(int level) {
    StringBuilder indent = new StringBuilder();
    for (int i = 0; i < level * indentSize; i++) {
      indent.append(" ");
    }
    return indent.toString();
  }

  /** Escape کردن XML */
  private String escapeXML(String input) {
    if (input == null) return "";

    return input
        .replace("&", "&amp;")
        .replace("<", "&lt;")
        .replace(">", "&gt;")
        .replace("\"", "&quot;")
        .replace("'", "&apos;");
  }

  /** فرمت کردن فایل از assets */
  public FormattingResult formatAssetFile(String assetFileName) {
    try {
      InputStream inputStream = context.getAssets().open(assetFileName);
      String content = readInputStream(inputStream);
      inputStream.close();

      return formatSVGContent(content);

    } catch (IOException e) {
      FormattingResult result = new FormattingResult();
      result.success = false;
      result.errorMessage = "خطا در خواندن فایل از assets: " + e.getMessage();
      Log.e(TAG, result.errorMessage, e);
      return result;
    }
  }

  /** فرمت کردن فایل از internal storage */
  public FormattingResult formatInternalFile(String fileName) {
    try {
      FileInputStream fis = context.openFileInput(fileName);
      String content = readInputStream(fis);
      fis.close();

      return formatSVGContent(content);

    } catch (IOException e) {
      FormattingResult result = new FormattingResult();
      result.success = false;
      result.errorMessage = "خطا در خواندن فایل: " + e.getMessage();
      Log.e(TAG, result.errorMessage, e);
      return result;
    }
  }

  /** ذخیره کردن نتیجه فرمت شده */
  public boolean saveFormattedContent(String fileName, String content) {
    try {
      FileOutputStream fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
      fos.write(content.getBytes("UTF-8"));
      fos.close();

      Log.d(TAG, "فایل ذخیره شد: " + fileName);
      return true;

    } catch (IOException e) {
      Log.e(TAG, "خطا در ذخیره فایل: " + e.getMessage(), e);
      return false;
    }
  }

  /** خواندن InputStream */
  private String readInputStream(InputStream inputStream) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
    StringBuilder content = new StringBuilder();
    String line;

    while ((line = reader.readLine()) != null) {
      content.append(line).append("\n");
    }

    reader.close();
    return content.toString();
  }

  public static String format(Context c, String code) {
    AndroidSVGFormatter formatter = new AndroidSVGFormatter(c);
    FormattingResult result = formatter.formatSVGContent(code);
    return result.formattedContent;
  }

  /** متد کمکی برای تست سریع */
  public static void testFormatter(Context context) {
    String sampleSVG =
        "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
            + "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"200\" height=\"150\" viewBox=\"0 0 200 150\">\n"
            + "  <circle r=\"40\" cy=\"60\" cx=\"60\" fill=\"red\" stroke=\"black\" stroke-width=\"2\" style=\"opacity:0.8;stroke-dasharray:5,5\" />\n"
            + "  <rect height=\"50\" width=\"70\" y=\"20\" x=\"120\" fill=\"blue\" transform=\"rotate(10 155 45)\" />\n"
            + "  <path d=\"M30,120Q60,100 90,120T150,120\" stroke=\"green\" stroke-width=\"3\" fill=\"none\" />\n"
            + "  <text font-size=\"14\" font-family=\"Arial\" fill=\"navy\" y=\"140\" x=\"100\">تست اندروید!</text>\n"
            + "</svg>";

    AndroidSVGFormatter formatter = new AndroidSVGFormatter(context);
    FormattingResult result = formatter.formatSVGContent(sampleSVG);

    if (result.success) {
      Log.d(TAG, "✅ تست موفق!");
      Log.d(TAG, "📊 اندازه اصلی: " + result.originalSize + " bytes");
      Log.d(TAG, "📊 اندازه فرمت شده: " + result.formattedSize + " bytes");
      Log.d(TAG, "⏱️ زمان پردازش: " + result.processingTime + " ms");
      Log.d(TAG, "📈 تغییر: " + String.format("%.1f%%", result.getCompressionRatio()));
      Log.d(TAG, "🎨 محتوای فرمت شده:\n" + result.formattedContent);
    } else {
      Log.e(TAG, "❌ تست ناموفق: " + result.errorMessage);
    }
  }
}
