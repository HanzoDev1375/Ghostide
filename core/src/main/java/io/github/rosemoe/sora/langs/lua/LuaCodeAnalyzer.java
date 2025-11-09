package io.github.rosemoe.sora.langs.lua;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

import java.io.StringReader;
import java.util.regex.Pattern;

import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.langs.internal.Identifiers;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import ir.ninjacoder.codesnap.antlr4.lua.LuaLexer;

public class LuaCodeAnalyzer implements CodeAnalyzer {

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    try {
      Token token;
      int pretoken = -1;
      int type;
      int lastLine = 1;
      int line, column;
      Identifiers info = new Identifiers();
      info.begin();
      var lexer = new LuaLexer(CharStreams.fromReader(new StringReader(content.toString())));
      while (delegate.shouldAnalyze()) {
        token = lexer.nextToken();
        if (token == null) break;
        if (token.getType() == LuaLexer.EOF) {
          lastLine = token.getLine() - 1;
          break;
        }
        line = token.getLine() - 1;
        type = token.getType();
        column = token.getCharPositionInLine();
        if (type == LuaLexer.EOF) {
          lastLine = line;
          break;
        }
        switch (type) {
          case LuaLexer.WS:
          case LuaLexer.NL:
            result.addNormalIfNull();
            break;
          case LuaLexer.BREAK:
          case LuaLexer.GOTO:
          case LuaLexer.DO:
          case LuaLexer.END:
          case LuaLexer.WHILE:
          case LuaLexer.REPEAT:
          case LuaLexer.UNTIL:
          case LuaLexer.IF:
          case LuaLexer.THEN:
          case LuaLexer.ELSEIF:
          case LuaLexer.ELSE:
          case LuaLexer.FOR:
          case LuaLexer.IN:
          case LuaLexer.FUNCTION:
          case LuaLexer.LOCAL:
          case LuaLexer.RETURN:
          case LuaLexer.CONTINUE:
          case LuaLexer.NIL:
          case LuaLexer.FALSE:
          case LuaLexer.TRUE:
          case LuaLexer.NOT:
          case LuaLexer.AND:
          case LuaLexer.OR:
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.javakeyword, 0, true, false, false));
            break;

          case LuaLexer.LT:
          case LuaLexer.GT:
          case LuaLexer.LE:
          case LuaLexer.GE:
          case LuaLexer.EE:
          case LuaLexer.SQEQ:
          case LuaLexer.PLUS:
          case LuaLexer.MINUS:
          case LuaLexer.STAR:
          case LuaLexer.SLASH:
          case LuaLexer.SS:
          case LuaLexer.PER:
          case LuaLexer.AMP:
          case LuaLexer.PIPE:
          case LuaLexer.CARET:
          case LuaLexer.SQUIG:
          case LuaLexer.LL:
          case LuaLexer.GG:
          case LuaLexer.DD:
          case LuaLexer.DDD:
          case LuaLexer.POUND:
            result.addIfNeeded(line, column, EditorColorScheme.javakeywordoprator);
            break;

          case LuaLexer.SEMI:
          case LuaLexer.COMMA:
          case LuaLexer.DOT:
          case LuaLexer.COL:
          case LuaLexer.CC:
          case LuaLexer.OP:
          case LuaLexer.CP:
          case LuaLexer.OCU:
          case LuaLexer.CCU:
          case LuaLexer.OB:
          case LuaLexer.CB:
          case LuaLexer.EQ:
            result.addIfNeeded(line, column, EditorColorScheme.javaoprator);
            break;

          case LuaLexer.NORMALSTRING:
          case LuaLexer.CHARSTRING:
          case LuaLexer.LONGSTRING:
            result.addIfNeeded(line, column, EditorColorScheme.javastring);
            break;

          case LuaLexer.INT:
          case LuaLexer.HEX:
          case LuaLexer.FLOAT:
          case LuaLexer.HEX_FLOAT:
            result.addIfNeeded(line, column, EditorColorScheme.javatype);
            break;

          case LuaLexer.NAME:
            {
              int colorNormal = EditorColorScheme.TEXT_NORMAL;
              boolean isClassName = false, isbold = false, isShadow = false;
              info.addIdentifier(token.getText());

              if (pretoken == LuaLexer.FUNCTION
                  || pretoken == LuaLexer.LOCAL
                  || pretoken == LuaLexer.END) {
                colorNormal = EditorColorScheme.javafield;
                isShadow = true;
                isbold = true;
                isClassName = true;
              } else if (pretoken == LuaLexer.COMMA
                  || pretoken == LuaLexer.OP
                  || pretoken == LuaLexer.EQ) {
                colorNormal = EditorColorScheme.jsattr;
                isbold = true;

                if (lexer._input.LA(1) == '(') {
                  colorNormal = EditorColorScheme.javakeyword;
                }
              } else if (lexer._input.LA(1) == '.') {
                colorNormal = EditorColorScheme.javaparament;
              } else if (lexer._input.LA(1) == '[' || lexer._input.LA(1) == ']') {
                colorNormal = EditorColorScheme.jsoprator;
              } else if (pretoken == LuaLexer.DOT) {
                colorNormal = EditorColorScheme.tsattr;
              } else if (!isClassName && Character.isUpperCase(token.getText().charAt(0))) {
                Pattern pattern = Pattern.compile("^[A-Z][A-Z0-9_]*$");
                var matcher = pattern.matcher(token.getText());
                if (matcher.matches()) {

                  colorNormal = EditorColorScheme.tscolormatch1;
                }
              }

              if (isBuiltInFunction(token.getText())) {
                colorNormal = EditorColorScheme.tscolormatch2;
                isbold = true;
              } else if (isBuiltInLibrary(token.getText())) {
                colorNormal = EditorColorScheme.tscolormatch3;
                isbold = true;
              }
              result.addIfNeeded(
                  line, column, TextStyle.makeStyle(colorNormal, 0, isbold, isClassName,false));
              break;
            }

          case LuaLexer.COMMENT:
            result.addIfNeeded(line, column, EditorColorScheme.COMMENT);

            break;

          case LuaLexer.SHEBANG:
            result.addIfNeeded(line, column, EditorColorScheme.jsoprator);
            break;

          default:
            result.addIfNeeded(line, column, EditorColorScheme.TEXT_NORMAL);
            break;
        }
        if (type != LuaLexer.WS && type != LuaLexer.NL) {
          pretoken = type;
        }
      }
      result.determine(lastLine);
      info.finish();
      result.setExtra(info);
    } catch (Exception err) {

    }
  }

  private boolean isBuiltInFunction(String name) {
    String[] builtInFunctions = {
      "print",
      "type",
      "tostring",
      "tonumber",
      "getmetatable",
      "setmetatable",
      "rawget",
      "rawset",
      "rawequal",
      "pairs",
      "ipairs",
      "next",
      "assert",
      "error",
      "pcall",
      "xpcall",
      "select",
      "load",
      "loadstring",
      "loadfile",
      "dofile",
      "require",
      "module",
      "collectgarbage",
      "getfenv",
      "setfenv"
    };

    for (String func : builtInFunctions) {
      if (func.equals(name)) {
        return true;
      }
    }
    return false;
  }

  private boolean isBuiltInLibrary(String name) {
    String[] builtInLibraries = {
      "string", "table", "math", "io", "os", "debug", "coroutine", "package"
    };

    for (String lib : builtInLibraries) {
      if (lib.equals(name)) {
        return true;
      }
    }
    return false;
  }
}
