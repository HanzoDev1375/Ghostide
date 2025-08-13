package io.github.rosemoe.sora.langs.python;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.rosemoe.sora.data.RainbowBracketHelper;
import io.github.rosemoe.sora.data.Span;
import io.github.rosemoe.sora.langs.python.formatter.PythonCodeAnalyzerAst;
import io.github.rosemoe.sora.langs.python.formatter.PythonSyntaxChecker;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import ir.ninjacoder.ghostide.IdeEditor;
import android.graphics.Color;
import android.util.Log;

import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.ListCss3Color;
import java.io.InputStreamReader;
import java.util.List;
import io.github.rosemoe.sora.data.NavigationItem;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
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

public class PythonCodeAnalyzer implements CodeAnalyzer {

  private PythonErrorManager errors;
  protected IdeEditor editor;
  private RainbowBracketHelper rb;
  Token token = null, preToken = null, prePreToken = null;

  public PythonCodeAnalyzer(IdeEditor editor) {
    this.editor = editor;
  }

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    try {

      CodePointCharStream stream = CharStreams.fromReader(new StringReader(content.toString()));
      var lexer = new PythonLexerCompat(stream);
      var auto = new PythonAutoComplete(editor);
      auto.setKeywords(PythonLang.keywords);
      rb = new RainbowBracketHelper(editor.getTextAsString());
      var info = new PythonAutoComplete.Identifiers();
      info.begin();
      errors = new PythonErrorManager(editor);
      var classNamePrevious = false;

      boolean first = true;
      Stack<BlockLine> stack = new Stack<>();
      List<NavigationItem> labels = new ArrayList<>();
      int type, currSwitch = 1, maxSwitch = 0, previous = -1;
      int lastLine = 1;
      int line, column;
      var prevIsTagName = false;

      while (delegate.shouldAnalyze()) {
        token = lexer.nextToken();
        if (token == null) break;
        if (token.getType() == PythonLexerCompat.EOF) {
          lastLine = token.getLine() - 1;
          break;
        }
        line = token.getLine() - 1;
        type = token.getType();

        column = token.getCharPositionInLine();
        if (type == PythonLexerCompat.EOF) {
          lastLine = line;
          break;
        }

        switch (type) {
          case PythonLexerCompat.WS:
            //   case PythonLexerCompat.NEWLINE:
            if (first) {
              result.addNormalIfNull();
            }
            break;

          case PythonLexerCompat.LBRACE:
          case PythonLexerCompat.LPAR:
          case PythonLexerCompat.LSQB:
            rb.handleOpenBracket(result, line, column, EditorColorScheme.pycolormatch4);
            break;
          case PythonLexerCompat.RBRACE:
          case PythonLexerCompat.RPAR:
          case PythonLexerCompat.RSQB:
            rb.handleCloseBracket(result, line, column, EditorColorScheme.pycolormatch4);
            break;
          case PythonLexerCompat.AND:
          case PythonLexerCompat.AS:
          case PythonLexerCompat.ASYNC:
          case PythonLexerCompat.AWAIT:
          case PythonLexerCompat.BREAK:
          case PythonLexerCompat.CLASS:
          case PythonLexerCompat.CONTINUE:
          case PythonLexerCompat.DEF:
          case PythonLexerCompat.DEL:
          case PythonLexerCompat.ELIF:
          case PythonLexerCompat.ELSE:
          case PythonLexerCompat.EXCEPT:
          case PythonLexerCompat.FALSE:
          case PythonLexerCompat.FINALLY:
          case PythonLexerCompat.FOR:
          case PythonLexerCompat.GLOBAL:
          case PythonLexerCompat.IF:
          case PythonLexerCompat.IMPORT:
          case PythonLexerCompat.IN:
          case PythonLexerCompat.IS:
          case PythonLexerCompat.RAISE:
          case PythonLexerCompat.RETURN:
          case PythonLexerCompat.TRUE:
          case PythonLexerCompat.TRY:
          case PythonLexerCompat.WITH:
          case PythonLexerCompat.YIELD:
          case PythonLexerCompat.FROM:
          case PythonLexerCompat.WHILE:
          case PythonLexerCompat.ASSERT:
          case PythonLexerCompat.LAMBDA:
          case PythonLexerCompat.NONE:
          case PythonLexerCompat.NONLOCAL:
          case PythonLexerCompat.NOT:
          case PythonLexerCompat.OR:
          case PythonLexerCompat.PASS:
          case PythonLexerCompat.NAME_OR_TYPE:
          case PythonLexerCompat.NAME_OR_MATCH:
          case PythonLexerCompat.NAME_OR_CASE:
            //    case PythonLexerCompat.NAME_OR_WILDCARD:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.pykeyword, 0, true, false, false));
            break;
          case PythonLexerCompat.DOT:
          case PythonLexerCompat.STAR:
          case PythonLexerCompat.COMMA:
          case PythonLexerCompat.VBAR:
          case PythonLexerCompat.EQUAL:
          case PythonLexerCompat.PERCENT:
          case PythonLexerCompat.EQEQUAL:
          case PythonLexerCompat.NOTEQUAL:
          case PythonLexerCompat.LESSEQUAL:
          case PythonLexerCompat.GREATEREQUAL:
          case PythonLexerCompat.TILDE:
          case PythonLexerCompat.CIRCUMFLEX:
          case PythonLexerCompat.LEFTSHIFT:
          case PythonLexerCompat.RIGHTSHIFT:
          case PythonLexerCompat.DOUBLESTAR:
          case PythonLexerCompat.PLUSEQUAL:
          case PythonLexerCompat.MINEQUAL:
          case PythonLexerCompat.STAREQUAL:
          case PythonLexerCompat.SLASHEQUAL:
          case PythonLexerCompat.PERCENTEQUAL:
          case PythonLexerCompat.AMPEREQUAL:
          case PythonLexerCompat.VBAREQUAL:
          case PythonLexerCompat.CIRCUMFLEXEQUAL:
          case PythonLexerCompat.LEFTSHIFTEQUAL:
          case PythonLexerCompat.RIGHTSHIFTEQUAL:
          case PythonLexerCompat.DOUBLESTAREQUAL:
          case PythonLexerCompat.DOUBLESLASH:
          case PythonLexerCompat.DOUBLESLASHEQUAL:
          case PythonLexerCompat.AT:
          case PythonLexerCompat.ATEQUAL:
          case PythonLexerCompat.RARROW:
          case PythonLexerCompat.ELLIPSIS:
          case PythonLexerCompat.COLONEQUAL:
          case PythonLexerCompat.EXCLAMATION:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.pysymbol, 0, true, false, false));
            break;

          case PythonLexerCompat.STRING:
            int colors = EditorColorScheme.pystring;
            result.addIfNeeded(line, column, TextStyle.makeStyle(colors, 0, true, false, false));
            break;
          case PythonLexerCompat.NUMBER:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.pynumber, 0, true, false, false));
            break;
          case PythonLexerCompat.FSTRING:
            result.addIfNeeded(line, column, EditorColorScheme.ATTRIBUTE_VALUE);
            break;

          case PythonLexerCompat.IDENTIFIER:
            {
              int colorid = EditorColorScheme.TEXT_NORMAL;
              boolean isBold = false;
              boolean isUnderLine = false;
              info.addIdentifier(token.getText());

              if (previous == PythonLexerCompat.CLASS) {
                colorid = EditorColorScheme.pycolormatch1;
                isBold = true;
                isUnderLine = false;
              }
              //              if (previous == PythonLexerCompat.DEF) {
              //                colorid = EditorColorScheme.pycolormatch2;
              //              }
              if (previous == PythonLexerCompat.IF) {
                colorid = EditorColorScheme.pycolormatch3;
                isBold = true;
                isUnderLine = false;
              }
              if (previous == PythonLexerCompat.FROM) {
                colorid = EditorColorScheme.pycolormatch3;
                isBold = false;
                isUnderLine = false;
              }
              if (previous == PythonLexerCompat.IMPORT) {
                colorid = EditorColorScheme.pycolormatch3;
                isBold = false;
                isUnderLine = false;
              }
              if (previous == PythonLexerCompat.EQUAL) {
                colorid = EditorColorScheme.pycolormatch1;
                isUnderLine = false;
                isBold = true;
              }
              if (previous == PythonLexerCompat.AT) {
                colorid = EditorColorScheme.pysymbol;
                isBold = true;
              }
              if (previous == PythonLexerCompat.OR
                  || previous == PythonLexerCompat.DOT
                  || previous == PythonLexerCompat.RETURN
                  || previous == PythonLexerCompat.YIELD
                  || previous == PythonLexerCompat.COLON) {
                colorid = EditorColorScheme.pycolormatch2;
                isBold = true;
                isUnderLine = false;
              }
              Set<String> methodNames = new HashSet<>();

              try {
                var input = GhostIdeAppLoader.getContext().getAssets().open("methods.json");
                var array = JsonParser.parseReader(new InputStreamReader(input)).getAsJsonArray();
                array.forEach(
                    it -> {
                      JsonObject obj = it.getAsJsonObject();
                      if (obj.has("name")) {
                        methodNames.add(obj.get("name").getAsString());
                      }
                    });
              } catch (Exception err) {
                Log.e("JsonErrorToRun" + PythonCodeAnalyzer.class.getName(), err.getMessage());
              }

              if (methodNames.contains(token.getText())
                  || methodNames.stream()
                      .anyMatch(name -> name.equalsIgnoreCase(token.getText()))) {
                colorid = EditorColorScheme.pycolormatch3;
              }
              result.addIfNeeded(
                  line, column, TextStyle.makeStyle(colorid, 0, isBold, false, false, isUnderLine));
              break;
            }

          case PythonLexerCompat.COMMENT:
            result.addIfNeeded(line, column, EditorColorScheme.COMMENT);
            break;
          default:
            result.addIfNeeded(line, column, EditorColorScheme.TEXT_NORMAL);
            prevIsTagName = false;
            classNamePrevious = false;
            break;
        }

        first = false;
        if (type != PythonLexerCompat.WS) {
          previous = type;
        }
      }
      info.finish();
      result.setExtra(info);
      result.determine(lastLine);
      var ch = new PythonSyntaxChecker();
      ch.checkSyntax(GhostIdeAppLoader.getContext(), content.toString());
      if (ch.hasErrors()) {
        ch.getErrors()
            .forEach(
                it -> {
                  Utils.setErrorSpan(result, it.line, it.column);
                });
      }
      if (ch.hasWarnings()) {
        ch.getWarnings()
            .forEach(
                it -> {
                  Utils.setWaringSpan(result, it.line, it.column, EditorColorScheme.pysymbol);
                });
      }
      if (ch.hasTypo()) {
        ch.getTypo()
            .forEach(
                it -> {
                  Utils.setTypoSpan(result, it.line, it.column);
                });
      }
      // error manager not work
      //   errors.analyze(content, result, delegate);
      result.setSuppressSwitch(maxSwitch + 10);
      var pyast = new PythonCodeAnalyzerAst();
      pyast.analyze(GhostIdeAppLoader.getContext(), content.toString());
      var listAst = pyast.getElements();
      pyast
          .getMethods()
          .forEach(
              v -> {
                Utils.setSpanEFO2(
                    result, v.line, v.column, EditorColorScheme.javafield, false, true);
              });
      pyast
          .getFunctions()
          .forEach(
              v -> {
                Utils.setSpanEFO2(result, v.line, v.column, EditorColorScheme.javafun, true, false);
              });
      pyast
          .getClasses()
          .forEach(
              v -> {
                Utils.setSpanEFO2(
                    result, v.line, v.column, EditorColorScheme.javaoprator, true, false);
              });
      pyast
          .getVariables()
          .forEach(
              v -> {
                Utils.setSpanEFO2(
                    result, v.line, v.column, EditorColorScheme.javatype, false, false);
              });
      result.setNavigation(labels);
    } catch (IOException e) {
      e.printStackTrace();
      Log.e("TAG", e.getMessage());
    }
  }

  public long Bold() {
    return TextStyle.makeStyle(EditorColorScheme.ATTRIBUTE_VALUE, 0, true, false, false);
  }

  public long Italic() {
    return TextStyle.makeStyle(EditorColorScheme.ATTRIBUTE_NAME, 0, false, true, false);
  }
}
