package io.github.rosemoe.sora.widget.map;

import io.github.rosemoe.sora.data.Span;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import io.github.rosemoe.sora.text.TextStyle;
import android.graphics.Color;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import org.antlr.v4.runtime.Token;

public class SpanModel {
  public static void get(TextAnalyzeResult result, int line, int column, int color,Token token) {
    Span span =
        Span.obtain(column, TextStyle.makeStyle(EditorColorScheme.tsattr, 0, true, true, false));
    span.setBackgroundColorMy(color);
    Span middle = Span.obtain(column + token.getText().length(), EditorColorScheme.Ninja);
    middle.setBackgroundColorMy(Color.TRANSPARENT);
    result.add(line, middle);

    Span end =
        Span.obtain(
            column + token.getText().length(), TextStyle.makeStyle(EditorColorScheme.Ninja));
    end.setBackgroundColorMy(Color.TRANSPARENT);
    result.add(line, end);

    result.addIfNeeded(line, column, EditorColorScheme.Ninja);
    result.add(line, span);
  }
}
