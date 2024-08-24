grammar SVG;
// Rule for the SVG document

svg
   : header element* footer
   ;
   // Header of the SVG document
   
header
   : '<svg' attributes? '>'
   ;
   // Footer of the SVG document
   
footer
   : '</svg>'
   ;
   // Elements that can appear inside the SVG
   
element
   : circle
   | rectangle
   | line
   | text
   ;
   // Definition for circle element
   
circle
   : '<circle' attributes? '/>'
   ;
   // Definition for rectangle element
   
rectangle
   : '<rect' attributes? '/>'
   ;
   // Definition for line element
   
line
   : '<line' attributes? '/>'
   ;
   // Definition for text element
   
text
   : '<text' attributes? '>' STRING '</text>'
   ;
   // Attributes common to SVG elements
   
attributes
   : (attribute)+
   ;
   // Individual attribute definition
   
attribute
   : NAME '=' STRING
   ;
   // String definition
   
STRING
   : '"' ~ [<"]* '"'
   | '\'' ~ [<']* '\''
   ;

NAME
   : Letter LetterOrDigit*
   ;
   // Skip whitespace
   
WS
   : [ \t\r\n\u000C]+ -> channel (HIDDEN)
   ;
   //<svg> </svg>
   
SYIN
   : '<'
   ;

SYMIN
   : '>'
   ;

SYOU
   : '/>'
   ;

ASSES
   : '='
   ;

HEXCOLOR
   : '#' HexDigit+
   ;

Comment
   : '<-!- ' .*? '-->' -> skip
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

fragment HexDigit
   : [a-fA-F0-9]
   ;