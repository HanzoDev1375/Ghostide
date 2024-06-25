// Generated from ./ANTLRv4Parser.g4 by ANTLR 4.13.1
package org.antlr.parser.antlr4;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ANTLRv4Parser extends Parser {
  static {
    RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION);
  }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
  public static final int TOKEN_REF = 1,
      RULE_REF = 2,
      LEXER_CHAR_SET = 3,
      DOC_COMMENT = 4,
      BLOCK_COMMENT = 5,
      LINE_COMMENT = 6,
      INT = 7,
      STRING_LITERAL = 8,
      UNTERMINATED_STRING_LITERAL = 9,
      BEGIN_ARGUMENT = 10,
      BEGIN_ACTION = 11,
      OPTIONS = 12,
      TOKENS = 13,
      CHANNELS = 14,
      IMPORT = 15,
      FRAGMENT = 16,
      LEXER = 17,
      PARSER = 18,
      GRAMMAR = 19,
      PROTECTED = 20,
      PUBLIC = 21,
      PRIVATE = 22,
      RETURNS = 23,
      LOCALS = 24,
      THROWS = 25,
      CATCH = 26,
      FINALLY = 27,
      MODE = 28,
      COLON = 29,
      COLONCOLON = 30,
      COMMA = 31,
      SEMI = 32,
      LPAREN = 33,
      RPAREN = 34,
      LBRACE = 35,
      RBRACE = 36,
      RARROW = 37,
      LT = 38,
      GT = 39,
      ASSIGN = 40,
      QUESTION = 41,
      STAR = 42,
      PLUS_ASSIGN = 43,
      PLUS = 44,
      OR = 45,
      DOLLAR = 46,
      RANGE = 47,
      DOT = 48,
      AT = 49,
      POUND = 50,
      NOT = 51,
      ID = 52,
      WS = 53,
      ERRCHAR = 54,
      END_ARGUMENT = 55,
      UNTERMINATED_ARGUMENT = 56,
      ARGUMENT_CONTENT = 57,
      END_ACTION = 58,
      UNTERMINATED_ACTION = 59,
      ACTION_CONTENT = 60,
      OPT_LBRACE = 61,
      UNTERMINATED_CHAR_SET = 62;
  public static final int RULE_grammarSpec = 0,
      RULE_grammarDecl = 1,
      RULE_grammarType = 2,
      RULE_prequelConstruct = 3,
      RULE_optionsSpec = 4,
      RULE_option = 5,
      RULE_optionValue = 6,
      RULE_delegateGrammars = 7,
      RULE_delegateGrammar = 8,
      RULE_tokensSpec = 9,
      RULE_channelsSpec = 10,
      RULE_idList = 11,
      RULE_action_ = 12,
      RULE_actionScopeName = 13,
      RULE_actionBlock = 14,
      RULE_argActionBlock = 15,
      RULE_modeSpec = 16,
      RULE_rules = 17,
      RULE_ruleSpec = 18,
      RULE_parserRuleSpec = 19,
      RULE_exceptionGroup = 20,
      RULE_exceptionHandler = 21,
      RULE_finallyClause = 22,
      RULE_rulePrequel = 23,
      RULE_ruleReturns = 24,
      RULE_throwsSpec = 25,
      RULE_localsSpec = 26,
      RULE_ruleAction = 27,
      RULE_ruleModifiers = 28,
      RULE_ruleModifier = 29,
      RULE_ruleBlock = 30,
      RULE_ruleAltList = 31,
      RULE_labeledAlt = 32,
      RULE_lexerRuleSpec = 33,
      RULE_lexerRuleBlock = 34,
      RULE_lexerAltList = 35,
      RULE_lexerAlt = 36,
      RULE_lexerElements = 37,
      RULE_lexerElement = 38,
      RULE_labeledLexerElement = 39,
      RULE_lexerBlock = 40,
      RULE_lexerCommands = 41,
      RULE_lexerCommand = 42,
      RULE_lexerCommandName = 43,
      RULE_lexerCommandExpr = 44,
      RULE_altList = 45,
      RULE_alternative = 46,
      RULE_element = 47,
      RULE_labeledElement = 48,
      RULE_ebnf = 49,
      RULE_blockSuffix = 50,
      RULE_ebnfSuffix = 51,
      RULE_lexerAtom = 52,
      RULE_atom = 53,
      RULE_notSet = 54,
      RULE_blockSet = 55,
      RULE_setElement = 56,
      RULE_block = 57,
      RULE_ruleref = 58,
      RULE_characterRange = 59,
      RULE_terminal = 60,
      RULE_elementOptions = 61,
      RULE_elementOption = 62,
      RULE_identifier = 63;

  private static String[] makeRuleNames() {
    return new String[] {
      "grammarSpec",
      "grammarDecl",
      "grammarType",
      "prequelConstruct",
      "optionsSpec",
      "option",
      "optionValue",
      "delegateGrammars",
      "delegateGrammar",
      "tokensSpec",
      "channelsSpec",
      "idList",
      "action_",
      "actionScopeName",
      "actionBlock",
      "argActionBlock",
      "modeSpec",
      "rules",
      "ruleSpec",
      "parserRuleSpec",
      "exceptionGroup",
      "exceptionHandler",
      "finallyClause",
      "rulePrequel",
      "ruleReturns",
      "throwsSpec",
      "localsSpec",
      "ruleAction",
      "ruleModifiers",
      "ruleModifier",
      "ruleBlock",
      "ruleAltList",
      "labeledAlt",
      "lexerRuleSpec",
      "lexerRuleBlock",
      "lexerAltList",
      "lexerAlt",
      "lexerElements",
      "lexerElement",
      "labeledLexerElement",
      "lexerBlock",
      "lexerCommands",
      "lexerCommand",
      "lexerCommandName",
      "lexerCommandExpr",
      "altList",
      "alternative",
      "element",
      "labeledElement",
      "ebnf",
      "blockSuffix",
      "ebnfSuffix",
      "lexerAtom",
      "atom",
      "notSet",
      "blockSet",
      "setElement",
      "block",
      "ruleref",
      "characterRange",
      "terminal",
      "elementOptions",
      "elementOption",
      "identifier"
    };
  }

  public static final String[] ruleNames = makeRuleNames();

  private static String[] makeLiteralNames() {
    return new String[] {
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
      "'options'",
      "'tokens'",
      "'channels'",
      "'import'",
      "'fragment'",
      "'lexer'",
      "'parser'",
      "'grammar'",
      "'protected'",
      "'public'",
      "'private'",
      "'returns'",
      "'locals'",
      "'throws'",
      "'catch'",
      "'finally'",
      "'mode'"
    };
  }

  private static final String[] _LITERAL_NAMES = makeLiteralNames();

  private static String[] makeSymbolicNames() {
    return new String[] {
      null,
      "TOKEN_REF",
      "RULE_REF",
      "LEXER_CHAR_SET",
      "DOC_COMMENT",
      "BLOCK_COMMENT",
      "LINE_COMMENT",
      "INT",
      "STRING_LITERAL",
      "UNTERMINATED_STRING_LITERAL",
      "BEGIN_ARGUMENT",
      "BEGIN_ACTION",
      "OPTIONS",
      "TOKENS",
      "CHANNELS",
      "IMPORT",
      "FRAGMENT",
      "LEXER",
      "PARSER",
      "GRAMMAR",
      "PROTECTED",
      "PUBLIC",
      "PRIVATE",
      "RETURNS",
      "LOCALS",
      "THROWS",
      "CATCH",
      "FINALLY",
      "MODE",
      "COLON",
      "COLONCOLON",
      "COMMA",
      "SEMI",
      "LPAREN",
      "RPAREN",
      "LBRACE",
      "RBRACE",
      "RARROW",
      "LT",
      "GT",
      "ASSIGN",
      "QUESTION",
      "STAR",
      "PLUS_ASSIGN",
      "PLUS",
      "OR",
      "DOLLAR",
      "RANGE",
      "DOT",
      "AT",
      "POUND",
      "NOT",
      "ID",
      "WS",
      "ERRCHAR",
      "END_ARGUMENT",
      "UNTERMINATED_ARGUMENT",
      "ARGUMENT_CONTENT",
      "END_ACTION",
      "UNTERMINATED_ACTION",
      "ACTION_CONTENT",
      "OPT_LBRACE",
      "UNTERMINATED_CHAR_SET"
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
    return "ANTLRv4Parser.g4";
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

  public ANTLRv4Parser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
  }

  @SuppressWarnings("CheckReturnValue")
  public static class GrammarSpecContext extends ParserRuleContext {
    public GrammarDeclContext grammarDecl() {
      return getRuleContext(GrammarDeclContext.class, 0);
    }

    public RulesContext rules() {
      return getRuleContext(RulesContext.class, 0);
    }

    public TerminalNode EOF() {
      return getToken(ANTLRv4Parser.EOF, 0);
    }

    public List<TerminalNode> DOC_COMMENT() {
      return getTokens(ANTLRv4Parser.DOC_COMMENT);
    }

    public TerminalNode DOC_COMMENT(int i) {
      return getToken(ANTLRv4Parser.DOC_COMMENT, i);
    }

    public List<PrequelConstructContext> prequelConstruct() {
      return getRuleContexts(PrequelConstructContext.class);
    }

    public PrequelConstructContext prequelConstruct(int i) {
      return getRuleContext(PrequelConstructContext.class, i);
    }

    public List<ModeSpecContext> modeSpec() {
      return getRuleContexts(ModeSpecContext.class);
    }

    public ModeSpecContext modeSpec(int i) {
      return getRuleContext(ModeSpecContext.class, i);
    }

    public GrammarSpecContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_grammarSpec;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterGrammarSpec(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitGrammarSpec(this);
    }
  }

  public final GrammarSpecContext grammarSpec() throws RecognitionException {
    GrammarSpecContext _localctx = new GrammarSpecContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_grammarSpec);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(131);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == DOC_COMMENT) {
          {
            {
              setState(128);
              match(DOC_COMMENT);
            }
          }
          setState(133);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(134);
        grammarDecl();
        setState(138);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 562949953482752L) != 0)) {
          {
            {
              setState(135);
              prequelConstruct();
            }
          }
          setState(140);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(141);
        rules();
        setState(145);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == MODE) {
          {
            {
              setState(142);
              modeSpec();
            }
          }
          setState(147);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(148);
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
  public static class GrammarDeclContext extends ParserRuleContext {
    public GrammarTypeContext grammarType() {
      return getRuleContext(GrammarTypeContext.class, 0);
    }

    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public TerminalNode SEMI() {
      return getToken(ANTLRv4Parser.SEMI, 0);
    }

    public GrammarDeclContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_grammarDecl;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterGrammarDecl(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitGrammarDecl(this);
    }
  }

  public final GrammarDeclContext grammarDecl() throws RecognitionException {
    GrammarDeclContext _localctx = new GrammarDeclContext(_ctx, getState());
    enterRule(_localctx, 2, RULE_grammarDecl);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(150);
        grammarType();
        setState(151);
        identifier();
        setState(152);
        match(SEMI);
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
  public static class GrammarTypeContext extends ParserRuleContext {
    public TerminalNode LEXER() {
      return getToken(ANTLRv4Parser.LEXER, 0);
    }

    public TerminalNode GRAMMAR() {
      return getToken(ANTLRv4Parser.GRAMMAR, 0);
    }

    public TerminalNode PARSER() {
      return getToken(ANTLRv4Parser.PARSER, 0);
    }

    public GrammarTypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_grammarType;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterGrammarType(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitGrammarType(this);
    }
  }

  public final GrammarTypeContext grammarType() throws RecognitionException {
    GrammarTypeContext _localctx = new GrammarTypeContext(_ctx, getState());
    enterRule(_localctx, 4, RULE_grammarType);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(159);
        _errHandler.sync(this);
        switch (_input.LA(1)) {
          case LEXER:
            {
              setState(154);
              match(LEXER);
              setState(155);
              match(GRAMMAR);
            }
            break;
          case PARSER:
            {
              setState(156);
              match(PARSER);
              setState(157);
              match(GRAMMAR);
            }
            break;
          case GRAMMAR:
            {
              setState(158);
              match(GRAMMAR);
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
  public static class PrequelConstructContext extends ParserRuleContext {
    public OptionsSpecContext optionsSpec() {
      return getRuleContext(OptionsSpecContext.class, 0);
    }

    public DelegateGrammarsContext delegateGrammars() {
      return getRuleContext(DelegateGrammarsContext.class, 0);
    }

    public TokensSpecContext tokensSpec() {
      return getRuleContext(TokensSpecContext.class, 0);
    }

    public ChannelsSpecContext channelsSpec() {
      return getRuleContext(ChannelsSpecContext.class, 0);
    }

    public Action_Context action_() {
      return getRuleContext(Action_Context.class, 0);
    }

    public PrequelConstructContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_prequelConstruct;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterPrequelConstruct(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitPrequelConstruct(this);
    }
  }

  public final PrequelConstructContext prequelConstruct() throws RecognitionException {
    PrequelConstructContext _localctx = new PrequelConstructContext(_ctx, getState());
    enterRule(_localctx, 6, RULE_prequelConstruct);
    try {
      setState(166);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case OPTIONS:
          enterOuterAlt(_localctx, 1);
          {
            setState(161);
            optionsSpec();
          }
          break;
        case IMPORT:
          enterOuterAlt(_localctx, 2);
          {
            setState(162);
            delegateGrammars();
          }
          break;
        case TOKENS:
          enterOuterAlt(_localctx, 3);
          {
            setState(163);
            tokensSpec();
          }
          break;
        case CHANNELS:
          enterOuterAlt(_localctx, 4);
          {
            setState(164);
            channelsSpec();
          }
          break;
        case AT:
          enterOuterAlt(_localctx, 5);
          {
            setState(165);
            action_();
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
  public static class OptionsSpecContext extends ParserRuleContext {
    public TerminalNode OPTIONS() {
      return getToken(ANTLRv4Parser.OPTIONS, 0);
    }

    public TerminalNode LBRACE() {
      return getToken(ANTLRv4Parser.LBRACE, 0);
    }

    public TerminalNode RBRACE() {
      return getToken(ANTLRv4Parser.RBRACE, 0);
    }

    public List<OptionContext> option() {
      return getRuleContexts(OptionContext.class);
    }

    public OptionContext option(int i) {
      return getRuleContext(OptionContext.class, i);
    }

    public List<TerminalNode> SEMI() {
      return getTokens(ANTLRv4Parser.SEMI);
    }

    public TerminalNode SEMI(int i) {
      return getToken(ANTLRv4Parser.SEMI, i);
    }

    public OptionsSpecContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_optionsSpec;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterOptionsSpec(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitOptionsSpec(this);
    }
  }

  public final OptionsSpecContext optionsSpec() throws RecognitionException {
    OptionsSpecContext _localctx = new OptionsSpecContext(_ctx, getState());
    enterRule(_localctx, 8, RULE_optionsSpec);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(168);
        match(OPTIONS);
        setState(169);
        match(LBRACE);
        setState(175);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == TOKEN_REF || _la == RULE_REF) {
          {
            {
              setState(170);
              option();
              setState(171);
              match(SEMI);
            }
          }
          setState(177);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(178);
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
  public static class OptionContext extends ParserRuleContext {
    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public TerminalNode ASSIGN() {
      return getToken(ANTLRv4Parser.ASSIGN, 0);
    }

    public OptionValueContext optionValue() {
      return getRuleContext(OptionValueContext.class, 0);
    }

    public OptionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_option;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterOption(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitOption(this);
    }
  }

  public final OptionContext option() throws RecognitionException {
    OptionContext _localctx = new OptionContext(_ctx, getState());
    enterRule(_localctx, 10, RULE_option);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(180);
        identifier();
        setState(181);
        match(ASSIGN);
        setState(182);
        optionValue();
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
  public static class OptionValueContext extends ParserRuleContext {
    public List<IdentifierContext> identifier() {
      return getRuleContexts(IdentifierContext.class);
    }

    public IdentifierContext identifier(int i) {
      return getRuleContext(IdentifierContext.class, i);
    }

    public List<TerminalNode> DOT() {
      return getTokens(ANTLRv4Parser.DOT);
    }

    public TerminalNode DOT(int i) {
      return getToken(ANTLRv4Parser.DOT, i);
    }

    public TerminalNode STRING_LITERAL() {
      return getToken(ANTLRv4Parser.STRING_LITERAL, 0);
    }

    public ActionBlockContext actionBlock() {
      return getRuleContext(ActionBlockContext.class, 0);
    }

    public TerminalNode INT() {
      return getToken(ANTLRv4Parser.INT, 0);
    }

    public OptionValueContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_optionValue;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterOptionValue(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitOptionValue(this);
    }
  }

  public final OptionValueContext optionValue() throws RecognitionException {
    OptionValueContext _localctx = new OptionValueContext(_ctx, getState());
    enterRule(_localctx, 12, RULE_optionValue);
    int _la;
    try {
      setState(195);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case TOKEN_REF:
        case RULE_REF:
          enterOuterAlt(_localctx, 1);
          {
            setState(184);
            identifier();
            setState(189);
            _errHandler.sync(this);
            _la = _input.LA(1);
            while (_la == DOT) {
              {
                {
                  setState(185);
                  match(DOT);
                  setState(186);
                  identifier();
                }
              }
              setState(191);
              _errHandler.sync(this);
              _la = _input.LA(1);
            }
          }
          break;
        case STRING_LITERAL:
          enterOuterAlt(_localctx, 2);
          {
            setState(192);
            match(STRING_LITERAL);
          }
          break;
        case BEGIN_ACTION:
          enterOuterAlt(_localctx, 3);
          {
            setState(193);
            actionBlock();
          }
          break;
        case INT:
          enterOuterAlt(_localctx, 4);
          {
            setState(194);
            match(INT);
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
  public static class DelegateGrammarsContext extends ParserRuleContext {
    public TerminalNode IMPORT() {
      return getToken(ANTLRv4Parser.IMPORT, 0);
    }

    public List<DelegateGrammarContext> delegateGrammar() {
      return getRuleContexts(DelegateGrammarContext.class);
    }

    public DelegateGrammarContext delegateGrammar(int i) {
      return getRuleContext(DelegateGrammarContext.class, i);
    }

    public TerminalNode SEMI() {
      return getToken(ANTLRv4Parser.SEMI, 0);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(ANTLRv4Parser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(ANTLRv4Parser.COMMA, i);
    }

    public DelegateGrammarsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_delegateGrammars;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterDelegateGrammars(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitDelegateGrammars(this);
    }
  }

  public final DelegateGrammarsContext delegateGrammars() throws RecognitionException {
    DelegateGrammarsContext _localctx = new DelegateGrammarsContext(_ctx, getState());
    enterRule(_localctx, 14, RULE_delegateGrammars);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(197);
        match(IMPORT);
        setState(198);
        delegateGrammar();
        setState(203);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == COMMA) {
          {
            {
              setState(199);
              match(COMMA);
              setState(200);
              delegateGrammar();
            }
          }
          setState(205);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(206);
        match(SEMI);
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
  public static class DelegateGrammarContext extends ParserRuleContext {
    public List<IdentifierContext> identifier() {
      return getRuleContexts(IdentifierContext.class);
    }

    public IdentifierContext identifier(int i) {
      return getRuleContext(IdentifierContext.class, i);
    }

    public TerminalNode ASSIGN() {
      return getToken(ANTLRv4Parser.ASSIGN, 0);
    }

    public DelegateGrammarContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_delegateGrammar;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterDelegateGrammar(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitDelegateGrammar(this);
    }
  }

  public final DelegateGrammarContext delegateGrammar() throws RecognitionException {
    DelegateGrammarContext _localctx = new DelegateGrammarContext(_ctx, getState());
    enterRule(_localctx, 16, RULE_delegateGrammar);
    try {
      setState(213);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 9, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(208);
            identifier();
            setState(209);
            match(ASSIGN);
            setState(210);
            identifier();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(212);
            identifier();
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
  public static class TokensSpecContext extends ParserRuleContext {
    public TerminalNode TOKENS() {
      return getToken(ANTLRv4Parser.TOKENS, 0);
    }

    public TerminalNode LBRACE() {
      return getToken(ANTLRv4Parser.LBRACE, 0);
    }

    public TerminalNode RBRACE() {
      return getToken(ANTLRv4Parser.RBRACE, 0);
    }

    public IdListContext idList() {
      return getRuleContext(IdListContext.class, 0);
    }

    public TokensSpecContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_tokensSpec;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterTokensSpec(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitTokensSpec(this);
    }
  }

  public final TokensSpecContext tokensSpec() throws RecognitionException {
    TokensSpecContext _localctx = new TokensSpecContext(_ctx, getState());
    enterRule(_localctx, 18, RULE_tokensSpec);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(215);
        match(TOKENS);
        setState(216);
        match(LBRACE);
        setState(218);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == TOKEN_REF || _la == RULE_REF) {
          {
            setState(217);
            idList();
          }
        }

        setState(220);
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
  public static class ChannelsSpecContext extends ParserRuleContext {
    public TerminalNode CHANNELS() {
      return getToken(ANTLRv4Parser.CHANNELS, 0);
    }

    public TerminalNode LBRACE() {
      return getToken(ANTLRv4Parser.LBRACE, 0);
    }

    public TerminalNode RBRACE() {
      return getToken(ANTLRv4Parser.RBRACE, 0);
    }

    public IdListContext idList() {
      return getRuleContext(IdListContext.class, 0);
    }

    public ChannelsSpecContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_channelsSpec;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterChannelsSpec(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitChannelsSpec(this);
    }
  }

  public final ChannelsSpecContext channelsSpec() throws RecognitionException {
    ChannelsSpecContext _localctx = new ChannelsSpecContext(_ctx, getState());
    enterRule(_localctx, 20, RULE_channelsSpec);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(222);
        match(CHANNELS);
        setState(223);
        match(LBRACE);
        setState(225);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == TOKEN_REF || _la == RULE_REF) {
          {
            setState(224);
            idList();
          }
        }

        setState(227);
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
  public static class IdListContext extends ParserRuleContext {
    public List<IdentifierContext> identifier() {
      return getRuleContexts(IdentifierContext.class);
    }

    public IdentifierContext identifier(int i) {
      return getRuleContext(IdentifierContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(ANTLRv4Parser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(ANTLRv4Parser.COMMA, i);
    }

    public IdListContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_idList;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterIdList(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitIdList(this);
    }
  }

  public final IdListContext idList() throws RecognitionException {
    IdListContext _localctx = new IdListContext(_ctx, getState());
    enterRule(_localctx, 22, RULE_idList);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(229);
        identifier();
        setState(234);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 12, _ctx);
        while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            {
              {
                setState(230);
                match(COMMA);
                setState(231);
                identifier();
              }
            }
          }
          setState(236);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 12, _ctx);
        }
        setState(238);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == COMMA) {
          {
            setState(237);
            match(COMMA);
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
  public static class Action_Context extends ParserRuleContext {
    public TerminalNode AT() {
      return getToken(ANTLRv4Parser.AT, 0);
    }

    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public ActionBlockContext actionBlock() {
      return getRuleContext(ActionBlockContext.class, 0);
    }

    public ActionScopeNameContext actionScopeName() {
      return getRuleContext(ActionScopeNameContext.class, 0);
    }

    public TerminalNode COLONCOLON() {
      return getToken(ANTLRv4Parser.COLONCOLON, 0);
    }

    public Action_Context(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_action_;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterAction_(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitAction_(this);
    }
  }

  public final Action_Context action_() throws RecognitionException {
    Action_Context _localctx = new Action_Context(_ctx, getState());
    enterRule(_localctx, 24, RULE_action_);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(240);
        match(AT);
        setState(244);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 14, _ctx)) {
          case 1:
            {
              setState(241);
              actionScopeName();
              setState(242);
              match(COLONCOLON);
            }
            break;
        }
        setState(246);
        identifier();
        setState(247);
        actionBlock();
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
  public static class ActionScopeNameContext extends ParserRuleContext {
    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public TerminalNode LEXER() {
      return getToken(ANTLRv4Parser.LEXER, 0);
    }

    public TerminalNode PARSER() {
      return getToken(ANTLRv4Parser.PARSER, 0);
    }

    public ActionScopeNameContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_actionScopeName;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterActionScopeName(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitActionScopeName(this);
    }
  }

  public final ActionScopeNameContext actionScopeName() throws RecognitionException {
    ActionScopeNameContext _localctx = new ActionScopeNameContext(_ctx, getState());
    enterRule(_localctx, 26, RULE_actionScopeName);
    try {
      setState(252);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case TOKEN_REF:
        case RULE_REF:
          enterOuterAlt(_localctx, 1);
          {
            setState(249);
            identifier();
          }
          break;
        case LEXER:
          enterOuterAlt(_localctx, 2);
          {
            setState(250);
            match(LEXER);
          }
          break;
        case PARSER:
          enterOuterAlt(_localctx, 3);
          {
            setState(251);
            match(PARSER);
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
  public static class ActionBlockContext extends ParserRuleContext {
    public TerminalNode BEGIN_ACTION() {
      return getToken(ANTLRv4Parser.BEGIN_ACTION, 0);
    }

    public TerminalNode END_ACTION() {
      return getToken(ANTLRv4Parser.END_ACTION, 0);
    }

    public List<TerminalNode> ACTION_CONTENT() {
      return getTokens(ANTLRv4Parser.ACTION_CONTENT);
    }

    public TerminalNode ACTION_CONTENT(int i) {
      return getToken(ANTLRv4Parser.ACTION_CONTENT, i);
    }

    public ActionBlockContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_actionBlock;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterActionBlock(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitActionBlock(this);
    }
  }

  public final ActionBlockContext actionBlock() throws RecognitionException {
    ActionBlockContext _localctx = new ActionBlockContext(_ctx, getState());
    enterRule(_localctx, 28, RULE_actionBlock);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(254);
        match(BEGIN_ACTION);
        setState(258);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == ACTION_CONTENT) {
          {
            {
              setState(255);
              match(ACTION_CONTENT);
            }
          }
          setState(260);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(261);
        match(END_ACTION);
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
  public static class ArgActionBlockContext extends ParserRuleContext {
    public TerminalNode BEGIN_ARGUMENT() {
      return getToken(ANTLRv4Parser.BEGIN_ARGUMENT, 0);
    }

    public TerminalNode END_ARGUMENT() {
      return getToken(ANTLRv4Parser.END_ARGUMENT, 0);
    }

    public List<TerminalNode> ARGUMENT_CONTENT() {
      return getTokens(ANTLRv4Parser.ARGUMENT_CONTENT);
    }

    public TerminalNode ARGUMENT_CONTENT(int i) {
      return getToken(ANTLRv4Parser.ARGUMENT_CONTENT, i);
    }

    public ArgActionBlockContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_argActionBlock;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterArgActionBlock(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitArgActionBlock(this);
    }
  }

  public final ArgActionBlockContext argActionBlock() throws RecognitionException {
    ArgActionBlockContext _localctx = new ArgActionBlockContext(_ctx, getState());
    enterRule(_localctx, 30, RULE_argActionBlock);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(263);
        match(BEGIN_ARGUMENT);
        setState(267);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == ARGUMENT_CONTENT) {
          {
            {
              setState(264);
              match(ARGUMENT_CONTENT);
            }
          }
          setState(269);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(270);
        match(END_ARGUMENT);
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
  public static class ModeSpecContext extends ParserRuleContext {
    public TerminalNode MODE() {
      return getToken(ANTLRv4Parser.MODE, 0);
    }

    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public TerminalNode SEMI() {
      return getToken(ANTLRv4Parser.SEMI, 0);
    }

    public List<LexerRuleSpecContext> lexerRuleSpec() {
      return getRuleContexts(LexerRuleSpecContext.class);
    }

    public LexerRuleSpecContext lexerRuleSpec(int i) {
      return getRuleContext(LexerRuleSpecContext.class, i);
    }

    public ModeSpecContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_modeSpec;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterModeSpec(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitModeSpec(this);
    }
  }

  public final ModeSpecContext modeSpec() throws RecognitionException {
    ModeSpecContext _localctx = new ModeSpecContext(_ctx, getState());
    enterRule(_localctx, 32, RULE_modeSpec);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(272);
        match(MODE);
        setState(273);
        identifier();
        setState(274);
        match(SEMI);
        setState(278);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 65554L) != 0)) {
          {
            {
              setState(275);
              lexerRuleSpec();
            }
          }
          setState(280);
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
  public static class RulesContext extends ParserRuleContext {
    public List<RuleSpecContext> ruleSpec() {
      return getRuleContexts(RuleSpecContext.class);
    }

    public RuleSpecContext ruleSpec(int i) {
      return getRuleContext(RuleSpecContext.class, i);
    }

    public RulesContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_rules;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterRules(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitRules(this);
    }
  }

  public final RulesContext rules() throws RecognitionException {
    RulesContext _localctx = new RulesContext(_ctx, getState());
    enterRule(_localctx, 34, RULE_rules);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(284);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 7405590L) != 0)) {
          {
            {
              setState(281);
              ruleSpec();
            }
          }
          setState(286);
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
  public static class RuleSpecContext extends ParserRuleContext {
    public ParserRuleSpecContext parserRuleSpec() {
      return getRuleContext(ParserRuleSpecContext.class, 0);
    }

    public LexerRuleSpecContext lexerRuleSpec() {
      return getRuleContext(LexerRuleSpecContext.class, 0);
    }

    public RuleSpecContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_ruleSpec;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterRuleSpec(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitRuleSpec(this);
    }
  }

  public final RuleSpecContext ruleSpec() throws RecognitionException {
    RuleSpecContext _localctx = new RuleSpecContext(_ctx, getState());
    enterRule(_localctx, 36, RULE_ruleSpec);
    try {
      setState(289);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 20, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(287);
            parserRuleSpec();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(288);
            lexerRuleSpec();
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
  public static class ParserRuleSpecContext extends ParserRuleContext {
    public TerminalNode RULE_REF() {
      return getToken(ANTLRv4Parser.RULE_REF, 0);
    }

    public TerminalNode COLON() {
      return getToken(ANTLRv4Parser.COLON, 0);
    }

    public RuleBlockContext ruleBlock() {
      return getRuleContext(RuleBlockContext.class, 0);
    }

    public TerminalNode SEMI() {
      return getToken(ANTLRv4Parser.SEMI, 0);
    }

    public ExceptionGroupContext exceptionGroup() {
      return getRuleContext(ExceptionGroupContext.class, 0);
    }

    public List<TerminalNode> DOC_COMMENT() {
      return getTokens(ANTLRv4Parser.DOC_COMMENT);
    }

    public TerminalNode DOC_COMMENT(int i) {
      return getToken(ANTLRv4Parser.DOC_COMMENT, i);
    }

    public RuleModifiersContext ruleModifiers() {
      return getRuleContext(RuleModifiersContext.class, 0);
    }

    public ArgActionBlockContext argActionBlock() {
      return getRuleContext(ArgActionBlockContext.class, 0);
    }

    public RuleReturnsContext ruleReturns() {
      return getRuleContext(RuleReturnsContext.class, 0);
    }

    public ThrowsSpecContext throwsSpec() {
      return getRuleContext(ThrowsSpecContext.class, 0);
    }

    public LocalsSpecContext localsSpec() {
      return getRuleContext(LocalsSpecContext.class, 0);
    }

    public List<RulePrequelContext> rulePrequel() {
      return getRuleContexts(RulePrequelContext.class);
    }

    public RulePrequelContext rulePrequel(int i) {
      return getRuleContext(RulePrequelContext.class, i);
    }

    public ParserRuleSpecContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_parserRuleSpec;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterParserRuleSpec(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitParserRuleSpec(this);
    }
  }

  public final ParserRuleSpecContext parserRuleSpec() throws RecognitionException {
    ParserRuleSpecContext _localctx = new ParserRuleSpecContext(_ctx, getState());
    enterRule(_localctx, 38, RULE_parserRuleSpec);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(294);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == DOC_COMMENT) {
          {
            {
              setState(291);
              match(DOC_COMMENT);
            }
          }
          setState(296);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(298);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 7405568L) != 0)) {
          {
            setState(297);
            ruleModifiers();
          }
        }

        setState(300);
        match(RULE_REF);
        setState(302);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == BEGIN_ARGUMENT) {
          {
            setState(301);
            argActionBlock();
          }
        }

        setState(305);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == RETURNS) {
          {
            setState(304);
            ruleReturns();
          }
        }

        setState(308);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == THROWS) {
          {
            setState(307);
            throwsSpec();
          }
        }

        setState(311);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == LOCALS) {
          {
            setState(310);
            localsSpec();
          }
        }

        setState(316);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == OPTIONS || _la == AT) {
          {
            {
              setState(313);
              rulePrequel();
            }
          }
          setState(318);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(319);
        match(COLON);
        setState(320);
        ruleBlock();
        setState(321);
        match(SEMI);
        setState(322);
        exceptionGroup();
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
  public static class ExceptionGroupContext extends ParserRuleContext {
    public List<ExceptionHandlerContext> exceptionHandler() {
      return getRuleContexts(ExceptionHandlerContext.class);
    }

    public ExceptionHandlerContext exceptionHandler(int i) {
      return getRuleContext(ExceptionHandlerContext.class, i);
    }

    public FinallyClauseContext finallyClause() {
      return getRuleContext(FinallyClauseContext.class, 0);
    }

    public ExceptionGroupContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_exceptionGroup;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterExceptionGroup(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitExceptionGroup(this);
    }
  }

  public final ExceptionGroupContext exceptionGroup() throws RecognitionException {
    ExceptionGroupContext _localctx = new ExceptionGroupContext(_ctx, getState());
    enterRule(_localctx, 40, RULE_exceptionGroup);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(327);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == CATCH) {
          {
            {
              setState(324);
              exceptionHandler();
            }
          }
          setState(329);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(331);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == FINALLY) {
          {
            setState(330);
            finallyClause();
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
  public static class ExceptionHandlerContext extends ParserRuleContext {
    public TerminalNode CATCH() {
      return getToken(ANTLRv4Parser.CATCH, 0);
    }

    public ArgActionBlockContext argActionBlock() {
      return getRuleContext(ArgActionBlockContext.class, 0);
    }

    public ActionBlockContext actionBlock() {
      return getRuleContext(ActionBlockContext.class, 0);
    }

    public ExceptionHandlerContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_exceptionHandler;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterExceptionHandler(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitExceptionHandler(this);
    }
  }

  public final ExceptionHandlerContext exceptionHandler() throws RecognitionException {
    ExceptionHandlerContext _localctx = new ExceptionHandlerContext(_ctx, getState());
    enterRule(_localctx, 42, RULE_exceptionHandler);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(333);
        match(CATCH);
        setState(334);
        argActionBlock();
        setState(335);
        actionBlock();
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
  public static class FinallyClauseContext extends ParserRuleContext {
    public TerminalNode FINALLY() {
      return getToken(ANTLRv4Parser.FINALLY, 0);
    }

    public ActionBlockContext actionBlock() {
      return getRuleContext(ActionBlockContext.class, 0);
    }

    public FinallyClauseContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_finallyClause;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterFinallyClause(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitFinallyClause(this);
    }
  }

  public final FinallyClauseContext finallyClause() throws RecognitionException {
    FinallyClauseContext _localctx = new FinallyClauseContext(_ctx, getState());
    enterRule(_localctx, 44, RULE_finallyClause);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(337);
        match(FINALLY);
        setState(338);
        actionBlock();
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
  public static class RulePrequelContext extends ParserRuleContext {
    public OptionsSpecContext optionsSpec() {
      return getRuleContext(OptionsSpecContext.class, 0);
    }

    public RuleActionContext ruleAction() {
      return getRuleContext(RuleActionContext.class, 0);
    }

    public RulePrequelContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_rulePrequel;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterRulePrequel(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitRulePrequel(this);
    }
  }

  public final RulePrequelContext rulePrequel() throws RecognitionException {
    RulePrequelContext _localctx = new RulePrequelContext(_ctx, getState());
    enterRule(_localctx, 46, RULE_rulePrequel);
    try {
      setState(342);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case OPTIONS:
          enterOuterAlt(_localctx, 1);
          {
            setState(340);
            optionsSpec();
          }
          break;
        case AT:
          enterOuterAlt(_localctx, 2);
          {
            setState(341);
            ruleAction();
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
  public static class RuleReturnsContext extends ParserRuleContext {
    public TerminalNode RETURNS() {
      return getToken(ANTLRv4Parser.RETURNS, 0);
    }

    public ArgActionBlockContext argActionBlock() {
      return getRuleContext(ArgActionBlockContext.class, 0);
    }

    public RuleReturnsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_ruleReturns;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterRuleReturns(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitRuleReturns(this);
    }
  }

  public final RuleReturnsContext ruleReturns() throws RecognitionException {
    RuleReturnsContext _localctx = new RuleReturnsContext(_ctx, getState());
    enterRule(_localctx, 48, RULE_ruleReturns);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(344);
        match(RETURNS);
        setState(345);
        argActionBlock();
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
  public static class ThrowsSpecContext extends ParserRuleContext {
    public TerminalNode THROWS() {
      return getToken(ANTLRv4Parser.THROWS, 0);
    }

    public List<IdentifierContext> identifier() {
      return getRuleContexts(IdentifierContext.class);
    }

    public IdentifierContext identifier(int i) {
      return getRuleContext(IdentifierContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(ANTLRv4Parser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(ANTLRv4Parser.COMMA, i);
    }

    public ThrowsSpecContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_throwsSpec;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterThrowsSpec(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitThrowsSpec(this);
    }
  }

  public final ThrowsSpecContext throwsSpec() throws RecognitionException {
    ThrowsSpecContext _localctx = new ThrowsSpecContext(_ctx, getState());
    enterRule(_localctx, 50, RULE_throwsSpec);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(347);
        match(THROWS);
        setState(348);
        identifier();
        setState(353);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == COMMA) {
          {
            {
              setState(349);
              match(COMMA);
              setState(350);
              identifier();
            }
          }
          setState(355);
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
  public static class LocalsSpecContext extends ParserRuleContext {
    public TerminalNode LOCALS() {
      return getToken(ANTLRv4Parser.LOCALS, 0);
    }

    public ArgActionBlockContext argActionBlock() {
      return getRuleContext(ArgActionBlockContext.class, 0);
    }

    public LocalsSpecContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_localsSpec;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterLocalsSpec(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitLocalsSpec(this);
    }
  }

  public final LocalsSpecContext localsSpec() throws RecognitionException {
    LocalsSpecContext _localctx = new LocalsSpecContext(_ctx, getState());
    enterRule(_localctx, 52, RULE_localsSpec);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(356);
        match(LOCALS);
        setState(357);
        argActionBlock();
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
  public static class RuleActionContext extends ParserRuleContext {
    public TerminalNode AT() {
      return getToken(ANTLRv4Parser.AT, 0);
    }

    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public ActionBlockContext actionBlock() {
      return getRuleContext(ActionBlockContext.class, 0);
    }

    public RuleActionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_ruleAction;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterRuleAction(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitRuleAction(this);
    }
  }

  public final RuleActionContext ruleAction() throws RecognitionException {
    RuleActionContext _localctx = new RuleActionContext(_ctx, getState());
    enterRule(_localctx, 54, RULE_ruleAction);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(359);
        match(AT);
        setState(360);
        identifier();
        setState(361);
        actionBlock();
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
  public static class RuleModifiersContext extends ParserRuleContext {
    public List<RuleModifierContext> ruleModifier() {
      return getRuleContexts(RuleModifierContext.class);
    }

    public RuleModifierContext ruleModifier(int i) {
      return getRuleContext(RuleModifierContext.class, i);
    }

    public RuleModifiersContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_ruleModifiers;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterRuleModifiers(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitRuleModifiers(this);
    }
  }

  public final RuleModifiersContext ruleModifiers() throws RecognitionException {
    RuleModifiersContext _localctx = new RuleModifiersContext(_ctx, getState());
    enterRule(_localctx, 56, RULE_ruleModifiers);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(364);
        _errHandler.sync(this);
        _la = _input.LA(1);
        do {
          {
            {
              setState(363);
              ruleModifier();
            }
          }
          setState(366);
          _errHandler.sync(this);
          _la = _input.LA(1);
        } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 7405568L) != 0));
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
  public static class RuleModifierContext extends ParserRuleContext {
    public TerminalNode PUBLIC() {
      return getToken(ANTLRv4Parser.PUBLIC, 0);
    }

    public TerminalNode PRIVATE() {
      return getToken(ANTLRv4Parser.PRIVATE, 0);
    }

    public TerminalNode PROTECTED() {
      return getToken(ANTLRv4Parser.PROTECTED, 0);
    }

    public TerminalNode FRAGMENT() {
      return getToken(ANTLRv4Parser.FRAGMENT, 0);
    }

    public RuleModifierContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_ruleModifier;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterRuleModifier(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitRuleModifier(this);
    }
  }

  public final RuleModifierContext ruleModifier() throws RecognitionException {
    RuleModifierContext _localctx = new RuleModifierContext(_ctx, getState());
    enterRule(_localctx, 58, RULE_ruleModifier);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(368);
        _la = _input.LA(1);
        if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 7405568L) != 0))) {
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
  public static class RuleBlockContext extends ParserRuleContext {
    public RuleAltListContext ruleAltList() {
      return getRuleContext(RuleAltListContext.class, 0);
    }

    public RuleBlockContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_ruleBlock;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterRuleBlock(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitRuleBlock(this);
    }
  }

  public final RuleBlockContext ruleBlock() throws RecognitionException {
    RuleBlockContext _localctx = new RuleBlockContext(_ctx, getState());
    enterRule(_localctx, 60, RULE_ruleBlock);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(370);
        ruleAltList();
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
  public static class RuleAltListContext extends ParserRuleContext {
    public List<LabeledAltContext> labeledAlt() {
      return getRuleContexts(LabeledAltContext.class);
    }

    public LabeledAltContext labeledAlt(int i) {
      return getRuleContext(LabeledAltContext.class, i);
    }

    public List<TerminalNode> OR() {
      return getTokens(ANTLRv4Parser.OR);
    }

    public TerminalNode OR(int i) {
      return getToken(ANTLRv4Parser.OR, i);
    }

    public RuleAltListContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_ruleAltList;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterRuleAltList(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitRuleAltList(this);
    }
  }

  public final RuleAltListContext ruleAltList() throws RecognitionException {
    RuleAltListContext _localctx = new RuleAltListContext(_ctx, getState());
    enterRule(_localctx, 62, RULE_ruleAltList);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(372);
        labeledAlt();
        setState(377);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == OR) {
          {
            {
              setState(373);
              match(OR);
              setState(374);
              labeledAlt();
            }
          }
          setState(379);
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
  public static class LabeledAltContext extends ParserRuleContext {
    public AlternativeContext alternative() {
      return getRuleContext(AlternativeContext.class, 0);
    }

    public TerminalNode POUND() {
      return getToken(ANTLRv4Parser.POUND, 0);
    }

    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public LabeledAltContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_labeledAlt;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterLabeledAlt(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitLabeledAlt(this);
    }
  }

  public final LabeledAltContext labeledAlt() throws RecognitionException {
    LabeledAltContext _localctx = new LabeledAltContext(_ctx, getState());
    enterRule(_localctx, 64, RULE_labeledAlt);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(380);
        alternative();
        setState(383);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == POUND) {
          {
            setState(381);
            match(POUND);
            setState(382);
            identifier();
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
  public static class LexerRuleSpecContext extends ParserRuleContext {
    public TerminalNode TOKEN_REF() {
      return getToken(ANTLRv4Parser.TOKEN_REF, 0);
    }

    public TerminalNode COLON() {
      return getToken(ANTLRv4Parser.COLON, 0);
    }

    public LexerRuleBlockContext lexerRuleBlock() {
      return getRuleContext(LexerRuleBlockContext.class, 0);
    }

    public TerminalNode SEMI() {
      return getToken(ANTLRv4Parser.SEMI, 0);
    }

    public List<TerminalNode> DOC_COMMENT() {
      return getTokens(ANTLRv4Parser.DOC_COMMENT);
    }

    public TerminalNode DOC_COMMENT(int i) {
      return getToken(ANTLRv4Parser.DOC_COMMENT, i);
    }

    public TerminalNode FRAGMENT() {
      return getToken(ANTLRv4Parser.FRAGMENT, 0);
    }

    public LexerRuleSpecContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_lexerRuleSpec;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterLexerRuleSpec(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitLexerRuleSpec(this);
    }
  }

  public final LexerRuleSpecContext lexerRuleSpec() throws RecognitionException {
    LexerRuleSpecContext _localctx = new LexerRuleSpecContext(_ctx, getState());
    enterRule(_localctx, 66, RULE_lexerRuleSpec);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(388);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == DOC_COMMENT) {
          {
            {
              setState(385);
              match(DOC_COMMENT);
            }
          }
          setState(390);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(392);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == FRAGMENT) {
          {
            setState(391);
            match(FRAGMENT);
          }
        }

        setState(394);
        match(TOKEN_REF);
        setState(395);
        match(COLON);
        setState(396);
        lexerRuleBlock();
        setState(397);
        match(SEMI);
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
  public static class LexerRuleBlockContext extends ParserRuleContext {
    public LexerAltListContext lexerAltList() {
      return getRuleContext(LexerAltListContext.class, 0);
    }

    public LexerRuleBlockContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_lexerRuleBlock;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterLexerRuleBlock(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitLexerRuleBlock(this);
    }
  }

  public final LexerRuleBlockContext lexerRuleBlock() throws RecognitionException {
    LexerRuleBlockContext _localctx = new LexerRuleBlockContext(_ctx, getState());
    enterRule(_localctx, 68, RULE_lexerRuleBlock);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(399);
        lexerAltList();
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
  public static class LexerAltListContext extends ParserRuleContext {
    public List<LexerAltContext> lexerAlt() {
      return getRuleContexts(LexerAltContext.class);
    }

    public LexerAltContext lexerAlt(int i) {
      return getRuleContext(LexerAltContext.class, i);
    }

    public List<TerminalNode> OR() {
      return getTokens(ANTLRv4Parser.OR);
    }

    public TerminalNode OR(int i) {
      return getToken(ANTLRv4Parser.OR, i);
    }

    public LexerAltListContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_lexerAltList;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterLexerAltList(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitLexerAltList(this);
    }
  }

  public final LexerAltListContext lexerAltList() throws RecognitionException {
    LexerAltListContext _localctx = new LexerAltListContext(_ctx, getState());
    enterRule(_localctx, 70, RULE_lexerAltList);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(401);
        lexerAlt();
        setState(406);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == OR) {
          {
            {
              setState(402);
              match(OR);
              setState(403);
              lexerAlt();
            }
          }
          setState(408);
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
  public static class LexerAltContext extends ParserRuleContext {
    public LexerElementsContext lexerElements() {
      return getRuleContext(LexerElementsContext.class, 0);
    }

    public LexerCommandsContext lexerCommands() {
      return getRuleContext(LexerCommandsContext.class, 0);
    }

    public LexerAltContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_lexerAlt;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterLexerAlt(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitLexerAlt(this);
    }
  }

  public final LexerAltContext lexerAlt() throws RecognitionException {
    LexerAltContext _localctx = new LexerAltContext(_ctx, getState());
    enterRule(_localctx, 72, RULE_lexerAlt);
    int _la;
    try {
      setState(414);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case TOKEN_REF:
        case RULE_REF:
        case LEXER_CHAR_SET:
        case STRING_LITERAL:
        case BEGIN_ACTION:
        case LPAREN:
        case DOT:
        case NOT:
          enterOuterAlt(_localctx, 1);
          {
            setState(409);
            lexerElements();
            setState(411);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == RARROW) {
              {
                setState(410);
                lexerCommands();
              }
            }
          }
          break;
        case SEMI:
        case RPAREN:
        case OR:
          enterOuterAlt(_localctx, 2);
          {
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
  public static class LexerElementsContext extends ParserRuleContext {
    public List<LexerElementContext> lexerElement() {
      return getRuleContexts(LexerElementContext.class);
    }

    public LexerElementContext lexerElement(int i) {
      return getRuleContext(LexerElementContext.class, i);
    }

    public LexerElementsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_lexerElements;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterLexerElements(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitLexerElements(this);
    }
  }

  public final LexerElementsContext lexerElements() throws RecognitionException {
    LexerElementsContext _localctx = new LexerElementsContext(_ctx, getState());
    enterRule(_localctx, 74, RULE_lexerElements);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(417);
        _errHandler.sync(this);
        _la = _input.LA(1);
        do {
          {
            {
              setState(416);
              lexerElement();
            }
          }
          setState(419);
          _errHandler.sync(this);
          _la = _input.LA(1);
        } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2533283380332814L) != 0));
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
  public static class LexerElementContext extends ParserRuleContext {
    public LabeledLexerElementContext labeledLexerElement() {
      return getRuleContext(LabeledLexerElementContext.class, 0);
    }

    public EbnfSuffixContext ebnfSuffix() {
      return getRuleContext(EbnfSuffixContext.class, 0);
    }

    public LexerAtomContext lexerAtom() {
      return getRuleContext(LexerAtomContext.class, 0);
    }

    public LexerBlockContext lexerBlock() {
      return getRuleContext(LexerBlockContext.class, 0);
    }

    public ActionBlockContext actionBlock() {
      return getRuleContext(ActionBlockContext.class, 0);
    }

    public TerminalNode QUESTION() {
      return getToken(ANTLRv4Parser.QUESTION, 0);
    }

    public LexerElementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_lexerElement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterLexerElement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitLexerElement(this);
    }
  }

  public final LexerElementContext lexerElement() throws RecognitionException {
    LexerElementContext _localctx = new LexerElementContext(_ctx, getState());
    enterRule(_localctx, 76, RULE_lexerElement);
    int _la;
    try {
      setState(437);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 45, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(421);
            labeledLexerElement();
            setState(423);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 24189255811072L) != 0)) {
              {
                setState(422);
                ebnfSuffix();
              }
            }
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(425);
            lexerAtom();
            setState(427);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 24189255811072L) != 0)) {
              {
                setState(426);
                ebnfSuffix();
              }
            }
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(429);
            lexerBlock();
            setState(431);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 24189255811072L) != 0)) {
              {
                setState(430);
                ebnfSuffix();
              }
            }
          }
          break;
        case 4:
          enterOuterAlt(_localctx, 4);
          {
            setState(433);
            actionBlock();
            setState(435);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == QUESTION) {
              {
                setState(434);
                match(QUESTION);
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
  public static class LabeledLexerElementContext extends ParserRuleContext {
    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public TerminalNode ASSIGN() {
      return getToken(ANTLRv4Parser.ASSIGN, 0);
    }

    public TerminalNode PLUS_ASSIGN() {
      return getToken(ANTLRv4Parser.PLUS_ASSIGN, 0);
    }

    public LexerAtomContext lexerAtom() {
      return getRuleContext(LexerAtomContext.class, 0);
    }

    public LexerBlockContext lexerBlock() {
      return getRuleContext(LexerBlockContext.class, 0);
    }

    public LabeledLexerElementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_labeledLexerElement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterLabeledLexerElement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitLabeledLexerElement(this);
    }
  }

  public final LabeledLexerElementContext labeledLexerElement() throws RecognitionException {
    LabeledLexerElementContext _localctx = new LabeledLexerElementContext(_ctx, getState());
    enterRule(_localctx, 78, RULE_labeledLexerElement);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(439);
        identifier();
        setState(440);
        _la = _input.LA(1);
        if (!(_la == ASSIGN || _la == PLUS_ASSIGN)) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF) matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
        setState(443);
        _errHandler.sync(this);
        switch (_input.LA(1)) {
          case TOKEN_REF:
          case LEXER_CHAR_SET:
          case STRING_LITERAL:
          case DOT:
          case NOT:
            {
              setState(441);
              lexerAtom();
            }
            break;
          case LPAREN:
            {
              setState(442);
              lexerBlock();
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
  public static class LexerBlockContext extends ParserRuleContext {
    public TerminalNode LPAREN() {
      return getToken(ANTLRv4Parser.LPAREN, 0);
    }

    public LexerAltListContext lexerAltList() {
      return getRuleContext(LexerAltListContext.class, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(ANTLRv4Parser.RPAREN, 0);
    }

    public LexerBlockContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_lexerBlock;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterLexerBlock(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitLexerBlock(this);
    }
  }

  public final LexerBlockContext lexerBlock() throws RecognitionException {
    LexerBlockContext _localctx = new LexerBlockContext(_ctx, getState());
    enterRule(_localctx, 80, RULE_lexerBlock);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(445);
        match(LPAREN);
        setState(446);
        lexerAltList();
        setState(447);
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
  public static class LexerCommandsContext extends ParserRuleContext {
    public TerminalNode RARROW() {
      return getToken(ANTLRv4Parser.RARROW, 0);
    }

    public List<LexerCommandContext> lexerCommand() {
      return getRuleContexts(LexerCommandContext.class);
    }

    public LexerCommandContext lexerCommand(int i) {
      return getRuleContext(LexerCommandContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(ANTLRv4Parser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(ANTLRv4Parser.COMMA, i);
    }

    public LexerCommandsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_lexerCommands;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterLexerCommands(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitLexerCommands(this);
    }
  }

  public final LexerCommandsContext lexerCommands() throws RecognitionException {
    LexerCommandsContext _localctx = new LexerCommandsContext(_ctx, getState());
    enterRule(_localctx, 82, RULE_lexerCommands);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(449);
        match(RARROW);
        setState(450);
        lexerCommand();
        setState(455);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == COMMA) {
          {
            {
              setState(451);
              match(COMMA);
              setState(452);
              lexerCommand();
            }
          }
          setState(457);
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
  public static class LexerCommandContext extends ParserRuleContext {
    public LexerCommandNameContext lexerCommandName() {
      return getRuleContext(LexerCommandNameContext.class, 0);
    }

    public TerminalNode LPAREN() {
      return getToken(ANTLRv4Parser.LPAREN, 0);
    }

    public LexerCommandExprContext lexerCommandExpr() {
      return getRuleContext(LexerCommandExprContext.class, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(ANTLRv4Parser.RPAREN, 0);
    }

    public LexerCommandContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_lexerCommand;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterLexerCommand(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitLexerCommand(this);
    }
  }

  public final LexerCommandContext lexerCommand() throws RecognitionException {
    LexerCommandContext _localctx = new LexerCommandContext(_ctx, getState());
    enterRule(_localctx, 84, RULE_lexerCommand);
    try {
      setState(464);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 48, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(458);
            lexerCommandName();
            setState(459);
            match(LPAREN);
            setState(460);
            lexerCommandExpr();
            setState(461);
            match(RPAREN);
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(463);
            lexerCommandName();
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
  public static class LexerCommandNameContext extends ParserRuleContext {
    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public TerminalNode MODE() {
      return getToken(ANTLRv4Parser.MODE, 0);
    }

    public LexerCommandNameContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_lexerCommandName;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterLexerCommandName(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitLexerCommandName(this);
    }
  }

  public final LexerCommandNameContext lexerCommandName() throws RecognitionException {
    LexerCommandNameContext _localctx = new LexerCommandNameContext(_ctx, getState());
    enterRule(_localctx, 86, RULE_lexerCommandName);
    try {
      setState(468);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case TOKEN_REF:
        case RULE_REF:
          enterOuterAlt(_localctx, 1);
          {
            setState(466);
            identifier();
          }
          break;
        case MODE:
          enterOuterAlt(_localctx, 2);
          {
            setState(467);
            match(MODE);
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
  public static class LexerCommandExprContext extends ParserRuleContext {
    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public TerminalNode INT() {
      return getToken(ANTLRv4Parser.INT, 0);
    }

    public LexerCommandExprContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_lexerCommandExpr;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterLexerCommandExpr(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitLexerCommandExpr(this);
    }
  }

  public final LexerCommandExprContext lexerCommandExpr() throws RecognitionException {
    LexerCommandExprContext _localctx = new LexerCommandExprContext(_ctx, getState());
    enterRule(_localctx, 88, RULE_lexerCommandExpr);
    try {
      setState(472);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case TOKEN_REF:
        case RULE_REF:
          enterOuterAlt(_localctx, 1);
          {
            setState(470);
            identifier();
          }
          break;
        case INT:
          enterOuterAlt(_localctx, 2);
          {
            setState(471);
            match(INT);
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
  public static class AltListContext extends ParserRuleContext {
    public List<AlternativeContext> alternative() {
      return getRuleContexts(AlternativeContext.class);
    }

    public AlternativeContext alternative(int i) {
      return getRuleContext(AlternativeContext.class, i);
    }

    public List<TerminalNode> OR() {
      return getTokens(ANTLRv4Parser.OR);
    }

    public TerminalNode OR(int i) {
      return getToken(ANTLRv4Parser.OR, i);
    }

    public AltListContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_altList;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterAltList(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitAltList(this);
    }
  }

  public final AltListContext altList() throws RecognitionException {
    AltListContext _localctx = new AltListContext(_ctx, getState());
    enterRule(_localctx, 90, RULE_altList);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(474);
        alternative();
        setState(479);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == OR) {
          {
            {
              setState(475);
              match(OR);
              setState(476);
              alternative();
            }
          }
          setState(481);
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
  public static class AlternativeContext extends ParserRuleContext {
    public ElementOptionsContext elementOptions() {
      return getRuleContext(ElementOptionsContext.class, 0);
    }

    public List<ElementContext> element() {
      return getRuleContexts(ElementContext.class);
    }

    public ElementContext element(int i) {
      return getRuleContext(ElementContext.class, i);
    }

    public AlternativeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_alternative;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterAlternative(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitAlternative(this);
    }
  }

  public final AlternativeContext alternative() throws RecognitionException {
    AlternativeContext _localctx = new AlternativeContext(_ctx, getState());
    enterRule(_localctx, 92, RULE_alternative);
    int _la;
    try {
      setState(491);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case TOKEN_REF:
        case RULE_REF:
        case STRING_LITERAL:
        case BEGIN_ACTION:
        case LPAREN:
        case LT:
        case DOT:
        case NOT:
          enterOuterAlt(_localctx, 1);
          {
            setState(483);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == LT) {
              {
                setState(482);
                elementOptions();
              }
            }

            setState(486);
            _errHandler.sync(this);
            _la = _input.LA(1);
            do {
              {
                {
                  setState(485);
                  element();
                }
              }
              setState(488);
              _errHandler.sync(this);
              _la = _input.LA(1);
            } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2533283380332806L) != 0));
          }
          break;
        case SEMI:
        case RPAREN:
        case OR:
        case POUND:
          enterOuterAlt(_localctx, 2);
          {
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
  public static class ElementContext extends ParserRuleContext {
    public LabeledElementContext labeledElement() {
      return getRuleContext(LabeledElementContext.class, 0);
    }

    public EbnfSuffixContext ebnfSuffix() {
      return getRuleContext(EbnfSuffixContext.class, 0);
    }

    public AtomContext atom() {
      return getRuleContext(AtomContext.class, 0);
    }

    public EbnfContext ebnf() {
      return getRuleContext(EbnfContext.class, 0);
    }

    public ActionBlockContext actionBlock() {
      return getRuleContext(ActionBlockContext.class, 0);
    }

    public TerminalNode QUESTION() {
      return getToken(ANTLRv4Parser.QUESTION, 0);
    }

    public ElementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_element;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterElement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitElement(this);
    }
  }

  public final ElementContext element() throws RecognitionException {
    ElementContext _localctx = new ElementContext(_ctx, getState());
    enterRule(_localctx, 94, RULE_element);
    int _la;
    try {
      setState(508);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 58, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(493);
            labeledElement();
            setState(496);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
              case QUESTION:
              case STAR:
              case PLUS:
                {
                  setState(494);
                  ebnfSuffix();
                }
                break;
              case TOKEN_REF:
              case RULE_REF:
              case STRING_LITERAL:
              case BEGIN_ACTION:
              case SEMI:
              case LPAREN:
              case RPAREN:
              case OR:
              case DOT:
              case POUND:
              case NOT:
                {
                }
                break;
              default:
                throw new NoViableAltException(this);
            }
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(498);
            atom();
            setState(501);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
              case QUESTION:
              case STAR:
              case PLUS:
                {
                  setState(499);
                  ebnfSuffix();
                }
                break;
              case TOKEN_REF:
              case RULE_REF:
              case STRING_LITERAL:
              case BEGIN_ACTION:
              case SEMI:
              case LPAREN:
              case RPAREN:
              case OR:
              case DOT:
              case POUND:
              case NOT:
                {
                }
                break;
              default:
                throw new NoViableAltException(this);
            }
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(503);
            ebnf();
          }
          break;
        case 4:
          enterOuterAlt(_localctx, 4);
          {
            setState(504);
            actionBlock();
            setState(506);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == QUESTION) {
              {
                setState(505);
                match(QUESTION);
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
  public static class LabeledElementContext extends ParserRuleContext {
    public IdentifierContext identifier() {
      return getRuleContext(IdentifierContext.class, 0);
    }

    public TerminalNode ASSIGN() {
      return getToken(ANTLRv4Parser.ASSIGN, 0);
    }

    public TerminalNode PLUS_ASSIGN() {
      return getToken(ANTLRv4Parser.PLUS_ASSIGN, 0);
    }

    public AtomContext atom() {
      return getRuleContext(AtomContext.class, 0);
    }

    public BlockContext block() {
      return getRuleContext(BlockContext.class, 0);
    }

    public LabeledElementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_labeledElement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterLabeledElement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitLabeledElement(this);
    }
  }

  public final LabeledElementContext labeledElement() throws RecognitionException {
    LabeledElementContext _localctx = new LabeledElementContext(_ctx, getState());
    enterRule(_localctx, 96, RULE_labeledElement);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(510);
        identifier();
        setState(511);
        _la = _input.LA(1);
        if (!(_la == ASSIGN || _la == PLUS_ASSIGN)) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF) matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
        setState(514);
        _errHandler.sync(this);
        switch (_input.LA(1)) {
          case TOKEN_REF:
          case RULE_REF:
          case STRING_LITERAL:
          case DOT:
          case NOT:
            {
              setState(512);
              atom();
            }
            break;
          case LPAREN:
            {
              setState(513);
              block();
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
  public static class EbnfContext extends ParserRuleContext {
    public BlockContext block() {
      return getRuleContext(BlockContext.class, 0);
    }

    public BlockSuffixContext blockSuffix() {
      return getRuleContext(BlockSuffixContext.class, 0);
    }

    public EbnfContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_ebnf;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterEbnf(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitEbnf(this);
    }
  }

  public final EbnfContext ebnf() throws RecognitionException {
    EbnfContext _localctx = new EbnfContext(_ctx, getState());
    enterRule(_localctx, 98, RULE_ebnf);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(516);
        block();
        setState(518);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 24189255811072L) != 0)) {
          {
            setState(517);
            blockSuffix();
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
  public static class BlockSuffixContext extends ParserRuleContext {
    public EbnfSuffixContext ebnfSuffix() {
      return getRuleContext(EbnfSuffixContext.class, 0);
    }

    public BlockSuffixContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_blockSuffix;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterBlockSuffix(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitBlockSuffix(this);
    }
  }

  public final BlockSuffixContext blockSuffix() throws RecognitionException {
    BlockSuffixContext _localctx = new BlockSuffixContext(_ctx, getState());
    enterRule(_localctx, 100, RULE_blockSuffix);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(520);
        ebnfSuffix();
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
  public static class EbnfSuffixContext extends ParserRuleContext {
    public List<TerminalNode> QUESTION() {
      return getTokens(ANTLRv4Parser.QUESTION);
    }

    public TerminalNode QUESTION(int i) {
      return getToken(ANTLRv4Parser.QUESTION, i);
    }

    public TerminalNode STAR() {
      return getToken(ANTLRv4Parser.STAR, 0);
    }

    public TerminalNode PLUS() {
      return getToken(ANTLRv4Parser.PLUS, 0);
    }

    public EbnfSuffixContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_ebnfSuffix;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterEbnfSuffix(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitEbnfSuffix(this);
    }
  }

  public final EbnfSuffixContext ebnfSuffix() throws RecognitionException {
    EbnfSuffixContext _localctx = new EbnfSuffixContext(_ctx, getState());
    enterRule(_localctx, 102, RULE_ebnfSuffix);
    int _la;
    try {
      setState(534);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case QUESTION:
          enterOuterAlt(_localctx, 1);
          {
            setState(522);
            match(QUESTION);
            setState(524);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == QUESTION) {
              {
                setState(523);
                match(QUESTION);
              }
            }
          }
          break;
        case STAR:
          enterOuterAlt(_localctx, 2);
          {
            setState(526);
            match(STAR);
            setState(528);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == QUESTION) {
              {
                setState(527);
                match(QUESTION);
              }
            }
          }
          break;
        case PLUS:
          enterOuterAlt(_localctx, 3);
          {
            setState(530);
            match(PLUS);
            setState(532);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == QUESTION) {
              {
                setState(531);
                match(QUESTION);
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
  public static class LexerAtomContext extends ParserRuleContext {
    public CharacterRangeContext characterRange() {
      return getRuleContext(CharacterRangeContext.class, 0);
    }

    public TerminalContext terminal() {
      return getRuleContext(TerminalContext.class, 0);
    }

    public NotSetContext notSet() {
      return getRuleContext(NotSetContext.class, 0);
    }

    public TerminalNode LEXER_CHAR_SET() {
      return getToken(ANTLRv4Parser.LEXER_CHAR_SET, 0);
    }

    public TerminalNode DOT() {
      return getToken(ANTLRv4Parser.DOT, 0);
    }

    public ElementOptionsContext elementOptions() {
      return getRuleContext(ElementOptionsContext.class, 0);
    }

    public LexerAtomContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_lexerAtom;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterLexerAtom(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitLexerAtom(this);
    }
  }

  public final LexerAtomContext lexerAtom() throws RecognitionException {
    LexerAtomContext _localctx = new LexerAtomContext(_ctx, getState());
    enterRule(_localctx, 104, RULE_lexerAtom);
    int _la;
    try {
      setState(544);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 66, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(536);
            characterRange();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(537);
            terminal();
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(538);
            notSet();
          }
          break;
        case 4:
          enterOuterAlt(_localctx, 4);
          {
            setState(539);
            match(LEXER_CHAR_SET);
          }
          break;
        case 5:
          enterOuterAlt(_localctx, 5);
          {
            setState(540);
            match(DOT);
            setState(542);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == LT) {
              {
                setState(541);
                elementOptions();
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
  public static class AtomContext extends ParserRuleContext {
    public TerminalContext terminal() {
      return getRuleContext(TerminalContext.class, 0);
    }

    public RulerefContext ruleref() {
      return getRuleContext(RulerefContext.class, 0);
    }

    public NotSetContext notSet() {
      return getRuleContext(NotSetContext.class, 0);
    }

    public TerminalNode DOT() {
      return getToken(ANTLRv4Parser.DOT, 0);
    }

    public ElementOptionsContext elementOptions() {
      return getRuleContext(ElementOptionsContext.class, 0);
    }

    public AtomContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_atom;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterAtom(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitAtom(this);
    }
  }

  public final AtomContext atom() throws RecognitionException {
    AtomContext _localctx = new AtomContext(_ctx, getState());
    enterRule(_localctx, 106, RULE_atom);
    int _la;
    try {
      setState(553);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case TOKEN_REF:
        case STRING_LITERAL:
          enterOuterAlt(_localctx, 1);
          {
            setState(546);
            terminal();
          }
          break;
        case RULE_REF:
          enterOuterAlt(_localctx, 2);
          {
            setState(547);
            ruleref();
          }
          break;
        case NOT:
          enterOuterAlt(_localctx, 3);
          {
            setState(548);
            notSet();
          }
          break;
        case DOT:
          enterOuterAlt(_localctx, 4);
          {
            setState(549);
            match(DOT);
            setState(551);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == LT) {
              {
                setState(550);
                elementOptions();
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
  public static class NotSetContext extends ParserRuleContext {
    public TerminalNode NOT() {
      return getToken(ANTLRv4Parser.NOT, 0);
    }

    public SetElementContext setElement() {
      return getRuleContext(SetElementContext.class, 0);
    }

    public BlockSetContext blockSet() {
      return getRuleContext(BlockSetContext.class, 0);
    }

    public NotSetContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_notSet;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterNotSet(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitNotSet(this);
    }
  }

  public final NotSetContext notSet() throws RecognitionException {
    NotSetContext _localctx = new NotSetContext(_ctx, getState());
    enterRule(_localctx, 108, RULE_notSet);
    try {
      setState(559);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 69, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(555);
            match(NOT);
            setState(556);
            setElement();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(557);
            match(NOT);
            setState(558);
            blockSet();
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
  public static class BlockSetContext extends ParserRuleContext {
    public TerminalNode LPAREN() {
      return getToken(ANTLRv4Parser.LPAREN, 0);
    }

    public List<SetElementContext> setElement() {
      return getRuleContexts(SetElementContext.class);
    }

    public SetElementContext setElement(int i) {
      return getRuleContext(SetElementContext.class, i);
    }

    public TerminalNode RPAREN() {
      return getToken(ANTLRv4Parser.RPAREN, 0);
    }

    public List<TerminalNode> OR() {
      return getTokens(ANTLRv4Parser.OR);
    }

    public TerminalNode OR(int i) {
      return getToken(ANTLRv4Parser.OR, i);
    }

    public BlockSetContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_blockSet;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterBlockSet(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitBlockSet(this);
    }
  }

  public final BlockSetContext blockSet() throws RecognitionException {
    BlockSetContext _localctx = new BlockSetContext(_ctx, getState());
    enterRule(_localctx, 110, RULE_blockSet);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(561);
        match(LPAREN);
        setState(562);
        setElement();
        setState(567);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == OR) {
          {
            {
              setState(563);
              match(OR);
              setState(564);
              setElement();
            }
          }
          setState(569);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(570);
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
  public static class SetElementContext extends ParserRuleContext {
    public TerminalNode TOKEN_REF() {
      return getToken(ANTLRv4Parser.TOKEN_REF, 0);
    }

    public ElementOptionsContext elementOptions() {
      return getRuleContext(ElementOptionsContext.class, 0);
    }

    public TerminalNode STRING_LITERAL() {
      return getToken(ANTLRv4Parser.STRING_LITERAL, 0);
    }

    public CharacterRangeContext characterRange() {
      return getRuleContext(CharacterRangeContext.class, 0);
    }

    public TerminalNode LEXER_CHAR_SET() {
      return getToken(ANTLRv4Parser.LEXER_CHAR_SET, 0);
    }

    public SetElementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_setElement;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterSetElement(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitSetElement(this);
    }
  }

  public final SetElementContext setElement() throws RecognitionException {
    SetElementContext _localctx = new SetElementContext(_ctx, getState());
    enterRule(_localctx, 112, RULE_setElement);
    int _la;
    try {
      setState(582);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 73, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(572);
            match(TOKEN_REF);
            setState(574);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == LT) {
              {
                setState(573);
                elementOptions();
              }
            }
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(576);
            match(STRING_LITERAL);
            setState(578);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == LT) {
              {
                setState(577);
                elementOptions();
              }
            }
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(580);
            characterRange();
          }
          break;
        case 4:
          enterOuterAlt(_localctx, 4);
          {
            setState(581);
            match(LEXER_CHAR_SET);
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
    public TerminalNode LPAREN() {
      return getToken(ANTLRv4Parser.LPAREN, 0);
    }

    public AltListContext altList() {
      return getRuleContext(AltListContext.class, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(ANTLRv4Parser.RPAREN, 0);
    }

    public TerminalNode COLON() {
      return getToken(ANTLRv4Parser.COLON, 0);
    }

    public OptionsSpecContext optionsSpec() {
      return getRuleContext(OptionsSpecContext.class, 0);
    }

    public List<RuleActionContext> ruleAction() {
      return getRuleContexts(RuleActionContext.class);
    }

    public RuleActionContext ruleAction(int i) {
      return getRuleContext(RuleActionContext.class, i);
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
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterBlock(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitBlock(this);
    }
  }

  public final BlockContext block() throws RecognitionException {
    BlockContext _localctx = new BlockContext(_ctx, getState());
    enterRule(_localctx, 114, RULE_block);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(584);
        match(LPAREN);
        setState(595);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 562950490296320L) != 0)) {
          {
            setState(586);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == OPTIONS) {
              {
                setState(585);
                optionsSpec();
              }
            }

            setState(591);
            _errHandler.sync(this);
            _la = _input.LA(1);
            while (_la == AT) {
              {
                {
                  setState(588);
                  ruleAction();
                }
              }
              setState(593);
              _errHandler.sync(this);
              _la = _input.LA(1);
            }
            setState(594);
            match(COLON);
          }
        }

        setState(597);
        altList();
        setState(598);
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
  public static class RulerefContext extends ParserRuleContext {
    public TerminalNode RULE_REF() {
      return getToken(ANTLRv4Parser.RULE_REF, 0);
    }

    public ArgActionBlockContext argActionBlock() {
      return getRuleContext(ArgActionBlockContext.class, 0);
    }

    public ElementOptionsContext elementOptions() {
      return getRuleContext(ElementOptionsContext.class, 0);
    }

    public RulerefContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_ruleref;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterRuleref(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitRuleref(this);
    }
  }

  public final RulerefContext ruleref() throws RecognitionException {
    RulerefContext _localctx = new RulerefContext(_ctx, getState());
    enterRule(_localctx, 116, RULE_ruleref);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(600);
        match(RULE_REF);
        setState(602);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == BEGIN_ARGUMENT) {
          {
            setState(601);
            argActionBlock();
          }
        }

        setState(605);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == LT) {
          {
            setState(604);
            elementOptions();
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
  public static class CharacterRangeContext extends ParserRuleContext {
    public List<TerminalNode> STRING_LITERAL() {
      return getTokens(ANTLRv4Parser.STRING_LITERAL);
    }

    public TerminalNode STRING_LITERAL(int i) {
      return getToken(ANTLRv4Parser.STRING_LITERAL, i);
    }

    public TerminalNode RANGE() {
      return getToken(ANTLRv4Parser.RANGE, 0);
    }

    public CharacterRangeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_characterRange;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterCharacterRange(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitCharacterRange(this);
    }
  }

  public final CharacterRangeContext characterRange() throws RecognitionException {
    CharacterRangeContext _localctx = new CharacterRangeContext(_ctx, getState());
    enterRule(_localctx, 118, RULE_characterRange);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(607);
        match(STRING_LITERAL);
        setState(608);
        match(RANGE);
        setState(609);
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
  public static class TerminalContext extends ParserRuleContext {
    public TerminalNode TOKEN_REF() {
      return getToken(ANTLRv4Parser.TOKEN_REF, 0);
    }

    public ElementOptionsContext elementOptions() {
      return getRuleContext(ElementOptionsContext.class, 0);
    }

    public TerminalNode STRING_LITERAL() {
      return getToken(ANTLRv4Parser.STRING_LITERAL, 0);
    }

    public TerminalContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_terminal;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterTerminal(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitTerminal(this);
    }
  }

  public final TerminalContext terminal() throws RecognitionException {
    TerminalContext _localctx = new TerminalContext(_ctx, getState());
    enterRule(_localctx, 120, RULE_terminal);
    int _la;
    try {
      setState(619);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case TOKEN_REF:
          enterOuterAlt(_localctx, 1);
          {
            setState(611);
            match(TOKEN_REF);
            setState(613);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == LT) {
              {
                setState(612);
                elementOptions();
              }
            }
          }
          break;
        case STRING_LITERAL:
          enterOuterAlt(_localctx, 2);
          {
            setState(615);
            match(STRING_LITERAL);
            setState(617);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == LT) {
              {
                setState(616);
                elementOptions();
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
  public static class ElementOptionsContext extends ParserRuleContext {
    public TerminalNode LT() {
      return getToken(ANTLRv4Parser.LT, 0);
    }

    public List<ElementOptionContext> elementOption() {
      return getRuleContexts(ElementOptionContext.class);
    }

    public ElementOptionContext elementOption(int i) {
      return getRuleContext(ElementOptionContext.class, i);
    }

    public TerminalNode GT() {
      return getToken(ANTLRv4Parser.GT, 0);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(ANTLRv4Parser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(ANTLRv4Parser.COMMA, i);
    }

    public ElementOptionsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_elementOptions;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterElementOptions(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitElementOptions(this);
    }
  }

  public final ElementOptionsContext elementOptions() throws RecognitionException {
    ElementOptionsContext _localctx = new ElementOptionsContext(_ctx, getState());
    enterRule(_localctx, 122, RULE_elementOptions);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(621);
        match(LT);
        setState(622);
        elementOption();
        setState(627);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == COMMA) {
          {
            {
              setState(623);
              match(COMMA);
              setState(624);
              elementOption();
            }
          }
          setState(629);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(630);
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
  public static class ElementOptionContext extends ParserRuleContext {
    public List<IdentifierContext> identifier() {
      return getRuleContexts(IdentifierContext.class);
    }

    public IdentifierContext identifier(int i) {
      return getRuleContext(IdentifierContext.class, i);
    }

    public TerminalNode ASSIGN() {
      return getToken(ANTLRv4Parser.ASSIGN, 0);
    }

    public TerminalNode STRING_LITERAL() {
      return getToken(ANTLRv4Parser.STRING_LITERAL, 0);
    }

    public ElementOptionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_elementOption;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterElementOption(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitElementOption(this);
    }
  }

  public final ElementOptionContext elementOption() throws RecognitionException {
    ElementOptionContext _localctx = new ElementOptionContext(_ctx, getState());
    enterRule(_localctx, 124, RULE_elementOption);
    try {
      setState(639);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 84, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(632);
            identifier();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(633);
            identifier();
            setState(634);
            match(ASSIGN);
            setState(637);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
              case TOKEN_REF:
              case RULE_REF:
                {
                  setState(635);
                  identifier();
                }
                break;
              case STRING_LITERAL:
                {
                  setState(636);
                  match(STRING_LITERAL);
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
  public static class IdentifierContext extends ParserRuleContext {
    public TerminalNode RULE_REF() {
      return getToken(ANTLRv4Parser.RULE_REF, 0);
    }

    public TerminalNode TOKEN_REF() {
      return getToken(ANTLRv4Parser.TOKEN_REF, 0);
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
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).enterIdentifier(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof ANTLRv4ParserListener)
        ((ANTLRv4ParserListener) listener).exitIdentifier(this);
    }
  }

  public final IdentifierContext identifier() throws RecognitionException {
    IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
    enterRule(_localctx, 126, RULE_identifier);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(641);
        _la = _input.LA(1);
        if (!(_la == TOKEN_REF || _la == RULE_REF)) {
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

  public static final String _serializedATN =
      "\u0004\u0001>\u0284\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"
          + "\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"
          + "\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"
          + "\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"
          + "\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"
          + "\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"
          + "\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"
          + "\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"
          + "\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"
          + "\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"
          + "\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"
          + "#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"
          + "(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"
          + "-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"
          + "2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0002"
          + "7\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007;\u0002"
          + "<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0001\u0000\u0005\u0000"
          + "\u0082\b\u0000\n\u0000\f\u0000\u0085\t\u0000\u0001\u0000\u0001\u0000\u0005"
          + "\u0000\u0089\b\u0000\n\u0000\f\u0000\u008c\t\u0000\u0001\u0000\u0001\u0000"
          + "\u0005\u0000\u0090\b\u0000\n\u0000\f\u0000\u0093\t\u0000\u0001\u0000\u0001"
          + "\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"
          + "\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u00a0\b\u0002\u0001"
          + "\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u00a7"
          + "\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005"
          + "\u0004\u00ae\b\u0004\n\u0004\f\u0004\u00b1\t\u0004\u0001\u0004\u0001\u0004"
          + "\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"
          + "\u0001\u0006\u0005\u0006\u00bc\b\u0006\n\u0006\f\u0006\u00bf\t\u0006\u0001"
          + "\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00c4\b\u0006\u0001\u0007\u0001"
          + "\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u00ca\b\u0007\n\u0007\f\u0007"
          + "\u00cd\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b"
          + "\u0001\b\u0003\b\u00d6\b\b\u0001\t\u0001\t\u0001\t\u0003\t\u00db\b\t\u0001"
          + "\t\u0001\t\u0001\n\u0001\n\u0001\n\u0003\n\u00e2\b\n\u0001\n\u0001\n\u0001"
          + "\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00e9\b\u000b\n\u000b\f\u000b"
          + "\u00ec\t\u000b\u0001\u000b\u0003\u000b\u00ef\b\u000b\u0001\f\u0001\f\u0001"
          + "\f\u0001\f\u0003\f\u00f5\b\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001"
          + "\r\u0003\r\u00fd\b\r\u0001\u000e\u0001\u000e\u0005\u000e\u0101\b\u000e"
          + "\n\u000e\f\u000e\u0104\t\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001"
          + "\u000f\u0005\u000f\u010a\b\u000f\n\u000f\f\u000f\u010d\t\u000f\u0001\u000f"
          + "\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010"
          + "\u0115\b\u0010\n\u0010\f\u0010\u0118\t\u0010\u0001\u0011\u0005\u0011\u011b"
          + "\b\u0011\n\u0011\f\u0011\u011e\t\u0011\u0001\u0012\u0001\u0012\u0003\u0012"
          + "\u0122\b\u0012\u0001\u0013\u0005\u0013\u0125\b\u0013\n\u0013\f\u0013\u0128"
          + "\t\u0013\u0001\u0013\u0003\u0013\u012b\b\u0013\u0001\u0013\u0001\u0013"
          + "\u0003\u0013\u012f\b\u0013\u0001\u0013\u0003\u0013\u0132\b\u0013\u0001"
          + "\u0013\u0003\u0013\u0135\b\u0013\u0001\u0013\u0003\u0013\u0138\b\u0013"
          + "\u0001\u0013\u0005\u0013\u013b\b\u0013\n\u0013\f\u0013\u013e\t\u0013\u0001"
          + "\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0005"
          + "\u0014\u0146\b\u0014\n\u0014\f\u0014\u0149\t\u0014\u0001\u0014\u0003\u0014"
          + "\u014c\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016"
          + "\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0003\u0017\u0157\b\u0017"
          + "\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019"
          + "\u0001\u0019\u0005\u0019\u0160\b\u0019\n\u0019\f\u0019\u0163\t\u0019\u0001"
          + "\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001"
          + "\u001b\u0001\u001c\u0004\u001c\u016d\b\u001c\u000b\u001c\f\u001c\u016e"
          + "\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f"
          + "\u0001\u001f\u0005\u001f\u0178\b\u001f\n\u001f\f\u001f\u017b\t\u001f\u0001"
          + " \u0001 \u0001 \u0003 \u0180\b \u0001!\u0005!\u0183\b!\n!\f!\u0186\t!"
          + "\u0001!\u0003!\u0189\b!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001\"\u0001"
          + "\"\u0001#\u0001#\u0001#\u0005#\u0195\b#\n#\f#\u0198\t#\u0001$\u0001$\u0003"
          + "$\u019c\b$\u0001$\u0003$\u019f\b$\u0001%\u0004%\u01a2\b%\u000b%\f%\u01a3"
          + "\u0001&\u0001&\u0003&\u01a8\b&\u0001&\u0001&\u0003&\u01ac\b&\u0001&\u0001"
          + "&\u0003&\u01b0\b&\u0001&\u0001&\u0003&\u01b4\b&\u0003&\u01b6\b&\u0001"
          + "\'\u0001\'\u0001\'\u0001\'\u0003\'\u01bc\b\'\u0001(\u0001(\u0001(\u0001"
          + "(\u0001)\u0001)\u0001)\u0001)\u0005)\u01c6\b)\n)\f)\u01c9\t)\u0001*\u0001"
          + "*\u0001*\u0001*\u0001*\u0001*\u0003*\u01d1\b*\u0001+\u0001+\u0003+\u01d5"
          + "\b+\u0001,\u0001,\u0003,\u01d9\b,\u0001-\u0001-\u0001-\u0005-\u01de\b"
          + "-\n-\f-\u01e1\t-\u0001.\u0003.\u01e4\b.\u0001.\u0004.\u01e7\b.\u000b."
          + "\f.\u01e8\u0001.\u0003.\u01ec\b.\u0001/\u0001/\u0001/\u0003/\u01f1\b/"
          + "\u0001/\u0001/\u0001/\u0003/\u01f6\b/\u0001/\u0001/\u0001/\u0003/\u01fb"
          + "\b/\u0003/\u01fd\b/\u00010\u00010\u00010\u00010\u00030\u0203\b0\u0001"
          + "1\u00011\u00031\u0207\b1\u00012\u00012\u00013\u00013\u00033\u020d\b3\u0001"
          + "3\u00013\u00033\u0211\b3\u00013\u00013\u00033\u0215\b3\u00033\u0217\b"
          + "3\u00014\u00014\u00014\u00014\u00014\u00014\u00034\u021f\b4\u00034\u0221"
          + "\b4\u00015\u00015\u00015\u00015\u00015\u00035\u0228\b5\u00035\u022a\b"
          + "5\u00016\u00016\u00016\u00016\u00036\u0230\b6\u00017\u00017\u00017\u0001"
          + "7\u00057\u0236\b7\n7\f7\u0239\t7\u00017\u00017\u00018\u00018\u00038\u023f"
          + "\b8\u00018\u00018\u00038\u0243\b8\u00018\u00018\u00038\u0247\b8\u0001"
          + "9\u00019\u00039\u024b\b9\u00019\u00059\u024e\b9\n9\f9\u0251\t9\u00019"
          + "\u00039\u0254\b9\u00019\u00019\u00019\u0001:\u0001:\u0003:\u025b\b:\u0001"
          + ":\u0003:\u025e\b:\u0001;\u0001;\u0001;\u0001;\u0001<\u0001<\u0003<\u0266"
          + "\b<\u0001<\u0001<\u0003<\u026a\b<\u0003<\u026c\b<\u0001=\u0001=\u0001"
          + "=\u0001=\u0005=\u0272\b=\n=\f=\u0275\t=\u0001=\u0001=\u0001>\u0001>\u0001"
          + ">\u0001>\u0001>\u0003>\u027e\b>\u0003>\u0280\b>\u0001?\u0001?\u0001?\u0000"
          + "\u0000@\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"
          + "\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0000"
          + "\u0003\u0002\u0000\u0010\u0010\u0014\u0016\u0002\u0000((++\u0001\u0000"
          + "\u0001\u0002\u02ab\u0000\u0083\u0001\u0000\u0000\u0000\u0002\u0096\u0001"
          + "\u0000\u0000\u0000\u0004\u009f\u0001\u0000\u0000\u0000\u0006\u00a6\u0001"
          + "\u0000\u0000\u0000\b\u00a8\u0001\u0000\u0000\u0000\n\u00b4\u0001\u0000"
          + "\u0000\u0000\f\u00c3\u0001\u0000\u0000\u0000\u000e\u00c5\u0001\u0000\u0000"
          + "\u0000\u0010\u00d5\u0001\u0000\u0000\u0000\u0012\u00d7\u0001\u0000\u0000"
          + "\u0000\u0014\u00de\u0001\u0000\u0000\u0000\u0016\u00e5\u0001\u0000\u0000"
          + "\u0000\u0018\u00f0\u0001\u0000\u0000\u0000\u001a\u00fc\u0001\u0000\u0000"
          + "\u0000\u001c\u00fe\u0001\u0000\u0000\u0000\u001e\u0107\u0001\u0000\u0000"
          + "\u0000 \u0110\u0001\u0000\u0000\u0000\"\u011c\u0001\u0000\u0000\u0000"
          + "$\u0121\u0001\u0000\u0000\u0000&\u0126\u0001\u0000\u0000\u0000(\u0147"
          + "\u0001\u0000\u0000\u0000*\u014d\u0001\u0000\u0000\u0000,\u0151\u0001\u0000"
          + "\u0000\u0000.\u0156\u0001\u0000\u0000\u00000\u0158\u0001\u0000\u0000\u0000"
          + "2\u015b\u0001\u0000\u0000\u00004\u0164\u0001\u0000\u0000\u00006\u0167"
          + "\u0001\u0000\u0000\u00008\u016c\u0001\u0000\u0000\u0000:\u0170\u0001\u0000"
          + "\u0000\u0000<\u0172\u0001\u0000\u0000\u0000>\u0174\u0001\u0000\u0000\u0000"
          + "@\u017c\u0001\u0000\u0000\u0000B\u0184\u0001\u0000\u0000\u0000D\u018f"
          + "\u0001\u0000\u0000\u0000F\u0191\u0001\u0000\u0000\u0000H\u019e\u0001\u0000"
          + "\u0000\u0000J\u01a1\u0001\u0000\u0000\u0000L\u01b5\u0001\u0000\u0000\u0000"
          + "N\u01b7\u0001\u0000\u0000\u0000P\u01bd\u0001\u0000\u0000\u0000R\u01c1"
          + "\u0001\u0000\u0000\u0000T\u01d0\u0001\u0000\u0000\u0000V\u01d4\u0001\u0000"
          + "\u0000\u0000X\u01d8\u0001\u0000\u0000\u0000Z\u01da\u0001\u0000\u0000\u0000"
          + "\\\u01eb\u0001\u0000\u0000\u0000^\u01fc\u0001\u0000\u0000\u0000`\u01fe"
          + "\u0001\u0000\u0000\u0000b\u0204\u0001\u0000\u0000\u0000d\u0208\u0001\u0000"
          + "\u0000\u0000f\u0216\u0001\u0000\u0000\u0000h\u0220\u0001\u0000\u0000\u0000"
          + "j\u0229\u0001\u0000\u0000\u0000l\u022f\u0001\u0000\u0000\u0000n\u0231"
          + "\u0001\u0000\u0000\u0000p\u0246\u0001\u0000\u0000\u0000r\u0248\u0001\u0000"
          + "\u0000\u0000t\u0258\u0001\u0000\u0000\u0000v\u025f\u0001\u0000\u0000\u0000"
          + "x\u026b\u0001\u0000\u0000\u0000z\u026d\u0001\u0000\u0000\u0000|\u027f"
          + "\u0001\u0000\u0000\u0000~\u0281\u0001\u0000\u0000\u0000\u0080\u0082\u0005"
          + "\u0004\u0000\u0000\u0081\u0080\u0001\u0000\u0000\u0000\u0082\u0085\u0001"
          + "\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0083\u0084\u0001"
          + "\u0000\u0000\u0000\u0084\u0086\u0001\u0000\u0000\u0000\u0085\u0083\u0001"
          + "\u0000\u0000\u0000\u0086\u008a\u0003\u0002\u0001\u0000\u0087\u0089\u0003"
          + "\u0006\u0003\u0000\u0088\u0087\u0001\u0000\u0000\u0000\u0089\u008c\u0001"
          + "\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008a\u008b\u0001"
          + "\u0000\u0000\u0000\u008b\u008d\u0001\u0000\u0000\u0000\u008c\u008a\u0001"
          + "\u0000\u0000\u0000\u008d\u0091\u0003\"\u0011\u0000\u008e\u0090\u0003 "
          + "\u0010\u0000\u008f\u008e\u0001\u0000\u0000\u0000\u0090\u0093\u0001\u0000"
          + "\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000"
          + "\u0000\u0000\u0092\u0094\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000"
          + "\u0000\u0000\u0094\u0095\u0005\u0000\u0000\u0001\u0095\u0001\u0001\u0000"
          + "\u0000\u0000\u0096\u0097\u0003\u0004\u0002\u0000\u0097\u0098\u0003~?\u0000"
          + "\u0098\u0099\u0005 \u0000\u0000\u0099\u0003\u0001\u0000\u0000\u0000\u009a"
          + "\u009b\u0005\u0011\u0000\u0000\u009b\u00a0\u0005\u0013\u0000\u0000\u009c"
          + "\u009d\u0005\u0012\u0000\u0000\u009d\u00a0\u0005\u0013\u0000\u0000\u009e"
          + "\u00a0\u0005\u0013\u0000\u0000\u009f\u009a\u0001\u0000\u0000\u0000\u009f"
          + "\u009c\u0001\u0000\u0000\u0000\u009f\u009e\u0001\u0000\u0000\u0000\u00a0"
          + "\u0005\u0001\u0000\u0000\u0000\u00a1\u00a7\u0003\b\u0004\u0000\u00a2\u00a7"
          + "\u0003\u000e\u0007\u0000\u00a3\u00a7\u0003\u0012\t\u0000\u00a4\u00a7\u0003"
          + "\u0014\n\u0000\u00a5\u00a7\u0003\u0018\f\u0000\u00a6\u00a1\u0001\u0000"
          + "\u0000\u0000\u00a6\u00a2\u0001\u0000\u0000\u0000\u00a6\u00a3\u0001\u0000"
          + "\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a5\u0001\u0000"
          + "\u0000\u0000\u00a7\u0007\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005\f\u0000"
          + "\u0000\u00a9\u00af\u0005#\u0000\u0000\u00aa\u00ab\u0003\n\u0005\u0000"
          + "\u00ab\u00ac\u0005 \u0000\u0000\u00ac\u00ae\u0001\u0000\u0000\u0000\u00ad"
          + "\u00aa\u0001\u0000\u0000\u0000\u00ae\u00b1\u0001\u0000\u0000\u0000\u00af"
          + "\u00ad\u0001\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0"
          + "\u00b2\u0001\u0000\u0000\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b2"
          + "\u00b3\u0005$\u0000\u0000\u00b3\t\u0001\u0000\u0000\u0000\u00b4\u00b5"
          + "\u0003~?\u0000\u00b5\u00b6\u0005(\u0000\u0000\u00b6\u00b7\u0003\f\u0006"
          + "\u0000\u00b7\u000b\u0001\u0000\u0000\u0000\u00b8\u00bd\u0003~?\u0000\u00b9"
          + "\u00ba\u00050\u0000\u0000\u00ba\u00bc\u0003~?\u0000\u00bb\u00b9\u0001"
          + "\u0000\u0000\u0000\u00bc\u00bf\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001"
          + "\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u00c4\u0001"
          + "\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00c0\u00c4\u0005"
          + "\b\u0000\u0000\u00c1\u00c4\u0003\u001c\u000e\u0000\u00c2\u00c4\u0005\u0007"
          + "\u0000\u0000\u00c3\u00b8\u0001\u0000\u0000\u0000\u00c3\u00c0\u0001\u0000"
          + "\u0000\u0000\u00c3\u00c1\u0001\u0000\u0000\u0000\u00c3\u00c2\u0001\u0000"
          + "\u0000\u0000\u00c4\r\u0001\u0000\u0000\u0000\u00c5\u00c6\u0005\u000f\u0000"
          + "\u0000\u00c6\u00cb\u0003\u0010\b\u0000\u00c7\u00c8\u0005\u001f\u0000\u0000"
          + "\u00c8\u00ca\u0003\u0010\b\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000\u00ca"
          + "\u00cd\u0001\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cb"
          + "\u00cc\u0001\u0000\u0000\u0000\u00cc\u00ce\u0001\u0000\u0000\u0000\u00cd"
          + "\u00cb\u0001\u0000\u0000\u0000\u00ce\u00cf\u0005 \u0000\u0000\u00cf\u000f"
          + "\u0001\u0000\u0000\u0000\u00d0\u00d1\u0003~?\u0000\u00d1\u00d2\u0005("
          + "\u0000\u0000\u00d2\u00d3\u0003~?\u0000\u00d3\u00d6\u0001\u0000\u0000\u0000"
          + "\u00d4\u00d6\u0003~?\u0000\u00d5\u00d0\u0001\u0000\u0000\u0000\u00d5\u00d4"
          + "\u0001\u0000\u0000\u0000\u00d6\u0011\u0001\u0000\u0000\u0000\u00d7\u00d8"
          + "\u0005\r\u0000\u0000\u00d8\u00da\u0005#\u0000\u0000\u00d9\u00db\u0003"
          + "\u0016\u000b\u0000\u00da\u00d9\u0001\u0000\u0000\u0000\u00da\u00db\u0001"
          + "\u0000\u0000\u0000\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc\u00dd\u0005"
          + "$\u0000\u0000\u00dd\u0013\u0001\u0000\u0000\u0000\u00de\u00df\u0005\u000e"
          + "\u0000\u0000\u00df\u00e1\u0005#\u0000\u0000\u00e0\u00e2\u0003\u0016\u000b"
          + "\u0000\u00e1\u00e0\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000\u0000"
          + "\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3\u00e4\u0005$\u0000\u0000"
          + "\u00e4\u0015\u0001\u0000\u0000\u0000\u00e5\u00ea\u0003~?\u0000\u00e6\u00e7"
          + "\u0005\u001f\u0000\u0000\u00e7\u00e9\u0003~?\u0000\u00e8\u00e6\u0001\u0000"
          + "\u0000\u0000\u00e9\u00ec\u0001\u0000\u0000\u0000\u00ea\u00e8\u0001\u0000"
          + "\u0000\u0000\u00ea\u00eb\u0001\u0000\u0000\u0000\u00eb\u00ee\u0001\u0000"
          + "\u0000\u0000\u00ec\u00ea\u0001\u0000\u0000\u0000\u00ed\u00ef\u0005\u001f"
          + "\u0000\u0000\u00ee\u00ed\u0001\u0000\u0000\u0000\u00ee\u00ef\u0001\u0000"
          + "\u0000\u0000\u00ef\u0017\u0001\u0000\u0000\u0000\u00f0\u00f4\u00051\u0000"
          + "\u0000\u00f1\u00f2\u0003\u001a\r\u0000\u00f2\u00f3\u0005\u001e\u0000\u0000"
          + "\u00f3\u00f5\u0001\u0000\u0000\u0000\u00f4\u00f1\u0001\u0000\u0000\u0000"
          + "\u00f4\u00f5\u0001\u0000\u0000\u0000\u00f5\u00f6\u0001\u0000\u0000\u0000"
          + "\u00f6\u00f7\u0003~?\u0000\u00f7\u00f8\u0003\u001c\u000e\u0000\u00f8\u0019"
          + "\u0001\u0000\u0000\u0000\u00f9\u00fd\u0003~?\u0000\u00fa\u00fd\u0005\u0011"
          + "\u0000\u0000\u00fb\u00fd\u0005\u0012\u0000\u0000\u00fc\u00f9\u0001\u0000"
          + "\u0000\u0000\u00fc\u00fa\u0001\u0000\u0000\u0000\u00fc\u00fb\u0001\u0000"
          + "\u0000\u0000\u00fd\u001b\u0001\u0000\u0000\u0000\u00fe\u0102\u0005\u000b"
          + "\u0000\u0000\u00ff\u0101\u0005<\u0000\u0000\u0100\u00ff\u0001\u0000\u0000"
          + "\u0000\u0101\u0104\u0001\u0000\u0000\u0000\u0102\u0100\u0001\u0000\u0000"
          + "\u0000\u0102\u0103\u0001\u0000\u0000\u0000\u0103\u0105\u0001\u0000\u0000"
          + "\u0000\u0104\u0102\u0001\u0000\u0000\u0000\u0105\u0106\u0005:\u0000\u0000"
          + "\u0106\u001d\u0001\u0000\u0000\u0000\u0107\u010b\u0005\n\u0000\u0000\u0108"
          + "\u010a\u00059\u0000\u0000\u0109\u0108\u0001\u0000\u0000\u0000\u010a\u010d"
          + "\u0001\u0000\u0000\u0000\u010b\u0109\u0001\u0000\u0000\u0000\u010b\u010c"
          + "\u0001\u0000\u0000\u0000\u010c\u010e\u0001\u0000\u0000\u0000\u010d\u010b"
          + "\u0001\u0000\u0000\u0000\u010e\u010f\u00057\u0000\u0000\u010f\u001f\u0001"
          + "\u0000\u0000\u0000\u0110\u0111\u0005\u001c\u0000\u0000\u0111\u0112\u0003"
          + "~?\u0000\u0112\u0116\u0005 \u0000\u0000\u0113\u0115\u0003B!\u0000\u0114"
          + "\u0113\u0001\u0000\u0000\u0000\u0115\u0118\u0001\u0000\u0000\u0000\u0116"
          + "\u0114\u0001\u0000\u0000\u0000\u0116\u0117\u0001\u0000\u0000\u0000\u0117"
          + "!\u0001\u0000\u0000\u0000\u0118\u0116\u0001\u0000\u0000\u0000\u0119\u011b"
          + "\u0003$\u0012\u0000\u011a\u0119\u0001\u0000\u0000\u0000\u011b\u011e\u0001"
          + "\u0000\u0000\u0000\u011c\u011a\u0001\u0000\u0000\u0000\u011c\u011d\u0001"
          + "\u0000\u0000\u0000\u011d#\u0001\u0000\u0000\u0000\u011e\u011c\u0001\u0000"
          + "\u0000\u0000\u011f\u0122\u0003&\u0013\u0000\u0120\u0122\u0003B!\u0000"
          + "\u0121\u011f\u0001\u0000\u0000\u0000\u0121\u0120\u0001\u0000\u0000\u0000"
          + "\u0122%\u0001\u0000\u0000\u0000\u0123\u0125\u0005\u0004\u0000\u0000\u0124"
          + "\u0123\u0001\u0000\u0000\u0000\u0125\u0128\u0001\u0000\u0000\u0000\u0126"
          + "\u0124\u0001\u0000\u0000\u0000\u0126\u0127\u0001\u0000\u0000\u0000\u0127"
          + "\u012a\u0001\u0000\u0000\u0000\u0128\u0126\u0001\u0000\u0000\u0000\u0129"
          + "\u012b\u00038\u001c\u0000\u012a\u0129\u0001\u0000\u0000\u0000\u012a\u012b"
          + "\u0001\u0000\u0000\u0000\u012b\u012c\u0001\u0000\u0000\u0000\u012c\u012e"
          + "\u0005\u0002\u0000\u0000\u012d\u012f\u0003\u001e\u000f\u0000\u012e\u012d"
          + "\u0001\u0000\u0000\u0000\u012e\u012f\u0001\u0000\u0000\u0000\u012f\u0131"
          + "\u0001\u0000\u0000\u0000\u0130\u0132\u00030\u0018\u0000\u0131\u0130\u0001"
          + "\u0000\u0000\u0000\u0131\u0132\u0001\u0000\u0000\u0000\u0132\u0134\u0001"
          + "\u0000\u0000\u0000\u0133\u0135\u00032\u0019\u0000\u0134\u0133\u0001\u0000"
          + "\u0000\u0000\u0134\u0135\u0001\u0000\u0000\u0000\u0135\u0137\u0001\u0000"
          + "\u0000\u0000\u0136\u0138\u00034\u001a\u0000\u0137\u0136\u0001\u0000\u0000"
          + "\u0000\u0137\u0138\u0001\u0000\u0000\u0000\u0138\u013c\u0001\u0000\u0000"
          + "\u0000\u0139\u013b\u0003.\u0017\u0000\u013a\u0139\u0001\u0000\u0000\u0000"
          + "\u013b\u013e\u0001\u0000\u0000\u0000\u013c\u013a\u0001\u0000\u0000\u0000"
          + "\u013c\u013d\u0001\u0000\u0000\u0000\u013d\u013f\u0001\u0000\u0000\u0000"
          + "\u013e\u013c\u0001\u0000\u0000\u0000\u013f\u0140\u0005\u001d\u0000\u0000"
          + "\u0140\u0141\u0003<\u001e\u0000\u0141\u0142\u0005 \u0000\u0000\u0142\u0143"
          + "\u0003(\u0014\u0000\u0143\'\u0001\u0000\u0000\u0000\u0144\u0146\u0003"
          + "*\u0015\u0000\u0145\u0144\u0001\u0000\u0000\u0000\u0146\u0149\u0001\u0000"
          + "\u0000\u0000\u0147\u0145\u0001\u0000\u0000\u0000\u0147\u0148\u0001\u0000"
          + "\u0000\u0000\u0148\u014b\u0001\u0000\u0000\u0000\u0149\u0147\u0001\u0000"
          + "\u0000\u0000\u014a\u014c\u0003,\u0016\u0000\u014b\u014a\u0001\u0000\u0000"
          + "\u0000\u014b\u014c\u0001\u0000\u0000\u0000\u014c)\u0001\u0000\u0000\u0000"
          + "\u014d\u014e\u0005\u001a\u0000\u0000\u014e\u014f\u0003\u001e\u000f\u0000"
          + "\u014f\u0150\u0003\u001c\u000e\u0000\u0150+\u0001\u0000\u0000\u0000\u0151"
          + "\u0152\u0005\u001b\u0000\u0000\u0152\u0153\u0003\u001c\u000e\u0000\u0153"
          + "-\u0001\u0000\u0000\u0000\u0154\u0157\u0003\b\u0004\u0000\u0155\u0157"
          + "\u00036\u001b\u0000\u0156\u0154\u0001\u0000\u0000\u0000\u0156\u0155\u0001"
          + "\u0000\u0000\u0000\u0157/\u0001\u0000\u0000\u0000\u0158\u0159\u0005\u0017"
          + "\u0000\u0000\u0159\u015a\u0003\u001e\u000f\u0000\u015a1\u0001\u0000\u0000"
          + "\u0000\u015b\u015c\u0005\u0019\u0000\u0000\u015c\u0161\u0003~?\u0000\u015d"
          + "\u015e\u0005\u001f\u0000\u0000\u015e\u0160\u0003~?\u0000\u015f\u015d\u0001"
          + "\u0000\u0000\u0000\u0160\u0163\u0001\u0000\u0000\u0000\u0161\u015f\u0001"
          + "\u0000\u0000\u0000\u0161\u0162\u0001\u0000\u0000\u0000\u01623\u0001\u0000"
          + "\u0000\u0000\u0163\u0161\u0001\u0000\u0000\u0000\u0164\u0165\u0005\u0018"
          + "\u0000\u0000\u0165\u0166\u0003\u001e\u000f\u0000\u01665\u0001\u0000\u0000"
          + "\u0000\u0167\u0168\u00051\u0000\u0000\u0168\u0169\u0003~?\u0000\u0169"
          + "\u016a\u0003\u001c\u000e\u0000\u016a7\u0001\u0000\u0000\u0000\u016b\u016d"
          + "\u0003:\u001d\u0000\u016c\u016b\u0001\u0000\u0000\u0000\u016d\u016e\u0001"
          + "\u0000\u0000\u0000\u016e\u016c\u0001\u0000\u0000\u0000\u016e\u016f\u0001"
          + "\u0000\u0000\u0000\u016f9\u0001\u0000\u0000\u0000\u0170\u0171\u0007\u0000"
          + "\u0000\u0000\u0171;\u0001\u0000\u0000\u0000\u0172\u0173\u0003>\u001f\u0000"
          + "\u0173=\u0001\u0000\u0000\u0000\u0174\u0179\u0003@ \u0000\u0175\u0176"
          + "\u0005-\u0000\u0000\u0176\u0178\u0003@ \u0000\u0177\u0175\u0001\u0000"
          + "\u0000\u0000\u0178\u017b\u0001\u0000\u0000\u0000\u0179\u0177\u0001\u0000"
          + "\u0000\u0000\u0179\u017a\u0001\u0000\u0000\u0000\u017a?\u0001\u0000\u0000"
          + "\u0000\u017b\u0179\u0001\u0000\u0000\u0000\u017c\u017f\u0003\\.\u0000"
          + "\u017d\u017e\u00052\u0000\u0000\u017e\u0180\u0003~?\u0000\u017f\u017d"
          + "\u0001\u0000\u0000\u0000\u017f\u0180\u0001\u0000\u0000\u0000\u0180A\u0001"
          + "\u0000\u0000\u0000\u0181\u0183\u0005\u0004\u0000\u0000\u0182\u0181\u0001"
          + "\u0000\u0000\u0000\u0183\u0186\u0001\u0000\u0000\u0000\u0184\u0182\u0001"
          + "\u0000\u0000\u0000\u0184\u0185\u0001\u0000\u0000\u0000\u0185\u0188\u0001"
          + "\u0000\u0000\u0000\u0186\u0184\u0001\u0000\u0000\u0000\u0187\u0189\u0005"
          + "\u0010\u0000\u0000\u0188\u0187\u0001\u0000\u0000\u0000\u0188\u0189\u0001"
          + "\u0000\u0000\u0000\u0189\u018a\u0001\u0000\u0000\u0000\u018a\u018b\u0005"
          + "\u0001\u0000\u0000\u018b\u018c\u0005\u001d\u0000\u0000\u018c\u018d\u0003"
          + "D\"\u0000\u018d\u018e\u0005 \u0000\u0000\u018eC\u0001\u0000\u0000\u0000"
          + "\u018f\u0190\u0003F#\u0000\u0190E\u0001\u0000\u0000\u0000\u0191\u0196"
          + "\u0003H$\u0000\u0192\u0193\u0005-\u0000\u0000\u0193\u0195\u0003H$\u0000"
          + "\u0194\u0192\u0001\u0000\u0000\u0000\u0195\u0198\u0001\u0000\u0000\u0000"
          + "\u0196\u0194\u0001\u0000\u0000\u0000\u0196\u0197\u0001\u0000\u0000\u0000"
          + "\u0197G\u0001\u0000\u0000\u0000\u0198\u0196\u0001\u0000\u0000\u0000\u0199"
          + "\u019b\u0003J%\u0000\u019a\u019c\u0003R)\u0000\u019b\u019a\u0001\u0000"
          + "\u0000\u0000\u019b\u019c\u0001\u0000\u0000\u0000\u019c\u019f\u0001\u0000"
          + "\u0000\u0000\u019d\u019f\u0001\u0000\u0000\u0000\u019e\u0199\u0001\u0000"
          + "\u0000\u0000\u019e\u019d\u0001\u0000\u0000\u0000\u019fI\u0001\u0000\u0000"
          + "\u0000\u01a0\u01a2\u0003L&\u0000\u01a1\u01a0\u0001\u0000\u0000\u0000\u01a2"
          + "\u01a3\u0001\u0000\u0000\u0000\u01a3\u01a1\u0001\u0000\u0000\u0000\u01a3"
          + "\u01a4\u0001\u0000\u0000\u0000\u01a4K\u0001\u0000\u0000\u0000\u01a5\u01a7"
          + "\u0003N\'\u0000\u01a6\u01a8\u0003f3\u0000\u01a7\u01a6\u0001\u0000\u0000"
          + "\u0000\u01a7\u01a8\u0001\u0000\u0000\u0000\u01a8\u01b6\u0001\u0000\u0000"
          + "\u0000\u01a9\u01ab\u0003h4\u0000\u01aa\u01ac\u0003f3\u0000\u01ab\u01aa"
          + "\u0001\u0000\u0000\u0000\u01ab\u01ac\u0001\u0000\u0000\u0000\u01ac\u01b6"
          + "\u0001\u0000\u0000\u0000\u01ad\u01af\u0003P(\u0000\u01ae\u01b0\u0003f"
          + "3\u0000\u01af\u01ae\u0001\u0000\u0000\u0000\u01af\u01b0\u0001\u0000\u0000"
          + "\u0000\u01b0\u01b6\u0001\u0000\u0000\u0000\u01b1\u01b3\u0003\u001c\u000e"
          + "\u0000\u01b2\u01b4\u0005)\u0000\u0000\u01b3\u01b2\u0001\u0000\u0000\u0000"
          + "\u01b3\u01b4\u0001\u0000\u0000\u0000\u01b4\u01b6\u0001\u0000\u0000\u0000"
          + "\u01b5\u01a5\u0001\u0000\u0000\u0000\u01b5\u01a9\u0001\u0000\u0000\u0000"
          + "\u01b5\u01ad\u0001\u0000\u0000\u0000\u01b5\u01b1\u0001\u0000\u0000\u0000"
          + "\u01b6M\u0001\u0000\u0000\u0000\u01b7\u01b8\u0003~?\u0000\u01b8\u01bb"
          + "\u0007\u0001\u0000\u0000\u01b9\u01bc\u0003h4\u0000\u01ba\u01bc\u0003P"
          + "(\u0000\u01bb\u01b9\u0001\u0000\u0000\u0000\u01bb\u01ba\u0001\u0000\u0000"
          + "\u0000\u01bcO\u0001\u0000\u0000\u0000\u01bd\u01be\u0005!\u0000\u0000\u01be"
          + "\u01bf\u0003F#\u0000\u01bf\u01c0\u0005\"\u0000\u0000\u01c0Q\u0001\u0000"
          + "\u0000\u0000\u01c1\u01c2\u0005%\u0000\u0000\u01c2\u01c7\u0003T*\u0000"
          + "\u01c3\u01c4\u0005\u001f\u0000\u0000\u01c4\u01c6\u0003T*\u0000\u01c5\u01c3"
          + "\u0001\u0000\u0000\u0000\u01c6\u01c9\u0001\u0000\u0000\u0000\u01c7\u01c5"
          + "\u0001\u0000\u0000\u0000\u01c7\u01c8\u0001\u0000\u0000\u0000\u01c8S\u0001"
          + "\u0000\u0000\u0000\u01c9\u01c7\u0001\u0000\u0000\u0000\u01ca\u01cb\u0003"
          + "V+\u0000\u01cb\u01cc\u0005!\u0000\u0000\u01cc\u01cd\u0003X,\u0000\u01cd"
          + "\u01ce\u0005\"\u0000\u0000\u01ce\u01d1\u0001\u0000\u0000\u0000\u01cf\u01d1"
          + "\u0003V+\u0000\u01d0\u01ca\u0001\u0000\u0000\u0000\u01d0\u01cf\u0001\u0000"
          + "\u0000\u0000\u01d1U\u0001\u0000\u0000\u0000\u01d2\u01d5\u0003~?\u0000"
          + "\u01d3\u01d5\u0005\u001c\u0000\u0000\u01d4\u01d2\u0001\u0000\u0000\u0000"
          + "\u01d4\u01d3\u0001\u0000\u0000\u0000\u01d5W\u0001\u0000\u0000\u0000\u01d6"
          + "\u01d9\u0003~?\u0000\u01d7\u01d9\u0005\u0007\u0000\u0000\u01d8\u01d6\u0001"
          + "\u0000\u0000\u0000\u01d8\u01d7\u0001\u0000\u0000\u0000\u01d9Y\u0001\u0000"
          + "\u0000\u0000\u01da\u01df\u0003\\.\u0000\u01db\u01dc\u0005-\u0000\u0000"
          + "\u01dc\u01de\u0003\\.\u0000\u01dd\u01db\u0001\u0000\u0000\u0000\u01de"
          + "\u01e1\u0001\u0000\u0000\u0000\u01df\u01dd\u0001\u0000\u0000\u0000\u01df"
          + "\u01e0\u0001\u0000\u0000\u0000\u01e0[\u0001\u0000\u0000\u0000\u01e1\u01df"
          + "\u0001\u0000\u0000\u0000\u01e2\u01e4\u0003z=\u0000\u01e3\u01e2\u0001\u0000"
          + "\u0000\u0000\u01e3\u01e4\u0001\u0000\u0000\u0000\u01e4\u01e6\u0001\u0000"
          + "\u0000\u0000\u01e5\u01e7\u0003^/\u0000\u01e6\u01e5\u0001\u0000\u0000\u0000"
          + "\u01e7\u01e8\u0001\u0000\u0000\u0000\u01e8\u01e6\u0001\u0000\u0000\u0000"
          + "\u01e8\u01e9\u0001\u0000\u0000\u0000\u01e9\u01ec\u0001\u0000\u0000\u0000"
          + "\u01ea\u01ec\u0001\u0000\u0000\u0000\u01eb\u01e3\u0001\u0000\u0000\u0000"
          + "\u01eb\u01ea\u0001\u0000\u0000\u0000\u01ec]\u0001\u0000\u0000\u0000\u01ed"
          + "\u01f0\u0003`0\u0000\u01ee\u01f1\u0003f3\u0000\u01ef\u01f1\u0001\u0000"
          + "\u0000\u0000\u01f0\u01ee\u0001\u0000\u0000\u0000\u01f0\u01ef\u0001\u0000"
          + "\u0000\u0000\u01f1\u01fd\u0001\u0000\u0000\u0000\u01f2\u01f5\u0003j5\u0000"
          + "\u01f3\u01f6\u0003f3\u0000\u01f4\u01f6\u0001\u0000\u0000\u0000\u01f5\u01f3"
          + "\u0001\u0000\u0000\u0000\u01f5\u01f4\u0001\u0000\u0000\u0000\u01f6\u01fd"
          + "\u0001\u0000\u0000\u0000\u01f7\u01fd\u0003b1\u0000\u01f8\u01fa\u0003\u001c"
          + "\u000e\u0000\u01f9\u01fb\u0005)\u0000\u0000\u01fa\u01f9\u0001\u0000\u0000"
          + "\u0000\u01fa\u01fb\u0001\u0000\u0000\u0000\u01fb\u01fd\u0001\u0000\u0000"
          + "\u0000\u01fc\u01ed\u0001\u0000\u0000\u0000\u01fc\u01f2\u0001\u0000\u0000"
          + "\u0000\u01fc\u01f7\u0001\u0000\u0000\u0000\u01fc\u01f8\u0001\u0000\u0000"
          + "\u0000\u01fd_\u0001\u0000\u0000\u0000\u01fe\u01ff\u0003~?\u0000\u01ff"
          + "\u0202\u0007\u0001\u0000\u0000\u0200\u0203\u0003j5\u0000\u0201\u0203\u0003"
          + "r9\u0000\u0202\u0200\u0001\u0000\u0000\u0000\u0202\u0201\u0001\u0000\u0000"
          + "\u0000\u0203a\u0001\u0000\u0000\u0000\u0204\u0206\u0003r9\u0000\u0205"
          + "\u0207\u0003d2\u0000\u0206\u0205\u0001\u0000\u0000\u0000\u0206\u0207\u0001"
          + "\u0000\u0000\u0000\u0207c\u0001\u0000\u0000\u0000\u0208\u0209\u0003f3"
          + "\u0000\u0209e\u0001\u0000\u0000\u0000\u020a\u020c\u0005)\u0000\u0000\u020b"
          + "\u020d\u0005)\u0000\u0000\u020c\u020b\u0001\u0000\u0000\u0000\u020c\u020d"
          + "\u0001\u0000\u0000\u0000\u020d\u0217\u0001\u0000\u0000\u0000\u020e\u0210"
          + "\u0005*\u0000\u0000\u020f\u0211\u0005)\u0000\u0000\u0210\u020f\u0001\u0000"
          + "\u0000\u0000\u0210\u0211\u0001\u0000\u0000\u0000\u0211\u0217\u0001\u0000"
          + "\u0000\u0000\u0212\u0214\u0005,\u0000\u0000\u0213\u0215\u0005)\u0000\u0000"
          + "\u0214\u0213\u0001\u0000\u0000\u0000\u0214\u0215\u0001\u0000\u0000\u0000"
          + "\u0215\u0217\u0001\u0000\u0000\u0000\u0216\u020a\u0001\u0000\u0000\u0000"
          + "\u0216\u020e\u0001\u0000\u0000\u0000\u0216\u0212\u0001\u0000\u0000\u0000"
          + "\u0217g\u0001\u0000\u0000\u0000\u0218\u0221\u0003v;\u0000\u0219\u0221"
          + "\u0003x<\u0000\u021a\u0221\u0003l6\u0000\u021b\u0221\u0005\u0003\u0000"
          + "\u0000\u021c\u021e\u00050\u0000\u0000\u021d\u021f\u0003z=\u0000\u021e"
          + "\u021d\u0001\u0000\u0000\u0000\u021e\u021f\u0001\u0000\u0000\u0000\u021f"
          + "\u0221\u0001\u0000\u0000\u0000\u0220\u0218\u0001\u0000\u0000\u0000\u0220"
          + "\u0219\u0001\u0000\u0000\u0000\u0220\u021a\u0001\u0000\u0000\u0000\u0220"
          + "\u021b\u0001\u0000\u0000\u0000\u0220\u021c\u0001\u0000\u0000\u0000\u0221"
          + "i\u0001\u0000\u0000\u0000\u0222\u022a\u0003x<\u0000\u0223\u022a\u0003"
          + "t:\u0000\u0224\u022a\u0003l6\u0000\u0225\u0227\u00050\u0000\u0000\u0226"
          + "\u0228\u0003z=\u0000\u0227\u0226\u0001\u0000\u0000\u0000\u0227\u0228\u0001"
          + "\u0000\u0000\u0000\u0228\u022a\u0001\u0000\u0000\u0000\u0229\u0222\u0001"
          + "\u0000\u0000\u0000\u0229\u0223\u0001\u0000\u0000\u0000\u0229\u0224\u0001"
          + "\u0000\u0000\u0000\u0229\u0225\u0001\u0000\u0000\u0000\u022ak\u0001\u0000"
          + "\u0000\u0000\u022b\u022c\u00053\u0000\u0000\u022c\u0230\u0003p8\u0000"
          + "\u022d\u022e\u00053\u0000\u0000\u022e\u0230\u0003n7\u0000\u022f\u022b"
          + "\u0001\u0000\u0000\u0000\u022f\u022d\u0001\u0000\u0000\u0000\u0230m\u0001"
          + "\u0000\u0000\u0000\u0231\u0232\u0005!\u0000\u0000\u0232\u0237\u0003p8"
          + "\u0000\u0233\u0234\u0005-\u0000\u0000\u0234\u0236\u0003p8\u0000\u0235"
          + "\u0233\u0001\u0000\u0000\u0000\u0236\u0239\u0001\u0000\u0000\u0000\u0237"
          + "\u0235\u0001\u0000\u0000\u0000\u0237\u0238\u0001\u0000\u0000\u0000\u0238"
          + "\u023a\u0001\u0000\u0000\u0000\u0239\u0237\u0001\u0000\u0000\u0000\u023a"
          + "\u023b\u0005\"\u0000\u0000\u023bo\u0001\u0000\u0000\u0000\u023c\u023e"
          + "\u0005\u0001\u0000\u0000\u023d\u023f\u0003z=\u0000\u023e\u023d\u0001\u0000"
          + "\u0000\u0000\u023e\u023f\u0001\u0000\u0000\u0000\u023f\u0247\u0001\u0000"
          + "\u0000\u0000\u0240\u0242\u0005\b\u0000\u0000\u0241\u0243\u0003z=\u0000"
          + "\u0242\u0241\u0001\u0000\u0000\u0000\u0242\u0243\u0001\u0000\u0000\u0000"
          + "\u0243\u0247\u0001\u0000\u0000\u0000\u0244\u0247\u0003v;\u0000\u0245\u0247"
          + "\u0005\u0003\u0000\u0000\u0246\u023c\u0001\u0000\u0000\u0000\u0246\u0240"
          + "\u0001\u0000\u0000\u0000\u0246\u0244\u0001\u0000\u0000\u0000\u0246\u0245"
          + "\u0001\u0000\u0000\u0000\u0247q\u0001\u0000\u0000\u0000\u0248\u0253\u0005"
          + "!\u0000\u0000\u0249\u024b\u0003\b\u0004\u0000\u024a\u0249\u0001\u0000"
          + "\u0000\u0000\u024a\u024b\u0001\u0000\u0000\u0000\u024b\u024f\u0001\u0000"
          + "\u0000\u0000\u024c\u024e\u00036\u001b\u0000\u024d\u024c\u0001\u0000\u0000"
          + "\u0000\u024e\u0251\u0001\u0000\u0000\u0000\u024f\u024d\u0001\u0000\u0000"
          + "\u0000\u024f\u0250\u0001\u0000\u0000\u0000\u0250\u0252\u0001\u0000\u0000"
          + "\u0000\u0251\u024f\u0001\u0000\u0000\u0000\u0252\u0254\u0005\u001d\u0000"
          + "\u0000\u0253\u024a\u0001\u0000\u0000\u0000\u0253\u0254\u0001\u0000\u0000"
          + "\u0000\u0254\u0255\u0001\u0000\u0000\u0000\u0255\u0256\u0003Z-\u0000\u0256"
          + "\u0257\u0005\"\u0000\u0000\u0257s\u0001\u0000\u0000\u0000\u0258\u025a"
          + "\u0005\u0002\u0000\u0000\u0259\u025b\u0003\u001e\u000f\u0000\u025a\u0259"
          + "\u0001\u0000\u0000\u0000\u025a\u025b\u0001\u0000\u0000\u0000\u025b\u025d"
          + "\u0001\u0000\u0000\u0000\u025c\u025e\u0003z=\u0000\u025d\u025c\u0001\u0000"
          + "\u0000\u0000\u025d\u025e\u0001\u0000\u0000\u0000\u025eu\u0001\u0000\u0000"
          + "\u0000\u025f\u0260\u0005\b\u0000\u0000\u0260\u0261\u0005/\u0000\u0000"
          + "\u0261\u0262\u0005\b\u0000\u0000\u0262w\u0001\u0000\u0000\u0000\u0263"
          + "\u0265\u0005\u0001\u0000\u0000\u0264\u0266\u0003z=\u0000\u0265\u0264\u0001"
          + "\u0000\u0000\u0000\u0265\u0266\u0001\u0000\u0000\u0000\u0266\u026c\u0001"
          + "\u0000\u0000\u0000\u0267\u0269\u0005\b\u0000\u0000\u0268\u026a\u0003z"
          + "=\u0000\u0269\u0268\u0001\u0000\u0000\u0000\u0269\u026a\u0001\u0000\u0000"
          + "\u0000\u026a\u026c\u0001\u0000\u0000\u0000\u026b\u0263\u0001\u0000\u0000"
          + "\u0000\u026b\u0267\u0001\u0000\u0000\u0000\u026cy\u0001\u0000\u0000\u0000"
          + "\u026d\u026e\u0005&\u0000\u0000\u026e\u0273\u0003|>\u0000\u026f\u0270"
          + "\u0005\u001f\u0000\u0000\u0270\u0272\u0003|>\u0000\u0271\u026f\u0001\u0000"
          + "\u0000\u0000\u0272\u0275\u0001\u0000\u0000\u0000\u0273\u0271\u0001\u0000"
          + "\u0000\u0000\u0273\u0274\u0001\u0000\u0000\u0000\u0274\u0276\u0001\u0000"
          + "\u0000\u0000\u0275\u0273\u0001\u0000\u0000\u0000\u0276\u0277\u0005\'\u0000"
          + "\u0000\u0277{\u0001\u0000\u0000\u0000\u0278\u0280\u0003~?\u0000\u0279"
          + "\u027a\u0003~?\u0000\u027a\u027d\u0005(\u0000\u0000\u027b\u027e\u0003"
          + "~?\u0000\u027c\u027e\u0005\b\u0000\u0000\u027d\u027b\u0001\u0000\u0000"
          + "\u0000\u027d\u027c\u0001\u0000\u0000\u0000\u027e\u0280\u0001\u0000\u0000"
          + "\u0000\u027f\u0278\u0001\u0000\u0000\u0000\u027f\u0279\u0001\u0000\u0000"
          + "\u0000\u0280}\u0001\u0000\u0000\u0000\u0281\u0282\u0007\u0002\u0000\u0000"
          + "\u0282\u007f\u0001\u0000\u0000\u0000U\u0083\u008a\u0091\u009f\u00a6\u00af"
          + "\u00bd\u00c3\u00cb\u00d5\u00da\u00e1\u00ea\u00ee\u00f4\u00fc\u0102\u010b"
          + "\u0116\u011c\u0121\u0126\u012a\u012e\u0131\u0134\u0137\u013c\u0147\u014b"
          + "\u0156\u0161\u016e\u0179\u017f\u0184\u0188\u0196\u019b\u019e\u01a3\u01a7"
          + "\u01ab\u01af\u01b3\u01b5\u01bb\u01c7\u01d0\u01d4\u01d8\u01df\u01e3\u01e8"
          + "\u01eb\u01f0\u01f5\u01fa\u01fc\u0202\u0206\u020c\u0210\u0214\u0216\u021e"
          + "\u0220\u0227\u0229\u022f\u0237\u023e\u0242\u0246\u024a\u024f\u0253\u025a"
          + "\u025d\u0265\u0269\u026b\u0273\u027d\u027f";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
