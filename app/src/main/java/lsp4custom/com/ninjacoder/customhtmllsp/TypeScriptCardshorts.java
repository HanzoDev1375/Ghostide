package lsp4custom.com.ninjacoder.customhtmllsp;

import java.util.List;
import io.github.rosemoe.sora.data.CompletionItem;
import java.io.IOException;
import java.util.Map;
import java.util.ArrayList;
import Ninja.coder.Ghostemane.code.ApplicationLoader;
import com.google.gson.Gson;
import Ninja.coder.Ghostemane.code.utils.DataUtil;
import com.google.common.reflect.TypeToken;

public class TypeScriptCardshorts extends Css3Server{

  private List<CompletionItem> item;
  private String prf;

  public TypeScriptCardshorts(List<CompletionItem> item, String prf) {
    this.item = item;
    this.prf = prf;
    try {
      asChild(); 
    } catch (Exception err) {

    }
  }

  void asChild() throws IOException {
    boolean isLen = prf.length() > 0;
    List<Map<String, String>> listScript = new ArrayList<>();
    var inputstream = ApplicationLoader.getContext().getAssets().open("typescriptsnippet.java");
    listScript =
        new Gson()
            .fromJson(
                DataUtil.copyFromInputStream(inputstream),
                new TypeToken<List<Map<String, String>>>() {}.getType());
    listScript.forEach(
        it -> {
          if (isLen && prf.startsWith(it.get("name"))) {
            item.add(css(it.get("name"), "Snippet", it.get("snippet")));
          }
        });
  }
}
