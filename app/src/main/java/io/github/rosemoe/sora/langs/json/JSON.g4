lexer grammar JSON;

LBRACE
   : '{'
   | '['
   ;

RBRACE
   : '}'
   | ']'
   ;

COLON
   : ':'
   ;

OPEN_QUOTE
   : '"'
   ;

TEXT
   : [a-zA-Z0-9]+
   ;

WS
   : [\t\r\n]+ -> skip
   ;

HEXCOLOR
   : [a-fA-F-0-9]+
   ;

TRUE
   : 'true'
   ;

FALSE
   : 'false'
   ;

NULL
   : 'null'
   ;

