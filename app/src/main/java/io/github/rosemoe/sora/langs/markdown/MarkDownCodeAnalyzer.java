package io.github.rosemoe.sora.langs.markdown;

import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import io.github.rosemoe.sora.data.Span;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import io.github.rosemoe.sora.widget.ListCss3Color;
import java.io.StringReader;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import java.util.Stack;
import io.github.rosemoe.sora.data.BlockLine;
import java.io.IOException;
import android.util.Log;
import org.antlr.v4.runtime.Token;

public class MarkDownCodeAnalyzer implements CodeAnalyzer {

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    try {
      StringBuilder text =
          content instanceof StringBuilder ? (StringBuilder) content : new StringBuilder(content);
      CodePointCharStream stream = CharStreams.fromReader(new StringReader(content.toString()));
      
      var lexer = new MarkDown(stream);
      var classNamePrevious = false;
      Token token, preToken = null, prePreToken = null;
      boolean first = true;
      Stack<BlockLine> stack = new Stack<>();
      int type, currSwitch = 1, maxSwitch = 0, previous = -1;
      int lastLine = 1;
      int line, column;
      var prevIsTagName = false;

      while (delegate.shouldAnalyze()) {
        token = lexer.nextToken();
        if (token == null) break;
        if (token.getType() == MarkDown.EOF) {
          lastLine = token.getLine() - 1;
          break;
        }
        line = token.getLine() - 1;
        type = token.getType();
        String text1 = token.getText();
        column = token.getCharPositionInLine();
        if (type == MarkDown.EOF) {
          lastLine = line;
          break;
        }

        switch (type) {
          case MarkDown.WS:
            if (first) {
              result.addNormalIfNull();
            }
            break;
          
          case MarkDown.HQ:
            result.addIfNeeded(line, column, EditorColorScheme.LITERAL);
            break;
          case MarkDown.STRING:
          case MarkDown.CHATREF:
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

          case MarkDown.LPAREN:
          case MarkDown.RPAREN:
          case MarkDown.LBRACK:
          case MarkDown.RBRACK:
          case MarkDown.SEMI:
          case MarkDown.COMMA:
          case MarkDown.ASSIGN:
          case MarkDown.BANG:
          case MarkDown.TILDE:
          case MarkDown.QUESTION:
          case MarkDown.COLON:
          case MarkDown.EQUAL:
          case MarkDown.GE:
          case MarkDown.LE:
          case MarkDown.NOTEQUAL:
          case MarkDown.AND:
          case MarkDown.OR:
          case MarkDown.INC:
          case MarkDown.DEC:
          case MarkDown.ADD:
          case MarkDown.SUB:
          case MarkDown.MUL:
          case MarkDown.BITAND:
          case MarkDown.BITOR:
          case MarkDown.CARET:
          case MarkDown.MOD:
          case MarkDown.ADD_ASSIGN:
          case MarkDown.SUB_ASSIGN:
          case MarkDown.MUL_ASSIGN:
          case MarkDown.DIV_ASSIGN:
          case MarkDown.AND_ASSIGN:
          case MarkDown.OR_ASSIGN:
          case MarkDown.XOR_ASSIGN:
          case MarkDown.MOD_ASSIGN:
          case MarkDown.LSHIFT_ASSIGN:
          case MarkDown.RSHIFT_ASSIGN:
          case MarkDown.URSHIFT_ASSIGN:
          case MarkDown.ARROW:
          
          case MarkDown.ELLIPSIS:
          case MarkDown.DOT:
            result.addIfNeeded(line, column, EditorColorScheme.OPERATOR);
            break;
          
          case MarkDown.GT:
            result.addIfNeeded(line, column, EditorColorScheme.KEYWORD);
            break;
          case MarkDown.LT:
            { 
              result.addIfNeeded(line, column, EditorColorScheme.KEYWORD);
              var block = result.obtainNewBlock();
              block.startLine = line;
              block.startColumn = column;
              stack.push(block);
              
              break;
            }
            //// '/>'
          case MarkDown.SLASH_CLOSE:
            result.addIfNeeded(line, column, EditorColorScheme.KEYWORD);
            break;

            /// '</'
          case MarkDown.OPEN_SLASH:
            {
              result.addIfNeeded(line, column, EditorColorScheme.KEYWORD);
              final var block = stack.pop();
                block.endLine = line;
                block.endColumn = column;
                result.addBlockLine(block);

              break;
            }
          case MarkDown.IDENTIFIER:
            {
              int colorid = EditorColorScheme.TEXT_NORMAL;
              boolean isBold, isItalic, isUnderLineMode = false;
              
              if (previous == MarkDown.HQ) {
                colorid = EditorColorScheme.AUTO_COMP_PANEL_CORNER;
              }
              if (previous == MarkDown.LBRACK
                  || previous == MarkDown.DOT
                  || previous == MarkDown.COLON) {
                colorid = EditorColorScheme.ATTRIBUTE_NAME;
              }
              
              // show '<'
              if (previous == MarkDown.LT) {
                colorid = EditorColorScheme.OPERATOR;
              }
              // end '</'
              if (previous == MarkDown.OPEN_SLASH) {
                colorid = EditorColorScheme.OPERATOR;
                
              }

              //ListCss3Color.initColor(token, line, column, result, true);
              result.addIfNeeded(line, column, colorid);
              break;
            }
          case MarkDown.LBRACE:
            result.addIfNeeded(line, column, EditorColorScheme.OPERATOR);
            if (stack.isEmpty()) {
              if (currSwitch > maxSwitch) {
                maxSwitch = currSwitch;
              }
              currSwitch = 0;
            }
            currSwitch++;
            BlockLine block = result.obtainNewBlock();
            block.startLine = line;
            block.startColumn = column;
            stack.push(block);
            break;
          case MarkDown.RBRACE:
            result.addIfNeeded(line, column, EditorColorScheme.OPERATOR);
            if (!stack.isEmpty()) {
              BlockLine b = stack.pop();
              b.endLine = line;
              b.endColumn = column;
              if (b.startLine != b.endLine) {
                result.addBlockLine(b);
              }
            }
            break;
          case MarkDown.DIV:
            {
              result.addIfNeeded(line, column, EditorColorScheme.KEYWORD);
              break;
            }
          
          default:
            result.addIfNeeded(line, column, EditorColorScheme.TEXT_NORMAL);

            break;
        }

        /** test */
        if (token.getType() != MarkDown.WS) {
          preToken = token;
        }
        if (type != MarkDown.WS) {
          previous = type;
        }

        first = false;
      }
      result.determine(lastLine);

    } catch (IOException e) {
      e.printStackTrace();
      Log.e("TAG", e.getMessage());
    }
  }

  public long withoutCompletion(int id) {
    return TextStyle.makeStyle(id, 0, true, false, false, false, true);
  }

  public long forString() {
    return TextStyle.makeStyle(EditorColorScheme.LITERAL, 0, true, false, false);
  }
}
