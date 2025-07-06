package lsp4custom.com.ninjacoder.customhtmllsp;

import android.util.Log;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import io.github.rosemoe.sora.data.CompletionItem;
import io.github.rosemoe.sora.langs.html.HTMLLanguage;
import io.github.rosemoe.sora.widget.TextSummry.HTMLConstants;

import io.github.rosemoe.sora.widget.Transilt;
import ir.ninjacoder.ghostide.utils.DataUtil;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Css3Server {
  private Random RANDOM = new Random();
  private int COLORS_TO_GENERATE = 20;

  static String[] cssColorAttr = {
    "color:",
    "background-color:",
    "border-color:",
    "outline-color:",
    "text-shadow:",
    "box-shadow:",
    "fill:",
    "stroke:",
    "caret-color:",
    "column-rule-color:",
    "mask-border:",
    "border-top-color:",
    "border-right-color:",
    "border-bottom-color:",
    "border-left-color:",
  };
  public static final String[] MCSS = {
    "align-content",
    "align-items",
    "align-self",
    "all",
    "animation",
    "animation-delay",
    "animation-direction",
    "animation-duration",
    "animation-fill-mode",
    "animation-iteration-count",
    "animation-name",
    "animation-play-state",
    "animation-timing-function",
    "backface-visibility",
    "background",
    "background-attachment",
    "background-blur",
    "background-clip",
    "background-color:",
    "background-image",
    "background-origin",
    "background-position",
    "background-repeat",
    "background-size",
    "border",
    "border-bottom",
    "border-bottom-color:",
    "border-bottom-left-radius",
    "border-bottom-right-radius",
    "border-bottom-style",
    "border-bottom-width",
    "border-collapse",
    "border-color:",
    "border-image",
    "border-image-outset",
    "border-image-repeat",
    "border-image-slice",
    "border-image-source",
    "border-image-width",
    "border-left",
    "border-left-color:",
    "border-left-style",
    "border-left-width",
    "border-radius",
    "border-right",
    "border-right-color",
    "border-right-style",
    "border-right-width",
    "border-spacing",
    "border-style",
    "border-top",
    "border-top-color",
    "border-top-left-radius",
    "border-top-right-radius",
    "border-top-style",
    "border-top-width",
    "border-width",
    "bottom",
    "box-decoration-break",
    "box-shadow",
    "box-sizing",
    "break-after",
    "break-before",
    "break-inside",
    "caption-side",
    "caret-color",
    "clear",
    "clip",
    "color:",
    "column-count",
    "column-fill",
    "column-gap",
    "column-rule",
    "column-rule-color",
    "column-rule-style",
    "column-rule-width",
    "column-span",
    "column-width",
    "columns",
    "content",
    "counter-increment",
    "counter-reset",
    "cursor",
    "direction",
    "display",
    "empty-cells",
    "filter",
    "flex",
    "flex-basis",
    "flex-direction",
    "flex-flow",
    "flex-grow",
    "flex-shrink",
    "flex-wrap",
    "float",
    "font",
    "font-family",
    "font-size",
    "font-size-adjust",
    "font-stretch",
    "font-style",
    "font-variant",
    "font-variant-caps",
    "font-weight",
    "gap",
    "grid",
    "grid-area",
    "grid-auto-columns",
    "grid-auto-flow",
    "grid-auto-rows",
    "grid-column",
    "grid-column-end",
    "grid-column-gap",
    "grid-column-start",
    "grid-gap",
    "grid-row",
    "grid-row-end",
    "grid-row-gap",
    "grid-row-start",
    "grid-template",
    "grid-template-areas",
    "grid-template-columns",
    "grid-template-rows",
    "height",
    "ime-mode",
    "justify-content",
    "left",
    "letter-spacing",
    "line-break",
    "line-height",
    "list-style",
    "list-style-image",
    "list-style-position",
    "list-style-type",
    "margin",
    "margin-bottom",
    "margin-left",
    "margin-right",
    "margin-top",
    "marker-offset",
    "max-height",
    "max-width",
    "min-height",
    "min-width",
    "mix-blend-mode",
    "object-fit",
    "object-position",
    "opacity",
    "order",
    "orphans",
    "outline",
    "outline-color",
    "outline-offset",
    "outline-style",
    "outline-width",
    "overflow",
    "overflow-wrap",
    "overflow-x",
    "overflow-y",
    "padding",
    "padding-bottom",
    "padding-left",
    "padding-right",
    "padding-top",
    "page-break-after",
    "page-break-before",
    "page-break-inside",
    "perspective",
    "perspective-origin",
    "pointer-events",
    "position",
    "quotes",
    "resize",
    "right",
    "row-gap",
    "scroll-behavior",
    "speak",
    "table-layout",
    "tab-size",
    "text-align",
    "text-align-last",
    "text-decoration",
    "text-decoration-color",
    "text-decoration-line",
    "text-decoration-skip",
    "text-decoration-style",
    "text-indent",
    "text-justify",
    "text-overflow",
    "text-shadow",
    "text-transform",
    "text-underline-position",
    "top",
    "transform",
    "transform-origin",
    "transform-style",
    "transition",
    "transition-delay",
    "transition-duration",
    "transition-property",
    "transition-timing-function",
    "unicode-bidi",
    "vertical-align",
    "visibility",
    "white-space",
    "widows",
    "width",
    "will-change",
    "word-break",
    "word-spacing",
    "word-wrap",
    "writing-mode",
    "z-index"
  };

  protected HTMLConstants htmlconfig;

  public Css3Server() {
    htmlconfig = new HTMLConstants();
  }

  public void install(List<CompletionItem> list, String prfex) {
    for (var lo : MCSS) {
      if (lo.startsWith(prfex)) {
        list.add(css(lo, htmlconfig.CssKey));
      }
    }
  }

  void Padding(List<CompletionItem> list, String prefix, String... titles) {
    for (String title : titles) {
      if (prefix.startsWith(title)) {
        String valuePrefix = prefix.substring(title.length()).trim();
        String numberPart = "";
        for (int i = 0; i < valuePrefix.length(); i++) {
          char c = valuePrefix.charAt(i);
          if (Character.isDigit(c)) {
            numberPart += c;
          } else {
            break;
          }
        }

        if (!numberPart.isEmpty()) {
          for (String value : paddingValues) {
            list.add(css(title + numberPart + value + ";", "CssPadding"));
          }
        }
        break;
      }
    }
  }

  String[] VALUE = {"left", "right", "center", "justify", "start", "end"};


  public void installCssColor(List<CompletionItem> list, String prefix) {
    
    String propertyName = "";
    if (prefix.startsWith("color:")) {
      propertyName = "color";
    } else if (prefix.startsWith("background-color:")) {
      propertyName = "background-color";
    } else if (prefix.startsWith("border-color:")) {
      propertyName = "border-color";
    } else if (prefix.startsWith("outline-color:")) {
      propertyName = "outline-color";
    } else if (prefix.startsWith("text-decoration-color:")) {
      propertyName = "text-decoration-color";
    } else if (prefix.startsWith("column-rule-color:")) {
      propertyName = "column-rule-color";
    } else if (prefix.startsWith("caret-color:")) {
      propertyName = "caret-color";
    } else if (prefix.startsWith("background-shadow:")) {
      propertyName = "background-shadow";
    } else if (prefix.startsWith("filter:")) {
      propertyName = "filter";
    } else if (prefix.startsWith("mask-border:")) {
      propertyName = "mask-border";
    } else if (prefix.startsWith("border-top-color:")) {
      propertyName = "border-top-color";
    } else if (prefix.startsWith("border-right-color:")) {
      propertyName = "border-right-color";
    } else if (prefix.startsWith("border-bottom-color:")) {
      propertyName = "border-bottom-color";
    } else if (prefix.startsWith("border-left-color:")) {
      propertyName = "border-left-color";
    } else if (prefix.startsWith("text-shadow:")) {
      propertyName = "text-shadow";
    } else if (prefix.startsWith("box-shadow:")) {
      propertyName = "box-shadow";
    } else if (prefix.startsWith("filter:")) {
      propertyName = "filter";
    } else if (prefix.startsWith("border-image-source:")) {
      propertyName = "border-image-source"; // رنگ برای تصویر مرزی
    } else if (prefix.startsWith("border-image-slice:")) {
      propertyName = "border-image-slice"; // برای بخش‌های تصویر مرزی
    } else if (prefix.startsWith("border-image-width:")) {
      propertyName = "border-image-width"; // عرض تصویر مرزی
    } else if (prefix.startsWith("border-image-outset:")) {
      propertyName = "border-image-outset"; // خارج کردن تصویر مرزی
    }

    if (!propertyName.isEmpty()) {
      String colorPrefix = prefix.substring(propertyName.length() + 1);
      for (String color : HTMLLanguage.colorsCss) {
        if (color.startsWith(colorPrefix)) {
          list.add(css(color, htmlconfig.CssColor, propertyName + ": " + color + " ;"));
        }
      }
    }
    TypeValue(list, prefix);
    try {
      toMaterialize(list, prefix);
    } catch (Exception err) {

    }
    new KeyWordConst().cssFont(list, prefix);
  }

  public void toAndroidManifestXml(List<CompletionItem> list, String prefix) {

    String propeName = "";
    if (prefix.startsWith("name=")) {
      propeName = "name";
    }
    if (!propeName.isEmpty()) {
      String typePrefix = prefix.substring(propeName.length() + 1).trim();
      for (var it : PermissionGroup.values()) {
        if (it.name().startsWith(typePrefix)) {
          list.add(css(it.name(), it.name(), "android:name=" + "\"" + it.getConstant() + "\""));
        }
      }
    }
    try {
      toAndroidAttr(list, prefix);
    } catch (Exception e) {
      Log.e("Error to load", e.getMessage());
    }
  }

  void toMaterialize(List<CompletionItem> list, String prefix) throws Exception {
    String regex = "\\.(?!\\d)([\\w-]+)";
    String propName = "";
    List<Materialize> item = new ArrayList<>();

    if (prefix.startsWith("class=")) {
      propName = "class";
    }
    var inputStream = GhostIdeAppLoader.getContext().getAssets().open("materialize.min.css");
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(DataUtil.copyFromInputStream(inputStream));
    while (matcher.find()) {
      item.add(new Materialize("materialize", matcher.group(1)));
    }
    if (!propName.isEmpty()) {
      String typePrefix = prefix.substring(propName.length() + 1).trim();
      for (var it : item) {
        if (it.getId().startsWith(typePrefix)) {
          list.add(css("class=" + "\"" + it.getId() + "\"", it.getName()));
        }
      }
    }
  }

  void toAndroidAttr(List<CompletionItem> list, String prefix) throws Exception {
    String propName = "";
    if (prefix.startsWith("name=")) {
      propName = "name";
    }
    var openFile = GhostIdeAppLoader.getContext().getAssets().open("android.R.attrs.json");
    List<Map<String, String>> itemReadattr = new ArrayList<>();
    itemReadattr =
        new Gson()
            .fromJson(
                DataUtil.copyFromInputStream(openFile),
                new TypeToken<List<Map<String, String>>>() {}.getType());
    if (!propName.isEmpty()) {
      var typePrfex = prefix.substring(propName.length() + 1).trim();
      for (var it : itemReadattr) {
        var isname = it.containsKey("names") ? it.get("names") : "Not found";
        var issince = it.containsKey("since") ? it.get("since") : "";
        var isdeprecated = it.containsKey("deprecated") ? it.get("deprecated") : "";
        if (isname.startsWith(typePrfex)) {
          list.add(css("name= " + "\"" + "@android/attr:" + isname + "\"", isname + " " + issince));
        }
      }
    }
  }

  public void toJavaLspDemo(List<CompletionItem> list, String prefix) {}

  private String convertStreamToString(InputStream is) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    StringBuilder sb = new StringBuilder();
    String line;

    try {
      while ((line = reader.readLine()) != null) {
        sb.append(line);
        sb.append('\n');
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        is.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return sb.toString();
  }

  private String[] types = {
    "text",
    "password",
    "email",
    "number",
    "tel",
    "url",
    "date",
    "time",
    "datetime-local",
    "color",
    "range",
    "checkbox",
    "radio",
    "file",
    "hidden",
    "search"
  };

  public void TypeValue(List<CompletionItem> list, String prefix) {
    String propertyName = "";

    if (prefix.startsWith("type=") || prefix.startsWith("type")) {
      String typePrefix = prefix.substring("type=".length());
      String typePr = prefix.substring("type".length());

      for (String type : types) {
        if (type.startsWith(typePrefix) || type.startsWith(typePr)) {
          list.add(css("type=" + "\"" + type + "\"", "Type"));
        }
      }
      return;
    }
    if (prefix.startsWith("lang=")) {
      String langPrefix = prefix.substring("lang=".length()).trim();
      for (var it : Transilt.arrf2) {
        if (it.startsWith(langPrefix)) {
          list.add(css("lang=" + "\"" + it + "\"", "Langs"));
        }
      }
    }
	if (prefix.startsWith("text-align:")) {
      String langPrefix = prefix.substring("text-align:".length()).trim();
      for (var it : VALUE) {
        if (it.startsWith(langPrefix)) {
          list.add(css("text-align:"  + it + " ;", "css Al"));
        }
      }
    }
  }

  String[] paddingValues = {
    "px", "em", "rem", "vw", "vh", "vmin", "vmax", "in", "cm", "mm", "pt", "pc", "ch"
  };

  // برای نمایش عین vscode و در xml هم بزودی
  List<CompletionItem> getPaddingCompletions(String prefix) {
    List<CompletionItem> result = new ArrayList<>();

    // حالت 1: عدد خالص (مثلاً "2")
    if (prefix.matches("^\\d+$")) {
      for (String unit : paddingValues) {
        result.add(css(prefix + unit, "CssUnit"));
      }
      return result;
    }
    installCombinedTags(result, prefix);
    // حالت 2: عدد + واحد ناتمام (مثلاً "2p", "2em", "2pc")
    Matcher unitMatcher = Pattern.compile("^(\\d+)([a-z%]*)").matcher(prefix);
    if (unitMatcher.matches()) {
      String number = unitMatcher.group(1);
      String partialUnit = unitMatcher.group(2);

      for (String unit : paddingValues) {
        if (unit.startsWith(partialUnit)) {
          result.add(css(number + unit, "CssUnit"));
        }
      }
      return result;
    }

    // حالت 3: خصوصیت CSS (مثلاً "padding:2", "padding:2p", "padding:2pc")
    String[] properties = {
      "padding:", "padding-top:", "padding-right:", "padding-bottom:", "padding-left:"
    };

    for (String prop : properties) {
      if (prefix.startsWith(prop)) {
        String valuePart = prefix.substring(prop.length());
        Matcher valueMatcher = Pattern.compile("^(\\d+)([a-z%]*)").matcher(valuePart);

        if (valueMatcher.matches()) {
          String number = valueMatcher.group(1);
          String partialUnit = valueMatcher.group(2);

          for (String unit : paddingValues) {
            if (unit.startsWith(partialUnit)) {
              result.add(css(prop + number + unit, "CssPadding"));
            }
          }
        }
        break;
      }
    }

    return result;
  }

  public void Padding(List<CompletionItem> list, String prefix) {
    list.addAll(getPaddingCompletions(prefix));
  }

  public CompletionItem css(String attr, String desc, String data) {
    final var item = new CompletionItem(attr, data, desc);
    item.cursorOffset(item.commit.length() - 1);
    return item;
  }

  public CompletionItem css(String data, String val) {
    final var item = new CompletionItem(data, val);
    item.cursorOffset(item.commit.length() - 1);
    return item;
  }

  public void setColorRandom(List<CompletionItem> list, String prfex) {
    List<String> fake = generateRandomColors(COLORS_TO_GENERATE);
    fake.forEach(
        it -> {
          if (prfex.endsWith("#f")) list.add(css(it, "RandomColor"));
        });
  }

  private List<String> generateRandomColors(int count) {
    List<String> colors = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      colors.add(generateRandomHexColor());
    }
    return colors;
  }

  private String generateRandomHexColor() {
    return String.format("#%06X", RANDOM.nextInt(0xFFFFFF + 1));
  }

  public void installCombinedTags(List<CompletionItem> list, String prefix) {
    if (prefix.contains("+")) {
      String[] tagParts = prefix.split("\\+");
      StringBuilder result = new StringBuilder();
      int indentLevel = 1;
      String indent = "\t";

      for (String part : tagParts) {
        part = part.trim();
        if (part.isEmpty()) continue;

        // پردازش هر بخش از تگ
        TagInfo tagInfo = parseTag(part);

        // ساخت تگ باز
        result.append(indent.repeat(indentLevel)).append("<").append(tagInfo.tagName);

        if (!tagInfo.className.isEmpty()) {
          result.append(" class=\"").append(tagInfo.className).append("\"");
        }

        if (!tagInfo.id.isEmpty()) {
          result.append(" id=\"").append(tibuteValue(tagInfo.id)).append("\"");
        }

        for (Map.Entry<String, String> attr : tagInfo.attributes.entrySet()) {
          result
              .append(" ")
              .append(attr.getKey())
              .append("=\"")
              .append(tibuteValue(attr.getValue()))
              .append("\"");
        }

        result.append(">");

        // اگر تگ بعدی وجود دارد، خط جدید اضافه کن
        if (indentLevel < tagParts.length) {
          result.append("\n");
        }

        indentLevel++;
      }

      // ساخت تگ‌های بسته به صورت معکوس
      indentLevel -= 2; // یک سطح کمتر از آخرین تگ
      for (int i = tagParts.length - 1; i >= 0; i--) {
        if (tagParts[i].trim().isEmpty()) continue;

        TagInfo tagInfo = parseTag(tagParts[i]);
        result
            .append(indent.repeat(indentLevel + 1))
            .append("</")
            .append(tagInfo.tagName)
            .append(">");

        if (i > 0) {
          result.append("\n");
        }

        indentLevel--;
      }

      String completionText = result.toString();
      list.stream().filter(it -> it.label.startsWith(completionText)).collect(Collectors.toList());
      list.add(css(completionText, "Combined Tags", completionText));
    }
  }

  private static class TagInfo {
    String tagName;
    String className = "";
    String id = "";
    Map<String, String> attributes = new HashMap<>();
  }

  // متد برای تجزیه و تحلیل هر بخش از تگ
  private TagInfo parseTag(String tagStr) {
    TagInfo info = new TagInfo();

    // جدا کردن نام تگ از بقیه مشخصات
    String[] parts = tagStr.split("[#.=]", 2);
    info.tagName = parts[0].trim();

    if (parts.length == 1) {
      return info;
    }

    String rest = tagStr.substring(parts[0].length());

    // پردازش کلاس
    if (rest.contains(".")) {
      int dotIndex = rest.indexOf('.');
      int nextSpecial =
          Math.min(
              rest.indexOf('#', dotIndex + 1) != -1
                  ? rest.indexOf('#', dotIndex + 1)
                  : Integer.MAX_VALUE,
              rest.indexOf('=', dotIndex + 1) != -1
                  ? rest.indexOf('=', dotIndex + 1)
                  : Integer.MAX_VALUE);

      String classPart =
          nextSpecial != Integer.MAX_VALUE
              ? rest.substring(dotIndex + 1, nextSpecial)
              : rest.substring(dotIndex + 1);

      info.className = classPart.trim();
    }

    // پردازش ID
    if (rest.contains("#")) {
      int hashIndex = rest.indexOf('#');
      int nextSpecial =
          Math.min(
              rest.indexOf('.', hashIndex + 1) != -1
                  ? rest.indexOf('.', hashIndex + 1)
                  : Integer.MAX_VALUE,
              rest.indexOf('=', hashIndex + 1) != -1
                  ? rest.indexOf('=', hashIndex + 1)
                  : Integer.MAX_VALUE);

      String idPart =
          nextSpecial != Integer.MAX_VALUE
              ? rest.substring(hashIndex + 1, nextSpecial)
              : rest.substring(hashIndex + 1);

      info.id = idPart.trim();
    }
    if (rest.contains("=")) {
      int equalIndex = rest.indexOf('=');
      String attrStr = rest.substring(equalIndex + 1).trim();

      // تقسیم ویژگی‌ها با & (مثلا div=type=button&name=submit)
      String[] attrPairs = attrStr.split("&");
      for (String pair : attrPairs) {
        String[] keyValue = pair.split("=", 2);
        if (keyValue.length == 2) {
          info.attributes.put(keyValue[0].trim(), keyValue[1].trim());
        }
      }
    }

    return info;
  }

  private String tibuteValue(String value) {
    return value
        .replace("\"", "&quot;")
        .replace("'", "&apos;")
        .replace("<", "&lt;")
        .replace(">", "&gt;");
  }
}
