package io.github.rosemoe.sora.langs.loglang;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({
        "all",
        "warnings",
        "unchecked",
        "unused",
        "cast",
        "CheckReturnValue",
        "this-escape"
})
public class LOGLexer extends Lexer {
    public static final int DEBUG = 1,
            INFO = 2,
            ERROR = 3,
            LOG = 4,
            WARNING = 5,
            WS = 6,
            DECIMAL_LITERAL = 7,
            HEX_LITERAL = 8,
            OCT_LITERAL = 9,
            BINARY_LITERAL = 10,
            SPACENAME = 11;
    public static final String[] ruleNames = makeRuleNames();
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\u0004\u0000\u000b\u00b6\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"
                    + "\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"
                    + "\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"
                    + "\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"
                    + "\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"
                    + "\u0002\u000f\u0007\u000f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"
                    + "\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"
                    + "\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"
                    + "\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"
                    + "\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"
                    + "\u0001\u0004\u0001\u0005\u0004\u0005@\b\u0005\u000b\u0005\f\u0005A\u0001"
                    + "\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006I\b"
                    + "\u0006\u0001\u0006\u0004\u0006L\b\u0006\u000b\u0006\f\u0006M\u0001\u0006"
                    + "\u0003\u0006Q\b\u0006\u0003\u0006S\b\u0006\u0001\u0006\u0003\u0006V\b"
                    + "\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\\\b"
                    + "\u0007\n\u0007\f\u0007_\t\u0007\u0001\u0007\u0003\u0007b\b\u0007\u0001"
                    + "\u0007\u0003\u0007e\b\u0007\u0001\b\u0001\b\u0005\bi\b\b\n\b\f\bl\t\b"
                    + "\u0001\b\u0001\b\u0005\bp\b\b\n\b\f\bs\t\b\u0001\b\u0003\bv\b\b\u0001"
                    + "\b\u0003\by\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u007f\b\t\n\t"
                    + "\f\t\u0082\t\t\u0001\t\u0003\t\u0085\b\t\u0001\t\u0003\t\u0088\b\t\u0001"
                    + "\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"
                    + "\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u0099"
                    + "\b\u000b\n\u000b\f\u000b\u009c\t\u000b\u0001\u000b\u0003\u000b\u009f\b"
                    + "\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0005\r\u00a5\b\r\n\r\f\r\u00a8"
                    + "\t\r\u0001\r\u0003\r\u00ab\b\r\u0001\u000e\u0001\u000e\u0003\u000e\u00af"
                    + "\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00b5"
                    + "\b\u000f\u0000\u0000\u0010\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"
                    + "\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017"
                    + "\u0000\u0019\u0000\u001b\u0000\u001d\u0000\u001f\u0000\u0001\u0000\u0011"
                    + "\u0003\u0000\t\n\f\r  \u0001\u000019\u0002\u0000LLll\u0002\u0000XXxx\u0003"
                    + "\u000009AFaf\u0004\u000009AF__af\u0001\u000007\u0002\u000007__\u0002\u0000"
                    + "BBbb\u0001\u000001\u0002\u000001__\u0001\u000009\u0002\u000009__\u0004"
                    + "\u0000$$AZ__az\u0002\u0000\u0000\u007f\u8000\ud800\u8000\udbff\u0001\u0000"
                    + "\u8000\ud800\u8000\udbff\u0001\u0000\u8000\udc00\u8000\udfff\u00c8\u0000"
                    + "\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000"
                    + "\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000"
                    + "\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r"
                    + "\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"
                    + "\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"
                    + "\u0001\u0000\u0000\u0000\u0001!\u0001\u0000\u0000\u0000\u0003\'\u0001"
                    + "\u0000\u0000\u0000\u0005,\u0001\u0000\u0000\u0000\u00072\u0001\u0000\u0000"
                    + "\u0000\t6\u0001\u0000\u0000\u0000\u000b?\u0001\u0000\u0000\u0000\rR\u0001"
                    + "\u0000\u0000\u0000\u000fW\u0001\u0000\u0000\u0000\u0011f\u0001\u0000\u0000"
                    + "\u0000\u0013z\u0001\u0000\u0000\u0000\u0015\u0089\u0001\u0000\u0000\u0000"
                    + "\u0017\u0095\u0001\u0000\u0000\u0000\u0019\u00a0\u0001\u0000\u0000\u0000"
                    + "\u001b\u00a2\u0001\u0000\u0000\u0000\u001d\u00ae\u0001\u0000\u0000\u0000"
                    + "\u001f\u00b4\u0001\u0000\u0000\u0000!\"\u0005D\u0000\u0000\"#\u0005E\u0000"
                    + "\u0000#$\u0005B\u0000\u0000$%\u0005U\u0000\u0000%&\u0005G\u0000\u0000"
                    + "&\u0002\u0001\u0000\u0000\u0000\'(\u0005I\u0000\u0000()\u0005N\u0000\u0000"
                    + ")*\u0005F\u0000\u0000*+\u0005O\u0000\u0000+\u0004\u0001\u0000\u0000\u0000"
                    + ",-\u0005E\u0000\u0000-.\u0005R\u0000\u0000./\u0005R\u0000\u0000/0\u0005"
                    + "O\u0000\u000001\u0005R\u0000\u00001\u0006\u0001\u0000\u0000\u000023\u0005"
                    + "L\u0000\u000034\u0005O\u0000\u000045\u0005G\u0000\u00005\b\u0001\u0000"
                    + "\u0000\u000067\u0005W\u0000\u000078\u0005A\u0000\u000089\u0005R\u0000"
                    + "\u00009:\u0005N\u0000\u0000:;\u0005I\u0000\u0000;<\u0005N\u0000\u0000"
                    + "<=\u0005G\u0000\u0000=\n\u0001\u0000\u0000\u0000>@\u0007\u0000\u0000\u0000"
                    + "?>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000"
                    + "\u0000AB\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000CD\u0006\u0005"
                    + "\u0000\u0000D\f\u0001\u0000\u0000\u0000ES\u00050\u0000\u0000FP\u0007\u0001"
                    + "\u0000\u0000GI\u0003\u001b\r\u0000HG\u0001\u0000\u0000\u0000HI\u0001\u0000"
                    + "\u0000\u0000IQ\u0001\u0000\u0000\u0000JL\u0005_\u0000\u0000KJ\u0001\u0000"
                    + "\u0000\u0000LM\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000MN\u0001"
                    + "\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OQ\u0003\u001b\r\u0000PH\u0001"
                    + "\u0000\u0000\u0000PK\u0001\u0000\u0000\u0000QS\u0001\u0000\u0000\u0000"
                    + "RE\u0001\u0000\u0000\u0000RF\u0001\u0000\u0000\u0000SU\u0001\u0000\u0000"
                    + "\u0000TV\u0007\u0002\u0000\u0000UT\u0001\u0000\u0000\u0000UV\u0001\u0000"
                    + "\u0000\u0000V\u000e\u0001\u0000\u0000\u0000WX\u00050\u0000\u0000XY\u0007"
                    + "\u0003\u0000\u0000Ya\u0007\u0004\u0000\u0000Z\\\u0007\u0005\u0000\u0000"
                    + "[Z\u0001\u0000\u0000\u0000\\_\u0001\u0000\u0000\u0000][\u0001\u0000\u0000"
                    + "\u0000]^\u0001\u0000\u0000\u0000^`\u0001\u0000\u0000\u0000_]\u0001\u0000"
                    + "\u0000\u0000`b\u0007\u0004\u0000\u0000a]\u0001\u0000\u0000\u0000ab\u0001"
                    + "\u0000\u0000\u0000bd\u0001\u0000\u0000\u0000ce\u0007\u0002\u0000\u0000"
                    + "dc\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000e\u0010\u0001\u0000"
                    + "\u0000\u0000fj\u00050\u0000\u0000gi\u0005_\u0000\u0000hg\u0001\u0000\u0000"
                    + "\u0000il\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000jk\u0001\u0000"
                    + "\u0000\u0000km\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000mu\u0007"
                    + "\u0006\u0000\u0000np\u0007\u0007\u0000\u0000on\u0001\u0000\u0000\u0000"
                    + "ps\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000"
                    + "\u0000rt\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000tv\u0007\u0006"
                    + "\u0000\u0000uq\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vx\u0001"
                    + "\u0000\u0000\u0000wy\u0007\u0002\u0000\u0000xw\u0001\u0000\u0000\u0000"
                    + "xy\u0001\u0000\u0000\u0000y\u0012\u0001\u0000\u0000\u0000z{\u00050\u0000"
                    + "\u0000{|\u0007\b\u0000\u0000|\u0084\u0007\t\u0000\u0000}\u007f\u0007\n"
                    + "\u0000\u0000~}\u0001\u0000\u0000\u0000\u007f\u0082\u0001\u0000\u0000\u0000"
                    + "\u0080~\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081"
                    + "\u0083\u0001\u0000\u0000\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0083"
                    + "\u0085\u0007\t\u0000\u0000\u0084\u0080\u0001\u0000\u0000\u0000\u0084\u0085"
                    + "\u0001\u0000\u0000\u0000\u0085\u0087\u0001\u0000\u0000\u0000\u0086\u0088"
                    + "\u0007\u0002\u0000\u0000\u0087\u0086\u0001\u0000\u0000\u0000\u0087\u0088"
                    + "\u0001\u0000\u0000\u0000\u0088\u0014\u0001\u0000\u0000\u0000\u0089\u008a"
                    + "\u0005[\u0000\u0000\u008a\u008b\u0005A\u0000\u0000\u008b\u008c\u0005-"
                    + "\u0000\u0000\u008c\u008d\u0005Z\u0000\u0000\u008d\u008e\u0005a\u0000\u0000"
                    + "\u008e\u008f\u0005-\u0000\u0000\u008f\u0090\u0005z\u0000\u0000\u0090\u0091"
                    + "\u00050\u0000\u0000\u0091\u0092\u0005-\u0000\u0000\u0092\u0093\u00059"
                    + "\u0000\u0000\u0093\u0094\u0005]\u0000\u0000\u0094\u0016\u0001\u0000\u0000"
                    + "\u0000\u0095\u009e\u0003\u0019\f\u0000\u0096\u0099\u0003\u0019\f\u0000"
                    + "\u0097\u0099\u0005_\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0098"
                    + "\u0097\u0001\u0000\u0000\u0000\u0099\u009c\u0001\u0000\u0000\u0000\u009a"
                    + "\u0098\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b"
                    + "\u009d\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009d"
                    + "\u009f\u0003\u0019\f\u0000\u009e\u009a\u0001\u0000\u0000\u0000\u009e\u009f"
                    + "\u0001\u0000\u0000\u0000\u009f\u0018\u0001\u0000\u0000\u0000\u00a0\u00a1"
                    + "\u0007\u0004\u0000\u0000\u00a1\u001a\u0001\u0000\u0000\u0000\u00a2\u00aa"
                    + "\u0007\u000b\u0000\u0000\u00a3\u00a5\u0007\f\u0000\u0000\u00a4\u00a3\u0001"
                    + "\u0000\u0000\u0000\u00a5\u00a8\u0001\u0000\u0000\u0000\u00a6\u00a4\u0001"
                    + "\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00a9\u0001"
                    + "\u0000\u0000\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a9\u00ab\u0007"
                    + "\u000b\u0000\u0000\u00aa\u00a6\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001"
                    + "\u0000\u0000\u0000\u00ab\u001c\u0001\u0000\u0000\u0000\u00ac\u00af\u0003"
                    + "\u001f\u000f\u0000\u00ad\u00af\u0007\u000b\u0000\u0000\u00ae\u00ac\u0001"
                    + "\u0000\u0000\u0000\u00ae\u00ad\u0001\u0000\u0000\u0000\u00af\u001e\u0001"
                    + "\u0000\u0000\u0000\u00b0\u00b5\u0007\r\u0000\u0000\u00b1\u00b5\b\u000e"
                    + "\u0000\u0000\u00b2\u00b3\u0007\u000f\u0000\u0000\u00b3\u00b5\u0007\u0010"
                    + "\u0000\u0000\u00b4\u00b0\u0001\u0000\u0000\u0000\u00b4\u00b1\u0001\u0000"
                    + "\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b5 \u0001\u0000\u0000"
                    + "\u0000\u0018\u0000AHMPRU]adjqux\u0080\u0084\u0087\u0098\u009a\u009e\u00a6"
                    + "\u00aa\u00ae\u00b4\u0001\u0000\u0001\u0000";
    public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = makeLiteralNames();
    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);
    public static String[] channelNames = {"DEFAULT_TOKEN_CHANNEL", "HIDDEN"};
    public static String[] modeNames = {"DEFAULT_MODE"};

    static {
        RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION);
    }

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

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public LOGLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    private static String[] makeRuleNames() {
        return new String[]{
                "DEBUG",
                "INFO",
                "ERROR",
                "LOG",
                "WARNING",
                "WS",
                "DECIMAL_LITERAL",
                "HEX_LITERAL",
                "OCT_LITERAL",
                "BINARY_LITERAL",
                "SPACENAME",
                "HexDigits",
                "HexDigit",
                "Digits",
                "LetterOrDigit",
                "Letter"
        };
    }

    private static String[] makeLiteralNames() {
        return new String[]{
                null,
                "'DEBUG'",
                "'INFO'",
                "'ERROR'",
                "'LOG'",
                "'WARNING'",
                null,
                null,
                null,
                null,
                null,
                "'[A-Za-z0-9]'"
        };
    }

    private static String[] makeSymbolicNames() {
        return new String[]{
                null,
                "DEBUG",
                "INFO",
                "ERROR",
                "LOG",
                "WARNING",
                "WS",
                "DECIMAL_LITERAL",
                "HEX_LITERAL",
                "OCT_LITERAL",
                "BINARY_LITERAL",
                "SPACENAME"
        };
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
        return "LOG.g4";
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
    public String[] getChannelNames() {
        return channelNames;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }
}
