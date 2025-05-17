package io.github.rosemoe.sora.langs.java;

import android.os.Handler;
import android.os.Looper;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.type.Type;
import io.github.rosemoe.sora.model.Inlay;
import io.github.rosemoe.sora.widget.ListCss3Color;
import io.github.rosemoe.sora.widget.TextSummry.HTMLConstants;
import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import ir.ninjacoder.ghostide.IdeEditor;
import ir.ninjacoder.ghostide.config.JavaPaserUtils;
import ir.ninjacoder.ghostide.utils.ThemeUtils;
import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
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
import android.util.Log;
import io.github.rosemoe.sora.data.Span;
import io.github.rosemoe.sora.text.TextStyle;
import java.lang.ref.WeakReference;
import java.util.HashMap;
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
  private static final Object OBJECT = new Object();
  private Map<String, Boolean> mapStyle;

  public JavaCodeAnalyzer(IdeEditor editor) {
    mEditorReference = new WeakReference<>(editor);
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

      Stack<BlockLine> stack = new Stack<>();
      TrieTree<Object> tree = new TrieTree<>();
      int type, currSwitch = 1, maxSwitch = 0, previous = 0;
      int lastLine = 1;
      int line, column;

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
              get(EditorColorScheme.red, line, column, result);
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
            //  case JavaLexer.BLOCK_COMMENT:
          case JavaLexer.LINE_COMMENT:
            if (previous == JavaLexer.AT) {
              result.addIfNeeded(
                  line,
                  column,
                  TextStyle.makeStyle(EditorColorScheme.javafield, 0, false, true, false));
            }
            result.addIfNeeded(line, column, EditorColorScheme.COMMENT);
            break;
          case JavaLexer.AT:
            result.addIfNeeded(line, column, EditorColorScheme.Ninja);
            break;
          case JavaLexer.IDENTIFIER:
            {
              info.addIdentifier(token.getText());

              boolean isDot = true;

              int colorid = EditorColorScheme.TEXT_NORMAL;
              if (previous == JavaLexer.AT) {
                colorid = EditorColorScheme.javastring;
              }
              if (previous == JavaLexer.CLASS
                  || previous == JavaLexer.IMPLEMENTS
                  || previous == JavaLexer.VOID) {
                colorid = EditorColorScheme.javafun;
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
              if (previous == JavaLexer.RETURN || previous == JavaLexer.NEW) {
                colorid = EditorColorScheme.javatype;
              }
              if (previous == JavaLexer.INT) {
                colorid = EditorColorScheme.javafield;
              }
              if (previous == JavaLexer.CASE || previous == JavaLexer.FINAL) {
                colorid = EditorColorScheme.javaoprator;
              }

              if (previous == JavaLexer.PRIVATE
                  || previous == JavaLexer.PROTECTED
                  || previous == JavaLexer.PUBLIC) {
                colorid = EditorColorScheme.javafield;
              }
              if (token.getText().equals("main")) {
                colorid = EditorColorScheme.green;
              }
              if (token.getText().equals("author")) {
                colorid = EditorColorScheme.red;
              }
              get(colorid, line, column, result);

              break;
            }

          case JavaLexer.HEX_LITERAL:
            ListCss3Color.setColorBinery(token, line, column, result);
            break;

          case JavaLexer.RBRACE:
            {
              if (!stack.isEmpty()) {
                BlockLine b = stack.pop();
                b.endLine = line;
                b.endColumn = column;
                if (b.startLine != b.endLine) {
                  result.addBlockLine(b);
                }
              }
              var lists = result.getBlocks();
              var colorid = EditorColorScheme.htmlblocknormal;

              if (GhostIdeAppLoader.getPrefManager().getBoolean("breaks", false) == true)
                colorid = HTMLConstants.get(stack.size());
              else colorid = EditorColorScheme.htmlblocknormal;
              result.addIfNeeded(line, column, colorid);
              break;
            }

          case JavaLexer.LBRACE:
            {
              BlockLine block = result.obtainNewBlock();
              block.startLine = line;
              block.startColumn = column;
              // اضافه کردن بلوک به استک
              var lists = result.getBlocks();
              var colorres = EditorColorScheme.htmlblocknormal;
              if (GhostIdeAppLoader.getPrefManager().getBoolean("breaks", false) == true)
                colorres = HTMLConstants.get(stack.size());
              else colorres = EditorColorScheme.htmlblocknormal;
              stack.push(block);
              result.addIfNeeded(line, column, colorres);
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

      // fast read();

      try {
        if (GhostIdeAppLoader.getAnalyzercod().getBoolean("Analyzercod", false) == true) {

          ParserConfiguration config = new ParserConfiguration();
          config.setLanguageLevel(ParserConfiguration.LanguageLevel.BLEEDING_EDGE);
          StaticJavaParser.setConfiguration(config);
          var cu = StaticJavaParser.parse(content.toString());
          Set<String> declaredVariables = new HashSet<>();
          Set<String> usedVariables = new HashSet<>();
          Set<String> unusedImport = new HashSet<>();
          Set<String> mtcall = new HashSet<>();
          Set<String> mtusing = new HashSet<>();
          Map<String, Integer> mlines = new HashMap<>();
          Map<String, Integer> mcoloum = new HashMap<>();
          Map<String, Integer> inline = new HashMap<>();
          Map<String, Integer> incol = new HashMap<>();
          Map<String, Integer> varLines = new HashMap<>(); // خطوط تعریف متغیرها
          Map<String, Integer> varColumns = new HashMap<>(); // ستون‌های تعریف متغیرها

          cu.accept(
              new VoidVisitorAdapter<Void>() {

                @Override
                public void visit(VariableDeclarationExpr variableDeclarationExpr, Void arg) {
                  for (VariableDeclarator variable : variableDeclarationExpr.getVariables()) {
                    String variableName = variable.getNameAsString();
                    int line = variable.getBegin().get().line;
                    int column = variable.getBegin().get().column;
                    declaredVariables.add(variableName);
                    try {
                      new Handler(Looper.getMainLooper())
                          .postDelayed(
                              () -> {
                                if (variableName.equals("author")) {
                                  editor.addInlay(
                                      new Inlay(line, column, "user", EditorColorScheme.COLOR_TIP));
                                }
                              },
                              2000);
                    } catch (Exception err) {
                      Log.e("Error run time -> ", err.getLocalizedMessage());
                    }
                    inline.put(variableName, line);
                    incol.put(variableName, column);
                    varLines.put(variableName, line);
                    varColumns.put(variableName, column);
                    Utils.setSpanEFO(
                        result,
                        variable.getType().getBegin().get().line,
                        variable.getType().getBegin().get().column,
                        EditorColorScheme.javafield);
                    if (JavaPaserUtils.getRegexAnnotation(variableDeclarationExpr.getAnnotations()))
                      Utils.setWaringSpan(result, line, column, EditorColorScheme.green);
                  }

                  super.visit(variableDeclarationExpr, arg);
                }

                @Override
                public void visit(NameExpr nameExpr, Void arg) {
                  String varName = nameExpr.getNameAsString();
                  usedVariables.add(varName);
                  super.visit(nameExpr, arg);
                }

                @Override
                public void visit(ImportDeclaration dec, Void arg) {
                  String importName = dec.getNameAsString();
                  int line = dec.getBegin().get().line - 1;
                  int column = dec.getBegin().get().column;
                  inline.put(importName, line);
                  incol.put(importName, column);
                  unusedImport.add(importName);
                  result.addIfNeeded(
                      line,
                      column,
                      TextStyle.makeStyle(EditorColorScheme.javafun, 0, true, false, false));
                  super.visit(dec, arg);
                }

                @Override
                public void visit(ObjectCreationExpr objectCreationExpr, Void arg) {
                  String className = objectCreationExpr.getType().getNameAsString();
                  usedVariables.add(className);
                  super.visit(objectCreationExpr, arg);
                }

                @Override
                public void visit(MethodDeclaration methodDecl, Void arg1) {
                  // ذخیره نام متد و موقعیت آن (مثل قبل)
                  String methodName = methodDecl.getNameAsString();
                  int line = methodDecl.getBegin().get().line; // خط (بر اساس 0)
                  int col = methodDecl.getBegin().get().column; // ستون شروع متد
                  mtusing.add(methodName);
                  inline.put(methodName, line);
                  incol.put(methodName, col);

                  // رنگ‌آمیزی نوع برگشتی متد (مثل 'void', 'int', 'String')
                  Type returnType = methodDecl.getType();
                  int returnTypeStartLine = returnType.getBegin().get().line - 1;
                  int returnTypeStartCol = returnType.getBegin().get().column;
                  String returnTypeName = returnType.asString();

                  Utils.setSpanEFO(
                      result,
                      returnTypeStartLine,
                      returnTypeStartCol,
                      EditorColorScheme.javatype, // رنگ نوع برگشتی
                      true, // پررنگ
                      false // زیرخط دار نباشد
                      );

                  // رنگ‌آمیزی نام متد
                  String methodName1 = methodDecl.getNameAsString();
                  int nameStartLine1 = methodDecl.getName().getBegin().get().line - 1;
                  int nameStartCol1 = methodDecl.getName().getBegin().get().column;

                  Utils.setSpanEFO(
                      result,
                      nameStartLine1,
                      nameStartCol1,
                      EditorColorScheme.javafield, // رنگ نام متد
                      false, // پررنگ نباشد
                      true // زیرخط دار باشد
                      );
                  // بررسی Deprecated (مثل قبل)
                  if (JavaPaserUtils.getDeprecated(methodDecl.getAnnotations())) {
                    Utils.setWaringSpan(result, line, col + 1);
                  }

                  // رنگ‌آمیزی پارامترهای متد
                  for (var param : methodDecl.getParameters()) {
                    // استخراج نوع پارامتر (مثل `int`, `File`, `String`)
                    Type paramType = param.getType();
                    String typeName = paramType.toString();
                    int typeStartLine = paramType.getBegin().get().line; // خط نوع (بر اساس 0)
                    int typeStartCol = paramType.getBegin().get().column; // ستون شروع نوع
                    int[] id =
                        Utils.setSpanEFO(
                            result,
                            typeStartLine,
                            typeStartCol,
                            EditorColorScheme.javatype,
                            true,
                            false);
                    int nameStartLine = param.getName().getBegin().get().line; // خط نام (بر اساس 0)
                    int nameStartCol = param.getName().getBegin().get().column;
                    Utils.setSpanStyle(
                        result,
                        nameStartLine,
                        nameStartCol,
                        EditorColorScheme.javaparament,
                        false,
                        true);
                  }

                  super.visit(methodDecl, arg1); // ادامه بازدید از فرزندان (مثل بدنه متد)
                }

                @Override
                public void visit(ConstructorDeclaration arg0, Void arg1) {
                  int lines = arg0.getBegin().get().line;
                  int colz = arg0.getBegin().get().column;
                  if (JavaPaserUtils.getDeprecated(arg0.getAnnotations()))
                    Utils.setWaringSpan(result, lines, colz + 1);
                  if (JavaPaserUtils.getCustomAnnotationExpr(arg0.getAnnotations(), "NonNull"))
                    Utils.setWaringSpan(result, lines, colz + 1, EditorColorScheme.HTML_TAG);

                  super.visit(arg0, arg1);
                }

                @Override
                public void visit(BlockStmt arg0, Void arg1) {
                  if (arg0.getStatements().isEmpty()) {
                    var lines1 = arg0.getBegin().get().line;
                    var columns1 = arg0.getBegin().get().column;
                    Utils.setWaringSpan(
                        result, lines1, columns1 + 1, EditorColorScheme.javakeyword);
                  }
                  super.visit(arg0, arg1);
                }

                @Override
                public void visit(JavadocComment arg0, Void arg1) {
                  var i = arg0.getBegin().get().line;
                  var c = arg0.getBegin().get().column;
                  Utils.setSpanEFO(result, i, c, EditorColorScheme.COMMENT);

                  super.visit(arg0, arg1);
                }

                @Override
                public void visit(FieldDeclaration arg0, Void arg1) {
                  for (VariableDeclarator it : arg0.getVariables()) {
                    var fieldType = it.getType();
                    int typeStartLine = fieldType.getBegin().get().line - 1;
                    int typeStartCol = fieldType.getBegin().get().column;
                    var fieldName = it.getName();
                    int nameLine = fieldName.getBegin().get().line - 1;
                    int nameCol = fieldName.getBegin().get().column;
                    result.addIfNeeded(typeStartLine, typeStartCol, EditorColorScheme.javatype);
                    // رنگ‌آمیزی نوع فیلد
                    // Utils.setSpanEFO(
                    // result,
                    // typeStartLine,
                    // typeStartCol,
                    // EditorColorScheme.javatype,
                    // true,
                    // false);

                    // رنگ‌آمیزی نام فیلد
                    Utils.setSpanEFO(
                        result,
                        nameLine,
                        nameCol, // پایان ستون نام
                        EditorColorScheme.javafield,
                        false,
                        true);
                  }
                }
              },
              null);
          Set<String> unusedVariables = new HashSet<>(declaredVariables);
          unusedVariables.removeAll(usedVariables);

          for (String varName : unusedVariables) {
            int line32 = varLines.get(varName);
            int column32 = varColumns.get(varName);
            Utils.setWaringSpan(result, line32, column32);
          }

          unusedImport.removeIf(importName -> usedVariables.contains(getSimpleName(importName)));
          declaredVariables.removeAll(usedVariables);

          for (var it : unusedImport) {
            var myline = inline.get(it);
            var mycol = incol.get(it);
            Utils.setSpanEFO(
                result,
                myline.intValue(),
                mycol.intValue() + it.length(),
                EditorColorScheme.COMMENT,
                false,
                true);
          }
        }

        Log.d("text:-> ", result.getText());
      } catch (Exception err) {

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
