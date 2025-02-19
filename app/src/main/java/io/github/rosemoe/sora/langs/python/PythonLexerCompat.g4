lexer grammar PythonLexerCompat;

LPAR
   : '('
   ; // OPEN_PAREN
   
LSQB
   : '['
   ; // OPEN_BRACK
   
LBRACE
   : '{'
   ; // OPEN_BRACE
   
RPAR
   : ')'
   ; // CLOSE_PAREN
   
RSQB
   : ']'
   ; // CLOSE_BRACK
   
RBRACE
   : '}'
   ; // CLOSE_BRACE
   
DOT
   : '.'
   ;

COLON
   : ':'
   ;

COMMA
   : ','
   ;

SEMI
   : ';'
   ;

PLUS
   : '+'
   ;

MINUS
   : '-'
   ;

STAR
   : '*'
   ;

SLASH
   : '/'
   ;

VBAR
   : '|'
   ;

AMPER
   : '&'
   ;

LESS
   : '<'
   ;

GREATER
   : '>'
   ;

EQUAL
   : '='
   ;

PERCENT
   : '%'
   ;

EQEQUAL
   : '=='
   ;

NOTEQUAL
   : '!='
   ;

LESSEQUAL
   : '<='
   ;

GREATEREQUAL
   : '>='
   ;

TILDE
   : '~'
   ;

CIRCUMFLEX
   : '^'
   ;

LEFTSHIFT
   : '<<'
   ;

RIGHTSHIFT
   : '>>'
   ;

DOUBLESTAR
   : '**'
   ;

PLUSEQUAL
   : '+='
   ;

MINEQUAL
   : '-='
   ;

STAREQUAL
   : '*='
   ;

SLASHEQUAL
   : '/='
   ;

PERCENTEQUAL
   : '%='
   ;

AMPEREQUAL
   : '&='
   ;

VBAREQUAL
   : '|='
   ;

CIRCUMFLEXEQUAL
   : '^='
   ;

LEFTSHIFTEQUAL
   : '<<='
   ;

RIGHTSHIFTEQUAL
   : '>>='
   ;

DOUBLESTAREQUAL
   : '**='
   ;

DOUBLESLASH
   : '//'
   ;

DOUBLESLASHEQUAL
   : '//='
   ;

AT
   : '@'
   ;

ATEQUAL
   : '@='
   ;

RARROW
   : '->'
   ;

ELLIPSIS
   : '...'
   ;

COLONEQUAL
   : ':='
   ;

EXCLAMATION
   : '!'
   ;
   // https://docs.python.org/3.13/reference/lexical_analysis.html#keywords
   
FALSE
   : 'False'
   ;

AWAIT
   : 'await'
   ;

ELSE
   : 'else'
   ;

IMPORT
   : 'import'
   ;

PASS
   : 'pass'
   ;

NONE
   : 'None'
   ;

BREAK
   : 'break'
   ;

EXCEPT
   : 'except'
   ;

IN
   : 'in'
   ;

RAISE
   : 'raise'
   ;

TRUE
   : 'True'
   ;

CLASS
   : 'class'
   ;

FINALLY
   : 'finally'
   ;

IS
   : 'is'
   ;

RETURN
   : 'return'
   ;

AND
   : 'and'
   ;

CONTINUE
   : 'continue'
   ;

FOR
   : 'for'
   ;

LAMBDA
   : 'lambda'
   ;

TRY
   : 'try'
   ;

AS
   : 'as'
   ;

DEF
   : 'def'
   ;

FROM
   : 'from'
   ;

NONLOCAL
   : 'nonlocal'
   ;

WHILE
   : 'while'
   ;

ASSERT
   : 'assert'
   ;

DEL
   : 'del'
   ;

GLOBAL
   : 'global'
   ;

NOT
   : 'not'
   ;

WITH
   : 'with'
   ;

ASYNC
   : 'async'
   ;

ELIF
   : 'elif'
   ;

IF
   : 'if'
   ;

OR
   : 'or'
   ;

YIELD
   : 'yield'
   ;
   // *** Soft Keywords: https://docs.python.org/3.13/reference/lexical_analysis.html#soft-keywords
   
NAME_OR_TYPE
   : 'type'
   ; // identifier or type keyword,    the parser grammar will decide what it means
   
NAME_OR_MATCH
   : 'match'
   ; // identifier or match keyword,   the parser grammar will decide what it means
   
NAME_OR_CASE
   : 'case'
   ; // identifier or case keyword,    the parser grammar will decide what it means
   
NAME_OR_WILDCARD
   : '_'
   ; // identifier or wildcard symbol, the parser grammar will decide what it means
   
STRING
   : '"' .*? '"'
   | '"""' .*? '"""'
   | '\'\'\'' .*? '\'\'\''
   | '\'' .*? '\''
   ;
   // https://docs.python.org/3.13/reference/lexical_analysis.html#physical-lines
   
fragment Digits
   : [0-9] ([0-9_]* [0-9])?
   ;

NUMBER
   : Digits
   ;

FSTRING
   : 'f' '\'' .*? '${' IDENTIFIER '}' '\''
   ;

NEWLINE
   : '\r'? '\n'
   ; // Unix, Windows
   
   // https://docs.python.org/3.13/reference/lexical_analysis.html#comments
   
COMMENT
   : '#' ~ [\r\n]* -> channel (HIDDEN)
   ;
   // https://docs.python.org/3.13/reference/lexical_analysis.html#whitespace-between-tokens
   
WS
   : [ \t\f]+ -> channel (HIDDEN)
   ;

ERRORTOKEN
   : .
   ; // PythonLexerBase class will report an error about this (the ERRORTOKEN will also cause an error in the parser)
   
/*
 *  other lexer modes
 */
   
   
IDENTIFIER
   : Letter LetterOrDigit*
   ;

fragment LetterOrDigit
   : Letter
   | [0-9]
   ;

fragment Letter
   : [a-zA-Z] // these are the "java letters" below 0x7F
   | ~ [\u0000-\u007F\uD800-\uDBFF] // covers all characters above 0x7F which are not a surrogate
   | [\uD800-\uDBFF] [\uDC00-\uDFFF] // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
   
   ;

