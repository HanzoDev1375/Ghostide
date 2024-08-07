package io.github.rosemoe.sora.langs.html;

import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import org.antlr.v4.runtime.ANTLRInputStream;
import io.github.rosemoe.sora.langs.javascript.JavaScriptLexer;
import org.antlr.v4.runtime.CommonTokenStream;
import io.github.rosemoe.sora.langs.javascript.JavaScriptParser;
import io.github.rosemoe.sora.langs.javascript.JavaScriptParserBaseListener;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class BasicSyntaxHtmlAnalyzerMod {

  public void run(String code,TextAnalyzeResult colors) {
    ANTLRInputStream input = new ANTLRInputStream(code);
    JavaScriptLexer lexer = new JavaScriptLexer(input);
    CommonTokenStream stream = new CommonTokenStream(lexer);
    JavaScriptParser parser = new JavaScriptParser(stream);
    parser.removeErrorListeners();
    JavaScriptParserBaseListener listener =
        new JavaScriptParserBaseListener() {
          @Override
          public void visitErrorNode(ErrorNode node) {
            int lines = node.getSymbol().getLine();
            int col = node.getSymbol().getCharPositionInLine();
            int[] error = Utils.setErrorSpan(colors, lines, col);
            ///  logError("Error at line " + lines + ", column " + col + ": " + node.getText());
          }
        };
    
    
    ParseTreeWalker walker = new ParseTreeWalker();
    walker.walk(listener, parser.program());
  }
}
