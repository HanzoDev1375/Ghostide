/*
 * Antlr4Formatter Copyright 2018, khubla.com
 *
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package com.khubla.antlr4formatter.listener;

import java.util.*;

import java.util.logging.Logger;
import org.antlr.parser.antlr4.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import com.khubla.antlr4formatter.listener.FormatterListener.*;

public class FormatterParseTreeListenerImpl implements ParseTreeListener {
  /** logger */

  /** comment tokens */
  private static final Set<String> commentTokens =
      new HashSet<>(Arrays.asList(new String[] {"/*", "//"}));

  /** formatter */
  private final FormatterListener formatterListener;

  /** comment token marker */
  private int commentTokenPos = -1;

  /** token stream */
  private final CommonTokenStream commonTokenStream;

  public FormatterParseTreeListenerImpl(
      FormatterListener formatterListener, CommonTokenStream commonTokenStream) {
    super();
    this.formatterListener = formatterListener;
    this.commonTokenStream = commonTokenStream;
  }

  @Override
  public void enterEveryRule(ParserRuleContext ctx) {

    /*
     * rule
     */
    formatterListener.enterEveryRule(ctx);
  }

  @Override
  public void exitEveryRule(ParserRuleContext ctx) {

    /*
     * rule
     */
    formatterListener.exitEveryRule(ctx);
  }

  private CommentType getCommentType(String comment) {
    if (comment.startsWith("//")) {
      return CommentType.line;
    } else {
      return CommentType.block;
    }
  }

  private void handleLeftCommentTokens(TerminalNode node) {
    /*
     * check for comment tokens left of the ctx
     */
    final int tokPos = node.getSymbol().getTokenIndex();
    if (tokPos > commentTokenPos) {
      /*
       * get comment tokens to left of current token
       */
      final List<Token> leftCommentTokens =
          commonTokenStream.getHiddenTokensToLeft(tokPos, ANTLRv4Lexer.COMMENT);
      if ((null != leftCommentTokens) && (leftCommentTokens.size() > 0)) {
        /*
         * walk comment tokens
         */
        for (final Token commentToken : leftCommentTokens) {
          if (commentToken.getTokenIndex() > commentTokenPos) {
            /*
             * check if there is a CRLF skipped in there
             */
            final List<Token> skippedTokens =
                commonTokenStream.getHiddenTokensToLeft(
                    commentToken.getTokenIndex(), ANTLRv4Lexer.OFF_CHANNEL);
            int lfCount = 0;
            if (null != skippedTokens) {
              for (final Token skippedToken : skippedTokens) {
                if (skippedToken.getText().indexOf("\n") != -1) {
                  lfCount++;
                }
              }
            }
            /*
             * print comments
             */
            final String str = commentToken.getText().trim();
            if (str.length() > 0) {
              if (isComment(str)) {
                formatterListener.visitComment(
                    commentToken,
                    true,
                    getCommentType(commentToken.getText()),
                    (lfCount > 0) ? true : false);
              }
            }
          }
          if (commentToken.getTokenIndex() > commentTokenPos) {
            commentTokenPos = commentToken.getTokenIndex();
          }
        }
      } else {
        commentTokenPos = tokPos;
      }
    }
  }

  private void handleRightCommentTokens(TerminalNode node) {
    /*
     * check for comment tokens right of the ctx
     */
    final int tokPos = node.getSymbol().getTokenIndex();
    if (tokPos >= commentTokenPos) {
      /*
       * get comment tokens to right of current token
       */
      final List<Token> rightCommentTokens =
          commonTokenStream.getHiddenTokensToRight(tokPos, ANTLRv4Lexer.COMMENT);
      if ((null != rightCommentTokens) && (rightCommentTokens.size() > 0)) {
        /*
         * walk comment tokens
         */
        for (final Token commentToken : rightCommentTokens) {
          /*
           * check if there is a CRLF skipped in there
           */
          final List<Token> skippedTokens =
              commonTokenStream.getHiddenTokensToLeft(
                  commentToken.getTokenIndex(), ANTLRv4Lexer.OFF_CHANNEL);
          int lfCount = 0;
          if (null != skippedTokens) {
            for (final Token skippedToken : skippedTokens) {
              if (skippedToken.getText().indexOf("\n") != -1) {
                lfCount++;
              }
            }
          }
          /*
           * print comments
           */
          final String str = commentToken.getText().trim();
          if (str.length() > 0) {
            if (isComment(str)) {
              formatterListener.visitComment(
                  commentToken,
                  false,
                  getCommentType(commentToken.getText()),
                  (lfCount > 0) ? true : false);
            }
          }
          if (commentToken.getTokenIndex() > commentTokenPos) {
            commentTokenPos = commentToken.getTokenIndex();
          }
        }
      } else {
        commentTokenPos = tokPos;
      }
    }
  }

  /** check if string is comment */
  private boolean isComment(String str) {
    for (final String c : commentTokens) {
      if (str.startsWith(c)) {
        return true;
      }
    }
    return false;
  }

  protected int tokenStart(ParserRuleContext ctx) {
    return (ctx.getStart().getTokenIndex() < ctx.getStop().getTokenIndex())
        ? ctx.getStart().getTokenIndex()
        : ctx.getStop().getTokenIndex();
  }

  protected int tokenStop(ParserRuleContext ctx) {
    return (ctx.getStop().getTokenIndex() > ctx.getStart().getTokenIndex())
        ? ctx.getStop().getTokenIndex()
        : ctx.getStart().getTokenIndex();
  }

  @Override
  public void visitErrorNode(ErrorNode node) {
    formatterListener.visitErrorNode(node);
  }

  @Override
  public void visitTerminal(TerminalNode node) {

    /*
     * left comment tokens
     */
    handleLeftCommentTokens(node);
    /*
     * terminal
     */
    formatterListener.visitTerminal(node);
    /*
     * right comment tokens
     */
    handleRightCommentTokens(node);
  }
}
