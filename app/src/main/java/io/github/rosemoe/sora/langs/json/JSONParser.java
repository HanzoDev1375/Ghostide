// Generated from /storage/emulated/0/AndroidIDEProjects/Ghost-web-ide2/app/src/main/java/io/github/rosemoe/sora/langs/json/JSON.g4 by ANTLR 4.13.2
package io.github.rosemoe.sora.langs.json;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class JSONParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TRUE=1, FALSE=2, NULL=3, COLON=4, STRING=5, LBRACE=6, RBRACE=7, LBRACKET=8, 
		RBRACKET=9, COMMA=10, NUMBER=11, WS=12;
	public static final int
		RULE_json = 0, RULE_obj = 1, RULE_pair = 2, RULE_arr = 3, RULE_value = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"json", "obj", "pair", "arr", "value"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'true'", "'false'", "'null'", "':'", null, "'{'", "'}'", "'['", 
			"']'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TRUE", "FALSE", "NULL", "COLON", "STRING", "LBRACE", "RBRACE", 
			"LBRACKET", "RBRACKET", "COMMA", "NUMBER", "WS"
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
	public String getGrammarFileName() { return "JSON.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JSONParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JsonContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public JsonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_json; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSONListener ) ((JSONListener)listener).enterJson(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSONListener ) ((JSONListener)listener).exitJson(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSONVisitor ) return ((JSONVisitor<? extends T>)visitor).visitJson(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JsonContext json() throws RecognitionException {
		JsonContext _localctx = new JsonContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_json);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
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
	public static class ObjContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(JSONParser.LBRACE, 0); }
		public List<PairContext> pair() {
			return getRuleContexts(PairContext.class);
		}
		public PairContext pair(int i) {
			return getRuleContext(PairContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(JSONParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(JSONParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JSONParser.COMMA, i);
		}
		public ObjContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_obj; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSONListener ) ((JSONListener)listener).enterObj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSONListener ) ((JSONListener)listener).exitObj(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSONVisitor ) return ((JSONVisitor<? extends T>)visitor).visitObj(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjContext obj() throws RecognitionException {
		ObjContext _localctx = new ObjContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_obj);
		int _la;
		try {
			setState(25);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(12);
				match(LBRACE);
				setState(13);
				pair();
				setState(18);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(14);
					match(COMMA);
					setState(15);
					pair();
					}
					}
					setState(20);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(21);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(23);
				match(LBRACE);
				setState(24);
				match(RBRACE);
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
	public static class PairContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(JSONParser.STRING, 0); }
		public TerminalNode COLON() { return getToken(JSONParser.COLON, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public PairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSONListener ) ((JSONListener)listener).enterPair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSONListener ) ((JSONListener)listener).exitPair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSONVisitor ) return ((JSONVisitor<? extends T>)visitor).visitPair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairContext pair() throws RecognitionException {
		PairContext _localctx = new PairContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_pair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			match(STRING);
			setState(28);
			match(COLON);
			setState(29);
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
	public static class ArrContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(JSONParser.LBRACKET, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode RBRACKET() { return getToken(JSONParser.RBRACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(JSONParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JSONParser.COMMA, i);
		}
		public ArrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSONListener ) ((JSONListener)listener).enterArr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSONListener ) ((JSONListener)listener).exitArr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSONVisitor ) return ((JSONVisitor<? extends T>)visitor).visitArr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrContext arr() throws RecognitionException {
		ArrContext _localctx = new ArrContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_arr);
		int _la;
		try {
			setState(44);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				match(LBRACKET);
				setState(32);
				value();
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(33);
					match(COMMA);
					setState(34);
					value();
					}
					}
					setState(39);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(40);
				match(RBRACKET);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				match(LBRACKET);
				setState(43);
				match(RBRACKET);
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
	public static class ValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(JSONParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(JSONParser.NUMBER, 0); }
		public ObjContext obj() {
			return getRuleContext(ObjContext.class,0);
		}
		public ArrContext arr() {
			return getRuleContext(ArrContext.class,0);
		}
		public TerminalNode TRUE() { return getToken(JSONParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(JSONParser.FALSE, 0); }
		public TerminalNode NULL() { return getToken(JSONParser.NULL, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSONListener ) ((JSONListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSONListener ) ((JSONListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSONVisitor ) return ((JSONVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_value);
		try {
			setState(53);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				match(STRING);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				match(NUMBER);
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				obj();
				}
				break;
			case LBRACKET:
				enterOuterAlt(_localctx, 4);
				{
				setState(49);
				arr();
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 5);
				{
				setState(50);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 6);
				{
				setState(51);
				match(FALSE);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 7);
				{
				setState(52);
				match(NULL);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static final String _serializedATN =
		"\u0004\u0001\f8\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005"+
		"\u0001\u0011\b\u0001\n\u0001\f\u0001\u0014\t\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001\u001a\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003$\b\u0003\n\u0003\f\u0003\'\t\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003-\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"6\b\u0004\u0001\u0004\u0000\u0000\u0005\u0000\u0002\u0004\u0006\b\u0000"+
		"\u0000<\u0000\n\u0001\u0000\u0000\u0000\u0002\u0019\u0001\u0000\u0000"+
		"\u0000\u0004\u001b\u0001\u0000\u0000\u0000\u0006,\u0001\u0000\u0000\u0000"+
		"\b5\u0001\u0000\u0000\u0000\n\u000b\u0003\b\u0004\u0000\u000b\u0001\u0001"+
		"\u0000\u0000\u0000\f\r\u0005\u0006\u0000\u0000\r\u0012\u0003\u0004\u0002"+
		"\u0000\u000e\u000f\u0005\n\u0000\u0000\u000f\u0011\u0003\u0004\u0002\u0000"+
		"\u0010\u000e\u0001\u0000\u0000\u0000\u0011\u0014\u0001\u0000\u0000\u0000"+
		"\u0012\u0010\u0001\u0000\u0000\u0000\u0012\u0013\u0001\u0000\u0000\u0000"+
		"\u0013\u0015\u0001\u0000\u0000\u0000\u0014\u0012\u0001\u0000\u0000\u0000"+
		"\u0015\u0016\u0005\u0007\u0000\u0000\u0016\u001a\u0001\u0000\u0000\u0000"+
		"\u0017\u0018\u0005\u0006\u0000\u0000\u0018\u001a\u0005\u0007\u0000\u0000"+
		"\u0019\f\u0001\u0000\u0000\u0000\u0019\u0017\u0001\u0000\u0000\u0000\u001a"+
		"\u0003\u0001\u0000\u0000\u0000\u001b\u001c\u0005\u0005\u0000\u0000\u001c"+
		"\u001d\u0005\u0004\u0000\u0000\u001d\u001e\u0003\b\u0004\u0000\u001e\u0005"+
		"\u0001\u0000\u0000\u0000\u001f \u0005\b\u0000\u0000 %\u0003\b\u0004\u0000"+
		"!\"\u0005\n\u0000\u0000\"$\u0003\b\u0004\u0000#!\u0001\u0000\u0000\u0000"+
		"$\'\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000"+
		"\u0000&(\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000()\u0005\t"+
		"\u0000\u0000)-\u0001\u0000\u0000\u0000*+\u0005\b\u0000\u0000+-\u0005\t"+
		"\u0000\u0000,\u001f\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000"+
		"-\u0007\u0001\u0000\u0000\u0000.6\u0005\u0005\u0000\u0000/6\u0005\u000b"+
		"\u0000\u000006\u0003\u0002\u0001\u000016\u0003\u0006\u0003\u000026\u0005"+
		"\u0001\u0000\u000036\u0005\u0002\u0000\u000046\u0005\u0003\u0000\u0000"+
		"5.\u0001\u0000\u0000\u00005/\u0001\u0000\u0000\u000050\u0001\u0000\u0000"+
		"\u000051\u0001\u0000\u0000\u000052\u0001\u0000\u0000\u000053\u0001\u0000"+
		"\u0000\u000054\u0001\u0000\u0000\u00006\t\u0001\u0000\u0000\u0000\u0005"+
		"\u0012\u0019%,5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}