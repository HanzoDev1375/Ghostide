lexer grammar YAMLLexer;

STRING
   : '\'' ('\'\'' | ~ ['])* '\''
   | '"' ('\\' . | ~ ["\\])* '"'
   ;

COMMENT
   : '#' ~ [\n]* -> skip
   ;

TRUE
   : 'true'
   ;

FALSE
   : 'false'
   ;

NULL
   : 'null'
   | '~'
   ;

ANCHOR
   : '&' ID
   ;

ALIAS
   : '*' ID
   ;

NUMBER
   : [0-9]+
   ;

COLON
   : ':'
   ;

DASH
   : '-'
   ;

COMMA
   : ','
   ;

LBRACE
   : '{'
   ;

RBRACE
   : '}'
   ;

ID
   : [a-zA-Z_] [a-zA-Z0-9_]*
   ;

WS
   : [ \t\r\n]+ -> skip
   ;
