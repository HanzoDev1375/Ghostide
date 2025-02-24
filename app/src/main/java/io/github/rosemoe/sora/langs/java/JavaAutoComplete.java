package io.github.rosemoe.sora.langs.java;

import ir.ninjacoder.ghostide.IdeEditor;
import ir.ninjacoder.ghostide.config.JavaToGsonHelper;
import ir.ninjacoder.ghostide.config.LOG;
import io.github.rosemoe.sora.data.CompletionItem;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import lsp4custom.com.ninjacoder.customhtmllsp.Css3Server;
import lsp4custom.com.ninjacoder.customhtmllsp.JavaCardshorts;
import lsp4custom.com.ninjacoder.customhtmllsp.TypeScriptCardshorts;

public class JavaAutoComplete implements AutoCompleteProvider {

  private String[] mKeywords;
  private boolean mKeywordsAreLowCase;
  private JavaCardshorts shortcard;
  private IdeEditor editor;
  boolean isMd = false;
  private List<CompletionItem> it;
  private String prf;
  private String[] name;

  public JavaAutoComplete() {}

  public JavaAutoComplete(IdeEditor editor) {
    this.editor = editor;
  }

  public void setMd(boolean isMd) {
    this.isMd = isMd;
  }

  public void setKeywords(String[] keywords) {
    mKeywords = keywords;
    mKeywordsAreLowCase = false;
  }

  public void setKeywords(String[] keywords, String[] name) {
    mKeywords = keywords;
    mKeywordsAreLowCase = false;
    this.name = name;
  }

  @Override
  public List<CompletionItem> getAutoCompleteItems(
      String prefix, TextAnalyzeResult analyzeResult, int line, int column) {
    List<CompletionItem> keywords = new ArrayList<>();
    final String[] keywordArray = mKeywords;
    final boolean lowCase = mKeywordsAreLowCase;
    prf = prefix;

    String match = prefix;
    if (keywordArray != null) {
      for (String kw : keywordArray) {
        if (kw.startsWith(match)) {
          keywords.add(new CompletionItem(kw, "Java Keyword"));
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
          words.add(new CompletionItem(word, "Data?"));
        }
      }
      Collections.sort(words, CompletionItem.COMPARATOR_BY_NAME);
      keywords.addAll(words);
    }
    shortcard = new JavaCardshorts(keywords, prefix, editor);
    JavaToGsonHelper.installFormSora(keywords);

    it = keywords;
    try {
      new Css3Server().toJavaLspDemo(keywords, prefix);
    } catch (Exception err) {
      LOG.error("ErrorOpenXmlFile", err.getLocalizedMessage());
    }

    return keywords;
  }

  public void setTsCardshorts() {
    new TypeScriptCardshorts(it, prf);
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
