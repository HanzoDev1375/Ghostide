package io.github.rosemoe.sora.langs.javascript;

import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.ErrorNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BasicSyntaxJavaScriptAnalyzer implements CodeAnalyzer {

  private static class CodePosition {
    final int line;
    final int column;

    public CodePosition(int line, int column) {
      this.line = line;
      this.column = column;
    }
  }

  private final Map<String, CodePosition> variables = new HashMap<>();
  private final Set<String> usedVariables = new HashSet<>();
  private final Map<String, CodePosition> functions = new HashMap<>();
  private final Set<String> calledFunctions = new HashSet<>();

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult colors,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    // Reset state for new analysis
    variables.clear();
    usedVariables.clear();
    functions.clear();
    calledFunctions.clear();

    ANTLRInputStream input = new ANTLRInputStream(content.toString());
    JavaScriptLexer lexer = new JavaScriptLexer(input);
    CommonTokenStream stream = new CommonTokenStream(lexer);
    JavaScriptParser parser = new JavaScriptParser(stream);
    parser.removeErrorListeners();

    JavaScriptParserBaseListener listener =
        new JavaScriptParserBaseListener() {
          @Override
          public void visitErrorNode(ErrorNode node) {
            int line = node.getSymbol().getLine();
            int column = node.getSymbol().getCharPositionInLine();
            Utils.setErrorSpan(colors, line, column);
          }

          @Override
          public void enterVariableDeclaration(JavaScriptParser.VariableDeclarationContext ctx) {
            String varName = ctx.assignable().getText();
            variables.put(
                varName,
                new CodePosition(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine()));
          }

          @Override
          public void enterIdentifierExpression(JavaScriptParser.IdentifierExpressionContext ctx) {
            String varName = ctx.getText();
            if (variables.containsKey(varName)) {
              usedVariables.add(varName);
            }
          }

          @Override
          public void enterFunctionDeclaration(JavaScriptParser.FunctionDeclarationContext ctx) {
            String funcName = ctx.identifier().getText();
            functions.put(
                funcName,
                new CodePosition(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine()));
          }

          @Override
          public void enterArgumentsExpression(JavaScriptParser.ArgumentsExpressionContext ctx) {
            String funcName = ctx.singleExpression().getText();
            if (functions.containsKey(funcName)) {
              calledFunctions.add(funcName);
            }
          }

          @Override
          public void enterMemberDotExpression(JavaScriptParser.MemberDotExpressionContext ctx) {
            String funcName = ctx.identifierName().getText();
            if (functions.containsKey(funcName)) {
              calledFunctions.add(funcName);
            }
          }
        };

    ParseTreeWalker walker = new ParseTreeWalker();
    walker.walk(listener, parser.program());
    variables.forEach(
        (name, pos) -> {
          if (!usedVariables.contains(name)) {
            Utils.setWaringSpan(colors, pos.line, pos.column);
          }
        });
    functions.forEach(
        (name, pos) -> {
			
          if (!calledFunctions.contains(name)) {
            Utils.setWaringSpan(colors, pos.line, pos.column);
          }
        });
  }
}
