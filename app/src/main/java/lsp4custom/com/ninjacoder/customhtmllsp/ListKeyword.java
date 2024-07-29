package lsp4custom.com.ninjacoder.customhtmllsp;

import io.github.rosemoe.sora.data.CompletionItem;
import io.github.rosemoe.sora.widget.TextSummry.HTMLConstants;

import java.util.ArrayList;
import java.util.List;

public class ListKeyword {

  public String[] TAGS = {
    "a",
    "abbr",
    "acronym",
    "address",
    "applet",
    "article",
    "aside",
    "audio",
    "b",
    "basefont",
    "bdi",
    "bdo",
    "bgsound",
    "big",
    "blink",
    "blockquote",
    "body",
    "button",
    "canvas",
    "caption",
    "center",
    "circle",
    "cite",
    "clipPath",
    "code",
    "colgroup",
    "command",
    "content",
    "data",
    "datalist",
    "dd",
    "defs",
    "del",
    "details",
    "dfn",
    "dialog",
    "dir",
    "div",
    "dl",
    "dt",
    "element",
    "ellipse",
    "em",
    "fieldset",
    "figcaption",
    "figure",
    "font",
    "footer",
    "foreignObject",
    "form",
    "frame",
    "frameset",
    "g",
    "h1",
    "h2",
    "h3",
    "h4",
    "h5",
    "h6",
    "head",
    "header",
    "hgroup",
    "html",
    "i",
    "iframe",
    "image",
    "ins",
    "isindex",
    "kbd",
    "label",
    "legend",
    "li",
    "line",
    "linearGradient",
    "listing",
    "main",
    "map",
    "mark",
    "marquee",
    "mask",
    "math",
    "menu",
    "menuitem",
    "meter",
    "multicol",
    "nav",
    "nextid",
    "nobr",
    "noembed",
    "noframes",
    "noscript",
    "object",
    "ol",
    "optgroup",
    "option",
    "output",
    "p",
    "path",
    "pattern",
    "picture",
    "plaintext",
    "polygon",
    "polyline",
    "pre",
    "progress",
    "q",
    "radialGradient",
    "rb",
    "rbc",
    "rect",
    "rp",
    "rt",
    "rtc",
    "ruby",
    "s",
    "samp",
    "script",
    "section",
    "select",
    "shadow",
    "slot",
    "small",
    "spacer",
    "span",
    "stop",
    "strike",
    "strong",
    "style",
    "nostyle",
    "sub",
    "summary",
    "sup",
    "svg",
    "table",
    "tbody",
    "td",
    "template",
    "text",
    "textarea",
    "tfoot",
    "th",
    "thead",
    "time",
    "title",
    "tr",
    "tspan",
    "tt",
    "u",
    "ul",
    "var",
    "video",
    "xmp"
  };
  protected HTMLConstants htmlconfig;
  public ListKeyword() {
    htmlconfig = new HTMLConstants();
  }

  public void installHtmlAttr(List<CompletionItem> items, String prfex) {
    var attr = new HtmlAttr();
    attr.install(items, prfex);
  }

  public void intallCss3KeyWord(List<CompletionItem> item, String prfex) {
    var css = new Css3Server();
    css.install(item, prfex);
  }

  public void installCssAttr(List<CompletionItem> item, String prfex) {
    var cssattr = new Css3Attr();
    cssattr.install(item, prfex);
  }

  public void installFromSora(List<CompletionItem> items, String prfex) {
    for (var keylist : TAGS) {
      if (keylist.startsWith(prfex)) {
        items.add(getCustomTag(keylist, htmlconfig.HTMLTAG));
      }
    }
  }

  private CompletionItem getCustomTag(String tag, String desc) {
    final String open = "<".concat(tag).concat(">");
    final String close = "</".concat(tag).concat(">");
    final var item = new CompletionItem(tag, desc);
    item.commit = open.concat(close);
    item.cursorOffset(item.commit.length() - close.length());
    return item;
  }
}
