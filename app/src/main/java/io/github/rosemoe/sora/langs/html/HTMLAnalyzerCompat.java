package io.github.rosemoe.sora.langs.html;

import Ninja.coder.Ghostemane.code.IdeEditor;
import Ninja.coder.Ghostemane.code.marco.RegexUtilCompat;
import Ninja.coder.Ghostemane.code.utils.FileUtil;
import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import io.github.rosemoe.sora.data.Span;
import android.util.Log;
import io.github.rosemoe.sora.langs.javascript.BasicSyntaxJavaScriptAnalyzer;
import io.github.rosemoe.sora.langs.php.PHPLanguage;
import io.github.rosemoe.sora.langs.php.PhpErrorManager;
import io.github.rosemoe.sora.langs.xml.analyzer.BasicSyntaxPullAnalyzer;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.ListCss3Color;
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
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

public class HTMLAnalyzerCompat implements CodeAnalyzer {
  private IdeEditor editor;
  
  
  public HTMLAnalyzerCompat(){
    
  }
  public HTMLAnalyzerCompat(IdeEditor editor) {
    this.editor = editor;
  }

  private BasicSyntaxPullAnalyzer htmlCodeAnalyzer;

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    try {
      StringBuilder text =
          content instanceof StringBuilder ? (StringBuilder) content : new StringBuilder(content);
      CodePointCharStream stream = CharStreams.fromReader(new StringReader(content.toString()));
      htmlCodeAnalyzer = new BasicSyntaxPullAnalyzer();
      HTMLLexer lexer = new HTMLLexer(stream);
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
        if (token.getType() == HTMLLexer.EOF) {
          lastLine = token.getLine() - 1;
          break;
        }
        line = token.getLine() - 1;
        type = token.getType();
        String text1 = token.getText();
        column = token.getCharPositionInLine();
        if (type == HTMLLexer.EOF) {
          lastLine = line;
          break;
        }

        switch (type) {
          case HTMLLexer.WS:
            if (first) {
              result.addNormalIfNull();
            }
            break;
          case HTMLLexer.ABSTRACT:
          case HTMLLexer.ASSERT:
          case HTMLLexer.BREAK:
          case HTMLLexer.CASE:
          case HTMLLexer.CATCH:
          case HTMLLexer.CLASS:
          case HTMLLexer.CONST:
          case HTMLLexer.CONTINUE:
          case HTMLLexer.DEFAULT:
          case HTMLLexer.DO:
          case HTMLLexer.ELSE:
          case HTMLLexer.EXTENDS:
          case HTMLLexer.FINAL:
          case HTMLLexer.FINALLY:
          case HTMLLexer.FOR:
          case HTMLLexer.IF:
          case HTMLLexer.GOTO:
          case HTMLLexer.IMPLEMENTS:
          case HTMLLexer.IMPORT:
          case HTMLLexer.INSTANCEOF:
          case HTMLLexer.INTERFACE:
          case HTMLLexer.NATIVE:
          case HTMLLexer.NEW:
          case HTMLLexer.PACKAGE:
          case HTMLLexer.PRIVATE:
          case HTMLLexer.PROTECTED:
          case HTMLLexer.PUBLIC:
          case HTMLLexer.RETURN:
          case HTMLLexer.STATIC:
          case HTMLLexer.STRICTFP:
          case HTMLLexer.SUPER:
          case HTMLLexer.SWITCH:
          case HTMLLexer.SYNCHRONIZED:
          case HTMLLexer.THIS:
          case HTMLLexer.THROW:
          case HTMLLexer.THROWS:
          case HTMLLexer.TRANSIENT:
          case HTMLLexer.TRY:
          case HTMLLexer.VOID:
          case HTMLLexer.VOLATILE:
          case HTMLLexer.WHILE:
          case HTMLLexer.VAR:
          case HTMLLexer.FUNCTION:
          case HTMLLexer.LET:
          case HTMLLexer.DEBUGGER:
          case HTMLLexer.YELD:
          case HTMLLexer.BYTE:
          case HTMLLexer.CHAR:
          case HTMLLexer.DOUBLE:
          case HTMLLexer.ENUM:
          case HTMLLexer.FLOAT:
          case HTMLLexer.INT:
          case HTMLLexer.LONG:
          case HTMLLexer.SHORT:
          case HTMLLexer.BOOLEAN:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.jskeyword, 0, true, false, false, false));
            break;
          case HTMLLexer.DECIMAL_LITERAL:
          case HTMLLexer.HEX_LITERAL:
          case HTMLLexer.OCT_LITERAL:
          case HTMLLexer.BINARY_LITERAL:
          case HTMLLexer.FLOAT_LITERAL:
          case HTMLLexer.HEX_FLOAT_LITERAL:
          case HTMLLexer.BOOL_LITERAL:
          case HTMLLexer.NULL_LITERAL:
            result.addIfNeeded(line, column, EditorColorScheme.jsoprator);
            break;
          case HTMLLexer.STRING:
          case HTMLLexer.CHATREF:
            {
              if (RegexUtilCompat.RegexSelect(
                  "(\\#[a-zA-F0-9]{8})|(\\#[a-zA-F0-9]{6})|(\\#[a-zA-F0-9]{3})", text1)) {

                var colors = result;
                String colorString = text1;

                // تبدیل رنگ سه رقمی به شش رقمی
                if (colorString.length() == 4) { // اگر رنگ سه رقمی باشد
                  String red = colorString.substring(1, 2);
                  String green = colorString.substring(2, 3);
                  String blue = colorString.substring(3, 4);
                  colorString = "#" + red + red + green + green + blue + blue; // تبدیل به شش رقمی
                }

                try {
                  int color = Color.parseColor(colorString);
                  colors.addIfNeeded(line, column, EditorColorScheme.LITERAL);
                  if (ColorUtils.calculateLuminance(color) > 0.5) {
                    Span span =
                        Span.obtain(
                            column,
                            TextStyle.makeStyle(
                                EditorColorScheme.black, 0, false, false, false, false, true));
                    if (span != null) {
                      span.setBackgroundColorMy(color);
                      colors.add(line, span);
                    }
                  } else {
                    Span span =
                        Span.obtain(
                            column,
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

                  Span middle = Span.obtain(column + text1.length(), EditorColorScheme.LITERAL);
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
              } else {
                result.addIfNeeded(line, column, forString());
              }

              result.addIfNeeded(line, column, forString());
              break;
            }

          case HTMLLexer.LPAREN:
          case HTMLLexer.RPAREN:
          case HTMLLexer.LBRACK:
          case HTMLLexer.RBRACK:
          case HTMLLexer.SEMI:
          case HTMLLexer.COMMA:
          case HTMLLexer.ASSIGN:
          case HTMLLexer.BANG:
          case HTMLLexer.TILDE:
          case HTMLLexer.QUESTION:
          case HTMLLexer.COLON:
          case HTMLLexer.EQUAL:
          case HTMLLexer.GE:
          case HTMLLexer.LE:
          case HTMLLexer.NOTEQUAL:
          case HTMLLexer.AND:
          case HTMLLexer.OR:
          case HTMLLexer.INC:
          case HTMLLexer.DEC:
          case HTMLLexer.ADD:
          case HTMLLexer.SUB:
          case HTMLLexer.MUL:
          case HTMLLexer.BITAND:
          case HTMLLexer.BITOR:
          case HTMLLexer.CARET:
          case HTMLLexer.MOD:
          case HTMLLexer.ADD_ASSIGN:
          case HTMLLexer.SUB_ASSIGN:
          case HTMLLexer.MUL_ASSIGN:
          case HTMLLexer.DIV_ASSIGN:
          case HTMLLexer.AND_ASSIGN:
          case HTMLLexer.OR_ASSIGN:
          case HTMLLexer.XOR_ASSIGN:
          case HTMLLexer.MOD_ASSIGN:
          case HTMLLexer.LSHIFT_ASSIGN:
          case HTMLLexer.RSHIFT_ASSIGN:
          case HTMLLexer.URSHIFT_ASSIGN:
          case HTMLLexer.ARROW:
          case HTMLLexer.COLONCOLON:
          case HTMLLexer.ELLIPSIS:
          case HTMLLexer.DOT:
          case HTMLLexer.DOLLAR:
          case HTMLLexer.DIV:
          case HTMLLexer.AT:
            result.addIfNeeded(line, column, EditorColorScheme.htmlsymbol);
            break;
          
          
          case HTMLLexer.HtmlAttr:
            result.addIfNeeded(line, column, EditorColorScheme.jsattr);
            break;
          case HTMLLexer.BLOCK_COMMENT:
          case HTMLLexer.LINE_COMMENT:
            result.addIfNeeded(line, column, EditorColorScheme.COMMENT);
            break;
          
          case HTMLLexer.CSSKEYWORD:
            result.addIfNeeded(line, column, EditorColorScheme.csskeyword);
            break;
          case HTMLLexer.HtmlTags:
          case HTMLLexer.HtmlTagOne:
            result.addIfNeeded(line, column, EditorColorScheme.htmltag);
            break;
          case HTMLLexer.GT:
            result.addIfNeeded(line, column, EditorColorScheme.htmlblockhash);
            break;
          case HTMLLexer.LT:
            {
              result.addIfNeeded(line, column, EditorColorScheme.htmlblockhash);
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
            }
            //// '/>'
          case HTMLLexer.SLASH_CLOSE:
            result.addIfNeeded(line, column, EditorColorScheme.htmlblockhash);
            break;

            /// '</'
          case HTMLLexer.OPEN_SLASH:
            {
              result.addIfNeeded(line, column, EditorColorScheme.htmlblockhash);
              if (!stack.isEmpty()) {
                BlockLine b = stack.pop();
                b.endLine = line;
                b.endColumn = column;
                if (b.startLine != b.endLine) {
                  result.addBlockLine(b);
                }
              }

              break;
            }
          case HTMLLexer.IDENTIFIER:
            {
              int colorid = EditorColorScheme.TEXT_NORMAL;
              boolean isBold, isItalic, isUnderLineMode = false;
              if (previous == HTMLLexer.AT) {
                colorid = EditorColorScheme.Ninja;
              }
              if (previous == HTMLLexer.CLASS || previous == HTMLLexer.CONST) {
                colorid = EditorColorScheme.AUTO_COMP_PANEL_CORNER;
              }
              if (previous == HTMLLexer.LBRACK
                  || previous == HTMLLexer.DOT
                  || previous == HTMLLexer.IMPORT
                  || previous == HTMLLexer.FUNCTION
                  || previous == HTMLLexer.COLONCOLON) {
                colorid = EditorColorScheme.ATTRIBUTE_NAME;
              }
              if (previous == HTMLLexer.VOID || previous == HTMLLexer.EXTENDS) {
                colorid = EditorColorScheme.OPERATOR;
              }
              if (previous == HTMLLexer.RETURN || previous == HTMLLexer.NEW) {
                colorid = EditorColorScheme.HTML_TAG;
              }
              if (previous == HTMLLexer.INT
                  || previous == HTMLLexer.LET
                  || previous == HTMLLexer.VAR) {
                colorid = EditorColorScheme.LITERAL;
                int[] err = Utils.setWaringSpan(result, line, column + 1);
              }
              if (previous == HTMLLexer.CASE || previous == HTMLLexer.FINAL) {
                colorid = EditorColorScheme.ATTRIBUTE_NAME;
              }
              // show '<'
              if (previous == HTMLLexer.LT) {
                colorid = EditorColorScheme.OPERATOR;
              }
              // end '</'
              if (previous == HTMLLexer.OPEN_SLASH) {
                colorid = EditorColorScheme.OPERATOR;
              }
              if (previous == HTMLLexer.SUB) {
                colorid = EditorColorScheme.HTML_TAG;
              }
              if (previous == HTMLLexer.DOLLAR) {
                // $php
                colorid = EditorColorScheme.ATTRIBUTE_VALUE;
              }

              ListCss3Color.initColor(token, line, column, result, true);
              result.addIfNeeded(line, column, colorid);
              break;
            }
          case HTMLLexer.LBRACE:
            //  result.addIfNeeded(line, column, EditorColorScheme.OPERATOR);
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
            result.addIfNeeded(line, column, EditorColorScheme.htmlblocknormal);
            break;
          case HTMLLexer.RBRACE:
            if (!stack.isEmpty()) {
              BlockLine b = stack.pop();
              b.endLine = line;
              b.endColumn = column;

              if (b.startLine != b.endLine) {
                result.addBlockLine(b);
              }
            }
            result.addIfNeeded(line, column, EditorColorScheme.htmlblocknormal);
            break;
          case HTMLLexer.COLORSSS:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(
                    EditorColorScheme.ATTRIBUTE_NAME, 0, false, false, false, false, true));

            break;
          case HTMLLexer.LinkLiteral:
            result.addIfNeeded(line, column, EditorColorScheme.Ninja);
            break;
          default:
            result.addIfNeeded(line, column, EditorColorScheme.TEXT_NORMAL);

            break;
        }

        if (preToken != null) {
          prePreToken = preToken;
        }
        /** test */
        if (token.getType() != HTMLLexer.WS) {
          preToken = token;
        }
        if (type != HTMLLexer.WS) {
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
    return TextStyle.makeStyle(EditorColorScheme.htmlstr, 0, true, false, false);
  }
}
