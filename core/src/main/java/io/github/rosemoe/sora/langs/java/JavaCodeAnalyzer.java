package io.github.rosemoe.sora.langs.java;

import android.graphics.Color;
import android.util.Log;
import androidx.core.graphics.ColorUtils;
import io.github.rosemoe.sora.diagnostics.Diagnostic;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.commentRule.BetterCommentHelper;
import ir.ninjacoder.ghostide.core.GhostIdeAppLoader;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.Token;
import java.io.IOException;
import java.io.StringReader;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Pattern;
import io.github.rosemoe.sora.data.BlockLine;
import io.github.rosemoe.sora.data.RainbowBracketHelper;
import io.github.rosemoe.sora.data.Span;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.langs.internal.Identifiers;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import io.github.rosemoe.sora.widget.ListCss3Color;
import ir.ninjacoder.ghostide.core.IdeEditor;
import ninjacoder.ghostide.androidtools.r8.android.CodeLine;
import ninjacoder.ghostide.androidtools.r8.android.JavaAnalyzer;

public class JavaCodeAnalyzer implements CodeAnalyzer {
  private final WeakReference<IdeEditor> mEditorReference;
  private Map<String, Boolean> mapStyle;
  private RainbowBracketHelper ha;
  private BasicSyntaxJavaAnalyzer codeax;
  private BetterCommentHelper betterCommentHelper;

  public JavaCodeAnalyzer(IdeEditor editor) {
    mEditorReference = new WeakReference<>(editor);
    betterCommentHelper = new BetterCommentHelper();
    configureBetterComments();
  }

  private void configureBetterComments() {
    betterCommentHelper.addRule(
        new BetterCommentHelper.BetterCommentRule.Builder("@\\w+")
            .color(EditorColorScheme.ANNOTATION)
            .asRegex(true)
            .bold(true)
            .italic(false)
            .priority(12)
            .build());
    
    betterCommentHelper.addRule(
        new BetterCommentHelper.BetterCommentRule.Builder("\\{@\\w+[^}]*\\}")
            .color(EditorColorScheme.KEYWORD)
            .asRegex(true)
            .italic(true)
            .priority(13)
            .build());
    
    betterCommentHelper.addRule(
        new BetterCommentHelper.BetterCommentRule.Builder("<\\w+>.*?</\\w+>")
            .color(EditorColorScheme.LITERAL)
            .asRegex(true)
            .priority(11)
            .build());
    
    betterCommentHelper.addRule(
        new BetterCommentHelper.BetterCommentRule.Builder("`.*?`")
            .color(EditorColorScheme.LITERAL)
            .asRegex(true)
            .bold(false)
            .italic(true)
            .priority(10)
            .build());
    
    betterCommentHelper.addRule(
        new BetterCommentHelper.BetterCommentRule.Builder("\\b(v\\d+\\.\\d+\\.\\d+)\\b")
            .color(EditorColorScheme.KEYWORD)
            .asRegex(true)
            .bold(true)
            .priority(9)
            .build());
    
    
    betterCommentHelper.addRegexRule("\\b[A-Z][a-z]+Exception\\b", EditorColorScheme.COLOR_ERROR, 8);
    betterCommentHelper.addRegexRule("\\b[A-Z][a-z]+Error\\b", EditorColorScheme.COLOR_ERROR, 8);
    betterCommentHelper.addRegexRule("@[a-zA-Z0-9_]+", EditorColorScheme.ATTRIBUTE_NAME, 7);
    betterCommentHelper.addRegexRule("#[a-zA-Z0-9_]+", EditorColorScheme.HTML_TAG, 6);
  }

  @Override
  public void analyzeInBackground(CharSequence content) {
    IdeEditor editor = mEditorReference.get();
    if (editor == null) return;
  }

  @Override
  public void analyze(CharSequence content, TextAnalyzeResult result, TextAnalyzer.AnalyzeThread.Delegate delegate) {
    try {
      ha = new RainbowBracketHelper(content);
      IdeEditor editor = mEditorReference.get();
      if (editor == null) return;
      
      codeax = new BasicSyntaxJavaAnalyzer(editor);
      CodePointCharStream stream = CharStreams.fromReader(new StringReader(content.toString()));
      JavaLexer lexer = new JavaLexer(stream);

      var classNamePrevious = false;
      Token token, preprevious = null;
      boolean first = true;
      JavaAutoComplete auto = new JavaAutoComplete(editor);
      auto.setMd(true);
      auto.setKeywords(JavaLanguage.keywords);
      Identifiers info = new Identifiers();
      info.begin();
      Stack<BlockLine> stack = new Stack<>();
      int type, currSwitch = 1, maxSwitch = 0;
      int previous = 0;
      int lastLine = 1;
      int line, column;
      
      while (delegate.shouldAnalyze()) {
        token = lexer.nextToken();
        if (token == null) break;
        if (token.getType() == JavaLexer.EOF) {
          lastLine = token.getLine() - 1;
          break;
        }
        line = token.getLine() - 1;
        type = token.getType();
        String text1 = token.getText();
        column = token.getCharPositionInLine();
        
        if (type == JavaLexer.EOF) {
          lastLine = line;
          break;
        }

        switch (type) {
          case JavaLexer.WS:
            if (first) result.addNormalIfNull();
            break;
            
          case JavaLexer.ABSTRACT:
          case JavaLexer.ASSERT:
          case JavaLexer.BREAK:
          case JavaLexer.CASE:
          case JavaLexer.CATCH:
          case JavaLexer.CLASS:
          case JavaLexer.CONST:
          case JavaLexer.CONTINUE:
          case JavaLexer.DEFAULT:
          case JavaLexer.DO:
          case JavaLexer.ELSE:
          case JavaLexer.EXTENDS:
          case JavaLexer.FINAL:
          case JavaLexer.FINALLY:
          case JavaLexer.FOR:
          case JavaLexer.IF:
          case JavaLexer.GOTO:
          case JavaLexer.IMPLEMENTS:
          case JavaLexer.IMPORT:
          case JavaLexer.INSTANCEOF:
          case JavaLexer.INTERFACE:
          case JavaLexer.NATIVE:
          case JavaLexer.NEW:
          case JavaLexer.PACKAGE:
          case JavaLexer.PRIVATE:
          case JavaLexer.PROTECTED:
          case JavaLexer.PUBLIC:
          case JavaLexer.RETURN:
          case JavaLexer.STATIC:
          case JavaLexer.STRICTFP:
          case JavaLexer.SUPER:
          case JavaLexer.SWITCH:
          case JavaLexer.SYNCHRONIZED:
          case JavaLexer.THIS:
          case JavaLexer.THROW:
          case JavaLexer.THROWS:
          case JavaLexer.TRANSIENT:
          case JavaLexer.TRY:
          case JavaLexer.VOID:
          case JavaLexer.VOLATILE:
          case JavaLexer.WHILE:
          case JavaLexer.VAR:
            result.addIfNeeded(line, column, EditorColorScheme.javakeyword);
            classNamePrevious = true;
            break;
            
          case JavaLexer.DECIMAL_LITERAL:
          case JavaLexer.OCT_LITERAL:
          case JavaLexer.BINARY_LITERAL:
          case JavaLexer.FLOAT_LITERAL:
          case JavaLexer.HEX_FLOAT_LITERAL:
          case JavaLexer.BOOL_LITERAL:
          case JavaLexer.CHAR_LITERAL:
          case JavaLexer.NULL_LITERAL:
            result.addIfNeeded(line, column, EditorColorScheme.LITERAL);
            break;
            
          case JavaLexer.STRING_LITERAL:
            {
              if (text1.startsWith("\"#")) {
                var colors = result;
                try {
                  int color = Color.parseColor(text1.substring(1, text1.length() - 1));
                  colors.addIfNeeded(line, column, EditorColorScheme.javastring);
                  if (ColorUtils.calculateLuminance(color) > 0.5) {
                    Span span = Span.obtain(column + 1, TextStyle.makeStyle(EditorColorScheme.black, 0, true, false, false, false, true));
                    if (span != null) {
                      span.setBackgroundColorMy(color);
                      colors.add(line, span);
                    }
                  } else if (ColorUtils.calculateLuminance(color) <= 0.5) {
                    Span span = Span.obtain(column + 1, TextStyle.makeStyle(EditorColorScheme.white, 0, true, false, false, false, true));
                    if (span != null) {
                      span.setBackgroundColorMy(color);
                      colors.add(line, span);
                    }
                  }

                  Span middle = Span.obtain(column + text1.length() - 1, EditorColorScheme.javastring);
                  middle.setBackgroundColorMy(Color.TRANSPARENT);
                  colors.add(line, middle);

                  Span end = Span.obtain(column + text1.length(), TextStyle.makeStyle(EditorColorScheme.white));
                  end.setBackgroundColorMy(Color.TRANSPARENT);
                  colors.add(line, end);
                  break;
                } catch (Exception ignore) {}
              }
              result.addIfNeeded(line, column, EditorColorScheme.javastring);
              break;
            }

          case JavaLexer.LPAREN:
          case JavaLexer.LT:
            ha.handleOpenBracket(result, line, column, false);
            break;
            
          case JavaLexer.LBRACE:
          case JavaLexer.LBRACK:
            ha.handleOpenBracket(result, line, column, true);
            break;
            
          case JavaLexer.RPAREN:
          case JavaLexer.GT:
            ha.handleCloseBracket(result, line, column, false);
            break;
            
          case JavaLexer.RBRACK:
          case JavaLexer.RBRACE:
            ha.handleCloseBracket(result, line, column, true);
            break;
            
          case JavaLexer.SEMI:
          case JavaLexer.COMMA:
          case JavaLexer.ASSIGN:
          case JavaLexer.BANG:
          case JavaLexer.TILDE:
          case JavaLexer.QUESTION:
          case JavaLexer.COLON:
          case JavaLexer.EQUAL:
          case JavaLexer.GE:
          case JavaLexer.LE:
          case JavaLexer.NOTEQUAL:
          case JavaLexer.AND:
          case JavaLexer.OR:
          case JavaLexer.INC:
          case JavaLexer.DEC:
          case JavaLexer.ADD:
          case JavaLexer.SUB:
          case JavaLexer.MUL:
          case JavaLexer.DIV:
          case JavaLexer.BITAND:
          case JavaLexer.BITOR:
          case JavaLexer.CARET:
          case JavaLexer.MOD:
          case JavaLexer.ADD_ASSIGN:
          case JavaLexer.SUB_ASSIGN:
          case JavaLexer.MUL_ASSIGN:
          case JavaLexer.DIV_ASSIGN:
          case JavaLexer.AND_ASSIGN:
          case JavaLexer.OR_ASSIGN:
          case JavaLexer.XOR_ASSIGN:
          case JavaLexer.MOD_ASSIGN:
          case JavaLexer.LSHIFT_ASSIGN:
          case JavaLexer.RSHIFT_ASSIGN:
          case JavaLexer.URSHIFT_ASSIGN:
          case JavaLexer.ARROW:
          case JavaLexer.COLONCOLON:
          case JavaLexer.ELLIPSIS:
          case JavaLexer.DOT:
            if (previous == JavaLexer.IDENTIFIER) {
              result.addIfNeeded(line, column, EditorColorScheme.red);
            }
            ha.handleCustom(result, line, column, EditorColorScheme.javaoprator);
            break;
            
          case JavaLexer.BOOLEAN:
          case JavaLexer.BYTE:
          case JavaLexer.CHAR:
          case JavaLexer.DOUBLE:
          case JavaLexer.ENUM:
          case JavaLexer.FLOAT:
          case JavaLexer.INT:
          case JavaLexer.LONG:
          case JavaLexer.SHORT:
            result.addIfNeeded(line, column, EditorColorScheme.javakeywordoprator);
            classNamePrevious = true;
            break;
            
          case JavaLexer.BLOCK_COMMENT:
          case JavaLexer.LINE_COMMENT:
            {
              betterCommentHelper.processCommentBlock(result, line, column, token.getText());
              break;
            }
            
          case JavaLexer.AT:
            result.addIfNeeded(line, column, EditorColorScheme.javaoprator);
            break;
            
          case JavaLexer.IDENTIFIER:
            {
              info.addIdentifier(token.getText());
              int colorNormal = EditorColorScheme.TEXT_NORMAL;
              boolean isClassName = false;
              
              if (previous == JavaLexer.CLASS
                  || previous == JavaLexer.IMPORT
                  || previous == JavaLexer.INTERFACE
                  || previous == JavaLexer.ENUM
                  || previous == JavaLexer.EXTENDS
                  || previous == JavaLexer.IMPLEMENTS) {
                colorNormal = EditorColorScheme.jsfun;
                isClassName = true;
              } else if (previous == JavaLexer.VOID
                  || previous == JavaLexer.BOOLEAN
                  || previous == JavaLexer.BYTE
                  || previous == JavaLexer.CHAR
                  || previous == JavaLexer.DOUBLE
                  || previous == JavaLexer.FLOAT
                  || previous == JavaLexer.INT
                  || previous == JavaLexer.LONG
                  || previous == JavaLexer.SHORT
                  || previous == JavaLexer.IDENTIFIER) {
                colorNormal = EditorColorScheme.javaparament;
              } else if (previous == JavaLexer.THROW || previous == JavaLexer.CASE) {
                colorNormal = EditorColorScheme.javaoprator;
              } else if (lexer._input.LA(1) == '.') {
                colorNormal = EditorColorScheme.javatype;
              } else if (lexer._input.LA(1) == '[' || lexer._input.LA(1) == ']') {
                colorNormal = EditorColorScheme.tscolormatch1;
              } else if (lexer._input.LA(1) == '(') {
                colorNormal = EditorColorScheme.tscolormatch4;
              } else if (previous == JavaLexer.DOT) {
                colorNormal = EditorColorScheme.javafun;
              } else if (!isClassName && Character.isUpperCase(token.getText().charAt(0))) {
                Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z0-9_]*$");
                var matcher = pattern.matcher(token.getText());
                if (matcher.matches()) {
                  colorNormal = EditorColorScheme.javafield;
                }
              }

              result.addIfNeeded(line, column, TextStyle.makeStyleSh(colorNormal, 0, false, false, false, false, true, 0));
              break;
            }

          case JavaLexer.HEX_LITERAL:
            ListCss3Color.setColorBinery(token, line, column, result);
            break;

          default:
            result.addIfNeeded(line, column, EditorColorScheme.TEXT_NORMAL);
            break;
        }

        if (type != JavaLexer.WS) previous = type;
        first = false;
      }
      
      info.finish();

      if (GhostIdeAppLoader.getPrefManager().getBoolean("codeanalyzer", true)) {
        List<CodeLine> code123 = JavaAnalyzer.analyze(content.toString());
        code123.forEach(item -> {
          if (item.haserror) Utils.setErrorSpan(result, item.line, item.column);
          if (item.haswar) Utils.setWaringSpan(result, item.line, item.column);
        });
        codeax.analyze(content, result, delegate);
      }

      result.determine(lastLine);
      result.setExtra(info);

    } catch (IOException e) {
      Log.e("JavaCodeAnalyzer", e.getMessage());
    }
  }
  
  public BetterCommentHelper getBetterCommentHelper() {
    return betterCommentHelper;
  }
}