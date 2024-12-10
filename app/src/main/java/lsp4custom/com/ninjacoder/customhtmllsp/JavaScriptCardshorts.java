package lsp4custom.com.ninjacoder.customhtmllsp;

import Ninja.coder.Ghostemane.code.ApplicationLoader;
import Ninja.coder.Ghostemane.code.utils.DataUtil;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import io.github.rosemoe.sora.data.CompletionItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JavaScriptCardshorts extends Css3Server {

  private List<CompletionItem> item;
  private String prf;

  public JavaScriptCardshorts(List<CompletionItem> item, String prf) {
    this.item = item;
    this.prf = prf;
    try {
    	asChild();
    } catch(Exception err) {
    	
    }
  }

  void asChild() throws IOException {
    boolean isLen = prf.length() > 0;
    List<Map<String, String>> listScript = new ArrayList<>();
    var inputstream = ApplicationLoader.getContext().getAssets().open("javascriptsnippet.json");
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
