package io.github.rosemoe.sora.langs.ghostthemelang.ghostcodeanalyzer;

import android.graphics.Color;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import io.github.rosemoe.sora.data.BlockLine;
import io.github.rosemoe.sora.data.NavigationItem;
import io.github.rosemoe.sora.data.Span;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.langs.IdentifierAutoComplete;
import io.github.rosemoe.sora.langs.ghostthemelang.TokenCompat;
import io.github.rosemoe.sora.langs.ghostthemelang.ghostlang.GhostTextTokenizer;
import io.github.rosemoe.sora.langs.internal.TrieTree;
import io.github.rosemoe.sora.text.LineNumberCalculator;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.EditorColorScheme;

/**
 * Note:Navigation not supported
 *
 * @author Ninja coder
 */
public class GhostCodeAnalyzer implements CodeAnalyzer {

  private static final Object OBJECT = new Object();

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    StringBuilder text =
        content instanceof StringBuilder ? (StringBuilder) content : new StringBuilder(content);
    GhostTextTokenizer tokenizer = new GhostTextTokenizer(text);
    tokenizer.setCalculateLineColumn(false);
    TokenCompat token, previous = TokenCompat.UNKNOWN;
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
        token = TokenCompat.CHARACTER_LITERAL;
      }
      if (token == TokenCompat.EOF) {
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
          if (previous == TokenCompat.AT) {
            result.addIfNeeded(line, column, EditorColorScheme.print);
            break;
          }
          // Here we have to get next token to see if it is function
          // We can only get the next token in stream.
          // If more TokenCompat required, we have to use a stack in tokenizer
          TokenCompat next = tokenizer.directNextToken();
          // The next is LPAREN,so this is function name or type name
          if (next == TokenCompat.LPAREN) {
            result.addIfNeeded(line, column, EditorColorScheme.HTML_TAG);
            tokenizer.pushBack(tokenizer.getTokenLength());
            break;
          }
          // Push back the next token
          tokenizer.pushBack(tokenizer.getTokenLength());
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
        case FLOATING_POINT_LITERAL:
        case INTEGER_LITERAL:
          classNamePrevious = false;
          result.addIfNeeded(line, column, EditorColorScheme.HTML_TAG);
          break;

        case LBRACE:
          {
            classNamePrevious = false;
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
          }
        case RBRACE:
          {
            classNamePrevious = false;
            result.addIfNeeded(line, column, EditorColorScheme.OPERATOR);
            if (!stack.isEmpty()) {
              BlockLine block = stack.pop();
              block.endLine = line;
              block.endColumn = column;
              if (block.startLine != block.endLine) {
                result.addBlockLine(block);
              }
            }
            break;
          }
        case LINE_COMMENT:
          result.addIfNeeded(line, column, EditorColorScheme.COMMENT);
          break;
        case LONG_COMMENT:
          result.addIfNeeded(line, column, EditorColorScheme.COMMENT);
          break;
        case CHARACTER_LITERAL:
          String text3 = text.toString();
          if (text3.startsWith("\"#")) {
            try {
              int color = Color.parseColor(text3.substring(1, text3.length() - 1));
              result.addIfNeeded(
                  line,
                  column,
                  TextStyle.makeStyle(EditorColorScheme.LITERAL, 0, true, true, false));

              Span span =
                  Span.obtain(
                      column + 1,
                      TextStyle.makeStyle(
                          EditorColorScheme.TEXT_NORMAL, color, true, false, false));
              // span.setUnderlineColor(color);
              result.add(line, span);

              Span middle = Span.obtain(column + text3.length() - 1, EditorColorScheme.LITERAL);
              middle.setUnderlineColor(Color.TRANSPARENT);
              result.add(line, middle);

              Span end =
                  Span.obtain(
                      column + text3.length(), TextStyle.makeStyle(EditorColorScheme.TEXT_NORMAL));
              end.setUnderlineColor(Color.TRANSPARENT);
              result.add(line, end);
              break;
            } catch (Exception sumError) {
              Log.i("ColorError", sumError.getMessage());
            }
          }
          result.addIfNeeded(line, column, EditorColorScheme.OPERATOR);
          break;
        case TRUE:
        case FALSE:
          result.addIfNeeded(
              line, column, TextStyle.makeStyle(EditorColorScheme.HTML_TAG, 0, true, true, false));
          break;

        default:
          if (token == TokenCompat.LBRACK
              || (token == TokenCompat.RBRACK && previous == TokenCompat.LBRACK)) {
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
      if (token != TokenCompat.WHITESPACE && token != TokenCompat.NEWLINE) {
        previous = token;
      }
    }
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
