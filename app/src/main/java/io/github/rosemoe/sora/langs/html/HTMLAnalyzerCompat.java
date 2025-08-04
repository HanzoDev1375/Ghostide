package io.github.rosemoe.sora.langs.html;

import io.github.rosemoe.sora.data.RainbowBracketHelper;
import io.github.rosemoe.sora.langs.less.LessLexer;
import io.github.rosemoe.sora.langs.less.LessParser;
import io.github.rosemoe.sora.langs.less.LessParserBaseListener;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import io.github.rosemoe.sora.widget.TextSummry.HTMLConstants;
import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import ir.ninjacoder.ghostide.IdeEditor;
import ir.ninjacoder.ghostide.marco.RegexUtilCompat;
import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import io.github.rosemoe.sora.data.Span;
import android.util.Log;
import io.github.rosemoe.sora.langs.xml.analyzer.BasicSyntaxPullAnalyzer;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.ListCss3Color;
import ir.ninjacoder.ghostide.widget.data.CSSVariableParser;
import java.util.Stack;
import io.github.rosemoe.sora.data.BlockLine;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import java.io.IOException;
import java.io.StringReader;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class HTMLAnalyzerCompat implements CodeAnalyzer {
  private IdeEditor editor;
  private RainbowBracketHelper hl;
  private boolean isLess = false;

  public HTMLAnalyzerCompat() {}

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
      hl = new RainbowBracketHelper();
      htmlCodeAnalyzer = new BasicSyntaxPullAnalyzer();
      HTMLLexer lexer = new HTMLLexer(stream);
      HTMLAutoComplete auto = new HTMLAutoComplete(editor);
      HTMLAutoComplete.Identifiers info = new HTMLAutoComplete.Identifiers();
      info.begin();
      var classNamePrevious = false;
      Token token, preToken = null, prePreToken = null;
      boolean first = true;
      Stack<BlockLine> stack = new Stack<>();
      int type, currSwitch = 1, maxSwitch = 0, previous = -1, next = 1;
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
          case HTMLLexer.OCT_LITERAL:
          case HTMLLexer.BINARY_LITERAL:
          case HTMLLexer.FLOAT_LITERAL:
          case HTMLLexer.HEX_FLOAT_LITERAL:
          case HTMLLexer.BOOL_LITERAL:
          case HTMLLexer.NULL_LITERAL:
            result.addIfNeeded(line, column, EditorColorScheme.jsoprator);
            break;

          case HTMLLexer.PhpFuns:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.phpcolormatch3, 0, true, false, false));
            break;
          case HTMLLexer.HEX_LITERAL:
            {
              Span span =
                  Span.obtain(
                      column, TextStyle.makeStyle(EditorColorScheme.black, 0, false, true, false));
              span.setBackgroundColorMy(Color.WHITE);
              result.add(line, span);

              Span middle =
                  Span.obtain(column + token.getText().length(), EditorColorScheme.LITERAL);
              middle.setBackgroundColorMy(Color.TRANSPARENT);
              result.add(line, middle);

              Span end =
                  Span.obtain(
                      column + token.getText().length(),
                      TextStyle.makeStyle(EditorColorScheme.TEXT_NORMAL));
              end.setBackgroundColorMy(Color.TRANSPARENT);
              result.add(line, end);

              break;
            }
          case HTMLLexer.STRING:
          case HTMLLexer.CHATREF:
            {
              if (previous == HTMLLexer.DOLLAR || token.getType() == HTMLLexer.DOLLAR) {
                result.addIfNeeded(line, column, EditorColorScheme.jsoprator);
              }
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
            /// colse
          case HTMLLexer.LPAREN:
          case HTMLLexer.RBRACK:
            hl.handleOpenBracket(result, line, column, EditorColorScheme.htmlblocknormal);
            break;
            // open
          case HTMLLexer.RPAREN:
          case HTMLLexer.LBRACK:
            hl.handleCloseBracket(result, line, column, EditorColorScheme.htmlblocknormal);
            break;
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
            hl.handleCustom(result, line, column, EditorColorScheme.htmlsymbol);
            if (previous == HTMLLexer.IDENTIFIER || token.getType() == HTMLLexer.IDENTIFIER) {
              result.addIfNeeded(line, column, EditorColorScheme.jsattr);
            }
            break;

          case HTMLLexer.HtmlAttr:
            result.addIfNeeded(line, column, EditorColorScheme.htmlattr);
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
              var colorida = EditorColorScheme.htmlblocknormal;

              if (GhostIdeAppLoader.getPrefManager().getBoolean("breaks", false) == true)
                colorida = HTMLConstants.get(stack.size());
              else colorida = EditorColorScheme.htmlblocknormal;
              stack.push(block);
              result.addIfNeeded(line, column, colorida);
              break;
            }
            //// '/>'
          case HTMLLexer.SLASH_CLOSE:
            result.addIfNeeded(line, column, EditorColorScheme.htmlblockhash);
            break;

            /// '</'
          case HTMLLexer.OPEN_SLASH:
            {
              if (!stack.isEmpty()) {
                BlockLine b = stack.pop();
                b.endLine = line;
                b.endColumn = column;
                if (b.startLine != b.endLine) {
                  result.addBlockLine(b);
                }
              }
              var colorres1 = EditorColorScheme.htmlblocknormal;
              if (GhostIdeAppLoader.getPrefManager().getBoolean("breaks", false) == true)
                colorres1 = HTMLConstants.get(stack.size());
              else colorres1 = EditorColorScheme.htmlblocknormal;
              result.addIfNeeded(line, column, colorres1);
              break;
            }
          case HTMLLexer.IDENTIFIER:
            {
              int colorid = EditorColorScheme.TEXT_NORMAL;
              info.addIdentifier(token.getText());
              boolean isHexColor = false;
              boolean isBold, isItalic, isUnderLineMode = false;

              if (previous == HTMLLexer.AT) {
                colorid = EditorColorScheme.Ninja;
              }
              if (previous == HTMLLexer.CLASS || previous == HTMLLexer.CONST) {
                colorid = EditorColorScheme.AUTO_COMP_PANEL_CORNER;
              }
              if (previous == HTMLLexer.LBRACK
                  || previous == HTMLLexer.IMPORT
                  || previous == HTMLLexer.FUNCTION
                  || previous == HTMLLexer.COLONCOLON) {
                colorid = EditorColorScheme.ATTRIBUTE_NAME;
              }
              if (previous == HTMLLexer.STRING) {
                colorid = EditorColorScheme.javastring;
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
                colorid = EditorColorScheme.htmlsymbol;
                isHexColor = false;
              }
              if (previous == HTMLLexer.DOLLAR) {
                // $php
                colorid = EditorColorScheme.ATTRIBUTE_VALUE;
              }
              if (previous == HTMLLexer.DOT) {
                /// def code result -> Java.user();
                colorid = EditorColorScheme.javafun;
              }
              ListCss3Color.getHslColor(token, line, column, result);
            
             ListCss3Color.initColor(token, line, column, result, true);
              hl.handleCustom(result, line, column, colorid);
              var cssH = new CSSVariableParser(editor);
              cssH.highlightVariables(result, editor.getText().toString());
              break;
            }
          case HTMLLexer.HTMLRGB:
            ListCss3Color.getHexColor(token, line, column, result);
            // result.addIfNeeded(line, column, EditorColorScheme.COLOR_DEBUG);
            break;
          case HTMLLexer.HSL:
            ListCss3Color.getHslColor(token, line, column, result);
            break;
          case HTMLLexer.LBRACE:
            if (stack.isEmpty()) {
              if (currSwitch > maxSwitch) {
                maxSwitch = currSwitch;
              }
              currSwitch = 0; // ریست کردن currSwitch
            }
            currSwitch++;
            BlockLine block = result.obtainNewBlock();
            block.startLine = line;
            block.startColumn = column;
            // max level 8x
            var colorid = EditorColorScheme.htmlblocknormal;
            stack.push(block);
            hl.handleOpenBracket(result, line, column, colorid);
            // result.addIfNeeded(line, column, colorid);
            break;

          case HTMLLexer.RBRACE:
            {
              if (!stack.isEmpty()) {
                BlockLine b = stack.pop();
                b.endLine = line;
                b.endColumn = column;

                if (b.startLine != b.endLine || b.startColumn != b.endColumn) {
                  result.addBlockLine(b);
                }
              }
              // اضافه کردن رنگ برای RBRACE
              hl.handleCloseBracket(result, line, column, EditorColorScheme.htmlblocknormal);
              break;
            }
          case HTMLLexer.COLORSSS:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(
                    EditorColorScheme.ATTRIBUTE_NAME, 0, false, false, false, false, true));

            break;
          case HTMLLexer.LinkLiteral:
            Span span =
                Span.obtain(
                    column, TextStyle.makeStyle(EditorColorScheme.Ninja, 0, true, true, false));
            result.addIfNeeded(line, column, EditorColorScheme.Ninja);
            if (span != null) result.add(line, span);
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
        next = type;
        first = false;
      }
      result.determine(lastLine);
      info.finish();
      result.setExtra(info);
      if (isLess) {
        var inputStream = new ANTLRInputStream(content.toString());
        var lexer1 = new LessLexer(inputStream);
        var com = new CommonTokenStream(lexer1);
        var parse = new LessParser(com);
        var call =
            new LessParserBaseListener() {
              @Override
              public void visitErrorNode(ErrorNode node) {
                super.visitErrorNode(node);

                // TODO: Implement this method
                int lines = node.getSymbol().getLine();
                int col = node.getSymbol().getCharPositionInLine();
                int[] error = Utils.setErrorSpan(result, lines, col);
              }
            };
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(call, parse.stylesheet());
      }
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

  public boolean getIsLess() {
    return this.isLess;
  }

  public void setIsLess(boolean isLess) {
    this.isLess = isLess;
  }
}
