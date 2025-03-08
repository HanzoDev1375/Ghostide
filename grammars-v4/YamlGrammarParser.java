// Generated from /storage/emulated/0/AndroidIDEProjects/Ghost-web-ide2/grammars-v4/YamlGrammar.g4 by ANTLR 4.13.1
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
public class YamlGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, STRING=5, NUMBER=6, BOOLEAN=7, WS=8, COMMENT=9;
	public static final int
		RULE_yaml = 0, RULE_document = 1, RULE_key_value_pairs = 2, RULE_key_value_pair = 3, 
		RULE_key = 4, RULE_value = 5, RULE_list = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"yaml", "document", "key_value_pairs", "key_value_pair", "key", "value", 
			"list"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'['", "','", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "STRING", "NUMBER", "BOOLEAN", "WS", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
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
	public String getGrammarFileName() { return "YamlGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public YamlGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YamlContext extends ParserRuleContext {
		public List<DocumentContext> document() {
			return getRuleContexts(DocumentContext.class);
		}
		public DocumentContext document(int i) {
			return getRuleContext(DocumentContext.class,i);
		}
		public YamlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yaml; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YamlGrammarListener ) ((YamlGrammarListener)listener).enterYaml(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YamlGrammarListener ) ((YamlGrammarListener)listener).exitYaml(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YamlGrammarVisitor ) return ((YamlGrammarVisitor<? extends T>)visitor).visitYaml(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YamlContext yaml() throws RecognitionException {
		YamlContext _localctx = new YamlContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_yaml);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(14);
				document();
				}
				}
				setState(17); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==STRING );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DocumentContext extends ParserRuleContext {
		public Key_value_pairsContext key_value_pairs() {
			return getRuleContext(Key_value_pairsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(YamlGrammarParser.EOF, 0); }
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YamlGrammarListener ) ((YamlGrammarListener)listener).enterDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YamlGrammarListener ) ((YamlGrammarListener)listener).exitDocument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YamlGrammarVisitor ) return ((YamlGrammarVisitor<? extends T>)visitor).visitDocument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_document);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			key_value_pairs(0);
			setState(20);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Key_value_pairsContext extends ParserRuleContext {
		public Key_value_pairContext key_value_pair() {
			return getRuleContext(Key_value_pairContext.class,0);
		}
		public Key_value_pairsContext key_value_pairs() {
			return getRuleContext(Key_value_pairsContext.class,0);
		}
		public Key_value_pairsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_key_value_pairs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YamlGrammarListener ) ((YamlGrammarListener)listener).enterKey_value_pairs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YamlGrammarListener ) ((YamlGrammarListener)listener).exitKey_value_pairs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YamlGrammarVisitor ) return ((YamlGrammarVisitor<? extends T>)visitor).visitKey_value_pairs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Key_value_pairsContext key_value_pairs() throws RecognitionException {
		return key_value_pairs(0);
	}

	private Key_value_pairsContext key_value_pairs(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Key_value_pairsContext _localctx = new Key_value_pairsContext(_ctx, _parentState);
		Key_value_pairsContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_key_value_pairs, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(23);
			key_value_pair();
			}
			_ctx.stop = _input.LT(-1);
			setState(29);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Key_value_pairsContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_key_value_pairs);
					setState(25);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(26);
					key_value_pair();
					}
					} 
				}
				setState(31);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Key_value_pairContext extends ParserRuleContext {
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public Key_value_pairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_key_value_pair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YamlGrammarListener ) ((YamlGrammarListener)listener).enterKey_value_pair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YamlGrammarListener ) ((YamlGrammarListener)listener).exitKey_value_pair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YamlGrammarVisitor ) return ((YamlGrammarVisitor<? extends T>)visitor).visitKey_value_pair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Key_value_pairContext key_value_pair() throws RecognitionException {
		Key_value_pairContext _localctx = new Key_value_pairContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_key_value_pair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			key();
			setState(33);
			match(T__0);
			setState(34);
			value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class KeyContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(YamlGrammarParser.STRING, 0); }
		public KeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_key; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YamlGrammarListener ) ((YamlGrammarListener)listener).enterKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YamlGrammarListener ) ((YamlGrammarListener)listener).exitKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YamlGrammarVisitor ) return ((YamlGrammarVisitor<? extends T>)visitor).visitKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyContext key() throws RecognitionException {
		KeyContext _localctx = new KeyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_key);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(YamlGrammarParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(YamlGrammarParser.NUMBER, 0); }
		public TerminalNode BOOLEAN() { return getToken(YamlGrammarParser.BOOLEAN, 0); }
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public Key_value_pairsContext key_value_pairs() {
			return getRuleContext(Key_value_pairsContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YamlGrammarListener ) ((YamlGrammarListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YamlGrammarListener ) ((YamlGrammarListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YamlGrammarVisitor ) return ((YamlGrammarVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_value);
		try {
			setState(43);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				match(STRING);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				match(NUMBER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(40);
				match(BOOLEAN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(41);
				list();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(42);
				key_value_pairs(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YamlGrammarListener ) ((YamlGrammarListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YamlGrammarListener ) ((YamlGrammarListener)listener).exitList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YamlGrammarVisitor ) return ((YamlGrammarVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(T__1);
			setState(46);
			value();
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(47);
				match(T__2);
				setState(48);
				value();
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return key_value_pairs_sempred((Key_value_pairsContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean key_value_pairs_sempred(Key_value_pairsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\t9\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0004\u0000\u0010"+
		"\b\u0000\u000b\u0000\f\u0000\u0011\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"\u001c\b\u0002\n\u0002\f\u0002\u001f\t\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005,\b\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0005\u00062\b\u0006\n\u0006\f\u00065\t"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0000\u0001\u0004\u0007\u0000"+
		"\u0002\u0004\u0006\b\n\f\u0000\u00008\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0002\u0013\u0001\u0000\u0000\u0000\u0004\u0016\u0001\u0000\u0000\u0000"+
		"\u0006 \u0001\u0000\u0000\u0000\b$\u0001\u0000\u0000\u0000\n+\u0001\u0000"+
		"\u0000\u0000\f-\u0001\u0000\u0000\u0000\u000e\u0010\u0003\u0002\u0001"+
		"\u0000\u000f\u000e\u0001\u0000\u0000\u0000\u0010\u0011\u0001\u0000\u0000"+
		"\u0000\u0011\u000f\u0001\u0000\u0000\u0000\u0011\u0012\u0001\u0000\u0000"+
		"\u0000\u0012\u0001\u0001\u0000\u0000\u0000\u0013\u0014\u0003\u0004\u0002"+
		"\u0000\u0014\u0015\u0005\u0000\u0000\u0001\u0015\u0003\u0001\u0000\u0000"+
		"\u0000\u0016\u0017\u0006\u0002\uffff\uffff\u0000\u0017\u0018\u0003\u0006"+
		"\u0003\u0000\u0018\u001d\u0001\u0000\u0000\u0000\u0019\u001a\n\u0001\u0000"+
		"\u0000\u001a\u001c\u0003\u0006\u0003\u0000\u001b\u0019\u0001\u0000\u0000"+
		"\u0000\u001c\u001f\u0001\u0000\u0000\u0000\u001d\u001b\u0001\u0000\u0000"+
		"\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e\u0005\u0001\u0000\u0000"+
		"\u0000\u001f\u001d\u0001\u0000\u0000\u0000 !\u0003\b\u0004\u0000!\"\u0005"+
		"\u0001\u0000\u0000\"#\u0003\n\u0005\u0000#\u0007\u0001\u0000\u0000\u0000"+
		"$%\u0005\u0005\u0000\u0000%\t\u0001\u0000\u0000\u0000&,\u0005\u0005\u0000"+
		"\u0000\',\u0005\u0006\u0000\u0000(,\u0005\u0007\u0000\u0000),\u0003\f"+
		"\u0006\u0000*,\u0003\u0004\u0002\u0000+&\u0001\u0000\u0000\u0000+\'\u0001"+
		"\u0000\u0000\u0000+(\u0001\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000"+
		"+*\u0001\u0000\u0000\u0000,\u000b\u0001\u0000\u0000\u0000-.\u0005\u0002"+
		"\u0000\u0000.3\u0003\n\u0005\u0000/0\u0005\u0003\u0000\u000002\u0003\n"+
		"\u0005\u00001/\u0001\u0000\u0000\u000025\u0001\u0000\u0000\u000031\u0001"+
		"\u0000\u0000\u000034\u0001\u0000\u0000\u000046\u0001\u0000\u0000\u0000"+
		"53\u0001\u0000\u0000\u000067\u0005\u0004\u0000\u00007\r\u0001\u0000\u0000"+
		"\u0000\u0004\u0011\u001d+3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}