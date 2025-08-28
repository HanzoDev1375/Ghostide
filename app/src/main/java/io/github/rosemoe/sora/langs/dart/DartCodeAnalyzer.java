package io.github.rosemoe.sora.langs.dart;

import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.langs.dart.dartserver.DartAuto;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import java.util.regex.Pattern;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

import java.io.IOException;
import java.io.StringReader;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import io.github.rosemoe.sora.data.RainbowBracketHelper;

public class DartCodeAnalyzer implements CodeAnalyzer {
  private String[] getColor = {"red", "blue", "green"};

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    try {
      CodePointCharStream stream = CharStreams.fromReader(new StringReader(content.toString()));
      Dart2LexerCompat lexer = new Dart2LexerCompat(stream);
      RainbowBracketHelper helper = new RainbowBracketHelper(content);
      Token token;
      DartAuto.Identifiers auto = new DartAuto.Identifiers();
      auto.begin();
      boolean first = true;
      int type, previous = -1;
      int lastLine = 1;
      int line, column;

      while (delegate.shouldAnalyze()) {
        token = lexer.nextToken();
        if (token == null) break;
        if (token.getType() == Dart2LexerCompat.EOF) {
          lastLine = token.getLine() - 1;
          break;
        }
        line = token.getLine() - 1;
        column = token.getCharPositionInLine();
        lastLine = line;
        type = token.getType();
        // Log.d("test",token.getText()+"  "+token.getType());
        if (type == Dart2LexerCompat.EOF) {
          lastLine = line;
          break;
        }
        switch (type) {
          case Dart2LexerCompat.WHITESPACE:
            if (first) result.addNormalIfNull();
            break;

          case Dart2LexerCompat.CB:
          case Dart2LexerCompat.CBC:
          case Dart2LexerCompat.CP:
            helper.handleCloseBracket(result, line, column);
            break;
          case Dart2LexerCompat.OB:
          case Dart2LexerCompat.OBC:
          case Dart2LexerCompat.OP:
            helper.handleOpenBracket(result, line, column);
            break;
          case Dart2LexerCompat.A:
          case Dart2LexerCompat.AA:
          case Dart2LexerCompat.AE:
          case Dart2LexerCompat.AT:
          case Dart2LexerCompat.C:
          case Dart2LexerCompat.CIR:
          case Dart2LexerCompat.CIRE:
          case Dart2LexerCompat.CO:
          case Dart2LexerCompat.D:
          case Dart2LexerCompat.DD:
          case Dart2LexerCompat.DDD:
          case Dart2LexerCompat.EE:
          case Dart2LexerCompat.EG:
          case Dart2LexerCompat.EQ:
          case Dart2LexerCompat.GT:
          case Dart2LexerCompat.LT:
          case Dart2LexerCompat.LTE:
          case Dart2LexerCompat.LTLT:
          case Dart2LexerCompat.LTLTE:
          case Dart2LexerCompat.ME:
          case Dart2LexerCompat.MINUS:
          case Dart2LexerCompat.MM:
          case Dart2LexerCompat.NE:
            //  case Dart2LexerCompat.NOT:
          case Dart2LexerCompat.P:
          case Dart2LexerCompat.PC:
            // case Dart2LexerCompat.PE:
          case Dart2LexerCompat.PL:
          case Dart2LexerCompat.PLE:
          case Dart2LexerCompat.PLPL:
          case Dart2LexerCompat.POE:
          case Dart2LexerCompat.PP:
          case Dart2LexerCompat.QU:
          case Dart2LexerCompat.QUD:
          case Dart2LexerCompat.QUDD:
          case Dart2LexerCompat.QUQU:
          case Dart2LexerCompat.QUQUEQ:
          case Dart2LexerCompat.SC:
          case Dart2LexerCompat.SE:
          case Dart2LexerCompat.SL:
          case Dart2LexerCompat.SQS:
          case Dart2LexerCompat.SQSE:
          case Dart2LexerCompat.SQUIG:
          case Dart2LexerCompat.ST:
          case Dart2LexerCompat.STE:
            result.addIfNeeded(line, column, EditorColorScheme.javaoprator);
            break;
          case Dart2LexerCompat.ABSTRACT_:
          case Dart2LexerCompat.AS_:
          case Dart2LexerCompat.ASSERT_:
          case Dart2LexerCompat.ASYNC_:
          case Dart2LexerCompat.AWAIT_:
          case Dart2LexerCompat.BREAK_:
          case Dart2LexerCompat.CASE_:
          case Dart2LexerCompat.CATCH_:
          case Dart2LexerCompat.CLASS_:
          case Dart2LexerCompat.CONST_:
          case Dart2LexerCompat.CONTINUE_:
          case Dart2LexerCompat.COVARIANT_:
          case Dart2LexerCompat.DEFAULT_:
          case Dart2LexerCompat.DEFERRED_:
          case Dart2LexerCompat.DO_:
          case Dart2LexerCompat.DYNAMIC_:
          case Dart2LexerCompat.ELSE_:
          case Dart2LexerCompat.ENUM_:
          case Dart2LexerCompat.EXPORT_:
          case Dart2LexerCompat.EXTENDS_:
          case Dart2LexerCompat.EXTENSION_:
          case Dart2LexerCompat.EXTERNAL_:
          case Dart2LexerCompat.FACTORY_:
          case Dart2LexerCompat.FALSE_:
          case Dart2LexerCompat.FINAL_:
          case Dart2LexerCompat.FINALLY_:
          case Dart2LexerCompat.FOR_:
          case Dart2LexerCompat.FUNCTION_:
          case Dart2LexerCompat.GET_:
            //  case Dart2LexerCompat.GTILDE_:
          case Dart2LexerCompat.HIDE_:
          case Dart2LexerCompat.IF_:
          case Dart2LexerCompat.IMPLEMENTS_:
          case Dart2LexerCompat.IMPORT_:
          case Dart2LexerCompat.IN_:
          case Dart2LexerCompat.INTERFACE_:
          case Dart2LexerCompat.IS_:
          case Dart2LexerCompat.LATE_:
            //     case Dart2LexerCompat.LET_:
          case Dart2LexerCompat.LIBRARY_:
          case Dart2LexerCompat.MIXIN_:
          case Dart2LexerCompat.NATIVE_:
          case Dart2LexerCompat.NEW_:
          case Dart2LexerCompat.NULL_:
            //   case Dart2LexerCompat.OF_:
          case Dart2LexerCompat.ON_:
          case Dart2LexerCompat.OPERATOR_:
          case Dart2LexerCompat.PART_:
          case Dart2LexerCompat.REQUIRED_:
          case Dart2LexerCompat.RETHROW_:
          case Dart2LexerCompat.RETURN_:
          case Dart2LexerCompat.SET_:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.javakeyword, 0, false, true, false));
            break;

          case Dart2LexerCompat.SHOW_:
          case Dart2LexerCompat.STATIC_:
          case Dart2LexerCompat.SUPER_:
          case Dart2LexerCompat.SWITCH_:
          case Dart2LexerCompat.SYNC_:
          case Dart2LexerCompat.THIS_:
          case Dart2LexerCompat.THROW_:
          case Dart2LexerCompat.TRUE_:
          case Dart2LexerCompat.TRY_:
          case Dart2LexerCompat.TYPEDEF_:
          case Dart2LexerCompat.VAR_:
          case Dart2LexerCompat.WHILE_:
          case Dart2LexerCompat.WITH_:
          case Dart2LexerCompat.YIELD_:
          case Dart2LexerCompat.VOID_:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.javakeywordoprator, 0, true, false, false));
            break;
          case Dart2LexerCompat.STRING:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.javastring, 0, true, false, false));
            break;
            // 注释
          case Dart2LexerCompat.SINGLE_LINE_COMMENT:
          case Dart2LexerCompat.MULTI_LINE_COMMENT:
            result.addIfNeeded(line, column, EditorColorScheme.COMMENT);
            break;
          case Dart2LexerCompat.IDENTIFIER:
            {
              int colorid = EditorColorScheme.TEXT_NORMAL;
              boolean hasUpperCase = false;
              auto.addIdentifier(token.getText());
              // pre
              if (previous == Dart2LexerCompat.FINAL_) {
                colorid = EditorColorScheme.javafield;
                hasUpperCase = true;
              }
              if (previous == Dart2LexerCompat.CONST_
                  || previous == Dart2LexerCompat.CLASS_
                  || previous == Dart2LexerCompat.STATIC_
                  || previous == Dart2LexerCompat.VOID_) {
                colorid = EditorColorScheme.javafun;
                hasUpperCase = true;
              }
              if (previous == Dart2LexerCompat.FACTORY_) {
                colorid = EditorColorScheme.htmlattr;
                hasUpperCase = true;
              }
              if (previous == Dart2LexerCompat.AT) {
                colorid = EditorColorScheme.javaoprator;
              }
              if (previous == Dart2LexerCompat.RETURN_) {
                colorid = EditorColorScheme.htmltag;
                hasUpperCase = true;
              }

              // next
              if (ObjectUtils.getNextLexer(lexer, '(')) {
                colorid = EditorColorScheme.tsattr;
              }
              if (ObjectUtils.getNextLexer(lexer, '.')) {
                colorid = EditorColorScheme.tscolormatch1;
              }
              if (ObjectUtils.getNextLexer(lexer, ',')) {
                colorid = EditorColorScheme.tscolormatch3;
              }
              if (ObjectUtils.getNextLexer(lexer, ')')) {
                colorid = EditorColorScheme.tscolormatch3;
              }
              // -> str
              if (ObjectUtils.getNextLexer(lexer, '>')) {
                colorid = EditorColorScheme.pycolormatch4;
              }
              if (ObjectUtils.getNextLexer(lexer, ':')) {
                colorid = EditorColorScheme.jskeyword;
              }

              result.addIfNeeded(line, column, colorid);
			  break;
            }

          default:
            result.addIfNeeded(line, column, EditorColorScheme.TEXT_NORMAL);
            break;
        }
        if (type != Dart2LexerCompat.WHITESPACE) {
          previous = type;
        }
        first = false;
      }

      if (GhostIdeAppLoader.getAnalyzercod().getBoolean("Analyzercod", false) == true) {
        var inputStream = new ANTLRInputStream(content.toString());
        var mlexer = new Dart2Lexer(inputStream);
        var stream1 = new CommonTokenStream(mlexer);
        var paser = new Dart2Parser(stream1);
        var base =
            new Dart2ParserBaseListener() {
              @Override
              public void visitErrorNode(ErrorNode node) {
                super.visitErrorNode(node);
                // TODO: Implement this method
                Utils.setErrorSpan(
                    result, node.getSymbol().getLine(), node.getSymbol().getCharPositionInLine());
              }
            };
        ParseTreeWalker.DEFAULT.walk(base, paser.compilationUnit());
      }
      result.determine(lastLine);
      auto.finish();
      result.setExtra(auto);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
