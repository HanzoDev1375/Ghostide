package io.github.rosemoe.sora.langs.less;

import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.util.ArrayList;
import java.util.List;

public class LessAutoComplete implements AutoCompleteProvider {

  private CodeEditor editor;
  private List<CompletionItem> item = new ArrayList<>();

  public LessAutoComplete(CodeEditor editor) {
    this.editor = editor;
  }

  @Override
  public List<CompletionItem> getAutoCompleteItems(
      String prefix, TextAnalyzeResult analyzeResult, int line, int column) {
    String[] lessKeywords = {
      "@import",
      "@media",
      "@keyframes",
      "@font-face",
      "@namespace",
      "@supports",
      "@document",
      "@page",
      "@charset",
      "@viewport",
      "@counter-style",
      "@color-profile",
      "@property",
      "@-moz-document",
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
    for (var it : lessKeywords) {
      if (it.startsWith(prefix)) {
        add(it, "lessKeyWord");
      }
    }
    return item;
  }

  private String get() {
    return editor.getTextAsString();
  }

  void add(String data, String doc) {
    item.add(new CompletionItem(data, doc));
  }
}
