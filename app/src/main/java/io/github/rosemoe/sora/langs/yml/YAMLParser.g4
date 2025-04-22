parser grammar YAMLParser;


options { tokenVocab = YAMLLexer; }
yamlDocument
   : (property | value)* EOF
   ;

property
   : key = ID COLON value? # SimpleProperty
   | key = STRING COLON value? # QuotedProperty
   ;

value
   : STRING # StringValue
   | NUMBER # NumberValue
   | TRUE # TrueValue
   | FALSE # FalseValue
   | NULL # NullValue
   | ANCHOR # AnchorValue
   | ALIAS # AliasValue
   | list # ListValue
   | map # MapValue
   ;

list
   : DASH value (COMMA? DASH value)*
   ;

map
   : LBRACE (property (COMMA property)*)? RBRACE
   ;

