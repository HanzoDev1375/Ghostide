package io.github.rosemoe.sora.langs.python;

import io.github.rosemoe.sora.data.CompletionItem;
import io.github.rosemoe.sora.langs.python.formatter.PythonAutoCompleter;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import ir.ninjacoder.ghostide.IdeEditor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import lsp4custom.com.ninjacoder.customhtmllsp.CodeSnippet;

public class PythonAutoComplete implements AutoCompleteProvider {

  private String[] mKeywords;
  private boolean mKeywordsAreLowCase;
  private IdeEditor editor;

  public PythonAutoComplete(IdeEditor editor) {
    this.editor = editor;
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
          keywords.add(new CompletionItem(kw, "Python3 keyword"));
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
          words.add(new CompletionItem(word, "( Identifier )"));
        }
      }
      Collections.sort(words, CompletionItem.COMPARATOR_BY_NAME);
      keywords.addAll(words);
    }
    PythonAutoCompleter lsp = new PythonAutoCompleter();

    try {
      keywords.addAll(
          lsp.complete(editor.getContext(), editor.getTextAsString(), line, column, prefix));
    } catch (Exception err) {

    }
    keywords.addAll(CodeSnippet.runasList("python", prefix));
    // keywords.addAll(CodeSnippet.getPythonMethod(prefix));
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
