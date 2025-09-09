package io.github.rosemoe.sora.langs.dart.dartserver;

import io.github.rosemoe.sora.data.CompletionItem;
import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.text.TextAnalyzeResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import lsp4custom.com.ninjacoder.customhtmllsp.CodeSnippet;

public class DartAuto implements AutoCompleteProvider {

  @Override
  public List<CompletionItem> getAutoCompleteItems(
      String prefix, TextAnalyzeResult analyzeResult, int line, int column) {
    List<CompletionItem> list = new ArrayList<>();
    list.clear();
    Object extra = analyzeResult.getExtra();
    if (extra instanceof Identifiers) {
      Identifiers userIdentifiers = (Identifiers) extra;
      List<CompletionItem> words = new ArrayList<>();

      for (String word : userIdentifiers.getIdentifiers()) {
        if (word.startsWith(prefix)) {
          words.add(new CompletionItem(word, "ABC"));
        }
      }

      Collections.sort(words, CompletionItem.COMPARATOR_BY_NAME);
      list.addAll(words);
    }
    for (var it : HotserverDart.keyword) {
      if (it.contains(prefix)) { //like fuzzy mod
        list.add(new CompletionItem(it, "dart keyword"));
      }
    }
    list.addAll(CodeSnippet.runasList("dart", prefix));
    return list;
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
