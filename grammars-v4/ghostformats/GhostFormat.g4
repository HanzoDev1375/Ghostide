lexer grammar GhostFormat;

WS
   : [ \t\r\n\u000C]+ -> channel (HIDDEN)
   ;

Clang
   : '.c'
   ;

Cpp
   : '.cpp'
   ;

Java
   : '.java'
   ;

Python
   : '.py'
   ;

Ruby
   : '.rb'
   ;

PHP
   : '.php'
   ;

JavaScript
   : '.js'
   ;

GOLANG
   : '.go'
   ;

Swift
   : '.swift'
   ;

Kotlin
   : '.kt'
   ;

Rust
   : '.rs'
   ;

CSharp
   : '.cs'
   ;

ObjectiveC
   : '.m'
   ;

HTML
   : '.html'
   ;

CSS
   : '.css'
   ;

TypeScript
   : '.ts'
   ;

Shell
   : '.sh'
   ;

Dart
   : '.dart'
   ;

MATLAB
   : '.m'
   ;

SQL
   : '.sql'
   ;

Groovy
   : '.groovy'
   ;

RLANG
   : '.r'
   ;

VHDL
   : '.vhdl'
   ;

Verilog
   : '.v'
   ;

PowerShell
   : '.ps1'
   ;

Perl
   : '.pl'
   ;

Haskell
   : '.hs'
   ;

Scala
   : '.scala'
   ;

Elixir
   : '.ex'
   ;

Clojure
   : '.clj'
   ;

SAS
   : '.sas'
   ;

COBOL
   : '.cob'
   ;

Pascal
   : '.pas'
   ;

Fortran
   : '.f90'
   ;

Ada
   : '.adb'
   ;

FSharp
   : '.fs'
   ;

Assembly
   : '.asm'
   ;

OCaml
   : '.ml'
   ;

Scheme
   : '.scm'
   ;

Smalltalk
   : '.st'
   ;

Tcl
   : '.tcl'
   ;

AWK
   : '.awk'
   ;

Lisp
   : '.lisp'
   ;

ActionScript
   : '.as'
   ;

Solidity
   : '.sol'
   ;

Prolog
   : '.plg'
   ;

Erlang
   : '.erl'
   ;

XSLT
   : '.xslt'
   ;

Logo
   : '.logo'
   ;

Scratch
   : '.sb3'
   ;

Haxe
   : '.hx'
   ;

Factor
   : '.factor'
   ;

Zig
   : '.zig'
   ;

Chapel
   : '.chpl'
   ;

Mercury
   : '.m'
   ;

Turing
   : '.t'
   ;

Io
   : '.io'
   ;

Algol
   : '.alg'
   ;

VisualFoxPro
   : '.vfp'
   ;

Processing
   : '.pde'
   ;

Dylan
   : '.dylan'
   ;

Wolfram
   : '.wl'
   ;

OpenCL
   : '.cl'
   ;

VBScript
   : '.vbs'
   ;

Modula2
   : '.m2'
   ;

JLANG
   : '.ij'
   ;

Nim
   : '.nim'
   ;

Crystal
   : '.cr'
   ;

Elm
   : '.elm'
   ;

NAT
   : '.nat'
   ;

COMMONLISP
   : '.cl'
   ;

Squirrel
   : '.nut'
   ;

PostScript
   : '.ps'
   ;

Forth
   : '.fs'
   ;

REXX
   : '.rexx'
   ;

fragment Number
   : [0-9]
   ;

fragment Name
   : [a-zA-Z]
   ;

LANGS
   : Name Number+
   ;

