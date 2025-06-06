package ir.ninjacoder.ghostide.widget.data;

import com.helger.css.ECSSVersion;
import com.helger.css.decl.CSSKeyframesBlock;
import com.helger.css.decl.CSSKeyframesRule;
import com.helger.css.reader.CSSReader;
import com.helger.css.decl.CSSStyleRule;
import com.helger.css.decl.CSSDeclaration;
import com.helger.css.decl.CSSExpression;
import com.helger.css.reader.CSSReaderSettings;
import com.helger.css.writer.CSSWriter;
import com.helger.css.decl.CascadingStyleSheet;
import com.helger.css.writer.CSSWriterSettings;
import ir.ninjacoder.ghostide.IdeEditor;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.HashMap;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import org.jsoup.Jsoup;

public class ColorChecker {
  private IdeEditor editText;
  private Map<String, String> colorMap = new HashMap<>();

  public ColorChecker(IdeEditor editText) {
    this.editText = editText;
    initializeColorMap();

    var doc = Jsoup.parse(editText.getText().toString());
    var styleTags = doc.select("style");
    doc.outputSettings().indentAmount(2).prettyPrint(true).outline(true);
    for (var styleTag : styleTags) {
      String originalCss = styleTag.html();
      String processedCss = processCss(originalCss);
      String indentedCss =
          Arrays.stream(processedCss.split("\n"))
              .map(line -> " \t\t\t   " + line)
              .collect(Collectors.joining("\n"));

      styleTag.html("\n" + indentedCss + "\n    ");
    }

    // Set the entire modified document back
    editText.setText(doc.outerHtml());
  }

  static String geyCss4(String code) {
    CascadingStyleSheet aCSS = CSSReader.readFromString(code, ECSSVersion.CSS30);
    CSSWriterSettings aSettings = new CSSWriterSettings(ECSSVersion.LATEST, false);
    CSSWriter aWriter = new CSSWriter(aSettings).setWriteHeaderText(false);
    return aWriter.getCSSAsString(aCSS);
  }

  public static String fromatWeb(String code) {
    var doc = Jsoup.parse(code);
    var styleTags = doc.select("style");
    doc.outputSettings().indentAmount(2).prettyPrint(true).outline(true);
    for (var styleTag : styleTags) {
      String originalCss = styleTag.html();
      String processedCss = geyCss4(originalCss);
      String indentedCss =
          Arrays.stream(processedCss.split("\n"))
              .map(line -> " \t\t\t   " + line)
              .collect(Collectors.joining("\n"));

      styleTag.html("\n" + indentedCss + "\n    ");
    }
    return doc.outerHtml();
  }

  private void initializeColorMap() {

    try {
      String json =
          """


		    [
        {
            "colorName": "aliceblue",
            "cssColor": "#f0f8ff"
        },
        {
            "colorName": "antiquewhite",
            "cssColor": "#faebd7"
        },
        {
            "colorName": "aqua",
            "cssColor": "#00ffff"
        },
        {
            "colorName": "aquamarine",
            "cssColor": "#7fffd4"
        },
        {
            "colorName": "azure",
            "cssColor": "#f0ffff"
        },
        {
            "colorName": "beige",
            "cssColor": "#f5f5dc"
        },
        {
            "colorName": "bisque",
            "cssColor": "#ffe4c4"
        },
        {
            "colorName": "black",
            "cssColor": "#000000"
        },
        {
            "colorName": "blanchedalmond",
            "cssColor": "#ffebcd"
        },
        {
            "colorName": "blue",
            "cssColor": "#0000ff"
        },
        {
            "colorName": "blueviolet",
            "cssColor": "#8a2be2"
        },
        {
            "colorName": "brown",
            "cssColor": "#a52a2a"
        },
        {
            "colorName": "burlywood",
            "cssColor": "#deb887"
        },
        {
            "colorName": "cadetblue",
            "cssColor": "#5f9ea0"
        },
        {
            "colorName": "chartreuse",
            "cssColor": "#7fff00"
        },
        {
            "colorName": "chocolate",
            "cssColor": "#d2691e"
        },
        {
            "colorName": "coral",
            "cssColor": "#ff7f50"
        },
        {
            "colorName": "cornflowerblue",
            "cssColor": "#6495ed"
        },
        {
            "colorName": "cornsilk",
            "cssColor": "#fff8dc"
        },
        {
            "colorName": "crimson",
            "cssColor": "#dc143c"
        },
        {
            "colorName": "cyan",
            "cssColor": "#00ffff"
        },
        {
            "colorName": "darkblue",
            "cssColor": "#00008b"
        },
        {
            "colorName": "darkcyan",
            "cssColor": "#008b8b"
        },
        {
            "colorName": "darkgoldenrod",
            "cssColor": "#b8860b"
        },
        {
            "colorName": "darkgray",
            "cssColor": "#a9a9a9"
        },
        {
            "colorName": "darkgrey",
            "cssColor": "#a9a9a9"
        },
        {
            "colorName": "darkgreen",
            "cssColor": "#006400"
        },
        {
            "colorName": "darkkhaki",
            "cssColor": "#bdb76b"
        },
        {
            "colorName": "darkmagenta",
            "cssColor": "#8b008b"
        },
        {
            "colorName": "darkolivegreen",
            "cssColor": "#556b2f"
        },
        {
            "colorName": "darkorange",
            "cssColor": "#ff8c00"
        },
        {
            "colorName": "darkorchid",
            "cssColor": "#9932cc"
        },
        {
            "colorName": "darkred",
            "cssColor": "#8b0000"
        },
        {
            "colorName": "darksalmon",
            "cssColor": "#e9967a"
        },
        {
            "colorName": "darkseagreen",
            "cssColor": "#8fbc8f"
        },
        {
            "colorName": "darkslateblue",
            "cssColor": "#483d8b"
        },
        {
            "colorName": "darkslategray",
            "cssColor": "#2f4f4f"
        },
        {
            "colorName": "darkslategrey",
            "cssColor": "#2f4f4f"
        },
        {
            "colorName": "darkturquoise",
            "cssColor": "#00ced1"
        },
        {
            "colorName": "darkviolet",
            "cssColor": "#9400d3"
        },
        {
            "colorName": "deeppink",
            "cssColor": "#ff1493"
        },
        {
            "colorName": "deepskyblue",
            "cssColor": "#00bfff"
        },
        {
            "colorName": "dimgray",
            "cssColor": "#696969"
        },
        {
            "colorName": "dimgrey",
            "cssColor": "#696969"
        },
        {
            "colorName": "dodgerblue",
            "cssColor": "#1e90ff"
        },
        {
            "colorName": "firebrick",
            "cssColor": "#b22222"
        },
        {
            "colorName": "floralwhite",
            "cssColor": "#fffaf0"
        },
        {
            "colorName": "forestgreen",
            "cssColor": "#228b22"
        },
        {
            "colorName": "fuchsia",
            "cssColor": "#ff00ff"
        },
        {
            "colorName": "gainsboro",
            "cssColor": "#dcdcdc"
        },
        {
            "colorName": "ghostwhite",
            "cssColor": "#f8f8ff"
        },
        {
            "colorName": "gold",
            "cssColor": "#ffd700"
        },
        {
            "colorName": "goldenrod",
            "cssColor": "#daa520"
        },
        {
            "colorName": "gray",
            "cssColor": "#808080"
        },
        {
            "colorName": "grey",
            "cssColor": "#808080"
        },
        {
            "colorName": "green",
            "cssColor": "#008000"
        },
        {
            "colorName": "greenyellow",
            "cssColor": "#adff2f"
        },
        {
            "colorName": "honeydew",
            "cssColor": "#f0fff0"
        },
        {
            "colorName": "hotpink",
            "cssColor": "#ff69b4"
        },
        {
            "colorName": "indianred",
            "cssColor": "#cd5c5c"
        },
        {
            "colorName": "indigo",
            "cssColor": "#4b0082"
        },
        {
            "colorName": "ivory",
            "cssColor": "#fffff0"
        },
        {
            "colorName": "khaki",
            "cssColor": "#f0e68c"
        },
        {
            "colorName": "lavender",
            "cssColor": "#e6e6fa"
        },
        {
            "colorName": "lavenderblush",
            "cssColor": "#fff0f5"
        },
        {
            "colorName": "lawngreen",
            "cssColor": "#7cfc00"
        },
        {
            "colorName": "lemonchiffon",
            "cssColor": "#fffacd"
        },
        {
            "colorName": "lightblue",
            "cssColor": "#add8e6"
        },
        {
            "colorName": "lightcoral",
            "cssColor": "#f08080"
        },
        {
            "colorName": "lightcyan",
            "cssColor": "#e0ffff"
        },
        {
            "colorName": "lightgoldenrodyellow",
            "cssColor": "#fafad2"
        },
        {
            "colorName": "lightgray",
            "cssColor": "#d3d3d3"
        },
        {
            "colorName": "lightgrey",
            "cssColor": "#d3d3d3"
        },
        {
            "colorName": "lightgreen",
            "cssColor": "#90ee90"
        },
        {
            "colorName": "lightpink",
            "cssColor": "#ffb6c1"
        },
        {
            "colorName": "lightsalmon",
            "cssColor": "#ffa07a"
        },
        {
            "colorName": "lightseagreen",
            "cssColor": "#20b2aa"
        },
        {
            "colorName": "lightskyblue",
            "cssColor": "#87cefa"
        },
        {
            "colorName": "lightslategray",
            "cssColor": "#778899"
        },
        {
            "colorName": "lightslategrey",
            "cssColor": "#778899"
        },
        {
            "colorName": "lightsteelblue",
            "cssColor": "#b0c4de"
        },
        {
            "colorName": "lightyellow",
            "cssColor": "#ffffe0"
        },
        {
            "colorName": "lime",
            "cssColor": "#00ff00"
        },
        {
            "colorName": "limegreen",
            "cssColor": "#32cd32"
        },
        {
            "colorName": "linen",
            "cssColor": "#faf0e6"
        },
        {
            "colorName": "magenta",
            "cssColor": "#ff00ff"
        },
        {
            "colorName": "maroon",
            "cssColor": "#800000"
        },
        {
            "colorName": "mediumaquamarine",
            "cssColor": "#66cdaa"
        },
        {
            "colorName": "mediumblue",
            "cssColor": "#0000cd"
        },
        {
            "colorName": "mediumorchid",
            "cssColor": "#ba55d3"
        },
        {
            "colorName": "mediumpurple",
            "cssColor": "#9370db"
        },
        {
            "colorName": "mediumseagreen",
            "cssColor": "#3cb371"
        },
        {
            "colorName": "mediumslateblue",
            "cssColor": "#7b68ee"
        },
        {
            "colorName": "mediumspringgreen",
            "cssColor": "#00fa9a"
        },
        {
            "colorName": "mediumturquoise",
            "cssColor": "#48d1cc"
        },
        {
            "colorName": "mediumvioletred",
            "cssColor": "#c71585"
        },
        {
            "colorName": "midnightblue",
            "cssColor": "#191970"
        },
        {
            "colorName": "mintcream",
            "cssColor": "#f5fffa"
        },
        {
            "colorName": "mistyrose",
            "cssColor": "#ffe4e1"
        },
        {
            "colorName": "moccasin",
            "cssColor": "#ffe4b5"
        },
        {
            "colorName": "navajowhite",
            "cssColor": "#ffdead"
        },
        {
            "colorName": "navy",
            "cssColor": "#000080"
        },
        {
            "colorName": "oldlace",
            "cssColor": "#fdf5e6"
        },
        {
            "colorName": "olive",
            "cssColor": "#808000"
        },
        {
            "colorName": "olivedrab",
            "cssColor": "#6b8e23"
        },
        {
            "colorName": "orange",
            "cssColor": "#ffa500"
        },
        {
            "colorName": "orangered",
            "cssColor": "#ff4500"
        },
        {
            "colorName": "orchid",
            "cssColor": "#da70d6"
        },
        {
            "colorName": "palegoldenrod",
            "cssColor": "#eee8aa"
        },
        {
            "colorName": "palegreen",
            "cssColor": "#98fb98"
        },
        {
            "colorName": "paleturquoise",
            "cssColor": "#afeeee"
        },
        {
            "colorName": "palevioletred",
            "cssColor": "#db7093"
        },
        {
            "colorName": "papayawhip",
            "cssColor": "#ffefd5"
        },
        {
            "colorName": "peachpuff",
            "cssColor": "#ffdab9"
        },
        {
            "colorName": "peru",
            "cssColor": "#cd853f"
        },
        {
            "colorName": "pink",
            "cssColor": "#ffc0cb"
        },
        {
            "colorName": "plum",
            "cssColor": "#dda0dd"
        },
        {
            "colorName": "powderblue",
            "cssColor": "#b0e0e6"
        },
        {
            "colorName": "purple",
            "cssColor": "#800080"
        },
        {
            "colorName": "red",
            "cssColor": "#ff0000"
        },
        {
            "colorName": "rosybrown",
            "cssColor": "#bc8f8f"
        },
        {
            "colorName": "royalblue",
            "cssColor": "#4169e1"
        },
        {
            "colorName": "saddlebrown",
            "cssColor": "#8b4513"
        },
        {
            "colorName": "salmon",
            "cssColor": "#fa8072"
        },
        {
            "colorName": "sandybrown",
            "cssColor": "#f4a460"
        },
        {
            "colorName": "seagreen",
            "cssColor": "#2e8b57"
        },
        {
            "colorName": "seashell",
            "cssColor": "#fff5ee"
        },
        {
            "colorName": "sienna",
            "cssColor": "#a0522d"
        },
        {
            "colorName": "silver",
            "cssColor": "#c0c0c0"
        },
        {
            "colorName": "skyblue",
            "cssColor": "#87ceeb"
        },
        {
            "colorName": "slateblue",
            "cssColor": "#6a5acd"
        },
        {
            "colorName": "slategray",
            "cssColor": "#708090"
        },
        {
            "colorName": "slategrey",
            "cssColor": "#708090"
        },
        {
            "colorName": "snow",
            "cssColor": "#fffafa"
        },
        {
            "colorName": "springgreen",
            "cssColor": "#00ff7f"
        },
        {
            "colorName": "steelblue",
            "cssColor": "#4682b4"
        },
        {
            "colorName": "tan",
            "cssColor": "#d2b48c"
        },
        {
            "colorName": "teal",
            "cssColor": "#008080"
        },
        {
            "colorName": "thistle",
            "cssColor": "#d8bfd8"
        },
        {
            "colorName": "tomato",
            "cssColor": "#ff6347"
        },
        {
            "colorName": "turquoise",
            "cssColor": "#40e0d0"
        },
        {
            "colorName": "violet",
            "cssColor": "#ee82ee"
        },
        {
            "colorName": "wheat",
            "cssColor": "#f5deb3"
        },
        {
            "colorName": "white",
            "cssColor": "#ffffff"
        },
        {
            "colorName": "whitesmoke",
            "cssColor": "#f5f5f5"
        },
        {
            "colorName": "yellow",
            "cssColor": "#ffff00"
        },
        {
            "colorName": "yellowgreen",
            "cssColor": "#9acd32"
        },
        {
            "colorName":"drakheil",
            "cssColor":"#340171"
        }
        ]
	  """;
      JSONArray jsonArray = new JSONArray(json);
      for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject colorObj = jsonArray.getJSONObject(i);
        String colorName = colorObj.getString("colorName");
        String cssColor = colorObj.getString("cssColor").toLowerCase();
        colorMap.put(cssColor, colorName);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public String processCss(String cssCode) {
    try {
      CSSReaderSettings readerSettings = new CSSReaderSettings();
      CascadingStyleSheet css =
          CSSReader.readFromString(cssCode, StandardCharsets.UTF_8, ECSSVersion.LATEST);

      if (css == null) {
        return cssCode;
      }

      for (CSSStyleRule rule : css.getAllStyleRules()) {
        processDeclarations(rule);
      }
      for (CSSKeyframesRule keyframesRule : css.getAllKeyframesRules()) {
        for (CSSKeyframesBlock block : keyframesRule.getAllBlocks()) {
          for (CSSDeclaration decl : block.getAllDeclarations()) {
            if (isColorProperty(decl.getProperty())) {
              String colorValue = extractColorValue(decl.getExpression());
              String colorName = detectColorName(colorValue);
              if (colorName != null) {
                String newValue = colorValue + " /* " + colorName + " */";
                decl.setExpression(CSSExpression.createSimple(newValue));
              }
            }
          }
        }
      }
      CSSWriterSettings writerSettings = new CSSWriterSettings(ECSSVersion.LATEST);
      writerSettings.setOptimizedOutput(false);
      writerSettings.setIndent("\t\t\t");
      CSSWriter writer = new CSSWriter(writerSettings).setWriteHeaderText(false);

      return writer.getCSSAsString(css);

    } catch (Exception e) {
      e.printStackTrace();
      return cssCode;
    }
  }

  private void processDeclarations(CSSStyleRule rule) {
    for (CSSDeclaration decl : rule.getAllDeclarations()) {
      if (isColorProperty(decl.getProperty())) {
        String originalValue = extractColorValue(decl.getExpression());
        String processedValue = processColorValue(originalValue);

        if (!originalValue.equals(processedValue)) {
          decl.setExpression(CSSExpression.createSimple(processedValue));
        }
      }
    }
  }

  private String processGradient(String gradient) {
    Pattern pattern =
        Pattern.compile("(linear|radial|conic)-gradient\\(([^)]+)\\)", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(gradient);
    if (!matcher.find()) {
      return gradient;
    }

    String type = matcher.group(1);
    String content = matcher.group(2);

    String[] parts = content.split(",");
    StringBuilder result = new StringBuilder(type + "-gradient(");

    for (int i = 0; i < parts.length; i++) {
      String part = parts[i].trim();

      String[] colorAndPos = part.split("(?<=\\S)(?=\\s|$)");
      if (colorAndPos.length > 0) {
        String color = colorAndPos[0];
        String colorName = detectColorName(color);

        if (colorName != null) {
          part =
              color
                  + " /* "
                  + colorName
                  + " */"
                  + (colorAndPos.length > 1 ? " " + colorAndPos[1] : "");
        }
      }

      result.append(i > 0 ? ", " : "").append(part);
    }

    return result.append(")").toString();
  }

  private String extractColorValue(CSSExpression expression) {

    if (!expression.getAllMembers().isEmpty()) {
      for (var it : expression.getAllMembers()) {
        return it.getAsCSSString();
      }
    }
    return "";
  }

  private boolean isColorProperty(String property) {
    return property.endsWith("color")
        || property.equals("background")
        || property.equals("border-color")
        || property.equals("fill")
        || property.equals("stroke");
  }

  private String detectColorName(String colorValue) {
    if (colorValue == null || colorValue.isEmpty()) {
      return null;
    }

    String lowerValue = colorValue.toLowerCase().trim();

    if (colorMap.containsValue(lowerValue)) {
      return lowerValue;
    }

    if (lowerValue.startsWith("#")) {
      String hex = normalizeHex(lowerValue);
      return colorMap.getOrDefault(hex, null);
    }

    if (lowerValue.startsWith("rgb")) {
      String hex = convertRgbaToHex(lowerValue);
      if (hex != null) {
        String baseColor = colorMap.get(hex);
        if (baseColor != null) {
          if (lowerValue.startsWith("rgba")) {
            float alpha = extractAlpha(lowerValue);
            return baseColor + " (alpha: " + String.format("%.1f", alpha) + ")";
          }
          return baseColor;
        }
      }
    }

    if (lowerValue.startsWith("hsl")) {
      String hex = convertHslToHex(lowerValue);
      return hex != null ? colorMap.getOrDefault(hex, null) : null;
    }

    return null;
  }

  private String processColorValue(String value) {
    if (value == null || value.isEmpty()) {
      return value;
    }

    if (value.contains("gradient(")) {
      return processGradient(value);
    }

    String colorName = detectColorName(value);
    if (colorName != null) {

      if (value.toLowerCase().contains("rgba")) {
        return value + " /* " + colorName + " */";
      }
      return value + " /* " + colorName + " */";
    }
    return value;
  }

  private String normalizeHex(String hex) {
    if (hex.length() == 4) {
      return "#"
          + hex.charAt(1)
          + hex.charAt(1)
          + hex.charAt(2)
          + hex.charAt(2)
          + hex.charAt(3)
          + hex.charAt(3);
    }
    return hex;
  }

  private String convertRgbaToHex(String rgbaValue) {
    try {
      String[] parts = rgbaValue.replaceAll("[rgba()]", "").split(",");
      int r = Integer.parseInt(parts[0].trim());
      int g = Integer.parseInt(parts[1].trim());
      int b = Integer.parseInt(parts[2].trim());
      return String.format("#%02x%02x%02x", r, g, b);
    } catch (Exception e) {
      return null;
    }
  }

  private float extractAlpha(String rgbaValue) {
    try {
      String[] parts = rgbaValue.replaceAll("[rgba()]", "").split(",");
      if (parts.length >= 4) {
        return Float.parseFloat(parts[3].trim());
      }
    } catch (Exception e) {

    }
    return 1.0f;
  }

  private String convertHslToHex(String hslValue) {
    try {
      String[] parts = hslValue.replaceAll("[hsla()%]", "").split(",");
      float h = Float.parseFloat(parts[0].trim());
      float s = Float.parseFloat(parts[1].trim()) / 100;
      float l = Float.parseFloat(parts[2].trim()) / 100;
      float c = (1 - Math.abs(2 * l - 1)) * s;
      float x = c * (1 - Math.abs((h / 60) % 2 - 1));
      float m = l - c / 2;

      float r, g, b;
      if (h < 60) {
        r = c;
        g = x;
        b = 0;
      } else if (h < 120) {
        r = x;
        g = c;
        b = 0;
      } else if (h < 180) {
        r = 0;
        g = c;
        b = x;
      } else if (h < 240) {
        r = 0;
        g = x;
        b = c;
      } else if (h < 300) {
        r = x;
        g = 0;
        b = c;
      } else {
        r = c;
        g = 0;
        b = x;
      }
      int red = Math.round((r + m) * 255);
      int green = Math.round((g + m) * 255);
      int blue = Math.round((b + m) * 255);
      return String.format("#%02x%02x%02x", red, green, blue);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
