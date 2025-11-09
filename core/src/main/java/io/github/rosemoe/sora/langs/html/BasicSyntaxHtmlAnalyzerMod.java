package io.github.rosemoe.sora.langs.html;

import android.util.Log;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.jsoup.Jsoup;

import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.langs.javascript.JavaScriptLexer;
import io.github.rosemoe.sora.langs.javascript.JavaScriptParser;
import io.github.rosemoe.sora.langs.javascript.JavaScriptParserBaseListener;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import ir.ninjacoder.ghostide.core.GhostIdeAppLoader;

public class BasicSyntaxHtmlAnalyzerMod implements CodeAnalyzer {

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    if (GhostIdeAppLoader.getAnalyzercod().getBoolean("Analyzercod", false) == true) {

      try {
        var doc = Jsoup.parse(content.toString());
        var elment = doc.select("script");
        for (var it : elment) {
          var jsCode = it.html();
          var input = new ANTLRInputStream(jsCode);
          var lexer = new JavaScriptLexer(input);
          var stream = new CommonTokenStream(lexer);
          var parser = new JavaScriptParser(stream);
          parser.removeErrorListeners();
          var listener =
              new JavaScriptParserBaseListener() {
                @Override
                public void visitErrorNode(ErrorNode node) {
                  int lines = node.getSymbol().getLine() - 1;
                  int col = node.getSymbol().getCharPositionInLine();
                  int[] error = Utils.setErrorSpan(result, lines, col);
                  Log.w("Jsoup in Script Tag is run " , jsCode);
                }
              };

          ParseTreeWalker walker = new ParseTreeWalker();
          walker.walk(listener, parser.program());
        }
      } catch (Exception err) {

      }
    }
  }
}
