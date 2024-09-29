package lsp4custom.com.ninjacoder.customhtmllsp;

import io.github.rosemoe.sora.data.CompletionItem;
import io.github.rosemoe.sora.widget.TextSummry.HTMLConstants;

import java.util.List;

public class Css3Attr {
  public static final String[] cssAttr = {
    "px",
    "em",
    "flex",
    "vim",
    "rem",
    "vh",
    "vw",
    "pt",
    "cm",
    "mm",
    "in",
    "pc",
    "ex",
    "ch",
    "deg",
    "grad",
    "rad",
    "turn",
    "s",
    "ms",
    "%",
    "fr",
    "underline",
    "italic",
    "bold",
    "normal",
    "rgba(R, G, B, A)",
    "hsl(H, S, L)",
    "url(\"path/to/image\")",
    "none",
    "block",
    "inline",
    "inline-block",
    "table",
    "table-cell",
    "table-row",
    "absolute",
    "relative",
    "fixed",
    "center",
    "bottom",
    "top",
    "left",
    "right",
    "none",
    "visible",
    "hidden",
    "collapse",
    "visible",
    "uppercase",
    "lowercase",
    "capitalize",
    "wrap",
    "nowrap",
    "shrink",
    "reverse",
    "nowrap",
    "horizontal",
    "vertical",
    "repeat",
    "no-repeat",
    "repeat-x",
    "repeat-y"
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
  }

  private final CompletionItem cssAttr(String lb, String des) {
    var items = new CompletionItem(lb + " ", des);
    items.cursorOffset(items.commit.length() - 1);
    return items;
  }
}
