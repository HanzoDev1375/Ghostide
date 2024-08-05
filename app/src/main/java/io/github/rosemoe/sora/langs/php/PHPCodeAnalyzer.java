package io.github.rosemoe.sora.langs.php;

import android.util.Log;
import io.github.rosemoe.sora.data.BlockLine;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.Token;

import java.io.IOException;
import java.io.StringReader;
import java.util.Stack;

public class PHPCodeAnalyzer implements CodeAnalyzer {
  private int COMPLETE = 25;
  private int INCOMPLETE = 24;
  private PhpErrorManager error;

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    try {

      CodePointCharStream stream = CharStreams.fromReader(new StringReader(content.toString()));
      PhpLexer lexer = new PhpLexer(stream);
      error = new PhpErrorManager();
      var classNamePrevious = false;
      Token token, preToken = null, prePreToken = null;
      boolean first = true;
      Stack<BlockLine> stack = new Stack<>();
      TokenCss css3 = null;
      int maxSwitch = 1, currSwitch = 0;
      int lastLine = 1;
      int line, column;
      var prevIsTagName = false;

      while (delegate.shouldAnalyze()) {
        token = lexer.nextToken();
        if (token == null) break;
        if (token.getType() == PhpLexer.EOF) {
          lastLine = token.getLine() - 1;
          break;
        }
        line = token.getLine() - 1;
        column = token.getCharPositionInLine();
        lastLine = line;

        switch (token.getType()) {
          case PhpLexer.Whitespace:
          case PhpLexer.SeaWhitespace:
            if (first) {
              result.addNormalIfNull();
            }
            break;

          case PhpLexer.Abstract:
          case PhpLexer.Array:
          case PhpLexer.As:
          case PhpLexer.BinaryCast:
          case PhpLexer.BoolType:
          case PhpLexer.BooleanConstant:
          case PhpLexer.Break:
          case PhpLexer.Callable:
          case PhpLexer.Case:
          case PhpLexer.Catch:
          case PhpLexer.Class:
          case PhpLexer.Clone:
          case PhpLexer.Const:
          case PhpLexer.Continue:
          case PhpLexer.Declare:
          case PhpLexer.Default:
          case PhpLexer.Do:
          case PhpLexer.DoubleCast:
          case PhpLexer.DoubleType:
          case PhpLexer.Echo:
          case PhpLexer.Else:
          case PhpLexer.ElseIf:
          case PhpLexer.Empty:
          case PhpLexer.Enum_:
          case PhpLexer.EndDeclare:
          case PhpLexer.EndFor:
          case PhpLexer.EndForeach:
          case PhpLexer.EndIf:
          case PhpLexer.EndSwitch:
          case PhpLexer.EndWhile:
          case PhpLexer.Eval:
          case PhpLexer.Exit:
          case PhpLexer.Extends:
          case PhpLexer.Final:
          case PhpLexer.Finally:
          case PhpLexer.FloatCast:
          case PhpLexer.For:
          case PhpLexer.Foreach:
          case PhpLexer.Function_:
          case PhpLexer.Global:
          case PhpLexer.Goto:
          case PhpLexer.If:
          case PhpLexer.Implements:
          case PhpLexer.Import:
          case PhpLexer.Include:
          case PhpLexer.IncludeOnce:
          case PhpLexer.InstanceOf:
          case PhpLexer.InsteadOf:
          case PhpLexer.IntType:
          case PhpLexer.Interface:
          case PhpLexer.IsSet:
          case PhpLexer.List:
          case PhpLexer.LogicalAnd:
          case PhpLexer.LogicalOr:
          case PhpLexer.LogicalXor:
          case PhpLexer.Match_:
          case PhpLexer.Namespace:
          case PhpLexer.New:
          case PhpLexer.Null:
          case PhpLexer.ObjectType:
          case PhpLexer.Parent_:
          case PhpLexer.Partial:
          case PhpLexer.Print:
          case PhpLexer.Private:
          case PhpLexer.Protected:
          case PhpLexer.Public:
          case PhpLexer.Readonly:
          case PhpLexer.Require:
          case PhpLexer.RequireOnce:
          case PhpLexer.Resource:
          case PhpLexer.Return:
          case PhpLexer.Static:
          case PhpLexer.StringType:
          case PhpLexer.Switch:
          case PhpLexer.Throw:
          case PhpLexer.Trait:
          case PhpLexer.Try:
          case PhpLexer.Typeof:
          case PhpLexer.UintCast:
          case PhpLexer.UnicodeCast:
          case PhpLexer.Unset:
          case PhpLexer.Use:
          case PhpLexer.Var:
          case PhpLexer.While:
          case PhpLexer.Yield:
          case PhpLexer.From:
          
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(
                    EditorColorScheme.AUTO_COMP_PANEL_CORNER, 0, true, false, false));
            break;
          case PhpLexer.LambdaFn:
          case PhpLexer.Ticks:
          case PhpLexer.Encoding:
          case PhpLexer.StrictTypes:
          case PhpLexer.Get:
          case PhpLexer.Set:
          case PhpLexer.Call:
          case PhpLexer.CallStatic:
          case PhpLexer.Constructor:
          case PhpLexer.Destruct:
          case PhpLexer.Wakeup:
          case PhpLexer.Sleep:
          case PhpLexer.Autoload:
          case PhpLexer.IsSet__:
          case PhpLexer.Unset__:
          case PhpLexer.ToString__:
          case PhpLexer.Invoke:
          case PhpLexer.SetState:
          case PhpLexer.Clone__:
          case PhpLexer.DebugInfo:
          case PhpLexer.Namespace__:
          case PhpLexer.Class__:
          case PhpLexer.Function__:
          case PhpLexer.Method__:
          case PhpLexer.Line__:
          case PhpLexer.File__:
          case PhpLexer.Dir__:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.NON_PRINTABLE_CHAR, 0, true, false, false));
            break;
          case PhpLexer.Spaceship:
          case PhpLexer.Lgeneric:
          case PhpLexer.Rgeneric:
          case PhpLexer.DoubleArrow:
          case PhpLexer.Inc:
          case PhpLexer.Dec:
          case PhpLexer.IsIdentical:
          case PhpLexer.IsNoidentical:
          case PhpLexer.IsEqual:
          case PhpLexer.IsNotEq:
          case PhpLexer.IsSmallerOrEqual:
          case PhpLexer.IsGreaterOrEqual:
          case PhpLexer.PlusEqual:
          case PhpLexer.MinusEqual:
          case PhpLexer.MulEqual:
          case PhpLexer.Pow:
          case PhpLexer.PowEqual:
          case PhpLexer.DivEqual:
          case PhpLexer.Concaequal:
          case PhpLexer.ModEqual:
          case PhpLexer.ShiftLeftEqual:
          case PhpLexer.ShiftRightEqual:
          case PhpLexer.AndEqual:
          case PhpLexer.OrEqual:
          case PhpLexer.XorEqual:
          case PhpLexer.BooleanOr:
          case PhpLexer.BooleanAnd:
          case PhpLexer.NullCoalescing:
          case PhpLexer.NullCoalescingEqual:
          case PhpLexer.ShiftLeft:
          case PhpLexer.ShiftRight:
          case PhpLexer.DoubleColon:
          case PhpLexer.ObjectOperator:
          case PhpLexer.NamespaceSeparator:
          case PhpLexer.Ellipsis:
          case PhpLexer.Less:
          case PhpLexer.Greater:
          case PhpLexer.Ampersand:
          case PhpLexer.Pipe:
          case PhpLexer.Bang:
          case PhpLexer.Caret:
          case PhpLexer.Plus:
          case PhpLexer.Minus:
          case PhpLexer.Asterisk:
          case PhpLexer.Percent:
          case PhpLexer.Divide:
          case PhpLexer.Tilde:
          case PhpLexer.SuppressWarnings:
          case PhpLexer.Dollar:
          case PhpLexer.Dot:
          case PhpLexer.QuestionMark:
          case PhpLexer.Comma:
          case PhpLexer.Colon:
          case PhpLexer.SemiColon:
          case PhpLexer.Eq:
          case PhpLexer.Quote:
          case PhpLexer.OpenCurlyBracket:
          case PhpLexer.CloseCurlyBracket:
          case PhpLexer.OpenRoundBracket:
          case PhpLexer.CloseRoundBracket:
          case PhpLexer.OpenSquareBracket:
          case PhpLexer.CloseSquareBracket:
          case PhpLexer.BackQuote:
          case PhpLexer.DoubleQuote:
          case PhpLexer.BackQuoteString:
          case PhpLexer.SingleQuoteString:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.ATTRIBUTE_VALUE, 0, true, false, false));
            break;
          case PhpLexer.VarName:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.KEYWORD, 0, true, false, false));
            break;
          case PhpLexer.SingleLineComment:
          case PhpLexer.MultiLineComment:
          case PhpLexer.CommentEnd:
          case PhpLexer.ShellStyleComment:
          case PhpLexer.Comment:
          case PhpLexer.Shebang:
            classNamePrevious = false;
            int[] ersr = Utils.setWaringSpan(result, line , column  );
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.COMMENT, 0, false, true, false));
            break;
          case PhpLexer.Octal:
          case PhpLexer.Decimal:
          case PhpLexer.Real:
          case PhpLexer.Hex:
          case PhpLexer.StartNowDoc:
          case PhpLexer.StartHereDoc:
          case PhpLexer.Binary:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.ATTRIBUTE_NAME, 0, true, false, false));
            break;
          case PhpLexer.HtmlText:
          case PhpLexer.XmlStart:
          case PhpLexer.PHPStart:
          case PhpLexer.HtmlScriptOpen:
          case PhpLexer.HtmlStyleOpen:
          case PhpLexer.HtmlComment:
          case PhpLexer.HtmlDtd:
          case PhpLexer.HtmlOpen:
          case PhpLexer.XmlText:
          case PhpLexer.XmlClose:
          case PhpLexer.PHPStartInside:
          case PhpLexer.HtmlClose:
          case PhpLexer.HtmlSlashClose:
          case PhpLexer.HtmlSlash:
          case PhpLexer.HtmlEquals:
          case PhpLexer.HtmlStartQuoteString:
          case PhpLexer.HtmlStartDoubleQuoteString:
          case PhpLexer.HtmlHex:
          case PhpLexer.HtmlDecimal:
          case PhpLexer.HtmlSpace:
          case PhpLexer.HtmlName:
          case PhpLexer.StringPart:
          case PhpLexer.UnicodeEscape:
            result.addIfNeeded(line, column, EditorColorScheme.Ninja);
            break;
          case PhpLexer.PHPStartInsideQuoteString:
          case PhpLexer.HtmlEndQuoteString:
          case PhpLexer.HtmlQuoteString:
          case PhpLexer.PHPStartDoubleQuoteString:
          case PhpLexer.HtmlEndDoubleQuoteString:
          case PhpLexer.HtmlDoubleQuoteString:
          case PhpLexer.ScriptText:
          case PhpLexer.HtmlScriptClose:
          case PhpLexer.PHPStartInsideScript:
          case PhpLexer.StyleBody:
          case PhpLexer.PHPEnd:
          case PhpLexer.AttributeStart:
            result.addIfNeeded(line, column, EditorColorScheme.LITERAL);
            break;
          case PhpLexer.Error:
          case PhpLexer.ErrorInside:
          case PhpLexer.ErrorHtmlDoubleQuote:
          case PhpLexer.ErrorHtmlQuote:
            result.addIfNeeded(line, column, EditorColorScheme.COLOR_WARNING);
            int[] err = Utils.setWaringSpan(result, line, column);
            break;

          default:
            result.addIfNeeded(line, column, EditorColorScheme.TEXT_NORMAL);
            prevIsTagName = false;
            classNamePrevious = false;
            break;
        }

        first = false;
      }

      result.determine(lastLine);
      error.analyze(content, result, delegate);

    } catch (IOException e) {
      e.printStackTrace();
      Log.e("TAG", e.getMessage());
    }
  }
}
