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
package io.github.rosemoe.sora.langs.css3;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.Token;

import java.io.IOException;
import java.io.StringReader;

import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.EditorColorScheme;

/**
 * Simple implementation of highlight CSS3. The color matching may not be beautiful and reasonable.
 * Part of it depends on css3.g4. You can continue to expand according to your needs.
 */

/** علت ان منتقل شدن به html است.این کلاس منسوخ شده است */
@Deprecated
public class CSS3Analyzer implements CodeAnalyzer {
  protected CodeEditor soraEditor;
  private String[] getColor = {"red", "blue", "green"};

  public CSS3Analyzer(CodeEditor editor) {
    this.soraEditor = editor;
  }

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    try {
      CodePointCharStream stream = CharStreams.fromReader(new StringReader(content.toString()));
      css3Lexer lexer = new css3Lexer(stream);
      Token token;
      boolean first = true;
      int lastLine = 1;
      int line, column;
      int type, currSwitch = 1, maxSwitch = 0, previous = -1;
      while (delegate.shouldAnalyze()) {
        token = lexer.nextToken();
        if (token == null) break;
        if (token.getType() == css3Lexer.EOF) {
          lastLine = token.getLine() - 1;
          break;
        }
        line = token.getLine() - 1;
        column = token.getCharPositionInLine();
        lastLine = line;
        type = token.getType();

        // Log.d("test",token.getText()+"  "+token.getType());
        switch (type) {
          case css3Lexer.Space:
            if (first) result.addNormalIfNull();
            break;
          case css3Lexer.Url:
          case css3Lexer.Cdo:
          case css3Lexer.Cdc:
          case css3Lexer.Includes:
          case css3Lexer.DashMatch:
          case css3Lexer.Hash:
          case css3Lexer.Import:
          case css3Lexer.Page:
          case css3Lexer.Media:
          case css3Lexer.Namespace:
          case css3Lexer.Charset:
          case css3Lexer.Important:
          case css3Lexer.Percentage:
          case css3Lexer.Url_:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.OPERATOR, 0, true, false, false));
            break;
          case css3Lexer.Equal:
          case css3Lexer.Colon:
          case css3Lexer.Dot:
          case css3Lexer.Multiply:
          case css3Lexer.Divide:
          case css3Lexer.Pipe:
          case css3Lexer.Underscore:
            result.addIfNeeded(line, column, EditorColorScheme.ATTRIBUTE_VALUE);
            break;
          case css3Lexer.UnicodeRange:
          case css3Lexer.MediaOnly:
          case css3Lexer.Not:
          case css3Lexer.And:
          case css3Lexer.Dimension:
          case css3Lexer.UnknownDimension:
          case css3Lexer.Plus:
          case css3Lexer.Minus:
          case css3Lexer.Greater:
          case css3Lexer.Comma:
          case css3Lexer.OpenBracket:
          case css3Lexer.CloseBracket:
          case css3Lexer.OpenParen:
          case css3Lexer.CloseParen:
          case css3Lexer.OpenBrace:
          case css3Lexer.CloseBrace:
          case css3Lexer.SemiColon:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.BLOCK_LINE, 0, false, true, false));
            break;
          case css3Lexer.Tilde:
          case css3Lexer.PseudoNot:
          case css3Lexer.Number:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(
                    EditorColorScheme.AUTO_COMP_PANEL_CORNER, 0, false, true, false));
            break;

          case css3Lexer.PrefixMatch:
          case css3Lexer.SuffixMatch:
          case css3Lexer.SubstringMatch:
          case css3Lexer.FontFace:
          case css3Lexer.Supports:
          case css3Lexer.Or:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.KEYWORD, 0, true, false, false));
            break;
          case css3Lexer.String_:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.LITERAL, 0, true, false, false));
            break;
          case css3Lexer.Keyframes:
          case css3Lexer.From:
          case css3Lexer.To:
          case css3Lexer.Calc:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.LINE_NUMBER, 0, true, false, false));
            break;
          case css3Lexer.Comment:
            result.addIfNeeded(
                line, column, TextStyle.makeStyle(EditorColorScheme.COMMENT, 0, false, true, true));
            break;
          case css3Lexer.Viewport:
          case css3Lexer.CounterStyle:
          case css3Lexer.FontFeatureValues:
          case css3Lexer.DxImageTransform:
            result.addIfNeeded(
                line, column, TextStyle.makeStyle(EditorColorScheme.LITERAL, 0, true, true, false));
            break;
          case css3Lexer.AtKeyword:
          case css3Lexer.Variable:
          case css3Lexer.Var:
          case css3Lexer.Ident:
          case css3Lexer.Function_:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.IDENTIFIER_NAME, 0, false, true, false));
            break;

          case css3Lexer.IDENTIFIER:
            {
              int colorid = EditorColorScheme.TEXT_NORMAL;
              boolean isBold = false, isItalic = false;
              if (previous == css3Lexer.Colon) {
                colorid = EditorColorScheme.OPERATOR;
                isBold = true;
              }
              result.addIfNeeded(
                  line, column, TextStyle.makeStyle(colorid, 0, isBold, isItalic, false, false));

              break;
            }

          default:
            result.addIfNeeded(line, column, EditorColorScheme.TEXT_NORMAL);

            break;
        }

        if (type != css3Lexer.Space) {
          previous = type;
        }

        first = false;
      }
      result.determine(lastLine);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
