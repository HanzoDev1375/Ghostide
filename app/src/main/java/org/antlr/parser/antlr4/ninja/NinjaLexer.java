// Generated from /storage/emulated/0/apk/Ninja.g4 by ANTLR 4.13.1
package org.antlr.parser.antlr4.ninja;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class NinjaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, WS=8, Dot=9, Public=10, 
		For=11, If=12, Pwd=13, Coordinated=14, Index=15, Get=16, Set=17, At=18, 
		Class=19, Interface=20, Try=21, Handler=22, Apply=23, Aslo=24, Run=25, 
		Hash=26, OpenTag=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "WS", "Dot", 
			"Public", "For", "If", "Pwd", "Coordinated", "Number", "Name", "Index", 
			"Get", "Set", "At", "Class", "Interface", "Try", "Handler", "Apply", 
			"Aslo", "Run", "Hash", "OpenTag"
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


	public NinjaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Ninja.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u001b\u00b5\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0004\u0007L\b\u0007\u000b\u0007\f\u0007M\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0005"+
		"\u0010x\b\u0010\n\u0010\f\u0010{\t\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001c\u0001"+
		"\u001c\u0000\u0000\u001d\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017"+
		"\f\u0019\r\u001b\u000e\u001d\u0000\u001f\u0000!\u000f#\u0010%\u0011\'"+
		"\u0012)\u0013+\u0014-\u0015/\u00161\u00173\u00185\u00197\u001a9\u001b"+
		"\u0001\u0000\u0003\u0003\u0000\t\n\r\r  \u0001\u000009\u0002\u0000AZa"+
		"z\u00b4\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"+
		"\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000"+
		"\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000"+
		"\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000"+
		"\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000"+
		"\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000"+
		"!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001"+
		"\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000"+
		"\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000"+
		"\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u00003"+
		"\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001\u0000"+
		"\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0001;\u0001\u0000\u0000\u0000"+
		"\u0003=\u0001\u0000\u0000\u0000\u0005?\u0001\u0000\u0000\u0000\u0007A"+
		"\u0001\u0000\u0000\u0000\tC\u0001\u0000\u0000\u0000\u000bE\u0001\u0000"+
		"\u0000\u0000\rH\u0001\u0000\u0000\u0000\u000fK\u0001\u0000\u0000\u0000"+
		"\u0011Q\u0001\u0000\u0000\u0000\u0013S\u0001\u0000\u0000\u0000\u0015Z"+
		"\u0001\u0000\u0000\u0000\u0017^\u0001\u0000\u0000\u0000\u0019a\u0001\u0000"+
		"\u0000\u0000\u001be\u0001\u0000\u0000\u0000\u001dq\u0001\u0000\u0000\u0000"+
		"\u001fs\u0001\u0000\u0000\u0000!u\u0001\u0000\u0000\u0000#|\u0001\u0000"+
		"\u0000\u0000%\u0080\u0001\u0000\u0000\u0000\'\u0084\u0001\u0000\u0000"+
		"\u0000)\u0086\u0001\u0000\u0000\u0000+\u008c\u0001\u0000\u0000\u0000-"+
		"\u0096\u0001\u0000\u0000\u0000/\u009a\u0001\u0000\u0000\u00001\u00a2\u0001"+
		"\u0000\u0000\u00003\u00a8\u0001\u0000\u0000\u00005\u00ad\u0001\u0000\u0000"+
		"\u00007\u00b1\u0001\u0000\u0000\u00009\u00b3\u0001\u0000\u0000\u0000;"+
		"<\u0005(\u0000\u0000<\u0002\u0001\u0000\u0000\u0000=>\u0005)\u0000\u0000"+
		">\u0004\u0001\u0000\u0000\u0000?@\u0005{\u0000\u0000@\u0006\u0001\u0000"+
		"\u0000\u0000AB\u0005?\u0000\u0000B\b\u0001\u0000\u0000\u0000CD\u0005:"+
		"\u0000\u0000D\n\u0001\u0000\u0000\u0000EF\u0005?\u0000\u0000FG\u0005("+
		"\u0000\u0000G\f\u0001\u0000\u0000\u0000HI\u0005!\u0000\u0000I\u000e\u0001"+
		"\u0000\u0000\u0000JL\u0007\u0000\u0000\u0000KJ\u0001\u0000\u0000\u0000"+
		"LM\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000"+
		"\u0000NO\u0001\u0000\u0000\u0000OP\u0006\u0007\u0000\u0000P\u0010\u0001"+
		"\u0000\u0000\u0000QR\u0005.\u0000\u0000R\u0012\u0001\u0000\u0000\u0000"+
		"ST\u0005p\u0000\u0000TU\u0005u\u0000\u0000UV\u0005b\u0000\u0000VW\u0005"+
		"l\u0000\u0000WX\u0005i\u0000\u0000XY\u0005c\u0000\u0000Y\u0014\u0001\u0000"+
		"\u0000\u0000Z[\u0005f\u0000\u0000[\\\u0005o\u0000\u0000\\]\u0005r\u0000"+
		"\u0000]\u0016\u0001\u0000\u0000\u0000^_\u0005i\u0000\u0000_`\u0005f\u0000"+
		"\u0000`\u0018\u0001\u0000\u0000\u0000ab\u0005p\u0000\u0000bc\u0005w\u0000"+
		"\u0000cd\u0005d\u0000\u0000d\u001a\u0001\u0000\u0000\u0000ef\u0005c\u0000"+
		"\u0000fg\u0005o\u0000\u0000gh\u0005o\u0000\u0000hi\u0005r\u0000\u0000"+
		"ij\u0005d\u0000\u0000jk\u0005i\u0000\u0000kl\u0005n\u0000\u0000lm\u0005"+
		"a\u0000\u0000mn\u0005t\u0000\u0000no\u0005e\u0000\u0000op\u0005d\u0000"+
		"\u0000p\u001c\u0001\u0000\u0000\u0000qr\u0007\u0001\u0000\u0000r\u001e"+
		"\u0001\u0000\u0000\u0000st\u0007\u0002\u0000\u0000t \u0001\u0000\u0000"+
		"\u0000uy\u0003\u001f\u000f\u0000vx\u0003\u001d\u000e\u0000wv\u0001\u0000"+
		"\u0000\u0000x{\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000yz\u0001"+
		"\u0000\u0000\u0000z\"\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000"+
		"|}\u0005g\u0000\u0000}~\u0005e\u0000\u0000~\u007f\u0005t\u0000\u0000\u007f"+
		"$\u0001\u0000\u0000\u0000\u0080\u0081\u0005s\u0000\u0000\u0081\u0082\u0005"+
		"e\u0000\u0000\u0082\u0083\u0005t\u0000\u0000\u0083&\u0001\u0000\u0000"+
		"\u0000\u0084\u0085\u0005@\u0000\u0000\u0085(\u0001\u0000\u0000\u0000\u0086"+
		"\u0087\u0005c\u0000\u0000\u0087\u0088\u0005l\u0000\u0000\u0088\u0089\u0005"+
		"a\u0000\u0000\u0089\u008a\u0005s\u0000\u0000\u008a\u008b\u0005s\u0000"+
		"\u0000\u008b*\u0001\u0000\u0000\u0000\u008c\u008d\u0005i\u0000\u0000\u008d"+
		"\u008e\u0005n\u0000\u0000\u008e\u008f\u0005t\u0000\u0000\u008f\u0090\u0005"+
		"e\u0000\u0000\u0090\u0091\u0005r\u0000\u0000\u0091\u0092\u0005f\u0000"+
		"\u0000\u0092\u0093\u0005a\u0000\u0000\u0093\u0094\u0005c\u0000\u0000\u0094"+
		"\u0095\u0005e\u0000\u0000\u0095,\u0001\u0000\u0000\u0000\u0096\u0097\u0005"+
		"t\u0000\u0000\u0097\u0098\u0005r\u0000\u0000\u0098\u0099\u0005y\u0000"+
		"\u0000\u0099.\u0001\u0000\u0000\u0000\u009a\u009b\u0005h\u0000\u0000\u009b"+
		"\u009c\u0005a\u0000\u0000\u009c\u009d\u0005n\u0000\u0000\u009d\u009e\u0005"+
		"d\u0000\u0000\u009e\u009f\u0005l\u0000\u0000\u009f\u00a0\u0005e\u0000"+
		"\u0000\u00a0\u00a1\u0005r\u0000\u0000\u00a10\u0001\u0000\u0000\u0000\u00a2"+
		"\u00a3\u0005a\u0000\u0000\u00a3\u00a4\u0005p\u0000\u0000\u00a4\u00a5\u0005"+
		"p\u0000\u0000\u00a5\u00a6\u0005l\u0000\u0000\u00a6\u00a7\u0005y\u0000"+
		"\u0000\u00a72\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005a\u0000\u0000\u00a9"+
		"\u00aa\u0005s\u0000\u0000\u00aa\u00ab\u0005l\u0000\u0000\u00ab\u00ac\u0005"+
		"o\u0000\u0000\u00ac4\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005r\u0000"+
		"\u0000\u00ae\u00af\u0005u\u0000\u0000\u00af\u00b0\u0005n\u0000\u0000\u00b0"+
		"6\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005#\u0000\u0000\u00b28\u0001"+
		"\u0000\u0000\u0000\u00b3\u00b4\u0005<\u0000\u0000\u00b4:\u0001\u0000\u0000"+
		"\u0000\u0003\u0000My\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}