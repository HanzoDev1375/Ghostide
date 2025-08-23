package io.github.rosemoe.sora.langs.rust;

import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import ir.ninjacoder.ghostide.IdeEditor;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import java.io.StringReader;
import java.util.regex.Pattern;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.Token;
import io.github.rosemoe.sora.data.RainbowBracketHelper;

public class RustCodeAnalyzer implements CodeAnalyzer {
  private RainbowBracketHelper helper;
  private IdeEditor editor;
  private RustLexer lexer;

  public RustCodeAnalyzer(IdeEditor editor) {
    this.editor = editor;
  }

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {

    try {
      CodePointCharStream stream = CharStreams.fromReader(new StringReader(content.toString()));
      lexer = new RustLexer(stream);
      Token token;

      int line, column;
      int lastLine = 1;
      int previous = -1;
      helper = new RainbowBracketHelper(content);
      while (delegate.shouldAnalyze()) {
        token = lexer.nextToken();
        if (token == null) break;
        if (token.getType() == RustLexer.EOF) {
          lastLine = token.getLine() - 1;
          break;
        }
        line = token.getLine() - 1;
        column = token.getCharPositionInLine();
        lastLine = line;

        switch (token.getType()) {
          case RustLexer.WHITESPACE:
          case RustLexer.NEWLINE:
            result.addNormalIfNull();
            break;
            // rust keyword -> javakeyword
          case RustLexer.KW_AS:
          case RustLexer.KW_BREAK:
          case RustLexer.KW_CONST:
          case RustLexer.KW_CONTINUE:
          case RustLexer.KW_CRATE:
          case RustLexer.KW_ELSE:
          case RustLexer.KW_ENUM:
          case RustLexer.KW_EXTERN:
          case RustLexer.KW_FALSE:
          case RustLexer.KW_FN:
          case RustLexer.KW_FOR:
          case RustLexer.KW_IF:
          case RustLexer.KW_IMPL:
          case RustLexer.KW_IN:
          case RustLexer.KW_LET:
          case RustLexer.KW_LOOP:
          case RustLexer.KW_MATCH:
          case RustLexer.KW_MOD:
          case RustLexer.KW_MOVE:
          case RustLexer.KW_MUT:
          case RustLexer.KW_PUB:
          case RustLexer.KW_REF:
          case RustLexer.KW_RETURN:
          case RustLexer.KW_SELFVALUE:
          case RustLexer.KW_SELFTYPE:
          case RustLexer.KW_STATIC:
          case RustLexer.KW_STRUCT:
          case RustLexer.KW_SUPER:
          case RustLexer.KW_TRAIT:
          case RustLexer.KW_TRUE:
          case RustLexer.KW_TYPE:
          case RustLexer.KW_UNSAFE:
          case RustLexer.KW_USE:
          case RustLexer.KW_WHERE:
          case RustLexer.KW_WHILE:
          case RustLexer.KW_ASYNC:
          case RustLexer.KW_AWAIT:
          case RustLexer.KW_DYN:
          case RustLexer.KW_ABSTRACT:
          case RustLexer.KW_BECOME:
          case RustLexer.KW_BOX:
          case RustLexer.KW_DO:
          case RustLexer.KW_FINAL:
          case RustLexer.KW_MACRO:
          case RustLexer.KW_OVERRIDE:
          case RustLexer.KW_PRIV:
          case RustLexer.KW_TYPEOF:
          case RustLexer.KW_UNSIZED:
          case RustLexer.KW_VIRTUAL:
          case RustLexer.KW_YIELD:
          case RustLexer.KW_TRY:
          case RustLexer.KW_UNION:
          case RustLexer.KW_STATICLIFETIME:
          case RustLexer.KW_MACRORULES:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.javakeyword, 0, true, false, false));
            break;

            // rust symobol +='/'
          case RustLexer.PLUS:
          case RustLexer.MINUS:
          case RustLexer.STAR:
          case RustLexer.SLASH:
          case RustLexer.PERCENT:
          case RustLexer.CARET:
          case RustLexer.NOT:
          case RustLexer.AND:
          case RustLexer.OR:
          case RustLexer.ANDAND:
          case RustLexer.OROR:
          case RustLexer.PLUSEQ:
          case RustLexer.MINUSEQ:
          case RustLexer.STAREQ:
          case RustLexer.SLASHEQ:
          case RustLexer.PERCENTEQ:
          case RustLexer.CARETEQ:
          case RustLexer.ANDEQ:
          case RustLexer.OREQ:
          case RustLexer.SHLEQ:
          case RustLexer.SHREQ:
          case RustLexer.EQ:
          case RustLexer.EQEQ:
          case RustLexer.NE:
          case RustLexer.GT:
          case RustLexer.LT:
          case RustLexer.GE:
          case RustLexer.LE:
          case RustLexer.AT:
          case RustLexer.UNDERSCORE:
          case RustLexer.DOT:
          case RustLexer.DOTDOT:
          case RustLexer.DOTDOTDOT:
          case RustLexer.DOTDOTEQ:
          case RustLexer.COMMA:
          case RustLexer.SEMI:
          case RustLexer.COLON:
          case RustLexer.PATHSEP:
          case RustLexer.RARROW:
          case RustLexer.FATARROW:
          case RustLexer.POUND:
          case RustLexer.DOLLAR:
          case RustLexer.QUESTION:
            result.addIfNeeded(line, column, EditorColorScheme.javaoprator);
            break;
          case RustLexer.LCURLYBRACE:
          case RustLexer.LSQUAREBRACKET:
          case RustLexer.LPAREN:
            helper.handleOpenBracket(result, line, column);
            break;
          case RustLexer.RCURLYBRACE:
          case RustLexer.RSQUAREBRACKET:
          case RustLexer.RPAREN:
            helper.handleCloseBracket(result, line, column);
            break;
          case RustLexer.INTEGER_LITERAL:
            result.addIfNeeded(line, column, EditorColorScheme.javaoprator);
            break;
          case RustLexer.FLOAT_LITERAL:
            result.addIfNeeded(line, column, EditorColorScheme.javatype);
            break;
          case RustLexer.STRING_LITERAL:
          case RustLexer.CHAR_LITERAL:
            result.addIfNeeded(line, column, EditorColorScheme.javastring);
            break;
          case RustLexer.NON_KEYWORD_IDENTIFIER:
            {
              int colorid = EditorColorScheme.TEXT_NORMAL;
              if (previous == RustLexer.KW_STATIC) {
                colorid = EditorColorScheme.javafun;
              }
              if (previous == RustLexer.KW_FN) {
                colorid = EditorColorScheme.javafun;
              }
              if (previous == RustLexer.LT) {
                colorid = EditorColorScheme.javanumber;
              }
              if (previous == RustLexer.COLON || previous == RustLexer.PATHSEP) {
                colorid = EditorColorScheme.pycolormatch3;
              }
              if (ObjectUtils.getNextLexer(lexer, '(')) {
                colorid = EditorColorScheme.javafun;
              }
              if (ObjectUtils.getNextLexer(lexer, ':')) {
                colorid = EditorColorScheme.tsattr;
              }
              if (ObjectUtils.getNextLexer(lexer, '.')) {
                colorid = EditorColorScheme.tskeyword;
              }
              if (ObjectUtils.getNextLexer(lexer, '<')) {
                colorid = EditorColorScheme.tssymbols;
              }
              if (ObjectUtils.getNextLexer(lexer, '!')) {
                colorid = EditorColorScheme.pysymbol;
              }
              if (previous == RustLexer.KW_MUT
                  || previous == RustLexer.KW_MATCH
                  || previous == RustLexer.KW_LET) {
                colorid = EditorColorScheme.pycolormatch1;
              }
              result.addIfNeeded(line, column, colorid);
              break;
            }
        }
        if (token.getType() != RustLexer.NEWLINE && token.getType() != RustLexer.WHITESPACE) {
          previous = token.getType();
        }
      }

      result.determine(lastLine);
    } catch (Exception err) {

    }
  }
}
