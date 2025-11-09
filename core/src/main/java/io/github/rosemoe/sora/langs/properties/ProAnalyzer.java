package io.github.rosemoe.sora.langs.properties;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.Token;

import java.io.IOException;
import java.io.StringReader;

import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.EditorColorScheme;

public class ProAnalyzer implements CodeAnalyzer {

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    try {
      CodePointCharStream stream = CharStreams.fromReader(new StringReader(content.toString()));
      var lexer = new PropertiesLexer(stream);
      Token token;
      boolean first = true;
      int lastLine = 1;
      int line, column;
      while (delegate.shouldAnalyze()) {
        token = lexer.nextToken();
        if (token == null) break;
        if (token.getType() == PropertiesLexer.EOF) {
          lastLine = token.getLine() - 1;
          break;
        }
        line = token.getLine() - 1;
        column = token.getCharPositionInLine();
        lastLine = line;
        switch (token.getType()) {
          case PropertiesLexer.NEWLINE:
            if (first) result.addNormalIfNull();

          case PropertiesLexer.CHARACTER:
            result.addIfNeeded(line, column, EditorColorScheme.HTML_TAG);
            break;
          case PropertiesLexer.COMMENT:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.COMMENT, 0, true, false, false));
            break;

          case PropertiesLexer.DELIMITER:
            result.addIfNeeded(line, column, EditorColorScheme.KEYWORD);
            break;
          case PropertiesLexer.SLASH:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.ATTRIBUTE_NAME, 0, false, true, false));
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
