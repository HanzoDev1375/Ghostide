grammar Javacc;

LOOKAHEAD
   : 'LOOKAHEAD'
   ;

IGNORE_CASE
   : 'IGNORE_CASE'
   ;

PARSER_BEGIN
   : 'PARSER_BEGIN'
   ;

PARSER_END
   : 'PARSER_END'
   ;

JAVACODE
   : 'JAVACODE'
   ;

CPPCODE
   : 'CPPCODE'
   ;

TOKEN
   : 'TOKEN'
   ;

SPECIAL_TOKEN
   : 'SPECIAL_TOKEN'
   ;

MORE_
   : 'MORE'
   ;

SKIP_
   : 'SKIP'
   ;

TOKEN_MGR_DECLS
   : 'TOKEN_MGR_DECLS'
   ;

EOF_
   : 'EOF'
   ;

DCL_PARSER_BEGIN
   : 'DCL_PARSER_BEGIN'
   ;

DCL_PARSER_END
   : 'DCL_PARSER_END'
   ;

INC_PARSER_BEGIN
   : 'INC_PARSER_BEGIN'
   ;

INC_PARSER_END
   : 'INC_PARSER_END'
   ;

DEF_PARSER_BEGIN
   : 'DEF_PARSER_BEGIN'
   ;

DEF_PARSER_END
   : 'DEF_PARSER_END'
   ;
/* WHITE SPACE */
   
   
WS
   : (' ' | '\t' | '\n' | '\r' | '\f' | '/*@egen*/') -> channel (HIDDEN)
   ;
/* COMMENTS */
   
   
COMMENT
   : '/*' .*? '*/' -> channel (HIDDEN)
   ;

LINE_COMMENT
   : '//' ~ [\r\n]* -> channel (HIDDEN)
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

FALSE
   : 'false'
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

GOTO
   : 'goto'
   ;

IF
   : 'if'
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

NULL
   : 'null'
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

TRUE
   : 'true'
   ;

TRY
   : 'try'
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

TEMPLATE
   : 'template'
   ;

TYPENAME
   : 'typename'
   ;

INTEGER_LITERAL
   : DECIMAL_LITERAL [lL]?
   | HEX_LITERAL [lL]?
   | OCTAL_LITERAL [lL]?
   | BINARY_LITERAL [lL]?
   ;

DECIMAL_LITERAL
   : [1-9] (('_')* [0-9])*
   ;

HEX_LITERAL
   : '0' [xX] [0-9a-fA-F] (('_')* [0-9a-fA-F])*
   ;

OCTAL_LITERAL
   : '0' (('_')* [0-7])*
   ;

BINARY_LITERAL
   : '0' [bB] [01] (('_')* [01])*
   ;

FLOATING_POINT_LITERAL
   : DECIMAL_FLOATING_POINT_LITERAL
   | HEXADECIMAL_FLOATING_POINT_LITERAL
   ;

DECIMAL_FLOATING_POINT_LITERAL
   : [0-9] (('_')* [0-9])* '.' ([0-9] (('_')* [0-9])*)? DECIMAL_EXPONENT? ([fFdD])?
   | '.' [0-9] (('_')* [0-9])* DECIMAL_EXPONENT? ([fFdD])?
   | [0-9] (('_')* [0-9])* DECIMAL_EXPONENT ([fFdD])?
   | [0-9] (('_')* [0-9])* DECIMAL_EXPONENT? [fFdD]
   ;

DECIMAL_EXPONENT
   : [eE] ([+-])? [0-9] (('_')* [0-9])*
   ;

HEXADECIMAL_FLOATING_POINT_LITERAL
   : '0' [xX] [0-9a-fA-F] (('_')* [0-9a-fA-F])* ('.')? HEXADECIMAL_EXPONENT ([fFdD])?
   | '0' [xX] ([0-9a-fA-F] (('_')* [0-9a-fA-F])*)? '.' [0-9a-fA-F] (('_')* [0-9a-fA-F])* HEXADECIMAL_EXPONENT ([fFdD])?
   ;

HEXADECIMAL_EXPONENT
   : [pP] ([+-])? [0-9] (('_')* [0-9])*
   ;

CHARACTER_LITERAL
   : '\'' (~ ['\\\n\r] | '\\' ([ntbrf\\'"] | [0-7] [0-7]? | [0-3] [0-7] [0-7])) '\''
   ;

STRING_LITERAL
   : '"' (~ ["\\\n\r] | '\\' ([ntbrf\\'"] | 'u' [0-9a-fA-F] [0-9a-fA-F]? [0-9a-fA-F]? [0-9a-fA-F]? | [0-7] | [0-3] [0-7] [0-7]))* '"'
   ;
/* SEPARATORS */
   
   
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

LBRACKET
   : '['
   ;

RBRACKET
   : ']'
   ;

SEMICOLON
   : ';'
   ;

COMMA
   : ','
   ;

DOT
   : '.'
   ;

ASSIGN
   : '='
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

HOOK
   : '?'
   ;

COLON
   : ':'
   ;

DOUBLECOLON
   : '::'
   ;

EQ
   : '=='
   ;

LE
   : '<='
   ;

GE
   : '>='
   ;

NE
   : '!='
   ;

SC_OR
   : '||'
   ;

SC_AND
   : '&&'
   ;

INCR
   : '++'
   ;

DECR
   : '--'
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

BIT_AND
   : '&'
   ;

BIT_OR
   : '|'
   ;

XOR
   : '^'
   ;

REM
   : '%'
   ;

PLUSASSIGN
   : '+='
   ;

MINUSASSIGN
   : '-='
   ;

STARASSIGN
   : '*='
   ;

SLASHASSIGN
   : '/='
   ;

ANDASSIGN
   : '&='
   ;

ORASSIGN
   : '|='
   ;

XORASSIGN
   : '^='
   ;

REMASSIGN
   : '%='
   ;
   //RUNSIGNEDSHIFT: '>>>';
   
runsignedshift
   : GT GT GT
   ;
   //RSIGNEDSHIFT: '>>';
   
rsignedshift
   : GT GT
   ;

GT
   : '>'
   ;

IDENTIFIER
   : Letter LetterOrDigit*
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

javacc_input
   : javacc_options 'PARSER_BEGIN' '(' identifier ')' compilationUnit 'PARSER_END' '(' identifier ')' production+ EOF
   ;

javacc_options
   : (IDENTIFIER '{' option_binding* '}')?
   ;

option_binding
   : (IDENTIFIER | 'LOOKAHEAD' | 'IGNORE_CASE' | 'static' | 'PARSER_BEGIN') '=' (integerLiteral | booleanLiteral | stringLiteral | stringList) ';'
   ;

stringList
   : '(' stringLiteral (',' stringLiteral)* ')'
   ;

production
   : javacode_production
   | cppcode_production
   | regular_expr_production
   | token_manager_decls
   | bnf_production
   ;

javacode_production
   : 'JAVACODE' resultType identifier formalParameters ('throws' name (',' name)*)? node_descriptor? block
   ;

cppcode_production
   : 'CPPCODE' accessModifier resultType identifier formalParameters ('throws' name (',' name)*)? block
   ;

bnf_production
   : resultType identifier formalParameters ('throws' name (',' name)*)? node_descriptor? ':' block '{' expansion_choices '}'
   ;

accessModifier
   : ('public' | 'protected' | 'private')?
   ;

regular_expr_production
   : ('<' '*' '>' | '<' IDENTIFIER (',' IDENTIFIER)* '>')? regexpr_kind ('[' 'IGNORE_CASE' ']')? ':' '{' regexpr_spec ('|' regexpr_spec)* '}'
   ;

token_manager_decls
   : 'TOKEN_MGR_DECLS' ':' (classOrInterfaceBody)?
   ;

regexpr_kind
   : 'TOKEN'
   | 'SPECIAL_TOKEN'
   | 'SKIP'
   | 'MORE'
   ;

regexpr_spec
   : regular_expression (block)? (':' IDENTIFIER)?
   ;

expansion_choices
   : expansion ('|' expansion)*
   ;

expansion
   : ('LOOKAHEAD' '(' local_lookahead ')')? (expansion_unit node_descriptor?)+
   ;

local_lookahead
   : (integerLiteral)? (',')? (expansion_choices)? (',')? ('{' (expression)? '}')?
   ;

expansion_unit
   : 'LOOKAHEAD' '(' local_lookahead ')'
   | block
   | '[' expansion_choices ']'
   | 'try' '{' expansion_choices '}' ('catch' '(' (name IDENTIFIER)? ')' block)* ('finally' block)?
   | (primaryExpression '=')? (identifier (typeArguments)? arguments | regular_expression ('.' IDENTIFIER)?)
   | '(' expansion_choices ')' ('+' | '*' | '?')?
   ;

regular_expression
   : stringLiteral
   | LT (('#')? identifier ':')? complex_regular_expression_choices GT
   | '<' identifier '>'
   | '<' 'EOF' '>'
   ;

complex_regular_expression_choices
   : complex_regular_expression ('|' complex_regular_expression)*
   ;

complex_regular_expression
   : (complex_regular_expression_unit)+
   ;

complex_regular_expression_unit
   : stringLiteral
   | '<' identifier '>'
   | character_list
   | '(' complex_regular_expression_choices ')' ('+' | '*' | '?' | '{' integerLiteral (',' (integerLiteral)?)? '}')?
   ;

character_list
   : ('~')? '[' (character_descriptor (',' character_descriptor)*)? ']'
   ;

character_descriptor
   : stringLiteral ('-' stringLiteral)?
   ;

identifier
   : IDENTIFIER
   ;

node_descriptor
   : '#' (IDENTIFIER | VOID) ('(' '>'? node_descriptor_expression ')')?
   ;

node_descriptor_expression
   : (~ '(')*
   | '(' node_descriptor_expression ')'
   ;

javaIdentifier
   : (IDENTIFIER | 'LOOKAHEAD' | 'IGNORE_CASE' | 'PARSER_BEGIN' | 'PARSER_END' | 'JAVACODE' | 'TOKEN' | 'SPECIAL_TOKEN' | 'MORE' | 'SKIP' | 'TOKEN_MGR_DECLS' | 'EOF' | 'template' | 'DCL_PARSER_BEGIN' | 'DCL_PARSER_END' | 'INC_PARSER_BEGIN' | 'INC_PARSER_END' | 'DEF_PARSER_BEGIN' | 'DEF_PARSER_END')
   ;

compilationUnit
   : (packageDeclaration)? (importDeclaration)* (typeDeclaration)*
   ;

packageDeclaration
   : modifiers 'package' name ';'
   ;

importDeclaration
   : 'import' ('static')? name ('.' '*')? ';'
   ;

modifiers
   : (('public' | 'static' | 'protected' | 'private' | 'final' | 'abstract' | 'synchronized' | 'native' | 'transient' | 'volatile' | 'strictfp' | annotation))*
   ;

typeDeclaration
   : ';'
   | modifiers (classOrInterfaceDeclaration | enumDeclaration | annotationTypeDeclaration)
   ;

classOrInterfaceDeclaration
   : ('class' | 'interface') javaIdentifier typeParameters? extendsList? implementsList? classOrInterfaceBody
   ;

extendsList
   : 'extends' classOrInterfaceType (',' classOrInterfaceType)*
   ;

implementsList
   : 'implements' classOrInterfaceType (',' classOrInterfaceType)*
   ;

enumDeclaration
   : 'enum' javaIdentifier (implementsList)? enumBody
   ;

enumBody
   : '{' (enumConstant (',' enumConstant)*)? (',')? (';' (classOrInterfaceBodyDeclaration)*)? '}'
   ;

enumConstant
   : modifiers javaIdentifier arguments? classOrInterfaceBody?
   ;

typeParameters
   : '<' typeParameter (',' typeParameter)* '>'
   ;

typeParameter
   : javaIdentifier typeBound?
   ;

typeBound
   : 'extends' classOrInterfaceType ('&' classOrInterfaceType)*
   ;

classOrInterfaceBody
   : '{' classOrInterfaceBodyDeclaration* '}'
   ;

classOrInterfaceBodyDeclaration
   : initializer
   | modifiers (classOrInterfaceDeclaration | enumDeclaration | constructorDeclaration | fieldDeclaration | methodDeclaration)
   | ';'
   ;

fieldDeclaration
   : type variableDeclarator (',' variableDeclarator)* ';'
   ;

variableDeclarator
   : variableDeclaratorId ('=' variableInitializer)?
   ;

variableDeclaratorId
   : javaIdentifier ('[' ']')*
   ;

variableInitializer
   : arrayInitializer
   | expression
   ;

arrayInitializer
   : '{' (variableInitializer (',' variableInitializer)*)? (',')? '}'
   ;

methodDeclaration
   : typeParameters? resultType methodDeclarator ('throws' nameList)? (block | ';')
   ;

methodDeclarator
   : javaIdentifier formalParameters ('[' ']')*
   ;

formalParameters
   : '(' (formalParameter (',' formalParameter)*)? ')'
   ;

formalParameter
   : modifiers type (('&' | '*') | '...')? variableDeclaratorId
   ;

constructorDeclaration
   : typeParameters? javaIdentifier formalParameters ('throws' nameList)? '{' explicitConstructorInvocation? blockStatement* '}'
   ;

explicitConstructorInvocation
   : 'this' arguments ';'
   | (primaryExpression '.')? 'super' arguments ';'
   ;

initializer
   : ('static')? block
   ;

type
   : referenceType
   | primitiveType
   ;

referenceType
   : primitiveType ('[' ']')+
   | (template? classOrInterfaceType) ('[' ']')*
   ;

template
   : 'template' '<' templateBase (',' templateBase)* '>'
   ;

templateBase
   : templatePack '...'? IDENTIFIER
   ;

templatePack
   : 'class'
   | 'typename'
   ;

classOrInterfaceType
   : ('::')? IDENTIFIER typeArguments? (('.' | '::') IDENTIFIER typeArguments?)*
   ;

typeArguments
   : '<' (typeArgument (',' typeArgument ('...')?)*)? '>'
   ;

typeArgument
   : referenceType
   | '?' wildcardBounds?
   ;

wildcardBounds
   : 'extends' referenceType
   | 'super' referenceType
   ;

primitiveType
   : 'boolean'
   | 'char'
   | 'byte'
   | 'short'
   | 'int'
   | 'long'
   | 'float'
   | 'double'
   ;

resultType
   : ('void' ('*')? | ('const')? type ('*' | '&')?)
   ;

name
   : javaIdentifier ('.' javaIdentifier)*
   ;

nameList
   : name (',' name)*
   ;

expression
   : conditionalExpression (assignmentOperator expression)?
   ;

assignmentOperator
   : '='
   | '*='
   | '/='
   | '%='
   | '+='
   | '-='
   | '<<='
   | '>>='
   | '>>>='
   | '&='
   | '^='
   | '|='
   ;

conditionalExpression
   : conditionalOrExpression ('?' expression ':' expression)?
   ;

conditionalOrExpression
   : conditionalAndExpression ('||' conditionalAndExpression)*
   ;

conditionalAndExpression
   : inclusiveOrExpression ('&&' inclusiveOrExpression)*
   ;

inclusiveOrExpression
   : exclusiveOrExpression ('|' exclusiveOrExpression)*
   ;

exclusiveOrExpression
   : andExpression ('^' andExpression)*
   ;

andExpression
   : equalityExpression ('&' equalityExpression)*
   ;

equalityExpression
   : instanceOfExpression (('==' | '!=') instanceOfExpression)*
   ;

instanceOfExpression
   : relationalExpression ('instanceof' type)?
   ;

relationalExpression
   : shiftExpression (('<' | '>' | '<=' | '>=') shiftExpression)*
   ;

shiftExpression
   : additiveExpression (('<<' | rsignedshift | runsignedshift) additiveExpression)*
   ;

additiveExpression
   : multiplicativeExpression (('+' | '-') multiplicativeExpression)*
   ;

multiplicativeExpression
   : unaryExpression (('*' | '/' | '%') unaryExpression)*
   ;

unaryExpression
   : ('+' | '-') unaryExpression
   | preIncrementExpression
   | preDecrementExpression
   | unaryExpressionNotPlusMinus
   ;

preIncrementExpression
   : '++' primaryExpression
   ;

preDecrementExpression
   : '--' primaryExpression
   ;

unaryExpressionNotPlusMinus
   : ('~' | '!') unaryExpression
   | castExpression
   | postfixExpression
   ;

castLookahead
   : '(' primitiveType
   | '(' type '[' ']'
   | '(' type ')' ('~' | '!' | '(' | javaIdentifier | 'this' | 'super' | 'new' | literal)
   ;

postfixExpression
   : primaryExpression ('++' | '--')?
   ;

castExpression
   : '(' type ')' unaryExpression
   | '(' type ')' unaryExpressionNotPlusMinus
   ;

primaryExpression
   : primaryPrefix primarySuffix*
   ;

memberSelector
   : '.' typeArguments javaIdentifier
   ;

primaryPrefix
   : literal
   | 'this'
   | 'super' '.' javaIdentifier
   | '(' expression ')'
   | allocationExpression
   | resultType '.' 'class'
   | name
   ;

primarySuffix
   : '.' 'this'
   | '.' allocationExpression
   | memberSelector
   | '[' expression ']'
   | '.' javaIdentifier
   | arguments
   ;

literal
   : INTEGER_LITERAL
   | FLOATING_POINT_LITERAL
   | CHARACTER_LITERAL
   | STRING_LITERAL
   | booleanLiteral
   | nullLiteral
   ;

integerLiteral
   : INTEGER_LITERAL
   ;

booleanLiteral
   : 'true'
   | 'false'
   ;

stringLiteral
   : STRING_LITERAL
   ;

nullLiteral
   : 'null'
   ;

arguments
   : '(' argumentList? ')'
   ;

argumentList
   : expression (',' expression)*
   ;

allocationExpression
   : 'new' primitiveType arrayDimsAndInits
   | 'new' classOrInterfaceType typeArguments? (arrayDimsAndInits | arguments classOrInterfaceBody?)
   ;

arrayDimsAndInits
   : ('[' expression ']')+ ('[' ']')*
   | ('[' ']')+ arrayInitializer
   ;

statement
   : labeledStatement
   | assertStatement
   | block
   | emptyStatement
   | statementExpression ';'
   | switchStatement
   | ifStatement
   | whileStatement
   | doStatement
   | forStatement
   | breakStatement
   | continueStatement
   | returnStatement
   | throwStatement
   | synchronizedStatement
   | tryStatement
   ;

assertStatement
   : 'assert' expression (':' expression)? ';'
   ;

labeledStatement
   : javaIdentifier ':' statement
   ;

block
   : '{' blockStatement* '}'
   ;

blockStatement
   : localVariableDeclaration ';'
   | statement
   | classOrInterfaceDeclaration
   ;

localVariableDeclaration
   : modifiers type variableDeclarator (',' variableDeclarator)*
   ;

emptyStatement
   : ';'
   ;

statementExpression
   : preIncrementExpression
   | preDecrementExpression
   | primaryExpression ('++' | '--' | assignmentOperator expression)?
   ;

switchStatement
   : 'switch' '(' expression ')' '{' (switchLabel (blockStatement)*)* '}'
   ;

switchLabel
   : 'case' expression ':'
   | 'default' ':'
   ;

ifStatement
   : 'if' '(' expression ')' statement ('else' statement)?
   ;

whileStatement
   : 'while' '(' expression ')' statement
   ;

doStatement
   : 'do' statement 'while' '(' expression ')' ';'
   ;

forStatement
   : 'for' '(' (modifiers type javaIdentifier ':' expression | (forInit)? ';' (expression)? ';' (forUpdate)?) ')' statement
   ;

forInit
   : localVariableDeclaration
   | statementExpressionList
   ;

statementExpressionList
   : statementExpression (',' statementExpression)*
   ;

forUpdate
   : statementExpressionList
   ;

breakStatement
   : 'break' (javaIdentifier)? ';'
   ;

continueStatement
   : 'continue' (javaIdentifier)? ';'
   ;

returnStatement
   : 'return' expression? ';'
   ;

throwStatement
   : 'throw' expression ';'
   ;

synchronizedStatement
   : 'synchronized' '(' expression ')' block
   ;

resourceDeclaration
   : type variableDeclaratorId '=' expression
   ;

catchParameter
   : modifiers type (('&' | '*') | '...')? ('|' type)* variableDeclaratorId
   ;

tryStatement
   : 'try' ('(' resourceDeclaration (';' resourceDeclaration)* (';')? ')')? block ('catch' '(' catchParameter ')' block)* ('finally' block)?
   ;

annotation
   : normalAnnotation
   | singleMemberAnnotation
   | markerAnnotation
   ;

normalAnnotation
   : '@' name '(' memberValuePairs? ')'
   ;

markerAnnotation
   : '@' name
   ;

singleMemberAnnotation
   : '@' name '(' memberValue ')'
   ;

memberValuePairs
   : memberValuePair (',' memberValuePair)*
   ;

memberValuePair
   : javaIdentifier '=' memberValue
   ;

memberValue
   : annotation
   | memberValueArrayInitializer
   | conditionalExpression
   ;

memberValueArrayInitializer
   : '{' memberValue (',' memberValue)* (',')? '}'
   ;

annotationTypeDeclaration
   : '@' 'interface' javaIdentifier annotationTypeBody
   ;

annotationTypeBody
   : '{' annotationTypeMemberDeclaration* '}'
   ;

annotationTypeMemberDeclaration
   : modifiers (type javaIdentifier '(' ')' defaultValue? ';' | classOrInterfaceDeclaration | enumDeclaration | annotationTypeDeclaration | fieldDeclaration)
   | ';'
   ;

defaultValue
   : 'default' memberValue
   ;

