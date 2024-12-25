package io.github.rosemoe.sora.langs.Javacc;

import ir.ninjacoder.ghostide.IdeEditor;
import android.util.Log;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.langs.java.JavaAutoComplete;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import java.io.StringReader;
import java.lang.ref.WeakReference;
import org.antlr.parser.antlr4.Javacc.JavaccBaseListener;
import org.antlr.parser.antlr4.Javacc.JavaccLexer;
import org.antlr.parser.antlr4.Javacc.JavaccParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class JavaccCodeAnalyzer implements CodeAnalyzer {

  private IdeEditor editor;
  private final WeakReference<IdeEditor> mEditorReference;

  public JavaccCodeAnalyzer(IdeEditor editor) {
    this.editor = editor;
    mEditorReference = new WeakReference<>(editor);
  }

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {

    try {
      var stream = CharStreams.fromReader(new StringReader(content.toString()));
      JavaAutoComplete auto = new JavaAutoComplete(editor);
      JavaAutoComplete.Identifiers info = new JavaAutoComplete.Identifiers();
      var lexer = new JavaccLexer(stream);
      Token token = null;
      int line = 0, lastline = 1, column = 0, type = 0, previous = -1;
      while (delegate.shouldAnalyze()) {
        token = lexer.nextToken();
        type = token.getType();

        info.begin();
        if (type == JavaccLexer.EOF) {
          lastline = lexer.getLine() - 1;
          break;
        }
        line = lexer.getLine() - 1;
        column = lexer.getCharPositionInLine();
        if (type == JavaccLexer.EOF) {
          lastline = line;
          break;
        }
        switch (type) {
          case JavaccLexer.WS:
            result.addNormalIfNull();
            break;
          case JavaccLexer.LOOKAHEAD:
          case JavaccLexer.IGNORE_CASE:
          case JavaccLexer.PARSER_BEGIN:
          case JavaccLexer.PARSER_END:
          case JavaccLexer.JAVACODE:
          case JavaccLexer.CPPCODE:
          case JavaccLexer.TOKEN:
          case JavaccLexer.SPECIAL_TOKEN:
          case JavaccLexer.MORE_:
          case JavaccLexer.SKIP_:
          case JavaccLexer.TOKEN_MGR_DECLS:
          case JavaccLexer.EOF_:
          case JavaccLexer.DCL_PARSER_BEGIN:
          case JavaccLexer.DCL_PARSER_END:
          case JavaccLexer.INC_PARSER_BEGIN:
          case JavaccLexer.INC_PARSER_END:
          case JavaccLexer.DEF_PARSER_BEGIN:
          case JavaccLexer.DEF_PARSER_END:
            result.addIfNeeded(line, column, EditorColorScheme.ATTRIBUTE_NAME);
            break;
          case JavaccLexer.ABSTRACT:
          case JavaccLexer.ASSERT:
          case JavaccLexer.BREAK:
          case JavaccLexer.CASE:
          case JavaccLexer.CATCH:
          case JavaccLexer.CLASS:
          case JavaccLexer.CONST:
          case JavaccLexer.CONTINUE:
          case JavaccLexer.DEFAULT:
          case JavaccLexer.DO:
          case JavaccLexer.ELSE:
          case JavaccLexer.EXTENDS:
          case JavaccLexer.FINAL:
          case JavaccLexer.FINALLY:
          case JavaccLexer.FOR:
          case JavaccLexer.IF:
          case JavaccLexer.GOTO:
          case JavaccLexer.IMPLEMENTS:
          case JavaccLexer.IMPORT:
          case JavaccLexer.INSTANCEOF:
          case JavaccLexer.INTERFACE:
          case JavaccLexer.NATIVE:
          case JavaccLexer.NEW:
          case JavaccLexer.PACKAGE:
          case JavaccLexer.PRIVATE:
          case JavaccLexer.PROTECTED:
          case JavaccLexer.PUBLIC:
          case JavaccLexer.RETURN:
          case JavaccLexer.STATIC:
          case JavaccLexer.STRICTFP:
          case JavaccLexer.SUPER:
          case JavaccLexer.SWITCH:
          case JavaccLexer.SYNCHRONIZED:
          case JavaccLexer.THIS:
          case JavaccLexer.THROW:
          case JavaccLexer.THROWS:
          case JavaccLexer.TRANSIENT:
          case JavaccLexer.TRY:
          case JavaccLexer.VOID:
          case JavaccLexer.VOLATILE:
          case JavaccLexer.WHILE:
          case JavaccLexer.TEMPLATE:
          case JavaccLexer.TYPENAME:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.javakeyword, 0, true, false, false));
            break;
          case JavaccLexer.LPAREN:
          case JavaccLexer.RPAREN:
          case JavaccLexer.LBRACE:
          case JavaccLexer.RBRACE:
          case JavaccLexer.LBRACKET:
          case JavaccLexer.RBRACKET:
          case JavaccLexer.SEMICOLON:
          case JavaccLexer.COMMA:
          case JavaccLexer.DOT:
          case JavaccLexer.ASSIGN:
          case JavaccLexer.LT:
          case JavaccLexer.BANG:
          case JavaccLexer.TILDE:
          case JavaccLexer.HOOK:
          case JavaccLexer.COLON:
          case JavaccLexer.DOUBLECOLON:
          case JavaccLexer.EQ:
          case JavaccLexer.LE:
          case JavaccLexer.GE:
          case JavaccLexer.NE:
          case JavaccLexer.SC_OR:
          case JavaccLexer.SC_AND:
          case JavaccLexer.INCR:
          case JavaccLexer.DECR:
          case JavaccLexer.PLUS:
          case JavaccLexer.MINUS:
          case JavaccLexer.STAR:
          case JavaccLexer.SLASH:
          case JavaccLexer.BIT_AND:
          case JavaccLexer.BIT_OR:
          case JavaccLexer.XOR:
          case JavaccLexer.REM:
          case JavaccLexer.PLUSASSIGN:
          case JavaccLexer.MINUSASSIGN:
          case JavaccLexer.STARASSIGN:
          case JavaccLexer.SLASHASSIGN:
          case JavaccLexer.ANDASSIGN:
          case JavaccLexer.ORASSIGN:
          case JavaccLexer.XORASSIGN:
          case JavaccLexer.REMASSIGN:
            result.addIfNeeded(line, column, EditorColorScheme.javaoprator);
            break;
          case JavaccLexer.INTEGER_LITERAL:
          case JavaccLexer.FLOATING_POINT_LITERAL:
            result.addIfNeeded(line, column, EditorColorScheme.javatype);
            break;
          case JavaccLexer.STRING_LITERAL:
            result.addIfNeeded(line, column, EditorColorScheme.javastring);
            break;
          case JavaccLexer.COMMENT:
          case JavaccLexer.LINE_COMMENT:
            result.addIfNeeded(line, column, EditorColorScheme.COMMENT);
            break;

          case JavaccLexer.IDENTIFIER:
            {
              info.addIdentifier(token.getText());
              int colorid = EditorColorScheme.TEXT_NORMAL;
              if (previous == JavaccLexer.DOT) {
                colorid = EditorColorScheme.javafun;
              }
              if (token.getText().matches("\\@") || token.getText().matches("\\@\\w+")) {
                colorid = EditorColorScheme.javafun;
              }

              result.addIfNeeded(line, column, colorid);
              break;
            }
          default:
            result.addIfNeeded(line, column, EditorColorScheme.TEXT_NORMAL);
            break;
        }
        if (type != JavaccLexer.WS) {
          previous = type;
        }
      }

      result.determine(lastline);
      result.setExtra(info);
      info.finish();

      var antlrinputstream = new ANTLRInputStream(token.getText().toString());
      var mlexer = new JavaccLexer(antlrinputstream);
      var mstream = new CommonTokenStream(mlexer);
      var paser = new JavaccParser(mstream);
      var base =
          new JavaccBaseListener() {

            @Override
            public void visitErrorNode(ErrorNode node) {
              var li = node.getSymbol().getLine() - 1;
              var col = node.getSymbol().getCharPositionInLine();
              var text = node.getText().toString();
              Utils.setErrorSpan(result, li - 1, col);
            }
          };
      var treeWalk = new ParseTreeWalker();
      treeWalk.walk(base, paser.javacc_input());

    } catch (Exception err) {
      Log.w("Error Lexer: ", err.getMessage());
    }
  }

  @Override
  public void analyzeInBackground(CharSequence contents) {
    IdeEditor editor = mEditorReference.get();
    if (editor == null) {
      return;
    }
  }
}
