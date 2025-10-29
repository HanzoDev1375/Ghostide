package io.github.rosemoe.sora.langs.internal;

import io.github.rosemoe.sora.data.RainbowBracketHelper;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CodeHighlighter {
  public static void highlightFStringkt(
      String fstringtext, int line, int column, TextAnalyzeResult result, int innerColor) {
    Pattern pattern = Pattern.compile("(\\{[^}]+\\})|(\\$\\w+)");
    Matcher matcher = pattern.matcher(fstringtext);
    var rbcolorHelper = new RainbowBracketHelper(fstringtext);

    int lastIndex = 0;
    int currentLine = line;
    int currentColumn = column;

    while (matcher.find()) {
      int matchStart = matcher.start();

      // بخش عادی (قبل از براکت)
      if (matchStart > lastIndex) {
        String normalText = fstringtext.substring(lastIndex, matchStart);
        addTextWithColor(
            normalText, currentLine, currentColumn, EditorColorScheme.javastring, result);
        currentColumn += normalText.length();
      }

      String matchedText = matcher.group();

      if (matchedText.startsWith("{")) {
        // براکت باز رنگی
        rbcolorHelper.handleOpenBracket(result, currentLine, currentColumn, false);
        currentColumn++;

        // ✅ محتوای داخل {} با رنگ pretoken (innerColor)
        String content = matchedText.substring(1, matchedText.length() - 1);
        if (!content.isEmpty()) {
          addTextWithColor(content, currentLine, currentColumn, innerColor, result);
          currentColumn += content.length();
        }

        // براکت بسته رنگی
        rbcolorHelper.handleCloseBracket(result, currentLine, currentColumn, false);
        currentColumn++;
      } else if (matchedText.startsWith("$")) {
        // متغیرهای مستقیم $var → رنگ خاص خودشون
        addTextWithColor(
            matchedText, currentLine, currentColumn, EditorColorScheme.javanumber, result, true);
        currentColumn += matchedText.length();
      }

      lastIndex = matcher.end();
    }

    // ادامه‌ی رشته بعد از آخرین براکت
    if (lastIndex < fstringtext.length()) {
      String remainingText = fstringtext.substring(lastIndex);
      addTextWithColor(
          remainingText, currentLine, currentColumn, EditorColorScheme.javastring, result);
    }
  }

  public static void highlightFString(
      String fstringText, int startLine, int startColumn, TextAnalyzeResult result) {
    Pattern exprPattern = Pattern.compile("\\{(.*?)\\}");
    Matcher exprMatcher = exprPattern.matcher(fstringText);

    int lastEnd = 0;
    int currentLine = startLine;
    int currentColumn = startColumn;

    while (exprMatcher.find()) {
      int exprStart = exprMatcher.start();
      int exprEnd = exprMatcher.end();
      if (exprStart > lastEnd) {
        String normalText = fstringText.substring(lastEnd, exprStart);
        addTextWithColor(
            normalText, currentLine, currentColumn, EditorColorScheme.pystring, result);
        currentColumn += normalText.length();
      }
      result.addIfNeeded(currentLine, currentColumn, EditorColorScheme.pysymbol);
      currentColumn++;
      String innerContent = exprMatcher.group(1);
      if (!innerContent.isEmpty()) {
        addTextWithColor(
            innerContent, currentLine, currentColumn, EditorColorScheme.pynumber, result);
        currentColumn += innerContent.length();
      }
      result.addIfNeeded(currentLine, currentColumn, EditorColorScheme.pysymbol);
      currentColumn++;

      lastEnd = exprEnd;
    }
    if (lastEnd < fstringText.length()) {
      String remainingText = fstringText.substring(lastEnd);
      addTextWithColor(
          remainingText, currentLine, currentColumn, EditorColorScheme.pystring, result);
    }
  }

  private static void addTextWithColor(
      String text, int line, int startColumn, int color, TextAnalyzeResult result, boolean isbold) {
    for (int i = 0; i < text.length(); i++) {
      result.addIfNeeded(
          line, startColumn + i, TextStyle.makeStyle(color, 0, isbold, false, false));
    }
  }

  private static void addTextWithColor(
      String text, int line, int startColumn, int color, TextAnalyzeResult result) {
    for (int i = 0; i < text.length(); i++) {
      result.addIfNeeded(line, startColumn + i, color);
    }
  }
}
