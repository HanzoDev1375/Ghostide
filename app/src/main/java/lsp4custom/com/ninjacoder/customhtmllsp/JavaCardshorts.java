package lsp4custom.com.ninjacoder.customhtmllsp;

import ir.ninjacoder.ghostide.ApplicationLoader;
import ir.ninjacoder.ghostide.IdeEditor;
import ir.ninjacoder.ghostide.utils.DataUtil;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import io.github.rosemoe.sora.data.CompletionItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JavaCardshorts extends Css3Server {

  private List<CompletionItem> item;
  private IdeEditor editor;

  private String prf;

  public JavaCardshorts(List<CompletionItem> item, String prf, IdeEditor editor) {
    this.item = item;
    this.prf = prf;
    this.editor = editor;
    try {
      asChild();
    } catch (Exception e) {
    }
  }

  void asChild() throws IOException {
    boolean isLen = prf.length() > 0;
    List<Map<String, String>> listItem = new ArrayList<>();
    var inputStream = ApplicationLoader.getContext().getAssets().open("javasnippet.json");
    listItem =
        new Gson()
            .fromJson(
                DataUtil.copyFromInputStream(inputStream),
                new TypeToken<List<Map<String, String>>>() {}.getType());
    listItem.forEach(
        it -> {
          if (it.get("name").startsWith(prf) && isLen) {
            item.add(css(it.get("name"), "Snippet", it.get("snippet")));
          }
        });
    
  }
}
