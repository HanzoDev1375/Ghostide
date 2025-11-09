package io.github.rosemoe.sora.langs.yml;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.Token;

import java.io.StringReader;

import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.widget.EditorColorScheme;

public class YmlCodeAnalyzer implements CodeAnalyzer {

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {

    try {
      CodePointCharStream stream = CharStreams.fromReader(new StringReader(content.toString()));
      var lexer = new YAMLLexer(stream);
      Token token, preToken = null, prePreToken = null;
      int lastLine = 1;
      int line, column;
      int type = 0;
      boolean first = true;
      while (delegate.shouldAnalyze()) {
        token = lexer.nextToken();
        if (token == null) break;
        if (token.getType() == YAMLLexer.EOF) {
          lastLine = token.getLine() - 1;
          break;
        }
        line = token.getLine() - 1;
        type = token.getType();
        String text1 = token.getText();
        column = token.getCharPositionInLine();
        if (token.getType() == YAMLLexer.EOF) {
          lastLine = line;
          break;
        }

        switch (token.getType()) {
          case YAMLLexer.WS:
            if (first) {
              result.addNormalIfNull();
            }
            break;
          case YAMLLexer.TRUE:
          case YAMLLexer.FALSE:
            result.addIfNeeded(line, column, EditorColorScheme.ATTRIBUTE_NAME);
            break;
          
        }
      }
      result.determine(lastLine);
    } catch (Exception err) {

    }
  }
}
