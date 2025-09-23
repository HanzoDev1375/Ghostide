package io.github.rosemoe.sora.langs.css3;

import android.app.Activity;
import android.content.SharedPreferences;
import io.github.rosemoe.sora.data.CompletionItem;
import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.langs.IdentifierAutoComplete;
import io.github.rosemoe.sora.text.TextAnalyzeResult;

import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import java.util.ArrayList;
import java.util.List;
import lsp4custom.com.ninjacoder.customhtmllsp.CodeSnippet;
import lsp4custom.com.ninjacoder.customhtmllsp.Css3Server;

public class CSS3AutoComplete implements AutoCompleteProvider {

  private static final String FILE_PATH = "sdcard/Download/";
  private IdentifierAutoComplete.Identifiers is = new IdentifierAutoComplete.Identifiers();

  @Override
  public List<CompletionItem> getAutoCompleteItems(
      String prefix, TextAnalyzeResult analyzeResult, int line, int column) {
    List<CompletionItem> items = new ArrayList<>();

    Css3Server server = new Css3Server();
    server.installCssColor(items,prefix);
    server.hot(item,prefix);
    SharedPreferences save_path = GhostIdeAppLoader.getContext().getSharedPreferences("save_path", Activity.MODE_PRIVATE);
    // Add file path completion item
    items.addAll(CodeSnippet.getListFile(save_path.getString("path",""),prefix));
    items.addAll(CodeSnippet.runasList("css3", prefix));
    return items;
  }

  private CompletionItem ColorcssAttrAsCompletion(String mcss, String desc) {
    final CompletionItem item = new CompletionItem(mcss + "  ", desc);
    item.cursorOffset(item.commit.length() - 1);
    return item;
  }

  private CompletionItem asImport(String attr, String desc) {
    final var item = new CompletionItem(attr, attr.concat("' '"), desc);
    item.cursorOffset(item.commit.length() - 1);
    return item;
  }
}
