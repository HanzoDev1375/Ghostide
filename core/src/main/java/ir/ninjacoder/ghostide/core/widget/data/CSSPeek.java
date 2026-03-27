package ir.ninjacoder.ghostide.core.widget.data;

import android.content.Context;
import android.widget.Toast;

import com.helger.css.ECSSVersion;
import com.helger.css.decl.CSSSelector;
import com.helger.css.decl.CascadingStyleSheet;
import com.helger.css.reader.CSSReader;
import com.helger.css.writer.CSSWriter;
import com.helger.css.writer.CSSWriterSettings;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * این کلاس مشکل دارد بزودی حلش میکنم الان وقت ندارم
 * نویسنده : گوست
 */
public class CSSPeek {

  public static void peekFromHtmlString(
      String htmlContent, String cssPath, String elementSelector, Context context) {
    try {
      Document doc = Jsoup.parse(htmlContent);
      List<File> cssFiles = resolveCssPaths(cssPath, null);
      processSourceType(doc, cssFiles, elementSelector, context);
    } catch (Exception e) {
      showToast(context, "خطا در پردازش HTML: " + e.getMessage());
    }
  }

  private static List<File> resolveCssPaths(String cssPath, String baseDir) {
    List<File> cssFiles = new ArrayList<>();
    File target = new File(cssPath);

    if (target.exists()) {
      if (target.isDirectory()) {
        File[] files = target.listFiles((dir, name) -> name.toLowerCase().endsWith(".css"));
        if (files != null) {
          Collections.addAll(cssFiles, files);
        }
      } else if (target.getName().toLowerCase().endsWith(".css")) {
        cssFiles.add(target);
      }
    }

    if (baseDir != null && cssFiles.isEmpty()) {
      File relativeFile = new File(baseDir, cssPath);
      if (relativeFile.exists()) {
        if (relativeFile.isDirectory()) {
          File[] files = relativeFile.listFiles((dir, name) -> name.toLowerCase().endsWith(".css"));
          if (files != null) {
            Collections.addAll(cssFiles, files);
          }
        } else if (relativeFile.getName().toLowerCase().endsWith(".css")) {
          cssFiles.add(relativeFile);
        }
      }
    }

    return cssFiles;
  }

  private static void processSourceType(
      Document doc, List<File> cssFiles, String elementSelector, Context context) {

    Elements elements = doc.select(elementSelector);
    if (elements.isEmpty()) {
      showToast(context, "❗ المنت '" + elementSelector + "' یافت نشد");
      return;
    }

    Element targetElement = elements.first();
    for (File cssFile : cssFiles) {
      try {
        CascadingStyleSheet externalCss =
            CSSReader.readFromFile(cssFile, StandardCharsets.UTF_8, ECSSVersion.LATEST);
        List<String> rules = findRulesForElement(targetElement, externalCss);

        if (!rules.isEmpty()) {
          showToast(context, " استایل از نوع فایل است برای '" + elementSelector + "'");
          return;
        }
      } catch (Exception e) {
        showToast(context, " خطا در پردازش فایل CSS: " + e.getMessage());
        return;
      }
    }
    Elements styleTags = doc.select("style");
    for (int i = 0; i < styleTags.size(); i++) {
      try {
        CascadingStyleSheet inlineCss =
            CSSReader.readFromString(styleTags.get(i).html(), ECSSVersion.LATEST);
        List<String> rules = findRulesForElement(targetElement, inlineCss);

        if (!rules.isEmpty()) {
          StringBuilder sb = new StringBuilder();
          sb.append("🖋️ استایل از نوع درون‌خطی است برای '")
              .append(elementSelector.substring(0))
              .append("':\n\n");
          for (String rule : rules) {
            sb.append(rule).append("\n");
          }
          showToast(context, sb.toString().trim());
          return;
        }
      } catch (Exception e) {
        showToast(context, "❌ خطا در پردازش CSS درون‌خطی: " + e.getMessage());
        return;
      }
    }

    showToast(context, "❗ هیچ استایلی برای المنت '" + elementSelector + "' یافت نشد");
  }

  private static List<String> findRulesForElement(Element element, CascadingStyleSheet css) {
    List<String> matchedRules = new ArrayList<>();

    css.getAllStyleRules()
        .forEach(
            rule -> {
              for (CSSSelector selector : rule.getAllSelectors()) {
                if (elementMatches(element, selector.getAsCSSString())) {
                  String ruleText =
                      new CSSWriter(new CSSWriterSettings(ECSSVersion.LATEST, false))
                          .getCSSAsString(rule);
                  matchedRules.add("▪️ " + ruleText.replace("\n", " "));
                  break;
                }
              }
            });

    return matchedRules;
  }

  private static boolean elementMatches(Element element, String selector) {
    try {
      return !element.select(selector).isEmpty();
    } catch (Exception e) {
      if (selector.startsWith(".")) {
        return element.hasClass(selector.substring(1));
      } else if (selector.startsWith("#")) {
        return element.id().equals(selector.substring(1));
      } else {
        return element.tagName().equalsIgnoreCase(selector);
      }
    }
  }

  private static void showToast(Context context, String message) {
    if (context != null) {
      Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    } else {
      System.out.println("نتیجه:\n" + message);
    }
  }
}
