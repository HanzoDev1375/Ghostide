package io.github.rosemoe.sora.langs.php;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;

public class PhpErrorManager implements CodeAnalyzer {

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

    try {
      PhpLexer lexer = new PhpLexer(CharStreams.fromReader(new StringReader(content.toString())));
      CommonTokenStream stream = new CommonTokenStream(lexer);
      PhpParser parser = new PhpParser(stream);
      parser.removeErrorListeners();

      PhpParserBaseListener listener =
          new PhpParserBaseListener() {
            @Override
            public void visitErrorNode(ErrorNode node) {
              int line = node.getSymbol().getLine();
              int column = node.getSymbol().getCharPositionInLine();
              Utils.setErrorSpan(colors, line, column);
            }

            @Override
            public void enterVariableInitializer(PhpParser.VariableInitializerContext ctx) {
              if (ctx.VarName() != null) {
                String varName = ctx.VarName().getText().substring(1); // Remove $ prefix
                variables.put(
                    varName,
                    new CodePosition(
                        ctx.VarName().getSymbol().getLine(),
                        ctx.VarName().getSymbol().getCharPositionInLine()));
              }
            }

            @Override
            public void enterChain(PhpParser.ChainContext ctx) {
              if (ctx.chainOrigin() != null && ctx.chainOrigin().getText().startsWith("$")) {
                String varName = ctx.chainOrigin().getText().substring(1); // Remove $ prefix
                if (variables.containsKey(varName)) {
                  usedVariables.add(varName);
                }
              }
            }

            @Override
            public void enterFunctionDeclaration(PhpParser.FunctionDeclarationContext ctx) {
              String funcName = ctx.identifier().getText();
              functions.put(
                  funcName,
                  new CodePosition(
                      ctx.identifier().getStart().getLine(),
                      ctx.identifier().getStart().getCharPositionInLine()));
            }

            @Override
            public void enterFunctionCall(PhpParser.FunctionCallContext ctx) {
              if (ctx.functionCallName() != null) {
                String funcName = ctx.functionCallName().getText();
                if (functions.containsKey(funcName)) {
                  calledFunctions.add(funcName);
                }
              }
            }

            @Override
            public void enterMemberAccess(PhpParser.MemberAccessContext ctx) {
              if (ctx.keyedFieldName() != null) {
                String methodName = ctx.keyedFieldName().getText();
                if (functions.containsKey(methodName)) {
                  calledFunctions.add(methodName);
                }
              }
            }
          };

      ParseTreeWalker walker = new ParseTreeWalker();
      walker.walk(listener, parser.htmlDocument());

      // Mark unused variables
      variables.forEach(
          (name, pos) -> {
            if (!usedVariables.contains(name)) {
              Utils.setWaringSpan(colors, pos.line, pos.column);
            }
          });

      // Mark unused functions
      functions.forEach(
          (name, pos) -> {
            if (!calledFunctions.contains(name)) {
              Utils.setWaringSpan(colors, pos.line, pos.column);
            }
          });

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
