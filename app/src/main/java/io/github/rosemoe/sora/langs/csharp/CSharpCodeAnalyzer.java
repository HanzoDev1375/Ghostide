package io.github.rosemoe.sora.langs.csharp;

import android.util.Log;
import io.github.rosemoe.sora.data.BlockLine;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import java.io.StringReader;
import java.util.Stack;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

public class CSharpCodeAnalyzer implements CodeAnalyzer {

  private CSharpLexer lexer;
  private int line, lastline, column, type, previous = -1;

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {

    try {
      lexer = new CSharpLexer(CharStreams.fromReader(new StringReader(content.toString())));
      Stack<BlockLine> stack = new Stack<>();
      var info = new CsAutoComplete.Identifiers();
      info.begin();
      Token token;
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
              BlockLine block = result.obtainNewBlock();
              block.startLine = line;
              block.startColumn = column;
              stack.push(block);
              result.addIfNeeded(line, column, EditorColorScheme.javaoprator);
              break;
            }
          case CSharpLexer.CLOSE_BRACE:
            {
              if (!stack.isEmpty()) {
                BlockLine b = stack.pop();
                b.endLine = line;
                b.endColumn = column;

                if (b.startLine != b.endLine) {
                  result.addBlockLine(b);
                }
              }
              result.addIfNeeded(line, column, EditorColorScheme.javaoprator);
              break;
            }

          case CSharpLexer.OPEN_BRACKET:
          case CSharpLexer.CLOSE_BRACKET:
          case CSharpLexer.OPEN_PARENS:
          case CSharpLexer.CLOSE_PARENS:
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
              info.addIdentifier(token.getText());
              int color = EditorColorScheme.TEXT_NORMAL;
              if (previous == CSharpLexer.ABSTRACT
                  || previous == CSharpLexer.USING
                  || previous == CSharpLexer.DELEGATE
                  || previous == CSharpLexer.VAR) {
                color = EditorColorScheme.javaparament;
              }
              if (previous == CSharpLexer.BOOL || previous == CSharpLexer.AS) {
                color = EditorColorScheme.javafield;
              }
              if (previous == CSharpLexer.DOT
                  || previous == CSharpLexer.OPEN_BRACE
                  || previous == CSharpLexer.CLOSE_BRACE) {
                color = EditorColorScheme.javafun;
              }
              if (token.getText().equals("Console")) {
                color = EditorColorScheme.ATTRIBUTE_VALUE;
              }
              result.addIfNeeded(line,column,color);
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

    } catch (Exception err) {
      Log.e("Lexer Error : ", err.getMessage());
    }
  }
}
