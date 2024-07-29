package io.github.rosemoe.sora.langs.python;

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
  
  private PythonErrorManager errors ;

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
      errors = new PythonErrorManager();
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
          case PythonLexer.NEWLINE:
            if (first) {
              result.addNormalIfNull();
            }
            break;
          case PythonLexer.FALSE:
          case PythonLexer.AWAIT:
          case PythonLexer.ELSE:
          case PythonLexer.IMPORT:
          case PythonLexer.PASS:
          case PythonLexer.NONE:
            result.addIfNeeded(line, column, Italic());
            break;

          case PythonLexer.BREAK:
          case PythonLexer.EXCEPT:
          case PythonLexer.IN:
          case PythonLexer.RAISE:
          case PythonLexer.TRUE:
          case PythonLexer.CLASS:
          case PythonLexer.DEF:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.LITERAL, 0, true, false, false));
            break;
          case PythonLexer.COLON:
            classNamePrevious = false;
            result.addIfNeeded(line, column, EditorColorScheme.HTML_TAG);
            break;
          case PythonLexer.FINALLY:
          case PythonLexer.IS:
          case PythonLexer.RETURN:
          case PythonLexer.AND:
          case PythonLexer.CONTINUE:
          case PythonLexer.FOR:
          case PythonLexer.LAMBDA:
          case PythonLexer.TRY:
          case PythonLexer.AS:
            result.addIfNeeded(line, column, Bold());
            break;
          case PythonLexer.FROM:
          case PythonLexer.NONLOCAL:
          case PythonLexer.WHILE:
          case PythonLexer.ASSERT:
          case PythonLexer.DEL:
            result.addIfNeeded(
                line, column, TextStyle.makeStyle(EditorColorScheme.Ninja, 0, true, false, false));
            break;
          case PythonLexer.GLOBAL:
          case PythonLexer.NOT:
          case PythonLexer.WITH:
          case PythonLexer.ASYNC:
          case PythonLexer.ELIF:
          case PythonLexer.IF:
          case PythonLexer.OR:
          case PythonLexer.YIELD:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.ATTRIBUTE_NAME, 0, true, false, false));
            break;
          case PythonLexer.DOT:
          case PythonLexer.ELLIPSIS:
          case PythonLexer.STAR:
        
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.ATTRIBUTE_NAME, 0, true, false, false));
            break;

          case PythonLexer.NUMBER:
          case PythonLexer.STRING:
          case PythonLexer.MINUS:
          
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.BLOCK_LINE, 0, true, false, false));
            break;
          case PythonLexer.IDENTIFIER:
            {
              int colorid = EditorColorScheme.TEXT_NORMAL;
              boolean isBold = false;
              boolean isUnderLine = false;
              info.addIdentifier(token.getText());
              if (previous == PythonLexer.CLASS || previous == PythonLexer.DEF) {
                colorid = EditorColorScheme.ATTRIBUTE_VALUE;
                isBold = true;
                isUnderLine = false;
              }
              if (previous == PythonLexer.IF) {
                colorid = EditorColorScheme.Ninja;
                isBold = true;
                isUnderLine = false;
              }
              if (previous == PythonLexer.FROM) {
                colorid = EditorColorScheme.ATTRIBUTE_NAME;
                isBold = false;
                isUnderLine = false;
              }
              if (previous == PythonLexer.IMPORT) {
                colorid = EditorColorScheme.HTML_TAG;
                isBold = false;
                isUnderLine = false;
              }
              if (previous == PythonLexer.OR
                  || previous == PythonLexer.DOT
                  || previous == PythonLexer.RETURN
                  || previous == PythonLexer.YIELD
                  || previous == PythonLexer.COLON) {
                colorid = EditorColorScheme.KEYWORD;
                isBold = true;
                isUnderLine = false;
              }
              
                result.addIfNeeded(
                    line,
                    column,
                    TextStyle.makeStyle(colorid, 0, isBold, false, false, isUnderLine));
              break;
            }
          default:
            result.addIfNeeded(line, column, EditorColorScheme.TEXT_NORMAL);
            prevIsTagName = false;
            classNamePrevious = false;
            break;
        }
        

        first = false;
        if (type != PythonLexer.NEWLINE) {
          previous = type;
        }
      }
      info.finish();
      result.setExtra(info);
      result.determine(lastLine);
      errors.analyze(content,result,delegate);
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
