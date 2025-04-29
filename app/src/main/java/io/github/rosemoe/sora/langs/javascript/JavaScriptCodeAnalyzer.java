package io.github.rosemoe.sora.langs.javascript;

import android.util.Log;

import io.github.rosemoe.sora.text.TextStyle;
import java.util.Stack;
import io.github.rosemoe.sora.data.BlockLine;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.Token;
import java.io.IOException;
import java.io.StringReader;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.widget.EditorColorScheme;

public class JavaScriptCodeAnalyzer implements CodeAnalyzer {
  private int COMPLETE = 25;
  private int INCOMPLETE = 24;
  private BasicSyntaxJavaScriptAnalyzer as;

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    try {
      as = new BasicSyntaxJavaScriptAnalyzer();
      CodePointCharStream stream = CharStreams.fromReader(new StringReader(content.toString()));
      JavaScriptLexer lexer = new JavaScriptLexer(stream);
      var classNamePrevious = false;
      Token token, preToken = null, prePreToken = null;
      JsAutoComplete com = new JsAutoComplete();
      com.setKeywords(JavaScriptLanguage.keywords);
      JsAutoComplete.Identifiers identifiers = new JsAutoComplete.Identifiers();
      identifiers.begin();
      boolean first = true;
      Stack<BlockLine> stack = new Stack<>();
      int type, currSwitch = 1, maxSwitch = 0, previous = -1;
      int lastLine = 1;
      int line, column;
      var prevIsTagName = false;

      while (delegate.shouldAnalyze()) {
        token = lexer.nextToken();
        if (token == null) break;
        if (token.getType() == JavaScriptLexer.EOF) {
          lastLine = token.getLine() - 1;
          break;
        }
        line = token.getLine() - 1;
        type = token.getType();
        column = token.getCharPositionInLine();
        if (type == JavaScriptLexer.EOF) {
          lastLine = line;
          break;
        }
        switch (type) {
          case JavaScriptLexer.WhiteSpaces:
            if (first) {
              result.addNormalIfNull();
            }
            break;
          case JavaScriptLexer.OpenBracket:
          case JavaScriptLexer.CloseBracket:
            {
              classNamePrevious = false;
              result.addIfNeeded(line, column, EditorColorScheme.OPERATOR);

              break;
            }

          case JavaScriptLexer.OpenParen:
          case JavaScriptLexer.CloseParen:
          case JavaScriptLexer.OpenBrace:
          case JavaScriptLexer.CloseBrace:
            {
              classNamePrevious = false;
              result.addIfNeeded(line, column, EditorColorScheme.OPERATOR);

              break;
            }

          case JavaScriptLexer.SemiColon:
          case JavaScriptLexer.Comma:
          case JavaScriptLexer.Assign:
          case JavaScriptLexer.QuestionMark:
          case JavaScriptLexer.QuestionMarkDot:
          case JavaScriptLexer.Colon:
          case JavaScriptLexer.Ellipsis:

          case JavaScriptLexer.PlusPlus:
          case JavaScriptLexer.Plus:
          case JavaScriptLexer.MinusMinus:
          case JavaScriptLexer.Minus:
          case JavaScriptLexer.BitNot:
          case JavaScriptLexer.Not:
          case JavaScriptLexer.Multiply:
          case JavaScriptLexer.Divide:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(
                    EditorColorScheme.AUTO_COMP_PANEL_CORNER, 0, true, false, false));
            break;

          case JavaScriptLexer.Dot:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(
                    EditorColorScheme.AUTO_COMP_PANEL_CORNER, 0, true, false, false));
            if (previous == JavaScriptLexer.Identifier) {
              result.addIfNeeded(line, column +1, EditorColorScheme.javafield);
            }
            break;
          case JavaScriptLexer.Modulus:
          case JavaScriptLexer.NullCoalesce:
          case JavaScriptLexer.Hashtag:
          case JavaScriptLexer.RightShiftArithmetic:
          case JavaScriptLexer.LeftShiftArithmetic:
          case JavaScriptLexer.RightShiftLogical:
          case JavaScriptLexer.LessThan:
          case JavaScriptLexer.MoreThan:
          case JavaScriptLexer.LessThanEquals:
          case JavaScriptLexer.GreaterThanEquals:
          case JavaScriptLexer.Equals_:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.NON_PRINTABLE_CHAR, 0, true, false, false));
            break;
          case JavaScriptLexer.NotEquals:
          case JavaScriptLexer.IdentityEquals:
          case JavaScriptLexer.IdentityNotEquals:
          case JavaScriptLexer.BitAnd:
          case JavaScriptLexer.BitXOr:
          case JavaScriptLexer.BitOr:
          case JavaScriptLexer.And:
          case JavaScriptLexer.Or:
          case JavaScriptLexer.MultiplyAssign:
          case JavaScriptLexer.DivideAssign:
          case JavaScriptLexer.ModulusAssign:
          case JavaScriptLexer.PlusAssign:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.ATTRIBUTE_VALUE, 0, true, false, false));
            break;
          case JavaScriptLexer.MinusAssign:
          case JavaScriptLexer.LeftShiftArithmeticAssign:
          case JavaScriptLexer.RightShiftArithmeticAssign:
          case JavaScriptLexer.RightShiftLogicalAssign:
          case JavaScriptLexer.BitAndAssign:
          case JavaScriptLexer.BitXorAssign:
          case JavaScriptLexer.BitOrAssign:
          case JavaScriptLexer.PowerAssign:
          case JavaScriptLexer.ARROW:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.KEYWORD, 0, true, false, false));
            break;
          case JavaScriptLexer.SingleLineComment:
          case JavaScriptLexer.MultiLineComment:
          case JavaScriptLexer.HtmlComment:
            classNamePrevious = false;
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.COMMENT, 0, false, true, false));
            break;
          case JavaScriptLexer.Var:
          case JavaScriptLexer.NonStrictLet:
          case JavaScriptLexer.StrictLet:
          case JavaScriptLexer.Const:
          case JavaScriptLexer.Break:
          case JavaScriptLexer.Do:
          case JavaScriptLexer.Instanceof:
          case JavaScriptLexer.Typeof:
          case JavaScriptLexer.Case:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.OPERATOR, 0, true, false, false));
            break;
          case JavaScriptLexer.Else:
          case JavaScriptLexer.New:
          case JavaScriptLexer.Catch:
          case JavaScriptLexer.Finally:
          case JavaScriptLexer.Return:
          case JavaScriptLexer.Void:
          case JavaScriptLexer.Continue:
          case JavaScriptLexer.For:
          case JavaScriptLexer.Switch:
          case JavaScriptLexer.While:
          case JavaScriptLexer.Debugger:
          case JavaScriptLexer.Function_:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.ATTRIBUTE_NAME, 0, true, false, false));
            break;
          case JavaScriptLexer.This:
          case JavaScriptLexer.With:
          case JavaScriptLexer.Default:
          case JavaScriptLexer.If:
          case JavaScriptLexer.Throw:
          case JavaScriptLexer.Delete:
          case JavaScriptLexer.In:
          case JavaScriptLexer.Try:
          case JavaScriptLexer.As:
          case JavaScriptLexer.From:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.BLOCK_LINE, 0, true, false, false));
            break;
          case JavaScriptLexer.Class:
            if (classNamePrevious) {
              classNamePrevious = true;
              result.addIfNeeded(
                  line,
                  column,
                  TextStyle.makeStyle(EditorColorScheme.HTML_TAG, 0, true, false, false));
            } else {
              result.addIfNeeded(
                  line,
                  column,
                  TextStyle.makeStyle(EditorColorScheme.LITERAL, 0, true, true, false));
              classNamePrevious = false;
            }
            break;
          case JavaScriptLexer.Enum:
          case JavaScriptLexer.Extends:
          case JavaScriptLexer.Super:
          case JavaScriptLexer.Export:
          case JavaScriptLexer.Import:
          case JavaScriptLexer.Async:
          case JavaScriptLexer.Await:
          case JavaScriptLexer.Yield:
          case JavaScriptLexer.Implements:
          case JavaScriptLexer.Private:
          case JavaScriptLexer.Public:
          case JavaScriptLexer.Interface:
          case JavaScriptLexer.Package:
          case JavaScriptLexer.Protected:
          case JavaScriptLexer.Static:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.HTML_TAG, 0, true, false, false));
            break;
          case JavaScriptLexer.NullLiteral:
          case JavaScriptLexer.BooleanLiteral:
          case JavaScriptLexer.DecimalLiteral:
          case JavaScriptLexer.HexIntegerLiteral:
          case JavaScriptLexer.BigHexIntegerLiteral:
          case JavaScriptLexer.OctalIntegerLiteral:
          case JavaScriptLexer.OctalIntegerLiteral2:
          case JavaScriptLexer.BinaryIntegerLiteral:
          case JavaScriptLexer.BigOctalIntegerLiteral:
          case JavaScriptLexer.BigBinaryIntegerLiteral:
          case JavaScriptLexer.BigDecimalIntegerLiteral:
          case JavaScriptLexer.NullishCoalescingAssign:
          case JavaScriptLexer.BackTick:
            classNamePrevious = false;
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.LITERAL, 0, true, false, false));
            break;

          case JavaScriptLexer.Identifier:
            {
              identifiers.addIdentifier(token.getText());
              int mycolor = EditorColorScheme.TEXT_NORMAL;
              if (previous == JavaScriptLexer.Import || previous == JavaScriptLexer.From) {
                mycolor = EditorColorScheme.ATTRIBUTE_NAME;
              }
              if (previous == JavaScriptLexer.LessThan) {
                mycolor = EditorColorScheme.ATTRIBUTE_VALUE;
              }
              // symbol like in vscode
              if (previous == JavaScriptLexer.Dot || previous == JavaScriptLexer.Colon) {
                mycolor = EditorColorScheme.BLOCK_LINE_CURRENT;
              }
              if (previous == JavaScriptLexer.Function_
                  || previous == JavaScriptLexer.Class
                  || previous == JavaScriptLexer.Package
                  || previous == JavaScriptLexer.Export
                  || previous == JavaScriptLexer.Extends) {
                mycolor = EditorColorScheme.HTML_TAG;
              }
              // var
              if (previous == JavaScriptLexer.Var
                  || previous == JavaScriptLexer.StrictLet
                  || previous == JavaScriptLexer.Const) {
                mycolor = EditorColorScheme.LITERAL;
              }
              // retrun and .....
              if (previous == JavaScriptLexer.Return
                  || previous == JavaScriptLexer.As
                  || previous == JavaScriptLexer.Interface
                  || previous == JavaScriptLexer.Yield) {
                mycolor = EditorColorScheme.OPERATOR;
              }
              result.addIfNeeded(line, column, mycolor);
              break;
            }

          case JavaScriptLexer.StringLiteral:
            {
              result.addIfNeeded(line, column, EditorColorScheme.LITERAL);
            }

            break;
          default:
            result.addIfNeeded(line, column, EditorColorScheme.TEXT_NORMAL);
            prevIsTagName = false;
            classNamePrevious = false;
            break;
        }
        if (type != JavaScriptLexer.WhiteSpaces) {
          previous = type;
        }
        preToken = token;
        first = false;
      }
      result.determine(lastLine);
      identifiers.finish();
      result.setExtra(identifiers);
      as.analyze(content, result, delegate);
    } catch (IOException e) {
      e.printStackTrace();
      Log.e("TAG", e.getMessage());
    }
  }
}
