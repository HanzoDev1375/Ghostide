package io.github.rosemoe.sora.langs.javascript;

import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import io.github.rosemoe.sora.text.LineNumberCalculator;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.ErrorNode;

// Basic syntax analyzer with JavaScript using Rhino parser.
public class BasicSyntaxJavaScriptAnalyzer implements CodeAnalyzer {
  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult colors,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    ANTLRInputStream input = new ANTLRInputStream(content.toString());
    JavaScriptLexer lexer = new JavaScriptLexer(input);
    CommonTokenStream stream = new CommonTokenStream(lexer);
    JavaScriptParser parser = new JavaScriptParser(stream);
    parser.removeErrorListeners();

    // Listener for handling errors
    JavaScriptParserBaseListener listener =
        new JavaScriptParserBaseListener() {
          @Override
          public void visitErrorNode(ErrorNode node) {
            int lines = node.getSymbol().getLine();
            int col = node.getSymbol().getCharPositionInLine();
            int[] error = Utils.setErrorSpan(colors, lines, col);
            logError("Error at line " + lines + ", column " + col + ": " + node.getText());
          }
        };

    ParseTreeWalker walker = new ParseTreeWalker();
    walker.walk(listener, parser.program()); // Assuming 'program' is the starting rule

    // Additional processing if needed...
  }

  private void logError(String message) {
    System.err.println(message); // Replace with your logging mechanism
  }
}
