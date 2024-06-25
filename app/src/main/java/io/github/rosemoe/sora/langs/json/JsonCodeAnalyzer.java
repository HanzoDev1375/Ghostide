package io.github.rosemoe.sora.langs.json;

import android.graphics.Color;
import android.util.Log;
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
          int[] end = Utils.setErrorSpan(result, line, column);

          identifiers.addIdentifier(
              text.substring(
                  tokenizer.getIndex(), tokenizer.getTokenLength() + tokenizer.getIndex()));
          // The previous so this will be the annotation's type name
          if (previous == Tokens.AT) {
            result.addIfNeeded(line, column, EditorColorScheme.print);
            break;
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
          if (stack.isEmpty()) {
            if (currSwitch > maxSwitch) {
              maxSwitch = currSwitch;
            }
            currSwitch = 0;
          }
          currSwitch++;
          BlockLine blocks = result.obtainNewBlock();
          blocks.startLine = line;
          blocks.startColumn = column;
          stack.push(blocks);
          break;

        case LBRACE:
          {
            classNamePrevious = false;
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.BLOCK_LINE, 0, true, false, false));
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
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.BLOCK_LINE, 0, true, false, false));
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
        case CHARACTER_LITERAL:
          break;
        case LINE_COMMENT:
          result.addIfNeeded(line, column, EditorColorScheme.COMMENT);
          break;
        case LONG_COMMENT:
          result.addIfNeeded(line, column, EditorColorScheme.COMMENT);
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
    j.analyze(content,result,delegate);
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
