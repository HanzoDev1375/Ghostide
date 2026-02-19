package io.github.rosemoe.sora.langs.javascript;

import androidx.core.content.ContextCompat;
import io.github.rosemoe.sora.widget.icon.IconSpan;
import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.model.IconShop;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.diagnostics.*;

import java.util.*;

public class BasicSyntaxJavaScriptAnalyzer implements CodeAnalyzer {

  private CodeEditor editor;
  private List<Diagnostic> diagnostics = new ArrayList<>();
  private Map<String, VarPosition> variables = new HashMap<>();
  private Set<String> usedVariables = new HashSet<>();
  private Map<String, FuncPosition> functions = new HashMap<>();
  private Set<String> calledFunctions = new HashSet<>();
  private CharSequence currentContent;

  private static class VarPosition {
    int line;
    int characterColumn;
    int visualColumn;  
    int length;
    int startIndex;
    int endIndex;

    VarPosition(int line, int characterColumn, int visualColumn, int length, int startIndex, int endIndex) {
      this.line = line;
      this.characterColumn = characterColumn;
      this.visualColumn = visualColumn;
      this.length = length;
      this.startIndex = startIndex;
      this.endIndex = endIndex;
    }
  }

  private static class FuncPosition {
    int line;
    int characterColumn;
    int visualColumn;
    int length;
    int startIndex;
    int endIndex;

    FuncPosition(int line, int characterColumn, int visualColumn, int length, int startIndex, int endIndex) {
      this.line = line;
      this.characterColumn = characterColumn;
      this.visualColumn = visualColumn;
      this.length = length;
      this.startIndex = startIndex;
      this.endIndex = endIndex;
    }
  }

  public BasicSyntaxJavaScriptAnalyzer(CodeEditor editor) {
    this.editor = editor;
  }

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult colors,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {

    this.currentContent = content;

    if (editor != null) {
      editor.clearDiagnostics();
      
    }
    diagnostics.clear();
    variables.clear();
    usedVariables.clear();
    functions.clear();
    calledFunctions.clear();

    JsAutoComplete com = new JsAutoComplete();

    try {
      CharStream input = CharStreams.fromString(content.toString());
      JavaScriptLexer lexer = new JavaScriptLexer(input);
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      JavaScriptParser parser = new JavaScriptParser(tokens);
      parser.removeErrorListeners();
      parser.addErrorListener(
          new BaseErrorListener() {
            @Override
            public void syntaxError(
                Recognizer<?, ?> recognizer,
                Object offendingSymbol,
                int line,
                int charPositionInLine,
                String msg,
                RecognitionException e) {

              if (editor != null) {
                line = line - 1;
                try {
                  int startIndex = getCharIndex(line, charPositionInLine, content);
                  int endIndex = startIndex + 1;

                  Diagnostic diagnostic =
                      new Diagnostic(
                          startIndex, endIndex, "`Error` " + msg, DiagnosticsState.ERROR);
                  editor.addDiagnostic(diagnostic);
                  if (editor != null) editor.showCurrentDiagnostic();
                } catch (Exception ex) {
                  // ignore
                }
              }
            }
          });

      JavaScriptParserBaseListener listener =
          new JavaScriptParserBaseListener() {

            @Override
            public void enterVariableDeclaration(JavaScriptParser.VariableDeclarationContext ctx) {
              try {
                String varName = ctx.assignable().getText();
                int line = ctx.getStart().getLine() - 1;
                int characterColumn = ctx.getStart().getCharPositionInLine();
                int visualColumn = calculateVisualColumn(content, line, characterColumn);
                int length = varName.length();
                int startIndex = getCharIndex(line, characterColumn, content);
                int endIndex = startIndex + length;

                variables.put(varName, new VarPosition(line, characterColumn, visualColumn, length, startIndex, endIndex));
                com.addVariable(varName, "var");
              } catch (Exception e) {
                // ignore
              }
            }

            @Override
            public void enterIdentifierExpression(
                JavaScriptParser.IdentifierExpressionContext ctx) {
              try {
                String identifier = ctx.getText();

                if (variables.containsKey(identifier)) {
                  usedVariables.add(identifier);
                }

                if (functions.containsKey(identifier)) {
                  calledFunctions.add(identifier);
                }
              } catch (Exception e) {
                // ignore
              }
            }

            @Override
            public void enterFunctionDeclaration(JavaScriptParser.FunctionDeclarationContext ctx) {
              try {
                if (ctx.identifier() != null) {
                  String funcName = ctx.identifier().getText();
                  int line = ctx.getStart().getLine() - 1;
                  int characterColumn = ctx.getStart().getCharPositionInLine();
                  int visualColumn = calculateVisualColumn(content, line, characterColumn);
                  int length = funcName.length();

                  int startIndex = getCharIndex(line, characterColumn, content);
                  int endIndex = startIndex + length;

                  functions.put(
                      funcName, new FuncPosition(line, characterColumn, visualColumn, length, startIndex, endIndex));
                  com.addFunction(funcName, "void");
                }
              } catch (Exception e) {
                // ignore
              }
            }

            @Override
            public void enterArgumentsExpression(JavaScriptParser.ArgumentsExpressionContext ctx) {
              try {
                if (ctx.singleExpression()
                    instanceof JavaScriptParser.IdentifierExpressionContext) {
                  String funcName = ctx.singleExpression().getText();
                  if (functions.containsKey(funcName)) {
                    calledFunctions.add(funcName);
                  }
                }
              } catch (Exception e) {
                // ignore
              }
            }

            @Override
            public void enterArrowFunction(JavaScriptParser.ArrowFunctionContext ctx) {
              try {
                JavaScriptParser.ArrowFunctionParametersContext params =
                    ctx.arrowFunctionParameters();
                if (params.getText() != null) {
                  String funcName = params.getText();
                  int line = ctx.getStart().getLine() - 1;
                  int characterColumn = ctx.getStart().getCharPositionInLine();
                  int visualColumn = calculateVisualColumn(content, line, characterColumn);
                  int length = funcName.length();

                  int startIndex = getCharIndex(line, characterColumn, content);
                  int endIndex = startIndex + length;

                  functions.put(
                      funcName, new FuncPosition(line, characterColumn, visualColumn, length, startIndex, endIndex));
                  com.addFunction(funcName, "void");
                }
              } catch (Exception e) {
                // ignore
              }
            }

            @Override
            public void enterMethodDefinition(JavaScriptParser.MethodDefinitionContext ctx) {
              try {
                String methodName = ctx.classElementName().getText();
                int line = ctx.getStart().getLine() - 1;
                int characterColumn = ctx.getStart().getCharPositionInLine();
                int visualColumn = calculateVisualColumn(content, line, characterColumn);
                int length = methodName.length();

                int startIndex = getCharIndex(line, characterColumn, content);
                int endIndex = startIndex + length;

                functions.put(
                    methodName, new FuncPosition(line, characterColumn, visualColumn, length, startIndex, endIndex));
                com.addFunction(methodName, "void");
              } catch (Exception e) {
                // ignore
              }
            }
          };

      ParseTreeWalker walker = new ParseTreeWalker();
      walker.walk(listener, parser.program());
      
      // بررسی متغیرهای استفاده نشده
      for (Map.Entry<String, VarPosition> entry : variables.entrySet()) {
        String varName = entry.getKey();
        VarPosition pos = entry.getValue();

        if (!usedVariables.contains(varName)) {
          if (editor != null) {
            Diagnostic diagnostic =
                new Diagnostic(
                    pos.startIndex,
                    pos.endIndex,
                    "var `" + varName + "` not using",
                    DiagnosticsState.UNUSED);
            editor.addDiagnostic(diagnostic);
            if (editor != null) editor.showCurrentDiagnostic();
          }
        }
      }
      
      // بررسی توابع استفاده نشده
      for (Map.Entry<String, FuncPosition> entry : functions.entrySet()) {
        String funcName = entry.getKey();
        FuncPosition pos = entry.getValue();

        if (!calledFunctions.contains(funcName)) {
          if (editor != null) {
            Diagnostic diagnostic =
                new Diagnostic(
                    pos.startIndex,
                    pos.endIndex,
                    "fun `" + funcName + "` not call or using",
                    DiagnosticsState.UNUSED);
            editor.addDiagnostic(diagnostic);
            if (editor != null) editor.showCurrentDiagnostic();
          }
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * تبدیل character column به visual column با در نظر گرفتن tabها
   */
  private int calculateVisualColumn(CharSequence content, int line, int characterColumn) {
    String text = content.toString();
    String[] lines = text.split("\n", -1);
    
    if (line >= lines.length) return characterColumn;
    
    String targetLine = lines[line];
    int visualColumn = 0;
    int tabWidth = editor != null ? editor.getTabWidth() : 4;
    
    for (int i = 0; i < Math.min(characterColumn, targetLine.length()); i++) {
      char c = targetLine.charAt(i);
      if (c == '\t') {
        // هر tab به اندازه tabWidth - (visualColumn % tabWidth) فاصله اضافه میکنه
        visualColumn += tabWidth - (visualColumn % tabWidth);
      } else {
        visualColumn++;
      }
    }
    
    return visualColumn;
  }

  private int getCharIndex(int line, int column, CharSequence content) {
    String text = content.toString();
    String[] lines = text.split("\n", -1);

    int index = 0;
    for (int i = 0; i < line; i++) {
      if (i < lines.length) {
        index += lines[i].length() + 1;
      }
    }

    if (line < lines.length) {
      index += Math.min(column, lines[line].length());
    }
    return Math.min(index, text.length());
  }
}