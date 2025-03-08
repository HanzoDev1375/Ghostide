// Generated from /storage/emulated/0/AndroidIDEProjects/Ghost-web-ide2/grammars-v4/YamlGrammar.g4 by ANTLR 4.13.1
package ir.ninjacoder.ghostide;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class YamlGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, STRING=5, NUMBER=6, BOOLEAN=7, WS=8, COMMENT=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "STRING", "NUMBER", "BOOLEAN", "WS", 
			"COMMENT"
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


	public YamlGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "YamlGrammar.g4"; }

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
		"\u0004\u0000\tM\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0005\u0004\u001e\b\u0004\n\u0004\f\u0004!\t\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0003\u0005&\b\u0005\u0001\u0005\u0004\u0005"+
		")\b\u0005\u000b\u0005\f\u0005*\u0001\u0005\u0001\u0005\u0004\u0005/\b"+
		"\u0005\u000b\u0005\f\u00050\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006<\b\u0006\u0001\u0007\u0004\u0007?\b\u0007\u000b\u0007\f\u0007@"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0005\bG\b\b\n\b\f\bJ\t\b\u0001"+
		"\b\u0001\b\u0000\u0000\t\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0001\u0000\u0004\u0001\u0000"+
		"\"\"\u0001\u000009\u0003\u0000\t\n\r\r  \u0002\u0000\n\n\r\rS\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0001\u0013\u0001\u0000\u0000\u0000\u0003\u0015\u0001\u0000"+
		"\u0000\u0000\u0005\u0017\u0001\u0000\u0000\u0000\u0007\u0019\u0001\u0000"+
		"\u0000\u0000\t\u001b\u0001\u0000\u0000\u0000\u000b%\u0001\u0000\u0000"+
		"\u0000\r;\u0001\u0000\u0000\u0000\u000f>\u0001\u0000\u0000\u0000\u0011"+
		"D\u0001\u0000\u0000\u0000\u0013\u0014\u0005:\u0000\u0000\u0014\u0002\u0001"+
		"\u0000\u0000\u0000\u0015\u0016\u0005[\u0000\u0000\u0016\u0004\u0001\u0000"+
		"\u0000\u0000\u0017\u0018\u0005,\u0000\u0000\u0018\u0006\u0001\u0000\u0000"+
		"\u0000\u0019\u001a\u0005]\u0000\u0000\u001a\b\u0001\u0000\u0000\u0000"+
		"\u001b\u001f\u0005\"\u0000\u0000\u001c\u001e\b\u0000\u0000\u0000\u001d"+
		"\u001c\u0001\u0000\u0000\u0000\u001e!\u0001\u0000\u0000\u0000\u001f\u001d"+
		"\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000\u0000 \"\u0001\u0000"+
		"\u0000\u0000!\u001f\u0001\u0000\u0000\u0000\"#\u0005\"\u0000\u0000#\n"+
		"\u0001\u0000\u0000\u0000$&\u0005-\u0000\u0000%$\u0001\u0000\u0000\u0000"+
		"%&\u0001\u0000\u0000\u0000&(\u0001\u0000\u0000\u0000\')\u0007\u0001\u0000"+
		"\u0000(\'\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000*(\u0001\u0000"+
		"\u0000\u0000*+\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,.\u0005"+
		".\u0000\u0000-/\u0007\u0001\u0000\u0000.-\u0001\u0000\u0000\u0000/0\u0001"+
		"\u0000\u0000\u00000.\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u0000"+
		"1\f\u0001\u0000\u0000\u000023\u0005t\u0000\u000034\u0005r\u0000\u0000"+
		"45\u0005u\u0000\u00005<\u0005e\u0000\u000067\u0005f\u0000\u000078\u0005"+
		"a\u0000\u000089\u0005l\u0000\u00009:\u0005s\u0000\u0000:<\u0005e\u0000"+
		"\u0000;2\u0001\u0000\u0000\u0000;6\u0001\u0000\u0000\u0000<\u000e\u0001"+
		"\u0000\u0000\u0000=?\u0007\u0002\u0000\u0000>=\u0001\u0000\u0000\u0000"+
		"?@\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000"+
		"\u0000AB\u0001\u0000\u0000\u0000BC\u0006\u0007\u0000\u0000C\u0010\u0001"+
		"\u0000\u0000\u0000DH\u0005#\u0000\u0000EG\b\u0003\u0000\u0000FE\u0001"+
		"\u0000\u0000\u0000GJ\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000"+
		"HI\u0001\u0000\u0000\u0000IK\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000"+
		"\u0000KL\u0006\b\u0000\u0000L\u0012\u0001\u0000\u0000\u0000\b\u0000\u001f"+
		"%*0;@H\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}