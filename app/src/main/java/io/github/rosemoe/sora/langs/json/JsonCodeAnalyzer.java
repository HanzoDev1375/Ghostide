package io.github.rosemoe.sora.langs.json;

import io.github.rosemoe.sora.widget.TextSummry.HTMLConstants;
import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import ir.ninjacoder.ghostide.marco.RegexUtilCompat;
import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.EditorColorScheme;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import io.github.rosemoe.sora.data.BlockLine;
import io.github.rosemoe.sora.data.NavigationItem;
import io.github.rosemoe.sora.data.Span;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.langs.IdentifierAutoComplete;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;

import org.antlr.v4.runtime.CodePointCharStream;
import java.io.StringReader;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

/**
 * Note:Navigation not supported
 *
 * @author Ghost
 */
public class JsonCodeAnalyzer implements CodeAnalyzer {

  private static final Object OBJECT = new Object();

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    try {
      CodePointCharStream stream = CharStreams.fromReader(new StringReader(content.toString()));
      JSON jsons = new JSON(stream);
      Token token;
      int line, column;
      IdentifierAutoComplete.Identifiers identifiers = new IdentifierAutoComplete.Identifiers();
      identifiers.begin();
      Stack<BlockLine> stack = new Stack<>();
      int maxSwitch = 1, currSwitch = 0, previous = -1, type = -1;
      boolean classNamePrevious = false;
      boolean first = true;
      int lastLine = 1;
      while (delegate.shouldAnalyze()) {

        token = jsons.nextToken();
        if (token == null) break;
        if (token.getType() == JSON.EOF) {
          lastLine = token.getLine() - 1;
          break;
        }
        line = token.getLine() - 1;
        type = token.getType();
        column = token.getCharPositionInLine();
        if (type == JSON.EOF) {
          lastLine = line;
          break;
        }

        switch (token.getType()) {
          case JSON.WS:
            if (first) {
              result.addNormalIfNull();
            }
            break;

          case JSON.TEXT:
            identifiers.addIdentifier(token.getText());
            if (RegexUtilCompat.RegexSelect("\".*?\"", token.getText())) {
              result.addIfNeeded(
                  line, column + token.getText().length() - 1, EditorColorScheme.KEYWORD);
            }
            if (RegexUtilCompat.RegexSelect("\\(n|t|r|s)(\\$.*)", token.getText())) {
              result.addIfNeeded(
                  line, column + token.getText().length() - 1, EditorColorScheme.IDENTIFIER_NAME);
            }
            if (RegexUtilCompat.RegexSelect(
                "(\\#[a-zA-F0-9]{8})|(\\#[a-zA-F0-9]{6})|(\\#[a-zA-F0-9]{3})", token.getText())) {
              var colors = result;
              String colorString = token.getText();
              var text1 = colorString;
              if (colorString.length() == 4) { // اگر رنگ سه رقمی باشد
                String red = colorString.substring(1, 2);
                String green = colorString.substring(2, 3);
                String blue = colorString.substring(3, 4);
                colorString = "#" + red + red + green + green + blue + blue; // تبدیل به شش رقمی
              }

              try {
                int color = Color.parseColor(colorString);
                colors.addIfNeeded(line, column, EditorColorScheme.LITERAL);
                if (ColorUtils.calculateLuminance(color) > 0.5) {
                  Span span =
                      Span.obtain(
                          column,
                          TextStyle.makeStyle(
                              EditorColorScheme.black, 0, false, false, false, false, true));
                  if (span != null) {
                    span.setBackgroundColorMy(color);
                    colors.add(line, span);
                  }
                } else {
                  Span span =
                      Span.obtain(
                          column,
                          TextStyle.makeStyle(
                              EditorColorScheme.TEXT_NORMAL, 0, false, false, false, false, true));
                  if (span != null) {
                    span.setBackgroundColorMy(color);
                    colors.add(line, span);
                  }
                }

                Span middle = Span.obtain(column + text1.length(), EditorColorScheme.LITERAL);
                middle.setBackgroundColorMy(Color.TRANSPARENT);
                colors.add(line, middle);

                Span end =
                    Span.obtain(
                        column + text1.length(),
                        TextStyle.makeStyle(EditorColorScheme.TEXT_NORMAL));
                end.setBackgroundColorMy(Color.TRANSPARENT);
                colors.add(line, end);
                break;
              } catch (Exception ignore) {
                ignore.printStackTrace();
              }
            }

            result.addIfNeeded(line, column, EditorColorScheme.TEXT_NORMAL);
            break;
          case JSON.COLON:
            classNamePrevious = false;
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(
                    EditorColorScheme.AUTO_COMP_PANEL_CORNER, 0, true, false, false));
            break;

          case JSON.LBRACE:
            {
              classNamePrevious = false;
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
              var colorid = EditorColorScheme.htmlblocknormal;

              if (GhostIdeAppLoader.getPrefManager().getBoolean("breaks", false) == true)
                colorid = HTMLConstants.get(stack.size());
              else colorid = EditorColorScheme.htmlblocknormal;
              result.addIfNeeded(line, column, TextStyle.makeStyle(colorid, 0, true, false, false));
              stack.push(block);
              break;
            }
          case JSON.RBRACE:
            {
              classNamePrevious = false;

              if (!stack.isEmpty()) {
                BlockLine block = stack.pop();
                block.endLine = line;
                block.endColumn = column;
                if (block.startLine != block.endLine) {
                  result.addBlockLine(block);
                }
              }
              var colorres = EditorColorScheme.htmlblocknormal;
              if (GhostIdeAppLoader.getPrefManager().getBoolean("breaks", false) == true)
                colorres = HTMLConstants.get(stack.size());
              else colorres = EditorColorScheme.htmlblocknormal;
              result.addIfNeeded(
                  line, column, TextStyle.makeStyle(colorres, 0, true, false, false));
              break;
            }
          case JSON.TRUE:
          case JSON.FALSE:
          case JSON.NULL:
            result.addIfNeeded(line, column, EditorColorScheme.KEYWORD);
            break;

          default:
            classNamePrevious = false;
            result.addIfNeeded(line, column, EditorColorScheme.OPERATOR);
        }
        first = false;
      }
      if (stack.isEmpty()) {
        if (currSwitch > maxSwitch) {
          maxSwitch = currSwitch;
        }
      }
      if (type != JSON.WS) {
        previous = type;
      }
      identifiers.finish();
      result.determine(lastLine);
      result.setExtra(identifiers);
      result.setSuppressSwitch(maxSwitch + 10);
    } catch (Exception err) {

    }
  }
}
