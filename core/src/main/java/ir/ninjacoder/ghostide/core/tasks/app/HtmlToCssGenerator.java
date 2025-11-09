package ir.ninjacoder.ghostide.core.tasks.app;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

import io.github.rosemoe.sora.widget.CodeEditor;

public class HtmlToCssGenerator {

  public static void run(String code, String output, CodeEditor et) {
    try {
      Document doc = Jsoup.parse(code, "UTF-8", Parser.htmlParser());

      // 2. چک کن ببین <link rel="stylesheet" href="main.css"> هست یا نه
      boolean hasCssLink = false;
      Elements links = doc.select("link[rel=stylesheet][href]");
      for (Element link : links) {
        if (link.attr("href").equals("style.css")) {
          hasCssLink = true;
          break;
        }
      }

      // 3. اگر نبود، اضافه کن به <head>
      if (!hasCssLink) {
        Element head = doc.head();
        head.appendElement("link").attr("rel", "stylesheet").attr("href", "style.css");
        System.out.println("main.css link added to HTML.");
      } else {
        System.out.println("main.css link already exists.");
      }

      // 4. استخراج تمام کلاس‌ها و آیدی‌ها
      Elements allElements = doc.getAllElements();
      HashSet<String> classNames = new HashSet<>();
      HashSet<String> ids = new HashSet<>();

      for (Element element : allElements) {
        String classAttr = element.className();
        if (!classAttr.isEmpty()) {
          for (String className : classAttr.split("\\s+")) {
            classNames.add(className.trim());
          }
        }

        String idAttr = element.id();
        if (!idAttr.isEmpty()) {
          ids.add(idAttr.trim());
        }
      }

      // 5. تولید CSS
      StringBuilder cssBuilder = new StringBuilder();
      for (String className : classNames) {
        cssBuilder
            .append(".")
            .append(className)
            .append(" {\n")
            .append("    /* style here */\n")
            .append("}\n\n");
      }
      for (String id : ids) {
        cssBuilder
            .append("#")
            .append(id)
            .append(" {\n")
            .append("    /* style here */\n")
            .append("}\n\n");
      }

      // 6. ذخیره فایل CSS
      FileWriter cssWriter = new FileWriter(output + "/style.css");
      cssWriter.write(cssBuilder.toString());
      cssWriter.close();
      System.out.println("CSS file generated: output.css");
      et.setText(doc.outerHtml());
      // 7. ذخیره فایل HTML به‌روزرسانی‌شده
      //      FileWriter htmlWriter = new FileWriter("output.html");
      //      htmlWriter.write(doc.outerHtml());
      //      htmlWriter.close();
      System.out.println("Updated HTML saved as: output.html");

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
