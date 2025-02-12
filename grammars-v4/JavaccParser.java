// Generated from /storage/emulated/0/AndroidIDEProjects/Ghost-web-ide/grammars-v4/Javacc.g4 by
// ANTLR 4.13.1
package ir.ninjacoder.ghostide;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class JavaccParser extends Parser {
  static {
    RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION);
  }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
  public static final int T__0 = 1,
      T__1 = 2,
      T__2 = 3,
      T__3 = 4,
      T__4 = 5,
      T__5 = 6,
      T__6 = 7,
      LOOKAHEAD = 8,
      IGNORE_CASE = 9,
      PARSER_BEGIN = 10,
      PARSER_END = 11,
      JAVACODE = 12,
      CPPCODE = 13,
      TOKEN = 14,
      SPECIAL_TOKEN = 15,
      MORE_ = 16,
      SKIP_ = 17,
      TOKEN_MGR_DECLS = 18,
      EOF_ = 19,
      DCL_PARSER_BEGIN = 20,
      DCL_PARSER_END = 21,
      INC_PARSER_BEGIN = 22,
      INC_PARSER_END = 23,
      DEF_PARSER_BEGIN = 24,
      DEF_PARSER_END = 25,
      WS = 26,
      COMMENT = 27,
      LINE_COMMENT = 28,
      ABSTRACT = 29,
      ASSERT = 30,
      BOOLEAN = 31,
      BREAK = 32,
      BYTE = 33,
      CASE = 34,
      CATCH = 35,
      CHAR = 36,
      CLASS = 37,
      CONST = 38,
      CONTINUE = 39,
      DEFAULT = 40,
      DO = 41,
      DOUBLE = 42,
      ELSE = 43,
      ENUM = 44,
      EXTENDS = 45,
      FALSE = 46,
      FINAL = 47,
      FINALLY = 48,
      FLOAT = 49,
      FOR = 50,
      GOTO = 51,
      IF = 52,
      IMPLEMENTS = 53,
      IMPORT = 54,
      INSTANCEOF = 55,
      INT = 56,
      INTERFACE = 57,
      LONG = 58,
      NATIVE = 59,
      NEW = 60,
      NULL = 61,
      PACKAGE = 62,
      PRIVATE = 63,
      PROTECTED = 64,
      PUBLIC = 65,
      RETURN = 66,
      SHORT = 67,
      STATIC = 68,
      STRICTFP = 69,
      SUPER = 70,
      SWITCH = 71,
      SYNCHRONIZED = 72,
      THIS = 73,
      THROW = 74,
      THROWS = 75,
      TRANSIENT = 76,
      TRUE = 77,
      TRY = 78,
      VOID = 79,
      VOLATILE = 80,
      WHILE = 81,
      TEMPLATE = 82,
      TYPENAME = 83,
      INTEGER_LITERAL = 84,
      DECIMAL_LITERAL = 85,
      HEX_LITERAL = 86,
      OCTAL_LITERAL = 87,
      BINARY_LITERAL = 88,
      FLOATING_POINT_LITERAL = 89,
      DECIMAL_FLOATING_POINT_LITERAL = 90,
      DECIMAL_EXPONENT = 91,
      HEXADECIMAL_FLOATING_POINT_LITERAL = 92,
      HEXADECIMAL_EXPONENT = 93,
      CHARACTER_LITERAL = 94,
      STRING_LITERAL = 95,
      LPAREN = 96,
      RPAREN = 97,
      LBRACE = 98,
      RBRACE = 99,
      LBRACKET = 100,
      RBRACKET = 101,
      SEMICOLON = 102,
      COMMA = 103,
      DOT = 104,
      ASSIGN = 105,
      LT = 106,
      BANG = 107,
      TILDE = 108,
      HOOK = 109,
      COLON = 110,
      DOUBLECOLON = 111,
      EQ = 112,
      LE = 113,
      GE = 114,
      NE = 115,
      SC_OR = 116,
      SC_AND = 117,
      INCR = 118,
      DECR = 119,
      PLUS = 120,
      MINUS = 121,
      STAR = 122,
      SLASH = 123,
      BIT_AND = 124,
      BIT_OR = 125,
      XOR = 126,
      REM = 127,
      PLUSASSIGN = 128,
      MINUSASSIGN = 129,
      STARASSIGN = 130,
      SLASHASSIGN = 131,
      ANDASSIGN = 132,
      ORASSIGN = 133,
      XORASSIGN = 134,
      REMASSIGN = 135,
      GT = 136,
      IDENTIFIER = 137;
  public static final int RULE_runsignedshift = 0,
      RULE_rsignedshift = 1,
      RULE_javacc_input = 2,
      RULE_javacc_options = 3,
      RULE_option_binding = 4,
      RULE_stringList = 5,
      RULE_production = 6,
      RULE_javacode_production = 7,
      RULE_cppcode_production = 8,
      RULE_bnf_production = 9,
      RULE_accessModifier = 10,
      RULE_regular_expr_production = 11,
      RULE_token_manager_decls = 12,
      RULE_regexpr_kind = 13,
      RULE_regexpr_spec = 14,
      RULE_expansion_choices = 15,
      RULE_expansion = 16,
      RULE_local_lookahead = 17,
      RULE_expansion_unit = 18,
      RULE_regular_expression = 19,
      RULE_complex_regular_expression_choices = 20,
      RULE_complex_regular_expression = 21,
      RULE_complex_regular_expression_unit = 22,
      RULE_character_list = 23,
      RULE_character_descriptor = 24,
      RULE_identifier = 25,
      RULE_node_descriptor = 26,
      RULE_node_descriptor_expression = 27,
      RULE_javaIdentifier = 28,
      RULE_compilationUnit = 29,
      RULE_packageDeclaration = 30,
      RULE_importDeclaration = 31,
      RULE_modifiers = 32,
      RULE_typeDeclaration = 33,
      RULE_classOrInterfaceDeclaration = 34,
      RULE_extendsList = 35,
      RULE_implementsList = 36,
      RULE_enumDeclaration = 37,
      RULE_enumBody = 38,
      RULE_enumConstant = 39,
      RULE_typeParameters = 40,
      RULE_typeParameter = 41,
      RULE_typeBound = 42,
      RULE_classOrInterfaceBody = 43,
      RULE_classOrInterfaceBodyDeclaration = 44,
      RULE_fieldDeclaration = 45,
      RULE_variableDeclarator = 46,
      RULE_variableDeclaratorId = 47,
      RULE_variableInitializer = 48,
      RULE_arrayInitializer = 49,
      RULE_methodDeclaration = 50,
      RULE_methodDeclarator = 51,
      RULE_formalParameters = 52,
      RULE_formalParameter = 53,
      RULE_constructorDeclaration = 54,
      RULE_explicitConstructorInvocation = 55,
      RULE_initializer = 56,
      RULE_type = 57,
      RULE_referenceType = 58,
      RULE_template = 59,
      RULE_templateBase = 60,
      RULE_templatePack = 61,
      RULE_classOrInterfaceType = 62,
      RULE_typeArguments = 63,
      RULE_typeArgument = 64,
      RULE_wildcardBounds = 65,
      RULE_primitiveType = 66,
      RULE_resultType = 67,
      RULE_name = 68,
      RULE_nameList = 69,
      RULE_expression = 70,
      RULE_assignmentOperator = 71,
      RULE_conditionalExpression = 72,
      RULE_conditionalOrExpression = 73,
      RULE_conditionalAndExpression = 74,
      RULE_inclusiveOrExpression = 75,
      RULE_exclusiveOrExpression = 76,
      RULE_andExpression = 77,
      RULE_equalityExpression = 78,
      RULE_instanceOfExpression = 79,
      RULE_relationalExpression = 80,
      RULE_shiftExpression = 81,
      RULE_additiveExpression = 82,
      RULE_multiplicativeExpression = 83,
      RULE_unaryExpression = 84,
      RULE_preIncrementExpression = 85,
      RULE_preDecrementExpression = 86,
      RULE_unaryExpressionNotPlusMinus = 87,
      RULE_castLookahead = 88,
      RULE_postfixExpression = 89,
      RULE_castExpression = 90,
      RULE_primaryExpression = 91,
      RULE_memberSelector = 92,
      RULE_primaryPrefix = 93,
      RULE_primarySuffix = 94,
      RULE_literal = 95,
      RULE_integerLiteral = 96,
      RULE_booleanLiteral = 97,
      RULE_stringLiteral = 98,
      RULE_nullLiteral = 99,
      RULE_arguments = 100,
      RULE_argumentList = 101,
      RULE_allocationExpression = 102,
      RULE_arrayDimsAndInits = 103,
      RULE_statement = 104,
      RULE_assertStatement = 105,
      RULE_labeledStatement = 106,
      RULE_block = 107,
      RULE_blockStatement = 108,
      RULE_localVariableDeclaration = 109,
      RULE_emptyStatement = 110,
      RULE_statementExpression = 111,
      RULE_switchStatement = 112,
      RULE_switchLabel = 113,
      RULE_ifStatement = 114,
      RULE_whileStatement = 115,
      RULE_doStatement = 116,
      RULE_forStatement = 117,
      RULE_forInit = 118,
      RULE_statementExpressionList = 119,
      RULE_forUpdate = 120,
      RULE_breakStatement = 121,
      RULE_continueStatement = 122,
      RULE_returnStatement = 123,
      RULE_throwStatement = 124,
      RULE_synchronizedStatement = 125,
      RULE_resourceDeclaration = 126,
      RULE_catchParameter = 127,
      RULE_tryStatement = 128,
      RULE_annotation = 129,
      RULE_normalAnnotation = 130,
      RULE_markerAnnotation = 131,
      RULE_singleMemberAnnotation = 132,
      RULE_memberValuePairs = 133,
      RULE_memberValuePair = 134,
      RULE_memberValue = 135,
      RULE_memberValueArrayInitializer = 136,
      RULE_annotationTypeDeclaration = 137,
      RULE_annotationTypeBody = 138,
      RULE_annotationTypeMemberDeclaration = 139,
      RULE_defaultValue = 140;

  private static String[] makeRuleNames() {
    return new String[] {
      "runsignedshift",
      "rsignedshift",
      "javacc_input",
      "javacc_options",
      "option_binding",
      "stringList",
      "production",
      "javacode_production",
      "cppcode_production",
      "bnf_production",
      "accessModifier",
      "regular_expr_production",
      "token_manager_decls",
      "regexpr_kind",
      "regexpr_spec",
      "expansion_choices",
      "expansion",
      "local_lookahead",
      "expansion_unit",
      "regular_expression",
      "complex_regular_expression_choices",
      "complex_regular_expression",
      "complex_regular_expression_unit",
      "character_list",
      "character_descriptor",
      "identifier",
      "node_descriptor",
      "node_descriptor_expression",
      "javaIdentifier",
      "compilationUnit",
      "packageDeclaration",
      "importDeclaration",
      "modifiers",
      "typeDeclaration",
      "classOrInterfaceDeclaration",
      "extendsList",
      "implementsList",
      "enumDeclaration",
      "enumBody",
      "enumConstant",
      "typeParameters",
      "typeParameter",
      "typeBound",
      "classOrInterfaceBody",
      "classOrInterfaceBodyDeclaration",
      "fieldDeclaration",
      "variableDeclarator",
      "variableDeclaratorId",
      "variableInitializer",
      "arrayInitializer",
      "methodDeclaration",
      "methodDeclarator",
      "formalParameters",
      "formalParameter",
      "constructorDeclaration",
      "explicitConstructorInvocation",
      "initializer",
      "type",
      "referenceType",
      "template",
      "templateBase",
      "templatePack",
      "classOrInterfaceType",
      "typeArguments",
      "typeArgument",
      "wildcardBounds",
      "primitiveType",
      "resultType",
      "name",
      "nameList",
      "expression",
      "assignmentOperator",
      "conditionalExpression",
      "conditionalOrExpression",
      "conditionalAndExpression",
      "inclusiveOrExpression",
      "exclusiveOrExpression",
      "andExpression",
      "equalityExpression",
      "instanceOfExpression",
      "relationalExpression",
      "shiftExpression",
      "additiveExpression",
      "multiplicativeExpression",
      "unaryExpression",
      "preIncrementExpression",
      "preDecrementExpression",
      "unaryExpressionNotPlusMinus",
      "castLookahead",
      "postfixExpression",
      "castExpression",
      "primaryExpression",
      "memberSelector",
      "primaryPrefix",
      "primarySuffix",
      "literal",
      "integerLiteral",
      "booleanLiteral",
      "stringLiteral",
      "nullLiteral",
      "arguments",
      "argumentList",
      "allocationExpression",
      "arrayDimsAndInits",
      "statement",
      "assertStatement",
      "labeledStatement",
      "block",
      "blockStatement",
      "localVariableDeclaration",
      "emptyStatement",
      "statementExpression",
      "switchStatement",
      "switchLabel",
      "ifStatement",
      "whileStatement",
      "doStatement",
      "forStatement",
      "forInit",
      "statementExpressionList",
      "forUpdate",
      "breakStatement",
      "continueStatement",
      "returnStatement",
      "throwStatement",
      "synchronizedStatement",
      "resourceDeclaration",
      "catchParameter",
      "tryStatement",
      "annotation",
      "normalAnnotation",
      "markerAnnotation",
      "singleMemberAnnotation",
      "memberValuePairs",
      "memberValuePair",
      "memberValue",
      "memberValueArrayInitializer",
      "annotationTypeDeclaration",
      "annotationTypeBody",
      "annotationTypeMemberDeclaration",
      "defaultValue"
    };
  }

  public static final String[] ruleNames = makeRuleNames();

  private static String[] makeLiteralNames() {
    return new String[] {
      null,
      "'#'",
      "'...'",
      "'<<='",
      "'>>='",
      "'>>>='",
      "'<<'",
      "'@'",
      "'LOOKAHEAD'",
      "'IGNORE_CASE'",
      "'PARSER_BEGIN'",
      "'PARSER_END'",
      "'JAVACODE'",
      "'CPPCODE'",
      "'TOKEN'",
      "'SPECIAL_TOKEN'",
      "'MORE'",
      "'SKIP'",
      "'TOKEN_MGR_DECLS'",
      "'EOF'",
      "'DCL_PARSER_BEGIN'",
      "'DCL_PARSER_END'",
      "'INC_PARSER_BEGIN'",
      "'INC_PARSER_END'",
      "'DEF_PARSER_BEGIN'",
      "'DEF_PARSER_END'",
      null,
      null,
      null,
      "'abstract'",
      "'assert'",
      "'boolean'",
      "'break'",
      "'byte'",
      "'case'",
      "'catch'",
      "'char'",
      "'class'",
      "'const'",
      "'continue'",
      "'default'",
      "'do'",
      "'double'",
      "'else'",
      "'enum'",
      "'extends'",
      "'false'",
      "'final'",
      "'finally'",
      "'float'",
      "'for'",
      "'goto'",
      "'if'",
      "'implements'",
      "'import'",
      "'instanceof'",
      "'int'",
      "'interface'",
      "'long'",
      "'native'",
      "'new'",
      "'null'",
      "'package'",
      "'private'",
      "'protected'",
      "'public'",
      "'return'",
      "'short'",
      "'static'",
      "'strictfp'",
      "'super'",
      "'switch'",
      "'synchronized'",
      "'this'",
      "'throw'",
      "'throws'",
      "'transient'",
      "'true'",
      "'try'",
      "'void'",
      "'volatile'",
      "'while'",
      "'template'",
      "'typename'",
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      "'('",
      "')'",
      "'{'",
      "'}'",
      "'['",
      "']'",
      "';'",
      "','",
      "'.'",
      "'='",
      "'<'",
      "'!'",
      "'~'",
      "'?'",
      "':'",
      "'::'",
      "'=='",
      "'<='",
      "'>='",
      "'!='",
      "'||'",
      "'&&'",
      "'++'",
      "'--'",
      "'+'",
      "'-'",
      "'*'",
      "'/'",
      "'&'",
      "'|'",
      "'^'",
      "'%'",
      "'+='",
      "'-='",
      "'*='",
      "'/='",
      "'&='",
      "'|='",
      "'^='",
      "'%='",
      "'>'"
    };
  }

  private static final String[] _LITERAL_NAMES = makeLiteralNames();

  private static String[] makeSymbolicNames() {
    return new String[] {
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      "LOOKAHEAD",
      "IGNORE_CASE",
      "PARSER_BEGIN",
      "PARSER_END",
      "JAVACODE",
      "CPPCODE",
      "TOKEN",
      "SPECIAL_TOKEN",
      "MORE_",
      "SKIP_",
      "TOKEN_MGR_DECLS",
      "EOF_",
      "DCL_PARSER_BEGIN",
      "DCL_PARSER_END",
      "INC_PARSER_BEGIN",
      "INC_PARSER_END",
      "DEF_PARSER_BEGIN",
      "DEF_PARSER_END",
      "WS",
      "COMMENT",
      "LINE_COMMENT",
      "ABSTRACT",
      "ASSERT",
      "BOOLEAN",
      "BREAK",
      "BYTE",
      "CASE",
      "CATCH",
      "CHAR",
      "CLASS",
      "CONST",
      "CONTINUE",
      "DEFAULT",
      "DO",
      "DOUBLE",
      "ELSE",
      "ENUM",
      "EXTENDS",
      "FALSE",
      "FINAL",
      "FINALLY",
      "FLOAT",
      "FOR",
      "GOTO",
      "IF",
      "IMPLEMENTS",
      "IMPORT",
      "INSTANCEOF",
      "INT",
      "INTERFACE",
      "LONG",
      "NATIVE",
      "NEW",
      "NULL",
      "PACKAGE",
      "PRIVATE",
      "PROTECTED",
      "PUBLIC",
      "RETURN",
      "SHORT",
      "STATIC",
      "STRICTFP",
      "SUPER",
      "SWITCH",
      "SYNCHRONIZED",
      "THIS",
      "THROW",
      "THROWS",
      "TRANSIENT",
      "TRUE",
      "TRY",
      "VOID",
      "VOLATILE",
      "WHILE",
      "TEMPLATE",
      "TYPENAME",
      "INTEGER_LITERAL",
      "DECIMAL_LITERAL",
      "HEX_LITERAL",
      "OCTAL_LITERAL",
      "BINARY_LITERAL",
      "FLOATING_POINT_LITERAL",
      "DECIMAL_FLOATING_POINT_LITERAL",
      "DECIMAL_EXPONENT",
      "HEXADECIMAL_FLOATING_POINT_LITERAL",
      "HEXADECIMAL_EXPONENT",
      "CHARACTER_LITERAL",
      "STRING_LITERAL",
      "LPAREN",
      "RPAREN",
      "LBRACE",
      "RBRACE",
      "LBRACKET",
      "RBRACKET",
      "SEMICOLON",
      "COMMA",
      "DOT",
      "ASSIGN",
      "LT",
      "BANG",
      "TILDE",
      "HOOK",
      "COLON",
      "DOUBLECOLON",
      "EQ",
      "LE",
      "GE",
      "NE",
      "SC_OR",
      "SC_AND",
      "INCR",
      "DECR",
      "PLUS",
      "MINUS",
      "STAR",
      "SLASH",
      "BIT_AND",
      "BIT_OR",
      "XOR",
      "REM",
      "PLUSASSIGN",
      "MINUSASSIGN",
      "STARASSIGN",
      "SLASHASSIGN",
      "ANDASSIGN",
      "ORASSIGN",
      "XORASSIGN",
      "REMASSIGN",
      "GT",
      "IDENTIFIER"
    };
  }

  private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
  public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

  /**
   * @deprecated Use {@link #VOCABULARY} instead.
   */
  @Deprecated public static final String[] tokenNames;

  static {
    tokenNames = new String[_SYMBOLIC_NAMES.length];
    for (int i = 0; i < tokenNames.length; i++) {
      tokenNames[i] = VOCABULARY.getLiteralName(i);
      if (tokenNames[i] == null) {
        tokenNames[i] = VOCABULARY.getSymbolicName(i);
      }

      if (tokenNames[i] == null) {
        tokenNames[i] = "<INVALID>";
      }
    }
  }

  @Override
  @Deprecated
  public String[] getTokenNames() {
    return tokenNames;
  }

  @Override
  public Vocabulary getVocabulary() {
    return VOCABULARY;
  }

  @Override
  public String getGrammarFileName() {
    return "Javacc.g4";
  }

  @Override
  public String[] getRuleNames() {
    return ruleNames;
  }

  @Override
  public String getSerializedATN() {
    return _serializedATN;
  }

  @Override
  public ATN getATN() {
    return _ATN;
  }

  public JavaccParser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
  }

  @SuppressWarnings("CheckReturnValue")
  public static class RunsignedshiftContext extends ParserRuleContext {
    public List<TerminalNode> GT() {
      return getTokens(JavaccParser.GT);
    }

    public TerminalNode GT(int i) {
      return getToken(JavaccParser.GT, i);
    }

    public RunsignedshiftContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_runsignedshift;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterRunsignedshift(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitRunsignedshift(this);
    }
  }

  public final RunsignedshiftContext runsignedshift() throws RecognitionException {
    RunsignedshiftContext _localctx = new RunsignedshiftContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_runsignedshift);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(282);
        match(GT);
        setState(283);
        match(GT);
        setState(284);
        match(GT);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class RsignedshiftContext extends ParserRuleContext {
    public List<TerminalNode> GT() {
      return getTokens(JavaccParser.GT);
    }

    public TerminalNode GT(int i) {
      return getToken(JavaccParser.GT, i);
    }

    public RsignedshiftContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_rsignedshift;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterRsignedshift(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitRsignedshift(this);
    }
  }

  public final RsignedshiftContext rsignedshift() throws RecognitionException {
    RsignedshiftContext _localctx = new RsignedshiftContext(_ctx, getState());
    enterRule(_localctx, 2, RULE_rsignedshift);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(286);
        match(GT);
        setState(287);
        match(GT);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Javacc_inputContext extends ParserRuleContext {
    public Javacc_optionsContext javacc_options() {
      return getRuleContext(Javacc_optionsContext.class, 0);
    }

    public TerminalNode PARSER_BEGIN() {
      return getToken(JavaccParser.PARSER_BEGIN, 0);
    }

    public List<TerminalNode> LPAREN() {
      return getTokens(JavaccParser.LPAREN);
    }

    public TerminalNode LPAREN(int i) {
      return getToken(JavaccParser.LPAREN, i);
    }

    public List<IdentifierContext> identifier() {
      return getRuleContexts(IdentifierContext.class);
    }

    public IdentifierContext identifier(int i) {
      return getRuleContext(IdentifierContext.class, i);
    }

    public List<TerminalNode> RPAREN() {
      return getTokens(JavaccParser.RPAREN);
    }

    public TerminalNode RPAREN(int i) {
      return getToken(JavaccParser.RPAREN, i);
    }

    public CompilationUnitContext compilationUnit() {
      return getRuleContext(CompilationUnitContext.class, 0);
    }

    public TerminalNode PARSER_END() {
      return getToken(JavaccParser.PARSER_END, 0);
    }

    public TerminalNode EOF() {
      return getToken(JavaccParser.EOF, 0);
    }

    public List<ProductionContext> production() {
      return getRuleContexts(ProductionContext.class);
    }

    public ProductionContext production(int i) {
      return getRuleContext(ProductionContext.class, i);
    }

    public Javacc_inputContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_javacc_input;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterJavacc_input(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitJavacc_input(this);
    }
  }

  public final Javacc_inputContext javacc_input() throws RecognitionException {
    Javacc_inputContext _localctx = new Javacc_inputContext(_ctx, getState());
    enterRule(_localctx, 4, RULE_javacc_input);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(289);
        javacc_options();
        setState(290);
        match(PARSER_BEGIN);
        setState(291);
        match(LPAREN);
        setState(292);
        identifier();
        setState(293);
        match(RPAREN);
        setState(294);
        compilationUnit();
        setState(295);
        match(PARSER_END);
        setState(296);
        match(LPAREN);
        setState(297);
        identifier();
        setState(298);
        match(RPAREN);
        setState(300);
        _errHandler.sync(this);
        _la = _input.LA(1);
        do {
          {
            {
              setState(299);
              production();
            }
          }
          setState(302);
          _errHandler.sync(this);
          _la = _input.LA(1);
        } while (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & 36116896548388991L) != 0)
            || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & 288230380580896777L) != 0));
        setState(304);
        match(EOF);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Javacc_optionsContext extends ParserRuleContext {
    public TerminalNode IDENTIFIER() {
      return getToken(JavaccParser.IDENTIFIER, 0);
    }

    public TerminalNode LBRACE() {
      return getToken(JavaccParser.LBRACE, 0);
    }

    public TerminalNode RBRACE() {
      return getToken(JavaccParser.RBRACE, 0);
    }

    public List<Option_bindingContext> option_binding() {
      return getRuleContexts(Option_bindingContext.class);
    }

    public Option_bindingContext option_binding(int i) {
      return getRuleContext(Option_bindingContext.class, i);
    }

    public Javacc_optionsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_javacc_options;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterJavacc_options(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitJavacc_options(this);
    }
  }

  public final Javacc_optionsContext javacc_options() throws RecognitionException {
    Javacc_optionsContext _localctx = new Javacc_optionsContext(_ctx, getState());
    enterRule(_localctx, 6, RULE_javacc_options);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(315);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == IDENTIFIER) {
          {
            setState(306);
            match(IDENTIFIER);
            setState(307);
            match(LBRACE);
            setState(311);
            _errHandler.sync(this);
            _la = _input.LA(1);
            while (((((_la - 8)) & ~0x3f) == 0 && ((1L << (_la - 8)) & 1152921504606846983L) != 0)
                || _la == IDENTIFIER) {
              {
                {
                  setState(308);
                  option_binding();
                }
              }
              setState(313);
              _errHandler.sync(this);
              _la = _input.LA(1);
            }
            setState(314);
            match(RBRACE);
          }
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Option_bindingContext extends ParserRuleContext {
    public TerminalNode ASSIGN() {
      return getToken(JavaccParser.ASSIGN, 0);
    }

    public TerminalNode SEMICOLON() {
      return getToken(JavaccParser.SEMICOLON, 0);
    }

    public TerminalNode IDENTIFIER() {
      return getToken(JavaccParser.IDENTIFIER, 0);
    }

    public TerminalNode LOOKAHEAD() {
      return getToken(JavaccParser.LOOKAHEAD, 0);
    }

    public TerminalNode IGNORE_CASE() {
      return getToken(JavaccParser.IGNORE_CASE, 0);
    }

    public TerminalNode STATIC() {
      return getToken(JavaccParser.STATIC, 0);
    }

    public TerminalNode PARSER_BEGIN() {
      return getToken(JavaccParser.PARSER_BEGIN, 0);
    }

    public IntegerLiteralContext integerLiteral() {
      return getRuleContext(IntegerLiteralContext.class, 0);
    }

    public BooleanLiteralContext booleanLiteral() {
      return getRuleContext(BooleanLiteralContext.class, 0);
    }

    public StringLiteralContext stringLiteral() {
      return getRuleContext(StringLiteralContext.class, 0);
    }

    public StringListContext stringList() {
      return getRuleContext(StringListContext.class, 0);
    }

    public Option_bindingContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_option_binding;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterOption_binding(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitOption_binding(this);
    }
  }

  public final Option_bindingContext option_binding() throws RecognitionException {
    Option_bindingContext _localctx = new Option_bindingContext(_ctx, getState());
    enterRule(_localctx, 8, RULE_option_binding);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(317);
        _la = _input.LA(1);
        if (!(((((_la - 8)) & ~0x3f) == 0 && ((1L << (_la - 8)) & 1152921504606846983L) != 0)
            || _la == IDENTIFIER)) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF) matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
        setState(318);
        match(ASSIGN);
        setState(323);
        _errHandler.sync(this);
        switch (_input.LA(1)) {
          case INTEGER_LITERAL:
            {
              setState(319);
              integerLiteral();
            }
            break;
          case FALSE:
          case TRUE:
            {
              setState(320);
              booleanLiteral();
            }
            break;
          case STRING_LITERAL:
            {
              setState(321);
              stringLiteral();
            }
            break;
          case LPAREN:
            {
              setState(322);
              stringList();
            }
            break;
          default:
            throw new NoViableAltException(this);
        }
        setState(325);
        match(SEMICOLON);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class StringListContext extends ParserRuleContext {
    public TerminalNode LPAREN() {
      return getToken(JavaccParser.LPAREN, 0);
    }

    public List<StringLiteralContext> stringLiteral() {
      return getRuleContexts(StringLiteralContext.class);
    }

    public StringLiteralContext stringLiteral(int i) {
      return getRuleContext(StringLiteralContext.class, i);
    }

    public TerminalNode RPAREN() {
      return getToken(JavaccParser.RPAREN, 0);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(JavaccParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(JavaccParser.COMMA, i);
    }

    public StringListContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_stringList;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterStringList(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitStringList(this);
    }
  }

  public final StringListContext stringList() throws RecognitionException {
    StringListContext _localctx = new StringListContext(_ctx, getState());
    enterRule(_localctx, 10, RULE_stringList);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(327);
        match(LPAREN);
        setState(328);
        stringLiteral();
        setState(333);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == COMMA) {
          {
            {
              setState(329);
              match(COMMA);
              setState(330);
              stringLiteral();
            }
          }
          setState(335);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(336);
        match(RPAREN);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ProductionContext extends ParserRuleContext {
    public Javacode_productionContext javacode_production() {
      return getRuleContext(Javacode_productionContext.class, 0);
    }

    public Cppcode_productionContext cppcode_production() {
      return getRuleContext(Cppcode_productionContext.class, 0);
    }

    public Regular_expr_productionContext regular_expr_production() {
      return getRuleContext(Regular_expr_productionContext.class, 0);
    }

    public Token_manager_declsContext token_manager_decls() {
      return getRuleContext(Token_manager_declsContext.class, 0);
    }

    public Bnf_productionContext bnf_production() {
      return getRuleContext(Bnf_productionContext.class, 0);
    }

    public ProductionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_production;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterProduction(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitProduction(this);
    }
  }

  public final ProductionContext production() throws RecognitionException {
    ProductionContext _localctx = new ProductionContext(_ctx, getState());
    enterRule(_localctx, 12, RULE_production);
    try {
      setState(343);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case JAVACODE:
          enterOuterAlt(_localctx, 1);
          {
            setState(338);
            javacode_production();
          }
          break;
        case CPPCODE:
          enterOuterAlt(_localctx, 2);
          {
            setState(339);
            cppcode_production();
          }
          break;
        case TOKEN:
        case SPECIAL_TOKEN:
        case MORE_:
        case SKIP_:
        case LT:
          enterOuterAlt(_localctx, 3);
          {
            setState(340);
            regular_expr_production();
          }
          break;
        case TOKEN_MGR_DECLS:
          enterOuterAlt(_localctx, 4);
          {
            setState(341);
            token_manager_decls();
          }
          break;
        case BOOLEAN:
        case BYTE:
        case CHAR:
        case CONST:
        case DOUBLE:
        case FLOAT:
        case INT:
        case LONG:
        case SHORT:
        case VOID:
        case TEMPLATE:
        case DOUBLECOLON:
        case IDENTIFIER:
          enterOuterAlt(_localctx, 5);
          {
            setState(342);
            bnf_production();
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Javacode_productionContext extends ParserRuleContext {
    public TerminalNode JAVACODE() {
      return getToken(JavaccParser.JAVACODE, 0);
    }

    public ResultTypeContext resultType() {
      return getRuleContext(ResultTypeContext.class, 0);
    }

    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public FormalParametersContext formalParameters() {
      return getRuleContext(FormalParametersContext.class, 0);
    }

    public BlockContext block() {
      return getRuleContext(BlockContext.class, 0);
    }

    public TerminalNode THROWS() {
      return getToken(JavaccParser.THROWS, 0);
    }

    public List<NameContext> name() {
      return getRuleContexts(NameContext.class);
    }

    public NameContext name(int i) {
      return getRuleContext(NameContext.class, i);
    }

    public Node_descriptorContext node_descriptor() {
      return getRuleContext(Node_descriptorContext.class, 0);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(JavaccParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(JavaccParser.COMMA, i);
    }

    public Javacode_productionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_javacode_production;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterJavacode_production(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitJavacode_production(this);
    }
  }

  public final Javacode_productionContext javacode_production() throws RecognitionException {
    Javacode_productionContext _localctx = new Javacode_productionContext(_ctx, getState());
    enterRule(_localctx, 14, RULE_javacode_production);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(345);
        match(JAVACODE);
        setState(346);
        resultType();
        setState(347);
        identifier();
        setState(348);
        formalParameters();
        setState(358);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == THROWS) {
          {
            setState(349);
            match(THROWS);
            setState(350);
            name();
            setState(355);
            _errHandler.sync(this);
            _la = _input.LA(1);
            while (_la == COMMA) {
              {
                {
                  setState(351);
                  match(COMMA);
                  setState(352);
                  name();
                }
              }
              setState(357);
              _errHandler.sync(this);
              _la = _input.LA(1);
            }
          }
        }

        setState(361);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__0) {
          {
            setState(360);
            node_descriptor();
          }
        }

        setState(363);
        block();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Cppcode_productionContext extends ParserRuleContext {
    public TerminalNode CPPCODE() {
      return getToken(JavaccParser.CPPCODE, 0);
    }

    public AccessModifierContext accessModifier() {
      return getRuleContext(AccessModifierContext.class, 0);
    }

    public ResultTypeContext resultType() {
      return getRuleContext(ResultTypeContext.class, 0);
    }

    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public FormalParametersContext formalParameters() {
      return getRuleContext(FormalParametersContext.class, 0);
    }

    public BlockContext block() {
      return getRuleContext(BlockContext.class, 0);
    }

    public TerminalNode THROWS() {
      return getToken(JavaccParser.THROWS, 0);
    }

    public List<NameContext> name() {
      return getRuleContexts(NameContext.class);
    }

    public NameContext name(int i) {
      return getRuleContext(NameContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(JavaccParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(JavaccParser.COMMA, i);
    }

    public Cppcode_productionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_cppcode_production;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterCppcode_production(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitCppcode_production(this);
    }
  }

  public final Cppcode_productionContext cppcode_production() throws RecognitionException {
    Cppcode_productionContext _localctx = new Cppcode_productionContext(_ctx, getState());
    enterRule(_localctx, 16, RULE_cppcode_production);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(365);
        match(CPPCODE);
        setState(366);
        accessModifier();
        setState(367);
        resultType();
        setState(368);
        identifier();
        setState(369);
        formalParameters();
        setState(379);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == THROWS) {
          {
            setState(370);
            match(THROWS);
            setState(371);
            name();
            setState(376);
            _errHandler.sync(this);
            _la = _input.LA(1);
            while (_la == COMMA) {
              {
                {
                  setState(372);
                  match(COMMA);
                  setState(373);
                  name();
                }
              }
              setState(378);
              _errHandler.sync(this);
              _la = _input.LA(1);
            }
          }
        }

        setState(381);
        block();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Bnf_productionContext extends ParserRuleContext {
    public ResultTypeContext resultType() {
      return getRuleContext(ResultTypeContext.class, 0);
    }

    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public FormalParametersContext formalParameters() {
      return getRuleContext(FormalParametersContext.class, 0);
    }

    public TerminalNode COLON() {
      return getToken(JavaccParser.COLON, 0);
    }

    public BlockContext block() {
      return getRuleContext(BlockContext.class, 0);
    }

    public TerminalNode LBRACE() {
      return getToken(JavaccParser.LBRACE, 0);
    }

    public Expansion_choicesContext expansion_choices() {
      return getRuleContext(Expansion_choicesContext.class, 0);
    }

    public TerminalNode RBRACE() {
      return getToken(JavaccParser.RBRACE, 0);
    }

    public TerminalNode THROWS() {
      return getToken(JavaccParser.THROWS, 0);
    }

    public List<NameContext> name() {
      return getRuleContexts(NameContext.class);
    }

    public NameContext name(int i) {
      return getRuleContext(NameContext.class, i);
    }

    public Node_descriptorContext node_descriptor() {
      return getRuleContext(Node_descriptorContext.class, 0);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(JavaccParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(JavaccParser.COMMA, i);
    }

    public Bnf_productionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_bnf_production;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterBnf_production(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitBnf_production(this);
    }
  }

  public final Bnf_productionContext bnf_production() throws RecognitionException {
    Bnf_productionContext _localctx = new Bnf_productionContext(_ctx, getState());
    enterRule(_localctx, 18, RULE_bnf_production);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(383);
        resultType();
        setState(384);
        identifier();
        setState(385);
        formalParameters();
        setState(395);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == THROWS) {
          {
            setState(386);
            match(THROWS);
            setState(387);
            name();
            setState(392);
            _errHandler.sync(this);
            _la = _input.LA(1);
            while (_la == COMMA) {
              {
                {
                  setState(388);
                  match(COMMA);
                  setState(389);
                  name();
                }
              }
              setState(394);
              _errHandler.sync(this);
              _la = _input.LA(1);
            }
          }
        }

        setState(398);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__0) {
          {
            setState(397);
            node_descriptor();
          }
        }

        setState(400);
        match(COLON);
        setState(401);
        block();
        setState(402);
        match(LBRACE);
        setState(403);
        expansion_choices();
        setState(404);
        match(RBRACE);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class AccessModifierContext extends ParserRuleContext {
    public TerminalNode PUBLIC() {
      return getToken(JavaccParser.PUBLIC, 0);
    }

    public TerminalNode PROTECTED() {
      return getToken(JavaccParser.PROTECTED, 0);
    }

    public TerminalNode PRIVATE() {
      return getToken(JavaccParser.PRIVATE, 0);
    }

    public AccessModifierContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_accessModifier;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterAccessModifier(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitAccessModifier(this);
    }
  }

  public final AccessModifierContext accessModifier() throws RecognitionException {
    AccessModifierContext _localctx = new AccessModifierContext(_ctx, getState());
    enterRule(_localctx, 20, RULE_accessModifier);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(407);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & 7L) != 0)) {
          {
            setState(406);
            _la = _input.LA(1);
            if (!(((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & 7L) != 0))) {
              _errHandler.recoverInline(this);
            } else {
              if (_input.LA(1) == Token.EOF) matchedEOF = true;
              _errHandler.reportMatch(this);
              consume();
            }
          }
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Regular_expr_productionContext extends ParserRuleContext {
    public Regexpr_kindContext regexpr_kind() {
      return getRuleContext(Regexpr_kindContext.class, 0);
    }

    public TerminalNode COLON() {
      return getToken(JavaccParser.COLON, 0);
    }

    public TerminalNode LBRACE() {
      return getToken(JavaccParser.LBRACE, 0);
    }

    public List<Regexpr_specContext> regexpr_spec() {
      return getRuleContexts(Regexpr_specContext.class);
    }

    public Regexpr_specContext regexpr_spec(int i) {
      return getRuleContext(Regexpr_specContext.class, i);
    }

    public TerminalNode RBRACE() {
      return getToken(JavaccParser.RBRACE, 0);
    }

    public TerminalNode LT() {
      return getToken(JavaccParser.LT, 0);
    }

    public TerminalNode STAR() {
      return getToken(JavaccParser.STAR, 0);
    }

    public TerminalNode GT() {
      return getToken(JavaccParser.GT, 0);
    }

    public List<TerminalNode> IDENTIFIER() {
      return getTokens(JavaccParser.IDENTIFIER);
    }

    public TerminalNode IDENTIFIER(int i) {
      return getToken(JavaccParser.IDENTIFIER, i);
    }

    public TerminalNode LBRACKET() {
      return getToken(JavaccParser.LBRACKET, 0);
    }

    public TerminalNode IGNORE_CASE() {
      return getToken(JavaccParser.IGNORE_CASE, 0);
    }

    public TerminalNode RBRACKET() {
      return getToken(JavaccParser.RBRACKET, 0);
    }

    public List<TerminalNode> BIT_OR() {
      return getTokens(JavaccParser.BIT_OR);
    }

    public TerminalNode BIT_OR(int i) {
      return getToken(JavaccParser.BIT_OR, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(JavaccParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(JavaccParser.COMMA, i);
    }

    public Regular_expr_productionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_regular_expr_production;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterRegular_expr_production(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitRegular_expr_production(this);
    }
  }

  public final Regular_expr_productionContext regular_expr_production()
      throws RecognitionException {
    Regular_expr_productionContext _localctx = new Regular_expr_productionContext(_ctx, getState());
    enterRule(_localctx, 22, RULE_regular_expr_production);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(422);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 16, _ctx)) {
          case 1:
            {
              setState(409);
              match(LT);
              setState(410);
              match(STAR);
              setState(411);
              match(GT);
            }
            break;
          case 2:
            {
              setState(412);
              match(LT);
              setState(413);
              match(IDENTIFIER);
              setState(418);
              _errHandler.sync(this);
              _la = _input.LA(1);
              while (_la == COMMA) {
                {
                  {
                    setState(414);
                    match(COMMA);
                    setState(415);
                    match(IDENTIFIER);
                  }
                }
                setState(420);
                _errHandler.sync(this);
                _la = _input.LA(1);
              }
              setState(421);
              match(GT);
            }
            break;
        }
        setState(424);
        regexpr_kind();
        setState(428);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == LBRACKET) {
          {
            setState(425);
            match(LBRACKET);
            setState(426);
            match(IGNORE_CASE);
            setState(427);
            match(RBRACKET);
          }
        }

        setState(430);
        match(COLON);
        setState(431);
        match(LBRACE);
        setState(432);
        regexpr_spec();
        setState(437);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == BIT_OR) {
          {
            {
              setState(433);
              match(BIT_OR);
              setState(434);
              regexpr_spec();
            }
          }
          setState(439);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(440);
        match(RBRACE);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Token_manager_declsContext extends ParserRuleContext {
    public TerminalNode TOKEN_MGR_DECLS() {
      return getToken(JavaccParser.TOKEN_MGR_DECLS, 0);
    }

    public TerminalNode COLON() {
      return getToken(JavaccParser.COLON, 0);
    }

    public ClassOrInterfaceBodyContext classOrInterfaceBody() {
      return getRuleContext(ClassOrInterfaceBodyContext.class, 0);
    }

    public Token_manager_declsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_token_manager_decls;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterToken_manager_decls(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitToken_manager_decls(this);
    }
  }

  public final Token_manager_declsContext token_manager_decls() throws RecognitionException {
    Token_manager_declsContext _localctx = new Token_manager_declsContext(_ctx, getState());
    enterRule(_localctx, 24, RULE_token_manager_decls);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(442);
        match(TOKEN_MGR_DECLS);
        setState(443);
        match(COLON);
        setState(445);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == LBRACE) {
          {
            setState(444);
            classOrInterfaceBody();
          }
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Regexpr_kindContext extends ParserRuleContext {
    public TerminalNode TOKEN() {
      return getToken(JavaccParser.TOKEN, 0);
    }

    public TerminalNode SPECIAL_TOKEN() {
      return getToken(JavaccParser.SPECIAL_TOKEN, 0);
    }

    public TerminalNode SKIP_() {
      return getToken(JavaccParser.SKIP_, 0);
    }

    public TerminalNode MORE_() {
      return getToken(JavaccParser.MORE_, 0);
    }

    public Regexpr_kindContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_regexpr_kind;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterRegexpr_kind(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitRegexpr_kind(this);
    }
  }

  public final Regexpr_kindContext regexpr_kind() throws RecognitionException {
    Regexpr_kindContext _localctx = new Regexpr_kindContext(_ctx, getState());
    enterRule(_localctx, 26, RULE_regexpr_kind);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(447);
        _la = _input.LA(1);
        if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 245760L) != 0))) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF) matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Regexpr_specContext extends ParserRuleContext {
    public Regular_expressionContext regular_expression() {
      return getRuleContext(Regular_expressionContext.class, 0);
    }

    public BlockContext block() {
      return getRuleContext(BlockContext.class, 0);
    }

    public TerminalNode COLON() {
      return getToken(JavaccParser.COLON, 0);
    }

    public TerminalNode IDENTIFIER() {
      return getToken(JavaccParser.IDENTIFIER, 0);
    }

    public Regexpr_specContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_regexpr_spec;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterRegexpr_spec(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitRegexpr_spec(this);
    }
  }

  public final Regexpr_specContext regexpr_spec() throws RecognitionException {
    Regexpr_specContext _localctx = new Regexpr_specContext(_ctx, getState());
    enterRule(_localctx, 28, RULE_regexpr_spec);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(449);
        regular_expression();
        setState(451);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == LBRACE) {
          {
            setState(450);
            block();
          }
        }

        setState(455);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == COLON) {
          {
            setState(453);
            match(COLON);
            setState(454);
            match(IDENTIFIER);
          }
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Expansion_choicesContext extends ParserRuleContext {
    public List<ExpansionContext> expansion() {
      return getRuleContexts(ExpansionContext.class);
    }

    public ExpansionContext expansion(int i) {
      return getRuleContext(ExpansionContext.class, i);
    }

    public List<TerminalNode> BIT_OR() {
      return getTokens(JavaccParser.BIT_OR);
    }

    public TerminalNode BIT_OR(int i) {
      return getToken(JavaccParser.BIT_OR, i);
    }

    public Expansion_choicesContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_expansion_choices;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterExpansion_choices(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitExpansion_choices(this);
    }
  }

  public final Expansion_choicesContext expansion_choices() throws RecognitionException {
    Expansion_choicesContext _localctx = new Expansion_choicesContext(_ctx, getState());
    enterRule(_localctx, 30, RULE_expansion_choices);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(457);
        expansion();
        setState(462);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == BIT_OR) {
          {
            {
              setState(458);
              match(BIT_OR);
              setState(459);
              expansion();
            }
          }
          setState(464);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ExpansionContext extends ParserRuleContext {
    public TerminalNode LOOKAHEAD() {
      return getToken(JavaccParser.LOOKAHEAD, 0);
    }

    public TerminalNode LPAREN() {
      return getToken(JavaccParser.LPAREN, 0);
    }

    public Local_lookaheadContext local_lookahead() {
      return getRuleContext(Local_lookaheadContext.class, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(JavaccParser.RPAREN, 0);
    }

    public List<Expansion_unitContext> expansion_unit() {
      return getRuleContexts(Expansion_unitContext.class);
    }

    public Expansion_unitContext expansion_unit(int i) {
      return getRuleContext(Expansion_unitContext.class, i);
    }

    public List<Node_descriptorContext> node_descriptor() {
      return getRuleContexts(Node_descriptorContext.class);
    }

    public Node_descriptorContext node_descriptor(int i) {
      return getRuleContext(Node_descriptorContext.class, i);
    }

    public ExpansionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_expansion;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterExpansion(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitExpansion(this);
    }
  }

  public final ExpansionContext expansion() throws RecognitionException {
    ExpansionContext _localctx = new ExpansionContext(_ctx, getState());
    enterRule(_localctx, 32, RULE_expansion);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(470);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 23, _ctx)) {
          case 1:
            {
              setState(465);
              match(LOOKAHEAD);
              setState(466);
              match(LPAREN);
              setState(467);
              local_lookahead();
              setState(468);
              match(RPAREN);
            }
            break;
        }
        setState(476);
        _errHandler.sync(this);
        _alt = 1;
        do {
          switch (_alt) {
            case 1:
              {
                {
                  setState(472);
                  expansion_unit();
                  setState(474);
                  _errHandler.sync(this);
                  _la = _input.LA(1);
                  if (_la == T__0) {
                    {
                      setState(473);
                      node_descriptor();
                    }
                  }
                }
              }
              break;
            default:
              throw new NoViableAltException(this);
          }
          setState(478);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 25, _ctx);
        } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Local_lookaheadContext extends ParserRuleContext {
    public IntegerLiteralContext integerLiteral() {
      return getRuleContext(IntegerLiteralContext.class, 0);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(JavaccParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(JavaccParser.COMMA, i);
    }

    public Expansion_choicesContext expansion_choices() {
      return getRuleContext(Expansion_choicesContext.class, 0);
    }

    public TerminalNode LBRACE() {
      return getToken(JavaccParser.LBRACE, 0);
    }

    public TerminalNode RBRACE() {
      return getToken(JavaccParser.RBRACE, 0);
    }

    public ExpressionContext expression() {
      return getRuleContext(ExpressionContext.class, 0);
    }

    public Local_lookaheadContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_local_lookahead;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterLocal_lookahead(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitLocal_lookahead(this);
    }
  }

  public final Local_lookaheadContext local_lookahead() throws RecognitionException {
    Local_lookaheadContext _localctx = new Local_lookaheadContext(_ctx, getState());
    enterRule(_localctx, 34, RULE_local_lookahead);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(481);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 26, _ctx)) {
          case 1:
            {
              setState(480);
              integerLiteral();
            }
            break;
        }
        setState(484);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 27, _ctx)) {
          case 1:
            {
              setState(483);
              match(COMMA);
            }
            break;
        }
        setState(487);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 28, _ctx)) {
          case 1:
            {
              setState(486);
              expansion_choices();
            }
            break;
        }
        setState(490);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == COMMA) {
          {
            setState(489);
            match(COMMA);
          }
        }

        setState(497);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == LBRACE) {
          {
            setState(492);
            match(LBRACE);
            setState(494);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3819690555156193024L) != 0)
                || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 33797888870093897L) != 0)
                || _la == IDENTIFIER) {
              {
                setState(493);
                expression();
              }
            }

            setState(496);
            match(RBRACE);
          }
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Expansion_unitContext extends ParserRuleContext {
    public TerminalNode LOOKAHEAD() {
      return getToken(JavaccParser.LOOKAHEAD, 0);
    }

    public List<TerminalNode> LPAREN() {
      return getTokens(JavaccParser.LPAREN);
    }

    public TerminalNode LPAREN(int i) {
      return getToken(JavaccParser.LPAREN, i);
    }

    public Local_lookaheadContext local_lookahead() {
      return getRuleContext(Local_lookaheadContext.class, 0);
    }

    public List<TerminalNode> RPAREN() {
      return getTokens(JavaccParser.RPAREN);
    }

    public TerminalNode RPAREN(int i) {
      return getToken(JavaccParser.RPAREN, i);
    }

    public List<BlockContext> block() {
      return getRuleContexts(BlockContext.class);
    }

    public BlockContext block(int i) {
      return getRuleContext(BlockContext.class, i);
    }

    public TerminalNode LBRACKET() {
      return getToken(JavaccParser.LBRACKET, 0);
    }

    public Expansion_choicesContext expansion_choices() {
      return getRuleContext(Expansion_choicesContext.class, 0);
    }

    public TerminalNode RBRACKET() {
      return getToken(JavaccParser.RBRACKET, 0);
    }

    public TerminalNode TRY() {
      return getToken(JavaccParser.TRY, 0);
    }

    public TerminalNode LBRACE() {
      return getToken(JavaccParser.LBRACE, 0);
    }

    public TerminalNode RBRACE() {
      return getToken(JavaccParser.RBRACE, 0);
    }

    public List<TerminalNode> CATCH() {
      return getTokens(JavaccParser.CATCH);
    }

    public TerminalNode CATCH(int i) {
      return getToken(JavaccParser.CATCH, i);
    }

    public TerminalNode FINALLY() {
      return getToken(JavaccParser.FINALLY, 0);
    }

    public List<NameContext> name() {
      return getRuleContexts(NameContext.class);
    }

    public NameContext name(int i) {
      return getRuleContext(NameContext.class, i);
    }

    public List<TerminalNode> IDENTIFIER() {
      return getTokens(JavaccParser.IDENTIFIER);
    }

    public TerminalNode IDENTIFIER(int i) {
      return getToken(JavaccParser.IDENTIFIER, i);
    }

    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public ArgumentsContext arguments() {
      return getRuleContext(ArgumentsContext.class, 0);
    }

    public Regular_expressionContext regular_expression() {
      return getRuleContext(Regular_expressionContext.class, 0);
    }

    public PrimaryExpressionContext primaryExpression() {
      return getRuleContext(PrimaryExpressionContext.class, 0);
    }

    public TerminalNode ASSIGN() {
      return getToken(JavaccParser.ASSIGN, 0);
    }

    public TypeArgumentsContext typeArguments() {
      return getRuleContext(TypeArgumentsContext.class, 0);
    }

    public TerminalNode DOT() {
      return getToken(JavaccParser.DOT, 0);
    }

    public TerminalNode PLUS() {
      return getToken(JavaccParser.PLUS, 0);
    }

    public TerminalNode STAR() {
      return getToken(JavaccParser.STAR, 0);
    }

    public TerminalNode HOOK() {
      return getToken(JavaccParser.HOOK, 0);
    }

    public Expansion_unitContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_expansion_unit;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterExpansion_unit(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitExpansion_unit(this);
    }
  }

  public final Expansion_unitContext expansion_unit() throws RecognitionException {
    Expansion_unitContext _localctx = new Expansion_unitContext(_ctx, getState());
    enterRule(_localctx, 36, RULE_expansion_unit);
    int _la;
    try {
      setState(555);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 40, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(499);
            match(LOOKAHEAD);
            setState(500);
            match(LPAREN);
            setState(501);
            local_lookahead();
            setState(502);
            match(RPAREN);
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(504);
            block();
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(505);
            match(LBRACKET);
            setState(506);
            expansion_choices();
            setState(507);
            match(RBRACKET);
          }
          break;
        case 4:
          enterOuterAlt(_localctx, 4);
          {
            setState(509);
            match(TRY);
            setState(510);
            match(LBRACE);
            setState(511);
            expansion_choices();
            setState(512);
            match(RBRACE);
            setState(524);
            _errHandler.sync(this);
            _la = _input.LA(1);
            while (_la == CATCH) {
              {
                {
                  setState(513);
                  match(CATCH);
                  setState(514);
                  match(LPAREN);
                  setState(518);
                  _errHandler.sync(this);
                  _la = _input.LA(1);
                  if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 67100416L) != 0)
                      || _la == TEMPLATE
                      || _la == IDENTIFIER) {
                    {
                      setState(515);
                      name();
                      setState(516);
                      match(IDENTIFIER);
                    }
                  }

                  setState(520);
                  match(RPAREN);
                  setState(521);
                  block();
                }
              }
              setState(526);
              _errHandler.sync(this);
              _la = _input.LA(1);
            }
            setState(529);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == FINALLY) {
              {
                setState(527);
                match(FINALLY);
                setState(528);
                block();
              }
            }
          }
          break;
        case 5:
          enterOuterAlt(_localctx, 5);
          {
            setState(534);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 35, _ctx)) {
              case 1:
                {
                  setState(531);
                  primaryExpression();
                  setState(532);
                  match(ASSIGN);
                }
                break;
            }
            setState(547);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
              case IDENTIFIER:
                {
                  setState(536);
                  identifier();
                  setState(538);
                  _errHandler.sync(this);
                  _la = _input.LA(1);
                  if (_la == LT) {
                    {
                      setState(537);
                      typeArguments();
                    }
                  }

                  setState(540);
                  arguments();
                }
                break;
              case STRING_LITERAL:
              case LT:
                {
                  setState(542);
                  regular_expression();
                  setState(545);
                  _errHandler.sync(this);
                  _la = _input.LA(1);
                  if (_la == DOT) {
                    {
                      setState(543);
                      match(DOT);
                      setState(544);
                      match(IDENTIFIER);
                    }
                  }
                }
                break;
              default:
                throw new NoViableAltException(this);
            }
          }
          break;
        case 6:
          enterOuterAlt(_localctx, 6);
          {
            setState(549);
            match(LPAREN);
            setState(550);
            expansion_choices();
            setState(551);
            match(RPAREN);
            setState(553);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (((((_la - 109)) & ~0x3f) == 0 && ((1L << (_la - 109)) & 10241L) != 0)) {
              {
                setState(552);
                _la = _input.LA(1);
                if (!(((((_la - 109)) & ~0x3f) == 0 && ((1L << (_la - 109)) & 10241L) != 0))) {
                  _errHandler.recoverInline(this);
                } else {
                  if (_input.LA(1) == Token.EOF) matchedEOF = true;
                  _errHandler.reportMatch(this);
                  consume();
                }
              }
            }
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Regular_expressionContext extends ParserRuleContext {
    public StringLiteralContext stringLiteral() {
      return getRuleContext(StringLiteralContext.class, 0);
    }

    public TerminalNode LT() {
      return getToken(JavaccParser.LT, 0);
    }

    public Complex_regular_expression_choicesContext complex_regular_expression_choices() {
      return getRuleContext(Complex_regular_expression_choicesContext.class, 0);
    }

    public TerminalNode GT() {
      return getToken(JavaccParser.GT, 0);
    }

    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public TerminalNode COLON() {
      return getToken(JavaccParser.COLON, 0);
    }

    public TerminalNode EOF_() {
      return getToken(JavaccParser.EOF_, 0);
    }

    public Regular_expressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_regular_expression;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterRegular_expression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitRegular_expression(this);
    }
  }

  public final Regular_expressionContext regular_expression() throws RecognitionException {
    Regular_expressionContext _localctx = new Regular_expressionContext(_ctx, getState());
    enterRule(_localctx, 38, RULE_regular_expression);
    int _la;
    try {
      setState(577);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 43, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(557);
            stringLiteral();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(558);
            match(LT);
            setState(565);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == T__0 || _la == IDENTIFIER) {
              {
                setState(560);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__0) {
                  {
                    setState(559);
                    match(T__0);
                  }
                }

                setState(562);
                identifier();
                setState(563);
                match(COLON);
              }
            }

            setState(567);
            complex_regular_expression_choices();
            setState(568);
            match(GT);
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(570);
            match(LT);
            setState(571);
            identifier();
            setState(572);
            match(GT);
          }
          break;
        case 4:
          enterOuterAlt(_localctx, 4);
          {
            setState(574);
            match(LT);
            setState(575);
            match(EOF_);
            setState(576);
            match(GT);
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Complex_regular_expression_choicesContext extends ParserRuleContext {
    public List<Complex_regular_expressionContext> complex_regular_expression() {
      return getRuleContexts(Complex_regular_expressionContext.class);
    }

    public Complex_regular_expressionContext complex_regular_expression(int i) {
      return getRuleContext(Complex_regular_expressionContext.class, i);
    }

    public List<TerminalNode> BIT_OR() {
      return getTokens(JavaccParser.BIT_OR);
    }

    public TerminalNode BIT_OR(int i) {
      return getToken(JavaccParser.BIT_OR, i);
    }

    public Complex_regular_expression_choicesContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_complex_regular_expression_choices;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterComplex_regular_expression_choices(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitComplex_regular_expression_choices(this);
    }
  }

  public final Complex_regular_expression_choicesContext complex_regular_expression_choices()
      throws RecognitionException {
    Complex_regular_expression_choicesContext _localctx =
        new Complex_regular_expression_choicesContext(_ctx, getState());
    enterRule(_localctx, 40, RULE_complex_regular_expression_choices);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(579);
        complex_regular_expression();
        setState(584);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == BIT_OR) {
          {
            {
              setState(580);
              match(BIT_OR);
              setState(581);
              complex_regular_expression();
            }
          }
          setState(586);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Complex_regular_expressionContext extends ParserRuleContext {
    public List<Complex_regular_expression_unitContext> complex_regular_expression_unit() {
      return getRuleContexts(Complex_regular_expression_unitContext.class);
    }

    public Complex_regular_expression_unitContext complex_regular_expression_unit(int i) {
      return getRuleContext(Complex_regular_expression_unitContext.class, i);
    }

    public Complex_regular_expressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_complex_regular_expression;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterComplex_regular_expression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitComplex_regular_expression(this);
    }
  }

  public final Complex_regular_expressionContext complex_regular_expression()
      throws RecognitionException {
    Complex_regular_expressionContext _localctx =
        new Complex_regular_expressionContext(_ctx, getState());
    enterRule(_localctx, 42, RULE_complex_regular_expression);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(588);
        _errHandler.sync(this);
        _la = _input.LA(1);
        do {
          {
            {
              setState(587);
              complex_regular_expression_unit();
            }
          }
          setState(590);
          _errHandler.sync(this);
          _la = _input.LA(1);
        } while (((((_la - 95)) & ~0x3f) == 0 && ((1L << (_la - 95)) & 10275L) != 0));
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Complex_regular_expression_unitContext extends ParserRuleContext {
    public StringLiteralContext stringLiteral() {
      return getRuleContext(StringLiteralContext.class, 0);
    }

    public TerminalNode LT() {
      return getToken(JavaccParser.LT, 0);
    }

    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public TerminalNode GT() {
      return getToken(JavaccParser.GT, 0);
    }

    public Character_listContext character_list() {
      return getRuleContext(Character_listContext.class, 0);
    }

    public TerminalNode LPAREN() {
      return getToken(JavaccParser.LPAREN, 0);
    }

    public Complex_regular_expression_choicesContext complex_regular_expression_choices() {
      return getRuleContext(Complex_regular_expression_choicesContext.class, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(JavaccParser.RPAREN, 0);
    }

    public TerminalNode PLUS() {
      return getToken(JavaccParser.PLUS, 0);
    }

    public TerminalNode STAR() {
      return getToken(JavaccParser.STAR, 0);
    }

    public TerminalNode HOOK() {
      return getToken(JavaccParser.HOOK, 0);
    }

    public TerminalNode LBRACE() {
      return getToken(JavaccParser.LBRACE, 0);
    }

    public List<IntegerLiteralContext> integerLiteral() {
      return getRuleContexts(IntegerLiteralContext.class);
    }

    public IntegerLiteralContext integerLiteral(int i) {
      return getRuleContext(IntegerLiteralContext.class, i);
    }

    public TerminalNode RBRACE() {
      return getToken(JavaccParser.RBRACE, 0);
    }

    public TerminalNode COMMA() {
      return getToken(JavaccParser.COMMA, 0);
    }

    public Complex_regular_expression_unitContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_complex_regular_expression_unit;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterComplex_regular_expression_unit(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitComplex_regular_expression_unit(this);
    }
  }

  public final Complex_regular_expression_unitContext complex_regular_expression_unit()
      throws RecognitionException {
    Complex_regular_expression_unitContext _localctx =
        new Complex_regular_expression_unitContext(_ctx, getState());
    enterRule(_localctx, 44, RULE_complex_regular_expression_unit);
    int _la;
    try {
      setState(616);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case STRING_LITERAL:
          enterOuterAlt(_localctx, 1);
          {
            setState(592);
            stringLiteral();
          }
          break;
        case LT:
          enterOuterAlt(_localctx, 2);
          {
            setState(593);
            match(LT);
            setState(594);
            identifier();
            setState(595);
            match(GT);
          }
          break;
        case LBRACKET:
        case TILDE:
          enterOuterAlt(_localctx, 3);
          {
            setState(597);
            character_list();
          }
          break;
        case LPAREN:
          enterOuterAlt(_localctx, 4);
          {
            setState(598);
            match(LPAREN);
            setState(599);
            complex_regular_expression_choices();
            setState(600);
            match(RPAREN);
            setState(614);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
              case PLUS:
                {
                  setState(601);
                  match(PLUS);
                }
                break;
              case STAR:
                {
                  setState(602);
                  match(STAR);
                }
                break;
              case HOOK:
                {
                  setState(603);
                  match(HOOK);
                }
                break;
              case LBRACE:
                {
                  setState(604);
                  match(LBRACE);
                  setState(605);
                  integerLiteral();
                  setState(610);
                  _errHandler.sync(this);
                  _la = _input.LA(1);
                  if (_la == COMMA) {
                    {
                      setState(606);
                      match(COMMA);
                      setState(608);
                      _errHandler.sync(this);
                      _la = _input.LA(1);
                      if (_la == INTEGER_LITERAL) {
                        {
                          setState(607);
                          integerLiteral();
                        }
                      }
                    }
                  }

                  setState(612);
                  match(RBRACE);
                }
                break;
              case STRING_LITERAL:
              case LPAREN:
              case RPAREN:
              case LBRACKET:
              case LT:
              case TILDE:
              case BIT_OR:
              case GT:
                break;
              default:
                break;
            }
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Character_listContext extends ParserRuleContext {
    public TerminalNode LBRACKET() {
      return getToken(JavaccParser.LBRACKET, 0);
    }

    public TerminalNode RBRACKET() {
      return getToken(JavaccParser.RBRACKET, 0);
    }

    public TerminalNode TILDE() {
      return getToken(JavaccParser.TILDE, 0);
    }

    public List<Character_descriptorContext> character_descriptor() {
      return getRuleContexts(Character_descriptorContext.class);
    }

    public Character_descriptorContext character_descriptor(int i) {
      return getRuleContext(Character_descriptorContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(JavaccParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(JavaccParser.COMMA, i);
    }

    public Character_listContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_character_list;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterCharacter_list(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitCharacter_list(this);
    }
  }

  public final Character_listContext character_list() throws RecognitionException {
    Character_listContext _localctx = new Character_listContext(_ctx, getState());
    enterRule(_localctx, 46, RULE_character_list);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(619);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == TILDE) {
          {
            setState(618);
            match(TILDE);
          }
        }

        setState(621);
        match(LBRACKET);
        setState(630);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == STRING_LITERAL) {
          {
            setState(622);
            character_descriptor();
            setState(627);
            _errHandler.sync(this);
            _la = _input.LA(1);
            while (_la == COMMA) {
              {
                {
                  setState(623);
                  match(COMMA);
                  setState(624);
                  character_descriptor();
                }
              }
              setState(629);
              _errHandler.sync(this);
              _la = _input.LA(1);
            }
          }
        }

        setState(632);
        match(RBRACKET);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Character_descriptorContext extends ParserRuleContext {
    public List<StringLiteralContext> stringLiteral() {
      return getRuleContexts(StringLiteralContext.class);
    }

    public StringLiteralContext stringLiteral(int i) {
      return getRuleContext(StringLiteralContext.class, i);
    }

    public TerminalNode MINUS() {
      return getToken(JavaccParser.MINUS, 0);
    }

    public Character_descriptorContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_character_descriptor;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterCharacter_descriptor(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitCharacter_descriptor(this);
    }
  }

  public final Character_descriptorContext character_descriptor() throws RecognitionException {
    Character_descriptorContext _localctx = new Character_descriptorContext(_ctx, getState());
    enterRule(_localctx, 48, RULE_character_descriptor);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(634);
        stringLiteral();
        setState(637);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == MINUS) {
          {
            setState(635);
            match(MINUS);
            setState(636);
            stringLiteral();
          }
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class IdentifierContext extends ParserRuleContext {
    public TerminalNode IDENTIFIER() {
      return getToken(JavaccParser.IDENTIFIER, 0);
    }

    public IdentifierContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_identifier;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterIdentifier(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitIdentifier(this);
    }
  }

  public final IdentifierContext identifier() throws RecognitionException {
    IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
    enterRule(_localctx, 50, RULE_identifier);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(639);
        match(IDENTIFIER);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Node_descriptorContext extends ParserRuleContext {
    public TerminalNode IDENTIFIER() {
      return getToken(JavaccParser.IDENTIFIER, 0);
    }

    public TerminalNode VOID() {
      return getToken(JavaccParser.VOID, 0);
    }

    public TerminalNode LPAREN() {
      return getToken(JavaccParser.LPAREN, 0);
    }

    public Node_descriptor_expressionContext node_descriptor_expression() {
      return getRuleContext(Node_descriptor_expressionContext.class, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(JavaccParser.RPAREN, 0);
    }

    public TerminalNode GT() {
      return getToken(JavaccParser.GT, 0);
    }

    public Node_descriptorContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_node_descriptor;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterNode_descriptor(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitNode_descriptor(this);
    }
  }

  public final Node_descriptorContext node_descriptor() throws RecognitionException {
    Node_descriptorContext _localctx = new Node_descriptorContext(_ctx, getState());
    enterRule(_localctx, 52, RULE_node_descriptor);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(641);
        match(T__0);
        setState(642);
        _la = _input.LA(1);
        if (!(_la == VOID || _la == IDENTIFIER)) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF) matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
        setState(650);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 55, _ctx)) {
          case 1:
            {
              setState(643);
              match(LPAREN);
              setState(645);
              _errHandler.sync(this);
              switch (getInterpreter().adaptivePredict(_input, 54, _ctx)) {
                case 1:
                  {
                    setState(644);
                    match(GT);
                  }
                  break;
              }
              setState(647);
              node_descriptor_expression();
              setState(648);
              match(RPAREN);
            }
            break;
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Node_descriptor_expressionContext extends ParserRuleContext {
    public List<TerminalNode> LPAREN() {
      return getTokens(JavaccParser.LPAREN);
    }

    public TerminalNode LPAREN(int i) {
      return getToken(JavaccParser.LPAREN, i);
    }

    public Node_descriptor_expressionContext node_descriptor_expression() {
      return getRuleContext(Node_descriptor_expressionContext.class, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(JavaccParser.RPAREN, 0);
    }

    public Node_descriptor_expressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_node_descriptor_expression;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterNode_descriptor_expression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitNode_descriptor_expression(this);
    }
  }

  public final Node_descriptor_expressionContext node_descriptor_expression()
      throws RecognitionException {
    Node_descriptor_expressionContext _localctx =
        new Node_descriptor_expressionContext(_ctx, getState());
    enterRule(_localctx, 54, RULE_node_descriptor_expression);
    int _la;
    try {
      int _alt;
      setState(662);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__0:
        case T__1:
        case T__2:
        case T__3:
        case T__4:
        case T__5:
        case T__6:
        case LOOKAHEAD:
        case IGNORE_CASE:
        case PARSER_BEGIN:
        case PARSER_END:
        case JAVACODE:
        case CPPCODE:
        case TOKEN:
        case SPECIAL_TOKEN:
        case MORE_:
        case SKIP_:
        case TOKEN_MGR_DECLS:
        case EOF_:
        case DCL_PARSER_BEGIN:
        case DCL_PARSER_END:
        case INC_PARSER_BEGIN:
        case INC_PARSER_END:
        case DEF_PARSER_BEGIN:
        case DEF_PARSER_END:
        case WS:
        case COMMENT:
        case LINE_COMMENT:
        case ABSTRACT:
        case ASSERT:
        case BOOLEAN:
        case BREAK:
        case BYTE:
        case CASE:
        case CATCH:
        case CHAR:
        case CLASS:
        case CONST:
        case CONTINUE:
        case DEFAULT:
        case DO:
        case DOUBLE:
        case ELSE:
        case ENUM:
        case EXTENDS:
        case FALSE:
        case FINAL:
        case FINALLY:
        case FLOAT:
        case FOR:
        case GOTO:
        case IF:
        case IMPLEMENTS:
        case IMPORT:
        case INSTANCEOF:
        case INT:
        case INTERFACE:
        case LONG:
        case NATIVE:
        case NEW:
        case NULL:
        case PACKAGE:
        case PRIVATE:
        case PROTECTED:
        case PUBLIC:
        case RETURN:
        case SHORT:
        case STATIC:
        case STRICTFP:
        case SUPER:
        case SWITCH:
        case SYNCHRONIZED:
        case THIS:
        case THROW:
        case THROWS:
        case TRANSIENT:
        case TRUE:
        case TRY:
        case VOID:
        case VOLATILE:
        case WHILE:
        case TEMPLATE:
        case TYPENAME:
        case INTEGER_LITERAL:
        case DECIMAL_LITERAL:
        case HEX_LITERAL:
        case OCTAL_LITERAL:
        case BINARY_LITERAL:
        case FLOATING_POINT_LITERAL:
        case DECIMAL_FLOATING_POINT_LITERAL:
        case DECIMAL_EXPONENT:
        case HEXADECIMAL_FLOATING_POINT_LITERAL:
        case HEXADECIMAL_EXPONENT:
        case CHARACTER_LITERAL:
        case STRING_LITERAL:
        case RPAREN:
        case LBRACE:
        case RBRACE:
        case LBRACKET:
        case RBRACKET:
        case SEMICOLON:
        case COMMA:
        case DOT:
        case ASSIGN:
        case LT:
        case BANG:
        case TILDE:
        case HOOK:
        case COLON:
        case DOUBLECOLON:
        case EQ:
        case LE:
        case GE:
        case NE:
        case SC_OR:
        case SC_AND:
        case INCR:
        case DECR:
        case PLUS:
        case MINUS:
        case STAR:
        case SLASH:
        case BIT_AND:
        case BIT_OR:
        case XOR:
        case REM:
        case PLUSASSIGN:
        case MINUSASSIGN:
        case STARASSIGN:
        case SLASHASSIGN:
        case ANDASSIGN:
        case ORASSIGN:
        case XORASSIGN:
        case REMASSIGN:
        case GT:
        case IDENTIFIER:
          enterOuterAlt(_localctx, 1);
          {
            setState(655);
            _errHandler.sync(this);
            _alt = getInterpreter().adaptivePredict(_input, 56, _ctx);
            while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
              if (_alt == 1) {
                {
                  {
                    setState(652);
                    _la = _input.LA(1);
                    if (_la <= 0 || (_la == LPAREN)) {
                      _errHandler.recoverInline(this);
                    } else {
                      if (_input.LA(1) == Token.EOF) matchedEOF = true;
                      _errHandler.reportMatch(this);
                      consume();
                    }
                  }
                }
              }
              setState(657);
              _errHandler.sync(this);
              _alt = getInterpreter().adaptivePredict(_input, 56, _ctx);
            }
          }
          break;
        case LPAREN:
          enterOuterAlt(_localctx, 2);
          {
            setState(658);
            match(LPAREN);
            setState(659);
            node_descriptor_expression();
            setState(660);
            match(RPAREN);
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class JavaIdentifierContext extends ParserRuleContext {
    public TerminalNode IDENTIFIER() {
      return getToken(JavaccParser.IDENTIFIER, 0);
    }

    public TerminalNode LOOKAHEAD() {
      return getToken(JavaccParser.LOOKAHEAD, 0);
    }

    public TerminalNode IGNORE_CASE() {
      return getToken(JavaccParser.IGNORE_CASE, 0);
    }

    public TerminalNode PARSER_BEGIN() {
      return getToken(JavaccParser.PARSER_BEGIN, 0);
    }

    public TerminalNode PARSER_END() {
      return getToken(JavaccParser.PARSER_END, 0);
    }

    public TerminalNode JAVACODE() {
      return getToken(JavaccParser.JAVACODE, 0);
    }

    public TerminalNode TOKEN() {
      return getToken(JavaccParser.TOKEN, 0);
    }

    public TerminalNode SPECIAL_TOKEN() {
      return getToken(JavaccParser.SPECIAL_TOKEN, 0);
    }

    public TerminalNode MORE_() {
      return getToken(JavaccParser.MORE_, 0);
    }

    public TerminalNode SKIP_() {
      return getToken(JavaccParser.SKIP_, 0);
    }

    public TerminalNode TOKEN_MGR_DECLS() {
      return getToken(JavaccParser.TOKEN_MGR_DECLS, 0);
    }

    public TerminalNode EOF_() {
      return getToken(JavaccParser.EOF_, 0);
    }

    public TerminalNode TEMPLATE() {
      return getToken(JavaccParser.TEMPLATE, 0);
    }

    public TerminalNode DCL_PARSER_BEGIN() {
      return getToken(JavaccParser.DCL_PARSER_BEGIN, 0);
    }

    public TerminalNode DCL_PARSER_END() {
      return getToken(JavaccParser.DCL_PARSER_END, 0);
    }

    public TerminalNode INC_PARSER_BEGIN() {
      return getToken(JavaccParser.INC_PARSER_BEGIN, 0);
    }

    public TerminalNode INC_PARSER_END() {
      return getToken(JavaccParser.INC_PARSER_END, 0);
    }

    public TerminalNode DEF_PARSER_BEGIN() {
      return getToken(JavaccParser.DEF_PARSER_BEGIN, 0);
    }

    public TerminalNode DEF_PARSER_END() {
      return getToken(JavaccParser.DEF_PARSER_END, 0);
    }

    public JavaIdentifierContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_javaIdentifier;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterJavaIdentifier(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitJavaIdentifier(this);
    }
  }

  public final JavaIdentifierContext javaIdentifier() throws RecognitionException {
    JavaIdentifierContext _localctx = new JavaIdentifierContext(_ctx, getState());
    enterRule(_localctx, 56, RULE_javaIdentifier);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(664);
        _la = _input.LA(1);
        if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 67100416L) != 0)
            || _la == TEMPLATE
            || _la == IDENTIFIER)) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF) matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class CompilationUnitContext extends ParserRuleContext {
    public PackageDeclarationContext packageDeclaration() {
      return getRuleContext(PackageDeclarationContext.class, 0);
    }

    public List<ImportDeclarationContext> importDeclaration() {
      return getRuleContexts(ImportDeclarationContext.class);
    }

    public ImportDeclarationContext importDeclaration(int i) {
      return getRuleContext(ImportDeclarationContext.class, i);
    }

    public List<TypeDeclarationContext> typeDeclaration() {
      return getRuleContexts(TypeDeclarationContext.class);
    }

    public TypeDeclarationContext typeDeclaration(int i) {
      return getRuleContext(TypeDeclarationContext.class, i);
    }

    public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_compilationUnit;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterCompilationUnit(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitCompilationUnit(this);
    }
  }

  public final CompilationUnitContext compilationUnit() throws RecognitionException {
    CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
    enterRule(_localctx, 58, RULE_compilationUnit);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(667);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 58, _ctx)) {
          case 1:
            {
              setState(666);
              packageDeclaration();
            }
            break;
        }
        setState(672);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == IMPORT) {
          {
            {
              setState(669);
              importDeclaration();
            }
          }
          setState(674);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(678);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8502637628825272192L) != 0)
            || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 274877976883L) != 0)) {
          {
            {
              setState(675);
              typeDeclaration();
            }
          }
          setState(680);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PackageDeclarationContext extends ParserRuleContext {
    public ModifiersContext modifiers() {
      return getRuleContext(ModifiersContext.class, 0);
    }

    public TerminalNode PACKAGE() {
      return getToken(JavaccParser.PACKAGE, 0);
    }

    public NameContext name() {
      return getRuleContext(NameContext.class, 0);
    }

    public TerminalNode SEMICOLON() {
      return getToken(JavaccParser.SEMICOLON, 0);
    }

    public PackageDeclarationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_packageDeclaration;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterPackageDeclaration(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitPackageDeclaration(this);
    }
  }

  public final PackageDeclarationContext packageDeclaration() throws RecognitionException {
    PackageDeclarationContext _localctx = new PackageDeclarationContext(_ctx, getState());
    enterRule(_localctx, 60, RULE_packageDeclaration);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(681);
        modifiers();
        setState(682);
        match(PACKAGE);
        setState(683);
        name();
        setState(684);
        match(SEMICOLON);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ImportDeclarationContext extends ParserRuleContext {
    public TerminalNode IMPORT() {
      return getToken(JavaccParser.IMPORT, 0);
    }

    public NameContext name() {
      return getRuleContext(NameContext.class, 0);
    }

    public TerminalNode SEMICOLON() {
      return getToken(JavaccParser.SEMICOLON, 0);
    }

    public TerminalNode STATIC() {
      return getToken(JavaccParser.STATIC, 0);
    }

    public TerminalNode DOT() {
      return getToken(JavaccParser.DOT, 0);
    }

    public TerminalNode STAR() {
      return getToken(JavaccParser.STAR, 0);
    }

    public ImportDeclarationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_importDeclaration;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterImportDeclaration(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitImportDeclaration(this);
    }
  }

  public final ImportDeclarationContext importDeclaration() throws RecognitionException {
    ImportDeclarationContext _localctx = new ImportDeclarationContext(_ctx, getState());
    enterRule(_localctx, 62, RULE_importDeclaration);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(686);
        match(IMPORT);
        setState(688);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == STATIC) {
          {
            setState(687);
            match(STATIC);
          }
        }

        setState(690);
        name();
        setState(693);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == DOT) {
          {
            setState(691);
            match(DOT);
            setState(692);
            match(STAR);
          }
        }

        setState(695);
        match(SEMICOLON);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ModifiersContext extends ParserRuleContext {
    public List<TerminalNode> PUBLIC() {
      return getTokens(JavaccParser.PUBLIC);
    }

    public TerminalNode PUBLIC(int i) {
      return getToken(JavaccParser.PUBLIC, i);
    }

    public List<TerminalNode> STATIC() {
      return getTokens(JavaccParser.STATIC);
    }

    public TerminalNode STATIC(int i) {
      return getToken(JavaccParser.STATIC, i);
    }

    public List<TerminalNode> PROTECTED() {
      return getTokens(JavaccParser.PROTECTED);
    }

    public TerminalNode PROTECTED(int i) {
      return getToken(JavaccParser.PROTECTED, i);
    }

    public List<TerminalNode> PRIVATE() {
      return getTokens(JavaccParser.PRIVATE);
    }

    public TerminalNode PRIVATE(int i) {
      return getToken(JavaccParser.PRIVATE, i);
    }

    public List<TerminalNode> FINAL() {
      return getTokens(JavaccParser.FINAL);
    }

    public TerminalNode FINAL(int i) {
      return getToken(JavaccParser.FINAL, i);
    }

    public List<TerminalNode> ABSTRACT() {
      return getTokens(JavaccParser.ABSTRACT);
    }

    public TerminalNode ABSTRACT(int i) {
      return getToken(JavaccParser.ABSTRACT, i);
    }

    public List<TerminalNode> SYNCHRONIZED() {
      return getTokens(JavaccParser.SYNCHRONIZED);
    }

    public TerminalNode SYNCHRONIZED(int i) {
      return getToken(JavaccParser.SYNCHRONIZED, i);
    }

    public List<TerminalNode> NATIVE() {
      return getTokens(JavaccParser.NATIVE);
    }

    public TerminalNode NATIVE(int i) {
      return getToken(JavaccParser.NATIVE, i);
    }

    public List<TerminalNode> TRANSIENT() {
      return getTokens(JavaccParser.TRANSIENT);
    }

    public TerminalNode TRANSIENT(int i) {
      return getToken(JavaccParser.TRANSIENT, i);
    }

    public List<TerminalNode> VOLATILE() {
      return getTokens(JavaccParser.VOLATILE);
    }

    public TerminalNode VOLATILE(int i) {
      return getToken(JavaccParser.VOLATILE, i);
    }

    public List<TerminalNode> STRICTFP() {
      return getTokens(JavaccParser.STRICTFP);
    }

    public TerminalNode STRICTFP(int i) {
      return getToken(JavaccParser.STRICTFP, i);
    }

    public List<AnnotationContext> annotation() {
      return getRuleContexts(AnnotationContext.class);
    }

    public AnnotationContext annotation(int i) {
      return getRuleContext(AnnotationContext.class, i);
    }

    public ModifiersContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_modifiers;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterModifiers(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitModifiers(this);
    }
  }

  public final ModifiersContext modifiers() throws RecognitionException {
    ModifiersContext _localctx = new ModifiersContext(_ctx, getState());
    enterRule(_localctx, 64, RULE_modifiers);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(713);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 64, _ctx);
        while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            {
              {
                setState(709);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                  case PUBLIC:
                    {
                      setState(697);
                      match(PUBLIC);
                    }
                    break;
                  case STATIC:
                    {
                      setState(698);
                      match(STATIC);
                    }
                    break;
                  case PROTECTED:
                    {
                      setState(699);
                      match(PROTECTED);
                    }
                    break;
                  case PRIVATE:
                    {
                      setState(700);
                      match(PRIVATE);
                    }
                    break;
                  case FINAL:
                    {
                      setState(701);
                      match(FINAL);
                    }
                    break;
                  case ABSTRACT:
                    {
                      setState(702);
                      match(ABSTRACT);
                    }
                    break;
                  case SYNCHRONIZED:
                    {
                      setState(703);
                      match(SYNCHRONIZED);
                    }
                    break;
                  case NATIVE:
                    {
                      setState(704);
                      match(NATIVE);
                    }
                    break;
                  case TRANSIENT:
                    {
                      setState(705);
                      match(TRANSIENT);
                    }
                    break;
                  case VOLATILE:
                    {
                      setState(706);
                      match(VOLATILE);
                    }
                    break;
                  case STRICTFP:
                    {
                      setState(707);
                      match(STRICTFP);
                    }
                    break;
                  case T__6:
                    {
                      setState(708);
                      annotation();
                    }
                    break;
                  default:
                    throw new NoViableAltException(this);
                }
              }
            }
          }
          setState(715);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 64, _ctx);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class TypeDeclarationContext extends ParserRuleContext {
    public TerminalNode SEMICOLON() {
      return getToken(JavaccParser.SEMICOLON, 0);
    }

    public ModifiersContext modifiers() {
      return getRuleContext(ModifiersContext.class, 0);
    }

    public ClassOrInterfaceDeclarationContext classOrInterfaceDeclaration() {
      return getRuleContext(ClassOrInterfaceDeclarationContext.class, 0);
    }

    public EnumDeclarationContext enumDeclaration() {
      return getRuleContext(EnumDeclarationContext.class, 0);
    }

    public AnnotationTypeDeclarationContext annotationTypeDeclaration() {
      return getRuleContext(AnnotationTypeDeclarationContext.class, 0);
    }

    public TypeDeclarationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_typeDeclaration;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterTypeDeclaration(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitTypeDeclaration(this);
    }
  }

  public final TypeDeclarationContext typeDeclaration() throws RecognitionException {
    TypeDeclarationContext _localctx = new TypeDeclarationContext(_ctx, getState());
    enterRule(_localctx, 66, RULE_typeDeclaration);
    try {
      setState(723);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case SEMICOLON:
          enterOuterAlt(_localctx, 1);
          {
            setState(716);
            match(SEMICOLON);
          }
          break;
        case T__6:
        case ABSTRACT:
        case CLASS:
        case ENUM:
        case FINAL:
        case INTERFACE:
        case NATIVE:
        case PRIVATE:
        case PROTECTED:
        case PUBLIC:
        case STATIC:
        case STRICTFP:
        case SYNCHRONIZED:
        case TRANSIENT:
        case VOLATILE:
          enterOuterAlt(_localctx, 2);
          {
            setState(717);
            modifiers();
            setState(721);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
              case CLASS:
              case INTERFACE:
                {
                  setState(718);
                  classOrInterfaceDeclaration();
                }
                break;
              case ENUM:
                {
                  setState(719);
                  enumDeclaration();
                }
                break;
              case T__6:
                {
                  setState(720);
                  annotationTypeDeclaration();
                }
                break;
              default:
                throw new NoViableAltException(this);
            }
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ClassOrInterfaceDeclarationContext extends ParserRuleContext {
    public JavaIdentifierContext javaIdentifier() {
      return getRuleContext(JavaIdentifierContext.class, 0);
    }

    public ClassOrInterfaceBodyContext classOrInterfaceBody() {
      return getRuleContext(ClassOrInterfaceBodyContext.class, 0);
    }

    public TerminalNode CLASS() {
      return getToken(JavaccParser.CLASS, 0);
    }

    public TerminalNode INTERFACE() {
      return getToken(JavaccParser.INTERFACE, 0);
    }

    public TypeParametersContext typeParameters() {
      return getRuleContext(TypeParametersContext.class, 0);
    }

    public ExtendsListContext extendsList() {
      return getRuleContext(ExtendsListContext.class, 0);
    }

    public ImplementsListContext implementsList() {
      return getRuleContext(ImplementsListContext.class, 0);
    }

    public ClassOrInterfaceDeclarationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_classOrInterfaceDeclaration;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterClassOrInterfaceDeclaration(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitClassOrInterfaceDeclaration(this);
    }
  }

  public final ClassOrInterfaceDeclarationContext classOrInterfaceDeclaration()
      throws RecognitionException {
    ClassOrInterfaceDeclarationContext _localctx =
        new ClassOrInterfaceDeclarationContext(_ctx, getState());
    enterRule(_localctx, 68, RULE_classOrInterfaceDeclaration);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(725);
        _la = _input.LA(1);
        if (!(_la == CLASS || _la == INTERFACE)) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF) matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
        setState(726);
        javaIdentifier();
        setState(728);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == LT) {
          {
            setState(727);
            typeParameters();
          }
        }

        setState(731);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == EXTENDS) {
          {
            setState(730);
            extendsList();
          }
        }

        setState(734);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == IMPLEMENTS) {
          {
            setState(733);
            implementsList();
          }
        }

        setState(736);
        classOrInterfaceBody();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ExtendsListContext extends ParserRuleContext {
    public TerminalNode EXTENDS() {
      return getToken(JavaccParser.EXTENDS, 0);
    }

    public List<ClassOrInterfaceTypeContext> classOrInterfaceType() {
      return getRuleContexts(ClassOrInterfaceTypeContext.class);
    }

    public ClassOrInterfaceTypeContext classOrInterfaceType(int i) {
      return getRuleContext(ClassOrInterfaceTypeContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(JavaccParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(JavaccParser.COMMA, i);
    }

    public ExtendsListContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_extendsList;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterExtendsList(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitExtendsList(this);
    }
  }

  public final ExtendsListContext extendsList() throws RecognitionException {
    ExtendsListContext _localctx = new ExtendsListContext(_ctx, getState());
    enterRule(_localctx, 70, RULE_extendsList);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(738);
        match(EXTENDS);
        setState(739);
        classOrInterfaceType();
        setState(744);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == COMMA) {
          {
            {
              setState(740);
              match(COMMA);
              setState(741);
              classOrInterfaceType();
            }
          }
          setState(746);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ImplementsListContext extends ParserRuleContext {
    public TerminalNode IMPLEMENTS() {
      return getToken(JavaccParser.IMPLEMENTS, 0);
    }

    public List<ClassOrInterfaceTypeContext> classOrInterfaceType() {
      return getRuleContexts(ClassOrInterfaceTypeContext.class);
    }

    public ClassOrInterfaceTypeContext classOrInterfaceType(int i) {
      return getRuleContext(ClassOrInterfaceTypeContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(JavaccParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(JavaccParser.COMMA, i);
    }

    public ImplementsListContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_implementsList;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterImplementsList(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitImplementsList(this);
    }
  }

  public final ImplementsListContext implementsList() throws RecognitionException {
    ImplementsListContext _localctx = new ImplementsListContext(_ctx, getState());
    enterRule(_localctx, 72, RULE_implementsList);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(747);
        match(IMPLEMENTS);
        setState(748);
        classOrInterfaceType();
        setState(753);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == COMMA) {
          {
            {
              setState(749);
              match(COMMA);
              setState(750);
              classOrInterfaceType();
            }
          }
          setState(755);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class EnumDeclarationContext extends ParserRuleContext {
    public TerminalNode ENUM() {
      return getToken(JavaccParser.ENUM, 0);
    }

    public JavaIdentifierContext javaIdentifier() {
      return getRuleContext(JavaIdentifierContext.class, 0);
    }

    public EnumBodyContext enumBody() {
      return getRuleContext(EnumBodyContext.class, 0);
    }

    public ImplementsListContext implementsList() {
      return getRuleContext(ImplementsListContext.class, 0);
    }

    public EnumDeclarationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_enumDeclaration;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterEnumDeclaration(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitEnumDeclaration(this);
    }
  }

  public final EnumDeclarationContext enumDeclaration() throws RecognitionException {
    EnumDeclarationContext _localctx = new EnumDeclarationContext(_ctx, getState());
    enterRule(_localctx, 74, RULE_enumDeclaration);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(756);
        match(ENUM);
        setState(757);
        javaIdentifier();
        setState(759);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == IMPLEMENTS) {
          {
            setState(758);
            implementsList();
          }
        }

        setState(761);
        enumBody();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class EnumBodyContext extends ParserRuleContext {
    public TerminalNode LBRACE() {
      return getToken(JavaccParser.LBRACE, 0);
    }

    public TerminalNode RBRACE() {
      return getToken(JavaccParser.RBRACE, 0);
    }

    public List<EnumConstantContext> enumConstant() {
      return getRuleContexts(EnumConstantContext.class);
    }

    public EnumConstantContext enumConstant(int i) {
      return getRuleContext(EnumConstantContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(JavaccParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(JavaccParser.COMMA, i);
    }

    public TerminalNode SEMICOLON() {
      return getToken(JavaccParser.SEMICOLON, 0);
    }

    public List<ClassOrInterfaceBodyDeclarationContext> classOrInterfaceBodyDeclaration() {
      return getRuleContexts(ClassOrInterfaceBodyDeclarationContext.class);
    }

    public ClassOrInterfaceBodyDeclarationContext classOrInterfaceBodyDeclaration(int i) {
      return getRuleContext(ClassOrInterfaceBodyDeclarationContext.class, i);
    }

    public EnumBodyContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_enumBody;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterEnumBody(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitEnumBody(this);
    }
  }

  public final EnumBodyContext enumBody() throws RecognitionException {
    EnumBodyContext _localctx = new EnumBodyContext(_ctx, getState());
    enterRule(_localctx, 76, RULE_enumBody);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(763);
        match(LBRACE);
        setState(772);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8646770546459025536L) != 0)
            || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 332083L) != 0)
            || _la == IDENTIFIER) {
          {
            setState(764);
            enumConstant();
            setState(769);
            _errHandler.sync(this);
            _alt = getInterpreter().adaptivePredict(_input, 73, _ctx);
            while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
              if (_alt == 1) {
                {
                  {
                    setState(765);
                    match(COMMA);
                    setState(766);
                    enumConstant();
                  }
                }
              }
              setState(771);
              _errHandler.sync(this);
              _alt = getInterpreter().adaptivePredict(_input, 73, _ctx);
            }
          }
        }

        setState(775);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == COMMA) {
          {
            setState(774);
            match(COMMA);
          }
        }

        setState(784);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == SEMICOLON) {
          {
            setState(777);
            match(SEMICOLON);
            setState(781);
            _errHandler.sync(this);
            _la = _input.LA(1);
            while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8141781956233797760L) != 0)
                || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 145427593007419L) != 0)
                || _la == IDENTIFIER) {
              {
                {
                  setState(778);
                  classOrInterfaceBodyDeclaration();
                }
              }
              setState(783);
              _errHandler.sync(this);
              _la = _input.LA(1);
            }
          }
        }

        setState(786);
        match(RBRACE);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class EnumConstantContext extends ParserRuleContext {
    public ModifiersContext modifiers() {
      return getRuleContext(ModifiersContext.class, 0);
    }

    public JavaIdentifierContext javaIdentifier() {
      return getRuleContext(JavaIdentifierContext.class, 0);
    }

    public ArgumentsContext arguments() {
      return getRuleContext(ArgumentsContext.class, 0);
    }

    public ClassOrInterfaceBodyContext classOrInterfaceBody() {
      return getRuleContext(ClassOrInterfaceBodyContext.class, 0);
    }

    public EnumConstantContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_enumConstant;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterEnumConstant(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitEnumConstant(this);
    }
  }

  public final EnumConstantContext enumConstant() throws RecognitionException {
    EnumConstantContext _localctx = new EnumConstantContext(_ctx, getState());
    enterRule(_localctx, 78, RULE_enumConstant);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(788);
        modifiers();
        setState(789);
        javaIdentifier();
        setState(791);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == LPAREN) {
          {
            setState(790);
            arguments();
          }
        }

        setState(794);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == LBRACE) {
          {
            setState(793);
            classOrInterfaceBody();
          }
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class TypeParametersContext extends ParserRuleContext {
    public TerminalNode LT() {
      return getToken(JavaccParser.LT, 0);
    }

    public List<TypeParameterContext> typeParameter() {
      return getRuleContexts(TypeParameterContext.class);
    }

    public TypeParameterContext typeParameter(int i) {
      return getRuleContext(TypeParameterContext.class, i);
    }

    public TerminalNode GT() {
      return getToken(JavaccParser.GT, 0);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(JavaccParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(JavaccParser.COMMA, i);
    }

    public TypeParametersContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_typeParameters;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterTypeParameters(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitTypeParameters(this);
    }
  }

  public final TypeParametersContext typeParameters() throws RecognitionException {
    TypeParametersContext _localctx = new TypeParametersContext(_ctx, getState());
    enterRule(_localctx, 80, RULE_typeParameters);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(796);
        match(LT);
        setState(797);
        typeParameter();
        setState(802);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == COMMA) {
          {
            {
              setState(798);
              match(COMMA);
              setState(799);
              typeParameter();
            }
          }
          setState(804);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(805);
        match(GT);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class TypeParameterContext extends ParserRuleContext {
    public JavaIdentifierContext javaIdentifier() {
      return getRuleContext(JavaIdentifierContext.class, 0);
    }

    public TypeBoundContext typeBound() {
      return getRuleContext(TypeBoundContext.class, 0);
    }

    public TypeParameterContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_typeParameter;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterTypeParameter(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitTypeParameter(this);
    }
  }

  public final TypeParameterContext typeParameter() throws RecognitionException {
    TypeParameterContext _localctx = new TypeParameterContext(_ctx, getState());
    enterRule(_localctx, 82, RULE_typeParameter);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(807);
        javaIdentifier();
        setState(809);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == EXTENDS) {
          {
            setState(808);
            typeBound();
          }
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class TypeBoundContext extends ParserRuleContext {
    public TerminalNode EXTENDS() {
      return getToken(JavaccParser.EXTENDS, 0);
    }

    public List<ClassOrInterfaceTypeContext> classOrInterfaceType() {
      return getRuleContexts(ClassOrInterfaceTypeContext.class);
    }

    public ClassOrInterfaceTypeContext classOrInterfaceType(int i) {
      return getRuleContext(ClassOrInterfaceTypeContext.class, i);
    }

    public List<TerminalNode> BIT_AND() {
      return getTokens(JavaccParser.BIT_AND);
    }

    public TerminalNode BIT_AND(int i) {
      return getToken(JavaccParser.BIT_AND, i);
    }

    public TypeBoundContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_typeBound;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterTypeBound(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitTypeBound(this);
    }
  }

  public final TypeBoundContext typeBound() throws RecognitionException {
    TypeBoundContext _localctx = new TypeBoundContext(_ctx, getState());
    enterRule(_localctx, 84, RULE_typeBound);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(811);
        match(EXTENDS);
        setState(812);
        classOrInterfaceType();
        setState(817);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == BIT_AND) {
          {
            {
              setState(813);
              match(BIT_AND);
              setState(814);
              classOrInterfaceType();
            }
          }
          setState(819);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ClassOrInterfaceBodyContext extends ParserRuleContext {
    public TerminalNode LBRACE() {
      return getToken(JavaccParser.LBRACE, 0);
    }

    public TerminalNode RBRACE() {
      return getToken(JavaccParser.RBRACE, 0);
    }

    public List<ClassOrInterfaceBodyDeclarationContext> classOrInterfaceBodyDeclaration() {
      return getRuleContexts(ClassOrInterfaceBodyDeclarationContext.class);
    }

    public ClassOrInterfaceBodyDeclarationContext classOrInterfaceBodyDeclaration(int i) {
      return getRuleContext(ClassOrInterfaceBodyDeclarationContext.class, i);
    }

    public ClassOrInterfaceBodyContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_classOrInterfaceBody;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterClassOrInterfaceBody(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitClassOrInterfaceBody(this);
    }
  }

  public final ClassOrInterfaceBodyContext classOrInterfaceBody() throws RecognitionException {
    ClassOrInterfaceBodyContext _localctx = new ClassOrInterfaceBodyContext(_ctx, getState());
    enterRule(_localctx, 86, RULE_classOrInterfaceBody);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(820);
        match(LBRACE);
        setState(824);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8141781956233797760L) != 0)
            || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 145427593007419L) != 0)
            || _la == IDENTIFIER) {
          {
            {
              setState(821);
              classOrInterfaceBodyDeclaration();
            }
          }
          setState(826);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(827);
        match(RBRACE);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ClassOrInterfaceBodyDeclarationContext extends ParserRuleContext {
    public InitializerContext initializer() {
      return getRuleContext(InitializerContext.class, 0);
    }

    public ModifiersContext modifiers() {
      return getRuleContext(ModifiersContext.class, 0);
    }

    public ClassOrInterfaceDeclarationContext classOrInterfaceDeclaration() {
      return getRuleContext(ClassOrInterfaceDeclarationContext.class, 0);
    }

    public EnumDeclarationContext enumDeclaration() {
      return getRuleContext(EnumDeclarationContext.class, 0);
    }

    public ConstructorDeclarationContext constructorDeclaration() {
      return getRuleContext(ConstructorDeclarationContext.class, 0);
    }

    public FieldDeclarationContext fieldDeclaration() {
      return getRuleContext(FieldDeclarationContext.class, 0);
    }

    public MethodDeclarationContext methodDeclaration() {
      return getRuleContext(MethodDeclarationContext.class, 0);
    }

    public TerminalNode SEMICOLON() {
      return getToken(JavaccParser.SEMICOLON, 0);
    }

    public ClassOrInterfaceBodyDeclarationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_classOrInterfaceBodyDeclaration;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterClassOrInterfaceBodyDeclaration(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitClassOrInterfaceBodyDeclaration(this);
    }
  }

  public final ClassOrInterfaceBodyDeclarationContext classOrInterfaceBodyDeclaration()
      throws RecognitionException {
    ClassOrInterfaceBodyDeclarationContext _localctx =
        new ClassOrInterfaceBodyDeclarationContext(_ctx, getState());
    enterRule(_localctx, 88, RULE_classOrInterfaceBodyDeclaration);
    try {
      setState(839);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 85, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(829);
            initializer();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(830);
            modifiers();
            setState(836);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 84, _ctx)) {
              case 1:
                {
                  setState(831);
                  classOrInterfaceDeclaration();
                }
                break;
              case 2:
                {
                  setState(832);
                  enumDeclaration();
                }
                break;
              case 3:
                {
                  setState(833);
                  constructorDeclaration();
                }
                break;
              case 4:
                {
                  setState(834);
                  fieldDeclaration();
                }
                break;
              case 5:
                {
                  setState(835);
                  methodDeclaration();
                }
                break;
            }
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(838);
            match(SEMICOLON);
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class FieldDeclarationContext extends ParserRuleContext {
    public TypeContext type() {
      return getRuleContext(TypeContext.class, 0);
    }

    public List<VariableDeclaratorContext> variableDeclarator() {
      return getRuleContexts(VariableDeclaratorContext.class);
    }

    public VariableDeclaratorContext variableDeclarator(int i) {
      return getRuleContext(VariableDeclaratorContext.class, i);
    }

    public TerminalNode SEMICOLON() {
      return getToken(JavaccParser.SEMICOLON, 0);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(JavaccParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(JavaccParser.COMMA, i);
    }

    public FieldDeclarationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_fieldDeclaration;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterFieldDeclaration(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitFieldDeclaration(this);
    }
  }

  public final FieldDeclarationContext fieldDeclaration() throws RecognitionException {
    FieldDeclarationContext _localctx = new FieldDeclarationContext(_ctx, getState());
    enterRule(_localctx, 90, RULE_fieldDeclaration);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(841);
        type();
        setState(842);
        variableDeclarator();
        setState(847);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == COMMA) {
          {
            {
              setState(843);
              match(COMMA);
              setState(844);
              variableDeclarator();
            }
          }
          setState(849);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(850);
        match(SEMICOLON);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class VariableDeclaratorContext extends ParserRuleContext {
    public VariableDeclaratorIdContext variableDeclaratorId() {
      return getRuleContext(VariableDeclaratorIdContext.class, 0);
    }

    public TerminalNode ASSIGN() {
      return getToken(JavaccParser.ASSIGN, 0);
    }

    public VariableInitializerContext variableInitializer() {
      return getRuleContext(VariableInitializerContext.class, 0);
    }

    public VariableDeclaratorContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_variableDeclarator;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterVariableDeclarator(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitVariableDeclarator(this);
    }
  }

  public final VariableDeclaratorContext variableDeclarator() throws RecognitionException {
    VariableDeclaratorContext _localctx = new VariableDeclaratorContext(_ctx, getState());
    enterRule(_localctx, 92, RULE_variableDeclarator);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(852);
        variableDeclaratorId();
        setState(855);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == ASSIGN) {
          {
            setState(853);
            match(ASSIGN);
            setState(854);
            variableInitializer();
          }
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class VariableDeclaratorIdContext extends ParserRuleContext {
    public JavaIdentifierContext javaIdentifier() {
      return getRuleContext(JavaIdentifierContext.class, 0);
    }

    public List<TerminalNode> LBRACKET() {
      return getTokens(JavaccParser.LBRACKET);
    }

    public TerminalNode LBRACKET(int i) {
      return getToken(JavaccParser.LBRACKET, i);
    }

    public List<TerminalNode> RBRACKET() {
      return getTokens(JavaccParser.RBRACKET);
    }

    public TerminalNode RBRACKET(int i) {
      return getToken(JavaccParser.RBRACKET, i);
    }

    public VariableDeclaratorIdContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_variableDeclaratorId;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterVariableDeclaratorId(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitVariableDeclaratorId(this);
    }
  }

  public final VariableDeclaratorIdContext variableDeclaratorId() throws RecognitionException {
    VariableDeclaratorIdContext _localctx = new VariableDeclaratorIdContext(_ctx, getState());
    enterRule(_localctx, 94, RULE_variableDeclaratorId);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(857);
        javaIdentifier();
        setState(862);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == LBRACKET) {
          {
            {
              setState(858);
              match(LBRACKET);
              setState(859);
              match(RBRACKET);
            }
          }
          setState(864);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class VariableInitializerContext extends ParserRuleContext {
    public ArrayInitializerContext arrayInitializer() {
      return getRuleContext(ArrayInitializerContext.class, 0);
    }

    public ExpressionContext expression() {
      return getRuleContext(ExpressionContext.class, 0);
    }

    public VariableInitializerContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_variableInitializer;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterVariableInitializer(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitVariableInitializer(this);
    }
  }

  public final VariableInitializerContext variableInitializer() throws RecognitionException {
    VariableInitializerContext _localctx = new VariableInitializerContext(_ctx, getState());
    enterRule(_localctx, 96, RULE_variableInitializer);
    try {
      setState(867);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case LBRACE:
          enterOuterAlt(_localctx, 1);
          {
            setState(865);
            arrayInitializer();
          }
          break;
        case LOOKAHEAD:
        case IGNORE_CASE:
        case PARSER_BEGIN:
        case PARSER_END:
        case JAVACODE:
        case TOKEN:
        case SPECIAL_TOKEN:
        case MORE_:
        case SKIP_:
        case TOKEN_MGR_DECLS:
        case EOF_:
        case DCL_PARSER_BEGIN:
        case DCL_PARSER_END:
        case INC_PARSER_BEGIN:
        case INC_PARSER_END:
        case DEF_PARSER_BEGIN:
        case DEF_PARSER_END:
        case BOOLEAN:
        case BYTE:
        case CHAR:
        case CONST:
        case DOUBLE:
        case FALSE:
        case FLOAT:
        case INT:
        case LONG:
        case NEW:
        case NULL:
        case SHORT:
        case SUPER:
        case THIS:
        case TRUE:
        case VOID:
        case TEMPLATE:
        case INTEGER_LITERAL:
        case FLOATING_POINT_LITERAL:
        case CHARACTER_LITERAL:
        case STRING_LITERAL:
        case LPAREN:
        case BANG:
        case TILDE:
        case DOUBLECOLON:
        case INCR:
        case DECR:
        case PLUS:
        case MINUS:
        case IDENTIFIER:
          enterOuterAlt(_localctx, 2);
          {
            setState(866);
            expression();
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ArrayInitializerContext extends ParserRuleContext {
    public TerminalNode LBRACE() {
      return getToken(JavaccParser.LBRACE, 0);
    }

    public TerminalNode RBRACE() {
      return getToken(JavaccParser.RBRACE, 0);
    }

    public List<VariableInitializerContext> variableInitializer() {
      return getRuleContexts(VariableInitializerContext.class);
    }

    public VariableInitializerContext variableInitializer(int i) {
      return getRuleContext(VariableInitializerContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(JavaccParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(JavaccParser.COMMA, i);
    }

    public ArrayInitializerContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_arrayInitializer;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterArrayInitializer(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitArrayInitializer(this);
    }
  }

  public final ArrayInitializerContext arrayInitializer() throws RecognitionException {
    ArrayInitializerContext _localctx = new ArrayInitializerContext(_ctx, getState());
    enterRule(_localctx, 98, RULE_arrayInitializer);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(869);
        match(LBRACE);
        setState(878);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3819690555156193024L) != 0)
            || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 33797891017577545L) != 0)
            || _la == IDENTIFIER) {
          {
            setState(870);
            variableInitializer();
            setState(875);
            _errHandler.sync(this);
            _alt = getInterpreter().adaptivePredict(_input, 90, _ctx);
            while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
              if (_alt == 1) {
                {
                  {
                    setState(871);
                    match(COMMA);
                    setState(872);
                    variableInitializer();
                  }
                }
              }
              setState(877);
              _errHandler.sync(this);
              _alt = getInterpreter().adaptivePredict(_input, 90, _ctx);
            }
          }
        }

        setState(881);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == COMMA) {
          {
            setState(880);
            match(COMMA);
          }
        }

        setState(883);
        match(RBRACE);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class MethodDeclarationContext extends ParserRuleContext {
    public ResultTypeContext resultType() {
      return getRuleContext(ResultTypeContext.class, 0);
    }

    public MethodDeclaratorContext methodDeclarator() {
      return getRuleContext(MethodDeclaratorContext.class, 0);
    }

    public BlockContext block() {
      return getRuleContext(BlockContext.class, 0);
    }

    public TerminalNode SEMICOLON() {
      return getToken(JavaccParser.SEMICOLON, 0);
    }

    public TypeParametersContext typeParameters() {
      return getRuleContext(TypeParametersContext.class, 0);
    }

    public TerminalNode THROWS() {
      return getToken(JavaccParser.THROWS, 0);
    }

    public NameListContext nameList() {
      return getRuleContext(NameListContext.class, 0);
    }

    public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_methodDeclaration;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterMethodDeclaration(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitMethodDeclaration(this);
    }
  }

  public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
    MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
    enterRule(_localctx, 100, RULE_methodDeclaration);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(886);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == LT) {
          {
            setState(885);
            typeParameters();
          }
        }

        setState(888);
        resultType();
        setState(889);
        methodDeclarator();
        setState(892);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == THROWS) {
          {
            setState(890);
            match(THROWS);
            setState(891);
            nameList();
          }
        }

        setState(896);
        _errHandler.sync(this);
        switch (_input.LA(1)) {
          case LBRACE:
            {
              setState(894);
              block();
            }
            break;
          case SEMICOLON:
            {
              setState(895);
              match(SEMICOLON);
            }
            break;
          default:
            throw new NoViableAltException(this);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class MethodDeclaratorContext extends ParserRuleContext {
    public JavaIdentifierContext javaIdentifier() {
      return getRuleContext(JavaIdentifierContext.class, 0);
    }

    public FormalParametersContext formalParameters() {
      return getRuleContext(FormalParametersContext.class, 0);
    }

    public List<TerminalNode> LBRACKET() {
      return getTokens(JavaccParser.LBRACKET);
    }

    public TerminalNode LBRACKET(int i) {
      return getToken(JavaccParser.LBRACKET, i);
    }

    public List<TerminalNode> RBRACKET() {
      return getTokens(JavaccParser.RBRACKET);
    }

    public TerminalNode RBRACKET(int i) {
      return getToken(JavaccParser.RBRACKET, i);
    }

    public MethodDeclaratorContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_methodDeclarator;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterMethodDeclarator(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitMethodDeclarator(this);
    }
  }

  public final MethodDeclaratorContext methodDeclarator() throws RecognitionException {
    MethodDeclaratorContext _localctx = new MethodDeclaratorContext(_ctx, getState());
    enterRule(_localctx, 102, RULE_methodDeclarator);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(898);
        javaIdentifier();
        setState(899);
        formalParameters();
        setState(904);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == LBRACKET) {
          {
            {
              setState(900);
              match(LBRACKET);
              setState(901);
              match(RBRACKET);
            }
          }
          setState(906);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class FormalParametersContext extends ParserRuleContext {
    public TerminalNode LPAREN() {
      return getToken(JavaccParser.LPAREN, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(JavaccParser.RPAREN, 0);
    }

    public List<FormalParameterContext> formalParameter() {
      return getRuleContexts(FormalParameterContext.class);
    }

    public FormalParameterContext formalParameter(int i) {
      return getRuleContext(FormalParameterContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(JavaccParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(JavaccParser.COMMA, i);
    }

    public FormalParametersContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_formalParameters;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterFormalParameters(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitFormalParameters(this);
    }
  }

  public final FormalParametersContext formalParameters() throws RecognitionException {
    FormalParametersContext _localctx = new FormalParametersContext(_ctx, getState());
    enterRule(_localctx, 104, RULE_formalParameters);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(907);
        match(LPAREN);
        setState(916);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8285915148879658880L) != 0)
            || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 140737488687419L) != 0)
            || _la == IDENTIFIER) {
          {
            setState(908);
            formalParameter();
            setState(913);
            _errHandler.sync(this);
            _la = _input.LA(1);
            while (_la == COMMA) {
              {
                {
                  setState(909);
                  match(COMMA);
                  setState(910);
                  formalParameter();
                }
              }
              setState(915);
              _errHandler.sync(this);
              _la = _input.LA(1);
            }
          }
        }

        setState(918);
        match(RPAREN);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class FormalParameterContext extends ParserRuleContext {
    public ModifiersContext modifiers() {
      return getRuleContext(ModifiersContext.class, 0);
    }

    public TypeContext type() {
      return getRuleContext(TypeContext.class, 0);
    }

    public VariableDeclaratorIdContext variableDeclaratorId() {
      return getRuleContext(VariableDeclaratorIdContext.class, 0);
    }

    public TerminalNode BIT_AND() {
      return getToken(JavaccParser.BIT_AND, 0);
    }

    public TerminalNode STAR() {
      return getToken(JavaccParser.STAR, 0);
    }

    public FormalParameterContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_formalParameter;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterFormalParameter(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitFormalParameter(this);
    }
  }

  public final FormalParameterContext formalParameter() throws RecognitionException {
    FormalParameterContext _localctx = new FormalParameterContext(_ctx, getState());
    enterRule(_localctx, 106, RULE_formalParameter);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(920);
        modifiers();
        setState(921);
        type();
        setState(924);
        _errHandler.sync(this);
        switch (_input.LA(1)) {
          case STAR:
          case BIT_AND:
            {
              setState(922);
              _la = _input.LA(1);
              if (!(_la == STAR || _la == BIT_AND)) {
                _errHandler.recoverInline(this);
              } else {
                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                _errHandler.reportMatch(this);
                consume();
              }
            }
            break;
          case T__1:
            {
              setState(923);
              match(T__1);
            }
            break;
          case LOOKAHEAD:
          case IGNORE_CASE:
          case PARSER_BEGIN:
          case PARSER_END:
          case JAVACODE:
          case TOKEN:
          case SPECIAL_TOKEN:
          case MORE_:
          case SKIP_:
          case TOKEN_MGR_DECLS:
          case EOF_:
          case DCL_PARSER_BEGIN:
          case DCL_PARSER_END:
          case INC_PARSER_BEGIN:
          case INC_PARSER_END:
          case DEF_PARSER_BEGIN:
          case DEF_PARSER_END:
          case TEMPLATE:
          case IDENTIFIER:
            break;
          default:
            break;
        }
        setState(926);
        variableDeclaratorId();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ConstructorDeclarationContext extends ParserRuleContext {
    public JavaIdentifierContext javaIdentifier() {
      return getRuleContext(JavaIdentifierContext.class, 0);
    }

    public FormalParametersContext formalParameters() {
      return getRuleContext(FormalParametersContext.class, 0);
    }

    public TerminalNode LBRACE() {
      return getToken(JavaccParser.LBRACE, 0);
    }

    public TerminalNode RBRACE() {
      return getToken(JavaccParser.RBRACE, 0);
    }

    public TypeParametersContext typeParameters() {
      return getRuleContext(TypeParametersContext.class, 0);
    }

    public TerminalNode THROWS() {
      return getToken(JavaccParser.THROWS, 0);
    }

    public NameListContext nameList() {
      return getRuleContext(NameListContext.class, 0);
    }

    public ExplicitConstructorInvocationContext explicitConstructorInvocation() {
      return getRuleContext(ExplicitConstructorInvocationContext.class, 0);
    }

    public List<BlockStatementContext> blockStatement() {
      return getRuleContexts(BlockStatementContext.class);
    }

    public BlockStatementContext blockStatement(int i) {
      return getRuleContext(BlockStatementContext.class, i);
    }

    public ConstructorDeclarationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_constructorDeclaration;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterConstructorDeclaration(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitConstructorDeclaration(this);
    }
  }

  public final ConstructorDeclarationContext constructorDeclaration() throws RecognitionException {
    ConstructorDeclarationContext _localctx = new ConstructorDeclarationContext(_ctx, getState());
    enterRule(_localctx, 108, RULE_constructorDeclaration);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(929);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == LT) {
          {
            setState(928);
            typeParameters();
          }
        }

        setState(931);
        javaIdentifier();
        setState(932);
        formalParameters();
        setState(935);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == THROWS) {
          {
            setState(933);
            match(THROWS);
            setState(934);
            nameList();
          }
        }

        setState(937);
        match(LBRACE);
        setState(939);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 102, _ctx)) {
          case 1:
            {
              setState(938);
              explicitConstructorInvocation();
            }
            break;
        }
        setState(944);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -4677332412173131904L) != 0)
            || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 54184232625895423L) != 0)
            || _la == IDENTIFIER) {
          {
            {
              setState(941);
              blockStatement();
            }
          }
          setState(946);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(947);
        match(RBRACE);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ExplicitConstructorInvocationContext extends ParserRuleContext {
    public TerminalNode THIS() {
      return getToken(JavaccParser.THIS, 0);
    }

    public ArgumentsContext arguments() {
      return getRuleContext(ArgumentsContext.class, 0);
    }

    public TerminalNode SEMICOLON() {
      return getToken(JavaccParser.SEMICOLON, 0);
    }

    public TerminalNode SUPER() {
      return getToken(JavaccParser.SUPER, 0);
    }

    public PrimaryExpressionContext primaryExpression() {
      return getRuleContext(PrimaryExpressionContext.class, 0);
    }

    public TerminalNode DOT() {
      return getToken(JavaccParser.DOT, 0);
    }

    public ExplicitConstructorInvocationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_explicitConstructorInvocation;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterExplicitConstructorInvocation(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitExplicitConstructorInvocation(this);
    }
  }

  public final ExplicitConstructorInvocationContext explicitConstructorInvocation()
      throws RecognitionException {
    ExplicitConstructorInvocationContext _localctx =
        new ExplicitConstructorInvocationContext(_ctx, getState());
    enterRule(_localctx, 110, RULE_explicitConstructorInvocation);
    try {
      setState(962);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 105, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(949);
            match(THIS);
            setState(950);
            arguments();
            setState(951);
            match(SEMICOLON);
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(956);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 104, _ctx)) {
              case 1:
                {
                  setState(953);
                  primaryExpression();
                  setState(954);
                  match(DOT);
                }
                break;
            }
            setState(958);
            match(SUPER);
            setState(959);
            arguments();
            setState(960);
            match(SEMICOLON);
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class InitializerContext extends ParserRuleContext {
    public BlockContext block() {
      return getRuleContext(BlockContext.class, 0);
    }

    public TerminalNode STATIC() {
      return getToken(JavaccParser.STATIC, 0);
    }

    public InitializerContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_initializer;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterInitializer(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitInitializer(this);
    }
  }

  public final InitializerContext initializer() throws RecognitionException {
    InitializerContext _localctx = new InitializerContext(_ctx, getState());
    enterRule(_localctx, 112, RULE_initializer);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(965);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == STATIC) {
          {
            setState(964);
            match(STATIC);
          }
        }

        setState(967);
        block();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class TypeContext extends ParserRuleContext {
    public ReferenceTypeContext referenceType() {
      return getRuleContext(ReferenceTypeContext.class, 0);
    }

    public PrimitiveTypeContext primitiveType() {
      return getRuleContext(PrimitiveTypeContext.class, 0);
    }

    public TypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_type;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterType(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitType(this);
    }
  }

  public final TypeContext type() throws RecognitionException {
    TypeContext _localctx = new TypeContext(_ctx, getState());
    enterRule(_localctx, 114, RULE_type);
    try {
      setState(971);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 107, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(969);
            referenceType();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(970);
            primitiveType();
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ReferenceTypeContext extends ParserRuleContext {
    public PrimitiveTypeContext primitiveType() {
      return getRuleContext(PrimitiveTypeContext.class, 0);
    }

    public List<TerminalNode> LBRACKET() {
      return getTokens(JavaccParser.LBRACKET);
    }

    public TerminalNode LBRACKET(int i) {
      return getToken(JavaccParser.LBRACKET, i);
    }

    public List<TerminalNode> RBRACKET() {
      return getTokens(JavaccParser.RBRACKET);
    }

    public TerminalNode RBRACKET(int i) {
      return getToken(JavaccParser.RBRACKET, i);
    }

    public ClassOrInterfaceTypeContext classOrInterfaceType() {
      return getRuleContext(ClassOrInterfaceTypeContext.class, 0);
    }

    public TemplateContext template() {
      return getRuleContext(TemplateContext.class, 0);
    }

    public ReferenceTypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_referenceType;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterReferenceType(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitReferenceType(this);
    }
  }

  public final ReferenceTypeContext referenceType() throws RecognitionException {
    ReferenceTypeContext _localctx = new ReferenceTypeContext(_ctx, getState());
    enterRule(_localctx, 116, RULE_referenceType);
    int _la;
    try {
      int _alt;
      setState(992);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case BOOLEAN:
        case BYTE:
        case CHAR:
        case DOUBLE:
        case FLOAT:
        case INT:
        case LONG:
        case SHORT:
          enterOuterAlt(_localctx, 1);
          {
            setState(973);
            primitiveType();
            setState(976);
            _errHandler.sync(this);
            _alt = 1;
            do {
              switch (_alt) {
                case 1:
                  {
                    {
                      setState(974);
                      match(LBRACKET);
                      setState(975);
                      match(RBRACKET);
                    }
                  }
                  break;
                default:
                  throw new NoViableAltException(this);
              }
              setState(978);
              _errHandler.sync(this);
              _alt = getInterpreter().adaptivePredict(_input, 108, _ctx);
            } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
          }
          break;
        case TEMPLATE:
        case DOUBLECOLON:
        case IDENTIFIER:
          enterOuterAlt(_localctx, 2);
          {
            {
              setState(981);
              _errHandler.sync(this);
              _la = _input.LA(1);
              if (_la == TEMPLATE) {
                {
                  setState(980);
                  template();
                }
              }

              setState(983);
              classOrInterfaceType();
            }
            setState(989);
            _errHandler.sync(this);
            _alt = getInterpreter().adaptivePredict(_input, 110, _ctx);
            while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
              if (_alt == 1) {
                {
                  {
                    setState(985);
                    match(LBRACKET);
                    setState(986);
                    match(RBRACKET);
                  }
                }
              }
              setState(991);
              _errHandler.sync(this);
              _alt = getInterpreter().adaptivePredict(_input, 110, _ctx);
            }
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class TemplateContext extends ParserRuleContext {
    public TerminalNode TEMPLATE() {
      return getToken(JavaccParser.TEMPLATE, 0);
    }

    public TerminalNode LT() {
      return getToken(JavaccParser.LT, 0);
    }

    public List<TemplateBaseContext> templateBase() {
      return getRuleContexts(TemplateBaseContext.class);
    }

    public TemplateBaseContext templateBase(int i) {
      return getRuleContext(TemplateBaseContext.class, i);
    }

    public TerminalNode GT() {
      return getToken(JavaccParser.GT, 0);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(JavaccParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(JavaccParser.COMMA, i);
    }

    public TemplateContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_template;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterTemplate(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitTemplate(this);
    }
  }

  public final TemplateContext template() throws RecognitionException {
    TemplateContext _localctx = new TemplateContext(_ctx, getState());
    enterRule(_localctx, 118, RULE_template);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(994);
        match(TEMPLATE);
        setState(995);
        match(LT);
        setState(996);
        templateBase();
        setState(1001);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == COMMA) {
          {
            {
              setState(997);
              match(COMMA);
              setState(998);
              templateBase();
            }
          }
          setState(1003);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(1004);
        match(GT);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class TemplateBaseContext extends ParserRuleContext {
    public TemplatePackContext templatePack() {
      return getRuleContext(TemplatePackContext.class, 0);
    }

    public TerminalNode IDENTIFIER() {
      return getToken(JavaccParser.IDENTIFIER, 0);
    }

    public TemplateBaseContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_templateBase;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterTemplateBase(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitTemplateBase(this);
    }
  }

  public final TemplateBaseContext templateBase() throws RecognitionException {
    TemplateBaseContext _localctx = new TemplateBaseContext(_ctx, getState());
    enterRule(_localctx, 120, RULE_templateBase);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1006);
        templatePack();
        setState(1008);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__1) {
          {
            setState(1007);
            match(T__1);
          }
        }

        setState(1010);
        match(IDENTIFIER);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class TemplatePackContext extends ParserRuleContext {
    public TerminalNode CLASS() {
      return getToken(JavaccParser.CLASS, 0);
    }

    public TerminalNode TYPENAME() {
      return getToken(JavaccParser.TYPENAME, 0);
    }

    public TemplatePackContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_templatePack;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterTemplatePack(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitTemplatePack(this);
    }
  }

  public final TemplatePackContext templatePack() throws RecognitionException {
    TemplatePackContext _localctx = new TemplatePackContext(_ctx, getState());
    enterRule(_localctx, 122, RULE_templatePack);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1012);
        _la = _input.LA(1);
        if (!(_la == CLASS || _la == TYPENAME)) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF) matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ClassOrInterfaceTypeContext extends ParserRuleContext {
    public List<TerminalNode> IDENTIFIER() {
      return getTokens(JavaccParser.IDENTIFIER);
    }

    public TerminalNode IDENTIFIER(int i) {
      return getToken(JavaccParser.IDENTIFIER, i);
    }

    public List<TerminalNode> DOUBLECOLON() {
      return getTokens(JavaccParser.DOUBLECOLON);
    }

    public TerminalNode DOUBLECOLON(int i) {
      return getToken(JavaccParser.DOUBLECOLON, i);
    }

    public List<TypeArgumentsContext> typeArguments() {
      return getRuleContexts(TypeArgumentsContext.class);
    }

    public TypeArgumentsContext typeArguments(int i) {
      return getRuleContext(TypeArgumentsContext.class, i);
    }

    public List<TerminalNode> DOT() {
      return getTokens(JavaccParser.DOT);
    }

    public TerminalNode DOT(int i) {
      return getToken(JavaccParser.DOT, i);
    }

    public ClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_classOrInterfaceType;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterClassOrInterfaceType(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitClassOrInterfaceType(this);
    }
  }

  public final ClassOrInterfaceTypeContext classOrInterfaceType() throws RecognitionException {
    ClassOrInterfaceTypeContext _localctx = new ClassOrInterfaceTypeContext(_ctx, getState());
    enterRule(_localctx, 124, RULE_classOrInterfaceType);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(1015);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == DOUBLECOLON) {
          {
            setState(1014);
            match(DOUBLECOLON);
          }
        }

        setState(1017);
        match(IDENTIFIER);
        setState(1019);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 115, _ctx)) {
          case 1:
            {
              setState(1018);
              typeArguments();
            }
            break;
        }
        setState(1028);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 117, _ctx);
        while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            {
              {
                setState(1021);
                _la = _input.LA(1);
                if (!(_la == DOT || _la == DOUBLECOLON)) {
                  _errHandler.recoverInline(this);
                } else {
                  if (_input.LA(1) == Token.EOF) matchedEOF = true;
                  _errHandler.reportMatch(this);
                  consume();
                }
                setState(1022);
                match(IDENTIFIER);
                setState(1024);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 116, _ctx)) {
                  case 1:
                    {
                      setState(1023);
                      typeArguments();
                    }
                    break;
                }
              }
            }
          }
          setState(1030);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 117, _ctx);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class TypeArgumentsContext extends ParserRuleContext {
    public TerminalNode LT() {
      return getToken(JavaccParser.LT, 0);
    }

    public TerminalNode GT() {
      return getToken(JavaccParser.GT, 0);
    }

    public List<TypeArgumentContext> typeArgument() {
      return getRuleContexts(TypeArgumentContext.class);
    }

    public TypeArgumentContext typeArgument(int i) {
      return getRuleContext(TypeArgumentContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(JavaccParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(JavaccParser.COMMA, i);
    }

    public TypeArgumentsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_typeArguments;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterTypeArguments(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitTypeArguments(this);
    }
  }

  public final TypeArgumentsContext typeArguments() throws RecognitionException {
    TypeArgumentsContext _localctx = new TypeArgumentsContext(_ctx, getState());
    enterRule(_localctx, 126, RULE_typeArguments);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1031);
        match(LT);
        setState(1043);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (((((_la - 31)) & ~0x3f) == 0 && ((1L << (_la - 31)) & 2251868701198373L) != 0)
            || ((((_la - 109)) & ~0x3f) == 0 && ((1L << (_la - 109)) & 268435461L) != 0)) {
          {
            setState(1032);
            typeArgument();
            setState(1040);
            _errHandler.sync(this);
            _la = _input.LA(1);
            while (_la == COMMA) {
              {
                {
                  setState(1033);
                  match(COMMA);
                  setState(1034);
                  typeArgument();
                  setState(1036);
                  _errHandler.sync(this);
                  _la = _input.LA(1);
                  if (_la == T__1) {
                    {
                      setState(1035);
                      match(T__1);
                    }
                  }
                }
              }
              setState(1042);
              _errHandler.sync(this);
              _la = _input.LA(1);
            }
          }
        }

        setState(1045);
        match(GT);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class TypeArgumentContext extends ParserRuleContext {
    public ReferenceTypeContext referenceType() {
      return getRuleContext(ReferenceTypeContext.class, 0);
    }

    public TerminalNode HOOK() {
      return getToken(JavaccParser.HOOK, 0);
    }

    public WildcardBoundsContext wildcardBounds() {
      return getRuleContext(WildcardBoundsContext.class, 0);
    }

    public TypeArgumentContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_typeArgument;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterTypeArgument(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitTypeArgument(this);
    }
  }

  public final TypeArgumentContext typeArgument() throws RecognitionException {
    TypeArgumentContext _localctx = new TypeArgumentContext(_ctx, getState());
    enterRule(_localctx, 128, RULE_typeArgument);
    int _la;
    try {
      setState(1052);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case BOOLEAN:
        case BYTE:
        case CHAR:
        case DOUBLE:
        case FLOAT:
        case INT:
        case LONG:
        case SHORT:
        case TEMPLATE:
        case DOUBLECOLON:
        case IDENTIFIER:
          enterOuterAlt(_localctx, 1);
          {
            setState(1047);
            referenceType();
          }
          break;
        case HOOK:
          enterOuterAlt(_localctx, 2);
          {
            setState(1048);
            match(HOOK);
            setState(1050);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == EXTENDS || _la == SUPER) {
              {
                setState(1049);
                wildcardBounds();
              }
            }
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class WildcardBoundsContext extends ParserRuleContext {
    public TerminalNode EXTENDS() {
      return getToken(JavaccParser.EXTENDS, 0);
    }

    public ReferenceTypeContext referenceType() {
      return getRuleContext(ReferenceTypeContext.class, 0);
    }

    public TerminalNode SUPER() {
      return getToken(JavaccParser.SUPER, 0);
    }

    public WildcardBoundsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_wildcardBounds;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterWildcardBounds(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitWildcardBounds(this);
    }
  }

  public final WildcardBoundsContext wildcardBounds() throws RecognitionException {
    WildcardBoundsContext _localctx = new WildcardBoundsContext(_ctx, getState());
    enterRule(_localctx, 130, RULE_wildcardBounds);
    try {
      setState(1058);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case EXTENDS:
          enterOuterAlt(_localctx, 1);
          {
            setState(1054);
            match(EXTENDS);
            setState(1055);
            referenceType();
          }
          break;
        case SUPER:
          enterOuterAlt(_localctx, 2);
          {
            setState(1056);
            match(SUPER);
            setState(1057);
            referenceType();
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PrimitiveTypeContext extends ParserRuleContext {
    public TerminalNode BOOLEAN() {
      return getToken(JavaccParser.BOOLEAN, 0);
    }

    public TerminalNode CHAR() {
      return getToken(JavaccParser.CHAR, 0);
    }

    public TerminalNode BYTE() {
      return getToken(JavaccParser.BYTE, 0);
    }

    public TerminalNode SHORT() {
      return getToken(JavaccParser.SHORT, 0);
    }

    public TerminalNode INT() {
      return getToken(JavaccParser.INT, 0);
    }

    public TerminalNode LONG() {
      return getToken(JavaccParser.LONG, 0);
    }

    public TerminalNode FLOAT() {
      return getToken(JavaccParser.FLOAT, 0);
    }

    public TerminalNode DOUBLE() {
      return getToken(JavaccParser.DOUBLE, 0);
    }

    public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_primitiveType;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterPrimitiveType(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitPrimitiveType(this);
    }
  }

  public final PrimitiveTypeContext primitiveType() throws RecognitionException {
    PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
    enterRule(_localctx, 132, RULE_primitiveType);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1060);
        _la = _input.LA(1);
        if (!(((((_la - 31)) & ~0x3f) == 0 && ((1L << (_la - 31)) & 68887513125L) != 0))) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF) matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ResultTypeContext extends ParserRuleContext {
    public TerminalNode VOID() {
      return getToken(JavaccParser.VOID, 0);
    }

    public TypeContext type() {
      return getRuleContext(TypeContext.class, 0);
    }

    public TerminalNode STAR() {
      return getToken(JavaccParser.STAR, 0);
    }

    public TerminalNode CONST() {
      return getToken(JavaccParser.CONST, 0);
    }

    public TerminalNode BIT_AND() {
      return getToken(JavaccParser.BIT_AND, 0);
    }

    public ResultTypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_resultType;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterResultType(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitResultType(this);
    }
  }

  public final ResultTypeContext resultType() throws RecognitionException {
    ResultTypeContext _localctx = new ResultTypeContext(_ctx, getState());
    enterRule(_localctx, 134, RULE_resultType);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1073);
        _errHandler.sync(this);
        switch (_input.LA(1)) {
          case VOID:
            {
              setState(1062);
              match(VOID);
              setState(1064);
              _errHandler.sync(this);
              _la = _input.LA(1);
              if (_la == STAR) {
                {
                  setState(1063);
                  match(STAR);
                }
              }
            }
            break;
          case BOOLEAN:
          case BYTE:
          case CHAR:
          case CONST:
          case DOUBLE:
          case FLOAT:
          case INT:
          case LONG:
          case SHORT:
          case TEMPLATE:
          case DOUBLECOLON:
          case IDENTIFIER:
            {
              setState(1067);
              _errHandler.sync(this);
              _la = _input.LA(1);
              if (_la == CONST) {
                {
                  setState(1066);
                  match(CONST);
                }
              }

              setState(1069);
              type();
              setState(1071);
              _errHandler.sync(this);
              _la = _input.LA(1);
              if (_la == STAR || _la == BIT_AND) {
                {
                  setState(1070);
                  _la = _input.LA(1);
                  if (!(_la == STAR || _la == BIT_AND)) {
                    _errHandler.recoverInline(this);
                  } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                  }
                }
              }
            }
            break;
          default:
            throw new NoViableAltException(this);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class NameContext extends ParserRuleContext {
    public List<JavaIdentifierContext> javaIdentifier() {
      return getRuleContexts(JavaIdentifierContext.class);
    }

    public JavaIdentifierContext javaIdentifier(int i) {
      return getRuleContext(JavaIdentifierContext.class, i);
    }

    public List<TerminalNode> DOT() {
      return getTokens(JavaccParser.DOT);
    }

    public TerminalNode DOT(int i) {
      return getToken(JavaccParser.DOT, i);
    }

    public NameContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_name;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterName(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitName(this);
    }
  }

  public final NameContext name() throws RecognitionException {
    NameContext _localctx = new NameContext(_ctx, getState());
    enterRule(_localctx, 136, RULE_name);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(1075);
        javaIdentifier();
        setState(1080);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 128, _ctx);
        while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            {
              {
                setState(1076);
                match(DOT);
                setState(1077);
                javaIdentifier();
              }
            }
          }
          setState(1082);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 128, _ctx);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class NameListContext extends ParserRuleContext {
    public List<NameContext> name() {
      return getRuleContexts(NameContext.class);
    }

    public NameContext name(int i) {
      return getRuleContext(NameContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(JavaccParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(JavaccParser.COMMA, i);
    }

    public NameListContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_nameList;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterNameList(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitNameList(this);
    }
  }

  public final NameListContext nameList() throws RecognitionException {
    NameListContext _localctx = new NameListContext(_ctx, getState());
    enterRule(_localctx, 138, RULE_nameList);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1083);
        name();
        setState(1088);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == COMMA) {
          {
            {
              setState(1084);
              match(COMMA);
              setState(1085);
              name();
            }
          }
          setState(1090);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ExpressionContext extends ParserRuleContext {
    public ConditionalExpressionContext conditionalExpression() {
      return getRuleContext(ConditionalExpressionContext.class, 0);
    }

    public AssignmentOperatorContext assignmentOperator() {
      return getRuleContext(AssignmentOperatorContext.class, 0);
    }

    public ExpressionContext expression() {
      return getRuleContext(ExpressionContext.class, 0);
    }

    public ExpressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_expression;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitExpression(this);
    }
  }

  public final ExpressionContext expression() throws RecognitionException {
    ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
    enterRule(_localctx, 140, RULE_expression);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1091);
        conditionalExpression();
        setState(1095);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 130, _ctx)) {
          case 1:
            {
              setState(1092);
              assignmentOperator();
              setState(1093);
              expression();
            }
            break;
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class AssignmentOperatorContext extends ParserRuleContext {
    public TerminalNode ASSIGN() {
      return getToken(JavaccParser.ASSIGN, 0);
    }

    public TerminalNode STARASSIGN() {
      return getToken(JavaccParser.STARASSIGN, 0);
    }

    public TerminalNode SLASHASSIGN() {
      return getToken(JavaccParser.SLASHASSIGN, 0);
    }

    public TerminalNode REMASSIGN() {
      return getToken(JavaccParser.REMASSIGN, 0);
    }

    public TerminalNode PLUSASSIGN() {
      return getToken(JavaccParser.PLUSASSIGN, 0);
    }

    public TerminalNode MINUSASSIGN() {
      return getToken(JavaccParser.MINUSASSIGN, 0);
    }

    public TerminalNode ANDASSIGN() {
      return getToken(JavaccParser.ANDASSIGN, 0);
    }

    public TerminalNode XORASSIGN() {
      return getToken(JavaccParser.XORASSIGN, 0);
    }

    public TerminalNode ORASSIGN() {
      return getToken(JavaccParser.ORASSIGN, 0);
    }

    public AssignmentOperatorContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_assignmentOperator;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterAssignmentOperator(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitAssignmentOperator(this);
    }
  }

  public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
    AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
    enterRule(_localctx, 142, RULE_assignmentOperator);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1097);
        _la = _input.LA(1);
        if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 56L) != 0)
            || ((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & 2139095041L) != 0))) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF) matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ConditionalExpressionContext extends ParserRuleContext {
    public ConditionalOrExpressionContext conditionalOrExpression() {
      return getRuleContext(ConditionalOrExpressionContext.class, 0);
    }

    public TerminalNode HOOK() {
      return getToken(JavaccParser.HOOK, 0);
    }

    public List<ExpressionContext> expression() {
      return getRuleContexts(ExpressionContext.class);
    }

    public ExpressionContext expression(int i) {
      return getRuleContext(ExpressionContext.class, i);
    }

    public TerminalNode COLON() {
      return getToken(JavaccParser.COLON, 0);
    }

    public ConditionalExpressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_conditionalExpression;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterConditionalExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitConditionalExpression(this);
    }
  }

  public final ConditionalExpressionContext conditionalExpression() throws RecognitionException {
    ConditionalExpressionContext _localctx = new ConditionalExpressionContext(_ctx, getState());
    enterRule(_localctx, 144, RULE_conditionalExpression);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1099);
        conditionalOrExpression();
        setState(1105);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == HOOK) {
          {
            setState(1100);
            match(HOOK);
            setState(1101);
            expression();
            setState(1102);
            match(COLON);
            setState(1103);
            expression();
          }
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ConditionalOrExpressionContext extends ParserRuleContext {
    public List<ConditionalAndExpressionContext> conditionalAndExpression() {
      return getRuleContexts(ConditionalAndExpressionContext.class);
    }

    public ConditionalAndExpressionContext conditionalAndExpression(int i) {
      return getRuleContext(ConditionalAndExpressionContext.class, i);
    }

    public List<TerminalNode> SC_OR() {
      return getTokens(JavaccParser.SC_OR);
    }

    public TerminalNode SC_OR(int i) {
      return getToken(JavaccParser.SC_OR, i);
    }

    public ConditionalOrExpressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_conditionalOrExpression;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterConditionalOrExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitConditionalOrExpression(this);
    }
  }

  public final ConditionalOrExpressionContext conditionalOrExpression()
      throws RecognitionException {
    ConditionalOrExpressionContext _localctx = new ConditionalOrExpressionContext(_ctx, getState());
    enterRule(_localctx, 146, RULE_conditionalOrExpression);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1107);
        conditionalAndExpression();
        setState(1112);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == SC_OR) {
          {
            {
              setState(1108);
              match(SC_OR);
              setState(1109);
              conditionalAndExpression();
            }
          }
          setState(1114);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ConditionalAndExpressionContext extends ParserRuleContext {
    public List<InclusiveOrExpressionContext> inclusiveOrExpression() {
      return getRuleContexts(InclusiveOrExpressionContext.class);
    }

    public InclusiveOrExpressionContext inclusiveOrExpression(int i) {
      return getRuleContext(InclusiveOrExpressionContext.class, i);
    }

    public List<TerminalNode> SC_AND() {
      return getTokens(JavaccParser.SC_AND);
    }

    public TerminalNode SC_AND(int i) {
      return getToken(JavaccParser.SC_AND, i);
    }

    public ConditionalAndExpressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_conditionalAndExpression;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterConditionalAndExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitConditionalAndExpression(this);
    }
  }

  public final ConditionalAndExpressionContext conditionalAndExpression()
      throws RecognitionException {
    ConditionalAndExpressionContext _localctx =
        new ConditionalAndExpressionContext(_ctx, getState());
    enterRule(_localctx, 148, RULE_conditionalAndExpression);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1115);
        inclusiveOrExpression();
        setState(1120);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == SC_AND) {
          {
            {
              setState(1116);
              match(SC_AND);
              setState(1117);
              inclusiveOrExpression();
            }
          }
          setState(1122);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class InclusiveOrExpressionContext extends ParserRuleContext {
    public List<ExclusiveOrExpressionContext> exclusiveOrExpression() {
      return getRuleContexts(ExclusiveOrExpressionContext.class);
    }

    public ExclusiveOrExpressionContext exclusiveOrExpression(int i) {
      return getRuleContext(ExclusiveOrExpressionContext.class, i);
    }

    public List<TerminalNode> BIT_OR() {
      return getTokens(JavaccParser.BIT_OR);
    }

    public TerminalNode BIT_OR(int i) {
      return getToken(JavaccParser.BIT_OR, i);
    }

    public InclusiveOrExpressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_inclusiveOrExpression;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterInclusiveOrExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitInclusiveOrExpression(this);
    }
  }

  public final InclusiveOrExpressionContext inclusiveOrExpression() throws RecognitionException {
    InclusiveOrExpressionContext _localctx = new InclusiveOrExpressionContext(_ctx, getState());
    enterRule(_localctx, 150, RULE_inclusiveOrExpression);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1123);
        exclusiveOrExpression();
        setState(1128);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == BIT_OR) {
          {
            {
              setState(1124);
              match(BIT_OR);
              setState(1125);
              exclusiveOrExpression();
            }
          }
          setState(1130);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ExclusiveOrExpressionContext extends ParserRuleContext {
    public List<AndExpressionContext> andExpression() {
      return getRuleContexts(AndExpressionContext.class);
    }

    public AndExpressionContext andExpression(int i) {
      return getRuleContext(AndExpressionContext.class, i);
    }

    public List<TerminalNode> XOR() {
      return getTokens(JavaccParser.XOR);
    }

    public TerminalNode XOR(int i) {
      return getToken(JavaccParser.XOR, i);
    }

    public ExclusiveOrExpressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_exclusiveOrExpression;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterExclusiveOrExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitExclusiveOrExpression(this);
    }
  }

  public final ExclusiveOrExpressionContext exclusiveOrExpression() throws RecognitionException {
    ExclusiveOrExpressionContext _localctx = new ExclusiveOrExpressionContext(_ctx, getState());
    enterRule(_localctx, 152, RULE_exclusiveOrExpression);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1131);
        andExpression();
        setState(1136);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == XOR) {
          {
            {
              setState(1132);
              match(XOR);
              setState(1133);
              andExpression();
            }
          }
          setState(1138);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class AndExpressionContext extends ParserRuleContext {
    public List<EqualityExpressionContext> equalityExpression() {
      return getRuleContexts(EqualityExpressionContext.class);
    }

    public EqualityExpressionContext equalityExpression(int i) {
      return getRuleContext(EqualityExpressionContext.class, i);
    }

    public List<TerminalNode> BIT_AND() {
      return getTokens(JavaccParser.BIT_AND);
    }

    public TerminalNode BIT_AND(int i) {
      return getToken(JavaccParser.BIT_AND, i);
    }

    public AndExpressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_andExpression;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterAndExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitAndExpression(this);
    }
  }

  public final AndExpressionContext andExpression() throws RecognitionException {
    AndExpressionContext _localctx = new AndExpressionContext(_ctx, getState());
    enterRule(_localctx, 154, RULE_andExpression);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1139);
        equalityExpression();
        setState(1144);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == BIT_AND) {
          {
            {
              setState(1140);
              match(BIT_AND);
              setState(1141);
              equalityExpression();
            }
          }
          setState(1146);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class EqualityExpressionContext extends ParserRuleContext {
    public List<InstanceOfExpressionContext> instanceOfExpression() {
      return getRuleContexts(InstanceOfExpressionContext.class);
    }

    public InstanceOfExpressionContext instanceOfExpression(int i) {
      return getRuleContext(InstanceOfExpressionContext.class, i);
    }

    public List<TerminalNode> EQ() {
      return getTokens(JavaccParser.EQ);
    }

    public TerminalNode EQ(int i) {
      return getToken(JavaccParser.EQ, i);
    }

    public List<TerminalNode> NE() {
      return getTokens(JavaccParser.NE);
    }

    public TerminalNode NE(int i) {
      return getToken(JavaccParser.NE, i);
    }

    public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_equalityExpression;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterEqualityExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitEqualityExpression(this);
    }
  }

  public final EqualityExpressionContext equalityExpression() throws RecognitionException {
    EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, getState());
    enterRule(_localctx, 156, RULE_equalityExpression);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1147);
        instanceOfExpression();
        setState(1152);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == EQ || _la == NE) {
          {
            {
              setState(1148);
              _la = _input.LA(1);
              if (!(_la == EQ || _la == NE)) {
                _errHandler.recoverInline(this);
              } else {
                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                _errHandler.reportMatch(this);
                consume();
              }
              setState(1149);
              instanceOfExpression();
            }
          }
          setState(1154);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class InstanceOfExpressionContext extends ParserRuleContext {
    public RelationalExpressionContext relationalExpression() {
      return getRuleContext(RelationalExpressionContext.class, 0);
    }

    public TerminalNode INSTANCEOF() {
      return getToken(JavaccParser.INSTANCEOF, 0);
    }

    public TypeContext type() {
      return getRuleContext(TypeContext.class, 0);
    }

    public InstanceOfExpressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_instanceOfExpression;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterInstanceOfExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitInstanceOfExpression(this);
    }
  }

  public final InstanceOfExpressionContext instanceOfExpression() throws RecognitionException {
    InstanceOfExpressionContext _localctx = new InstanceOfExpressionContext(_ctx, getState());
    enterRule(_localctx, 158, RULE_instanceOfExpression);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1155);
        relationalExpression();
        setState(1158);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == INSTANCEOF) {
          {
            setState(1156);
            match(INSTANCEOF);
            setState(1157);
            type();
          }
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class RelationalExpressionContext extends ParserRuleContext {
    public List<ShiftExpressionContext> shiftExpression() {
      return getRuleContexts(ShiftExpressionContext.class);
    }

    public ShiftExpressionContext shiftExpression(int i) {
      return getRuleContext(ShiftExpressionContext.class, i);
    }

    public List<TerminalNode> LT() {
      return getTokens(JavaccParser.LT);
    }

    public TerminalNode LT(int i) {
      return getToken(JavaccParser.LT, i);
    }

    public List<TerminalNode> GT() {
      return getTokens(JavaccParser.GT);
    }

    public TerminalNode GT(int i) {
      return getToken(JavaccParser.GT, i);
    }

    public List<TerminalNode> LE() {
      return getTokens(JavaccParser.LE);
    }

    public TerminalNode LE(int i) {
      return getToken(JavaccParser.LE, i);
    }

    public List<TerminalNode> GE() {
      return getTokens(JavaccParser.GE);
    }

    public TerminalNode GE(int i) {
      return getToken(JavaccParser.GE, i);
    }

    public RelationalExpressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_relationalExpression;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterRelationalExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitRelationalExpression(this);
    }
  }

  public final RelationalExpressionContext relationalExpression() throws RecognitionException {
    RelationalExpressionContext _localctx = new RelationalExpressionContext(_ctx, getState());
    enterRule(_localctx, 160, RULE_relationalExpression);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1160);
        shiftExpression();
        setState(1165);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (((((_la - 106)) & ~0x3f) == 0 && ((1L << (_la - 106)) & 1073742209L) != 0)) {
          {
            {
              setState(1161);
              _la = _input.LA(1);
              if (!(((((_la - 106)) & ~0x3f) == 0 && ((1L << (_la - 106)) & 1073742209L) != 0))) {
                _errHandler.recoverInline(this);
              } else {
                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                _errHandler.reportMatch(this);
                consume();
              }
              setState(1162);
              shiftExpression();
            }
          }
          setState(1167);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ShiftExpressionContext extends ParserRuleContext {
    public List<AdditiveExpressionContext> additiveExpression() {
      return getRuleContexts(AdditiveExpressionContext.class);
    }

    public AdditiveExpressionContext additiveExpression(int i) {
      return getRuleContext(AdditiveExpressionContext.class, i);
    }

    public List<RsignedshiftContext> rsignedshift() {
      return getRuleContexts(RsignedshiftContext.class);
    }

    public RsignedshiftContext rsignedshift(int i) {
      return getRuleContext(RsignedshiftContext.class, i);
    }

    public List<RunsignedshiftContext> runsignedshift() {
      return getRuleContexts(RunsignedshiftContext.class);
    }

    public RunsignedshiftContext runsignedshift(int i) {
      return getRuleContext(RunsignedshiftContext.class, i);
    }

    public ShiftExpressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_shiftExpression;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterShiftExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitShiftExpression(this);
    }
  }

  public final ShiftExpressionContext shiftExpression() throws RecognitionException {
    ShiftExpressionContext _localctx = new ShiftExpressionContext(_ctx, getState());
    enterRule(_localctx, 162, RULE_shiftExpression);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(1168);
        additiveExpression();
        setState(1177);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 141, _ctx);
        while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            {
              {
                setState(1172);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 140, _ctx)) {
                  case 1:
                    {
                      setState(1169);
                      match(T__5);
                    }
                    break;
                  case 2:
                    {
                      setState(1170);
                      rsignedshift();
                    }
                    break;
                  case 3:
                    {
                      setState(1171);
                      runsignedshift();
                    }
                    break;
                }
                setState(1174);
                additiveExpression();
              }
            }
          }
          setState(1179);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 141, _ctx);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class AdditiveExpressionContext extends ParserRuleContext {
    public List<MultiplicativeExpressionContext> multiplicativeExpression() {
      return getRuleContexts(MultiplicativeExpressionContext.class);
    }

    public MultiplicativeExpressionContext multiplicativeExpression(int i) {
      return getRuleContext(MultiplicativeExpressionContext.class, i);
    }

    public List<TerminalNode> PLUS() {
      return getTokens(JavaccParser.PLUS);
    }

    public TerminalNode PLUS(int i) {
      return getToken(JavaccParser.PLUS, i);
    }

    public List<TerminalNode> MINUS() {
      return getTokens(JavaccParser.MINUS);
    }

    public TerminalNode MINUS(int i) {
      return getToken(JavaccParser.MINUS, i);
    }

    public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_additiveExpression;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterAdditiveExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitAdditiveExpression(this);
    }
  }

  public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
    AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, getState());
    enterRule(_localctx, 164, RULE_additiveExpression);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1180);
        multiplicativeExpression();
        setState(1185);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == PLUS || _la == MINUS) {
          {
            {
              setState(1181);
              _la = _input.LA(1);
              if (!(_la == PLUS || _la == MINUS)) {
                _errHandler.recoverInline(this);
              } else {
                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                _errHandler.reportMatch(this);
                consume();
              }
              setState(1182);
              multiplicativeExpression();
            }
          }
          setState(1187);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class MultiplicativeExpressionContext extends ParserRuleContext {
    public List<UnaryExpressionContext> unaryExpression() {
      return getRuleContexts(UnaryExpressionContext.class);
    }

    public UnaryExpressionContext unaryExpression(int i) {
      return getRuleContext(UnaryExpressionContext.class, i);
    }

    public List<TerminalNode> STAR() {
      return getTokens(JavaccParser.STAR);
    }

    public TerminalNode STAR(int i) {
      return getToken(JavaccParser.STAR, i);
    }

    public List<TerminalNode> SLASH() {
      return getTokens(JavaccParser.SLASH);
    }

    public TerminalNode SLASH(int i) {
      return getToken(JavaccParser.SLASH, i);
    }

    public List<TerminalNode> REM() {
      return getTokens(JavaccParser.REM);
    }

    public TerminalNode REM(int i) {
      return getToken(JavaccParser.REM, i);
    }

    public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_multiplicativeExpression;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterMultiplicativeExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitMultiplicativeExpression(this);
    }
  }

  public final MultiplicativeExpressionContext multiplicativeExpression()
      throws RecognitionException {
    MultiplicativeExpressionContext _localctx =
        new MultiplicativeExpressionContext(_ctx, getState());
    enterRule(_localctx, 166, RULE_multiplicativeExpression);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1188);
        unaryExpression();
        setState(1193);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (((((_la - 122)) & ~0x3f) == 0 && ((1L << (_la - 122)) & 35L) != 0)) {
          {
            {
              setState(1189);
              _la = _input.LA(1);
              if (!(((((_la - 122)) & ~0x3f) == 0 && ((1L << (_la - 122)) & 35L) != 0))) {
                _errHandler.recoverInline(this);
              } else {
                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                _errHandler.reportMatch(this);
                consume();
              }
              setState(1190);
              unaryExpression();
            }
          }
          setState(1195);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class UnaryExpressionContext extends ParserRuleContext {
    public UnaryExpressionContext unaryExpression() {
      return getRuleContext(UnaryExpressionContext.class, 0);
    }

    public TerminalNode PLUS() {
      return getToken(JavaccParser.PLUS, 0);
    }

    public TerminalNode MINUS() {
      return getToken(JavaccParser.MINUS, 0);
    }

    public PreIncrementExpressionContext preIncrementExpression() {
      return getRuleContext(PreIncrementExpressionContext.class, 0);
    }

    public PreDecrementExpressionContext preDecrementExpression() {
      return getRuleContext(PreDecrementExpressionContext.class, 0);
    }

    public UnaryExpressionNotPlusMinusContext unaryExpressionNotPlusMinus() {
      return getRuleContext(UnaryExpressionNotPlusMinusContext.class, 0);
    }

    public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_unaryExpression;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterUnaryExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitUnaryExpression(this);
    }
  }

  public final UnaryExpressionContext unaryExpression() throws RecognitionException {
    UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
    enterRule(_localctx, 168, RULE_unaryExpression);
    int _la;
    try {
      setState(1201);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case PLUS:
        case MINUS:
          enterOuterAlt(_localctx, 1);
          {
            setState(1196);
            _la = _input.LA(1);
            if (!(_la == PLUS || _la == MINUS)) {
              _errHandler.recoverInline(this);
            } else {
              if (_input.LA(1) == Token.EOF) matchedEOF = true;
              _errHandler.reportMatch(this);
              consume();
            }
            setState(1197);
            unaryExpression();
          }
          break;
        case INCR:
          enterOuterAlt(_localctx, 2);
          {
            setState(1198);
            preIncrementExpression();
          }
          break;
        case DECR:
          enterOuterAlt(_localctx, 3);
          {
            setState(1199);
            preDecrementExpression();
          }
          break;
        case LOOKAHEAD:
        case IGNORE_CASE:
        case PARSER_BEGIN:
        case PARSER_END:
        case JAVACODE:
        case TOKEN:
        case SPECIAL_TOKEN:
        case MORE_:
        case SKIP_:
        case TOKEN_MGR_DECLS:
        case EOF_:
        case DCL_PARSER_BEGIN:
        case DCL_PARSER_END:
        case INC_PARSER_BEGIN:
        case INC_PARSER_END:
        case DEF_PARSER_BEGIN:
        case DEF_PARSER_END:
        case BOOLEAN:
        case BYTE:
        case CHAR:
        case CONST:
        case DOUBLE:
        case FALSE:
        case FLOAT:
        case INT:
        case LONG:
        case NEW:
        case NULL:
        case SHORT:
        case SUPER:
        case THIS:
        case TRUE:
        case VOID:
        case TEMPLATE:
        case INTEGER_LITERAL:
        case FLOATING_POINT_LITERAL:
        case CHARACTER_LITERAL:
        case STRING_LITERAL:
        case LPAREN:
        case BANG:
        case TILDE:
        case DOUBLECOLON:
        case IDENTIFIER:
          enterOuterAlt(_localctx, 4);
          {
            setState(1200);
            unaryExpressionNotPlusMinus();
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PreIncrementExpressionContext extends ParserRuleContext {
    public TerminalNode INCR() {
      return getToken(JavaccParser.INCR, 0);
    }

    public PrimaryExpressionContext primaryExpression() {
      return getRuleContext(PrimaryExpressionContext.class, 0);
    }

    public PreIncrementExpressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_preIncrementExpression;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterPreIncrementExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitPreIncrementExpression(this);
    }
  }

  public final PreIncrementExpressionContext preIncrementExpression() throws RecognitionException {
    PreIncrementExpressionContext _localctx = new PreIncrementExpressionContext(_ctx, getState());
    enterRule(_localctx, 170, RULE_preIncrementExpression);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1203);
        match(INCR);
        setState(1204);
        primaryExpression();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PreDecrementExpressionContext extends ParserRuleContext {
    public TerminalNode DECR() {
      return getToken(JavaccParser.DECR, 0);
    }

    public PrimaryExpressionContext primaryExpression() {
      return getRuleContext(PrimaryExpressionContext.class, 0);
    }

    public PreDecrementExpressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_preDecrementExpression;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterPreDecrementExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitPreDecrementExpression(this);
    }
  }

  public final PreDecrementExpressionContext preDecrementExpression() throws RecognitionException {
    PreDecrementExpressionContext _localctx = new PreDecrementExpressionContext(_ctx, getState());
    enterRule(_localctx, 172, RULE_preDecrementExpression);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1206);
        match(DECR);
        setState(1207);
        primaryExpression();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class UnaryExpressionNotPlusMinusContext extends ParserRuleContext {
    public UnaryExpressionContext unaryExpression() {
      return getRuleContext(UnaryExpressionContext.class, 0);
    }

    public TerminalNode TILDE() {
      return getToken(JavaccParser.TILDE, 0);
    }

    public TerminalNode BANG() {
      return getToken(JavaccParser.BANG, 0);
    }

    public CastExpressionContext castExpression() {
      return getRuleContext(CastExpressionContext.class, 0);
    }

    public PostfixExpressionContext postfixExpression() {
      return getRuleContext(PostfixExpressionContext.class, 0);
    }

    public UnaryExpressionNotPlusMinusContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_unaryExpressionNotPlusMinus;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterUnaryExpressionNotPlusMinus(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitUnaryExpressionNotPlusMinus(this);
    }
  }

  public final UnaryExpressionNotPlusMinusContext unaryExpressionNotPlusMinus()
      throws RecognitionException {
    UnaryExpressionNotPlusMinusContext _localctx =
        new UnaryExpressionNotPlusMinusContext(_ctx, getState());
    enterRule(_localctx, 174, RULE_unaryExpressionNotPlusMinus);
    int _la;
    try {
      setState(1213);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 145, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(1209);
            _la = _input.LA(1);
            if (!(_la == BANG || _la == TILDE)) {
              _errHandler.recoverInline(this);
            } else {
              if (_input.LA(1) == Token.EOF) matchedEOF = true;
              _errHandler.reportMatch(this);
              consume();
            }
            setState(1210);
            unaryExpression();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(1211);
            castExpression();
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(1212);
            postfixExpression();
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class CastLookaheadContext extends ParserRuleContext {
    public List<TerminalNode> LPAREN() {
      return getTokens(JavaccParser.LPAREN);
    }

    public TerminalNode LPAREN(int i) {
      return getToken(JavaccParser.LPAREN, i);
    }

    public PrimitiveTypeContext primitiveType() {
      return getRuleContext(PrimitiveTypeContext.class, 0);
    }

    public TypeContext type() {
      return getRuleContext(TypeContext.class, 0);
    }

    public TerminalNode LBRACKET() {
      return getToken(JavaccParser.LBRACKET, 0);
    }

    public TerminalNode RBRACKET() {
      return getToken(JavaccParser.RBRACKET, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(JavaccParser.RPAREN, 0);
    }

    public TerminalNode TILDE() {
      return getToken(JavaccParser.TILDE, 0);
    }

    public TerminalNode BANG() {
      return getToken(JavaccParser.BANG, 0);
    }

    public JavaIdentifierContext javaIdentifier() {
      return getRuleContext(JavaIdentifierContext.class, 0);
    }

    public TerminalNode THIS() {
      return getToken(JavaccParser.THIS, 0);
    }

    public TerminalNode SUPER() {
      return getToken(JavaccParser.SUPER, 0);
    }

    public TerminalNode NEW() {
      return getToken(JavaccParser.NEW, 0);
    }

    public LiteralContext literal() {
      return getRuleContext(LiteralContext.class, 0);
    }

    public CastLookaheadContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_castLookahead;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterCastLookahead(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitCastLookahead(this);
    }
  }

  public final CastLookaheadContext castLookahead() throws RecognitionException {
    CastLookaheadContext _localctx = new CastLookaheadContext(_ctx, getState());
    enterRule(_localctx, 176, RULE_castLookahead);
    try {
      setState(1235);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 147, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(1215);
            match(LPAREN);
            setState(1216);
            primitiveType();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(1217);
            match(LPAREN);
            setState(1218);
            type();
            setState(1219);
            match(LBRACKET);
            setState(1220);
            match(RBRACKET);
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(1222);
            match(LPAREN);
            setState(1223);
            type();
            setState(1224);
            match(RPAREN);
            setState(1233);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
              case TILDE:
                {
                  setState(1225);
                  match(TILDE);
                }
                break;
              case BANG:
                {
                  setState(1226);
                  match(BANG);
                }
                break;
              case LPAREN:
                {
                  setState(1227);
                  match(LPAREN);
                }
                break;
              case LOOKAHEAD:
              case IGNORE_CASE:
              case PARSER_BEGIN:
              case PARSER_END:
              case JAVACODE:
              case TOKEN:
              case SPECIAL_TOKEN:
              case MORE_:
              case SKIP_:
              case TOKEN_MGR_DECLS:
              case EOF_:
              case DCL_PARSER_BEGIN:
              case DCL_PARSER_END:
              case INC_PARSER_BEGIN:
              case INC_PARSER_END:
              case DEF_PARSER_BEGIN:
              case DEF_PARSER_END:
              case TEMPLATE:
              case IDENTIFIER:
                {
                  setState(1228);
                  javaIdentifier();
                }
                break;
              case THIS:
                {
                  setState(1229);
                  match(THIS);
                }
                break;
              case SUPER:
                {
                  setState(1230);
                  match(SUPER);
                }
                break;
              case NEW:
                {
                  setState(1231);
                  match(NEW);
                }
                break;
              case FALSE:
              case NULL:
              case TRUE:
              case INTEGER_LITERAL:
              case FLOATING_POINT_LITERAL:
              case CHARACTER_LITERAL:
              case STRING_LITERAL:
                {
                  setState(1232);
                  literal();
                }
                break;
              default:
                throw new NoViableAltException(this);
            }
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PostfixExpressionContext extends ParserRuleContext {
    public PrimaryExpressionContext primaryExpression() {
      return getRuleContext(PrimaryExpressionContext.class, 0);
    }

    public TerminalNode INCR() {
      return getToken(JavaccParser.INCR, 0);
    }

    public TerminalNode DECR() {
      return getToken(JavaccParser.DECR, 0);
    }

    public PostfixExpressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_postfixExpression;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterPostfixExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitPostfixExpression(this);
    }
  }

  public final PostfixExpressionContext postfixExpression() throws RecognitionException {
    PostfixExpressionContext _localctx = new PostfixExpressionContext(_ctx, getState());
    enterRule(_localctx, 178, RULE_postfixExpression);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1237);
        primaryExpression();
        setState(1239);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == INCR || _la == DECR) {
          {
            setState(1238);
            _la = _input.LA(1);
            if (!(_la == INCR || _la == DECR)) {
              _errHandler.recoverInline(this);
            } else {
              if (_input.LA(1) == Token.EOF) matchedEOF = true;
              _errHandler.reportMatch(this);
              consume();
            }
          }
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class CastExpressionContext extends ParserRuleContext {
    public TerminalNode LPAREN() {
      return getToken(JavaccParser.LPAREN, 0);
    }

    public TypeContext type() {
      return getRuleContext(TypeContext.class, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(JavaccParser.RPAREN, 0);
    }

    public UnaryExpressionContext unaryExpression() {
      return getRuleContext(UnaryExpressionContext.class, 0);
    }

    public UnaryExpressionNotPlusMinusContext unaryExpressionNotPlusMinus() {
      return getRuleContext(UnaryExpressionNotPlusMinusContext.class, 0);
    }

    public CastExpressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_castExpression;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterCastExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitCastExpression(this);
    }
  }

  public final CastExpressionContext castExpression() throws RecognitionException {
    CastExpressionContext _localctx = new CastExpressionContext(_ctx, getState());
    enterRule(_localctx, 180, RULE_castExpression);
    try {
      setState(1251);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 149, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(1241);
            match(LPAREN);
            setState(1242);
            type();
            setState(1243);
            match(RPAREN);
            setState(1244);
            unaryExpression();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(1246);
            match(LPAREN);
            setState(1247);
            type();
            setState(1248);
            match(RPAREN);
            setState(1249);
            unaryExpressionNotPlusMinus();
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PrimaryExpressionContext extends ParserRuleContext {
    public PrimaryPrefixContext primaryPrefix() {
      return getRuleContext(PrimaryPrefixContext.class, 0);
    }

    public List<PrimarySuffixContext> primarySuffix() {
      return getRuleContexts(PrimarySuffixContext.class);
    }

    public PrimarySuffixContext primarySuffix(int i) {
      return getRuleContext(PrimarySuffixContext.class, i);
    }

    public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_primaryExpression;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterPrimaryExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitPrimaryExpression(this);
    }
  }

  public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
    PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
    enterRule(_localctx, 182, RULE_primaryExpression);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(1253);
        primaryPrefix();
        setState(1257);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 150, _ctx);
        while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            {
              {
                setState(1254);
                primarySuffix();
              }
            }
          }
          setState(1259);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 150, _ctx);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class MemberSelectorContext extends ParserRuleContext {
    public TerminalNode DOT() {
      return getToken(JavaccParser.DOT, 0);
    }

    public TypeArgumentsContext typeArguments() {
      return getRuleContext(TypeArgumentsContext.class, 0);
    }

    public JavaIdentifierContext javaIdentifier() {
      return getRuleContext(JavaIdentifierContext.class, 0);
    }

    public MemberSelectorContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_memberSelector;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterMemberSelector(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitMemberSelector(this);
    }
  }

  public final MemberSelectorContext memberSelector() throws RecognitionException {
    MemberSelectorContext _localctx = new MemberSelectorContext(_ctx, getState());
    enterRule(_localctx, 184, RULE_memberSelector);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1260);
        match(DOT);
        setState(1261);
        typeArguments();
        setState(1262);
        javaIdentifier();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PrimaryPrefixContext extends ParserRuleContext {
    public LiteralContext literal() {
      return getRuleContext(LiteralContext.class, 0);
    }

    public TerminalNode THIS() {
      return getToken(JavaccParser.THIS, 0);
    }

    public TerminalNode SUPER() {
      return getToken(JavaccParser.SUPER, 0);
    }

    public TerminalNode DOT() {
      return getToken(JavaccParser.DOT, 0);
    }

    public JavaIdentifierContext javaIdentifier() {
      return getRuleContext(JavaIdentifierContext.class, 0);
    }

    public TerminalNode LPAREN() {
      return getToken(JavaccParser.LPAREN, 0);
    }

    public ExpressionContext expression() {
      return getRuleContext(ExpressionContext.class, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(JavaccParser.RPAREN, 0);
    }

    public AllocationExpressionContext allocationExpression() {
      return getRuleContext(AllocationExpressionContext.class, 0);
    }

    public ResultTypeContext resultType() {
      return getRuleContext(ResultTypeContext.class, 0);
    }

    public TerminalNode CLASS() {
      return getToken(JavaccParser.CLASS, 0);
    }

    public NameContext name() {
      return getRuleContext(NameContext.class, 0);
    }

    public PrimaryPrefixContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_primaryPrefix;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterPrimaryPrefix(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitPrimaryPrefix(this);
    }
  }

  public final PrimaryPrefixContext primaryPrefix() throws RecognitionException {
    PrimaryPrefixContext _localctx = new PrimaryPrefixContext(_ctx, getState());
    enterRule(_localctx, 186, RULE_primaryPrefix);
    try {
      setState(1279);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 151, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(1264);
            literal();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(1265);
            match(THIS);
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(1266);
            match(SUPER);
            setState(1267);
            match(DOT);
            setState(1268);
            javaIdentifier();
          }
          break;
        case 4:
          enterOuterAlt(_localctx, 4);
          {
            setState(1269);
            match(LPAREN);
            setState(1270);
            expression();
            setState(1271);
            match(RPAREN);
          }
          break;
        case 5:
          enterOuterAlt(_localctx, 5);
          {
            setState(1273);
            allocationExpression();
          }
          break;
        case 6:
          enterOuterAlt(_localctx, 6);
          {
            setState(1274);
            resultType();
            setState(1275);
            match(DOT);
            setState(1276);
            match(CLASS);
          }
          break;
        case 7:
          enterOuterAlt(_localctx, 7);
          {
            setState(1278);
            name();
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PrimarySuffixContext extends ParserRuleContext {
    public TerminalNode DOT() {
      return getToken(JavaccParser.DOT, 0);
    }

    public TerminalNode THIS() {
      return getToken(JavaccParser.THIS, 0);
    }

    public AllocationExpressionContext allocationExpression() {
      return getRuleContext(AllocationExpressionContext.class, 0);
    }

    public MemberSelectorContext memberSelector() {
      return getRuleContext(MemberSelectorContext.class, 0);
    }

    public TerminalNode LBRACKET() {
      return getToken(JavaccParser.LBRACKET, 0);
    }

    public ExpressionContext expression() {
      return getRuleContext(ExpressionContext.class, 0);
    }

    public TerminalNode RBRACKET() {
      return getToken(JavaccParser.RBRACKET, 0);
    }

    public JavaIdentifierContext javaIdentifier() {
      return getRuleContext(JavaIdentifierContext.class, 0);
    }

    public ArgumentsContext arguments() {
      return getRuleContext(ArgumentsContext.class, 0);
    }

    public PrimarySuffixContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_primarySuffix;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterPrimarySuffix(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitPrimarySuffix(this);
    }
  }

  public final PrimarySuffixContext primarySuffix() throws RecognitionException {
    PrimarySuffixContext _localctx = new PrimarySuffixContext(_ctx, getState());
    enterRule(_localctx, 188, RULE_primarySuffix);
    try {
      setState(1293);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 152, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(1281);
            match(DOT);
            setState(1282);
            match(THIS);
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(1283);
            match(DOT);
            setState(1284);
            allocationExpression();
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(1285);
            memberSelector();
          }
          break;
        case 4:
          enterOuterAlt(_localctx, 4);
          {
            setState(1286);
            match(LBRACKET);
            setState(1287);
            expression();
            setState(1288);
            match(RBRACKET);
          }
          break;
        case 5:
          enterOuterAlt(_localctx, 5);
          {
            setState(1290);
            match(DOT);
            setState(1291);
            javaIdentifier();
          }
          break;
        case 6:
          enterOuterAlt(_localctx, 6);
          {
            setState(1292);
            arguments();
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class LiteralContext extends ParserRuleContext {
    public TerminalNode INTEGER_LITERAL() {
      return getToken(JavaccParser.INTEGER_LITERAL, 0);
    }

    public TerminalNode FLOATING_POINT_LITERAL() {
      return getToken(JavaccParser.FLOATING_POINT_LITERAL, 0);
    }

    public TerminalNode CHARACTER_LITERAL() {
      return getToken(JavaccParser.CHARACTER_LITERAL, 0);
    }

    public TerminalNode STRING_LITERAL() {
      return getToken(JavaccParser.STRING_LITERAL, 0);
    }

    public BooleanLiteralContext booleanLiteral() {
      return getRuleContext(BooleanLiteralContext.class, 0);
    }

    public NullLiteralContext nullLiteral() {
      return getRuleContext(NullLiteralContext.class, 0);
    }

    public LiteralContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_literal;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterLiteral(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitLiteral(this);
    }
  }

  public final LiteralContext literal() throws RecognitionException {
    LiteralContext _localctx = new LiteralContext(_ctx, getState());
    enterRule(_localctx, 190, RULE_literal);
    try {
      setState(1301);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case INTEGER_LITERAL:
          enterOuterAlt(_localctx, 1);
          {
            setState(1295);
            match(INTEGER_LITERAL);
          }
          break;
        case FLOATING_POINT_LITERAL:
          enterOuterAlt(_localctx, 2);
          {
            setState(1296);
            match(FLOATING_POINT_LITERAL);
          }
          break;
        case CHARACTER_LITERAL:
          enterOuterAlt(_localctx, 3);
          {
            setState(1297);
            match(CHARACTER_LITERAL);
          }
          break;
        case STRING_LITERAL:
          enterOuterAlt(_localctx, 4);
          {
            setState(1298);
            match(STRING_LITERAL);
          }
          break;
        case FALSE:
        case TRUE:
          enterOuterAlt(_localctx, 5);
          {
            setState(1299);
            booleanLiteral();
          }
          break;
        case NULL:
          enterOuterAlt(_localctx, 6);
          {
            setState(1300);
            nullLiteral();
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class IntegerLiteralContext extends ParserRuleContext {
    public TerminalNode INTEGER_LITERAL() {
      return getToken(JavaccParser.INTEGER_LITERAL, 0);
    }

    public IntegerLiteralContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_integerLiteral;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterIntegerLiteral(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitIntegerLiteral(this);
    }
  }

  public final IntegerLiteralContext integerLiteral() throws RecognitionException {
    IntegerLiteralContext _localctx = new IntegerLiteralContext(_ctx, getState());
    enterRule(_localctx, 192, RULE_integerLiteral);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1303);
        match(INTEGER_LITERAL);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class BooleanLiteralContext extends ParserRuleContext {
    public TerminalNode TRUE() {
      return getToken(JavaccParser.TRUE, 0);
    }

    public TerminalNode FALSE() {
      return getToken(JavaccParser.FALSE, 0);
    }

    public BooleanLiteralContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_booleanLiteral;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterBooleanLiteral(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitBooleanLiteral(this);
    }
  }

  public final BooleanLiteralContext booleanLiteral() throws RecognitionException {
    BooleanLiteralContext _localctx = new BooleanLiteralContext(_ctx, getState());
    enterRule(_localctx, 194, RULE_booleanLiteral);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1305);
        _la = _input.LA(1);
        if (!(_la == FALSE || _la == TRUE)) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF) matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class StringLiteralContext extends ParserRuleContext {
    public TerminalNode STRING_LITERAL() {
      return getToken(JavaccParser.STRING_LITERAL, 0);
    }

    public StringLiteralContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_stringLiteral;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterStringLiteral(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitStringLiteral(this);
    }
  }

  public final StringLiteralContext stringLiteral() throws RecognitionException {
    StringLiteralContext _localctx = new StringLiteralContext(_ctx, getState());
    enterRule(_localctx, 196, RULE_stringLiteral);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1307);
        match(STRING_LITERAL);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class NullLiteralContext extends ParserRuleContext {
    public TerminalNode NULL() {
      return getToken(JavaccParser.NULL, 0);
    }

    public NullLiteralContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_nullLiteral;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterNullLiteral(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitNullLiteral(this);
    }
  }

  public final NullLiteralContext nullLiteral() throws RecognitionException {
    NullLiteralContext _localctx = new NullLiteralContext(_ctx, getState());
    enterRule(_localctx, 198, RULE_nullLiteral);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1309);
        match(NULL);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ArgumentsContext extends ParserRuleContext {
    public TerminalNode LPAREN() {
      return getToken(JavaccParser.LPAREN, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(JavaccParser.RPAREN, 0);
    }

    public ArgumentListContext argumentList() {
      return getRuleContext(ArgumentListContext.class, 0);
    }

    public ArgumentsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_arguments;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterArguments(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitArguments(this);
    }
  }

  public final ArgumentsContext arguments() throws RecognitionException {
    ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
    enterRule(_localctx, 200, RULE_arguments);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1311);
        match(LPAREN);
        setState(1313);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3819690555156193024L) != 0)
            || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 33797888870093897L) != 0)
            || _la == IDENTIFIER) {
          {
            setState(1312);
            argumentList();
          }
        }

        setState(1315);
        match(RPAREN);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ArgumentListContext extends ParserRuleContext {
    public List<ExpressionContext> expression() {
      return getRuleContexts(ExpressionContext.class);
    }

    public ExpressionContext expression(int i) {
      return getRuleContext(ExpressionContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(JavaccParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(JavaccParser.COMMA, i);
    }

    public ArgumentListContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_argumentList;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterArgumentList(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitArgumentList(this);
    }
  }

  public final ArgumentListContext argumentList() throws RecognitionException {
    ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
    enterRule(_localctx, 202, RULE_argumentList);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1317);
        expression();
        setState(1322);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == COMMA) {
          {
            {
              setState(1318);
              match(COMMA);
              setState(1319);
              expression();
            }
          }
          setState(1324);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class AllocationExpressionContext extends ParserRuleContext {
    public TerminalNode NEW() {
      return getToken(JavaccParser.NEW, 0);
    }

    public PrimitiveTypeContext primitiveType() {
      return getRuleContext(PrimitiveTypeContext.class, 0);
    }

    public ArrayDimsAndInitsContext arrayDimsAndInits() {
      return getRuleContext(ArrayDimsAndInitsContext.class, 0);
    }

    public ClassOrInterfaceTypeContext classOrInterfaceType() {
      return getRuleContext(ClassOrInterfaceTypeContext.class, 0);
    }

    public ArgumentsContext arguments() {
      return getRuleContext(ArgumentsContext.class, 0);
    }

    public TypeArgumentsContext typeArguments() {
      return getRuleContext(TypeArgumentsContext.class, 0);
    }

    public ClassOrInterfaceBodyContext classOrInterfaceBody() {
      return getRuleContext(ClassOrInterfaceBodyContext.class, 0);
    }

    public AllocationExpressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_allocationExpression;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterAllocationExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitAllocationExpression(this);
    }
  }

  public final AllocationExpressionContext allocationExpression() throws RecognitionException {
    AllocationExpressionContext _localctx = new AllocationExpressionContext(_ctx, getState());
    enterRule(_localctx, 204, RULE_allocationExpression);
    int _la;
    try {
      setState(1341);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 159, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(1325);
            match(NEW);
            setState(1326);
            primitiveType();
            setState(1327);
            arrayDimsAndInits();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(1329);
            match(NEW);
            setState(1330);
            classOrInterfaceType();
            setState(1332);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == LT) {
              {
                setState(1331);
                typeArguments();
              }
            }

            setState(1339);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
              case LBRACKET:
                {
                  setState(1334);
                  arrayDimsAndInits();
                }
                break;
              case LPAREN:
                {
                  setState(1335);
                  arguments();
                  setState(1337);
                  _errHandler.sync(this);
                  _la = _input.LA(1);
                  if (_la == LBRACE) {
                    {
                      setState(1336);
                      classOrInterfaceBody();
                    }
                  }
                }
                break;
              default:
                throw new NoViableAltException(this);
            }
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ArrayDimsAndInitsContext extends ParserRuleContext {
    public List<TerminalNode> LBRACKET() {
      return getTokens(JavaccParser.LBRACKET);
    }

    public TerminalNode LBRACKET(int i) {
      return getToken(JavaccParser.LBRACKET, i);
    }

    public List<ExpressionContext> expression() {
      return getRuleContexts(ExpressionContext.class);
    }

    public ExpressionContext expression(int i) {
      return getRuleContext(ExpressionContext.class, i);
    }

    public List<TerminalNode> RBRACKET() {
      return getTokens(JavaccParser.RBRACKET);
    }

    public TerminalNode RBRACKET(int i) {
      return getToken(JavaccParser.RBRACKET, i);
    }

    public ArrayInitializerContext arrayInitializer() {
      return getRuleContext(ArrayInitializerContext.class, 0);
    }

    public ArrayDimsAndInitsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_arrayDimsAndInits;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterArrayDimsAndInits(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitArrayDimsAndInits(this);
    }
  }

  public final ArrayDimsAndInitsContext arrayDimsAndInits() throws RecognitionException {
    ArrayDimsAndInitsContext _localctx = new ArrayDimsAndInitsContext(_ctx, getState());
    enterRule(_localctx, 206, RULE_arrayDimsAndInits);
    int _la;
    try {
      int _alt;
      setState(1365);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 163, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(1347);
            _errHandler.sync(this);
            _alt = 1;
            do {
              switch (_alt) {
                case 1:
                  {
                    {
                      setState(1343);
                      match(LBRACKET);
                      setState(1344);
                      expression();
                      setState(1345);
                      match(RBRACKET);
                    }
                  }
                  break;
                default:
                  throw new NoViableAltException(this);
              }
              setState(1349);
              _errHandler.sync(this);
              _alt = getInterpreter().adaptivePredict(_input, 160, _ctx);
            } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
            setState(1355);
            _errHandler.sync(this);
            _alt = getInterpreter().adaptivePredict(_input, 161, _ctx);
            while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
              if (_alt == 1) {
                {
                  {
                    setState(1351);
                    match(LBRACKET);
                    setState(1352);
                    match(RBRACKET);
                  }
                }
              }
              setState(1357);
              _errHandler.sync(this);
              _alt = getInterpreter().adaptivePredict(_input, 161, _ctx);
            }
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(1360);
            _errHandler.sync(this);
            _la = _input.LA(1);
            do {
              {
                {
                  setState(1358);
                  match(LBRACKET);
                  setState(1359);
                  match(RBRACKET);
                }
              }
              setState(1362);
              _errHandler.sync(this);
              _la = _input.LA(1);
            } while (_la == LBRACKET);
            setState(1364);
            arrayInitializer();
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class StatementContext extends ParserRuleContext {
    public LabeledStatementContext labeledStatement() {
      return getRuleContext(LabeledStatementContext.class, 0);
    }

    public AssertStatementContext assertStatement() {
      return getRuleContext(AssertStatementContext.class, 0);
    }

    public BlockContext block() {
      return getRuleContext(BlockContext.class, 0);
    }

    public EmptyStatementContext emptyStatement() {
      return getRuleContext(EmptyStatementContext.class, 0);
    }

    public StatementExpressionContext statementExpression() {
      return getRuleContext(StatementExpressionContext.class, 0);
    }

    public TerminalNode SEMICOLON() {
      return getToken(JavaccParser.SEMICOLON, 0);
    }

    public SwitchStatementContext switchStatement() {
      return getRuleContext(SwitchStatementContext.class, 0);
    }

    public IfStatementContext ifStatement() {
      return getRuleContext(IfStatementContext.class, 0);
    }

    public WhileStatementContext whileStatement() {
      return getRuleContext(WhileStatementContext.class, 0);
    }

    public DoStatementContext doStatement() {
      return getRuleContext(DoStatementContext.class, 0);
    }

    public ForStatementContext forStatement() {
      return getRuleContext(ForStatementContext.class, 0);
    }

    public BreakStatementContext breakStatement() {
      return getRuleContext(BreakStatementContext.class, 0);
    }

    public ContinueStatementContext continueStatement() {
      return getRuleContext(ContinueStatementContext.class, 0);
    }

    public ReturnStatementContext returnStatement() {
      return getRuleContext(ReturnStatementContext.class, 0);
    }

    public ThrowStatementContext throwStatement() {
      return getRuleContext(ThrowStatementContext.class, 0);
    }

    public SynchronizedStatementContext synchronizedStatement() {
      return getRuleContext(SynchronizedStatementContext.class, 0);
    }

    public TryStatementContext tryStatement() {
      return getRuleContext(TryStatementContext.class, 0);
    }

    public StatementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_statement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitStatement(this);
    }
  }

  public final StatementContext statement() throws RecognitionException {
    StatementContext _localctx = new StatementContext(_ctx, getState());
    enterRule(_localctx, 208, RULE_statement);
    try {
      setState(1385);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 164, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(1367);
            labeledStatement();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(1368);
            assertStatement();
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(1369);
            block();
          }
          break;
        case 4:
          enterOuterAlt(_localctx, 4);
          {
            setState(1370);
            emptyStatement();
          }
          break;
        case 5:
          enterOuterAlt(_localctx, 5);
          {
            setState(1371);
            statementExpression();
            setState(1372);
            match(SEMICOLON);
          }
          break;
        case 6:
          enterOuterAlt(_localctx, 6);
          {
            setState(1374);
            switchStatement();
          }
          break;
        case 7:
          enterOuterAlt(_localctx, 7);
          {
            setState(1375);
            ifStatement();
          }
          break;
        case 8:
          enterOuterAlt(_localctx, 8);
          {
            setState(1376);
            whileStatement();
          }
          break;
        case 9:
          enterOuterAlt(_localctx, 9);
          {
            setState(1377);
            doStatement();
          }
          break;
        case 10:
          enterOuterAlt(_localctx, 10);
          {
            setState(1378);
            forStatement();
          }
          break;
        case 11:
          enterOuterAlt(_localctx, 11);
          {
            setState(1379);
            breakStatement();
          }
          break;
        case 12:
          enterOuterAlt(_localctx, 12);
          {
            setState(1380);
            continueStatement();
          }
          break;
        case 13:
          enterOuterAlt(_localctx, 13);
          {
            setState(1381);
            returnStatement();
          }
          break;
        case 14:
          enterOuterAlt(_localctx, 14);
          {
            setState(1382);
            throwStatement();
          }
          break;
        case 15:
          enterOuterAlt(_localctx, 15);
          {
            setState(1383);
            synchronizedStatement();
          }
          break;
        case 16:
          enterOuterAlt(_localctx, 16);
          {
            setState(1384);
            tryStatement();
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class AssertStatementContext extends ParserRuleContext {
    public TerminalNode ASSERT() {
      return getToken(JavaccParser.ASSERT, 0);
    }

    public List<ExpressionContext> expression() {
      return getRuleContexts(ExpressionContext.class);
    }

    public ExpressionContext expression(int i) {
      return getRuleContext(ExpressionContext.class, i);
    }

    public TerminalNode SEMICOLON() {
      return getToken(JavaccParser.SEMICOLON, 0);
    }

    public TerminalNode COLON() {
      return getToken(JavaccParser.COLON, 0);
    }

    public AssertStatementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_assertStatement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterAssertStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitAssertStatement(this);
    }
  }

  public final AssertStatementContext assertStatement() throws RecognitionException {
    AssertStatementContext _localctx = new AssertStatementContext(_ctx, getState());
    enterRule(_localctx, 210, RULE_assertStatement);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1387);
        match(ASSERT);
        setState(1388);
        expression();
        setState(1391);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == COLON) {
          {
            setState(1389);
            match(COLON);
            setState(1390);
            expression();
          }
        }

        setState(1393);
        match(SEMICOLON);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class LabeledStatementContext extends ParserRuleContext {
    public JavaIdentifierContext javaIdentifier() {
      return getRuleContext(JavaIdentifierContext.class, 0);
    }

    public TerminalNode COLON() {
      return getToken(JavaccParser.COLON, 0);
    }

    public StatementContext statement() {
      return getRuleContext(StatementContext.class, 0);
    }

    public LabeledStatementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_labeledStatement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterLabeledStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitLabeledStatement(this);
    }
  }

  public final LabeledStatementContext labeledStatement() throws RecognitionException {
    LabeledStatementContext _localctx = new LabeledStatementContext(_ctx, getState());
    enterRule(_localctx, 212, RULE_labeledStatement);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1395);
        javaIdentifier();
        setState(1396);
        match(COLON);
        setState(1397);
        statement();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class BlockContext extends ParserRuleContext {
    public TerminalNode LBRACE() {
      return getToken(JavaccParser.LBRACE, 0);
    }

    public TerminalNode RBRACE() {
      return getToken(JavaccParser.RBRACE, 0);
    }

    public List<BlockStatementContext> blockStatement() {
      return getRuleContexts(BlockStatementContext.class);
    }

    public BlockStatementContext blockStatement(int i) {
      return getRuleContext(BlockStatementContext.class, i);
    }

    public BlockContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_block;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterBlock(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitBlock(this);
    }
  }

  public final BlockContext block() throws RecognitionException {
    BlockContext _localctx = new BlockContext(_ctx, getState());
    enterRule(_localctx, 214, RULE_block);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1399);
        match(LBRACE);
        setState(1403);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -4677332412173131904L) != 0)
            || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 54184232625895423L) != 0)
            || _la == IDENTIFIER) {
          {
            {
              setState(1400);
              blockStatement();
            }
          }
          setState(1405);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(1406);
        match(RBRACE);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class BlockStatementContext extends ParserRuleContext {
    public LocalVariableDeclarationContext localVariableDeclaration() {
      return getRuleContext(LocalVariableDeclarationContext.class, 0);
    }

    public TerminalNode SEMICOLON() {
      return getToken(JavaccParser.SEMICOLON, 0);
    }

    public StatementContext statement() {
      return getRuleContext(StatementContext.class, 0);
    }

    public ClassOrInterfaceDeclarationContext classOrInterfaceDeclaration() {
      return getRuleContext(ClassOrInterfaceDeclarationContext.class, 0);
    }

    public BlockStatementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_blockStatement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterBlockStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitBlockStatement(this);
    }
  }

  public final BlockStatementContext blockStatement() throws RecognitionException {
    BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
    enterRule(_localctx, 216, RULE_blockStatement);
    try {
      setState(1413);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 167, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(1408);
            localVariableDeclaration();
            setState(1409);
            match(SEMICOLON);
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(1411);
            statement();
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(1412);
            classOrInterfaceDeclaration();
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class LocalVariableDeclarationContext extends ParserRuleContext {
    public ModifiersContext modifiers() {
      return getRuleContext(ModifiersContext.class, 0);
    }

    public TypeContext type() {
      return getRuleContext(TypeContext.class, 0);
    }

    public List<VariableDeclaratorContext> variableDeclarator() {
      return getRuleContexts(VariableDeclaratorContext.class);
    }

    public VariableDeclaratorContext variableDeclarator(int i) {
      return getRuleContext(VariableDeclaratorContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(JavaccParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(JavaccParser.COMMA, i);
    }

    public LocalVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_localVariableDeclaration;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterLocalVariableDeclaration(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitLocalVariableDeclaration(this);
    }
  }

  public final LocalVariableDeclarationContext localVariableDeclaration()
      throws RecognitionException {
    LocalVariableDeclarationContext _localctx =
        new LocalVariableDeclarationContext(_ctx, getState());
    enterRule(_localctx, 218, RULE_localVariableDeclaration);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1415);
        modifiers();
        setState(1416);
        type();
        setState(1417);
        variableDeclarator();
        setState(1422);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == COMMA) {
          {
            {
              setState(1418);
              match(COMMA);
              setState(1419);
              variableDeclarator();
            }
          }
          setState(1424);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class EmptyStatementContext extends ParserRuleContext {
    public TerminalNode SEMICOLON() {
      return getToken(JavaccParser.SEMICOLON, 0);
    }

    public EmptyStatementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_emptyStatement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterEmptyStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitEmptyStatement(this);
    }
  }

  public final EmptyStatementContext emptyStatement() throws RecognitionException {
    EmptyStatementContext _localctx = new EmptyStatementContext(_ctx, getState());
    enterRule(_localctx, 220, RULE_emptyStatement);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1425);
        match(SEMICOLON);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class StatementExpressionContext extends ParserRuleContext {
    public PreIncrementExpressionContext preIncrementExpression() {
      return getRuleContext(PreIncrementExpressionContext.class, 0);
    }

    public PreDecrementExpressionContext preDecrementExpression() {
      return getRuleContext(PreDecrementExpressionContext.class, 0);
    }

    public PrimaryExpressionContext primaryExpression() {
      return getRuleContext(PrimaryExpressionContext.class, 0);
    }

    public TerminalNode INCR() {
      return getToken(JavaccParser.INCR, 0);
    }

    public TerminalNode DECR() {
      return getToken(JavaccParser.DECR, 0);
    }

    public AssignmentOperatorContext assignmentOperator() {
      return getRuleContext(AssignmentOperatorContext.class, 0);
    }

    public ExpressionContext expression() {
      return getRuleContext(ExpressionContext.class, 0);
    }

    public StatementExpressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_statementExpression;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterStatementExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitStatementExpression(this);
    }
  }

  public final StatementExpressionContext statementExpression() throws RecognitionException {
    StatementExpressionContext _localctx = new StatementExpressionContext(_ctx, getState());
    enterRule(_localctx, 222, RULE_statementExpression);
    try {
      setState(1437);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case INCR:
          enterOuterAlt(_localctx, 1);
          {
            setState(1427);
            preIncrementExpression();
          }
          break;
        case DECR:
          enterOuterAlt(_localctx, 2);
          {
            setState(1428);
            preDecrementExpression();
          }
          break;
        case LOOKAHEAD:
        case IGNORE_CASE:
        case PARSER_BEGIN:
        case PARSER_END:
        case JAVACODE:
        case TOKEN:
        case SPECIAL_TOKEN:
        case MORE_:
        case SKIP_:
        case TOKEN_MGR_DECLS:
        case EOF_:
        case DCL_PARSER_BEGIN:
        case DCL_PARSER_END:
        case INC_PARSER_BEGIN:
        case INC_PARSER_END:
        case DEF_PARSER_BEGIN:
        case DEF_PARSER_END:
        case BOOLEAN:
        case BYTE:
        case CHAR:
        case CONST:
        case DOUBLE:
        case FALSE:
        case FLOAT:
        case INT:
        case LONG:
        case NEW:
        case NULL:
        case SHORT:
        case SUPER:
        case THIS:
        case TRUE:
        case VOID:
        case TEMPLATE:
        case INTEGER_LITERAL:
        case FLOATING_POINT_LITERAL:
        case CHARACTER_LITERAL:
        case STRING_LITERAL:
        case LPAREN:
        case DOUBLECOLON:
        case IDENTIFIER:
          enterOuterAlt(_localctx, 3);
          {
            setState(1429);
            primaryExpression();
            setState(1435);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
              case INCR:
                {
                  setState(1430);
                  match(INCR);
                }
                break;
              case DECR:
                {
                  setState(1431);
                  match(DECR);
                }
                break;
              case T__2:
              case T__3:
              case T__4:
              case ASSIGN:
              case PLUSASSIGN:
              case MINUSASSIGN:
              case STARASSIGN:
              case SLASHASSIGN:
              case ANDASSIGN:
              case ORASSIGN:
              case XORASSIGN:
              case REMASSIGN:
                {
                  setState(1432);
                  assignmentOperator();
                  setState(1433);
                  expression();
                }
                break;
              case RPAREN:
              case SEMICOLON:
              case COMMA:
                break;
              default:
                break;
            }
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class SwitchStatementContext extends ParserRuleContext {
    public TerminalNode SWITCH() {
      return getToken(JavaccParser.SWITCH, 0);
    }

    public TerminalNode LPAREN() {
      return getToken(JavaccParser.LPAREN, 0);
    }

    public ExpressionContext expression() {
      return getRuleContext(ExpressionContext.class, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(JavaccParser.RPAREN, 0);
    }

    public TerminalNode LBRACE() {
      return getToken(JavaccParser.LBRACE, 0);
    }

    public TerminalNode RBRACE() {
      return getToken(JavaccParser.RBRACE, 0);
    }

    public List<SwitchLabelContext> switchLabel() {
      return getRuleContexts(SwitchLabelContext.class);
    }

    public SwitchLabelContext switchLabel(int i) {
      return getRuleContext(SwitchLabelContext.class, i);
    }

    public List<BlockStatementContext> blockStatement() {
      return getRuleContexts(BlockStatementContext.class);
    }

    public BlockStatementContext blockStatement(int i) {
      return getRuleContext(BlockStatementContext.class, i);
    }

    public SwitchStatementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_switchStatement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterSwitchStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitSwitchStatement(this);
    }
  }

  public final SwitchStatementContext switchStatement() throws RecognitionException {
    SwitchStatementContext _localctx = new SwitchStatementContext(_ctx, getState());
    enterRule(_localctx, 224, RULE_switchStatement);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1439);
        match(SWITCH);
        setState(1440);
        match(LPAREN);
        setState(1441);
        expression();
        setState(1442);
        match(RPAREN);
        setState(1443);
        match(LBRACE);
        setState(1453);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == CASE || _la == DEFAULT) {
          {
            {
              setState(1444);
              switchLabel();
              setState(1448);
              _errHandler.sync(this);
              _la = _input.LA(1);
              while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -4677332412173131904L) != 0)
                  || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 54184232625895423L) != 0)
                  || _la == IDENTIFIER) {
                {
                  {
                    setState(1445);
                    blockStatement();
                  }
                }
                setState(1450);
                _errHandler.sync(this);
                _la = _input.LA(1);
              }
            }
          }
          setState(1455);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(1456);
        match(RBRACE);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class SwitchLabelContext extends ParserRuleContext {
    public TerminalNode CASE() {
      return getToken(JavaccParser.CASE, 0);
    }

    public ExpressionContext expression() {
      return getRuleContext(ExpressionContext.class, 0);
    }

    public TerminalNode COLON() {
      return getToken(JavaccParser.COLON, 0);
    }

    public TerminalNode DEFAULT() {
      return getToken(JavaccParser.DEFAULT, 0);
    }

    public SwitchLabelContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_switchLabel;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterSwitchLabel(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitSwitchLabel(this);
    }
  }

  public final SwitchLabelContext switchLabel() throws RecognitionException {
    SwitchLabelContext _localctx = new SwitchLabelContext(_ctx, getState());
    enterRule(_localctx, 226, RULE_switchLabel);
    try {
      setState(1464);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case CASE:
          enterOuterAlt(_localctx, 1);
          {
            setState(1458);
            match(CASE);
            setState(1459);
            expression();
            setState(1460);
            match(COLON);
          }
          break;
        case DEFAULT:
          enterOuterAlt(_localctx, 2);
          {
            setState(1462);
            match(DEFAULT);
            setState(1463);
            match(COLON);
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class IfStatementContext extends ParserRuleContext {
    public TerminalNode IF() {
      return getToken(JavaccParser.IF, 0);
    }

    public TerminalNode LPAREN() {
      return getToken(JavaccParser.LPAREN, 0);
    }

    public ExpressionContext expression() {
      return getRuleContext(ExpressionContext.class, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(JavaccParser.RPAREN, 0);
    }

    public List<StatementContext> statement() {
      return getRuleContexts(StatementContext.class);
    }

    public StatementContext statement(int i) {
      return getRuleContext(StatementContext.class, i);
    }

    public TerminalNode ELSE() {
      return getToken(JavaccParser.ELSE, 0);
    }

    public IfStatementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_ifStatement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterIfStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitIfStatement(this);
    }
  }

  public final IfStatementContext ifStatement() throws RecognitionException {
    IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
    enterRule(_localctx, 228, RULE_ifStatement);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1466);
        match(IF);
        setState(1467);
        match(LPAREN);
        setState(1468);
        expression();
        setState(1469);
        match(RPAREN);
        setState(1470);
        statement();
        setState(1473);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 174, _ctx)) {
          case 1:
            {
              setState(1471);
              match(ELSE);
              setState(1472);
              statement();
            }
            break;
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class WhileStatementContext extends ParserRuleContext {
    public TerminalNode WHILE() {
      return getToken(JavaccParser.WHILE, 0);
    }

    public TerminalNode LPAREN() {
      return getToken(JavaccParser.LPAREN, 0);
    }

    public ExpressionContext expression() {
      return getRuleContext(ExpressionContext.class, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(JavaccParser.RPAREN, 0);
    }

    public StatementContext statement() {
      return getRuleContext(StatementContext.class, 0);
    }

    public WhileStatementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_whileStatement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterWhileStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitWhileStatement(this);
    }
  }

  public final WhileStatementContext whileStatement() throws RecognitionException {
    WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
    enterRule(_localctx, 230, RULE_whileStatement);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1475);
        match(WHILE);
        setState(1476);
        match(LPAREN);
        setState(1477);
        expression();
        setState(1478);
        match(RPAREN);
        setState(1479);
        statement();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class DoStatementContext extends ParserRuleContext {
    public TerminalNode DO() {
      return getToken(JavaccParser.DO, 0);
    }

    public StatementContext statement() {
      return getRuleContext(StatementContext.class, 0);
    }

    public TerminalNode WHILE() {
      return getToken(JavaccParser.WHILE, 0);
    }

    public TerminalNode LPAREN() {
      return getToken(JavaccParser.LPAREN, 0);
    }

    public ExpressionContext expression() {
      return getRuleContext(ExpressionContext.class, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(JavaccParser.RPAREN, 0);
    }

    public TerminalNode SEMICOLON() {
      return getToken(JavaccParser.SEMICOLON, 0);
    }

    public DoStatementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_doStatement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterDoStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitDoStatement(this);
    }
  }

  public final DoStatementContext doStatement() throws RecognitionException {
    DoStatementContext _localctx = new DoStatementContext(_ctx, getState());
    enterRule(_localctx, 232, RULE_doStatement);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1481);
        match(DO);
        setState(1482);
        statement();
        setState(1483);
        match(WHILE);
        setState(1484);
        match(LPAREN);
        setState(1485);
        expression();
        setState(1486);
        match(RPAREN);
        setState(1487);
        match(SEMICOLON);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ForStatementContext extends ParserRuleContext {
    public TerminalNode FOR() {
      return getToken(JavaccParser.FOR, 0);
    }

    public TerminalNode LPAREN() {
      return getToken(JavaccParser.LPAREN, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(JavaccParser.RPAREN, 0);
    }

    public StatementContext statement() {
      return getRuleContext(StatementContext.class, 0);
    }

    public ModifiersContext modifiers() {
      return getRuleContext(ModifiersContext.class, 0);
    }

    public TypeContext type() {
      return getRuleContext(TypeContext.class, 0);
    }

    public JavaIdentifierContext javaIdentifier() {
      return getRuleContext(JavaIdentifierContext.class, 0);
    }

    public TerminalNode COLON() {
      return getToken(JavaccParser.COLON, 0);
    }

    public ExpressionContext expression() {
      return getRuleContext(ExpressionContext.class, 0);
    }

    public List<TerminalNode> SEMICOLON() {
      return getTokens(JavaccParser.SEMICOLON);
    }

    public TerminalNode SEMICOLON(int i) {
      return getToken(JavaccParser.SEMICOLON, i);
    }

    public ForInitContext forInit() {
      return getRuleContext(ForInitContext.class, 0);
    }

    public ForUpdateContext forUpdate() {
      return getRuleContext(ForUpdateContext.class, 0);
    }

    public ForStatementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_forStatement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterForStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitForStatement(this);
    }
  }

  public final ForStatementContext forStatement() throws RecognitionException {
    ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
    enterRule(_localctx, 234, RULE_forStatement);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1489);
        match(FOR);
        setState(1490);
        match(LPAREN);
        setState(1508);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 178, _ctx)) {
          case 1:
            {
              setState(1491);
              modifiers();
              setState(1492);
              type();
              setState(1493);
              javaIdentifier();
              setState(1494);
              match(COLON);
              setState(1495);
              expression();
            }
            break;
          case 2:
            {
              setState(1498);
              _errHandler.sync(this);
              _la = _input.LA(1);
              if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -4827079991369932928L) != 0)
                  || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 54183940567970683L) != 0)
                  || _la == IDENTIFIER) {
                {
                  setState(1497);
                  forInit();
                }
              }

              setState(1500);
              match(SEMICOLON);
              setState(1502);
              _errHandler.sync(this);
              _la = _input.LA(1);
              if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3819690555156193024L) != 0)
                  || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 33797888870093897L) != 0)
                  || _la == IDENTIFIER) {
                {
                  setState(1501);
                  expression();
                }
              }

              setState(1504);
              match(SEMICOLON);
              setState(1506);
              _errHandler.sync(this);
              _la = _input.LA(1);
              if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3819690555156193024L) != 0)
                  || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 6772992570987593L) != 0)
                  || _la == IDENTIFIER) {
                {
                  setState(1505);
                  forUpdate();
                }
              }
            }
            break;
        }
        setState(1510);
        match(RPAREN);
        setState(1511);
        statement();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ForInitContext extends ParserRuleContext {
    public LocalVariableDeclarationContext localVariableDeclaration() {
      return getRuleContext(LocalVariableDeclarationContext.class, 0);
    }

    public StatementExpressionListContext statementExpressionList() {
      return getRuleContext(StatementExpressionListContext.class, 0);
    }

    public ForInitContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_forInit;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterForInit(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitForInit(this);
    }
  }

  public final ForInitContext forInit() throws RecognitionException {
    ForInitContext _localctx = new ForInitContext(_ctx, getState());
    enterRule(_localctx, 236, RULE_forInit);
    try {
      setState(1515);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 179, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(1513);
            localVariableDeclaration();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(1514);
            statementExpressionList();
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class StatementExpressionListContext extends ParserRuleContext {
    public List<StatementExpressionContext> statementExpression() {
      return getRuleContexts(StatementExpressionContext.class);
    }

    public StatementExpressionContext statementExpression(int i) {
      return getRuleContext(StatementExpressionContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(JavaccParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(JavaccParser.COMMA, i);
    }

    public StatementExpressionListContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_statementExpressionList;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterStatementExpressionList(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitStatementExpressionList(this);
    }
  }

  public final StatementExpressionListContext statementExpressionList()
      throws RecognitionException {
    StatementExpressionListContext _localctx = new StatementExpressionListContext(_ctx, getState());
    enterRule(_localctx, 238, RULE_statementExpressionList);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1517);
        statementExpression();
        setState(1522);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == COMMA) {
          {
            {
              setState(1518);
              match(COMMA);
              setState(1519);
              statementExpression();
            }
          }
          setState(1524);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ForUpdateContext extends ParserRuleContext {
    public StatementExpressionListContext statementExpressionList() {
      return getRuleContext(StatementExpressionListContext.class, 0);
    }

    public ForUpdateContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_forUpdate;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterForUpdate(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitForUpdate(this);
    }
  }

  public final ForUpdateContext forUpdate() throws RecognitionException {
    ForUpdateContext _localctx = new ForUpdateContext(_ctx, getState());
    enterRule(_localctx, 240, RULE_forUpdate);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1525);
        statementExpressionList();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class BreakStatementContext extends ParserRuleContext {
    public TerminalNode BREAK() {
      return getToken(JavaccParser.BREAK, 0);
    }

    public TerminalNode SEMICOLON() {
      return getToken(JavaccParser.SEMICOLON, 0);
    }

    public JavaIdentifierContext javaIdentifier() {
      return getRuleContext(JavaIdentifierContext.class, 0);
    }

    public BreakStatementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_breakStatement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterBreakStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitBreakStatement(this);
    }
  }

  public final BreakStatementContext breakStatement() throws RecognitionException {
    BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
    enterRule(_localctx, 242, RULE_breakStatement);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1527);
        match(BREAK);
        setState(1529);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 67100416L) != 0)
            || _la == TEMPLATE
            || _la == IDENTIFIER) {
          {
            setState(1528);
            javaIdentifier();
          }
        }

        setState(1531);
        match(SEMICOLON);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ContinueStatementContext extends ParserRuleContext {
    public TerminalNode CONTINUE() {
      return getToken(JavaccParser.CONTINUE, 0);
    }

    public TerminalNode SEMICOLON() {
      return getToken(JavaccParser.SEMICOLON, 0);
    }

    public JavaIdentifierContext javaIdentifier() {
      return getRuleContext(JavaIdentifierContext.class, 0);
    }

    public ContinueStatementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_continueStatement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterContinueStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitContinueStatement(this);
    }
  }

  public final ContinueStatementContext continueStatement() throws RecognitionException {
    ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
    enterRule(_localctx, 244, RULE_continueStatement);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1533);
        match(CONTINUE);
        setState(1535);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 67100416L) != 0)
            || _la == TEMPLATE
            || _la == IDENTIFIER) {
          {
            setState(1534);
            javaIdentifier();
          }
        }

        setState(1537);
        match(SEMICOLON);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ReturnStatementContext extends ParserRuleContext {
    public TerminalNode RETURN() {
      return getToken(JavaccParser.RETURN, 0);
    }

    public TerminalNode SEMICOLON() {
      return getToken(JavaccParser.SEMICOLON, 0);
    }

    public ExpressionContext expression() {
      return getRuleContext(ExpressionContext.class, 0);
    }

    public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_returnStatement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterReturnStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitReturnStatement(this);
    }
  }

  public final ReturnStatementContext returnStatement() throws RecognitionException {
    ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
    enterRule(_localctx, 246, RULE_returnStatement);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1539);
        match(RETURN);
        setState(1541);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3819690555156193024L) != 0)
            || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 33797888870093897L) != 0)
            || _la == IDENTIFIER) {
          {
            setState(1540);
            expression();
          }
        }

        setState(1543);
        match(SEMICOLON);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ThrowStatementContext extends ParserRuleContext {
    public TerminalNode THROW() {
      return getToken(JavaccParser.THROW, 0);
    }

    public ExpressionContext expression() {
      return getRuleContext(ExpressionContext.class, 0);
    }

    public TerminalNode SEMICOLON() {
      return getToken(JavaccParser.SEMICOLON, 0);
    }

    public ThrowStatementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_throwStatement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterThrowStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitThrowStatement(this);
    }
  }

  public final ThrowStatementContext throwStatement() throws RecognitionException {
    ThrowStatementContext _localctx = new ThrowStatementContext(_ctx, getState());
    enterRule(_localctx, 248, RULE_throwStatement);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1545);
        match(THROW);
        setState(1546);
        expression();
        setState(1547);
        match(SEMICOLON);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class SynchronizedStatementContext extends ParserRuleContext {
    public TerminalNode SYNCHRONIZED() {
      return getToken(JavaccParser.SYNCHRONIZED, 0);
    }

    public TerminalNode LPAREN() {
      return getToken(JavaccParser.LPAREN, 0);
    }

    public ExpressionContext expression() {
      return getRuleContext(ExpressionContext.class, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(JavaccParser.RPAREN, 0);
    }

    public BlockContext block() {
      return getRuleContext(BlockContext.class, 0);
    }

    public SynchronizedStatementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_synchronizedStatement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterSynchronizedStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitSynchronizedStatement(this);
    }
  }

  public final SynchronizedStatementContext synchronizedStatement() throws RecognitionException {
    SynchronizedStatementContext _localctx = new SynchronizedStatementContext(_ctx, getState());
    enterRule(_localctx, 250, RULE_synchronizedStatement);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1549);
        match(SYNCHRONIZED);
        setState(1550);
        match(LPAREN);
        setState(1551);
        expression();
        setState(1552);
        match(RPAREN);
        setState(1553);
        block();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ResourceDeclarationContext extends ParserRuleContext {
    public TypeContext type() {
      return getRuleContext(TypeContext.class, 0);
    }

    public VariableDeclaratorIdContext variableDeclaratorId() {
      return getRuleContext(VariableDeclaratorIdContext.class, 0);
    }

    public TerminalNode ASSIGN() {
      return getToken(JavaccParser.ASSIGN, 0);
    }

    public ExpressionContext expression() {
      return getRuleContext(ExpressionContext.class, 0);
    }

    public ResourceDeclarationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_resourceDeclaration;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterResourceDeclaration(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitResourceDeclaration(this);
    }
  }

  public final ResourceDeclarationContext resourceDeclaration() throws RecognitionException {
    ResourceDeclarationContext _localctx = new ResourceDeclarationContext(_ctx, getState());
    enterRule(_localctx, 252, RULE_resourceDeclaration);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1555);
        type();
        setState(1556);
        variableDeclaratorId();
        setState(1557);
        match(ASSIGN);
        setState(1558);
        expression();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class CatchParameterContext extends ParserRuleContext {
    public ModifiersContext modifiers() {
      return getRuleContext(ModifiersContext.class, 0);
    }

    public List<TypeContext> type() {
      return getRuleContexts(TypeContext.class);
    }

    public TypeContext type(int i) {
      return getRuleContext(TypeContext.class, i);
    }

    public VariableDeclaratorIdContext variableDeclaratorId() {
      return getRuleContext(VariableDeclaratorIdContext.class, 0);
    }

    public List<TerminalNode> BIT_OR() {
      return getTokens(JavaccParser.BIT_OR);
    }

    public TerminalNode BIT_OR(int i) {
      return getToken(JavaccParser.BIT_OR, i);
    }

    public TerminalNode BIT_AND() {
      return getToken(JavaccParser.BIT_AND, 0);
    }

    public TerminalNode STAR() {
      return getToken(JavaccParser.STAR, 0);
    }

    public CatchParameterContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_catchParameter;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterCatchParameter(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitCatchParameter(this);
    }
  }

  public final CatchParameterContext catchParameter() throws RecognitionException {
    CatchParameterContext _localctx = new CatchParameterContext(_ctx, getState());
    enterRule(_localctx, 254, RULE_catchParameter);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1560);
        modifiers();
        setState(1561);
        type();
        setState(1564);
        _errHandler.sync(this);
        switch (_input.LA(1)) {
          case STAR:
          case BIT_AND:
            {
              setState(1562);
              _la = _input.LA(1);
              if (!(_la == STAR || _la == BIT_AND)) {
                _errHandler.recoverInline(this);
              } else {
                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                _errHandler.reportMatch(this);
                consume();
              }
            }
            break;
          case T__1:
            {
              setState(1563);
              match(T__1);
            }
            break;
          case LOOKAHEAD:
          case IGNORE_CASE:
          case PARSER_BEGIN:
          case PARSER_END:
          case JAVACODE:
          case TOKEN:
          case SPECIAL_TOKEN:
          case MORE_:
          case SKIP_:
          case TOKEN_MGR_DECLS:
          case EOF_:
          case DCL_PARSER_BEGIN:
          case DCL_PARSER_END:
          case INC_PARSER_BEGIN:
          case INC_PARSER_END:
          case DEF_PARSER_BEGIN:
          case DEF_PARSER_END:
          case TEMPLATE:
          case BIT_OR:
          case IDENTIFIER:
            break;
          default:
            break;
        }
        setState(1570);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == BIT_OR) {
          {
            {
              setState(1566);
              match(BIT_OR);
              setState(1567);
              type();
            }
          }
          setState(1572);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(1573);
        variableDeclaratorId();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class TryStatementContext extends ParserRuleContext {
    public TerminalNode TRY() {
      return getToken(JavaccParser.TRY, 0);
    }

    public List<BlockContext> block() {
      return getRuleContexts(BlockContext.class);
    }

    public BlockContext block(int i) {
      return getRuleContext(BlockContext.class, i);
    }

    public List<TerminalNode> LPAREN() {
      return getTokens(JavaccParser.LPAREN);
    }

    public TerminalNode LPAREN(int i) {
      return getToken(JavaccParser.LPAREN, i);
    }

    public List<ResourceDeclarationContext> resourceDeclaration() {
      return getRuleContexts(ResourceDeclarationContext.class);
    }

    public ResourceDeclarationContext resourceDeclaration(int i) {
      return getRuleContext(ResourceDeclarationContext.class, i);
    }

    public List<TerminalNode> RPAREN() {
      return getTokens(JavaccParser.RPAREN);
    }

    public TerminalNode RPAREN(int i) {
      return getToken(JavaccParser.RPAREN, i);
    }

    public List<TerminalNode> CATCH() {
      return getTokens(JavaccParser.CATCH);
    }

    public TerminalNode CATCH(int i) {
      return getToken(JavaccParser.CATCH, i);
    }

    public List<CatchParameterContext> catchParameter() {
      return getRuleContexts(CatchParameterContext.class);
    }

    public CatchParameterContext catchParameter(int i) {
      return getRuleContext(CatchParameterContext.class, i);
    }

    public TerminalNode FINALLY() {
      return getToken(JavaccParser.FINALLY, 0);
    }

    public List<TerminalNode> SEMICOLON() {
      return getTokens(JavaccParser.SEMICOLON);
    }

    public TerminalNode SEMICOLON(int i) {
      return getToken(JavaccParser.SEMICOLON, i);
    }

    public TryStatementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_tryStatement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterTryStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitTryStatement(this);
    }
  }

  public final TryStatementContext tryStatement() throws RecognitionException {
    TryStatementContext _localctx = new TryStatementContext(_ctx, getState());
    enterRule(_localctx, 256, RULE_tryStatement);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(1575);
        match(TRY);
        setState(1590);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == LPAREN) {
          {
            setState(1576);
            match(LPAREN);
            setState(1577);
            resourceDeclaration();
            setState(1582);
            _errHandler.sync(this);
            _alt = getInterpreter().adaptivePredict(_input, 186, _ctx);
            while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
              if (_alt == 1) {
                {
                  {
                    setState(1578);
                    match(SEMICOLON);
                    setState(1579);
                    resourceDeclaration();
                  }
                }
              }
              setState(1584);
              _errHandler.sync(this);
              _alt = getInterpreter().adaptivePredict(_input, 186, _ctx);
            }
            setState(1586);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == SEMICOLON) {
              {
                setState(1585);
                match(SEMICOLON);
              }
            }

            setState(1588);
            match(RPAREN);
          }
        }

        setState(1592);
        block();
        setState(1601);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == CATCH) {
          {
            {
              setState(1593);
              match(CATCH);
              setState(1594);
              match(LPAREN);
              setState(1595);
              catchParameter();
              setState(1596);
              match(RPAREN);
              setState(1597);
              block();
            }
          }
          setState(1603);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(1606);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == FINALLY) {
          {
            setState(1604);
            match(FINALLY);
            setState(1605);
            block();
          }
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class AnnotationContext extends ParserRuleContext {
    public NormalAnnotationContext normalAnnotation() {
      return getRuleContext(NormalAnnotationContext.class, 0);
    }

    public SingleMemberAnnotationContext singleMemberAnnotation() {
      return getRuleContext(SingleMemberAnnotationContext.class, 0);
    }

    public MarkerAnnotationContext markerAnnotation() {
      return getRuleContext(MarkerAnnotationContext.class, 0);
    }

    public AnnotationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_annotation;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterAnnotation(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitAnnotation(this);
    }
  }

  public final AnnotationContext annotation() throws RecognitionException {
    AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
    enterRule(_localctx, 258, RULE_annotation);
    try {
      setState(1611);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 191, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(1608);
            normalAnnotation();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(1609);
            singleMemberAnnotation();
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(1610);
            markerAnnotation();
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class NormalAnnotationContext extends ParserRuleContext {
    public NameContext name() {
      return getRuleContext(NameContext.class, 0);
    }

    public TerminalNode LPAREN() {
      return getToken(JavaccParser.LPAREN, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(JavaccParser.RPAREN, 0);
    }

    public MemberValuePairsContext memberValuePairs() {
      return getRuleContext(MemberValuePairsContext.class, 0);
    }

    public NormalAnnotationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_normalAnnotation;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterNormalAnnotation(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitNormalAnnotation(this);
    }
  }

  public final NormalAnnotationContext normalAnnotation() throws RecognitionException {
    NormalAnnotationContext _localctx = new NormalAnnotationContext(_ctx, getState());
    enterRule(_localctx, 260, RULE_normalAnnotation);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1613);
        match(T__6);
        setState(1614);
        name();
        setState(1615);
        match(LPAREN);
        setState(1617);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 67100416L) != 0)
            || _la == TEMPLATE
            || _la == IDENTIFIER) {
          {
            setState(1616);
            memberValuePairs();
          }
        }

        setState(1619);
        match(RPAREN);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class MarkerAnnotationContext extends ParserRuleContext {
    public NameContext name() {
      return getRuleContext(NameContext.class, 0);
    }

    public MarkerAnnotationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_markerAnnotation;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterMarkerAnnotation(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitMarkerAnnotation(this);
    }
  }

  public final MarkerAnnotationContext markerAnnotation() throws RecognitionException {
    MarkerAnnotationContext _localctx = new MarkerAnnotationContext(_ctx, getState());
    enterRule(_localctx, 262, RULE_markerAnnotation);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1621);
        match(T__6);
        setState(1622);
        name();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class SingleMemberAnnotationContext extends ParserRuleContext {
    public NameContext name() {
      return getRuleContext(NameContext.class, 0);
    }

    public TerminalNode LPAREN() {
      return getToken(JavaccParser.LPAREN, 0);
    }

    public MemberValueContext memberValue() {
      return getRuleContext(MemberValueContext.class, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(JavaccParser.RPAREN, 0);
    }

    public SingleMemberAnnotationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_singleMemberAnnotation;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterSingleMemberAnnotation(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitSingleMemberAnnotation(this);
    }
  }

  public final SingleMemberAnnotationContext singleMemberAnnotation() throws RecognitionException {
    SingleMemberAnnotationContext _localctx = new SingleMemberAnnotationContext(_ctx, getState());
    enterRule(_localctx, 264, RULE_singleMemberAnnotation);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1624);
        match(T__6);
        setState(1625);
        name();
        setState(1626);
        match(LPAREN);
        setState(1627);
        memberValue();
        setState(1628);
        match(RPAREN);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class MemberValuePairsContext extends ParserRuleContext {
    public List<MemberValuePairContext> memberValuePair() {
      return getRuleContexts(MemberValuePairContext.class);
    }

    public MemberValuePairContext memberValuePair(int i) {
      return getRuleContext(MemberValuePairContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(JavaccParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(JavaccParser.COMMA, i);
    }

    public MemberValuePairsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_memberValuePairs;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterMemberValuePairs(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitMemberValuePairs(this);
    }
  }

  public final MemberValuePairsContext memberValuePairs() throws RecognitionException {
    MemberValuePairsContext _localctx = new MemberValuePairsContext(_ctx, getState());
    enterRule(_localctx, 266, RULE_memberValuePairs);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1630);
        memberValuePair();
        setState(1635);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == COMMA) {
          {
            {
              setState(1631);
              match(COMMA);
              setState(1632);
              memberValuePair();
            }
          }
          setState(1637);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class MemberValuePairContext extends ParserRuleContext {
    public JavaIdentifierContext javaIdentifier() {
      return getRuleContext(JavaIdentifierContext.class, 0);
    }

    public TerminalNode ASSIGN() {
      return getToken(JavaccParser.ASSIGN, 0);
    }

    public MemberValueContext memberValue() {
      return getRuleContext(MemberValueContext.class, 0);
    }

    public MemberValuePairContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_memberValuePair;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterMemberValuePair(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitMemberValuePair(this);
    }
  }

  public final MemberValuePairContext memberValuePair() throws RecognitionException {
    MemberValuePairContext _localctx = new MemberValuePairContext(_ctx, getState());
    enterRule(_localctx, 268, RULE_memberValuePair);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1638);
        javaIdentifier();
        setState(1639);
        match(ASSIGN);
        setState(1640);
        memberValue();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class MemberValueContext extends ParserRuleContext {
    public AnnotationContext annotation() {
      return getRuleContext(AnnotationContext.class, 0);
    }

    public MemberValueArrayInitializerContext memberValueArrayInitializer() {
      return getRuleContext(MemberValueArrayInitializerContext.class, 0);
    }

    public ConditionalExpressionContext conditionalExpression() {
      return getRuleContext(ConditionalExpressionContext.class, 0);
    }

    public MemberValueContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_memberValue;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterMemberValue(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitMemberValue(this);
    }
  }

  public final MemberValueContext memberValue() throws RecognitionException {
    MemberValueContext _localctx = new MemberValueContext(_ctx, getState());
    enterRule(_localctx, 270, RULE_memberValue);
    try {
      setState(1645);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__6:
          enterOuterAlt(_localctx, 1);
          {
            setState(1642);
            annotation();
          }
          break;
        case LBRACE:
          enterOuterAlt(_localctx, 2);
          {
            setState(1643);
            memberValueArrayInitializer();
          }
          break;
        case LOOKAHEAD:
        case IGNORE_CASE:
        case PARSER_BEGIN:
        case PARSER_END:
        case JAVACODE:
        case TOKEN:
        case SPECIAL_TOKEN:
        case MORE_:
        case SKIP_:
        case TOKEN_MGR_DECLS:
        case EOF_:
        case DCL_PARSER_BEGIN:
        case DCL_PARSER_END:
        case INC_PARSER_BEGIN:
        case INC_PARSER_END:
        case DEF_PARSER_BEGIN:
        case DEF_PARSER_END:
        case BOOLEAN:
        case BYTE:
        case CHAR:
        case CONST:
        case DOUBLE:
        case FALSE:
        case FLOAT:
        case INT:
        case LONG:
        case NEW:
        case NULL:
        case SHORT:
        case SUPER:
        case THIS:
        case TRUE:
        case VOID:
        case TEMPLATE:
        case INTEGER_LITERAL:
        case FLOATING_POINT_LITERAL:
        case CHARACTER_LITERAL:
        case STRING_LITERAL:
        case LPAREN:
        case BANG:
        case TILDE:
        case DOUBLECOLON:
        case INCR:
        case DECR:
        case PLUS:
        case MINUS:
        case IDENTIFIER:
          enterOuterAlt(_localctx, 3);
          {
            setState(1644);
            conditionalExpression();
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class MemberValueArrayInitializerContext extends ParserRuleContext {
    public TerminalNode LBRACE() {
      return getToken(JavaccParser.LBRACE, 0);
    }

    public List<MemberValueContext> memberValue() {
      return getRuleContexts(MemberValueContext.class);
    }

    public MemberValueContext memberValue(int i) {
      return getRuleContext(MemberValueContext.class, i);
    }

    public TerminalNode RBRACE() {
      return getToken(JavaccParser.RBRACE, 0);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(JavaccParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(JavaccParser.COMMA, i);
    }

    public MemberValueArrayInitializerContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_memberValueArrayInitializer;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterMemberValueArrayInitializer(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitMemberValueArrayInitializer(this);
    }
  }

  public final MemberValueArrayInitializerContext memberValueArrayInitializer()
      throws RecognitionException {
    MemberValueArrayInitializerContext _localctx =
        new MemberValueArrayInitializerContext(_ctx, getState());
    enterRule(_localctx, 272, RULE_memberValueArrayInitializer);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(1647);
        match(LBRACE);
        setState(1648);
        memberValue();
        setState(1653);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 195, _ctx);
        while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            {
              {
                setState(1649);
                match(COMMA);
                setState(1650);
                memberValue();
              }
            }
          }
          setState(1655);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 195, _ctx);
        }
        setState(1657);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == COMMA) {
          {
            setState(1656);
            match(COMMA);
          }
        }

        setState(1659);
        match(RBRACE);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class AnnotationTypeDeclarationContext extends ParserRuleContext {
    public TerminalNode INTERFACE() {
      return getToken(JavaccParser.INTERFACE, 0);
    }

    public JavaIdentifierContext javaIdentifier() {
      return getRuleContext(JavaIdentifierContext.class, 0);
    }

    public AnnotationTypeBodyContext annotationTypeBody() {
      return getRuleContext(AnnotationTypeBodyContext.class, 0);
    }

    public AnnotationTypeDeclarationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_annotationTypeDeclaration;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterAnnotationTypeDeclaration(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitAnnotationTypeDeclaration(this);
    }
  }

  public final AnnotationTypeDeclarationContext annotationTypeDeclaration()
      throws RecognitionException {
    AnnotationTypeDeclarationContext _localctx =
        new AnnotationTypeDeclarationContext(_ctx, getState());
    enterRule(_localctx, 274, RULE_annotationTypeDeclaration);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1661);
        match(T__6);
        setState(1662);
        match(INTERFACE);
        setState(1663);
        javaIdentifier();
        setState(1664);
        annotationTypeBody();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class AnnotationTypeBodyContext extends ParserRuleContext {
    public TerminalNode LBRACE() {
      return getToken(JavaccParser.LBRACE, 0);
    }

    public TerminalNode RBRACE() {
      return getToken(JavaccParser.RBRACE, 0);
    }

    public List<AnnotationTypeMemberDeclarationContext> annotationTypeMemberDeclaration() {
      return getRuleContexts(AnnotationTypeMemberDeclarationContext.class);
    }

    public AnnotationTypeMemberDeclarationContext annotationTypeMemberDeclaration(int i) {
      return getRuleContext(AnnotationTypeMemberDeclarationContext.class, i);
    }

    public AnnotationTypeBodyContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_annotationTypeBody;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterAnnotationTypeBody(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitAnnotationTypeBody(this);
    }
  }

  public final AnnotationTypeBodyContext annotationTypeBody() throws RecognitionException {
    AnnotationTypeBodyContext _localctx = new AnnotationTypeBodyContext(_ctx, getState());
    enterRule(_localctx, 276, RULE_annotationTypeBody);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1666);
        match(LBRACE);
        setState(1670);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8141782231178805120L) != 0)
            || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 141012366594363L) != 0)
            || _la == IDENTIFIER) {
          {
            {
              setState(1667);
              annotationTypeMemberDeclaration();
            }
          }
          setState(1672);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(1673);
        match(RBRACE);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class AnnotationTypeMemberDeclarationContext extends ParserRuleContext {
    public ModifiersContext modifiers() {
      return getRuleContext(ModifiersContext.class, 0);
    }

    public TypeContext type() {
      return getRuleContext(TypeContext.class, 0);
    }

    public JavaIdentifierContext javaIdentifier() {
      return getRuleContext(JavaIdentifierContext.class, 0);
    }

    public TerminalNode LPAREN() {
      return getToken(JavaccParser.LPAREN, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(JavaccParser.RPAREN, 0);
    }

    public TerminalNode SEMICOLON() {
      return getToken(JavaccParser.SEMICOLON, 0);
    }

    public ClassOrInterfaceDeclarationContext classOrInterfaceDeclaration() {
      return getRuleContext(ClassOrInterfaceDeclarationContext.class, 0);
    }

    public EnumDeclarationContext enumDeclaration() {
      return getRuleContext(EnumDeclarationContext.class, 0);
    }

    public AnnotationTypeDeclarationContext annotationTypeDeclaration() {
      return getRuleContext(AnnotationTypeDeclarationContext.class, 0);
    }

    public FieldDeclarationContext fieldDeclaration() {
      return getRuleContext(FieldDeclarationContext.class, 0);
    }

    public DefaultValueContext defaultValue() {
      return getRuleContext(DefaultValueContext.class, 0);
    }

    public AnnotationTypeMemberDeclarationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_annotationTypeMemberDeclaration;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).enterAnnotationTypeMemberDeclaration(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener)
        ((JavaccListener) listener).exitAnnotationTypeMemberDeclaration(this);
    }
  }

  public final AnnotationTypeMemberDeclarationContext annotationTypeMemberDeclaration()
      throws RecognitionException {
    AnnotationTypeMemberDeclarationContext _localctx =
        new AnnotationTypeMemberDeclarationContext(_ctx, getState());
    enterRule(_localctx, 278, RULE_annotationTypeMemberDeclaration);
    int _la;
    try {
      setState(1692);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__6:
        case ABSTRACT:
        case BOOLEAN:
        case BYTE:
        case CHAR:
        case CLASS:
        case DOUBLE:
        case ENUM:
        case FINAL:
        case FLOAT:
        case INT:
        case INTERFACE:
        case LONG:
        case NATIVE:
        case PRIVATE:
        case PROTECTED:
        case PUBLIC:
        case SHORT:
        case STATIC:
        case STRICTFP:
        case SYNCHRONIZED:
        case TRANSIENT:
        case VOLATILE:
        case TEMPLATE:
        case DOUBLECOLON:
        case IDENTIFIER:
          enterOuterAlt(_localctx, 1);
          {
            setState(1675);
            modifiers();
            setState(1689);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 199, _ctx)) {
              case 1:
                {
                  setState(1676);
                  type();
                  setState(1677);
                  javaIdentifier();
                  setState(1678);
                  match(LPAREN);
                  setState(1679);
                  match(RPAREN);
                  setState(1681);
                  _errHandler.sync(this);
                  _la = _input.LA(1);
                  if (_la == DEFAULT) {
                    {
                      setState(1680);
                      defaultValue();
                    }
                  }

                  setState(1683);
                  match(SEMICOLON);
                }
                break;
              case 2:
                {
                  setState(1685);
                  classOrInterfaceDeclaration();
                }
                break;
              case 3:
                {
                  setState(1686);
                  enumDeclaration();
                }
                break;
              case 4:
                {
                  setState(1687);
                  annotationTypeDeclaration();
                }
                break;
              case 5:
                {
                  setState(1688);
                  fieldDeclaration();
                }
                break;
            }
          }
          break;
        case SEMICOLON:
          enterOuterAlt(_localctx, 2);
          {
            setState(1691);
            match(SEMICOLON);
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class DefaultValueContext extends ParserRuleContext {
    public TerminalNode DEFAULT() {
      return getToken(JavaccParser.DEFAULT, 0);
    }

    public MemberValueContext memberValue() {
      return getRuleContext(MemberValueContext.class, 0);
    }

    public DefaultValueContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_defaultValue;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).enterDefaultValue(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaccListener) ((JavaccListener) listener).exitDefaultValue(this);
    }
  }

  public final DefaultValueContext defaultValue() throws RecognitionException {
    DefaultValueContext _localctx = new DefaultValueContext(_ctx, getState());
    enterRule(_localctx, 280, RULE_defaultValue);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1694);
        match(DEFAULT);
        setState(1695);
        memberValue();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  public static final String _serializedATN =
      "\u0004\u0001\u0089\u06a2\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"
          + "\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"
          + "\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"
          + "\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"
          + "\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"
          + "\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"
          + "\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"
          + "\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"
          + "\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"
          + "\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"
          + "\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007"
          + "\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007"
          + "\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007"
          + ",\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u0007"
          + "1\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u0007"
          + "6\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007"
          + ";\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007"
          + "@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007"
          + "E\u0002F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007"
          + "J\u0002K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007"
          + "O\u0002P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007"
          + "T\u0002U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0002Y\u0007"
          + "Y\u0002Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007]\u0002^\u0007"
          + "^\u0002_\u0007_\u0002`\u0007`\u0002a\u0007a\u0002b\u0007b\u0002c\u0007"
          + "c\u0002d\u0007d\u0002e\u0007e\u0002f\u0007f\u0002g\u0007g\u0002h\u0007"
          + "h\u0002i\u0007i\u0002j\u0007j\u0002k\u0007k\u0002l\u0007l\u0002m\u0007"
          + "m\u0002n\u0007n\u0002o\u0007o\u0002p\u0007p\u0002q\u0007q\u0002r\u0007"
          + "r\u0002s\u0007s\u0002t\u0007t\u0002u\u0007u\u0002v\u0007v\u0002w\u0007"
          + "w\u0002x\u0007x\u0002y\u0007y\u0002z\u0007z\u0002{\u0007{\u0002|\u0007"
          + "|\u0002}\u0007}\u0002~\u0007~\u0002\u007f\u0007\u007f\u0002\u0080\u0007"
          + "\u0080\u0002\u0081\u0007\u0081\u0002\u0082\u0007\u0082\u0002\u0083\u0007"
          + "\u0083\u0002\u0084\u0007\u0084\u0002\u0085\u0007\u0085\u0002\u0086\u0007"
          + "\u0086\u0002\u0087\u0007\u0087\u0002\u0088\u0007\u0088\u0002\u0089\u0007"
          + "\u0089\u0002\u008a\u0007\u008a\u0002\u008b\u0007\u008b\u0002\u008c\u0007"
          + "\u008c\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"
          + "\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"
          + "\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"
          + "\u0002\u0004\u0002\u012d\b\u0002\u000b\u0002\f\u0002\u012e\u0001\u0002"
          + "\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003\u0136\b\u0003"
          + "\n\u0003\f\u0003\u0139\t\u0003\u0001\u0003\u0003\u0003\u013c\b\u0003\u0001"
          + "\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003"
          + "\u0004\u0144\b\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"
          + "\u0005\u0001\u0005\u0005\u0005\u014c\b\u0005\n\u0005\f\u0005\u014f\t\u0005"
          + "\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"
          + "\u0001\u0006\u0003\u0006\u0158\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007"
          + "\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007"
          + "\u0162\b\u0007\n\u0007\f\u0007\u0165\t\u0007\u0003\u0007\u0167\b\u0007"
          + "\u0001\u0007\u0003\u0007\u016a\b\u0007\u0001\u0007\u0001\u0007\u0001\b"
          + "\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005"
          + "\b\u0177\b\b\n\b\f\b\u017a\t\b\u0003\b\u017c\b\b\u0001\b\u0001\b\u0001"
          + "\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u0187\b\t\n"
          + "\t\f\t\u018a\t\t\u0003\t\u018c\b\t\u0001\t\u0003\t\u018f\b\t\u0001\t\u0001"
          + "\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0003\n\u0198\b\n\u0001\u000b"
          + "\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"
          + "\u0005\u000b\u01a1\b\u000b\n\u000b\f\u000b\u01a4\t\u000b\u0001\u000b\u0003"
          + "\u000b\u01a7\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"
          + "\u000b\u01ad\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"
          + "\u000b\u0005\u000b\u01b4\b\u000b\n\u000b\f\u000b\u01b7\t\u000b\u0001\u000b"
          + "\u0001\u000b\u0001\f\u0001\f\u0001\f\u0003\f\u01be\b\f\u0001\r\u0001\r"
          + "\u0001\u000e\u0001\u000e\u0003\u000e\u01c4\b\u000e\u0001\u000e\u0001\u000e"
          + "\u0003\u000e\u01c8\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f"
          + "\u01cd\b\u000f\n\u000f\f\u000f\u01d0\t\u000f\u0001\u0010\u0001\u0010\u0001"
          + "\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u01d7\b\u0010\u0001\u0010\u0001"
          + "\u0010\u0003\u0010\u01db\b\u0010\u0004\u0010\u01dd\b\u0010\u000b\u0010"
          + "\f\u0010\u01de\u0001\u0011\u0003\u0011\u01e2\b\u0011\u0001\u0011\u0003"
          + "\u0011\u01e5\b\u0011\u0001\u0011\u0003\u0011\u01e8\b\u0011\u0001\u0011"
          + "\u0003\u0011\u01eb\b\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u01ef\b"
          + "\u0011\u0001\u0011\u0003\u0011\u01f2\b\u0011\u0001\u0012\u0001\u0012\u0001"
          + "\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"
          + "\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"
          + "\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0207"
          + "\b\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u020b\b\u0012\n\u0012\f\u0012"
          + "\u020e\t\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0212\b\u0012\u0001"
          + "\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0217\b\u0012\u0001\u0012\u0001"
          + "\u0012\u0003\u0012\u021b\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"
          + "\u0012\u0001\u0012\u0003\u0012\u0222\b\u0012\u0003\u0012\u0224\b\u0012"
          + "\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u022a\b\u0012"
          + "\u0003\u0012\u022c\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013"
          + "\u0231\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0236\b"
          + "\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"
          + "\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0242"
          + "\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u0247\b\u0014"
          + "\n\u0014\f\u0014\u024a\t\u0014\u0001\u0015\u0004\u0015\u024d\b\u0015\u000b"
          + "\u0015\f\u0015\u024e\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"
          + "\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"
          + "\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003"
          + "\u0016\u0261\b\u0016\u0003\u0016\u0263\b\u0016\u0001\u0016\u0001\u0016"
          + "\u0003\u0016\u0267\b\u0016\u0003\u0016\u0269\b\u0016\u0001\u0017\u0003"
          + "\u0017\u026c\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005"
          + "\u0017\u0272\b\u0017\n\u0017\f\u0017\u0275\t\u0017\u0003\u0017\u0277\b"
          + "\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0003"
          + "\u0018\u027e\b\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001"
          + "\u001a\u0001\u001a\u0003\u001a\u0286\b\u001a\u0001\u001a\u0001\u001a\u0001"
          + "\u001a\u0003\u001a\u028b\b\u001a\u0001\u001b\u0005\u001b\u028e\b\u001b"
          + "\n\u001b\f\u001b\u0291\t\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"
          + "\u001b\u0003\u001b\u0297\b\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0003"
          + "\u001d\u029c\b\u001d\u0001\u001d\u0005\u001d\u029f\b\u001d\n\u001d\f\u001d"
          + "\u02a2\t\u001d\u0001\u001d\u0005\u001d\u02a5\b\u001d\n\u001d\f\u001d\u02a8"
          + "\t\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"
          + "\u001f\u0001\u001f\u0003\u001f\u02b1\b\u001f\u0001\u001f\u0001\u001f\u0001"
          + "\u001f\u0003\u001f\u02b6\b\u001f\u0001\u001f\u0001\u001f\u0001 \u0001"
          + " \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001"
          + " \u0003 \u02c6\b \u0005 \u02c8\b \n \f \u02cb\t \u0001!\u0001!\u0001!"
          + "\u0001!\u0001!\u0003!\u02d2\b!\u0003!\u02d4\b!\u0001\"\u0001\"\u0001\""
          + "\u0003\"\u02d9\b\"\u0001\"\u0003\"\u02dc\b\"\u0001\"\u0003\"\u02df\b\""
          + "\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001#\u0005#\u02e7\b#\n#\f#\u02ea"
          + "\t#\u0001$\u0001$\u0001$\u0001$\u0005$\u02f0\b$\n$\f$\u02f3\t$\u0001%"
          + "\u0001%\u0001%\u0003%\u02f8\b%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001"
          + "&\u0005&\u0300\b&\n&\f&\u0303\t&\u0003&\u0305\b&\u0001&\u0003&\u0308\b"
          + "&\u0001&\u0001&\u0005&\u030c\b&\n&\f&\u030f\t&\u0003&\u0311\b&\u0001&"
          + "\u0001&\u0001\'\u0001\'\u0001\'\u0003\'\u0318\b\'\u0001\'\u0003\'\u031b"
          + "\b\'\u0001(\u0001(\u0001(\u0001(\u0005(\u0321\b(\n(\f(\u0324\t(\u0001"
          + "(\u0001(\u0001)\u0001)\u0003)\u032a\b)\u0001*\u0001*\u0001*\u0001*\u0005"
          + "*\u0330\b*\n*\f*\u0333\t*\u0001+\u0001+\u0005+\u0337\b+\n+\f+\u033a\t"
          + "+\u0001+\u0001+\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0003"
          + ",\u0345\b,\u0001,\u0003,\u0348\b,\u0001-\u0001-\u0001-\u0001-\u0005-\u034e"
          + "\b-\n-\f-\u0351\t-\u0001-\u0001-\u0001.\u0001.\u0001.\u0003.\u0358\b."
          + "\u0001/\u0001/\u0001/\u0005/\u035d\b/\n/\f/\u0360\t/\u00010\u00010\u0003"
          + "0\u0364\b0\u00011\u00011\u00011\u00011\u00051\u036a\b1\n1\f1\u036d\t1"
          + "\u00031\u036f\b1\u00011\u00031\u0372\b1\u00011\u00011\u00012\u00032\u0377"
          + "\b2\u00012\u00012\u00012\u00012\u00032\u037d\b2\u00012\u00012\u00032\u0381"
          + "\b2\u00013\u00013\u00013\u00013\u00053\u0387\b3\n3\f3\u038a\t3\u00014"
          + "\u00014\u00014\u00014\u00054\u0390\b4\n4\f4\u0393\t4\u00034\u0395\b4\u0001"
          + "4\u00014\u00015\u00015\u00015\u00015\u00035\u039d\b5\u00015\u00015\u0001"
          + "6\u00036\u03a2\b6\u00016\u00016\u00016\u00016\u00036\u03a8\b6\u00016\u0001"
          + "6\u00036\u03ac\b6\u00016\u00056\u03af\b6\n6\f6\u03b2\t6\u00016\u00016"
          + "\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u00037\u03bd\b7\u0001"
          + "7\u00017\u00017\u00017\u00037\u03c3\b7\u00018\u00038\u03c6\b8\u00018\u0001"
          + "8\u00019\u00019\u00039\u03cc\b9\u0001:\u0001:\u0001:\u0004:\u03d1\b:\u000b"
          + ":\f:\u03d2\u0001:\u0003:\u03d6\b:\u0001:\u0001:\u0001:\u0001:\u0005:\u03dc"
          + "\b:\n:\f:\u03df\t:\u0003:\u03e1\b:\u0001;\u0001;\u0001;\u0001;\u0001;"
          + "\u0005;\u03e8\b;\n;\f;\u03eb\t;\u0001;\u0001;\u0001<\u0001<\u0003<\u03f1"
          + "\b<\u0001<\u0001<\u0001=\u0001=\u0001>\u0003>\u03f8\b>\u0001>\u0001>\u0003"
          + ">\u03fc\b>\u0001>\u0001>\u0001>\u0003>\u0401\b>\u0005>\u0403\b>\n>\f>"
          + "\u0406\t>\u0001?\u0001?\u0001?\u0001?\u0001?\u0003?\u040d\b?\u0005?\u040f"
          + "\b?\n?\f?\u0412\t?\u0003?\u0414\b?\u0001?\u0001?\u0001@\u0001@\u0001@"
          + "\u0003@\u041b\b@\u0003@\u041d\b@\u0001A\u0001A\u0001A\u0001A\u0003A\u0423"
          + "\bA\u0001B\u0001B\u0001C\u0001C\u0003C\u0429\bC\u0001C\u0003C\u042c\b"
          + "C\u0001C\u0001C\u0003C\u0430\bC\u0003C\u0432\bC\u0001D\u0001D\u0001D\u0005"
          + "D\u0437\bD\nD\fD\u043a\tD\u0001E\u0001E\u0001E\u0005E\u043f\bE\nE\fE\u0442"
          + "\tE\u0001F\u0001F\u0001F\u0001F\u0003F\u0448\bF\u0001G\u0001G\u0001H\u0001"
          + "H\u0001H\u0001H\u0001H\u0001H\u0003H\u0452\bH\u0001I\u0001I\u0001I\u0005"
          + "I\u0457\bI\nI\fI\u045a\tI\u0001J\u0001J\u0001J\u0005J\u045f\bJ\nJ\fJ\u0462"
          + "\tJ\u0001K\u0001K\u0001K\u0005K\u0467\bK\nK\fK\u046a\tK\u0001L\u0001L"
          + "\u0001L\u0005L\u046f\bL\nL\fL\u0472\tL\u0001M\u0001M\u0001M\u0005M\u0477"
          + "\bM\nM\fM\u047a\tM\u0001N\u0001N\u0001N\u0005N\u047f\bN\nN\fN\u0482\t"
          + "N\u0001O\u0001O\u0001O\u0003O\u0487\bO\u0001P\u0001P\u0001P\u0005P\u048c"
          + "\bP\nP\fP\u048f\tP\u0001Q\u0001Q\u0001Q\u0001Q\u0003Q\u0495\bQ\u0001Q"
          + "\u0005Q\u0498\bQ\nQ\fQ\u049b\tQ\u0001R\u0001R\u0001R\u0005R\u04a0\bR\n"
          + "R\fR\u04a3\tR\u0001S\u0001S\u0001S\u0005S\u04a8\bS\nS\fS\u04ab\tS\u0001"
          + "T\u0001T\u0001T\u0001T\u0001T\u0003T\u04b2\bT\u0001U\u0001U\u0001U\u0001"
          + "V\u0001V\u0001V\u0001W\u0001W\u0001W\u0001W\u0003W\u04be\bW\u0001X\u0001"
          + "X\u0001X\u0001X\u0001X\u0001X\u0001X\u0001X\u0001X\u0001X\u0001X\u0001"
          + "X\u0001X\u0001X\u0001X\u0001X\u0001X\u0001X\u0003X\u04d2\bX\u0003X\u04d4"
          + "\bX\u0001Y\u0001Y\u0003Y\u04d8\bY\u0001Z\u0001Z\u0001Z\u0001Z\u0001Z\u0001"
          + "Z\u0001Z\u0001Z\u0001Z\u0001Z\u0003Z\u04e4\bZ\u0001[\u0001[\u0005[\u04e8"
          + "\b[\n[\f[\u04eb\t[\u0001\\\u0001\\\u0001\\\u0001\\\u0001]\u0001]\u0001"
          + "]\u0001]\u0001]\u0001]\u0001]\u0001]\u0001]\u0001]\u0001]\u0001]\u0001"
          + "]\u0001]\u0001]\u0003]\u0500\b]\u0001^\u0001^\u0001^\u0001^\u0001^\u0001"
          + "^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001^\u0003^\u050e\b^\u0001_\u0001"
          + "_\u0001_\u0001_\u0001_\u0001_\u0003_\u0516\b_\u0001`\u0001`\u0001a\u0001"
          + "a\u0001b\u0001b\u0001c\u0001c\u0001d\u0001d\u0003d\u0522\bd\u0001d\u0001"
          + "d\u0001e\u0001e\u0001e\u0005e\u0529\be\ne\fe\u052c\te\u0001f\u0001f\u0001"
          + "f\u0001f\u0001f\u0001f\u0001f\u0003f\u0535\bf\u0001f\u0001f\u0001f\u0003"
          + "f\u053a\bf\u0003f\u053c\bf\u0003f\u053e\bf\u0001g\u0001g\u0001g\u0001"
          + "g\u0004g\u0544\bg\u000bg\fg\u0545\u0001g\u0001g\u0005g\u054a\bg\ng\fg"
          + "\u054d\tg\u0001g\u0001g\u0004g\u0551\bg\u000bg\fg\u0552\u0001g\u0003g"
          + "\u0556\bg\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001"
          + "h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0003"
          + "h\u056a\bh\u0001i\u0001i\u0001i\u0001i\u0003i\u0570\bi\u0001i\u0001i\u0001"
          + "j\u0001j\u0001j\u0001j\u0001k\u0001k\u0005k\u057a\bk\nk\fk\u057d\tk\u0001"
          + "k\u0001k\u0001l\u0001l\u0001l\u0001l\u0001l\u0003l\u0586\bl\u0001m\u0001"
          + "m\u0001m\u0001m\u0001m\u0005m\u058d\bm\nm\fm\u0590\tm\u0001n\u0001n\u0001"
          + "o\u0001o\u0001o\u0001o\u0001o\u0001o\u0001o\u0001o\u0003o\u059c\bo\u0003"
          + "o\u059e\bo\u0001p\u0001p\u0001p\u0001p\u0001p\u0001p\u0001p\u0005p\u05a7"
          + "\bp\np\fp\u05aa\tp\u0005p\u05ac\bp\np\fp\u05af\tp\u0001p\u0001p\u0001"
          + "q\u0001q\u0001q\u0001q\u0001q\u0001q\u0003q\u05b9\bq\u0001r\u0001r\u0001"
          + "r\u0001r\u0001r\u0001r\u0001r\u0003r\u05c2\br\u0001s\u0001s\u0001s\u0001"
          + "s\u0001s\u0001s\u0001t\u0001t\u0001t\u0001t\u0001t\u0001t\u0001t\u0001"
          + "t\u0001u\u0001u\u0001u\u0001u\u0001u\u0001u\u0001u\u0001u\u0001u\u0003"
          + "u\u05db\bu\u0001u\u0001u\u0003u\u05df\bu\u0001u\u0001u\u0003u\u05e3\b"
          + "u\u0003u\u05e5\bu\u0001u\u0001u\u0001u\u0001v\u0001v\u0003v\u05ec\bv\u0001"
          + "w\u0001w\u0001w\u0005w\u05f1\bw\nw\fw\u05f4\tw\u0001x\u0001x\u0001y\u0001"
          + "y\u0003y\u05fa\by\u0001y\u0001y\u0001z\u0001z\u0003z\u0600\bz\u0001z\u0001"
          + "z\u0001{\u0001{\u0003{\u0606\b{\u0001{\u0001{\u0001|\u0001|\u0001|\u0001"
          + "|\u0001}\u0001}\u0001}\u0001}\u0001}\u0001}\u0001~\u0001~\u0001~\u0001"
          + "~\u0001~\u0001\u007f\u0001\u007f\u0001\u007f\u0001\u007f\u0003\u007f\u061d"
          + "\b\u007f\u0001\u007f\u0001\u007f\u0005\u007f\u0621\b\u007f\n\u007f\f\u007f"
          + "\u0624\t\u007f\u0001\u007f\u0001\u007f\u0001\u0080\u0001\u0080\u0001\u0080"
          + "\u0001\u0080\u0001\u0080\u0005\u0080\u062d\b\u0080\n\u0080\f\u0080\u0630"
          + "\t\u0080\u0001\u0080\u0003\u0080\u0633\b\u0080\u0001\u0080\u0001\u0080"
          + "\u0003\u0080\u0637\b\u0080\u0001\u0080\u0001\u0080\u0001\u0080\u0001\u0080"
          + "\u0001\u0080\u0001\u0080\u0001\u0080\u0005\u0080\u0640\b\u0080\n\u0080"
          + "\f\u0080\u0643\t\u0080\u0001\u0080\u0001\u0080\u0003\u0080\u0647\b\u0080"
          + "\u0001\u0081\u0001\u0081\u0001\u0081\u0003\u0081\u064c\b\u0081\u0001\u0082"
          + "\u0001\u0082\u0001\u0082\u0001\u0082\u0003\u0082\u0652\b\u0082\u0001\u0082"
          + "\u0001\u0082\u0001\u0083\u0001\u0083\u0001\u0083\u0001\u0084\u0001\u0084"
          + "\u0001\u0084\u0001\u0084\u0001\u0084\u0001\u0084\u0001\u0085\u0001\u0085"
          + "\u0001\u0085\u0005\u0085\u0662\b\u0085\n\u0085\f\u0085\u0665\t\u0085\u0001"
          + "\u0086\u0001\u0086\u0001\u0086\u0001\u0086\u0001\u0087\u0001\u0087\u0001"
          + "\u0087\u0003\u0087\u066e\b\u0087\u0001\u0088\u0001\u0088\u0001\u0088\u0001"
          + "\u0088\u0005\u0088\u0674\b\u0088\n\u0088\f\u0088\u0677\t\u0088\u0001\u0088"
          + "\u0003\u0088\u067a\b\u0088\u0001\u0088\u0001\u0088\u0001\u0089\u0001\u0089"
          + "\u0001\u0089\u0001\u0089\u0001\u0089\u0001\u008a\u0001\u008a\u0005\u008a"
          + "\u0685\b\u008a\n\u008a\f\u008a\u0688\t\u008a\u0001\u008a\u0001\u008a\u0001"
          + "\u008b\u0001\u008b\u0001\u008b\u0001\u008b\u0001\u008b\u0001\u008b\u0003"
          + "\u008b\u0692\b\u008b\u0001\u008b\u0001\u008b\u0001\u008b\u0001\u008b\u0001"
          + "\u008b\u0001\u008b\u0003\u008b\u069a\b\u008b\u0001\u008b\u0003\u008b\u069d"
          + "\b\u008b\u0001\u008c\u0001\u008c\u0001\u008c\u0001\u008c\u0000\u0000\u008d"
          + "\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"
          + "\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082"
          + "\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a"
          + "\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2"
          + "\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca"
          + "\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc\u00de\u00e0\u00e2"
          + "\u00e4\u00e6\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2\u00f4\u00f6\u00f8\u00fa"
          + "\u00fc\u00fe\u0100\u0102\u0104\u0106\u0108\u010a\u010c\u010e\u0110\u0112"
          + "\u0114\u0116\u0118\u0000\u0014\u0003\u0000\b\nDD\u0089\u0089\u0001\u0000"
          + "?A\u0001\u0000\u000e\u0011\u0003\u0000mmxxzz\u0002\u0000OO\u0089\u0089"
          + "\u0001\u0000``\u0004\u0000\b\f\u000e\u0019RR\u0089\u0089\u0002\u0000%"
          + "%99\u0002\u0000zz||\u0002\u0000%%SS\u0002\u0000hhoo\b\u0000\u001f\u001f"
          + "!!$$**1188::CC\u0003\u0000\u0003\u0005ii\u0080\u0087\u0002\u0000ppss\u0003"
          + "\u0000jjqr\u0088\u0088\u0001\u0000xy\u0002\u0000z{\u007f\u007f\u0001\u0000"
          + "kl\u0001\u0000vw\u0002\u0000..MM\u072e\u0000\u011a\u0001\u0000\u0000\u0000"
          + "\u0002\u011e\u0001\u0000\u0000\u0000\u0004\u0121\u0001\u0000\u0000\u0000"
          + "\u0006\u013b\u0001\u0000\u0000\u0000\b\u013d\u0001\u0000\u0000\u0000\n"
          + "\u0147\u0001\u0000\u0000\u0000\f\u0157\u0001\u0000\u0000\u0000\u000e\u0159"
          + "\u0001\u0000\u0000\u0000\u0010\u016d\u0001\u0000\u0000\u0000\u0012\u017f"
          + "\u0001\u0000\u0000\u0000\u0014\u0197\u0001\u0000\u0000\u0000\u0016\u01a6"
          + "\u0001\u0000\u0000\u0000\u0018\u01ba\u0001\u0000\u0000\u0000\u001a\u01bf"
          + "\u0001\u0000\u0000\u0000\u001c\u01c1\u0001\u0000\u0000\u0000\u001e\u01c9"
          + "\u0001\u0000\u0000\u0000 \u01d6\u0001\u0000\u0000\u0000\"\u01e1\u0001"
          + "\u0000\u0000\u0000$\u022b\u0001\u0000\u0000\u0000&\u0241\u0001\u0000\u0000"
          + "\u0000(\u0243\u0001\u0000\u0000\u0000*\u024c\u0001\u0000\u0000\u0000,"
          + "\u0268\u0001\u0000\u0000\u0000.\u026b\u0001\u0000\u0000\u00000\u027a\u0001"
          + "\u0000\u0000\u00002\u027f\u0001\u0000\u0000\u00004\u0281\u0001\u0000\u0000"
          + "\u00006\u0296\u0001\u0000\u0000\u00008\u0298\u0001\u0000\u0000\u0000:"
          + "\u029b\u0001\u0000\u0000\u0000<\u02a9\u0001\u0000\u0000\u0000>\u02ae\u0001"
          + "\u0000\u0000\u0000@\u02c9\u0001\u0000\u0000\u0000B\u02d3\u0001\u0000\u0000"
          + "\u0000D\u02d5\u0001\u0000\u0000\u0000F\u02e2\u0001\u0000\u0000\u0000H"
          + "\u02eb\u0001\u0000\u0000\u0000J\u02f4\u0001\u0000\u0000\u0000L\u02fb\u0001"
          + "\u0000\u0000\u0000N\u0314\u0001\u0000\u0000\u0000P\u031c\u0001\u0000\u0000"
          + "\u0000R\u0327\u0001\u0000\u0000\u0000T\u032b\u0001\u0000\u0000\u0000V"
          + "\u0334\u0001\u0000\u0000\u0000X\u0347\u0001\u0000\u0000\u0000Z\u0349\u0001"
          + "\u0000\u0000\u0000\\\u0354\u0001\u0000\u0000\u0000^\u0359\u0001\u0000"
          + "\u0000\u0000`\u0363\u0001\u0000\u0000\u0000b\u0365\u0001\u0000\u0000\u0000"
          + "d\u0376\u0001\u0000\u0000\u0000f\u0382\u0001\u0000\u0000\u0000h\u038b"
          + "\u0001\u0000\u0000\u0000j\u0398\u0001\u0000\u0000\u0000l\u03a1\u0001\u0000"
          + "\u0000\u0000n\u03c2\u0001\u0000\u0000\u0000p\u03c5\u0001\u0000\u0000\u0000"
          + "r\u03cb\u0001\u0000\u0000\u0000t\u03e0\u0001\u0000\u0000\u0000v\u03e2"
          + "\u0001\u0000\u0000\u0000x\u03ee\u0001\u0000\u0000\u0000z\u03f4\u0001\u0000"
          + "\u0000\u0000|\u03f7\u0001\u0000\u0000\u0000~\u0407\u0001\u0000\u0000\u0000"
          + "\u0080\u041c\u0001\u0000\u0000\u0000\u0082\u0422\u0001\u0000\u0000\u0000"
          + "\u0084\u0424\u0001\u0000\u0000\u0000\u0086\u0431\u0001\u0000\u0000\u0000"
          + "\u0088\u0433\u0001\u0000\u0000\u0000\u008a\u043b\u0001\u0000\u0000\u0000"
          + "\u008c\u0443\u0001\u0000\u0000\u0000\u008e\u0449\u0001\u0000\u0000\u0000"
          + "\u0090\u044b\u0001\u0000\u0000\u0000\u0092\u0453\u0001\u0000\u0000\u0000"
          + "\u0094\u045b\u0001\u0000\u0000\u0000\u0096\u0463\u0001\u0000\u0000\u0000"
          + "\u0098\u046b\u0001\u0000\u0000\u0000\u009a\u0473\u0001\u0000\u0000\u0000"
          + "\u009c\u047b\u0001\u0000\u0000\u0000\u009e\u0483\u0001\u0000\u0000\u0000"
          + "\u00a0\u0488\u0001\u0000\u0000\u0000\u00a2\u0490\u0001\u0000\u0000\u0000"
          + "\u00a4\u049c\u0001\u0000\u0000\u0000\u00a6\u04a4\u0001\u0000\u0000\u0000"
          + "\u00a8\u04b1\u0001\u0000\u0000\u0000\u00aa\u04b3\u0001\u0000\u0000\u0000"
          + "\u00ac\u04b6\u0001\u0000\u0000\u0000\u00ae\u04bd\u0001\u0000\u0000\u0000"
          + "\u00b0\u04d3\u0001\u0000\u0000\u0000\u00b2\u04d5\u0001\u0000\u0000\u0000"
          + "\u00b4\u04e3\u0001\u0000\u0000\u0000\u00b6\u04e5\u0001\u0000\u0000\u0000"
          + "\u00b8\u04ec\u0001\u0000\u0000\u0000\u00ba\u04ff\u0001\u0000\u0000\u0000"
          + "\u00bc\u050d\u0001\u0000\u0000\u0000\u00be\u0515\u0001\u0000\u0000\u0000"
          + "\u00c0\u0517\u0001\u0000\u0000\u0000\u00c2\u0519\u0001\u0000\u0000\u0000"
          + "\u00c4\u051b\u0001\u0000\u0000\u0000\u00c6\u051d\u0001\u0000\u0000\u0000"
          + "\u00c8\u051f\u0001\u0000\u0000\u0000\u00ca\u0525\u0001\u0000\u0000\u0000"
          + "\u00cc\u053d\u0001\u0000\u0000\u0000\u00ce\u0555\u0001\u0000\u0000\u0000"
          + "\u00d0\u0569\u0001\u0000\u0000\u0000\u00d2\u056b\u0001\u0000\u0000\u0000"
          + "\u00d4\u0573\u0001\u0000\u0000\u0000\u00d6\u0577\u0001\u0000\u0000\u0000"
          + "\u00d8\u0585\u0001\u0000\u0000\u0000\u00da\u0587\u0001\u0000\u0000\u0000"
          + "\u00dc\u0591\u0001\u0000\u0000\u0000\u00de\u059d\u0001\u0000\u0000\u0000"
          + "\u00e0\u059f\u0001\u0000\u0000\u0000\u00e2\u05b8\u0001\u0000\u0000\u0000"
          + "\u00e4\u05ba\u0001\u0000\u0000\u0000\u00e6\u05c3\u0001\u0000\u0000\u0000"
          + "\u00e8\u05c9\u0001\u0000\u0000\u0000\u00ea\u05d1\u0001\u0000\u0000\u0000"
          + "\u00ec\u05eb\u0001\u0000\u0000\u0000\u00ee\u05ed\u0001\u0000\u0000\u0000"
          + "\u00f0\u05f5\u0001\u0000\u0000\u0000\u00f2\u05f7\u0001\u0000\u0000\u0000"
          + "\u00f4\u05fd\u0001\u0000\u0000\u0000\u00f6\u0603\u0001\u0000\u0000\u0000"
          + "\u00f8\u0609\u0001\u0000\u0000\u0000\u00fa\u060d\u0001\u0000\u0000\u0000"
          + "\u00fc\u0613\u0001\u0000\u0000\u0000\u00fe\u0618\u0001\u0000\u0000\u0000"
          + "\u0100\u0627\u0001\u0000\u0000\u0000\u0102\u064b\u0001\u0000\u0000\u0000"
          + "\u0104\u064d\u0001\u0000\u0000\u0000\u0106\u0655\u0001\u0000\u0000\u0000"
          + "\u0108\u0658\u0001\u0000\u0000\u0000\u010a\u065e\u0001\u0000\u0000\u0000"
          + "\u010c\u0666\u0001\u0000\u0000\u0000\u010e\u066d\u0001\u0000\u0000\u0000"
          + "\u0110\u066f\u0001\u0000\u0000\u0000\u0112\u067d\u0001\u0000\u0000\u0000"
          + "\u0114\u0682\u0001\u0000\u0000\u0000\u0116\u069c\u0001\u0000\u0000\u0000"
          + "\u0118\u069e\u0001\u0000\u0000\u0000\u011a\u011b\u0005\u0088\u0000\u0000"
          + "\u011b\u011c\u0005\u0088\u0000\u0000\u011c\u011d\u0005\u0088\u0000\u0000"
          + "\u011d\u0001\u0001\u0000\u0000\u0000\u011e\u011f\u0005\u0088\u0000\u0000"
          + "\u011f\u0120\u0005\u0088\u0000\u0000\u0120\u0003\u0001\u0000\u0000\u0000"
          + "\u0121\u0122\u0003\u0006\u0003\u0000\u0122\u0123\u0005\n\u0000\u0000\u0123"
          + "\u0124\u0005`\u0000\u0000\u0124\u0125\u00032\u0019\u0000\u0125\u0126\u0005"
          + "a\u0000\u0000\u0126\u0127\u0003:\u001d\u0000\u0127\u0128\u0005\u000b\u0000"
          + "\u0000\u0128\u0129\u0005`\u0000\u0000\u0129\u012a\u00032\u0019\u0000\u012a"
          + "\u012c\u0005a\u0000\u0000\u012b\u012d\u0003\f\u0006\u0000\u012c\u012b"
          + "\u0001\u0000\u0000\u0000\u012d\u012e\u0001\u0000\u0000\u0000\u012e\u012c"
          + "\u0001\u0000\u0000\u0000\u012e\u012f\u0001\u0000\u0000\u0000\u012f\u0130"
          + "\u0001\u0000\u0000\u0000\u0130\u0131\u0005\u0000\u0000\u0001\u0131\u0005"
          + "\u0001\u0000\u0000\u0000\u0132\u0133\u0005\u0089\u0000\u0000\u0133\u0137"
          + "\u0005b\u0000\u0000\u0134\u0136\u0003\b\u0004\u0000\u0135\u0134\u0001"
          + "\u0000\u0000\u0000\u0136\u0139\u0001\u0000\u0000\u0000\u0137\u0135\u0001"
          + "\u0000\u0000\u0000\u0137\u0138\u0001\u0000\u0000\u0000\u0138\u013a\u0001"
          + "\u0000\u0000\u0000\u0139\u0137\u0001\u0000\u0000\u0000\u013a\u013c\u0005"
          + "c\u0000\u0000\u013b\u0132\u0001\u0000\u0000\u0000\u013b\u013c\u0001\u0000"
          + "\u0000\u0000\u013c\u0007\u0001\u0000\u0000\u0000\u013d\u013e\u0007\u0000"
          + "\u0000\u0000\u013e\u0143\u0005i\u0000\u0000\u013f\u0144\u0003\u00c0`\u0000"
          + "\u0140\u0144\u0003\u00c2a\u0000\u0141\u0144\u0003\u00c4b\u0000\u0142\u0144"
          + "\u0003\n\u0005\u0000\u0143\u013f\u0001\u0000\u0000\u0000\u0143\u0140\u0001"
          + "\u0000\u0000\u0000\u0143\u0141\u0001\u0000\u0000\u0000\u0143\u0142\u0001"
          + "\u0000\u0000\u0000\u0144\u0145\u0001\u0000\u0000\u0000\u0145\u0146\u0005"
          + "f\u0000\u0000\u0146\t\u0001\u0000\u0000\u0000\u0147\u0148\u0005`\u0000"
          + "\u0000\u0148\u014d\u0003\u00c4b\u0000\u0149\u014a\u0005g\u0000\u0000\u014a"
          + "\u014c\u0003\u00c4b\u0000\u014b\u0149\u0001\u0000\u0000\u0000\u014c\u014f"
          + "\u0001\u0000\u0000\u0000\u014d\u014b\u0001\u0000\u0000\u0000\u014d\u014e"
          + "\u0001\u0000\u0000\u0000\u014e\u0150\u0001\u0000\u0000\u0000\u014f\u014d"
          + "\u0001\u0000\u0000\u0000\u0150\u0151\u0005a\u0000\u0000\u0151\u000b\u0001"
          + "\u0000\u0000\u0000\u0152\u0158\u0003\u000e\u0007\u0000\u0153\u0158\u0003"
          + "\u0010\b\u0000\u0154\u0158\u0003\u0016\u000b\u0000\u0155\u0158\u0003\u0018"
          + "\f\u0000\u0156\u0158\u0003\u0012\t\u0000\u0157\u0152\u0001\u0000\u0000"
          + "\u0000\u0157\u0153\u0001\u0000\u0000\u0000\u0157\u0154\u0001\u0000\u0000"
          + "\u0000\u0157\u0155\u0001\u0000\u0000\u0000\u0157\u0156\u0001\u0000\u0000"
          + "\u0000\u0158\r\u0001\u0000\u0000\u0000\u0159\u015a\u0005\f\u0000\u0000"
          + "\u015a\u015b\u0003\u0086C\u0000\u015b\u015c\u00032\u0019\u0000\u015c\u0166"
          + "\u0003h4\u0000\u015d\u015e\u0005K\u0000\u0000\u015e\u0163\u0003\u0088"
          + "D\u0000\u015f\u0160\u0005g\u0000\u0000\u0160\u0162\u0003\u0088D\u0000"
          + "\u0161\u015f\u0001\u0000\u0000\u0000\u0162\u0165\u0001\u0000\u0000\u0000"
          + "\u0163\u0161\u0001\u0000\u0000\u0000\u0163\u0164\u0001\u0000\u0000\u0000"
          + "\u0164\u0167\u0001\u0000\u0000\u0000\u0165\u0163\u0001\u0000\u0000\u0000"
          + "\u0166\u015d\u0001\u0000\u0000\u0000\u0166\u0167\u0001\u0000\u0000\u0000"
          + "\u0167\u0169\u0001\u0000\u0000\u0000\u0168\u016a\u00034\u001a\u0000\u0169"
          + "\u0168\u0001\u0000\u0000\u0000\u0169\u016a\u0001\u0000\u0000\u0000\u016a"
          + "\u016b\u0001\u0000\u0000\u0000\u016b\u016c\u0003\u00d6k\u0000\u016c\u000f"
          + "\u0001\u0000\u0000\u0000\u016d\u016e\u0005\r\u0000\u0000\u016e\u016f\u0003"
          + "\u0014\n\u0000\u016f\u0170\u0003\u0086C\u0000\u0170\u0171\u00032\u0019"
          + "\u0000\u0171\u017b\u0003h4\u0000\u0172\u0173\u0005K\u0000\u0000\u0173"
          + "\u0178\u0003\u0088D\u0000\u0174\u0175\u0005g\u0000\u0000\u0175\u0177\u0003"
          + "\u0088D\u0000\u0176\u0174\u0001\u0000\u0000\u0000\u0177\u017a\u0001\u0000"
          + "\u0000\u0000\u0178\u0176\u0001\u0000\u0000\u0000\u0178\u0179\u0001\u0000"
          + "\u0000\u0000\u0179\u017c\u0001\u0000\u0000\u0000\u017a\u0178\u0001\u0000"
          + "\u0000\u0000\u017b\u0172\u0001\u0000\u0000\u0000\u017b\u017c\u0001\u0000"
          + "\u0000\u0000\u017c\u017d\u0001\u0000\u0000\u0000\u017d\u017e\u0003\u00d6"
          + "k\u0000\u017e\u0011\u0001\u0000\u0000\u0000\u017f\u0180\u0003\u0086C\u0000"
          + "\u0180\u0181\u00032\u0019\u0000\u0181\u018b\u0003h4\u0000\u0182\u0183"
          + "\u0005K\u0000\u0000\u0183\u0188\u0003\u0088D\u0000\u0184\u0185\u0005g"
          + "\u0000\u0000\u0185\u0187\u0003\u0088D\u0000\u0186\u0184\u0001\u0000\u0000"
          + "\u0000\u0187\u018a\u0001\u0000\u0000\u0000\u0188\u0186\u0001\u0000\u0000"
          + "\u0000\u0188\u0189\u0001\u0000\u0000\u0000\u0189\u018c\u0001\u0000\u0000"
          + "\u0000\u018a\u0188\u0001\u0000\u0000\u0000\u018b\u0182\u0001\u0000\u0000"
          + "\u0000\u018b\u018c\u0001\u0000\u0000\u0000\u018c\u018e\u0001\u0000\u0000"
          + "\u0000\u018d\u018f\u00034\u001a\u0000\u018e\u018d\u0001\u0000\u0000\u0000"
          + "\u018e\u018f\u0001\u0000\u0000\u0000\u018f\u0190\u0001\u0000\u0000\u0000"
          + "\u0190\u0191\u0005n\u0000\u0000\u0191\u0192\u0003\u00d6k\u0000\u0192\u0193"
          + "\u0005b\u0000\u0000\u0193\u0194\u0003\u001e\u000f\u0000\u0194\u0195\u0005"
          + "c\u0000\u0000\u0195\u0013\u0001\u0000\u0000\u0000\u0196\u0198\u0007\u0001"
          + "\u0000\u0000\u0197\u0196\u0001\u0000\u0000\u0000\u0197\u0198\u0001\u0000"
          + "\u0000\u0000\u0198\u0015\u0001\u0000\u0000\u0000\u0199\u019a\u0005j\u0000"
          + "\u0000\u019a\u019b\u0005z\u0000\u0000\u019b\u01a7\u0005\u0088\u0000\u0000"
          + "\u019c\u019d\u0005j\u0000\u0000\u019d\u01a2\u0005\u0089\u0000\u0000\u019e"
          + "\u019f\u0005g\u0000\u0000\u019f\u01a1\u0005\u0089\u0000\u0000\u01a0\u019e"
          + "\u0001\u0000\u0000\u0000\u01a1\u01a4\u0001\u0000\u0000\u0000\u01a2\u01a0"
          + "\u0001\u0000\u0000\u0000\u01a2\u01a3\u0001\u0000\u0000\u0000\u01a3\u01a5"
          + "\u0001\u0000\u0000\u0000\u01a4\u01a2\u0001\u0000\u0000\u0000\u01a5\u01a7"
          + "\u0005\u0088\u0000\u0000\u01a6\u0199\u0001\u0000\u0000\u0000\u01a6\u019c"
          + "\u0001\u0000\u0000\u0000\u01a6\u01a7\u0001\u0000\u0000\u0000\u01a7\u01a8"
          + "\u0001\u0000\u0000\u0000\u01a8\u01ac\u0003\u001a\r\u0000\u01a9\u01aa\u0005"
          + "d\u0000\u0000\u01aa\u01ab\u0005\t\u0000\u0000\u01ab\u01ad\u0005e\u0000"
          + "\u0000\u01ac\u01a9\u0001\u0000\u0000\u0000\u01ac\u01ad\u0001\u0000\u0000"
          + "\u0000\u01ad\u01ae\u0001\u0000\u0000\u0000\u01ae\u01af\u0005n\u0000\u0000"
          + "\u01af\u01b0\u0005b\u0000\u0000\u01b0\u01b5\u0003\u001c\u000e\u0000\u01b1"
          + "\u01b2\u0005}\u0000\u0000\u01b2\u01b4\u0003\u001c\u000e\u0000\u01b3\u01b1"
          + "\u0001\u0000\u0000\u0000\u01b4\u01b7\u0001\u0000\u0000\u0000\u01b5\u01b3"
          + "\u0001\u0000\u0000\u0000\u01b5\u01b6\u0001\u0000\u0000\u0000\u01b6\u01b8"
          + "\u0001\u0000\u0000\u0000\u01b7\u01b5\u0001\u0000\u0000\u0000\u01b8\u01b9"
          + "\u0005c\u0000\u0000\u01b9\u0017\u0001\u0000\u0000\u0000\u01ba\u01bb\u0005"
          + "\u0012\u0000\u0000\u01bb\u01bd\u0005n\u0000\u0000\u01bc\u01be\u0003V+"
          + "\u0000\u01bd\u01bc\u0001\u0000\u0000\u0000\u01bd\u01be\u0001\u0000\u0000"
          + "\u0000\u01be\u0019\u0001\u0000\u0000\u0000\u01bf\u01c0\u0007\u0002\u0000"
          + "\u0000\u01c0\u001b\u0001\u0000\u0000\u0000\u01c1\u01c3\u0003&\u0013\u0000"
          + "\u01c2\u01c4\u0003\u00d6k\u0000\u01c3\u01c2\u0001\u0000\u0000\u0000\u01c3"
          + "\u01c4\u0001\u0000\u0000\u0000\u01c4\u01c7\u0001\u0000\u0000\u0000\u01c5"
          + "\u01c6\u0005n\u0000\u0000\u01c6\u01c8\u0005\u0089\u0000\u0000\u01c7\u01c5"
          + "\u0001\u0000\u0000\u0000\u01c7\u01c8\u0001\u0000\u0000\u0000\u01c8\u001d"
          + "\u0001\u0000\u0000\u0000\u01c9\u01ce\u0003 \u0010\u0000\u01ca\u01cb\u0005"
          + "}\u0000\u0000\u01cb\u01cd\u0003 \u0010\u0000\u01cc\u01ca\u0001\u0000\u0000"
          + "\u0000\u01cd\u01d0\u0001\u0000\u0000\u0000\u01ce\u01cc\u0001\u0000\u0000"
          + "\u0000\u01ce\u01cf\u0001\u0000\u0000\u0000\u01cf\u001f\u0001\u0000\u0000"
          + "\u0000\u01d0\u01ce\u0001\u0000\u0000\u0000\u01d1\u01d2\u0005\b\u0000\u0000"
          + "\u01d2\u01d3\u0005`\u0000\u0000\u01d3\u01d4\u0003\"\u0011\u0000\u01d4"
          + "\u01d5\u0005a\u0000\u0000\u01d5\u01d7\u0001\u0000\u0000\u0000\u01d6\u01d1"
          + "\u0001\u0000\u0000\u0000\u01d6\u01d7\u0001\u0000\u0000\u0000\u01d7\u01dc"
          + "\u0001\u0000\u0000\u0000\u01d8\u01da\u0003$\u0012\u0000\u01d9\u01db\u0003"
          + "4\u001a\u0000\u01da\u01d9\u0001\u0000\u0000\u0000\u01da\u01db\u0001\u0000"
          + "\u0000\u0000\u01db\u01dd\u0001\u0000\u0000\u0000\u01dc\u01d8\u0001\u0000"
          + "\u0000\u0000\u01dd\u01de\u0001\u0000\u0000\u0000\u01de\u01dc\u0001\u0000"
          + "\u0000\u0000\u01de\u01df\u0001\u0000\u0000\u0000\u01df!\u0001\u0000\u0000"
          + "\u0000\u01e0\u01e2\u0003\u00c0`\u0000\u01e1\u01e0\u0001\u0000\u0000\u0000"
          + "\u01e1\u01e2\u0001\u0000\u0000\u0000\u01e2\u01e4\u0001\u0000\u0000\u0000"
          + "\u01e3\u01e5\u0005g\u0000\u0000\u01e4\u01e3\u0001\u0000\u0000\u0000\u01e4"
          + "\u01e5\u0001\u0000\u0000\u0000\u01e5\u01e7\u0001\u0000\u0000\u0000\u01e6"
          + "\u01e8\u0003\u001e\u000f\u0000\u01e7\u01e6\u0001\u0000\u0000\u0000\u01e7"
          + "\u01e8\u0001\u0000\u0000\u0000\u01e8\u01ea\u0001\u0000\u0000\u0000\u01e9"
          + "\u01eb\u0005g\u0000\u0000\u01ea\u01e9\u0001\u0000\u0000\u0000\u01ea\u01eb"
          + "\u0001\u0000\u0000\u0000\u01eb\u01f1\u0001\u0000\u0000\u0000\u01ec\u01ee"
          + "\u0005b\u0000\u0000\u01ed\u01ef\u0003\u008cF\u0000\u01ee\u01ed\u0001\u0000"
          + "\u0000\u0000\u01ee\u01ef\u0001\u0000\u0000\u0000\u01ef\u01f0\u0001\u0000"
          + "\u0000\u0000\u01f0\u01f2\u0005c\u0000\u0000\u01f1\u01ec\u0001\u0000\u0000"
          + "\u0000\u01f1\u01f2\u0001\u0000\u0000\u0000\u01f2#\u0001\u0000\u0000\u0000"
          + "\u01f3\u01f4\u0005\b\u0000\u0000\u01f4\u01f5\u0005`\u0000\u0000\u01f5"
          + "\u01f6\u0003\"\u0011\u0000\u01f6\u01f7\u0005a\u0000\u0000\u01f7\u022c"
          + "\u0001\u0000\u0000\u0000\u01f8\u022c\u0003\u00d6k\u0000\u01f9\u01fa\u0005"
          + "d\u0000\u0000\u01fa\u01fb\u0003\u001e\u000f\u0000\u01fb\u01fc\u0005e\u0000"
          + "\u0000\u01fc\u022c\u0001\u0000\u0000\u0000\u01fd\u01fe\u0005N\u0000\u0000"
          + "\u01fe\u01ff\u0005b\u0000\u0000\u01ff\u0200\u0003\u001e\u000f\u0000\u0200"
          + "\u020c\u0005c\u0000\u0000\u0201\u0202\u0005#\u0000\u0000\u0202\u0206\u0005"
          + "`\u0000\u0000\u0203\u0204\u0003\u0088D\u0000\u0204\u0205\u0005\u0089\u0000"
          + "\u0000\u0205\u0207\u0001\u0000\u0000\u0000\u0206\u0203\u0001\u0000\u0000"
          + "\u0000\u0206\u0207\u0001\u0000\u0000\u0000\u0207\u0208\u0001\u0000\u0000"
          + "\u0000\u0208\u0209\u0005a\u0000\u0000\u0209\u020b\u0003\u00d6k\u0000\u020a"
          + "\u0201\u0001\u0000\u0000\u0000\u020b\u020e\u0001\u0000\u0000\u0000\u020c"
          + "\u020a\u0001\u0000\u0000\u0000\u020c\u020d\u0001\u0000\u0000\u0000\u020d"
          + "\u0211\u0001\u0000\u0000\u0000\u020e\u020c\u0001\u0000\u0000\u0000\u020f"
          + "\u0210\u00050\u0000\u0000\u0210\u0212\u0003\u00d6k\u0000\u0211\u020f\u0001"
          + "\u0000\u0000\u0000\u0211\u0212\u0001\u0000\u0000\u0000\u0212\u022c\u0001"
          + "\u0000\u0000\u0000\u0213\u0214\u0003\u00b6[\u0000\u0214\u0215\u0005i\u0000"
          + "\u0000\u0215\u0217\u0001\u0000\u0000\u0000\u0216\u0213\u0001\u0000\u0000"
          + "\u0000\u0216\u0217\u0001\u0000\u0000\u0000\u0217\u0223\u0001\u0000\u0000"
          + "\u0000\u0218\u021a\u00032\u0019\u0000\u0219\u021b\u0003~?\u0000\u021a"
          + "\u0219\u0001\u0000\u0000\u0000\u021a\u021b\u0001\u0000\u0000\u0000\u021b"
          + "\u021c\u0001\u0000\u0000\u0000\u021c\u021d\u0003\u00c8d\u0000\u021d\u0224"
          + "\u0001\u0000\u0000\u0000\u021e\u0221\u0003&\u0013\u0000\u021f\u0220\u0005"
          + "h\u0000\u0000\u0220\u0222\u0005\u0089\u0000\u0000\u0221\u021f\u0001\u0000"
          + "\u0000\u0000\u0221\u0222\u0001\u0000\u0000\u0000\u0222\u0224\u0001\u0000"
          + "\u0000\u0000\u0223\u0218\u0001\u0000\u0000\u0000\u0223\u021e\u0001\u0000"
          + "\u0000\u0000\u0224\u022c\u0001\u0000\u0000\u0000\u0225\u0226\u0005`\u0000"
          + "\u0000\u0226\u0227\u0003\u001e\u000f\u0000\u0227\u0229\u0005a\u0000\u0000"
          + "\u0228\u022a\u0007\u0003\u0000\u0000\u0229\u0228\u0001\u0000\u0000\u0000"
          + "\u0229\u022a\u0001\u0000\u0000\u0000\u022a\u022c\u0001\u0000\u0000\u0000"
          + "\u022b\u01f3\u0001\u0000\u0000\u0000\u022b\u01f8\u0001\u0000\u0000\u0000"
          + "\u022b\u01f9\u0001\u0000\u0000\u0000\u022b\u01fd\u0001\u0000\u0000\u0000"
          + "\u022b\u0216\u0001\u0000\u0000\u0000\u022b\u0225\u0001\u0000\u0000\u0000"
          + "\u022c%\u0001\u0000\u0000\u0000\u022d\u0242\u0003\u00c4b\u0000\u022e\u0235"
          + "\u0005j\u0000\u0000\u022f\u0231\u0005\u0001\u0000\u0000\u0230\u022f\u0001"
          + "\u0000\u0000\u0000\u0230\u0231\u0001\u0000\u0000\u0000\u0231\u0232\u0001"
          + "\u0000\u0000\u0000\u0232\u0233\u00032\u0019\u0000\u0233\u0234\u0005n\u0000"
          + "\u0000\u0234\u0236\u0001\u0000\u0000\u0000\u0235\u0230\u0001\u0000\u0000"
          + "\u0000\u0235\u0236\u0001\u0000\u0000\u0000\u0236\u0237\u0001\u0000\u0000"
          + "\u0000\u0237\u0238\u0003(\u0014\u0000\u0238\u0239\u0005\u0088\u0000\u0000"
          + "\u0239\u0242\u0001\u0000\u0000\u0000\u023a\u023b\u0005j\u0000\u0000\u023b"
          + "\u023c\u00032\u0019\u0000\u023c\u023d\u0005\u0088\u0000\u0000\u023d\u0242"
          + "\u0001\u0000\u0000\u0000\u023e\u023f\u0005j\u0000\u0000\u023f\u0240\u0005"
          + "\u0013\u0000\u0000\u0240\u0242\u0005\u0088\u0000\u0000\u0241\u022d\u0001"
          + "\u0000\u0000\u0000\u0241\u022e\u0001\u0000\u0000\u0000\u0241\u023a\u0001"
          + "\u0000\u0000\u0000\u0241\u023e\u0001\u0000\u0000\u0000\u0242\'\u0001\u0000"
          + "\u0000\u0000\u0243\u0248\u0003*\u0015\u0000\u0244\u0245\u0005}\u0000\u0000"
          + "\u0245\u0247\u0003*\u0015\u0000\u0246\u0244\u0001\u0000\u0000\u0000\u0247"
          + "\u024a\u0001\u0000\u0000\u0000\u0248\u0246\u0001\u0000\u0000\u0000\u0248"
          + "\u0249\u0001\u0000\u0000\u0000\u0249)\u0001\u0000\u0000\u0000\u024a\u0248"
          + "\u0001\u0000\u0000\u0000\u024b\u024d\u0003,\u0016\u0000\u024c\u024b\u0001"
          + "\u0000\u0000\u0000\u024d\u024e\u0001\u0000\u0000\u0000\u024e\u024c\u0001"
          + "\u0000\u0000\u0000\u024e\u024f\u0001\u0000\u0000\u0000\u024f+\u0001\u0000"
          + "\u0000\u0000\u0250\u0269\u0003\u00c4b\u0000\u0251\u0252\u0005j\u0000\u0000"
          + "\u0252\u0253\u00032\u0019\u0000\u0253\u0254\u0005\u0088\u0000\u0000\u0254"
          + "\u0269\u0001\u0000\u0000\u0000\u0255\u0269\u0003.\u0017\u0000\u0256\u0257"
          + "\u0005`\u0000\u0000\u0257\u0258\u0003(\u0014\u0000\u0258\u0266\u0005a"
          + "\u0000\u0000\u0259\u0267\u0005x\u0000\u0000\u025a\u0267\u0005z\u0000\u0000"
          + "\u025b\u0267\u0005m\u0000\u0000\u025c\u025d\u0005b\u0000\u0000\u025d\u0262"
          + "\u0003\u00c0`\u0000\u025e\u0260\u0005g\u0000\u0000\u025f\u0261\u0003\u00c0"
          + "`\u0000\u0260\u025f\u0001\u0000\u0000\u0000\u0260\u0261\u0001\u0000\u0000"
          + "\u0000\u0261\u0263\u0001\u0000\u0000\u0000\u0262\u025e\u0001\u0000\u0000"
          + "\u0000\u0262\u0263\u0001\u0000\u0000\u0000\u0263\u0264\u0001\u0000\u0000"
          + "\u0000\u0264\u0265\u0005c\u0000\u0000\u0265\u0267\u0001\u0000\u0000\u0000"
          + "\u0266\u0259\u0001\u0000\u0000\u0000\u0266\u025a\u0001\u0000\u0000\u0000"
          + "\u0266\u025b\u0001\u0000\u0000\u0000\u0266\u025c\u0001\u0000\u0000\u0000"
          + "\u0266\u0267\u0001\u0000\u0000\u0000\u0267\u0269\u0001\u0000\u0000\u0000"
          + "\u0268\u0250\u0001\u0000\u0000\u0000\u0268\u0251\u0001\u0000\u0000\u0000"
          + "\u0268\u0255\u0001\u0000\u0000\u0000\u0268\u0256\u0001\u0000\u0000\u0000"
          + "\u0269-\u0001\u0000\u0000\u0000\u026a\u026c\u0005l\u0000\u0000\u026b\u026a"
          + "\u0001\u0000\u0000\u0000\u026b\u026c\u0001\u0000\u0000\u0000\u026c\u026d"
          + "\u0001\u0000\u0000\u0000\u026d\u0276\u0005d\u0000\u0000\u026e\u0273\u0003"
          + "0\u0018\u0000\u026f\u0270\u0005g\u0000\u0000\u0270\u0272\u00030\u0018"
          + "\u0000\u0271\u026f\u0001\u0000\u0000\u0000\u0272\u0275\u0001\u0000\u0000"
          + "\u0000\u0273\u0271\u0001\u0000\u0000\u0000\u0273\u0274\u0001\u0000\u0000"
          + "\u0000\u0274\u0277\u0001\u0000\u0000\u0000\u0275\u0273\u0001\u0000\u0000"
          + "\u0000\u0276\u026e\u0001\u0000\u0000\u0000\u0276\u0277\u0001\u0000\u0000"
          + "\u0000\u0277\u0278\u0001\u0000\u0000\u0000\u0278\u0279\u0005e\u0000\u0000"
          + "\u0279/\u0001\u0000\u0000\u0000\u027a\u027d\u0003\u00c4b\u0000\u027b\u027c"
          + "\u0005y\u0000\u0000\u027c\u027e\u0003\u00c4b\u0000\u027d\u027b\u0001\u0000"
          + "\u0000\u0000\u027d\u027e\u0001\u0000\u0000\u0000\u027e1\u0001\u0000\u0000"
          + "\u0000\u027f\u0280\u0005\u0089\u0000\u0000\u02803\u0001\u0000\u0000\u0000"
          + "\u0281\u0282\u0005\u0001\u0000\u0000\u0282\u028a\u0007\u0004\u0000\u0000"
          + "\u0283\u0285\u0005`\u0000\u0000\u0284\u0286\u0005\u0088\u0000\u0000\u0285"
          + "\u0284\u0001\u0000\u0000\u0000\u0285\u0286\u0001\u0000\u0000\u0000\u0286"
          + "\u0287\u0001\u0000\u0000\u0000\u0287\u0288\u00036\u001b\u0000\u0288\u0289"
          + "\u0005a\u0000\u0000\u0289\u028b\u0001\u0000\u0000\u0000\u028a\u0283\u0001"
          + "\u0000\u0000\u0000\u028a\u028b\u0001\u0000\u0000\u0000\u028b5\u0001\u0000"
          + "\u0000\u0000\u028c\u028e\b\u0005\u0000\u0000\u028d\u028c\u0001\u0000\u0000"
          + "\u0000\u028e\u0291\u0001\u0000\u0000\u0000\u028f\u028d\u0001\u0000\u0000"
          + "\u0000\u028f\u0290\u0001\u0000\u0000\u0000\u0290\u0297\u0001\u0000\u0000"
          + "\u0000\u0291\u028f\u0001\u0000\u0000\u0000\u0292\u0293\u0005`\u0000\u0000"
          + "\u0293\u0294\u00036\u001b\u0000\u0294\u0295\u0005a\u0000\u0000\u0295\u0297"
          + "\u0001\u0000\u0000\u0000\u0296\u028f\u0001\u0000\u0000\u0000\u0296\u0292"
          + "\u0001\u0000\u0000\u0000\u02977\u0001\u0000\u0000\u0000\u0298\u0299\u0007"
          + "\u0006\u0000\u0000\u02999\u0001\u0000\u0000\u0000\u029a\u029c\u0003<\u001e"
          + "\u0000\u029b\u029a\u0001\u0000\u0000\u0000\u029b\u029c\u0001\u0000\u0000"
          + "\u0000\u029c\u02a0\u0001\u0000\u0000\u0000\u029d\u029f\u0003>\u001f\u0000"
          + "\u029e\u029d\u0001\u0000\u0000\u0000\u029f\u02a2\u0001\u0000\u0000\u0000"
          + "\u02a0\u029e\u0001\u0000\u0000\u0000\u02a0\u02a1\u0001\u0000\u0000\u0000"
          + "\u02a1\u02a6\u0001\u0000\u0000\u0000\u02a2\u02a0\u0001\u0000\u0000\u0000"
          + "\u02a3\u02a5\u0003B!\u0000\u02a4\u02a3\u0001\u0000\u0000\u0000\u02a5\u02a8"
          + "\u0001\u0000\u0000\u0000\u02a6\u02a4\u0001\u0000\u0000\u0000\u02a6\u02a7"
          + "\u0001\u0000\u0000\u0000\u02a7;\u0001\u0000\u0000\u0000\u02a8\u02a6\u0001"
          + "\u0000\u0000\u0000\u02a9\u02aa\u0003@ \u0000\u02aa\u02ab\u0005>\u0000"
          + "\u0000\u02ab\u02ac\u0003\u0088D\u0000\u02ac\u02ad\u0005f\u0000\u0000\u02ad"
          + "=\u0001\u0000\u0000\u0000\u02ae\u02b0\u00056\u0000\u0000\u02af\u02b1\u0005"
          + "D\u0000\u0000\u02b0\u02af\u0001\u0000\u0000\u0000\u02b0\u02b1\u0001\u0000"
          + "\u0000\u0000\u02b1\u02b2\u0001\u0000\u0000\u0000\u02b2\u02b5\u0003\u0088"
          + "D\u0000\u02b3\u02b4\u0005h\u0000\u0000\u02b4\u02b6\u0005z\u0000\u0000"
          + "\u02b5\u02b3\u0001\u0000\u0000\u0000\u02b5\u02b6\u0001\u0000\u0000\u0000"
          + "\u02b6\u02b7\u0001\u0000\u0000\u0000\u02b7\u02b8\u0005f\u0000\u0000\u02b8"
          + "?\u0001\u0000\u0000\u0000\u02b9\u02c6\u0005A\u0000\u0000\u02ba\u02c6\u0005"
          + "D\u0000\u0000\u02bb\u02c6\u0005@\u0000\u0000\u02bc\u02c6\u0005?\u0000"
          + "\u0000\u02bd\u02c6\u0005/\u0000\u0000\u02be\u02c6\u0005\u001d\u0000\u0000"
          + "\u02bf\u02c6\u0005H\u0000\u0000\u02c0\u02c6\u0005;\u0000\u0000\u02c1\u02c6"
          + "\u0005L\u0000\u0000\u02c2\u02c6\u0005P\u0000\u0000\u02c3\u02c6\u0005E"
          + "\u0000\u0000\u02c4\u02c6\u0003\u0102\u0081\u0000\u02c5\u02b9\u0001\u0000"
          + "\u0000\u0000\u02c5\u02ba\u0001\u0000\u0000\u0000\u02c5\u02bb\u0001\u0000"
          + "\u0000\u0000\u02c5\u02bc\u0001\u0000\u0000\u0000\u02c5\u02bd\u0001\u0000"
          + "\u0000\u0000\u02c5\u02be\u0001\u0000\u0000\u0000\u02c5\u02bf\u0001\u0000"
          + "\u0000\u0000\u02c5\u02c0\u0001\u0000\u0000\u0000\u02c5\u02c1\u0001\u0000"
          + "\u0000\u0000\u02c5\u02c2\u0001\u0000\u0000\u0000\u02c5\u02c3\u0001\u0000"
          + "\u0000\u0000\u02c5\u02c4\u0001\u0000\u0000\u0000\u02c6\u02c8\u0001\u0000"
          + "\u0000\u0000\u02c7\u02c5\u0001\u0000\u0000\u0000\u02c8\u02cb\u0001\u0000"
          + "\u0000\u0000\u02c9\u02c7\u0001\u0000\u0000\u0000\u02c9\u02ca\u0001\u0000"
          + "\u0000\u0000\u02caA\u0001\u0000\u0000\u0000\u02cb\u02c9\u0001\u0000\u0000"
          + "\u0000\u02cc\u02d4\u0005f\u0000\u0000\u02cd\u02d1\u0003@ \u0000\u02ce"
          + "\u02d2\u0003D\"\u0000\u02cf\u02d2\u0003J%\u0000\u02d0\u02d2\u0003\u0112"
          + "\u0089\u0000\u02d1\u02ce\u0001\u0000\u0000\u0000\u02d1\u02cf\u0001\u0000"
          + "\u0000\u0000\u02d1\u02d0\u0001\u0000\u0000\u0000\u02d2\u02d4\u0001\u0000"
          + "\u0000\u0000\u02d3\u02cc\u0001\u0000\u0000\u0000\u02d3\u02cd\u0001\u0000"
          + "\u0000\u0000\u02d4C\u0001\u0000\u0000\u0000\u02d5\u02d6\u0007\u0007\u0000"
          + "\u0000\u02d6\u02d8\u00038\u001c\u0000\u02d7\u02d9\u0003P(\u0000\u02d8"
          + "\u02d7\u0001\u0000\u0000\u0000\u02d8\u02d9\u0001\u0000\u0000\u0000\u02d9"
          + "\u02db\u0001\u0000\u0000\u0000\u02da\u02dc\u0003F#\u0000\u02db\u02da\u0001"
          + "\u0000\u0000\u0000\u02db\u02dc\u0001\u0000\u0000\u0000\u02dc\u02de\u0001"
          + "\u0000\u0000\u0000\u02dd\u02df\u0003H$\u0000\u02de\u02dd\u0001\u0000\u0000"
          + "\u0000\u02de\u02df\u0001\u0000\u0000\u0000\u02df\u02e0\u0001\u0000\u0000"
          + "\u0000\u02e0\u02e1\u0003V+\u0000\u02e1E\u0001\u0000\u0000\u0000\u02e2"
          + "\u02e3\u0005-\u0000\u0000\u02e3\u02e8\u0003|>\u0000\u02e4\u02e5\u0005"
          + "g\u0000\u0000\u02e5\u02e7\u0003|>\u0000\u02e6\u02e4\u0001\u0000\u0000"
          + "\u0000\u02e7\u02ea\u0001\u0000\u0000\u0000\u02e8\u02e6\u0001\u0000\u0000"
          + "\u0000\u02e8\u02e9\u0001\u0000\u0000\u0000\u02e9G\u0001\u0000\u0000\u0000"
          + "\u02ea\u02e8\u0001\u0000\u0000\u0000\u02eb\u02ec\u00055\u0000\u0000\u02ec"
          + "\u02f1\u0003|>\u0000\u02ed\u02ee\u0005g\u0000\u0000\u02ee\u02f0\u0003"
          + "|>\u0000\u02ef\u02ed\u0001\u0000\u0000\u0000\u02f0\u02f3\u0001\u0000\u0000"
          + "\u0000\u02f1\u02ef\u0001\u0000\u0000\u0000\u02f1\u02f2\u0001\u0000\u0000"
          + "\u0000\u02f2I\u0001\u0000\u0000\u0000\u02f3\u02f1\u0001\u0000\u0000\u0000"
          + "\u02f4\u02f5\u0005,\u0000\u0000\u02f5\u02f7\u00038\u001c\u0000\u02f6\u02f8"
          + "\u0003H$\u0000\u02f7\u02f6\u0001\u0000\u0000\u0000\u02f7\u02f8\u0001\u0000"
          + "\u0000\u0000\u02f8\u02f9\u0001\u0000\u0000\u0000\u02f9\u02fa\u0003L&\u0000"
          + "\u02faK\u0001\u0000\u0000\u0000\u02fb\u0304\u0005b\u0000\u0000\u02fc\u0301"
          + "\u0003N\'\u0000\u02fd\u02fe\u0005g\u0000\u0000\u02fe\u0300\u0003N\'\u0000"
          + "\u02ff\u02fd\u0001\u0000\u0000\u0000\u0300\u0303\u0001\u0000\u0000\u0000"
          + "\u0301\u02ff\u0001\u0000\u0000\u0000\u0301\u0302\u0001\u0000\u0000\u0000"
          + "\u0302\u0305\u0001\u0000\u0000\u0000\u0303\u0301\u0001\u0000\u0000\u0000"
          + "\u0304\u02fc\u0001\u0000\u0000\u0000\u0304\u0305\u0001\u0000\u0000\u0000"
          + "\u0305\u0307\u0001\u0000\u0000\u0000\u0306\u0308\u0005g\u0000\u0000\u0307"
          + "\u0306\u0001\u0000\u0000\u0000\u0307\u0308\u0001\u0000\u0000\u0000\u0308"
          + "\u0310\u0001\u0000\u0000\u0000\u0309\u030d\u0005f\u0000\u0000\u030a\u030c"
          + "\u0003X,\u0000\u030b\u030a\u0001\u0000\u0000\u0000\u030c\u030f\u0001\u0000"
          + "\u0000\u0000\u030d\u030b\u0001\u0000\u0000\u0000\u030d\u030e\u0001\u0000"
          + "\u0000\u0000\u030e\u0311\u0001\u0000\u0000\u0000\u030f\u030d\u0001\u0000"
          + "\u0000\u0000\u0310\u0309\u0001\u0000\u0000\u0000\u0310\u0311\u0001\u0000"
          + "\u0000\u0000\u0311\u0312\u0001\u0000\u0000\u0000\u0312\u0313\u0005c\u0000"
          + "\u0000\u0313M\u0001\u0000\u0000\u0000\u0314\u0315\u0003@ \u0000\u0315"
          + "\u0317\u00038\u001c\u0000\u0316\u0318\u0003\u00c8d\u0000\u0317\u0316\u0001"
          + "\u0000\u0000\u0000\u0317\u0318\u0001\u0000\u0000\u0000\u0318\u031a\u0001"
          + "\u0000\u0000\u0000\u0319\u031b\u0003V+\u0000\u031a\u0319\u0001\u0000\u0000"
          + "\u0000\u031a\u031b\u0001\u0000\u0000\u0000\u031bO\u0001\u0000\u0000\u0000"
          + "\u031c\u031d\u0005j\u0000\u0000\u031d\u0322\u0003R)\u0000\u031e\u031f"
          + "\u0005g\u0000\u0000\u031f\u0321\u0003R)\u0000\u0320\u031e\u0001\u0000"
          + "\u0000\u0000\u0321\u0324\u0001\u0000\u0000\u0000\u0322\u0320\u0001\u0000"
          + "\u0000\u0000\u0322\u0323\u0001\u0000\u0000\u0000\u0323\u0325\u0001\u0000"
          + "\u0000\u0000\u0324\u0322\u0001\u0000\u0000\u0000\u0325\u0326\u0005\u0088"
          + "\u0000\u0000\u0326Q\u0001\u0000\u0000\u0000\u0327\u0329\u00038\u001c\u0000"
          + "\u0328\u032a\u0003T*\u0000\u0329\u0328\u0001\u0000\u0000\u0000\u0329\u032a"
          + "\u0001\u0000\u0000\u0000\u032aS\u0001\u0000\u0000\u0000\u032b\u032c\u0005"
          + "-\u0000\u0000\u032c\u0331\u0003|>\u0000\u032d\u032e\u0005|\u0000\u0000"
          + "\u032e\u0330\u0003|>\u0000\u032f\u032d\u0001\u0000\u0000\u0000\u0330\u0333"
          + "\u0001\u0000\u0000\u0000\u0331\u032f\u0001\u0000\u0000\u0000\u0331\u0332"
          + "\u0001\u0000\u0000\u0000\u0332U\u0001\u0000\u0000\u0000\u0333\u0331\u0001"
          + "\u0000\u0000\u0000\u0334\u0338\u0005b\u0000\u0000\u0335\u0337\u0003X,"
          + "\u0000\u0336\u0335\u0001\u0000\u0000\u0000\u0337\u033a\u0001\u0000\u0000"
          + "\u0000\u0338\u0336\u0001\u0000\u0000\u0000\u0338\u0339\u0001\u0000\u0000"
          + "\u0000\u0339\u033b\u0001\u0000\u0000\u0000\u033a\u0338\u0001\u0000\u0000"
          + "\u0000\u033b\u033c\u0005c\u0000\u0000\u033cW\u0001\u0000\u0000\u0000\u033d"
          + "\u0348\u0003p8\u0000\u033e\u0344\u0003@ \u0000\u033f\u0345\u0003D\"\u0000"
          + "\u0340\u0345\u0003J%\u0000\u0341\u0345\u0003l6\u0000\u0342\u0345\u0003"
          + "Z-\u0000\u0343\u0345\u0003d2\u0000\u0344\u033f\u0001\u0000\u0000\u0000"
          + "\u0344\u0340\u0001\u0000\u0000\u0000\u0344\u0341\u0001\u0000\u0000\u0000"
          + "\u0344\u0342\u0001\u0000\u0000\u0000\u0344\u0343\u0001\u0000\u0000\u0000"
          + "\u0345\u0348\u0001\u0000\u0000\u0000\u0346\u0348\u0005f\u0000\u0000\u0347"
          + "\u033d\u0001\u0000\u0000\u0000\u0347\u033e\u0001\u0000\u0000\u0000\u0347"
          + "\u0346\u0001\u0000\u0000\u0000\u0348Y\u0001\u0000\u0000\u0000\u0349\u034a"
          + "\u0003r9\u0000\u034a\u034f\u0003\\.\u0000\u034b\u034c\u0005g\u0000\u0000"
          + "\u034c\u034e\u0003\\.\u0000\u034d\u034b\u0001\u0000\u0000\u0000\u034e"
          + "\u0351\u0001\u0000\u0000\u0000\u034f\u034d\u0001\u0000\u0000\u0000\u034f"
          + "\u0350\u0001\u0000\u0000\u0000\u0350\u0352\u0001\u0000\u0000\u0000\u0351"
          + "\u034f\u0001\u0000\u0000\u0000\u0352\u0353\u0005f\u0000\u0000\u0353[\u0001"
          + "\u0000\u0000\u0000\u0354\u0357\u0003^/\u0000\u0355\u0356\u0005i\u0000"
          + "\u0000\u0356\u0358\u0003`0\u0000\u0357\u0355\u0001\u0000\u0000\u0000\u0357"
          + "\u0358\u0001\u0000\u0000\u0000\u0358]\u0001\u0000\u0000\u0000\u0359\u035e"
          + "\u00038\u001c\u0000\u035a\u035b\u0005d\u0000\u0000\u035b\u035d\u0005e"
          + "\u0000\u0000\u035c\u035a\u0001\u0000\u0000\u0000\u035d\u0360\u0001\u0000"
          + "\u0000\u0000\u035e\u035c\u0001\u0000\u0000\u0000\u035e\u035f\u0001\u0000"
          + "\u0000\u0000\u035f_\u0001\u0000\u0000\u0000\u0360\u035e\u0001\u0000\u0000"
          + "\u0000\u0361\u0364\u0003b1\u0000\u0362\u0364\u0003\u008cF\u0000\u0363"
          + "\u0361\u0001\u0000\u0000\u0000\u0363\u0362\u0001\u0000\u0000\u0000\u0364"
          + "a\u0001\u0000\u0000\u0000\u0365\u036e\u0005b\u0000\u0000\u0366\u036b\u0003"
          + "`0\u0000\u0367\u0368\u0005g\u0000\u0000\u0368\u036a\u0003`0\u0000\u0369"
          + "\u0367\u0001\u0000\u0000\u0000\u036a\u036d\u0001\u0000\u0000\u0000\u036b"
          + "\u0369\u0001\u0000\u0000\u0000\u036b\u036c\u0001\u0000\u0000\u0000\u036c"
          + "\u036f\u0001\u0000\u0000\u0000\u036d\u036b\u0001\u0000\u0000\u0000\u036e"
          + "\u0366\u0001\u0000\u0000\u0000\u036e\u036f\u0001\u0000\u0000\u0000\u036f"
          + "\u0371\u0001\u0000\u0000\u0000\u0370\u0372\u0005g\u0000\u0000\u0371\u0370"
          + "\u0001\u0000\u0000\u0000\u0371\u0372\u0001\u0000\u0000\u0000\u0372\u0373"
          + "\u0001\u0000\u0000\u0000\u0373\u0374\u0005c\u0000\u0000\u0374c\u0001\u0000"
          + "\u0000\u0000\u0375\u0377\u0003P(\u0000\u0376\u0375\u0001\u0000\u0000\u0000"
          + "\u0376\u0377\u0001\u0000\u0000\u0000\u0377\u0378\u0001\u0000\u0000\u0000"
          + "\u0378\u0379\u0003\u0086C\u0000\u0379\u037c\u0003f3\u0000\u037a\u037b"
          + "\u0005K\u0000\u0000\u037b\u037d\u0003\u008aE\u0000\u037c\u037a\u0001\u0000"
          + "\u0000\u0000\u037c\u037d\u0001\u0000\u0000\u0000\u037d\u0380\u0001\u0000"
          + "\u0000\u0000\u037e\u0381\u0003\u00d6k\u0000\u037f\u0381\u0005f\u0000\u0000"
          + "\u0380\u037e\u0001\u0000\u0000\u0000\u0380\u037f\u0001\u0000\u0000\u0000"
          + "\u0381e\u0001\u0000\u0000\u0000\u0382\u0383\u00038\u001c\u0000\u0383\u0388"
          + "\u0003h4\u0000\u0384\u0385\u0005d\u0000\u0000\u0385\u0387\u0005e\u0000"
          + "\u0000\u0386\u0384\u0001\u0000\u0000\u0000\u0387\u038a\u0001\u0000\u0000"
          + "\u0000\u0388\u0386\u0001\u0000\u0000\u0000\u0388\u0389\u0001\u0000\u0000"
          + "\u0000\u0389g\u0001\u0000\u0000\u0000\u038a\u0388\u0001\u0000\u0000\u0000"
          + "\u038b\u0394\u0005`\u0000\u0000\u038c\u0391\u0003j5\u0000\u038d\u038e"
          + "\u0005g\u0000\u0000\u038e\u0390\u0003j5\u0000\u038f\u038d\u0001\u0000"
          + "\u0000\u0000\u0390\u0393\u0001\u0000\u0000\u0000\u0391\u038f\u0001\u0000"
          + "\u0000\u0000\u0391\u0392\u0001\u0000\u0000\u0000\u0392\u0395\u0001\u0000"
          + "\u0000\u0000\u0393\u0391\u0001\u0000\u0000\u0000\u0394\u038c\u0001\u0000"
          + "\u0000\u0000\u0394\u0395\u0001\u0000\u0000\u0000\u0395\u0396\u0001\u0000"
          + "\u0000\u0000\u0396\u0397\u0005a\u0000\u0000\u0397i\u0001\u0000\u0000\u0000"
          + "\u0398\u0399\u0003@ \u0000\u0399\u039c\u0003r9\u0000\u039a\u039d\u0007"
          + "\b\u0000\u0000\u039b\u039d\u0005\u0002\u0000\u0000\u039c\u039a\u0001\u0000"
          + "\u0000\u0000\u039c\u039b\u0001\u0000\u0000\u0000\u039c\u039d\u0001\u0000"
          + "\u0000\u0000\u039d\u039e\u0001\u0000\u0000\u0000\u039e\u039f\u0003^/\u0000"
          + "\u039fk\u0001\u0000\u0000\u0000\u03a0\u03a2\u0003P(\u0000\u03a1\u03a0"
          + "\u0001\u0000\u0000\u0000\u03a1\u03a2\u0001\u0000\u0000\u0000\u03a2\u03a3"
          + "\u0001\u0000\u0000\u0000\u03a3\u03a4\u00038\u001c\u0000\u03a4\u03a7\u0003"
          + "h4\u0000\u03a5\u03a6\u0005K\u0000\u0000\u03a6\u03a8\u0003\u008aE\u0000"
          + "\u03a7\u03a5\u0001\u0000\u0000\u0000\u03a7\u03a8\u0001\u0000\u0000\u0000"
          + "\u03a8\u03a9\u0001\u0000\u0000\u0000\u03a9\u03ab\u0005b\u0000\u0000\u03aa"
          + "\u03ac\u0003n7\u0000\u03ab\u03aa\u0001\u0000\u0000\u0000\u03ab\u03ac\u0001"
          + "\u0000\u0000\u0000\u03ac\u03b0\u0001\u0000\u0000\u0000\u03ad\u03af\u0003"
          + "\u00d8l\u0000\u03ae\u03ad\u0001\u0000\u0000\u0000\u03af\u03b2\u0001\u0000"
          + "\u0000\u0000\u03b0\u03ae\u0001\u0000\u0000\u0000\u03b0\u03b1\u0001\u0000"
          + "\u0000\u0000\u03b1\u03b3\u0001\u0000\u0000\u0000\u03b2\u03b0\u0001\u0000"
          + "\u0000\u0000\u03b3\u03b4\u0005c\u0000\u0000\u03b4m\u0001\u0000\u0000\u0000"
          + "\u03b5\u03b6\u0005I\u0000\u0000\u03b6\u03b7\u0003\u00c8d\u0000\u03b7\u03b8"
          + "\u0005f\u0000\u0000\u03b8\u03c3\u0001\u0000\u0000\u0000\u03b9\u03ba\u0003"
          + "\u00b6[\u0000\u03ba\u03bb\u0005h\u0000\u0000\u03bb\u03bd\u0001\u0000\u0000"
          + "\u0000\u03bc\u03b9\u0001\u0000\u0000\u0000\u03bc\u03bd\u0001\u0000\u0000"
          + "\u0000\u03bd\u03be\u0001\u0000\u0000\u0000\u03be\u03bf\u0005F\u0000\u0000"
          + "\u03bf\u03c0\u0003\u00c8d\u0000\u03c0\u03c1\u0005f\u0000\u0000\u03c1\u03c3"
          + "\u0001\u0000\u0000\u0000\u03c2\u03b5\u0001\u0000\u0000\u0000\u03c2\u03bc"
          + "\u0001\u0000\u0000\u0000\u03c3o\u0001\u0000\u0000\u0000\u03c4\u03c6\u0005"
          + "D\u0000\u0000\u03c5\u03c4\u0001\u0000\u0000\u0000\u03c5\u03c6\u0001\u0000"
          + "\u0000\u0000\u03c6\u03c7\u0001\u0000\u0000\u0000\u03c7\u03c8\u0003\u00d6"
          + "k\u0000\u03c8q\u0001\u0000\u0000\u0000\u03c9\u03cc\u0003t:\u0000\u03ca"
          + "\u03cc\u0003\u0084B\u0000\u03cb\u03c9\u0001\u0000\u0000\u0000\u03cb\u03ca"
          + "\u0001\u0000\u0000\u0000\u03ccs\u0001\u0000\u0000\u0000\u03cd\u03d0\u0003"
          + "\u0084B\u0000\u03ce\u03cf\u0005d\u0000\u0000\u03cf\u03d1\u0005e\u0000"
          + "\u0000\u03d0\u03ce\u0001\u0000\u0000\u0000\u03d1\u03d2\u0001\u0000\u0000"
          + "\u0000\u03d2\u03d0\u0001\u0000\u0000\u0000\u03d2\u03d3\u0001\u0000\u0000"
          + "\u0000\u03d3\u03e1\u0001\u0000\u0000\u0000\u03d4\u03d6\u0003v;\u0000\u03d5"
          + "\u03d4\u0001\u0000\u0000\u0000\u03d5\u03d6\u0001\u0000\u0000\u0000\u03d6"
          + "\u03d7\u0001\u0000\u0000\u0000\u03d7\u03d8\u0003|>\u0000\u03d8\u03dd\u0001"
          + "\u0000\u0000\u0000\u03d9\u03da\u0005d\u0000\u0000\u03da\u03dc\u0005e\u0000"
          + "\u0000\u03db\u03d9\u0001\u0000\u0000\u0000\u03dc\u03df\u0001\u0000\u0000"
          + "\u0000\u03dd\u03db\u0001\u0000\u0000\u0000\u03dd\u03de\u0001\u0000\u0000"
          + "\u0000\u03de\u03e1\u0001\u0000\u0000\u0000\u03df\u03dd\u0001\u0000\u0000"
          + "\u0000\u03e0\u03cd\u0001\u0000\u0000\u0000\u03e0\u03d5\u0001\u0000\u0000"
          + "\u0000\u03e1u\u0001\u0000\u0000\u0000\u03e2\u03e3\u0005R\u0000\u0000\u03e3"
          + "\u03e4\u0005j\u0000\u0000\u03e4\u03e9\u0003x<\u0000\u03e5\u03e6\u0005"
          + "g\u0000\u0000\u03e6\u03e8\u0003x<\u0000\u03e7\u03e5\u0001\u0000\u0000"
          + "\u0000\u03e8\u03eb\u0001\u0000\u0000\u0000\u03e9\u03e7\u0001\u0000\u0000"
          + "\u0000\u03e9\u03ea\u0001\u0000\u0000\u0000\u03ea\u03ec\u0001\u0000\u0000"
          + "\u0000\u03eb\u03e9\u0001\u0000\u0000\u0000\u03ec\u03ed\u0005\u0088\u0000"
          + "\u0000\u03edw\u0001\u0000\u0000\u0000\u03ee\u03f0\u0003z=\u0000\u03ef"
          + "\u03f1\u0005\u0002\u0000\u0000\u03f0\u03ef\u0001\u0000\u0000\u0000\u03f0"
          + "\u03f1\u0001\u0000\u0000\u0000\u03f1\u03f2\u0001\u0000\u0000\u0000\u03f2"
          + "\u03f3\u0005\u0089\u0000\u0000\u03f3y\u0001\u0000\u0000\u0000\u03f4\u03f5"
          + "\u0007\t\u0000\u0000\u03f5{\u0001\u0000\u0000\u0000\u03f6\u03f8\u0005"
          + "o\u0000\u0000\u03f7\u03f6\u0001\u0000\u0000\u0000\u03f7\u03f8\u0001\u0000"
          + "\u0000\u0000\u03f8\u03f9\u0001\u0000\u0000\u0000\u03f9\u03fb\u0005\u0089"
          + "\u0000\u0000\u03fa\u03fc\u0003~?\u0000\u03fb\u03fa\u0001\u0000\u0000\u0000"
          + "\u03fb\u03fc\u0001\u0000\u0000\u0000\u03fc\u0404\u0001\u0000\u0000\u0000"
          + "\u03fd\u03fe\u0007\n\u0000\u0000\u03fe\u0400\u0005\u0089\u0000\u0000\u03ff"
          + "\u0401\u0003~?\u0000\u0400\u03ff\u0001\u0000\u0000\u0000\u0400\u0401\u0001"
          + "\u0000\u0000\u0000\u0401\u0403\u0001\u0000\u0000\u0000\u0402\u03fd\u0001"
          + "\u0000\u0000\u0000\u0403\u0406\u0001\u0000\u0000\u0000\u0404\u0402\u0001"
          + "\u0000\u0000\u0000\u0404\u0405\u0001\u0000\u0000\u0000\u0405}\u0001\u0000"
          + "\u0000\u0000\u0406\u0404\u0001\u0000\u0000\u0000\u0407\u0413\u0005j\u0000"
          + "\u0000\u0408\u0410\u0003\u0080@\u0000\u0409\u040a\u0005g\u0000\u0000\u040a"
          + "\u040c\u0003\u0080@\u0000\u040b\u040d\u0005\u0002\u0000\u0000\u040c\u040b"
          + "\u0001\u0000\u0000\u0000\u040c\u040d\u0001\u0000\u0000\u0000\u040d\u040f"
          + "\u0001\u0000\u0000\u0000\u040e\u0409\u0001\u0000\u0000\u0000\u040f\u0412"
          + "\u0001\u0000\u0000\u0000\u0410\u040e\u0001\u0000\u0000\u0000\u0410\u0411"
          + "\u0001\u0000\u0000\u0000\u0411\u0414\u0001\u0000\u0000\u0000\u0412\u0410"
          + "\u0001\u0000\u0000\u0000\u0413\u0408\u0001\u0000\u0000\u0000\u0413\u0414"
          + "\u0001\u0000\u0000\u0000\u0414\u0415\u0001\u0000\u0000\u0000\u0415\u0416"
          + "\u0005\u0088\u0000\u0000\u0416\u007f\u0001\u0000\u0000\u0000\u0417\u041d"
          + "\u0003t:\u0000\u0418\u041a\u0005m\u0000\u0000\u0419\u041b\u0003\u0082"
          + "A\u0000\u041a\u0419\u0001\u0000\u0000\u0000\u041a\u041b\u0001\u0000\u0000"
          + "\u0000\u041b\u041d\u0001\u0000\u0000\u0000\u041c\u0417\u0001\u0000\u0000"
          + "\u0000\u041c\u0418\u0001\u0000\u0000\u0000\u041d\u0081\u0001\u0000\u0000"
          + "\u0000\u041e\u041f\u0005-\u0000\u0000\u041f\u0423\u0003t:\u0000\u0420"
          + "\u0421\u0005F\u0000\u0000\u0421\u0423\u0003t:\u0000\u0422\u041e\u0001"
          + "\u0000\u0000\u0000\u0422\u0420\u0001\u0000\u0000\u0000\u0423\u0083\u0001"
          + "\u0000\u0000\u0000\u0424\u0425\u0007\u000b\u0000\u0000\u0425\u0085\u0001"
          + "\u0000\u0000\u0000\u0426\u0428\u0005O\u0000\u0000\u0427\u0429\u0005z\u0000"
          + "\u0000\u0428\u0427\u0001\u0000\u0000\u0000\u0428\u0429\u0001\u0000\u0000"
          + "\u0000\u0429\u0432\u0001\u0000\u0000\u0000\u042a\u042c\u0005&\u0000\u0000"
          + "\u042b\u042a\u0001\u0000\u0000\u0000\u042b\u042c\u0001\u0000\u0000\u0000"
          + "\u042c\u042d\u0001\u0000\u0000\u0000\u042d\u042f\u0003r9\u0000\u042e\u0430"
          + "\u0007\b\u0000\u0000\u042f\u042e\u0001\u0000\u0000\u0000\u042f\u0430\u0001"
          + "\u0000\u0000\u0000\u0430\u0432\u0001\u0000\u0000\u0000\u0431\u0426\u0001"
          + "\u0000\u0000\u0000\u0431\u042b\u0001\u0000\u0000\u0000\u0432\u0087\u0001"
          + "\u0000\u0000\u0000\u0433\u0438\u00038\u001c\u0000\u0434\u0435\u0005h\u0000"
          + "\u0000\u0435\u0437\u00038\u001c\u0000\u0436\u0434\u0001\u0000\u0000\u0000"
          + "\u0437\u043a\u0001\u0000\u0000\u0000\u0438\u0436\u0001\u0000\u0000\u0000"
          + "\u0438\u0439\u0001\u0000\u0000\u0000\u0439\u0089\u0001\u0000\u0000\u0000"
          + "\u043a\u0438\u0001\u0000\u0000\u0000\u043b\u0440\u0003\u0088D\u0000\u043c"
          + "\u043d\u0005g\u0000\u0000\u043d\u043f\u0003\u0088D\u0000\u043e\u043c\u0001"
          + "\u0000\u0000\u0000\u043f\u0442\u0001\u0000\u0000\u0000\u0440\u043e\u0001"
          + "\u0000\u0000\u0000\u0440\u0441\u0001\u0000\u0000\u0000\u0441\u008b\u0001"
          + "\u0000\u0000\u0000\u0442\u0440\u0001\u0000\u0000\u0000\u0443\u0447\u0003"
          + "\u0090H\u0000\u0444\u0445\u0003\u008eG\u0000\u0445\u0446\u0003\u008cF"
          + "\u0000\u0446\u0448\u0001\u0000\u0000\u0000\u0447\u0444\u0001\u0000\u0000"
          + "\u0000\u0447\u0448\u0001\u0000\u0000\u0000\u0448\u008d\u0001\u0000\u0000"
          + "\u0000\u0449\u044a\u0007\f\u0000\u0000\u044a\u008f\u0001\u0000\u0000\u0000"
          + "\u044b\u0451\u0003\u0092I\u0000\u044c\u044d\u0005m\u0000\u0000\u044d\u044e"
          + "\u0003\u008cF\u0000\u044e\u044f\u0005n\u0000\u0000\u044f\u0450\u0003\u008c"
          + "F\u0000\u0450\u0452\u0001\u0000\u0000\u0000\u0451\u044c\u0001\u0000\u0000"
          + "\u0000\u0451\u0452\u0001\u0000\u0000\u0000\u0452\u0091\u0001\u0000\u0000"
          + "\u0000\u0453\u0458\u0003\u0094J\u0000\u0454\u0455\u0005t\u0000\u0000\u0455"
          + "\u0457\u0003\u0094J\u0000\u0456\u0454\u0001\u0000\u0000\u0000\u0457\u045a"
          + "\u0001\u0000\u0000\u0000\u0458\u0456\u0001\u0000\u0000\u0000\u0458\u0459"
          + "\u0001\u0000\u0000\u0000\u0459\u0093\u0001\u0000\u0000\u0000\u045a\u0458"
          + "\u0001\u0000\u0000\u0000\u045b\u0460\u0003\u0096K\u0000\u045c\u045d\u0005"
          + "u\u0000\u0000\u045d\u045f\u0003\u0096K\u0000\u045e\u045c\u0001\u0000\u0000"
          + "\u0000\u045f\u0462\u0001\u0000\u0000\u0000\u0460\u045e\u0001\u0000\u0000"
          + "\u0000\u0460\u0461\u0001\u0000\u0000\u0000\u0461\u0095\u0001\u0000\u0000"
          + "\u0000\u0462\u0460\u0001\u0000\u0000\u0000\u0463\u0468\u0003\u0098L\u0000"
          + "\u0464\u0465\u0005}\u0000\u0000\u0465\u0467\u0003\u0098L\u0000\u0466\u0464"
          + "\u0001\u0000\u0000\u0000\u0467\u046a\u0001\u0000\u0000\u0000\u0468\u0466"
          + "\u0001\u0000\u0000\u0000\u0468\u0469\u0001\u0000\u0000\u0000\u0469\u0097"
          + "\u0001\u0000\u0000\u0000\u046a\u0468\u0001\u0000\u0000\u0000\u046b\u0470"
          + "\u0003\u009aM\u0000\u046c\u046d\u0005~\u0000\u0000\u046d\u046f\u0003\u009a"
          + "M\u0000\u046e\u046c\u0001\u0000\u0000\u0000\u046f\u0472\u0001\u0000\u0000"
          + "\u0000\u0470\u046e\u0001\u0000\u0000\u0000\u0470\u0471\u0001\u0000\u0000"
          + "\u0000\u0471\u0099\u0001\u0000\u0000\u0000\u0472\u0470\u0001\u0000\u0000"
          + "\u0000\u0473\u0478\u0003\u009cN\u0000\u0474\u0475\u0005|\u0000\u0000\u0475"
          + "\u0477\u0003\u009cN\u0000\u0476\u0474\u0001\u0000\u0000\u0000\u0477\u047a"
          + "\u0001\u0000\u0000\u0000\u0478\u0476\u0001\u0000\u0000\u0000\u0478\u0479"
          + "\u0001\u0000\u0000\u0000\u0479\u009b\u0001\u0000\u0000\u0000\u047a\u0478"
          + "\u0001\u0000\u0000\u0000\u047b\u0480\u0003\u009eO\u0000\u047c\u047d\u0007"
          + "\r\u0000\u0000\u047d\u047f\u0003\u009eO\u0000\u047e\u047c\u0001\u0000"
          + "\u0000\u0000\u047f\u0482\u0001\u0000\u0000\u0000\u0480\u047e\u0001\u0000"
          + "\u0000\u0000\u0480\u0481\u0001\u0000\u0000\u0000\u0481\u009d\u0001\u0000"
          + "\u0000\u0000\u0482\u0480\u0001\u0000\u0000\u0000\u0483\u0486\u0003\u00a0"
          + "P\u0000\u0484\u0485\u00057\u0000\u0000\u0485\u0487\u0003r9\u0000\u0486"
          + "\u0484\u0001\u0000\u0000\u0000\u0486\u0487\u0001\u0000\u0000\u0000\u0487"
          + "\u009f\u0001\u0000\u0000\u0000\u0488\u048d\u0003\u00a2Q\u0000\u0489\u048a"
          + "\u0007\u000e\u0000\u0000\u048a\u048c\u0003\u00a2Q\u0000\u048b\u0489\u0001"
          + "\u0000\u0000\u0000\u048c\u048f\u0001\u0000\u0000\u0000\u048d\u048b\u0001"
          + "\u0000\u0000\u0000\u048d\u048e\u0001\u0000\u0000\u0000\u048e\u00a1\u0001"
          + "\u0000\u0000\u0000\u048f\u048d\u0001\u0000\u0000\u0000\u0490\u0499\u0003"
          + "\u00a4R\u0000\u0491\u0495\u0005\u0006\u0000\u0000\u0492\u0495\u0003\u0002"
          + "\u0001\u0000\u0493\u0495\u0003\u0000\u0000\u0000\u0494\u0491\u0001\u0000"
          + "\u0000\u0000\u0494\u0492\u0001\u0000\u0000\u0000\u0494\u0493\u0001\u0000"
          + "\u0000\u0000\u0495\u0496\u0001\u0000\u0000\u0000\u0496\u0498\u0003\u00a4"
          + "R\u0000\u0497\u0494\u0001\u0000\u0000\u0000\u0498\u049b\u0001\u0000\u0000"
          + "\u0000\u0499\u0497\u0001\u0000\u0000\u0000\u0499\u049a\u0001\u0000\u0000"
          + "\u0000\u049a\u00a3\u0001\u0000\u0000\u0000\u049b\u0499\u0001\u0000\u0000"
          + "\u0000\u049c\u04a1\u0003\u00a6S\u0000\u049d\u049e\u0007\u000f\u0000\u0000"
          + "\u049e\u04a0\u0003\u00a6S\u0000\u049f\u049d\u0001\u0000\u0000\u0000\u04a0"
          + "\u04a3\u0001\u0000\u0000\u0000\u04a1\u049f\u0001\u0000\u0000\u0000\u04a1"
          + "\u04a2\u0001\u0000\u0000\u0000\u04a2\u00a5\u0001\u0000\u0000\u0000\u04a3"
          + "\u04a1\u0001\u0000\u0000\u0000\u04a4\u04a9\u0003\u00a8T\u0000\u04a5\u04a6"
          + "\u0007\u0010\u0000\u0000\u04a6\u04a8\u0003\u00a8T\u0000\u04a7\u04a5\u0001"
          + "\u0000\u0000\u0000\u04a8\u04ab\u0001\u0000\u0000\u0000\u04a9\u04a7\u0001"
          + "\u0000\u0000\u0000\u04a9\u04aa\u0001\u0000\u0000\u0000\u04aa\u00a7\u0001"
          + "\u0000\u0000\u0000\u04ab\u04a9\u0001\u0000\u0000\u0000\u04ac\u04ad\u0007"
          + "\u000f\u0000\u0000\u04ad\u04b2\u0003\u00a8T\u0000\u04ae\u04b2\u0003\u00aa"
          + "U\u0000\u04af\u04b2\u0003\u00acV\u0000\u04b0\u04b2\u0003\u00aeW\u0000"
          + "\u04b1\u04ac\u0001\u0000\u0000\u0000\u04b1\u04ae\u0001\u0000\u0000\u0000"
          + "\u04b1\u04af\u0001\u0000\u0000\u0000\u04b1\u04b0\u0001\u0000\u0000\u0000"
          + "\u04b2\u00a9\u0001\u0000\u0000\u0000\u04b3\u04b4\u0005v\u0000\u0000\u04b4"
          + "\u04b5\u0003\u00b6[\u0000\u04b5\u00ab\u0001\u0000\u0000\u0000\u04b6\u04b7"
          + "\u0005w\u0000\u0000\u04b7\u04b8\u0003\u00b6[\u0000\u04b8\u00ad\u0001\u0000"
          + "\u0000\u0000\u04b9\u04ba\u0007\u0011\u0000\u0000\u04ba\u04be\u0003\u00a8"
          + "T\u0000\u04bb\u04be\u0003\u00b4Z\u0000\u04bc\u04be\u0003\u00b2Y\u0000"
          + "\u04bd\u04b9\u0001\u0000\u0000\u0000\u04bd\u04bb\u0001\u0000\u0000\u0000"
          + "\u04bd\u04bc\u0001\u0000\u0000\u0000\u04be\u00af\u0001\u0000\u0000\u0000"
          + "\u04bf\u04c0\u0005`\u0000\u0000\u04c0\u04d4\u0003\u0084B\u0000\u04c1\u04c2"
          + "\u0005`\u0000\u0000\u04c2\u04c3\u0003r9\u0000\u04c3\u04c4\u0005d\u0000"
          + "\u0000\u04c4\u04c5\u0005e\u0000\u0000\u04c5\u04d4\u0001\u0000\u0000\u0000"
          + "\u04c6\u04c7\u0005`\u0000\u0000\u04c7\u04c8\u0003r9\u0000\u04c8\u04d1"
          + "\u0005a\u0000\u0000\u04c9\u04d2\u0005l\u0000\u0000\u04ca\u04d2\u0005k"
          + "\u0000\u0000\u04cb\u04d2\u0005`\u0000\u0000\u04cc\u04d2\u00038\u001c\u0000"
          + "\u04cd\u04d2\u0005I\u0000\u0000\u04ce\u04d2\u0005F\u0000\u0000\u04cf\u04d2"
          + "\u0005<\u0000\u0000\u04d0\u04d2\u0003\u00be_\u0000\u04d1\u04c9\u0001\u0000"
          + "\u0000\u0000\u04d1\u04ca\u0001\u0000\u0000\u0000\u04d1\u04cb\u0001\u0000"
          + "\u0000\u0000\u04d1\u04cc\u0001\u0000\u0000\u0000\u04d1\u04cd\u0001\u0000"
          + "\u0000\u0000\u04d1\u04ce\u0001\u0000\u0000\u0000\u04d1\u04cf\u0001\u0000"
          + "\u0000\u0000\u04d1\u04d0\u0001\u0000\u0000\u0000\u04d2\u04d4\u0001\u0000"
          + "\u0000\u0000\u04d3\u04bf\u0001\u0000\u0000\u0000\u04d3\u04c1\u0001\u0000"
          + "\u0000\u0000\u04d3\u04c6\u0001\u0000\u0000\u0000\u04d4\u00b1\u0001\u0000"
          + "\u0000\u0000\u04d5\u04d7\u0003\u00b6[\u0000\u04d6\u04d8\u0007\u0012\u0000"
          + "\u0000\u04d7\u04d6\u0001\u0000\u0000\u0000\u04d7\u04d8\u0001\u0000\u0000"
          + "\u0000\u04d8\u00b3\u0001\u0000\u0000\u0000\u04d9\u04da\u0005`\u0000\u0000"
          + "\u04da\u04db\u0003r9\u0000\u04db\u04dc\u0005a\u0000\u0000\u04dc\u04dd"
          + "\u0003\u00a8T\u0000\u04dd\u04e4\u0001\u0000\u0000\u0000\u04de\u04df\u0005"
          + "`\u0000\u0000\u04df\u04e0\u0003r9\u0000\u04e0\u04e1\u0005a\u0000\u0000"
          + "\u04e1\u04e2\u0003\u00aeW\u0000\u04e2\u04e4\u0001\u0000\u0000\u0000\u04e3"
          + "\u04d9\u0001\u0000\u0000\u0000\u04e3\u04de\u0001\u0000\u0000\u0000\u04e4"
          + "\u00b5\u0001\u0000\u0000\u0000\u04e5\u04e9\u0003\u00ba]\u0000\u04e6\u04e8"
          + "\u0003\u00bc^\u0000\u04e7\u04e6\u0001\u0000\u0000\u0000\u04e8\u04eb\u0001"
          + "\u0000\u0000\u0000\u04e9\u04e7\u0001\u0000\u0000\u0000\u04e9\u04ea\u0001"
          + "\u0000\u0000\u0000\u04ea\u00b7\u0001\u0000\u0000\u0000\u04eb\u04e9\u0001"
          + "\u0000\u0000\u0000\u04ec\u04ed\u0005h\u0000\u0000\u04ed\u04ee\u0003~?"
          + "\u0000\u04ee\u04ef\u00038\u001c\u0000\u04ef\u00b9\u0001\u0000\u0000\u0000"
          + "\u04f0\u0500\u0003\u00be_\u0000\u04f1\u0500\u0005I\u0000\u0000\u04f2\u04f3"
          + "\u0005F\u0000\u0000\u04f3\u04f4\u0005h\u0000\u0000\u04f4\u0500\u00038"
          + "\u001c\u0000\u04f5\u04f6\u0005`\u0000\u0000\u04f6\u04f7\u0003\u008cF\u0000"
          + "\u04f7\u04f8\u0005a\u0000\u0000\u04f8\u0500\u0001\u0000\u0000\u0000\u04f9"
          + "\u0500\u0003\u00ccf\u0000\u04fa\u04fb\u0003\u0086C\u0000\u04fb\u04fc\u0005"
          + "h\u0000\u0000\u04fc\u04fd\u0005%\u0000\u0000\u04fd\u0500\u0001\u0000\u0000"
          + "\u0000\u04fe\u0500\u0003\u0088D\u0000\u04ff\u04f0\u0001\u0000\u0000\u0000"
          + "\u04ff\u04f1\u0001\u0000\u0000\u0000\u04ff\u04f2\u0001\u0000\u0000\u0000"
          + "\u04ff\u04f5\u0001\u0000\u0000\u0000\u04ff\u04f9\u0001\u0000\u0000\u0000"
          + "\u04ff\u04fa\u0001\u0000\u0000\u0000\u04ff\u04fe\u0001\u0000\u0000\u0000"
          + "\u0500\u00bb\u0001\u0000\u0000\u0000\u0501\u0502\u0005h\u0000\u0000\u0502"
          + "\u050e\u0005I\u0000\u0000\u0503\u0504\u0005h\u0000\u0000\u0504\u050e\u0003"
          + "\u00ccf\u0000\u0505\u050e\u0003\u00b8\\\u0000\u0506\u0507\u0005d\u0000"
          + "\u0000\u0507\u0508\u0003\u008cF\u0000\u0508\u0509\u0005e\u0000\u0000\u0509"
          + "\u050e\u0001\u0000\u0000\u0000\u050a\u050b\u0005h\u0000\u0000\u050b\u050e"
          + "\u00038\u001c\u0000\u050c\u050e\u0003\u00c8d\u0000\u050d\u0501\u0001\u0000"
          + "\u0000\u0000\u050d\u0503\u0001\u0000\u0000\u0000\u050d\u0505\u0001\u0000"
          + "\u0000\u0000\u050d\u0506\u0001\u0000\u0000\u0000\u050d\u050a\u0001\u0000"
          + "\u0000\u0000\u050d\u050c\u0001\u0000\u0000\u0000\u050e\u00bd\u0001\u0000"
          + "\u0000\u0000\u050f\u0516\u0005T\u0000\u0000\u0510\u0516\u0005Y\u0000\u0000"
          + "\u0511\u0516\u0005^\u0000\u0000\u0512\u0516\u0005_\u0000\u0000\u0513\u0516"
          + "\u0003\u00c2a\u0000\u0514\u0516\u0003\u00c6c\u0000\u0515\u050f\u0001\u0000"
          + "\u0000\u0000\u0515\u0510\u0001\u0000\u0000\u0000\u0515\u0511\u0001\u0000"
          + "\u0000\u0000\u0515\u0512\u0001\u0000\u0000\u0000\u0515\u0513\u0001\u0000"
          + "\u0000\u0000\u0515\u0514\u0001\u0000\u0000\u0000\u0516\u00bf\u0001\u0000"
          + "\u0000\u0000\u0517\u0518\u0005T\u0000\u0000\u0518\u00c1\u0001\u0000\u0000"
          + "\u0000\u0519\u051a\u0007\u0013\u0000\u0000\u051a\u00c3\u0001\u0000\u0000"
          + "\u0000\u051b\u051c\u0005_\u0000\u0000\u051c\u00c5\u0001\u0000\u0000\u0000"
          + "\u051d\u051e\u0005=\u0000\u0000\u051e\u00c7\u0001\u0000\u0000\u0000\u051f"
          + "\u0521\u0005`\u0000\u0000\u0520\u0522\u0003\u00cae\u0000\u0521\u0520\u0001"
          + "\u0000\u0000\u0000\u0521\u0522\u0001\u0000\u0000\u0000\u0522\u0523\u0001"
          + "\u0000\u0000\u0000\u0523\u0524\u0005a\u0000\u0000\u0524\u00c9\u0001\u0000"
          + "\u0000\u0000\u0525\u052a\u0003\u008cF\u0000\u0526\u0527\u0005g\u0000\u0000"
          + "\u0527\u0529\u0003\u008cF\u0000\u0528\u0526\u0001\u0000\u0000\u0000\u0529"
          + "\u052c\u0001\u0000\u0000\u0000\u052a\u0528\u0001\u0000\u0000\u0000\u052a"
          + "\u052b\u0001\u0000\u0000\u0000\u052b\u00cb\u0001\u0000\u0000\u0000\u052c"
          + "\u052a\u0001\u0000\u0000\u0000\u052d\u052e\u0005<\u0000\u0000\u052e\u052f"
          + "\u0003\u0084B\u0000\u052f\u0530\u0003\u00ceg\u0000\u0530\u053e\u0001\u0000"
          + "\u0000\u0000\u0531\u0532\u0005<\u0000\u0000\u0532\u0534\u0003|>\u0000"
          + "\u0533\u0535\u0003~?\u0000\u0534\u0533\u0001\u0000\u0000\u0000\u0534\u0535"
          + "\u0001\u0000\u0000\u0000\u0535\u053b\u0001\u0000\u0000\u0000\u0536\u053c"
          + "\u0003\u00ceg\u0000\u0537\u0539\u0003\u00c8d\u0000\u0538\u053a\u0003V"
          + "+\u0000\u0539\u0538\u0001\u0000\u0000\u0000\u0539\u053a\u0001\u0000\u0000"
          + "\u0000\u053a\u053c\u0001\u0000\u0000\u0000\u053b\u0536\u0001\u0000\u0000"
          + "\u0000\u053b\u0537\u0001\u0000\u0000\u0000\u053c\u053e\u0001\u0000\u0000"
          + "\u0000\u053d\u052d\u0001\u0000\u0000\u0000\u053d\u0531\u0001\u0000\u0000"
          + "\u0000\u053e\u00cd\u0001\u0000\u0000\u0000\u053f\u0540\u0005d\u0000\u0000"
          + "\u0540\u0541\u0003\u008cF\u0000\u0541\u0542\u0005e\u0000\u0000\u0542\u0544"
          + "\u0001\u0000\u0000\u0000\u0543\u053f\u0001\u0000\u0000\u0000\u0544\u0545"
          + "\u0001\u0000\u0000\u0000\u0545\u0543\u0001\u0000\u0000\u0000\u0545\u0546"
          + "\u0001\u0000\u0000\u0000\u0546\u054b\u0001\u0000\u0000\u0000\u0547\u0548"
          + "\u0005d\u0000\u0000\u0548\u054a\u0005e\u0000\u0000\u0549\u0547\u0001\u0000"
          + "\u0000\u0000\u054a\u054d\u0001\u0000\u0000\u0000\u054b\u0549\u0001\u0000"
          + "\u0000\u0000\u054b\u054c\u0001\u0000\u0000\u0000\u054c\u0556\u0001\u0000"
          + "\u0000\u0000\u054d\u054b\u0001\u0000\u0000\u0000\u054e\u054f\u0005d\u0000"
          + "\u0000\u054f\u0551\u0005e\u0000\u0000\u0550\u054e\u0001\u0000\u0000\u0000"
          + "\u0551\u0552\u0001\u0000\u0000\u0000\u0552\u0550\u0001\u0000\u0000\u0000"
          + "\u0552\u0553\u0001\u0000\u0000\u0000\u0553\u0554\u0001\u0000\u0000\u0000"
          + "\u0554\u0556\u0003b1\u0000\u0555\u0543\u0001\u0000\u0000\u0000\u0555\u0550"
          + "\u0001\u0000\u0000\u0000\u0556\u00cf\u0001\u0000\u0000\u0000\u0557\u056a"
          + "\u0003\u00d4j\u0000\u0558\u056a\u0003\u00d2i\u0000\u0559\u056a\u0003\u00d6"
          + "k\u0000\u055a\u056a\u0003\u00dcn\u0000\u055b\u055c\u0003\u00deo\u0000"
          + "\u055c\u055d\u0005f\u0000\u0000\u055d\u056a\u0001\u0000\u0000\u0000\u055e"
          + "\u056a\u0003\u00e0p\u0000\u055f\u056a\u0003\u00e4r\u0000\u0560\u056a\u0003"
          + "\u00e6s\u0000\u0561\u056a\u0003\u00e8t\u0000\u0562\u056a\u0003\u00eau"
          + "\u0000\u0563\u056a\u0003\u00f2y\u0000\u0564\u056a\u0003\u00f4z\u0000\u0565"
          + "\u056a\u0003\u00f6{\u0000\u0566\u056a\u0003\u00f8|\u0000\u0567\u056a\u0003"
          + "\u00fa}\u0000\u0568\u056a\u0003\u0100\u0080\u0000\u0569\u0557\u0001\u0000"
          + "\u0000\u0000\u0569\u0558\u0001\u0000\u0000\u0000\u0569\u0559\u0001\u0000"
          + "\u0000\u0000\u0569\u055a\u0001\u0000\u0000\u0000\u0569\u055b\u0001\u0000"
          + "\u0000\u0000\u0569\u055e\u0001\u0000\u0000\u0000\u0569\u055f\u0001\u0000"
          + "\u0000\u0000\u0569\u0560\u0001\u0000\u0000\u0000\u0569\u0561\u0001\u0000"
          + "\u0000\u0000\u0569\u0562\u0001\u0000\u0000\u0000\u0569\u0563\u0001\u0000"
          + "\u0000\u0000\u0569\u0564\u0001\u0000\u0000\u0000\u0569\u0565\u0001\u0000"
          + "\u0000\u0000\u0569\u0566\u0001\u0000\u0000\u0000\u0569\u0567\u0001\u0000"
          + "\u0000\u0000\u0569\u0568\u0001\u0000\u0000\u0000\u056a\u00d1\u0001\u0000"
          + "\u0000\u0000\u056b\u056c\u0005\u001e\u0000\u0000\u056c\u056f\u0003\u008c"
          + "F\u0000\u056d\u056e\u0005n\u0000\u0000\u056e\u0570\u0003\u008cF\u0000"
          + "\u056f\u056d\u0001\u0000\u0000\u0000\u056f\u0570\u0001\u0000\u0000\u0000"
          + "\u0570\u0571\u0001\u0000\u0000\u0000\u0571\u0572\u0005f\u0000\u0000\u0572"
          + "\u00d3\u0001\u0000\u0000\u0000\u0573\u0574\u00038\u001c\u0000\u0574\u0575"
          + "\u0005n\u0000\u0000\u0575\u0576\u0003\u00d0h\u0000\u0576\u00d5\u0001\u0000"
          + "\u0000\u0000\u0577\u057b\u0005b\u0000\u0000\u0578\u057a\u0003\u00d8l\u0000"
          + "\u0579\u0578\u0001\u0000\u0000\u0000\u057a\u057d\u0001\u0000\u0000\u0000"
          + "\u057b\u0579\u0001\u0000\u0000\u0000\u057b\u057c\u0001\u0000\u0000\u0000"
          + "\u057c\u057e\u0001\u0000\u0000\u0000\u057d\u057b\u0001\u0000\u0000\u0000"
          + "\u057e\u057f\u0005c\u0000\u0000\u057f\u00d7\u0001\u0000\u0000\u0000\u0580"
          + "\u0581\u0003\u00dam\u0000\u0581\u0582\u0005f\u0000\u0000\u0582\u0586\u0001"
          + "\u0000\u0000\u0000\u0583\u0586\u0003\u00d0h\u0000\u0584\u0586\u0003D\""
          + "\u0000\u0585\u0580\u0001\u0000\u0000\u0000\u0585\u0583\u0001\u0000\u0000"
          + "\u0000\u0585\u0584\u0001\u0000\u0000\u0000\u0586\u00d9\u0001\u0000\u0000"
          + "\u0000\u0587\u0588\u0003@ \u0000\u0588\u0589\u0003r9\u0000\u0589\u058e"
          + "\u0003\\.\u0000\u058a\u058b\u0005g\u0000\u0000\u058b\u058d\u0003\\.\u0000"
          + "\u058c\u058a\u0001\u0000\u0000\u0000\u058d\u0590\u0001\u0000\u0000\u0000"
          + "\u058e\u058c\u0001\u0000\u0000\u0000\u058e\u058f\u0001\u0000\u0000\u0000"
          + "\u058f\u00db\u0001\u0000\u0000\u0000\u0590\u058e\u0001\u0000\u0000\u0000"
          + "\u0591\u0592\u0005f\u0000\u0000\u0592\u00dd\u0001\u0000\u0000\u0000\u0593"
          + "\u059e\u0003\u00aaU\u0000\u0594\u059e\u0003\u00acV\u0000\u0595\u059b\u0003"
          + "\u00b6[\u0000\u0596\u059c\u0005v\u0000\u0000\u0597\u059c\u0005w\u0000"
          + "\u0000\u0598\u0599\u0003\u008eG\u0000\u0599\u059a\u0003\u008cF\u0000\u059a"
          + "\u059c\u0001\u0000\u0000\u0000\u059b\u0596\u0001\u0000\u0000\u0000\u059b"
          + "\u0597\u0001\u0000\u0000\u0000\u059b\u0598\u0001\u0000\u0000\u0000\u059b"
          + "\u059c\u0001\u0000\u0000\u0000\u059c\u059e\u0001\u0000\u0000\u0000\u059d"
          + "\u0593\u0001\u0000\u0000\u0000\u059d\u0594\u0001\u0000\u0000\u0000\u059d"
          + "\u0595\u0001\u0000\u0000\u0000\u059e\u00df\u0001\u0000\u0000\u0000\u059f"
          + "\u05a0\u0005G\u0000\u0000\u05a0\u05a1\u0005`\u0000\u0000\u05a1\u05a2\u0003"
          + "\u008cF\u0000\u05a2\u05a3\u0005a\u0000\u0000\u05a3\u05ad\u0005b\u0000"
          + "\u0000\u05a4\u05a8\u0003\u00e2q\u0000\u05a5\u05a7\u0003\u00d8l\u0000\u05a6"
          + "\u05a5\u0001\u0000\u0000\u0000\u05a7\u05aa\u0001\u0000\u0000\u0000\u05a8"
          + "\u05a6\u0001\u0000\u0000\u0000\u05a8\u05a9\u0001\u0000\u0000\u0000\u05a9"
          + "\u05ac\u0001\u0000\u0000\u0000\u05aa\u05a8\u0001\u0000\u0000\u0000\u05ab"
          + "\u05a4\u0001\u0000\u0000\u0000\u05ac\u05af\u0001\u0000\u0000\u0000\u05ad"
          + "\u05ab\u0001\u0000\u0000\u0000\u05ad\u05ae\u0001\u0000\u0000\u0000\u05ae"
          + "\u05b0\u0001\u0000\u0000\u0000\u05af\u05ad\u0001\u0000\u0000\u0000\u05b0"
          + "\u05b1\u0005c\u0000\u0000\u05b1\u00e1\u0001\u0000\u0000\u0000\u05b2\u05b3"
          + "\u0005\"\u0000\u0000\u05b3\u05b4\u0003\u008cF\u0000\u05b4\u05b5\u0005"
          + "n\u0000\u0000\u05b5\u05b9\u0001\u0000\u0000\u0000\u05b6\u05b7\u0005(\u0000"
          + "\u0000\u05b7\u05b9\u0005n\u0000\u0000\u05b8\u05b2\u0001\u0000\u0000\u0000"
          + "\u05b8\u05b6\u0001\u0000\u0000\u0000\u05b9\u00e3\u0001\u0000\u0000\u0000"
          + "\u05ba\u05bb\u00054\u0000\u0000\u05bb\u05bc\u0005`\u0000\u0000\u05bc\u05bd"
          + "\u0003\u008cF\u0000\u05bd\u05be\u0005a\u0000\u0000\u05be\u05c1\u0003\u00d0"
          + "h\u0000\u05bf\u05c0\u0005+\u0000\u0000\u05c0\u05c2\u0003\u00d0h\u0000"
          + "\u05c1\u05bf\u0001\u0000\u0000\u0000\u05c1\u05c2\u0001\u0000\u0000\u0000"
          + "\u05c2\u00e5\u0001\u0000\u0000\u0000\u05c3\u05c4\u0005Q\u0000\u0000\u05c4"
          + "\u05c5\u0005`\u0000\u0000\u05c5\u05c6\u0003\u008cF\u0000\u05c6\u05c7\u0005"
          + "a\u0000\u0000\u05c7\u05c8\u0003\u00d0h\u0000\u05c8\u00e7\u0001\u0000\u0000"
          + "\u0000\u05c9\u05ca\u0005)\u0000\u0000\u05ca\u05cb\u0003\u00d0h\u0000\u05cb"
          + "\u05cc\u0005Q\u0000\u0000\u05cc\u05cd\u0005`\u0000\u0000\u05cd\u05ce\u0003"
          + "\u008cF\u0000\u05ce\u05cf\u0005a\u0000\u0000\u05cf\u05d0\u0005f\u0000"
          + "\u0000\u05d0\u00e9\u0001\u0000\u0000\u0000\u05d1\u05d2\u00052\u0000\u0000"
          + "\u05d2\u05e4\u0005`\u0000\u0000\u05d3\u05d4\u0003@ \u0000\u05d4\u05d5"
          + "\u0003r9\u0000\u05d5\u05d6\u00038\u001c\u0000\u05d6\u05d7\u0005n\u0000"
          + "\u0000\u05d7\u05d8\u0003\u008cF\u0000\u05d8\u05e5\u0001\u0000\u0000\u0000"
          + "\u05d9\u05db\u0003\u00ecv\u0000\u05da\u05d9\u0001\u0000\u0000\u0000\u05da"
          + "\u05db\u0001\u0000\u0000\u0000\u05db\u05dc\u0001\u0000\u0000\u0000\u05dc"
          + "\u05de\u0005f\u0000\u0000\u05dd\u05df\u0003\u008cF\u0000\u05de\u05dd\u0001"
          + "\u0000\u0000\u0000\u05de\u05df\u0001\u0000\u0000\u0000\u05df\u05e0\u0001"
          + "\u0000\u0000\u0000\u05e0\u05e2\u0005f\u0000\u0000\u05e1\u05e3\u0003\u00f0"
          + "x\u0000\u05e2\u05e1\u0001\u0000\u0000\u0000\u05e2\u05e3\u0001\u0000\u0000"
          + "\u0000\u05e3\u05e5\u0001\u0000\u0000\u0000\u05e4\u05d3\u0001\u0000\u0000"
          + "\u0000\u05e4\u05da\u0001\u0000\u0000\u0000\u05e5\u05e6\u0001\u0000\u0000"
          + "\u0000\u05e6\u05e7\u0005a\u0000\u0000\u05e7\u05e8\u0003\u00d0h\u0000\u05e8"
          + "\u00eb\u0001\u0000\u0000\u0000\u05e9\u05ec\u0003\u00dam\u0000\u05ea\u05ec"
          + "\u0003\u00eew\u0000\u05eb\u05e9\u0001\u0000\u0000\u0000\u05eb\u05ea\u0001"
          + "\u0000\u0000\u0000\u05ec\u00ed\u0001\u0000\u0000\u0000\u05ed\u05f2\u0003"
          + "\u00deo\u0000\u05ee\u05ef\u0005g\u0000\u0000\u05ef\u05f1\u0003\u00deo"
          + "\u0000\u05f0\u05ee\u0001\u0000\u0000\u0000\u05f1\u05f4\u0001\u0000\u0000"
          + "\u0000\u05f2\u05f0\u0001\u0000\u0000\u0000\u05f2\u05f3\u0001\u0000\u0000"
          + "\u0000\u05f3\u00ef\u0001\u0000\u0000\u0000\u05f4\u05f2\u0001\u0000\u0000"
          + "\u0000\u05f5\u05f6\u0003\u00eew\u0000\u05f6\u00f1\u0001\u0000\u0000\u0000"
          + "\u05f7\u05f9\u0005 \u0000\u0000\u05f8\u05fa\u00038\u001c\u0000\u05f9\u05f8"
          + "\u0001\u0000\u0000\u0000\u05f9\u05fa\u0001\u0000\u0000\u0000\u05fa\u05fb"
          + "\u0001\u0000\u0000\u0000\u05fb\u05fc\u0005f\u0000\u0000\u05fc\u00f3\u0001"
          + "\u0000\u0000\u0000\u05fd\u05ff\u0005\'\u0000\u0000\u05fe\u0600\u00038"
          + "\u001c\u0000\u05ff\u05fe\u0001\u0000\u0000\u0000\u05ff\u0600\u0001\u0000"
          + "\u0000\u0000\u0600\u0601\u0001\u0000\u0000\u0000\u0601\u0602\u0005f\u0000"
          + "\u0000\u0602\u00f5\u0001\u0000\u0000\u0000\u0603\u0605\u0005B\u0000\u0000"
          + "\u0604\u0606\u0003\u008cF\u0000\u0605\u0604\u0001\u0000\u0000\u0000\u0605"
          + "\u0606\u0001\u0000\u0000\u0000\u0606\u0607\u0001\u0000\u0000\u0000\u0607"
          + "\u0608\u0005f\u0000\u0000\u0608\u00f7\u0001\u0000\u0000\u0000\u0609\u060a"
          + "\u0005J\u0000\u0000\u060a\u060b\u0003\u008cF\u0000\u060b\u060c\u0005f"
          + "\u0000\u0000\u060c\u00f9\u0001\u0000\u0000\u0000\u060d\u060e\u0005H\u0000"
          + "\u0000\u060e\u060f\u0005`\u0000\u0000\u060f\u0610\u0003\u008cF\u0000\u0610"
          + "\u0611\u0005a\u0000\u0000\u0611\u0612\u0003\u00d6k\u0000\u0612\u00fb\u0001"
          + "\u0000\u0000\u0000\u0613\u0614\u0003r9\u0000\u0614\u0615\u0003^/\u0000"
          + "\u0615\u0616\u0005i\u0000\u0000\u0616\u0617\u0003\u008cF\u0000\u0617\u00fd"
          + "\u0001\u0000\u0000\u0000\u0618\u0619\u0003@ \u0000\u0619\u061c\u0003r"
          + "9\u0000\u061a\u061d\u0007\b\u0000\u0000\u061b\u061d\u0005\u0002\u0000"
          + "\u0000\u061c\u061a\u0001\u0000\u0000\u0000\u061c\u061b\u0001\u0000\u0000"
          + "\u0000\u061c\u061d\u0001\u0000\u0000\u0000\u061d\u0622\u0001\u0000\u0000"
          + "\u0000\u061e\u061f\u0005}\u0000\u0000\u061f\u0621\u0003r9\u0000\u0620"
          + "\u061e\u0001\u0000\u0000\u0000\u0621\u0624\u0001\u0000\u0000\u0000\u0622"
          + "\u0620\u0001\u0000\u0000\u0000\u0622\u0623\u0001\u0000\u0000\u0000\u0623"
          + "\u0625\u0001\u0000\u0000\u0000\u0624\u0622\u0001\u0000\u0000\u0000\u0625"
          + "\u0626\u0003^/\u0000\u0626\u00ff\u0001\u0000\u0000\u0000\u0627\u0636\u0005"
          + "N\u0000\u0000\u0628\u0629\u0005`\u0000\u0000\u0629\u062e\u0003\u00fc~"
          + "\u0000\u062a\u062b\u0005f\u0000\u0000\u062b\u062d\u0003\u00fc~\u0000\u062c"
          + "\u062a\u0001\u0000\u0000\u0000\u062d\u0630\u0001\u0000\u0000\u0000\u062e"
          + "\u062c\u0001\u0000\u0000\u0000\u062e\u062f\u0001\u0000\u0000\u0000\u062f"
          + "\u0632\u0001\u0000\u0000\u0000\u0630\u062e\u0001\u0000\u0000\u0000\u0631"
          + "\u0633\u0005f\u0000\u0000\u0632\u0631\u0001\u0000\u0000\u0000\u0632\u0633"
          + "\u0001\u0000\u0000\u0000\u0633\u0634\u0001\u0000\u0000\u0000\u0634\u0635"
          + "\u0005a\u0000\u0000\u0635\u0637\u0001\u0000\u0000\u0000\u0636\u0628\u0001"
          + "\u0000\u0000\u0000\u0636\u0637\u0001\u0000\u0000\u0000\u0637\u0638\u0001"
          + "\u0000\u0000\u0000\u0638\u0641\u0003\u00d6k\u0000\u0639\u063a\u0005#\u0000"
          + "\u0000\u063a\u063b\u0005`\u0000\u0000\u063b\u063c\u0003\u00fe\u007f\u0000"
          + "\u063c\u063d\u0005a\u0000\u0000\u063d\u063e\u0003\u00d6k\u0000\u063e\u0640"
          + "\u0001\u0000\u0000\u0000\u063f\u0639\u0001\u0000\u0000\u0000\u0640\u0643"
          + "\u0001\u0000\u0000\u0000\u0641\u063f\u0001\u0000\u0000\u0000\u0641\u0642"
          + "\u0001\u0000\u0000\u0000\u0642\u0646\u0001\u0000\u0000\u0000\u0643\u0641"
          + "\u0001\u0000\u0000\u0000\u0644\u0645\u00050\u0000\u0000\u0645\u0647\u0003"
          + "\u00d6k\u0000\u0646\u0644\u0001\u0000\u0000\u0000\u0646\u0647\u0001\u0000"
          + "\u0000\u0000\u0647\u0101\u0001\u0000\u0000\u0000\u0648\u064c\u0003\u0104"
          + "\u0082\u0000\u0649\u064c\u0003\u0108\u0084\u0000\u064a\u064c\u0003\u0106"
          + "\u0083\u0000\u064b\u0648\u0001\u0000\u0000\u0000\u064b\u0649\u0001\u0000"
          + "\u0000\u0000\u064b\u064a\u0001\u0000\u0000\u0000\u064c\u0103\u0001\u0000"
          + "\u0000\u0000\u064d\u064e\u0005\u0007\u0000\u0000\u064e\u064f\u0003\u0088"
          + "D\u0000\u064f\u0651\u0005`\u0000\u0000\u0650\u0652\u0003\u010a\u0085\u0000"
          + "\u0651\u0650\u0001\u0000\u0000\u0000\u0651\u0652\u0001\u0000\u0000\u0000"
          + "\u0652\u0653\u0001\u0000\u0000\u0000\u0653\u0654\u0005a\u0000\u0000\u0654"
          + "\u0105\u0001\u0000\u0000\u0000\u0655\u0656\u0005\u0007\u0000\u0000\u0656"
          + "\u0657\u0003\u0088D\u0000\u0657\u0107\u0001\u0000\u0000\u0000\u0658\u0659"
          + "\u0005\u0007\u0000\u0000\u0659\u065a\u0003\u0088D\u0000\u065a\u065b\u0005"
          + "`\u0000\u0000\u065b\u065c\u0003\u010e\u0087\u0000\u065c\u065d\u0005a\u0000"
          + "\u0000\u065d\u0109\u0001\u0000\u0000\u0000\u065e\u0663\u0003\u010c\u0086"
          + "\u0000\u065f\u0660\u0005g\u0000\u0000\u0660\u0662\u0003\u010c\u0086\u0000"
          + "\u0661\u065f\u0001\u0000\u0000\u0000\u0662\u0665\u0001\u0000\u0000\u0000"
          + "\u0663\u0661\u0001\u0000\u0000\u0000\u0663\u0664\u0001\u0000\u0000\u0000"
          + "\u0664\u010b\u0001\u0000\u0000\u0000\u0665\u0663\u0001\u0000\u0000\u0000"
          + "\u0666\u0667\u00038\u001c\u0000\u0667\u0668\u0005i\u0000\u0000\u0668\u0669"
          + "\u0003\u010e\u0087\u0000\u0669\u010d\u0001\u0000\u0000\u0000\u066a\u066e"
          + "\u0003\u0102\u0081\u0000\u066b\u066e\u0003\u0110\u0088\u0000\u066c\u066e"
          + "\u0003\u0090H\u0000\u066d\u066a\u0001\u0000\u0000\u0000\u066d\u066b\u0001"
          + "\u0000\u0000\u0000\u066d\u066c\u0001\u0000\u0000\u0000\u066e\u010f\u0001"
          + "\u0000\u0000\u0000\u066f\u0670\u0005b\u0000\u0000\u0670\u0675\u0003\u010e"
          + "\u0087\u0000\u0671\u0672\u0005g\u0000\u0000\u0672\u0674\u0003\u010e\u0087"
          + "\u0000\u0673\u0671\u0001\u0000\u0000\u0000\u0674\u0677\u0001\u0000\u0000"
          + "\u0000\u0675\u0673\u0001\u0000\u0000\u0000\u0675\u0676\u0001\u0000\u0000"
          + "\u0000\u0676\u0679\u0001\u0000\u0000\u0000\u0677\u0675\u0001\u0000\u0000"
          + "\u0000\u0678\u067a\u0005g\u0000\u0000\u0679\u0678\u0001\u0000\u0000\u0000"
          + "\u0679\u067a\u0001\u0000\u0000\u0000\u067a\u067b\u0001\u0000\u0000\u0000"
          + "\u067b\u067c\u0005c\u0000\u0000\u067c\u0111\u0001\u0000\u0000\u0000\u067d"
          + "\u067e\u0005\u0007\u0000\u0000\u067e\u067f\u00059\u0000\u0000\u067f\u0680"
          + "\u00038\u001c\u0000\u0680\u0681\u0003\u0114\u008a\u0000\u0681\u0113\u0001"
          + "\u0000\u0000\u0000\u0682\u0686\u0005b\u0000\u0000\u0683\u0685\u0003\u0116"
          + "\u008b\u0000\u0684\u0683\u0001\u0000\u0000\u0000\u0685\u0688\u0001\u0000"
          + "\u0000\u0000\u0686\u0684\u0001\u0000\u0000\u0000\u0686\u0687\u0001\u0000"
          + "\u0000\u0000\u0687\u0689\u0001\u0000\u0000\u0000\u0688\u0686\u0001\u0000"
          + "\u0000\u0000\u0689\u068a\u0005c\u0000\u0000\u068a\u0115\u0001\u0000\u0000"
          + "\u0000\u068b\u0699\u0003@ \u0000\u068c\u068d\u0003r9\u0000\u068d\u068e"
          + "\u00038\u001c\u0000\u068e\u068f\u0005`\u0000\u0000\u068f\u0691\u0005a"
          + "\u0000\u0000\u0690\u0692\u0003\u0118\u008c\u0000\u0691\u0690\u0001\u0000"
          + "\u0000\u0000\u0691\u0692\u0001\u0000\u0000\u0000\u0692\u0693\u0001\u0000"
          + "\u0000\u0000\u0693\u0694\u0005f\u0000\u0000\u0694\u069a\u0001\u0000\u0000"
          + "\u0000\u0695\u069a\u0003D\"\u0000\u0696\u069a\u0003J%\u0000\u0697\u069a"
          + "\u0003\u0112\u0089\u0000\u0698\u069a\u0003Z-\u0000\u0699\u068c\u0001\u0000"
          + "\u0000\u0000\u0699\u0695\u0001\u0000\u0000\u0000\u0699\u0696\u0001\u0000"
          + "\u0000\u0000\u0699\u0697\u0001\u0000\u0000\u0000\u0699\u0698\u0001\u0000"
          + "\u0000\u0000\u069a\u069d\u0001\u0000\u0000\u0000\u069b\u069d\u0005f\u0000"
          + "\u0000\u069c\u068b\u0001\u0000\u0000\u0000\u069c\u069b\u0001\u0000\u0000"
          + "\u0000\u069d\u0117\u0001\u0000\u0000\u0000\u069e\u069f\u0005(\u0000\u0000"
          + "\u069f\u06a0\u0003\u010e\u0087\u0000\u06a0\u0119\u0001\u0000\u0000\u0000"
          + "\u00c9\u012e\u0137\u013b\u0143\u014d\u0157\u0163\u0166\u0169\u0178\u017b"
          + "\u0188\u018b\u018e\u0197\u01a2\u01a6\u01ac\u01b5\u01bd\u01c3\u01c7\u01ce"
          + "\u01d6\u01da\u01de\u01e1\u01e4\u01e7\u01ea\u01ee\u01f1\u0206\u020c\u0211"
          + "\u0216\u021a\u0221\u0223\u0229\u022b\u0230\u0235\u0241\u0248\u024e\u0260"
          + "\u0262\u0266\u0268\u026b\u0273\u0276\u027d\u0285\u028a\u028f\u0296\u029b"
          + "\u02a0\u02a6\u02b0\u02b5\u02c5\u02c9\u02d1\u02d3\u02d8\u02db\u02de\u02e8"
          + "\u02f1\u02f7\u0301\u0304\u0307\u030d\u0310\u0317\u031a\u0322\u0329\u0331"
          + "\u0338\u0344\u0347\u034f\u0357\u035e\u0363\u036b\u036e\u0371\u0376\u037c"
          + "\u0380\u0388\u0391\u0394\u039c\u03a1\u03a7\u03ab\u03b0\u03bc\u03c2\u03c5"
          + "\u03cb\u03d2\u03d5\u03dd\u03e0\u03e9\u03f0\u03f7\u03fb\u0400\u0404\u040c"
          + "\u0410\u0413\u041a\u041c\u0422\u0428\u042b\u042f\u0431\u0438\u0440\u0447"
          + "\u0451\u0458\u0460\u0468\u0470\u0478\u0480\u0486\u048d\u0494\u0499\u04a1"
          + "\u04a9\u04b1\u04bd\u04d1\u04d3\u04d7\u04e3\u04e9\u04ff\u050d\u0515\u0521"
          + "\u052a\u0534\u0539\u053b\u053d\u0545\u054b\u0552\u0555\u0569\u056f\u057b"
          + "\u0585\u058e\u059b\u059d\u05a8\u05ad\u05b8\u05c1\u05da\u05de\u05e2\u05e4"
          + "\u05eb\u05f2\u05f9\u05ff\u0605\u061c\u0622\u062e\u0632\u0636\u0641\u0646"
          + "\u064b\u0651\u0663\u066d\u0675\u0679\u0686\u0691\u0699\u069c";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
