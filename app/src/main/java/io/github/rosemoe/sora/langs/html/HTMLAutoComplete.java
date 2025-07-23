package io.github.rosemoe.sora.langs.html;

import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import android.app.Activity;
import android.content.SharedPreferences;
import android.net.Uri;
import io.github.rosemoe.sora.data.CompletionItem;
import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.langs.IdentifierAutoComplete;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.TextSummry.HTMLConstants;
import io.github.rosemoe.sora.widget.commentRule.AppConfig;
import ir.ninjacoder.ghostide.IdeEditor;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import java.io.File;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lsp4custom.com.ninjacoder.customhtmllsp.CodeSnippet;
import lsp4custom.com.ninjacoder.customhtmllsp.CssAnalyzer;
import lsp4custom.com.ninjacoder.customhtmllsp.ListKeyword;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import lsp4custom.com.ninjacoder.customhtmllsp.ScriptAnalyzer;
import org.jsoup.Jsoup;

public class HTMLAutoComplete implements AutoCompleteProvider {
  protected HTMLConstants htmlconfig;

  String Folder = "";
  String prfex = "";
  AppConfig config;
  ListKeyword keyhtml;
  String[] comit = {"Comment", "Lorem1"};
  private List<CompletionItem> items;
  private String[] mKeywords;
  private CompletionItem listItem;
  private boolean mKeywordsAreLowCase;
  private ArrayList<String> pathz;
  private CodeEditor editor;
  private IdentifierAutoComplete.Identifiers userIdentifiers;
  private TextAnalyzeResult analyzeResult;
  protected SharedPreferences save_path; // using default name

  public HTMLAutoComplete(CodeEditor editor) {
    config = new AppConfig();
    this.editor = editor;
    htmlconfig = new HTMLConstants();
    userIdentifiers = new IdentifierAutoComplete.Identifiers();
    pathz = new ArrayList<>();
    keyhtml = new ListKeyword();

    save_path =
        GhostIdeAppLoader.getContext().getSharedPreferences("save_path", Activity.MODE_PRIVATE);
  }

  @Override
  public List<CompletionItem> getAutoCompleteItems(
      String prefix, TextAnalyzeResult result, int line, int column) {
    prfex = prefix;
    analyzeResult = result;
    items = new ArrayList<>();
    setList(prefix);
    validTag();
    // classTag(prefix);
    // idTags(prefix);

    Collections.sort(items, CompletionItem.COMPARATOR_BY_NAME);

    Collections.sort(items, CompletionItem.COMPARATOR_BY_NAME);
    Object extra = analyzeResult.getExtra();
    Identifiers userIdentifiers = (extra instanceof Identifiers) ? (Identifiers) extra : null;
    if (userIdentifiers != null) {
      List<CompletionItem> words = new ArrayList<>();
      for (String word : userIdentifiers.getIdentifiers()) {
        if (prfex.startsWith(word)) {
          words.add(new CompletionItem(word, "ABC"));
        }
      }
      Collections.sort(words, CompletionItem.COMPARATOR_BY_NAME);
      items.addAll(words);
    }
    var doc = Jsoup.parse(editor.getTextAsString());
    var allElements = doc.select("*");
    for (var it : allElements) {
      var className = it.attr("class");
      var idName = it.attr("id");
      if (className.startsWith(prefix)) {
        items.add(new CompletionItem(className, "CssClass"));
      }
      if (idName.startsWith(prefix)) {
        items.add(new CompletionItem(idName, "CssId"));
      }
    }

    var css2 =
        new CssAnalyzer(editor.getContext(), prfex, new File(save_path.getString("path", "")));
    css2.setListener(
        (m) -> {
          items.addAll(m);
        });
    css2.analyzeHtml(editor.getText().toString());
    items.addAll(CodeSnippet.runasList("html", prefix));
    items.addAll(CodeSnippet.getListFile(save_path.getString("path", ""), prefix));
    items.addAll(CodeSnippet.getPhpLsp(prefix));
    return items;
  }

  private boolean isValidTag(String tag) {
    for (String validTag : keyhtml.TAGS) {
      if (validTag.equals(tag)) {
        return true;
      }
    }

    return false;
  }

  private CompletionItem attrAsCompletion(String attr, String desc) {
    final var item = new CompletionItem(attr, attr.concat("=\"\""), desc);
    item.cursorOffset(item.commit.length() - 1);
    return item;
  }

  private CompletionItem dddAsCompletion(String ddd, String desc) {
    final var item = new CompletionItem(ddd, desc);
    item.cursorOffset(item.commit.length());
    return item;
  }

  private CompletionItem mcssAsCompletion(String mcss, String desc) {
    final var item = new CompletionItem(mcss, desc);
    item.cursorOffset(item.commit.length());
    return item;
  }

  private CompletionItem ColorcssAsCompletion(String mcss, String desc) {
    final CompletionItem item = new CompletionItem(mcss + "  ", desc);
    item.cursorOffset(item.commit.length() - 1);
    return item;
  }

  private CompletionItem emmet(String em, String desc) {
    final var open =
        "<html lang=\"en\"> \n  <head> \n    <meta charset=\"UTF-8\"> \n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> \n    <title>Document</title> \n  </head> \n  <body>  \n  </body>\n</html>";
    final CompletionItem item = new CompletionItem(em, desc);
    item.commit = open;
    item.cursorOffset(item.commit.length() - open.length());
    return item;
  }

  private CompletionItem getEmmetItemPost(String em, String doc) {
    final String open = "<".concat(em).concat("/>");
    final var item = new CompletionItem(em, doc);
    item.commit = open;
    item.cursorOffset(item.commit.length() - open.length());
    return item;
  }

  private CompletionItem tagAsCompletion(String tag, String desc) {
    final String open = "<".concat(tag).concat(">");
    final String close = "</".concat(tag).concat(">");
    final var item = new CompletionItem(tag, desc);
    item.commit = open.concat(close);
    item.cursorOffset(item.commit.length() - close.length());
    return item;
  }

  private CompletionItem AutoCompletion(String tag, String desc, String items) {
    var userName = "class =".concat("\"".concat(ClassName("classTest").concat("\"")));
    String open =
        "<".concat(tag.replace(items, "".trim())).concat(" " + userName + " ").concat(">");
    String close = "</".concat(tag.replace(items, "".trim())).concat(">");
    var item = new CompletionItem(tag, desc);
    item.commit = open.concat(close);
    item.commit.endsWith(items.replace(items, "".trim()));
    item.cursorOffset(item.commit.length() - close.length());
    return item;
  }

  private CompletionItem getId(String tag, String desc, String items) {
    var userName = "id =".concat("\"".concat(ClassName("Id_Test").concat("\"")));
    String open =
        "<".concat(tag.replace(items, "".trim())).concat(" " + userName + " ").concat(">");
    String close = "</".concat(tag.replace(items, "".trim())).concat(">");
    CompletionItem item = new CompletionItem(tag, desc);
    item.commit = open.concat(close);
    boolean endsWith = item.commit.endsWith(items.replace(items, "".trim()));
    item.cursorOffset(item.commit.length() - close.length());
    return item;
  }

  private CompletionItem PhpAsCompletion(String php, String desc) {
    final CompletionItem item = new CompletionItem(php, desc);
    item.cursorOffset(item.commit.length());
    return item;
  }

  protected String ClassName(String base) {
    var random = new Random();
    int rd = random.nextInt(400282);
    return base + rd + " ";
  }

  private CompletionItem CodeSampel(String em, String desc, String codeS) {
    final String open = codeS;
    final CompletionItem item = new CompletionItem(em, desc);
    item.commit = open;
    item.cursorOffset(item.commit.length() - open.length());
    return item;
  }

  void Style(
      List<CompletionItem> items,
      String prefix,
      TextAnalyzeResult result,
      int line,
      int column,
      String mcss) {
    items.add(mcssAsCompletion(mcss + " : ", "Css3 keyword"));
    //	result.addIfNeeded(line,column,TextStyle.makeStyle(EditorColorScheme.ATTRIBUTE_VALUE,0,false,true,false));
  }

  void Style2(
      List<CompletionItem> items,
      String prefix,
      TextAnalyzeResult result,
      int line,
      int column,
      String mcss) {
    items.add(ColorcssAsCompletion(mcss, "Color Css "));
    //	result.addIfNeeded(line,column,TextStyle.makeStyle(EditorColorScheme.AUTO_COMP_PANEL_CORNER,CssColor(prefix),false,false,true));
  }

  /** تولید متن تصادفی Lorem Ipsum با تعداد کلمات مشخص مثال: loram200 → 200 کلمه تصادفی */
  public String getLoramRandom(String input) {
    // لیست ثابت از کلمات Lorem Ipsum (مختصر شده)
    String[] loremWords = {
      "Lorem",
      "ipsum",
      "dolor",
      "sit",
      "amet",
      "consectetur",
      "adipiscing",
      "elit",
      "sed",
      "do",
      "eiusmod",
      "tempor",
      "incididunt",
      "ut",
      "labore",
      "et",
      "dolore",
      "magna",
      "aliqua",
      "Ut",
      "enim",
      "ad",
      "minim",
      "veniam",
      "quis",
      "nostrud",
      "exercitation",
      "ullamco",
      "laboris",
      "nisi",
      "ut",
      "aliquip",
      "ex",
      "ea",
      "commodo",
      "consequat"
    };

    // استخراج عدد از ورودی (مثال: loram200 → 200)
    int wordCount = 50; // مقدار پیش‌فرض
    try {
      if (input.matches("loram\\d+")) {
        wordCount = Integer.parseInt(input.replace("loram", ""));
      }
    } catch (NumberFormatException e) {
      wordCount = 50; // Fallback
    }

    // تولید متن تصادفی
    Random random = new Random();
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < wordCount; i++) {
      String word = loremWords[random.nextInt(loremWords.length)];
      result.append(word).append(" ");

      // خط‌بندی هر 10 کلمه
      if ((i + 1) % 10 == 0) {
        result.append("\n");
      }
    }

    return result.toString().trim();
  }

  public String last(String pa) {
    return Uri.parse(pa).getLastPathSegment();
  }

  public void setList(String prefix) {
    if (prefix.startsWith("loram"))
      items.add(new CompletionItem(prefix, getLoramRandom(prefix), "Lorem Ipsum (" + prefix + ")"));
    keyhtml.installFromSora(items, prefix);
    keyhtml.installHtmlAttr(items, prfex);
    keyhtml.intallCss3KeyWord(items, prfex);
    keyhtml.installCssAttr(items, prfex);
    keyhtml.intallCss3Color(items, prfex);
    keyhtml.installCssPadding(items, prfex);
    keyhtml.randomColor(items, prfex);

    for (String ddd : HTMLLanguage.JS)
      if (ddd.startsWith(prefix)) items.add(dddAsCompletion(ddd, htmlconfig.JsKey));
    for (String classapp : HTMLLanguage.EmtClass)
      if (classapp.startsWith(prefix))
        items.add(AutoCompletion(classapp, "Class adding", HTMLLanguage.getClass));
    for (String getingId : HTMLLanguage.EmtId)
      if (getingId.startsWith(prefix)) items.add(getId(getingId, "Id Tag", HTMLLanguage.getId));
    for (String post : HTMLLanguage.POSTEEMET)
      if (post.startsWith(prefix)) items.add(getEmmetItemPost(post, htmlconfig.Emmet));
    for (String getEmmt : HTMLLanguage.GETHTML5)
      if (getEmmt.startsWith(prefix)) items.add(emmet(getEmmt, htmlconfig.EmmetTagFor));

    for (String getTagNull : HTMLLanguage.TagNull)
      if (getTagNull.startsWith(prefix)) items.add(getEmmetItemPost(getTagNull, htmlconfig.TagOne));

    for (String post : HTMLLanguage.colorsCss)
      if (post.startsWith(prefix)) items.add(PhpAsCompletion(post, htmlconfig.CssColor));

    for (String span : comit) {
      if (span.equalsIgnoreCase("Comment")) {
        if (span.startsWith(prefix)) {
          items.add(CodeSampel(span, "Html 5 Comment", "<!-- Comment -->"));
        }
      }
    }
  }

  protected String clazz() {
    return "class = " + "\"" + ClassName("ClassTest") + "\"";
  }

  private boolean isClassVaildTag(String tag) {
    for (String clss : HTMLLanguage.EmtClass) {
      if (clss.equals(tag)) {
        return true;
      }
    }
    return false;
  }

  private boolean isIdVaildTag(String tag) {
    for (String clss : HTMLLanguage.EmtId) {
      if (clss.equals(tag)) {
        return true;
      }
    }
    return false;
  }

  public void idTag(String tagsInput) {
    String api = "";
    List<String> validTags = new ArrayList<>();
    Collections.sort(validTags, String.CASE_INSENSITIVE_ORDER);
    String[] tags = tagsInput.split("\\+|\\$");
    for (String tag : tags) {
      String trimmedTag = tag.trim();
      if (isIdVaildTag(trimmedTag)) {
        validTags.add(trimmedTag);
      }
    }

    if (!validTags.isEmpty()) {
      StringBuilder openingTags = new StringBuilder();
      StringBuilder closingTags = new StringBuilder();
      String input = tagsInput;
      /** winter code html like in h1#$1name1+h1#$2name1+h1#$3name1+h1#$4name+h1#$5name */
      Pattern pattern = Pattern.compile("\\#\\$\\d+([a-zA-Z]+)");
      Matcher matcher = pattern.matcher(input);
      StringBuilder result = new StringBuilder();
      while (matcher.find()) {
        result.append(matcher.group(1));
      }
      for (String tag : validTags) {
        api = tag;
        openingTags.append("<" + api.replace("#", "") + " id=\"" + result.toString() + "\">");
        closingTags.insert(0, "</" + api.replace(".", "") + ">");
      }

      String wrappedTags = openingTags.toString() + closingTags.toString();
      CompletionItem tagCompletion = new CompletionItem(api, wrappedTags, "Html Snippet Compat Id");
      tagCompletion.commit = wrappedTags;
      tagCompletion.cursorOffset(tagCompletion.commit.length() - 1);
      items.add(tagCompletion);
    }
  }

  public void classTag(String tagsInput) {
    idTag(tagsInput); // اگر نیاز به پردازش id هم هست
    List<String> validTags = new ArrayList<>();
    String[] tags = tagsInput.split("\\+|\\$");

    // استخراج تمام تگ‌های معتبر از ورودی
    for (String tag : tags) {
      String trimmedTag = tag.trim();
      if (isClassVaildTag(trimmedTag)) {
        validTags.add(trimmedTag);
      }
    }

    if (!validTags.isEmpty()) {
      StringBuilder openingTags = new StringBuilder();
      StringBuilder closingTags = new StringBuilder();
      Pattern pattern = Pattern.compile("\\.\\$(\\d+)([a-zA-Z0-9]+)");
      Matcher matcher = pattern.matcher(tagsInput);

      while (matcher.find()) {
        /// String tagName = matcher.group(1); // نام تگ (مثلاً h1, div, p)
        int count = Integer.parseInt(matcher.group(2)); // عدد بعد از .$
        String className = matcher.group(3); // نام کلاس
        for (var tagName : validTags) {
          for (int i = 0; i <= count; i++) {
            openingTags
                .append("<")
                .append(tagName)
                .append(" class=\"")
                .append(className)
                .append("\">");
            closingTags.insert(0, "</" + tagName + ">");
          }
        }
      }

      String wrappedTags = openingTags.toString() + closingTags.toString();
      CompletionItem tagCompletion =
          new CompletionItem("Class Snippet", wrappedTags, "HTML Class Template");
      tagCompletion.commit = wrappedTags;
      tagCompletion.cursorOffset(openingTags.length() - 1);
      items.add(tagCompletion);
    }
  }

  public void validTag() {
    String api = "";
    List<String> validTags = new ArrayList<>();
    Collections.sort(validTags, String.CASE_INSENSITIVE_ORDER);
    String[] tags = prfex.split("\\+");
    for (String tag : tags) {
      String trimmedTag = tag.trim();
      if (isValidTag(trimmedTag)) {
        validTags.add(trimmedTag);
      }
    }

    if (!validTags.isEmpty()) {
      StringBuilder openingTags = new StringBuilder();
      StringBuilder closingTags = new StringBuilder();
      for (String tag : validTags) {
        api = tag;
        openingTags.append("<").append(tag).append(">");
        closingTags.insert(0, "</" + tag + ">");
      }
      String wrappedTags = openingTags.toString() + closingTags.toString();
      CompletionItem tagCompletion = new CompletionItem(api, wrappedTags, "Html Snippet Compat");
      tagCompletion.commit = wrappedTags;
      tagCompletion.cursorOffset = openingTags.length() - 2;
      //    Collections.sort(tagCompletion, CompletionItem.COMPARATOR_BY_NAME);
      items.add(tagCompletion);
    }
  }

  public void idTags(String tagsInput) {
    String api = "";
    List<String> validTags = new ArrayList<>();
    Collections.sort(validTags, String.CASE_INSENSITIVE_ORDER);
    String[] tags = tagsInput.split("\\+|\\$||\\*");
    for (String tag : tags) {
      String trimmedTag = tag.trim();
      if (isIdVaildTag(trimmedTag)) {
        validTags.add(trimmedTag);
      }
    }

    if (!validTags.isEmpty()) {
      StringBuilder openingTags = new StringBuilder();
      StringBuilder closingTags = new StringBuilder();
      String input = tagsInput;
      /** winter code html like in h1#$1name1+h1#$2name1+h1#$3name1+h1#$4name+h1#$5name */
      Pattern pattern = Pattern.compile("\\#\\$(\\d+)([a-zA-Z]+)");
      Matcher matcher = pattern.matcher(input);
      StringBuilder result = new StringBuilder();
      while (matcher.find()) {
        int num =
            Integer.parseInt(matcher.group(2)); // عدد بعد از '#$' را گرفته و تبدیل به int می کنیم
        String name = matcher.group(3); // نام بعد از عدد را گرفته
        for (String tag : validTags) {
          api = tag;
          for (int i = 1; i <= num; i++) { // از 1 شروع و تا عدد موجود تکرار می‌کنیم
            openingTags.append("<" + api.replace("#", "") + " id=\"" + name + "\">"); // خروجی
            closingTags.insert(0, "</" + api.replace("#", "") + ">");
          }
        }
      }

      String wrappedTags = openingTags.toString() + closingTags.toString();
      CompletionItem tagCompletion = new CompletionItem(api, wrappedTags, "Html Snippet Compat Id");
      tagCompletion.commit = wrappedTags;
      tagCompletion.cursorOffset = openingTags.length() - 2;
      items.add(tagCompletion);
    }
  }

  public static class Identifiers {

    private static final Object SIGN = new Object();
    private final List<String> identifiers = new ArrayList<>();
    private HashMap<String, Object> cache;

    public void addIdentifier(String identifier) {
      if (cache == null) {
        throw new IllegalStateException("begin() has not been called");
      }
      if (cache.put(identifier, SIGN) == SIGN) {
        return;
      }
      identifiers.add(identifier);
    }

    public void begin() {
      cache = new HashMap<>();
    }

    public void finish() {
      cache.clear();
      cache = null;
    }

    public List<String> getIdentifiers() {
      return identifiers;
    }
  }
}
