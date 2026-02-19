package io.github.rosemoe.sora.langs.internal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.github.rosemoe.sora.data.RainbowBracketHelper;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.EditorColorScheme;

public class CodeHighlighter {
  
  public static void highlightFStringkt(
      String fstringtext, int line, int column, TextAnalyzeResult result, int innerColor) {
    if (fstringtext == null || fstringtext.isEmpty()) return;
    
    try {
      Pattern pattern = Pattern.compile("(\\{[^}]+\\})|(\\$\\w+)");
      Matcher matcher = pattern.matcher(fstringtext);
      var rbcolorHelper = new RainbowBracketHelper(fstringtext);

      int lastIndex = 0;
      int currentLine = Math.max(0, line);
      int currentColumn = Math.max(0, column);

      while (matcher.find()) {
        int matchStart = matcher.start();
        int matchEnd = matcher.end();

        if (matchStart < 0 || matchEnd > fstringtext.length() || matchStart > matchEnd) {
          continue;
        }

        // بخش عادی (قبل از براکت)
        if (matchStart > lastIndex && lastIndex >= 0 && matchStart <= fstringtext.length()) {
          String normalText = fstringtext.substring(lastIndex, matchStart);
          addTextWithColor(
              normalText, currentLine, currentColumn, EditorColorScheme.javastring, result);
          currentColumn += normalText.length();
        }

        String matchedText = matcher.group();
        if (matchedText == null || matchedText.isEmpty()) continue;

        if (matchedText.startsWith("{")) {
          if (matchedText.length() >= 2) { // حداقل { و }
            // براکت باز رنگی
            rbcolorHelper.handleOpenBracket(result, currentLine, currentColumn, false);
            currentColumn++;

            // محتوای داخل {} با رنگ pretoken (innerColor)
            String content = matchedText.substring(1, matchedText.length() - 1);
            if (!content.isEmpty()) {
              addTextWithColor(content, currentLine, currentColumn, innerColor, result);
              currentColumn += content.length();
            }

            // براکت بسته رنگی
            rbcolorHelper.handleCloseBracket(result, currentLine, currentColumn, false);
            currentColumn++;
          }
        } else if (matchedText.startsWith("$")) {
          // متغیرهای مستقیم $var → رنگ خاص خودشون
          addTextWithColor(
              matchedText, currentLine, currentColumn, EditorColorScheme.javanumber, result, true);
          currentColumn += matchedText.length();
        }

        lastIndex = matchEnd;
      }

      // ادامه‌ی رشته بعد از آخرین براکت
      if (lastIndex >= 0 && lastIndex < fstringtext.length()) {
        String remainingText = fstringtext.substring(lastIndex);
        addTextWithColor(
            remainingText, currentLine, currentColumn, EditorColorScheme.javastring, result);
      }
    } catch (Exception e) {
      // در صورت خطا، کل متن رو با رنگ پیش‌فرض نشون بده
      addTextWithColor(fstringtext, line, column, EditorColorScheme.javastring, result);
    }
  }

  public static void highlightFString(
      String fstringText, int startLine, int startColumn, TextAnalyzeResult result) {
    if (fstringText == null || fstringText.isEmpty()) return;
    
    try {
      Pattern exprPattern = Pattern.compile("\\{(.*?)\\}");
      Matcher exprMatcher = exprPattern.matcher(fstringText);

      int lastEnd = 0;
      int currentLine = Math.max(0, startLine);
      int currentColumn = Math.max(0, startColumn);

      while (exprMatcher.find()) {
        int exprStart = exprMatcher.start();
        int exprEnd = exprMatcher.end();

        if (exprStart < 0 || exprEnd > fstringText.length() || exprStart > exprEnd) {
          continue;
        }

        if (exprStart > lastEnd && lastEnd >= 0 && exprStart <= fstringText.length()) {
          String normalText = fstringText.substring(lastEnd, exprStart);
          addTextWithColor(
              normalText, currentLine, currentColumn, EditorColorScheme.pystring, result);
          currentColumn += normalText.length();
        }

        if (exprEnd > exprStart) { // حداقل {}
          result.addIfNeeded(currentLine, currentColumn, EditorColorScheme.pysymbol);
          currentColumn++;

          String innerContent = exprMatcher.group(1);
          if (innerContent != null && !innerContent.isEmpty()) {
            addTextWithColor(
                innerContent, currentLine, currentColumn, EditorColorScheme.pynumber, result);
            currentColumn += innerContent.length();
          }

          result.addIfNeeded(currentLine, currentColumn, EditorColorScheme.pysymbol);
          currentColumn++;
        }

        lastEnd = exprEnd;
      }

      if (lastEnd >= 0 && lastEnd < fstringText.length()) {
        String remainingText = fstringText.substring(lastEnd);
        addTextWithColor(
            remainingText, currentLine, currentColumn, EditorColorScheme.pystring, result);
      }
    } catch (Exception e) {
      addTextWithColor(fstringText, startLine, startColumn, EditorColorScheme.pystring, result);
    }
  }

  public static void highlightFilePath(
      String text, int line, int column, TextAnalyzeResult result) {
    if (text == null || text.isEmpty() || line < 0 || column < 0) return;

    try {
      Pattern pathPattern =
          Pattern.compile(
              "(?:[\\w]:)?[\\\\/]?(?:\\.\\.?[\\\\/])?[\\w\\-. ]+[\\\\/][\\w\\-. ]+(?:\\.[a-zA-Z0-9]+)?|"
                  + "[\\.~][\\\\/][\\w\\-. ]+(?:\\.[a-zA-Z0-9]+)?|"
                  + "[\\\\/][\\w\\-. ]+[\\\\/][\\w\\-. ]+(?:\\.[a-zA-Z0-9]+)?");

      Matcher matcher = pathPattern.matcher(text);

      int lastIndex = 0;
      int currentLine = line;
      int currentColumn = column;

      while (matcher.find()) {
        int matchStart = matcher.start();
        int matchEnd = matcher.end();

        if (matchStart < 0 || matchEnd > text.length() || matchStart > matchEnd) {
          continue;
        }

        // متن عادی قبل از مسیر
        if (matchStart > lastIndex && lastIndex >= 0 && matchStart <= text.length()) {
          String normalText = text.substring(lastIndex, matchStart);
          addTextWithColor(
              normalText, currentLine, currentColumn, EditorColorScheme.javastring, result);
          currentColumn += normalText.length();
        }

        // مسیر پیدا شده
        String pathText = matcher.group();
        if (pathText != null && !pathText.isEmpty()) {
          addTextWithColor(
              pathText, currentLine, currentColumn, EditorColorScheme.javaoprator, result, true);
          currentColumn += pathText.length();
        }

        lastIndex = matchEnd;
      }

      // متن باقی‌مانده بعد از آخرین مسیر
      if (lastIndex >= 0 && lastIndex < text.length()) {
        String remainingText = text.substring(lastIndex);
        addTextWithColor(
            remainingText, currentLine, currentColumn, EditorColorScheme.javastring, result);
      }
    } catch (Exception e) {
      // در صورت خطا، کل متن را با رنگ پیش‌فرض نمایش بده
      addTextWithColor(text, line, column, EditorColorScheme.javastring, result);
    }
  }

  private static void addTextWithColor(
      String text, int line, int startColumn, int color, TextAnalyzeResult result, boolean isbold) {
    if (text == null || text.isEmpty() || line < 0 || startColumn < 0 || result == null) return;

    try {
      for (int i = 0; i < text.length(); i++) {
        result.addIfNeeded(
            line, startColumn + i, TextStyle.makeStyle(color, 0, isbold, false, false));
      }
    } catch (Exception e) {
      // ignore
    }
  }

  private static void addTextWithColor(
      String text, int line, int startColumn, int color, TextAnalyzeResult result) {
    if (text == null || text.isEmpty() || line < 0 || startColumn < 0 || result == null) return;

    try {
      for (int i = 0; i < text.length(); i++) {
        result.addIfNeeded(line, startColumn + i, color);
      }
    } catch (Exception e) {
      // ignore
    }
  }
}