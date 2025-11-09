package lsp4custom.com.ninjacoder.customhtmllsp;

import android.util.Log;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.github.rosemoe.sora.data.CompletionItem;
import io.github.rosemoe.sora.langs.html.HTMLLanguage;
import io.github.rosemoe.sora.widget.TextSummry.HTMLConstants;
import io.github.rosemoe.sora.widget.Transilt;
import ir.ninjacoder.ghostide.core.GhostIdeAppLoader;
import ir.ninjacoder.ghostide.core.utils.DataUtil;

public class Css3Server {
  private Random RANDOM = new Random();
  private int COLORS_TO_GENERATE = 20;

  protected HTMLConstants htmlconfig;

  public Css3Server() {
    htmlconfig = new HTMLConstants();
  }
  public void hot(List<CompletionItem> item,String prefix){
    var iv= new Css3Attr();
    iv.install(item,prefix);
    
  }
  public void install(List<CompletionItem> list, String prfex) {
    
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
    if (prefix.contains("color:") || prefix.contains("color: ")) {
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
    list.addAll(CodeSnippet.getCssShortcuts(prefix));
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
        if (it.name().contains(typePrefix)) {
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
          list.add(css("text-align:" + it + " ;", "css Al"));
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
}
