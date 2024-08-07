// Generated from /storage/emulated/0/Download/ADM/AndroidIDE-2.0.0-beta/lexers/src/main/java/com/itsaky/androidide/lexers/xml/XMLLexer.g4 by ANTLR 4.13.1
package io.github.rosemoe.sora.langs.xml;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class XMLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COLON=1, COMMENT=2, CDATA=3, DTD=4, EntityRef=5, CharRef=6, SEA_WS=7, 
		OPEN=8, OPEN_SLASH=9, XMLDeclOpen=10, TEXT=11, CLOSE=12, SPECIAL_CLOSE=13, 
		SLASH_CLOSE=14, SLASH=15, EQUALS=16, STRING=17, Name=18, S=19, PI=20;
	public static final int
		INSIDE=1, PROC_INSTR=2;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "INSIDE", "PROC_INSTR"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COLON", "COMMENT", "CDATA", "DTD", "EntityRef", "CharRef", "SEA_WS", 
			"OPEN", "OPEN_SLASH", "XMLDeclOpen", "SPECIAL_OPEN", "TEXT", "CLOSE", 
			"SPECIAL_CLOSE", "SLASH_CLOSE", "SLASH", "EQUALS", "STRING", "Name", 
			"S", "HEXDIGIT", "DIGIT", "NameChar", "NameStartChar", "PI", "IGNORE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", null, null, null, null, null, null, "'<'", "'</'", null, 
			null, "'>'", null, "'/>'", "'/'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COLON", "COMMENT", "CDATA", "DTD", "EntityRef", "CharRef", "SEA_WS", 
			"OPEN", "OPEN_SLASH", "XMLDeclOpen", "TEXT", "CLOSE", "SPECIAL_CLOSE", 
			"SLASH_CLOSE", "SLASH", "EQUALS", "STRING", "Name", "S", "PI"
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


	public XMLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "XMLLexer.g4"; }

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
		"\u0004\u0000\u0014\u00fb\u0006\uffff\uffff\u0006\uffff\uffff\u0006\uffff"+
		"\uffff\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002\u0007"+
		"\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005\u0007"+
		"\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007\b"+
		"\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002\f\u0007"+
		"\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f\u0002"+
		"\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012\u0002"+
		"\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015\u0002"+
		"\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018\u0002"+
		"\u0019\u0007\u0019\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001@\b\u0001\n\u0001"+
		"\f\u0001C\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002T\b"+
		"\u0002\n\u0002\f\u0002W\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003a\b"+
		"\u0003\n\u0003\f\u0003d\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0004\u0005r\b\u0005\u000b\u0005\f\u0005"+
		"s\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0004\u0005}\b\u0005\u000b\u0005\f\u0005~\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0004"+
		"\u0005\u0088\b\u0005\u000b\u0005\f\u0005\u0089\u0003\u0005\u008c\b\u0005"+
		"\u0001\u0006\u0001\u0006\u0003\u0006\u0090\b\u0006\u0001\u0006\u0004\u0006"+
		"\u0093\b\u0006\u000b\u0006\f\u0006\u0094\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0004\u000b\u00b3\b\u000b\u000b\u000b\f\u000b\u00b4\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0005\u0011\u00cb\b\u0011\n\u0011"+
		"\f\u0011\u00ce\t\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011"+
		"\u00d3\b\u0011\n\u0011\f\u0011\u00d6\t\u0011\u0001\u0011\u0003\u0011\u00d9"+
		"\b\u0011\u0001\u0012\u0001\u0012\u0005\u0012\u00dd\b\u0012\n\u0012\f\u0012"+
		"\u00e0\t\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0003\u0016\u00ee\b\u0016\u0001\u0017\u0003\u0017\u00f1\b"+
		"\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003AUb\u0000\u001a\u0003"+
		"\u0001\u0005\u0002\u0007\u0003\t\u0004\u000b\u0005\r\u0006\u000f\u0007"+
		"\u0011\b\u0013\t\u0015\n\u0017\u0000\u0019\u000b\u001b\f\u001d\r\u001f"+
		"\u000e!\u000f#\u0010%\u0011\'\u0012)\u0013+\u0000-\u0000/\u00001\u0000"+
		"3\u00145\u0000\u0003\u0000\u0001\u0002\n\u0002\u0000\t\t  \u0002\u0000"+
		"&&<<\u0002\u0000\"\"<<\u0002\u0000\'\'<<\u0003\u0000\t\n\r\r  \u0003\u0000"+
		"09AFaf\u0001\u000009\u0002\u0000-.__\u0003\u0000\u00b7\u00b7\u0300\u036f"+
		"\u203f\u2040\b\u0000::AZaz\u2070\u218f\u2c00\u2fef\u3001\u8000\ud7ff\u8000"+
		"\uf900\u8000\ufdcf\u8000\ufdf0\u8000\ufffd\u0107\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0001\u001b\u0001\u0000\u0000\u0000"+
		"\u0001\u001d\u0001\u0000\u0000\u0000\u0001\u001f\u0001\u0000\u0000\u0000"+
		"\u0001!\u0001\u0000\u0000\u0000\u0001#\u0001\u0000\u0000\u0000\u0001%"+
		"\u0001\u0000\u0000\u0000\u0001\'\u0001\u0000\u0000\u0000\u0001)\u0001"+
		"\u0000\u0000\u0000\u00023\u0001\u0000\u0000\u0000\u00025\u0001\u0000\u0000"+
		"\u0000\u00037\u0001\u0000\u0000\u0000\u00059\u0001\u0000\u0000\u0000\u0007"+
		"H\u0001\u0000\u0000\u0000\t\\\u0001\u0000\u0000\u0000\u000bi\u0001\u0000"+
		"\u0000\u0000\r\u008b\u0001\u0000\u0000\u0000\u000f\u0092\u0001\u0000\u0000"+
		"\u0000\u0011\u0096\u0001\u0000\u0000\u0000\u0013\u009a\u0001\u0000\u0000"+
		"\u0000\u0015\u009f\u0001\u0000\u0000\u0000\u0017\u00a9\u0001\u0000\u0000"+
		"\u0000\u0019\u00b2\u0001\u0000\u0000\u0000\u001b\u00b6\u0001\u0000\u0000"+
		"\u0000\u001d\u00ba\u0001\u0000\u0000\u0000\u001f\u00bf\u0001\u0000\u0000"+
		"\u0000!\u00c4\u0001\u0000\u0000\u0000#\u00c6\u0001\u0000\u0000\u0000%"+
		"\u00d8\u0001\u0000\u0000\u0000\'\u00da\u0001\u0000\u0000\u0000)\u00e1"+
		"\u0001\u0000\u0000\u0000+\u00e5\u0001\u0000\u0000\u0000-\u00e7\u0001\u0000"+
		"\u0000\u0000/\u00ed\u0001\u0000\u0000\u00001\u00f0\u0001\u0000\u0000\u0000"+
		"3\u00f2\u0001\u0000\u0000\u00005\u00f7\u0001\u0000\u0000\u000078\u0005"+
		":\u0000\u00008\u0004\u0001\u0000\u0000\u00009:\u0005<\u0000\u0000:;\u0005"+
		"!\u0000\u0000;<\u0005-\u0000\u0000<=\u0005-\u0000\u0000=A\u0001\u0000"+
		"\u0000\u0000>@\t\u0000\u0000\u0000?>\u0001\u0000\u0000\u0000@C\u0001\u0000"+
		"\u0000\u0000AB\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000BD\u0001"+
		"\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000DE\u0005-\u0000\u0000EF\u0005"+
		"-\u0000\u0000FG\u0005>\u0000\u0000G\u0006\u0001\u0000\u0000\u0000HI\u0005"+
		"<\u0000\u0000IJ\u0005!\u0000\u0000JK\u0005[\u0000\u0000KL\u0005C\u0000"+
		"\u0000LM\u0005D\u0000\u0000MN\u0005A\u0000\u0000NO\u0005T\u0000\u0000"+
		"OP\u0005A\u0000\u0000PQ\u0005[\u0000\u0000QU\u0001\u0000\u0000\u0000R"+
		"T\t\u0000\u0000\u0000SR\u0001\u0000\u0000\u0000TW\u0001\u0000\u0000\u0000"+
		"UV\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000VX\u0001\u0000\u0000"+
		"\u0000WU\u0001\u0000\u0000\u0000XY\u0005]\u0000\u0000YZ\u0005]\u0000\u0000"+
		"Z[\u0005>\u0000\u0000[\b\u0001\u0000\u0000\u0000\\]\u0005<\u0000\u0000"+
		"]^\u0005!\u0000\u0000^b\u0001\u0000\u0000\u0000_a\t\u0000\u0000\u0000"+
		"`_\u0001\u0000\u0000\u0000ad\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000"+
		"\u0000b`\u0001\u0000\u0000\u0000ce\u0001\u0000\u0000\u0000db\u0001\u0000"+
		"\u0000\u0000ef\u0005>\u0000\u0000fg\u0001\u0000\u0000\u0000gh\u0006\u0003"+
		"\u0000\u0000h\n\u0001\u0000\u0000\u0000ij\u0005&\u0000\u0000jk\u0003\'"+
		"\u0012\u0000kl\u0005;\u0000\u0000l\f\u0001\u0000\u0000\u0000mn\u0005&"+
		"\u0000\u0000no\u0005#\u0000\u0000oq\u0001\u0000\u0000\u0000pr\u0003-\u0015"+
		"\u0000qp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000sq\u0001\u0000"+
		"\u0000\u0000st\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000uv\u0005"+
		";\u0000\u0000v\u008c\u0001\u0000\u0000\u0000wx\u0005&\u0000\u0000xy\u0005"+
		"#\u0000\u0000yz\u0005x\u0000\u0000z|\u0001\u0000\u0000\u0000{}\u0003+"+
		"\u0014\u0000|{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~|\u0001"+
		"\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000"+
		"\u0000\u0000\u0080\u0081\u0005;\u0000\u0000\u0081\u008c\u0001\u0000\u0000"+
		"\u0000\u0082\u0083\u0005&\u0000\u0000\u0083\u0084\u0005#\u0000\u0000\u0084"+
		"\u0085\u0005x\u0000\u0000\u0085\u0087\u0001\u0000\u0000\u0000\u0086\u0088"+
		"\u0003+\u0014\u0000\u0087\u0086\u0001\u0000\u0000\u0000\u0088\u0089\u0001"+
		"\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u0089\u008a\u0001"+
		"\u0000\u0000\u0000\u008a\u008c\u0001\u0000\u0000\u0000\u008bm\u0001\u0000"+
		"\u0000\u0000\u008bw\u0001\u0000\u0000\u0000\u008b\u0082\u0001\u0000\u0000"+
		"\u0000\u008c\u000e\u0001\u0000\u0000\u0000\u008d\u0093\u0007\u0000\u0000"+
		"\u0000\u008e\u0090\u0005\r\u0000\u0000\u008f\u008e\u0001\u0000\u0000\u0000"+
		"\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000"+
		"\u0091\u0093\u0005\n\u0000\u0000\u0092\u008d\u0001\u0000\u0000\u0000\u0092"+
		"\u008f\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094"+
		"\u0092\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095"+
		"\u0010\u0001\u0000\u0000\u0000\u0096\u0097\u0005<\u0000\u0000\u0097\u0098"+
		"\u0001\u0000\u0000\u0000\u0098\u0099\u0006\u0007\u0001\u0000\u0099\u0012"+
		"\u0001\u0000\u0000\u0000\u009a\u009b\u0005<\u0000\u0000\u009b\u009c\u0005"+
		"/\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u009e\u0006\b"+
		"\u0001\u0000\u009e\u0014\u0001\u0000\u0000\u0000\u009f\u00a0\u0005<\u0000"+
		"\u0000\u00a0\u00a1\u0005?\u0000\u0000\u00a1\u00a2\u0005x\u0000\u0000\u00a2"+
		"\u00a3\u0005m\u0000\u0000\u00a3\u00a4\u0005l\u0000\u0000\u00a4\u00a5\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a6\u0003)\u0013\u0000\u00a6\u00a7\u0001\u0000"+
		"\u0000\u0000\u00a7\u00a8\u0006\t\u0001\u0000\u00a8\u0016\u0001\u0000\u0000"+
		"\u0000\u00a9\u00aa\u0005<\u0000\u0000\u00aa\u00ab\u0005?\u0000\u0000\u00ab"+
		"\u00ac\u0001\u0000\u0000\u0000\u00ac\u00ad\u0003\'\u0012\u0000\u00ad\u00ae"+
		"\u0001\u0000\u0000\u0000\u00ae\u00af\u0006\n\u0002\u0000\u00af\u00b0\u0006"+
		"\n\u0003\u0000\u00b0\u0018\u0001\u0000\u0000\u0000\u00b1\u00b3\b\u0001"+
		"\u0000\u0000\u00b2\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000"+
		"\u0000\u0000\u00b5\u001a\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005>\u0000"+
		"\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00b9\u0006\f\u0004\u0000"+
		"\u00b9\u001c\u0001\u0000\u0000\u0000\u00ba\u00bb\u0005?\u0000\u0000\u00bb"+
		"\u00bc\u0005>\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u00be"+
		"\u0006\r\u0004\u0000\u00be\u001e\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005"+
		"/\u0000\u0000\u00c0\u00c1\u0005>\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000"+
		"\u0000\u00c2\u00c3\u0006\u000e\u0004\u0000\u00c3 \u0001\u0000\u0000\u0000"+
		"\u00c4\u00c5\u0005/\u0000\u0000\u00c5\"\u0001\u0000\u0000\u0000\u00c6"+
		"\u00c7\u0005=\u0000\u0000\u00c7$\u0001\u0000\u0000\u0000\u00c8\u00cc\u0005"+
		"\"\u0000\u0000\u00c9\u00cb\b\u0002\u0000\u0000\u00ca\u00c9\u0001\u0000"+
		"\u0000\u0000\u00cb\u00ce\u0001\u0000\u0000\u0000\u00cc\u00ca\u0001\u0000"+
		"\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd\u00cf\u0001\u0000"+
		"\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00cf\u00d9\u0005\"\u0000"+
		"\u0000\u00d0\u00d4\u0005\'\u0000\u0000\u00d1\u00d3\b\u0003\u0000\u0000"+
		"\u00d2\u00d1\u0001\u0000\u0000\u0000\u00d3\u00d6\u0001\u0000\u0000\u0000"+
		"\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000"+
		"\u00d5\u00d7\u0001\u0000\u0000\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000"+
		"\u00d7\u00d9\u0005\'\u0000\u0000\u00d8\u00c8\u0001\u0000\u0000\u0000\u00d8"+
		"\u00d0\u0001\u0000\u0000\u0000\u00d9&\u0001\u0000\u0000\u0000\u00da\u00de"+
		"\u00031\u0017\u0000\u00db\u00dd\u0003/\u0016\u0000\u00dc\u00db\u0001\u0000"+
		"\u0000\u0000\u00dd\u00e0\u0001\u0000\u0000\u0000\u00de\u00dc\u0001\u0000"+
		"\u0000\u0000\u00de\u00df\u0001\u0000\u0000\u0000\u00df(\u0001\u0000\u0000"+
		"\u0000\u00e0\u00de\u0001\u0000\u0000\u0000\u00e1\u00e2\u0007\u0004\u0000"+
		"\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3\u00e4\u0006\u0013\u0000"+
		"\u0000\u00e4*\u0001\u0000\u0000\u0000\u00e5\u00e6\u0007\u0005\u0000\u0000"+
		"\u00e6,\u0001\u0000\u0000\u0000\u00e7\u00e8\u0007\u0006\u0000\u0000\u00e8"+
		".\u0001\u0000\u0000\u0000\u00e9\u00ee\u00031\u0017\u0000\u00ea\u00ee\u0007"+
		"\u0007\u0000\u0000\u00eb\u00ee\u0003-\u0015\u0000\u00ec\u00ee\u0007\b"+
		"\u0000\u0000\u00ed\u00e9\u0001\u0000\u0000\u0000\u00ed\u00ea\u0001\u0000"+
		"\u0000\u0000\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ed\u00ec\u0001\u0000"+
		"\u0000\u0000\u00ee0\u0001\u0000\u0000\u0000\u00ef\u00f1\u0007\t\u0000"+
		"\u0000\u00f0\u00ef\u0001\u0000\u0000\u0000\u00f12\u0001\u0000\u0000\u0000"+
		"\u00f2\u00f3\u0005?\u0000\u0000\u00f3\u00f4\u0005>\u0000\u0000\u00f4\u00f5"+
		"\u0001\u0000\u0000\u0000\u00f5\u00f6\u0006\u0018\u0004\u0000\u00f64\u0001"+
		"\u0000\u0000\u0000\u00f7\u00f8\t\u0000\u0000\u0000\u00f8\u00f9\u0001\u0000"+
		"\u0000\u0000\u00f9\u00fa\u0006\u0019\u0002\u0000\u00fa6\u0001\u0000\u0000"+
		"\u0000\u0014\u0000\u0001\u0002AUbs~\u0089\u008b\u008f\u0092\u0094\u00b4"+
		"\u00cc\u00d4\u00d8\u00de\u00ed\u00f0\u0005\u0006\u0000\u0000\u0005\u0001"+
		"\u0000\u0003\u0000\u0000\u0005\u0002\u0000\u0004\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}