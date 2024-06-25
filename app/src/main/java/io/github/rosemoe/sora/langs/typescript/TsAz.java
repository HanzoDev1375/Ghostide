package io.github.rosemoe.sora.langs.typescript;

import android.graphics.Color;
import android.util.Log;
import io.github.rosemoe.sora.data.Span;
import io.github.rosemoe.sora.text.TextStyle;

import java.util.Stack;

import io.github.rosemoe.sora.data.BlockLine;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.Token;

import java.io.IOException;
import java.io.StringReader;

import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import org.antlr.v4.runtime.TokenSource;

public class TsAz implements CodeAnalyzer {

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    try {
      CodePointCharStream stream = CharStreams.fromReader(new StringReader(content.toString()));
      var lexer = new TypeScriptLexer(stream);
      int maxSwitch = 1, currSwitch = 0;
      Token token;
      Token previous = UnknownToken.INSTANCE;
      Token prePreToken = null;
      boolean first = true;
      int lastLine = 1;
      int line, column;

      Stack<BlockLine> stack = new Stack<>();
      while (delegate.shouldAnalyze()) {
        token = lexer.nextToken();
        if (token == null) break;
        if (token.getType() == TypeScriptLexer.EOF) {
          lastLine = token.getLine() - 1;
          break;
        }
        line = token.getLine() - 1;
        column = token.getCharPositionInLine();
        lastLine = line;

        switch (token.getType()) {
          case TypeScriptLexer.WhiteSpaces:
            if (first) result.addNormalIfNull();
            break;

          case TypeScriptLexer.At:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.ATTRIBUTE_NAME, 0, true, false, true));

            break;
          case TypeScriptLexer.CloseParen:
            result.addIfNeeded(line, column, EditorColorScheme.OPERATOR);
            if (!stack.isEmpty()) {
              BlockLine b = stack.pop();
              b.endLine = line;
              b.endColumn = column;
              if (b.startLine != b.endLine) {
                result.addBlockLine(b);
              }
            }
            break;
          case TypeScriptLexer.OpenBrace:
            result.addIfNeeded(line, column, EditorColorScheme.OPERATOR);
            if (stack.isEmpty()) {
              if (currSwitch > maxSwitch) {
                maxSwitch = currSwitch;
              }
              currSwitch = 0;
            }
            currSwitch++;
            BlockLine block = result.obtainNewBlock();
            block.startLine = line;
            block.startColumn = column;
            stack.push(block);
            break;
          case TypeScriptLexer.RegularExpressionLiteral:
          case TypeScriptLexer.OpenBracket:
          case TypeScriptLexer.CloseBracket:
          case TypeScriptLexer.OpenParen:
          case TypeScriptLexer.BitNot:
          case TypeScriptLexer.Not:
          case TypeScriptLexer.Multiply:
          case TypeScriptLexer.Divide:
          case TypeScriptLexer.Modulus:
          case TypeScriptLexer.RightShiftArithmetic:
          case TypeScriptLexer.LeftShiftArithmetic:
          case TypeScriptLexer.RightShiftLogical:
          case TypeScriptLexer.LessThan:
          case TypeScriptLexer.MoreThan:
          case TypeScriptLexer.LessThanEquals:
          case TypeScriptLexer.GreaterThanEquals:
          case TypeScriptLexer.Equals_:
          case TypeScriptLexer.NotEquals:
          case TypeScriptLexer.IdentityEquals:
          case TypeScriptLexer.IdentityNotEquals:
          case TypeScriptLexer.BitAnd:
          case TypeScriptLexer.BitXOr:
          case TypeScriptLexer.BitOr:
          case TypeScriptLexer.And:
          case TypeScriptLexer.Or:
          case TypeScriptLexer.MultiplyAssign:
          case TypeScriptLexer.DivideAssign:
          case TypeScriptLexer.ModulusAssign:
          case TypeScriptLexer.PlusAssign:
          case TypeScriptLexer.MinusAssign:
          case TypeScriptLexer.LeftShiftArithmeticAssign:
          case TypeScriptLexer.RightShiftArithmeticAssign:
          case TypeScriptLexer.RightShiftLogicalAssign:
          case TypeScriptLexer.BitAndAssign:
          case TypeScriptLexer.BitXorAssign:
          case TypeScriptLexer.BitOrAssign:
          case TypeScriptLexer.ARROW:
          case TypeScriptLexer.NullLiteral:
          case TypeScriptLexer.BooleanLiteral:
          case TypeScriptLexer.DecimalLiteral:
          case TypeScriptLexer.HexIntegerLiteral:
          case TypeScriptLexer.OctalIntegerLiteral:
          case TypeScriptLexer.BinaryIntegerLiteral:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.OPERATOR, 0, true, false, false));
            break;
          case TypeScriptLexer.Break:
          case TypeScriptLexer.Do:
          case TypeScriptLexer.Instanceof:
          case TypeScriptLexer.Typeof:
          case TypeScriptLexer.Case:
          case TypeScriptLexer.Else:
          case TypeScriptLexer.New:
          case TypeScriptLexer.Var:
          case TypeScriptLexer.Catch:
          case TypeScriptLexer.Finally:
          case TypeScriptLexer.Return:
          case TypeScriptLexer.Void:
          case TypeScriptLexer.Continue:
          case TypeScriptLexer.For:
          case TypeScriptLexer.Switch:
          case TypeScriptLexer.While:
          case TypeScriptLexer.Debugger:
          case TypeScriptLexer.Function_:
          case TypeScriptLexer.This:
          case TypeScriptLexer.With:
          case TypeScriptLexer.Default:
          case TypeScriptLexer.If:
          case TypeScriptLexer.Throw:
          case TypeScriptLexer.Delete:
          case TypeScriptLexer.In:
          case TypeScriptLexer.Try:
          case TypeScriptLexer.As:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.KEYWORD, 0, true, false, false));
            break;
          case TypeScriptLexer.From:
          case TypeScriptLexer.ReadOnly:
          case TypeScriptLexer.Async:
          case TypeScriptLexer.Class:
          case TypeScriptLexer.Enum:
          case TypeScriptLexer.Extends:
          case TypeScriptLexer.Super:
          case TypeScriptLexer.Const:
          case TypeScriptLexer.Export:
          case TypeScriptLexer.Import:
          case TypeScriptLexer.Implements:
          case TypeScriptLexer.Let:
          case TypeScriptLexer.Private:
          case TypeScriptLexer.Public:
          case TypeScriptLexer.Interface:
          case TypeScriptLexer.Package:
          case TypeScriptLexer.Protected:
          case TypeScriptLexer.Static:
          case TypeScriptLexer.Yield:
          case TypeScriptLexer.Any:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.HTML_TAG, 0, true, false, false));
            break;

          case TypeScriptLexer.Number:
          case TypeScriptLexer.Boolean:
          case TypeScriptLexer.String:
          case TypeScriptLexer.Symbol:
          case TypeScriptLexer.TypeAlias:
          case TypeScriptLexer.Get:
          case TypeScriptLexer.Set:
          case TypeScriptLexer.Constructor:
          case TypeScriptLexer.Namespace:
          case TypeScriptLexer.Require:
          case TypeScriptLexer.Module:
          case TypeScriptLexer.Declare:
          case TypeScriptLexer.Abstract:
          case TypeScriptLexer.Is:
          case TypeScriptLexer.StringLiteral:
          case TypeScriptLexer.BackTick:
          case TypeScriptLexer.LineTerminator:
          case TypeScriptLexer.UnexpectedCharacter:
          case TypeScriptLexer.TemplateStringEscapeAtom:
          case TypeScriptLexer.TemplateStringStartExpression:
          case TypeScriptLexer.TemplateStringAtom:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.ATTRIBUTE_VALUE, 0, true, false, false));
            break;
          case TypeScriptLexer.MultiLineComment:
          case TypeScriptLexer.SingleLineComment:
          case TypeScriptLexer.HtmlComment:
          case TypeScriptLexer.CDataComment:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.COMMENT, 0, true, false, false));
            break;
          case TypeScriptLexer.Colon:
          case TypeScriptLexer.TemplateCloseBrace:
          case TypeScriptLexer.CloseBrace:
          case TypeScriptLexer.SemiColon:
          case TypeScriptLexer.Comma:
          case TypeScriptLexer.Assign:
          case TypeScriptLexer.QuestionMark:
          case TypeScriptLexer.Ellipsis:
          case TypeScriptLexer.Dot:
          case TypeScriptLexer.PlusPlus:
          case TypeScriptLexer.MinusMinus:
          case TypeScriptLexer.Plus:
          case TypeScriptLexer.Minus:
            result.addIfNeeded(line, column, EditorColorScheme.LITERAL);
            break;
          case TypeScriptLexer.STYLE_VSCODEBRACE:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.BLOCK_LINE_CURRENT, 0, true, true, false));
            break;
          default:
            int colorIds = EditorColorScheme.OPERATOR;
            result.addIfNeeded(line, column, colorIds);
            break;
        }

        first = false;
        if (token.getType() != TypeScriptLexer.WhiteSpaces) {
          previous = token;
        }
      }
      result.determine(lastLine);
      if (stack.isEmpty()) {
        if (currSwitch > maxSwitch) {
          maxSwitch = currSwitch;
        }
      }
      result.setSuppressSwitch(maxSwitch + 10);
    } catch (IOException e) {
      e.printStackTrace();
      Log.e("TAG", e.getMessage());
    }
  }

  private static class UnknownToken implements Token {

    public static UnknownToken INSTANCE = new UnknownToken();

    @Override
    public String getText() {
      return "";
    }

    @Override
    public int getType() {
      return -1;
    }

    @Override
    public int getLine() {
      return 0;
    }

    @Override
    public int getCharPositionInLine() {
      return 0;
    }

    @Override
    public int getChannel() {
      return 0;
    }

    @Override
    public int getTokenIndex() {
      return 0;
    }

    @Override
    public int getStartIndex() {
      return 0;
    }

    @Override
    public int getStopIndex() {
      return 0;
    }

    @Override
    public TokenSource getTokenSource() {
      return null;
    }

    @Override
    public CharStream getInputStream() {
      return null;
    }
  }
}
