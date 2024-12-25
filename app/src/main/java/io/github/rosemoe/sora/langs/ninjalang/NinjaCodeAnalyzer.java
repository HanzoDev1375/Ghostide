package io.github.rosemoe.sora.langs.ninjalang;

import android.graphics.Color;
import io.github.rosemoe.sora.langs.ninjalang.server.NinjaTextTokenizer;
import io.github.rosemoe.sora.text.TextStyle;
import android.util.Log;

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
import io.github.rosemoe.sora.widget.EditorColorScheme;
import org.antlr.parser.antlr4.ninja.NinjaTest;

/**
 * @author NinjaCoder
 */
public class NinjaCodeAnalyzer implements CodeAnalyzer {

  private static final Object OBJECT = new Object();

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    StringBuilder text =
        content instanceof StringBuilder ? (StringBuilder) content : new StringBuilder(content);
    var tokenizer = new NinjaTextTokenizer(text);
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
          if (next == Tokens.INT32 || next == Tokens.INT64) {
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(
                    EditorColorScheme.AUTO_COMP_PANEL_CORNER, 0, true, true, false));
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
        case FLOATING_POINT_LITERAL:
        case INTEGER_LITERAL:
          classNamePrevious = false;
          result.addIfNeeded(line, column, EditorColorScheme.HTML_TAG);
          break;
        case ABSOLUTE:
        case ABSTRACT:
        case ALL:
        case AND:
        case AND_THEN:
        case ARRAY:
        case AS:
        case ASM:
        case ATTRIBUTE:
        case BEGIN:
        case BINDABLE:
        case CASE:
        case CLASS:
        case CONST:
        case VAR:
          result.addIfNeeded(line, column, EditorColorScheme.IDENTIFIER_NAME);
          break;
        case OUT:
        case CONSTRUCTOR:
        case DESTRUCTOR:
        case DIV:
        case DO:

        case ELSE:
        case END:
        case VOID:
          classNamePrevious = true;
          result.addIfNeeded(line, column, EditorColorScheme.Ninja);
          break;

        case SYSTEM:
        case FOR:
        case IF:
          result.addIfNeeded(line, column, EditorColorScheme.KEYWORD);
          break;
        case PUBLIC:
        case PRIVATE:
        case PROTECTED:
          result.addIfNeeded(line, column, EditorColorScheme.Ninja);
          break;
        case EXCEPT:
        case EXPORT:
        case EXPORTS:
        case EXTERNAL:
        case FAR:
        case FILE:
        case FINALIZATION:
        case FINALLY:
          result.addIfNeeded(line, column, EditorColorScheme.HTML_TAG);
          break;

        case FORWARD:
        case GOTO:

        case IMPLEMENTATION:
        case IMPORT:
        case IN:
        case INHERITED:
        case INITIALIZATION:
        case INTERFACE:
        case INTERRUPT:
        case IS:
        case LABEL:
        case LIBRARY:
        case MOD:
          result.addIfNeeded(line, column, EditorColorScheme.OPERATOR);
          break;
        case MODULE:
        case NAME:
        case NEAR:
        case NIL:
        case NOT:
        case OBJECT:
        case OF:
        case ONLY:
        case OPERATOR:
        case OR:
        case OR_ELSE:
        case OTHERWISE:
          result.addIfNeeded(line, column, EditorColorScheme.OPERATOR);
          break;
        case PACKED:
        case POW:
        case PROGRAM:
        case PROPERTY:
        case PUBLISHED:
        case QUALIFIED:
        case RECORD:
        case REPEAT:
        case RESIDENT:
        case RESTRICTED:
        case SEGMENT:
        case SET:
        case SHL:
        case SHR:
        case THEN:
        case TO:
        case TRY:
        case TYPE:
        case UNIT:
        case UNTIL:
        case USES:
          result.addIfNeeded(line, column, EditorColorScheme.print);
          break;
        case VALUE:
        case VIEW:
        case VIRTUAL:
        case WHILE:
        case WITH:
        case XOR:
        case MSG:
        case PRAPERTY:
        case EXEC:
        case BASEEXCEPTION:
        case FROM:
        case PRINTOR:
        case CIN:
        case COUT:
        case LAMBDA:
          result.addIfNeeded(line, column, EditorColorScheme.Ninja);
          break;
        case QAR:
        case VEL:
        case VAL:
        case SYNCHRONIZED:
        case INT32:
        case INT64:
        case EXTENDS:
        case SEALED:
        case TYPEVIEW:

        case PERMITS:
          classNamePrevious = false;
          result.addIfNeeded(line, column, EditorColorScheme.KEYWORD);

          //     italic
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
        default:
          if (token == Tokens.LBRACK || (token == Tokens.RBRACK && previous == Tokens.LBRACK)) {
            result.addIfNeeded(line, column, EditorColorScheme.OPERATOR);
            break;
          }
          int colorId = EditorColorScheme.OPERATOR;
          if (previous == Tokens.BRAKRTCOMPAT) {
            colorId = EditorColorScheme.LITERAL;
          } else if (previous == Tokens.ENDBRAKRTCOMPAT) {
            colorId = EditorColorScheme.BLOCK_LINE;
          } else {
            colorId = EditorColorScheme.TEXT_NORMAL;
          }
           
          if(text.toString().matches("\\w+(.*?)[a-z]\\:")) {
          	result.addIfNeeded(line, column, EditorColorScheme.OPERATOR);
            break;
          }
          classNamePrevious = false;
          result.addIfNeeded(line, column, TextStyle.makeStyle(colorId));
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
    NinjaTest.main(result,content.toString());
    result.determine(line);
    result.setExtra(identifiers);
    result.setSuppressSwitch(maxSwitch + 10);
    result.setNavigation(labels);
  }
}
