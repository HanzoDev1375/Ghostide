package io.github.rosemoe.sora.langs.json;

import io.github.rosemoe.sora.data.RainbowBracketHelper;
import io.github.rosemoe.sora.langs.json.az.JsonAz;
import ir.ninjacoder.ghostide.marco.RegexUtilCompat;
import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.EditorColorScheme;

import java.util.Stack;

import io.github.rosemoe.sora.data.BlockLine;
import io.github.rosemoe.sora.data.Span;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.langs.IdentifierAutoComplete;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;

import org.antlr.v4.runtime.CodePointCharStream;
import java.io.StringReader;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

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
		br =new RainbowBracketHelper(content);
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
      }
      if (stack.isEmpty()) {
        if (currSwitch > maxSwitch) {
          maxSwitch = currSwitch;
        }
      }
      if (type != JSONLexer.WS) {
        previous = type;
      }
      result.determine(lastLine);
      var it = new JsonAz();
      it.analyze(content, result, delegate);
      result.setSuppressSwitch(maxSwitch + 10);
    } catch (Exception err) {

    }
  }
}
