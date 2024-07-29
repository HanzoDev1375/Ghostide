lexer grammar HTMLLexer;

HtmlTags
   : 'a'
   | 'abbr'
   | 'acronym'
   | 'address'
   | 'applet'
   | 'article'
   | 'aside'
   | 'audio'
   | 'b'
   | 'basefont'
   | 'bdi'
   | 'bdo'
   | 'bgsound'
   | 'big'
   | 'blink'
   | 'blockquote'
   | 'body'
   | 'button'
   | 'canvas'
   | 'caption'
   | 'center'
   | 'circle'
   | 'clipPath'
   | 'code'
   | 'colgroup'
   | 'command'
   | 'content'
   | 'data'
   | 'datalist'
   | 'dd'
   | 'defs'
   | 'del'
   | 'details'
   | 'dfn'
   | 'dialog'
   | 'dir'
   | 'div'
   | 'dl'
   | 'dt'
   | 'element'
   | 'ellipse'
   | 'fieldset'
   | 'figcaption'
   | 'figure'
   | 'font'
   | 'footer'
   | 'foreignObject'
   | 'frame'
   | 'frameset'
   | 'g'
   | 'h1'
   | 'h2'
   | 'h3'
   | 'h4'
   | 'h5'
   | 'h6'
   | 'head'
   | 'header'
   | 'hgroup'
   | 'html'
   | 'i'
   | 'iframe'
   | 'image'
   | 'ins'
   | 'isindex'
   | 'kbd'
   | 'label'
   | 'legend'
   | 'li'
   | 'line'
   | 'linearGradient'
   | 'listing'
   | 'main'
   | 'map'
   | 'mark'
   | 'marquee'
   | 'mask'
   | 'math'
   | 'menu'
   | 'menuitem'
   | 'meter'
   | 'multicol'
   | 'nav'
   | 'nextid'
   | 'nobr'
   | 'noembed'
   | 'noframes'
   | 'noscript'
   | 'object'
   | 'ol'
   | 'optgroup'
   | 'option'
   | 'output'
   | 'p'
   | 'path'
   | 'pattern'
   | 'picture'
   | 'plaintext'
   | 'polygon'
   | 'polyline'
   | 'pre'
   | 'progress'
   | 'radialGradient'
   | 'rb'
   | 'rbc'
   | 'rect'
   | 'rp'
   | 'rt'
   | 'rtc'
   | 'ruby'
   | 'samp'
   | 'script'
   | 'section'
   | 'select'
   | 'shadow'
   | 'slot'
   | 'small'
   | 'spacer'
   | 'stop'
   | 'strike'
   | 'strong'
   | 'style'
   | 'nostyle'
   | 'sub'
   | 'summary'
   | 'sup'
   | 'svg'
   | 'table'
   | 'tbody'
   | 'td' 'template'
   | 'text'
   | 'textarea'
   | 'tfoot'
   | 'th'
   | 'thead'
   | 'time'
   | 'tr'
   | 'tspan'
   | 'tt'
   | 'u'
   | 'ul'
   | 'video'
   | 'xmp'
   ;

HtmlTagOne
   : 'area'
   | 'base'
   | 'br'
   | 'col'
   | 'embed'
   | 'hr'
   | 'img'
   | 'input'
   | 'keygen'
   | 'link'
   | 'meta'
   | 'param'
   | 'source'
   | 'track'
   | 'wbr'
   | '<!DOCTYPE html>'
   ;

HtmlAttr
   : 'accept'
   | 'accept-charset'
   | 'accesskey'
   | 'action'
   | 'align'
   | 'alt'
   | 'autocomplete'
   | 'autofocus'
   | 'autoplay'
   | 'bgcolor'
   | 'charset'
   | 'checked'
   | 'cite'
   | 'cols'
   | 'colspan'
   | 'contenteditable'
   | 'controls'
   | 'coords'
   | 'data-*'
   | 'datetime'
   | 'defer'
   | 'dirname'
   | 'disabled'
   | 'draggable'
   | 'dropzone'
   | 'enctype'
   | 'face'
   | 'form'
   | 'formaction'
   | 'headers'
   | 'hidden'
   | 'high'
   | 'href'
   | 'hreflang'
   | 'http-equiv'
   | 'id'
   | 'ismap'
   | 'kind'
   | 'lang'
   | 'list'
   | 'loop'
   | 'low'
   | 'max'
   | 'maxlength'
   | 'media'
   | 'method'
   | 'min'
   | 'multiple'
   | 'muted'
   | 'name'
   | 'novalidate'
   | 'onabort'
   | 'onafterprint'
   | 'onbeforeprint'
   | 'onbeforeunload'
   | 'onblur'
   | 'oncanplay'
   | 'oncanplaythrough'
   | 'oncanplaythrough'
   | 'onchange'
   | 'onclick'
   | 'oncontextmenu'
   | 'oncopy'
   | 'oncuechange'
   | 'oncut'
   | 'ondblclick'
   | 'ondrag'
   | 'ondragend'
   | 'ondragenter'
   | 'ondragleave'
   | 'ondragover'
   | 'ondragstart'
   | 'ondrop'
   | 'ondurationchange'
   | 'onemptied'
   | 'onended'
   | 'onerror'
   | 'onfocus'
   | 'onhashchange'
   | 'oninput'
   | 'oninvalid'
   | 'onkeydown'
   | 'onkeypress'
   | 'onkeyup'
   | 'onload'
   | 'onloadeddata'
   | 'onloadedmetadata'
   | 'onloadstart'
   | 'onmousedown'
   | 'onmousemove'
   | 'onmouseout'
   | 'onmouseover'
   | 'onmouseup'
   | 'onmousewheel'
   | 'onoffline'
   | 'ononline'
   | 'onpagehide'
   | 'onpageshow'
   | 'onpaste'
   | 'onpause'
   | 'onplay'
   | 'onplaying'
   | 'onpopstate'
   | 'onprogress'
   | 'onratechange'
   | 'onreset'
   | 'onresize'
   | 'onscroll'
   | 'onsearch'
   | 'onseeked'
   | 'onseeking'
   | 'onselect'
   | 'onstalled'
   | 'onstorage'
   | 'onsubmit'
   | 'onsuspend'
   | 'ontimeupdate'
   | 'ontoggle'
   | 'onunload'
   | 'onvolumechange'
   | 'onwaiting'
   | 'onwheel'
   | 'open'
   | 'optimum'
   | 'pattern'
   | 'placeholder'
   | 'poster'
   | 'preload'
   | 'readonly'
   | 'rel'
   | 'required'
   | 'reversed'
   | 'rows'
   | 'rows'
   | 'rowspan'
   | 'sandbox'
   | 'scope'
   | 'selected'
   | 'shape'
   | 'size'
   | 'sizes'
   | 'span'
   | 'spellcheck'
   | 'src'
   | 'srcdoc'
   | 'srclang'
   | 'srcset'
   | 'start'
   | 'step'
   | 'tabindex'
   | 'target'
   | 'title'
   | 'translate'
   | 'type'
   | 'usemap'
   | 'value'
   | 'wrap'
   ;

CSSKEYWORD
   : 'align-content'
   | 'align-items'
   | 'align-self'
   | 'all'
   | 'animation'
   | 'animation-delay'
   | 'animation-direction'
   | 'animation-duration'
   | 'animation-fill-mode'
   | 'animation-iteration-count'
   | 'animation-name'
   | 'animation-play-state'
   | 'animation-timing-function'
   | 'backface-visibility'
   | 'background'
   | 'background-attachment'
   | 'background-blur'
   | 'background-clip'
   | 'background-color'
   | 'background-image'
   | 'background-origin'
   | 'background-position'
   | 'background-repeat'
   | 'background-size'
   | 'border'
   | 'border-bottom'
   | 'border-bottom-color'
   | 'border-bottom-left-radius'
   | 'border-bottom-right-radius'
   | 'border-bottom-style'
   | 'border-bottom-width'
   | 'border-collapse'
   | 'border-color'
   | 'border-image'
   | 'border-image-outset'
   | 'border-image-repeat'
   | 'border-image-slice'
   | 'border-image-source'
   | 'border-image-width'
   | 'border-left'
   | 'border-left-color'
   | 'border-left-style'
   | 'border-left-width'
   | 'border-radius'
   | 'border-right'
   | 'border-right-color'
   | 'border-right-style'
   | 'border-right-width'
   | 'border-spacing'
   | 'border-style'
   | 'border-top'
   | 'border-top-color'
   | 'border-top-left-radius'
   | 'border-top-right-radius'
   | 'border-top-style'
   | 'border-top-width'
   | 'border-width'
   | 'bottom'
   | 'box-decoration-break'
   | 'box-shadow'
   | 'box-sizing'
   | 'break-after'
   | 'break-before'
   | 'break-inside'
   | 'caption-side'
   | 'caret-color'
   | 'clear'
   | 'clip'
   | 'color'
   | 'column-count'
   | 'column-fill'
   | 'column-gap'
   | 'column-rule'
   | 'column-rule-color'
   | 'column-rule-style'
   | 'column-rule-width'
   | 'column-span'
   | 'column-width'
   | 'columns'
   | 'counter-increment'
   | 'counter-reset'
   | 'cursor'
   | 'direction'
   | 'display'
   | 'empty-cells'
   | 'filter'
   | 'flex'
   | 'flex-basis'
   | 'flex-direction'
   | 'flex-flow'
   | 'flex-grow'
   | 'flex-shrink'
   | 'flex-wrap'
   | 'float'
   | 'font-family'
   | 'font-size'
   | 'font-size-adjust'
   | 'font-stretch'
   | 'font-style'
   | 'font-variant'
   | 'font-variant-caps'
   | 'font-weight'
   | 'gap'
   | 'grid'
   | 'grid-area'
   | 'grid-auto-columns'
   | 'grid-auto-flow'
   | 'grid-auto-rows'
   | 'grid-column'
   | 'grid-column-end'
   | 'grid-column-gap'
   | 'grid-column-start'
   | 'grid-gap'
   | 'grid-row'
   | 'grid-row-end'
   | 'grid-row-gap'
   | 'grid-row-start'
   | 'grid-template'
   | 'grid-template-areas'
   | 'grid-template-columns'
   | 'grid-template-rows'
   | 'height'
   | 'ime-mode'
   | 'justify-content'
   | 'left'
   | 'letter-spacing'
   | 'line-break'
   | 'line-height'
   | 'list-style'
   | 'list-style-image'
   | 'list-style-position'
   | 'list-style-type'
   | 'margin'
   | 'margin-bottom'
   | 'margin-left'
   | 'margin-right'
   | 'margin-top'
   | 'marker-offset'
   | 'max-height'
   | 'max-width'
   | 'min-height'
   | 'min-width'
   | 'mix-blend-mode'
   | 'object-fit'
   | 'object-position'
   | 'opacity'
   | 'order'
   | 'orphans'
   | 'outline'
   | 'outline-color'
   | 'outline-offset'
   | 'outline-style'
   | 'outline-width'
   | 'overflow'
   | 'overflow-wrap'
   | 'overflow-x'
   | 'overflow-y'
   | 'padding'
   | 'padding-bottom'
   | 'padding-left'
   | 'padding-right'
   | 'padding-top'
   | 'page-break-after'
   | 'page-break-before'
   | 'page-break-inside'
   | 'perspective'
   | 'perspective-origin'
   | 'pointer-events'
   | 'position'
   | 'quotes'
   | 'resize'
   | 'right'
   | 'row-gap'
   | 'scroll-behavior'
   | 'speak'
   | 'table-layout'
   | 'tab-size'
   | 'text-align'
   | 'text-align-last'
   | 'text-decoration'
   | 'text-decoration-color'
   | 'text-decoration-line'
   | 'text-decoration-skip'
   | 'text-decoration-style'
   | 'text-indent'
   | 'text-justify'
   | 'text-overflow'
   | 'text-shadow'
   | 'text-transform'
   | 'text-underline-position'
   | 'top'
   | 'transform'
   | 'transform-origin'
   | 'transform-style'
   | 'transition'
   | 'transition-delay'
   | 'transition-duration'
   | 'transition-property'
   | 'transition-timing-function'
   | 'unicode-bidi'
   | 'vertical-align'
   | 'visibility'
   | 'white-space'
   | 'widows'
   | 'width'
   | 'will-change'
   | 'word-break'
   | 'word-spacing'
   | 'word-wrap'
   | 'writing-mode'
   | 'z-index'
   | '@import url(' //from css url 
   
   ;

ABSTRACT
   : 'abstract'
   ;

ASSERT
   : 'assert'
   ;

BOOLEAN
   : 'boolean'
   ;

BREAK
   : 'break'
   ;

BYTE
   : 'byte'
   ;

CASE
   : 'case'
   ;

CATCH
   : 'catch'
   ;

CHAR
   : 'char'
   ;

CLASS
   : 'class'
   ;

CONST
   : 'const'
   ;

CONTINUE
   : 'continue'
   ;

DEFAULT
   : 'default'
   ;

DO
   : 'do'
   ;

DOUBLE
   : 'double'
   ;

ELSE
   : 'else'
   ;

ENUM
   : 'enum'
   ;

EXTENDS
   : 'extends'
   ;

FINAL
   : 'final'
   ;

FINALLY
   : 'finally'
   ;

FLOAT
   : 'float'
   ;

FOR
   : 'for'
   ;

IF
   : 'if'
   ;

GOTO
   : 'goto'
   ;

IMPLEMENTS
   : 'implements'
   ;

IMPORT
   : 'import'
   ;

INSTANCEOF
   : 'instanceof'
   ;

INT
   : 'int'
   ;

INTERFACE
   : 'interface'
   ;

LONG
   : 'long'
   ;

NATIVE
   : 'native'
   ;

NEW
   : 'new'
   ;

PACKAGE
   : 'package'
   ;

PRIVATE
   : 'private'
   ;

PROTECTED
   : 'protected'
   ;

PUBLIC
   : 'public'
   ;

RETURN
   : 'return'
   ;

SHORT
   : 'short'
   ;

STATIC
   : 'static'
   ;

STRICTFP
   : 'strictfp'
   ;

SUPER
   : 'super'
   ;

SWITCH
   : 'switch'
   ;

SYNCHRONIZED
   : 'synchronized'
   ;

THIS
   : 'this'
   ;

THROW
   : 'throw'
   ;

THROWS
   : 'throws'
   ;

TRANSIENT
   : 'transient'
   ;

TRY
   : 'try'
   ;

VAR
   : 'var'
   ;

VOID
   : 'void'
   ;

VOLATILE
   : 'volatile'
   ;

WHILE
   : 'while'
   ;

LET
   : 'let'
   ;

YELD
   : 'yield'
   ;

FUNCTION
   : 'function'
   ;

DELETE
   : 'delete'
   ;

DEBUGGER
   : 'debugger'
   ;
   // Literals
   
DECIMAL_LITERAL
   : ('0' | [1-9] (Digits? | '_'+ Digits)) [lL]?
   ;

HEX_LITERAL
   : '0' [xX] [0-9a-fA-F] ([0-9a-fA-F_]* [0-9a-fA-F])? [lL]?
   ;

OCT_LITERAL
   : '0' '_'* [0-7] ([0-7_]* [0-7])? [lL]?
   ;

BINARY_LITERAL
   : '0' [bB] [01] ([01_]* [01])? [lL]?
   ;

FLOAT_LITERAL
   : (Digits '.' Digits? | '.' Digits) ExponentPart? [fFdD]?
   | Digits (ExponentPart [fFdD]? | [fFdD])
   ;

HEX_FLOAT_LITERAL
   : '0' [xX] (HexDigits '.'? | HexDigits? '.' HexDigits) [pP] [+-]? Digits [fFdD]?
   ;

BOOL_LITERAL
   : 'true'
   | 'false'
   ;
   //CHAR_LITERAL
   
   //   : '\'' (~ ['\\\r\n] | EscapeSequence) '\''
   
   //  ;
   
   //STRING_LITERAL
   
   //   : '"' (~ ["\\\r\n] | EscapeSequence)* '"'
   
   //  ;
   
STRING
   : '"' ~ [<"]* '"'
   | '\'' ~ [<']* '\''
   ;

NULL_LITERAL
   : 'null'
   ;
   // Separators
   
LPAREN
   : '('
   ;

RPAREN
   : ')'
   ;

LBRACE
   : '{'
   ;

RBRACE
   : '}'
   ;

LBRACK
   : '['
   ;

RBRACK
   : ']'
   ;

SEMI
   : ';'
   ;

COMMA
   : ','
   ;

DOT
   : '.'
   ;
   // Operators
   
ASSIGN
   : '='
   ;

GT
   : '>'
   ;

LT
   : '<'
   ;

BANG
   : '!'
   ;

TILDE
   : '~'
   ;

QUESTION
   : '?'
   ;

COLON
   : ':'
   ;

EQUAL
   : '=='
   ;

LE
   : '<='
   ;

GE
   : '>='
   ;

NOTEQUAL
   : '!='
   ;

AND
   : '&&'
   ;

OR
   : '||'
   ;

INC
   : '++'
   ;

DEC
   : '--'
   ;

ADD
   : '+'
   ;

SUB
   : '-'
   ;

MUL
   : '*'
   ;

DIV
   : '/'
   ;

BITAND
   : '&'
   ;

BITOR
   : '|'
   ;

CARET
   : '^'
   ;

MOD
   : '%'
   ;

ADD_ASSIGN
   : '+='
   ;

SUB_ASSIGN
   : '-='
   ;

MUL_ASSIGN
   : '*='
   ;

DIV_ASSIGN
   : '/='
   ;

AND_ASSIGN
   : '&='
   ;

OR_ASSIGN
   : '|='
   ;

XOR_ASSIGN
   : '^='
   ;

MOD_ASSIGN
   : '%='
   ;

LSHIFT_ASSIGN
   : '<<='
   ;

RSHIFT_ASSIGN
   : '>>='
   ;

URSHIFT_ASSIGN
   : '>>>='
   ;
   // Java 8 tokens
   
ARROW
   : '->'
   ;

COLONCOLON
   : '::'
   ;
   // Additional symbols not defined in the lexical specification
   
AT
   : '@'
   ;

ELLIPSIS
   : '...'
   ;
   // Whitespace and comments
   
WS
   : [ \t\r\n\u000C]+ -> channel (HIDDEN)
   ;

BLOCK_COMMENT
   : '/*' .*? '*/' -> channel (HIDDEN)
   ;

LINE_COMMENT
   : '//' ~ [\r\n]* -> channel (HIDDEN)
   ;
   // Identifiers
   
IDENTIFIER
   : Letter LetterOrDigit*
   ;
   // Fragment rules
   
fragment ExponentPart
   : [eE] [+-]? Digits
   ;

fragment EscapeSequence
   : '\\' [btnfr"'\\]
   | '\\' ([0-3]? [0-7])? [0-7]
   | '\\' 'u'+ HexDigit HexDigit HexDigit HexDigit
   ;

fragment HexDigits
   : HexDigit ((HexDigit | '_')* HexDigit)?
   ;

fragment HexDigit
   : [a-fA-F0-9]
   ;

fragment Digits
   : [0-9] ([0-9_]* [0-9])?
   ;

fragment LetterOrDigit
   : Letter
   | [0-9]
   ;

fragment Letter
   : [a-zA-Z$_] // these are the "java letters" below 0x7F
   | ~ [\u0000-\u007F\uD800-\uDBFF] // covers all characters above 0x7F which are not a surrogate
   | [\uD800-\uDBFF] [\uDC00-\uDFFF] // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
   
   ;
/*  
* <h1> hello </h1>
*/
   
   
SLASH_CLOSE
   : '/>'
   ;

OPEN_SLASH
   : '</'
   ;

DOLLAR
   : '$'
   ;

COLORSSS
   : 'aliceblue'
   | 'antiquewhite'
   | 'aquamarine'
   | 'azure'
   | 'beige'
   | 'bisque'
   | 'black'
   | 'blanchedalmond'
   | 'blue'
   | 'blueviolet'
   | 'brown'
   | 'burlywood'
   | 'cadetblue'
   | 'chartreuse'
   | 'chocolate'
   | 'coral'
   | 'cornflowerblue'
   | 'cornsilk'
   | 'crimson'
   | 'cyan'
   | 'darkblue'
   | 'darkcyan'
   | 'darkgoldenrod'
   | 'darkgrey'
   | 'darkgreen'
   | 'darkkhaki'
   | 'darkmagenta'
   | 'darkolivegreen'
   | 'darkorange'
   | 'darkorchid'
   | 'darkred'
   | 'darksalmon'
   | 'darkseagreen'
   | 'darkslateblue'
   | 'darkslategray'
   | 'darkturquoise'
   | 'darkviolet'
   | 'deeppink'
   | 'deepskyblue'
   | 'dimgray'
   | 'dodgerblue'
   | 'firebrick'
   | 'floralwhite'
   | 'forestgreen'
   | 'fuchsia'
   | 'gainsboro'
   | 'ghostwhite'
   | 'gold'
   | 'goldenrod'
   | 'grey'
   | 'green'
   | 'greenyellow'
   | 'cornflowerblue'
   | 'honeydew'
   | 'hotpink'
   | 'indianred'
   | 'indigo'
   | 'ivory'
   | 'khaki'
   | 'lavender'
   | 'lavenderblush'
   | 'lawngreen'
   | 'lemonchiffon'
   | 'lightblue'
   | 'lightcoral'
   | 'lightcyan'
   | 'lightgoldenrodyellow'
   | 'lightgray'
   ;

CHATREF
   : '#' HexDigit+
   ;

