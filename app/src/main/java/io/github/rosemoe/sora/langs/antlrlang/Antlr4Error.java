package io.github.rosemoe.sora.langs.antlrlang;

import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import java.io.StringReader;
import org.antlr.parser.antlr4.ANTLRv4Lexer;
import org.antlr.parser.antlr4.ANTLRv4Parser;
import org.antlr.parser.antlr4.ANTLRv4ParserBaseListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Antlr4Error implements CodeAnalyzer {

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    try {

      ANTLRv4Lexer lexer = new ANTLRv4Lexer(CharStreams.fromReader(new StringReader(content.toString())));
      var stream = new CommonTokenStream(lexer);
      ANTLRv4Parser parser = new ANTLRv4Parser(stream);
      ParseTree grammerSpace = parser.grammarSpec();
      var callBack =
          new ANTLRv4ParserBaseListener() {
            @Override
            public void visitErrorNode(ErrorNode node) {
              int line = node.getSymbol().getLine();
              int col = node.getSymbol().getCharPositionInLine();
              int text = node.getText().length();
              int[] err = Utils.setErrorSpan(result, line, col + text);
            }
          };
      var walk = new ParseTreeWalker();
      walk.walk(callBack, grammerSpace);

    } catch (Exception err) {

    }
  }
}
