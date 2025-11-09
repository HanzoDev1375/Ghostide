package io.github.rosemoe.sora.langs.csharp;

import android.util.Log;

import org.antlr.parser.antlr4.csharp.CSharpLexer;
import org.antlr.parser.antlr4.csharp.CSharpParser;
import org.antlr.parser.antlr4.csharp.CSharpParserBaseListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.StringReader;
import java.util.Stack;
import java.util.regex.Pattern;

import io.github.rosemoe.sora.data.BlockLine;
import io.github.rosemoe.sora.data.RainbowBracketHelper;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import ir.ninjacoder.ghostide.core.GhostIdeAppLoader;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;

public class CSharpCodeAnalyzer implements CodeAnalyzer {

  private CSharpLexer lexer;
  RainbowBracketHelper he;

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {

    try {
      he = new RainbowBracketHelper(content);
      lexer = new CSharpLexer(CharStreams.fromReader(new StringReader(content.toString())));
      Stack<BlockLine> stack = new Stack<>();
      var info = new CsAutoComplete.Identifiers();
      info.begin();
      Token token;
      int type, currSwitch = 1, maxSwitch = 0, previous = -1;
      int lastline = 1;
      int line, column;
      while (delegate.shouldAnalyze()) {
        token = lexer.nextToken();
        if (token == null) break;
        type = token.getType();
        if (type == CSharpLexer.EOF) {
          lastline = token.getLine() - 1;
          break;
        }
        line = token.getLine() - 1;
        column = token.getCharPositionInLine();
        if (type == CSharpLexer.EOF) {
          lastline = line;
          break;
        }
        switch (type) {
          case CSharpLexer.WHITESPACES:
            result.addNormalIfNull();
            break;
          case CSharpLexer.ABSTRACT:
          case CSharpLexer.ADD:
          case CSharpLexer.ALIAS:
          case CSharpLexer.ARGLIST:
          case CSharpLexer.AS:
          case CSharpLexer.ASCENDING:
          case CSharpLexer.ASYNC:
          case CSharpLexer.AWAIT:
          case CSharpLexer.BASE:
          case CSharpLexer.BOOL:
          case CSharpLexer.BREAK:
          case CSharpLexer.BY:
          case CSharpLexer.BYTE:
          case CSharpLexer.CASE:
          case CSharpLexer.CATCH:
          case CSharpLexer.CHAR:
          case CSharpLexer.CHECKED:
          case CSharpLexer.CLASS:
          case CSharpLexer.CONST:
          case CSharpLexer.CONTINUE:
          case CSharpLexer.DECIMAL:
          case CSharpLexer.DEFAULT:
          case CSharpLexer.DELEGATE:
          case CSharpLexer.DESCENDING:
          case CSharpLexer.DO:
          case CSharpLexer.DOUBLE:
          case CSharpLexer.DYNAMIC:
          case CSharpLexer.ELSE:
          case CSharpLexer.ENUM:
          case CSharpLexer.EQUALS:
          case CSharpLexer.EVENT:
          case CSharpLexer.EXPLICIT:
          case CSharpLexer.EXTERN:
          case CSharpLexer.FALSE:
          case CSharpLexer.FINALLY:
          case CSharpLexer.FIXED:
          case CSharpLexer.FLOAT:
          case CSharpLexer.FOR:
          case CSharpLexer.FOREACH:
          case CSharpLexer.FROM:
          case CSharpLexer.GET:
          case CSharpLexer.GOTO:
          case CSharpLexer.GROUP:
          case CSharpLexer.IF:
          case CSharpLexer.IMPLICIT:
          case CSharpLexer.IN:
          case CSharpLexer.INT:
          case CSharpLexer.INTERFACE:
          case CSharpLexer.INTERNAL:
          case CSharpLexer.INTO:
          case CSharpLexer.IS:
          case CSharpLexer.JOIN:
          case CSharpLexer.LET:
          case CSharpLexer.LOCK:
          case CSharpLexer.LONG:
          case CSharpLexer.NAMEOF:
          case CSharpLexer.NAMESPACE:
          case CSharpLexer.NEW:
          case CSharpLexer.NULL_:
          case CSharpLexer.OBJECT:
          case CSharpLexer.ON:
          case CSharpLexer.OPERATOR:
          case CSharpLexer.ORDERBY:
          case CSharpLexer.OUT:
          case CSharpLexer.OVERRIDE:
          case CSharpLexer.PARAMS:
          case CSharpLexer.PARTIAL:
          case CSharpLexer.PRIVATE:
          case CSharpLexer.PROTECTED:
          case CSharpLexer.PUBLIC:
          case CSharpLexer.READONLY:
          case CSharpLexer.REF:
          case CSharpLexer.REMOVE:
          case CSharpLexer.RETURN:
          case CSharpLexer.SBYTE:
          case CSharpLexer.SEALED:
          case CSharpLexer.SELECT:
          case CSharpLexer.SET:
          case CSharpLexer.SHORT:
          case CSharpLexer.SIZEOF:
          case CSharpLexer.STACKALLOC:
          case CSharpLexer.STATIC:
          case CSharpLexer.STRING:
          case CSharpLexer.STRUCT:
          case CSharpLexer.SWITCH:
          case CSharpLexer.THIS:
          case CSharpLexer.THROW:
          case CSharpLexer.TRUE:
          case CSharpLexer.TRY:
          case CSharpLexer.TYPEOF:
          case CSharpLexer.UINT:
          case CSharpLexer.ULONG:
          case CSharpLexer.UNCHECKED:
          case CSharpLexer.UNMANAGED:
          case CSharpLexer.UNSAFE:
          case CSharpLexer.USHORT:
          case CSharpLexer.USING:
          case CSharpLexer.VAR:
          case CSharpLexer.VIRTUAL:
          case CSharpLexer.VOID:
          case CSharpLexer.VOLATILE:
          case CSharpLexer.WHEN:
          case CSharpLexer.WHERE:
          case CSharpLexer.WHILE:
          case CSharpLexer.YIELD:
            result.addIfNeeded(line, column, EditorColorScheme.javakeyword);
            break;

          case CSharpLexer.OPEN_BRACE:
            {
              he.handleOpenBracket(result, line, column, true);
              break;
            }
          case CSharpLexer.CLOSE_BRACE:
            {
              he.handleCloseBracket(result, line, column, true);
              break;
            }

          case CSharpLexer.OPEN_BRACKET:
          case CSharpLexer.OPEN_PARENS:
            he.handleOpenBracket(result, line, column, false);
            break;
          case CSharpLexer.CLOSE_BRACKET:
          case CSharpLexer.CLOSE_PARENS:
            he.handleCloseBracket(result, line, column, false);
            break;
          case CSharpLexer.DOT:
          case CSharpLexer.COMMA:
          case CSharpLexer.COLON:
          case CSharpLexer.SEMICOLON:
          case CSharpLexer.PLUS:
          case CSharpLexer.MINUS:
          case CSharpLexer.STAR:
          case CSharpLexer.DIV:
          case CSharpLexer.PERCENT:
          case CSharpLexer.AMP:
          case CSharpLexer.BITWISE_OR:
          case CSharpLexer.CARET:
          case CSharpLexer.BANG:
          case CSharpLexer.TILDE:
          case CSharpLexer.ASSIGNMENT:
          case CSharpLexer.LT:
          case CSharpLexer.GT:
          case CSharpLexer.INTERR:
          case CSharpLexer.DOUBLE_COLON:
          case CSharpLexer.OP_COALESCING:
          case CSharpLexer.OP_INC:
          case CSharpLexer.OP_DEC:
          case CSharpLexer.OP_AND:
          case CSharpLexer.OP_OR:
          case CSharpLexer.OP_PTR:
          case CSharpLexer.OP_EQ:
          case CSharpLexer.OP_NE:
          case CSharpLexer.OP_LE:
          case CSharpLexer.OP_GE:
          case CSharpLexer.OP_ADD_ASSIGNMENT:
          case CSharpLexer.OP_SUB_ASSIGNMENT:
          case CSharpLexer.OP_MULT_ASSIGNMENT:
          case CSharpLexer.OP_DIV_ASSIGNMENT:
          case CSharpLexer.OP_MOD_ASSIGNMENT:
          case CSharpLexer.OP_AND_ASSIGNMENT:
          case CSharpLexer.OP_OR_ASSIGNMENT:
          case CSharpLexer.OP_XOR_ASSIGNMENT:
          case CSharpLexer.OP_LEFT_SHIFT:
          case CSharpLexer.OP_LEFT_SHIFT_ASSIGNMENT:
          case CSharpLexer.OP_COALESCING_ASSIGNMENT:
          case CSharpLexer.OP_RANGE:
            result.addIfNeeded(line, column, EditorColorScheme.HTML_TAG);
            break;
          case CSharpLexer.REGULAR_STRING:
            result.addIfNeeded(line, column, EditorColorScheme.javastring);
            break;
          case CSharpLexer.DIGITS:
          case CSharpLexer.LITERAL_ACCESS:
          case CSharpLexer.INTEGER_LITERAL:
          case CSharpLexer.HEX_INTEGER_LITERAL:
          case CSharpLexer.BIN_INTEGER_LITERAL:
          case CSharpLexer.REAL_LITERAL:
            result.addIfNeeded(line, column, EditorColorScheme.javanumber);
            break;
          case CSharpLexer.DEFINE:
          case CSharpLexer.UNDEF:
          case CSharpLexer.ELIF:
          case CSharpLexer.ENDIF:
          case CSharpLexer.LINE:
          case CSharpLexer.ERROR:
          case CSharpLexer.WARNING:
          case CSharpLexer.REGION:
          case CSharpLexer.ENDREGION:
          case CSharpLexer.PRAGMA:
          case CSharpLexer.NULLABLE:
          case CSharpLexer.DIRECTIVE_HIDDEN:
          case CSharpLexer.CONDITIONAL_SYMBOL:
          case CSharpLexer.DOUBLE_CURLY_CLOSE_INSIDE:
            result.addIfNeeded(line, column, EditorColorScheme.javatype);
            break;
          case CSharpLexer.SINGLE_LINE_DOC_COMMENT:
          case CSharpLexer.EMPTY_DELIMITED_DOC_COMMENT:
          case CSharpLexer.DELIMITED_COMMENT:
          case CSharpLexer.DELIMITED_DOC_COMMENT:
          case CSharpLexer.SHARP:
            result.addIfNeeded(line, column, EditorColorScheme.COMMENT);
            break;

          case CSharpLexer.IDENTIFIER:
            {
              boolean isClassName = false;
              int mcolor = EditorColorScheme.TEXT_NORMAL;

              if (previous == CSharpLexer.ABSTRACT
                  || previous == CSharpLexer.USING
                  || previous == CSharpLexer.DELEGATE
                  || previous == CSharpLexer.VOID
                  || previous == CSharpLexer.CLASS
                  || previous == CSharpLexer.VAR
                  || previous == CSharpLexer.IDENTIFIER) {
                mcolor = EditorColorScheme.javaoprator;
                isClassName = true;
                if (lexer._input.LA(1) == '(') {
                  mcolor = EditorColorScheme.javafun;
                }
              } else if (previous == CSharpLexer.BOOL
                  || previous == CSharpLexer.AS
                  || previous == CSharpLexer.IS
                  || previous == CSharpLexer.STRING) {
                mcolor = EditorColorScheme.javakeywordoprator;
              } else if (previous == CSharpLexer.DOT) {
                mcolor = EditorColorScheme.javatype;
              } else if (previous == CSharpLexer.NAMESPACE) {
                mcolor = EditorColorScheme.jsoprator;
              } else if (ObjectUtils.getNextLexer(lexer, '.')) {
                mcolor = EditorColorScheme.tscolormatch1;
              } else if (ObjectUtils.getNextLexer(lexer, ':')) {
                mcolor = EditorColorScheme.tscolormatch2;
              } else if (lexer._input.LA(1) == '[' || lexer._input.LA(1) == ']') {
                mcolor = EditorColorScheme.tscolormatch4;
              } else if (!isClassName && Character.isUpperCase(token.getText().charAt(0))) {
                Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z0-9_]*$");
                var matcher = pattern.matcher(token.getText());
                if (matcher.matches()) {
                  mcolor = EditorColorScheme.javaparament;
                }
              }

              result.addIfNeeded(line, column, TextStyle.makeStyle(mcolor,0,isClassName,false,false));
              break;
            }
          default:
            result.addIfNeeded(line, column, EditorColorScheme.TEXT_NORMAL);
            break;
        }
        if (type != CSharpLexer.WHITESPACES) {
          previous = type;
        }
      }
      result.determine(lastline);
      result.setExtra(info);
      info.finish();
      try {
        if (GhostIdeAppLoader.getAnalyzercod().getBoolean("Analyzercod", false) == true) {
          var antlrinputstream = new ANTLRInputStream(content.toString());
          var lexer = new CSharpLexer(antlrinputstream);
          var stream = new CommonTokenStream(lexer);
          var paser = new CSharpParser(stream);
          var base =
              new CSharpParserBaseListener() {

                @Override
                public void visitErrorNode(ErrorNode node) {
                  var lines = node.getSymbol().getLine();
                  var col = node.getSymbol().getCharPositionInLine();
                  var text = node.getText().toString();
                  int[] error = Utils.setErrorSpan(result, lines, col);
                }
              };
          var treeWalk = new ParseTreeWalker();
          treeWalk.walk(base, paser.compilation_unit());
        }
      } catch (Exception err) {
        Log.e("Analyzercode Error by ", err.getMessage());
      }

    } catch (Exception err) {
      Log.e("Lexer Error : ", err.getMessage());
    }
  }
}
