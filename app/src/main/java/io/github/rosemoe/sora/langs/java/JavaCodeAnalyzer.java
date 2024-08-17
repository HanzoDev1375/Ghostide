package io.github.rosemoe.sora.langs.java;


import Ninja.coder.Ghostemane.code.IdeEditor;
import Ninja.coder.Ghostemane.code.databin.DiagnosticWrapper;
import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import io.github.rosemoe.sora.util.TrieTree;
import java.util.ArrayList;
import io.github.rosemoe.sora.text.CharPosition;
import android.util.Log;
import io.github.rosemoe.sora.data.Span;
import io.github.rosemoe.sora.text.Indexer;
import io.github.rosemoe.sora.text.TextStyle;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Random;
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
import org.openjdk.javax.tools.Diagnostic;

public class JavaCodeAnalyzer implements CodeAnalyzer {

  private final WeakReference<IdeEditor> mEditorReference;
  private final List<DiagnosticWrapper> mDiagnostics;
  private static final Object OBJECT = new Object();
  private Set<Integer> usedColors = new HashSet<>();

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
      JavaAutoComplete auto = new JavaAutoComplete();
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
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.KEYWORD, 0, true, false, false, false));
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
            result.addIfNeeded(line, column, EditorColorScheme.LITERAL);
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
            result.addIfNeeded(line, column, EditorColorScheme.OPERATOR);
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
            result.addIfNeeded(line, column, EditorColorScheme.ATTRIBUTE_VALUE);
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
              int colorid = EditorColorScheme.TEXT_NORMAL;
              if (previous == JavaLexer.AT) {
                colorid = EditorColorScheme.Ninja;
              }
              if (previous == JavaLexer.CLASS) {
                colorid = EditorColorScheme.AUTO_COMP_PANEL_CORNER;
              }
              if (previous == JavaLexer.LBRACK
                  || previous == JavaLexer.DOT
                  || prePreToken != null && prePreToken.getType() == JavaLexer.DOT
                  || previous == JavaLexer.ASSERT
                  || previous == JavaLexer.PACKAGE
                  || previous == JavaLexer.IMPORT) {
                colorid = EditorColorScheme.LITERAL;
              }
              if (previous == JavaLexer.VOID
                  || previous == JavaLexer.EXTENDS
                  || previous == JavaLexer.FLOAT_LITERAL
                  || previous == JavaLexer.BOOLEAN) {
                colorid = getRandomColor();
              }
              if (previous == JavaLexer.RETURN || previous == JavaLexer.NEW) {
                colorid = EditorColorScheme.HTML_TAG;
              }
              if (previous == JavaLexer.INT) {
                colorid = EditorColorScheme.LITERAL;
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
                colorid = EditorColorScheme.BLOCK_LINE;
              }
              if (text1.matches("([A-Za-z]*)(Exception)([a-zA-Z]*)(\\s\\w+)")) {
                colorid = EditorColorScheme.Ninja;
              }
              if (previous == JavaLexer.COMMA || previous == JavaLexer.ASSIGN) {
                colorid = EditorColorScheme.OPERATOR;
              }

              /// test
              result.addIfNeeded(line, column, colorid);
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
              int colorid = EditorColorScheme.OPERATOR;
              for (int i = 1; i < lists.size(); ++i) {
                if (i == 1) {
                  colorid = EditorColorScheme.OPERATOR;
                } else if (i == 2) {
                  colorid = EditorColorScheme.Ninja;
                } else if (i == 3) {
                  colorid = EditorColorScheme.HTML_TAG;
                } else {
                  continue;
                }
              }
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
              int colorid = EditorColorScheme.OPERATOR;
              for (int i = 1; i < lists.size(); ++i) {
                if (i == 1) {
                  colorid = EditorColorScheme.OPERATOR;
                } else if (i == 2) {
                  colorid = EditorColorScheme.Ninja;
                } else if (i == 3) {
                  colorid = EditorColorScheme.HTML_TAG;
                } else {
                  continue;
                }
              }
              result.addIfNeeded(line, column, colorid);
              // بررسی maxSwitch
              if (stack.isEmpty()) {
                if (currSwitch > maxSwitch) {
                  maxSwitch = currSwitch;
                }
                currSwitch = 0; // بازنشانی شمارش برای سطح بعدی
              }
              currSwitch++; // افزایش شمارنده برای سطح nesting فعلی
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
      code.analyze(content,result,delegate);
      result.determine(lastLine);
      result.setExtra(info);

    } catch (IOException e) {
      e.printStackTrace();
      Log.e("TAG", e.getMessage());
    }
  }

  public long withoutCompletion(int id) {
    return TextStyle.makeStyle(id, 0, true, false, false);
  }

  public long forString() {
    return TextStyle.makeStyle(EditorColorScheme.LITERAL, 0, true, true, false);
  }

  public static void markDiagnostics(
      IdeEditor editor, List<DiagnosticWrapper> diagnostics, TextAnalyzeResult colors) {
    editor.getText().beginStreamCharGetting(0);
    Indexer indexer = editor.getText().getIndexer();

    diagnostics.forEach(
        it -> {
          try {
            int startLine;
            int startColumn;
            int endLine;
            int endColumn;
            if (it.getPosition() != DiagnosticWrapper.USE_LINE_POS) {
              if (it.getStartPosition() == -1) {
                it.setStartPosition(it.getPosition());
              }
              if (it.getEndPosition() == -1) {
                it.setEndPosition(it.getPosition());
              }
              CharPosition start = indexer.getCharPosition((int) it.getStartPosition());
              CharPosition end = indexer.getCharPosition((int) it.getEndPosition());

              int sLine = start.line;
              int sColumn = start.column;
              int eLine = end.line;
              int eColumn = end.column;

              // the editor does not support marking underline spans for the same start and end
              // index
              // to work around this, we just subtract one to the start index
              if (sLine == eLine && eColumn == sColumn) {
                sColumn--;
                eColumn++;
              }

              it.setStartLine(sLine);
              it.setEndLine(eLine);
              it.setStartColumn(sColumn);
              it.setEndColumn(eColumn);
            }
            startLine = it.getStartLine();
            startColumn = it.getStartColumn();
            endLine = it.getEndLine();
            endColumn = it.getEndColumn();

            int flag = it.getKind() == Diagnostic.Kind.ERROR ? Span.FLAG_ERROR : Span.FLAG_WARNING;
            colors.markProblemRegion(flag, startLine, startColumn, endLine, endColumn);
          } catch (IllegalArgumentException | IndexOutOfBoundsException e) {

          }
        });
    editor.getText().endStreamCharGetting();
  }

  public int getRandomColor() {
    int[] colors = {EditorColorScheme.OPERATOR, EditorColorScheme.KEYWORD};
    Random random = new Random();
    int color = colors[random.nextInt(colors.length)];
    return color;
  }
}
