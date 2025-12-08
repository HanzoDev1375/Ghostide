lexer grammar MarkDownLexer;

LANGTYPE
   : '```' [ \t]* [\n\r] [.\r\b]* '```'
   ;

WS
   : [ \t\r\n\u000C]+ -> channel (HIDDEN)
   ;

LinkLiteral
   : ('http' 's'? | 'ftp' | 'file' | 'content') '://' [a-zA-Z0-9./?=]+
   ;

HEADER1
   : '#'
   ;

HEADER2
   : '##'
   ;

HEADER3
   : '###'
   ;

HEADER4
   : '####'
   ;

HEADER5
   : '#####'
   ;

HEADER6
   : '######'
   ;

BACKTIKMASER
   : '`' .*? '`'
   ;

BOXOFF
   : '[ ]'
   ;

BOXON
   : '[x]'
   ;

POSTER
   : '-'
   ;

HADER
   : '---'
   ;

BOLD
   : '**' ID '**'
   ;

ITALIC
   : '*' ID '*'
   ;

Equal
   : '='
   ;

OPENBRACKET
   : '['
   ;

CLOSEBARCKET
   : ']'
   ;

OPENPARENTHESES
   : '('
   ;

CLOSEDPARENTHESES
   : ')'
   ;

LINK
   : OPENPARENTHESES ID CLOSEDPARENTHESES OPENBRACKET LinkLiteral CLOSEBARCKET
   ;

LINKMASET
   : '!' OPENPARENTHESES ID CLOSEDPARENTHESES OPENBRACKET LinkLiteral CLOSEBARCKET
   ;

STRING
   : '"' .*? '"'
   | '\'' .*? '\''
   ;

BLACKLINE
   : '~'
   ;

HTMLOPEN
   : '<'
   ;

HTMLCLOSE
   : '>'
   ;

SLASH
   : '/'
   ;

ID
   : Letter LetterOrDigit+
   ;

fragment LetterOrDigit
   : Letter
   | [0-9]
   ;

fragment Letter
   : [a-zA-Z$_\-]
   | ~ [\u0000-\u007F\uD800-\uDBFF]
   | [\uD800-\uDBFF] [\uDC00-\uDFFF]
   ;

