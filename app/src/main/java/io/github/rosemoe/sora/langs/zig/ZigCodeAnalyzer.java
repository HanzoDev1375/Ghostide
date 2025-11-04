package io.github.rosemoe.sora.langs.zig;

import io.github.rosemoe.sora.data.RainbowBracketHelper;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.langs.internal.CodeHighlighter;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import ir.ninjacoder.codesnap.antlr4.zig.ZigLexer;
import ir.ninjacoder.ghostide.IdeEditor;
import java.io.StringReader;
import io.github.rosemoe.sora.langs.internal.*;
import java.util.regex.Pattern;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

public class ZigCodeAnalyzer implements CodeAnalyzer {
  private IdeEditor editor;

  public ZigCodeAnalyzer(IdeEditor editor) {
    this.editor = editor;
  }

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    try {
      var lexer = new ZigLexer(CharStreams.fromReader(new StringReader(content.toString())));
      Token token;
      var he = new RainbowBracketHelper(content);
      int type, previous = -1;
      int lastline = 1;
      int line, column;
      var info = new Identifiers();
      info.begin();
      while (delegate.shouldAnalyze()) {
        token = lexer.nextToken();
        if (token == null) {
          break;
        }
        type = token.getType();
        if (type == ZigLexer.EOF) {
          lastline = token.getLine() - 1;
          break;
        }
        line = token.getLine() - 1;
        column = token.getCharPositionInLine();
        if (type == ZigLexer.EOF) {
          lastline = line;
          break;
        }
        switch (type) {
          case ZigLexer.WHITESPACE:
            result.addNormalIfNull();
            break;
          case ZigLexer.ADDRSPACE:
          case ZigLexer.ALIGN:
          case ZigLexer.ALLOWZERO:
          case ZigLexer.AND:
          case ZigLexer.ANYFRAME:
          case ZigLexer.ANYTYPE:
          case ZigLexer.ASM:
          case ZigLexer.BREAK:
          case ZigLexer.CALLCONV:
          case ZigLexer.CATCH:
          case ZigLexer.COMPTIME:
          case ZigLexer.CONST:
          case ZigLexer.CONTINUE:
          case ZigLexer.DEFER:
          case ZigLexer.ELSE:
          case ZigLexer.ENUM:
          case ZigLexer.ERRDEFER:
          case ZigLexer.ERROR:
          case ZigLexer.EXPORT:
          case ZigLexer.EXTERN:
          case ZigLexer.FN:
          case ZigLexer.FOR:
          case ZigLexer.IF:
          case ZigLexer.INLINE:
          case ZigLexer.LINKSECTION:
          case ZigLexer.NOALIAS:
          case ZigLexer.NOINLINE:
          case ZigLexer.NOSUSPEND:
          case ZigLexer.OPAQUE:
          case ZigLexer.OR:
          case ZigLexer.ORELSE:
          case ZigLexer.PACKED:
          case ZigLexer.PUB:
          case ZigLexer.RESUME:
          case ZigLexer.RETURN:
          case ZigLexer.STRUCT:
          case ZigLexer.SUSPEND:
          case ZigLexer.SWITCH:
          case ZigLexer.TEST:
          case ZigLexer.THREADLOCAL:
          case ZigLexer.TRY:
          case ZigLexer.UNION:
          case ZigLexer.UNREACHABLE:
          case ZigLexer.VAR:
          case ZigLexer.VOLATILE:
          case ZigLexer.WHILE:
            result.addIfNeeded(line, column, EditorColorScheme.javakeyword);
            break;
          case ZigLexer.AMPERSAND:
          case ZigLexer.AMPERSANDEQUAL:
          case ZigLexer.ASTERISK:
          case ZigLexer.ASTERISK2:
          case ZigLexer.ASTERISKEQUAL:
          case ZigLexer.ASTERISKPERCENT:
          case ZigLexer.ASTERISKPERCENTEQUAL:
          case ZigLexer.ASTERISKPIPE:
          case ZigLexer.ASTERISKPIPEEQUAL:
          case ZigLexer.CARET:
          case ZigLexer.CARETEQUAL:
          case ZigLexer.COLON:
          case ZigLexer.COMMA:
          case ZigLexer.DOT:
          case ZigLexer.DOT2:
          case ZigLexer.DOT3:
          case ZigLexer.DOTASTERISK:
          case ZigLexer.DOTQUESTIONMARK:
          case ZigLexer.EQUAL:
          case ZigLexer.EQUALEQUAL:
          case ZigLexer.BUILTINIDENTIFIER:
          case ZigLexer.EQUALRARROW:
          case ZigLexer.EXCLAMATIONMARK:
          case ZigLexer.EXCLAMATIONMARKEQUAL:
          case ZigLexer.LARROW:
          case ZigLexer.LARROW2:
          case ZigLexer.LARROW2EQUAL:
          case ZigLexer.LARROW2PIPE:
          case ZigLexer.LARROW2PIPEEQUAL:
          case ZigLexer.LARROWEQUAL:

          case ZigLexer.MINUS:
          case ZigLexer.MINUSEQUAL:
          case ZigLexer.MINUSPERCENT:
          case ZigLexer.MINUSPERCENTEQUAL:
          case ZigLexer.MINUSPIPE:
          case ZigLexer.MINUSPIPEEQUAL:
          case ZigLexer.MINUSRARROW:
          case ZigLexer.PERCENT:
          case ZigLexer.PERCENTEQUAL:
          case ZigLexer.PIPE:
          case ZigLexer.PIPE2:
          case ZigLexer.PIPEEQUAL:
          case ZigLexer.PLUS:
          case ZigLexer.PLUS2:
          case ZigLexer.PLUSEQUAL:
          case ZigLexer.PLUSPERCENT:
          case ZigLexer.PLUSPERCENTEQUAL:
          case ZigLexer.PLUSPIPE:
          case ZigLexer.PLUSPIPEEQUAL:
          case ZigLexer.LETTERC:
          case ZigLexer.QUESTIONMARK:
          case ZigLexer.RARROW:
          case ZigLexer.RARROW2:
          case ZigLexer.RARROW2EQUAL:
          case ZigLexer.RARROWEQUAL:
          case ZigLexer.SEMICOLON:
          case ZigLexer.SLASH:
          case ZigLexer.SLASHEQUAL:
          case ZigLexer.TILDE:
            result.addIfNeeded(line, column, EditorColorScheme.javaoprator);
            break;
          case ZigLexer.LBRACE:
            he.handleOpenBracket(result, line, column, true);
            break;
          case ZigLexer.RBRACE:
            he.handleCloseBracket(result, line, column, true);
            break;
          case ZigLexer.RBRACKET:
          case ZigLexer.RPAREN:
            he.handleOpenBracket(result, line, column, false);
            break;

          case ZigLexer.LBRACKET:
          case ZigLexer.LPAREN:
            he.handleCloseBracket(result, line, column, false);
            break;

          case ZigLexer.Container_doc_comment:
          case ZigLexer.Doc_comment:
          case ZigLexer.Line_comment:
            CodeHighlighter.highlightFString(token.getText(), line, column, result);
            break;
          case ZigLexer.INTEGER:
          case ZigLexer.FLOAT:
            result.addIfNeeded(line, column, EditorColorScheme.javanumber);
            break;
          case ZigLexer.STRINGLITERAL:
          case ZigLexer.CHAR_LITERAL:
            result.addIfNeeded(line, column, EditorColorScheme.javastring);
            break;
          case ZigLexer.IDENTIFIER:
            {
              int mcolor = EditorColorScheme.TEXT_NORMAL;
              boolean isBold = false;
              boolean isClassName = false;
              boolean isShadow = false;
              info.addIdentifier(token.getText());
              if (previous == ZigLexer.CONST || previous == ZigLexer.VAR) {
                mcolor = EditorColorScheme.jsoprator;
                isBold = true;
              } else if (previous == ZigLexer.FN
                  || previous == ZigLexer.STRUCT
                  || previous == ZigLexer.ENUM
                  || previous == ZigLexer.UNION) {
                mcolor = EditorColorScheme.jsattr;
                isShadow = true;
                isBold = true;
                isClassName = true;
              } else if (previous == ZigLexer.COMPTIME) {
                mcolor = EditorColorScheme.tscolormatch1;
                isBold = true;
                if (lexer._input.LA(1) == '(') {
                  mcolor = EditorColorScheme.tscolormatch2;
                }
              } else if (lexer._input.LA(1) == '.') {
                mcolor = EditorColorScheme.pycolormatch1;
              } else if (lexer._input.LA(1) == '[' || lexer._input.LA(1) == ']') {
                mcolor = EditorColorScheme.pycolormatch2;
              } else if (lexer._input.LA(2) == '{') {
                mcolor = EditorColorScheme.tscolormatch7;
              } else if (previous == ZigLexer.DOT) {
                mcolor = EditorColorScheme.tscolormatch3;
              } else if (!isClassName && Character.isUpperCase(token.getText().charAt(0))) {
                Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z0-9_]*$");
                var matcher = pattern.matcher(token.getText());
                if (matcher.matches()) {
                  mcolor = EditorColorScheme.tsattr;
                }
              }

              result.addIfNeeded(
                  line, column, TextStyle.makeStyle(mcolor, 0, isBold, isClassName, false));
              break;
            }
          default:
            result.addIfNeeded(line, column, EditorColorScheme.TEXT_NORMAL);
            break;
        }
        if (type != ZigLexer.WHITESPACE) {
          previous = type;
        }
      }
      info.finish();
      result.determine(lastline);
      result.setExtra(info);
    } catch (Exception err) {

    }
  }
}
