package io.github.rosemoe.sora.langs.cpp;

import io.github.rosemoe.sora.data.BlockLine;
import io.github.rosemoe.sora.data.NavigationItem;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.langs.IdentifierAutoComplete;
import io.github.rosemoe.sora.langs.internal.TrieTree;
import io.github.rosemoe.sora.text.LineNumberCalculator;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.EditorColorScheme;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Note:Navigation not supported
 *
 * @author Rose
 */
public class CppCodeAnalyzer implements CodeAnalyzer {

  private static final Object OBJECT = new Object();
  private static String Tag = "ColorError";
  private String currentWord = "";

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    StringBuilder text =
        content instanceof StringBuilder ? (StringBuilder) content : new StringBuilder(content);
    CppTextTokenizer tokenizer = new CppTextTokenizer(text);
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
          if (previous == Tokens.NAMESPACE) {
            result.addIfNeeded(line, column, EditorColorScheme.BLOCK_LINE);
            break;
          }
          if (previous == Tokens.PUBLIC || previous == Tokens.PRIVATE) {
            result.addIfNeeded(line, column, EditorColorScheme.ATTRIBUTE_VALUE);
            break;
          }
        
          if (next == Tokens.SEMICOLON) {
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.ATTRIBUTE_VALUE, 0, true, false, false));
            break;
          }
          switch (next) {
            case PROTECTED:
              result.addIfNeeded(line, column, EditorColorScheme.BLOCK_LINE);
              break;
            case PUBLIC:
              result.addIfNeeded(line, column, EditorColorScheme.BLOCK_LINE);
              break;
            case PRIVATE:
              result.addIfNeeded(line, column, EditorColorScheme.BLOCK_LINE);
              break;
            default:
              result.addIfNeeded(line, column, EditorColorScheme.ATTRIBUTE_VALUE);
          }

          // Push back the next token
          tokenizer.pushBack(tokenizer.getTokenLength());
          // This is a class definition
          if (previous == Tokens.SIGNED) {
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
          if (next == Tokens.LT || next == Tokens.GT) {
            result.addIfNeeded(line, column, EditorColorScheme.LITERAL);
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
        case TEST:
          {
            result.addIfNeeded(line, column, EditorColorScheme.LITERAL);
            break;
          }

        case LPAREN:
        case RPAREN:
          result.addIfNeeded(line, column, EditorColorScheme.HTML_TAG);
          break;
        case CHARACTER_LITERAL:
        case FRIEND:
        case FLOATING_POINT_LITERAL:
        case INTEGER_LITERAL:
        case LT:
        case GT:
        case SEMICOLON:
          result.addIfNeeded(line, column, EditorColorScheme.HTML_TAG);
          break;
        case INT:
        case LONG:
        case EXTERN:
          result.addIfNeeded(
              line,
              column,
              TextStyle.makeStyle(EditorColorScheme.IDENTIFIER_NAME, 0, true, false, false));
          break;
        case SIZEOF:
        case BOOL:
        case CHAR:
        case AUTO:
          result.addIfNeeded(line, column, EditorColorScheme.LITERAL);
          break;
        case EXPLICIT:
        case QUESTION:
        case COMP:
        case NOT:
        case DIV:
        case COMMA:
        case FLOAT:
        case DOUBLE:
        case SHORT:
        case VOID:
          classNamePrevious = true;
          result.addIfNeeded(
              line, column, TextStyle.makeStyle(EditorColorScheme.Ninja, 0, true, false, false));
          break;
        case STRUCT:
        case TEMPLATE:
        case THROW:
          result.addIfNeeded(line, column, EditorColorScheme.Pro);
        case DO:
        case INLINE_THEN_CONSTEXPR:
        case TYPEDEF:
        case FOR:
        case IF:
        case NEW:
          result.addIfNeeded(line, column, EditorColorScheme.KEYWORD);
          break;
        case PUBLIC:
        case PRIVATE:
        case PROTECTED:
          result.addIfNeeded(line, column, EditorColorScheme.ATTRIBUTE_VALUE);
        case RETURN:
        case STATIC:
        case SWITCH:
          result.addIfNeeded(line, column, EditorColorScheme.Ninja);
          break;
        case ELSE:
          result.addIfNeeded(line, column, EditorColorScheme.HTML_TAG);
          break;
        case VOLATILE:
        case UNION:
        case UNSIGNED:
        case GOTO:
          result.addIfNeeded(line, column, EditorColorScheme.AUTO_COMP_PANEL_CORNER);
          break;
        case CONTINUE:
        case BREAK:
          result.addIfNeeded(line, column, EditorColorScheme.OPERATOR);
          break;
        case USING:
        case TRY:
          result.addIfNeeded(
              line,
              column,
              TextStyle.makeStyle(EditorColorScheme.ATTRIBUTE_NAME, 0, true, false, false));
          break;
        case VIRTUAL:
        case WHILE:
        case CASE:
        case DEFAULT:
          result.addIfNeeded(line, column, EditorColorScheme.BLOCK_LINE_CURRENT);
          break;
        case CONST:
        case ENUM:
          result.addIfNeeded(
              line,
              column,
              TextStyle.makeStyle(EditorColorScheme.NON_PRINTABLE_CHAR, 0, false, false, true));
          break;
        case NULLPTR:
          result.addIfNeeded(line, column, EditorColorScheme.OPERATOR);
          break;
        case THIS:
        case INCLUDE:
        case HASHCODE:
        case COUT:
          result.addIfNeeded(line, column, EditorColorScheme.HTML_TAG);
          break;
        case TRUE:
          result.addIfNeeded(
              line, column, TextStyle.makeStyle(EditorColorScheme.print, 0, false, true, true));
          break;
        case FALSE:
          result.addIfNeeded(
              line, column, TextStyle.makeStyle(EditorColorScheme.Ninja, 0, false, true, true));
          break;

        case LBRACE:
          {
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
          result.addIfNeeded(
              line, column, TextStyle.makeStyle(EditorColorScheme.COMMENT, 0, false, true, false));
          break;
        case LONG_COMMENT:
          result.addIfNeeded(line, column, EditorColorScheme.COMMENT);
          break;
        case DEBUG:
          result.addIfNeeded(line, column, EditorColorScheme.COLOR_DEBUG);
          break;
        case ERROR:
          result.addIfNeeded(line, column, EditorColorScheme.COLOR_ERROR);
          break;
        case TIP:
          result.addIfNeeded(line, column, EditorColorScheme.COLOR_TIP);
          break;
        case WARNING:
          result.addIfNeeded(line, column, EditorColorScheme.COLOR_WARNING);
          break;
        case LOG:
          result.addIfNeeded(line, column, EditorColorScheme.COLOR_LOG);
          break;
        default:
          if (token == Tokens.LBRACK || (token == Tokens.RBRACK && previous == Tokens.LBRACK)) {
            result.addIfNeeded(line, column, EditorColorScheme.OPERATOR);
            break;
          }

          classNamePrevious = false;
      }

      first = false;
      helper.update(thisLength);
      line = helper.getLine();
      column = helper.getColumn();
      if (token != Tokens.WHITESPACE && token != Tokens.NEWLINE) {
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
