// Generated from /storage/emulated/0/AndroidIDEProjects/Ghost-web-ide/grammars-v4/SVG.g4 by ANTLR 4.13.1
package io.github.rosemoe.sora.langs.svg;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SVGParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, STRING=8, NAME=9, 
		WS=10, SYIN=11, SYMIN=12, SYOU=13, ASSES=14, HEXCOLOR=15, Comment=16;
	public static final int
		RULE_svg = 0, RULE_header = 1, RULE_footer = 2, RULE_element = 3, RULE_circle = 4, 
		RULE_rectangle = 5, RULE_line = 6, RULE_text = 7, RULE_attributes = 8, 
		RULE_attribute = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"svg", "header", "footer", "element", "circle", "rectangle", "line", 
			"text", "attributes", "attribute"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'<svg'", "'</svg>'", "'<circle'", "'<rect'", "'<line'", "'<text'", 
			"'</text>'", null, null, null, "'<'", "'>'", "'/>'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "STRING", "NAME", "WS", 
			"SYIN", "SYMIN", "SYOU", "ASSES", "HEXCOLOR", "Comment"
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
	public String getGrammarFileName() { return "SVG.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SVGParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SvgContext extends ParserRuleContext {
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public FooterContext footer() {
			return getRuleContext(FooterContext.class,0);
		}
		public List<ElementContext> element() {
			return getRuleContexts(ElementContext.class);
		}
		public ElementContext element(int i) {
			return getRuleContext(ElementContext.class,i);
		}
		public SvgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_svg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVGListener ) ((SVGListener)listener).enterSvg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVGListener ) ((SVGListener)listener).exitSvg(this);
		}
	}

	public final SvgContext svg() throws RecognitionException {
		SvgContext _localctx = new SvgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_svg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			header();
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 120L) != 0)) {
				{
				{
				setState(21);
				element();
				}
				}
				setState(26);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(27);
			footer();
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
	public static class HeaderContext extends ParserRuleContext {
		public TerminalNode SYMIN() { return getToken(SVGParser.SYMIN, 0); }
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVGListener ) ((SVGListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVGListener ) ((SVGListener)listener).exitHeader(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_header);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			match(T__0);
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(30);
				attributes();
				}
			}

			setState(33);
			match(SYMIN);
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
	public static class FooterContext extends ParserRuleContext {
		public FooterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_footer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVGListener ) ((SVGListener)listener).enterFooter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVGListener ) ((SVGListener)listener).exitFooter(this);
		}
	}

	public final FooterContext footer() throws RecognitionException {
		FooterContext _localctx = new FooterContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_footer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(T__1);
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
	public static class ElementContext extends ParserRuleContext {
		public CircleContext circle() {
			return getRuleContext(CircleContext.class,0);
		}
		public RectangleContext rectangle() {
			return getRuleContext(RectangleContext.class,0);
		}
		public LineContext line() {
			return getRuleContext(LineContext.class,0);
		}
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVGListener ) ((SVGListener)listener).enterElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVGListener ) ((SVGListener)listener).exitElement(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_element);
		try {
			setState(41);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				circle();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(38);
				rectangle();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(39);
				line();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 4);
				{
				setState(40);
				text();
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

	@SuppressWarnings("CheckReturnValue")
	public static class CircleContext extends ParserRuleContext {
		public TerminalNode SYOU() { return getToken(SVGParser.SYOU, 0); }
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public CircleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_circle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVGListener ) ((SVGListener)listener).enterCircle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVGListener ) ((SVGListener)listener).exitCircle(this);
		}
	}

	public final CircleContext circle() throws RecognitionException {
		CircleContext _localctx = new CircleContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_circle);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(T__2);
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(44);
				attributes();
				}
			}

			setState(47);
			match(SYOU);
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
	public static class RectangleContext extends ParserRuleContext {
		public TerminalNode SYOU() { return getToken(SVGParser.SYOU, 0); }
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public RectangleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rectangle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVGListener ) ((SVGListener)listener).enterRectangle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVGListener ) ((SVGListener)listener).exitRectangle(this);
		}
	}

	public final RectangleContext rectangle() throws RecognitionException {
		RectangleContext _localctx = new RectangleContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_rectangle);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(T__3);
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(50);
				attributes();
				}
			}

			setState(53);
			match(SYOU);
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
	public static class LineContext extends ParserRuleContext {
		public TerminalNode SYOU() { return getToken(SVGParser.SYOU, 0); }
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVGListener ) ((SVGListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVGListener ) ((SVGListener)listener).exitLine(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(T__4);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(56);
				attributes();
				}
			}

			setState(59);
			match(SYOU);
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
	public static class TextContext extends ParserRuleContext {
		public TerminalNode SYMIN() { return getToken(SVGParser.SYMIN, 0); }
		public TerminalNode STRING() { return getToken(SVGParser.STRING, 0); }
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVGListener ) ((SVGListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVGListener ) ((SVGListener)listener).exitText(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(T__5);
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(62);
				attributes();
				}
			}

			setState(65);
			match(SYMIN);
			setState(66);
			match(STRING);
			setState(67);
			match(T__6);
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
	public static class AttributesContext extends ParserRuleContext {
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public AttributesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVGListener ) ((SVGListener)listener).enterAttributes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVGListener ) ((SVGListener)listener).exitAttributes(this);
		}
	}

	public final AttributesContext attributes() throws RecognitionException {
		AttributesContext _localctx = new AttributesContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_attributes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(69);
				attribute();
				}
				}
				setState(72); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NAME );
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
	public static class AttributeContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(SVGParser.NAME, 0); }
		public TerminalNode ASSES() { return getToken(SVGParser.ASSES, 0); }
		public TerminalNode STRING() { return getToken(SVGParser.STRING, 0); }
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVGListener ) ((SVGListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVGListener ) ((SVGListener)listener).exitAttribute(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(NAME);
			setState(75);
			match(ASSES);
			setState(76);
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

	public static final String _serializedATN =
		"\u0004\u0001\u0010O\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0005\u0000\u0017\b"+
		"\u0000\n\u0000\f\u0000\u001a\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0003\u0001 \b\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"*\b\u0003\u0001\u0004\u0001\u0004\u0003\u0004.\b\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0003\u00054\b\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0003\u0006:\b\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0003\u0007@\b\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0004\bG\b\b\u000b\b\f\bH\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0000\u0000\n\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0000\u0000N\u0000\u0014\u0001\u0000\u0000\u0000"+
		"\u0002\u001d\u0001\u0000\u0000\u0000\u0004#\u0001\u0000\u0000\u0000\u0006"+
		")\u0001\u0000\u0000\u0000\b+\u0001\u0000\u0000\u0000\n1\u0001\u0000\u0000"+
		"\u0000\f7\u0001\u0000\u0000\u0000\u000e=\u0001\u0000\u0000\u0000\u0010"+
		"F\u0001\u0000\u0000\u0000\u0012J\u0001\u0000\u0000\u0000\u0014\u0018\u0003"+
		"\u0002\u0001\u0000\u0015\u0017\u0003\u0006\u0003\u0000\u0016\u0015\u0001"+
		"\u0000\u0000\u0000\u0017\u001a\u0001\u0000\u0000\u0000\u0018\u0016\u0001"+
		"\u0000\u0000\u0000\u0018\u0019\u0001\u0000\u0000\u0000\u0019\u001b\u0001"+
		"\u0000\u0000\u0000\u001a\u0018\u0001\u0000\u0000\u0000\u001b\u001c\u0003"+
		"\u0004\u0002\u0000\u001c\u0001\u0001\u0000\u0000\u0000\u001d\u001f\u0005"+
		"\u0001\u0000\u0000\u001e \u0003\u0010\b\u0000\u001f\u001e\u0001\u0000"+
		"\u0000\u0000\u001f \u0001\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000"+
		"!\"\u0005\f\u0000\u0000\"\u0003\u0001\u0000\u0000\u0000#$\u0005\u0002"+
		"\u0000\u0000$\u0005\u0001\u0000\u0000\u0000%*\u0003\b\u0004\u0000&*\u0003"+
		"\n\u0005\u0000\'*\u0003\f\u0006\u0000(*\u0003\u000e\u0007\u0000)%\u0001"+
		"\u0000\u0000\u0000)&\u0001\u0000\u0000\u0000)\'\u0001\u0000\u0000\u0000"+
		")(\u0001\u0000\u0000\u0000*\u0007\u0001\u0000\u0000\u0000+-\u0005\u0003"+
		"\u0000\u0000,.\u0003\u0010\b\u0000-,\u0001\u0000\u0000\u0000-.\u0001\u0000"+
		"\u0000\u0000./\u0001\u0000\u0000\u0000/0\u0005\r\u0000\u00000\t\u0001"+
		"\u0000\u0000\u000013\u0005\u0004\u0000\u000024\u0003\u0010\b\u000032\u0001"+
		"\u0000\u0000\u000034\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u0000"+
		"56\u0005\r\u0000\u00006\u000b\u0001\u0000\u0000\u000079\u0005\u0005\u0000"+
		"\u00008:\u0003\u0010\b\u000098\u0001\u0000\u0000\u00009:\u0001\u0000\u0000"+
		"\u0000:;\u0001\u0000\u0000\u0000;<\u0005\r\u0000\u0000<\r\u0001\u0000"+
		"\u0000\u0000=?\u0005\u0006\u0000\u0000>@\u0003\u0010\b\u0000?>\u0001\u0000"+
		"\u0000\u0000?@\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AB\u0005"+
		"\f\u0000\u0000BC\u0005\b\u0000\u0000CD\u0005\u0007\u0000\u0000D\u000f"+
		"\u0001\u0000\u0000\u0000EG\u0003\u0012\t\u0000FE\u0001\u0000\u0000\u0000"+
		"GH\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000"+
		"\u0000I\u0011\u0001\u0000\u0000\u0000JK\u0005\t\u0000\u0000KL\u0005\u000e"+
		"\u0000\u0000LM\u0005\b\u0000\u0000M\u0013\u0001\u0000\u0000\u0000\b\u0018"+
		"\u001f)-39?H";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}