package io.github.rosemoe.sora.langs.javascript;

import android.content.SharedPreferences;
import android.app.Activity;
import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import io.github.rosemoe.sora.data.CompletionItem;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import ir.ninjacoder.ghostide.config.ChlidJavaList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import lsp4custom.com.ninjacoder.customhtmllsp.CodeSnippet;

public class JsAutoComplete implements AutoCompleteProvider {

  private String[] mKeywords;
  private boolean mKeywordsAreLowCase;
  protected SharedPreferences save_path; // using default name

  public JsAutoComplete() {
    save_path =
        GhostIdeAppLoader.getContext().getSharedPreferences("save_path", Activity.MODE_PRIVATE);
  }

  public void setKeywords(String[] keywords) {
    mKeywords = keywords;
    mKeywordsAreLowCase = false;
  }

  @Override
  public List<CompletionItem> getAutoCompleteItems(
      String prefix, TextAnalyzeResult analyzeResult, int line, int column) {
    List<CompletionItem> keywords = new ArrayList<>();
    final String[] keywordArray = mKeywords;
    final boolean lowCase = mKeywordsAreLowCase;

    String match = prefix;
    if (keywordArray != null) {
      for (String kw : keywordArray) {
        if (kw.startsWith(match)) {
          keywords.add(new CompletionItem(kw, "Js key"));
        }
      }
    }
    Collections.sort(keywords, CompletionItem.COMPARATOR_BY_NAME);
    Object extra = analyzeResult.getExtra();
    Identifiers userIdentifiers = (extra instanceof Identifiers) ? (Identifiers) extra : null;
    if (userIdentifiers != null) {
      List<CompletionItem> words = new ArrayList<>();
      for (String word : userIdentifiers.getIdentifiers()) {
        if (word.startsWith(match)) {
          words.add(new CompletionItem(word, "Identifier"));
        }
      }
      Collections.sort(words, CompletionItem.COMPARATOR_BY_NAME);
      keywords.addAll(CodeSnippet.runasList("javascript", prefix));
      keywords.addAll(CodeSnippet.getListFile(save_path.getString("path", ""), prefix));

      CompletionItem myitem = new CompletionItem();

      List<String> l = ChlidJavaList.getPhpMethodsList(GhostIdeAppLoader.getContext());
      for (var let : l) {
        if (prefix.startsWith(let)) {
          keywords.add(new CompletionItem(let, "test"));
        }
      }
      keywords.addAll(words);
    }
    return keywords;
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
