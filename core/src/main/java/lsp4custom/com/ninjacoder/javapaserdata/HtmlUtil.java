package lsp4custom.com.ninjacoder.javapaserdata;

import org.jsoup.Jsoup;

public class HtmlUtil {

  public static boolean hasStyleTag(String html) {
    var doc = Jsoup.parse(html);
    var styleTags = doc.select("style");
    return !styleTags.isEmpty();
  }

  public static boolean hasScriptTag(String code) {
    var doc = Jsoup.parse(code);
    var scriptTag = doc.select("script");
    return !scriptTag.isEmpty();
  }
}
