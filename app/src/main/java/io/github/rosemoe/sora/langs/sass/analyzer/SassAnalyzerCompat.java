package io.github.rosemoe.sora.langs.sass.analyzer;

import android.util.Log;
import de.larsgrefer.sass.embedded.SassCompilationFailedException;
import de.larsgrefer.sass.embedded.SassCompiler;
import de.larsgrefer.sass.embedded.android.AndroidSassCompilerFactory;
import io.github.rosemoe.sora.langs.sass.ScssLexer;
import io.github.rosemoe.sora.langs.sass.ScssParser;
import io.github.rosemoe.sora.langs.sass.ScssParserBaseListener;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import io.github.rosemoe.sora.text.TextStyle;

import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import java.util.Stack;

import io.github.rosemoe.sora.data.BlockLine;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

import java.io.IOException;
import java.io.StringReader;

import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class SassAnalyzerCompat implements CodeAnalyzer {
  private boolean isSassMod = true;

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    try {

      CodePointCharStream stream = CharStreams.fromReader(new StringReader(content.toString()));
      ScssLexer lexer = new ScssLexer(stream);

      var classNamePrevious = false;
      Token token, preToken = null, prePreToken = null;
      boolean first = true;
      Stack<BlockLine> stack = new Stack<>();
      int maxSwitch = 1, currSwitch = 0;
      int lastLine = 1;
      int line, column;
      var prevIsTagName = false;
      int pre = -1;

      while (delegate.shouldAnalyze()) {
        token = lexer.nextToken();
        if (token == null) break;
        if (token.getType() == ScssLexer.EOF) {
          lastLine = token.getLine() - 1;
          break;
        }
        line = token.getLine() - 1;
        column = token.getCharPositionInLine();
        lastLine = line;

        switch (token.getType()) {
          case ScssLexer.Space:
            if (first) {
              result.addNormalIfNull();
            }
            break;
          case ScssLexer.BlockStart:
          case ScssLexer.BlockEnd:
            {
              if (!stack.isEmpty()) {
                BlockLine block1 = stack.pop();
                block1.endLine = line;
                block1.endColumn = column;
                if (block1.startLine != block1.endLine) {
                  result.addBlockLine(block1);
                }
              }
              result.addIfNeeded(
                  line,
                  column,
                  TextStyle.makeStyle(EditorColorScheme.ATTRIBUTE_VALUE, 0, true, false, false));
              break;
            }
            // from @ using
          case ScssLexer.Import:
          case ScssLexer.Include:
          case ScssLexer.Use:
          case ScssLexer.Require:
          case ScssLexer.Charset:
          case ScssLexer.Mixin:
          case ScssLexer.Function:
          case ScssLexer.FontFace:
          case ScssLexer.Forward:
          case ScssLexer.Content:
          case ScssLexer.Keyframes:
          case ScssLexer.Return:
          case ScssLexer.Media:
          case ScssLexer.Extend:
          case ScssLexer.Warn:
          case ScssLexer.Error:
          case ScssLexer.If:
          case ScssLexer.AtIf:
          case ScssLexer.AtFor:
          case ScssLexer.AtElse:
          case ScssLexer.AtWhile:
          case ScssLexer.AtEach:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.javaparament, 0, true, false, false));
            break;

            // from px dp ....
          case ScssLexer.AbsLength:
          case ScssLexer.FontRelative:
          case ScssLexer.ViewportRelative:
          case ScssLexer.Angle:
          case ScssLexer.Resolution:
          case ScssLexer.Freq:
          case ScssLexer.Time:
          case ScssLexer.Percentage:
            result.addIfNeeded(line, column, EditorColorScheme.jsoprator);
            break;
          case ScssLexer.Uri:
          case ScssLexer.Format:
            result.addIfNeeded(line, column, EditorColorScheme.KEYWORD);
            break;
          case ScssLexer.From:
          case ScssLexer.To:
          case ScssLexer.Through:
          case ScssLexer.Only:
          case ScssLexer.Not:
          case ScssLexer.And:
          case ScssLexer.Using:
          case ScssLexer.As:
          case ScssLexer.With:
          case ScssLexer.Or:
          case ScssLexer.In:
          case ScssLexer.Default:
          case ScssLexer.Important:
            result.addIfNeeded(line, column, EditorColorScheme.jsattr);
            break;
            /// Syombl
          case ScssLexer.Lparen:
          case ScssLexer.Rparen:
          case ScssLexer.Lbrack:
          case ScssLexer.Rbrack:
          case ScssLexer.Dot:
          case ScssLexer.Comma:
          case ScssLexer.Colon:
          case ScssLexer.Semi:
          case ScssLexer.Tilde:
          case ScssLexer.Under:
          case ScssLexer.Dollar:
          case ScssLexer.At:
          case ScssLexer.Amp:
          case ScssLexer.Hash:
          case ScssLexer.True:
          case ScssLexer.False:
          case ScssLexer.Plus:
          case ScssLexer.Div:
          case ScssLexer.Minus:
          case ScssLexer.Times:
          case ScssLexer.Eq:
          case ScssLexer.NotEq:
          case ScssLexer.Greater:
          case ScssLexer.Less:
          case ScssLexer.Includes:
          case ScssLexer.DashMatch:
          case ScssLexer.Pipe:
          case ScssLexer.Cdo:
          case ScssLexer.Cdc:
          case ScssLexer.PseudoNot:
          case ScssLexer.Calc:
          case ScssLexer.Rotate:
          case ScssLexer.Var:
          case ScssLexer.Rgba:
          case ScssLexer.Repeat:
          case ScssLexer.PrefixMatch:
          case ScssLexer.SuffixMatch:
          case ScssLexer.SubstringMatch:
            result.addIfNeeded(line, column, EditorColorScheme.javakeyword);
            break;
          case ScssLexer.Number:
            result.addIfNeeded(line, column, EditorColorScheme.javanumber);
            break;
          case ScssLexer.String_:
          case ScssLexer.Variable:
          case ScssLexer.VendorPrefix:
            result.addIfNeeded(line, column, EditorColorScheme.javakeywordoprator);
            break;
            // Comment
          case ScssLexer.Comment:
          case ScssLexer.MultiLineComment:
          case ScssLexer.LineComment:
            result.addIfNeeded(line, column, EditorColorScheme.COMMENT);
            break;

          case ScssLexer.HtmlTags:
            {
              result.addIfNeeded(line, column, EditorColorScheme.htmltag);
              break;
            }
          case ScssLexer.Ident:
            {
              int color = EditorColorScheme.TEXT_NORMAL;

              if (pre == ScssLexer.Colon) {
                color = EditorColorScheme.javatype;
              }
              if (pre == ScssLexer.Dollar) {
                color = EditorColorScheme.javafun;
              }
              if (pre == ScssLexer.VendorPrefix && pre == ScssLexer.Variable) {
                color = EditorColorScheme.jsfun;
              }
              if (token.getText().equals("red")) color = EditorColorScheme.red;

              result.addIfNeeded(line, column, color);
              break;
            }
          default:
            result.addIfNeeded(line, column, EditorColorScheme.TEXT_NORMAL);
            prevIsTagName = false;
            classNamePrevious = false;
            break;
        }

        if (token.getType() != ScssLexer.Space) {
          pre = token.getType();
        }
        first = false;
      }
      try (SassCompiler compiler =
          AndroidSassCompilerFactory.bundled(GhostIdeAppLoader.getContext())) {
        if (isSassMod) compiler.compileSassString(content.toString());
        else compiler.compileScssString(content.toString());
      } catch (SassCompilationFailedException e) {

        int lines = e.getCompileFailure().getSpan().getStart().getLine();
        int columnz = e.getCompileFailure().getSpan().getStart().getColumn();
        Utils.setErrorSpan(result, lines, columnz + 1);
      }

    } catch (IOException e) {
      e.printStackTrace();
      Log.e("TAG", e.getMessage());
    }
  }

  public void setSassMod(boolean isSass) {
    this.isSassMod = isSass;
  }
}
