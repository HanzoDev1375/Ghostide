package io.github.rosemoe.sora.langs.java;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.blankj.utilcode.util.ThreadUtils;
import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import ir.ninjacoder.ghostide.IdeEditor;
import ir.ninjacoder.ghostide.config.JavaToGsonHelper;
import io.github.rosemoe.sora.data.CompletionItem;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import ir.ninjacoder.ghostide.utils.FileUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import lsp4custom.com.ninjacoder.customhtmllsp.CodeSnippet;
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
  private String name;
  List<CompletionItem> keywords;
  private final WeakReference<IdeEditor> mEditorReference;

  

  public JavaAutoComplete(IdeEditor editor) {
    mEditorReference = new WeakReference<>(editor);
    if (editor == null) {
      return;
    }
  }

  public void setMd(boolean isMd) {
    this.isMd = isMd;
  }

  public void setKeywords(String[] keywords) {
    mKeywords = keywords;
    mKeywordsAreLowCase = false;
  }

  public void setKeywords(String[] keywords, String name) {
    mKeywords = keywords;
    mKeywordsAreLowCase = false;
    this.name = name;
  }

  @Override
  public List<CompletionItem> getAutoCompleteItems(
      String prefix, TextAnalyzeResult analyzeResult, int line, int column) {
    keywords = new ArrayList<>();
    final String[] keywordArray = mKeywords;
    prf = prefix;
    String match = prefix;
    editor = mEditorReference.get();
    // افزودن کلمات کلیدی
    if (keywordArray != null) {
      for (String kw : keywordArray) {
        if (kw.startsWith(match)) {
          keywords.add(new CompletionItem(kw, name != null ? name : "Keyword"));
        }
      }
    }

    Collections.sort(keywords, CompletionItem.COMPARATOR_BY_NAME);

    // افزودن شناسه‌های کاربر
    Object extra = analyzeResult.getExtra();
    if (extra instanceof Identifiers) {
      Identifiers userIdentifiers = (Identifiers) extra;
      List<CompletionItem> words = new ArrayList<>();

      for (String word : userIdentifiers.getIdentifiers()) {
        if (word.toLowerCase().startsWith(match)) {
          words.add(new CompletionItem(word, "Identifier"));
        }
      }

      Collections.sort(words, CompletionItem.COMPARATOR_BY_NAME);
      keywords.addAll(words);
    }

    JavaToGsonHelper.installFormSora(keywords);

    it = new ArrayList<>(keywords); // ایجاد کپی از لیست keywords
    keywords.addAll(CodeSnippet.runasList("java", prefix));
    var its = GhostIdeAppLoader.getShap();
    try {
      Handler j = new Handler(Looper.getMainLooper());
      j.post(
          () -> {
            keywords.addAll(
                CodeSnippet.analyzeCodeCompletion(
                    "/storage/emulated/0/apk/data/", editor.getText().toString()));
            Log.d("FilePathRead", editor.getText().toString());
          });
    } catch (Exception err) {
      Log.e("Errortolsp", err.getLocalizedMessage());
    }

    // keywords.addAll(CodeSnippet.getJar(prefix));
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
