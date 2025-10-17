package io.github.rosemoe.sora.langs.internal;

import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CodeHighlighter {

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
        addTextWithColor(normalText, currentLine, currentColumn,EditorColorScheme.pystring, result);
        currentColumn += normalText.length();
      }
      result.addIfNeeded(currentLine, currentColumn,EditorColorScheme.pysymbol);
      currentColumn++;
      String innerContent = exprMatcher.group(1);
      if (!innerContent.isEmpty()) {
        addTextWithColor(
            innerContent, currentLine, currentColumn,EditorColorScheme.pynumber, result);
        currentColumn += innerContent.length();
      }
      result.addIfNeeded(currentLine, currentColumn, EditorColorScheme.pysymbol);
      currentColumn++;

      lastEnd = exprEnd;
    }
    if (lastEnd < fstringText.length()) {
      String remainingText = fstringText.substring(lastEnd);
      addTextWithColor(remainingText, currentLine, currentColumn, EditorColorScheme.pystring, result);
    }
  }

  private static void addTextWithColor(
      String text, int line, int startColumn, int color, TextAnalyzeResult result) {
    for (int i = 0; i < text.length(); i++) {
      result.addIfNeeded(line, startColumn + i, color);
    }
  }
}
