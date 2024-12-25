grammar Ninja;
// Parser Rules

install
   : EOF? # installRule
   ;

forsteament
   : For '(' Index ')' '{' # forStatement
   ;

ifsteament
   : If '(' Index ')' '{' # ifStatementWithBlock
   | If '(' Index ')' # ifStatementWithoutBlock
   ;

pwdstemant
   : Pwd Index '?' Index ':' # pwdStatement
   ;

coordinatedstemant
   : Coordinated '?(' Index 'apply' ')' '!' # coordinatedStatement
   ;

setstement
   : Set At Index # setStatement
   ;

getstement
   : Get Index # getStatementWithoutCall
   | Get '(' Index ')' '!' # getStatementWithCall
   ;

classorinterfacePaser
   : Class WS Index '{' # classStatement
   | Interface WS Index '{' # interfaceStatement
   ;

trystemant
   : Try WS '{' # tryStatementWithBlock
   | Try '{' # tryStatementWithoutBlock
   ;

hanlderstemant
   : Handler '(' Index ')' # handlerStatement
   ;

asloruner
   : Dot+ Aslo '{' # aslomod
   ;

runruner
   : Dot+ Run '{' # runmod
   ;

applyruner
   : Dot+ Apply '{' # applymod
   ;

hashcomment
   : Hash Index # hashCoommentModel
   ;

opentagid
   : OpenTag Index
   ;
   // Keywords
   
WS
   : [ \t\n\r]+ -> skip // Skip whitespace characters
   
   ;

Dot
   : '.'
   ;

Public
   : 'public'
   ;

For
   : 'for'
   ;

If
   : 'if'
   ;

Pwd
   : 'pwd'
   ;

Coordinated
   : 'coordinated'
   ;

fragment Number
   : [0-9]
   ;

fragment Name
   : [a-zA-Z]
   ;

Index
   : Name Number* // Index rule for variable names
   
   ;

Get
   : 'get'
   ;

Set
   : 'set'
   ;

At
   : '@'
   ;

Class
   : 'class'
   ;

Interface
   : 'interface'
   ;

Try
   : 'try'
   ;

Handler
   : 'handler'
   ;

Apply
   : 'apply'
   ;

Aslo
   : 'aslo'
   ;

Run
   : 'run'
   ;

Hash
   : '#'
   ;

OpenTag
   : '<'
   ;

