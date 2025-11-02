package io.github.rosemoe.sora.langs.java;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.gson.Gson;
import com.tyron.javacompletion.JavaCompletions;
import com.tyron.javacompletion.completion.CompletionResult;
import com.tyron.javacompletion.options.JavaCompletionOptionsImpl;
import com.tyron.javacompletion.project.Project;
import io.github.rosemoe.sora.langs.internal.Identifiers;
import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import ir.ninjacoder.ghostide.IdeEditor;
import ir.ninjacoder.ghostide.config.JavaPaserUtils;
import ir.ninjacoder.ghostide.config.JavaToGsonHelper;
import io.github.rosemoe.sora.data.CompletionItem;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import java.util.stream.Collectors;
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
  private SharedPreferences shp;
  private final WeakReference<IdeEditor> mEditorReference;

  public JavaAutoComplete(IdeEditor editor) {
    mEditorReference = new WeakReference<>(editor);
    if (editor == null) {
      return;
    }
    shp = GhostIdeAppLoader.getContext().getSharedPreferences("shp", Context.MODE_PRIVATE);
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

    List<CompletionItem> allItems = new ArrayList<>();
    editor = mEditorReference.get();
    prf = prefix;

    if (mKeywords != null) {
      for (String kw : mKeywords) {
        if (kw.contains(prefix)) {
          allItems.add(new CompletionItem(kw, name != null ? name : "Keyword"));
        }
      }
    }

    Object extra = analyzeResult.getExtra();
    if (extra instanceof Identifiers) {
      Identifiers userIdentifiers = (Identifiers) extra;
      for (String word : userIdentifiers.getIdentifiers()) {
        if (word.contains(prefix)) {
          allItems.add(new CompletionItem(word, "ABC"));
        }
      }
    }

    if (editor != null) {
      JavaCompletions completions = new JavaCompletions();
      File mfile = new File(shp.getString("pos_path", ""));
      if (mfile.getParentFile() != null) {
        completions.initialize(
            URI.create("file:///" + mfile.getParentFile().getAbsolutePath()),
            new JavaCompletionOptionsImpl());
        Project project = completions.getProject();
        project.loadTypeIndexFile("/sdcard/apk/index.json");

        completions.openFile(mfile.getParentFile().toPath(), editor.getTextAsString());
        CompletionResult result =
            completions.getCompletions(mfile.getParentFile().toPath(), line, column);

        String filterPrefix = prefix;
        String userFilter =
            (prefix.lastIndexOf('.') >= 0) ? prefix.substring(prefix.lastIndexOf('.') + 1) : prefix;

        for (var candidate : result.getCompletionCandidates()) {
          if (candidate != null) {
            CompletionItem item = new CompletionItem();
            item.label = candidate.getName();
            item.desc = candidate.getDetail().orElse(candidate.getKind().name());
            item.commit = candidate.getName();
            item.cursorOffset(item.commit.length());

            if (userFilter.isEmpty() || item.label.contains(userFilter)) {
              allItems.add(item);
            }
          }
        }
      }
    }
    allItems.addAll(CodeSnippet.runasList("java", prefix));
    allItems.sort(CompletionItem.COMPARATOR_BY_NAME);
    it = new ArrayList<>(allItems);

    return allItems;
  }

  public void setTsCardshorts() {
    new TypeScriptCardshorts(it, prf);
  }

  
}
