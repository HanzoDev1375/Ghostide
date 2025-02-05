package io.github.rosemoe.sora.langs.json;

import io.github.rosemoe.sora.widget.TextSummry.HTMLConstants;
import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import ir.ninjacoder.ghostide.marco.RegexUtilCompat;
import android.graphics.Color;
import android.util.Log;
import androidx.core.graphics.ColorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
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
import io.github.rosemoe.sora.langs.internal.TrieTree;
import io.github.rosemoe.sora.text.LineNumberCalculator;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Note:Navigation not supported
 *
 * @author Rose
 */
public class JsonCodeAnalyzer implements CodeAnalyzer {

  private static final Object OBJECT = new Object();

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    StringBuilder text =
        content instanceof StringBuilder ? (StringBuilder) content : new StringBuilder(content);
    JsonTextTokenizer tokenizer = new JsonTextTokenizer(text);
    tokenizer.setCalculateLineColumn(false);
    Tokens token, previous = Tokens.UNKNOWN;
    int line = 0, column = 0;
    LineNumberCalculator helper = new LineNumberCalculator(text);
    IdentifierAutoComplete.Identifiers identifiers = new IdentifierAutoComplete.Identifiers();
    identifiers.begin();
    Stack<BlockLine> stack = new Stack<>();
    List<NavigationItem> labels = new ArrayList<>();
    int maxSwitch = 1, currSwitch = 0;
    // Tree to save class names and query
    TrieTree<Object> classNames = new TrieTree<>();
    // Whether previous token is class name
    boolean classNamePrevious = false;
    // Add default class name
    classNames.put("String", OBJECT);
    classNames.put("Object", OBJECT);
    boolean first = true;
    while (delegate.shouldAnalyze()) {
      try {
        // directNextToken() does not skip any token
        token = tokenizer.directNextToken();
      } catch (RuntimeException e) {
        // When a spelling input is in process, this will happen because of format mismatch
        token = Tokens.CHARACTER_LITERAL;
      }
      if (token == Tokens.EOF) {
        break;
      }
      // Backup values because looking ahead in function name match will change them
      int thisIndex = tokenizer.getIndex();
      int thisLength = tokenizer.getTokenLength();
      switch (token) {
        case WHITESPACE:
        case NEWLINE:
          if (first) {
            result.addNormalIfNull();
          }
          break;
        case IDENTIFIER:
          // Add a identifier to auto complete
          identifiers.addIdentifier(
              text.substring(
                  tokenizer.getIndex(), tokenizer.getTokenLength() + tokenizer.getIndex()));
          // The previous so this will be the annotation's type name
          if (previous == Tokens.AT) {
            result.addIfNeeded(line, column, EditorColorScheme.print);
            break;
          }
          // read colpr

          if (RegexUtilCompat.RegexSelect(
              "(\\#[a-zA-F0-9]{8})|(\\#[a-zA-F0-9]{6})|(\\#[a-zA-F0-9]{3})", content.toString())) {
            var colors = result;
            String colorString = tokenizer.getSource().toString();
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
                      column + text1.length(), TextStyle.makeStyle(EditorColorScheme.TEXT_NORMAL));
              end.setBackgroundColorMy(Color.TRANSPARENT);
              colors.add(line, end);
              break;
            } catch (Exception ignore) {
              ignore.printStackTrace();
            }
          }

          // Here we have to get next token to see if it is function
          // We can only get the next token in stream.
          // If more tokens required, we have to use a stack in tokenizer
          Tokens next = tokenizer.directNextToken();
          // The next is LPAREN,so this is function name or type name
          if (next == Tokens.LPAREN) {
            result.addIfNeeded(line, column, EditorColorScheme.HTML_TAG);
            tokenizer.pushBack(tokenizer.getTokenLength());
            break;
          }
          // Push back the next token
          tokenizer.pushBack(tokenizer.getTokenLength());
          // This is a class definition
          if (previous == Tokens.CLASS) {
            result.addIfNeeded(line, column, EditorColorScheme.ATTRIBUTE_VALUE);
            // Add class name
            classNames.put(text, thisIndex, thisLength, OBJECT);
            break;
          }
          // Has class name
          if (classNames.get(text, thisIndex, thisLength) == OBJECT) {
            result.addIfNeeded(line, column, EditorColorScheme.ATTRIBUTE_VALUE);
            // Mark it
            classNamePrevious = true;
            break;
          }
          if (classNamePrevious) {
            // Var name
            result.addIfNeeded(line, column, EditorColorScheme.ATTRIBUTE_NAME);
            classNamePrevious = false;
            break;
          }

          result.addIfNeeded(line, column, EditorColorScheme.TEXT_NORMAL);
          break;

        case STRING:
          result.addIfNeeded(line, column, EditorColorScheme.LITERAL);
          if (previous == Tokens.COLON) result.addIfNeeded(line, column, EditorColorScheme.KEYWORD);
          break;
        case FLOATING_POINT_LITERAL:
        case INTEGER_LITERAL:
          classNamePrevious = false;
          result.addIfNeeded(line, column, EditorColorScheme.HTML_TAG);
          break;
        case TRUE:
          result.addIfNeeded(line, column, EditorColorScheme.print);
          break;
        case FALSE:
          result.addIfNeeded(line, column, EditorColorScheme.Ninja);
          break;
        case NULL:
          classNamePrevious = false;
          result.addIfNeeded(line, column, EditorColorScheme.KEYWORD);

          //     italic
          break;
        case COLON:
          classNamePrevious = false;
          result.addIfNeeded(
              line,
              column,
              TextStyle.makeStyle(EditorColorScheme.AUTO_COMP_PANEL_CORNER, 0, true, false, false));
          break;

        case LBRACE:
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
        case RBRACE:
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
            result.addIfNeeded(line, column, TextStyle.makeStyle(colorres, 0, true, false, false));
            break;
          }
        case CHARACTER_LITERAL:
          break;
        case LINE_COMMENT:
          result.addIfNeeded(line, column, EditorColorScheme.COMMENT);
          break;
        case LONG_COMMENT:
          result.addIfNeeded(line, column, EditorColorScheme.COMMENT);
          break;
        case CLASS_USER:
          result.addIfNeeded(line, column, EditorColorScheme.javafun);
          break;
        default:
          if (token == Tokens.LBRACK || (token == Tokens.RBRACK && previous == Tokens.LBRACK)) {
            result.addIfNeeded(line, column, EditorColorScheme.OPERATOR);
            break;
          }
          classNamePrevious = false;
          result.addIfNeeded(line, column, EditorColorScheme.OPERATOR);
      }
      first = false;
      helper.update(thisLength);
      line = helper.getLine();
      column = helper.getColumn();
      if (token != Tokens.WHITESPACE && token != Tokens.NEWLINE) {
        previous = token;
      }
    }
    BasicSyntaxJsonAnalyzer j = new BasicSyntaxJsonAnalyzer();
    j.analyze(content, result, delegate);
    if (stack.isEmpty()) {
      if (currSwitch > maxSwitch) {
        maxSwitch = currSwitch;
      }
    }
    identifiers.finish();
    result.determine(line);
    result.setExtra(identifiers);
    result.setSuppressSwitch(maxSwitch + 10);
    result.setNavigation(labels);
  }
}
