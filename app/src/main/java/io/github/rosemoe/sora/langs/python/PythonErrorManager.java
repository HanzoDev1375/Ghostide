package io.github.rosemoe.sora.langs.python;

import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import io.github.rosemoe.sora.text.LineNumberCalculator;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

// Basic syntax analyzer with Python3 using Rhino parser.
public class PythonErrorManager implements CodeAnalyzer {

  private Token token;

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult colors,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {

    ANTLRInputStream input = new ANTLRInputStream(content.toString());
    PythonLexer lexer = new PythonLexer(input);
    CommonTokenStream stream = new CommonTokenStream(lexer);
    PythonParser parser = new PythonParser(stream);
    parser.removeErrorListeners();

    // Listener for handling errors
    PythonParserBaseListener listener =
        new PythonParserBaseListener() {
          @Override
          public void visitErrorNode(ErrorNode node) {
            int lines = node.getSymbol().getLine();
            int col = node.getSymbol().getCharPositionInLine();
            int[] error = Utils.setErrorSpan(colors, lines, col);
            logError("Error at line " + lines + ", column " + col + ": " + node.getText());
          }
        };

    ParseTreeWalker walker = new ParseTreeWalker();
    walker.walk(listener, parser.file_input()); // Assuming 'program' is the starting rule

    // Additional processing if needed...
  }

  private void logError(String message) {
    System.err.println(message); // Replace with your logging mechanism
  }
}
