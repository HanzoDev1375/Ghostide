package io.github.rosemoe.sora.langs.kotlin;

import android.graphics.Color;
import android.util.Log;
import io.github.rosemoe.sora.data.Span;
import io.github.rosemoe.sora.text.TextStyle;

import java.util.Stack;

import io.github.rosemoe.sora.data.BlockLine;
import org.antlr.parser.antlr4.ninja.NinjaTest;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.Token;

import java.io.IOException;
import java.io.StringReader;

import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import org.antlr.v4.runtime.TokenSource;

public class KotilnAnalyzer implements CodeAnalyzer {
  
  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    try {
      CodePointCharStream stream = CharStreams.fromReader(new StringReader(content.toString()));
      var auto = new KotilnAutoText();
      auto.setKeywords(KotilnKeys.ktKeyWord);
      var ktinfo = new KotilnAutoText.Identifiers();
      ktinfo.begin();
      var lexer = new KotlinLexer(stream);
      int maxSwitch = 1, currSwitch = 0;
      Token token;
      Token previous = UnknownToken.INSTANCE;
      Token prePreToken = null;
      boolean first = true;
      int lastLine = 1;
      int line, column;

      Stack<BlockLine> stack = new Stack<>();
      while (delegate.shouldAnalyze()) {
        token = lexer.nextToken();
        if (token == null) break;
        if (token.getType() == KotlinLexer.EOF) {
          lastLine = token.getLine() - 1;
          break;
        }
        line = token.getLine() - 1;
        column = token.getCharPositionInLine();
        lastLine = line;

        switch (token.getType()) {
          case KotlinLexer.WS:
            if (first) result.addNormalIfNull();
            break;

          case KotlinLexer.AT_WS:
          case KotlinLexer.AT:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.ATTRIBUTE_NAME, 0, true, false, true));

            break;
          case KotlinLexer.ANNOTATION:
          case KotlinLexer.ABSTRACT:
          case KotlinLexer.BY:
          case KotlinLexer.CATCH:
          case KotlinLexer.COMPANION:
          case KotlinLexer.CONSTRUCTOR:
          case KotlinLexer.CROSSINLINE:
          case KotlinLexer.DATA:
          case KotlinLexer.DYNAMIC:
          case KotlinLexer.ENUM:
          case KotlinLexer.EXTERNAL:
          case KotlinLexer.FINAL:
          case KotlinLexer.FINALLY:
          case KotlinLexer.IMPORT:
          case KotlinLexer.INFIX:
          case KotlinLexer.INIT:
          case KotlinLexer.INLINE:
          case KotlinLexer.INNER:
          case KotlinLexer.INTERNAL:
          case KotlinLexer.LATEINIT:
          case KotlinLexer.NOINLINE:
          case KotlinLexer.OPEN:
          case KotlinLexer.OPERATOR:
          case KotlinLexer.OUT:
          case KotlinLexer.OVERRIDE:
          case KotlinLexer.PRIVATE:
          case KotlinLexer.PROTECTED:
          case KotlinLexer.PUBLIC:
          case KotlinLexer.REIFIED:
          case KotlinLexer.SEALED:
          case KotlinLexer.TAILREC:
          case KotlinLexer.VARARG:
          case KotlinLexer.WHERE:

          case KotlinLexer.EXPECT:
          case KotlinLexer.ACTUAL:

          case KotlinLexer.CONST:
          case KotlinLexer.SUSPEND:
          case KotlinLexer.RETURN_AT:
          case KotlinLexer.CONTINUE_AT:
          case KotlinLexer.BREAK_AT:
          case KotlinLexer.THIS_AT:
          case KotlinLexer.SUPER_AT:
          case KotlinLexer.PACKAGE:
          case KotlinLexer.CLASS:
          case KotlinLexer.INTERFACE:
          case KotlinLexer.FUN:
          case KotlinLexer.OBJECT:
          case KotlinLexer.VAL:

          case KotlinLexer.VAR:
          case KotlinLexer.TYPE_ALIAS:
          case KotlinLexer.THIS:
          case KotlinLexer.SUPER:
          case KotlinLexer.TYPEOF:
          case KotlinLexer.IF:
          case KotlinLexer.ELSE:
          case KotlinLexer.WHEN:
          case KotlinLexer.TRY:
          case KotlinLexer.FOR:
          case KotlinLexer.DO:
          case KotlinLexer.WHILE:
          case KotlinLexer.THROW:
          case KotlinLexer.RETURN:
          case KotlinLexer.CONTINUE:
          case KotlinLexer.BREAK:
          case KotlinLexer.AS:
          case KotlinLexer.IS:
          case KotlinLexer.IN:
          case KotlinLexer.NOT_IS:
          case KotlinLexer.NOT_IN:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.KEYWORD, 0, true, false, false));
            break;
          case KotlinLexer.RealLiteral:
          case KotlinLexer.FloatLiteral:
          case KotlinLexer.DoubleLiteral:
          case KotlinLexer.IntegerLiteral:

          case KotlinLexer.BinLiteral:
          case KotlinLexer.LongLiteral:
          case KotlinLexer.BooleanLiteral:
          case KotlinLexer.NullLiteral:
          case KotlinLexer.CharacterLiteral:
          case KotlinLexer.HexLiteral:
            Span span = Span.obtain(column, EditorColorScheme.LITERAL);
            if (token.getType() == KotlinLexer.HexLiteral) {
              try {
                span.setUnderlineColor(Integer.parseInt(token.getText(), 16));
              } catch (Exception e) {
                span.setUnderlineColor(Color.TRANSPARENT);
              }
            }
            result.add(line, span);
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.KEYWORD, 0, true, false, false));
            break;
          case KotlinLexer.QUOTE_OPEN:
          case KotlinLexer.TRIPLE_QUOTE_OPEN:
          case KotlinLexer.QUOTE_CLOSE:
          case KotlinLexer.LineStrRef:
          case KotlinLexer.LineStrText:
          case KotlinLexer.LineStrEscapedChar:
          case KotlinLexer.LineStrExprStart:
          case KotlinLexer.TRIPLE_QUOTE_CLOSE:
          case KotlinLexer.MultiLineStringQuote:
          case KotlinLexer.MultiLineStrRef:
          case KotlinLexer.MultiLineStrText:
          case KotlinLexer.MultiLineStrExprStart:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.HTML_TAG, 0, true, false, false));
            break;
          case KotlinLexer.RESERVED:
          case KotlinLexer.DOT:
          case KotlinLexer.COMMA:
          case KotlinLexer.LPAREN:
          case KotlinLexer.RPAREN:
          case KotlinLexer.LSQUARE:
          case KotlinLexer.RSQUARE:

          case KotlinLexer.MULT:
          case KotlinLexer.MOD:
          case KotlinLexer.DIV:
          case KotlinLexer.ADD:
          case KotlinLexer.SUB:
          case KotlinLexer.INCR:
          case KotlinLexer.DECR:
          case KotlinLexer.CONJ:
          case KotlinLexer.DISJ:
          case KotlinLexer.EXCL_WS:
          case KotlinLexer.EXCL_NO_WS:
          case KotlinLexer.COLON:
          case KotlinLexer.SEMICOLON:
          case KotlinLexer.ASSIGNMENT:
          case KotlinLexer.ADD_ASSIGNMENT:
          case KotlinLexer.SUB_ASSIGNMENT:
          case KotlinLexer.MULT_ASSIGNMENT:
          case KotlinLexer.DIV_ASSIGNMENT:
          case KotlinLexer.MOD_ASSIGNMENT:
          case KotlinLexer.ARROW:
          case KotlinLexer.DOUBLE_ARROW:
          case KotlinLexer.RANGE:
          case KotlinLexer.COLONCOLON:
          case KotlinLexer.DOUBLE_SEMICOLON:
          case KotlinLexer.QUEST_WS:
          case KotlinLexer.QUEST_NO_WS:
          case KotlinLexer.LANGLE:
          case KotlinLexer.RANGLE:
          case KotlinLexer.LE:
          case KotlinLexer.GE:
          case KotlinLexer.EXCL_EQ:
          case KotlinLexer.EXCL_EQEQ:
          case KotlinLexer.AS_SAFE:
          case KotlinLexer.EQEQ:
          case KotlinLexer.EQEQEQ:
          case KotlinLexer.HASH:
          case KotlinLexer.SINGLE_QUOTE:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.OPERATOR, 0, true, false, false));
            break;
          case KotlinLexer.LineComment:
          case KotlinLexer.ShebangLine:
          case KotlinLexer.DelimitedComment:
          case KotlinLexer.Inside_Comment:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.COMMENT, 0, true, false, false));
            break;

          case KotlinLexer.Identifier:
            {
              int color = EditorColorScheme.TEXT_NORMAL;
              ktinfo.addIdentifier(token.getText());
              int typemode = previous.getType();
              if (typemode == KotlinLexer.AT) {
                color = EditorColorScheme.ATTRIBUTE_NAME;
              }
              if (typemode == KotlinLexer.HASH) {
                color = EditorColorScheme.OPERATOR;
              }
              if (typemode == KotlinLexer.DOT) {
                color = EditorColorScheme.HTML_TAG;
              }
              if (typemode == KotlinLexer.COLON) {
                color = EditorColorScheme.KEYWORD;
              }
              if (typemode == KotlinLexer.CLASS
                  || typemode == KotlinLexer.FUN
                  || typemode == KotlinLexer.INNER
                  || typemode == KotlinLexer.INTERFACE
                  || typemode == KotlinLexer.INTERNAL
                  || typemode == KotlinLexer.PACKAGE
                  || typemode == KotlinLexer.IMPORT) {
                color = EditorColorScheme.Ninja;
              }
              if (typemode == KotlinLexer.AS
                  || typemode == KotlinLexer.BY
                  || typemode == KotlinLexer.WHEN
                  || typemode == KotlinLexer.WHERE
                  || typemode == KotlinLexer.IS
                  || typemode == KotlinLexer.IN) {
                color = EditorColorScheme.LITERAL;
              }
              

              result.addIfNeeded(line, column, color);
              break;
            }
          case KotlinLexer.LCURL:
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
          case KotlinLexer.RCURL:
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
          default:
            result.addIfNeeded(line, column, EditorColorScheme.TEXT_NORMAL);
            break;
        }

        first = false;
        if (token.getType() != KotlinLexer.WS && token.getType() != KotlinLexer.NL) {
          previous = token;
        }
      }
      result.determine(lastLine);
      if (stack.isEmpty()) {
        if (currSwitch > maxSwitch) {
          maxSwitch = currSwitch;
        }
      }
      ktinfo.finish();
      result.setExtra(ktinfo);
      
      //for testninja lang
      NinjaTest.main(result,content.toString());
      result.setSuppressSwitch(maxSwitch + 10);
    } catch (IOException e) {
      e.printStackTrace();
      Log.e("TAG", e.getMessage());
    }
  }

  private static class UnknownToken implements Token {

    public static UnknownToken INSTANCE = new UnknownToken();

    @Override
    public String getText() {
      return "";
    }

    @Override
    public int getType() {
      return -1;
    }

    @Override
    public int getLine() {
      return 0;
    }

    @Override
    public int getCharPositionInLine() {
      return 0;
    }

    @Override
    public int getChannel() {
      return 0;
    }

    @Override
    public int getTokenIndex() {
      return 0;
    }

    @Override
    public int getStartIndex() {
      return 0;
    }

    @Override
    public int getStopIndex() {
      return 0;
    }

    @Override
    public TokenSource getTokenSource() {
      return null;
    }

    @Override
    public CharStream getInputStream() {
      return null;
    }
  }
}
