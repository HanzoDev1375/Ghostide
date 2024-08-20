package io.github.rosemoe.sora.langs.php;

import android.util.Log;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import java.io.IOException;
import java.io.StringReader;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

// Basic syntax analyzer with Php using Rhino parser.
public class PhpErrorManager implements CodeAnalyzer {

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult colors,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    try {
      PhpLexer lexer = new PhpLexer(CharStreams.fromReader(new StringReader(content.toString())));
      CommonTokenStream stream = new CommonTokenStream(lexer);
      PhpParser parser = new PhpParser(stream);
      ParseTree grammarSpecContext = parser.htmlDocument();

      parser.removeErrorListeners();

      // Listener for handling errors
      PhpParserBaseListener listener =
          new PhpParserBaseListener() {
            @Override
            public void visitErrorNode(ErrorNode node) {
              int lines = node.getSymbol().getLine();
              int col = node.getSymbol().getCharPositionInLine();
              int[] error = Utils.setErrorSpan(colors, lines, col);
              logError("Error at line " + lines + ", column " + col + ": " + node.getText());
            }

            @Override
            public void visitTerminal(TerminalNode node) {
              // TODO: Implement this method
              Log.d("Token Type", "Current Token Type: " + node.getSymbol().getText());
            }

            @Override
            public void enterArrayItem(PhpParser.ArrayItemContext ctx) {
              var node = ctx.Ampersand();
              int line = node.getSymbol().getLine();
              int col = node.getSymbol().getCharPositionInLine();
              Utils.setSpanEFO(colors, line, col, EditorColorScheme.ATTRIBUTE_VALUE);
              Log.w(
                  "SpanEFO ",
                  "Line : "
                      + String.valueOf(line)
                      + "Col : "
                      + String.valueOf(col)
                      + "Text : "
                      + node.getText());
            }
          };
      ParseTreeWalker walker = new ParseTreeWalker();
      walker.walk(listener, grammarSpecContext);
      // Additional processing if needed...
    } catch (IOException err) {
      Log.e("Error to paser", err.getLocalizedMessage());
    }
  }

  private void logError(String message) {
    System.err.println(message); // Replace with your logging mechanism
  }
}
