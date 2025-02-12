package io.github.rosemoe.sora.langs.python;

import io.github.rosemoe.sora.data.Span;
import ir.ninjacoder.ghostide.IdeEditor;
import android.graphics.Color;
import android.util.Log;

import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.ListCss3Color;
import java.util.List;
import io.github.rosemoe.sora.data.NavigationItem;
import java.util.ArrayList;
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

public class PythonCodeAnalyzer implements CodeAnalyzer {

  private PythonErrorManager errors;
  protected IdeEditor editor;

  public PythonCodeAnalyzer(IdeEditor editor) {
    this.editor = editor;
  }

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    try {

      CodePointCharStream stream = CharStreams.fromReader(new StringReader(content.toString()));
      var lexer = new PythonLexer(stream);
      var auto = new PythonAutoComplete();
      auto.setKeywords(PythonLang.keywords);
      var info = new PythonAutoComplete.Identifiers();
      info.begin();
      errors = new PythonErrorManager(editor);
      var classNamePrevious = false;
      Token token, preToken = null, prePreToken = null;
      boolean first = true;
      Stack<BlockLine> stack = new Stack<>();
      List<NavigationItem> labels = new ArrayList<>();
      int type, currSwitch = 1, maxSwitch = 0, previous = -1;
      int lastLine = 1;
      int line, column;
      var prevIsTagName = false;

      while (delegate.shouldAnalyze()) {
        token = lexer.nextToken();
        if (token == null) break;
        if (token.getType() == PythonLexer.EOF) {
          lastLine = token.getLine() - 1;
          break;
        }
        line = token.getLine() - 1;
        type = token.getType();
        column = token.getCharPositionInLine();
        if (type == PythonLexer.EOF) {
          lastLine = line;
          break;
        }

        switch (type) {
          case PythonLexer.WS:
            //   case PythonLexer.NEWLINE:
            if (first) {
              result.addNormalIfNull();
            }
            break;
          case PythonLexer.AND:
          case PythonLexer.AS:
          case PythonLexer.ASYNC:
          case PythonLexer.AWAIT:
          case PythonLexer.BREAK:
          case PythonLexer.CLASS:
          case PythonLexer.CONTINUE:
          case PythonLexer.DEF:
          case PythonLexer.DEL:
          case PythonLexer.ELIF:
          case PythonLexer.ELSE:
          case PythonLexer.EXCEPT:
          case PythonLexer.FALSE:
          case PythonLexer.FINALLY:
          case PythonLexer.FOR:
          case PythonLexer.GLOBAL:
          case PythonLexer.IF:
          case PythonLexer.IMPORT:
          case PythonLexer.IN:
          case PythonLexer.IS:
          case PythonLexer.RAISE:
          case PythonLexer.RETURN:
          case PythonLexer.TRUE:
          case PythonLexer.TRY:
          case PythonLexer.WITH:
          case PythonLexer.YIELD:
          case PythonLexer.FROM:
          case PythonLexer.WHILE:
          case PythonLexer.ASSERT:
          case PythonLexer.LAMBDA:
          case PythonLexer.NONE:
          case PythonLexer.NONLOCAL:
          case PythonLexer.NOT:
          case PythonLexer.OR:
          case PythonLexer.PASS:
            
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.pykeyword, 0, true, false, false));
            break;
          case PythonLexer.DOT:

          case PythonLexer.STAR:
          case PythonLexer.COMMA:
          case PythonLexer.LBRACE:
          case PythonLexer.RBRACE:
          case PythonLexer.LPAR:
          case PythonLexer.LSQB:
          case PythonLexer.RPAR:
          case PythonLexer.RSQB:
          case PythonLexer.VBAR:
          case PythonLexer.EQUAL:
          case PythonLexer.PERCENT:
          case PythonLexer.EQEQUAL:
          case PythonLexer.NOTEQUAL:
          case PythonLexer.LESSEQUAL:
          case PythonLexer.GREATEREQUAL:
          case PythonLexer.TILDE:
          case PythonLexer.CIRCUMFLEX:
          case PythonLexer.LEFTSHIFT:
          case PythonLexer.RIGHTSHIFT:
          case PythonLexer.DOUBLESTAR:
          case PythonLexer.PLUSEQUAL:
          case PythonLexer.MINEQUAL:
          case PythonLexer.STAREQUAL:
          case PythonLexer.SLASHEQUAL:
          case PythonLexer.PERCENTEQUAL:
          case PythonLexer.AMPEREQUAL:
          case PythonLexer.VBAREQUAL:
          case PythonLexer.CIRCUMFLEXEQUAL:
          case PythonLexer.LEFTSHIFTEQUAL:
          case PythonLexer.RIGHTSHIFTEQUAL:
          case PythonLexer.DOUBLESTAREQUAL:
          case PythonLexer.DOUBLESLASH:
          case PythonLexer.DOUBLESLASHEQUAL:
          case PythonLexer.AT:
          case PythonLexer.ATEQUAL:
          case PythonLexer.RARROW:
          case PythonLexer.ELLIPSIS:
          case PythonLexer.COLONEQUAL:
          case PythonLexer.EXCLAMATION:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.pysymbol, 0, true, false, false));
            break;

          case PythonLexer.STRING:
            int colors = EditorColorScheme.pystring;
            result.addIfNeeded(line, column, TextStyle.makeStyle(colors, 0, true, false, false));
            break;
          case PythonLexer.NUMBER:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.pynumber, 0, true, false, false));
            break;
          case PythonLexer.NAME:
            {
              int colorid = EditorColorScheme.TEXT_NORMAL;
              boolean isBold = false;
              boolean isUnderLine = false;
              info.addIdentifier(token.getText());
              if (previous == PythonLexer.CLASS) {
                colorid = EditorColorScheme.pycolormatch1;
                isBold = true;
                isUnderLine = false;
              }
              if (previous == PythonLexer.DEF) {
                colorid = EditorColorScheme.pycolormatch2;
              }
              if (previous == PythonLexer.IF) {
                colorid = EditorColorScheme.pycolormatch3;
                isBold = true;
                isUnderLine = false;
              }
              if (previous == PythonLexer.FROM) {
                colorid = EditorColorScheme.pycolormatch3;
                isBold = false;
                isUnderLine = false;
              }
              if (previous == PythonLexer.IMPORT) {
                colorid = EditorColorScheme.pycolormatch3;
                isBold = false;
                isUnderLine = false;
              }
              if (previous == PythonLexer.EQUAL) {
                colorid = EditorColorScheme.pycolormatch1;
                isUnderLine = false;
                isBold = true;
              }
              if (previous == PythonLexer.OR
                  || previous == PythonLexer.DOT
                  || previous == PythonLexer.RETURN
                  || previous == PythonLexer.YIELD
                  || previous == PythonLexer.COLON) {
                colorid = EditorColorScheme.pycolormatch2;
                isBold = true;
                isUnderLine = false;
              }

              result.addIfNeeded(
                  line, column, TextStyle.makeStyle(colorid, 0, isBold, false, false, isUnderLine));
              break;
            }

          case PythonLexer.COMMENT:
            result.addIfNeeded(line, column, EditorColorScheme.COMMENT);
            break;

          default:
            result.addIfNeeded(line, column, EditorColorScheme.TEXT_NORMAL);
            prevIsTagName = false;
            classNamePrevious = false;
            break;
        }

        first = false;
        if (type != PythonLexer.WS) {
          previous = type;
        }
      }
      info.finish();
      result.setExtra(info);
      result.determine(lastLine);
      // error manager not work
      errors.analyze(content, result, delegate);
      result.setSuppressSwitch(maxSwitch + 10);
      result.setNavigation(labels);
    } catch (IOException e) {
      e.printStackTrace();
      Log.e("TAG", e.getMessage());
    }
  }

  public long Bold() {
    return TextStyle.makeStyle(EditorColorScheme.ATTRIBUTE_VALUE, 0, true, false, false);
  }

  public long Italic() {
    return TextStyle.makeStyle(EditorColorScheme.ATTRIBUTE_NAME, 0, false, true, false);
  }
}
