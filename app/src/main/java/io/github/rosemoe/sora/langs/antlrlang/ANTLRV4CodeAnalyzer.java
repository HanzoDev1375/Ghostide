package io.github.rosemoe.sora.langs.antlrlang;

import android.graphics.Color;
import android.util.Log;
import io.github.rosemoe.sora.data.RainbowBracketHelper;
import io.github.rosemoe.sora.text.TextStyle;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import java.util.Stack;
import io.github.rosemoe.sora.data.BlockLine;
import org.antlr.parser.antlr4.ANTLRv4Lexer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.Token;
import java.io.IOException;
import java.io.StringReader;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.widget.EditorColorScheme;

public class ANTLRV4CodeAnalyzer implements CodeAnalyzer {
  private int COMPLETE = 25;
  private int INCOMPLETE = 24;
  private Antlr4Error error;
  private RainbowBracketHelper helper;

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    try {
      CodePointCharStream stream = CharStreams.fromReader(new StringReader(content.toString()));
      var lexer = new ANTLRv4Lexer(stream);
      var classNamePrevious = false;
      helper = new RainbowBracketHelper(content);
      Token token, preToken = null, prePreToken = null;
      var com = new Antlr4AutoText();
      com.setKeywords(ANTLRV4Lang.word);
      Antlr4AutoText.Identifiers identifiers = new Antlr4AutoText.Identifiers();
      identifiers.begin();
      error = new Antlr4Error();
      boolean first = true;
      Stack<BlockLine> stack = new Stack<>();
      int type, currSwitch = 1, maxSwitch = 0, previous = -1;
      int lastLine = 1;
      int line, column;
      var prevIsTagName = false;

      while (delegate.shouldAnalyze()) {
        token = lexer.nextToken();
        if (token == null) break;
        if (token.getType() == ANTLRv4Lexer.EOF) {
          lastLine = token.getLine() - 1;
          break;
        }
        line = token.getLine() - 1;
        type = token.getType();
        column = token.getCharPositionInLine();
        if (type == ANTLRv4Lexer.EOF) {
          lastLine = line;
          break;
        }
        switch (type) {
          case ANTLRv4Lexer.WS:
            if (first) {
              result.addNormalIfNull();
            }
            break;
          case ANTLRv4Lexer.LPAREN:
          case ANTLRv4Lexer.LT:
            helper.handleOpenBracket(result, line, column, false);
            break;
          case ANTLRv4Lexer.RPAREN:
          case ANTLRv4Lexer.GT:
            helper.handleCloseBracket(result, line, column, false);
            break;
          case ANTLRv4Lexer.TOKEN_REF:
            {
              result.addIfNeeded(line, column, EditorColorScheme.HTML_TAG);
              break;
            }
          case ANTLRv4Lexer.RULE_REF:
            {
              result.addIfNeeded(line, column, EditorColorScheme.KEYWORD);
              break;
            }
          case ANTLRv4Lexer.LEXER_CHAR_SET:
            {
              result.addIfNeeded(line, column, EditorColorScheme.LITERAL);
              break;
            }

            //  case ANTLRv4Lexer.ERRCHAR:
            //    case ANTLRv4Lexer.UNTERMINATED_ARGUMENT:
            //  case ANTLRv4Lexer.ARGUMENT_CONTENT:
          case ANTLRv4Lexer.END_ACTION:
          case ANTLRv4Lexer.UNTERMINATED_ACTION:
          case ANTLRv4Lexer.ACTION_CONTENT:
          case ANTLRv4Lexer.UNTERMINATED_CHAR_SET:
            classNamePrevious = false;
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.javafield, 0, true, false, false));

            break;

          case ANTLRv4Lexer.PRIVATE:
          case ANTLRv4Lexer.PROTECTED:
          case ANTLRv4Lexer.PUBLIC:
            classNamePrevious = false;
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.ATTRIBUTE_NAME, 0, true, false, false));
            break;
          case ANTLRv4Lexer.MODE:
          case ANTLRv4Lexer.COLON:
          case ANTLRv4Lexer.COLONCOLON:
          case ANTLRv4Lexer.COMMA:
          case ANTLRv4Lexer.SEMI:
          case ANTLRv4Lexer.RARROW:
          case ANTLRv4Lexer.ASSIGN:
          case ANTLRv4Lexer.QUESTION:
          case ANTLRv4Lexer.STAR:
          case ANTLRv4Lexer.PLUS_ASSIGN:
          case ANTLRv4Lexer.PLUS:
          case ANTLRv4Lexer.OR:
          case ANTLRv4Lexer.DOLLAR:
          case ANTLRv4Lexer.RANGE:
          case ANTLRv4Lexer.DOT:
          case ANTLRv4Lexer.AT:
          case ANTLRv4Lexer.POUND:
          case ANTLRv4Lexer.NOT:
          case ANTLRv4Lexer.END_ARGUMENT:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.javaoprator, 0, true, false, false));
            break;
          case ANTLRv4Lexer.PARSER:
          case ANTLRv4Lexer.GRAMMAR:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.javaparament, 0, true, false, false));
            break;

          case ANTLRv4Lexer.DOC_COMMENT:
          case ANTLRv4Lexer.BLOCK_COMMENT:
          case ANTLRv4Lexer.LINE_COMMENT:
            result.addIfNeeded(line, column, EditorColorScheme.COMMENT);
            break;

          case ANTLRv4Lexer.STRING_LITERAL:
          case ANTLRv4Lexer.UNTERMINATED_STRING_LITERAL:
          case ANTLRv4Lexer.BEGIN_ARGUMENT:
          case ANTLRv4Lexer.BEGIN_ACTION:
            result.addIfNeeded(line, column, EditorColorScheme.javastring);
            break;
          case ANTLRv4Lexer.LBRACE:
            helper.handleOpenBracket(result, line, column, true);
            break;
          case ANTLRv4Lexer.RBRACE:
            helper.handleCloseBracket(result, line, column, true);
            break;
          case ANTLRv4Lexer.OPTIONS:
          case ANTLRv4Lexer.TOKENS:
          case ANTLRv4Lexer.CHANNELS:
          case ANTLRv4Lexer.FRAGMENT:
          case ANTLRv4Lexer.LEXER:
            classNamePrevious = false;
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.javakeywordoprator, 0, true, false, false));
            break;
          case ANTLRv4Lexer.ID:
            {
              identifiers.addIdentifier(token.getText());
              int color = EditorColorScheme.TEXT_NORMAL;
              boolean isBold = false, isItalic = false;

              if (previous == ANTLRv4Lexer.FRAGMENT) {
                color = EditorColorScheme.jsfun;
                isBold = true;
              }
              if (previous == ANTLRv4Lexer.COLON
                  || previous == ANTLRv4Lexer.COLONCOLON
                  || previous == ANTLRv4Lexer.OR) {
                color = EditorColorScheme.jsattr;
              }
              if (previous == ANTLRv4Lexer.MODE) {
                color = EditorColorScheme.jskeyword;
              }
              if (previous == ANTLRv4Lexer.LEXER
                  || previous == ANTLRv4Lexer.PARSER
                  || previous == ANTLRv4Lexer.GRAMMAR) {
                color = EditorColorScheme.jsoprator;

                isBold = true;
              }
              if (ObjectUtils.getNextLexer(lexer, ':')) {
                color = EditorColorScheme.jsstring;
              }

              result.addIfNeeded(
                  line, column, TextStyle.makeStyle(color, 0, isBold, isItalic, false));
              break;
            }

          default:
            result.addIfNeeded(line, column, EditorColorScheme.TEXT_NORMAL);
            prevIsTagName = false;
            classNamePrevious = false;
            break;
        }

        if (type != ANTLRv4Lexer.WS) {
          previous = type;
        }

        first = false;
      }
      result.determine(lastLine);
      result.setExtra(identifiers);
      identifiers.finish();
      error.analyze(content, result, delegate);

    } catch (IOException e) {
      e.printStackTrace();
      Log.e("TAG", e.getMessage());
    }
  }
}
