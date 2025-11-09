lexer grammar Dart2LexerCompat;
// =====================

// Operators & Symbols

// =====================

AA
   : '&&'
   ;

PP
   : '||'
   ;

QUQUEQ
   : '??='
   ;

QUQU
   : '??'
   ;

DDDQ
   : '...?'
   ;

DDD
   : '...'
   ;

DD
   : '..'
   ;

PLPL
   : '++'
   ;

MM
   : '--'
   ;

LTLTE
   : '<<='
   ;

LTLT
   : '<<'
   ;

CIRE
   : '^='
   ;

POE
   : '|='
   ;

AE
   : '&='
   ;

PLE
   : '+='
   ;

ME
   : '-='
   ;

STE
   : '*='
   ;

SE
   : '/='
   ;

SQSE
   : '~/='
   ;

EE
   : '=='
   ;

NE
   : '!='
   ;

LTE
   : '<='
   ;

GT
   : '>'
   ;

LT
   : '<'
   ;

EG
   : '=>'
   ;

EQ
   : '='
   ;

QUDD
   : '?..'
   ;

QUD
   : '?.'
   ;

QU
   : '?'
   ;

PL
   : '+'
   ;

MINUS
   : '-'
   ;

ST
   : '*'
   ;

SL
   : '/'
   ;

SQS
   : '~/'
   ;

SQUIG
   : '~'
   ;

PO
   : '#'
   ;

P
   : '|'
   ;

A
   : '&'
   ;

CIR
   : '^'
   ;

PC
   : '%'
   ;

OB
   : '['
   ;

CB
   : ']'
   ;

OBC
   : '{'
   ;

CBC
   : '}'
   ;

OP
   : '('
   ;

CP
   : ')'
   ;

SC
   : ';'
   ;

CO
   : ':'
   ;

C
   : ','
   ;

AT
   : '@'
   ;

D
   : '.'
   ;
   // =====================
   
   // Keywords
   
   // =====================
   
ABSTRACT_
   : 'abstract'
   ;

AS_
   : 'as'
   ;

ASSERT_
   : 'assert'
   ;

ASYNC_
   : 'async'
   ;

AWAIT_
   : 'await'
   ;

BREAK_
   : 'break'
   ;

CASE_
   : 'case'
   ;

CATCH_
   : 'catch'
   ;

CLASS_
   : 'class'
   ;

CONST_
   : 'const'
   ;

CONTINUE_
   : 'continue'
   ;

COVARIANT_
   : 'covariant'
   ;

DEFAULT_
   : 'default'
   ;

DEFERRED_
   : 'deferred'
   ;

DO_
   : 'do'
   ;

DYNAMIC_
   : 'dynamic'
   ;

ELSE_
   : 'else'
   ;

ENUM_
   : 'enum'
   ;

EXPORT_
   : 'export'
   ;

EXTENDS_
   : 'extends'
   ;

EXTENSION_
   : 'extension'
   ;

EXTERNAL_
   : 'external'
   ;

FACTORY_
   : 'factory'
   ;

FALSE_
   : 'false'
   ;

FINAL_
   : 'final'
   ;

FINALLY_
   : 'finally'
   ;

FOR_
   : 'for'
   ;

FUNCTION_
   : 'Function'
   ;

GET_
   : 'get'
   ;

HIDE_
   : 'hide'
   ;

IF_
   : 'if'
   ;

IMPLEMENTS_
   : 'implements'
   ;

IMPORT_
   : 'import'
   ;

IN_
   : 'in'
   ;

INTERFACE_
   : 'interface'
   ;

IS_
   : 'is'
   ;

LATE_
   : 'late'
   ;

LIBRARY_
   : 'library'
   ;

MIXIN_
   : 'mixin'
   ;

NATIVE_
   : 'native'
   ;

NEW_
   : 'new'
   ;

NULL_
   : 'null'
   ;

ON_
   : 'on'
   ;

OPERATOR_
   : 'operator'
   ;

PART_
   : 'part'
   ;

REQUIRED_
   : 'required'
   ;

RETHROW_
   : 'rethrow'
   ;

RETURN_
   : 'return'
   ;

SET_
   : 'set'
   ;

SHOW_
   : 'show'
   ;

STATIC_
   : 'static'
   ;

SUPER_
   : 'super'
   ;

SWITCH_
   : 'switch'
   ;

SYNC_
   : 'sync'
   ;

THIS_
   : 'this'
   ;

THROW_
   : 'throw'
   ;

TRUE_
   : 'true'
   ;

TRY_
   : 'try'
   ;

TYPEDEF_
   : 'typedef'
   ;

VAR_
   : 'var'
   ;

VOID_
   : 'void'
   ;

WHILE_
   : 'while'
   ;

WITH_
   : 'with'
   ;

YIELD_
   : 'yield'
   ;
   // =====================
   
   // Literals
   
   // =====================
   
   // String literals: single-line, multi-line, raw
   
STRING
   : 'r'? '"' ('\\' . | ~ ["\\\r\n])* '"'
   | 'r'? '\'' ('\\' . | ~ ['\\\r\n])* '\''
   | 'r'? '"""' ('\\' . | ~ ["\\])*? '"""'
   | 'r'? '\'\'\'' ('\\' . | ~ ['\\])*? '\'\'\''
   ;
   // Numbers: int, double
   
NUMBER
   : DIGIT+ ('.' DIGIT+ ([eE] [+\-]? DIGIT+)?)?
   | '.' DIGIT+ ([eE] [+\-]? DIGIT+)?
   | DIGIT+ [eE] [+\-]? DIGIT+
   ;
   // Identifier
   
IDENTIFIER
   : Letter LetterOrDigit*
   ;
   // =====================
   
   // Comments & Whitespace
   
   // =====================
   
SINGLE_LINE_COMMENT
   : '//' ~ [\r\n]* -> skip
   ;

MULTI_LINE_COMMENT
   : '/*' .*? '*/' -> skip
   ;

WHITESPACE
   : [ \t\r\n\u000C]+ -> channel (HIDDEN)
   ;
   // =====================
   
   // Fragments
   
   // =====================
   
fragment DIGIT
   : [0-9]
   ;

fragment Letter
   : [a-zA-Z$_]
   | [\p{L}]
   ;

fragment LetterOrDigit
   : Letter
   | DIGIT
   ;
