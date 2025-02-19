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
      var lexer = new PythonLexerCompat(stream);
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
        if (token.getType() == PythonLexerCompat.EOF) {
          lastLine = token.getLine() - 1;
          break;
        }
        line = token.getLine() - 1;
        type = token.getType();
        column = token.getCharPositionInLine();
        if (type == PythonLexerCompat.EOF) {
          lastLine = line;
          break;
        }

        switch (type) {
          case PythonLexerCompat.WS:
            //   case PythonLexerCompat.NEWLINE:
            if (first) {
              result.addNormalIfNull();
            }
            break;
          case PythonLexerCompat.AND:
          case PythonLexerCompat.AS:
          case PythonLexerCompat.ASYNC:
          case PythonLexerCompat.AWAIT:
          case PythonLexerCompat.BREAK:
          case PythonLexerCompat.CLASS:
          case PythonLexerCompat.CONTINUE:
          case PythonLexerCompat.DEF:
          case PythonLexerCompat.DEL:
          case PythonLexerCompat.ELIF:
          case PythonLexerCompat.ELSE:
          case PythonLexerCompat.EXCEPT:
          case PythonLexerCompat.FALSE:
          case PythonLexerCompat.FINALLY:
          case PythonLexerCompat.FOR:
          case PythonLexerCompat.GLOBAL:
          case PythonLexerCompat.IF:
          case PythonLexerCompat.IMPORT:
          case PythonLexerCompat.IN:
          case PythonLexerCompat.IS:
          case PythonLexerCompat.RAISE:
          case PythonLexerCompat.RETURN:
          case PythonLexerCompat.TRUE:
          case PythonLexerCompat.TRY:
          case PythonLexerCompat.WITH:
          case PythonLexerCompat.YIELD:
          case PythonLexerCompat.FROM:
          case PythonLexerCompat.WHILE:
          case PythonLexerCompat.ASSERT:
          case PythonLexerCompat.LAMBDA:
          case PythonLexerCompat.NONE:
          case PythonLexerCompat.NONLOCAL:
          case PythonLexerCompat.NOT:
          case PythonLexerCompat.OR:
          case PythonLexerCompat.PASS:
          case PythonLexerCompat.NAME_OR_TYPE:
          case PythonLexerCompat.NAME_OR_MATCH:
          case PythonLexerCompat.NAME_OR_CASE:
            //    case PythonLexerCompat.NAME_OR_WILDCARD:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.pykeyword, 0, true, false, false));
            break;
          case PythonLexerCompat.DOT:

          case PythonLexerCompat.STAR:
          case PythonLexerCompat.COMMA:
          case PythonLexerCompat.LBRACE:
          case PythonLexerCompat.RBRACE:
          case PythonLexerCompat.LPAR:
          case PythonLexerCompat.LSQB:
          case PythonLexerCompat.RPAR:
          case PythonLexerCompat.RSQB:
          case PythonLexerCompat.VBAR:
          case PythonLexerCompat.EQUAL:
          case PythonLexerCompat.PERCENT:
          case PythonLexerCompat.EQEQUAL:
          case PythonLexerCompat.NOTEQUAL:
          case PythonLexerCompat.LESSEQUAL:
          case PythonLexerCompat.GREATEREQUAL:
          case PythonLexerCompat.TILDE:
          case PythonLexerCompat.CIRCUMFLEX:
          case PythonLexerCompat.LEFTSHIFT:
          case PythonLexerCompat.RIGHTSHIFT:
          case PythonLexerCompat.DOUBLESTAR:
          case PythonLexerCompat.PLUSEQUAL:
          case PythonLexerCompat.MINEQUAL:
          case PythonLexerCompat.STAREQUAL:
          case PythonLexerCompat.SLASHEQUAL:
          case PythonLexerCompat.PERCENTEQUAL:
          case PythonLexerCompat.AMPEREQUAL:
          case PythonLexerCompat.VBAREQUAL:
          case PythonLexerCompat.CIRCUMFLEXEQUAL:
          case PythonLexerCompat.LEFTSHIFTEQUAL:
          case PythonLexerCompat.RIGHTSHIFTEQUAL:
          case PythonLexerCompat.DOUBLESTAREQUAL:
          case PythonLexerCompat.DOUBLESLASH:
          case PythonLexerCompat.DOUBLESLASHEQUAL:
          case PythonLexerCompat.AT:
          case PythonLexerCompat.ATEQUAL:
          case PythonLexerCompat.RARROW:
          case PythonLexerCompat.ELLIPSIS:
          case PythonLexerCompat.COLONEQUAL:
          case PythonLexerCompat.EXCLAMATION:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.pysymbol, 0, true, false, false));
            break;

          case PythonLexerCompat.STRING:
            int colors = EditorColorScheme.pystring;
            result.addIfNeeded(line, column, TextStyle.makeStyle(colors, 0, true, false, false));
            break;
          case PythonLexerCompat.NUMBER:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.pynumber, 0, true, false, false));
            break;
          case PythonLexerCompat.FSTRING:
            result.addIfNeeded(line, column, EditorColorScheme.ATTRIBUTE_VALUE);
            break;

          case PythonLexerCompat.IDENTIFIER:
            {
              int colorid = EditorColorScheme.TEXT_NORMAL;
              boolean isBold = false;
              boolean isUnderLine = false;
              info.addIdentifier(token.getText());
              if (previous == PythonLexerCompat.CLASS) {
                colorid = EditorColorScheme.pycolormatch1;
                isBold = true;
                isUnderLine = false;
              }
              if (previous == PythonLexerCompat.DEF) {
                colorid = EditorColorScheme.pycolormatch2;
              }
              if (previous == PythonLexerCompat.IF) {
                colorid = EditorColorScheme.pycolormatch3;
                isBold = true;
                isUnderLine = false;
              }
              if (previous == PythonLexerCompat.FROM) {
                colorid = EditorColorScheme.pycolormatch3;
                isBold = false;
                isUnderLine = false;
              }
              if (previous == PythonLexerCompat.IMPORT) {
                colorid = EditorColorScheme.pycolormatch3;
                isBold = false;
                isUnderLine = false;
              }
              if (previous == PythonLexerCompat.EQUAL) {
                colorid = EditorColorScheme.pycolormatch1;
                isUnderLine = false;
                isBold = true;
              }
              if (previous == PythonLexerCompat.AT) {
                colorid = EditorColorScheme.pysymbol;
                isBold = true;
              }
              if (previous == PythonLexerCompat.OR
                  || previous == PythonLexerCompat.DOT
                  || previous == PythonLexerCompat.RETURN
                  || previous == PythonLexerCompat.YIELD
                  || previous == PythonLexerCompat.COLON) {
                colorid = EditorColorScheme.pycolormatch2;
                isBold = true;
                isUnderLine = false;
              }
              if (token.getText().equals("print")) {
                colorid = EditorColorScheme.gold;
                isBold = true;
              }
              if (token.getText().equals("self")) {
                colorid = EditorColorScheme.green;
                isBold = true;
              }

              result.addIfNeeded(
                  line, column, TextStyle.makeStyle(colorid, 0, isBold, false, false, isUnderLine));
              break;
            }

          case PythonLexerCompat.COMMENT:
            result.addIfNeeded(line, column, EditorColorScheme.COMMENT);
            break;
          default:
            result.addIfNeeded(line, column, EditorColorScheme.TEXT_NORMAL);
            prevIsTagName = false;
            classNamePrevious = false;
            break;
        }

        first = false;
        if (type != PythonLexerCompat.WS) {
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
