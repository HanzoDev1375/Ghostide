lexer grammar PhpLexer;

Whitespace
   : [\n\t\r] -> skip
   ;

AttributeStart
   : '#['
   ;

Abstract
   : 'abstract'
   ;

Array
   : 'array'
   ;

As
   : 'as'
   ;

BinaryCast
   : 'binary'
   ;

BoolType
   : 'bool' 'ean'?
   ;

BooleanConstant
   : 'true'
   | 'false'
   ;

Break
   : 'break'
   ;

Callable
   : 'callable'
   ;

Case
   : 'case'
   ;

Catch
   : 'catch'
   ;

Class
   : 'class'
   ;

Clone
   : 'clone'
   ;

Const
   : 'const'
   ;

Continue
   : 'continue'
   ;

Declare
   : 'declare'
   ;

Default
   : 'default'
   ;

Do
   : 'do'
   ;

DoubleCast
   : 'real'
   ;

DoubleType
   : 'double'
   ;

Echo
   : 'echo'
   ;

Else
   : 'else'
   ;

ElseIf
   : 'elseif'
   ;

Empty
   : 'empty'
   ;

Enum_
   : 'enum'
   ;

EndDeclare
   : 'enddeclare'
   ;

EndFor
   : 'endfor'
   ;

EndForeach
   : 'endforeach'
   ;

EndIf
   : 'endif'
   ;

EndSwitch
   : 'endswitch'
   ;

EndWhile
   : 'endwhile'
   ;

Eval
   : 'eval'
   ;

Exit
   : 'die'
   ;

Extends
   : 'extends'
   ;

Final
   : 'final'
   ;

Finally
   : 'finally'
   ;

FloatCast
   : 'float'
   ;

For
   : 'for'
   ;

Foreach
   : 'foreach'
   ;

Function_
   : 'function'
   ;

Global
   : 'global'
   ;

Goto
   : 'goto'
   ;

If
   : 'if'
   ;

Implements
   : 'implements'
   ;

Import
   : 'import'
   ;

Include
   : 'include'
   ;

IncludeOnce
   : 'include_once'
   ;

InstanceOf
   : 'instanceof'
   ;

InsteadOf
   : 'insteadof'
   ;

Int8Cast
   : 'int8'
   ;

Int16Cast
   : 'int16'
   ;

Int64Type
   : 'int64'
   ;

IntType
   : 'int' 'eger'?
   ;

Interface
   : 'interface'
   ;

IsSet
   : 'isset'
   ;

List
   : 'list'
   ;

LogicalAnd
   : 'and'
   ;

LogicalOr
   : 'or'
   ;

LogicalXor
   : 'xor'
   ;

Match_
   : 'match'
   ;

Namespace
   : 'namespace'
   ;

New
   : 'new'
   ;

Null
   : 'null'
   ;

ObjectType
   : 'object'
   ;

Parent_
   : 'parent'
   ;

Partial
   : 'partial'
   ;

Print
   : 'print'
   ;

Private
   : 'private'
   ;

Protected
   : 'protected'
   ;

Public
   : 'public'
   ;

Readonly
   : 'readonly'
   ;

Require
   : 'require'
   ;

RequireOnce
   : 'require_once'
   ;

Resource
   : 'resource'
   ;

Return
   : 'return'
   ;

Static
   : 'static'
   ;

StringType
   : 'string'
   ;

Switch
   : 'switch'
   ;

Throw
   : 'throw'
   ;

Trait
   : 'trait'
   ;

Try
   : 'try'
   ;

Typeof
   : 'clrtypeof'
   ;

UintCast
   : 'uint' ('8' | '16' | '64')?
   ;

UnicodeCast
   : 'unicode'
   ;

Unset
   : 'unset'
   ;

Use
   : 'use'
   ;

Var
   : 'var'
   ;

While
   : 'while'
   ;

Yield
   : 'yield'
   ;

From
   : 'from'
   ;

LambdaFn
   : 'fn'
   ;

Ticks
   : 'ticks'
   ;

Encoding
   : 'encoding'
   ;

StrictTypes
   : 'strict_types'
   ;

Get
   : '__get'
   ;

Set
   : '__set'
   ;

Call
   : '__call'
   ;

CallStatic
   : '__callstatic'
   ;

Constructor
   : '__construct'
   ;

Destruct
   : '__destruct'
   ;

Wakeup
   : '__wakeup'
   ;

Sleep
   : '__sleep'
   ;

Autoload
   : '__autoload'
   ;

IsSet__
   : '__isset'
   ;

Unset__
   : '__unset'
   ;

ToString__
   : '__tostring'
   ;

Invoke
   : '__invoke'
   ;

SetState
   : '__set_state'
   ;

Clone__
   : '__clone'
   ;

DebugInfo
   : '__debuginfo'
   ;

Namespace__
   : '__namespace__'
   ;

Class__
   : '__class__'
   ;

Traic__
   : '__trait__'
   ;

Function__
   : '__function__'
   ;

Method__
   : '__method__'
   ;

Line__
   : '__line__'
   ;

File__
   : '__file__'
   ;

Dir__
   : '__dir__'
   ;

Spaceship
   : '<=>'
   ;

Lgeneric
   : '<:'
   ;

Rgeneric
   : ':>'
   ;

DoubleArrow
   : '=>'
   ;

Inc
   : '++'
   ;

Dec
   : '--'
   ;

IsIdentical
   : '==='
   ;

IsNoidentical
   : '!=='
   ;

IsEqual
   : '=='
   ;

IsNotEq
   : '<>'
   | '!='
   ;

IsSmallerOrEqual
   : '<='
   ;

IsGreaterOrEqual
   : '>='
   ;

PlusEqual
   : '+='
   ;

MinusEqual
   : '-='
   ;

MulEqual
   : '*='
   ;

Pow
   : '**'
   ;

PowEqual
   : '**='
   ;

DivEqual
   : '/='
   ;

Concaequal
   : '.='
   ;

ModEqual
   : '%='
   ;

ShiftLeftEqual
   : '<<='
   ;

ShiftRightEqual
   : '>>='
   ;

AndEqual
   : '&='
   ;

OrEqual
   : '|='
   ;

XorEqual
   : '^='
   ;

BooleanOr
   : '||'
   ;

BooleanAnd
   : '&&'
   ;

NullCoalescing
   : '??'
   ;

NullCoalescingEqual
   : '??='
   ;

ShiftLeft
   : '<<'
   ;

ShiftRight
   : '>>'
   ;

DoubleColon
   : '::'
   ;

ObjectOperator
   : '->'
   ;

NamespaceSeparator
   : '\\'
   ;

Ellipsis
   : '...'
   ;

Less
   : '<'
   ;

Greater
   : '>'
   ;

Ampersand
   : '&'
   ;

Pipe
   : '|'
   ;

Bang
   : '!'
   ;

Caret
   : '^'
   ;

Plus
   : '+'
   ;

Minus
   : '-'
   ;

Asterisk
   : '*'
   ;

Percent
   : '%'
   ;

Divide
   : '/'
   ;

Tilde
   : '~'
   ;

SuppressWarnings
   : '@'
   ;

Dollar
   : '$'
   ;

Dot
   : '.'
   ;

QuestionMark
   : '?'
   ;

OpenRoundBracket
   : '('
   ;

CloseRoundBracket
   : ')'
   ;

OpenSquareBracket
   : '['
   ;

CloseSquareBracket
   : ']'
   ;

OpenCurlyBracket
   : '{'
   ;

CloseCurlyBracket
   : '}'
   ;

Comma
   : ','
   ;

Colon
   : ':'
   ;

SemiColon
   : ';'
   ;

Eq
   : '='
   ;

Quote
   : '\''
   ;

BackQuote
   : '`'
   ;

PhpError
   : .
   ;

ColorHex
   : '#' HexDigit+
   ;

fragment HexDigit
   : [a-f0-9-A-F]
   ;

MultiLineComment
   : '/*' .*? '*/' -> channel (HIDDEN)
   ;

SingleLineComment
   : '//' -> channel (HIDDEN)
   ;

ShellStyleComment
   : '#' -> channel (HIDDEN)
   ;

