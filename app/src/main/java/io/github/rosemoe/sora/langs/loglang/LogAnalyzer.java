package io.github.rosemoe.sora.langs.loglang;

import io.github.rosemoe.sora.langs.css3.css3Lexer;
import io.github.rosemoe.sora.text.TextStyle;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.Token;

import java.io.IOException;
import java.io.StringReader;

import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.widget.EditorColorScheme;

/**
 * Simple implementation of highlight CSS3. The color matching may not be beautiful and reasonable.
 * Part of it depends on css3.g4. You can continue to expand according to your needs.
 */
public class LogAnalyzer implements CodeAnalyzer {

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    try {
      CodePointCharStream stream = CharStreams.fromReader(new StringReader(content.toString()));
      LOGLexer lexer = new LOGLexer(stream);
      Token token;
      boolean first = true;
      int lastLine = 1;
      int line, column;
      while (delegate.shouldAnalyze()) {
        token = lexer.nextToken();
        if (token == null) break;
        if (token.getType() == LOGLexer.EOF) {
          lastLine = token.getLine() - 1;
          break;
        }
        line = token.getLine() - 1;
        column = token.getCharPositionInLine();
        lastLine = line;

        // Log.d("test",token.getText()+"  "+token.getType());
        switch (token.getType()) {
          case LOGLexer.WS:
            if (first) result.addNormalIfNull();
            break;
          case LOGLexer.DEBUG:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.COLOR_DEBUG, 0, true, false, false));
            break;

          case LOGLexer.INFO:
            result.addIfNeeded(line, column, EditorColorScheme.COLOR_TIP);
            break;
          case LOGLexer.WARNING:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.COLOR_WARNING, 0, false, true, false));
            break;
          case LOGLexer.ERROR:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.COLOR_ERROR, 0, false, true, false));
            break;
          case LOGLexer.LOG:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.COLOR_LOG, 0, false, true, false));
            break;
          case LOGLexer.DECIMAL_LITERAL:
          case LOGLexer.HEX_LITERAL:
          case LOGLexer.OCT_LITERAL:
          case LOGLexer.BINARY_LITERAL:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.BLOCK_LINE, 0, false, true, false));
            break;

          default:
            result.addIfNeeded(line, column, EditorColorScheme.TEXT_NORMAL);

            break;
        }

        first = false;
      }
      result.determine(lastLine);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
