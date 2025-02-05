package io.github.rosemoe.sora.langs.typescript;

import android.util.Log;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.TextSummry.HTMLConstants;
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

public class TypeScriptCodeAnalyzer implements CodeAnalyzer {

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    try {
      CodePointCharStream stream = CharStreams.fromReader(new StringReader(content.toString()));
      var lexer = new TypeScriptLexer(stream);
      int maxSwitch = 1, currSwitch = 0, previous = -1, type = 0;
      Token token;
      Token prePreToken = null;
      boolean first = true;
      int lastLine = 1;
      int line, column;
      var auto = new TypeScriptAutoComplete();
      auto.setKeywords(TsLang.list);
      TypeScriptAutoComplete.Identifiers info = new TypeScriptAutoComplete.Identifiers();
      info.begin();
      Stack<BlockLine> stack = new Stack<>();
      while (delegate.shouldAnalyze()) {
        token = lexer.nextToken();
        if (token == null) break;
        if (token.getType() == TypeScriptLexer.EOF) {
          lastLine = token.getLine() - 1;
          break;
        }
        line = token.getLine() - 1;
        type = token.getType();
        column = token.getCharPositionInLine();
        lastLine = line;
        if (type == TypeScriptLexer.EOF) {
          lastLine = line;
          break;
        }

        switch (type) {
          case TypeScriptLexer.WhiteSpaces:
            if (first) result.addNormalIfNull();
            break;

          case TypeScriptLexer.CloseBrace:
            if (!stack.isEmpty()) {
              BlockLine b = stack.pop();
              b.endLine = line;
              b.endColumn = column;
              if (b.startLine != b.endLine) {
                result.addBlockLine(b);
              }
            }
            int colorids = HTMLConstants.get(stack.size());
            result.addIfNeeded(line, column, colorids);
            break;
          case TypeScriptLexer.OpenBrace:
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
            int colorid1 = HTMLConstants.get(stack.size());
            result.addIfNeeded(line, column, colorid1);
            stack.push(block);
            break;
          case TypeScriptLexer.RegularExpressionLiteral:
          case TypeScriptLexer.OpenBracket:
          case TypeScriptLexer.CloseBracket:
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
          case TypeScriptLexer.At:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.tssymbols, 0, false, false, false));
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
                TextStyle.makeStyle(EditorColorScheme.tskeyword, 0, true, false, false));
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
                TextStyle.makeStyle(EditorColorScheme.tsattr, 0, false, false, false));
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
          case TypeScriptLexer.OpenParen:
          case TypeScriptLexer.SemiColon:
          case TypeScriptLexer.Comma:
          case TypeScriptLexer.Assign:
          case TypeScriptLexer.QuestionMark:
          case TypeScriptLexer.Ellipsis:
          case TypeScriptLexer.Dot:
          case TypeScriptLexer.PlusPlus:
          case TypeScriptLexer.MinusMinus:
          case TypeScriptLexer.Plus:
          case TypeScriptLexer.CloseParen:
          case TypeScriptLexer.Minus:
            result.addIfNeeded(line, column, EditorColorScheme.tssymbols);
            break;
          case TypeScriptLexer.Identifier:
            {
              int colorid = EditorColorScheme.TEXT_NORMAL;
              info.addIdentifier(token.getText());
              boolean isPart = false;
              int types = previous;
              if (types == TypeScriptLexer.At) {
                colorid = EditorColorScheme.tssymbols;
                isPart = false;
              }
              if (types == TypeScriptLexer.Dot) {
                colorid = EditorColorScheme.tscolormatch1;
                isPart = false;
              }
              if (types == TypeScriptLexer.Class
                  || types == TypeScriptLexer.Interface
                  || types == TypeScriptLexer.Abstract
                  || types == TypeScriptLexer.Export
                  || types == TypeScriptLexer.Extends) {
                colorid = EditorColorScheme.tscolormatch2;
                isPart = false;
              }
              if (types == TypeScriptLexer.Package
                  || types == TypeScriptLexer.Public
                  || types == TypeScriptLexer.Protected
                  || types == TypeScriptLexer.Private
                  || types == TypeScriptLexer.Void) {
                colorid = EditorColorScheme.tscolormatch3;
                isPart = false;
              }
              if (types == TypeScriptLexer.Colon
                  || types == TypeScriptLexer.From
                  || types == TypeScriptLexer.This
                  || types == TypeScriptLexer.Or
                  || types == TypeScriptLexer.And
                  || types == TypeScriptLexer.Any
                  || types == TypeScriptLexer.Yield) {
                colorid = EditorColorScheme.tscolormatch4;
                isPart = false;
              }
              if (types == TypeScriptLexer.Implements
                  || types == TypeScriptLexer.Import
                  || types == TypeScriptLexer.Var
                  || types == TypeScriptLexer.Let) {
                colorid = EditorColorScheme.tscolormatch5;
                isPart = false;
              }
              if (types == TypeScriptLexer.Enum
                  || types == TypeScriptLexer.New
                  || types == TypeScriptLexer.Typeof
                  || types == TypeScriptLexer.TypeAlias
                  || types == TypeScriptLexer.Super) {
                colorid = EditorColorScheme.tscolormatch6;
                isPart = false;
              }
              if (types == TypeScriptLexer.OpenParen
                  || types == TypeScriptLexer.CloseParen
                  || types == TypeScriptLexer.Assign) {
                colorid = EditorColorScheme.tscolormatch7;
                isPart = false;
              }
              isPart = true;
              result.addIfNeeded(line, column, colorid);
              break;
            }

          default:
            int colorIds = EditorColorScheme.TEXT_NORMAL;
            result.addIfNeeded(line, column, colorIds);
            break;
        }

        first = false;
        if (type != TypeScriptLexer.WhiteSpaces) {
          previous = type;
        }
      }
      result.determine(lastLine);
      if (stack.isEmpty()) {
        if (currSwitch > maxSwitch) {
          maxSwitch = currSwitch;
        }
      }
      info.finish();
      result.setExtra(info);
      result.setSuppressSwitch(maxSwitch + 10);

    } catch (IOException e) {
      e.printStackTrace();
      Log.e("TAG", e.getMessage());
    }
  }
}
