package io.github.rosemoe.sora.langs.python;

import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.text.TextAnalyzer;
import ir.ninjacoder.ghostide.IdeEditor;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import java.io.StringReader;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import com.blankj.utilcode.util.ThreadUtils;
import java.io.IOException;
import android.util.Log;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;

public class PythonErrorManager implements CodeAnalyzer {

  protected IdeEditor editor;
  protected List<String> errorMessages;
  protected Map<String, CodePosition> definedVariables;
  protected Set<String> usedVariables;
  protected Map<String, CodePosition> definedFunctions;
  protected Set<String> calledFunctions;

  public PythonErrorManager(IdeEditor editor) {
    this.editor = editor;

    this.errorMessages = new ArrayList<>();
    this.definedVariables = new HashMap<>();
    this.usedVariables = new HashSet<>();
    this.definedFunctions = new HashMap<>();
    this.calledFunctions = new HashSet<>();
  }

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult colors,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    definedVariables.clear();
    usedVariables.clear();
    definedFunctions.clear();
    calledFunctions.clear();
    errorMessages.clear();

    try {
      PythonLexer lexer =
          new PythonLexer(CharStreams.fromReader(new StringReader(content.toString())));
      CommonTokenStream stream = new CommonTokenStream(lexer);
      PythonParser parser = new PythonParser(stream);
      ParseTree tree = parser.file_input();

      ParseTreeWalker walker = new ParseTreeWalker();
      PythonUsageListener listener = new PythonUsageListener(colors);
      walker.walk(listener, tree);

      // بررسی متغیرهای استفاده نشده
      for (Map.Entry<String, CodePosition> entry : definedVariables.entrySet()) {
        String varName = entry.getKey();
        CodePosition pos = entry.getValue();
        if (!usedVariables.contains(varName)) {
          errorMessages.add("Unused variable: " + varName);
          Utils.setWaringSpan(colors, pos.line, pos.column);
        }
      }

      // بررسی توابع استفاده نشده
      for (Map.Entry<String, CodePosition> entry : definedFunctions.entrySet()) {
        String funcName = entry.getKey();
        CodePosition pos = entry.getValue();
        if (!calledFunctions.contains(funcName)) {
          errorMessages.add("Unused function: " + funcName);
          Utils.setWaringSpan(colors, pos.line, pos.column);
        }
      }
    } catch (IOException e) {
      Log.e("PythonErrorManager", "Error analyzing code: " + e.getMessage());
    }
  }

  class CodePosition {
    final int line;
    final int column;

    public CodePosition(int line, int column) {
      this.line = line;
      this.column = column;
    }
  }

  class PythonUsageListener extends PythonParserBaseListener {
    TextAnalyzeResult colors;

    public PythonUsageListener(TextAnalyzeResult colors) {
      this.colors = colors;
    }

    @Override
    public void enterAssignment(PythonParser.AssignmentContext ctx) {
      String varName = ctx.getText();
      Token token = ctx.getStart();
      definedVariables.put(
          varName, new CodePosition(token.getLine(), token.getCharPositionInLine()));
    }

    @Override
    public void enterName(PythonParser.NameContext ctx) {
      String varName = ctx.getText();
      usedVariables.add(varName);
    }

    @Override
    public void enterFunction_def(PythonParser.Function_defContext ctx) {
      String funcName = ctx.getText();

      Token token = ctx.getStart();
      definedFunctions.put(
          funcName, new CodePosition(token.getLine(), token.getCharPositionInLine()));
    }

    @Override
    public void enterAtom(PythonParser.AtomContext ctx) {
      String funcName = ctx.getText();
      calledFunctions.add(funcName);
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
      int line = node.getSymbol().getLine();
      int column = node.getSymbol().getCharPositionInLine();
      errorMessages.add(
          "Syntax error at line " + line + ", column " + column + ": " + node.getText());
      Utils.setErrorSpan(colors, line, column);
    }
  }

  private void logError(String message) {
    System.err.println(message);
  }
}
