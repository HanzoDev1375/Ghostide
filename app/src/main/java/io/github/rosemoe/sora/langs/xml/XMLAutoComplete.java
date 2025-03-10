package io.github.rosemoe.sora.langs.xml;

import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import ir.ninjacoder.ghostide.utils.DataUtil;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import io.github.rosemoe.sora.data.CompletionItem;
import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import com.google.gson.annotations.SerializedName;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lsp4custom.com.ninjacoder.customhtmllsp.Css3Server;

public class XMLAutoComplete implements AutoCompleteProvider {

  public boolean en = true;
  String docxml = "";
  private List<CompletionItem> items;
  private String prefix;
  private ArrayList<HashMap<String, Object>> xmlHelper = new ArrayList<>();

  @Override
  public List<CompletionItem> getAutoCompleteItems(
      String prefix, TextAnalyzeResult analyzeResult, int line, int column) {
    items = new ArrayList<>();
    prefix = prefix;

    /**
     * for (var tag : HTMLLanguage.TAGS) if (tag.startsWith(prefix)) items.add(tagAsCompletion(tag,
     * "Html Tag"));
     */
    new Css3Server().toAndroidManifestXml(items, prefix);
    //  setString(items);
    try {
      setAttrJson(prefix);
    } catch (Exception err) {
    }
    return items;
  }

  private CompletionItem tagAsCompletion(String tag, String desc) {
    var android = "android.";
    final var open = "<".concat(android).concat(tag).concat(">");
    final var close = "<".concat(android).concat(tag).concat("/>");
    final var item = new CompletionItem(tag, desc);
    docxml = "<!-- this Tag Service  " + tag.substring(0, 13) + " -->";
    item.commit = open.concat("\n").concat(docxml).concat(close);
    item.cursorOffset(item.commit.length() - close.length());
    return item;
  }

  private CompletionItem tagAsCompletion1(String tag, String desc) {
    var android = "android.";
    final var open = "<".concat(android).concat(tag).concat(">");
    final var close = "<".concat(android).concat(tag).concat("/>");
    final var item = new CompletionItem(tag, desc);
    docxml = "<!-- this Tag Service  " + tag.substring(0, 13) + " -->";
    item.commit = open.concat("\n").concat(docxml).concat(close);
    item.cursorOffset(item.commit.length() - close.length());
    return item;
  }

  private CompletionItem tagAsCompletion2(String tag, String desc) {

    var android = "android.";
    final var open = "<".concat(android).concat(tag).concat(">");
    final var close = "<".concat(android).concat(tag).concat("/>");
    final var item = new CompletionItem(tag, desc);
    docxml = "<!-- this Tag Service  " + tag.substring(0, 13) + " -->";
    item.commit = open.concat("\n").concat(docxml).concat(close);
    item.cursorOffset(item.commit.length() - close.length());
    return item;
  }

  private CompletionItem CodeSampel(String em, String desc, String codeS) {
    final var open = codeS;
    final CompletionItem item = new CompletionItem(em, desc);
    item.commit = open;
    item.cursorOffset(item.commit.length() - open.length() + 2);
    return item;
  }

  void setAttrJson(String prefix) throws Exception {
    var input = GhostIdeAppLoader.getContext().getAssets().open("android.R.attrs.json");
    Gson gson = new Gson();
    var type = new TypeToken<List<Attrs>>() {}.getType();
    List<Attrs> listattr = gson.fromJson(new InputStreamReader(input), type);
    for (var it : listattr) {
      if (it.getNames().startsWith(prefix))
        items.add(new CompletionItem(it.getNames(), "Android attr"));
    }
  }

  class Attrs {
    @SerializedName("names")
    String names;

    public String getNames() {
      return names;
    }
  }

  public boolean getEn() {
    return this.en;
  }

  public void setEn(boolean en) {
    this.en = en;
  }
}
