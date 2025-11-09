package io.github.rosemoe.sora.langs.html;

import io.github.rosemoe.sora.langs.internal.MyCharacter;
import io.github.rosemoe.sora.langs.internal.TrieTree;

/**
 * @author
 */
public class HTMLTextTokenizer {

  protected static String[] sKeywords;
  private static TrieTree<Token> keywords;
  private static TrieTree<Token> css;

  static {
    doStaticInit();
  }

  protected int bufferLen;
  protected int offset;
  protected int length;
  private CharSequence source;
  private int line;
  private int column;
  private int index;
  private Token currToken;
  private boolean lcCal;
  private boolean skipWS;
  private boolean skipComment;

  public HTMLTextTokenizer(CharSequence src) {
    if (src == null) {
      throw new IllegalArgumentException("src can not be null");
    }
    this.source = src;
    init();
  }

  public static TrieTree<Token> getTree() {
    return keywords;
  }

  public static TrieTree<Token> getcss() {
    return css;
  }

  /* */
  protected static void doStaticInit() {
    sKeywords =
        new String[] {
          "<!--",
          "-->",
          "/*",
          "*/",
          "a",
          "abbr",
          "acronym",
          "address",
          "applet",
          "article",
          "aside",
          "audio",
          "b",
          "basefont",
          "bdi",
          "bdo",
          "bgsound",
          "big",
          "blink",
          "blockquote",
          "body",
          "button",
          "canvas",
          "caption",
          "center",
          "circle",
          "clippath",
          "code",
          "colgroup",
          "command",
          "datalist",
          "dd",
          "defs",
          "del",
          "details",
          "dfn",
          "dialog",
          "dir",
          "div",
          "dl",
          "dt",
          "element",
          "ellipse",
          "em",
          "fieldset",
          "figcaption",
          "figure",
          "footer",
          "foreignobject",
          "form",
          "frame",
          "frameset",
          "g",
          "h1",
          "h2",
          "h3",
          "h4",
          "h5",
          "h6",
          "head",
          "header",
          "hgroup",
          "html",
          "i",
          "iframe",
          "image",
          "ins",
          "isindex",
          "kbd",
          "label",
          "legend",
          "li",
          "line",
          "lineargradient",
          "listing",
          "main",
          "map",
          "mark",
          "marquee",
          "mask",
          "math",
          "menu",
          "menuitem",
          "meter",
          "multicol",
          "nav",
          "nextid",
          "nobr",
          "noembed",
          "noframes",
          "noscript",
          "object",
          "ol",
          "optgroup",
          "option",
          "output",
          "p",
          "path",
          "pattern",
          "picture",
          "plaintext",
          "polygon",
          "polyline",
          "pre",
          "progress",
          "q",
          "radialgradient",
          "rb",
          "rbc",
          "rect",
          "rp",
          "rt",
          "rtc",
          "ruby",
          "s",
          "samp",
          "script",
          "section",
          "select",
          "shadow",
          "slot",
          "small",
          "spacer",
          "span",
          "stop",
          "strike",
          "strong",
          "style",
          "nostyle",
          "sub",
          "summary",
          "sup",
          "svg",
          "table",
          "tbody",
          "td",
          "template",
          "text",
          "textarea",
          "tfoot",
          "th",
          "thead",
          "time",
          "title",
          "tr",
          "tspan",
          "tt",
          "u",
          "ul",
          "video",
          "xmp",
          "class",
          "meta",
          "align_content",
          "align_items",
          "align_self",
          "all",
          "animation",
          "animation_delay",
          "animation_direction",
          "animation_duration",
          "animation_fill_mode",
          "animation_iteration_count",
          "animation_name",
          "animation_play_state",
          "animation_timing_function",
          "backface_visibility",
          "background",
          "background_attachment",
          "background_blur",
          "background_clip",
          "background_color",
          "background_image",
          "background_origin",
          "background_position",
          "background_repeat",
          "background_size",
          "border_bottom",
          "border_bottom_color",
          "border_bottom_left_radius",
          "border_bottom_right_radius",
          "border_bottom_style",
          "border_bottom_width",
          "border_collapse",
          "border_color",
          "border_image",
          "border_image_outset",
          "border_image_repeat",
          "border_image_slice",
          "border_image_source",
          "border_image_width",
          "border_left",
          "border_left_color",
          "border_left_style",
          "border_left_width",
          "border_radius",
          "border_right",
          "border_right_color",
          "border_right_style",
          "border_right_width",
          "border_spacing",
          "border_style",
          "border_top",
          "border_top_color",
          "border_top_left_radius",
          "border_top_right_radius",
          "border_top_style",
          "border_top_width",
          "border_width",
          "bottom",
          "box_decoration_break",
          "box_shadow",
          "box_sizing",
          "break_after",
          "break_before",
          "break_inside",
          "caption_side",
          "caret_color",
          "clear",
          "clip",
          "color",
          "column_count",
          "column_fill",
          "column_gap",
          "column_rule",
          "column_rule_color",
          "column_rule_style",
          "column_rule_width",
          "column_span",
          "column_width",
          "columns",
          "counter_increment",
          "counter_reset",
          "cursor",
          "direction",
          "display",
          "empty_cells",
          "filter",
          "flex",
          "flex_basis",
          "flex_direction",
          "flex_flow",
          "flex_grow",
          "flex_shrink",
          "flex_wrap",
          "font",
          "font_family",
          "font_size",
          "font_size_adjust",
          "font_stretch",
          "font_style",
          "font_variant",
          "font_variant_caps",
          "font_weight",
          "gap",
          "grid",
          "grid_area",
          "grid_auto_columns",
          "grid_auto_flow",
          "grid_auto_rows",
          "grid_column",
          "grid_column_end",
          "grid_column_gap",
          "grid_column_start",
          "grid_gap",
          "grid_row",
          "grid_row_end",
          "grid_row_gap",
          "grid_row_start",
          "grid_template",
          "grid_template_areas",
          "grid_template_columns",
          "grid_template_rows",
          "height",
          "ime_mode",
          "justify_content",
          "left",
          "letter_spacing",
          "line_break",
          "line_height",
          "list_style",
          "list_style_image",
          "list_style_position",
          "list_style_type",
          "margin",
          "margin_bottom",
          "margin_left",
          "margin_right",
          "margin_top",
          "marker_offset",
          "max_height",
          "max_width",
          "min_height",
          "min_width",
          "mix_blend_mode",
          "object_fit",
          "object_position",
          "opacity",
          "order",
          "orphans",
          "outline",
          "outline_color",
          "outline_offset",
          "outline_style",
          "outline_width",
          "overflow",
          "overflow_wrap",
          "overflow_x",
          "overflow_y",
          "padding",
          "padding_bottom",
          "padding_left",
          "padding_right",
          "padding_top",
          "page_break_after",
          "page_break_before",
          "page_break_inside",
          "perspective",
          "perspective_origin",
          "pointer_events",
          "position",
          "quotes",
          "resize",
          "right",
          "row_gap",
          "scroll_behavior",
          "speak",
          "table_layout",
          "tab_size",
          "text_align",
          "text_align_last",
          "text_decoration",
          "text_decoration_color",
          "text_decoration_line",
          "text_decoration_skip",
          "text_decoration_style",
          "text_indent",
          "text_justify",
          "text_overflow",
          "text_shadow",
          "text_transform",
          "text_underline_position",
          "top",
          "transform",
          "transform_origin",
          "transform_style",
          "transition",
          "transition_delay",
          "transition_duration",
          "transition_property",
          "transition_timing_function",
          "unicode_bidi",
          "vertical_align",
          "visibility",
          "white_space",
          "widows",
          "width",
          "will_change",
          "word_break",
          "word_spacing",
          "word_wrap",
          "writing_mode",
          "z_index",
          "abstract",
          "else",
          "instanceof",
          "super",
          "boolean",
          "enum",
          "int",
          "switch",
          "break",
          "export",
          "interface",
          "synchronized",
          "byte",
          "extends",
          "let",
          "this",
          "case",
          "false",
          "long",
          "throw",
          "catch",
          "final",
          "native",
          "throws",
          "char",
          "finally",
          "new",
          "transient",
          "float",
          "null",
          "true",
          "const",
          "for",
          "package",
          "try",
          "continue",
          "function",
          "private",
          "typeof",
          "debugger",
          "goto",
          "protected",
          "var",
          "if",
          "public",
          "void",
          "delete",
          "implements",
          "return",
          "volatile",
          "do",
          "import",
          "short",
          "while",
          "double",
          "in",
          "static",
          "with",
          "of",
          "console",
          "log",
          "prototype",
          "alert",
          "support",
          "yield",
          "async",
          "document",
          "arguments",
          "parseint",
          "await",
          "undefined",
          "parsefloat",
          "get",
          "storage",
          "infinity",
          "escape",
          "__count__",
          "__parent__",
          "__proto__",
          "window",
          "eval",
          "getelementbyid",
          "getelementbyclass",
          "accept",
          "accesskey",
          "action",
          "align",
          "alt",
          "autocomplete",
          "autofocus",
          "autoplay",
          "border",
          "bgcolor",
          "charset",
          "checked",
          "cite",
          "cols",
          "colspan",
          "content",
          "contenteditable",
          "controls",
          "coords",
          "data",
          "datetime",
          "default",
          "defer",
          "dirname",
          "disabled",
          "draggable",
          "dropzone",
          "enctype",
          "face",
          "formaction",
          "headers",
          "high",
          "href",
          "hreflang",
          "http",
          "equiv",
          "id",
          "ismap",
          "kind",
          "lang",
          "list",
          "loop",
          "low",
          "max",
          "maxlength",
          "media",
          "method",
          "min",
          "multiple",
          "muted",
          "name",
          "novalidate",
          "onabort",
          "onafterprint",
          "onbeforeprint",
          "onbeforeunload",
          "onblur",
          "oncanplay",
          "oncanplaythrough",
          "onchange",
          "onclick",
          "oncontextmenu",
          "oncopy",
          "oncuechange",
          "oncut",
          "ondblclick",
          "ondrag",
          "ondragend",
          "ondragenter",
          "ondragleave",
          "ondragover",
          "ondragstart",
          "ondrop",
          "ondurationchange",
          "onemptied",
          "onended",
          "onerror",
          "onfocus",
          "onhashchange",
          "oninput",
          "oninvalid",
          "onkeydown",
          "onkeypress",
          "onkeyup",
          "onload",
          "onloadeddata",
          "onloadedmetadata",
          "onloadstart",
          "onmousedown",
          "onmousemove",
          "onmouseout",
          "onmouseover",
          "onmouseup",
          "onmousewheel",
          "onoffline",
          "ononline",
          "onpagehide",
          "onpageshow",
          "onpaste",
          "onplay",
          "onplaying",
          "onpopstate",
          "onprogress",
          "onratechange",
          "onreset",
          "onresize",
          "onscroll",
          "onsearch",
          "onseeked",
          "onseeking",
          "onselect",
          "onstalled",
          "onstorage",
          "onsubmit",
          "onsuspend",
          "ontimeupdate",
          "ontoggle",
          "onunload",
          "onvolumechange",
          "onwaiting",
          "onwheel",
          "open",
          "optimum",
          "placeholder",
          "poster",
          "preload",
          "readonly",
          "rel",
          "required",
          "reversed",
          "rows",
          "rowspan",
          "sandbox",
          "scope",
          "selected",
          "shape",
          "size",
          "sizes",
          "spellcheck",
          "src",
          "srcdoc",
          "srclang",
          "srcset",
          "start",
          "step",
          "tabindex",
          "target",
          "translate",
          "type",
          "usemap",
          "value",
          "wrap",
          "area",
          "base",
          "br",
          "col",
          "embed",
          "hr",
          "img",
          "input",
          "keygen",
          "link",
          "param",
          "source",
          "track",
          "wbr",
          "px",
          "vim",
          "rem",
          "vh",
          "vw",
          "pt",
          "cm",
          "mm",
          "pc",
          "ex",
          "ch",
          "deg",
          "grad",
          "rad",
          "turn",
          "ms",
          "fr",
          "underline",
          "italic",
          "bold",
          "normal",
          "rgba",
          "hsl",
          "url",
          "none",
          "block",
          "inline",
          "cell",
          "row",
          "absolute",
          "relative",
          "fixed",
          "collapse",
          "visible",
          "uppercase",
          "lowercase",
          "capitalize",
          "shrink",
          "reverse",
          "nowrap",
          "horizontal",
          "vertical",
          "repeat",
          "no",
          "red",
          "aliceblue",
          "antiquewhite",
          "aqua",
          "aquamarine",
          "azure",
          "beige",
          "bisque",
          " black",
          "blanchedalmond",
          "blue",
          "blueviolet",
          "brown"
        };
    Token[] sToken =
        new Token[] {
          Token.HTMLCOMMENTSTART,
          Token.HTMLCOMMENTEND,
          Token.CSSCOMMENTSTART,
          Token.CSSCOMMENTEND,
          Token.A,
          Token.ABBR,
          Token.ACRONYM,
          Token.ADDRESS,
          Token.APPLET,
          Token.ARTICLE,
          Token.ASIDE,
          Token.AUDIO,
          Token.B,
          Token.BASEFONT,
          Token.BDI,
          Token.BDO,
          Token.BGSOUND,
          Token.BIG,
          Token.BLINK,
          Token.BLOCKQUOTE,
          Token.BODY,
          Token.BUTTON,
          Token.CANVAS,
          Token.CAPTION,
          Token.CENTER,
          Token.CIRCLE,
          Token.CLIPPATH,
          Token.CODE,
          Token.COLGROUP,
          Token.COMMAND,
          Token.DATALIST,
          Token.DD,
          Token.DEFS,
          Token.DEL,
          Token.DETAILS,
          Token.DFN,
          Token.DIALOG,
          Token.DIR,
          Token.DIV,
          Token.DL,
          Token.DT,
          Token.ELEMENT,
          Token.ELLIPSE,
          Token.EM,
          Token.FIELDSET,
          Token.FIGCAPTION,
          Token.FIGURE,
          Token.FOOTER,
          Token.FOREIGNOBJECT,
          Token.FORM,
          Token.FRAME,
          Token.FRAMESET,
          Token.G,
          Token.H1,
          Token.H2,
          Token.H3,
          Token.H4,
          Token.H5,
          Token.H6,
          Token.HEAD,
          Token.HEADER,
          Token.HGROUP,
          Token.HTML,
          Token.I,
          Token.IFRAME,
          Token.IMAGE,
          Token.INS,
          Token.ISINDEX,
          Token.KBD,
          Token.LABEL,
          Token.LEGEND,
          Token.LI,
          Token.LINE,
          Token.LINEARGRADIENT,
          Token.LISTING,
          Token.MAIN,
          Token.MAP,
          Token.MARK,
          Token.MARQUEE,
          Token.MASK,
          Token.MATH,
          Token.MENU,
          Token.MENUITEM,
          Token.METER,
          Token.MULTICOL,
          Token.NAV,
          Token.NEXTID,
          Token.NOBR,
          Token.NOEMBED,
          Token.NOFRAMES,
          Token.NOSCRIPT,
          Token.OBJECT,
          Token.OL,
          Token.OPTGROUP,
          Token.OPTION,
          Token.OUTPUT,
          Token.P,
          Token.PATH,
          Token.PATTERN,
          Token.PICTURE,
          Token.PLAINTEXT,
          Token.POLYGON,
          Token.POLYLINE,
          Token.PRE,
          Token.PROGRESS,
          Token.Q,
          Token.RADIALGRADIENT,
          Token.RB,
          Token.RBC,
          Token.RECT,
          Token.RP,
          Token.RT,
          Token.RTC,
          Token.RUBY,
          Token.S,
          Token.SAMP,
          Token.SCRIPT,
          Token.SECTION,
          Token.SELECT,
          Token.SHADOW,
          Token.SLOT,
          Token.SMALL,
          Token.SPACER,
          Token.SPAN,
          Token.STOP,
          Token.STRIKE,
          Token.STRONG,
          Token.STYLE,
          Token.NOSTYLE,
          Token.SUB,
          Token.SUMMARY,
          Token.SUP,
          Token.SVG,
          Token.TABLE,
          Token.TBODY,
          Token.TD,
          Token.TEMPLATE,
          Token.TEXT,
          Token.TEXTAREA,
          Token.TFOOT,
          Token.TH,
          Token.THEAD,
          Token.TIME,
          Token.TITLE,
          Token.TR,
          Token.TSPAN,
          Token.TT,
          Token.U,
          Token.UL,
          Token.VIDEO,
          Token.XMP,
          Token.CLASS,
          Token.META,
          Token.ALIGN_CONTENT,
          Token.ALIGN_ITEMS,
          Token.ALIGN_SELF,
          Token.ALL,
          Token.ANIMATION,
          Token.ANIMATION_DELAY,
          Token.ANIMATION_DIRECTION,
          Token.ANIMATION_DURATION,
          Token.ANIMATION_FILL_MODE,
          Token.ANIMATION_ITERATION_COUNT,
          Token.ANIMATION_NAME,
          Token.ANIMATION_PLAY_STATE,
          Token.ANIMATION_TIMING_FUNCTION,
          Token.BACKFACE_VISIBILITY,
          Token.BACKGROUND,
          Token.BACKGROUND_ATTACHMENT,
          Token.BACKGROUND_BLUR,
          Token.BACKGROUND_CLIP,
          Token.BACKGROUND_COLOR,
          Token.BACKGROUND_IMAGE,
          Token.BACKGROUND_ORIGIN,
          Token.BACKGROUND_POSITION,
          Token.BACKGROUND_REPEAT,
          Token.BACKGROUND_SIZE,
          Token.BORDER_BOTTOM,
          Token.BORDER_BOTTOM_COLOR,
          Token.BORDER_BOTTOM_LEFT_RADIUS,
          Token.BORDER_BOTTOM_RIGHT_RADIUS,
          Token.BORDER_BOTTOM_STYLE,
          Token.BORDER_BOTTOM_WIDTH,
          Token.BORDER_COLLAPSE,
          Token.BORDER_COLOR,
          Token.BORDER_IMAGE,
          Token.BORDER_IMAGE_OUTSET,
          Token.BORDER_IMAGE_REPEAT,
          Token.BORDER_IMAGE_SLICE,
          Token.BORDER_IMAGE_SOURCE,
          Token.BORDER_IMAGE_WIDTH,
          Token.BORDER_LEFT,
          Token.BORDER_LEFT_COLOR,
          Token.BORDER_LEFT_STYLE,
          Token.BORDER_LEFT_WIDTH,
          Token.BORDER_RADIUS,
          Token.BORDER_RIGHT,
          Token.BORDER_RIGHT_COLOR,
          Token.BORDER_RIGHT_STYLE,
          Token.BORDER_RIGHT_WIDTH,
          Token.BORDER_SPACING,
          Token.BORDER_STYLE,
          Token.BORDER_TOP,
          Token.BORDER_TOP_COLOR,
          Token.BORDER_TOP_LEFT_RADIUS,
          Token.BORDER_TOP_RIGHT_RADIUS,
          Token.BORDER_TOP_STYLE,
          Token.BORDER_TOP_WIDTH,
          Token.BORDER_WIDTH,
          Token.BOTTOM,
          Token.BOX_DECORATION_BREAK,
          Token.BOX_SHADOW,
          Token.BOX_SIZING,
          Token.BREAK_AFTER,
          Token.BREAK_BEFORE,
          Token.BREAK_INSIDE,
          Token.CAPTION_SIDE,
          Token.CARET_COLOR,
          Token.CLEAR,
          Token.CLIP,
          Token.COLOR,
          Token.COLUMN_COUNT,
          Token.COLUMN_FILL,
          Token.COLUMN_GAP,
          Token.COLUMN_RULE,
          Token.COLUMN_RULE_COLOR,
          Token.COLUMN_RULE_STYLE,
          Token.COLUMN_RULE_WIDTH,
          Token.COLUMN_SPAN,
          Token.COLUMN_WIDTH,
          Token.COLUMNS,
          Token.COUNTER_INCREMENT,
          Token.COUNTER_RESET,
          Token.CURSOR,
          Token.DIRECTION,
          Token.DISPLAY,
          Token.EMPTY_CELLS,
          Token.FILTER,
          Token.FLEX,
          Token.FLEX_BASIS,
          Token.FLEX_DIRECTION,
          Token.FLEX_FLOW,
          Token.FLEX_GROW,
          Token.FLEX_SHRINK,
          Token.FLEX_WRAP,
          Token.FONT,
          Token.FONT_FAMILY,
          Token.FONT_SIZE,
          Token.FONT_SIZE_ADJUST,
          Token.FONT_STRETCH,
          Token.FONT_STYLE,
          Token.FONT_VARIANT,
          Token.FONT_VARIANT_CAPS,
          Token.FONT_WEIGHT,
          Token.GAP,
          Token.GRID,
          Token.GRID_AREA,
          Token.GRID_AUTO_COLUMNS,
          Token.GRID_AUTO_FLOW,
          Token.GRID_AUTO_ROWS,
          Token.GRID_COLUMN,
          Token.GRID_COLUMN_END,
          Token.GRID_COLUMN_GAP,
          Token.GRID_COLUMN_START,
          Token.GRID_GAP,
          Token.GRID_ROW,
          Token.GRID_ROW_END,
          Token.GRID_ROW_GAP,
          Token.GRID_ROW_START,
          Token.GRID_TEMPLATE,
          Token.GRID_TEMPLATE_AREAS,
          Token.GRID_TEMPLATE_COLUMNS,
          Token.GRID_TEMPLATE_ROWS,
          Token.HEIGHT,
          Token.IME_MODE,
          Token.JUSTIFY_CONTENT,
          Token.LEFT,
          Token.LETTER_SPACING,
          Token.LINE_BREAK,
          Token.LINE_HEIGHT,
          Token.LIST_STYLE,
          Token.LIST_STYLE_IMAGE,
          Token.LIST_STYLE_POSITION,
          Token.LIST_STYLE_TYPE,
          Token.MARGIN,
          Token.MARGIN_BOTTOM,
          Token.MARGIN_LEFT,
          Token.MARGIN_RIGHT,
          Token.MARGIN_TOP,
          Token.MARKER_OFFSET,
          Token.MAX_HEIGHT,
          Token.MAX_WIDTH,
          Token.MIN_HEIGHT,
          Token.MIN_WIDTH,
          Token.MIX_BLEND_MODE,
          Token.OBJECT_FIT,
          Token.OBJECT_POSITION,
          Token.OPACITY,
          Token.ORDER,
          Token.ORPHANS,
          Token.OUTLINE,
          Token.OUTLINE_COLOR,
          Token.OUTLINE_OFFSET,
          Token.OUTLINE_STYLE,
          Token.OUTLINE_WIDTH,
          Token.OVERFLOW,
          Token.OVERFLOW_WRAP,
          Token.OVERFLOW_X,
          Token.OVERFLOW_Y,
          Token.PADDING,
          Token.PADDING_BOTTOM,
          Token.PADDING_LEFT,
          Token.PADDING_RIGHT,
          Token.PADDING_TOP,
          Token.PAGE_BREAK_AFTER,
          Token.PAGE_BREAK_BEFORE,
          Token.PAGE_BREAK_INSIDE,
          Token.PERSPECTIVE,
          Token.PERSPECTIVE_ORIGIN,
          Token.POINTER_EVENTS,
          Token.POSITION,
          Token.QUOTES,
          Token.RESIZE,
          Token.RIGHT,
          Token.ROW_GAP,
          Token.SCROLL_BEHAVIOR,
          Token.SPEAK,
          Token.TABLE_LAYOUT,
          Token.TAB_SIZE,
          Token.TEXT_ALIGN,
          Token.TEXT_ALIGN_LAST,
          Token.TEXT_DECORATION,
          Token.TEXT_DECORATION_COLOR,
          Token.TEXT_DECORATION_LINE,
          Token.TEXT_DECORATION_SKIP,
          Token.TEXT_DECORATION_STYLE,
          Token.TEXT_INDENT,
          Token.TEXT_JUSTIFY,
          Token.TEXT_OVERFLOW,
          Token.TEXT_SHADOW,
          Token.TEXT_TRANSFORM,
          Token.TEXT_UNDERLINE_POSITION,
          Token.TOP,
          Token.TRANSFORM,
          Token.TRANSFORM_ORIGIN,
          Token.TRANSFORM_STYLE,
          Token.TRANSITION,
          Token.TRANSITION_DELAY,
          Token.TRANSITION_DURATION,
          Token.TRANSITION_PROPERTY,
          Token.TRANSITION_TIMING_FUNCTION,
          Token.UNICODE_BIDI,
          Token.VERTICAL_ALIGN,
          Token.VISIBILITY,
          Token.WHITE_SPACE,
          Token.WIDOWS,
          Token.WIDTH,
          Token.WILL_CHANGE,
          Token.WORD_BREAK,
          Token.WORD_SPACING,
          Token.WORD_WRAP,
          Token.WRITING_MODE,
          Token.Z_INDEX,
          Token.ABSTRACT,
          Token.ELSE,
          Token.INSTANCEOF,
          Token.SUPER,
          Token.BOOLEAN,
          Token.ENUM,
          Token.INT,
          Token.SWITCH,
          Token.BREAK,
          Token.EXPORT,
          Token.INTERFACE,
          Token.SYNCHRONIZED,
          Token.BYTE,
          Token.EXTENDS,
          Token.LET,
          Token.THIS,
          Token.CASE,
          Token.FALSE,
          Token.LONG,
          Token.THROW,
          Token.CATCH,
          Token.FINAL,
          Token.NATIVE,
          Token.THROWS,
          Token.CHAR,
          Token.FINALLY,
          Token.NEW,
          Token.TRANSIENT,
          Token.FLOAT,
          Token.NULL,
          Token.TRUE,
          Token.CONST,
          Token.FOR,
          Token.PACKAGE,
          Token.TRY,
          Token.CONTINUE,
          Token.FUNCTION,
          Token.PRIVATE,
          Token.TYPEOF,
          Token.DEBUGGER,
          Token.GOTO,
          Token.PROTECTED,
          Token.VAR,
          Token.IF,
          Token.PUBLIC,
          Token.VOID,
          Token.DELETE,
          Token.IMPLEMENTS,
          Token.RETURN,
          Token.VOLATILE,
          Token.DO,
          Token.IMPORT,
          Token.SHORT,
          Token.WHILE,
          Token.DOUBLE,
          Token.IN,
          Token.STATIC,
          Token.WITH,
          Token.OF,
          Token.CONSOLE,
          Token.LOG,
          Token.PROTOTYPE,
          Token.ALERT,
          Token.SUPPORT,
          Token.YIELD,
          Token.ASYNC,
          Token.DOCUMENT,
          Token.ARGUMENTS,
          Token.PARSEINT,
          Token.AWAIT,
          Token.UNDEFINED,
          Token.PARSEFLOAT,
          Token.GET,
          Token.STORAGE,
          Token.INFINITY,
          Token.ESCAPE,
          Token.__COUNT__,
          Token.__PARENT__,
          Token.__PROTO__,
          Token.WINDOW,
          Token.EVAL,
          Token.GETELEMENTBYID,
          Token.GETELEMENTBYCLASS,
          Token.ACCEPT,
          Token.ACCESSKEY,
          Token.ACTION,
          Token.ALIGN,
          Token.ALT,
          Token.AUTOCOMPLETE,
          Token.AUTOFOCUS,
          Token.AUTOPLAY,
          Token.BORDER,
          Token.BGCOLOR,
          Token.CHARSET,
          Token.CHECKED,
          Token.CITE,
          Token.COLS,
          Token.COLSPAN,
          Token.CONTENT,
          Token.CONTENTEDITABLE,
          Token.CONTROLS,
          Token.COORDS,
          Token.DATA,
          Token.DATETIME,
          Token.DEFAULT,
          Token.DEFER,
          Token.DIRNAME,
          Token.DISABLED,
          Token.DRAGGABLE,
          Token.DROPZONE,
          Token.ENCTYPE,
          Token.FACE,
          Token.FORMACTION,
          Token.HEADERS,
          Token.HIGH,
          Token.HREF,
          Token.HREFLANG,
          Token.HTTP,
          Token.EQUIV,
          Token.ID,
          Token.ISMAP,
          Token.KIND,
          Token.LANG,
          Token.LIST,
          Token.LOOP,
          Token.LOW,
          Token.MAX,
          Token.MAXLENGTH,
          Token.MEDIA,
          Token.METHOD,
          Token.MIN,
          Token.MULTIPLE,
          Token.MUTED,
          Token.NAME,
          Token.NOVALIDATE,
          Token.ONABORT,
          Token.ONAFTERPRINT,
          Token.ONBEFOREPRINT,
          Token.ONBEFOREUNLOAD,
          Token.ONBLUR,
          Token.ONCANPLAY,
          Token.ONCANPLAYTHROUGH,
          Token.ONCHANGE,
          Token.ONCLICK,
          Token.ONCONTEXTMENU,
          Token.ONCOPY,
          Token.ONCUECHANGE,
          Token.ONCUT,
          Token.ONDBLCLICK,
          Token.ONDRAG,
          Token.ONDRAGEND,
          Token.ONDRAGENTER,
          Token.ONDRAGLEAVE,
          Token.ONDRAGOVER,
          Token.ONDRAGSTART,
          Token.ONDROP,
          Token.ONDURATIONCHANGE,
          Token.ONEMPTIED,
          Token.ONENDED,
          Token.ONERROR,
          Token.ONFOCUS,
          Token.ONHASHCHANGE,
          Token.ONINPUT,
          Token.ONINVALID,
          Token.ONKEYDOWN,
          Token.ONKEYPRESS,
          Token.ONKEYUP,
          Token.ONLOAD,
          Token.ONLOADEDDATA,
          Token.ONLOADEDMETADATA,
          Token.ONLOADSTART,
          Token.ONMOUSEDOWN,
          Token.ONMOUSEMOVE,
          Token.ONMOUSEOUT,
          Token.ONMOUSEOVER,
          Token.ONMOUSEUP,
          Token.ONMOUSEWHEEL,
          Token.ONOFFLINE,
          Token.ONONLINE,
          Token.ONPAGEHIDE,
          Token.ONPAGESHOW,
          Token.ONPASTE,
          Token.ONPLAY,
          Token.ONPLAYING,
          Token.ONPOPSTATE,
          Token.ONPROGRESS,
          Token.ONRATECHANGE,
          Token.ONRESET,
          Token.ONRESIZE,
          Token.ONSCROLL,
          Token.ONSEARCH,
          Token.ONSEEKED,
          Token.ONSEEKING,
          Token.ONSELECT,
          Token.ONSTALLED,
          Token.ONSTORAGE,
          Token.ONSUBMIT,
          Token.ONSUSPEND,
          Token.ONTIMEUPDATE,
          Token.ONTOGGLE,
          Token.ONUNLOAD,
          Token.ONVOLUMECHANGE,
          Token.ONWAITING,
          Token.ONWHEEL,
          Token.OPEN,
          Token.OPTIMUM,
          Token.PLACEHOLDER,
          Token.POSTER,
          Token.PRELOAD,
          Token.READONLY,
          Token.REL,
          Token.REQUIRED,
          Token.REVERSED,
          Token.ROWS,
          Token.ROWSPAN,
          Token.SANDBOX,
          Token.SCOPE,
          Token.SELECTED,
          Token.SHAPE,
          Token.SIZE,
          Token.SIZES,
          Token.SPELLCHECK,
          Token.SRC,
          Token.SRCDOC,
          Token.SRCLANG,
          Token.SRCSET,
          Token.START,
          Token.STEP,
          Token.TABINDEX,
          Token.TARGET,
          Token.TRANSLATE,
          Token.TYPE,
          Token.USEMAP,
          Token.VALUE,
          Token.WRAP,
          Token.AREA,
          Token.BASE,
          Token.BR,
          Token.COL,
          Token.EMBED,
          Token.HR,
          Token.IMG,
          Token.INPUT,
          Token.KEYGEN,
          Token.LINK,
          Token.PARAM,
          Token.SOURCE,
          Token.TRACK,
          Token.WBR,
          Token.PX,
          Token.VIM,
          Token.REM,
          Token.VH,
          Token.VW,
          Token.PT,
          Token.CM,
          Token.MM,
          Token.PC,
          Token.EX,
          Token.CH,
          Token.DEG,
          Token.GRAD,
          Token.RAD,
          Token.TURN,
          Token.MS,
          Token.FR,
          Token.UNDERLINE,
          Token.ITALIC,
          Token.BOLD,
          Token.NORMAL,
          Token.RGBA,
          Token.HSL,
          Token.URL,
          Token.NONE,
          Token.BLOCK,
          Token.INLINE,
          Token.CELL,
          Token.ROW,
          Token.ABSOLUTE,
          Token.RELATIVE,
          Token.FIXED,
          Token.COLLAPSE,
          Token.VISIBLE,
          Token.UPPERCASE,
          Token.LOWERCASE,
          Token.CAPITALIZE,
          Token.SHRINK,
          Token.REVERSE,
          Token.NOWRAP,
          Token.HORIZONTAL,
          Token.VERTICAL,
          Token.REPEAT,
          Token.NO,
          Token.RED,
          Token.ALICEBLUE,
          Token.ANTIQUEWHITE,
          Token.AQUA,
          Token.AQUAMARINE,
          Token.AZURE,
          Token.BEIGE,
          Token.BISQUE,
          Token.BLACK,
          Token.BLANCHEDALMOND,
          Token.BLUE,
          Token.BLUEVIOLET,
          Token.BROWN
        };
    keywords = new TrieTree<>();
    css = new TrieTree<>();
    for (int i = 0; i < sKeywords.length; i++) {
      keywords.put(sKeywords[i], sToken[i]);
    }
  }

  protected static boolean isDigit(char c) {
    return ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'));
  }

  protected static boolean isPrimeDigit(char c) {
    return (c >= '0' && c <= '9');
  }

  protected static boolean isWhitespace(char c) {
    return (c == '\t' || c == ' ' || c == '\f' || c == '\n' || c == '\r');
  }

  private void init() {
    line = 0;
    column = 0;
    length = 0;
    index = 0;
    currToken = Token.WHITESPACE;
    lcCal = false;
    skipWS = false;
    skipComment = false;
    this.bufferLen = source.length();
  }

  public void setCalculateLineColumn(boolean cal) {
    this.lcCal = cal;
  }

  public void setSkipWhitespace(boolean skip) {
    this.skipWS = skip;
  }

  public void setSkipComment(boolean skip) {
    this.skipComment = skip;
  }

  public void pushBack(int length) {
    if (length > getTokenLength()) {
      throw new IllegalArgumentException("pushBack length too large");
    }
    this.length -= length;
  }

  private boolean isIdentifierPart(char ch) {
    return MyCharacter.isJavaIdentifierPart(ch);
  }

  private boolean isIdentifierStart(char ch) {
    return MyCharacter.isJavaIdentifierStart(ch);
  }

  public CharSequence getTokentring() {
    return source.subSequence(offset, offset + length);
  }

  public int getTokenLength() {
    return length;
  }

  public int getLine() {
    return line;
  }

  public int getColumn() {
    return column;
  }

  public int getIndex() {
    return index;
  }

  public Token getToken() {
    return currToken;
  }

  public String yyDesc() {
    return " Line：" + line + " Column：" + column;
  }

  private char charAt(int i) {
    return source.charAt(i);
  }

  private char charAt() {
    return source.charAt(offset + length);
  }

  public Token nextToken() {
    Token token;
    do {
      token = directNextToken();
    } while ((skipWS && token == Token.WHITESPACE)
        || (skipComment && (token == Token.LINE_COMMENT || token == Token.LONG_COMMENT)));
    currToken = token;
    return token;
  }

  public int getOffset() {
    return offset;
  }

  public Token directNextToken() {
    if (lcCal) {
      boolean r = false;
      for (int i = offset; i < offset + length; i++) {
        char ch = charAt(i);
        if (ch == '\r') {
          r = true;
          line++;
          column = 0;
        } else if (ch == '\n') {
          if (r) {
            r = false;
            continue;
          }
          line++;
          column = 0;
        } else {
          r = false;
          column++;
        }
      }
    }
    index = index + length;
    offset = offset + length;
    if (offset == bufferLen) {
      return Token.EOF;
    }
    char ch = source.charAt(offset);
    length = 1;
    if (ch == '\n') {
      return Token.NEWLINE;
    } else if (ch == '\r') {
      scanNewline();
      return Token.NEWLINE;
    } else if (isWhitespace(ch)) {
      char chLocal;
      while (offset + length < bufferLen && isWhitespace(chLocal = charAt(offset + length))) {
        if (chLocal == '\r' || chLocal == '\n') {
          break;
        }
        length++;
      }
      return Token.WHITESPACE;
    } else {
      if (isIdentifierStart(ch)) {
        return scanIdentifier(ch);
      }
      if (isPrimeDigit(ch)) {
        return scanNumber();
      }
      /* Scan usual symbols first */
      if (ch == ';') {
        return Token.SEMICOLON;
      } else if (ch == '(') {
        return Token.LPAREN;
      } else if (ch == ')') {
        return Token.RPAREN;
      } else if (ch == ':') {
        return Token.COLON;
      } else if (ch == '<') {
        return scanLT();
      } else if (ch == '>') {
        return scanGT();
      }
      /* Scan secondly symbols */
      if (source.toString().contains("</")) {
        return Token.TAGSLASH;
      }

      switch (ch) {
        case '=':
          return scanOperatorTwo(Token.EQ);
        case '.':
          return Token.DOT;
        case '@':
          return Token.AT;
        case '{':
          return Token.LBRACE;
        case '}':
          return Token.RBRACE;
        case '/':
          return scanDIV();
        case '*':
          return scanOperatorTwo(Token.MULT);
        case '-':
          return scanOperatorTwo(Token.MINUS);
        case '+':
          return scanOperatorTwo(Token.PLUS);
        case '[':
          return Token.LBRACK;
        case ']':
          return Token.RBRACK;
        case ',':
          return Token.COMMA;
        case '!':
          return Token.NOT;
        case '~':
          return Token.COMP;
        case '?':
          return Token.QUESTION;
        case '&':
          return scanOperatorTwo(Token.AND);
        case '|':
          return scanOperatorTwo(Token.OR);
        case '^':
          return scanOperatorTwo(Token.XOR);
        case '%':
          return scanOperatorTwo(Token.MOD);
        case '\'':
          scanCharLiteral();
          return Token.CHARACTER_LITERAL;
        case '\"':
          scanStringLiteral();
          return Token.STRING;
        case '#':
          return Token.SHARP;
        default:
          // error("没有匹配的Token : '" + ch + " '", new
          // StringAdvice("检查是否使用了非法的符号，比如误使用了中文符号代替英文符号等"));
          return Token.UNKNOWN;
      }
    }
  }

  protected final void throwIfNeeded() {
    if (offset + length == bufferLen) {
      throw new RuntimeException("Token too long");
    }
  }

  protected void scanNewline() {
    if (offset + length < bufferLen && charAt(offset + length) == '\n') {
      length++;
    }
  }

  /* The following methods have been simplified for syntax high light */

  protected Token scanIdentifier(char ch) {
    TrieTree.Node<Token> n = keywords.root.map.get(ch);
    while (offset + length < bufferLen && isIdentifierPart(ch = charAt(offset + length))) {
      length++;
      n = n == null ? null : n.map.get(ch);
    } // n.token
    return n == null ? Token.IDENTIFIER : (n.token == null ? Token.IDENTIFIER : n.token);
  }

  protected void scanTrans() {
    throwIfNeeded();
    char ch = charAt();
    if (ch == '\\'
        || ch == 't'
        || ch == 'f'
        || ch == 'n'
        || ch == 'r'
        || ch == '0'
        || ch == '\"'
        || ch == '\''
        || ch == 'b') {
      length++;
    } else if (ch == 'u') {
      length++;
      for (int i = 0; i < 4; i++) {
        throwIfNeeded();
        if (!isDigit(charAt(offset + length))) {
          return;
        }
        length++;
      }
    }
  }

  protected void scanStringLiteral() {
    throwIfNeeded();
    char ch;
    while (offset + length < bufferLen && (ch = charAt(offset + length)) != '\"') {
      if (ch == '\\') {
        length++;
        scanTrans();
      } else {
        if (ch == '\n') {

          return;
        }
        length++;
        throwIfNeeded();
      }
    }
    if (offset + length != bufferLen) {
      length++;
    }
  }

  protected void scanCharLiteral() {
    throwIfNeeded();
    char ch = charAt();
    if (ch == '\\') {
      length++;
      scanTrans();
    } else if (ch == '\'') {
      length++;
      return;
    } else {
      if (ch == '\n') {
        return;
      }
      length++;
    }
    throwIfNeeded();
    if (charAt() == '\'') {
      length++;
    }
  }

  protected Token scanNumber() {
    if (offset + length == bufferLen) {
      return Token.INTEGER_LITERAL;
    }
    boolean flag = false;
    char ch = charAt(offset);
    if (ch == '0') {
      if (charAt() == 'x') {
        length++;
      }
      flag = true;
    }
    while (offset + length < bufferLen && isDigit(charAt())) {
      length++;
    }
    if (offset + length == bufferLen) {
      return Token.INTEGER_LITERAL;
    }
    ch = charAt();
    if (ch == '.') {
      if (flag) {
        return Token.INTEGER_LITERAL;
      }
      if (offset + length + 1 == bufferLen) {
        return Token.INTEGER_LITERAL;
      }
      length++;
      throwIfNeeded();
      while (offset + length < bufferLen && isDigit(charAt())) {
        length++;
      }
      if (offset + length == bufferLen) {
        return Token.FLOATING_POINT_LITERAL;
      }
      ch = charAt();
      if (ch == 'e' || ch == 'E') {
        length++;
        throwIfNeeded();
        if (charAt() == '-' || charAt() == '+') {
          length++;
          throwIfNeeded();
        }
        while (offset + length < bufferLen && isPrimeDigit(charAt())) {
          length++;
        }
        if (offset + length == bufferLen) {
          return Token.FLOATING_POINT_LITERAL;
        }
        ch = charAt();
      }
      if (ch == 'f' || ch == 'F' || ch == 'D' || ch == 'd') {
        length++;
      }
      return Token.FLOATING_POINT_LITERAL;
    } else if (ch == 'l' || ch == 'L') {
      length++;
      return Token.INTEGER_LITERAL;
    } else if (ch == 'F' || ch == 'f' || ch == 'D' || ch == 'd') {
      length++;
      return Token.FLOATING_POINT_LITERAL;
    } else {
      return Token.INTEGER_LITERAL;
    }
  }

  protected Token scanDIV() {
    if (offset + 1 == bufferLen) {
      return Token.DIVS;
    }
    char ch = charAt();
    if (ch == '<') {
      length++;
      while (offset + length < bufferLen && charAt() != '\n') {
        length++;
      }
      return Token.LINE_COMMENT;
    } else if (ch == '!' && ch == '-' && ch == '-') {
      length++;
      char pre, curr = '?';
      while (offset + length < bufferLen) {
        pre = curr;
        curr = charAt();
        if (curr == '<' && pre == '-') {
          length++;
          break;
        }
        length++;
      }
      return Token.LONG_COMMENT;
    } else {
      return Token.DIVS;
    }
  }

  @SuppressWarnings("SameReturnValue")
  protected Token scanLT() {
    return Token.LT;
  }

  @SuppressWarnings("SameReturnValue")
  protected Token scanGT() {
    return Token.GT;
  }

  protected Token scanOperatorTwo(Token ifWrong) {
    return ifWrong;
  }

  public void reset(CharSequence src) {
    if (src == null) {
      throw new IllegalArgumentException();
    }
    this.source = src;
    line = 0;
    column = 0;
    length = 0;
    index = 0;
    offset = 0;
    currToken = Token.WHITESPACE;
    bufferLen = src.length();
  }
}
