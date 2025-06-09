package io.github.rosemoe.sora.data;

import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import java.util.Stack;

public class RainbowBracketHelper {
  private static final int[] RAINBOW_COLORS = {
    EditorColorScheme.breaklevel1,
    EditorColorScheme.breaklevel2,
    EditorColorScheme.breaklevel3,
    EditorColorScheme.breaklevel4,
    EditorColorScheme.breaklevel5,
    EditorColorScheme.breaklevel6,
    EditorColorScheme.breaklevel7,
    EditorColorScheme.breaklevel8,
    EditorColorScheme.tscolormatch1,
    EditorColorScheme.tscolormatch2,
    EditorColorScheme.tscolormatch3,
    EditorColorScheme.tscolormatch4,
    EditorColorScheme.tscolormatch5,
    EditorColorScheme.tscolormatch6
  };

  private final Stack<Integer> bracketStack = new Stack<>();
  private final Stack<Integer> colonStack = new Stack<>();
  private int colorIndex = 0;
  private int colonColorIndex = 0;

  public void handleOpenBracket(TextAnalyzeResult result, int line, int column, int mcolor) {
    if (isRgbEn()) {
      int color = RAINBOW_COLORS[colorIndex % RAINBOW_COLORS.length];
      result.addIfNeeded(line, column, TextStyle.makeStyle(color, 0, true, false, false));
      bracketStack.push(color);
      colorIndex++;

    } else result.addIfNeeded(line, column, mcolor);
  }


  public void handleCustom(TextAnalyzeResult result, int line, int column, int mcolor) {
    if (isRgbEn()) {
      int color = RAINBOW_COLORS[colonColorIndex % RAINBOW_COLORS.length];
      result.addIfNeeded(line, column, TextStyle.makeStyle(color, 0, true, false, false));
      colonColorIndex = (colonColorIndex + 1) % RAINBOW_COLORS.length;
    } else result.addIfNeeded(line, column, mcolor);
  }

  public void handleSpanColor(
      TextAnalyzeResult result,
      int line,
      int column,
      int mcolor,
      boolean isBold,
      boolean isItalic) {
    if (isRgbEn()) {
      int color = RAINBOW_COLORS[colonColorIndex % RAINBOW_COLORS.length];
      Utils.setSpanEFO(result, line, column, color, isBold, isItalic);
      colonColorIndex = (colorIndex + 1) % RAINBOW_COLORS.length;
    } else Utils.setSpanEFO(result, line, column, mcolor, isBold, isItalic);
  }

  public void handleCloseBracket(TextAnalyzeResult result, int line, int column, int mcolor) {
    if (isRgbEn())
      if (!bracketStack.isEmpty()) {
        int color = bracketStack.pop();
        result.addIfNeeded(line, column, TextStyle.makeStyle(color, 0, true, false, false));
        colorIndex--;
      } else {
        result.addIfNeeded(line, column, EditorColorScheme.OPERATOR);
      }
    else result.addIfNeeded(line, column, mcolor);
  }

  private boolean isRgbEn() {
    if (GhostIdeAppLoader.getAnalyzercod().getBoolean("Analyzercod", false) == false) {
      return false;
    } else return true;
  }
}
