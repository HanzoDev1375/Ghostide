// Generated from /storage/emulated/0/apk/iconz/sources/JavaScriptParserJsx.g4 by ANTLR 4.13.1
package io.github.rosemoe.sora.langs.jsx;

import org.antlr.v4.runtime.FailedPredicateException;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class JavaScriptParserJsx extends JavaScriptParserBaseJsx {
  static {
    RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION);
  }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
  public static final int HashBangLine = 1,
      JsxElementBegin = 2,
      OpenBracket = 3,
      CloseBracket = 4,
      OpenParen = 5,
      CloseParen = 6,
      OpenBrace = 7,
      CloseBrace = 8,
      SemiColon = 9,
      Comma = 10,
      Assign = 11,
      QuestionMark = 12,
      Colon = 13,
      Ellipsis = 14,
      Dot = 15,
      PlusPlus = 16,
      MinusMinus = 17,
      Plus = 18,
      Minus = 19,
      BitNot = 20,
      Not = 21,
      Multiply = 22,
      Divide = 23,
      Modulus = 24,
      Power = 25,
      NullCoalesce = 26,
      Hashtag = 27,
      RightShiftArithmetic = 28,
      LeftShiftArithmetic = 29,
      RightShiftLogical = 30,
      LessThan = 31,
      MoreThan = 32,
      LessThanEquals = 33,
      GreaterThanEquals = 34,
      Equals_ = 35,
      NotEquals = 36,
      IdentityEquals = 37,
      IdentityNotEquals = 38,
      BitAnd = 39,
      BitXOr = 40,
      BitOr = 41,
      And = 42,
      Or = 43,
      MultiplyAssign = 44,
      DivideAssign = 45,
      ModulusAssign = 46,
      PlusAssign = 47,
      MinusAssign = 48,
      LeftShiftArithmeticAssign = 49,
      RightShiftArithmeticAssign = 50,
      RightShiftLogicalAssign = 51,
      BitAndAssign = 52,
      BitXorAssign = 53,
      BitOrAssign = 54,
      PowerAssign = 55,
      ARROW = 56,
      NullLiteral = 57,
      BooleanLiteral = 58,
      DecimalLiteral = 59,
      HexIntegerLiteral = 60,
      OctalIntegerLiteral = 61,
      OctalIntegerLiteral2 = 62,
      BinaryIntegerLiteral = 63,
      BigHexIntegerLiteral = 64,
      BigOctalIntegerLiteral = 65,
      BigBinaryIntegerLiteral = 66,
      BigDecimalIntegerLiteral = 67,
      Break = 68,
      Do = 69,
      Instanceof = 70,
      Typeof = 71,
      Case = 72,
      Else = 73,
      New = 74,
      Var = 75,
      Catch = 76,
      Finally = 77,
      Return = 78,
      Void = 79,
      Continue = 80,
      For = 81,
      Switch = 82,
      While = 83,
      Debugger = 84,
      Function_ = 85,
      This = 86,
      With = 87,
      Default = 88,
      If = 89,
      Throw = 90,
      Delete = 91,
      In = 92,
      Try = 93,
      As = 94,
      From = 95,
      YieldStar = 96,
      Class = 97,
      Enum = 98,
      Extends = 99,
      Super = 100,
      Const = 101,
      Export = 102,
      Import = 103,
      Async = 104,
      Await = 105,
      Implements = 106,
      StrictLet = 107,
      NonStrictLet = 108,
      Private = 109,
      Public = 110,
      Interface = 111,
      Package = 112,
      Protected = 113,
      Static = 114,
      Yield = 115,
      Identifier = 116,
      StringLiteral = 117,
      LinkLiteral = 118,
      BackTick = 119,
      WhiteSpaces = 120,
      LineTerminator = 121,
      JsxComment = 122,
      MultiLineComment = 123,
      SingleLineComment = 124,
      RegularExpressionLiteral = 125,
      HtmlComment = 126,
      CDataComment = 127,
      UnexpectedCharacter = 128,
      CDATA = 129,
      TemplateStringStartExpression = 130,
      TemplateStringAtom = 131,
      JsxOpeningElementBegin = 132,
      JsxOpeningElementEnd = 133,
      JsxOpeningElementSlashEnd = 134,
      JsxAssign = 135,
      JsxOpeningElementOpenBrace = 136,
      JsxOpeningElementId = 137,
      JsxOpeningElementWhiteSpaces = 138,
      JsxOpeningElementLineTerminator = 139,
      JsxOpeningElementMultiLineComment = 140,
      JsxOpeningElementSingleLineComment = 141,
      JsxAttributeValue = 142,
      HtmlChardata = 143,
      JsxChildrenOpeningElementBegin = 144,
      JsxChildrenClosingElementSlashBegin = 145,
      JsxChildrenOpenBrace = 146,
      JsxClosingElementEnd = 147,
      JsxClosingElementId = 148,
      JsxClosingElementLineTerminator = 149,
      JsxClosingElementWhiteSpaces = 150;
  public static final int RULE_program = 0,
      RULE_sourceElement = 1,
      RULE_statement = 2,
      RULE_block = 3,
      RULE_statementList = 4,
      RULE_importStatement = 5,
      RULE_importFromBlock = 6,
      RULE_moduleItems = 7,
      RULE_importDefault = 8,
      RULE_importNamespace = 9,
      RULE_importFrom = 10,
      RULE_aliasName = 11,
      RULE_exportStatement = 12,
      RULE_exportFromBlock = 13,
      RULE_declaration = 14,
      RULE_variableStatement = 15,
      RULE_variableDeclarationList = 16,
      RULE_variableDeclaration = 17,
      RULE_emptyStatement_ = 18,
      RULE_expressionStatement = 19,
      RULE_ifStatement = 20,
      RULE_iterationStatement = 21,
      RULE_varModifier = 22,
      RULE_continueStatement = 23,
      RULE_breakStatement = 24,
      RULE_returnStatement = 25,
      RULE_yieldStatement = 26,
      RULE_withStatement = 27,
      RULE_switchStatement = 28,
      RULE_caseBlock = 29,
      RULE_caseClauses = 30,
      RULE_caseClause = 31,
      RULE_defaultClause = 32,
      RULE_labelledStatement = 33,
      RULE_throwStatement = 34,
      RULE_tryStatement = 35,
      RULE_catchProduction = 36,
      RULE_finallyProduction = 37,
      RULE_debuggerStatement = 38,
      RULE_functionDeclaration = 39,
      RULE_classDeclaration = 40,
      RULE_classTail = 41,
      RULE_classElement = 42,
      RULE_methodDefinition = 43,
      RULE_formalParameterList = 44,
      RULE_formalParameterArg = 45,
      RULE_lastFormalParameterArg = 46,
      RULE_functionBody = 47,
      RULE_sourceElements = 48,
      RULE_arrayLiteral = 49,
      RULE_elementList = 50,
      RULE_arrayElement = 51,
      RULE_propertyAssignment = 52,
      RULE_propertyName = 53,
      RULE_arguments = 54,
      RULE_argument = 55,
      RULE_expressionSequence = 56,
      RULE_singleExpression = 57,
      RULE_jsxElements = 58,
      RULE_jsxElementBegin = 59,
      RULE_jsxElement = 60,
      RULE_jsxSelfClosingElement = 61,
      RULE_jsxOpeningElement = 62,
      RULE_jsxClosingElement = 63,
      RULE_jsxChildren = 64,
      RULE_jsxSelfClosingElementName = 65,
      RULE_jsxOpeningElementName = 66,
      RULE_jsxClosingElementName = 67,
      RULE_jsxAttributes = 68,
      RULE_jsxSpreadAttribute = 69,
      RULE_jsxAttribute = 70,
      RULE_jsxAttributeName = 71,
      RULE_jsxAttributeValue = 72,
      RULE_assignable = 73,
      RULE_objectLiteral = 74,
      RULE_openBrace = 75,
      RULE_objectExpressionSequence = 76,
      RULE_anoymousFunction = 77,
      RULE_arrowFunctionParameters = 78,
      RULE_arrowFunctionBody = 79,
      RULE_assignmentOperator = 80,
      RULE_literal = 81,
      RULE_templateStringLiteral = 82,
      RULE_templateStringAtom = 83,
      RULE_numericLiteral = 84,
      RULE_bigintLiteral = 85,
      RULE_getter = 86,
      RULE_setter = 87,
      RULE_identifierName = 88,
      RULE_identifier = 89,
      RULE_reservedWord = 90,
      RULE_keyword = 91,
      RULE_let_ = 92,
      RULE_eos = 93;

  private static String[] makeRuleNames() {
    return new String[] {
      "program",
      "sourceElement",
      "statement",
      "block",
      "statementList",
      "importStatement",
      "importFromBlock",
      "moduleItems",
      "importDefault",
      "importNamespace",
      "importFrom",
      "aliasName",
      "exportStatement",
      "exportFromBlock",
      "declaration",
      "variableStatement",
      "variableDeclarationList",
      "variableDeclaration",
      "emptyStatement_",
      "expressionStatement",
      "ifStatement",
      "iterationStatement",
      "varModifier",
      "continueStatement",
      "breakStatement",
      "returnStatement",
      "yieldStatement",
      "withStatement",
      "switchStatement",
      "caseBlock",
      "caseClauses",
      "caseClause",
      "defaultClause",
      "labelledStatement",
      "throwStatement",
      "tryStatement",
      "catchProduction",
      "finallyProduction",
      "debuggerStatement",
      "functionDeclaration",
      "classDeclaration",
      "classTail",
      "classElement",
      "methodDefinition",
      "formalParameterList",
      "formalParameterArg",
      "lastFormalParameterArg",
      "functionBody",
      "sourceElements",
      "arrayLiteral",
      "elementList",
      "arrayElement",
      "propertyAssignment",
      "propertyName",
      "arguments",
      "argument",
      "expressionSequence",
      "singleExpression",
      "jsxElements",
      "jsxElementBegin",
      "jsxElement",
      "jsxSelfClosingElement",
      "jsxOpeningElement",
      "jsxClosingElement",
      "jsxChildren",
      "jsxSelfClosingElementName",
      "jsxOpeningElementName",
      "jsxClosingElementName",
      "jsxAttributes",
      "jsxSpreadAttribute",
      "jsxAttribute",
      "jsxAttributeName",
      "jsxAttributeValue",
      "assignable",
      "objectLiteral",
      "openBrace",
      "objectExpressionSequence",
      "anoymousFunction",
      "arrowFunctionParameters",
      "arrowFunctionBody",
      "assignmentOperator",
      "literal",
      "templateStringLiteral",
      "templateStringAtom",
      "numericLiteral",
      "bigintLiteral",
      "getter",
      "setter",
      "identifierName",
      "identifier",
      "reservedWord",
      "keyword",
      "let_",
      "eos"
    };
  }

  public static final String[] ruleNames = makeRuleNames();

  private static String[] makeLiteralNames() {
    return new String[] {
      null,
      null,
      null,
      "'['",
      "']'",
      "'('",
      "')'",
      null,
      null,
      "';'",
      "','",
      null,
      "'?'",
      "':'",
      "'...'",
      "'.'",
      "'++'",
      "'--'",
      "'+'",
      "'-'",
      "'~'",
      "'!'",
      "'*'",
      "'/'",
      "'%'",
      "'**'",
      "'??'",
      "'#'",
      "'>>'",
      "'<<'",
      "'>>>'",
      null,
      null,
      "'<='",
      "'>='",
      "'=='",
      "'!='",
      "'==='",
      "'!=='",
      "'&'",
      "'^'",
      "'|'",
      "'&&'",
      "'||'",
      "'*='",
      "'/='",
      "'%='",
      "'+='",
      "'-='",
      "'<<='",
      "'>>='",
      "'>>>='",
      "'&='",
      "'^='",
      "'|='",
      "'**='",
      "'=>'",
      "'null'",
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
      "'break'",
      "'do'",
      "'instanceof'",
      "'typeof'",
      "'case'",
      "'else'",
      "'new'",
      "'var'",
      "'catch'",
      "'finally'",
      "'return'",
      "'void'",
      "'continue'",
      "'for'",
      "'switch'",
      "'while'",
      "'debugger'",
      "'function'",
      "'this'",
      "'with'",
      "'default'",
      "'if'",
      "'throw'",
      "'delete'",
      "'in'",
      "'try'",
      "'as'",
      "'from'",
      "'yield*'",
      "'class'",
      "'enum'",
      "'extends'",
      "'super'",
      "'const'",
      "'export'",
      "'import'",
      "'async'",
      "'await'",
      "'implements'",
      null,
      null,
      "'private'",
      "'public'",
      "'interface'",
      "'package'",
      "'protected'",
      "'static'",
      "'yield'",
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
      null,
      null,
      "'${'",
      null,
      null,
      null,
      "'/>'",
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
      "'</'"
    };
  }

  private static final String[] _LITERAL_NAMES = makeLiteralNames();

  private static String[] makeSymbolicNames() {
    return new String[] {
      null,
      "HashBangLine",
      "JsxElementBegin",
      "OpenBracket",
      "CloseBracket",
      "OpenParen",
      "CloseParen",
      "OpenBrace",
      "CloseBrace",
      "SemiColon",
      "Comma",
      "Assign",
      "QuestionMark",
      "Colon",
      "Ellipsis",
      "Dot",
      "PlusPlus",
      "MinusMinus",
      "Plus",
      "Minus",
      "BitNot",
      "Not",
      "Multiply",
      "Divide",
      "Modulus",
      "Power",
      "NullCoalesce",
      "Hashtag",
      "RightShiftArithmetic",
      "LeftShiftArithmetic",
      "RightShiftLogical",
      "LessThan",
      "MoreThan",
      "LessThanEquals",
      "GreaterThanEquals",
      "Equals_",
      "NotEquals",
      "IdentityEquals",
      "IdentityNotEquals",
      "BitAnd",
      "BitXOr",
      "BitOr",
      "And",
      "Or",
      "MultiplyAssign",
      "DivideAssign",
      "ModulusAssign",
      "PlusAssign",
      "MinusAssign",
      "LeftShiftArithmeticAssign",
      "RightShiftArithmeticAssign",
      "RightShiftLogicalAssign",
      "BitAndAssign",
      "BitXorAssign",
      "BitOrAssign",
      "PowerAssign",
      "ARROW",
      "NullLiteral",
      "BooleanLiteral",
      "DecimalLiteral",
      "HexIntegerLiteral",
      "OctalIntegerLiteral",
      "OctalIntegerLiteral2",
      "BinaryIntegerLiteral",
      "BigHexIntegerLiteral",
      "BigOctalIntegerLiteral",
      "BigBinaryIntegerLiteral",
      "BigDecimalIntegerLiteral",
      "Break",
      "Do",
      "Instanceof",
      "Typeof",
      "Case",
      "Else",
      "New",
      "Var",
      "Catch",
      "Finally",
      "Return",
      "Void",
      "Continue",
      "For",
      "Switch",
      "While",
      "Debugger",
      "Function_",
      "This",
      "With",
      "Default",
      "If",
      "Throw",
      "Delete",
      "In",
      "Try",
      "As",
      "From",
      "YieldStar",
      "Class",
      "Enum",
      "Extends",
      "Super",
      "Const",
      "Export",
      "Import",
      "Async",
      "Await",
      "Implements",
      "StrictLet",
      "NonStrictLet",
      "Private",
      "Public",
      "Interface",
      "Package",
      "Protected",
      "Static",
      "Yield",
      "Identifier",
      "StringLiteral",
      "LinkLiteral",
      "BackTick",
      "WhiteSpaces",
      "LineTerminator",
      "JsxComment",
      "MultiLineComment",
      "SingleLineComment",
      "RegularExpressionLiteral",
      "HtmlComment",
      "CDataComment",
      "UnexpectedCharacter",
      "CDATA",
      "TemplateStringStartExpression",
      "TemplateStringAtom",
      "JsxOpeningElementBegin",
      "JsxOpeningElementEnd",
      "JsxOpeningElementSlashEnd",
      "JsxAssign",
      "JsxOpeningElementOpenBrace",
      "JsxOpeningElementId",
      "JsxOpeningElementWhiteSpaces",
      "JsxOpeningElementLineTerminator",
      "JsxOpeningElementMultiLineComment",
      "JsxOpeningElementSingleLineComment",
      "JsxAttributeValue",
      "HtmlChardata",
      "JsxChildrenOpeningElementBegin",
      "JsxChildrenClosingElementSlashBegin",
      "JsxChildrenOpenBrace",
      "JsxClosingElementEnd",
      "JsxClosingElementId",
      "JsxClosingElementLineTerminator",
      "JsxClosingElementWhiteSpaces"
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
    return "JavaScriptParserJsx.g4";
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

  public JavaScriptParserJsx(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ProgramContext extends ParserRuleContext {
    public TerminalNode EOF() {
      return getToken(JavaScriptParserJsx.EOF, 0);
    }

    public TerminalNode HashBangLine() {
      return getToken(JavaScriptParserJsx.HashBangLine, 0);
    }

    public SourceElementsContext sourceElements() {
      return getRuleContext(SourceElementsContext.class, 0);
    }

    public ProgramContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_program;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterProgram(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitProgram(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitProgram(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ProgramContext program() throws RecognitionException {
    ProgramContext _localctx = new ProgramContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_program);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(189);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 0, _ctx)) {
          case 1:
            {
              setState(188);
              match(HashBangLine);
            }
            break;
        }
        setState(192);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 1, _ctx)) {
          case 1:
            {
              setState(191);
              sourceElements();
            }
            break;
        }
        setState(194);
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
  public static class SourceElementContext extends ParserRuleContext {
    public StatementContext statement() {
      return getRuleContext(StatementContext.class, 0);
    }

    public SourceElementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_sourceElement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterSourceElement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitSourceElement(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitSourceElement(this);
      else return visitor.visitChildren(this);
    }
  }

  public final SourceElementContext sourceElement() throws RecognitionException {
    SourceElementContext _localctx = new SourceElementContext(_ctx, getState());
    enterRule(_localctx, 2, RULE_sourceElement);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(196);
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
  public static class StatementContext extends ParserRuleContext {
    public BlockContext block() {
      return getRuleContext(BlockContext.class, 0);
    }

    public VariableStatementContext variableStatement() {
      return getRuleContext(VariableStatementContext.class, 0);
    }

    public ImportStatementContext importStatement() {
      return getRuleContext(ImportStatementContext.class, 0);
    }

    public ExportStatementContext exportStatement() {
      return getRuleContext(ExportStatementContext.class, 0);
    }

    public EmptyStatement_Context emptyStatement_() {
      return getRuleContext(EmptyStatement_Context.class, 0);
    }

    public ClassDeclarationContext classDeclaration() {
      return getRuleContext(ClassDeclarationContext.class, 0);
    }

    public ExpressionStatementContext expressionStatement() {
      return getRuleContext(ExpressionStatementContext.class, 0);
    }

    public IfStatementContext ifStatement() {
      return getRuleContext(IfStatementContext.class, 0);
    }

    public IterationStatementContext iterationStatement() {
      return getRuleContext(IterationStatementContext.class, 0);
    }

    public ContinueStatementContext continueStatement() {
      return getRuleContext(ContinueStatementContext.class, 0);
    }

    public BreakStatementContext breakStatement() {
      return getRuleContext(BreakStatementContext.class, 0);
    }

    public ReturnStatementContext returnStatement() {
      return getRuleContext(ReturnStatementContext.class, 0);
    }

    public YieldStatementContext yieldStatement() {
      return getRuleContext(YieldStatementContext.class, 0);
    }

    public WithStatementContext withStatement() {
      return getRuleContext(WithStatementContext.class, 0);
    }

    public LabelledStatementContext labelledStatement() {
      return getRuleContext(LabelledStatementContext.class, 0);
    }

    public SwitchStatementContext switchStatement() {
      return getRuleContext(SwitchStatementContext.class, 0);
    }

    public ThrowStatementContext throwStatement() {
      return getRuleContext(ThrowStatementContext.class, 0);
    }

    public TryStatementContext tryStatement() {
      return getRuleContext(TryStatementContext.class, 0);
    }

    public DebuggerStatementContext debuggerStatement() {
      return getRuleContext(DebuggerStatementContext.class, 0);
    }

    public FunctionDeclarationContext functionDeclaration() {
      return getRuleContext(FunctionDeclarationContext.class, 0);
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
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitStatement(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitStatement(this);
      else return visitor.visitChildren(this);
    }
  }

  public final StatementContext statement() throws RecognitionException {
    StatementContext _localctx = new StatementContext(_ctx, getState());
    enterRule(_localctx, 4, RULE_statement);
    try {
      setState(218);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(198);
            block();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(199);
            variableStatement();
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(200);
            importStatement();
          }
          break;
        case 4:
          enterOuterAlt(_localctx, 4);
          {
            setState(201);
            exportStatement();
          }
          break;
        case 5:
          enterOuterAlt(_localctx, 5);
          {
            setState(202);
            emptyStatement_();
          }
          break;
        case 6:
          enterOuterAlt(_localctx, 6);
          {
            setState(203);
            classDeclaration();
          }
          break;
        case 7:
          enterOuterAlt(_localctx, 7);
          {
            setState(204);
            expressionStatement();
          }
          break;
        case 8:
          enterOuterAlt(_localctx, 8);
          {
            setState(205);
            ifStatement();
          }
          break;
        case 9:
          enterOuterAlt(_localctx, 9);
          {
            setState(206);
            iterationStatement();
          }
          break;
        case 10:
          enterOuterAlt(_localctx, 10);
          {
            setState(207);
            continueStatement();
          }
          break;
        case 11:
          enterOuterAlt(_localctx, 11);
          {
            setState(208);
            breakStatement();
          }
          break;
        case 12:
          enterOuterAlt(_localctx, 12);
          {
            setState(209);
            returnStatement();
          }
          break;
        case 13:
          enterOuterAlt(_localctx, 13);
          {
            setState(210);
            yieldStatement();
          }
          break;
        case 14:
          enterOuterAlt(_localctx, 14);
          {
            setState(211);
            withStatement();
          }
          break;
        case 15:
          enterOuterAlt(_localctx, 15);
          {
            setState(212);
            labelledStatement();
          }
          break;
        case 16:
          enterOuterAlt(_localctx, 16);
          {
            setState(213);
            switchStatement();
          }
          break;
        case 17:
          enterOuterAlt(_localctx, 17);
          {
            setState(214);
            throwStatement();
          }
          break;
        case 18:
          enterOuterAlt(_localctx, 18);
          {
            setState(215);
            tryStatement();
          }
          break;
        case 19:
          enterOuterAlt(_localctx, 19);
          {
            setState(216);
            debuggerStatement();
          }
          break;
        case 20:
          enterOuterAlt(_localctx, 20);
          {
            setState(217);
            functionDeclaration();
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
  public static class BlockContext extends ParserRuleContext {
    public TerminalNode OpenBrace() {
      return getToken(JavaScriptParserJsx.OpenBrace, 0);
    }

    public TerminalNode CloseBrace() {
      return getToken(JavaScriptParserJsx.CloseBrace, 0);
    }

    public StatementListContext statementList() {
      return getRuleContext(StatementListContext.class, 0);
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
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterBlock(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitBlock(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitBlock(this);
      else return visitor.visitChildren(this);
    }
  }

  public final BlockContext block() throws RecognitionException {
    BlockContext _localctx = new BlockContext(_ctx, getState());
    enterRule(_localctx, 6, RULE_block);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(220);
        match(OpenBrace);
        setState(222);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 3, _ctx)) {
          case 1:
            {
              setState(221);
              statementList();
            }
            break;
        }
        setState(224);
        match(CloseBrace);
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
  public static class StatementListContext extends ParserRuleContext {
    public List<StatementContext> statement() {
      return getRuleContexts(StatementContext.class);
    }

    public StatementContext statement(int i) {
      return getRuleContext(StatementContext.class, i);
    }

    public StatementListContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_statementList;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterStatementList(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitStatementList(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitStatementList(this);
      else return visitor.visitChildren(this);
    }
  }

  public final StatementListContext statementList() throws RecognitionException {
    StatementListContext _localctx = new StatementListContext(_ctx, getState());
    enterRule(_localctx, 8, RULE_statementList);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(227);
        _errHandler.sync(this);
        _alt = 1;
        do {
          switch (_alt) {
            case 1:
              {
                {
                  setState(226);
                  statement();
                }
              }
              break;
            default:
              throw new NoViableAltException(this);
          }
          setState(229);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 4, _ctx);
        } while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER);
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
  public static class ImportStatementContext extends ParserRuleContext {
    public TerminalNode Import() {
      return getToken(JavaScriptParserJsx.Import, 0);
    }

    public ImportFromBlockContext importFromBlock() {
      return getRuleContext(ImportFromBlockContext.class, 0);
    }

    public ImportStatementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_importStatement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterImportStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitImportStatement(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitImportStatement(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ImportStatementContext importStatement() throws RecognitionException {
    ImportStatementContext _localctx = new ImportStatementContext(_ctx, getState());
    enterRule(_localctx, 10, RULE_importStatement);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(231);
        match(Import);
        setState(232);
        importFromBlock();
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
  public static class ImportFromBlockContext extends ParserRuleContext {
    public ImportFromContext importFrom() {
      return getRuleContext(ImportFromContext.class, 0);
    }

    public EosContext eos() {
      return getRuleContext(EosContext.class, 0);
    }

    public ImportNamespaceContext importNamespace() {
      return getRuleContext(ImportNamespaceContext.class, 0);
    }

    public ModuleItemsContext moduleItems() {
      return getRuleContext(ModuleItemsContext.class, 0);
    }

    public ImportDefaultContext importDefault() {
      return getRuleContext(ImportDefaultContext.class, 0);
    }

    public TerminalNode StringLiteral() {
      return getToken(JavaScriptParserJsx.StringLiteral, 0);
    }

    public ImportFromBlockContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_importFromBlock;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterImportFromBlock(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitImportFromBlock(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitImportFromBlock(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ImportFromBlockContext importFromBlock() throws RecognitionException {
    ImportFromBlockContext _localctx = new ImportFromBlockContext(_ctx, getState());
    enterRule(_localctx, 12, RULE_importFromBlock);
    try {
      setState(246);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case OpenBrace:
        case Multiply:
        case NullLiteral:
        case BooleanLiteral:
        case Break:
        case Do:
        case Instanceof:
        case Typeof:
        case Case:
        case Else:
        case New:
        case Var:
        case Catch:
        case Finally:
        case Return:
        case Void:
        case Continue:
        case For:
        case Switch:
        case While:
        case Debugger:
        case Function_:
        case This:
        case With:
        case Default:
        case If:
        case Throw:
        case Delete:
        case In:
        case Try:
        case As:
        case From:
        case Class:
        case Enum:
        case Extends:
        case Super:
        case Const:
        case Export:
        case Import:
        case Async:
        case Await:
        case Implements:
        case StrictLet:
        case NonStrictLet:
        case Private:
        case Public:
        case Interface:
        case Package:
        case Protected:
        case Static:
        case Yield:
        case Identifier:
          enterOuterAlt(_localctx, 1);
          {
            setState(235);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 5, _ctx)) {
              case 1:
                {
                  setState(234);
                  importDefault();
                }
                break;
            }
            setState(239);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
              case Multiply:
              case NullLiteral:
              case BooleanLiteral:
              case Break:
              case Do:
              case Instanceof:
              case Typeof:
              case Case:
              case Else:
              case New:
              case Var:
              case Catch:
              case Finally:
              case Return:
              case Void:
              case Continue:
              case For:
              case Switch:
              case While:
              case Debugger:
              case Function_:
              case This:
              case With:
              case Default:
              case If:
              case Throw:
              case Delete:
              case In:
              case Try:
              case As:
              case From:
              case Class:
              case Enum:
              case Extends:
              case Super:
              case Const:
              case Export:
              case Import:
              case Async:
              case Await:
              case Implements:
              case StrictLet:
              case NonStrictLet:
              case Private:
              case Public:
              case Interface:
              case Package:
              case Protected:
              case Static:
              case Yield:
              case Identifier:
                {
                  setState(237);
                  importNamespace();
                }
                break;
              case OpenBrace:
                {
                  setState(238);
                  moduleItems();
                }
                break;
              default:
                throw new NoViableAltException(this);
            }
            setState(241);
            importFrom();
            setState(242);
            eos();
          }
          break;
        case StringLiteral:
          enterOuterAlt(_localctx, 2);
          {
            setState(244);
            match(StringLiteral);
            setState(245);
            eos();
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
  public static class ModuleItemsContext extends ParserRuleContext {
    public TerminalNode OpenBrace() {
      return getToken(JavaScriptParserJsx.OpenBrace, 0);
    }

    public TerminalNode CloseBrace() {
      return getToken(JavaScriptParserJsx.CloseBrace, 0);
    }

    public List<AliasNameContext> aliasName() {
      return getRuleContexts(AliasNameContext.class);
    }

    public AliasNameContext aliasName(int i) {
      return getRuleContext(AliasNameContext.class, i);
    }

    public List<TerminalNode> Comma() {
      return getTokens(JavaScriptParserJsx.Comma);
    }

    public TerminalNode Comma(int i) {
      return getToken(JavaScriptParserJsx.Comma, i);
    }

    public ModuleItemsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_moduleItems;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterModuleItems(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitModuleItems(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitModuleItems(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ModuleItemsContext moduleItems() throws RecognitionException {
    ModuleItemsContext _localctx = new ModuleItemsContext(_ctx, getState());
    enterRule(_localctx, 14, RULE_moduleItems);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(248);
        match(OpenBrace);
        setState(254);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 8, _ctx);
        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            {
              {
                setState(249);
                aliasName();
                setState(250);
                match(Comma);
              }
            }
          }
          setState(256);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 8, _ctx);
        }
        setState(261);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (((((_la - 57)) & ~0x3f) == 0 && ((1L << (_la - 57)) & 1152920954851031043L) != 0)) {
          {
            setState(257);
            aliasName();
            setState(259);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == Comma) {
              {
                setState(258);
                match(Comma);
              }
            }
          }
        }

        setState(263);
        match(CloseBrace);
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
  public static class ImportDefaultContext extends ParserRuleContext {
    public AliasNameContext aliasName() {
      return getRuleContext(AliasNameContext.class, 0);
    }

    public TerminalNode Comma() {
      return getToken(JavaScriptParserJsx.Comma, 0);
    }

    public ImportDefaultContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_importDefault;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterImportDefault(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitImportDefault(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitImportDefault(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ImportDefaultContext importDefault() throws RecognitionException {
    ImportDefaultContext _localctx = new ImportDefaultContext(_ctx, getState());
    enterRule(_localctx, 16, RULE_importDefault);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(265);
        aliasName();
        setState(266);
        match(Comma);
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
  public static class ImportNamespaceContext extends ParserRuleContext {
    public TerminalNode Multiply() {
      return getToken(JavaScriptParserJsx.Multiply, 0);
    }

    public List<IdentifierNameContext> identifierName() {
      return getRuleContexts(IdentifierNameContext.class);
    }

    public IdentifierNameContext identifierName(int i) {
      return getRuleContext(IdentifierNameContext.class, i);
    }

    public TerminalNode As() {
      return getToken(JavaScriptParserJsx.As, 0);
    }

    public ImportNamespaceContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_importNamespace;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterImportNamespace(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitImportNamespace(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitImportNamespace(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ImportNamespaceContext importNamespace() throws RecognitionException {
    ImportNamespaceContext _localctx = new ImportNamespaceContext(_ctx, getState());
    enterRule(_localctx, 18, RULE_importNamespace);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(270);
        _errHandler.sync(this);
        switch (_input.LA(1)) {
          case Multiply:
            {
              setState(268);
              match(Multiply);
            }
            break;
          case NullLiteral:
          case BooleanLiteral:
          case Break:
          case Do:
          case Instanceof:
          case Typeof:
          case Case:
          case Else:
          case New:
          case Var:
          case Catch:
          case Finally:
          case Return:
          case Void:
          case Continue:
          case For:
          case Switch:
          case While:
          case Debugger:
          case Function_:
          case This:
          case With:
          case Default:
          case If:
          case Throw:
          case Delete:
          case In:
          case Try:
          case As:
          case From:
          case Class:
          case Enum:
          case Extends:
          case Super:
          case Const:
          case Export:
          case Import:
          case Async:
          case Await:
          case Implements:
          case StrictLet:
          case NonStrictLet:
          case Private:
          case Public:
          case Interface:
          case Package:
          case Protected:
          case Static:
          case Yield:
          case Identifier:
            {
              setState(269);
              identifierName();
            }
            break;
          default:
            throw new NoViableAltException(this);
        }
        setState(274);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == As) {
          {
            setState(272);
            match(As);
            setState(273);
            identifierName();
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
  public static class ImportFromContext extends ParserRuleContext {
    public TerminalNode From() {
      return getToken(JavaScriptParserJsx.From, 0);
    }

    public TerminalNode StringLiteral() {
      return getToken(JavaScriptParserJsx.StringLiteral, 0);
    }

    public ImportFromContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_importFrom;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterImportFrom(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitImportFrom(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitImportFrom(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ImportFromContext importFrom() throws RecognitionException {
    ImportFromContext _localctx = new ImportFromContext(_ctx, getState());
    enterRule(_localctx, 20, RULE_importFrom);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(276);
        match(From);
        setState(277);
        match(StringLiteral);
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
  public static class AliasNameContext extends ParserRuleContext {
    public List<IdentifierNameContext> identifierName() {
      return getRuleContexts(IdentifierNameContext.class);
    }

    public IdentifierNameContext identifierName(int i) {
      return getRuleContext(IdentifierNameContext.class, i);
    }

    public TerminalNode As() {
      return getToken(JavaScriptParserJsx.As, 0);
    }

    public AliasNameContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_aliasName;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterAliasName(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitAliasName(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitAliasName(this);
      else return visitor.visitChildren(this);
    }
  }

  public final AliasNameContext aliasName() throws RecognitionException {
    AliasNameContext _localctx = new AliasNameContext(_ctx, getState());
    enterRule(_localctx, 22, RULE_aliasName);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(279);
        identifierName();
        setState(282);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == As) {
          {
            setState(280);
            match(As);
            setState(281);
            identifierName();
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
  public static class ExportStatementContext extends ParserRuleContext {
    public ExportStatementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_exportStatement;
    }

    public ExportStatementContext() {}

    public void copyFrom(ExportStatementContext ctx) {
      super.copyFrom(ctx);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ExportDefaultDeclarationContext extends ExportStatementContext {
    public TerminalNode Export() {
      return getToken(JavaScriptParserJsx.Export, 0);
    }

    public TerminalNode Default() {
      return getToken(JavaScriptParserJsx.Default, 0);
    }

    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public EosContext eos() {
      return getRuleContext(EosContext.class, 0);
    }

    public ExportDefaultDeclarationContext(ExportStatementContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterExportDefaultDeclaration(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitExportDefaultDeclaration(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor)
            .visitExportDefaultDeclaration(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ExportDeclarationContext extends ExportStatementContext {
    public TerminalNode Export() {
      return getToken(JavaScriptParserJsx.Export, 0);
    }

    public EosContext eos() {
      return getRuleContext(EosContext.class, 0);
    }

    public ExportFromBlockContext exportFromBlock() {
      return getRuleContext(ExportFromBlockContext.class, 0);
    }

    public DeclarationContext declaration() {
      return getRuleContext(DeclarationContext.class, 0);
    }

    public ExportDeclarationContext(ExportStatementContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterExportDeclaration(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitExportDeclaration(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitExportDeclaration(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ExportStatementContext exportStatement() throws RecognitionException {
    ExportStatementContext _localctx = new ExportStatementContext(_ctx, getState());
    enterRule(_localctx, 24, RULE_exportStatement);
    try {
      setState(296);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 15, _ctx)) {
        case 1:
          _localctx = new ExportDeclarationContext(_localctx);
          enterOuterAlt(_localctx, 1);
          {
            setState(284);
            match(Export);
            setState(287);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 14, _ctx)) {
              case 1:
                {
                  setState(285);
                  exportFromBlock();
                }
                break;
              case 2:
                {
                  setState(286);
                  declaration();
                }
                break;
            }
            setState(289);
            eos();
          }
          break;
        case 2:
          _localctx = new ExportDefaultDeclarationContext(_localctx);
          enterOuterAlt(_localctx, 2);
          {
            setState(291);
            match(Export);
            setState(292);
            match(Default);
            setState(293);
            singleExpression(0);
            setState(294);
            eos();
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
  public static class ExportFromBlockContext extends ParserRuleContext {
    public ImportNamespaceContext importNamespace() {
      return getRuleContext(ImportNamespaceContext.class, 0);
    }

    public ImportFromContext importFrom() {
      return getRuleContext(ImportFromContext.class, 0);
    }

    public EosContext eos() {
      return getRuleContext(EosContext.class, 0);
    }

    public ModuleItemsContext moduleItems() {
      return getRuleContext(ModuleItemsContext.class, 0);
    }

    public ExportFromBlockContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_exportFromBlock;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterExportFromBlock(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitExportFromBlock(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitExportFromBlock(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ExportFromBlockContext exportFromBlock() throws RecognitionException {
    ExportFromBlockContext _localctx = new ExportFromBlockContext(_ctx, getState());
    enterRule(_localctx, 26, RULE_exportFromBlock);
    try {
      setState(308);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case Multiply:
        case NullLiteral:
        case BooleanLiteral:
        case Break:
        case Do:
        case Instanceof:
        case Typeof:
        case Case:
        case Else:
        case New:
        case Var:
        case Catch:
        case Finally:
        case Return:
        case Void:
        case Continue:
        case For:
        case Switch:
        case While:
        case Debugger:
        case Function_:
        case This:
        case With:
        case Default:
        case If:
        case Throw:
        case Delete:
        case In:
        case Try:
        case As:
        case From:
        case Class:
        case Enum:
        case Extends:
        case Super:
        case Const:
        case Export:
        case Import:
        case Async:
        case Await:
        case Implements:
        case StrictLet:
        case NonStrictLet:
        case Private:
        case Public:
        case Interface:
        case Package:
        case Protected:
        case Static:
        case Yield:
        case Identifier:
          enterOuterAlt(_localctx, 1);
          {
            setState(298);
            importNamespace();
            setState(299);
            importFrom();
            setState(300);
            eos();
          }
          break;
        case OpenBrace:
          enterOuterAlt(_localctx, 2);
          {
            setState(302);
            moduleItems();
            setState(304);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 16, _ctx)) {
              case 1:
                {
                  setState(303);
                  importFrom();
                }
                break;
            }
            setState(306);
            eos();
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
  public static class DeclarationContext extends ParserRuleContext {
    public VariableStatementContext variableStatement() {
      return getRuleContext(VariableStatementContext.class, 0);
    }

    public ClassDeclarationContext classDeclaration() {
      return getRuleContext(ClassDeclarationContext.class, 0);
    }

    public FunctionDeclarationContext functionDeclaration() {
      return getRuleContext(FunctionDeclarationContext.class, 0);
    }

    public DeclarationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_declaration;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterDeclaration(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitDeclaration(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitDeclaration(this);
      else return visitor.visitChildren(this);
    }
  }

  public final DeclarationContext declaration() throws RecognitionException {
    DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
    enterRule(_localctx, 28, RULE_declaration);
    try {
      setState(313);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case Var:
        case Const:
        case StrictLet:
        case NonStrictLet:
          enterOuterAlt(_localctx, 1);
          {
            setState(310);
            variableStatement();
          }
          break;
        case Class:
          enterOuterAlt(_localctx, 2);
          {
            setState(311);
            classDeclaration();
          }
          break;
        case Function_:
        case Async:
          enterOuterAlt(_localctx, 3);
          {
            setState(312);
            functionDeclaration();
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
  public static class VariableStatementContext extends ParserRuleContext {
    public VariableDeclarationListContext variableDeclarationList() {
      return getRuleContext(VariableDeclarationListContext.class, 0);
    }

    public EosContext eos() {
      return getRuleContext(EosContext.class, 0);
    }

    public VariableStatementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_variableStatement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterVariableStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitVariableStatement(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitVariableStatement(this);
      else return visitor.visitChildren(this);
    }
  }

  public final VariableStatementContext variableStatement() throws RecognitionException {
    VariableStatementContext _localctx = new VariableStatementContext(_ctx, getState());
    enterRule(_localctx, 30, RULE_variableStatement);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(315);
        variableDeclarationList();
        setState(316);
        eos();
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
  public static class VariableDeclarationListContext extends ParserRuleContext {
    public VarModifierContext varModifier() {
      return getRuleContext(VarModifierContext.class, 0);
    }

    public List<VariableDeclarationContext> variableDeclaration() {
      return getRuleContexts(VariableDeclarationContext.class);
    }

    public VariableDeclarationContext variableDeclaration(int i) {
      return getRuleContext(VariableDeclarationContext.class, i);
    }

    public List<TerminalNode> Comma() {
      return getTokens(JavaScriptParserJsx.Comma);
    }

    public TerminalNode Comma(int i) {
      return getToken(JavaScriptParserJsx.Comma, i);
    }

    public VariableDeclarationListContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_variableDeclarationList;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterVariableDeclarationList(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitVariableDeclarationList(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor)
            .visitVariableDeclarationList(this);
      else return visitor.visitChildren(this);
    }
  }

  public final VariableDeclarationListContext variableDeclarationList()
      throws RecognitionException {
    VariableDeclarationListContext _localctx = new VariableDeclarationListContext(_ctx, getState());
    enterRule(_localctx, 32, RULE_variableDeclarationList);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(318);
        varModifier();
        setState(319);
        variableDeclaration();
        setState(324);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 19, _ctx);
        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            {
              {
                setState(320);
                match(Comma);
                setState(321);
                variableDeclaration();
              }
            }
          }
          setState(326);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 19, _ctx);
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
  public static class VariableDeclarationContext extends ParserRuleContext {
    public AssignableContext assignable() {
      return getRuleContext(AssignableContext.class, 0);
    }

    public TerminalNode Assign() {
      return getToken(JavaScriptParserJsx.Assign, 0);
    }

    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_variableDeclaration;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterVariableDeclaration(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitVariableDeclaration(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitVariableDeclaration(this);
      else return visitor.visitChildren(this);
    }
  }

  public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
    VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
    enterRule(_localctx, 34, RULE_variableDeclaration);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(327);
        assignable();
        setState(330);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 20, _ctx)) {
          case 1:
            {
              setState(328);
              match(Assign);
              setState(329);
              singleExpression(0);
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
  public static class EmptyStatement_Context extends ParserRuleContext {
    public TerminalNode SemiColon() {
      return getToken(JavaScriptParserJsx.SemiColon, 0);
    }

    public EmptyStatement_Context(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_emptyStatement_;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterEmptyStatement_(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitEmptyStatement_(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitEmptyStatement_(this);
      else return visitor.visitChildren(this);
    }
  }

  public final EmptyStatement_Context emptyStatement_() throws RecognitionException {
    EmptyStatement_Context _localctx = new EmptyStatement_Context(_ctx, getState());
    enterRule(_localctx, 36, RULE_emptyStatement_);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(332);
        match(SemiColon);
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
  public static class ExpressionStatementContext extends ParserRuleContext {
    public ExpressionSequenceContext expressionSequence() {
      return getRuleContext(ExpressionSequenceContext.class, 0);
    }

    public EosContext eos() {
      return getRuleContext(EosContext.class, 0);
    }

    public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_expressionStatement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterExpressionStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitExpressionStatement(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitExpressionStatement(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ExpressionStatementContext expressionStatement() throws RecognitionException {
    ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
    enterRule(_localctx, 38, RULE_expressionStatement);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(334);
        if (!(this.notOpenBraceAndNotFunction()))
          throw new FailedPredicateException(this, "this.notOpenBraceAndNotFunction()");
        setState(335);
        expressionSequence();
        setState(336);
        eos();
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
    public TerminalNode If() {
      return getToken(JavaScriptParserJsx.If, 0);
    }

    public TerminalNode OpenParen() {
      return getToken(JavaScriptParserJsx.OpenParen, 0);
    }

    public ExpressionSequenceContext expressionSequence() {
      return getRuleContext(ExpressionSequenceContext.class, 0);
    }

    public TerminalNode CloseParen() {
      return getToken(JavaScriptParserJsx.CloseParen, 0);
    }

    public List<StatementContext> statement() {
      return getRuleContexts(StatementContext.class);
    }

    public StatementContext statement(int i) {
      return getRuleContext(StatementContext.class, i);
    }

    public TerminalNode Else() {
      return getToken(JavaScriptParserJsx.Else, 0);
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
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterIfStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitIfStatement(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitIfStatement(this);
      else return visitor.visitChildren(this);
    }
  }

  public final IfStatementContext ifStatement() throws RecognitionException {
    IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
    enterRule(_localctx, 40, RULE_ifStatement);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(338);
        match(If);
        setState(339);
        match(OpenParen);
        setState(340);
        expressionSequence();
        setState(341);
        match(CloseParen);
        setState(342);
        statement();
        setState(345);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 21, _ctx)) {
          case 1:
            {
              setState(343);
              match(Else);
              setState(344);
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
  public static class IterationStatementContext extends ParserRuleContext {
    public IterationStatementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_iterationStatement;
    }

    public IterationStatementContext() {}

    public void copyFrom(IterationStatementContext ctx) {
      super.copyFrom(ctx);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class DoStatementContext extends IterationStatementContext {
    public TerminalNode Do() {
      return getToken(JavaScriptParserJsx.Do, 0);
    }

    public StatementContext statement() {
      return getRuleContext(StatementContext.class, 0);
    }

    public TerminalNode While() {
      return getToken(JavaScriptParserJsx.While, 0);
    }

    public TerminalNode OpenParen() {
      return getToken(JavaScriptParserJsx.OpenParen, 0);
    }

    public ExpressionSequenceContext expressionSequence() {
      return getRuleContext(ExpressionSequenceContext.class, 0);
    }

    public TerminalNode CloseParen() {
      return getToken(JavaScriptParserJsx.CloseParen, 0);
    }

    public EosContext eos() {
      return getRuleContext(EosContext.class, 0);
    }

    public DoStatementContext(IterationStatementContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterDoStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitDoStatement(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitDoStatement(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class WhileStatementContext extends IterationStatementContext {
    public TerminalNode While() {
      return getToken(JavaScriptParserJsx.While, 0);
    }

    public TerminalNode OpenParen() {
      return getToken(JavaScriptParserJsx.OpenParen, 0);
    }

    public ExpressionSequenceContext expressionSequence() {
      return getRuleContext(ExpressionSequenceContext.class, 0);
    }

    public TerminalNode CloseParen() {
      return getToken(JavaScriptParserJsx.CloseParen, 0);
    }

    public StatementContext statement() {
      return getRuleContext(StatementContext.class, 0);
    }

    public WhileStatementContext(IterationStatementContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterWhileStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitWhileStatement(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitWhileStatement(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ForStatementContext extends IterationStatementContext {
    public TerminalNode For() {
      return getToken(JavaScriptParserJsx.For, 0);
    }

    public TerminalNode OpenParen() {
      return getToken(JavaScriptParserJsx.OpenParen, 0);
    }

    public List<TerminalNode> SemiColon() {
      return getTokens(JavaScriptParserJsx.SemiColon);
    }

    public TerminalNode SemiColon(int i) {
      return getToken(JavaScriptParserJsx.SemiColon, i);
    }

    public TerminalNode CloseParen() {
      return getToken(JavaScriptParserJsx.CloseParen, 0);
    }

    public StatementContext statement() {
      return getRuleContext(StatementContext.class, 0);
    }

    public List<ExpressionSequenceContext> expressionSequence() {
      return getRuleContexts(ExpressionSequenceContext.class);
    }

    public ExpressionSequenceContext expressionSequence(int i) {
      return getRuleContext(ExpressionSequenceContext.class, i);
    }

    public VariableDeclarationListContext variableDeclarationList() {
      return getRuleContext(VariableDeclarationListContext.class, 0);
    }

    public ForStatementContext(IterationStatementContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterForStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitForStatement(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitForStatement(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ForInStatementContext extends IterationStatementContext {
    public TerminalNode For() {
      return getToken(JavaScriptParserJsx.For, 0);
    }

    public TerminalNode OpenParen() {
      return getToken(JavaScriptParserJsx.OpenParen, 0);
    }

    public TerminalNode In() {
      return getToken(JavaScriptParserJsx.In, 0);
    }

    public ExpressionSequenceContext expressionSequence() {
      return getRuleContext(ExpressionSequenceContext.class, 0);
    }

    public TerminalNode CloseParen() {
      return getToken(JavaScriptParserJsx.CloseParen, 0);
    }

    public StatementContext statement() {
      return getRuleContext(StatementContext.class, 0);
    }

    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public VariableDeclarationListContext variableDeclarationList() {
      return getRuleContext(VariableDeclarationListContext.class, 0);
    }

    public ForInStatementContext(IterationStatementContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterForInStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitForInStatement(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitForInStatement(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ForOfStatementContext extends IterationStatementContext {
    public TerminalNode For() {
      return getToken(JavaScriptParserJsx.For, 0);
    }

    public TerminalNode OpenParen() {
      return getToken(JavaScriptParserJsx.OpenParen, 0);
    }

    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public ExpressionSequenceContext expressionSequence() {
      return getRuleContext(ExpressionSequenceContext.class, 0);
    }

    public TerminalNode CloseParen() {
      return getToken(JavaScriptParserJsx.CloseParen, 0);
    }

    public StatementContext statement() {
      return getRuleContext(StatementContext.class, 0);
    }

    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public VariableDeclarationListContext variableDeclarationList() {
      return getRuleContext(VariableDeclarationListContext.class, 0);
    }

    public TerminalNode Await() {
      return getToken(JavaScriptParserJsx.Await, 0);
    }

    public ForOfStatementContext(IterationStatementContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterForOfStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitForOfStatement(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitForOfStatement(this);
      else return visitor.visitChildren(this);
    }
  }

  public final IterationStatementContext iterationStatement() throws RecognitionException {
    IterationStatementContext _localctx = new IterationStatementContext(_ctx, getState());
    enterRule(_localctx, 42, RULE_iterationStatement);
    int _la;
    try {
      setState(403);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 28, _ctx)) {
        case 1:
          _localctx = new DoStatementContext(_localctx);
          enterOuterAlt(_localctx, 1);
          {
            setState(347);
            match(Do);
            setState(348);
            statement();
            setState(349);
            match(While);
            setState(350);
            match(OpenParen);
            setState(351);
            expressionSequence();
            setState(352);
            match(CloseParen);
            setState(353);
            eos();
          }
          break;
        case 2:
          _localctx = new WhileStatementContext(_localctx);
          enterOuterAlt(_localctx, 2);
          {
            setState(355);
            match(While);
            setState(356);
            match(OpenParen);
            setState(357);
            expressionSequence();
            setState(358);
            match(CloseParen);
            setState(359);
            statement();
          }
          break;
        case 3:
          _localctx = new ForStatementContext(_localctx);
          enterOuterAlt(_localctx, 3);
          {
            setState(361);
            match(For);
            setState(362);
            match(OpenParen);
            setState(365);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 22, _ctx)) {
              case 1:
                {
                  setState(363);
                  expressionSequence();
                }
                break;
              case 2:
                {
                  setState(364);
                  variableDeclarationList();
                }
                break;
            }
            setState(367);
            match(SemiColon);
            setState(369);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -144115188071710548L) != 0)
                || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 2357655927150118031L) != 0)
                || _la == JsxOpeningElementBegin
                || _la == JsxChildrenOpeningElementBegin) {
              {
                setState(368);
                expressionSequence();
              }
            }

            setState(371);
            match(SemiColon);
            setState(373);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -144115188071710548L) != 0)
                || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 2357655927150118031L) != 0)
                || _la == JsxOpeningElementBegin
                || _la == JsxChildrenOpeningElementBegin) {
              {
                setState(372);
                expressionSequence();
              }
            }

            setState(375);
            match(CloseParen);
            setState(376);
            statement();
          }
          break;
        case 4:
          _localctx = new ForInStatementContext(_localctx);
          enterOuterAlt(_localctx, 4);
          {
            setState(377);
            match(For);
            setState(378);
            match(OpenParen);
            setState(381);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 25, _ctx)) {
              case 1:
                {
                  setState(379);
                  singleExpression(0);
                }
                break;
              case 2:
                {
                  setState(380);
                  variableDeclarationList();
                }
                break;
            }
            setState(383);
            match(In);
            setState(384);
            expressionSequence();
            setState(385);
            match(CloseParen);
            setState(386);
            statement();
          }
          break;
        case 5:
          _localctx = new ForOfStatementContext(_localctx);
          enterOuterAlt(_localctx, 5);
          {
            setState(388);
            match(For);
            setState(390);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == Await) {
              {
                setState(389);
                match(Await);
              }
            }

            setState(392);
            match(OpenParen);
            setState(395);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 27, _ctx)) {
              case 1:
                {
                  setState(393);
                  singleExpression(0);
                }
                break;
              case 2:
                {
                  setState(394);
                  variableDeclarationList();
                }
                break;
            }
            setState(397);
            identifier();
            setState(398);
            if (!(this.p("of"))) throw new FailedPredicateException(this, "this.p(\"of\")");
            setState(399);
            expressionSequence();
            setState(400);
            match(CloseParen);
            setState(401);
            statement();
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
  public static class VarModifierContext extends ParserRuleContext {
    public TerminalNode Var() {
      return getToken(JavaScriptParserJsx.Var, 0);
    }

    public Let_Context let_() {
      return getRuleContext(Let_Context.class, 0);
    }

    public TerminalNode Const() {
      return getToken(JavaScriptParserJsx.Const, 0);
    }

    public VarModifierContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_varModifier;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterVarModifier(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitVarModifier(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitVarModifier(this);
      else return visitor.visitChildren(this);
    }
  }

  public final VarModifierContext varModifier() throws RecognitionException {
    VarModifierContext _localctx = new VarModifierContext(_ctx, getState());
    enterRule(_localctx, 44, RULE_varModifier);
    try {
      setState(408);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case Var:
          enterOuterAlt(_localctx, 1);
          {
            setState(405);
            match(Var);
          }
          break;
        case StrictLet:
        case NonStrictLet:
          enterOuterAlt(_localctx, 2);
          {
            setState(406);
            let_();
          }
          break;
        case Const:
          enterOuterAlt(_localctx, 3);
          {
            setState(407);
            match(Const);
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
  public static class ContinueStatementContext extends ParserRuleContext {
    public TerminalNode Continue() {
      return getToken(JavaScriptParserJsx.Continue, 0);
    }

    public EosContext eos() {
      return getRuleContext(EosContext.class, 0);
    }

    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
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
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterContinueStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitContinueStatement(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitContinueStatement(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ContinueStatementContext continueStatement() throws RecognitionException {
    ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
    enterRule(_localctx, 46, RULE_continueStatement);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(410);
        match(Continue);
        setState(413);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 30, _ctx)) {
          case 1:
            {
              setState(411);
              if (!(this.notLineTerminator()))
                throw new FailedPredicateException(this, "this.notLineTerminator()");
              setState(412);
              identifier();
            }
            break;
        }
        setState(415);
        eos();
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
    public TerminalNode Break() {
      return getToken(JavaScriptParserJsx.Break, 0);
    }

    public EosContext eos() {
      return getRuleContext(EosContext.class, 0);
    }

    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
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
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterBreakStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitBreakStatement(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitBreakStatement(this);
      else return visitor.visitChildren(this);
    }
  }

  public final BreakStatementContext breakStatement() throws RecognitionException {
    BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
    enterRule(_localctx, 48, RULE_breakStatement);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(417);
        match(Break);
        setState(420);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 31, _ctx)) {
          case 1:
            {
              setState(418);
              if (!(this.notLineTerminator()))
                throw new FailedPredicateException(this, "this.notLineTerminator()");
              setState(419);
              identifier();
            }
            break;
        }
        setState(422);
        eos();
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
    public TerminalNode Return() {
      return getToken(JavaScriptParserJsx.Return, 0);
    }

    public EosContext eos() {
      return getRuleContext(EosContext.class, 0);
    }

    public ExpressionSequenceContext expressionSequence() {
      return getRuleContext(ExpressionSequenceContext.class, 0);
    }

    public TerminalNode OpenParen() {
      return getToken(JavaScriptParserJsx.OpenParen, 0);
    }

    public JsxElementsContext jsxElements() {
      return getRuleContext(JsxElementsContext.class, 0);
    }

    public TerminalNode CloseParen() {
      return getToken(JavaScriptParserJsx.CloseParen, 0);
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
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterReturnStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitReturnStatement(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitReturnStatement(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ReturnStatementContext returnStatement() throws RecognitionException {
    ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
    enterRule(_localctx, 50, RULE_returnStatement);
    try {
      setState(436);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 33, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(424);
            match(Return);
            setState(427);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 32, _ctx)) {
              case 1:
                {
                  setState(425);
                  if (!(this.notLineTerminator()))
                    throw new FailedPredicateException(this, "this.notLineTerminator()");
                  setState(426);
                  expressionSequence();
                }
                break;
            }
            setState(429);
            eos();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(430);
            match(Return);
            setState(431);
            match(OpenParen);
            setState(432);
            jsxElements();
            setState(433);
            match(CloseParen);
            setState(434);
            eos();
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
  public static class YieldStatementContext extends ParserRuleContext {
    public EosContext eos() {
      return getRuleContext(EosContext.class, 0);
    }

    public TerminalNode Yield() {
      return getToken(JavaScriptParserJsx.Yield, 0);
    }

    public TerminalNode YieldStar() {
      return getToken(JavaScriptParserJsx.YieldStar, 0);
    }

    public ExpressionSequenceContext expressionSequence() {
      return getRuleContext(ExpressionSequenceContext.class, 0);
    }

    public YieldStatementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_yieldStatement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterYieldStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitYieldStatement(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitYieldStatement(this);
      else return visitor.visitChildren(this);
    }
  }

  public final YieldStatementContext yieldStatement() throws RecognitionException {
    YieldStatementContext _localctx = new YieldStatementContext(_ctx, getState());
    enterRule(_localctx, 52, RULE_yieldStatement);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(438);
        _la = _input.LA(1);
        if (!(_la == YieldStar || _la == Yield)) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF) matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
        setState(441);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 34, _ctx)) {
          case 1:
            {
              setState(439);
              if (!(this.notLineTerminator()))
                throw new FailedPredicateException(this, "this.notLineTerminator()");
              setState(440);
              expressionSequence();
            }
            break;
        }
        setState(443);
        eos();
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
  public static class WithStatementContext extends ParserRuleContext {
    public TerminalNode With() {
      return getToken(JavaScriptParserJsx.With, 0);
    }

    public TerminalNode OpenParen() {
      return getToken(JavaScriptParserJsx.OpenParen, 0);
    }

    public ExpressionSequenceContext expressionSequence() {
      return getRuleContext(ExpressionSequenceContext.class, 0);
    }

    public TerminalNode CloseParen() {
      return getToken(JavaScriptParserJsx.CloseParen, 0);
    }

    public StatementContext statement() {
      return getRuleContext(StatementContext.class, 0);
    }

    public WithStatementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_withStatement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterWithStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitWithStatement(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitWithStatement(this);
      else return visitor.visitChildren(this);
    }
  }

  public final WithStatementContext withStatement() throws RecognitionException {
    WithStatementContext _localctx = new WithStatementContext(_ctx, getState());
    enterRule(_localctx, 54, RULE_withStatement);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(445);
        match(With);
        setState(446);
        match(OpenParen);
        setState(447);
        expressionSequence();
        setState(448);
        match(CloseParen);
        setState(449);
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
  public static class SwitchStatementContext extends ParserRuleContext {
    public TerminalNode Switch() {
      return getToken(JavaScriptParserJsx.Switch, 0);
    }

    public TerminalNode OpenParen() {
      return getToken(JavaScriptParserJsx.OpenParen, 0);
    }

    public ExpressionSequenceContext expressionSequence() {
      return getRuleContext(ExpressionSequenceContext.class, 0);
    }

    public TerminalNode CloseParen() {
      return getToken(JavaScriptParserJsx.CloseParen, 0);
    }

    public CaseBlockContext caseBlock() {
      return getRuleContext(CaseBlockContext.class, 0);
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
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterSwitchStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitSwitchStatement(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitSwitchStatement(this);
      else return visitor.visitChildren(this);
    }
  }

  public final SwitchStatementContext switchStatement() throws RecognitionException {
    SwitchStatementContext _localctx = new SwitchStatementContext(_ctx, getState());
    enterRule(_localctx, 56, RULE_switchStatement);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(451);
        match(Switch);
        setState(452);
        match(OpenParen);
        setState(453);
        expressionSequence();
        setState(454);
        match(CloseParen);
        setState(455);
        caseBlock();
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
  public static class CaseBlockContext extends ParserRuleContext {
    public TerminalNode OpenBrace() {
      return getToken(JavaScriptParserJsx.OpenBrace, 0);
    }

    public TerminalNode CloseBrace() {
      return getToken(JavaScriptParserJsx.CloseBrace, 0);
    }

    public List<CaseClausesContext> caseClauses() {
      return getRuleContexts(CaseClausesContext.class);
    }

    public CaseClausesContext caseClauses(int i) {
      return getRuleContext(CaseClausesContext.class, i);
    }

    public DefaultClauseContext defaultClause() {
      return getRuleContext(DefaultClauseContext.class, 0);
    }

    public CaseBlockContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_caseBlock;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterCaseBlock(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitCaseBlock(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitCaseBlock(this);
      else return visitor.visitChildren(this);
    }
  }

  public final CaseBlockContext caseBlock() throws RecognitionException {
    CaseBlockContext _localctx = new CaseBlockContext(_ctx, getState());
    enterRule(_localctx, 58, RULE_caseBlock);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(457);
        match(OpenBrace);
        setState(459);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == Case) {
          {
            setState(458);
            caseClauses();
          }
        }

        setState(465);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == Default) {
          {
            setState(461);
            defaultClause();
            setState(463);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == Case) {
              {
                setState(462);
                caseClauses();
              }
            }
          }
        }

        setState(467);
        match(CloseBrace);
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
  public static class CaseClausesContext extends ParserRuleContext {
    public List<CaseClauseContext> caseClause() {
      return getRuleContexts(CaseClauseContext.class);
    }

    public CaseClauseContext caseClause(int i) {
      return getRuleContext(CaseClauseContext.class, i);
    }

    public CaseClausesContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_caseClauses;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterCaseClauses(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitCaseClauses(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitCaseClauses(this);
      else return visitor.visitChildren(this);
    }
  }

  public final CaseClausesContext caseClauses() throws RecognitionException {
    CaseClausesContext _localctx = new CaseClausesContext(_ctx, getState());
    enterRule(_localctx, 60, RULE_caseClauses);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(470);
        _errHandler.sync(this);
        _la = _input.LA(1);
        do {
          {
            {
              setState(469);
              caseClause();
            }
          }
          setState(472);
          _errHandler.sync(this);
          _la = _input.LA(1);
        } while (_la == Case);
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
  public static class CaseClauseContext extends ParserRuleContext {
    public TerminalNode Case() {
      return getToken(JavaScriptParserJsx.Case, 0);
    }

    public ExpressionSequenceContext expressionSequence() {
      return getRuleContext(ExpressionSequenceContext.class, 0);
    }

    public TerminalNode Colon() {
      return getToken(JavaScriptParserJsx.Colon, 0);
    }

    public StatementListContext statementList() {
      return getRuleContext(StatementListContext.class, 0);
    }

    public CaseClauseContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_caseClause;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterCaseClause(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitCaseClause(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitCaseClause(this);
      else return visitor.visitChildren(this);
    }
  }

  public final CaseClauseContext caseClause() throws RecognitionException {
    CaseClauseContext _localctx = new CaseClauseContext(_ctx, getState());
    enterRule(_localctx, 62, RULE_caseClause);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(474);
        match(Case);
        setState(475);
        expressionSequence();
        setState(476);
        match(Colon);
        setState(478);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 39, _ctx)) {
          case 1:
            {
              setState(477);
              statementList();
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
  public static class DefaultClauseContext extends ParserRuleContext {
    public TerminalNode Default() {
      return getToken(JavaScriptParserJsx.Default, 0);
    }

    public TerminalNode Colon() {
      return getToken(JavaScriptParserJsx.Colon, 0);
    }

    public StatementListContext statementList() {
      return getRuleContext(StatementListContext.class, 0);
    }

    public DefaultClauseContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_defaultClause;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterDefaultClause(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitDefaultClause(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitDefaultClause(this);
      else return visitor.visitChildren(this);
    }
  }

  public final DefaultClauseContext defaultClause() throws RecognitionException {
    DefaultClauseContext _localctx = new DefaultClauseContext(_ctx, getState());
    enterRule(_localctx, 64, RULE_defaultClause);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(480);
        match(Default);
        setState(481);
        match(Colon);
        setState(483);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 40, _ctx)) {
          case 1:
            {
              setState(482);
              statementList();
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
  public static class LabelledStatementContext extends ParserRuleContext {
    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public TerminalNode Colon() {
      return getToken(JavaScriptParserJsx.Colon, 0);
    }

    public StatementContext statement() {
      return getRuleContext(StatementContext.class, 0);
    }

    public LabelledStatementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_labelledStatement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterLabelledStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitLabelledStatement(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitLabelledStatement(this);
      else return visitor.visitChildren(this);
    }
  }

  public final LabelledStatementContext labelledStatement() throws RecognitionException {
    LabelledStatementContext _localctx = new LabelledStatementContext(_ctx, getState());
    enterRule(_localctx, 66, RULE_labelledStatement);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(485);
        identifier();
        setState(486);
        match(Colon);
        setState(487);
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
  public static class ThrowStatementContext extends ParserRuleContext {
    public TerminalNode Throw() {
      return getToken(JavaScriptParserJsx.Throw, 0);
    }

    public ExpressionSequenceContext expressionSequence() {
      return getRuleContext(ExpressionSequenceContext.class, 0);
    }

    public EosContext eos() {
      return getRuleContext(EosContext.class, 0);
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
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterThrowStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitThrowStatement(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitThrowStatement(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ThrowStatementContext throwStatement() throws RecognitionException {
    ThrowStatementContext _localctx = new ThrowStatementContext(_ctx, getState());
    enterRule(_localctx, 68, RULE_throwStatement);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(489);
        match(Throw);
        setState(490);
        if (!(this.notLineTerminator()))
          throw new FailedPredicateException(this, "this.notLineTerminator()");
        setState(491);
        expressionSequence();
        setState(492);
        eos();
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
    public TerminalNode Try() {
      return getToken(JavaScriptParserJsx.Try, 0);
    }

    public BlockContext block() {
      return getRuleContext(BlockContext.class, 0);
    }

    public CatchProductionContext catchProduction() {
      return getRuleContext(CatchProductionContext.class, 0);
    }

    public FinallyProductionContext finallyProduction() {
      return getRuleContext(FinallyProductionContext.class, 0);
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
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterTryStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitTryStatement(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitTryStatement(this);
      else return visitor.visitChildren(this);
    }
  }

  public final TryStatementContext tryStatement() throws RecognitionException {
    TryStatementContext _localctx = new TryStatementContext(_ctx, getState());
    enterRule(_localctx, 70, RULE_tryStatement);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(494);
        match(Try);
        setState(495);
        block();
        setState(501);
        _errHandler.sync(this);
        switch (_input.LA(1)) {
          case Catch:
            {
              setState(496);
              catchProduction();
              setState(498);
              _errHandler.sync(this);
              switch (getInterpreter().adaptivePredict(_input, 41, _ctx)) {
                case 1:
                  {
                    setState(497);
                    finallyProduction();
                  }
                  break;
              }
            }
            break;
          case Finally:
            {
              setState(500);
              finallyProduction();
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
  public static class CatchProductionContext extends ParserRuleContext {
    public TerminalNode Catch() {
      return getToken(JavaScriptParserJsx.Catch, 0);
    }

    public BlockContext block() {
      return getRuleContext(BlockContext.class, 0);
    }

    public TerminalNode OpenParen() {
      return getToken(JavaScriptParserJsx.OpenParen, 0);
    }

    public TerminalNode CloseParen() {
      return getToken(JavaScriptParserJsx.CloseParen, 0);
    }

    public AssignableContext assignable() {
      return getRuleContext(AssignableContext.class, 0);
    }

    public CatchProductionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_catchProduction;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterCatchProduction(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitCatchProduction(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitCatchProduction(this);
      else return visitor.visitChildren(this);
    }
  }

  public final CatchProductionContext catchProduction() throws RecognitionException {
    CatchProductionContext _localctx = new CatchProductionContext(_ctx, getState());
    enterRule(_localctx, 72, RULE_catchProduction);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(503);
        match(Catch);
        setState(509);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == OpenParen) {
          {
            setState(504);
            match(OpenParen);
            setState(506);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == OpenBracket
                || _la == OpenBrace
                || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & 4113L) != 0)) {
              {
                setState(505);
                assignable();
              }
            }

            setState(508);
            match(CloseParen);
          }
        }

        setState(511);
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
  public static class FinallyProductionContext extends ParserRuleContext {
    public TerminalNode Finally() {
      return getToken(JavaScriptParserJsx.Finally, 0);
    }

    public BlockContext block() {
      return getRuleContext(BlockContext.class, 0);
    }

    public FinallyProductionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_finallyProduction;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterFinallyProduction(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitFinallyProduction(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitFinallyProduction(this);
      else return visitor.visitChildren(this);
    }
  }

  public final FinallyProductionContext finallyProduction() throws RecognitionException {
    FinallyProductionContext _localctx = new FinallyProductionContext(_ctx, getState());
    enterRule(_localctx, 74, RULE_finallyProduction);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(513);
        match(Finally);
        setState(514);
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
  public static class DebuggerStatementContext extends ParserRuleContext {
    public TerminalNode Debugger() {
      return getToken(JavaScriptParserJsx.Debugger, 0);
    }

    public EosContext eos() {
      return getRuleContext(EosContext.class, 0);
    }

    public DebuggerStatementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_debuggerStatement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterDebuggerStatement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitDebuggerStatement(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitDebuggerStatement(this);
      else return visitor.visitChildren(this);
    }
  }

  public final DebuggerStatementContext debuggerStatement() throws RecognitionException {
    DebuggerStatementContext _localctx = new DebuggerStatementContext(_ctx, getState());
    enterRule(_localctx, 76, RULE_debuggerStatement);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(516);
        match(Debugger);
        setState(517);
        eos();
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
  public static class FunctionDeclarationContext extends ParserRuleContext {
    public TerminalNode Function_() {
      return getToken(JavaScriptParserJsx.Function_, 0);
    }

    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public TerminalNode OpenParen() {
      return getToken(JavaScriptParserJsx.OpenParen, 0);
    }

    public TerminalNode CloseParen() {
      return getToken(JavaScriptParserJsx.CloseParen, 0);
    }

    public TerminalNode OpenBrace() {
      return getToken(JavaScriptParserJsx.OpenBrace, 0);
    }

    public FunctionBodyContext functionBody() {
      return getRuleContext(FunctionBodyContext.class, 0);
    }

    public TerminalNode CloseBrace() {
      return getToken(JavaScriptParserJsx.CloseBrace, 0);
    }

    public TerminalNode Async() {
      return getToken(JavaScriptParserJsx.Async, 0);
    }

    public TerminalNode Multiply() {
      return getToken(JavaScriptParserJsx.Multiply, 0);
    }

    public FormalParameterListContext formalParameterList() {
      return getRuleContext(FormalParameterListContext.class, 0);
    }

    public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_functionDeclaration;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterFunctionDeclaration(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitFunctionDeclaration(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitFunctionDeclaration(this);
      else return visitor.visitChildren(this);
    }
  }

  public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
    FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
    enterRule(_localctx, 78, RULE_functionDeclaration);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(520);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == Async) {
          {
            setState(519);
            match(Async);
          }
        }

        setState(522);
        match(Function_);
        setState(524);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == Multiply) {
          {
            setState(523);
            match(Multiply);
          }
        }

        setState(526);
        identifier();
        setState(527);
        match(OpenParen);
        setState(529);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16520L) != 0)
            || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & 4113L) != 0)) {
          {
            setState(528);
            formalParameterList();
          }
        }

        setState(531);
        match(CloseParen);
        setState(532);
        match(OpenBrace);
        setState(533);
        functionBody();
        setState(534);
        match(CloseBrace);
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
  public static class ClassDeclarationContext extends ParserRuleContext {
    public TerminalNode Class() {
      return getToken(JavaScriptParserJsx.Class, 0);
    }

    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public ClassTailContext classTail() {
      return getRuleContext(ClassTailContext.class, 0);
    }

    public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_classDeclaration;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterClassDeclaration(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitClassDeclaration(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitClassDeclaration(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ClassDeclarationContext classDeclaration() throws RecognitionException {
    ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
    enterRule(_localctx, 80, RULE_classDeclaration);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(536);
        match(Class);
        setState(537);
        identifier();
        setState(538);
        classTail();
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
  public static class ClassTailContext extends ParserRuleContext {
    public TerminalNode OpenBrace() {
      return getToken(JavaScriptParserJsx.OpenBrace, 0);
    }

    public TerminalNode CloseBrace() {
      return getToken(JavaScriptParserJsx.CloseBrace, 0);
    }

    public TerminalNode Extends() {
      return getToken(JavaScriptParserJsx.Extends, 0);
    }

    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public List<ClassElementContext> classElement() {
      return getRuleContexts(ClassElementContext.class);
    }

    public ClassElementContext classElement(int i) {
      return getRuleContext(ClassElementContext.class, i);
    }

    public ClassTailContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_classTail;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterClassTail(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitClassTail(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitClassTail(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ClassTailContext classTail() throws RecognitionException {
    ClassTailContext _localctx = new ClassTailContext(_ctx, getState());
    enterRule(_localctx, 82, RULE_classTail);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(542);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == Extends) {
          {
            setState(540);
            match(Extends);
            setState(541);
            singleExpression(0);
          }
        }

        setState(544);
        match(OpenBrace);
        setState(548);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 49, _ctx);
        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            {
              {
                setState(545);
                classElement();
              }
            }
          }
          setState(550);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 49, _ctx);
        }
        setState(551);
        match(CloseBrace);
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
  public static class ClassElementContext extends ParserRuleContext {
    public MethodDefinitionContext methodDefinition() {
      return getRuleContext(MethodDefinitionContext.class, 0);
    }

    public AssignableContext assignable() {
      return getRuleContext(AssignableContext.class, 0);
    }

    public TerminalNode Assign() {
      return getToken(JavaScriptParserJsx.Assign, 0);
    }

    public ObjectLiteralContext objectLiteral() {
      return getRuleContext(ObjectLiteralContext.class, 0);
    }

    public TerminalNode SemiColon() {
      return getToken(JavaScriptParserJsx.SemiColon, 0);
    }

    public List<TerminalNode> Static() {
      return getTokens(JavaScriptParserJsx.Static);
    }

    public TerminalNode Static(int i) {
      return getToken(JavaScriptParserJsx.Static, i);
    }

    public List<IdentifierContext> identifier() {
      return getRuleContexts(IdentifierContext.class);
    }

    public IdentifierContext identifier(int i) {
      return getRuleContext(IdentifierContext.class, i);
    }

    public List<TerminalNode> Async() {
      return getTokens(JavaScriptParserJsx.Async);
    }

    public TerminalNode Async(int i) {
      return getToken(JavaScriptParserJsx.Async, i);
    }

    public EmptyStatement_Context emptyStatement_() {
      return getRuleContext(EmptyStatement_Context.class, 0);
    }

    public PropertyNameContext propertyName() {
      return getRuleContext(PropertyNameContext.class, 0);
    }

    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public TerminalNode Hashtag() {
      return getToken(JavaScriptParserJsx.Hashtag, 0);
    }

    public ClassElementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_classElement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterClassElement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitClassElement(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitClassElement(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ClassElementContext classElement() throws RecognitionException {
    ClassElementContext _localctx = new ClassElementContext(_ctx, getState());
    enterRule(_localctx, 84, RULE_classElement);
    int _la;
    try {
      int _alt;
      setState(578);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 54, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(559);
            _errHandler.sync(this);
            _alt = getInterpreter().adaptivePredict(_input, 51, _ctx);
            while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
              if (_alt == 1) {
                {
                  setState(557);
                  _errHandler.sync(this);
                  switch (getInterpreter().adaptivePredict(_input, 50, _ctx)) {
                    case 1:
                      {
                        setState(553);
                        match(Static);
                      }
                      break;
                    case 2:
                      {
                        setState(554);
                        if (!(this.n("static")))
                          throw new FailedPredicateException(this, "this.n(\"static\")");
                        setState(555);
                        identifier();
                      }
                      break;
                    case 3:
                      {
                        setState(556);
                        match(Async);
                      }
                      break;
                  }
                }
              }
              setState(561);
              _errHandler.sync(this);
              _alt = getInterpreter().adaptivePredict(_input, 51, _ctx);
            }
            setState(568);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 52, _ctx)) {
              case 1:
                {
                  setState(562);
                  methodDefinition();
                }
                break;
              case 2:
                {
                  setState(563);
                  assignable();
                  setState(564);
                  match(Assign);
                  setState(565);
                  objectLiteral();
                  setState(566);
                  match(SemiColon);
                }
                break;
            }
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(570);
            emptyStatement_();
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(572);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == Hashtag) {
              {
                setState(571);
                match(Hashtag);
              }
            }

            setState(574);
            propertyName();
            setState(575);
            match(Assign);
            setState(576);
            singleExpression(0);
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
  public static class MethodDefinitionContext extends ParserRuleContext {
    public PropertyNameContext propertyName() {
      return getRuleContext(PropertyNameContext.class, 0);
    }

    public TerminalNode OpenParen() {
      return getToken(JavaScriptParserJsx.OpenParen, 0);
    }

    public TerminalNode CloseParen() {
      return getToken(JavaScriptParserJsx.CloseParen, 0);
    }

    public TerminalNode OpenBrace() {
      return getToken(JavaScriptParserJsx.OpenBrace, 0);
    }

    public FunctionBodyContext functionBody() {
      return getRuleContext(FunctionBodyContext.class, 0);
    }

    public TerminalNode CloseBrace() {
      return getToken(JavaScriptParserJsx.CloseBrace, 0);
    }

    public TerminalNode Multiply() {
      return getToken(JavaScriptParserJsx.Multiply, 0);
    }

    public TerminalNode Hashtag() {
      return getToken(JavaScriptParserJsx.Hashtag, 0);
    }

    public FormalParameterListContext formalParameterList() {
      return getRuleContext(FormalParameterListContext.class, 0);
    }

    public GetterContext getter() {
      return getRuleContext(GetterContext.class, 0);
    }

    public SetterContext setter() {
      return getRuleContext(SetterContext.class, 0);
    }

    public MethodDefinitionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_methodDefinition;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterMethodDefinition(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitMethodDefinition(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitMethodDefinition(this);
      else return visitor.visitChildren(this);
    }
  }

  public final MethodDefinitionContext methodDefinition() throws RecognitionException {
    MethodDefinitionContext _localctx = new MethodDefinitionContext(_ctx, getState());
    enterRule(_localctx, 86, RULE_methodDefinition);
    int _la;
    try {
      setState(625);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 63, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(581);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == Multiply) {
              {
                setState(580);
                match(Multiply);
              }
            }

            setState(584);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == Hashtag) {
              {
                setState(583);
                match(Hashtag);
              }
            }

            setState(586);
            propertyName();
            setState(587);
            match(OpenParen);
            setState(589);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16520L) != 0)
                || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & 4113L) != 0)) {
              {
                setState(588);
                formalParameterList();
              }
            }

            setState(591);
            match(CloseParen);
            setState(592);
            match(OpenBrace);
            setState(593);
            functionBody();
            setState(594);
            match(CloseBrace);
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(597);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == Multiply) {
              {
                setState(596);
                match(Multiply);
              }
            }

            setState(600);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == Hashtag) {
              {
                setState(599);
                match(Hashtag);
              }
            }

            setState(602);
            getter();
            setState(603);
            match(OpenParen);
            setState(604);
            match(CloseParen);
            setState(605);
            match(OpenBrace);
            setState(606);
            functionBody();
            setState(607);
            match(CloseBrace);
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(610);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == Multiply) {
              {
                setState(609);
                match(Multiply);
              }
            }

            setState(613);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == Hashtag) {
              {
                setState(612);
                match(Hashtag);
              }
            }

            setState(615);
            setter();
            setState(616);
            match(OpenParen);
            setState(618);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16520L) != 0)
                || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & 4113L) != 0)) {
              {
                setState(617);
                formalParameterList();
              }
            }

            setState(620);
            match(CloseParen);
            setState(621);
            match(OpenBrace);
            setState(622);
            functionBody();
            setState(623);
            match(CloseBrace);
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
  public static class FormalParameterListContext extends ParserRuleContext {
    public List<FormalParameterArgContext> formalParameterArg() {
      return getRuleContexts(FormalParameterArgContext.class);
    }

    public FormalParameterArgContext formalParameterArg(int i) {
      return getRuleContext(FormalParameterArgContext.class, i);
    }

    public List<TerminalNode> Comma() {
      return getTokens(JavaScriptParserJsx.Comma);
    }

    public TerminalNode Comma(int i) {
      return getToken(JavaScriptParserJsx.Comma, i);
    }

    public LastFormalParameterArgContext lastFormalParameterArg() {
      return getRuleContext(LastFormalParameterArgContext.class, 0);
    }

    public FormalParameterListContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_formalParameterList;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterFormalParameterList(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitFormalParameterList(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitFormalParameterList(this);
      else return visitor.visitChildren(this);
    }
  }

  public final FormalParameterListContext formalParameterList() throws RecognitionException {
    FormalParameterListContext _localctx = new FormalParameterListContext(_ctx, getState());
    enterRule(_localctx, 88, RULE_formalParameterList);
    int _la;
    try {
      int _alt;
      setState(640);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case OpenBracket:
        case OpenBrace:
        case Async:
        case NonStrictLet:
        case Identifier:
          enterOuterAlt(_localctx, 1);
          {
            setState(627);
            formalParameterArg();
            setState(632);
            _errHandler.sync(this);
            _alt = getInterpreter().adaptivePredict(_input, 64, _ctx);
            while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
              if (_alt == 1) {
                {
                  {
                    setState(628);
                    match(Comma);
                    setState(629);
                    formalParameterArg();
                  }
                }
              }
              setState(634);
              _errHandler.sync(this);
              _alt = getInterpreter().adaptivePredict(_input, 64, _ctx);
            }
            setState(637);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == Comma) {
              {
                setState(635);
                match(Comma);
                setState(636);
                lastFormalParameterArg();
              }
            }
          }
          break;
        case Ellipsis:
          enterOuterAlt(_localctx, 2);
          {
            setState(639);
            lastFormalParameterArg();
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
  public static class FormalParameterArgContext extends ParserRuleContext {
    public AssignableContext assignable() {
      return getRuleContext(AssignableContext.class, 0);
    }

    public TerminalNode Assign() {
      return getToken(JavaScriptParserJsx.Assign, 0);
    }

    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public FormalParameterArgContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_formalParameterArg;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterFormalParameterArg(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitFormalParameterArg(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitFormalParameterArg(this);
      else return visitor.visitChildren(this);
    }
  }

  public final FormalParameterArgContext formalParameterArg() throws RecognitionException {
    FormalParameterArgContext _localctx = new FormalParameterArgContext(_ctx, getState());
    enterRule(_localctx, 90, RULE_formalParameterArg);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(642);
        assignable();
        setState(645);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == Assign) {
          {
            setState(643);
            match(Assign);
            setState(644);
            singleExpression(0);
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
  public static class LastFormalParameterArgContext extends ParserRuleContext {
    public TerminalNode Ellipsis() {
      return getToken(JavaScriptParserJsx.Ellipsis, 0);
    }

    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public LastFormalParameterArgContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_lastFormalParameterArg;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterLastFormalParameterArg(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitLastFormalParameterArg(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor)
            .visitLastFormalParameterArg(this);
      else return visitor.visitChildren(this);
    }
  }

  public final LastFormalParameterArgContext lastFormalParameterArg() throws RecognitionException {
    LastFormalParameterArgContext _localctx = new LastFormalParameterArgContext(_ctx, getState());
    enterRule(_localctx, 92, RULE_lastFormalParameterArg);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(647);
        match(Ellipsis);
        setState(648);
        singleExpression(0);
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
  public static class FunctionBodyContext extends ParserRuleContext {
    public SourceElementsContext sourceElements() {
      return getRuleContext(SourceElementsContext.class, 0);
    }

    public FunctionBodyContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_functionBody;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterFunctionBody(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitFunctionBody(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitFunctionBody(this);
      else return visitor.visitChildren(this);
    }
  }

  public final FunctionBodyContext functionBody() throws RecognitionException {
    FunctionBodyContext _localctx = new FunctionBodyContext(_ctx, getState());
    enterRule(_localctx, 94, RULE_functionBody);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(651);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 68, _ctx)) {
          case 1:
            {
              setState(650);
              sourceElements();
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
  public static class SourceElementsContext extends ParserRuleContext {
    public List<SourceElementContext> sourceElement() {
      return getRuleContexts(SourceElementContext.class);
    }

    public SourceElementContext sourceElement(int i) {
      return getRuleContext(SourceElementContext.class, i);
    }

    public SourceElementsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_sourceElements;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterSourceElements(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitSourceElements(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitSourceElements(this);
      else return visitor.visitChildren(this);
    }
  }

  public final SourceElementsContext sourceElements() throws RecognitionException {
    SourceElementsContext _localctx = new SourceElementsContext(_ctx, getState());
    enterRule(_localctx, 96, RULE_sourceElements);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(654);
        _errHandler.sync(this);
        _alt = 1;
        do {
          switch (_alt) {
            case 1:
              {
                {
                  setState(653);
                  sourceElement();
                }
              }
              break;
            default:
              throw new NoViableAltException(this);
          }
          setState(656);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 69, _ctx);
        } while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER);
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
  public static class ArrayLiteralContext extends ParserRuleContext {
    public TerminalNode OpenBracket() {
      return getToken(JavaScriptParserJsx.OpenBracket, 0);
    }

    public ElementListContext elementList() {
      return getRuleContext(ElementListContext.class, 0);
    }

    public TerminalNode CloseBracket() {
      return getToken(JavaScriptParserJsx.CloseBracket, 0);
    }

    public ArrayLiteralContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_arrayLiteral;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterArrayLiteral(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitArrayLiteral(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitArrayLiteral(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ArrayLiteralContext arrayLiteral() throws RecognitionException {
    ArrayLiteralContext _localctx = new ArrayLiteralContext(_ctx, getState());
    enterRule(_localctx, 98, RULE_arrayLiteral);
    try {
      enterOuterAlt(_localctx, 1);
      {
        {
          setState(658);
          match(OpenBracket);
          setState(659);
          elementList();
          setState(660);
          match(CloseBracket);
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
  public static class ElementListContext extends ParserRuleContext {
    public List<TerminalNode> Comma() {
      return getTokens(JavaScriptParserJsx.Comma);
    }

    public TerminalNode Comma(int i) {
      return getToken(JavaScriptParserJsx.Comma, i);
    }

    public List<ArrayElementContext> arrayElement() {
      return getRuleContexts(ArrayElementContext.class);
    }

    public ArrayElementContext arrayElement(int i) {
      return getRuleContext(ArrayElementContext.class, i);
    }

    public ElementListContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_elementList;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterElementList(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitElementList(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitElementList(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ElementListContext elementList() throws RecognitionException {
    ElementListContext _localctx = new ElementListContext(_ctx, getState());
    enterRule(_localctx, 100, RULE_elementList);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(665);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 70, _ctx);
        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            {
              {
                setState(662);
                match(Comma);
              }
            }
          }
          setState(667);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 70, _ctx);
        }
        setState(669);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -144115188071710548L) != 0)
            || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 2357655927150118031L) != 0)
            || _la == JsxOpeningElementBegin
            || _la == JsxChildrenOpeningElementBegin) {
          {
            setState(668);
            arrayElement();
          }
        }

        setState(679);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 73, _ctx);
        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            {
              {
                setState(672);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                  {
                    {
                      setState(671);
                      match(Comma);
                    }
                  }
                  setState(674);
                  _errHandler.sync(this);
                  _la = _input.LA(1);
                } while (_la == Comma);
                setState(676);
                arrayElement();
              }
            }
          }
          setState(681);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 73, _ctx);
        }
        setState(685);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == Comma) {
          {
            {
              setState(682);
              match(Comma);
            }
          }
          setState(687);
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
  public static class ArrayElementContext extends ParserRuleContext {
    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public TerminalNode Ellipsis() {
      return getToken(JavaScriptParserJsx.Ellipsis, 0);
    }

    public ArrayElementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_arrayElement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterArrayElement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitArrayElement(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitArrayElement(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ArrayElementContext arrayElement() throws RecognitionException {
    ArrayElementContext _localctx = new ArrayElementContext(_ctx, getState());
    enterRule(_localctx, 102, RULE_arrayElement);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(689);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == Ellipsis) {
          {
            setState(688);
            match(Ellipsis);
          }
        }

        setState(691);
        singleExpression(0);
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
  public static class PropertyAssignmentContext extends ParserRuleContext {
    public PropertyAssignmentContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_propertyAssignment;
    }

    public PropertyAssignmentContext() {}

    public void copyFrom(PropertyAssignmentContext ctx) {
      super.copyFrom(ctx);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PropertyExpressionAssignmentContext extends PropertyAssignmentContext {
    public PropertyNameContext propertyName() {
      return getRuleContext(PropertyNameContext.class, 0);
    }

    public TerminalNode Colon() {
      return getToken(JavaScriptParserJsx.Colon, 0);
    }

    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public PropertyExpressionAssignmentContext(PropertyAssignmentContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterPropertyExpressionAssignment(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitPropertyExpressionAssignment(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor)
            .visitPropertyExpressionAssignment(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ComputedPropertyExpressionAssignmentContext
      extends PropertyAssignmentContext {
    public TerminalNode OpenBracket() {
      return getToken(JavaScriptParserJsx.OpenBracket, 0);
    }

    public List<SingleExpressionContext> singleExpression() {
      return getRuleContexts(SingleExpressionContext.class);
    }

    public SingleExpressionContext singleExpression(int i) {
      return getRuleContext(SingleExpressionContext.class, i);
    }

    public TerminalNode CloseBracket() {
      return getToken(JavaScriptParserJsx.CloseBracket, 0);
    }

    public TerminalNode Colon() {
      return getToken(JavaScriptParserJsx.Colon, 0);
    }

    public ComputedPropertyExpressionAssignmentContext(PropertyAssignmentContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterComputedPropertyExpressionAssignment(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitComputedPropertyExpressionAssignment(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor)
            .visitComputedPropertyExpressionAssignment(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PropertyShorthandContext extends PropertyAssignmentContext {
    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public TerminalNode Ellipsis() {
      return getToken(JavaScriptParserJsx.Ellipsis, 0);
    }

    public PropertyShorthandContext(PropertyAssignmentContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterPropertyShorthand(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitPropertyShorthand(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitPropertyShorthand(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PropertySetterContext extends PropertyAssignmentContext {
    public SetterContext setter() {
      return getRuleContext(SetterContext.class, 0);
    }

    public TerminalNode OpenParen() {
      return getToken(JavaScriptParserJsx.OpenParen, 0);
    }

    public FormalParameterArgContext formalParameterArg() {
      return getRuleContext(FormalParameterArgContext.class, 0);
    }

    public TerminalNode CloseParen() {
      return getToken(JavaScriptParserJsx.CloseParen, 0);
    }

    public TerminalNode OpenBrace() {
      return getToken(JavaScriptParserJsx.OpenBrace, 0);
    }

    public FunctionBodyContext functionBody() {
      return getRuleContext(FunctionBodyContext.class, 0);
    }

    public TerminalNode CloseBrace() {
      return getToken(JavaScriptParserJsx.CloseBrace, 0);
    }

    public PropertySetterContext(PropertyAssignmentContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterPropertySetter(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitPropertySetter(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitPropertySetter(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PropertyGetterContext extends PropertyAssignmentContext {
    public GetterContext getter() {
      return getRuleContext(GetterContext.class, 0);
    }

    public TerminalNode OpenParen() {
      return getToken(JavaScriptParserJsx.OpenParen, 0);
    }

    public TerminalNode CloseParen() {
      return getToken(JavaScriptParserJsx.CloseParen, 0);
    }

    public TerminalNode OpenBrace() {
      return getToken(JavaScriptParserJsx.OpenBrace, 0);
    }

    public FunctionBodyContext functionBody() {
      return getRuleContext(FunctionBodyContext.class, 0);
    }

    public TerminalNode CloseBrace() {
      return getToken(JavaScriptParserJsx.CloseBrace, 0);
    }

    public PropertyGetterContext(PropertyAssignmentContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterPropertyGetter(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitPropertyGetter(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitPropertyGetter(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class FunctionPropertyContext extends PropertyAssignmentContext {
    public PropertyNameContext propertyName() {
      return getRuleContext(PropertyNameContext.class, 0);
    }

    public TerminalNode OpenParen() {
      return getToken(JavaScriptParserJsx.OpenParen, 0);
    }

    public TerminalNode CloseParen() {
      return getToken(JavaScriptParserJsx.CloseParen, 0);
    }

    public TerminalNode OpenBrace() {
      return getToken(JavaScriptParserJsx.OpenBrace, 0);
    }

    public FunctionBodyContext functionBody() {
      return getRuleContext(FunctionBodyContext.class, 0);
    }

    public TerminalNode CloseBrace() {
      return getToken(JavaScriptParserJsx.CloseBrace, 0);
    }

    public TerminalNode Async() {
      return getToken(JavaScriptParserJsx.Async, 0);
    }

    public TerminalNode Multiply() {
      return getToken(JavaScriptParserJsx.Multiply, 0);
    }

    public FormalParameterListContext formalParameterList() {
      return getRuleContext(FormalParameterListContext.class, 0);
    }

    public FunctionPropertyContext(PropertyAssignmentContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterFunctionProperty(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitFunctionProperty(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitFunctionProperty(this);
      else return visitor.visitChildren(this);
    }
  }

  public final PropertyAssignmentContext propertyAssignment() throws RecognitionException {
    PropertyAssignmentContext _localctx = new PropertyAssignmentContext(_ctx, getState());
    enterRule(_localctx, 104, RULE_propertyAssignment);
    int _la;
    try {
      setState(738);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 80, _ctx)) {
        case 1:
          _localctx = new PropertyExpressionAssignmentContext(_localctx);
          enterOuterAlt(_localctx, 1);
          {
            setState(693);
            propertyName();
            setState(694);
            match(Colon);
            setState(695);
            singleExpression(0);
          }
          break;
        case 2:
          _localctx = new ComputedPropertyExpressionAssignmentContext(_localctx);
          enterOuterAlt(_localctx, 2);
          {
            setState(697);
            match(OpenBracket);
            setState(698);
            singleExpression(0);
            setState(699);
            match(CloseBracket);
            setState(700);
            match(Colon);
            setState(701);
            singleExpression(0);
          }
          break;
        case 3:
          _localctx = new FunctionPropertyContext(_localctx);
          enterOuterAlt(_localctx, 3);
          {
            setState(704);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 76, _ctx)) {
              case 1:
                {
                  setState(703);
                  match(Async);
                }
                break;
            }
            setState(707);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == Multiply) {
              {
                setState(706);
                match(Multiply);
              }
            }

            setState(709);
            propertyName();
            setState(710);
            match(OpenParen);
            setState(712);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16520L) != 0)
                || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & 4113L) != 0)) {
              {
                setState(711);
                formalParameterList();
              }
            }

            setState(714);
            match(CloseParen);
            setState(715);
            match(OpenBrace);
            setState(716);
            functionBody();
            setState(717);
            match(CloseBrace);
          }
          break;
        case 4:
          _localctx = new PropertyGetterContext(_localctx);
          enterOuterAlt(_localctx, 4);
          {
            setState(719);
            getter();
            setState(720);
            match(OpenParen);
            setState(721);
            match(CloseParen);
            setState(722);
            match(OpenBrace);
            setState(723);
            functionBody();
            setState(724);
            match(CloseBrace);
          }
          break;
        case 5:
          _localctx = new PropertySetterContext(_localctx);
          enterOuterAlt(_localctx, 5);
          {
            setState(726);
            setter();
            setState(727);
            match(OpenParen);
            setState(728);
            formalParameterArg();
            setState(729);
            match(CloseParen);
            setState(730);
            match(OpenBrace);
            setState(731);
            functionBody();
            setState(732);
            match(CloseBrace);
          }
          break;
        case 6:
          _localctx = new PropertyShorthandContext(_localctx);
          enterOuterAlt(_localctx, 6);
          {
            setState(735);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == Ellipsis) {
              {
                setState(734);
                match(Ellipsis);
              }
            }

            setState(737);
            singleExpression(0);
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
  public static class PropertyNameContext extends ParserRuleContext {
    public IdentifierNameContext identifierName() {
      return getRuleContext(IdentifierNameContext.class, 0);
    }

    public TerminalNode StringLiteral() {
      return getToken(JavaScriptParserJsx.StringLiteral, 0);
    }

    public NumericLiteralContext numericLiteral() {
      return getRuleContext(NumericLiteralContext.class, 0);
    }

    public TerminalNode OpenBracket() {
      return getToken(JavaScriptParserJsx.OpenBracket, 0);
    }

    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public TerminalNode CloseBracket() {
      return getToken(JavaScriptParserJsx.CloseBracket, 0);
    }

    public PropertyNameContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_propertyName;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterPropertyName(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitPropertyName(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitPropertyName(this);
      else return visitor.visitChildren(this);
    }
  }

  public final PropertyNameContext propertyName() throws RecognitionException {
    PropertyNameContext _localctx = new PropertyNameContext(_ctx, getState());
    enterRule(_localctx, 106, RULE_propertyName);
    try {
      setState(747);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case NullLiteral:
        case BooleanLiteral:
        case Break:
        case Do:
        case Instanceof:
        case Typeof:
        case Case:
        case Else:
        case New:
        case Var:
        case Catch:
        case Finally:
        case Return:
        case Void:
        case Continue:
        case For:
        case Switch:
        case While:
        case Debugger:
        case Function_:
        case This:
        case With:
        case Default:
        case If:
        case Throw:
        case Delete:
        case In:
        case Try:
        case As:
        case From:
        case Class:
        case Enum:
        case Extends:
        case Super:
        case Const:
        case Export:
        case Import:
        case Async:
        case Await:
        case Implements:
        case StrictLet:
        case NonStrictLet:
        case Private:
        case Public:
        case Interface:
        case Package:
        case Protected:
        case Static:
        case Yield:
        case Identifier:
          enterOuterAlt(_localctx, 1);
          {
            setState(740);
            identifierName();
          }
          break;
        case StringLiteral:
          enterOuterAlt(_localctx, 2);
          {
            setState(741);
            match(StringLiteral);
          }
          break;
        case DecimalLiteral:
        case HexIntegerLiteral:
        case OctalIntegerLiteral:
        case OctalIntegerLiteral2:
        case BinaryIntegerLiteral:
          enterOuterAlt(_localctx, 3);
          {
            setState(742);
            numericLiteral();
          }
          break;
        case OpenBracket:
          enterOuterAlt(_localctx, 4);
          {
            setState(743);
            match(OpenBracket);
            setState(744);
            singleExpression(0);
            setState(745);
            match(CloseBracket);
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
  public static class ArgumentsContext extends ParserRuleContext {
    public TerminalNode OpenParen() {
      return getToken(JavaScriptParserJsx.OpenParen, 0);
    }

    public TerminalNode CloseParen() {
      return getToken(JavaScriptParserJsx.CloseParen, 0);
    }

    public List<ArgumentContext> argument() {
      return getRuleContexts(ArgumentContext.class);
    }

    public ArgumentContext argument(int i) {
      return getRuleContext(ArgumentContext.class, i);
    }

    public List<TerminalNode> Comma() {
      return getTokens(JavaScriptParserJsx.Comma);
    }

    public TerminalNode Comma(int i) {
      return getToken(JavaScriptParserJsx.Comma, i);
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
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterArguments(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitArguments(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitArguments(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ArgumentsContext arguments() throws RecognitionException {
    ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
    enterRule(_localctx, 108, RULE_arguments);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(749);
        match(OpenParen);
        setState(761);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -144115188071710548L) != 0)
            || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 2357655927150118031L) != 0)
            || _la == JsxOpeningElementBegin
            || _la == JsxChildrenOpeningElementBegin) {
          {
            setState(750);
            argument();
            setState(755);
            _errHandler.sync(this);
            _alt = getInterpreter().adaptivePredict(_input, 82, _ctx);
            while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
              if (_alt == 1) {
                {
                  {
                    setState(751);
                    match(Comma);
                    setState(752);
                    argument();
                  }
                }
              }
              setState(757);
              _errHandler.sync(this);
              _alt = getInterpreter().adaptivePredict(_input, 82, _ctx);
            }
            setState(759);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == Comma) {
              {
                setState(758);
                match(Comma);
              }
            }
          }
        }

        setState(763);
        match(CloseParen);
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
  public static class ArgumentContext extends ParserRuleContext {
    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public TerminalNode Ellipsis() {
      return getToken(JavaScriptParserJsx.Ellipsis, 0);
    }

    public ArgumentContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_argument;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterArgument(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitArgument(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitArgument(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ArgumentContext argument() throws RecognitionException {
    ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
    enterRule(_localctx, 110, RULE_argument);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(766);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == Ellipsis) {
          {
            setState(765);
            match(Ellipsis);
          }
        }

        setState(770);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 86, _ctx)) {
          case 1:
            {
              setState(768);
              singleExpression(0);
            }
            break;
          case 2:
            {
              setState(769);
              identifier();
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
  public static class ExpressionSequenceContext extends ParserRuleContext {
    public List<SingleExpressionContext> singleExpression() {
      return getRuleContexts(SingleExpressionContext.class);
    }

    public SingleExpressionContext singleExpression(int i) {
      return getRuleContext(SingleExpressionContext.class, i);
    }

    public List<TerminalNode> Ellipsis() {
      return getTokens(JavaScriptParserJsx.Ellipsis);
    }

    public TerminalNode Ellipsis(int i) {
      return getToken(JavaScriptParserJsx.Ellipsis, i);
    }

    public List<TerminalNode> Comma() {
      return getTokens(JavaScriptParserJsx.Comma);
    }

    public TerminalNode Comma(int i) {
      return getToken(JavaScriptParserJsx.Comma, i);
    }

    public ExpressionSequenceContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_expressionSequence;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterExpressionSequence(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitExpressionSequence(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitExpressionSequence(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ExpressionSequenceContext expressionSequence() throws RecognitionException {
    ExpressionSequenceContext _localctx = new ExpressionSequenceContext(_ctx, getState());
    enterRule(_localctx, 112, RULE_expressionSequence);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(773);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == Ellipsis) {
          {
            setState(772);
            match(Ellipsis);
          }
        }

        setState(775);
        singleExpression(0);
        setState(783);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 89, _ctx);
        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            {
              {
                setState(776);
                match(Comma);
                setState(778);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == Ellipsis) {
                  {
                    setState(777);
                    match(Ellipsis);
                  }
                }

                setState(780);
                singleExpression(0);
              }
            }
          }
          setState(785);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 89, _ctx);
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
  public static class SingleExpressionContext extends ParserRuleContext {
    public SingleExpressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_singleExpression;
    }

    public SingleExpressionContext() {}

    public void copyFrom(SingleExpressionContext ctx) {
      super.copyFrom(ctx);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class TemplateStringExpressionContext extends SingleExpressionContext {
    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public TemplateStringLiteralContext templateStringLiteral() {
      return getRuleContext(TemplateStringLiteralContext.class, 0);
    }

    public TemplateStringExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterTemplateStringExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitTemplateStringExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor)
            .visitTemplateStringExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class TernaryExpressionContext extends SingleExpressionContext {
    public List<SingleExpressionContext> singleExpression() {
      return getRuleContexts(SingleExpressionContext.class);
    }

    public SingleExpressionContext singleExpression(int i) {
      return getRuleContext(SingleExpressionContext.class, i);
    }

    public TerminalNode QuestionMark() {
      return getToken(JavaScriptParserJsx.QuestionMark, 0);
    }

    public TerminalNode Colon() {
      return getToken(JavaScriptParserJsx.Colon, 0);
    }

    public TernaryExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterTernaryExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitTernaryExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitTernaryExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class LogicalAndExpressionContext extends SingleExpressionContext {
    public List<SingleExpressionContext> singleExpression() {
      return getRuleContexts(SingleExpressionContext.class);
    }

    public SingleExpressionContext singleExpression(int i) {
      return getRuleContext(SingleExpressionContext.class, i);
    }

    public TerminalNode And() {
      return getToken(JavaScriptParserJsx.And, 0);
    }

    public LogicalAndExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterLogicalAndExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitLogicalAndExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitLogicalAndExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PowerExpressionContext extends SingleExpressionContext {
    public List<SingleExpressionContext> singleExpression() {
      return getRuleContexts(SingleExpressionContext.class);
    }

    public SingleExpressionContext singleExpression(int i) {
      return getRuleContext(SingleExpressionContext.class, i);
    }

    public TerminalNode Power() {
      return getToken(JavaScriptParserJsx.Power, 0);
    }

    public PowerExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterPowerExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitPowerExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitPowerExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PreIncrementExpressionContext extends SingleExpressionContext {
    public TerminalNode PlusPlus() {
      return getToken(JavaScriptParserJsx.PlusPlus, 0);
    }

    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public PreIncrementExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterPreIncrementExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitPreIncrementExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor)
            .visitPreIncrementExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ObjectLiteralExpressionContext extends SingleExpressionContext {
    public ObjectLiteralContext objectLiteral() {
      return getRuleContext(ObjectLiteralContext.class, 0);
    }

    public ObjectLiteralExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterObjectLiteralExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitObjectLiteralExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor)
            .visitObjectLiteralExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class MetaExpressionContext extends SingleExpressionContext {
    public TerminalNode New() {
      return getToken(JavaScriptParserJsx.New, 0);
    }

    public TerminalNode Dot() {
      return getToken(JavaScriptParserJsx.Dot, 0);
    }

    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public MetaExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterMetaExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitMetaExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitMetaExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class InExpressionContext extends SingleExpressionContext {
    public List<SingleExpressionContext> singleExpression() {
      return getRuleContexts(SingleExpressionContext.class);
    }

    public SingleExpressionContext singleExpression(int i) {
      return getRuleContext(SingleExpressionContext.class, i);
    }

    public TerminalNode In() {
      return getToken(JavaScriptParserJsx.In, 0);
    }

    public InExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterInExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitInExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitInExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class LogicalOrExpressionContext extends SingleExpressionContext {
    public List<SingleExpressionContext> singleExpression() {
      return getRuleContexts(SingleExpressionContext.class);
    }

    public SingleExpressionContext singleExpression(int i) {
      return getRuleContext(SingleExpressionContext.class, i);
    }

    public TerminalNode Or() {
      return getToken(JavaScriptParserJsx.Or, 0);
    }

    public LogicalOrExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterLogicalOrExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitLogicalOrExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitLogicalOrExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class NotExpressionContext extends SingleExpressionContext {
    public TerminalNode Not() {
      return getToken(JavaScriptParserJsx.Not, 0);
    }

    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public NotExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterNotExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitNotExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitNotExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PreDecreaseExpressionContext extends SingleExpressionContext {
    public TerminalNode MinusMinus() {
      return getToken(JavaScriptParserJsx.MinusMinus, 0);
    }

    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public PreDecreaseExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterPreDecreaseExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitPreDecreaseExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitPreDecreaseExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class JsxElementExpressionContext extends SingleExpressionContext {
    public JsxElementsContext jsxElements() {
      return getRuleContext(JsxElementsContext.class, 0);
    }

    public JsxElementExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterJsxElementExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitJsxElementExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitJsxElementExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ArgumentsExpressionContext extends SingleExpressionContext {
    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public ArgumentsContext arguments() {
      return getRuleContext(ArgumentsContext.class, 0);
    }

    public ArgumentsExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterArgumentsExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitArgumentsExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitArgumentsExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class AwaitExpressionContext extends SingleExpressionContext {
    public TerminalNode Await() {
      return getToken(JavaScriptParserJsx.Await, 0);
    }

    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public AwaitExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterAwaitExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitAwaitExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitAwaitExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ThisExpressionContext extends SingleExpressionContext {
    public TerminalNode This() {
      return getToken(JavaScriptParserJsx.This, 0);
    }

    public ThisExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterThisExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitThisExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitThisExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class FunctionExpressionContext extends SingleExpressionContext {
    public AnoymousFunctionContext anoymousFunction() {
      return getRuleContext(AnoymousFunctionContext.class, 0);
    }

    public FunctionExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterFunctionExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitFunctionExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitFunctionExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class UnaryMinusExpressionContext extends SingleExpressionContext {
    public TerminalNode Minus() {
      return getToken(JavaScriptParserJsx.Minus, 0);
    }

    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public UnaryMinusExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterUnaryMinusExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitUnaryMinusExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitUnaryMinusExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class AssignmentExpressionContext extends SingleExpressionContext {
    public List<SingleExpressionContext> singleExpression() {
      return getRuleContexts(SingleExpressionContext.class);
    }

    public SingleExpressionContext singleExpression(int i) {
      return getRuleContext(SingleExpressionContext.class, i);
    }

    public TerminalNode Assign() {
      return getToken(JavaScriptParserJsx.Assign, 0);
    }

    public AssignmentExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterAssignmentExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitAssignmentExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitAssignmentExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PostDecreaseExpressionContext extends SingleExpressionContext {
    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public TerminalNode MinusMinus() {
      return getToken(JavaScriptParserJsx.MinusMinus, 0);
    }

    public PostDecreaseExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterPostDecreaseExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitPostDecreaseExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor)
            .visitPostDecreaseExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class TypeofExpressionContext extends SingleExpressionContext {
    public TerminalNode Typeof() {
      return getToken(JavaScriptParserJsx.Typeof, 0);
    }

    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public TypeofExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterTypeofExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitTypeofExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitTypeofExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class InstanceofExpressionContext extends SingleExpressionContext {
    public List<SingleExpressionContext> singleExpression() {
      return getRuleContexts(SingleExpressionContext.class);
    }

    public SingleExpressionContext singleExpression(int i) {
      return getRuleContext(SingleExpressionContext.class, i);
    }

    public TerminalNode Instanceof() {
      return getToken(JavaScriptParserJsx.Instanceof, 0);
    }

    public InstanceofExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterInstanceofExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitInstanceofExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitInstanceofExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class UnaryPlusExpressionContext extends SingleExpressionContext {
    public TerminalNode Plus() {
      return getToken(JavaScriptParserJsx.Plus, 0);
    }

    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public UnaryPlusExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterUnaryPlusExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitUnaryPlusExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitUnaryPlusExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class DeleteExpressionContext extends SingleExpressionContext {
    public TerminalNode Delete() {
      return getToken(JavaScriptParserJsx.Delete, 0);
    }

    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public DeleteExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterDeleteExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitDeleteExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitDeleteExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ImportExpressionContext extends SingleExpressionContext {
    public TerminalNode Import() {
      return getToken(JavaScriptParserJsx.Import, 0);
    }

    public TerminalNode OpenParen() {
      return getToken(JavaScriptParserJsx.OpenParen, 0);
    }

    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public TerminalNode CloseParen() {
      return getToken(JavaScriptParserJsx.CloseParen, 0);
    }

    public ImportExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterImportExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitImportExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitImportExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class EqualityExpressionContext extends SingleExpressionContext {
    public List<SingleExpressionContext> singleExpression() {
      return getRuleContexts(SingleExpressionContext.class);
    }

    public SingleExpressionContext singleExpression(int i) {
      return getRuleContext(SingleExpressionContext.class, i);
    }

    public TerminalNode Equals_() {
      return getToken(JavaScriptParserJsx.Equals_, 0);
    }

    public TerminalNode NotEquals() {
      return getToken(JavaScriptParserJsx.NotEquals, 0);
    }

    public TerminalNode IdentityEquals() {
      return getToken(JavaScriptParserJsx.IdentityEquals, 0);
    }

    public TerminalNode IdentityNotEquals() {
      return getToken(JavaScriptParserJsx.IdentityNotEquals, 0);
    }

    public EqualityExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterEqualityExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitEqualityExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitEqualityExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class BitXOrExpressionContext extends SingleExpressionContext {
    public List<SingleExpressionContext> singleExpression() {
      return getRuleContexts(SingleExpressionContext.class);
    }

    public SingleExpressionContext singleExpression(int i) {
      return getRuleContext(SingleExpressionContext.class, i);
    }

    public TerminalNode BitXOr() {
      return getToken(JavaScriptParserJsx.BitXOr, 0);
    }

    public BitXOrExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterBitXOrExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitBitXOrExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitBitXOrExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class SuperExpressionContext extends SingleExpressionContext {
    public TerminalNode Super() {
      return getToken(JavaScriptParserJsx.Super, 0);
    }

    public SuperExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterSuperExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitSuperExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitSuperExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class MultiplicativeExpressionContext extends SingleExpressionContext {
    public List<SingleExpressionContext> singleExpression() {
      return getRuleContexts(SingleExpressionContext.class);
    }

    public SingleExpressionContext singleExpression(int i) {
      return getRuleContext(SingleExpressionContext.class, i);
    }

    public TerminalNode Multiply() {
      return getToken(JavaScriptParserJsx.Multiply, 0);
    }

    public TerminalNode Divide() {
      return getToken(JavaScriptParserJsx.Divide, 0);
    }

    public TerminalNode Modulus() {
      return getToken(JavaScriptParserJsx.Modulus, 0);
    }

    public MultiplicativeExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterMultiplicativeExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitMultiplicativeExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor)
            .visitMultiplicativeExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class BitShiftExpressionContext extends SingleExpressionContext {
    public List<SingleExpressionContext> singleExpression() {
      return getRuleContexts(SingleExpressionContext.class);
    }

    public SingleExpressionContext singleExpression(int i) {
      return getRuleContext(SingleExpressionContext.class, i);
    }

    public TerminalNode LeftShiftArithmetic() {
      return getToken(JavaScriptParserJsx.LeftShiftArithmetic, 0);
    }

    public TerminalNode RightShiftArithmetic() {
      return getToken(JavaScriptParserJsx.RightShiftArithmetic, 0);
    }

    public TerminalNode RightShiftLogical() {
      return getToken(JavaScriptParserJsx.RightShiftLogical, 0);
    }

    public BitShiftExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterBitShiftExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitBitShiftExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitBitShiftExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ParenthesizedExpressionContext extends SingleExpressionContext {
    public TerminalNode OpenParen() {
      return getToken(JavaScriptParserJsx.OpenParen, 0);
    }

    public ExpressionSequenceContext expressionSequence() {
      return getRuleContext(ExpressionSequenceContext.class, 0);
    }

    public TerminalNode CloseParen() {
      return getToken(JavaScriptParserJsx.CloseParen, 0);
    }

    public ParenthesizedExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterParenthesizedExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitParenthesizedExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor)
            .visitParenthesizedExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class AdditiveExpressionContext extends SingleExpressionContext {
    public List<SingleExpressionContext> singleExpression() {
      return getRuleContexts(SingleExpressionContext.class);
    }

    public SingleExpressionContext singleExpression(int i) {
      return getRuleContext(SingleExpressionContext.class, i);
    }

    public TerminalNode Plus() {
      return getToken(JavaScriptParserJsx.Plus, 0);
    }

    public TerminalNode Minus() {
      return getToken(JavaScriptParserJsx.Minus, 0);
    }

    public AdditiveExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterAdditiveExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitAdditiveExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitAdditiveExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class RelationalExpressionContext extends SingleExpressionContext {
    public List<SingleExpressionContext> singleExpression() {
      return getRuleContexts(SingleExpressionContext.class);
    }

    public SingleExpressionContext singleExpression(int i) {
      return getRuleContext(SingleExpressionContext.class, i);
    }

    public TerminalNode LessThan() {
      return getToken(JavaScriptParserJsx.LessThan, 0);
    }

    public TerminalNode MoreThan() {
      return getToken(JavaScriptParserJsx.MoreThan, 0);
    }

    public TerminalNode LessThanEquals() {
      return getToken(JavaScriptParserJsx.LessThanEquals, 0);
    }

    public TerminalNode GreaterThanEquals() {
      return getToken(JavaScriptParserJsx.GreaterThanEquals, 0);
    }

    public RelationalExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterRelationalExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitRelationalExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitRelationalExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PostIncrementExpressionContext extends SingleExpressionContext {
    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public TerminalNode PlusPlus() {
      return getToken(JavaScriptParserJsx.PlusPlus, 0);
    }

    public PostIncrementExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterPostIncrementExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitPostIncrementExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor)
            .visitPostIncrementExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class YieldExpressionContext extends SingleExpressionContext {
    public YieldStatementContext yieldStatement() {
      return getRuleContext(YieldStatementContext.class, 0);
    }

    public YieldExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterYieldExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitYieldExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitYieldExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class BitNotExpressionContext extends SingleExpressionContext {
    public TerminalNode BitNot() {
      return getToken(JavaScriptParserJsx.BitNot, 0);
    }

    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public BitNotExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterBitNotExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitBitNotExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitBitNotExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class NewExpressionContext extends SingleExpressionContext {
    public TerminalNode New() {
      return getToken(JavaScriptParserJsx.New, 0);
    }

    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public ArgumentsContext arguments() {
      return getRuleContext(ArgumentsContext.class, 0);
    }

    public NewExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterNewExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitNewExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitNewExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class LiteralExpressionContext extends SingleExpressionContext {
    public LiteralContext literal() {
      return getRuleContext(LiteralContext.class, 0);
    }

    public LiteralExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterLiteralExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitLiteralExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitLiteralExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ArrayLiteralExpressionContext extends SingleExpressionContext {
    public ArrayLiteralContext arrayLiteral() {
      return getRuleContext(ArrayLiteralContext.class, 0);
    }

    public ArrayLiteralExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterArrayLiteralExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitArrayLiteralExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor)
            .visitArrayLiteralExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class MemberDotExpressionContext extends SingleExpressionContext {
    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public TerminalNode Dot() {
      return getToken(JavaScriptParserJsx.Dot, 0);
    }

    public IdentifierNameContext identifierName() {
      return getRuleContext(IdentifierNameContext.class, 0);
    }

    public TerminalNode QuestionMark() {
      return getToken(JavaScriptParserJsx.QuestionMark, 0);
    }

    public TerminalNode Hashtag() {
      return getToken(JavaScriptParserJsx.Hashtag, 0);
    }

    public MemberDotExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterMemberDotExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitMemberDotExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitMemberDotExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ClassExpressionContext extends SingleExpressionContext {
    public TerminalNode Class() {
      return getToken(JavaScriptParserJsx.Class, 0);
    }

    public ClassTailContext classTail() {
      return getRuleContext(ClassTailContext.class, 0);
    }

    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public ClassExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterClassExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitClassExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitClassExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class MemberIndexExpressionContext extends SingleExpressionContext {
    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public TerminalNode OpenBracket() {
      return getToken(JavaScriptParserJsx.OpenBracket, 0);
    }

    public ExpressionSequenceContext expressionSequence() {
      return getRuleContext(ExpressionSequenceContext.class, 0);
    }

    public TerminalNode CloseBracket() {
      return getToken(JavaScriptParserJsx.CloseBracket, 0);
    }

    public MemberIndexExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterMemberIndexExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitMemberIndexExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitMemberIndexExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class IdentifierExpressionContext extends SingleExpressionContext {
    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public IdentifierExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterIdentifierExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitIdentifierExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitIdentifierExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class BitAndExpressionContext extends SingleExpressionContext {
    public List<SingleExpressionContext> singleExpression() {
      return getRuleContexts(SingleExpressionContext.class);
    }

    public SingleExpressionContext singleExpression(int i) {
      return getRuleContext(SingleExpressionContext.class, i);
    }

    public TerminalNode BitAnd() {
      return getToken(JavaScriptParserJsx.BitAnd, 0);
    }

    public BitAndExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterBitAndExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitBitAndExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitBitAndExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class BitOrExpressionContext extends SingleExpressionContext {
    public List<SingleExpressionContext> singleExpression() {
      return getRuleContexts(SingleExpressionContext.class);
    }

    public SingleExpressionContext singleExpression(int i) {
      return getRuleContext(SingleExpressionContext.class, i);
    }

    public TerminalNode BitOr() {
      return getToken(JavaScriptParserJsx.BitOr, 0);
    }

    public BitOrExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterBitOrExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitBitOrExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitBitOrExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class AssignmentOperatorExpressionContext extends SingleExpressionContext {
    public List<SingleExpressionContext> singleExpression() {
      return getRuleContexts(SingleExpressionContext.class);
    }

    public SingleExpressionContext singleExpression(int i) {
      return getRuleContext(SingleExpressionContext.class, i);
    }

    public AssignmentOperatorContext assignmentOperator() {
      return getRuleContext(AssignmentOperatorContext.class, 0);
    }

    public AssignmentOperatorExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterAssignmentOperatorExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitAssignmentOperatorExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor)
            .visitAssignmentOperatorExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class VoidExpressionContext extends SingleExpressionContext {
    public TerminalNode Void() {
      return getToken(JavaScriptParserJsx.Void, 0);
    }

    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public VoidExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterVoidExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitVoidExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitVoidExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class CoalesceExpressionContext extends SingleExpressionContext {
    public List<SingleExpressionContext> singleExpression() {
      return getRuleContexts(SingleExpressionContext.class);
    }

    public SingleExpressionContext singleExpression(int i) {
      return getRuleContext(SingleExpressionContext.class, i);
    }

    public TerminalNode NullCoalesce() {
      return getToken(JavaScriptParserJsx.NullCoalesce, 0);
    }

    public CoalesceExpressionContext(SingleExpressionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterCoalesceExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitCoalesceExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitCoalesceExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  public final SingleExpressionContext singleExpression() throws RecognitionException {
    return singleExpression(0);
  }

  private SingleExpressionContext singleExpression(int _p) throws RecognitionException {
    ParserRuleContext _parentctx = _ctx;
    int _parentState = getState();
    SingleExpressionContext _localctx = new SingleExpressionContext(_ctx, _parentState);
    SingleExpressionContext _prevctx = _localctx;
    int _startState = 114;
    enterRecursionRule(_localctx, 114, RULE_singleExpression, _p);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(839);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 91, _ctx)) {
          case 1:
            {
              _localctx = new FunctionExpressionContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;

              setState(787);
              anoymousFunction();
            }
            break;
          case 2:
            {
              _localctx = new ClassExpressionContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;
              setState(788);
              match(Class);
              setState(790);
              _errHandler.sync(this);
              _la = _input.LA(1);
              if (((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & 4113L) != 0)) {
                {
                  setState(789);
                  identifier();
                }
              }

              setState(792);
              classTail();
            }
            break;
          case 3:
            {
              _localctx = new NewExpressionContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;
              setState(793);
              match(New);
              setState(794);
              singleExpression(0);
              setState(795);
              arguments();
            }
            break;
          case 4:
            {
              _localctx = new NewExpressionContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;
              setState(797);
              match(New);
              setState(798);
              singleExpression(43);
            }
            break;
          case 5:
            {
              _localctx = new MetaExpressionContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;
              setState(799);
              match(New);
              setState(800);
              match(Dot);
              setState(801);
              identifier();
            }
            break;
          case 6:
            {
              _localctx = new DeleteExpressionContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;
              setState(802);
              match(Delete);
              setState(803);
              singleExpression(38);
            }
            break;
          case 7:
            {
              _localctx = new VoidExpressionContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;
              setState(804);
              match(Void);
              setState(805);
              singleExpression(37);
            }
            break;
          case 8:
            {
              _localctx = new TypeofExpressionContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;
              setState(806);
              match(Typeof);
              setState(807);
              singleExpression(36);
            }
            break;
          case 9:
            {
              _localctx = new PreIncrementExpressionContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;
              setState(808);
              match(PlusPlus);
              setState(809);
              singleExpression(35);
            }
            break;
          case 10:
            {
              _localctx = new PreDecreaseExpressionContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;
              setState(810);
              match(MinusMinus);
              setState(811);
              singleExpression(34);
            }
            break;
          case 11:
            {
              _localctx = new UnaryPlusExpressionContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;
              setState(812);
              match(Plus);
              setState(813);
              singleExpression(33);
            }
            break;
          case 12:
            {
              _localctx = new UnaryMinusExpressionContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;
              setState(814);
              match(Minus);
              setState(815);
              singleExpression(32);
            }
            break;
          case 13:
            {
              _localctx = new BitNotExpressionContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;
              setState(816);
              match(BitNot);
              setState(817);
              singleExpression(31);
            }
            break;
          case 14:
            {
              _localctx = new NotExpressionContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;
              setState(818);
              match(Not);
              setState(819);
              singleExpression(30);
            }
            break;
          case 15:
            {
              _localctx = new AwaitExpressionContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;
              setState(820);
              match(Await);
              setState(821);
              singleExpression(29);
            }
            break;
          case 16:
            {
              _localctx = new ImportExpressionContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;
              setState(822);
              match(Import);
              setState(823);
              match(OpenParen);
              setState(824);
              singleExpression(0);
              setState(825);
              match(CloseParen);
            }
            break;
          case 17:
            {
              _localctx = new YieldExpressionContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;
              setState(827);
              yieldStatement();
            }
            break;
          case 18:
            {
              _localctx = new ThisExpressionContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;
              setState(828);
              match(This);
            }
            break;
          case 19:
            {
              _localctx = new IdentifierExpressionContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;
              setState(829);
              identifier();
            }
            break;
          case 20:
            {
              _localctx = new SuperExpressionContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;
              setState(830);
              match(Super);
            }
            break;
          case 21:
            {
              _localctx = new LiteralExpressionContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;
              setState(831);
              literal();
            }
            break;
          case 22:
            {
              _localctx = new ArrayLiteralExpressionContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;
              setState(832);
              arrayLiteral();
            }
            break;
          case 23:
            {
              _localctx = new ObjectLiteralExpressionContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;
              setState(833);
              objectLiteral();
            }
            break;
          case 24:
            {
              _localctx = new JsxElementExpressionContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;
              setState(834);
              jsxElements();
            }
            break;
          case 25:
            {
              _localctx = new ParenthesizedExpressionContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;
              setState(835);
              match(OpenParen);
              setState(836);
              expressionSequence();
              setState(837);
              match(CloseParen);
            }
            break;
        }
        _ctx.stop = _input.LT(-1);
        setState(922);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 95, _ctx);
        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            if (_parseListeners != null) triggerExitRuleEvent();
            _prevctx = _localctx;
            {
              setState(920);
              _errHandler.sync(this);
              switch (getInterpreter().adaptivePredict(_input, 94, _ctx)) {
                case 1:
                  {
                    _localctx =
                        new PowerExpressionContext(
                            new SingleExpressionContext(_parentctx, _parentState));
                    pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
                    setState(841);
                    if (!(precpred(_ctx, 28)))
                      throw new FailedPredicateException(this, "precpred(_ctx, 28)");
                    setState(842);
                    match(Power);
                    setState(843);
                    singleExpression(28);
                  }
                  break;
                case 2:
                  {
                    _localctx =
                        new MultiplicativeExpressionContext(
                            new SingleExpressionContext(_parentctx, _parentState));
                    pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
                    setState(844);
                    if (!(precpred(_ctx, 27)))
                      throw new FailedPredicateException(this, "precpred(_ctx, 27)");
                    setState(845);
                    _la = _input.LA(1);
                    if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 29360128L) != 0))) {
                      _errHandler.recoverInline(this);
                    } else {
                      if (_input.LA(1) == Token.EOF) matchedEOF = true;
                      _errHandler.reportMatch(this);
                      consume();
                    }
                    setState(846);
                    singleExpression(28);
                  }
                  break;
                case 3:
                  {
                    _localctx =
                        new AdditiveExpressionContext(
                            new SingleExpressionContext(_parentctx, _parentState));
                    pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
                    setState(847);
                    if (!(precpred(_ctx, 26)))
                      throw new FailedPredicateException(this, "precpred(_ctx, 26)");
                    setState(848);
                    _la = _input.LA(1);
                    if (!(_la == Plus || _la == Minus)) {
                      _errHandler.recoverInline(this);
                    } else {
                      if (_input.LA(1) == Token.EOF) matchedEOF = true;
                      _errHandler.reportMatch(this);
                      consume();
                    }
                    setState(849);
                    singleExpression(27);
                  }
                  break;
                case 4:
                  {
                    _localctx =
                        new CoalesceExpressionContext(
                            new SingleExpressionContext(_parentctx, _parentState));
                    pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
                    setState(850);
                    if (!(precpred(_ctx, 25)))
                      throw new FailedPredicateException(this, "precpred(_ctx, 25)");
                    setState(851);
                    match(NullCoalesce);
                    setState(852);
                    singleExpression(26);
                  }
                  break;
                case 5:
                  {
                    _localctx =
                        new BitShiftExpressionContext(
                            new SingleExpressionContext(_parentctx, _parentState));
                    pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
                    setState(853);
                    if (!(precpred(_ctx, 24)))
                      throw new FailedPredicateException(this, "precpred(_ctx, 24)");
                    setState(854);
                    _la = _input.LA(1);
                    if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 1879048192L) != 0))) {
                      _errHandler.recoverInline(this);
                    } else {
                      if (_input.LA(1) == Token.EOF) matchedEOF = true;
                      _errHandler.reportMatch(this);
                      consume();
                    }
                    setState(855);
                    singleExpression(25);
                  }
                  break;
                case 6:
                  {
                    _localctx =
                        new RelationalExpressionContext(
                            new SingleExpressionContext(_parentctx, _parentState));
                    pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
                    setState(856);
                    if (!(precpred(_ctx, 23)))
                      throw new FailedPredicateException(this, "precpred(_ctx, 23)");
                    setState(857);
                    _la = _input.LA(1);
                    if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 32212254720L) != 0))) {
                      _errHandler.recoverInline(this);
                    } else {
                      if (_input.LA(1) == Token.EOF) matchedEOF = true;
                      _errHandler.reportMatch(this);
                      consume();
                    }
                    setState(858);
                    singleExpression(24);
                  }
                  break;
                case 7:
                  {
                    _localctx =
                        new InstanceofExpressionContext(
                            new SingleExpressionContext(_parentctx, _parentState));
                    pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
                    setState(859);
                    if (!(precpred(_ctx, 22)))
                      throw new FailedPredicateException(this, "precpred(_ctx, 22)");
                    setState(860);
                    match(Instanceof);
                    setState(861);
                    singleExpression(23);
                  }
                  break;
                case 8:
                  {
                    _localctx =
                        new InExpressionContext(
                            new SingleExpressionContext(_parentctx, _parentState));
                    pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
                    setState(862);
                    if (!(precpred(_ctx, 21)))
                      throw new FailedPredicateException(this, "precpred(_ctx, 21)");
                    setState(863);
                    match(In);
                    setState(864);
                    singleExpression(22);
                  }
                  break;
                case 9:
                  {
                    _localctx =
                        new EqualityExpressionContext(
                            new SingleExpressionContext(_parentctx, _parentState));
                    pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
                    setState(865);
                    if (!(precpred(_ctx, 20)))
                      throw new FailedPredicateException(this, "precpred(_ctx, 20)");
                    setState(866);
                    _la = _input.LA(1);
                    if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 515396075520L) != 0))) {
                      _errHandler.recoverInline(this);
                    } else {
                      if (_input.LA(1) == Token.EOF) matchedEOF = true;
                      _errHandler.reportMatch(this);
                      consume();
                    }
                    setState(867);
                    singleExpression(21);
                  }
                  break;
                case 10:
                  {
                    _localctx =
                        new BitAndExpressionContext(
                            new SingleExpressionContext(_parentctx, _parentState));
                    pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
                    setState(868);
                    if (!(precpred(_ctx, 19)))
                      throw new FailedPredicateException(this, "precpred(_ctx, 19)");
                    setState(869);
                    match(BitAnd);
                    setState(870);
                    singleExpression(20);
                  }
                  break;
                case 11:
                  {
                    _localctx =
                        new BitXOrExpressionContext(
                            new SingleExpressionContext(_parentctx, _parentState));
                    pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
                    setState(871);
                    if (!(precpred(_ctx, 18)))
                      throw new FailedPredicateException(this, "precpred(_ctx, 18)");
                    setState(872);
                    match(BitXOr);
                    setState(873);
                    singleExpression(19);
                  }
                  break;
                case 12:
                  {
                    _localctx =
                        new BitOrExpressionContext(
                            new SingleExpressionContext(_parentctx, _parentState));
                    pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
                    setState(874);
                    if (!(precpred(_ctx, 17)))
                      throw new FailedPredicateException(this, "precpred(_ctx, 17)");
                    setState(875);
                    match(BitOr);
                    setState(876);
                    singleExpression(18);
                  }
                  break;
                case 13:
                  {
                    _localctx =
                        new LogicalAndExpressionContext(
                            new SingleExpressionContext(_parentctx, _parentState));
                    pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
                    setState(877);
                    if (!(precpred(_ctx, 16)))
                      throw new FailedPredicateException(this, "precpred(_ctx, 16)");
                    setState(878);
                    match(And);
                    setState(879);
                    singleExpression(17);
                  }
                  break;
                case 14:
                  {
                    _localctx =
                        new LogicalOrExpressionContext(
                            new SingleExpressionContext(_parentctx, _parentState));
                    pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
                    setState(880);
                    if (!(precpred(_ctx, 15)))
                      throw new FailedPredicateException(this, "precpred(_ctx, 15)");
                    setState(881);
                    match(Or);
                    setState(882);
                    singleExpression(16);
                  }
                  break;
                case 15:
                  {
                    _localctx =
                        new TernaryExpressionContext(
                            new SingleExpressionContext(_parentctx, _parentState));
                    pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
                    setState(883);
                    if (!(precpred(_ctx, 14)))
                      throw new FailedPredicateException(this, "precpred(_ctx, 14)");
                    setState(884);
                    match(QuestionMark);
                    setState(885);
                    singleExpression(0);
                    setState(886);
                    match(Colon);
                    setState(887);
                    singleExpression(15);
                  }
                  break;
                case 16:
                  {
                    _localctx =
                        new AssignmentExpressionContext(
                            new SingleExpressionContext(_parentctx, _parentState));
                    pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
                    setState(889);
                    if (!(precpred(_ctx, 13)))
                      throw new FailedPredicateException(this, "precpred(_ctx, 13)");
                    setState(890);
                    match(Assign);
                    setState(891);
                    singleExpression(13);
                  }
                  break;
                case 17:
                  {
                    _localctx =
                        new AssignmentOperatorExpressionContext(
                            new SingleExpressionContext(_parentctx, _parentState));
                    pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
                    setState(892);
                    if (!(precpred(_ctx, 12)))
                      throw new FailedPredicateException(this, "precpred(_ctx, 12)");
                    setState(893);
                    assignmentOperator();
                    setState(894);
                    singleExpression(12);
                  }
                  break;
                case 18:
                  {
                    _localctx =
                        new MemberIndexExpressionContext(
                            new SingleExpressionContext(_parentctx, _parentState));
                    pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
                    setState(896);
                    if (!(precpred(_ctx, 46)))
                      throw new FailedPredicateException(this, "precpred(_ctx, 46)");
                    setState(897);
                    match(OpenBracket);
                    setState(898);
                    expressionSequence();
                    setState(899);
                    match(CloseBracket);
                  }
                  break;
                case 19:
                  {
                    _localctx =
                        new MemberDotExpressionContext(
                            new SingleExpressionContext(_parentctx, _parentState));
                    pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
                    setState(901);
                    if (!(precpred(_ctx, 45)))
                      throw new FailedPredicateException(this, "precpred(_ctx, 45)");
                    setState(903);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == QuestionMark) {
                      {
                        setState(902);
                        match(QuestionMark);
                      }
                    }

                    setState(905);
                    match(Dot);
                    setState(907);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == Hashtag) {
                      {
                        setState(906);
                        match(Hashtag);
                      }
                    }

                    setState(909);
                    identifierName();
                  }
                  break;
                case 20:
                  {
                    _localctx =
                        new ArgumentsExpressionContext(
                            new SingleExpressionContext(_parentctx, _parentState));
                    pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
                    setState(910);
                    if (!(precpred(_ctx, 42)))
                      throw new FailedPredicateException(this, "precpred(_ctx, 42)");
                    setState(911);
                    arguments();
                  }
                  break;
                case 21:
                  {
                    _localctx =
                        new PostIncrementExpressionContext(
                            new SingleExpressionContext(_parentctx, _parentState));
                    pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
                    setState(912);
                    if (!(precpred(_ctx, 40)))
                      throw new FailedPredicateException(this, "precpred(_ctx, 40)");
                    setState(913);
                    if (!(this.notLineTerminator()))
                      throw new FailedPredicateException(this, "this.notLineTerminator()");
                    setState(914);
                    match(PlusPlus);
                  }
                  break;
                case 22:
                  {
                    _localctx =
                        new PostDecreaseExpressionContext(
                            new SingleExpressionContext(_parentctx, _parentState));
                    pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
                    setState(915);
                    if (!(precpred(_ctx, 39)))
                      throw new FailedPredicateException(this, "precpred(_ctx, 39)");
                    setState(916);
                    if (!(this.notLineTerminator()))
                      throw new FailedPredicateException(this, "this.notLineTerminator()");
                    setState(917);
                    match(MinusMinus);
                  }
                  break;
                case 23:
                  {
                    _localctx =
                        new TemplateStringExpressionContext(
                            new SingleExpressionContext(_parentctx, _parentState));
                    pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
                    setState(918);
                    if (!(precpred(_ctx, 10)))
                      throw new FailedPredicateException(this, "precpred(_ctx, 10)");
                    setState(919);
                    templateStringLiteral();
                  }
                  break;
              }
            }
          }
          setState(924);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 95, _ctx);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      unrollRecursionContexts(_parentctx);
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class JsxElementsContext extends ParserRuleContext {
    public List<JsxElementContext> jsxElement() {
      return getRuleContexts(JsxElementContext.class);
    }

    public JsxElementContext jsxElement(int i) {
      return getRuleContext(JsxElementContext.class, i);
    }

    public JsxElementsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_jsxElements;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterJsxElements(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitJsxElements(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitJsxElements(this);
      else return visitor.visitChildren(this);
    }
  }

  public final JsxElementsContext jsxElements() throws RecognitionException {
    JsxElementsContext _localctx = new JsxElementsContext(_ctx, getState());
    enterRule(_localctx, 116, RULE_jsxElements);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(926);
        _errHandler.sync(this);
        _alt = 1;
        do {
          switch (_alt) {
            case 1:
              {
                {
                  setState(925);
                  jsxElement();
                }
              }
              break;
            default:
              throw new NoViableAltException(this);
          }
          setState(928);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 96, _ctx);
        } while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER);
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
  public static class JsxElementBeginContext extends ParserRuleContext {
    public TerminalNode JsxElementBegin() {
      return getToken(JavaScriptParserJsx.JsxElementBegin, 0);
    }

    public TerminalNode JsxOpeningElementBegin() {
      return getToken(JavaScriptParserJsx.JsxOpeningElementBegin, 0);
    }

    public TerminalNode JsxChildrenOpeningElementBegin() {
      return getToken(JavaScriptParserJsx.JsxChildrenOpeningElementBegin, 0);
    }

    public JsxElementBeginContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_jsxElementBegin;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterJsxElementBegin(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitJsxElementBegin(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitJsxElementBegin(this);
      else return visitor.visitChildren(this);
    }
  }

  public final JsxElementBeginContext jsxElementBegin() throws RecognitionException {
    JsxElementBeginContext _localctx = new JsxElementBeginContext(_ctx, getState());
    enterRule(_localctx, 118, RULE_jsxElementBegin);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(930);
        _la = _input.LA(1);
        if (!(_la == JsxElementBegin
            || _la == JsxOpeningElementBegin
            || _la == JsxChildrenOpeningElementBegin)) {
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
  public static class JsxElementContext extends ParserRuleContext {
    public JsxSelfClosingElementContext jsxSelfClosingElement() {
      return getRuleContext(JsxSelfClosingElementContext.class, 0);
    }

    public JsxOpeningElementContext jsxOpeningElement() {
      return getRuleContext(JsxOpeningElementContext.class, 0);
    }

    public JsxChildrenContext jsxChildren() {
      return getRuleContext(JsxChildrenContext.class, 0);
    }

    public JsxClosingElementContext jsxClosingElement() {
      return getRuleContext(JsxClosingElementContext.class, 0);
    }

    public JsxElementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_jsxElement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterJsxElement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitJsxElement(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitJsxElement(this);
      else return visitor.visitChildren(this);
    }
  }

  public final JsxElementContext jsxElement() throws RecognitionException {
    JsxElementContext _localctx = new JsxElementContext(_ctx, getState());
    enterRule(_localctx, 120, RULE_jsxElement);
    try {
      setState(937);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 97, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(932);
            jsxSelfClosingElement();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(933);
            jsxOpeningElement();
            setState(934);
            jsxChildren();
            setState(935);
            jsxClosingElement();
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
  public static class JsxSelfClosingElementContext extends ParserRuleContext {
    public JsxElementBeginContext jsxElementBegin() {
      return getRuleContext(JsxElementBeginContext.class, 0);
    }

    public JsxSelfClosingElementNameContext jsxSelfClosingElementName() {
      return getRuleContext(JsxSelfClosingElementNameContext.class, 0);
    }

    public TerminalNode JsxOpeningElementSlashEnd() {
      return getToken(JavaScriptParserJsx.JsxOpeningElementSlashEnd, 0);
    }

    public JsxAttributesContext jsxAttributes() {
      return getRuleContext(JsxAttributesContext.class, 0);
    }

    public JsxSelfClosingElementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_jsxSelfClosingElement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterJsxSelfClosingElement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitJsxSelfClosingElement(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitJsxSelfClosingElement(this);
      else return visitor.visitChildren(this);
    }
  }

  public final JsxSelfClosingElementContext jsxSelfClosingElement() throws RecognitionException {
    JsxSelfClosingElementContext _localctx = new JsxSelfClosingElementContext(_ctx, getState());
    enterRule(_localctx, 122, RULE_jsxSelfClosingElement);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(939);
        jsxElementBegin();
        setState(940);
        jsxSelfClosingElementName();
        setState(942);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == JsxOpeningElementOpenBrace || _la == JsxOpeningElementId) {
          {
            setState(941);
            jsxAttributes();
          }
        }

        setState(944);
        match(JsxOpeningElementSlashEnd);
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
  public static class JsxOpeningElementContext extends ParserRuleContext {
    public JsxElementBeginContext jsxElementBegin() {
      return getRuleContext(JsxElementBeginContext.class, 0);
    }

    public JsxOpeningElementNameContext jsxOpeningElementName() {
      return getRuleContext(JsxOpeningElementNameContext.class, 0);
    }

    public TerminalNode JsxOpeningElementEnd() {
      return getToken(JavaScriptParserJsx.JsxOpeningElementEnd, 0);
    }

    public JsxAttributesContext jsxAttributes() {
      return getRuleContext(JsxAttributesContext.class, 0);
    }

    public JsxOpeningElementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_jsxOpeningElement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterJsxOpeningElement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitJsxOpeningElement(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitJsxOpeningElement(this);
      else return visitor.visitChildren(this);
    }
  }

  public final JsxOpeningElementContext jsxOpeningElement() throws RecognitionException {
    JsxOpeningElementContext _localctx = new JsxOpeningElementContext(_ctx, getState());
    enterRule(_localctx, 124, RULE_jsxOpeningElement);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(946);
        jsxElementBegin();
        setState(947);
        jsxOpeningElementName();
        setState(949);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == JsxOpeningElementOpenBrace || _la == JsxOpeningElementId) {
          {
            setState(948);
            jsxAttributes();
          }
        }

        setState(951);
        match(JsxOpeningElementEnd);
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
  public static class JsxClosingElementContext extends ParserRuleContext {
    public TerminalNode JsxChildrenClosingElementSlashBegin() {
      return getToken(JavaScriptParserJsx.JsxChildrenClosingElementSlashBegin, 0);
    }

    public JsxClosingElementNameContext jsxClosingElementName() {
      return getRuleContext(JsxClosingElementNameContext.class, 0);
    }

    public TerminalNode JsxClosingElementEnd() {
      return getToken(JavaScriptParserJsx.JsxClosingElementEnd, 0);
    }

    public JsxClosingElementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_jsxClosingElement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterJsxClosingElement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitJsxClosingElement(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitJsxClosingElement(this);
      else return visitor.visitChildren(this);
    }
  }

  public final JsxClosingElementContext jsxClosingElement() throws RecognitionException {
    JsxClosingElementContext _localctx = new JsxClosingElementContext(_ctx, getState());
    enterRule(_localctx, 126, RULE_jsxClosingElement);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(953);
        match(JsxChildrenClosingElementSlashBegin);
        setState(954);
        jsxClosingElementName();
        setState(955);
        match(JsxClosingElementEnd);
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
  public static class JsxChildrenContext extends ParserRuleContext {
    public List<TerminalNode> HtmlChardata() {
      return getTokens(JavaScriptParserJsx.HtmlChardata);
    }

    public TerminalNode HtmlChardata(int i) {
      return getToken(JavaScriptParserJsx.HtmlChardata, i);
    }

    public List<JsxElementContext> jsxElement() {
      return getRuleContexts(JsxElementContext.class);
    }

    public JsxElementContext jsxElement(int i) {
      return getRuleContext(JsxElementContext.class, i);
    }

    public List<ObjectExpressionSequenceContext> objectExpressionSequence() {
      return getRuleContexts(ObjectExpressionSequenceContext.class);
    }

    public ObjectExpressionSequenceContext objectExpressionSequence(int i) {
      return getRuleContext(ObjectExpressionSequenceContext.class, i);
    }

    public JsxChildrenContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_jsxChildren;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterJsxChildren(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitJsxChildren(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitJsxChildren(this);
      else return visitor.visitChildren(this);
    }
  }

  public final JsxChildrenContext jsxChildren() throws RecognitionException {
    JsxChildrenContext _localctx = new JsxChildrenContext(_ctx, getState());
    enterRule(_localctx, 128, RULE_jsxChildren);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(958);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == HtmlChardata) {
          {
            setState(957);
            match(HtmlChardata);
          }
        }

        setState(969);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == JsxElementBegin
            || _la == OpenBrace
            || ((((_la - 132)) & ~0x3f) == 0 && ((1L << (_la - 132)) & 20497L) != 0)) {
          {
            {
              setState(962);
              _errHandler.sync(this);
              switch (_input.LA(1)) {
                case JsxElementBegin:
                case JsxOpeningElementBegin:
                case JsxChildrenOpeningElementBegin:
                  {
                    setState(960);
                    jsxElement();
                  }
                  break;
                case OpenBrace:
                case JsxOpeningElementOpenBrace:
                case JsxChildrenOpenBrace:
                  {
                    setState(961);
                    objectExpressionSequence();
                  }
                  break;
                default:
                  throw new NoViableAltException(this);
              }
              setState(965);
              _errHandler.sync(this);
              _la = _input.LA(1);
              if (_la == HtmlChardata) {
                {
                  setState(964);
                  match(HtmlChardata);
                }
              }
            }
          }
          setState(971);
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
  public static class JsxSelfClosingElementNameContext extends ParserRuleContext {
    public TerminalNode JsxOpeningElementId() {
      return getToken(JavaScriptParserJsx.JsxOpeningElementId, 0);
    }

    public JsxSelfClosingElementNameContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_jsxSelfClosingElementName;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterJsxSelfClosingElementName(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitJsxSelfClosingElementName(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor)
            .visitJsxSelfClosingElementName(this);
      else return visitor.visitChildren(this);
    }
  }

  public final JsxSelfClosingElementNameContext jsxSelfClosingElementName()
      throws RecognitionException {
    JsxSelfClosingElementNameContext _localctx =
        new JsxSelfClosingElementNameContext(_ctx, getState());
    enterRule(_localctx, 130, RULE_jsxSelfClosingElementName);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(972);
        match(JsxOpeningElementId);
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
  public static class JsxOpeningElementNameContext extends ParserRuleContext {
    public Token JsxOpeningElementId;

    public TerminalNode JsxOpeningElementId() {
      return getToken(JavaScriptParserJsx.JsxOpeningElementId, 0);
    }

    public JsxOpeningElementNameContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_jsxOpeningElementName;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterJsxOpeningElementName(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitJsxOpeningElementName(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitJsxOpeningElementName(this);
      else return visitor.visitChildren(this);
    }
  }

  public final JsxOpeningElementNameContext jsxOpeningElementName() throws RecognitionException {
    JsxOpeningElementNameContext _localctx = new JsxOpeningElementNameContext(_ctx, getState());
    enterRule(_localctx, 132, RULE_jsxOpeningElementName);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(974);
        ((JsxOpeningElementNameContext) _localctx).JsxOpeningElementId = match(JsxOpeningElementId);
        this.pushHtmlTagName(
            (((JsxOpeningElementNameContext) _localctx).JsxOpeningElementId != null
                ? ((JsxOpeningElementNameContext) _localctx).JsxOpeningElementId.getText()
                : null));
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
  public static class JsxClosingElementNameContext extends ParserRuleContext {
    public Token JsxClosingElementId;

    public TerminalNode JsxClosingElementId() {
      return getToken(JavaScriptParserJsx.JsxClosingElementId, 0);
    }

    public JsxClosingElementNameContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_jsxClosingElementName;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterJsxClosingElementName(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitJsxClosingElementName(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitJsxClosingElementName(this);
      else return visitor.visitChildren(this);
    }
  }

  public final JsxClosingElementNameContext jsxClosingElementName() throws RecognitionException {
    JsxClosingElementNameContext _localctx = new JsxClosingElementNameContext(_ctx, getState());
    enterRule(_localctx, 134, RULE_jsxClosingElementName);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(977);
        ((JsxClosingElementNameContext) _localctx).JsxClosingElementId = match(JsxClosingElementId);
        setState(978);
        if (!(this.popHtmlTagName(
            (((JsxClosingElementNameContext) _localctx).JsxClosingElementId != null
                ? ((JsxClosingElementNameContext) _localctx).JsxClosingElementId.getText()
                : null))))
          throw new FailedPredicateException(
              this, "this.popHtmlTagName($JsxClosingElementId.text)");
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
  public static class JsxAttributesContext extends ParserRuleContext {
    public JsxSpreadAttributeContext jsxSpreadAttribute() {
      return getRuleContext(JsxSpreadAttributeContext.class, 0);
    }

    public JsxAttributesContext jsxAttributes() {
      return getRuleContext(JsxAttributesContext.class, 0);
    }

    public JsxAttributeContext jsxAttribute() {
      return getRuleContext(JsxAttributeContext.class, 0);
    }

    public JsxAttributesContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_jsxAttributes;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterJsxAttributes(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitJsxAttributes(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitJsxAttributes(this);
      else return visitor.visitChildren(this);
    }
  }

  public final JsxAttributesContext jsxAttributes() throws RecognitionException {
    JsxAttributesContext _localctx = new JsxAttributesContext(_ctx, getState());
    enterRule(_localctx, 136, RULE_jsxAttributes);
    int _la;
    try {
      setState(988);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case JsxOpeningElementOpenBrace:
          enterOuterAlt(_localctx, 1);
          {
            setState(980);
            jsxSpreadAttribute();
            setState(982);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == JsxOpeningElementOpenBrace || _la == JsxOpeningElementId) {
              {
                setState(981);
                jsxAttributes();
              }
            }
          }
          break;
        case JsxOpeningElementId:
          enterOuterAlt(_localctx, 2);
          {
            setState(984);
            jsxAttribute();
            setState(986);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == JsxOpeningElementOpenBrace || _la == JsxOpeningElementId) {
              {
                setState(985);
                jsxAttributes();
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
  public static class JsxSpreadAttributeContext extends ParserRuleContext {
    public TerminalNode JsxOpeningElementOpenBrace() {
      return getToken(JavaScriptParserJsx.JsxOpeningElementOpenBrace, 0);
    }

    public TerminalNode Ellipsis() {
      return getToken(JavaScriptParserJsx.Ellipsis, 0);
    }

    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public TerminalNode CloseBrace() {
      return getToken(JavaScriptParserJsx.CloseBrace, 0);
    }

    public JsxSpreadAttributeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_jsxSpreadAttribute;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterJsxSpreadAttribute(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitJsxSpreadAttribute(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitJsxSpreadAttribute(this);
      else return visitor.visitChildren(this);
    }
  }

  public final JsxSpreadAttributeContext jsxSpreadAttribute() throws RecognitionException {
    JsxSpreadAttributeContext _localctx = new JsxSpreadAttributeContext(_ctx, getState());
    enterRule(_localctx, 138, RULE_jsxSpreadAttribute);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(990);
        match(JsxOpeningElementOpenBrace);
        setState(991);
        match(Ellipsis);
        setState(992);
        singleExpression(0);
        setState(993);
        match(CloseBrace);
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
  public static class JsxAttributeContext extends ParserRuleContext {
    public JsxAttributeNameContext jsxAttributeName() {
      return getRuleContext(JsxAttributeNameContext.class, 0);
    }

    public TerminalNode JsxAssign() {
      return getToken(JavaScriptParserJsx.JsxAssign, 0);
    }

    public JsxAttributeValueContext jsxAttributeValue() {
      return getRuleContext(JsxAttributeValueContext.class, 0);
    }

    public JsxAttributeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_jsxAttribute;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterJsxAttribute(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitJsxAttribute(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitJsxAttribute(this);
      else return visitor.visitChildren(this);
    }
  }

  public final JsxAttributeContext jsxAttribute() throws RecognitionException {
    JsxAttributeContext _localctx = new JsxAttributeContext(_ctx, getState());
    enterRule(_localctx, 140, RULE_jsxAttribute);
    try {
      setState(1000);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 107, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(995);
            jsxAttributeName();
            setState(996);
            match(JsxAssign);
            setState(997);
            jsxAttributeValue();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(999);
            jsxAttributeName();
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
  public static class JsxAttributeNameContext extends ParserRuleContext {
    public TerminalNode JsxOpeningElementId() {
      return getToken(JavaScriptParserJsx.JsxOpeningElementId, 0);
    }

    public JsxAttributeNameContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_jsxAttributeName;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterJsxAttributeName(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitJsxAttributeName(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitJsxAttributeName(this);
      else return visitor.visitChildren(this);
    }
  }

  public final JsxAttributeNameContext jsxAttributeName() throws RecognitionException {
    JsxAttributeNameContext _localctx = new JsxAttributeNameContext(_ctx, getState());
    enterRule(_localctx, 142, RULE_jsxAttributeName);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1002);
        match(JsxOpeningElementId);
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
  public static class JsxAttributeValueContext extends ParserRuleContext {
    public TerminalNode JsxAttributeValue() {
      return getToken(JavaScriptParserJsx.JsxAttributeValue, 0);
    }

    public JsxElementContext jsxElement() {
      return getRuleContext(JsxElementContext.class, 0);
    }

    public ObjectExpressionSequenceContext objectExpressionSequence() {
      return getRuleContext(ObjectExpressionSequenceContext.class, 0);
    }

    public JsxAttributeValueContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_jsxAttributeValue;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterJsxAttributeValue(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitJsxAttributeValue(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitJsxAttributeValue(this);
      else return visitor.visitChildren(this);
    }
  }

  public final JsxAttributeValueContext jsxAttributeValue() throws RecognitionException {
    JsxAttributeValueContext _localctx = new JsxAttributeValueContext(_ctx, getState());
    enterRule(_localctx, 144, RULE_jsxAttributeValue);
    try {
      setState(1007);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case JsxAttributeValue:
          enterOuterAlt(_localctx, 1);
          {
            setState(1004);
            match(JsxAttributeValue);
          }
          break;
        case JsxElementBegin:
        case JsxOpeningElementBegin:
        case JsxChildrenOpeningElementBegin:
          enterOuterAlt(_localctx, 2);
          {
            setState(1005);
            jsxElement();
          }
          break;
        case OpenBrace:
        case JsxOpeningElementOpenBrace:
        case JsxChildrenOpenBrace:
          enterOuterAlt(_localctx, 3);
          {
            setState(1006);
            objectExpressionSequence();
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
  public static class AssignableContext extends ParserRuleContext {
    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public ArrayLiteralContext arrayLiteral() {
      return getRuleContext(ArrayLiteralContext.class, 0);
    }

    public ObjectLiteralContext objectLiteral() {
      return getRuleContext(ObjectLiteralContext.class, 0);
    }

    public AssignableContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_assignable;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterAssignable(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitAssignable(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitAssignable(this);
      else return visitor.visitChildren(this);
    }
  }

  public final AssignableContext assignable() throws RecognitionException {
    AssignableContext _localctx = new AssignableContext(_ctx, getState());
    enterRule(_localctx, 146, RULE_assignable);
    try {
      setState(1012);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case Async:
        case NonStrictLet:
        case Identifier:
          enterOuterAlt(_localctx, 1);
          {
            setState(1009);
            identifier();
          }
          break;
        case OpenBracket:
          enterOuterAlt(_localctx, 2);
          {
            setState(1010);
            arrayLiteral();
          }
          break;
        case OpenBrace:
          enterOuterAlt(_localctx, 3);
          {
            setState(1011);
            objectLiteral();
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
  public static class ObjectLiteralContext extends ParserRuleContext {
    public TerminalNode OpenBrace() {
      return getToken(JavaScriptParserJsx.OpenBrace, 0);
    }

    public TerminalNode CloseBrace() {
      return getToken(JavaScriptParserJsx.CloseBrace, 0);
    }

    public List<PropertyAssignmentContext> propertyAssignment() {
      return getRuleContexts(PropertyAssignmentContext.class);
    }

    public PropertyAssignmentContext propertyAssignment(int i) {
      return getRuleContext(PropertyAssignmentContext.class, i);
    }

    public List<TerminalNode> Comma() {
      return getTokens(JavaScriptParserJsx.Comma);
    }

    public TerminalNode Comma(int i) {
      return getToken(JavaScriptParserJsx.Comma, i);
    }

    public ObjectLiteralContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_objectLiteral;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterObjectLiteral(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitObjectLiteral(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitObjectLiteral(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ObjectLiteralContext objectLiteral() throws RecognitionException {
    ObjectLiteralContext _localctx = new ObjectLiteralContext(_ctx, getState());
    enterRule(_localctx, 148, RULE_objectLiteral);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(1014);
        match(OpenBrace);
        setState(1026);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -144115188067516244L) != 0)
            || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 2359886204742139903L) != 0)
            || _la == JsxOpeningElementBegin
            || _la == JsxChildrenOpeningElementBegin) {
          {
            setState(1015);
            propertyAssignment();
            setState(1020);
            _errHandler.sync(this);
            _alt = getInterpreter().adaptivePredict(_input, 110, _ctx);
            while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
              if (_alt == 1) {
                {
                  {
                    setState(1016);
                    match(Comma);
                    setState(1017);
                    propertyAssignment();
                  }
                }
              }
              setState(1022);
              _errHandler.sync(this);
              _alt = getInterpreter().adaptivePredict(_input, 110, _ctx);
            }
            setState(1024);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == Comma) {
              {
                setState(1023);
                match(Comma);
              }
            }
          }
        }

        setState(1028);
        match(CloseBrace);
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
  public static class OpenBraceContext extends ParserRuleContext {
    public TerminalNode OpenBrace() {
      return getToken(JavaScriptParserJsx.OpenBrace, 0);
    }

    public TerminalNode JsxOpeningElementOpenBrace() {
      return getToken(JavaScriptParserJsx.JsxOpeningElementOpenBrace, 0);
    }

    public TerminalNode JsxChildrenOpenBrace() {
      return getToken(JavaScriptParserJsx.JsxChildrenOpenBrace, 0);
    }

    public OpenBraceContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_openBrace;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterOpenBrace(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitOpenBrace(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitOpenBrace(this);
      else return visitor.visitChildren(this);
    }
  }

  public final OpenBraceContext openBrace() throws RecognitionException {
    OpenBraceContext _localctx = new OpenBraceContext(_ctx, getState());
    enterRule(_localctx, 150, RULE_openBrace);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1030);
        _la = _input.LA(1);
        if (!(_la == OpenBrace
            || _la == JsxOpeningElementOpenBrace
            || _la == JsxChildrenOpenBrace)) {
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
  public static class ObjectExpressionSequenceContext extends ParserRuleContext {
    public OpenBraceContext openBrace() {
      return getRuleContext(OpenBraceContext.class, 0);
    }

    public ExpressionSequenceContext expressionSequence() {
      return getRuleContext(ExpressionSequenceContext.class, 0);
    }

    public TerminalNode CloseBrace() {
      return getToken(JavaScriptParserJsx.CloseBrace, 0);
    }

    public ObjectExpressionSequenceContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_objectExpressionSequence;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterObjectExpressionSequence(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitObjectExpressionSequence(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor)
            .visitObjectExpressionSequence(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ObjectExpressionSequenceContext objectExpressionSequence()
      throws RecognitionException {
    ObjectExpressionSequenceContext _localctx =
        new ObjectExpressionSequenceContext(_ctx, getState());
    enterRule(_localctx, 152, RULE_objectExpressionSequence);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1032);
        openBrace();
        setState(1033);
        expressionSequence();
        setState(1034);
        match(CloseBrace);
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
  public static class AnoymousFunctionContext extends ParserRuleContext {
    public AnoymousFunctionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_anoymousFunction;
    }

    public AnoymousFunctionContext() {}

    public void copyFrom(AnoymousFunctionContext ctx) {
      super.copyFrom(ctx);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class AnoymousFunctionDeclContext extends AnoymousFunctionContext {
    public TerminalNode Function_() {
      return getToken(JavaScriptParserJsx.Function_, 0);
    }

    public TerminalNode OpenParen() {
      return getToken(JavaScriptParserJsx.OpenParen, 0);
    }

    public TerminalNode CloseParen() {
      return getToken(JavaScriptParserJsx.CloseParen, 0);
    }

    public TerminalNode OpenBrace() {
      return getToken(JavaScriptParserJsx.OpenBrace, 0);
    }

    public FunctionBodyContext functionBody() {
      return getRuleContext(FunctionBodyContext.class, 0);
    }

    public TerminalNode CloseBrace() {
      return getToken(JavaScriptParserJsx.CloseBrace, 0);
    }

    public TerminalNode Async() {
      return getToken(JavaScriptParserJsx.Async, 0);
    }

    public TerminalNode Multiply() {
      return getToken(JavaScriptParserJsx.Multiply, 0);
    }

    public FormalParameterListContext formalParameterList() {
      return getRuleContext(FormalParameterListContext.class, 0);
    }

    public AnoymousFunctionDeclContext(AnoymousFunctionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterAnoymousFunctionDecl(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitAnoymousFunctionDecl(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitAnoymousFunctionDecl(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ArrowFunctionContext extends AnoymousFunctionContext {
    public ArrowFunctionParametersContext arrowFunctionParameters() {
      return getRuleContext(ArrowFunctionParametersContext.class, 0);
    }

    public TerminalNode ARROW() {
      return getToken(JavaScriptParserJsx.ARROW, 0);
    }

    public ArrowFunctionBodyContext arrowFunctionBody() {
      return getRuleContext(ArrowFunctionBodyContext.class, 0);
    }

    public TerminalNode Async() {
      return getToken(JavaScriptParserJsx.Async, 0);
    }

    public ArrowFunctionContext(AnoymousFunctionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterArrowFunction(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitArrowFunction(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitArrowFunction(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class FunctionDeclContext extends AnoymousFunctionContext {
    public FunctionDeclarationContext functionDeclaration() {
      return getRuleContext(FunctionDeclarationContext.class, 0);
    }

    public FunctionDeclContext(AnoymousFunctionContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterFunctionDecl(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitFunctionDecl(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitFunctionDecl(this);
      else return visitor.visitChildren(this);
    }
  }

  public final AnoymousFunctionContext anoymousFunction() throws RecognitionException {
    AnoymousFunctionContext _localctx = new AnoymousFunctionContext(_ctx, getState());
    enterRule(_localctx, 154, RULE_anoymousFunction);
    int _la;
    try {
      setState(1060);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 117, _ctx)) {
        case 1:
          _localctx = new FunctionDeclContext(_localctx);
          enterOuterAlt(_localctx, 1);
          {
            setState(1036);
            functionDeclaration();
          }
          break;
        case 2:
          _localctx = new AnoymousFunctionDeclContext(_localctx);
          enterOuterAlt(_localctx, 2);
          {
            setState(1038);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == Async) {
              {
                setState(1037);
                match(Async);
              }
            }

            setState(1040);
            match(Function_);
            setState(1042);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == Multiply) {
              {
                setState(1041);
                match(Multiply);
              }
            }

            setState(1044);
            match(OpenParen);
            setState(1046);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16520L) != 0)
                || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & 4113L) != 0)) {
              {
                setState(1045);
                formalParameterList();
              }
            }

            setState(1048);
            match(CloseParen);
            setState(1049);
            match(OpenBrace);
            setState(1050);
            functionBody();
            setState(1051);
            match(CloseBrace);
          }
          break;
        case 3:
          _localctx = new ArrowFunctionContext(_localctx);
          enterOuterAlt(_localctx, 3);
          {
            setState(1054);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 116, _ctx)) {
              case 1:
                {
                  setState(1053);
                  match(Async);
                }
                break;
            }
            setState(1056);
            arrowFunctionParameters();
            setState(1057);
            match(ARROW);
            setState(1058);
            arrowFunctionBody();
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
  public static class ArrowFunctionParametersContext extends ParserRuleContext {
    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public TerminalNode OpenParen() {
      return getToken(JavaScriptParserJsx.OpenParen, 0);
    }

    public TerminalNode CloseParen() {
      return getToken(JavaScriptParserJsx.CloseParen, 0);
    }

    public FormalParameterListContext formalParameterList() {
      return getRuleContext(FormalParameterListContext.class, 0);
    }

    public ArrowFunctionParametersContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_arrowFunctionParameters;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterArrowFunctionParameters(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitArrowFunctionParameters(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor)
            .visitArrowFunctionParameters(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ArrowFunctionParametersContext arrowFunctionParameters()
      throws RecognitionException {
    ArrowFunctionParametersContext _localctx = new ArrowFunctionParametersContext(_ctx, getState());
    enterRule(_localctx, 156, RULE_arrowFunctionParameters);
    int _la;
    try {
      setState(1068);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case Async:
        case NonStrictLet:
        case Identifier:
          enterOuterAlt(_localctx, 1);
          {
            setState(1062);
            identifier();
          }
          break;
        case OpenParen:
          enterOuterAlt(_localctx, 2);
          {
            setState(1063);
            match(OpenParen);
            setState(1065);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16520L) != 0)
                || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & 4113L) != 0)) {
              {
                setState(1064);
                formalParameterList();
              }
            }

            setState(1067);
            match(CloseParen);
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
  public static class ArrowFunctionBodyContext extends ParserRuleContext {
    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public TerminalNode OpenBrace() {
      return getToken(JavaScriptParserJsx.OpenBrace, 0);
    }

    public FunctionBodyContext functionBody() {
      return getRuleContext(FunctionBodyContext.class, 0);
    }

    public TerminalNode CloseBrace() {
      return getToken(JavaScriptParserJsx.CloseBrace, 0);
    }

    public ArrowFunctionBodyContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_arrowFunctionBody;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterArrowFunctionBody(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitArrowFunctionBody(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitArrowFunctionBody(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ArrowFunctionBodyContext arrowFunctionBody() throws RecognitionException {
    ArrowFunctionBodyContext _localctx = new ArrowFunctionBodyContext(_ctx, getState());
    enterRule(_localctx, 158, RULE_arrowFunctionBody);
    try {
      setState(1075);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 120, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(1070);
            singleExpression(0);
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(1071);
            match(OpenBrace);
            setState(1072);
            functionBody();
            setState(1073);
            match(CloseBrace);
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
  public static class AssignmentOperatorContext extends ParserRuleContext {
    public TerminalNode MultiplyAssign() {
      return getToken(JavaScriptParserJsx.MultiplyAssign, 0);
    }

    public TerminalNode DivideAssign() {
      return getToken(JavaScriptParserJsx.DivideAssign, 0);
    }

    public TerminalNode ModulusAssign() {
      return getToken(JavaScriptParserJsx.ModulusAssign, 0);
    }

    public TerminalNode PlusAssign() {
      return getToken(JavaScriptParserJsx.PlusAssign, 0);
    }

    public TerminalNode MinusAssign() {
      return getToken(JavaScriptParserJsx.MinusAssign, 0);
    }

    public TerminalNode LeftShiftArithmeticAssign() {
      return getToken(JavaScriptParserJsx.LeftShiftArithmeticAssign, 0);
    }

    public TerminalNode RightShiftArithmeticAssign() {
      return getToken(JavaScriptParserJsx.RightShiftArithmeticAssign, 0);
    }

    public TerminalNode RightShiftLogicalAssign() {
      return getToken(JavaScriptParserJsx.RightShiftLogicalAssign, 0);
    }

    public TerminalNode BitAndAssign() {
      return getToken(JavaScriptParserJsx.BitAndAssign, 0);
    }

    public TerminalNode BitXorAssign() {
      return getToken(JavaScriptParserJsx.BitXorAssign, 0);
    }

    public TerminalNode BitOrAssign() {
      return getToken(JavaScriptParserJsx.BitOrAssign, 0);
    }

    public TerminalNode PowerAssign() {
      return getToken(JavaScriptParserJsx.PowerAssign, 0);
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
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterAssignmentOperator(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitAssignmentOperator(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitAssignmentOperator(this);
      else return visitor.visitChildren(this);
    }
  }

  public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
    AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
    enterRule(_localctx, 160, RULE_assignmentOperator);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1077);
        _la = _input.LA(1);
        if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 72040001851883520L) != 0))) {
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
  public static class LiteralContext extends ParserRuleContext {
    public TerminalNode NullLiteral() {
      return getToken(JavaScriptParserJsx.NullLiteral, 0);
    }

    public TerminalNode BooleanLiteral() {
      return getToken(JavaScriptParserJsx.BooleanLiteral, 0);
    }

    public TerminalNode StringLiteral() {
      return getToken(JavaScriptParserJsx.StringLiteral, 0);
    }

    public TemplateStringLiteralContext templateStringLiteral() {
      return getRuleContext(TemplateStringLiteralContext.class, 0);
    }

    public TerminalNode RegularExpressionLiteral() {
      return getToken(JavaScriptParserJsx.RegularExpressionLiteral, 0);
    }

    public NumericLiteralContext numericLiteral() {
      return getRuleContext(NumericLiteralContext.class, 0);
    }

    public BigintLiteralContext bigintLiteral() {
      return getRuleContext(BigintLiteralContext.class, 0);
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
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterLiteral(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitLiteral(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitLiteral(this);
      else return visitor.visitChildren(this);
    }
  }

  public final LiteralContext literal() throws RecognitionException {
    LiteralContext _localctx = new LiteralContext(_ctx, getState());
    enterRule(_localctx, 162, RULE_literal);
    try {
      setState(1086);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case NullLiteral:
          enterOuterAlt(_localctx, 1);
          {
            setState(1079);
            match(NullLiteral);
          }
          break;
        case BooleanLiteral:
          enterOuterAlt(_localctx, 2);
          {
            setState(1080);
            match(BooleanLiteral);
          }
          break;
        case StringLiteral:
          enterOuterAlt(_localctx, 3);
          {
            setState(1081);
            match(StringLiteral);
          }
          break;
        case BackTick:
          enterOuterAlt(_localctx, 4);
          {
            setState(1082);
            templateStringLiteral();
          }
          break;
        case RegularExpressionLiteral:
          enterOuterAlt(_localctx, 5);
          {
            setState(1083);
            match(RegularExpressionLiteral);
          }
          break;
        case DecimalLiteral:
        case HexIntegerLiteral:
        case OctalIntegerLiteral:
        case OctalIntegerLiteral2:
        case BinaryIntegerLiteral:
          enterOuterAlt(_localctx, 6);
          {
            setState(1084);
            numericLiteral();
          }
          break;
        case BigHexIntegerLiteral:
        case BigOctalIntegerLiteral:
        case BigBinaryIntegerLiteral:
        case BigDecimalIntegerLiteral:
          enterOuterAlt(_localctx, 7);
          {
            setState(1085);
            bigintLiteral();
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
  public static class TemplateStringLiteralContext extends ParserRuleContext {
    public List<TerminalNode> BackTick() {
      return getTokens(JavaScriptParserJsx.BackTick);
    }

    public TerminalNode BackTick(int i) {
      return getToken(JavaScriptParserJsx.BackTick, i);
    }

    public List<TemplateStringAtomContext> templateStringAtom() {
      return getRuleContexts(TemplateStringAtomContext.class);
    }

    public TemplateStringAtomContext templateStringAtom(int i) {
      return getRuleContext(TemplateStringAtomContext.class, i);
    }

    public TemplateStringLiteralContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_templateStringLiteral;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterTemplateStringLiteral(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitTemplateStringLiteral(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitTemplateStringLiteral(this);
      else return visitor.visitChildren(this);
    }
  }

  public final TemplateStringLiteralContext templateStringLiteral() throws RecognitionException {
    TemplateStringLiteralContext _localctx = new TemplateStringLiteralContext(_ctx, getState());
    enterRule(_localctx, 164, RULE_templateStringLiteral);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1088);
        match(BackTick);
        setState(1092);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == TemplateStringStartExpression || _la == TemplateStringAtom) {
          {
            {
              setState(1089);
              templateStringAtom();
            }
          }
          setState(1094);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(1095);
        match(BackTick);
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
  public static class TemplateStringAtomContext extends ParserRuleContext {
    public TerminalNode TemplateStringAtom() {
      return getToken(JavaScriptParserJsx.TemplateStringAtom, 0);
    }

    public TerminalNode TemplateStringStartExpression() {
      return getToken(JavaScriptParserJsx.TemplateStringStartExpression, 0);
    }

    public SingleExpressionContext singleExpression() {
      return getRuleContext(SingleExpressionContext.class, 0);
    }

    public TerminalNode CloseBrace() {
      return getToken(JavaScriptParserJsx.CloseBrace, 0);
    }

    public TemplateStringAtomContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_templateStringAtom;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterTemplateStringAtom(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitTemplateStringAtom(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitTemplateStringAtom(this);
      else return visitor.visitChildren(this);
    }
  }

  public final TemplateStringAtomContext templateStringAtom() throws RecognitionException {
    TemplateStringAtomContext _localctx = new TemplateStringAtomContext(_ctx, getState());
    enterRule(_localctx, 166, RULE_templateStringAtom);
    try {
      setState(1102);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case TemplateStringAtom:
          enterOuterAlt(_localctx, 1);
          {
            setState(1097);
            match(TemplateStringAtom);
          }
          break;
        case TemplateStringStartExpression:
          enterOuterAlt(_localctx, 2);
          {
            setState(1098);
            match(TemplateStringStartExpression);
            setState(1099);
            singleExpression(0);
            setState(1100);
            match(CloseBrace);
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
  public static class NumericLiteralContext extends ParserRuleContext {
    public TerminalNode DecimalLiteral() {
      return getToken(JavaScriptParserJsx.DecimalLiteral, 0);
    }

    public TerminalNode HexIntegerLiteral() {
      return getToken(JavaScriptParserJsx.HexIntegerLiteral, 0);
    }

    public TerminalNode OctalIntegerLiteral() {
      return getToken(JavaScriptParserJsx.OctalIntegerLiteral, 0);
    }

    public TerminalNode OctalIntegerLiteral2() {
      return getToken(JavaScriptParserJsx.OctalIntegerLiteral2, 0);
    }

    public TerminalNode BinaryIntegerLiteral() {
      return getToken(JavaScriptParserJsx.BinaryIntegerLiteral, 0);
    }

    public NumericLiteralContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_numericLiteral;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterNumericLiteral(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitNumericLiteral(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitNumericLiteral(this);
      else return visitor.visitChildren(this);
    }
  }

  public final NumericLiteralContext numericLiteral() throws RecognitionException {
    NumericLiteralContext _localctx = new NumericLiteralContext(_ctx, getState());
    enterRule(_localctx, 168, RULE_numericLiteral);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1104);
        _la = _input.LA(1);
        if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & -576460752303423488L) != 0))) {
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
  public static class BigintLiteralContext extends ParserRuleContext {
    public TerminalNode BigDecimalIntegerLiteral() {
      return getToken(JavaScriptParserJsx.BigDecimalIntegerLiteral, 0);
    }

    public TerminalNode BigHexIntegerLiteral() {
      return getToken(JavaScriptParserJsx.BigHexIntegerLiteral, 0);
    }

    public TerminalNode BigOctalIntegerLiteral() {
      return getToken(JavaScriptParserJsx.BigOctalIntegerLiteral, 0);
    }

    public TerminalNode BigBinaryIntegerLiteral() {
      return getToken(JavaScriptParserJsx.BigBinaryIntegerLiteral, 0);
    }

    public BigintLiteralContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_bigintLiteral;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterBigintLiteral(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitBigintLiteral(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitBigintLiteral(this);
      else return visitor.visitChildren(this);
    }
  }

  public final BigintLiteralContext bigintLiteral() throws RecognitionException {
    BigintLiteralContext _localctx = new BigintLiteralContext(_ctx, getState());
    enterRule(_localctx, 170, RULE_bigintLiteral);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1106);
        _la = _input.LA(1);
        if (!(((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 15L) != 0))) {
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
  public static class GetterContext extends ParserRuleContext {
    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public PropertyNameContext propertyName() {
      return getRuleContext(PropertyNameContext.class, 0);
    }

    public GetterContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_getter;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterGetter(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitGetter(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitGetter(this);
      else return visitor.visitChildren(this);
    }
  }

  public final GetterContext getter() throws RecognitionException {
    GetterContext _localctx = new GetterContext(_ctx, getState());
    enterRule(_localctx, 172, RULE_getter);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1108);
        identifier();
        setState(1109);
        if (!(this.p("get"))) throw new FailedPredicateException(this, "this.p(\"get\")");
        setState(1110);
        propertyName();
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
  public static class SetterContext extends ParserRuleContext {
    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public PropertyNameContext propertyName() {
      return getRuleContext(PropertyNameContext.class, 0);
    }

    public SetterContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_setter;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterSetter(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitSetter(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitSetter(this);
      else return visitor.visitChildren(this);
    }
  }

  public final SetterContext setter() throws RecognitionException {
    SetterContext _localctx = new SetterContext(_ctx, getState());
    enterRule(_localctx, 174, RULE_setter);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1112);
        identifier();
        setState(1113);
        if (!(this.p("set"))) throw new FailedPredicateException(this, "this.p(\"set\")");
        setState(1114);
        propertyName();
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
  public static class IdentifierNameContext extends ParserRuleContext {
    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public ReservedWordContext reservedWord() {
      return getRuleContext(ReservedWordContext.class, 0);
    }

    public IdentifierNameContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_identifierName;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterIdentifierName(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitIdentifierName(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitIdentifierName(this);
      else return visitor.visitChildren(this);
    }
  }

  public final IdentifierNameContext identifierName() throws RecognitionException {
    IdentifierNameContext _localctx = new IdentifierNameContext(_ctx, getState());
    enterRule(_localctx, 176, RULE_identifierName);
    try {
      setState(1118);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 124, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(1116);
            identifier();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(1117);
            reservedWord();
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
  public static class IdentifierContext extends ParserRuleContext {
    public TerminalNode Identifier() {
      return getToken(JavaScriptParserJsx.Identifier, 0);
    }

    public TerminalNode NonStrictLet() {
      return getToken(JavaScriptParserJsx.NonStrictLet, 0);
    }

    public TerminalNode Async() {
      return getToken(JavaScriptParserJsx.Async, 0);
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
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterIdentifier(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitIdentifier(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitIdentifier(this);
      else return visitor.visitChildren(this);
    }
  }

  public final IdentifierContext identifier() throws RecognitionException {
    IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
    enterRule(_localctx, 178, RULE_identifier);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1120);
        _la = _input.LA(1);
        if (!(((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & 4113L) != 0))) {
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
  public static class ReservedWordContext extends ParserRuleContext {
    public KeywordContext keyword() {
      return getRuleContext(KeywordContext.class, 0);
    }

    public TerminalNode NullLiteral() {
      return getToken(JavaScriptParserJsx.NullLiteral, 0);
    }

    public TerminalNode BooleanLiteral() {
      return getToken(JavaScriptParserJsx.BooleanLiteral, 0);
    }

    public ReservedWordContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_reservedWord;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterReservedWord(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitReservedWord(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitReservedWord(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ReservedWordContext reservedWord() throws RecognitionException {
    ReservedWordContext _localctx = new ReservedWordContext(_ctx, getState());
    enterRule(_localctx, 180, RULE_reservedWord);
    try {
      setState(1125);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case Break:
        case Do:
        case Instanceof:
        case Typeof:
        case Case:
        case Else:
        case New:
        case Var:
        case Catch:
        case Finally:
        case Return:
        case Void:
        case Continue:
        case For:
        case Switch:
        case While:
        case Debugger:
        case Function_:
        case This:
        case With:
        case Default:
        case If:
        case Throw:
        case Delete:
        case In:
        case Try:
        case As:
        case From:
        case Class:
        case Enum:
        case Extends:
        case Super:
        case Const:
        case Export:
        case Import:
        case Async:
        case Await:
        case Implements:
        case StrictLet:
        case NonStrictLet:
        case Private:
        case Public:
        case Interface:
        case Package:
        case Protected:
        case Static:
        case Yield:
          enterOuterAlt(_localctx, 1);
          {
            setState(1122);
            keyword();
          }
          break;
        case NullLiteral:
          enterOuterAlt(_localctx, 2);
          {
            setState(1123);
            match(NullLiteral);
          }
          break;
        case BooleanLiteral:
          enterOuterAlt(_localctx, 3);
          {
            setState(1124);
            match(BooleanLiteral);
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
  public static class KeywordContext extends ParserRuleContext {
    public TerminalNode Break() {
      return getToken(JavaScriptParserJsx.Break, 0);
    }

    public TerminalNode Do() {
      return getToken(JavaScriptParserJsx.Do, 0);
    }

    public TerminalNode Instanceof() {
      return getToken(JavaScriptParserJsx.Instanceof, 0);
    }

    public TerminalNode Typeof() {
      return getToken(JavaScriptParserJsx.Typeof, 0);
    }

    public TerminalNode Case() {
      return getToken(JavaScriptParserJsx.Case, 0);
    }

    public TerminalNode Else() {
      return getToken(JavaScriptParserJsx.Else, 0);
    }

    public TerminalNode New() {
      return getToken(JavaScriptParserJsx.New, 0);
    }

    public TerminalNode Var() {
      return getToken(JavaScriptParserJsx.Var, 0);
    }

    public TerminalNode Catch() {
      return getToken(JavaScriptParserJsx.Catch, 0);
    }

    public TerminalNode Finally() {
      return getToken(JavaScriptParserJsx.Finally, 0);
    }

    public TerminalNode Return() {
      return getToken(JavaScriptParserJsx.Return, 0);
    }

    public TerminalNode Void() {
      return getToken(JavaScriptParserJsx.Void, 0);
    }

    public TerminalNode Continue() {
      return getToken(JavaScriptParserJsx.Continue, 0);
    }

    public TerminalNode For() {
      return getToken(JavaScriptParserJsx.For, 0);
    }

    public TerminalNode Switch() {
      return getToken(JavaScriptParserJsx.Switch, 0);
    }

    public TerminalNode While() {
      return getToken(JavaScriptParserJsx.While, 0);
    }

    public TerminalNode Debugger() {
      return getToken(JavaScriptParserJsx.Debugger, 0);
    }

    public TerminalNode Function_() {
      return getToken(JavaScriptParserJsx.Function_, 0);
    }

    public TerminalNode This() {
      return getToken(JavaScriptParserJsx.This, 0);
    }

    public TerminalNode With() {
      return getToken(JavaScriptParserJsx.With, 0);
    }

    public TerminalNode Default() {
      return getToken(JavaScriptParserJsx.Default, 0);
    }

    public TerminalNode If() {
      return getToken(JavaScriptParserJsx.If, 0);
    }

    public TerminalNode Throw() {
      return getToken(JavaScriptParserJsx.Throw, 0);
    }

    public TerminalNode Delete() {
      return getToken(JavaScriptParserJsx.Delete, 0);
    }

    public TerminalNode In() {
      return getToken(JavaScriptParserJsx.In, 0);
    }

    public TerminalNode Try() {
      return getToken(JavaScriptParserJsx.Try, 0);
    }

    public TerminalNode Class() {
      return getToken(JavaScriptParserJsx.Class, 0);
    }

    public TerminalNode Enum() {
      return getToken(JavaScriptParserJsx.Enum, 0);
    }

    public TerminalNode Extends() {
      return getToken(JavaScriptParserJsx.Extends, 0);
    }

    public TerminalNode Super() {
      return getToken(JavaScriptParserJsx.Super, 0);
    }

    public TerminalNode Const() {
      return getToken(JavaScriptParserJsx.Const, 0);
    }

    public TerminalNode Export() {
      return getToken(JavaScriptParserJsx.Export, 0);
    }

    public TerminalNode Import() {
      return getToken(JavaScriptParserJsx.Import, 0);
    }

    public TerminalNode Implements() {
      return getToken(JavaScriptParserJsx.Implements, 0);
    }

    public Let_Context let_() {
      return getRuleContext(Let_Context.class, 0);
    }

    public TerminalNode Private() {
      return getToken(JavaScriptParserJsx.Private, 0);
    }

    public TerminalNode Public() {
      return getToken(JavaScriptParserJsx.Public, 0);
    }

    public TerminalNode Interface() {
      return getToken(JavaScriptParserJsx.Interface, 0);
    }

    public TerminalNode Package() {
      return getToken(JavaScriptParserJsx.Package, 0);
    }

    public TerminalNode Protected() {
      return getToken(JavaScriptParserJsx.Protected, 0);
    }

    public TerminalNode Static() {
      return getToken(JavaScriptParserJsx.Static, 0);
    }

    public TerminalNode Yield() {
      return getToken(JavaScriptParserJsx.Yield, 0);
    }

    public TerminalNode Async() {
      return getToken(JavaScriptParserJsx.Async, 0);
    }

    public TerminalNode Await() {
      return getToken(JavaScriptParserJsx.Await, 0);
    }

    public TerminalNode From() {
      return getToken(JavaScriptParserJsx.From, 0);
    }

    public TerminalNode As() {
      return getToken(JavaScriptParserJsx.As, 0);
    }

    public KeywordContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_keyword;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterKeyword(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitKeyword(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitKeyword(this);
      else return visitor.visitChildren(this);
    }
  }

  public final KeywordContext keyword() throws RecognitionException {
    KeywordContext _localctx = new KeywordContext(_ctx, getState());
    enterRule(_localctx, 182, RULE_keyword);
    try {
      setState(1173);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case Break:
          enterOuterAlt(_localctx, 1);
          {
            setState(1127);
            match(Break);
          }
          break;
        case Do:
          enterOuterAlt(_localctx, 2);
          {
            setState(1128);
            match(Do);
          }
          break;
        case Instanceof:
          enterOuterAlt(_localctx, 3);
          {
            setState(1129);
            match(Instanceof);
          }
          break;
        case Typeof:
          enterOuterAlt(_localctx, 4);
          {
            setState(1130);
            match(Typeof);
          }
          break;
        case Case:
          enterOuterAlt(_localctx, 5);
          {
            setState(1131);
            match(Case);
          }
          break;
        case Else:
          enterOuterAlt(_localctx, 6);
          {
            setState(1132);
            match(Else);
          }
          break;
        case New:
          enterOuterAlt(_localctx, 7);
          {
            setState(1133);
            match(New);
          }
          break;
        case Var:
          enterOuterAlt(_localctx, 8);
          {
            setState(1134);
            match(Var);
          }
          break;
        case Catch:
          enterOuterAlt(_localctx, 9);
          {
            setState(1135);
            match(Catch);
          }
          break;
        case Finally:
          enterOuterAlt(_localctx, 10);
          {
            setState(1136);
            match(Finally);
          }
          break;
        case Return:
          enterOuterAlt(_localctx, 11);
          {
            setState(1137);
            match(Return);
          }
          break;
        case Void:
          enterOuterAlt(_localctx, 12);
          {
            setState(1138);
            match(Void);
          }
          break;
        case Continue:
          enterOuterAlt(_localctx, 13);
          {
            setState(1139);
            match(Continue);
          }
          break;
        case For:
          enterOuterAlt(_localctx, 14);
          {
            setState(1140);
            match(For);
          }
          break;
        case Switch:
          enterOuterAlt(_localctx, 15);
          {
            setState(1141);
            match(Switch);
          }
          break;
        case While:
          enterOuterAlt(_localctx, 16);
          {
            setState(1142);
            match(While);
          }
          break;
        case Debugger:
          enterOuterAlt(_localctx, 17);
          {
            setState(1143);
            match(Debugger);
          }
          break;
        case Function_:
          enterOuterAlt(_localctx, 18);
          {
            setState(1144);
            match(Function_);
          }
          break;
        case This:
          enterOuterAlt(_localctx, 19);
          {
            setState(1145);
            match(This);
          }
          break;
        case With:
          enterOuterAlt(_localctx, 20);
          {
            setState(1146);
            match(With);
          }
          break;
        case Default:
          enterOuterAlt(_localctx, 21);
          {
            setState(1147);
            match(Default);
          }
          break;
        case If:
          enterOuterAlt(_localctx, 22);
          {
            setState(1148);
            match(If);
          }
          break;
        case Throw:
          enterOuterAlt(_localctx, 23);
          {
            setState(1149);
            match(Throw);
          }
          break;
        case Delete:
          enterOuterAlt(_localctx, 24);
          {
            setState(1150);
            match(Delete);
          }
          break;
        case In:
          enterOuterAlt(_localctx, 25);
          {
            setState(1151);
            match(In);
          }
          break;
        case Try:
          enterOuterAlt(_localctx, 26);
          {
            setState(1152);
            match(Try);
          }
          break;
        case Class:
          enterOuterAlt(_localctx, 27);
          {
            setState(1153);
            match(Class);
          }
          break;
        case Enum:
          enterOuterAlt(_localctx, 28);
          {
            setState(1154);
            match(Enum);
          }
          break;
        case Extends:
          enterOuterAlt(_localctx, 29);
          {
            setState(1155);
            match(Extends);
          }
          break;
        case Super:
          enterOuterAlt(_localctx, 30);
          {
            setState(1156);
            match(Super);
          }
          break;
        case Const:
          enterOuterAlt(_localctx, 31);
          {
            setState(1157);
            match(Const);
          }
          break;
        case Export:
          enterOuterAlt(_localctx, 32);
          {
            setState(1158);
            match(Export);
          }
          break;
        case Import:
          enterOuterAlt(_localctx, 33);
          {
            setState(1159);
            match(Import);
          }
          break;
        case Implements:
          enterOuterAlt(_localctx, 34);
          {
            setState(1160);
            match(Implements);
          }
          break;
        case StrictLet:
        case NonStrictLet:
          enterOuterAlt(_localctx, 35);
          {
            setState(1161);
            let_();
          }
          break;
        case Private:
          enterOuterAlt(_localctx, 36);
          {
            setState(1162);
            match(Private);
          }
          break;
        case Public:
          enterOuterAlt(_localctx, 37);
          {
            setState(1163);
            match(Public);
          }
          break;
        case Interface:
          enterOuterAlt(_localctx, 38);
          {
            setState(1164);
            match(Interface);
          }
          break;
        case Package:
          enterOuterAlt(_localctx, 39);
          {
            setState(1165);
            match(Package);
          }
          break;
        case Protected:
          enterOuterAlt(_localctx, 40);
          {
            setState(1166);
            match(Protected);
          }
          break;
        case Static:
          enterOuterAlt(_localctx, 41);
          {
            setState(1167);
            match(Static);
          }
          break;
        case Yield:
          enterOuterAlt(_localctx, 42);
          {
            setState(1168);
            match(Yield);
          }
          break;
        case Async:
          enterOuterAlt(_localctx, 43);
          {
            setState(1169);
            match(Async);
          }
          break;
        case Await:
          enterOuterAlt(_localctx, 44);
          {
            setState(1170);
            match(Await);
          }
          break;
        case From:
          enterOuterAlt(_localctx, 45);
          {
            setState(1171);
            match(From);
          }
          break;
        case As:
          enterOuterAlt(_localctx, 46);
          {
            setState(1172);
            match(As);
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
  public static class Let_Context extends ParserRuleContext {
    public TerminalNode NonStrictLet() {
      return getToken(JavaScriptParserJsx.NonStrictLet, 0);
    }

    public TerminalNode StrictLet() {
      return getToken(JavaScriptParserJsx.StrictLet, 0);
    }

    public Let_Context(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_let_;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterLet_(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitLet_(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitLet_(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Let_Context let_() throws RecognitionException {
    Let_Context _localctx = new Let_Context(_ctx, getState());
    enterRule(_localctx, 184, RULE_let_);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1175);
        _la = _input.LA(1);
        if (!(_la == StrictLet || _la == NonStrictLet)) {
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
  public static class EosContext extends ParserRuleContext {
    public TerminalNode SemiColon() {
      return getToken(JavaScriptParserJsx.SemiColon, 0);
    }

    public TerminalNode EOF() {
      return getToken(JavaScriptParserJsx.EOF, 0);
    }

    public EosContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_eos;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).enterEos(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof JavaScriptParserJsxListener)
        ((JavaScriptParserJsxListener) listener).exitEos(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof JavaScriptParserJsxVisitor)
        return ((JavaScriptParserJsxVisitor<? extends T>) visitor).visitEos(this);
      else return visitor.visitChildren(this);
    }
  }

  public final EosContext eos() throws RecognitionException {
    EosContext _localctx = new EosContext(_ctx, getState());
    enterRule(_localctx, 186, RULE_eos);
    try {
      setState(1181);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 127, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(1177);
            match(SemiColon);
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(1178);
            match(EOF);
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(1179);
            if (!(this.lineTerminatorAhead()))
              throw new FailedPredicateException(this, "this.lineTerminatorAhead()");
          }
          break;
        case 4:
          enterOuterAlt(_localctx, 4);
          {
            setState(1180);
            if (!(this.closeBrace())) throw new FailedPredicateException(this, "this.closeBrace()");
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

  public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
    switch (ruleIndex) {
      case 19:
        return expressionStatement_sempred((ExpressionStatementContext) _localctx, predIndex);
      case 21:
        return iterationStatement_sempred((IterationStatementContext) _localctx, predIndex);
      case 23:
        return continueStatement_sempred((ContinueStatementContext) _localctx, predIndex);
      case 24:
        return breakStatement_sempred((BreakStatementContext) _localctx, predIndex);
      case 25:
        return returnStatement_sempred((ReturnStatementContext) _localctx, predIndex);
      case 26:
        return yieldStatement_sempred((YieldStatementContext) _localctx, predIndex);
      case 34:
        return throwStatement_sempred((ThrowStatementContext) _localctx, predIndex);
      case 42:
        return classElement_sempred((ClassElementContext) _localctx, predIndex);
      case 57:
        return singleExpression_sempred((SingleExpressionContext) _localctx, predIndex);
      case 67:
        return jsxClosingElementName_sempred((JsxClosingElementNameContext) _localctx, predIndex);
      case 86:
        return getter_sempred((GetterContext) _localctx, predIndex);
      case 87:
        return setter_sempred((SetterContext) _localctx, predIndex);
      case 93:
        return eos_sempred((EosContext) _localctx, predIndex);
    }
    return true;
  }

  private boolean expressionStatement_sempred(ExpressionStatementContext _localctx, int predIndex) {
    switch (predIndex) {
      case 0:
        return this.notOpenBraceAndNotFunction();
    }
    return true;
  }

  private boolean iterationStatement_sempred(IterationStatementContext _localctx, int predIndex) {
    switch (predIndex) {
      case 1:
        return this.p("of");
    }
    return true;
  }

  private boolean continueStatement_sempred(ContinueStatementContext _localctx, int predIndex) {
    switch (predIndex) {
      case 2:
        return this.notLineTerminator();
    }
    return true;
  }

  private boolean breakStatement_sempred(BreakStatementContext _localctx, int predIndex) {
    switch (predIndex) {
      case 3:
        return this.notLineTerminator();
    }
    return true;
  }

  private boolean returnStatement_sempred(ReturnStatementContext _localctx, int predIndex) {
    switch (predIndex) {
      case 4:
        return this.notLineTerminator();
    }
    return true;
  }

  private boolean yieldStatement_sempred(YieldStatementContext _localctx, int predIndex) {
    switch (predIndex) {
      case 5:
        return this.notLineTerminator();
    }
    return true;
  }

  private boolean throwStatement_sempred(ThrowStatementContext _localctx, int predIndex) {
    switch (predIndex) {
      case 6:
        return this.notLineTerminator();
    }
    return true;
  }

  private boolean classElement_sempred(ClassElementContext _localctx, int predIndex) {
    switch (predIndex) {
      case 7:
        return this.n("static");
    }
    return true;
  }

  private boolean singleExpression_sempred(SingleExpressionContext _localctx, int predIndex) {
    switch (predIndex) {
      case 8:
        return precpred(_ctx, 28);
      case 9:
        return precpred(_ctx, 27);
      case 10:
        return precpred(_ctx, 26);
      case 11:
        return precpred(_ctx, 25);
      case 12:
        return precpred(_ctx, 24);
      case 13:
        return precpred(_ctx, 23);
      case 14:
        return precpred(_ctx, 22);
      case 15:
        return precpred(_ctx, 21);
      case 16:
        return precpred(_ctx, 20);
      case 17:
        return precpred(_ctx, 19);
      case 18:
        return precpred(_ctx, 18);
      case 19:
        return precpred(_ctx, 17);
      case 20:
        return precpred(_ctx, 16);
      case 21:
        return precpred(_ctx, 15);
      case 22:
        return precpred(_ctx, 14);
      case 23:
        return precpred(_ctx, 13);
      case 24:
        return precpred(_ctx, 12);
      case 25:
        return precpred(_ctx, 46);
      case 26:
        return precpred(_ctx, 45);
      case 27:
        return precpred(_ctx, 42);
      case 28:
        return precpred(_ctx, 40);
      case 29:
        return this.notLineTerminator();
      case 30:
        return precpred(_ctx, 39);
      case 31:
        return this.notLineTerminator();
      case 32:
        return precpred(_ctx, 10);
    }
    return true;
  }

  private boolean jsxClosingElementName_sempred(
      JsxClosingElementNameContext _localctx, int predIndex) {
    switch (predIndex) {
      case 33:
        return this.popHtmlTagName(
            (((JsxClosingElementNameContext) _localctx).JsxClosingElementId != null
                ? ((JsxClosingElementNameContext) _localctx).JsxClosingElementId.getText()
                : null));
    }
    return true;
  }

  private boolean getter_sempred(GetterContext _localctx, int predIndex) {
    switch (predIndex) {
      case 34:
        return this.p("get");
    }
    return true;
  }

  private boolean setter_sempred(SetterContext _localctx, int predIndex) {
    switch (predIndex) {
      case 35:
        return this.p("set");
    }
    return true;
  }

  private boolean eos_sempred(EosContext _localctx, int predIndex) {
    switch (predIndex) {
      case 36:
        return this.lineTerminatorAhead();
      case 37:
        return this.closeBrace();
    }
    return true;
  }

  public static final String _serializedATN =
      "\u0004\u0001\u0096\u04a0\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"
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
          + "Y\u0002Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007]\u0001\u0000"
          + "\u0003\u0000\u00be\b\u0000\u0001\u0000\u0003\u0000\u00c1\b\u0000\u0001"
          + "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"
          + "\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"
          + "\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"
          + "\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"
          + "\u0002\u00db\b\u0002\u0001\u0003\u0001\u0003\u0003\u0003\u00df\b\u0003"
          + "\u0001\u0003\u0001\u0003\u0001\u0004\u0004\u0004\u00e4\b\u0004\u000b\u0004"
          + "\f\u0004\u00e5\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0003\u0006"
          + "\u00ec\b\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00f0\b\u0006\u0001"
          + "\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00f7"
          + "\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u00fd"
          + "\b\u0007\n\u0007\f\u0007\u0100\t\u0007\u0001\u0007\u0001\u0007\u0003\u0007"
          + "\u0104\b\u0007\u0003\u0007\u0106\b\u0007\u0001\u0007\u0001\u0007\u0001"
          + "\b\u0001\b\u0001\b\u0001\t\u0001\t\u0003\t\u010f\b\t\u0001\t\u0001\t\u0003"
          + "\t\u0113\b\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"
          + "\u0003\u000b\u011b\b\u000b\u0001\f\u0001\f\u0001\f\u0003\f\u0120\b\f\u0001"
          + "\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0129\b\f\u0001"
          + "\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u0131\b\r\u0001\r\u0001"
          + "\r\u0003\r\u0135\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u013a"
          + "\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"
          + "\u0010\u0001\u0010\u0005\u0010\u0143\b\u0010\n\u0010\f\u0010\u0146\t\u0010"
          + "\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u014b\b\u0011\u0001\u0012"
          + "\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014"
          + "\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"
          + "\u0003\u0014\u015a\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"
          + "\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"
          + "\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"
          + "\u0001\u0015\u0001\u0015\u0003\u0015\u016e\b\u0015\u0001\u0015\u0001\u0015"
          + "\u0003\u0015\u0172\b\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0176\b"
          + "\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"
          + "\u0015\u0003\u0015\u017e\b\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"
          + "\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0187\b\u0015\u0001"
          + "\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u018c\b\u0015\u0001\u0015\u0001"
          + "\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0194"
          + "\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u0199\b\u0016"
          + "\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u019e\b\u0017\u0001\u0017"
          + "\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u01a5\b\u0018"
          + "\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019"
          + "\u01ac\b\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"
          + "\u0001\u0019\u0001\u0019\u0003\u0019\u01b5\b\u0019\u0001\u001a\u0001\u001a"
          + "\u0001\u001a\u0003\u001a\u01ba\b\u001a\u0001\u001a\u0001\u001a\u0001\u001b"
          + "\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c"
          + "\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d"
          + "\u0001\u001d\u0003\u001d\u01cc\b\u001d\u0001\u001d\u0001\u001d\u0003\u001d"
          + "\u01d0\b\u001d\u0003\u001d\u01d2\b\u001d\u0001\u001d\u0001\u001d\u0001"
          + "\u001e\u0004\u001e\u01d7\b\u001e\u000b\u001e\f\u001e\u01d8\u0001\u001f"
          + "\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u01df\b\u001f\u0001 "
          + "\u0001 \u0001 \u0003 \u01e4\b \u0001!\u0001!\u0001!\u0001!\u0001\"\u0001"
          + "\"\u0001\"\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001#\u0003#\u01f3\b"
          + "#\u0001#\u0003#\u01f6\b#\u0001$\u0001$\u0001$\u0003$\u01fb\b$\u0001$\u0003"
          + "$\u01fe\b$\u0001$\u0001$\u0001%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001"
          + "\'\u0003\'\u0209\b\'\u0001\'\u0001\'\u0003\'\u020d\b\'\u0001\'\u0001\'"
          + "\u0001\'\u0003\'\u0212\b\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001"
          + "(\u0001(\u0001(\u0001(\u0001)\u0001)\u0003)\u021f\b)\u0001)\u0001)\u0005"
          + ")\u0223\b)\n)\f)\u0226\t)\u0001)\u0001)\u0001*\u0001*\u0001*\u0001*\u0005"
          + "*\u022e\b*\n*\f*\u0231\t*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0003"
          + "*\u0239\b*\u0001*\u0001*\u0003*\u023d\b*\u0001*\u0001*\u0001*\u0001*\u0003"
          + "*\u0243\b*\u0001+\u0003+\u0246\b+\u0001+\u0003+\u0249\b+\u0001+\u0001"
          + "+\u0001+\u0003+\u024e\b+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0003"
          + "+\u0256\b+\u0001+\u0003+\u0259\b+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001"
          + "+\u0001+\u0001+\u0003+\u0263\b+\u0001+\u0003+\u0266\b+\u0001+\u0001+\u0001"
          + "+\u0003+\u026b\b+\u0001+\u0001+\u0001+\u0001+\u0001+\u0003+\u0272\b+\u0001"
          + ",\u0001,\u0001,\u0005,\u0277\b,\n,\f,\u027a\t,\u0001,\u0001,\u0003,\u027e"
          + "\b,\u0001,\u0003,\u0281\b,\u0001-\u0001-\u0001-\u0003-\u0286\b-\u0001"
          + ".\u0001.\u0001.\u0001/\u0003/\u028c\b/\u00010\u00040\u028f\b0\u000b0\f"
          + "0\u0290\u00011\u00011\u00011\u00011\u00012\u00052\u0298\b2\n2\f2\u029b"
          + "\t2\u00012\u00032\u029e\b2\u00012\u00042\u02a1\b2\u000b2\f2\u02a2\u0001"
          + "2\u00052\u02a6\b2\n2\f2\u02a9\t2\u00012\u00052\u02ac\b2\n2\f2\u02af\t"
          + "2\u00013\u00033\u02b2\b3\u00013\u00013\u00014\u00014\u00014\u00014\u0001"
          + "4\u00014\u00014\u00014\u00014\u00014\u00014\u00034\u02c1\b4\u00014\u0003"
          + "4\u02c4\b4\u00014\u00014\u00014\u00034\u02c9\b4\u00014\u00014\u00014\u0001"
          + "4\u00014\u00014\u00014\u00014\u00014\u00014\u00014\u00014\u00014\u0001"
          + "4\u00014\u00014\u00014\u00014\u00014\u00014\u00014\u00034\u02e0\b4\u0001"
          + "4\u00034\u02e3\b4\u00015\u00015\u00015\u00015\u00015\u00015\u00015\u0003"
          + "5\u02ec\b5\u00016\u00016\u00016\u00016\u00056\u02f2\b6\n6\f6\u02f5\t6"
          + "\u00016\u00036\u02f8\b6\u00036\u02fa\b6\u00016\u00016\u00017\u00037\u02ff"
          + "\b7\u00017\u00017\u00037\u0303\b7\u00018\u00038\u0306\b8\u00018\u0001"
          + "8\u00018\u00038\u030b\b8\u00018\u00058\u030e\b8\n8\f8\u0311\t8\u00019"
          + "\u00019\u00019\u00019\u00039\u0317\b9\u00019\u00019\u00019\u00019\u0001"
          + "9\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u0001"
          + "9\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u0001"
          + "9\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u0001"
          + "9\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u0001"
          + "9\u00019\u00019\u00039\u0348\b9\u00019\u00019\u00019\u00019\u00019\u0001"
          + "9\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u0001"
          + "9\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u0001"
          + "9\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u0001"
          + "9\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u0001"
          + "9\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u0001"
          + "9\u00019\u00019\u00019\u00019\u00019\u00019\u00039\u0388\b9\u00019\u0001"
          + "9\u00039\u038c\b9\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u0001"
          + "9\u00019\u00019\u00019\u00059\u0399\b9\n9\f9\u039c\t9\u0001:\u0004:\u039f"
          + "\b:\u000b:\f:\u03a0\u0001;\u0001;\u0001<\u0001<\u0001<\u0001<\u0001<\u0003"
          + "<\u03aa\b<\u0001=\u0001=\u0001=\u0003=\u03af\b=\u0001=\u0001=\u0001>\u0001"
          + ">\u0001>\u0003>\u03b6\b>\u0001>\u0001>\u0001?\u0001?\u0001?\u0001?\u0001"
          + "@\u0003@\u03bf\b@\u0001@\u0001@\u0003@\u03c3\b@\u0001@\u0003@\u03c6\b"
          + "@\u0005@\u03c8\b@\n@\f@\u03cb\t@\u0001A\u0001A\u0001B\u0001B\u0001B\u0001"
          + "C\u0001C\u0001C\u0001D\u0001D\u0003D\u03d7\bD\u0001D\u0001D\u0003D\u03db"
          + "\bD\u0003D\u03dd\bD\u0001E\u0001E\u0001E\u0001E\u0001E\u0001F\u0001F\u0001"
          + "F\u0001F\u0001F\u0003F\u03e9\bF\u0001G\u0001G\u0001H\u0001H\u0001H\u0003"
          + "H\u03f0\bH\u0001I\u0001I\u0001I\u0003I\u03f5\bI\u0001J\u0001J\u0001J\u0001"
          + "J\u0005J\u03fb\bJ\nJ\fJ\u03fe\tJ\u0001J\u0003J\u0401\bJ\u0003J\u0403\b"
          + "J\u0001J\u0001J\u0001K\u0001K\u0001L\u0001L\u0001L\u0001L\u0001M\u0001"
          + "M\u0003M\u040f\bM\u0001M\u0001M\u0003M\u0413\bM\u0001M\u0001M\u0003M\u0417"
          + "\bM\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0003M\u041f\bM\u0001M\u0001"
          + "M\u0001M\u0001M\u0003M\u0425\bM\u0001N\u0001N\u0001N\u0003N\u042a\bN\u0001"
          + "N\u0003N\u042d\bN\u0001O\u0001O\u0001O\u0001O\u0001O\u0003O\u0434\bO\u0001"
          + "P\u0001P\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0003Q\u043f"
          + "\bQ\u0001R\u0001R\u0005R\u0443\bR\nR\fR\u0446\tR\u0001R\u0001R\u0001S"
          + "\u0001S\u0001S\u0001S\u0001S\u0003S\u044f\bS\u0001T\u0001T\u0001U\u0001"
          + "U\u0001V\u0001V\u0001V\u0001V\u0001W\u0001W\u0001W\u0001W\u0001X\u0001"
          + "X\u0003X\u045f\bX\u0001Y\u0001Y\u0001Z\u0001Z\u0001Z\u0003Z\u0466\bZ\u0001"
          + "[\u0001[\u0001[\u0001[\u0001[\u0001[\u0001[\u0001[\u0001[\u0001[\u0001"
          + "[\u0001[\u0001[\u0001[\u0001[\u0001[\u0001[\u0001[\u0001[\u0001[\u0001"
          + "[\u0001[\u0001[\u0001[\u0001[\u0001[\u0001[\u0001[\u0001[\u0001[\u0001"
          + "[\u0001[\u0001[\u0001[\u0001[\u0001[\u0001[\u0001[\u0001[\u0001[\u0001"
          + "[\u0001[\u0001[\u0001[\u0001[\u0001[\u0003[\u0496\b[\u0001\\\u0001\\\u0001"
          + "]\u0001]\u0001]\u0001]\u0003]\u049e\b]\u0001]\u0000\u0001r^\u0000\u0002"
          + "\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"
          + " \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086"
          + "\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e"
          + "\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6"
          + "\u00b8\u00ba\u0000\r\u0002\u0000``ss\u0001\u0000\u0016\u0018\u0001\u0000"
          + "\u0012\u0013\u0001\u0000\u001c\u001e\u0001\u0000\u001f\"\u0001\u0000#"
          + "&\u0003\u0000\u0002\u0002\u0084\u0084\u0090\u0090\u0003\u0000\u0007\u0007"
          + "\u0088\u0088\u0092\u0092\u0001\u0000,7\u0001\u0000;?\u0001\u0000@C\u0003"
          + "\u0000hhlltt\u0001\u0000kl\u0545\u0000\u00bd\u0001\u0000\u0000\u0000\u0002"
          + "\u00c4\u0001\u0000\u0000\u0000\u0004\u00da\u0001\u0000\u0000\u0000\u0006"
          + "\u00dc\u0001\u0000\u0000\u0000\b\u00e3\u0001\u0000\u0000\u0000\n\u00e7"
          + "\u0001\u0000\u0000\u0000\f\u00f6\u0001\u0000\u0000\u0000\u000e\u00f8\u0001"
          + "\u0000\u0000\u0000\u0010\u0109\u0001\u0000\u0000\u0000\u0012\u010e\u0001"
          + "\u0000\u0000\u0000\u0014\u0114\u0001\u0000\u0000\u0000\u0016\u0117\u0001"
          + "\u0000\u0000\u0000\u0018\u0128\u0001\u0000\u0000\u0000\u001a\u0134\u0001"
          + "\u0000\u0000\u0000\u001c\u0139\u0001\u0000\u0000\u0000\u001e\u013b\u0001"
          + "\u0000\u0000\u0000 \u013e\u0001\u0000\u0000\u0000\"\u0147\u0001\u0000"
          + "\u0000\u0000$\u014c\u0001\u0000\u0000\u0000&\u014e\u0001\u0000\u0000\u0000"
          + "(\u0152\u0001\u0000\u0000\u0000*\u0193\u0001\u0000\u0000\u0000,\u0198"
          + "\u0001\u0000\u0000\u0000.\u019a\u0001\u0000\u0000\u00000\u01a1\u0001\u0000"
          + "\u0000\u00002\u01b4\u0001\u0000\u0000\u00004\u01b6\u0001\u0000\u0000\u0000"
          + "6\u01bd\u0001\u0000\u0000\u00008\u01c3\u0001\u0000\u0000\u0000:\u01c9"
          + "\u0001\u0000\u0000\u0000<\u01d6\u0001\u0000\u0000\u0000>\u01da\u0001\u0000"
          + "\u0000\u0000@\u01e0\u0001\u0000\u0000\u0000B\u01e5\u0001\u0000\u0000\u0000"
          + "D\u01e9\u0001\u0000\u0000\u0000F\u01ee\u0001\u0000\u0000\u0000H\u01f7"
          + "\u0001\u0000\u0000\u0000J\u0201\u0001\u0000\u0000\u0000L\u0204\u0001\u0000"
          + "\u0000\u0000N\u0208\u0001\u0000\u0000\u0000P\u0218\u0001\u0000\u0000\u0000"
          + "R\u021e\u0001\u0000\u0000\u0000T\u0242\u0001\u0000\u0000\u0000V\u0271"
          + "\u0001\u0000\u0000\u0000X\u0280\u0001\u0000\u0000\u0000Z\u0282\u0001\u0000"
          + "\u0000\u0000\\\u0287\u0001\u0000\u0000\u0000^\u028b\u0001\u0000\u0000"
          + "\u0000`\u028e\u0001\u0000\u0000\u0000b\u0292\u0001\u0000\u0000\u0000d"
          + "\u0299\u0001\u0000\u0000\u0000f\u02b1\u0001\u0000\u0000\u0000h\u02e2\u0001"
          + "\u0000\u0000\u0000j\u02eb\u0001\u0000\u0000\u0000l\u02ed\u0001\u0000\u0000"
          + "\u0000n\u02fe\u0001\u0000\u0000\u0000p\u0305\u0001\u0000\u0000\u0000r"
          + "\u0347\u0001\u0000\u0000\u0000t\u039e\u0001\u0000\u0000\u0000v\u03a2\u0001"
          + "\u0000\u0000\u0000x\u03a9\u0001\u0000\u0000\u0000z\u03ab\u0001\u0000\u0000"
          + "\u0000|\u03b2\u0001\u0000\u0000\u0000~\u03b9\u0001\u0000\u0000\u0000\u0080"
          + "\u03be\u0001\u0000\u0000\u0000\u0082\u03cc\u0001\u0000\u0000\u0000\u0084"
          + "\u03ce\u0001\u0000\u0000\u0000\u0086\u03d1\u0001\u0000\u0000\u0000\u0088"
          + "\u03dc\u0001\u0000\u0000\u0000\u008a\u03de\u0001\u0000\u0000\u0000\u008c"
          + "\u03e8\u0001\u0000\u0000\u0000\u008e\u03ea\u0001\u0000\u0000\u0000\u0090"
          + "\u03ef\u0001\u0000\u0000\u0000\u0092\u03f4\u0001\u0000\u0000\u0000\u0094"
          + "\u03f6\u0001\u0000\u0000\u0000\u0096\u0406\u0001\u0000\u0000\u0000\u0098"
          + "\u0408\u0001\u0000\u0000\u0000\u009a\u0424\u0001\u0000\u0000\u0000\u009c"
          + "\u042c\u0001\u0000\u0000\u0000\u009e\u0433\u0001\u0000\u0000\u0000\u00a0"
          + "\u0435\u0001\u0000\u0000\u0000\u00a2\u043e\u0001\u0000\u0000\u0000\u00a4"
          + "\u0440\u0001\u0000\u0000\u0000\u00a6\u044e\u0001\u0000\u0000\u0000\u00a8"
          + "\u0450\u0001\u0000\u0000\u0000\u00aa\u0452\u0001\u0000\u0000\u0000\u00ac"
          + "\u0454\u0001\u0000\u0000\u0000\u00ae\u0458\u0001\u0000\u0000\u0000\u00b0"
          + "\u045e\u0001\u0000\u0000\u0000\u00b2\u0460\u0001\u0000\u0000\u0000\u00b4"
          + "\u0465\u0001\u0000\u0000\u0000\u00b6\u0495\u0001\u0000\u0000\u0000\u00b8"
          + "\u0497\u0001\u0000\u0000\u0000\u00ba\u049d\u0001\u0000\u0000\u0000\u00bc"
          + "\u00be\u0005\u0001\u0000\u0000\u00bd\u00bc\u0001\u0000\u0000\u0000\u00bd"
          + "\u00be\u0001\u0000\u0000\u0000\u00be\u00c0\u0001\u0000\u0000\u0000\u00bf"
          + "\u00c1\u0003`0\u0000\u00c0\u00bf\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001"
          + "\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005"
          + "\u0000\u0000\u0001\u00c3\u0001\u0001\u0000\u0000\u0000\u00c4\u00c5\u0003"
          + "\u0004\u0002\u0000\u00c5\u0003\u0001\u0000\u0000\u0000\u00c6\u00db\u0003"
          + "\u0006\u0003\u0000\u00c7\u00db\u0003\u001e\u000f\u0000\u00c8\u00db\u0003"
          + "\n\u0005\u0000\u00c9\u00db\u0003\u0018\f\u0000\u00ca\u00db\u0003$\u0012"
          + "\u0000\u00cb\u00db\u0003P(\u0000\u00cc\u00db\u0003&\u0013\u0000\u00cd"
          + "\u00db\u0003(\u0014\u0000\u00ce\u00db\u0003*\u0015\u0000\u00cf\u00db\u0003"
          + ".\u0017\u0000\u00d0\u00db\u00030\u0018\u0000\u00d1\u00db\u00032\u0019"
          + "\u0000\u00d2\u00db\u00034\u001a\u0000\u00d3\u00db\u00036\u001b\u0000\u00d4"
          + "\u00db\u0003B!\u0000\u00d5\u00db\u00038\u001c\u0000\u00d6\u00db\u0003"
          + "D\"\u0000\u00d7\u00db\u0003F#\u0000\u00d8\u00db\u0003L&\u0000\u00d9\u00db"
          + "\u0003N\'\u0000\u00da\u00c6\u0001\u0000\u0000\u0000\u00da\u00c7\u0001"
          + "\u0000\u0000\u0000\u00da\u00c8\u0001\u0000\u0000\u0000\u00da\u00c9\u0001"
          + "\u0000\u0000\u0000\u00da\u00ca\u0001\u0000\u0000\u0000\u00da\u00cb\u0001"
          + "\u0000\u0000\u0000\u00da\u00cc\u0001\u0000\u0000\u0000\u00da\u00cd\u0001"
          + "\u0000\u0000\u0000\u00da\u00ce\u0001\u0000\u0000\u0000\u00da\u00cf\u0001"
          + "\u0000\u0000\u0000\u00da\u00d0\u0001\u0000\u0000\u0000\u00da\u00d1\u0001"
          + "\u0000\u0000\u0000\u00da\u00d2\u0001\u0000\u0000\u0000\u00da\u00d3\u0001"
          + "\u0000\u0000\u0000\u00da\u00d4\u0001\u0000\u0000\u0000\u00da\u00d5\u0001"
          + "\u0000\u0000\u0000\u00da\u00d6\u0001\u0000\u0000\u0000\u00da\u00d7\u0001"
          + "\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00da\u00d9\u0001"
          + "\u0000\u0000\u0000\u00db\u0005\u0001\u0000\u0000\u0000\u00dc\u00de\u0005"
          + "\u0007\u0000\u0000\u00dd\u00df\u0003\b\u0004\u0000\u00de\u00dd\u0001\u0000"
          + "\u0000\u0000\u00de\u00df\u0001\u0000\u0000\u0000\u00df\u00e0\u0001\u0000"
          + "\u0000\u0000\u00e0\u00e1\u0005\b\u0000\u0000\u00e1\u0007\u0001\u0000\u0000"
          + "\u0000\u00e2\u00e4\u0003\u0004\u0002\u0000\u00e3\u00e2\u0001\u0000\u0000"
          + "\u0000\u00e4\u00e5\u0001\u0000\u0000\u0000\u00e5\u00e3\u0001\u0000\u0000"
          + "\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6\t\u0001\u0000\u0000\u0000"
          + "\u00e7\u00e8\u0005g\u0000\u0000\u00e8\u00e9\u0003\f\u0006\u0000\u00e9"
          + "\u000b\u0001\u0000\u0000\u0000\u00ea\u00ec\u0003\u0010\b\u0000\u00eb\u00ea"
          + "\u0001\u0000\u0000\u0000\u00eb\u00ec\u0001\u0000\u0000\u0000\u00ec\u00ef"
          + "\u0001\u0000\u0000\u0000\u00ed\u00f0\u0003\u0012\t\u0000\u00ee\u00f0\u0003"
          + "\u000e\u0007\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000\u00ef\u00ee\u0001"
          + "\u0000\u0000\u0000\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1\u00f2\u0003"
          + "\u0014\n\u0000\u00f2\u00f3\u0003\u00ba]\u0000\u00f3\u00f7\u0001\u0000"
          + "\u0000\u0000\u00f4\u00f5\u0005u\u0000\u0000\u00f5\u00f7\u0003\u00ba]\u0000"
          + "\u00f6\u00eb\u0001\u0000\u0000\u0000\u00f6\u00f4\u0001\u0000\u0000\u0000"
          + "\u00f7\r\u0001\u0000\u0000\u0000\u00f8\u00fe\u0005\u0007\u0000\u0000\u00f9"
          + "\u00fa\u0003\u0016\u000b\u0000\u00fa\u00fb\u0005\n\u0000\u0000\u00fb\u00fd"
          + "\u0001\u0000\u0000\u0000\u00fc\u00f9\u0001\u0000\u0000\u0000\u00fd\u0100"
          + "\u0001\u0000\u0000\u0000\u00fe\u00fc\u0001\u0000\u0000\u0000\u00fe\u00ff"
          + "\u0001\u0000\u0000\u0000\u00ff\u0105\u0001\u0000\u0000\u0000\u0100\u00fe"
          + "\u0001\u0000\u0000\u0000\u0101\u0103\u0003\u0016\u000b\u0000\u0102\u0104"
          + "\u0005\n\u0000\u0000\u0103\u0102\u0001\u0000\u0000\u0000\u0103\u0104\u0001"
          + "\u0000\u0000\u0000\u0104\u0106\u0001\u0000\u0000\u0000\u0105\u0101\u0001"
          + "\u0000\u0000\u0000\u0105\u0106\u0001\u0000\u0000\u0000\u0106\u0107\u0001"
          + "\u0000\u0000\u0000\u0107\u0108\u0005\b\u0000\u0000\u0108\u000f\u0001\u0000"
          + "\u0000\u0000\u0109\u010a\u0003\u0016\u000b\u0000\u010a\u010b\u0005\n\u0000"
          + "\u0000\u010b\u0011\u0001\u0000\u0000\u0000\u010c\u010f\u0005\u0016\u0000"
          + "\u0000\u010d\u010f\u0003\u00b0X\u0000\u010e\u010c\u0001\u0000\u0000\u0000"
          + "\u010e\u010d\u0001\u0000\u0000\u0000\u010f\u0112\u0001\u0000\u0000\u0000"
          + "\u0110\u0111\u0005^\u0000\u0000\u0111\u0113\u0003\u00b0X\u0000\u0112\u0110"
          + "\u0001\u0000\u0000\u0000\u0112\u0113\u0001\u0000\u0000\u0000\u0113\u0013"
          + "\u0001\u0000\u0000\u0000\u0114\u0115\u0005_\u0000\u0000\u0115\u0116\u0005"
          + "u\u0000\u0000\u0116\u0015\u0001\u0000\u0000\u0000\u0117\u011a\u0003\u00b0"
          + "X\u0000\u0118\u0119\u0005^\u0000\u0000\u0119\u011b\u0003\u00b0X\u0000"
          + "\u011a\u0118\u0001\u0000\u0000\u0000\u011a\u011b\u0001\u0000\u0000\u0000"
          + "\u011b\u0017\u0001\u0000\u0000\u0000\u011c\u011f\u0005f\u0000\u0000\u011d"
          + "\u0120\u0003\u001a\r\u0000\u011e\u0120\u0003\u001c\u000e\u0000\u011f\u011d"
          + "\u0001\u0000\u0000\u0000\u011f\u011e\u0001\u0000\u0000\u0000\u0120\u0121"
          + "\u0001\u0000\u0000\u0000\u0121\u0122\u0003\u00ba]\u0000\u0122\u0129\u0001"
          + "\u0000\u0000\u0000\u0123\u0124\u0005f\u0000\u0000\u0124\u0125\u0005X\u0000"
          + "\u0000\u0125\u0126\u0003r9\u0000\u0126\u0127\u0003\u00ba]\u0000\u0127"
          + "\u0129\u0001\u0000\u0000\u0000\u0128\u011c\u0001\u0000\u0000\u0000\u0128"
          + "\u0123\u0001\u0000\u0000\u0000\u0129\u0019\u0001\u0000\u0000\u0000\u012a"
          + "\u012b\u0003\u0012\t\u0000\u012b\u012c\u0003\u0014\n\u0000\u012c\u012d"
          + "\u0003\u00ba]\u0000\u012d\u0135\u0001\u0000\u0000\u0000\u012e\u0130\u0003"
          + "\u000e\u0007\u0000\u012f\u0131\u0003\u0014\n\u0000\u0130\u012f\u0001\u0000"
          + "\u0000\u0000\u0130\u0131\u0001\u0000\u0000\u0000\u0131\u0132\u0001\u0000"
          + "\u0000\u0000\u0132\u0133\u0003\u00ba]\u0000\u0133\u0135\u0001\u0000\u0000"
          + "\u0000\u0134\u012a\u0001\u0000\u0000\u0000\u0134\u012e\u0001\u0000\u0000"
          + "\u0000\u0135\u001b\u0001\u0000\u0000\u0000\u0136\u013a\u0003\u001e\u000f"
          + "\u0000\u0137\u013a\u0003P(\u0000\u0138\u013a\u0003N\'\u0000\u0139\u0136"
          + "\u0001\u0000\u0000\u0000\u0139\u0137\u0001\u0000\u0000\u0000\u0139\u0138"
          + "\u0001\u0000\u0000\u0000\u013a\u001d\u0001\u0000\u0000\u0000\u013b\u013c"
          + "\u0003 \u0010\u0000\u013c\u013d\u0003\u00ba]\u0000\u013d\u001f\u0001\u0000"
          + "\u0000\u0000\u013e\u013f\u0003,\u0016\u0000\u013f\u0144\u0003\"\u0011"
          + "\u0000\u0140\u0141\u0005\n\u0000\u0000\u0141\u0143\u0003\"\u0011\u0000"
          + "\u0142\u0140\u0001\u0000\u0000\u0000\u0143\u0146\u0001\u0000\u0000\u0000"
          + "\u0144\u0142\u0001\u0000\u0000\u0000\u0144\u0145\u0001\u0000\u0000\u0000"
          + "\u0145!\u0001\u0000\u0000\u0000\u0146\u0144\u0001\u0000\u0000\u0000\u0147"
          + "\u014a\u0003\u0092I\u0000\u0148\u0149\u0005\u000b\u0000\u0000\u0149\u014b"
          + "\u0003r9\u0000\u014a\u0148\u0001\u0000\u0000\u0000\u014a\u014b\u0001\u0000"
          + "\u0000\u0000\u014b#\u0001\u0000\u0000\u0000\u014c\u014d\u0005\t\u0000"
          + "\u0000\u014d%\u0001\u0000\u0000\u0000\u014e\u014f\u0004\u0013\u0000\u0000"
          + "\u014f\u0150\u0003p8\u0000\u0150\u0151\u0003\u00ba]\u0000\u0151\'\u0001"
          + "\u0000\u0000\u0000\u0152\u0153\u0005Y\u0000\u0000\u0153\u0154\u0005\u0005"
          + "\u0000\u0000\u0154\u0155\u0003p8\u0000\u0155\u0156\u0005\u0006\u0000\u0000"
          + "\u0156\u0159\u0003\u0004\u0002\u0000\u0157\u0158\u0005I\u0000\u0000\u0158"
          + "\u015a\u0003\u0004\u0002\u0000\u0159\u0157\u0001\u0000\u0000\u0000\u0159"
          + "\u015a\u0001\u0000\u0000\u0000\u015a)\u0001\u0000\u0000\u0000\u015b\u015c"
          + "\u0005E\u0000\u0000\u015c\u015d\u0003\u0004\u0002\u0000\u015d\u015e\u0005"
          + "S\u0000\u0000\u015e\u015f\u0005\u0005\u0000\u0000\u015f\u0160\u0003p8"
          + "\u0000\u0160\u0161\u0005\u0006\u0000\u0000\u0161\u0162\u0003\u00ba]\u0000"
          + "\u0162\u0194\u0001\u0000\u0000\u0000\u0163\u0164\u0005S\u0000\u0000\u0164"
          + "\u0165\u0005\u0005\u0000\u0000\u0165\u0166\u0003p8\u0000\u0166\u0167\u0005"
          + "\u0006\u0000\u0000\u0167\u0168\u0003\u0004\u0002\u0000\u0168\u0194\u0001"
          + "\u0000\u0000\u0000\u0169\u016a\u0005Q\u0000\u0000\u016a\u016d\u0005\u0005"
          + "\u0000\u0000\u016b\u016e\u0003p8\u0000\u016c\u016e\u0003 \u0010\u0000"
          + "\u016d\u016b\u0001\u0000\u0000\u0000\u016d\u016c\u0001\u0000\u0000\u0000"
          + "\u016d\u016e\u0001\u0000\u0000\u0000\u016e\u016f\u0001\u0000\u0000\u0000"
          + "\u016f\u0171\u0005\t\u0000\u0000\u0170\u0172\u0003p8\u0000\u0171\u0170"
          + "\u0001\u0000\u0000\u0000\u0171\u0172\u0001\u0000\u0000\u0000\u0172\u0173"
          + "\u0001\u0000\u0000\u0000\u0173\u0175\u0005\t\u0000\u0000\u0174\u0176\u0003"
          + "p8\u0000\u0175\u0174\u0001\u0000\u0000\u0000\u0175\u0176\u0001\u0000\u0000"
          + "\u0000\u0176\u0177\u0001\u0000\u0000\u0000\u0177\u0178\u0005\u0006\u0000"
          + "\u0000\u0178\u0194\u0003\u0004\u0002\u0000\u0179\u017a\u0005Q\u0000\u0000"
          + "\u017a\u017d\u0005\u0005\u0000\u0000\u017b\u017e\u0003r9\u0000\u017c\u017e"
          + "\u0003 \u0010\u0000\u017d\u017b\u0001\u0000\u0000\u0000\u017d\u017c\u0001"
          + "\u0000\u0000\u0000\u017e\u017f\u0001\u0000\u0000\u0000\u017f\u0180\u0005"
          + "\\\u0000\u0000\u0180\u0181\u0003p8\u0000\u0181\u0182\u0005\u0006\u0000"
          + "\u0000\u0182\u0183\u0003\u0004\u0002\u0000\u0183\u0194\u0001\u0000\u0000"
          + "\u0000\u0184\u0186\u0005Q\u0000\u0000\u0185\u0187\u0005i\u0000\u0000\u0186"
          + "\u0185\u0001\u0000\u0000\u0000\u0186\u0187\u0001\u0000\u0000\u0000\u0187"
          + "\u0188\u0001\u0000\u0000\u0000\u0188\u018b\u0005\u0005\u0000\u0000\u0189"
          + "\u018c\u0003r9\u0000\u018a\u018c\u0003 \u0010\u0000\u018b\u0189\u0001"
          + "\u0000\u0000\u0000\u018b\u018a\u0001\u0000\u0000\u0000\u018c\u018d\u0001"
          + "\u0000\u0000\u0000\u018d\u018e\u0003\u00b2Y\u0000\u018e\u018f\u0004\u0015"
          + "\u0001\u0000\u018f\u0190\u0003p8\u0000\u0190\u0191\u0005\u0006\u0000\u0000"
          + "\u0191\u0192\u0003\u0004\u0002\u0000\u0192\u0194\u0001\u0000\u0000\u0000"
          + "\u0193\u015b\u0001\u0000\u0000\u0000\u0193\u0163\u0001\u0000\u0000\u0000"
          + "\u0193\u0169\u0001\u0000\u0000\u0000\u0193\u0179\u0001\u0000\u0000\u0000"
          + "\u0193\u0184\u0001\u0000\u0000\u0000\u0194+\u0001\u0000\u0000\u0000\u0195"
          + "\u0199\u0005K\u0000\u0000\u0196\u0199\u0003\u00b8\\\u0000\u0197\u0199"
          + "\u0005e\u0000\u0000\u0198\u0195\u0001\u0000\u0000\u0000\u0198\u0196\u0001"
          + "\u0000\u0000\u0000\u0198\u0197\u0001\u0000\u0000\u0000\u0199-\u0001\u0000"
          + "\u0000\u0000\u019a\u019d\u0005P\u0000\u0000\u019b\u019c\u0004\u0017\u0002"
          + "\u0000\u019c\u019e\u0003\u00b2Y\u0000\u019d\u019b\u0001\u0000\u0000\u0000"
          + "\u019d\u019e\u0001\u0000\u0000\u0000\u019e\u019f\u0001\u0000\u0000\u0000"
          + "\u019f\u01a0\u0003\u00ba]\u0000\u01a0/\u0001\u0000\u0000\u0000\u01a1\u01a4"
          + "\u0005D\u0000\u0000\u01a2\u01a3\u0004\u0018\u0003\u0000\u01a3\u01a5\u0003"
          + "\u00b2Y\u0000\u01a4\u01a2\u0001\u0000\u0000\u0000\u01a4\u01a5\u0001\u0000"
          + "\u0000\u0000\u01a5\u01a6\u0001\u0000\u0000\u0000\u01a6\u01a7\u0003\u00ba"
          + "]\u0000\u01a71\u0001\u0000\u0000\u0000\u01a8\u01ab\u0005N\u0000\u0000"
          + "\u01a9\u01aa\u0004\u0019\u0004\u0000\u01aa\u01ac\u0003p8\u0000\u01ab\u01a9"
          + "\u0001\u0000\u0000\u0000\u01ab\u01ac\u0001\u0000\u0000\u0000\u01ac\u01ad"
          + "\u0001\u0000\u0000\u0000\u01ad\u01b5\u0003\u00ba]\u0000\u01ae\u01af\u0005"
          + "N\u0000\u0000\u01af\u01b0\u0005\u0005\u0000\u0000\u01b0\u01b1\u0003t:"
          + "\u0000\u01b1\u01b2\u0005\u0006\u0000\u0000\u01b2\u01b3\u0003\u00ba]\u0000"
          + "\u01b3\u01b5\u0001\u0000\u0000\u0000\u01b4\u01a8\u0001\u0000\u0000\u0000"
          + "\u01b4\u01ae\u0001\u0000\u0000\u0000\u01b53\u0001\u0000\u0000\u0000\u01b6"
          + "\u01b9\u0007\u0000\u0000\u0000\u01b7\u01b8\u0004\u001a\u0005\u0000\u01b8"
          + "\u01ba\u0003p8\u0000\u01b9\u01b7\u0001\u0000\u0000\u0000\u01b9\u01ba\u0001"
          + "\u0000\u0000\u0000\u01ba\u01bb\u0001\u0000\u0000\u0000\u01bb\u01bc\u0003"
          + "\u00ba]\u0000\u01bc5\u0001\u0000\u0000\u0000\u01bd\u01be\u0005W\u0000"
          + "\u0000\u01be\u01bf\u0005\u0005\u0000\u0000\u01bf\u01c0\u0003p8\u0000\u01c0"
          + "\u01c1\u0005\u0006\u0000\u0000\u01c1\u01c2\u0003\u0004\u0002\u0000\u01c2"
          + "7\u0001\u0000\u0000\u0000\u01c3\u01c4\u0005R\u0000\u0000\u01c4\u01c5\u0005"
          + "\u0005\u0000\u0000\u01c5\u01c6\u0003p8\u0000\u01c6\u01c7\u0005\u0006\u0000"
          + "\u0000\u01c7\u01c8\u0003:\u001d\u0000\u01c89\u0001\u0000\u0000\u0000\u01c9"
          + "\u01cb\u0005\u0007\u0000\u0000\u01ca\u01cc\u0003<\u001e\u0000\u01cb\u01ca"
          + "\u0001\u0000\u0000\u0000\u01cb\u01cc\u0001\u0000\u0000\u0000\u01cc\u01d1"
          + "\u0001\u0000\u0000\u0000\u01cd\u01cf\u0003@ \u0000\u01ce\u01d0\u0003<"
          + "\u001e\u0000\u01cf\u01ce\u0001\u0000\u0000\u0000\u01cf\u01d0\u0001\u0000"
          + "\u0000\u0000\u01d0\u01d2\u0001\u0000\u0000\u0000\u01d1\u01cd\u0001\u0000"
          + "\u0000\u0000\u01d1\u01d2\u0001\u0000\u0000\u0000\u01d2\u01d3\u0001\u0000"
          + "\u0000\u0000\u01d3\u01d4\u0005\b\u0000\u0000\u01d4;\u0001\u0000\u0000"
          + "\u0000\u01d5\u01d7\u0003>\u001f\u0000\u01d6\u01d5\u0001\u0000\u0000\u0000"
          + "\u01d7\u01d8\u0001\u0000\u0000\u0000\u01d8\u01d6\u0001\u0000\u0000\u0000"
          + "\u01d8\u01d9\u0001\u0000\u0000\u0000\u01d9=\u0001\u0000\u0000\u0000\u01da"
          + "\u01db\u0005H\u0000\u0000\u01db\u01dc\u0003p8\u0000\u01dc\u01de\u0005"
          + "\r\u0000\u0000\u01dd\u01df\u0003\b\u0004\u0000\u01de\u01dd\u0001\u0000"
          + "\u0000\u0000\u01de\u01df\u0001\u0000\u0000\u0000\u01df?\u0001\u0000\u0000"
          + "\u0000\u01e0\u01e1\u0005X\u0000\u0000\u01e1\u01e3\u0005\r\u0000\u0000"
          + "\u01e2\u01e4\u0003\b\u0004\u0000\u01e3\u01e2\u0001\u0000\u0000\u0000\u01e3"
          + "\u01e4\u0001\u0000\u0000\u0000\u01e4A\u0001\u0000\u0000\u0000\u01e5\u01e6"
          + "\u0003\u00b2Y\u0000\u01e6\u01e7\u0005\r\u0000\u0000\u01e7\u01e8\u0003"
          + "\u0004\u0002\u0000\u01e8C\u0001\u0000\u0000\u0000\u01e9\u01ea\u0005Z\u0000"
          + "\u0000\u01ea\u01eb\u0004\"\u0006\u0000\u01eb\u01ec\u0003p8\u0000\u01ec"
          + "\u01ed\u0003\u00ba]\u0000\u01edE\u0001\u0000\u0000\u0000\u01ee\u01ef\u0005"
          + "]\u0000\u0000\u01ef\u01f5\u0003\u0006\u0003\u0000\u01f0\u01f2\u0003H$"
          + "\u0000\u01f1\u01f3\u0003J%\u0000\u01f2\u01f1\u0001\u0000\u0000\u0000\u01f2"
          + "\u01f3\u0001\u0000\u0000\u0000\u01f3\u01f6\u0001\u0000\u0000\u0000\u01f4"
          + "\u01f6\u0003J%\u0000\u01f5\u01f0\u0001\u0000\u0000\u0000\u01f5\u01f4\u0001"
          + "\u0000\u0000\u0000\u01f6G\u0001\u0000\u0000\u0000\u01f7\u01fd\u0005L\u0000"
          + "\u0000\u01f8\u01fa\u0005\u0005\u0000\u0000\u01f9\u01fb\u0003\u0092I\u0000"
          + "\u01fa\u01f9\u0001\u0000\u0000\u0000\u01fa\u01fb\u0001\u0000\u0000\u0000"
          + "\u01fb\u01fc\u0001\u0000\u0000\u0000\u01fc\u01fe\u0005\u0006\u0000\u0000"
          + "\u01fd\u01f8\u0001\u0000\u0000\u0000\u01fd\u01fe\u0001\u0000\u0000\u0000"
          + "\u01fe\u01ff\u0001\u0000\u0000\u0000\u01ff\u0200\u0003\u0006\u0003\u0000"
          + "\u0200I\u0001\u0000\u0000\u0000\u0201\u0202\u0005M\u0000\u0000\u0202\u0203"
          + "\u0003\u0006\u0003\u0000\u0203K\u0001\u0000\u0000\u0000\u0204\u0205\u0005"
          + "T\u0000\u0000\u0205\u0206\u0003\u00ba]\u0000\u0206M\u0001\u0000\u0000"
          + "\u0000\u0207\u0209\u0005h\u0000\u0000\u0208\u0207\u0001\u0000\u0000\u0000"
          + "\u0208\u0209\u0001\u0000\u0000\u0000\u0209\u020a\u0001\u0000\u0000\u0000"
          + "\u020a\u020c\u0005U\u0000\u0000\u020b\u020d\u0005\u0016\u0000\u0000\u020c"
          + "\u020b\u0001\u0000\u0000\u0000\u020c\u020d\u0001\u0000\u0000\u0000\u020d"
          + "\u020e\u0001\u0000\u0000\u0000\u020e\u020f\u0003\u00b2Y\u0000\u020f\u0211"
          + "\u0005\u0005\u0000\u0000\u0210\u0212\u0003X,\u0000\u0211\u0210\u0001\u0000"
          + "\u0000\u0000\u0211\u0212\u0001\u0000\u0000\u0000\u0212\u0213\u0001\u0000"
          + "\u0000\u0000\u0213\u0214\u0005\u0006\u0000\u0000\u0214\u0215\u0005\u0007"
          + "\u0000\u0000\u0215\u0216\u0003^/\u0000\u0216\u0217\u0005\b\u0000\u0000"
          + "\u0217O\u0001\u0000\u0000\u0000\u0218\u0219\u0005a\u0000\u0000\u0219\u021a"
          + "\u0003\u00b2Y\u0000\u021a\u021b\u0003R)\u0000\u021bQ\u0001\u0000\u0000"
          + "\u0000\u021c\u021d\u0005c\u0000\u0000\u021d\u021f\u0003r9\u0000\u021e"
          + "\u021c\u0001\u0000\u0000\u0000\u021e\u021f\u0001\u0000\u0000\u0000\u021f"
          + "\u0220\u0001\u0000\u0000\u0000\u0220\u0224\u0005\u0007\u0000\u0000\u0221"
          + "\u0223\u0003T*\u0000\u0222\u0221\u0001\u0000\u0000\u0000\u0223\u0226\u0001"
          + "\u0000\u0000\u0000\u0224\u0222\u0001\u0000\u0000\u0000\u0224\u0225\u0001"
          + "\u0000\u0000\u0000\u0225\u0227\u0001\u0000\u0000\u0000\u0226\u0224\u0001"
          + "\u0000\u0000\u0000\u0227\u0228\u0005\b\u0000\u0000\u0228S\u0001\u0000"
          + "\u0000\u0000\u0229\u022e\u0005r\u0000\u0000\u022a\u022b\u0004*\u0007\u0000"
          + "\u022b\u022e\u0003\u00b2Y\u0000\u022c\u022e\u0005h\u0000\u0000\u022d\u0229"
          + "\u0001\u0000\u0000\u0000\u022d\u022a\u0001\u0000\u0000\u0000\u022d\u022c"
          + "\u0001\u0000\u0000\u0000\u022e\u0231\u0001\u0000\u0000\u0000\u022f\u022d"
          + "\u0001\u0000\u0000\u0000\u022f\u0230\u0001\u0000\u0000\u0000\u0230\u0238"
          + "\u0001\u0000\u0000\u0000\u0231\u022f\u0001\u0000\u0000\u0000\u0232\u0239"
          + "\u0003V+\u0000\u0233\u0234\u0003\u0092I\u0000\u0234\u0235\u0005\u000b"
          + "\u0000\u0000\u0235\u0236\u0003\u0094J\u0000\u0236\u0237\u0005\t\u0000"
          + "\u0000\u0237\u0239\u0001\u0000\u0000\u0000\u0238\u0232\u0001\u0000\u0000"
          + "\u0000\u0238\u0233\u0001\u0000\u0000\u0000\u0239\u0243\u0001\u0000\u0000"
          + "\u0000\u023a\u0243\u0003$\u0012\u0000\u023b\u023d\u0005\u001b\u0000\u0000"
          + "\u023c\u023b\u0001\u0000\u0000\u0000\u023c\u023d\u0001\u0000\u0000\u0000"
          + "\u023d\u023e\u0001\u0000\u0000\u0000\u023e\u023f\u0003j5\u0000\u023f\u0240"
          + "\u0005\u000b\u0000\u0000\u0240\u0241\u0003r9\u0000\u0241\u0243\u0001\u0000"
          + "\u0000\u0000\u0242\u022f\u0001\u0000\u0000\u0000\u0242\u023a\u0001\u0000"
          + "\u0000\u0000\u0242\u023c\u0001\u0000\u0000\u0000\u0243U\u0001\u0000\u0000"
          + "\u0000\u0244\u0246\u0005\u0016\u0000\u0000\u0245\u0244\u0001\u0000\u0000"
          + "\u0000\u0245\u0246\u0001\u0000\u0000\u0000\u0246\u0248\u0001\u0000\u0000"
          + "\u0000\u0247\u0249\u0005\u001b\u0000\u0000\u0248\u0247\u0001\u0000\u0000"
          + "\u0000\u0248\u0249\u0001\u0000\u0000\u0000\u0249\u024a\u0001\u0000\u0000"
          + "\u0000\u024a\u024b\u0003j5\u0000\u024b\u024d\u0005\u0005\u0000\u0000\u024c"
          + "\u024e\u0003X,\u0000\u024d\u024c\u0001\u0000\u0000\u0000\u024d\u024e\u0001"
          + "\u0000\u0000\u0000\u024e\u024f\u0001\u0000\u0000\u0000\u024f\u0250\u0005"
          + "\u0006\u0000\u0000\u0250\u0251\u0005\u0007\u0000\u0000\u0251\u0252\u0003"
          + "^/\u0000\u0252\u0253\u0005\b\u0000\u0000\u0253\u0272\u0001\u0000\u0000"
          + "\u0000\u0254\u0256\u0005\u0016\u0000\u0000\u0255\u0254\u0001\u0000\u0000"
          + "\u0000\u0255\u0256\u0001\u0000\u0000\u0000\u0256\u0258\u0001\u0000\u0000"
          + "\u0000\u0257\u0259\u0005\u001b\u0000\u0000\u0258\u0257\u0001\u0000\u0000"
          + "\u0000\u0258\u0259\u0001\u0000\u0000\u0000\u0259\u025a\u0001\u0000\u0000"
          + "\u0000\u025a\u025b\u0003\u00acV\u0000\u025b\u025c\u0005\u0005\u0000\u0000"
          + "\u025c\u025d\u0005\u0006\u0000\u0000\u025d\u025e\u0005\u0007\u0000\u0000"
          + "\u025e\u025f\u0003^/\u0000\u025f\u0260\u0005\b\u0000\u0000\u0260\u0272"
          + "\u0001\u0000\u0000\u0000\u0261\u0263\u0005\u0016\u0000\u0000\u0262\u0261"
          + "\u0001\u0000\u0000\u0000\u0262\u0263\u0001\u0000\u0000\u0000\u0263\u0265"
          + "\u0001\u0000\u0000\u0000\u0264\u0266\u0005\u001b\u0000\u0000\u0265\u0264"
          + "\u0001\u0000\u0000\u0000\u0265\u0266\u0001\u0000\u0000\u0000\u0266\u0267"
          + "\u0001\u0000\u0000\u0000\u0267\u0268\u0003\u00aeW\u0000\u0268\u026a\u0005"
          + "\u0005\u0000\u0000\u0269\u026b\u0003X,\u0000\u026a\u0269\u0001\u0000\u0000"
          + "\u0000\u026a\u026b\u0001\u0000\u0000\u0000\u026b\u026c\u0001\u0000\u0000"
          + "\u0000\u026c\u026d\u0005\u0006\u0000\u0000\u026d\u026e\u0005\u0007\u0000"
          + "\u0000\u026e\u026f\u0003^/\u0000\u026f\u0270\u0005\b\u0000\u0000\u0270"
          + "\u0272\u0001\u0000\u0000\u0000\u0271\u0245\u0001\u0000\u0000\u0000\u0271"
          + "\u0255\u0001\u0000\u0000\u0000\u0271\u0262\u0001\u0000\u0000\u0000\u0272"
          + "W\u0001\u0000\u0000\u0000\u0273\u0278\u0003Z-\u0000\u0274\u0275\u0005"
          + "\n\u0000\u0000\u0275\u0277\u0003Z-\u0000\u0276\u0274\u0001\u0000\u0000"
          + "\u0000\u0277\u027a\u0001\u0000\u0000\u0000\u0278\u0276\u0001\u0000\u0000"
          + "\u0000\u0278\u0279\u0001\u0000\u0000\u0000\u0279\u027d\u0001\u0000\u0000"
          + "\u0000\u027a\u0278\u0001\u0000\u0000\u0000\u027b\u027c\u0005\n\u0000\u0000"
          + "\u027c\u027e\u0003\\.\u0000\u027d\u027b\u0001\u0000\u0000\u0000\u027d"
          + "\u027e\u0001\u0000\u0000\u0000\u027e\u0281\u0001\u0000\u0000\u0000\u027f"
          + "\u0281\u0003\\.\u0000\u0280\u0273\u0001\u0000\u0000\u0000\u0280\u027f"
          + "\u0001\u0000\u0000\u0000\u0281Y\u0001\u0000\u0000\u0000\u0282\u0285\u0003"
          + "\u0092I\u0000\u0283\u0284\u0005\u000b\u0000\u0000\u0284\u0286\u0003r9"
          + "\u0000\u0285\u0283\u0001\u0000\u0000\u0000\u0285\u0286\u0001\u0000\u0000"
          + "\u0000\u0286[\u0001\u0000\u0000\u0000\u0287\u0288\u0005\u000e\u0000\u0000"
          + "\u0288\u0289\u0003r9\u0000\u0289]\u0001\u0000\u0000\u0000\u028a\u028c"
          + "\u0003`0\u0000\u028b\u028a\u0001\u0000\u0000\u0000\u028b\u028c\u0001\u0000"
          + "\u0000\u0000\u028c_\u0001\u0000\u0000\u0000\u028d\u028f\u0003\u0002\u0001"
          + "\u0000\u028e\u028d\u0001\u0000\u0000\u0000\u028f\u0290\u0001\u0000\u0000"
          + "\u0000\u0290\u028e\u0001\u0000\u0000\u0000\u0290\u0291\u0001\u0000\u0000"
          + "\u0000\u0291a\u0001\u0000\u0000\u0000\u0292\u0293\u0005\u0003\u0000\u0000"
          + "\u0293\u0294\u0003d2\u0000\u0294\u0295\u0005\u0004\u0000\u0000\u0295c"
          + "\u0001\u0000\u0000\u0000\u0296\u0298\u0005\n\u0000\u0000\u0297\u0296\u0001"
          + "\u0000\u0000\u0000\u0298\u029b\u0001\u0000\u0000\u0000\u0299\u0297\u0001"
          + "\u0000\u0000\u0000\u0299\u029a\u0001\u0000\u0000\u0000\u029a\u029d\u0001"
          + "\u0000\u0000\u0000\u029b\u0299\u0001\u0000\u0000\u0000\u029c\u029e\u0003"
          + "f3\u0000\u029d\u029c\u0001\u0000\u0000\u0000\u029d\u029e\u0001\u0000\u0000"
          + "\u0000\u029e\u02a7\u0001\u0000\u0000\u0000\u029f\u02a1\u0005\n\u0000\u0000"
          + "\u02a0\u029f\u0001\u0000\u0000\u0000\u02a1\u02a2\u0001\u0000\u0000\u0000"
          + "\u02a2\u02a0\u0001\u0000\u0000\u0000\u02a2\u02a3\u0001\u0000\u0000\u0000"
          + "\u02a3\u02a4\u0001\u0000\u0000\u0000\u02a4\u02a6\u0003f3\u0000\u02a5\u02a0"
          + "\u0001\u0000\u0000\u0000\u02a6\u02a9\u0001\u0000\u0000\u0000\u02a7\u02a5"
          + "\u0001\u0000\u0000\u0000\u02a7\u02a8\u0001\u0000\u0000\u0000\u02a8\u02ad"
          + "\u0001\u0000\u0000\u0000\u02a9\u02a7\u0001\u0000\u0000\u0000\u02aa\u02ac"
          + "\u0005\n\u0000\u0000\u02ab\u02aa\u0001\u0000\u0000\u0000\u02ac\u02af\u0001"
          + "\u0000\u0000\u0000\u02ad\u02ab\u0001\u0000\u0000\u0000\u02ad\u02ae\u0001"
          + "\u0000\u0000\u0000\u02aee\u0001\u0000\u0000\u0000\u02af\u02ad\u0001\u0000"
          + "\u0000\u0000\u02b0\u02b2\u0005\u000e\u0000\u0000\u02b1\u02b0\u0001\u0000"
          + "\u0000\u0000\u02b1\u02b2\u0001\u0000\u0000\u0000\u02b2\u02b3\u0001\u0000"
          + "\u0000\u0000\u02b3\u02b4\u0003r9\u0000\u02b4g\u0001\u0000\u0000\u0000"
          + "\u02b5\u02b6\u0003j5\u0000\u02b6\u02b7\u0005\r\u0000\u0000\u02b7\u02b8"
          + "\u0003r9\u0000\u02b8\u02e3\u0001\u0000\u0000\u0000\u02b9\u02ba\u0005\u0003"
          + "\u0000\u0000\u02ba\u02bb\u0003r9\u0000\u02bb\u02bc\u0005\u0004\u0000\u0000"
          + "\u02bc\u02bd\u0005\r\u0000\u0000\u02bd\u02be\u0003r9\u0000\u02be\u02e3"
          + "\u0001\u0000\u0000\u0000\u02bf\u02c1\u0005h\u0000\u0000\u02c0\u02bf\u0001"
          + "\u0000\u0000\u0000\u02c0\u02c1\u0001\u0000\u0000\u0000\u02c1\u02c3\u0001"
          + "\u0000\u0000\u0000\u02c2\u02c4\u0005\u0016\u0000\u0000\u02c3\u02c2\u0001"
          + "\u0000\u0000\u0000\u02c3\u02c4\u0001\u0000\u0000\u0000\u02c4\u02c5\u0001"
          + "\u0000\u0000\u0000\u02c5\u02c6\u0003j5\u0000\u02c6\u02c8\u0005\u0005\u0000"
          + "\u0000\u02c7\u02c9\u0003X,\u0000\u02c8\u02c7\u0001\u0000\u0000\u0000\u02c8"
          + "\u02c9\u0001\u0000\u0000\u0000\u02c9\u02ca\u0001\u0000\u0000\u0000\u02ca"
          + "\u02cb\u0005\u0006\u0000\u0000\u02cb\u02cc\u0005\u0007\u0000\u0000\u02cc"
          + "\u02cd\u0003^/\u0000\u02cd\u02ce\u0005\b\u0000\u0000\u02ce\u02e3\u0001"
          + "\u0000\u0000\u0000\u02cf\u02d0\u0003\u00acV\u0000\u02d0\u02d1\u0005\u0005"
          + "\u0000\u0000\u02d1\u02d2\u0005\u0006\u0000\u0000\u02d2\u02d3\u0005\u0007"
          + "\u0000\u0000\u02d3\u02d4\u0003^/\u0000\u02d4\u02d5\u0005\b\u0000\u0000"
          + "\u02d5\u02e3\u0001\u0000\u0000\u0000\u02d6\u02d7\u0003\u00aeW\u0000\u02d7"
          + "\u02d8\u0005\u0005\u0000\u0000\u02d8\u02d9\u0003Z-\u0000\u02d9\u02da\u0005"
          + "\u0006\u0000\u0000\u02da\u02db\u0005\u0007\u0000\u0000\u02db\u02dc\u0003"
          + "^/\u0000\u02dc\u02dd\u0005\b\u0000\u0000\u02dd\u02e3\u0001\u0000\u0000"
          + "\u0000\u02de\u02e0\u0005\u000e\u0000\u0000\u02df\u02de\u0001\u0000\u0000"
          + "\u0000\u02df\u02e0\u0001\u0000\u0000\u0000\u02e0\u02e1\u0001\u0000\u0000"
          + "\u0000\u02e1\u02e3\u0003r9\u0000\u02e2\u02b5\u0001\u0000\u0000\u0000\u02e2"
          + "\u02b9\u0001\u0000\u0000\u0000\u02e2\u02c0\u0001\u0000\u0000\u0000\u02e2"
          + "\u02cf\u0001\u0000\u0000\u0000\u02e2\u02d6\u0001\u0000\u0000\u0000\u02e2"
          + "\u02df\u0001\u0000\u0000\u0000\u02e3i\u0001\u0000\u0000\u0000\u02e4\u02ec"
          + "\u0003\u00b0X\u0000\u02e5\u02ec\u0005u\u0000\u0000\u02e6\u02ec\u0003\u00a8"
          + "T\u0000\u02e7\u02e8\u0005\u0003\u0000\u0000\u02e8\u02e9\u0003r9\u0000"
          + "\u02e9\u02ea\u0005\u0004\u0000\u0000\u02ea\u02ec\u0001\u0000\u0000\u0000"
          + "\u02eb\u02e4\u0001\u0000\u0000\u0000\u02eb\u02e5\u0001\u0000\u0000\u0000"
          + "\u02eb\u02e6\u0001\u0000\u0000\u0000\u02eb\u02e7\u0001\u0000\u0000\u0000"
          + "\u02eck\u0001\u0000\u0000\u0000\u02ed\u02f9\u0005\u0005\u0000\u0000\u02ee"
          + "\u02f3\u0003n7\u0000\u02ef\u02f0\u0005\n\u0000\u0000\u02f0\u02f2\u0003"
          + "n7\u0000\u02f1\u02ef\u0001\u0000\u0000\u0000\u02f2\u02f5\u0001\u0000\u0000"
          + "\u0000\u02f3\u02f1\u0001\u0000\u0000\u0000\u02f3\u02f4\u0001\u0000\u0000"
          + "\u0000\u02f4\u02f7\u0001\u0000\u0000\u0000\u02f5\u02f3\u0001\u0000\u0000"
          + "\u0000\u02f6\u02f8\u0005\n\u0000\u0000\u02f7\u02f6\u0001\u0000\u0000\u0000"
          + "\u02f7\u02f8\u0001\u0000\u0000\u0000\u02f8\u02fa\u0001\u0000\u0000\u0000"
          + "\u02f9\u02ee\u0001\u0000\u0000\u0000\u02f9\u02fa\u0001\u0000\u0000\u0000"
          + "\u02fa\u02fb\u0001\u0000\u0000\u0000\u02fb\u02fc\u0005\u0006\u0000\u0000"
          + "\u02fcm\u0001\u0000\u0000\u0000\u02fd\u02ff\u0005\u000e\u0000\u0000\u02fe"
          + "\u02fd\u0001\u0000\u0000\u0000\u02fe\u02ff\u0001\u0000\u0000\u0000\u02ff"
          + "\u0302\u0001\u0000\u0000\u0000\u0300\u0303\u0003r9\u0000\u0301\u0303\u0003"
          + "\u00b2Y\u0000\u0302\u0300\u0001\u0000\u0000\u0000\u0302\u0301\u0001\u0000"
          + "\u0000\u0000\u0303o\u0001\u0000\u0000\u0000\u0304\u0306\u0005\u000e\u0000"
          + "\u0000\u0305\u0304\u0001\u0000\u0000\u0000\u0305\u0306\u0001\u0000\u0000"
          + "\u0000\u0306\u0307\u0001\u0000\u0000\u0000\u0307\u030f\u0003r9\u0000\u0308"
          + "\u030a\u0005\n\u0000\u0000\u0309\u030b\u0005\u000e\u0000\u0000\u030a\u0309"
          + "\u0001\u0000\u0000\u0000\u030a\u030b\u0001\u0000\u0000\u0000\u030b\u030c"
          + "\u0001\u0000\u0000\u0000\u030c\u030e\u0003r9\u0000\u030d\u0308\u0001\u0000"
          + "\u0000\u0000\u030e\u0311\u0001\u0000\u0000\u0000\u030f\u030d\u0001\u0000"
          + "\u0000\u0000\u030f\u0310\u0001\u0000\u0000\u0000\u0310q\u0001\u0000\u0000"
          + "\u0000\u0311\u030f\u0001\u0000\u0000\u0000\u0312\u0313\u00069\uffff\uffff"
          + "\u0000\u0313\u0348\u0003\u009aM\u0000\u0314\u0316\u0005a\u0000\u0000\u0315"
          + "\u0317\u0003\u00b2Y\u0000\u0316\u0315\u0001\u0000\u0000\u0000\u0316\u0317"
          + "\u0001\u0000\u0000\u0000\u0317\u0318\u0001\u0000\u0000\u0000\u0318\u0348"
          + "\u0003R)\u0000\u0319\u031a\u0005J\u0000\u0000\u031a\u031b\u0003r9\u0000"
          + "\u031b\u031c\u0003l6\u0000\u031c\u0348\u0001\u0000\u0000\u0000\u031d\u031e"
          + "\u0005J\u0000\u0000\u031e\u0348\u0003r9+\u031f\u0320\u0005J\u0000\u0000"
          + "\u0320\u0321\u0005\u000f\u0000\u0000\u0321\u0348\u0003\u00b2Y\u0000\u0322"
          + "\u0323\u0005[\u0000\u0000\u0323\u0348\u0003r9&\u0324\u0325\u0005O\u0000"
          + "\u0000\u0325\u0348\u0003r9%\u0326\u0327\u0005G\u0000\u0000\u0327\u0348"
          + "\u0003r9$\u0328\u0329\u0005\u0010\u0000\u0000\u0329\u0348\u0003r9#\u032a"
          + "\u032b\u0005\u0011\u0000\u0000\u032b\u0348\u0003r9\"\u032c\u032d\u0005"
          + "\u0012\u0000\u0000\u032d\u0348\u0003r9!\u032e\u032f\u0005\u0013\u0000"
          + "\u0000\u032f\u0348\u0003r9 \u0330\u0331\u0005\u0014\u0000\u0000\u0331"
          + "\u0348\u0003r9\u001f\u0332\u0333\u0005\u0015\u0000\u0000\u0333\u0348\u0003"
          + "r9\u001e\u0334\u0335\u0005i\u0000\u0000\u0335\u0348\u0003r9\u001d\u0336"
          + "\u0337\u0005g\u0000\u0000\u0337\u0338\u0005\u0005\u0000\u0000\u0338\u0339"
          + "\u0003r9\u0000\u0339\u033a\u0005\u0006\u0000\u0000\u033a\u0348\u0001\u0000"
          + "\u0000\u0000\u033b\u0348\u00034\u001a\u0000\u033c\u0348\u0005V\u0000\u0000"
          + "\u033d\u0348\u0003\u00b2Y\u0000\u033e\u0348\u0005d\u0000\u0000\u033f\u0348"
          + "\u0003\u00a2Q\u0000\u0340\u0348\u0003b1\u0000\u0341\u0348\u0003\u0094"
          + "J\u0000\u0342\u0348\u0003t:\u0000\u0343\u0344\u0005\u0005\u0000\u0000"
          + "\u0344\u0345\u0003p8\u0000\u0345\u0346\u0005\u0006\u0000\u0000\u0346\u0348"
          + "\u0001\u0000\u0000\u0000\u0347\u0312\u0001\u0000\u0000\u0000\u0347\u0314"
          + "\u0001\u0000\u0000\u0000\u0347\u0319\u0001\u0000\u0000\u0000\u0347\u031d"
          + "\u0001\u0000\u0000\u0000\u0347\u031f\u0001\u0000\u0000\u0000\u0347\u0322"
          + "\u0001\u0000\u0000\u0000\u0347\u0324\u0001\u0000\u0000\u0000\u0347\u0326"
          + "\u0001\u0000\u0000\u0000\u0347\u0328\u0001\u0000\u0000\u0000\u0347\u032a"
          + "\u0001\u0000\u0000\u0000\u0347\u032c\u0001\u0000\u0000\u0000\u0347\u032e"
          + "\u0001\u0000\u0000\u0000\u0347\u0330\u0001\u0000\u0000\u0000\u0347\u0332"
          + "\u0001\u0000\u0000\u0000\u0347\u0334\u0001\u0000\u0000\u0000\u0347\u0336"
          + "\u0001\u0000\u0000\u0000\u0347\u033b\u0001\u0000\u0000\u0000\u0347\u033c"
          + "\u0001\u0000\u0000\u0000\u0347\u033d\u0001\u0000\u0000\u0000\u0347\u033e"
          + "\u0001\u0000\u0000\u0000\u0347\u033f\u0001\u0000\u0000\u0000\u0347\u0340"
          + "\u0001\u0000\u0000\u0000\u0347\u0341\u0001\u0000\u0000\u0000\u0347\u0342"
          + "\u0001\u0000\u0000\u0000\u0347\u0343\u0001\u0000\u0000\u0000\u0348\u039a"
          + "\u0001\u0000\u0000\u0000\u0349\u034a\n\u001c\u0000\u0000\u034a\u034b\u0005"
          + "\u0019\u0000\u0000\u034b\u0399\u0003r9\u001c\u034c\u034d\n\u001b\u0000"
          + "\u0000\u034d\u034e\u0007\u0001\u0000\u0000\u034e\u0399\u0003r9\u001c\u034f"
          + "\u0350\n\u001a\u0000\u0000\u0350\u0351\u0007\u0002\u0000\u0000\u0351\u0399"
          + "\u0003r9\u001b\u0352\u0353\n\u0019\u0000\u0000\u0353\u0354\u0005\u001a"
          + "\u0000\u0000\u0354\u0399\u0003r9\u001a\u0355\u0356\n\u0018\u0000\u0000"
          + "\u0356\u0357\u0007\u0003\u0000\u0000\u0357\u0399\u0003r9\u0019\u0358\u0359"
          + "\n\u0017\u0000\u0000\u0359\u035a\u0007\u0004\u0000\u0000\u035a\u0399\u0003"
          + "r9\u0018\u035b\u035c\n\u0016\u0000\u0000\u035c\u035d\u0005F\u0000\u0000"
          + "\u035d\u0399\u0003r9\u0017\u035e\u035f\n\u0015\u0000\u0000\u035f\u0360"
          + "\u0005\\\u0000\u0000\u0360\u0399\u0003r9\u0016\u0361\u0362\n\u0014\u0000"
          + "\u0000\u0362\u0363\u0007\u0005\u0000\u0000\u0363\u0399\u0003r9\u0015\u0364"
          + "\u0365\n\u0013\u0000\u0000\u0365\u0366\u0005\'\u0000\u0000\u0366\u0399"
          + "\u0003r9\u0014\u0367\u0368\n\u0012\u0000\u0000\u0368\u0369\u0005(\u0000"
          + "\u0000\u0369\u0399\u0003r9\u0013\u036a\u036b\n\u0011\u0000\u0000\u036b"
          + "\u036c\u0005)\u0000\u0000\u036c\u0399\u0003r9\u0012\u036d\u036e\n\u0010"
          + "\u0000\u0000\u036e\u036f\u0005*\u0000\u0000\u036f\u0399\u0003r9\u0011"
          + "\u0370\u0371\n\u000f\u0000\u0000\u0371\u0372\u0005+\u0000\u0000\u0372"
          + "\u0399\u0003r9\u0010\u0373\u0374\n\u000e\u0000\u0000\u0374\u0375\u0005"
          + "\f\u0000\u0000\u0375\u0376\u0003r9\u0000\u0376\u0377\u0005\r\u0000\u0000"
          + "\u0377\u0378\u0003r9\u000f\u0378\u0399\u0001\u0000\u0000\u0000\u0379\u037a"
          + "\n\r\u0000\u0000\u037a\u037b\u0005\u000b\u0000\u0000\u037b\u0399\u0003"
          + "r9\r\u037c\u037d\n\f\u0000\u0000\u037d\u037e\u0003\u00a0P\u0000\u037e"
          + "\u037f\u0003r9\f\u037f\u0399\u0001\u0000\u0000\u0000\u0380\u0381\n.\u0000"
          + "\u0000\u0381\u0382\u0005\u0003\u0000\u0000\u0382\u0383\u0003p8\u0000\u0383"
          + "\u0384\u0005\u0004\u0000\u0000\u0384\u0399\u0001\u0000\u0000\u0000\u0385"
          + "\u0387\n-\u0000\u0000\u0386\u0388\u0005\f\u0000\u0000\u0387\u0386\u0001"
          + "\u0000\u0000\u0000\u0387\u0388\u0001\u0000\u0000\u0000\u0388\u0389\u0001"
          + "\u0000\u0000\u0000\u0389\u038b\u0005\u000f\u0000\u0000\u038a\u038c\u0005"
          + "\u001b\u0000\u0000\u038b\u038a\u0001\u0000\u0000\u0000\u038b\u038c\u0001"
          + "\u0000\u0000\u0000\u038c\u038d\u0001\u0000\u0000\u0000\u038d\u0399\u0003"
          + "\u00b0X\u0000\u038e\u038f\n*\u0000\u0000\u038f\u0399\u0003l6\u0000\u0390"
          + "\u0391\n(\u0000\u0000\u0391\u0392\u00049\u001d\u0000\u0392\u0399\u0005"
          + "\u0010\u0000\u0000\u0393\u0394\n\'\u0000\u0000\u0394\u0395\u00049\u001f"
          + "\u0000\u0395\u0399\u0005\u0011\u0000\u0000\u0396\u0397\n\n\u0000\u0000"
          + "\u0397\u0399\u0003\u00a4R\u0000\u0398\u0349\u0001\u0000\u0000\u0000\u0398"
          + "\u034c\u0001\u0000\u0000\u0000\u0398\u034f\u0001\u0000\u0000\u0000\u0398"
          + "\u0352\u0001\u0000\u0000\u0000\u0398\u0355\u0001\u0000\u0000\u0000\u0398"
          + "\u0358\u0001\u0000\u0000\u0000\u0398\u035b\u0001\u0000\u0000\u0000\u0398"
          + "\u035e\u0001\u0000\u0000\u0000\u0398\u0361\u0001\u0000\u0000\u0000\u0398"
          + "\u0364\u0001\u0000\u0000\u0000\u0398\u0367\u0001\u0000\u0000\u0000\u0398"
          + "\u036a\u0001\u0000\u0000\u0000\u0398\u036d\u0001\u0000\u0000\u0000\u0398"
          + "\u0370\u0001\u0000\u0000\u0000\u0398\u0373\u0001\u0000\u0000\u0000\u0398"
          + "\u0379\u0001\u0000\u0000\u0000\u0398\u037c\u0001\u0000\u0000\u0000\u0398"
          + "\u0380\u0001\u0000\u0000\u0000\u0398\u0385\u0001\u0000\u0000\u0000\u0398"
          + "\u038e\u0001\u0000\u0000\u0000\u0398\u0390\u0001\u0000\u0000\u0000\u0398"
          + "\u0393\u0001\u0000\u0000\u0000\u0398\u0396\u0001\u0000\u0000\u0000\u0399"
          + "\u039c\u0001\u0000\u0000\u0000\u039a\u0398\u0001\u0000\u0000\u0000\u039a"
          + "\u039b\u0001\u0000\u0000\u0000\u039bs\u0001\u0000\u0000\u0000\u039c\u039a"
          + "\u0001\u0000\u0000\u0000\u039d\u039f\u0003x<\u0000\u039e\u039d\u0001\u0000"
          + "\u0000\u0000\u039f\u03a0\u0001\u0000\u0000\u0000\u03a0\u039e\u0001\u0000"
          + "\u0000\u0000\u03a0\u03a1\u0001\u0000\u0000\u0000\u03a1u\u0001\u0000\u0000"
          + "\u0000\u03a2\u03a3\u0007\u0006\u0000\u0000\u03a3w\u0001\u0000\u0000\u0000"
          + "\u03a4\u03aa\u0003z=\u0000\u03a5\u03a6\u0003|>\u0000\u03a6\u03a7\u0003"
          + "\u0080@\u0000\u03a7\u03a8\u0003~?\u0000\u03a8\u03aa\u0001\u0000\u0000"
          + "\u0000\u03a9\u03a4\u0001\u0000\u0000\u0000\u03a9\u03a5\u0001\u0000\u0000"
          + "\u0000\u03aay\u0001\u0000\u0000\u0000\u03ab\u03ac\u0003v;\u0000\u03ac"
          + "\u03ae\u0003\u0082A\u0000\u03ad\u03af\u0003\u0088D\u0000\u03ae\u03ad\u0001"
          + "\u0000\u0000\u0000\u03ae\u03af\u0001\u0000\u0000\u0000\u03af\u03b0\u0001"
          + "\u0000\u0000\u0000\u03b0\u03b1\u0005\u0086\u0000\u0000\u03b1{\u0001\u0000"
          + "\u0000\u0000\u03b2\u03b3\u0003v;\u0000\u03b3\u03b5\u0003\u0084B\u0000"
          + "\u03b4\u03b6\u0003\u0088D\u0000\u03b5\u03b4\u0001\u0000\u0000\u0000\u03b5"
          + "\u03b6\u0001\u0000\u0000\u0000\u03b6\u03b7\u0001\u0000\u0000\u0000\u03b7"
          + "\u03b8\u0005\u0085\u0000\u0000\u03b8}\u0001\u0000\u0000\u0000\u03b9\u03ba"
          + "\u0005\u0091\u0000\u0000\u03ba\u03bb\u0003\u0086C\u0000\u03bb\u03bc\u0005"
          + "\u0093\u0000\u0000\u03bc\u007f\u0001\u0000\u0000\u0000\u03bd\u03bf\u0005"
          + "\u008f\u0000\u0000\u03be\u03bd\u0001\u0000\u0000\u0000\u03be\u03bf\u0001"
          + "\u0000\u0000\u0000\u03bf\u03c9\u0001\u0000\u0000\u0000\u03c0\u03c3\u0003"
          + "x<\u0000\u03c1\u03c3\u0003\u0098L\u0000\u03c2\u03c0\u0001\u0000\u0000"
          + "\u0000\u03c2\u03c1\u0001\u0000\u0000\u0000\u03c3\u03c5\u0001\u0000\u0000"
          + "\u0000\u03c4\u03c6\u0005\u008f\u0000\u0000\u03c5\u03c4\u0001\u0000\u0000"
          + "\u0000\u03c5\u03c6\u0001\u0000\u0000\u0000\u03c6\u03c8\u0001\u0000\u0000"
          + "\u0000\u03c7\u03c2\u0001\u0000\u0000\u0000\u03c8\u03cb\u0001\u0000\u0000"
          + "\u0000\u03c9\u03c7\u0001\u0000\u0000\u0000\u03c9\u03ca\u0001\u0000\u0000"
          + "\u0000\u03ca\u0081\u0001\u0000\u0000\u0000\u03cb\u03c9\u0001\u0000\u0000"
          + "\u0000\u03cc\u03cd\u0005\u0089\u0000\u0000\u03cd\u0083\u0001\u0000\u0000"
          + "\u0000\u03ce\u03cf\u0005\u0089\u0000\u0000\u03cf\u03d0\u0006B\uffff\uffff"
          + "\u0000\u03d0\u0085\u0001\u0000\u0000\u0000\u03d1\u03d2\u0005\u0094\u0000"
          + "\u0000\u03d2\u03d3\u0004C!\u0001\u03d3\u0087\u0001\u0000\u0000\u0000\u03d4"
          + "\u03d6\u0003\u008aE\u0000\u03d5\u03d7\u0003\u0088D\u0000\u03d6\u03d5\u0001"
          + "\u0000\u0000\u0000\u03d6\u03d7\u0001\u0000\u0000\u0000\u03d7\u03dd\u0001"
          + "\u0000\u0000\u0000\u03d8\u03da\u0003\u008cF\u0000\u03d9\u03db\u0003\u0088"
          + "D\u0000\u03da\u03d9\u0001\u0000\u0000\u0000\u03da\u03db\u0001\u0000\u0000"
          + "\u0000\u03db\u03dd\u0001\u0000\u0000\u0000\u03dc\u03d4\u0001\u0000\u0000"
          + "\u0000\u03dc\u03d8\u0001\u0000\u0000\u0000\u03dd\u0089\u0001\u0000\u0000"
          + "\u0000\u03de\u03df\u0005\u0088\u0000\u0000\u03df\u03e0\u0005\u000e\u0000"
          + "\u0000\u03e0\u03e1\u0003r9\u0000\u03e1\u03e2\u0005\b\u0000\u0000\u03e2"
          + "\u008b\u0001\u0000\u0000\u0000\u03e3\u03e4\u0003\u008eG\u0000\u03e4\u03e5"
          + "\u0005\u0087\u0000\u0000\u03e5\u03e6\u0003\u0090H\u0000\u03e6\u03e9\u0001"
          + "\u0000\u0000\u0000\u03e7\u03e9\u0003\u008eG\u0000\u03e8\u03e3\u0001\u0000"
          + "\u0000\u0000\u03e8\u03e7\u0001\u0000\u0000\u0000\u03e9\u008d\u0001\u0000"
          + "\u0000\u0000\u03ea\u03eb\u0005\u0089\u0000\u0000\u03eb\u008f\u0001\u0000"
          + "\u0000\u0000\u03ec\u03f0\u0005\u008e\u0000\u0000\u03ed\u03f0\u0003x<\u0000"
          + "\u03ee\u03f0\u0003\u0098L\u0000\u03ef\u03ec\u0001\u0000\u0000\u0000\u03ef"
          + "\u03ed\u0001\u0000\u0000\u0000\u03ef\u03ee\u0001\u0000\u0000\u0000\u03f0"
          + "\u0091\u0001\u0000\u0000\u0000\u03f1\u03f5\u0003\u00b2Y\u0000\u03f2\u03f5"
          + "\u0003b1\u0000\u03f3\u03f5\u0003\u0094J\u0000\u03f4\u03f1\u0001\u0000"
          + "\u0000\u0000\u03f4\u03f2\u0001\u0000\u0000\u0000\u03f4\u03f3\u0001\u0000"
          + "\u0000\u0000\u03f5\u0093\u0001\u0000\u0000\u0000\u03f6\u0402\u0005\u0007"
          + "\u0000\u0000\u03f7\u03fc\u0003h4\u0000\u03f8\u03f9\u0005\n\u0000\u0000"
          + "\u03f9\u03fb\u0003h4\u0000\u03fa\u03f8\u0001\u0000\u0000\u0000\u03fb\u03fe"
          + "\u0001\u0000\u0000\u0000\u03fc\u03fa\u0001\u0000\u0000\u0000\u03fc\u03fd"
          + "\u0001\u0000\u0000\u0000\u03fd\u0400\u0001\u0000\u0000\u0000\u03fe\u03fc"
          + "\u0001\u0000\u0000\u0000\u03ff\u0401\u0005\n\u0000\u0000\u0400\u03ff\u0001"
          + "\u0000\u0000\u0000\u0400\u0401\u0001\u0000\u0000\u0000\u0401\u0403\u0001"
          + "\u0000\u0000\u0000\u0402\u03f7\u0001\u0000\u0000\u0000\u0402\u0403\u0001"
          + "\u0000\u0000\u0000\u0403\u0404\u0001\u0000\u0000\u0000\u0404\u0405\u0005"
          + "\b\u0000\u0000\u0405\u0095\u0001\u0000\u0000\u0000\u0406\u0407\u0007\u0007"
          + "\u0000\u0000\u0407\u0097\u0001\u0000\u0000\u0000\u0408\u0409\u0003\u0096"
          + "K\u0000\u0409\u040a\u0003p8\u0000\u040a\u040b\u0005\b\u0000\u0000\u040b"
          + "\u0099\u0001\u0000\u0000\u0000\u040c\u0425\u0003N\'\u0000\u040d\u040f"
          + "\u0005h\u0000\u0000\u040e\u040d\u0001\u0000\u0000\u0000\u040e\u040f\u0001"
          + "\u0000\u0000\u0000\u040f\u0410\u0001\u0000\u0000\u0000\u0410\u0412\u0005"
          + "U\u0000\u0000\u0411\u0413\u0005\u0016\u0000\u0000\u0412\u0411\u0001\u0000"
          + "\u0000\u0000\u0412\u0413\u0001\u0000\u0000\u0000\u0413\u0414\u0001\u0000"
          + "\u0000\u0000\u0414\u0416\u0005\u0005\u0000\u0000\u0415\u0417\u0003X,\u0000"
          + "\u0416\u0415\u0001\u0000\u0000\u0000\u0416\u0417\u0001\u0000\u0000\u0000"
          + "\u0417\u0418\u0001\u0000\u0000\u0000\u0418\u0419\u0005\u0006\u0000\u0000"
          + "\u0419\u041a\u0005\u0007\u0000\u0000\u041a\u041b\u0003^/\u0000\u041b\u041c"
          + "\u0005\b\u0000\u0000\u041c\u0425\u0001\u0000\u0000\u0000\u041d\u041f\u0005"
          + "h\u0000\u0000\u041e\u041d\u0001\u0000\u0000\u0000\u041e\u041f\u0001\u0000"
          + "\u0000\u0000\u041f\u0420\u0001\u0000\u0000\u0000\u0420\u0421\u0003\u009c"
          + "N\u0000\u0421\u0422\u00058\u0000\u0000\u0422\u0423\u0003\u009eO\u0000"
          + "\u0423\u0425\u0001\u0000\u0000\u0000\u0424\u040c\u0001\u0000\u0000\u0000"
          + "\u0424\u040e\u0001\u0000\u0000\u0000\u0424\u041e\u0001\u0000\u0000\u0000"
          + "\u0425\u009b\u0001\u0000\u0000\u0000\u0426\u042d\u0003\u00b2Y\u0000\u0427"
          + "\u0429\u0005\u0005\u0000\u0000\u0428\u042a\u0003X,\u0000\u0429\u0428\u0001"
          + "\u0000\u0000\u0000\u0429\u042a\u0001\u0000\u0000\u0000\u042a\u042b\u0001"
          + "\u0000\u0000\u0000\u042b\u042d\u0005\u0006\u0000\u0000\u042c\u0426\u0001"
          + "\u0000\u0000\u0000\u042c\u0427\u0001\u0000\u0000\u0000\u042d\u009d\u0001"
          + "\u0000\u0000\u0000\u042e\u0434\u0003r9\u0000\u042f\u0430\u0005\u0007\u0000"
          + "\u0000\u0430\u0431\u0003^/\u0000\u0431\u0432\u0005\b\u0000\u0000\u0432"
          + "\u0434\u0001\u0000\u0000\u0000\u0433\u042e\u0001\u0000\u0000\u0000\u0433"
          + "\u042f\u0001\u0000\u0000\u0000\u0434\u009f\u0001\u0000\u0000\u0000\u0435"
          + "\u0436\u0007\b\u0000\u0000\u0436\u00a1\u0001\u0000\u0000\u0000\u0437\u043f"
          + "\u00059\u0000\u0000\u0438\u043f\u0005:\u0000\u0000\u0439\u043f\u0005u"
          + "\u0000\u0000\u043a\u043f\u0003\u00a4R\u0000\u043b\u043f\u0005}\u0000\u0000"
          + "\u043c\u043f\u0003\u00a8T\u0000\u043d\u043f\u0003\u00aaU\u0000\u043e\u0437"
          + "\u0001\u0000\u0000\u0000\u043e\u0438\u0001\u0000\u0000\u0000\u043e\u0439"
          + "\u0001\u0000\u0000\u0000\u043e\u043a\u0001\u0000\u0000\u0000\u043e\u043b"
          + "\u0001\u0000\u0000\u0000\u043e\u043c\u0001\u0000\u0000\u0000\u043e\u043d"
          + "\u0001\u0000\u0000\u0000\u043f\u00a3\u0001\u0000\u0000\u0000\u0440\u0444"
          + "\u0005w\u0000\u0000\u0441\u0443\u0003\u00a6S\u0000\u0442\u0441\u0001\u0000"
          + "\u0000\u0000\u0443\u0446\u0001\u0000\u0000\u0000\u0444\u0442\u0001\u0000"
          + "\u0000\u0000\u0444\u0445\u0001\u0000\u0000\u0000\u0445\u0447\u0001\u0000"
          + "\u0000\u0000\u0446\u0444\u0001\u0000\u0000\u0000\u0447\u0448\u0005w\u0000"
          + "\u0000\u0448\u00a5\u0001\u0000\u0000\u0000\u0449\u044f\u0005\u0083\u0000"
          + "\u0000\u044a\u044b\u0005\u0082\u0000\u0000\u044b\u044c\u0003r9\u0000\u044c"
          + "\u044d\u0005\b\u0000\u0000\u044d\u044f\u0001\u0000\u0000\u0000\u044e\u0449"
          + "\u0001\u0000\u0000\u0000\u044e\u044a\u0001\u0000\u0000\u0000\u044f\u00a7"
          + "\u0001\u0000\u0000\u0000\u0450\u0451\u0007\t\u0000\u0000\u0451\u00a9\u0001"
          + "\u0000\u0000\u0000\u0452\u0453\u0007\n\u0000\u0000\u0453\u00ab\u0001\u0000"
          + "\u0000\u0000\u0454\u0455\u0003\u00b2Y\u0000\u0455\u0456\u0004V\"\u0000"
          + "\u0456\u0457\u0003j5\u0000\u0457\u00ad\u0001\u0000\u0000\u0000\u0458\u0459"
          + "\u0003\u00b2Y\u0000\u0459\u045a\u0004W#\u0000\u045a\u045b\u0003j5\u0000"
          + "\u045b\u00af\u0001\u0000\u0000\u0000\u045c\u045f\u0003\u00b2Y\u0000\u045d"
          + "\u045f\u0003\u00b4Z\u0000\u045e\u045c\u0001\u0000\u0000\u0000\u045e\u045d"
          + "\u0001\u0000\u0000\u0000\u045f\u00b1\u0001\u0000\u0000\u0000\u0460\u0461"
          + "\u0007\u000b\u0000\u0000\u0461\u00b3\u0001\u0000\u0000\u0000\u0462\u0466"
          + "\u0003\u00b6[\u0000\u0463\u0466\u00059\u0000\u0000\u0464\u0466\u0005:"
          + "\u0000\u0000\u0465\u0462\u0001\u0000\u0000\u0000\u0465\u0463\u0001\u0000"
          + "\u0000\u0000\u0465\u0464\u0001\u0000\u0000\u0000\u0466\u00b5\u0001\u0000"
          + "\u0000\u0000\u0467\u0496\u0005D\u0000\u0000\u0468\u0496\u0005E\u0000\u0000"
          + "\u0469\u0496\u0005F\u0000\u0000\u046a\u0496\u0005G\u0000\u0000\u046b\u0496"
          + "\u0005H\u0000\u0000\u046c\u0496\u0005I\u0000\u0000\u046d\u0496\u0005J"
          + "\u0000\u0000\u046e\u0496\u0005K\u0000\u0000\u046f\u0496\u0005L\u0000\u0000"
          + "\u0470\u0496\u0005M\u0000\u0000\u0471\u0496\u0005N\u0000\u0000\u0472\u0496"
          + "\u0005O\u0000\u0000\u0473\u0496\u0005P\u0000\u0000\u0474\u0496\u0005Q"
          + "\u0000\u0000\u0475\u0496\u0005R\u0000\u0000\u0476\u0496\u0005S\u0000\u0000"
          + "\u0477\u0496\u0005T\u0000\u0000\u0478\u0496\u0005U\u0000\u0000\u0479\u0496"
          + "\u0005V\u0000\u0000\u047a\u0496\u0005W\u0000\u0000\u047b\u0496\u0005X"
          + "\u0000\u0000\u047c\u0496\u0005Y\u0000\u0000\u047d\u0496\u0005Z\u0000\u0000"
          + "\u047e\u0496\u0005[\u0000\u0000\u047f\u0496\u0005\\\u0000\u0000\u0480"
          + "\u0496\u0005]\u0000\u0000\u0481\u0496\u0005a\u0000\u0000\u0482\u0496\u0005"
          + "b\u0000\u0000\u0483\u0496\u0005c\u0000\u0000\u0484\u0496\u0005d\u0000"
          + "\u0000\u0485\u0496\u0005e\u0000\u0000\u0486\u0496\u0005f\u0000\u0000\u0487"
          + "\u0496\u0005g\u0000\u0000\u0488\u0496\u0005j\u0000\u0000\u0489\u0496\u0003"
          + "\u00b8\\\u0000\u048a\u0496\u0005m\u0000\u0000\u048b\u0496\u0005n\u0000"
          + "\u0000\u048c\u0496\u0005o\u0000\u0000\u048d\u0496\u0005p\u0000\u0000\u048e"
          + "\u0496\u0005q\u0000\u0000\u048f\u0496\u0005r\u0000\u0000\u0490\u0496\u0005"
          + "s\u0000\u0000\u0491\u0496\u0005h\u0000\u0000\u0492\u0496\u0005i\u0000"
          + "\u0000\u0493\u0496\u0005_\u0000\u0000\u0494\u0496\u0005^\u0000\u0000\u0495"
          + "\u0467\u0001\u0000\u0000\u0000\u0495\u0468\u0001\u0000\u0000\u0000\u0495"
          + "\u0469\u0001\u0000\u0000\u0000\u0495\u046a\u0001\u0000\u0000\u0000\u0495"
          + "\u046b\u0001\u0000\u0000\u0000\u0495\u046c\u0001\u0000\u0000\u0000\u0495"
          + "\u046d\u0001\u0000\u0000\u0000\u0495\u046e\u0001\u0000\u0000\u0000\u0495"
          + "\u046f\u0001\u0000\u0000\u0000\u0495\u0470\u0001\u0000\u0000\u0000\u0495"
          + "\u0471\u0001\u0000\u0000\u0000\u0495\u0472\u0001\u0000\u0000\u0000\u0495"
          + "\u0473\u0001\u0000\u0000\u0000\u0495\u0474\u0001\u0000\u0000\u0000\u0495"
          + "\u0475\u0001\u0000\u0000\u0000\u0495\u0476\u0001\u0000\u0000\u0000\u0495"
          + "\u0477\u0001\u0000\u0000\u0000\u0495\u0478\u0001\u0000\u0000\u0000\u0495"
          + "\u0479\u0001\u0000\u0000\u0000\u0495\u047a\u0001\u0000\u0000\u0000\u0495"
          + "\u047b\u0001\u0000\u0000\u0000\u0495\u047c\u0001\u0000\u0000\u0000\u0495"
          + "\u047d\u0001\u0000\u0000\u0000\u0495\u047e\u0001\u0000\u0000\u0000\u0495"
          + "\u047f\u0001\u0000\u0000\u0000\u0495\u0480\u0001\u0000\u0000\u0000\u0495"
          + "\u0481\u0001\u0000\u0000\u0000\u0495\u0482\u0001\u0000\u0000\u0000\u0495"
          + "\u0483\u0001\u0000\u0000\u0000\u0495\u0484\u0001\u0000\u0000\u0000\u0495"
          + "\u0485\u0001\u0000\u0000\u0000\u0495\u0486\u0001\u0000\u0000\u0000\u0495"
          + "\u0487\u0001\u0000\u0000\u0000\u0495\u0488\u0001\u0000\u0000\u0000\u0495"
          + "\u0489\u0001\u0000\u0000\u0000\u0495\u048a\u0001\u0000\u0000\u0000\u0495"
          + "\u048b\u0001\u0000\u0000\u0000\u0495\u048c\u0001\u0000\u0000\u0000\u0495"
          + "\u048d\u0001\u0000\u0000\u0000\u0495\u048e\u0001\u0000\u0000\u0000\u0495"
          + "\u048f\u0001\u0000\u0000\u0000\u0495\u0490\u0001\u0000\u0000\u0000\u0495"
          + "\u0491\u0001\u0000\u0000\u0000\u0495\u0492\u0001\u0000\u0000\u0000\u0495"
          + "\u0493\u0001\u0000\u0000\u0000\u0495\u0494\u0001\u0000\u0000\u0000\u0496"
          + "\u00b7\u0001\u0000\u0000\u0000\u0497\u0498\u0007\f\u0000\u0000\u0498\u00b9"
          + "\u0001\u0000\u0000\u0000\u0499\u049e\u0005\t\u0000\u0000\u049a\u049e\u0005"
          + "\u0000\u0000\u0001\u049b\u049e\u0004]$\u0000\u049c\u049e\u0004]%\u0000"
          + "\u049d\u0499\u0001\u0000\u0000\u0000\u049d\u049a\u0001\u0000\u0000\u0000"
          + "\u049d\u049b\u0001\u0000\u0000\u0000\u049d\u049c\u0001\u0000\u0000\u0000"
          + "\u049e\u00bb\u0001\u0000\u0000\u0000\u0080\u00bd\u00c0\u00da\u00de\u00e5"
          + "\u00eb\u00ef\u00f6\u00fe\u0103\u0105\u010e\u0112\u011a\u011f\u0128\u0130"
          + "\u0134\u0139\u0144\u014a\u0159\u016d\u0171\u0175\u017d\u0186\u018b\u0193"
          + "\u0198\u019d\u01a4\u01ab\u01b4\u01b9\u01cb\u01cf\u01d1\u01d8\u01de\u01e3"
          + "\u01f2\u01f5\u01fa\u01fd\u0208\u020c\u0211\u021e\u0224\u022d\u022f\u0238"
          + "\u023c\u0242\u0245\u0248\u024d\u0255\u0258\u0262\u0265\u026a\u0271\u0278"
          + "\u027d\u0280\u0285\u028b\u0290\u0299\u029d\u02a2\u02a7\u02ad\u02b1\u02c0"
          + "\u02c3\u02c8\u02df\u02e2\u02eb\u02f3\u02f7\u02f9\u02fe\u0302\u0305\u030a"
          + "\u030f\u0316\u0347\u0387\u038b\u0398\u039a\u03a0\u03a9\u03ae\u03b5\u03be"
          + "\u03c2\u03c5\u03c9\u03d6\u03da\u03dc\u03e8\u03ef\u03f4\u03fc\u0400\u0402"
          + "\u040e\u0412\u0416\u041e\u0424\u0429\u042c\u0433\u043e\u0444\u044e\u045e"
          + "\u0465\u0495\u049d";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
