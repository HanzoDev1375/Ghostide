package io.github.rosemoe.sora.langs.less;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.github.rosemoe.sora.data.CompletionItem;
import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.widget.CodeEditor;

public class LessAutoComplete implements AutoCompleteProvider {

  private CodeEditor editor;
  private List<CompletionItem> items = new ArrayList<>();

  public LessAutoComplete(CodeEditor editor) {
    this.editor = editor;
  }

  @Override
  public List<CompletionItem> getAutoCompleteItems(
      String prefix, TextAnalyzeResult analyzeResult, int line, int column) {
    items.clear();

    // Add LESS keywords
    String[] lessKeywords = {
      "and",
      "not",
      "only",
      "or",
      "when",
      "extend",
      "!important",
      "darken",
      "lighten",
      "saturate",
      "desaturate",
      "fadein",
      "fadeout",
      "fade",
      "spin",
      "mix",
      "hue",
      "saturation",
      "lightness",
      "alpha",
      "round",
      "ceil",
      "floor",
      "percentage",
      "isnumber",
      "isstring",
      "iscolor",
      "iskeyword",
      "isurl",
      "ispixel",
      "isem",
      "ispercentage",
      "isunit",
      "rgb",
      "rgba",
      "hsl",
      "hsla",
      "hsv",
      "hsva",
      "argb",
      "color",
      "convert",
      "unit",
      "get-unit",
      "svg-gradient",
      "escape",
      "default",
      "rest",
      "multiple",
      "when",
      "not",
      "and",
      "or",
      "guard",
      "if",
      "else"
    };

    for (var keyword : lessKeywords) {
      if (keyword.startsWith(prefix)) {
        items.add(new CompletionItem(keyword, "LESS keyword"));
      }
    }

    // Extract LESS variables
    extractLessVariables();

    // Filter variables by prefix
    if (!prefix.isEmpty()) {
      List<CompletionItem> filtered = new ArrayList<>();
      for (CompletionItem item : items) {
        if (item.label.startsWith(prefix)) {
          filtered.add(item);
        }
      }
      return filtered;
    }
    Object extra = analyzeResult.getExtra();
    Identifiers userIdentifiers = (extra instanceof Identifiers) ? (Identifiers) extra : null;
    if (userIdentifiers != null) {
      List<CompletionItem> words = new ArrayList<>();
      for (String word : userIdentifiers.getIdentifiers()) {
        if (word.startsWith(prefix)) {
          words.add(new CompletionItem(word, "Identifier"));
        }
      }
      Collections.sort(words, CompletionItem.COMPARATOR_BY_NAME);
      items.addAll(words);
    }
    return items;
  }

  private void extractLessVariables() {
    String code = get();
    // Pattern for LESS variables:
    // @variable-name: value;
    // Also matches nested variables and complex cases
    Pattern pattern =
        Pattern.compile(
            "@([a-zA-Z][a-zA-Z0-9_-]*)\\s*:" // Match @variable:
                + "(?:[^;{/]+|/\\*(?:.|\\n)*?\\*/|//.*)*?(?=;|\\{|$)" // Match any value until ; or
            // { or end of line
            );

    Matcher matcher = pattern.matcher(code);
    while (matcher.find()) {
      String varName = "@" + matcher.group(1);
      // Avoid duplicates
      boolean exists = items.stream().anyMatch(item -> item.label.equals(varName));
      if (!exists) {
        items.add(new CompletionItem(varName, "LESS variable"));
      }
    }

    // Also find variables used in selector names (like @{variable})
    Pattern selectorVarPattern = Pattern.compile("@\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
    Matcher selectorVarMatcher = selectorVarPattern.matcher(code);
    while (selectorVarMatcher.find()) {
      String varName = "@" + selectorVarMatcher.group(1);
      boolean exists = items.stream().anyMatch(item -> item.label.equals(varName));
      if (!exists) {
        items.add(new CompletionItem(varName, "LESS selector variable"));
      }
    }
  }

  private String get() {
    return editor.getTextAsString();
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
