package io.github.rosemoe.sora.langs.json;

import android.graphics.Color;

import androidx.core.graphics.ColorUtils;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.Token;

import java.io.StringReader;
import java.util.Stack;

import io.github.rosemoe.sora.data.BlockLine;
import io.github.rosemoe.sora.data.RainbowBracketHelper;
import io.github.rosemoe.sora.data.Span;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.langs.json.az.JsonAz;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import ir.ninjacoder.ghostide.core.marco.RegexUtilCompat;

/**
 * Note:Navigation not supported
 *
 * @author Ghost
 */
public class JsonCodeAnalyzer implements CodeAnalyzer {

  private static final Object OBJECT = new Object();
  RainbowBracketHelper br;

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    try {
      br = new RainbowBracketHelper(content);
      CodePointCharStream stream = CharStreams.fromReader(new StringReader(content.toString()));
      JSONLexer jsons = new JSONLexer(stream);
      Token token;
      int line, column;
      Stack<BlockLine> stack = new Stack<>();
      int maxSwitch = 1, currSwitch = 0, previous = -1, type = -1;
      boolean classNamePrevious = false;
      boolean first = true;
      int lastLine = 1;
      while (delegate.shouldAnalyze()) {

        token = jsons.nextToken();
        if (token == null) break;
        if (token.getType() == JSONLexer.EOF) {
          lastLine = token.getLine() - 1;
          break;
        }
        line = token.getLine() - 1;
        type = token.getType();
        column = token.getCharPositionInLine();
        if (type == JSONLexer.EOF) {
          lastLine = line;
          break;
        }

        switch (type) {
          case JSONLexer.WS:
            if (first) {
              result.addNormalIfNull();
            }
            break;
          case JSONLexer.COLON:
          case JSONLexer.COMMA:
            classNamePrevious = false;
            result.addIfNeeded(
                line, column, TextStyle.makeStyle(EditorColorScheme.jsfun, 0, true, false, false));
            break;
          case JSONLexer.STRING:
            {
              if (RegexUtilCompat.RegexSelect(
                  "(\\#[a-zA-F0-9]{8})|(\\#[a-zA-F0-9]{6})|(\\#[a-zA-F0-9]{3})", token.getText())) {
               String text1=token.getText();
                var colors = result;
                String colorString = text1;

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
                                EditorColorScheme.black, 0, false, false, false, false, true));
                    if (span != null) {
                      span.setBackgroundColorMy(color);
                      colors.add(line, span);
                    }
                  } else {
                    Span span =
                        Span.obtain(
                            column,
                            TextStyle.makeStyle(
                                EditorColorScheme.TEXT_NORMAL,
                                0,
                                false,
                                false,
                                false,
                                false,
                                true));
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
                result.addIfNeeded(line, column, forString());
              }
              if (previous == JSONLexer.COLON) {
                result.addIfNeeded(
                    line,
                    column,
                    TextStyle.makeStyle(EditorColorScheme.jsoprator, 0, true, false, false));
              }
              result.addIfNeeded(
                  line,
                  column,
                  TextStyle.makeStyle(EditorColorScheme.jsstring, 0, true, false, false));
              break;
            }

          case JSONLexer.LBRACE:
          case JSONLexer.LBRACKET:
            {
              br.handleOpenBracket(result, line, column, EditorColorScheme.htmlblockhash);
              break;
            }
          case JSONLexer.RBRACE:
          case JSONLexer.RBRACKET:
            {
              br.handleCloseBracket(result, line, column, EditorColorScheme.htmlblockhash);
              break;
            }
          case JSONLexer.TRUE:
          case JSONLexer.FALSE:
          case JSONLexer.NULL:
            result.addIfNeeded(line, column, EditorColorScheme.jskeyword);
            break;
        }
        first = false;
        if (type != JSONLexer.WS) {
        previous = type;
      }
      }
      if (stack.isEmpty()) {
        if (currSwitch > maxSwitch) {
          maxSwitch = currSwitch;
        }
      }
      
      result.determine(lastLine);
      var it = new JsonAz();
      it.analyze(content, result, delegate);
      result.setSuppressSwitch(maxSwitch + 10);
    } catch (Exception err) {

    }
  }

  public long forString() {
    return TextStyle.makeStyle(EditorColorScheme.htmlstr, 0, true, false, false);
  }
}
