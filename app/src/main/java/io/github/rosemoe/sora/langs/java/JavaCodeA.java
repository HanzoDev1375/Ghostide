package io.github.rosemoe.sora.langs.java;

import Ninja.coder.Ghostemane.code.ApplicationLoader;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import android.util.*;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import org.antlr.parser.antlr4.java20.Java20Lexer;
import org.antlr.parser.antlr4.java20.Java20Parser;
import org.antlr.parser.antlr4.java20.Java20ParserBaseListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class JavaCodeA implements CodeAnalyzer {

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {

    /// test

    try {
      if (ApplicationLoader.getAnalyzercod().getBoolean("Analyzercod", false) == true) {

        ANTLRInputStream input = new ANTLRInputStream(content.toString());
        Java20Lexer lexer = new Java20Lexer(input);
        CommonTokenStream stream = new CommonTokenStream(lexer);
        Java20Parser paser = new Java20Parser(stream);
        Java20ParserBaseListener base =
            new Java20ParserBaseListener() {
              @Override
              public void visitErrorNode(ErrorNode node) {
                super.visitErrorNode(node);
                // TODO: Implement this method
                int line = node.getSymbol().getLine();
                int col = node.getSymbol().getCharPositionInLine();
                int[] errorMatch = Utils.setErrorSpan(result, line, col);
              }

              @Override
              public void enterTypeParameter(Java20Parser.TypeParameterContext ctx) {
                var token = ctx.getStart();
                int line = token.getLine() - 1;
                int colum = token.getCharPositionInLine();
                Utils.setSpanEFO(result, line, colum, EditorColorScheme.javatype);
              }

              /**
               * {@inheritDoc}
               *
               * <p>The default implementation does nothing.
               */
              @Override
              public void exitTypeParameter(Java20Parser.TypeParameterContext ctx) {}
            };

        ParseTreeWalker tree = new ParseTreeWalker();
        tree.walk(base, paser.start_());
      }

    } catch (Exception err) {
      // Handle exception if necessary
    }
  }
}
