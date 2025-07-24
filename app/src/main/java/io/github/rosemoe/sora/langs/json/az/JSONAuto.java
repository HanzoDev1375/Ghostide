package io.github.rosemoe.sora.langs.json.az;

import io.github.rosemoe.sora.data.CompletionItem;
import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSONAuto implements AutoCompleteProvider {
  private CodeEditor editor;
  private List<CompletionItem> all = new ArrayList<>();

  public JSONAuto(CodeEditor editor) {
    this.editor = editor;
  }

  @Override
  public List<CompletionItem> getAutoCompleteItems(
      String prefix, TextAnalyzeResult analyzeResult, int line, int column) {
    all.clear(); // Clear previous items

    // Add JSON keywords
    String[] jsonKeys = {"true", "false", "null"};
    for (var ite : jsonKeys) {
      if (ite.startsWith(prefix)) {
        all.add(new CompletionItem(ite, "JsonKeyWord"));
      }
    }

    // Extract keys and values from JSON
    String jsonText = get();
    extractJsonKeysAndValues(jsonText, prefix);

    return all;
  }

  private void extractJsonKeysAndValues(String jsonText, String prefix) {
    Pattern keyPattern = Pattern.compile("\"(.*?)\"\\s*:");
    Matcher keyMatcher = keyPattern.matcher(jsonText);

    while (keyMatcher.find()) {
      String key = keyMatcher.group(1);
      if (key.startsWith(prefix)) {
        all.add(new CompletionItem(key, "JSON Key"));
      }
    }
    Pattern valuePattern = Pattern.compile(":\\s*(\"(.*?)\"|(true|false|null|\\d+\\.?\\d*))");
    Matcher valueMatcher = valuePattern.matcher(jsonText);

    while (valueMatcher.find()) {
      String value =
          valueMatcher.group(2) != null
              ? valueMatcher.group(2)
              : valueMatcher.group(3) != null ? valueMatcher.group(3) : "";
      if (value.startsWith(prefix)) {
        all.add(new CompletionItem(value, "JSON Value"));
      }
    }
  }

  private String get() {
    return editor.getTextAsString();
  }
}
