package io.github.rosemoe.sora.langs.java;

import Ninja.coder.Ghostemane.code.IdeEditor;
import Ninja.coder.Ghostemane.code.databin.DiagnosticWrapper;
import Ninja.coder.Ghostemane.code.utils.ThemeUtils;
import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.expr.TypeExpr;
import com.github.javaparser.ast.type.TypeParameter;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import io.github.rosemoe.sora.util.TrieTree;
import java.util.ArrayList;
import android.util.Log;
import io.github.rosemoe.sora.data.Span;
import io.github.rosemoe.sora.text.TextStyle;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;
import io.github.rosemoe.sora.data.BlockLine;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.Token;
import java.io.IOException;
import java.io.StringReader;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.widget.EditorColorScheme;

public class JavaCodeAnalyzer implements CodeAnalyzer {

  private final WeakReference<IdeEditor> mEditorReference;
  private final List<DiagnosticWrapper> mDiagnostics;
  private static final Object OBJECT = new Object();
  private Set<Integer> usedColors = new HashSet<>();
  private Map<String, Boolean> mapStyle;

  private static final int MAX_BRACE_COUNT = Integer.MAX_VALUE;
  private static final int[] BRACE_COLORS = {
    EditorColorScheme.OPERATOR,
    EditorColorScheme.KEYWORD,
    EditorColorScheme.ATTRIBUTE_NAME,
    EditorColorScheme.COLOR_WARNING,
    EditorColorScheme.HTML_TAG,
    EditorColorScheme.LITERAL,
    EditorColorScheme.Ninja,
    EditorColorScheme.ATTRIBUTE_NAME
  };

  public JavaCodeAnalyzer(IdeEditor editor) {
    mEditorReference = new WeakReference<>(editor);
    mDiagnostics = new ArrayList<>();
  }

  @Override
  public void setDiagnostics(List<DiagnosticWrapper> diagnostics) {
    mDiagnostics.clear();
    mDiagnostics.addAll(diagnostics);
  }

  @Override
  public void analyzeInBackground(CharSequence content) {
    IdeEditor editor = mEditorReference.get();
    if (editor == null) {
      return;
    }
  }

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    try {

      IdeEditor editor = mEditorReference.get();
      if (editor == null) {
        return;
      }
      StringBuilder text =
          content instanceof StringBuilder ? (StringBuilder) content : new StringBuilder(content);
      CodePointCharStream stream = CharStreams.fromReader(new StringReader(content.toString()));
      JavaLexer lexer = new JavaLexer(stream);
      

      var classNamePrevious = false;
      Token token, preToken = null, prePreToken = null;
      boolean first = true;
      JavaAutoComplete auto = new JavaAutoComplete(editor);
      auto.setMd(true);
      auto.setKeywords(JavaLanguage.keywords);
      JavaAutoComplete.Identifiers info = new JavaAutoComplete.Identifiers();
      info.begin();
      int[] mcolors = {
        EditorColorScheme.ATTRIBUTE_NAME,
        EditorColorScheme.ATTRIBUTE_VALUE,
        EditorColorScheme.OPERATOR,
        EditorColorScheme.Ninja,
        EditorColorScheme.KEYWORD
      };
      int lbraceCount = 0;
      Stack<Integer> lbraceLevels = new Stack<>();

      Stack<BlockLine> stack = new Stack<>();
      TrieTree<Object> tree = new TrieTree<>();
      int type, currSwitch = 1, maxSwitch = 0, previous = 0;
      int lastLine = 1;
      int line, column;
      var prevIsTagName = false;
      tree.put("String", OBJECT);
      tree.put("Object", OBJECT);
      while (delegate.shouldAnalyze()) {
        token = lexer.nextToken();
        if (token == null) break;
        if (token.getType() == JavaLexer.EOF) {
          lastLine = token.getLine() - 1;
          break;
        }
        line = token.getLine() - 1;
        type = token.getType();
        String text1 = token.getText();
        var tokenLength = token.getText().length();
        column = token.getCharPositionInLine();
        if (type == JavaLexer.EOF) {
          lastLine = line;
          break;
        }

        switch (type) {
          case JavaLexer.WS:
            if (first) {
              result.addNormalIfNull();
            }
            break;
          case JavaLexer.ABSTRACT:
          case JavaLexer.ASSERT:
          case JavaLexer.BREAK:
          case JavaLexer.CASE:
          case JavaLexer.CATCH:
          case JavaLexer.CLASS:
          case JavaLexer.CONST:
          case JavaLexer.CONTINUE:
          case JavaLexer.DEFAULT:
          case JavaLexer.DO:
          case JavaLexer.ELSE:
          case JavaLexer.EXTENDS:
          case JavaLexer.FINAL:
          case JavaLexer.FINALLY:
          case JavaLexer.FOR:
          case JavaLexer.IF:
          case JavaLexer.GOTO:
          case JavaLexer.IMPLEMENTS:
          case JavaLexer.IMPORT:
          case JavaLexer.INSTANCEOF:
          case JavaLexer.INTERFACE:
          case JavaLexer.NATIVE:
          case JavaLexer.NEW:
          case JavaLexer.PACKAGE:
          case JavaLexer.PRIVATE:
          case JavaLexer.PROTECTED:
          case JavaLexer.PUBLIC:
          case JavaLexer.RETURN:
          case JavaLexer.STATIC:
          case JavaLexer.STRICTFP:
          case JavaLexer.SUPER:
          case JavaLexer.SWITCH:
          case JavaLexer.SYNCHRONIZED:
          case JavaLexer.THIS:
          case JavaLexer.THROW:
          case JavaLexer.THROWS:
          case JavaLexer.TRANSIENT:
          case JavaLexer.TRY:
          case JavaLexer.VOID:
          case JavaLexer.VOLATILE:
          case JavaLexer.WHILE:
          case JavaLexer.VAR:
            get(EditorColorScheme.javakeyword, line, column, result);
            classNamePrevious = true;
            break;
          case JavaLexer.DECIMAL_LITERAL:
          case JavaLexer.HEX_LITERAL:
          case JavaLexer.OCT_LITERAL:
          case JavaLexer.BINARY_LITERAL:
          case JavaLexer.FLOAT_LITERAL:
          case JavaLexer.HEX_FLOAT_LITERAL:
          case JavaLexer.BOOL_LITERAL:
          case JavaLexer.CHAR_LITERAL:
          case JavaLexer.NULL_LITERAL:
            result.addIfNeeded(line, column, EditorColorScheme.javastring);
            break;
          case JavaLexer.STRING_LITERAL:
            {
              if (text1.startsWith("\"#")) {
                var colors = result;
                try {
                  int color = Color.parseColor(text1.substring(1, text1.length() - 1));
                  colors.addIfNeeded(line, column, EditorColorScheme.LITERAL);
                  if (ColorUtils.calculateLuminance(color) > 0.5) {
                    Span span =
                        Span.obtain(
                            column + 1,
                            TextStyle.makeStyle(
                                EditorColorScheme.black, 0, false, false, false, false, true));
                    if (span != null) {
                      span.setBackgroundColorMy(color);
                      colors.add(line, span);
                    }
                  } else if (ColorUtils.calculateLuminance(color) <= 0.5) {
                    Span span =
                        Span.obtain(
                            column + 1,
                            TextStyle.makeStyle(
                                EditorColorScheme.TEXT_NORMAL,
                                0,
                                false,
                                false,
                                false,
                                false,
                                true));
                    if (span != null) {
                      span.setBackgroundColorMy(color);
                      colors.add(line, span);
                    }
                  }

                  Span middle = Span.obtain(column + text1.length() - 1, EditorColorScheme.LITERAL);
                  middle.setBackgroundColorMy(Color.TRANSPARENT);
                  colors.add(line, middle);

                  Span end =
                      Span.obtain(
                          column + text1.length(),
                          TextStyle.makeStyle(EditorColorScheme.TEXT_NORMAL));
                  end.setBackgroundColorMy(Color.TRANSPARENT);
                  colors.add(line, end);
                  break;
                } catch (Exception ignore) {
                  ignore.printStackTrace();
                }
              }
              result.addIfNeeded(line, column, forString());
              break;
            }

          case JavaLexer.LPAREN:
          case JavaLexer.RPAREN:
          case JavaLexer.LBRACK:
          case JavaLexer.RBRACK:
          case JavaLexer.SEMI:
          case JavaLexer.COMMA:
          case JavaLexer.ASSIGN:
          case JavaLexer.GT:
          case JavaLexer.LT:
          case JavaLexer.BANG:
          case JavaLexer.TILDE:
          case JavaLexer.QUESTION:
          case JavaLexer.COLON:
          case JavaLexer.EQUAL:
          case JavaLexer.GE:
          case JavaLexer.LE:
          case JavaLexer.NOTEQUAL:
          case JavaLexer.AND:
          case JavaLexer.OR:
          case JavaLexer.INC:
          case JavaLexer.DEC:
          case JavaLexer.ADD:
          case JavaLexer.SUB:
          case JavaLexer.MUL:
          case JavaLexer.DIV:
          case JavaLexer.BITAND:
          case JavaLexer.BITOR:
          case JavaLexer.CARET:
          case JavaLexer.MOD:
          case JavaLexer.ADD_ASSIGN:
          case JavaLexer.SUB_ASSIGN:
          case JavaLexer.MUL_ASSIGN:
          case JavaLexer.DIV_ASSIGN:
          case JavaLexer.AND_ASSIGN:
          case JavaLexer.OR_ASSIGN:
          case JavaLexer.XOR_ASSIGN:
          case JavaLexer.MOD_ASSIGN:
          case JavaLexer.LSHIFT_ASSIGN:
          case JavaLexer.RSHIFT_ASSIGN:
          case JavaLexer.URSHIFT_ASSIGN:
          case JavaLexer.ARROW:
          case JavaLexer.COLONCOLON:
          case JavaLexer.ELLIPSIS:
          case JavaLexer.DOT:
            if (previous == JavaLexer.IDENTIFIER) {
              get(EditorColorScheme.ATTRIBUTE_VALUE, line, column, result);
            }
            get(EditorColorScheme.TEXT_NORMAL, line, column, result);
            break;
          case JavaLexer.BOOLEAN:
          case JavaLexer.BYTE:
          case JavaLexer.CHAR:
          case JavaLexer.DOUBLE:
          case JavaLexer.ENUM:
          case JavaLexer.FLOAT:
          case JavaLexer.INT:
          case JavaLexer.LONG:
          case JavaLexer.SHORT:
            get(EditorColorScheme.javakeyword, line, column, result);
            classNamePrevious = true;
            break;
          case JavaLexer.BLOCK_COMMENT:
          case JavaLexer.LINE_COMMENT:
            result.addIfNeeded(line, column, EditorColorScheme.COMMENT);
            break;
          case JavaLexer.AT:
            result.addIfNeeded(line, column, EditorColorScheme.Ninja);
            break;
          case JavaLexer.IDENTIFIER:
            {
              info.addIdentifier(token.getText());
              boolean isBold, isItalic, isUnderLineMode = false;
              boolean isDot = true;

              int colorid = EditorColorScheme.TEXT_NORMAL;
              if (previous == JavaLexer.AT) {
                colorid = EditorColorScheme.Ninja;
              }
              if (previous == JavaLexer.CLASS
                  || previous == JavaLexer.IMPLEMENTS
                  || previous == JavaLexer.VOID) {
                colorid = EditorColorScheme.javafun;
              }

              if (previous == JavaLexer.LBRACK || previous == JavaLexer.ASSERT) {
                colorid = EditorColorScheme.LITERAL;
              }
              if (previous == JavaLexer.PACKAGE
                  || previous == JavaLexer.IMPORT
                  || prePreToken != null && prePreToken.getType() == JavaLexer.DOT
                  || previous == JavaLexer.DOT) {
                isDot = false;
                colorid = EditorColorScheme.javafield;
              }

              if (previous == JavaLexer.EXTENDS
                  || previous == JavaLexer.FLOAT_LITERAL
                  || previous == JavaLexer.BOOLEAN) {
                colorid = EditorColorScheme.javafun;
              }
              if (previous == JavaLexer.RETURN  || previous == JavaLexer.NEW) {
                colorid = EditorColorScheme.HTML_TAG;
              }
              if (previous == JavaLexer.INT) {
                colorid = EditorColorScheme.javafield;
              }
              if (previous == JavaLexer.CASE || previous == JavaLexer.FINAL) {
                colorid = EditorColorScheme.ATTRIBUTE_NAME;
              }

              if (previous == JavaLexer.PRIVATE
                  || previous == JavaLexer.PROTECTED
                  || previous == JavaLexer.PUBLIC) {
                colorid = EditorColorScheme.HTML_TAG;
              }
              if (text1.matches("([A-Za-z]*)(Exception)([a-zA-Z]*)")) {
                colorid = EditorColorScheme.javatype;
              }
              if (text1.matches("([A-Za-z]*)(Exception)([a-zA-Z]*)(\\s\\w+)")) {
                colorid = EditorColorScheme.javatype;
                Span span = Span.obtain(column, TextStyle.makeStyle(EditorColorScheme.javatype));
                span.setBackgroundColorMy(Color.parseColor("#F40000"));
                // #1BF40000
                span.setDrawminiText("Exception Handler");

                result.add(line, span);
              }
              if (previous == JavaLexer.LPAREN
                  || prePreToken != null && prePreToken.getType() == JavaLexer.LPAREN
                  || previous == JavaLexer.RPAREN
                  || prePreToken != null && prePreToken.getType() == JavaLexer.RPAREN) {

                colorid = EditorColorScheme.javaparament;
              }
              if (previous == JavaLexer.LT
                  || prePreToken != null && prePreToken.getType() == JavaLexer.LT
                  || previous == JavaLexer.GT
                  || prePreToken != null && prePreToken.getType() == JavaLexer.GT) {
                colorid = EditorColorScheme.javafun;
              }

              if (token.getText().equals("System")) {
                Span span = Span.obtain(column, TextStyle.makeStyle(EditorColorScheme.javafun));
                span.setBackgroundColorMy(Color.BLACK);
                span.setDrawminiText("System::");
                result.add(line, span);
              }

              get(colorid, line, column, result);
              break;
            }

          case JavaLexer.RBRACE:
            {
              if (!stack.isEmpty()) {
                BlockLine b = stack.pop();
                b.endLine = line;
                b.endColumn = column;
                if (b.startLine != b.endLine) {
                  result.addBlockLine(b); // اضافه کردن بلوک به نتایج
                }
              }
              var lists = result.getBlocks();
              int colorid = EditorColorScheme.TEXT_NORMAL;
              result.addIfNeeded(line, column, colorid);
              break;
            }

          case JavaLexer.LBRACE:
            {
              BlockLine block = result.obtainNewBlock();
              block.startLine = line;
              block.startColumn = column;
              stack.push(block); // اضافه کردن بلوک به استک
              var lists = result.getBlocks();
              int colorid = EditorColorScheme.TEXT_NORMAL;
              result.addIfNeeded(line, column, colorid);
              // بررسی maxSwitch
              if (stack.isEmpty()) {
                if (currSwitch > maxSwitch) {
                  maxSwitch = currSwitch;
                }
                currSwitch = 0; 
              }
              currSwitch++; // ا 
              break;
            }

          default:
            result.addIfNeeded(line, column, EditorColorScheme.TEXT_NORMAL);
            break;
        }

        if (type != JavaLexer.WS) {
          if (preToken != null) {
            prePreToken = preToken;
          }
          preToken = token;
        }

        if (type != JavaLexer.WS) {
          previous = type;
        }
        first = false;
      }
      info.finish();

      JavaCodeA code = new JavaCodeA();
      code.analyze(content, result, delegate);

      result.determine(lastLine);
      result.setExtra(info);

      var cu = StaticJavaParser.parse(content.toString());
      Set<String> declaredVariables = new HashSet<>();
      Set<String> usedVariables = new HashSet<>();
      Set<String> unusedImport = new HashSet<>();
      Set<String> mtcall = new HashSet<>();
      Map<String, Integer> mlines = new HashMap<>();
      Map<String, Integer> mcoloum = new HashMap<>();
      Map<String, Integer> inline = new HashMap<>();
      Map<String, Integer> incol = new HashMap<>();

      cu.accept(
          new VoidVisitorAdapter<Void>() {
            @Override
            public void visit(FieldDeclaration fieldDeclaration, Void arg) {
              for (VariableDeclarator variable : fieldDeclaration.getVariables()) {
                String variableName = variable.getNameAsString();
                int line = variable.getBegin().get().line;
                int column = variable.getBegin().get().column;
                declaredVariables.add(variableName);
                inline.put(variableName, line);
                incol.put(variableName, column);
              }
              super.visit(fieldDeclaration, arg);
            }

            @Override
            public void visit(VariableDeclarationExpr variableDeclarationExpr, Void arg) {
              for (VariableDeclarator variable : variableDeclarationExpr.getVariables()) {
                String variableName = variable.getNameAsString();
                int line = variable.getBegin().get().line;
                int column = variable.getBegin().get().column;
                declaredVariables.add(variableName);
                inline.put(variableName, line);
                incol.put(variableName, column);
              }
              super.visit(variableDeclarationExpr, arg);
            }

            @Override
            public void visit(NameExpr nameExpr, Void arg) {
              usedVariables.add(nameExpr.getNameAsString());
              super.visit(nameExpr, arg);
            }

            @Override
            public void visit(ImportDeclaration dec, Void arg) {
              String importName = dec.getNameAsString();
              int line = dec.getBegin().get().line;
              int column = dec.getBegin().get().column;
              inline.put(importName, line);
              incol.put(importName, column);
              unusedImport.add(importName);
              super.visit(dec, arg);
            }

            @Override
            public void visit(ObjectCreationExpr objectCreationExpr, Void arg) {
              String className = objectCreationExpr.getType().getNameAsString();
              usedVariables.add(className);
              super.visit(objectCreationExpr, arg);
            }

            @Override
            public void visit(TypeExpr arg0, Void arg1) {
              var l = arg0.getBegin().get().line;
              var c = arg0.getBegin().get().column;
              Utils.setSpanEFO(result, l, c + 1, EditorColorScheme.javastring);
              super.visit(arg0, arg1);
            }

            @Override
            public void visit(TypeParameter arg0, Void arg1) {
              var l = arg0.getBegin().get().line;
              var c = arg0.getBegin().get().column;
              Utils.setSpanEFO(result, l, c + 1, EditorColorScheme.javatype);
              super.visit(arg0, arg1);
            }

            @Override
            public void visit(MethodCallExpr arg0, Void arg1) {
              String names = arg0.getNameAsString();
              mtcall.add(names);

              var li = arg0.getBegin().get().line;
              var col = arg0.getBegin().get().column;
              mlines.put(names, li);
              mcoloum.put(names, col);

              // Utils.setSpanEFO(result, li, col + 2, EditorColorScheme.COMMENT);

              super.visit(arg0, arg1);
            }
          },
          null);
      unusedImport.removeIf(importName -> usedVariables.contains(getSimpleName(importName)));
      declaredVariables.removeAll(usedVariables);

      for (var it : unusedImport) {
        var myline = inline.get(it);
        var mycol = incol.get(it);
        Utils.setSpanEFO(
            result, myline.intValue(), mycol.intValue() + it.length(), EditorColorScheme.COMMENT);
      }

      for (var unusedVar : declaredVariables) {
        var lines = inline.get(unusedVar);
        var col = incol.get(unusedVar);
        Utils.setSpanEFO(
            result,
            lines.intValue(),
            col.intValue() + unusedVar.length(),
            EditorColorScheme.COMMENT);
      }
      for (var it : mtcall) {
        var li = mlines.get(it);
        var col = mcoloum.get(it);
        Utils.setSpanEFO(result, li, col + 2, EditorColorScheme.javaoprator);
      }

    } catch (IOException e) {
      e.printStackTrace();
      Log.e("TAG", e.getMessage());
    }
  }

  private String getSimpleName(String importName) {
    return importName.substring(importName.lastIndexOf('.') + 1);
  }

  long withoutCompletion(int id) {
    return TextStyle.makeStyle(id, 0, true, false, false);
  }

  long forString() {
    return TextStyle.makeStyle(EditorColorScheme.LITERAL, 0, true, true, false);
  }

  private void get(int color, int line, int col, TextAnalyzeResult result) {
    mapStyle = new HashMap<>();
    mapStyle =
        new Gson()
            .fromJson(
                ThemeUtils.setReloadStyle(), new TypeToken<Map<String, Boolean>>() {}.getType());

    result.addIfNeeded(
        line,
        col,
        TextStyle.makeStyle(
            color,
            0,
            mapStyle.get("isBold").booleanValue(),
            mapStyle.get("isItalic").booleanValue(),
            mapStyle.get("isStrike").booleanValue(),
            mapStyle.get("isLine").booleanValue()));
  }

  
}
