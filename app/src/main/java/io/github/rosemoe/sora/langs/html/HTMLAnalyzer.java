package io.github.rosemoe.sora.langs.html;

import ir.ninjacoder.ghostide.interfaces.CallBackErrorManager;
import io.github.rosemoe.sora.data.BlockLine;
import io.github.rosemoe.sora.data.NavigationItem;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.langs.IdentifierAutoComplete;
import io.github.rosemoe.sora.langs.internal.TrieTree;
import io.github.rosemoe.sora.langs.xml.analyzer.BasicSyntaxPullAnalyzer;
import io.github.rosemoe.sora.text.LineNumberCalculator;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.EditorColorScheme;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * Note:Navigation not supported
 *
 * @author Ninja coder
 */
@Deprecated
public class HTMLAnalyzer implements CodeAnalyzer, CallBackErrorManager {

  private static final Object OBJECT = new Object();
  public boolean isError = false;
  protected CodeEditor editor;
  private Pattern URL_PATTERN =
      Pattern.compile(
          "https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)");
  private BasicSyntaxPullAnalyzer sin = new BasicSyntaxPullAnalyzer();

  public HTMLAnalyzer(CodeEditor editor) {
    this.editor = editor;
  }

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    StringBuilder text =
        content instanceof StringBuilder ? (StringBuilder) content : new StringBuilder(content);
    HTMLTextTokenizer tokenizer = new HTMLTextTokenizer(text);
    tokenizer.setCalculateLineColumn(false);
    Token token, previous = Token.UNKNOWN;
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
        token = Token.CHARACTER_LITERAL;
      }
      if (token == Token.EOF) {
        break;
      }
      // Backup values because looking ahead in function name match will change them
      int thisIndex = tokenizer.getIndex();
      int thisLength = tokenizer.getTokenLength();
      int index = tokenizer.getOffset();
      switch (token) {
        case WHITESPACE:
        case NEWLINE:
          if (first) {
            isError = false;
            result.addNormalIfNull();
          }
          break;
        case IDENTIFIER:
          isError = true;

          //  /=
          // identifiers.addIdentifier(text.substring(helper.getLine(),tokenizer.getTokenLength()));

          // Add a identifier to auto complete
          identifiers.addIdentifier(text.substring(index, index + tokenizer.getTokenLength()));
          // The previous so this will be the annotation's type name

          /// coloring from #
          if (previous == Token.SHARP) {
            result.addIfNeeded(line, column, EditorColorScheme.Ninja);
            break;
          }

          /// coloring from -
          if (previous == Token.MINUS) {
            result.addIfNeeded(line, column, EditorColorScheme.KEYWORD);
            break;
          }

          Token next = tokenizer.directNextToken();
          // The next is LPAREN,so this is function name or type name

          if (next == Token.LPAREN) {
            result.addIfNeeded(line, column, EditorColorScheme.HTML_TAG);
            tokenizer.pushBack(tokenizer.getTokenLength());
            break;
          }

          if (previous == Token.IMPORT) {
            result.addIfNeeded(line, column, EditorColorScheme.ATTRIBUTE_VALUE);
            isError = false;
            break;
          }
          if (previous == Token.FORM) {
            result.addIfNeeded(line, column, EditorColorScheme.ATTRIBUTE_VALUE);
            isError = false;
            break;
          }
          if (previous == Token.AT) {
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(
                    EditorColorScheme.AUTO_COMP_PANEL_CORNER, 0, true, false, true));
            isError = false;
            classNamePrevious = false;
            break;
          }

          // Push back the next token
          tokenizer.pushBack(tokenizer.getTokenLength());
          // This is a class definition
          if (previous == Token.FUNCTION) {
            result.addIfNeeded(line, column, EditorColorScheme.ATTRIBUTE_VALUE);
            // Add class name
            classNames.put(text, thisIndex, thisLength, OBJECT);
            break;
          }
          if (previous == Token.CLASS) {
            isError = false;
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
            isError = false;
            break;
          }
          if (classNamePrevious) {
            // Var name
            result.addIfNeeded(line, column, EditorColorScheme.ATTRIBUTE_NAME);
            classNamePrevious = false;
            break;
          }
          if (previous == Token.LET && previous == Token.VAR) {
            result.addIfNeeded(line, column, EditorColorScheme.ATTRIBUTE_VALUE);
            // Mark it
            classNamePrevious = true;
            isError = false;
            break;
          }

          if (next == Token.AT) {
            result.addIfNeeded(line, column, EditorColorScheme.print);
            break;
          }

          result.addIfNeeded(line, column, EditorColorScheme.IDENTIFIER_NAME);
          break;

        case STRING:
          result.addIfNeeded(
              line, column, TextStyle.makeStyle(EditorColorScheme.HTML_TAG, 0, true, true, false));
          break;
        case FLOATING_POINT_LITERAL:
        case INTEGER_LITERAL:
          classNamePrevious = false;
          result.addIfNeeded(line, column, EditorColorScheme.COLOR_DEBUG);
          break;
        case A:
        case ABBR:
        case ACRONYM:
        case ADDRESS:
        case APPLET:
        case ARTICLE:
        case ASIDE:
        case AUDIO:
        case B:
        case BASEFONT:
        case BDI:
        case BDO:
        case BGSOUND:
        case BIG:
        case BLINK:
        case BLOCKQUOTE:
        case BODY:
        case BUTTON:
        case CANVAS:
        case CAPTION:
        case CENTER:
        case CIRCLE:
        case CITE:
        case CLIPPATH:
        case CODE:
        case COLGROUP:
        case COMMAND:
        case CONTENT:
        case DATALIST:
        case DD:
        case DEFS:
        case DEL:
        case DETAILS:
        case DFN:
        case DIALOG:
        case DIR:
        case DIV:
        case DL:
        case DT:
        case ELEMENT:
        case ELLIPSE:
        case EM:
        case FIELDSET:
        case FIGCAPTION:
        case FIGURE:
        case FONT:
        case FOOTER:
        case FOREIGNOBJECT:
        case FORM:
        case FRAME:
        case FRAMESET:
        case G:
        case H1:
        case H2:
        case H3:
        case H4:
        case H5:
        case H6:
        case HEAD:
        case HEADER:
        case HGROUP:
        case HTML:
        case I:
        case IFRAME:
        case IMAGE:
        case INS:
        case ISINDEX:
        case KBD:
        case LABEL:
        case LEGEND:
        case LI:
        case LINE:
        case LINEARGRADIENT:
        case LISTING:
        case MAIN:
        case MAP:
        case MARK:
        case MARQUEE:
        case MASK:
        case MATH:
        case MENU:
        case MENUITEM:
        case METER:
        case MULTICOL:
        case NAV:
        case NEXTID:
        case NOBR:
        case NOEMBED:
        case NOFRAMES:
        case NOSCRIPT:
        case OBJECT:
        case OL:
        case OPTGROUP:
        case OPTION:
        case OUTPUT:
        case P:
        case PATH:
        case PATTERN:
        case PICTURE:
        case PLAINTEXT:
        case POLYGON:
        case POLYLINE:
        case PRE:
        case PROGRESS:
        case Q:
        case RADIALGRADIENT:
        case RB:
        case RBC:
        case RECT:
        case RP:
        case RT:
        case RTC:
        case RUBY:
        case S:
        case SAMP:
        case SCRIPT:
        case SECTION:
        case SELECT:
        case SHADOW:
        case SLOT:
        case SMALL:
        case SPACER:
        case SPAN:
        case STOP:
        case STRIKE:
        case STRONG:
        case STYLE:
        case NOSTYLE:
        case SUB:
        case SUMMARY:
        case SUP:
        case SVG:
        case TABLE:
        case TBODY:
        case TD:
        case TEMPLATE:
        case TEXTAREA:
        case TFOOT:
        case TH:
        case THEAD:
        case TIME:
        case TITLE:
        case TR:
        case TSPAN:
        case TT:
        case U:
        case UL:
        case VAR:
        case VIDEO:
        case XMP:
        case META:
          isError = false;
          result.addIfNeeded(line, column, EditorColorScheme.KEYWORD);
          break;
        case COLON:
          isError = false;
          classNamePrevious = false;
          result.addIfNeeded(
              line,
              column,
              TextStyle.makeStyle(EditorColorScheme.AUTO_COMP_PANEL_CORNER, 0, true, false, false));

          break;
          // {
        case LBRACE:
          {
            isError = false;
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
          // }
        case RBRACE:
          {
            isError = false;

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
              break;
            } else {
              break;
            }
          }
        case CHARACTER_LITERAL:
          isError = false;
          result.addIfNeeded(line, column, EditorColorScheme.HTML_TAG);
          break;
        case LINE_COMMENT:
          isError = false;
          result.addIfNeeded(line, column, EditorColorScheme.COMMENT);
          break;
        case LONG_COMMENT:
          isError = false;
          result.addIfNeeded(line, column, EditorColorScheme.COMMENT);
          break;
          // divs = /
        case DIVS:
          result.addIfNeeded(line, column, EditorColorScheme.HTML_TAG);
          break;
          // tagslash  <
        case TAGSLASH:
        case GT:
          {
            isError = false;
            result.addIfNeeded(line, column, EditorColorScheme.HTML_TAG);
            if (stack.isEmpty()) {
              if (currSwitch > maxSwitch) {
                maxSwitch = currSwitch;
              }
              currSwitch = 0;
            }
            currSwitch++;

            break;
          }
          // LT <

        case LT:
          {
            isError = false;
            result.addIfNeeded(line, column, EditorColorScheme.HTML_TAG);
            if (!stack.isEmpty()) {
              BlockLine block = stack.pop();
              block.endLine = line - 1;
              block.endColumn = column;
              if (block.startLine != block.endLine) {
                if (helper.getLine() == helper.getColumn()) block.toBottomOfEndLine = true;
                result.addBlockLine(block);
              }
            }
            break;
          }

        case ALIGN_CONTENT:
        case ALIGN_ITEMS:
        case ALIGN_SELF:
        case ALL:
        case ANIMATION:
        case ANIMATION_DELAY:
        case ANIMATION_DIRECTION:
        case ANIMATION_DURATION:
        case ANIMATION_FILL_MODE:
        case ANIMATION_ITERATION_COUNT:
        case ANIMATION_NAME:
        case ANIMATION_PLAY_STATE:
        case ANIMATION_TIMING_FUNCTION:
        case BACKFACE_VISIBILITY:
        case BACKGROUND:
        case BACKGROUND_ATTACHMENT:
        case BACKGROUND_BLUR:
        case BACKGROUND_CLIP:
        case BACKGROUND_COLOR:
        case BACKGROUND_IMAGE:
        case BACKGROUND_ORIGIN:
        case BACKGROUND_POSITION:
        case BACKGROUND_REPEAT:
        case BACKGROUND_SIZE:
        case BORDER:
        case CLASS:
        case BORDER_BOTTOM:
        case BORDER_BOTTOM_COLOR:
        case BORDER_BOTTOM_LEFT_RADIUS:
        case BORDER_BOTTOM_RIGHT_RADIUS:
        case BORDER_BOTTOM_STYLE:
        case BORDER_BOTTOM_WIDTH:
        case BORDER_COLLAPSE:
        case BORDER_COLOR:
        case BORDER_IMAGE:
        case BORDER_IMAGE_OUTSET:
        case BORDER_IMAGE_REPEAT:
        case BORDER_IMAGE_SLICE:
        case BORDER_IMAGE_SOURCE:
        case BORDER_IMAGE_WIDTH:
        case BORDER_LEFT:
        case BORDER_LEFT_COLOR:
        case BORDER_LEFT_STYLE:
        case BORDER_LEFT_WIDTH:
        case BORDER_RADIUS:
        case BORDER_RIGHT:
        case BORDER_RIGHT_COLOR:
        case BORDER_RIGHT_STYLE:
        case BORDER_RIGHT_WIDTH:
        case BORDER_SPACING:
        case BORDER_STYLE:
        case BORDER_TOP:
        case BORDER_TOP_COLOR:
        case BORDER_TOP_LEFT_RADIUS:
        case BORDER_TOP_RIGHT_RADIUS:
        case BORDER_TOP_STYLE:
        case BORDER_TOP_WIDTH:
        case BORDER_WIDTH:
        case BOTTOM:
        case BOX_DECORATION_BREAK:
        case BOX_SHADOW:
        case BOX_SIZING:
        case BREAK_AFTER:
        case BREAK_BEFORE:
        case BREAK_INSIDE:
        case CAPTION_SIDE:
        case CARET_COLOR:
        case CLEAR:
        case CLIP:
        case COLOR:
        case COLUMN_COUNT:
        case COLUMN_FILL:
        case COLUMN_GAP:
        case COLUMN_RULE:
        case COLUMN_RULE_COLOR:
        case COLUMN_RULE_STYLE:
        case COLUMN_RULE_WIDTH:
        case COLUMN_SPAN:
        case COLUMN_WIDTH:
        case COLUMNS:
        case COUNTER_INCREMENT:
        case COUNTER_RESET:
        case CURSOR:
        case DIRECTION:
        case DISPLAY:
        case EMPTY_CELLS:
        case FILTER:
        case FLEX:
        case FLEX_BASIS:
        case FLEX_DIRECTION:
        case FLEX_FLOW:
        case FLEX_GROW:
        case FLEX_SHRINK:
        case FLEX_WRAP:
        case FLOAT:
          isError = false;
          result.addIfNeeded(
              line,
              column,
              TextStyle.makeStyle(EditorColorScheme.ATTRIBUTE_VALUE, 0, true, false, false));
          break;
        case FONT_FAMILY:
        case FONT_SIZE:
        case FONT_SIZE_ADJUST:
        case FONT_STRETCH:
        case FONT_STYLE:
        case FONT_VARIANT:
        case FONT_VARIANT_CAPS:
        case FONT_WEIGHT:
        case GAP:
        case GRID:
        case GRID_AREA:
        case GRID_AUTO_COLUMNS:
        case GRID_AUTO_FLOW:
        case GRID_AUTO_ROWS:
        case GRID_COLUMN:
        case GRID_COLUMN_END:
        case GRID_COLUMN_GAP:
        case GRID_COLUMN_START:
        case GRID_GAP:
        case GRID_ROW:
        case GRID_ROW_END:
        case GRID_ROW_GAP:
        case GRID_ROW_START:
        case GRID_TEMPLATE:
        case GRID_TEMPLATE_AREAS:
        case GRID_TEMPLATE_COLUMNS:
        case GRID_TEMPLATE_ROWS:
        case HEIGHT:
        case IME_MODE:
        case JUSTIFY_CONTENT:
        case LEFT:
        case LETTER_SPACING:
        case LINE_BREAK:
        case LINE_HEIGHT:
        case LIST_STYLE:
        case LIST_STYLE_IMAGE:
        case LIST_STYLE_POSITION:
        case LIST_STYLE_TYPE:
        case MARGIN:
        case MARGIN_BOTTOM:
        case MARGIN_LEFT:
        case MARGIN_RIGHT:
        case MARGIN_TOP:
        case MARKER_OFFSET:
        case MAX_HEIGHT:
        case MAX_WIDTH:
        case MIN_HEIGHT:
        case MIN_WIDTH:
        case MIX_BLEND_MODE:
        case OBJECT_FIT:
        case OBJECT_POSITION:
        case OPACITY:
        case ORDER:
        case ORPHANS:
        case OUTLINE:
        case OUTLINE_COLOR:
        case OUTLINE_OFFSET:
        case OUTLINE_STYLE:
        case OUTLINE_WIDTH:
        case OVERFLOW:
        case OVERFLOW_WRAP:
        case OVERFLOW_X:
        case OVERFLOW_Y:
        case PADDING:
        case PADDING_BOTTOM:
        case PADDING_LEFT:
        case PADDING_RIGHT:
        case PADDING_TOP:
        case PAGE_BREAK_AFTER:
        case PAGE_BREAK_BEFORE:
        case PAGE_BREAK_INSIDE:
        case PERSPECTIVE:
        case PERSPECTIVE_ORIGIN:
        case POINTER_EVENTS:
        case POSITION:
        case QUOTES:
        case RESIZE:
        case RIGHT:
        case ROW_GAP:
        case SCROLL_BEHAVIOR:
        case SPEAK:
        case TABLE_LAYOUT:

        case TOP:
        case TRANSFORM:
        case TRANSITION:
        case UNICODE_BIDI:
        case VERTICAL_ALIGN:
        case VISIBILITY:
        case WHITE_SPACE:
        case WIDOWS:
        case WIDTH:
        case WORD_BREAK:
        case WORD_SPACING:
        case WORD_WRAP:
        case WRITING_MODE:
        case REPEAT:
        case Z_INDEX:
          isError = false;
          result.addIfNeeded(
              line,
              column,
              TextStyle.makeStyle(EditorColorScheme.ATTRIBUTE_NAME, 0, true, false, false));
          break;
        case ABSTRACT:
        case ELSE:
        case INSTANCEOF:
        case SUPER:
        case BOOLEAN:
        case ENUM:
        case INT:
        case SWITCH:
        case BREAK:
        case EXPORT:
        case INTERFACE:
        case SYNCHRONIZED:
        case BYTE:
        case EXTENDS:
        case LET:
        case THIS:
        case CASE:
        case FALSE:
        case LONG:
        case THROW:
        case CATCH:
        case FINAL:
        case NATIVE:
        case THROWS:
        case CHAR:
        case FINALLY:
        case NEW:
        case TRANSIENT:
        case NULL:
        case TRUE:
        case CONST:
        case FOR:
        case PACKAGE:
        case TRY:
        case CONTINUE:
        case FUNCTION:
        case PRIVATE:
        case TYPEOF:
        case DEBUGGER:
        case GOTO:
        case PROTECTED:
        case IF:
        case PUBLIC:
        case VOID:
        case DELETE:
        case IMPLEMENTS:
        case RETURN:
        case VOLATILE:
        case DO:
        case IMPORT:
        case SHORT:
        case WHILE:
        case DOUBLE:
        case IN:
        case STATIC:
        case WITH:
        case OF:
        case CONSOLE:
        case LOG:
          isError = false;
          result.addIfNeeded(
              line,
              column,
              TextStyle.makeStyle(EditorColorScheme.NON_PRINTABLE_CHAR, 0, true, false, false));
          break;

        case PROTOTYPE:
        case ALERT:
        case SUPPORT:
        case YIELD:
        case ASYNC:
        case DOCUMENT:
        case ARGUMENTS:
        case PARSEINT:
        case AWAIT:
        case UNDEFINED:
        case PARSEFLOAT:
        case GET:
        case STORAGE:
        case TYPE:
        case INFINITY:
        case ESCAPE:
        case __PROTO__:
        case WINDOW:
        case EVAL:
        case GETELEMENTBYID:
          isError = false;
          result.addIfNeeded(
              line, column, TextStyle.makeStyle(EditorColorScheme.LITERAL, 0, true, false, false));
          break;
        case DOT:
        case MULT:
        case MINUS:
        case PLUS:
        case COMMA:
        case NOT:
        case QUESTION:
        case AND:
        case OR:
        case XOR:
        case MOD:
        case SEMICOLON:
          isError = false;
          result.addIfNeeded(
              line, column, TextStyle.makeStyle(EditorColorScheme.print, 0, true, true, false));
          break;
        case ACCEPT:
        case ACCESSKEY:
        case ACTION:
        case ALIGN:
        case TEXT:
        case ALT:
        case AUTOCOMPLETE:
        case AUTOFOCUS:
        case AUTOPLAY:

        case BGCOLOR:
        case CHARSET:
        case CHECKED:
        case COLS:
        case COLSPAN:
        case CONTENTEDITABLE:
        case CONTROLS:
        case COORDS:
        case DATA:
        case DATETIME:
        case DEFAULT:
        case DEFER:
        case DIRNAME:
        case DISABLED:
        case DRAGGABLE:
        case DROPZONE:
        case ENCTYPE:
        case FACE:
        case FORMACTION:
        case HEADERS:
        case HIGH:
        case HREF:
        case HREFLANG:
        case HTTP:
        case EQUIV:
        case ID:
        case ISMAP:
        case KIND:
        case LANG:
        case LIST:
        case LOOP:
        case LOW:
        case MAX:
        case MAXLENGTH:
        case MEDIA:
        case METHOD:
        case MIN:
        case MULTIPLE:
        case MUTED:
        case NAME:
        case NOVALIDATE:
        case ONABORT:
        case ONAFTERPRINT:
        case ONBEFOREPRINT:
        case ONBEFOREUNLOAD:
        case ONBLUR:
        case ONCANPLAY:
        case ONCANPLAYTHROUGH:
        case ONCHANGE:
        case ONCLICK:
        case ONCONTEXTMENU:
        case ONCOPY:
        case ONCUECHANGE:
        case ONCUT:
        case ONDBLCLICK:
        case ONDRAG:
        case ONDRAGEND:
        case ONDRAGENTER:
        case ONDRAGLEAVE:
        case ONDRAGOVER:
        case ONDRAGSTART:
        case ONDROP:
        case ONDURATIONCHANGE:
        case ONEMPTIED:
        case ONENDED:
        case ONERROR:
        case ONFOCUS:
        case ONHASHCHANGE:
        case ONINPUT:
        case ONINVALID:
        case ONKEYDOWN:
        case ONKEYPRESS:
        case ONKEYUP:
        case ONLOAD:
        case ONLOADEDDATA:
        case ONLOADEDMETADATA:
        case ONLOADSTART:
        case ONMOUSEDOWN:
        case ONMOUSEMOVE:
        case ONMOUSEOUT:
        case ONMOUSEOVER:
        case ONMOUSEUP:
        case ONMOUSEWHEEL:
        case ONOFFLINE:
        case ONONLINE:
        case ONPAGEHIDE:
        case ONPAGESHOW:
        case ONPASTE:
        case ONPLAY:
        case ONPLAYING:
        case ONPOPSTATE:
        case ONPROGRESS:
        case ONRATECHANGE:
        case ONRESET:
        case ONRESIZE:
        case ONSCROLL:
        case ONSEARCH:
        case ONSEEKED:
        case ONSEEKING:
        case ONSELECT:
        case ONSTALLED:
        case ONSTORAGE:
        case ONSUBMIT:
        case ONSUSPEND:
        case ONTIMEUPDATE:
        case ONTOGGLE:
        case ONUNLOAD:
        case ONVOLUMECHANGE:
        case ONWAITING:
        case ONWHEEL:
        case OPEN:
        case OPTIMUM:
        case PLACEHOLDER:
        case POSTER:
        case PRELOAD:
        case READONLY:
        case REL:
        case REQUIRED:
        case REVERSED:
        case ROWS:
        case ROWSPAN:
        case SANDBOX:
        case SCOPE:
        case SELECTED:
        case SHAPE:
        case SIZE:
        case SIZES:
        case SPELLCHECK:
        case SRC:
        case SRCDOC:
        case SRCLANG:
        case SRCSET:
        case START:
        case STEP:
        case TABINDEX:
        case TARGET:
        case TRANSLATE:
        case USEMAP:
        case VALUE:
        case WRAP:
          result.addIfNeeded(line, column, EditorColorScheme.OPERATOR);
          isError = false;
          break;
        case HTMLCOMMENTSTART:
        case HTMLCOMMENTEND:
        case CSSCOMMENTSTART:
        case CSSCOMMENTEND:
          isError = false;
          result.addIfNeeded(line, column, EditorColorScheme.COMMENT);
          break;
        case AREA:
        case BASE:
        case BR:
        case COL:
        case EMBED:
        case HR:
        case IMG:
        case INPUT:
        case KEYGEN:
        case LINK:
        case PARAM:
        case SOURCE:
        case TRACK:
        case WBR:
        case VIM:
        case REM:
        case VH:
        case VW:
        case PT:
        case CM:
        case MM:
        case PC:
        case EX:
        case CH:
        case DEG:
        case GRAD:
        case RAD:
        case TURN:
        case MS:
        case FR:
        case UNDERLINE:
        case ITALIC:
        case BOLD:
        case NORMAL:
        case RGBA:
        case HSL:
        case URL:
        case NONE:
        case BLOCK:
        case INLINE:
        case CELL:
        case ROW:
        case ABSOLUTE:
        case RELATIVE:
        case FIXED:
        case COLLAPSE:
        case VISIBLE:
        case UPPERCASE:
        case LOWERCASE:
        case CAPITALIZE:
        case SHRINK:
        case REVERSE:
        case NOWRAP:
        case HORIZONTAL:
        case VERTICAL:
        case NO:
          isError = false;
          result.addIfNeeded(
              line, column, TextStyle.makeStyle(EditorColorScheme.OPERATOR, 0, true, false, false));
          break;
        case RED:
          {
            result.addIfNeeded(
                line, column, TextStyle.makeStyle(EditorColorScheme.red, 0, true, false, false));
            break;
          }
        case ALICEBLUE:
          {
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.aliceblue, 0, true, false, false));

            break;
          }
        case ANTIQUEWHITE:
          {
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.antiquewhite, 0, true, false, false));

            break;
          }
        case AQUA:
          {
            result.addIfNeeded(
                line, column, TextStyle.makeStyle(EditorColorScheme.aqua, 0, true, false, false));

            break;
          }
        case AQUAMARINE:
          {
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.aquamarine, 0, true, false, false));

            break;
          }
        case AZURE:
          {
            result.addIfNeeded(
                line, column, TextStyle.makeStyle(EditorColorScheme.azure, 0, true, false, false));

            break;
          }
        case BEIGE:
          {
            result.addIfNeeded(
                line, column, TextStyle.makeStyle(EditorColorScheme.beige, 0, true, false, false));

            break;
          }
        case BISQUE:
          {
            result.addIfNeeded(
                line, column, TextStyle.makeStyle(EditorColorScheme.bisque, 0, true, false, false));

            break;
          }
        case BLACK:
          {
            result.addIfNeeded(
                line, column, TextStyle.makeStyle(EditorColorScheme.black, 0, true, false, false));

            break;
          }
        case BLANCHEDALMOND:
          {
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.blanchedalmond, 0, true, false, false));

            break;
          }
        case BLUE:
          {
            result.addIfNeeded(line, column, EditorColorScheme.blue);
            break;
          }
        case BLUEVIOLET:
          {
            result.addIfNeeded(
                line,
                column,
                TextStyle.makeStyle(EditorColorScheme.blueviolet, 0, true, false, false));

            break;
          }
        case BROWN:
          {
            result.addIfNeeded(
                line, column, TextStyle.makeStyle(EditorColorScheme.brown, 0, true, false, false));

            break;
          }

        default:
          isError = true;
          if (token == Token.LBRACK || (token == Token.RBRACK && previous == Token.LBRACK)) {
            result.addIfNeeded(line, column, EditorColorScheme.OPERATOR);
            break;
          }
          try {
            if (text.toString()
                .matches(
                    "https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)")) {
              result.addIfNeeded(line, column, EditorColorScheme.red);
              break;
            }
          } catch (Exception err) {
            err.printStackTrace();
          }

          classNamePrevious = false;
          result.addIfNeeded(line, column, EditorColorScheme.OPERATOR);
      }
      first = false;
      helper.update(thisLength);
      line = helper.getLine();
      column = helper.getColumn();
      if (token != Token.WHITESPACE && token != Token.NEWLINE) {
        previous = token;
      }
    }
    if (stack.isEmpty()) {
      if (currSwitch > maxSwitch) {
        maxSwitch = currSwitch;
      }
    }
    if (isError) {
      //      if(helperzz != null) {
      //      	//helperzz.show();
      //      }
      sin.analyze(content, result, delegate);
    }
    identifiers.finish();
    result.determine(line);
    result.setExtra(identifiers);
    result.setSuppressSwitch(maxSwitch + 50);
    result.setNavigation(labels);
  }

  @Override
  public void Error(boolean error) {
    isError = error;
  }

  @Override
  public void NotError(boolean error) {
    isError = error;
  }

  protected interface End {
    void ends();
  }

  public static class HighlightToken {

    public Token token;
    public int offset;
    public String url;

    public HighlightToken(Token token, int offset) {
      this.token = token;
      this.offset = offset;
    }

    public HighlightToken(Token token, int offset, String url) {
      this.token = token;
      this.offset = offset;
      this.url = url;
    }
  }
}
