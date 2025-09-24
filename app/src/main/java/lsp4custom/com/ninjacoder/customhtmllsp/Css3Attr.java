package lsp4custom.com.ninjacoder.customhtmllsp;

import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.github.rosemoe.sora.data.CompletionItem;
import io.github.rosemoe.sora.widget.TextSummry.HTMLConstants;

import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

public class Css3Attr {
  public static final String[] cssAttr = {
    "px", "em", "flex", "vim", "rem", "vh", "vw", "pt", "cm", "mm", "in", "pc", "ex", "ch", "deg",
    "grad", "rad", "turn", "s", "ms",
  };
  protected HTMLConstants htmlConfig;

  public Css3Attr() {
    htmlConfig = new HTMLConstants();
  }

  public void install(List<CompletionItem> list, String prfex) {
    for (var last : cssAttr) {
      if (last.startsWith(prfex)) {
        list.add(cssAttr(last, htmlConfig.CssAttractions));
      }
    }
    scopePath("css/cssproperty.kj", list, prfex);
    scopePath("css/pseudo_classes.kj", list, prfex);
  }

  private void getCssColor(List<CompletionItem> item, String prefix) {
     ///bad work
  }

  private void scopePath(String assterName, List<CompletionItem> mmber, String prfex) {
    try {
      var open = GhostIdeAppLoader.getContext().getAssets().open(assterName);
      List<DataScope> data =
          new Gson()
              .fromJson(new InputStreamReader(open), new TypeToken<List<DataScope>>() {}.getType());
      data.forEach(
          it -> {
            if (it.getName().startsWith(prfex)) {
              mmber.add(new CompletionItem(it.getName(), it.getName() + ":", it.getDesc()));
            }
          });
    } catch (Exception err) {
      Log.e("KJsonError", err.getMessage());
    }
  }

  private final CompletionItem cssAttr(String lb, String des) {
    var items = new CompletionItem(lb + " ", des);
    items.cursorOffset(items.commit.length() - 1);
    return items;
  }

  class DataScope {
    String name;
    String desc;

    public String getName() {
      return this.name;
    }

    public String getDesc() {
      return this.desc;
    }
  }
}
