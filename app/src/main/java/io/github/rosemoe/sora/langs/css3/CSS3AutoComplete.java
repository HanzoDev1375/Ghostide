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

public class CSS3AutoComplete implements AutoCompleteProvider {

  private static final String FILE_PATH = "sdcard/Download/";
  private IdentifierAutoComplete.Identifiers is = new IdentifierAutoComplete.Identifiers();

  @Override
  public List<CompletionItem> getAutoCompleteItems(
      String prefix, TextAnalyzeResult analyzeResult, int line, int column) {
    List<CompletionItem> items = new ArrayList<>();

    for (String tag : CSS3Language.MCSS)
      if (tag.startsWith(prefix)) items.add(ColorcssAttrAsCompletion(tag, "css KeyWord"));

    for (String attr : CSS3Language.colorsCss)
      if (attr.startsWith(prefix)) items.add(ColorcssAttrAsCompletion(attr, "css Property"));

    for (String attr : CSS3Language.cssAttr)
      if (attr.startsWith(prefix)) items.add(ColorcssAttrAsCompletion(attr, "css Attr"));

    for (var getSpinded : CSS3Language.pishfarz)
      if (getSpinded.startsWith(prefix)) items.add(getcss3(getSpinded, "css Spined"));

    for (var itemslist : CSS3Language.list)
      if (itemslist.startsWith(prefix)) items.add(asImport(itemslist, "css Import"));
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

  private CompletionItem getcss3(String dest, String post) {
    var open =
        "html{\n color : blue;\n background-color : #ff000000;\n position : relative;\n padding : 0px;\n top :0px;\n bottom :0px;\n left : 0px;\n text-align : left;\n}\n";
    var item = new CompletionItem(dest + " ", post);
    item.commit = open;
    item.cursorOffset(item.commit.length() - open.length());
    return item;
  }

  private CompletionItem asImport(String attr, String desc) {
    final var item = new CompletionItem(attr, attr.concat("' '"), desc);
    item.cursorOffset(item.commit.length() - 1);
    return item;
  }
}
