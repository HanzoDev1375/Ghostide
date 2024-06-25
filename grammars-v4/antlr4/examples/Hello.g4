// define a grammar called Hello

lexer grammar Hello;


ID
   : [a-z]+
   ;

WS
   : [ \t\r\n]+ -> skip
   ;

