/*
 * [The "BSD license"]
 *  Copyright (c) 2014 Terence Parr
 *  Copyright (c) 2014 Sam Harwell
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions
 *  are met:
 *
 *  1. Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *  3. The identifier of the author may not be used to endorse or promote products
 *     derived from this software without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 *  IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 *  OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 *  IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 *  INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 *  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 *  DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 *  THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 *  THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  Modified by @KylePls
 */
lexer grammar Ninja9;

compilationUnit
   : packageDeclaration? importDeclaration* typeDeclaration* EOF
   ;

modifier
   : 'public'
   | 'private'
   | 'protected'
   | 'final'
   | 'static'
   | 'strictfp'
   | 'volatile'
   | 'abstract'
   | 'synchronized'
   | 'transient'
   | 'native'
   ;

literal
   : IntegerLiteral # IntegerLiteral
   | FloatingPointLiteral # FloatingPointLiteral
   | BooleanLiteral # BooleanLiteral
   | CharacterLiteral # CharacterLiteral
   | StringLiteral # StringLiteral
   | NullLiteral # NullLiteral
   ;

primitiveType
   : annotation* numericType
   | annotation* 'boolean'
   ;

numericType
   : integralType
   | floatingPointType
   ;

integralType
   : 'byte'
   | 'short'
   | 'int'
   | 'long'
   | 'char'
   ;

floatingPointType
   : 'float'
   | 'double'
   ;

referenceType
   : classType
   | typeVariable
   | arrayType
   ;

classType
   : annotation* identifier typeArguments?
   | classType '.' classType
   ;

typeVariable
   : annotation* identifier
   ;

arrayType
   : arrayTypeName arrayDimension+
   ;

arrayTypeName
   : primitiveType
   | classType
   | typeVariable
   ;

dims
   : arrayDimension+
   ;

arrayDimension
   : '[' ']'
   ;

typeParameter
   : annotation* identifier typeBound?
   ;

typeBound
   : 'extends' typeVariable # simpleTypeBound
   | 'extends' classType additionalBound* # classTypeBound
   ;

additionalBound
   : '&' classType
   ;

typeArguments
   : '<' typeArgumentList '>'
   ;

typeArgumentList
   : typeArgument (',' typeArgument)*
   ;

typeArgument
   : referenceType
   | wildcard
   ;

wildcard
   : '?' wildcardBounds?
   ;

wildcardBounds
   : wildcardType referenceType
   ;

wildcardType
   : 'extends'
   | 'super'
   ;

typeName
   : Identifier
   | packageName '.' Identifier
   ;

propertyLookup
   : Identifier ('.' Identifier)*
   ;

packageName
   : propertyLookup
   ;

expressionName
   : Identifier
   | propertyLookup '.' Identifier
   ;

packageDeclaration
   : 'package' packageName ';'
   ;

import_static
   : 'static'
   ;

import_wildcard
   : '.' '*'
   ;

importDeclaration
   : 'import' import_static? (packageName '.')? typeName import_wildcard? ';'
   ;

typeDeclaration
   : classDeclaration
   | enumDeclaration
   | interfaceDeclaration
   | ';'
   ;

classDeclaration
   : annotation* modifier* 'class' identifier typeParameters? superclass? superinterfaces? classBody
   ;

typeParameterList
   : typeParameter (',' typeParameter)*
   ;

typeParameters
   : '<' typeParameterList '>'
   ;

superclass
   : 'extends' classType
   ;

superinterfaces
   : 'implements' interfaceTypeList
   ;

interfaceTypeList
   : classType (',' classType)*
   ;

classBody
   : '{' classBodyDeclaration* '}'
   ;

classBodyDeclaration
   : fieldDeclaration
   | methodDeclaration
   | classDeclaration
   | interfaceDeclaration
   | emptyStatement
   | instanceInitializer
   | staticInitializer
   | constructorDeclaration
   ;

fieldDeclaration
   : annotation* modifier* unannType variableDeclaratorList ';'
   ;

variableDeclaratorList
   : variableDeclarator (',' variableDeclarator)*
   ;

variableDeclarator
   : variableDeclaratorId ('=' variableInitializer)?
   ;

variableDeclaratorId
   : identifier arrayDimension*
   ;

variableInitializer
   : expression
   | arrayInitializer
   ;

unannType
   : unannPrimitiveType
   | unannReferenceType
   ;

unannPrimitiveType
   : numericType
   | 'boolean'
   ;

unannReferenceType
   : unannClassOrInterfaceType
   | unannTypeVariable
   | unannArrayType
   ;

unannClassOrInterfaceType
   : (unannClassType_lfno_unannClassOrInterfaceType | unannInterfaceType_lfno_unannClassOrInterfaceType) (unannClassType_lf_unannClassOrInterfaceType | unannInterfaceType_lf_unannClassOrInterfaceType)*
   ;

unannClassType
   : Identifier typeArguments?
   | unannClassOrInterfaceType '.' annotation* Identifier typeArguments?
   ;

unannClassType_lf_unannClassOrInterfaceType
   : '.' annotation* Identifier typeArguments?
   ;

unannClassType_lfno_unannClassOrInterfaceType
   : Identifier typeArguments?
   ;

unannInterfaceType_lf_unannClassOrInterfaceType
   : unannClassType_lf_unannClassOrInterfaceType
   ;

unannInterfaceType_lfno_unannClassOrInterfaceType
   : unannClassType_lfno_unannClassOrInterfaceType
   ;

unannTypeVariable
   : Identifier
   ;

unannArrayType
   : unannPrimitiveType arrayDimension+
   | unannClassOrInterfaceType arrayDimension+
   | unannTypeVariable arrayDimension+
   ;

methodDeclaration
   : annotation* modifier* methodHeader methodBody
   ;

methodHeader
   : result methodDeclarator throws_?
   | typeParameters annotation* result methodDeclarator throws_?
   ;

result
   : unannType
   | 'void'
   ;

methodDeclarator
   : identifier '(' formalParameterList? ')'
   ;

formalParameterList
   : receiverParameter
   | formalParameters ',' lastFormalParameter
   | lastFormalParameter
   ;

formalParameters
   : formalParameter (',' formalParameter)*
   | receiverParameter (',' formalParameter)*
   ;

formalParameter
   : annotation* modifier* unannType variableDeclaratorId
   ;

lastFormalParameter
   : modifier* unannType annotation* '...' variableDeclaratorId
   | formalParameter
   ;

receiverParameter
   : annotation* unannType (identifier '.')? 'this'
   ;

throws_
   : 'throws' exceptionTypeList
   ;

exceptionTypeList
   : exceptionType (',' exceptionType)*
   ;

exceptionType
   : classType
   | typeVariable
   ;

methodBody
   : block
   | ';'
   ;

instanceInitializer
   : block
   ;

staticInitializer
   : 'static' block
   ;

constructorDeclaration
   : annotation* modifier* constructorDeclarator throws_? constructorBody
   ;

constructorDeclarator
   : typeParameters? simpleTypeName '(' formalParameterList? ')'
   ;

simpleTypeName
   : Identifier
   ;

constructorBody
   : '{' explicitConstructorInvocation? blockStatements? '}'
   ;

explicitConstructorInvocation
   : typeArguments? 'this' '(' argumentList? ')' ';'
   | typeArguments? 'super' '(' argumentList? ')' ';'
   | expressionName '.' typeArguments? 'super' '(' argumentList? ')' ';'
   | primary '.' typeArguments? 'super' '(' argumentList? ')' ';'
   ;

enumDeclaration
   : annotation* modifier* 'enum' identifier superinterfaces? enumBody
   ;

enumBody
   : '{' enumConstantList? ','? enumBodyDeclarations? '}'
   ;

enumConstantList
   : enumConstant (',' enumConstant)*
   ;

enumConstant
   : annotation* identifier ('(' argumentList? ')')? classBody?
   ;

enumBodyDeclarations
   : ';' classBodyDeclaration*
   ;
/*
 * Productions from §9 (Interfaces)
 */
   
   
interfaceDeclaration
   : normalInterfaceDeclaration
   | annotationTypeDeclaration
   ;

normalInterfaceDeclaration
   : annotation* modifier* 'interface' identifier typeParameters? extendsInterfaces? interfaceBody
   ;

extendsInterfaces
   : 'extends' interfaceTypeList
   ;

interfaceBody
   : '{' interfaceMemberDeclaration* '}'
   ;

interfaceMemberDeclaration
   : constantDeclaration
   | interfaceMethodDeclaration
   | classDeclaration
   | interfaceDeclaration
   | emptyStatement
   ;

constantDeclaration
   : annotation* modifier* unannType variableDeclaratorList ';'
   ;

interfaceMethodDeclaration
   : annotation* modifier* DEFAULT? methodHeader methodBody
   ;

annotationTypeDeclaration
   : annotation* modifier* '@' 'interface' identifier annotationTypeBody
   ;

annotationTypeBody
   : '{' annotationTypeMemberDeclaration* '}'
   ;

annotationTypeMemberDeclaration
   : annotationTypeElementDeclaration
   | constantDeclaration
   | classDeclaration
   | interfaceDeclaration
   | ';'
   ;

annotationTypeElementDeclaration
   : annotation* modifier* unannType identifier '(' ')' arrayDimension* defaultValue? ';'
   ;

defaultValue
   : 'default' elementValue
   ;

annotation
   : normalAnnotation
   | markerAnnotation
   | singleElementAnnotation
   ;

normalAnnotation
   : '@' typeName '(' elementValuePairList? ')'
   ;

elementValuePairList
   : elementValuePair (',' elementValuePair)*
   ;

elementValuePair
   : identifier '=' elementValue
   ;

elementValue
   : conditionalExpression # elementValueExpression
   | elementValueArrayInitializer # elementValueArray
   | annotation # elementValueAnnotation
   ;

elementValueArrayInitializer
   : '{' elementValueList? ','? '}'
   ;

elementValueList
   : elementValue (',' elementValue)*
   ;

markerAnnotation
   : '@' typeName
   ;

singleElementAnnotation
   : '@' typeName '(' elementValue ')'
   ;
/*
 * Productions from §10 (Arrays)
 */
   
   
arrayInitializer
   : '{' variableInitializerList? ','? '}'
   ;

variableInitializerList
   : variableInitializer (',' variableInitializer)*
   ;
/*
 * Productions from §14 (Blocks and Statements)
 */
   
   
block
   : '{' blockStatement* '}'
   ;

blockStatements
   : blockStatement+
   ;

blockStatement
   : localVariableDeclarationStatement
   | classDeclaration
   | statement
   ;

localVariableDeclarationStatement
   : localVariableDeclaration ';'
   ;

localVariableDeclaration
   : annotation* modifier* unannType variableDeclaratorList
   ;

statement
   : statementWithoutTrailingSubstatement
   | labeledStatement
   | ifThenStatement
   | ifThenElseStatement
   | whileStatement
   | forStatement
   ;

statementNoShortIf
   : statementWithoutTrailingSubstatement
   | labeledStatementNoShortIf
   | ifThenElseStatementNoShortIf
   | whileStatementNoShortIf
   | forStatementNoShortIf
   ;

statementWithoutTrailingSubstatement
   : block
   | emptyStatement
   | expressionStatement
   | assertStatement
   | switchStatement
   | doStatement
   | breakStatement
   | continueStatement
   | returnStatement
   | synchronizedStatement
   | throwStatement
   | tryStatement
   ;

emptyStatement
   : ';'
   ;

labeledStatement
   : identifier ':' statement
   ;

labeledStatementNoShortIf
   : identifier ':' statementNoShortIf
   ;

expressionStatement
   : statementExpression ';'
   ;

statementExpression
   : statementAssignment_nocol
   | statementPre_nocol
   | statementPost_nocol
   | statementMethodInvocation_nocol
   | statementClassInstanceCreation_nocol
   ;

statementAssignment_nocol
   : assignment
   ;

statementPre_nocol
   : preExpression
   ;

statementPost_nocol
   : postExpression
   ;

statementMethodInvocation_nocol
   : methodInvocation
   ;

statementClassInstanceCreation_nocol
   : classInstanceCreationExpression
   ;

ifThenStatement
   : 'if' '(' expression ')' statement
   ;

ifThenElseStatement
   : 'if' '(' expression ')' statementNoShortIf 'else' statement
   ;

ifThenElseStatementNoShortIf
   : 'if' '(' expression ')' statementNoShortIf 'else' statementNoShortIf
   ;

assertStatement
   : 'assert' expression ';'
   | 'assert' expression ':' expression ';'
   ;

switchStatement
   : 'switch' '(' expression ')' switchBlock
   ;

switchBlock
   : '{' switchCase* defaultSwitchCase? '}'
   ;

switchCase
   : 'case' expression ':' blockStatements?
   ;

defaultSwitchCase
   : 'default' ':' blockStatements?
   ;

whileStatement
   : 'while' '(' expression ')' statement
   ;

whileStatementNoShortIf
   : 'while' '(' expression ')' statementNoShortIf
   ;

doStatement
   : 'do' statement 'while' '(' expression ')' ';'
   ;

forStatement
   : basicForStatement
   | enhancedForStatement
   ;

forStatementNoShortIf
   : basicForStatementNoShortIf
   | enhancedForStatementNoShortIf
   ;

basicForStatement
   : 'for' '(' forInit? ';' expression? ';' forUpdate? ')' statement
   ;

basicForStatementNoShortIf
   : 'for' '(' forInit? ';' expression? ';' forUpdate? ')' statementNoShortIf
   ;

forInit
   : statementExpressionList
   | localVariableDeclaration
   ;

forUpdate
   : statementExpressionList
   ;

statementExpressionList
   : statementExpression (',' statementExpression)*
   ;

enhancedForStatement
   : 'for' '(' modifier* unannType variableDeclaratorId ':' expression ')' statement
   ;

enhancedForStatementNoShortIf
   : 'for' '(' modifier* unannType variableDeclaratorId ':' expression ')' statementNoShortIf
   ;

breakStatement
   : 'break' identifier? ';'
   ;

continueStatement
   : 'continue' identifier? ';'
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

tryStatement
   : basicTryStatement
   | tryWithResourcesStatement
   ;

basicTryStatement
   : 'try' block catches # tryCatchStatement
   | 'try' block catches? finally_ # tryCatchFinallyStatement
   ;

catches
   : catchClause catchClause*
   ;

catchClause
   : 'catch' '(' modifier* unannClassType ('|' classType)* variableDeclaratorId ')' block
   ;

finally_
   : 'finally' block
   ;

tryWithResourcesStatement
   : 'try' resourceSpecification block catches? finally_?
   ;

resourceSpecification
   : '(' resourceList ';'? ')'
   ;

resourceList
   : resource (';' resource)*
   ;

resource
   : modifier* unannType variableDeclaratorId '=' expression
   ;
/*
 * Productions from §15 (Expressions)
 */
   
   
primary
   : (primaryNoNewArray_lfno_primary | arrayCreationExpression) (primaryNoNewArray_lf_primary)*
   ;

expressionParenthesis
   : '(' expression ')'
   ;

primaryNoNewArray_lf_arrayAccess
   :
   ;

primaryNoNewArray_lfno_arrayAccess
   : literal
   | typeName ('[' ']')* '.' 'class'
   | 'void' '.' 'class'
   | 'this'
   | typeName '.' 'this'
   | expressionParenthesis
   | classInstanceCreationExpression
   | fieldAccess
   | methodInvocation
   | methodReference
   ;

primaryNoNewArray_lf_primary
   : classInstanceCreationExpression_lf_primary
   | fieldAccess_lf_primary
   | arrayAccess_lf_primary
   | methodInvocation_lf_primary
   | methodReference_lf_primary
   ;

primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary
   :
   ;

primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary
   : classInstanceCreationExpression_lf_primary
   | fieldAccess_lf_primary
   | methodInvocation_lf_primary
   | methodReference_lf_primary
   ;

primaryClassType
   : primaryClassTypeAlternates bracketPair* '.' 'class'
   ;

primaryClassTypeAlternates
   : typeName
   | unannPrimitiveType
   | voidType
   ;

voidType
   : 'void'
   ;

bracketPair
   : '[' ']'
   ;

primaryNoNewArray_lfno_primary
   : literal
   | primaryClassType
   | 'this'
   | typeName '.' 'this'
   | expressionParenthesis
   | classInstanceCreationExpression_lfno_primary
   | fieldAccess_lfno_primary
   | arrayAccess_lfno_primary
   | methodInvocation_lfno_primary
   | methodReference_lfno_primary
   ;

primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary
   :
   ;

primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary
   : literal
   | primaryClassType
   | 'this'
   | typeName '.' 'this'
   | expressionParenthesis
   | classInstanceCreationExpression_lfno_primary
   | fieldAccess_lfno_primary
   | methodInvocation_lfno_primary
   | methodReference_lfno_primary
   ;

classIdentifier
   : propertyLookup
   ;

classInstanceCreationExpression
   : 'new' typeArguments? classIdentifier typeArgumentsOrDiamond? '(' argumentList? ')' classBody?
   ;

classInstanceCreationExpression_lf_primary
   : '.' 'new' typeArguments? annotation* Identifier typeArgumentsOrDiamond? '(' argumentList? ')' classBody?
   ;

classInstanceCreationExpression_lfno_primary
   : 'new' typeArguments? annotation* Identifier ('.' annotation* Identifier)* typeArgumentsOrDiamond? '(' argumentList? ')' classBody?
   | expressionName '.' 'new' typeArguments? annotation* Identifier typeArgumentsOrDiamond? '(' argumentList? ')' classBody?
   ;

typeArgumentsOrDiamond
   : typeArguments # ig22
   | '<' '>' # diamond
   ;

fieldAccess
   : primary '.' identifier
   | 'super' '.' identifier
   | typeName '.' 'super' '.' identifier
   ;

fieldAccess_lf_primary
   : '.' identifier
   ;

fieldAccess_lfno_primary
   : 'super' '.' identifier
   | typeName '.' 'super' '.' identifier
   ;

arrayAccess
   : (expressionName '[' expression ']' | primaryNoNewArray_lfno_arrayAccess '[' expression ']') (primaryNoNewArray_lf_arrayAccess '[' expression ']')*
   ;

arrayAccess_lf_primary
   : (primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary '[' expression ']') (primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary '[' expression ']')*
   ;

arrayAccess_lfno_primary
   : (expressionName '[' expression ']' | primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary '[' expression ']') (primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary '[' expression ']')*
   ;

methodInvocation
   : methodArea? typeArguments? identifier '(' argumentList? ')'
   ;

methodArea
   : typeName
   | expressionName
   | primary
   | 'super' '.'
   | typeName '.' 'super' '.'
   ;

methodInvocation_lf_primary
   : '.' typeArguments? identifier '(' argumentList? ')'
   ;

methodInvocation_lfno_primary
   : identifier '(' argumentList? ')'
   | typeName '.' typeArguments? identifier '(' argumentList? ')'
   | expressionName '.' typeArguments? identifier '(' argumentList? ')'
   | 'super' '.' typeArguments? identifier '(' argumentList? ')'
   | typeName '.' 'super' '.' typeArguments? identifier '(' argumentList? ')'
   ;

argumentList
   : expression (',' expression)*
   ;

methodReference
   : expressionName '::' typeArguments? identifier
   | referenceType '::' typeArguments? identifier
   | primary '::' typeArguments? identifier
   | 'super' '::' typeArguments? identifier
   | typeName '.' 'super' '::' typeArguments? identifier
   | classType '::' typeArguments? 'new'
   | arrayType '::' 'new'
   ;

methodReference_lf_primary
   : '::' typeArguments? identifier
   ;

methodReference_lfno_primary
   : expressionName '::' typeArguments? identifier
   | referenceType '::' typeArguments? identifier
   | 'super' '::' typeArguments? identifier
   | typeName '.' 'super' '::' typeArguments? identifier
   | classType '::' typeArguments? 'new'
   | arrayType '::' 'new'
   ;

arrayCreationExpression
   : 'new' primitiveType dimExprs dims?
   | 'new' classType dimExprs dims?
   | 'new' primitiveType dims arrayInitializer
   | 'new' classType dims arrayInitializer
   ;

dimExprs
   : dimExpr dimExpr*
   ;

dimExpr
   : annotation* '[' expression ']'
   ;

expression
   : lambdaExpression
   | assignmentExpression
   | conditionalExpression
   ;

lambdaExpression
   : lambdaParameters '->' lambdaBody
   ;

lambdaParameters
   : lambdaIdentifierParameter
   | lambdaParameterList
   | lambdaInteredParameterList
   ;

lambdaInteredParameterList
   : '(' inferredFormalParameterList ')' # lambdaInferedParameterList
   ;

lambdaIdentifierParameter
   : identifier
   ;

lambdaParameterList
   : '(' formalParameterList? ')'
   ;

inferredFormalParameterList
   : identifier (',' identifier)*
   ;

lambdaBody
   : expression
   | block
   ;

assignmentExpression
   //	:	conditionalExpression
   : assignment
   ;

assignment
   : leftHandSide assignmentOperator expression
   ;

leftHandSide
   : expressionName
   | fieldAccess
   | arrayAccess
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

leftRightOperator
   : '||'
   | '&&'
   | '|'
   | '^'
   | '&'
   | '=='
   | '!='
   | '<'
   | '>'
   | '<='
   | '>='
   | 'instanceof'
   | '<<'
   | '>>'
   | '>>>'
   | '+'
   | '-'
   | '*'
   | '/'
   | '%'
   ;

conditionalExpression
   : conditionalExpression leftRightOperator conditionalExpression # leftRightExpression
   | conditionalExpression '?' expression ':' conditionalExpression # conditionalTernary
   | unaryExpression # ig18
   ;

unaryExpression
   : preExpression
   | postfixExpression
   | binaryExpression
   | castExpression
   ;

binaryExpression
   : binaryOperator unaryExpression
   ;

binaryOperator
   : '+'
   | '-'
   | '~'
   | '!'
   ;

prefixOperator
   : '++'
   | '--'
   ;

preExpression
   : prefixOperator unaryExpression
   ;

postfixExpression
   : (primary | expressionName) postfixOperator?
   ;

postfixOperator
   : '++'
   | '--'
   ;

postExpression
   : (primary | expressionName) postfixOperator
   ;

castExpression
   : castPrimitive
   | castReference
   ;

castPrimitive
   : '(' primitiveType ')' unaryExpression
   ;

castReference
   : '(' referenceType additionalBound* ')' (unaryExpression | lambdaExpression)
   ;

identifier
   : Identifier
   ;
   // LEXER
   
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

IF
   : 'if'
   ;

GOTO
   : 'goto'
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
   // §3.10.1 Integer Literals
   
IntegerLiteral
   : DecimalIntegerLiteral
   | HexIntegerLiteral
   | OctalIntegerLiteral
   | BinaryIntegerLiteral
   ;

fragment DecimalIntegerLiteral
   : DecimalNumeral IntegerTypeSuffix?
   ;

fragment HexIntegerLiteral
   : HexNumeral IntegerTypeSuffix?
   ;

fragment OctalIntegerLiteral
   : OctalNumeral IntegerTypeSuffix?
   ;

fragment BinaryIntegerLiteral
   : BinaryNumeral IntegerTypeSuffix?
   ;

fragment IntegerTypeSuffix
   : [lL]
   ;

fragment DecimalNumeral
   : '0'
   | NonZeroDigit (Digits? | Underscores Digits)
   ;

fragment Digits
   : Digit (DigitsAndUnderscores? Digit)?
   ;

fragment Digit
   : '0'
   | NonZeroDigit
   ;

fragment NonZeroDigit
   : [1-9]
   ;

fragment DigitsAndUnderscores
   : DigitOrUnderscore+
   ;

fragment DigitOrUnderscore
   : Digit
   | '_'
   ;

fragment Underscores
   : '_'+
   ;

fragment HexNumeral
   : '0' [xX] HexDigits
   ;

fragment HexDigits
   : HexDigit (HexDigitsAndUnderscores? HexDigit)?
   ;

fragment HexDigit
   : [0-9a-fA-F]
   ;

fragment HexDigitsAndUnderscores
   : HexDigitOrUnderscore+
   ;

fragment HexDigitOrUnderscore
   : HexDigit
   | '_'
   ;

fragment OctalNumeral
   : '0' Underscores? OctalDigits
   ;

fragment OctalDigits
   : OctalDigit (OctalDigitsAndUnderscores? OctalDigit)?
   ;

fragment OctalDigit
   : [0-7]
   ;

fragment OctalDigitsAndUnderscores
   : OctalDigitOrUnderscore+
   ;

fragment OctalDigitOrUnderscore
   : OctalDigit
   | '_'
   ;

fragment BinaryNumeral
   : '0' [bB] BinaryDigits
   ;

fragment BinaryDigits
   : BinaryDigit (BinaryDigitsAndUnderscores? BinaryDigit)?
   ;

fragment BinaryDigit
   : [01]
   ;

fragment BinaryDigitsAndUnderscores
   : BinaryDigitOrUnderscore+
   ;

fragment BinaryDigitOrUnderscore
   : BinaryDigit
   | '_'
   ;
   // §3.10.2 Floating-Point Literals
   
FloatingPointLiteral
   : DecimalFloatingPointLiteral
   | HexadecimalFloatingPointLiteral
   ;

fragment DecimalFloatingPointLiteral
   : Digits '.' Digits? ExponentPart? FloatTypeSuffix?
   | '.' Digits ExponentPart? FloatTypeSuffix?
   | Digits ExponentPart FloatTypeSuffix?
   | Digits FloatTypeSuffix
   ;

fragment ExponentPart
   : ExponentIndicator SignedInteger
   ;

fragment ExponentIndicator
   : [eE]
   ;

fragment SignedInteger
   : Sign? Digits
   ;

fragment Sign
   : [+-]
   ;

fragment FloatTypeSuffix
   : [fFdD]
   ;

fragment HexadecimalFloatingPointLiteral
   : HexSignificand BinaryExponent FloatTypeSuffix?
   ;

fragment HexSignificand
   : HexNumeral '.'?
   | '0' [xX] HexDigits? '.' HexDigits
   ;

fragment BinaryExponent
   : BinaryExponentIndicator SignedInteger
   ;

fragment BinaryExponentIndicator
   : [pP]
   ;
   // §3.10.3 Boolean Literals
   
BooleanLiteral
   : 'true'
   | 'false'
   ;
   // §3.10.4 Character Literals
   
CharacterLiteral
   : '\'' SingleCharacter '\''
   | '\'' EscapeSequence '\''
   ;

fragment SingleCharacter
   : ~ ['\\\r\n]
   ;
   // §3.10.5 String Literals
   
StringLiteral
   : '"' StringCharacters? '"'
   ;

fragment StringCharacters
   : StringCharacter+
   ;

fragment StringCharacter
   : ~ ["\\\r\n]
   | EscapeSequence
   ;
   // §3.10.6 Escape Sequences for Character and String Literals
   
fragment EscapeSequence
   : '\\' [btnfr"'\\]
   | OctalEscape
   | UnicodeEscape // This is not in the spec but prevents having to preprocess the input
   
   ;

fragment OctalEscape
   : '\\' OctalDigit
   | '\\' OctalDigit OctalDigit
   | '\\' ZeroToThree OctalDigit OctalDigit
   ;

fragment ZeroToThree
   : [0-3]
   ;
   // This is not in the spec but prevents having to preprocess the input
   
fragment UnicodeEscape
   : '\\' 'u'+ HexDigit HexDigit HexDigit HexDigit
   ;
   // §3.10.7 The Null Literal
   
NullLiteral
   : 'null'
   ;
   // §3.11 Separators
   
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

LBRACK
   : '['
   ;

RBRACK
   : ']'
   ;

SEMI
   : ';'
   ;

COMMA
   : ','
   ;

DOT
   : '.'
   ;
   // §3.12 Operators
   
ASSIGN
   : '='
   ;

GT
   : '>'
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

QUESTION
   : '?'
   ;

COLON
   : ':'
   ;

EQUAL
   : '=='
   ;

LE
   : '<='
   ;

GE
   : '>='
   ;

NOTEQUAL
   : '!='
   ;

AND
   : '&&'
   ;

OR
   : '||'
   ;

INC
   : '++'
   ;

DEC
   : '--'
   ;

ADD
   : '+'
   ;

SUB
   : '-'
   ;

MUL
   : '*'
   ;

DIV
   : '/'
   ;

BITAND
   : '&'
   ;

BITOR
   : '|'
   ;

CARET
   : '^'
   ;

MOD
   : '%'
   ;

ARROW
   : '->'
   ;

COLONCOLON
   : '::'
   ;

ADD_ASSIGN
   : '+='
   ;

SUB_ASSIGN
   : '-='
   ;

MUL_ASSIGN
   : '*='
   ;

DIV_ASSIGN
   : '/='
   ;

AND_ASSIGN
   : '&='
   ;

OR_ASSIGN
   : '|='
   ;

XOR_ASSIGN
   : '^='
   ;

MOD_ASSIGN
   : '%='
   ;

LSHIFT_ASSIGN
   : '<<='
   ;

RSHIFT_ASSIGN
   : '>>='
   ;

URSHIFT_ASSIGN
   : '>>>='
   ;
   // §3.8 Identifiers (must appear after all keywords in the grammar)
   
Identifier
   : JavaLetter JavaLetterOrDigit*
   ;

fragment JavaLetter
   : [a-zA-Z$_] // these are the "java letters" below 0x7F
   | // covers all characters above 0x7F which are not a surrogate
   ~ [\u0000-\u007F\uD800-\uDBFF]
   {Character.isJavaIdentifierStart(_input.LA(-1))}?
   | // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
   [\uD800-\uDBFF] [\uDC00-\uDFFF]
   {Character.isJavaIdentifierStart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
   ;

fragment JavaLetterOrDigit
   : [a-zA-Z0-9$_] // these are the "java letters or digits" below 0x7F
   | // covers all characters above 0x7F which are not a surrogate
   ~ [\u0000-\u007F\uD800-\uDBFF]
   {Character.isJavaIdentifierPart(_input.LA(-1))}?
   | // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
   [\uD800-\uDBFF] [\uDC00-\uDFFF]
   {Character.isJavaIdentifierPart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
   ;
   //
   
   // Additional symbols not defined in the lexical specification
   
   //
   
AT
   : '@'
   ;

ELLIPSIS
   : '...'
   ;
   //
   
   // Whitespace and comments
   
   //
   
WS
   : [ \t\r\n\u000C]+ -> skip
   ;

COMMENT
   : '/*' .*? '*/' -> skip
   ;

LINE_COMMENT
   : '//' ~ [\r\n]* -> skip
   ;

