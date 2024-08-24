package io.github.rosemoe.sora.langs.svg;

import Ninja.coder.Ghostemane.code.marco.RegexUtilCompat;
import Ninja.coder.Ghostemane.code.utils.SetThemeForJson;
import android.graphics.Color;
import android.util.Log;
import androidx.core.graphics.ColorUtils;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import io.github.rosemoe.sora.data.Span;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.*;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

public class SvgCodeAZ implements CodeAnalyzer {

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    try {
      var str = CharStreams.fromReader(new StringReader(content.toString()));
      var lexer = new SVGLexer(str);
      Token token, pretoken = null;
      int line, column;
      var previous = -1;
      var lastLine = 1;
      var type = 0;

      while (delegate.shouldAnalyze()) {
        token = lexer.nextToken();
        if (token == null) break;
        if (token.getType() == SVGLexer.EOF) {
          lastLine = token.getLine() - 1;
          break;
        }

        line = token.getLine() - 1;
        type = token.getType();
        column = token.getCharPositionInLine();
        if (type == SVGLexer.EOF) {
          lastLine = line;
          break;
        }

        switch (type) {
          case SVGLexer.WS:
            result.addNormalIfNull();
            break;
          case SVGLexer.Comment:
            get(result, EditorColorScheme.COMMENT, line, column);
            break;
          case SVGLexer.STRING:
            get(result, EditorColorScheme.ATTRIBUTE_NAME, line, column);
            break;
          case SVGLexer.SYIN:
          case SVGLexer.SYMIN:
          case SVGLexer.SYOU:
          case SVGLexer.ASSES:
            get(result, EditorColorScheme.ATTRIBUTE_VALUE, line, column);
            break;
          case SVGLexer.NAME:
            {
              int color = EditorColorScheme.TEXT_NORMAL;

              if (previous == SVGLexer.SYIN) {
                color = EditorColorScheme.LITERAL;
              }
            
              get(result,colors,line,column);
              break;
            }

          case SVGLexer.HEXCOLOR:
            {
               var text1 = token.getText();
              if (RegexUtilCompat.RegexSelect(
                  "(\\#[a-zA-F0-9]{8})|(\\#[a-zA-F0-9]{6})|(\\#[a-zA-F0-9]{3})", text1)) {

                var colors = result;
                String colorString = token.getText();

                // تبدیل رنگ سه رقمی به شش رقمی
                if (colorString.length() == 4) { // اگر رنگ سه رقمی باشد
                  String red = colorString.substring(1, 2);
                  String green = colorString.substring(2, 3);
                  String blue = colorString.substring(3, 4);
                  colorString = "#" + red + red + green + green + blue + blue; // تبدیل به شش رقمی
                }

                try {
                  int color = Color.parseColor(colorString);
                  colors.addIfNeeded(line, column, EditorColorScheme.LITERAL);
                  if (ColorUtils.calculateLuminance(color) > 0.5) {
                    Span span =
                        Span.obtain(
                            column,
                            TextStyle.makeStyle(
                                EditorColorScheme.black));
                    if (span != null) {
                      span.setBackgroundColorMy(color);
                      colors.add(line, span);
                    }
                  } else {
                    Span span =
                        Span.obtain(
                            column,
                            TextStyle.makeStyle(
                                EditorColorScheme.TEXT_NORMAL));
                    if (span != null) {
                      span.setBackgroundColorMy(color);
                      colors.add(line, span);
                    }
                  }

                  Span middle = Span.obtain(column + text1.length(), EditorColorScheme.LITERAL);
                  middle.setBackgroundColorMy(Color.TRANSPARENT);
                  colors.add(line, middle);

                  Span end =
                      Span.obtain(
                          column + text1.length(),
                          TextStyle.makeStyle(EditorColorScheme.TEXT_NORMAL));
                  end.setBackgroundColorMy(Color.TRANSPARENT);
                  colors.add(line, end);
                  break;
                } catch (Exception ignore) {
                  ignore.printStackTrace();
                }
              } else {
                result.addIfNeeded(line, column, EditorColorScheme.LITERAL);
              }

              get(result,EditorColorScheme.HTML_TAG,line,column);
              break;
            }
        }

        if (type != SVGLexer.WS) {
          previous = type;
        }
        result.determine(lastLine);
      }

    } catch (LexerError | IOException err) {
      Log.w("Lexer not run : ", err.getLocalizedMessage());
    }
  }

  void get(TextAnalyzeResult result, int color, int line, int col) {
    Map<String, Boolean> styleMap = new HashMap<>();
    styleMap =
        new Gson()
            .fromJson(
                SetThemeForJson.setReloadStyle(),
                new TypeToken<Map<String, Boolean>>() {}.getType());
    result.addIfNeeded(
        line,
        col,
        TextStyle.makeStyle(
            color,
            0,
            styleMap.get("isBold").booleanValue(),
            styleMap.get("isItalic").booleanValue(),
            styleMap.get("isStrike").booleanValue(),
            styleMap.get("isLine").booleanValue()));
  }

  class LexerError extends RuntimeException {
    public LexerError(String code) {
      super(code);
    }
  }
}
