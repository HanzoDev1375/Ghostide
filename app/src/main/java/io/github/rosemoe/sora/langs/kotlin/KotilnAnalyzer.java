package io.github.rosemoe.sora.langs.kotlin;

import android.graphics.Color;
import android.util.Log;
import io.github.rosemoe.sora.data.Span;
import io.github.rosemoe.sora.langs.kotlin.jum.KtJu;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import io.github.rosemoe.sora.text.TextStyle;

import io.github.rosemoe.sora.widget.TextSummry.HTMLConstants;
import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import java.util.Arrays;
import java.util.Stack;

import io.github.rosemoe.sora.data.BlockLine;
import ninjacoder.ghostide.androidtools.r8.android.KotlinCodeAnalyzerCompat;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
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
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class KotilnAnalyzer implements CodeAnalyzer {

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    try {
      CodePointCharStream stream = CharStreams.fromReader(new StringReader(content.toString()));
      var auto = new KotilnAutoText();
      auto.setKeywords(KotilnKeys.ktKeyWord);
      var ktinfo = new KotilnAutoText.Identifiers();
      ktinfo.begin();
      var lexer = new KotlinLexer(stream);
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
        if (token.getType() == KotlinLexer.EOF) {
          lastLine = token.getLine() - 1;
          break;
        }
        line = token.getLine() - 1;
        column = token.getCharPositionInLine();
        lastLine = line;

        switch (token.getType()) {
          case KotlinLexer.WS:
            if (first) result.addNormalIfNull();
            break;
          case KotlinLexer.AT:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.javaoprator, 0, true, false, false));

            break;
          case KotlinLexer.ANNOTATION:
          case KotlinLexer.ABSTRACT:
          case KotlinLexer.BY:
          case KotlinLexer.CATCH:
          case KotlinLexer.COMPANION:
          case KotlinLexer.CONSTRUCTOR:
          case KotlinLexer.CROSSINLINE:
          case KotlinLexer.DATA:
          case KotlinLexer.DYNAMIC:
          case KotlinLexer.ENUM:
          case KotlinLexer.EXTERNAL:
          case KotlinLexer.FINAL:
          case KotlinLexer.FINALLY:
          case KotlinLexer.IMPORT:
          case KotlinLexer.INFIX:
          case KotlinLexer.INIT:
          case KotlinLexer.INLINE:
          case KotlinLexer.INNER:
          case KotlinLexer.INTERNAL:
          case KotlinLexer.LATEINIT:
          case KotlinLexer.NOINLINE:
          case KotlinLexer.OPEN:
          case KotlinLexer.OPERATOR:
          case KotlinLexer.OUT:
          case KotlinLexer.OVERRIDE:
          case KotlinLexer.PRIVATE:
          case KotlinLexer.PROTECTED:
          case KotlinLexer.PUBLIC:
          case KotlinLexer.REIFIED:
          case KotlinLexer.SEALED:
          case KotlinLexer.TAILREC:
          case KotlinLexer.VARARG:
          case KotlinLexer.WHERE:
          case KotlinLexer.CONST:
          case KotlinLexer.SUSPEND:
          case KotlinLexer.RETURN_AT:
          case KotlinLexer.CONTINUE_AT:
          case KotlinLexer.BREAK_AT:
          case KotlinLexer.PACKAGE:
          case KotlinLexer.CLASS:
          case KotlinLexer.INTERFACE:
          case KotlinLexer.FUN:
          case KotlinLexer.OBJECT:
          case KotlinLexer.VAL:

          case KotlinLexer.VAR:
          case KotlinLexer.TYPE_ALIAS:
          case KotlinLexer.THIS:
          case KotlinLexer.SUPER:
          case KotlinLexer.TYPEOF:
          case KotlinLexer.IF:
          case KotlinLexer.ELSE:
          case KotlinLexer.WHEN:
          case KotlinLexer.TRY:
          case KotlinLexer.FOR:
          case KotlinLexer.DO:
          case KotlinLexer.WHILE:
          case KotlinLexer.THROW:
          case KotlinLexer.RETURN:
          case KotlinLexer.CONTINUE:
          case KotlinLexer.BREAK:
          case KotlinLexer.AS:
          case KotlinLexer.IS:
          case KotlinLexer.IN:
          case KotlinLexer.NOT_IS:
          case KotlinLexer.NOT_IN:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.javaoprator, 0, true, false, false));
            break;
          case KotlinLexer.RealLiteral:
          case KotlinLexer.FloatLiteral:
          case KotlinLexer.DoubleLiteral:
          case KotlinLexer.IntegerLiteral:

          case KotlinLexer.BinLiteral:
          case KotlinLexer.LongLiteral:
          case KotlinLexer.BooleanLiteral:
          case KotlinLexer.NullLiteral:
          case KotlinLexer.CharacterLiteral:
          case KotlinLexer.HexLiteral:
            Span span = Span.obtain(column, EditorColorScheme.javatype);
            if (token.getType() == KotlinLexer.HexLiteral) {
              try {
                span.setUnderlineColor(Integer.parseInt(token.getText(), 16));
              } catch (Exception e) {
                span.setUnderlineColor(Color.TRANSPARENT);
              }
            }
            result.add(line, span);
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.javatype, 0, true, false, false));
            break;
          case KotlinLexer.QUOTE_OPEN:
          case KotlinLexer.TRIPLE_QUOTE_OPEN:
          case KotlinLexer.QUOTE_CLOSE:
          case KotlinLexer.LineStrRef:
          case KotlinLexer.LineStrText:
          case KotlinLexer.LineStrEscapedChar:
          case KotlinLexer.LineStrExprStart:
          case KotlinLexer.TRIPLE_QUOTE_CLOSE:
          case KotlinLexer.MultiLineStringQuote:
          case KotlinLexer.MultiLineStrRef:
          case KotlinLexer.MultiLineStrText:
          case KotlinLexer.MultiLineStrExprStart:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.javanumber, 0, true, false, false));
            break;
          case KotlinLexer.RESERVED:
          case KotlinLexer.DOT:
          case KotlinLexer.COMMA:
          case KotlinLexer.LPAREN:
          case KotlinLexer.RPAREN:
          case KotlinLexer.LSQUARE:
          case KotlinLexer.RSQUARE:

          case KotlinLexer.MULT:
          case KotlinLexer.MOD:
          case KotlinLexer.DIV:
          case KotlinLexer.ADD:
          case KotlinLexer.SUB:
          case KotlinLexer.INCR:
          case KotlinLexer.DECR:
          case KotlinLexer.CONJ:
          case KotlinLexer.DISJ:
          case KotlinLexer.COLON:
          case KotlinLexer.SEMICOLON:
          case KotlinLexer.ASSIGNMENT:
          case KotlinLexer.ADD_ASSIGNMENT:
          case KotlinLexer.SUB_ASSIGNMENT:
          case KotlinLexer.MULT_ASSIGNMENT:
          case KotlinLexer.DIV_ASSIGNMENT:
          case KotlinLexer.MOD_ASSIGNMENT:
          case KotlinLexer.ARROW:
          case KotlinLexer.DOUBLE_ARROW:
          case KotlinLexer.RANGE:
          case KotlinLexer.COLONCOLON:
          case KotlinLexer.DOUBLE_SEMICOLON:
          case KotlinLexer.LANGLE:
          case KotlinLexer.RANGLE:
          case KotlinLexer.LE:
          case KotlinLexer.GE:
          case KotlinLexer.EXCL_EQ:
          case KotlinLexer.EXCL_EQEQ:
          case KotlinLexer.AS_SAFE:
          case KotlinLexer.EQEQ:
          case KotlinLexer.EQEQEQ:
          case KotlinLexer.HASH:
          case KotlinLexer.SINGLE_QUOTE:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.javaparament, 0, true, false, false));
            break;
          case KotlinLexer.LineComment:
          case KotlinLexer.ShebangLine:
          case KotlinLexer.DelimitedComment:
          case KotlinLexer.Inside_Comment:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.COMMENT, 0, true, false, false));
            break;

          case KotlinLexer.Identifier:
            {
              int color = EditorColorScheme.TEXT_NORMAL;
              boolean isbold = false, isItalic = false;
              ktinfo.addIdentifier(token.getText());
              var mytext = token.getText();
              boolean hasktpr = false;
              int typemode = previous.getType();
              if (typemode == KotlinLexer.AT) {
                color = EditorColorScheme.ATTRIBUTE_NAME;
              }
              if (typemode == KotlinLexer.HASH) {
                color = EditorColorScheme.javaoprator;
              }
              if (typemode == KotlinLexer.DOT) {
                color = EditorColorScheme.HTML_TAG;
              }
              if (typemode == KotlinLexer.COLON) {
                color = EditorColorScheme.KEYWORD;
                hasktpr = true;
              }
              if (typemode == KotlinLexer.CLASS
                  || typemode == KotlinLexer.FUN
                  || typemode == KotlinLexer.INNER
                  || typemode == KotlinLexer.INTERFACE
                  || typemode == KotlinLexer.INTERNAL
                  || typemode == KotlinLexer.PACKAGE
                  || typemode == KotlinLexer.IMPORT) {
                color = EditorColorScheme.Ninja;
              }
              if (typemode == KotlinLexer.AS
                  || typemode == KotlinLexer.BY
                  || typemode == KotlinLexer.WHEN
                  || typemode == KotlinLexer.WHERE
                  || typemode == KotlinLexer.IS
                  || typemode == KotlinLexer.IN) {
                color = EditorColorScheme.LITERAL;
              }
              if (typemode == KotlinLexer.VAL || typemode == KotlinLexer.VAR) {
                color = EditorColorScheme.javatype;
                isItalic = true;
              }
              if (token.getText().equals("apply") || token.getText().equals("let")) {

                color = EditorColorScheme.Ninja;
              }
              if (token.getText().equals("field")) {
                isbold = true;
                color = EditorColorScheme.white;
              }
              if (token.getText().equals("run")
                  || token.getText().equals("aslo")
                  || token.getText().equals("launch")) {
                isbold = true;
                color = EditorColorScheme.javafield;
              }
              if (token.getText().equals("main")) {
                isbold = true;
                color = EditorColorScheme.javafun;
              }
              // this for ninja lang
              if (token.getText().equals("runAsUi")) {
                color = EditorColorScheme.javaoprator;
              }
              // next
              if (ObjectUtils.getNextLexer(lexer, '(')) {
                color = EditorColorScheme.javafield;
              }
              if (ObjectUtils.getNextLexer(lexer, '.')) {
                color = EditorColorScheme.javafun;
              }
              if (ObjectUtils.getNextLexer(lexer, ',')) {
                color = EditorColorScheme.javaparament;
              }
              if (ObjectUtils.getNextLexer(lexer, ')')) {
                color = EditorColorScheme.javaparament;
              }
              // -> str
              if (ObjectUtils.getNextLexer(lexer, '>')) {
                color = EditorColorScheme.javafun;
              }
              if (!hasktpr)
                if (ObjectUtils.getNextLexer(lexer, ':')) {
                  color = EditorColorScheme.javanumber;
                }
              // توابع حوزه همزمانی (coroutines)

              String[] ktScopeFunctions = {"with"};
              String[] ktCollectionFunctions = {
                "filter",
                "map",
                "flatMap",
                "fold",
                "reduce",
                "forEach",
                "any",
                "all",
                "none",
                "first",
                "last",
                "contains",
                "reversed",
                "sorted",
                "sum",
                "average",
                "count",
                "max",
                "min",
                "take",
                "drop",
                "zip",
                "plus",
                "minus",
                "distinct",
                "groupBy",
                "associateBy",
                "partition",
                "onEach",
                "shuffled",
                "joinToString"
              };
              if (KtJu.ktStd(mytext)) {
                color = EditorColorScheme.javafield;
              } else if (KtJu.ktcoroutine(mytext)) {
                color = EditorColorScheme.javafun;
              } else if (Arrays.asList(ktScopeFunctions).contains(token.getText())) {
                color = EditorColorScheme.javaoprator;
              } else if (Arrays.asList(ktCollectionFunctions).contains(token.getText())) {
                color = EditorColorScheme.javaparament;
              }

              result.addIfNeeded(
                  line, column, TextStyle.makeStyle(color, 0, isbold, isItalic, false));
              break;
            }
          case KotlinLexer.LCURL:
            {
              BlockLine block = result.obtainNewBlock();
              block.startLine = line;
              block.startColumn = column;
              // اضافه کردن بلوک به استک
              var lists = result.getBlocks();
              var colorres = EditorColorScheme.htmlblocknormal;
              if (GhostIdeAppLoader.getPrefManager().getBoolean("breaks", false) == true)
                colorres = HTMLConstants.get(stack.size());
              else colorres = EditorColorScheme.htmlblocknormal;
              stack.push(block);
              result.addIfNeeded(line, column, colorres);
              // بررسی maxSwitch
              if (stack.isEmpty()) {
                if (currSwitch > maxSwitch) {
                  maxSwitch = currSwitch;
                }
                currSwitch = 0;
              }
              currSwitch++; // ا
              break;
            }

          case KotlinLexer.RCURL:
            {
              if (!stack.isEmpty()) {
                BlockLine b = stack.pop();
                b.endLine = line;
                b.endColumn = column;
                if (b.startLine != b.endLine) {
                  result.addBlockLine(b); // اضافه کردن بلوک به نتایج
                }
              }
              var lists = result.getBlocks();
              var colorid = EditorColorScheme.htmlblocknormal;

              if (GhostIdeAppLoader.getPrefManager().getBoolean("breaks", false) == true)
                colorid = HTMLConstants.get(stack.size());
              else colorid = EditorColorScheme.htmlblocknormal;
              result.addIfNeeded(line, column, colorid);
              break;
            }
          default:
            result.addIfNeeded(line, column, EditorColorScheme.TEXT_NORMAL);
            break;
        }

        first = false;
        if (token.getType() != KotlinLexer.WS && token.getType() != KotlinLexer.NL) {
          previous = token;
        }
      }
      result.determine(lastLine);
      if (stack.isEmpty()) {
        if (currSwitch > maxSwitch) {
          maxSwitch = currSwitch;
        }
      }
      ktinfo.finish();
      result.setExtra(ktinfo);
      result.setSuppressSwitch(maxSwitch + 10);

      if (GhostIdeAppLoader.getAnalyzercod().getBoolean("Analyzercod", false) == true) {
        var analyzers = new KotlinCodeAnalyzerCompat(content.toString());
        var re = analyzers.analyze();
        if (re.isSuccess()) {
          System.out.println("Not found Error");
        } else {
          if (re.hasErrors())
            Utils.setErrorSpan(result, re.getStartLineError(), re.getStartColErrors());
          else System.out.print("no error");
          if (re.hasWarnings())
            Utils.setWaringSpan(result, re.getStartLineWar(), re.getStartColWar());
          else System.out.println("no error");
        }
      }
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
