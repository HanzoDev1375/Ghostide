package io.github.rosemoe.sora.langs.json.az;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.langs.json.JSONBaseListener;
import io.github.rosemoe.sora.langs.json.JSONLexer;
import io.github.rosemoe.sora.langs.json.JSONParser;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import ir.ninjacoder.ghostide.core.GhostIdeAppLoader;

public class JsonAz implements CodeAnalyzer {
  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    if (GhostIdeAppLoader.getAnalyzercod().getBoolean("Analyzercod", false) == true) {
      var inputStream = new ANTLRInputStream(content.toString());
      var lexer = new JSONLexer(inputStream);
      var commen = new CommonTokenStream(lexer);
      var parser = new JSONParser(commen);
      var callback =
          new JSONBaseListener() {
            @Override
            public void visitErrorNode(ErrorNode node) {
              super.visitErrorNode(node);
              // TODO: Implement this method
              int line = node.getSymbol().getLine();
              int col = node.getSymbol().getCharPositionInLine();
              int[] errorMatch = Utils.setErrorSpan(result, line, col, node.getSymbol().getText());
            }
			
          };
      ParseTreeWalker tree = new ParseTreeWalker();
      tree.walk(callback, parser.json());
    }
  }
}
