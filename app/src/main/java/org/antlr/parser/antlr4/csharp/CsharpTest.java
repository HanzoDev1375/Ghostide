package org.antlr.parser.antlr4.csharp;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class CsharpTest {

  static void main() {
    String cscode = """
     public class ClassName {
      Constructor MethodName(Object a, String b, int c) {
        var avgSum = Math.Sqrt(Math.Pow(x[i] - x[j], 2) + Math.Pow(y[i] - y[j], 2));
        return new Constructor(field, a.b, a.b + c.d, e.f.g + h);
    }
 }
    """;
    var antlrinputstream = new ANTLRInputStream(cscode);
    var lexer = new CSharpLexer(antlrinputstream);
    var stream = new CommonTokenStream(lexer);
    var paser = new CSharpParser(stream);
    var base =
        new CSharpParserBaseListener() {

          @Override
          public void visitErrorNode(ErrorNode node) {
            var line = node.getSymbol().getLine() - 1;
            var col = node.getSymbol().getCharPositionInLine();
            var text = node.getText().toString();
            System.err.println(
                "Error in node in line " + line + "Node in col " + col + "Node is Text " + text);
          }
        };
    var treeWalk = new ParseTreeWalker();
    treeWalk.walk(base, paser.compilation_unit());
  }
}
