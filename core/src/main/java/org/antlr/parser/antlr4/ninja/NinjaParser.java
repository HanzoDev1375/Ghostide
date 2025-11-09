// Generated from /storage/emulated/0/AndroidIDEProjects/Ghost-web-ide2/grammars-v4/Ninja.g4 by ANTLR 4.13.1
package org.antlr.parser.antlr4.ninja;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class NinjaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, WS=8, Dot=9, Public=10, 
		For=11, If=12, Pwd=13, Coordinated=14, Index=15, Get=16, Set=17, At=18, 
		Class=19, Interface=20, Try=21, Handler=22, Apply=23, Aslo=24, Run=25, 
		Hash=26, OpenTag=27;
	public static final int
		RULE_install = 0, RULE_user = 1, RULE_forsteament = 2, RULE_ifsteament = 3, 
		RULE_pwdstemant = 4, RULE_coordinatedstemant = 5, RULE_setstement = 6, 
		RULE_getstement = 7, RULE_classorinterfacePaser = 8, RULE_trystemant = 9, 
		RULE_hanlderstemant = 10, RULE_asloruner = 11, RULE_runruner = 12, RULE_applyruner = 13, 
		RULE_hashcomment = 14, RULE_opentagid = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"install", "user", "forsteament", "ifsteament", "pwdstemant", "coordinatedstemant", 
			"setstement", "getstement", "classorinterfacePaser", "trystemant", "hanlderstemant", 
			"asloruner", "runruner", "applyruner", "hashcomment", "opentagid"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'{'", "'?'", "':'", "'?('", "'!'", null, "'.'", 
			"'public'", "'for'", "'if'", "'pwd'", "'coordinated'", null, "'get'", 
			"'set'", "'@'", "'class'", "'interface'", "'try'", "'handler'", "'apply'", 
			"'aslo'", "'run'", "'#'", "'<'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "WS", "Dot", "Public", 
			"For", "If", "Pwd", "Coordinated", "Index", "Get", "Set", "At", "Class", 
			"Interface", "Try", "Handler", "Apply", "Aslo", "Run", "Hash", "OpenTag"
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
	public String getGrammarFileName() { return "Ninja.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public NinjaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InstallContext extends ParserRuleContext {
		public InstallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_install; }
	 
		public InstallContext() { }
		public void copyFrom(InstallContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstallRuleContext extends InstallContext {
		public TerminalNode EOF() { return getToken(NinjaParser.EOF, 0); }
		public List<UserContext> user() {
			return getRuleContexts(UserContext.class);
		}
		public UserContext user(int i) {
			return getRuleContext(UserContext.class,i);
		}
		public InstallRuleContext(InstallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener) ((NinjaListener)listener).enterInstallRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).exitInstallRule(this);
		}
	}

	public final InstallContext install() throws RecognitionException {
		InstallContext _localctx = new InstallContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_install);
		int _la;
		try {
			_localctx = new InstallRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 209418752L) != 0)) {
				{
				{
				setState(32);
				user();
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38);
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
	public static class UserContext extends ParserRuleContext {
		public ForsteamentContext forsteament() {
			return getRuleContext(ForsteamentContext.class,0);
		}
		public IfsteamentContext ifsteament() {
			return getRuleContext(IfsteamentContext.class,0);
		}
		public PwdstemantContext pwdstemant() {
			return getRuleContext(PwdstemantContext.class,0);
		}
		public CoordinatedstemantContext coordinatedstemant() {
			return getRuleContext(CoordinatedstemantContext.class,0);
		}
		public SetstementContext setstement() {
			return getRuleContext(SetstementContext.class,0);
		}
		public GetstementContext getstement() {
			return getRuleContext(GetstementContext.class,0);
		}
		public ClassorinterfacePaserContext classorinterfacePaser() {
			return getRuleContext(ClassorinterfacePaserContext.class,0);
		}
		public TrystemantContext trystemant() {
			return getRuleContext(TrystemantContext.class,0);
		}
		public HanlderstemantContext hanlderstemant() {
			return getRuleContext(HanlderstemantContext.class,0);
		}
		public OpentagidContext opentagid() {
			return getRuleContext(OpentagidContext.class,0);
		}
		public HashcommentContext hashcomment() {
			return getRuleContext(HashcommentContext.class,0);
		}
		public RunrunerContext runruner() {
			return getRuleContext(RunrunerContext.class,0);
		}
		public AslorunerContext asloruner() {
			return getRuleContext(AslorunerContext.class,0);
		}
		public UserContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_user; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).enterUser(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).exitUser(this);
		}
	}

	public final UserContext user() throws RecognitionException {
		UserContext _localctx = new UserContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_user);
		try {
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				forsteament();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				ifsteament();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(42);
				pwdstemant();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(43);
				coordinatedstemant();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(44);
				setstement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(45);
				getstement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(46);
				classorinterfacePaser();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(47);
				trystemant();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(48);
				hanlderstemant();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(49);
				opentagid();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(50);
				hashcomment();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(51);
				runruner();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(52);
				asloruner();
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
	public static class ForsteamentContext extends ParserRuleContext {
		public ForsteamentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forsteament; }
	 
		public ForsteamentContext() { }
		public void copyFrom(ForsteamentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContext extends ForsteamentContext {
		public TerminalNode For() { return getToken(NinjaParser.For, 0); }
		public TerminalNode Index() { return getToken(NinjaParser.Index, 0); }
		public ForStatementContext(ForsteamentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).exitForStatement(this);
		}
	}

	public final ForsteamentContext forsteament() throws RecognitionException {
		ForsteamentContext _localctx = new ForsteamentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_forsteament);
		try {
			_localctx = new ForStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(For);
			setState(56);
			match(T__0);
			setState(57);
			match(Index);
			setState(58);
			match(T__1);
			setState(59);
			match(T__2);
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
	public static class IfsteamentContext extends ParserRuleContext {
		public IfsteamentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifsteament; }
	 
		public IfsteamentContext() { }
		public void copyFrom(IfsteamentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementWithoutBlockContext extends IfsteamentContext {
		public TerminalNode If() { return getToken(NinjaParser.If, 0); }
		public TerminalNode Index() { return getToken(NinjaParser.Index, 0); }
		public IfStatementWithoutBlockContext(IfsteamentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).enterIfStatementWithoutBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).exitIfStatementWithoutBlock(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementWithBlockContext extends IfsteamentContext {
		public TerminalNode If() { return getToken(NinjaParser.If, 0); }
		public TerminalNode Index() { return getToken(NinjaParser.Index, 0); }
		public IfStatementWithBlockContext(IfsteamentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).enterIfStatementWithBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).exitIfStatementWithBlock(this);
		}
	}

	public final IfsteamentContext ifsteament() throws RecognitionException {
		IfsteamentContext _localctx = new IfsteamentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ifsteament);
		try {
			setState(70);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new IfStatementWithBlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				match(If);
				setState(62);
				match(T__0);
				setState(63);
				match(Index);
				setState(64);
				match(T__1);
				setState(65);
				match(T__2);
				}
				break;
			case 2:
				_localctx = new IfStatementWithoutBlockContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				match(If);
				setState(67);
				match(T__0);
				setState(68);
				match(Index);
				setState(69);
				match(T__1);
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
	public static class PwdstemantContext extends ParserRuleContext {
		public PwdstemantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pwdstemant; }
	 
		public PwdstemantContext() { }
		public void copyFrom(PwdstemantContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PwdStatementContext extends PwdstemantContext {
		public TerminalNode Pwd() { return getToken(NinjaParser.Pwd, 0); }
		public List<TerminalNode> Index() { return getTokens(NinjaParser.Index); }
		public TerminalNode Index(int i) {
			return getToken(NinjaParser.Index, i);
		}
		public PwdStatementContext(PwdstemantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).enterPwdStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).exitPwdStatement(this);
		}
	}

	public final PwdstemantContext pwdstemant() throws RecognitionException {
		PwdstemantContext _localctx = new PwdstemantContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_pwdstemant);
		try {
			_localctx = new PwdStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(Pwd);
			setState(73);
			match(Index);
			setState(74);
			match(T__3);
			setState(75);
			match(Index);
			setState(76);
			match(T__4);
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
	public static class CoordinatedstemantContext extends ParserRuleContext {
		public CoordinatedstemantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coordinatedstemant; }
	 
		public CoordinatedstemantContext() { }
		public void copyFrom(CoordinatedstemantContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CoordinatedStatementContext extends CoordinatedstemantContext {
		public TerminalNode Coordinated() { return getToken(NinjaParser.Coordinated, 0); }
		public TerminalNode Index() { return getToken(NinjaParser.Index, 0); }
		public TerminalNode Apply() { return getToken(NinjaParser.Apply, 0); }
		public CoordinatedStatementContext(CoordinatedstemantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).enterCoordinatedStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).exitCoordinatedStatement(this);
		}
	}

	public final CoordinatedstemantContext coordinatedstemant() throws RecognitionException {
		CoordinatedstemantContext _localctx = new CoordinatedstemantContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_coordinatedstemant);
		try {
			_localctx = new CoordinatedStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(Coordinated);
			setState(79);
			match(T__5);
			setState(80);
			match(Index);
			setState(81);
			match(Apply);
			setState(82);
			match(T__1);
			setState(83);
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
	public static class SetstementContext extends ParserRuleContext {
		public SetstementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setstement; }
	 
		public SetstementContext() { }
		public void copyFrom(SetstementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SetStatementContext extends SetstementContext {
		public TerminalNode Set() { return getToken(NinjaParser.Set, 0); }
		public TerminalNode At() { return getToken(NinjaParser.At, 0); }
		public TerminalNode Index() { return getToken(NinjaParser.Index, 0); }
		public SetStatementContext(SetstementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).enterSetStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).exitSetStatement(this);
		}
	}

	public final SetstementContext setstement() throws RecognitionException {
		SetstementContext _localctx = new SetstementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_setstement);
		try {
			_localctx = new SetStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(Set);
			setState(86);
			match(At);
			setState(87);
			match(Index);
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
	public static class GetstementContext extends ParserRuleContext {
		public GetstementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_getstement; }
	 
		public GetstementContext() { }
		public void copyFrom(GetstementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GetStatementWithCallContext extends GetstementContext {
		public TerminalNode Get() { return getToken(NinjaParser.Get, 0); }
		public TerminalNode Index() { return getToken(NinjaParser.Index, 0); }
		public GetStatementWithCallContext(GetstementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).enterGetStatementWithCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).exitGetStatementWithCall(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GetStatementWithoutCallContext extends GetstementContext {
		public TerminalNode Get() { return getToken(NinjaParser.Get, 0); }
		public TerminalNode Index() { return getToken(NinjaParser.Index, 0); }
		public GetStatementWithoutCallContext(GetstementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).enterGetStatementWithoutCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).exitGetStatementWithoutCall(this);
		}
	}

	public final GetstementContext getstement() throws RecognitionException {
		GetstementContext _localctx = new GetstementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_getstement);
		try {
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new GetStatementWithoutCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				match(Get);
				setState(90);
				match(Index);
				}
				break;
			case 2:
				_localctx = new GetStatementWithCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				match(Get);
				setState(92);
				match(T__0);
				setState(93);
				match(Index);
				setState(94);
				match(T__1);
				setState(95);
				match(T__6);
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
	public static class ClassorinterfacePaserContext extends ParserRuleContext {
		public ClassorinterfacePaserContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classorinterfacePaser; }
	 
		public ClassorinterfacePaserContext() { }
		public void copyFrom(ClassorinterfacePaserContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ClassStatementContext extends ClassorinterfacePaserContext {
		public TerminalNode Class() { return getToken(NinjaParser.Class, 0); }
		public TerminalNode WS() { return getToken(NinjaParser.WS, 0); }
		public TerminalNode Index() { return getToken(NinjaParser.Index, 0); }
		public ClassStatementContext(ClassorinterfacePaserContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).enterClassStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).exitClassStatement(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceStatementContext extends ClassorinterfacePaserContext {
		public TerminalNode Interface() { return getToken(NinjaParser.Interface, 0); }
		public TerminalNode WS() { return getToken(NinjaParser.WS, 0); }
		public TerminalNode Index() { return getToken(NinjaParser.Index, 0); }
		public InterfaceStatementContext(ClassorinterfacePaserContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).enterInterfaceStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).exitInterfaceStatement(this);
		}
	}

	public final ClassorinterfacePaserContext classorinterfacePaser() throws RecognitionException {
		ClassorinterfacePaserContext _localctx = new ClassorinterfacePaserContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_classorinterfacePaser);
		try {
			setState(106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Class:
				_localctx = new ClassStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				match(Class);
				setState(99);
				match(WS);
				setState(100);
				match(Index);
				setState(101);
				match(T__2);
				}
				break;
			case Interface:
				_localctx = new InterfaceStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				match(Interface);
				setState(103);
				match(WS);
				setState(104);
				match(Index);
				setState(105);
				match(T__2);
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
	public static class TrystemantContext extends ParserRuleContext {
		public TrystemantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trystemant; }
	 
		public TrystemantContext() { }
		public void copyFrom(TrystemantContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TryStatementWithBlockContext extends TrystemantContext {
		public TerminalNode Try() { return getToken(NinjaParser.Try, 0); }
		public TerminalNode WS() { return getToken(NinjaParser.WS, 0); }
		public TryStatementWithBlockContext(TrystemantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).enterTryStatementWithBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).exitTryStatementWithBlock(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TryStatementWithoutBlockContext extends TrystemantContext {
		public TerminalNode Try() { return getToken(NinjaParser.Try, 0); }
		public TryStatementWithoutBlockContext(TrystemantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).enterTryStatementWithoutBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).exitTryStatementWithoutBlock(this);
		}
	}

	public final TrystemantContext trystemant() throws RecognitionException {
		TrystemantContext _localctx = new TrystemantContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_trystemant);
		try {
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new TryStatementWithBlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				match(Try);
				setState(109);
				match(WS);
				setState(110);
				match(T__2);
				}
				break;
			case 2:
				_localctx = new TryStatementWithoutBlockContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				match(Try);
				setState(112);
				match(T__2);
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
	public static class HanlderstemantContext extends ParserRuleContext {
		public HanlderstemantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hanlderstemant; }
	 
		public HanlderstemantContext() { }
		public void copyFrom(HanlderstemantContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HandlerStatementContext extends HanlderstemantContext {
		public TerminalNode Handler() { return getToken(NinjaParser.Handler, 0); }
		public TerminalNode Index() { return getToken(NinjaParser.Index, 0); }
		public HandlerStatementContext(HanlderstemantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).enterHandlerStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).exitHandlerStatement(this);
		}
	}

	public final HanlderstemantContext hanlderstemant() throws RecognitionException {
		HanlderstemantContext _localctx = new HanlderstemantContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_hanlderstemant);
		try {
			_localctx = new HandlerStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(Handler);
			setState(116);
			match(T__0);
			setState(117);
			match(Index);
			setState(118);
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
	public static class AslorunerContext extends ParserRuleContext {
		public AslorunerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asloruner; }
	 
		public AslorunerContext() { }
		public void copyFrom(AslorunerContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AslomodContext extends AslorunerContext {
		public TerminalNode Aslo() { return getToken(NinjaParser.Aslo, 0); }
		public List<TerminalNode> Dot() { return getTokens(NinjaParser.Dot); }
		public TerminalNode Dot(int i) {
			return getToken(NinjaParser.Dot, i);
		}
		public AslomodContext(AslorunerContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).enterAslomod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).exitAslomod(this);
		}
	}

	public final AslorunerContext asloruner() throws RecognitionException {
		AslorunerContext _localctx = new AslorunerContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_asloruner);
		int _la;
		try {
			_localctx = new AslomodContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(121); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(120);
				match(Dot);
				}
				}
				setState(123); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Dot );
			setState(125);
			match(Aslo);
			setState(126);
			match(T__2);
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
	public static class RunrunerContext extends ParserRuleContext {
		public RunrunerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_runruner; }
	 
		public RunrunerContext() { }
		public void copyFrom(RunrunerContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RunmodContext extends RunrunerContext {
		public TerminalNode Run() { return getToken(NinjaParser.Run, 0); }
		public List<TerminalNode> Dot() { return getTokens(NinjaParser.Dot); }
		public TerminalNode Dot(int i) {
			return getToken(NinjaParser.Dot, i);
		}
		public RunmodContext(RunrunerContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).enterRunmod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).exitRunmod(this);
		}
	}

	public final RunrunerContext runruner() throws RecognitionException {
		RunrunerContext _localctx = new RunrunerContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_runruner);
		int _la;
		try {
			_localctx = new RunmodContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(129); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(128);
				match(Dot);
				}
				}
				setState(131); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Dot );
			setState(133);
			match(Run);
			setState(134);
			match(T__2);
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
	public static class ApplyrunerContext extends ParserRuleContext {
		public ApplyrunerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_applyruner; }
	 
		public ApplyrunerContext() { }
		public void copyFrom(ApplyrunerContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ApplymodContext extends ApplyrunerContext {
		public TerminalNode Apply() { return getToken(NinjaParser.Apply, 0); }
		public List<TerminalNode> Dot() { return getTokens(NinjaParser.Dot); }
		public TerminalNode Dot(int i) {
			return getToken(NinjaParser.Dot, i);
		}
		public ApplymodContext(ApplyrunerContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).enterApplymod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).exitApplymod(this);
		}
	}

	public final ApplyrunerContext applyruner() throws RecognitionException {
		ApplyrunerContext _localctx = new ApplyrunerContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_applyruner);
		int _la;
		try {
			_localctx = new ApplymodContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(137); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(136);
				match(Dot);
				}
				}
				setState(139); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Dot );
			setState(141);
			match(Apply);
			setState(142);
			match(T__2);
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
	public static class HashcommentContext extends ParserRuleContext {
		public HashcommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hashcomment; }
	 
		public HashcommentContext() { }
		public void copyFrom(HashcommentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HashCoommentModelContext extends HashcommentContext {
		public TerminalNode Hash() { return getToken(NinjaParser.Hash, 0); }
		public TerminalNode Index() { return getToken(NinjaParser.Index, 0); }
		public HashCoommentModelContext(HashcommentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).enterHashCoommentModel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).exitHashCoommentModel(this);
		}
	}

	public final HashcommentContext hashcomment() throws RecognitionException {
		HashcommentContext _localctx = new HashcommentContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_hashcomment);
		try {
			_localctx = new HashCoommentModelContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(Hash);
			setState(145);
			match(Index);
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
	public static class OpentagidContext extends ParserRuleContext {
		public TerminalNode OpenTag() { return getToken(NinjaParser.OpenTag, 0); }
		public TerminalNode Index() { return getToken(NinjaParser.Index, 0); }
		public OpentagidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opentagid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).enterOpentagid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NinjaListener ) ((NinjaListener)listener).exitOpentagid(this);
		}
	}

	public final OpentagidContext opentagid() throws RecognitionException {
		OpentagidContext _localctx = new OpentagidContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_opentagid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(OpenTag);
			setState(148);
			match(Index);
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
		"\u0004\u0001\u001b\u0097\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0001\u0000\u0005\u0000\"\b\u0000\n\u0000\f\u0000%\t\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u00016\b\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0003\u0003G\b\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007a\b\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\bk\b"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\tr\b\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0004\u000bz\b\u000b\u000b\u000b"+
		"\f\u000b{\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0004\f\u0082\b"+
		"\f\u000b\f\f\f\u0083\u0001\f\u0001\f\u0001\f\u0001\r\u0004\r\u008a\b\r"+
		"\u000b\r\f\r\u008b\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0000\u0000\u0010"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e\u0000\u0000\u009a\u0000#\u0001\u0000\u0000\u0000\u00025\u0001"+
		"\u0000\u0000\u0000\u00047\u0001\u0000\u0000\u0000\u0006F\u0001\u0000\u0000"+
		"\u0000\bH\u0001\u0000\u0000\u0000\nN\u0001\u0000\u0000\u0000\fU\u0001"+
		"\u0000\u0000\u0000\u000e`\u0001\u0000\u0000\u0000\u0010j\u0001\u0000\u0000"+
		"\u0000\u0012q\u0001\u0000\u0000\u0000\u0014s\u0001\u0000\u0000\u0000\u0016"+
		"y\u0001\u0000\u0000\u0000\u0018\u0081\u0001\u0000\u0000\u0000\u001a\u0089"+
		"\u0001\u0000\u0000\u0000\u001c\u0090\u0001\u0000\u0000\u0000\u001e\u0093"+
		"\u0001\u0000\u0000\u0000 \"\u0003\u0002\u0001\u0000! \u0001\u0000\u0000"+
		"\u0000\"%\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000#$\u0001\u0000"+
		"\u0000\u0000$&\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000&\'\u0005"+
		"\u0000\u0000\u0001\'\u0001\u0001\u0000\u0000\u0000(6\u0003\u0004\u0002"+
		"\u0000)6\u0003\u0006\u0003\u0000*6\u0003\b\u0004\u0000+6\u0003\n\u0005"+
		"\u0000,6\u0003\f\u0006\u0000-6\u0003\u000e\u0007\u0000.6\u0003\u0010\b"+
		"\u0000/6\u0003\u0012\t\u000006\u0003\u0014\n\u000016\u0003\u001e\u000f"+
		"\u000026\u0003\u001c\u000e\u000036\u0003\u0018\f\u000046\u0003\u0016\u000b"+
		"\u00005(\u0001\u0000\u0000\u00005)\u0001\u0000\u0000\u00005*\u0001\u0000"+
		"\u0000\u00005+\u0001\u0000\u0000\u00005,\u0001\u0000\u0000\u00005-\u0001"+
		"\u0000\u0000\u00005.\u0001\u0000\u0000\u00005/\u0001\u0000\u0000\u0000"+
		"50\u0001\u0000\u0000\u000051\u0001\u0000\u0000\u000052\u0001\u0000\u0000"+
		"\u000053\u0001\u0000\u0000\u000054\u0001\u0000\u0000\u00006\u0003\u0001"+
		"\u0000\u0000\u000078\u0005\u000b\u0000\u000089\u0005\u0001\u0000\u0000"+
		"9:\u0005\u000f\u0000\u0000:;\u0005\u0002\u0000\u0000;<\u0005\u0003\u0000"+
		"\u0000<\u0005\u0001\u0000\u0000\u0000=>\u0005\f\u0000\u0000>?\u0005\u0001"+
		"\u0000\u0000?@\u0005\u000f\u0000\u0000@A\u0005\u0002\u0000\u0000AG\u0005"+
		"\u0003\u0000\u0000BC\u0005\f\u0000\u0000CD\u0005\u0001\u0000\u0000DE\u0005"+
		"\u000f\u0000\u0000EG\u0005\u0002\u0000\u0000F=\u0001\u0000\u0000\u0000"+
		"FB\u0001\u0000\u0000\u0000G\u0007\u0001\u0000\u0000\u0000HI\u0005\r\u0000"+
		"\u0000IJ\u0005\u000f\u0000\u0000JK\u0005\u0004\u0000\u0000KL\u0005\u000f"+
		"\u0000\u0000LM\u0005\u0005\u0000\u0000M\t\u0001\u0000\u0000\u0000NO\u0005"+
		"\u000e\u0000\u0000OP\u0005\u0006\u0000\u0000PQ\u0005\u000f\u0000\u0000"+
		"QR\u0005\u0017\u0000\u0000RS\u0005\u0002\u0000\u0000ST\u0005\u0007\u0000"+
		"\u0000T\u000b\u0001\u0000\u0000\u0000UV\u0005\u0011\u0000\u0000VW\u0005"+
		"\u0012\u0000\u0000WX\u0005\u000f\u0000\u0000X\r\u0001\u0000\u0000\u0000"+
		"YZ\u0005\u0010\u0000\u0000Za\u0005\u000f\u0000\u0000[\\\u0005\u0010\u0000"+
		"\u0000\\]\u0005\u0001\u0000\u0000]^\u0005\u000f\u0000\u0000^_\u0005\u0002"+
		"\u0000\u0000_a\u0005\u0007\u0000\u0000`Y\u0001\u0000\u0000\u0000`[\u0001"+
		"\u0000\u0000\u0000a\u000f\u0001\u0000\u0000\u0000bc\u0005\u0013\u0000"+
		"\u0000cd\u0005\b\u0000\u0000de\u0005\u000f\u0000\u0000ek\u0005\u0003\u0000"+
		"\u0000fg\u0005\u0014\u0000\u0000gh\u0005\b\u0000\u0000hi\u0005\u000f\u0000"+
		"\u0000ik\u0005\u0003\u0000\u0000jb\u0001\u0000\u0000\u0000jf\u0001\u0000"+
		"\u0000\u0000k\u0011\u0001\u0000\u0000\u0000lm\u0005\u0015\u0000\u0000"+
		"mn\u0005\b\u0000\u0000nr\u0005\u0003\u0000\u0000op\u0005\u0015\u0000\u0000"+
		"pr\u0005\u0003\u0000\u0000ql\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000"+
		"\u0000r\u0013\u0001\u0000\u0000\u0000st\u0005\u0016\u0000\u0000tu\u0005"+
		"\u0001\u0000\u0000uv\u0005\u000f\u0000\u0000vw\u0005\u0002\u0000\u0000"+
		"w\u0015\u0001\u0000\u0000\u0000xz\u0005\t\u0000\u0000yx\u0001\u0000\u0000"+
		"\u0000z{\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000{|\u0001\u0000"+
		"\u0000\u0000|}\u0001\u0000\u0000\u0000}~\u0005\u0018\u0000\u0000~\u007f"+
		"\u0005\u0003\u0000\u0000\u007f\u0017\u0001\u0000\u0000\u0000\u0080\u0082"+
		"\u0005\t\u0000\u0000\u0081\u0080\u0001\u0000\u0000\u0000\u0082\u0083\u0001"+
		"\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0083\u0084\u0001"+
		"\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0086\u0005"+
		"\u0019\u0000\u0000\u0086\u0087\u0005\u0003\u0000\u0000\u0087\u0019\u0001"+
		"\u0000\u0000\u0000\u0088\u008a\u0005\t\u0000\u0000\u0089\u0088\u0001\u0000"+
		"\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000"+
		"\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000"+
		"\u0000\u0000\u008d\u008e\u0005\u0017\u0000\u0000\u008e\u008f\u0005\u0003"+
		"\u0000\u0000\u008f\u001b\u0001\u0000\u0000\u0000\u0090\u0091\u0005\u001a"+
		"\u0000\u0000\u0091\u0092\u0005\u000f\u0000\u0000\u0092\u001d\u0001\u0000"+
		"\u0000\u0000\u0093\u0094\u0005\u001b\u0000\u0000\u0094\u0095\u0005\u000f"+
		"\u0000\u0000\u0095\u001f\u0001\u0000\u0000\u0000\t#5F`jq{\u0083\u008b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}