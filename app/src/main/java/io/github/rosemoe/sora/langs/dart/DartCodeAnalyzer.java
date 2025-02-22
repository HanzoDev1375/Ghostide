package io.github.rosemoe.sora.langs.dart;

/*
 *    sora-editor - the awesome code editor for Android
 *    https://github.com/Rosemoe/CodeEditor
 *    Copyright (C) 2020-2021  Rosemoe
 *
 *     This library is free software; you can redistribute it and/or
 *     modify it under the terms of the GNU Lesser General Public
 *     License as published by the Free Software Foundation; either
 *     version 2.1 of the License, or (at your option) any later version.
 *
 *     This library is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *     Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public
 *     License along with this library; if not, write to the Free Software
 *     Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 *     USA
 *
 *     Please contact Rosemoe by email 2073412493@qq.com if you need
 *     additional information or have any questions
 */

import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

import java.io.IOException;
import java.io.StringReader;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * Simple implementation of highlight CSS3. The color matching may not be beautiful and reasonable.
 * Part of it depends on css3.g4. You can continue to expand according to your needs.
 */
public class DartCodeAnalyzer implements CodeAnalyzer {
  private String[] getColor = {"red", "blue", "green"};

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    try {
      CodePointCharStream stream = CharStreams.fromReader(new StringReader(content.toString()));
      Dart2Lexer lexer = new Dart2Lexer(stream);
      Token token;
      boolean first = true;
      int lastLine = 1;
      int line, column;
      while (delegate.shouldAnalyze()) {
        token = lexer.nextToken();
        if (token == null) break;
        if (token.getType() == Dart2Lexer.EOF) {
          lastLine = token.getLine() - 1;
          break;
        }
        line = token.getLine() - 1;
        column = token.getCharPositionInLine();
        lastLine = line;

        // Log.d("test",token.getText()+"  "+token.getType());
        switch (token.getType()) {
          case Dart2Lexer.WHITESPACE:
            if (first) result.addNormalIfNull();
            break;
            // 运算符
          case Dart2Lexer.A:
          case Dart2Lexer.AA:
          case Dart2Lexer.AE:
          case Dart2Lexer.AT:
          case Dart2Lexer.C:
          case Dart2Lexer.CB:
          case Dart2Lexer.CBC:
          case Dart2Lexer.CIR:
          case Dart2Lexer.CIRE:
          case Dart2Lexer.CO:
          case Dart2Lexer.CP:
          case Dart2Lexer.D:
          case Dart2Lexer.DD:
          case Dart2Lexer.DDD:
          case Dart2Lexer.EE:
          case Dart2Lexer.EG:
          case Dart2Lexer.EQ:
          case Dart2Lexer.GT:
          case Dart2Lexer.LT:
          case Dart2Lexer.LTE:
          case Dart2Lexer.LTLT:
          case Dart2Lexer.LTLTE:
          case Dart2Lexer.ME:
          case Dart2Lexer.MINUS:
          case Dart2Lexer.MM:
          case Dart2Lexer.NE:
          case Dart2Lexer.NOT:
          case Dart2Lexer.OB:
          case Dart2Lexer.OBC:
          case Dart2Lexer.OP:
          case Dart2Lexer.P:
          case Dart2Lexer.PC:
          case Dart2Lexer.PE:
          case Dart2Lexer.PL:
          case Dart2Lexer.PLE:
          case Dart2Lexer.PLPL:
          case Dart2Lexer.PO:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.OPERATOR, 0, true, false, false));
            break;
            // 单位
          case Dart2Lexer.POE:
          case Dart2Lexer.PP:
          case Dart2Lexer.QU:
          case Dart2Lexer.QUD:
          case Dart2Lexer.QUDD:
          case Dart2Lexer.QUQU:
          case Dart2Lexer.QUQUEQ:
          case Dart2Lexer.SC:
          case Dart2Lexer.SE:
          case Dart2Lexer.SL:
          case Dart2Lexer.SQS:
          case Dart2Lexer.SQSE:
          case Dart2Lexer.SQUIG:
          case Dart2Lexer.ST:
          case Dart2Lexer.STE:
            result.addIfNeeded(line, column, EditorColorScheme.ATTRIBUTE_VALUE);
            break;
            // @

          case Dart2Lexer.ABSTRACT_:
          case Dart2Lexer.AS_:
          case Dart2Lexer.ASSERT_:
          case Dart2Lexer.ASYNC_:
          case Dart2Lexer.AWAIT_:
          case Dart2Lexer.BREAK_:
          case Dart2Lexer.CASE_:
          case Dart2Lexer.CATCH_:
          case Dart2Lexer.CLASS_:
          case Dart2Lexer.CONST_:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.BLOCK_LINE, 0, false, true, false));
            break;
            // 数字
          case Dart2Lexer.CONTINUE_:
          case Dart2Lexer.COVARIANT_:
          case Dart2Lexer.DEFAULT_:
          case Dart2Lexer.DEFERRED_:
          case Dart2Lexer.DO_:
          case Dart2Lexer.DYNAMIC_:
          case Dart2Lexer.ELSE_:
          case Dart2Lexer.ENUM_:
          case Dart2Lexer.EXPORT_:
          case Dart2Lexer.EXTENDS_:
          case Dart2Lexer.EXTENSION_:
          case Dart2Lexer.EXTERNAL_:
          case Dart2Lexer.FACTORY_:
          case Dart2Lexer.FALSE_:
          case Dart2Lexer.FINAL_:
          case Dart2Lexer.FINALLY_:
          case Dart2Lexer.FOR_:
          case Dart2Lexer.FUNCTION_:
          case Dart2Lexer.GET_:
          case Dart2Lexer.GTILDE_:
          case Dart2Lexer.HIDE_:
          case Dart2Lexer.IF_:
          case Dart2Lexer.IMPLEMENTS_:
          case Dart2Lexer.IMPORT_:
          case Dart2Lexer.IN_:
          case Dart2Lexer.INTERFACE_:
          case Dart2Lexer.IS_:
          case Dart2Lexer.LATE_:
          case Dart2Lexer.LET_:
          case Dart2Lexer.LIBRARY_:
          case Dart2Lexer.MIXIN_:
          case Dart2Lexer.NATIVE_:
          case Dart2Lexer.NEW_:
          case Dart2Lexer.NULL_:
          case Dart2Lexer.OF_:
          case Dart2Lexer.ON_:
          case Dart2Lexer.OPERATOR_:
          case Dart2Lexer.PART_:
          case Dart2Lexer.REQUIRED_:
          case Dart2Lexer.RETHROW_:
          case Dart2Lexer.RETURN_:
          case Dart2Lexer.SET_:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(
                    EditorColorScheme.AUTO_COMP_PANEL_CORNER, 0, false, true, false));
            break;
            // 名字
          case Dart2Lexer.SHOW_:
          case Dart2Lexer.STATIC_:
          case Dart2Lexer.SUPER_:
          case Dart2Lexer.SWITCH_:
          case Dart2Lexer.SYNC_:
          case Dart2Lexer.THIS_:
          case Dart2Lexer.THROW_:
          case Dart2Lexer.TRUE_:
          case Dart2Lexer.TRY_:
          case Dart2Lexer.TYPEDEF_:
          case Dart2Lexer.VAR_:
          case Dart2Lexer.VOID_:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.KEYWORD, 0, true, false, false));
            break;
            // 字符串
          case Dart2Lexer.WHILE_:
          case Dart2Lexer.WITH_:
          case Dart2Lexer.YIELD_:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.LITERAL, 0, true, false, false));
            break;
            // 颜色
          case Dart2Lexer.NUMBER:
          case Dart2Lexer.HEX_NUMBER:
          case Dart2Lexer.SingleLineString:
          case Dart2Lexer.MultiLineString:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.LINE_NUMBER, 0, true, false, false));
            break;
            // 注释
          case Dart2Lexer.SINGLE_LINE_COMMENT:
            result.addIfNeeded(
                line, column, TextStyle.makeStyle(EditorColorScheme.COMMENT, 0, false, true, true));
            break;
          case Dart2Lexer.MULTI_LINE_COMMENT:
            result.addIfNeeded(
                line, column, TextStyle.makeStyle(EditorColorScheme.LITERAL, 0, true, true, false));
            break;

          default:
            result.addIfNeeded(line, column, EditorColorScheme.TEXT_NORMAL);
            break;
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
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
