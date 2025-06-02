package io.github.rosemoe.sora.langs.kotlin;

import io.github.rosemoe.sora.data.RainbowBracketHelper;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import ir.ninjacoder.ghostide.model.Position;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KotlinSyntaxAnalyzer implements CodeAnalyzer {

  private final Map<String, Position> variables = new HashMap<>();
  private final Set<String> usedVariables = new HashSet<>();
  private final Map<String, Position> functions = new HashMap<>();
  private final Set<String> calledFunctions = new HashSet<>();
  private final Map<String, Position> parameters = new HashMap<>();
  private RainbowBracketHelper rainbowBracketHelper;

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult colors,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {

    rainbowBracketHelper = new RainbowBracketHelper();
    variables.clear();
    usedVariables.clear();
    functions.clear();
    calledFunctions.clear();

    KotlinLexer lexer = new KotlinLexer(CharStreams.fromString(content.toString()));
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    KotlinParser parser = new KotlinParser(tokens);
    parser.removeErrorListeners();

    KotlinParserBaseListener listener =
        new KotlinParserBaseListener() {
          @Override
          public void enterVariableDeclaration(KotlinParser.VariableDeclarationContext ctx) {
            String varName = ctx.simpleIdentifier().getText();
            if (!varName.equals("it")) { // Skip 'it' parameter
              variables.put(
                  varName,
                  new Position(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine()));
            }
          }

          @Override
          public void enterFunctionDeclaration(KotlinParser.FunctionDeclarationContext ctx) {
            if (ctx.identifier() != null) {
              String funcName = ctx.identifier().getText();
              functions.put(
                  funcName,
                  new Position(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine()));
            }
          }

          @Override
          public void enterSimpleIdentifier(KotlinParser.SimpleIdentifierContext ctx) {
            String identifier = ctx.getText();
            // Check if this identifier is a variable that's being used
            if (variables.containsKey(identifier)) {
              usedVariables.add(identifier);
            }
            // Check if this identifier is a function that's being called
            // (This is a simplified approach - may need more sophisticated detection)
            if (functions.containsKey(identifier)) {
              calledFunctions.add(identifier);
            }
          }

          @Override
          public void enterParameter(KotlinParser.ParameterContext ctx) {
            String paramName = ctx.simpleIdentifier().Identifier().getText();
            parameters.put(
                paramName,
                new Position(
                    ctx.simpleIdentifier().Identifier().getSymbol().getLine(),
                    ctx.simpleIdentifier().Identifier().getSymbol().getCharPositionInLine()));
          }

          @Override
          public void enterCallSuffix(KotlinParser.CallSuffixContext ctx) {
            // This helps detect function calls more accurately
            if (ctx.getParent() instanceof KotlinParser.PostfixUnaryExpressionContext) {
              KotlinParser.PostfixUnaryExpressionContext postfix =
                  (KotlinParser.PostfixUnaryExpressionContext) ctx.getParent();
              if (postfix.atomicExpression() != null
                  && postfix.atomicExpression().simpleIdentifier() != null) {
                String funcName = postfix.atomicExpression().simpleIdentifier().getText();
                if (functions.containsKey(funcName)) {
                  calledFunctions.add(funcName);
                }
              }
            }
          }
        };

    ParseTreeWalker walker = new ParseTreeWalker();
    walker.walk(listener, parser.kotlinFile());

    // Mark unused variables (with correct line/column calculation)
    variables.forEach(
        (name, pos) -> {
          if (!usedVariables.contains(name)) {
            Utils.setWaringSpan(colors, pos.line - 1, pos.column);
          }
        });

    // Mark unused functions (with correct line/column calculation)
    functions.forEach(
        (name, pos) -> {
          if (!calledFunctions.contains(name)) {
            Utils.setWaringSpan(colors, pos.line, pos.column);
          }
        });

    parameters.forEach(
        (name, pos) -> {
          rainbowBracketHelper.handleSpanColor(
              colors,
              pos.line,
              pos.column + name.length(),
              EditorColorScheme.ATTRIBUTE_NAME,
              false,
              false);
          //  colors.addIfNeeded(pos.line , pos.column, );
          // colors.addIfNeeded(pos.line , pos.column + name.length(),
          // EditorColorScheme.ATTRIBUTE_NAME);
        });
  }
}
