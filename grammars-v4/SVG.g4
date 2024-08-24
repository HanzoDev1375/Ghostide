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
   : '"' (ESC | ~ ["\\])* '"'
   ;

fragment ESC
   : '\\' ["\\/bfnrt]
   ; // Escape sequences (like \n, \", etc.)
   
   // Rule to match names (tags and attributes)
   
NAME
   : [a-zA-Z_] [a-zA-Z0-9_]*
   ;
   // Skip whitespace
   
WS
   : [ \t\n\r]+ -> skip
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
   : '#' [a-fA-F0-9]*
   ;

Comment
   : '<-!- ' .*? '-->' -> skip
   ;

