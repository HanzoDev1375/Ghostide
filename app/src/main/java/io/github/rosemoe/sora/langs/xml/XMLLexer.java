package io.github.rosemoe.sora.langs.xml;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class XMLLexer extends Lexer {
    public static final int COMMENT = 1,
            COMMENT_OPEN = 2,
            CDATA = 3,
            DTD = 4,
            EntityRef = 5,
            CharRef = 6,
            SEA_WS = 7,
            OPEN = 8,
            XMLDeclOpen = 9,
            TEXT = 10,
            CLOSE = 11,
            SPECIAL_CLOSE = 12,
            SLASH_CLOSE = 13,
            SLASH = 14,
            EQUALS = 15,
            STRING = 16,
            Name = 17,
            S = 18,
            PI = 19;
    public static final int INSIDE = 1, PROC_INSTR = 2;
    public static final String[] ruleNames = makeRuleNames();
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\u0004\u0000\u0013\u00ec\u0006\uffff\uffff\u0006\uffff\uffff\u0006\uffff"
                    + "\uffff\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002\u0007"
                    + "\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005\u0007"
                    + "\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007\b"
                    + "\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002\f\u0007"
                    + "\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f\u0002"
                    + "\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012\u0002"
                    + "\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015\u0002"
                    + "\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018\u0001"
                    + "\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005"
                    + "\u0000<\b\u0000\n\u0000\f\u0000?\t\u0000\u0001\u0000\u0001\u0000\u0001"
                    + "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"
                    + "\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"
                    + "\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005"
                    + "\u0002U\b\u0002\n\u0002\f\u0002X\t\u0002\u0001\u0002\u0001\u0002\u0001"
                    + "\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005"
                    + "\u0003b\b\u0003\n\u0003\f\u0003e\t\u0003\u0001\u0003\u0001\u0003\u0001"
                    + "\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"
                    + "\u0005\u0001\u0005\u0004\u0005q\b\u0005\u000b\u0005\f\u0005r\u0001\u0005"
                    + "\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"
                    + "\u0004\u0005|\b\u0005\u000b\u0005\f\u0005}\u0001\u0005\u0001\u0005\u0003"
                    + "\u0005\u0082\b\u0005\u0001\u0006\u0001\u0006\u0003\u0006\u0086\b\u0006"
                    + "\u0001\u0006\u0004\u0006\u0089\b\u0006\u000b\u0006\f\u0006\u008a\u0001"
                    + "\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"
                    + "\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"
                    + "\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0004\n\u00a4\b\n\u000b"
                    + "\n\f\n\u00a5\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001"
                    + "\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"
                    + "\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0005"
                    + "\u0010\u00bc\b\u0010\n\u0010\f\u0010\u00bf\t\u0010\u0001\u0010\u0001\u0010"
                    + "\u0001\u0010\u0005\u0010\u00c4\b\u0010\n\u0010\f\u0010\u00c7\t\u0010\u0001"
                    + "\u0010\u0003\u0010\u00ca\b\u0010\u0001\u0011\u0001\u0011\u0005\u0011\u00ce"
                    + "\b\u0011\n\u0011\f\u0011\u00d1\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012"
                    + "\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015"
                    + "\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u00df\b\u0015\u0001\u0016"
                    + "\u0003\u0016\u00e2\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"
                    + "\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003=Vc"
                    + "\u0000\u0019\u0003\u0001\u0005\u0002\u0007\u0003\t\u0004\u000b\u0005\r"
                    + "\u0006\u000f\u0007\u0011\b\u0013\t\u0015\u0000\u0017\n\u0019\u000b\u001b"
                    + "\f\u001d\r\u001f\u000e!\u000f#\u0010%\u0011\'\u0012)\u0000+\u0000-\u0000"
                    + "/\u00001\u00133\u0000\u0003\u0000\u0001\u0002\n\u0002\u0000\t\t  \u0002"
                    + "\u0000&&<<\u0002\u0000\"\"<<\u0002\u0000\'\'<<\u0003\u0000\t\n\r\r  \u0003"
                    + "\u000009AFaf\u0001\u000009\u0002\u0000-.__\u0003\u0000\u00b7\u00b7\u0300"
                    + "\u036f\u203f\u2040\b\u0000::AZaz\u2070\u218f\u2c00\u2fef\u3001\u8000\ud7ff"
                    + "\u8000\uf900\u8000\ufdcf\u8000\ufdf0\u8000\ufffd\u00f6\u0000\u0003\u0001"
                    + "\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001"
                    + "\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000"
                    + "\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000"
                    + "\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000"
                    + "\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000"
                    + "\u0000\u0001\u0019\u0001\u0000\u0000\u0000\u0001\u001b\u0001\u0000\u0000"
                    + "\u0000\u0001\u001d\u0001\u0000\u0000\u0000\u0001\u001f\u0001\u0000\u0000"
                    + "\u0000\u0001!\u0001\u0000\u0000\u0000\u0001#\u0001\u0000\u0000\u0000\u0001"
                    + "%\u0001\u0000\u0000\u0000\u0001\'\u0001\u0000\u0000\u0000\u00021\u0001"
                    + "\u0000\u0000\u0000\u00023\u0001\u0000\u0000\u0000\u00035\u0001\u0000\u0000"
                    + "\u0000\u0005D\u0001\u0000\u0000\u0000\u0007I\u0001\u0000\u0000\u0000\t"
                    + "]\u0001\u0000\u0000\u0000\u000bh\u0001\u0000\u0000\u0000\r\u0081\u0001"
                    + "\u0000\u0000\u0000\u000f\u0088\u0001\u0000\u0000\u0000\u0011\u008c\u0001"
                    + "\u0000\u0000\u0000\u0013\u0090\u0001\u0000\u0000\u0000\u0015\u009a\u0001"
                    + "\u0000\u0000\u0000\u0017\u00a3\u0001\u0000\u0000\u0000\u0019\u00a7\u0001"
                    + "\u0000\u0000\u0000\u001b\u00ab\u0001\u0000\u0000\u0000\u001d\u00b0\u0001"
                    + "\u0000\u0000\u0000\u001f\u00b5\u0001\u0000\u0000\u0000!\u00b7\u0001\u0000"
                    + "\u0000\u0000#\u00c9\u0001\u0000\u0000\u0000%\u00cb\u0001\u0000\u0000\u0000"
                    + "\'\u00d2\u0001\u0000\u0000\u0000)\u00d6\u0001\u0000\u0000\u0000+\u00d8"
                    + "\u0001\u0000\u0000\u0000-\u00de\u0001\u0000\u0000\u0000/\u00e1\u0001\u0000"
                    + "\u0000\u00001\u00e3\u0001\u0000\u0000\u00003\u00e8\u0001\u0000\u0000\u0000"
                    + "56\u0005<\u0000\u000067\u0005!\u0000\u000078\u0005-\u0000\u000089\u0005"
                    + "-\u0000\u00009=\u0001\u0000\u0000\u0000:<\t\u0000\u0000\u0000;:\u0001"
                    + "\u0000\u0000\u0000<?\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000"
                    + "=;\u0001\u0000\u0000\u0000>@\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000"
                    + "\u0000@A\u0005-\u0000\u0000AB\u0005-\u0000\u0000BC\u0005>\u0000\u0000"
                    + "C\u0004\u0001\u0000\u0000\u0000DE\u0005<\u0000\u0000EF\u0005!\u0000\u0000"
                    + "FG\u0005-\u0000\u0000GH\u0005-\u0000\u0000H\u0006\u0001\u0000\u0000\u0000"
                    + "IJ\u0005<\u0000\u0000JK\u0005!\u0000\u0000KL\u0005[\u0000\u0000LM\u0005"
                    + "C\u0000\u0000MN\u0005D\u0000\u0000NO\u0005A\u0000\u0000OP\u0005T\u0000"
                    + "\u0000PQ\u0005A\u0000\u0000QR\u0005[\u0000\u0000RV\u0001\u0000\u0000\u0000"
                    + "SU\t\u0000\u0000\u0000TS\u0001\u0000\u0000\u0000UX\u0001\u0000\u0000\u0000"
                    + "VW\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000WY\u0001\u0000\u0000"
                    + "\u0000XV\u0001\u0000\u0000\u0000YZ\u0005]\u0000\u0000Z[\u0005]\u0000\u0000"
                    + "[\\\u0005>\u0000\u0000\\\b\u0001\u0000\u0000\u0000]^\u0005<\u0000\u0000"
                    + "^_\u0005!\u0000\u0000_c\u0001\u0000\u0000\u0000`b\t\u0000\u0000\u0000"
                    + "a`\u0001\u0000\u0000\u0000be\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000"
                    + "\u0000ca\u0001\u0000\u0000\u0000df\u0001\u0000\u0000\u0000ec\u0001\u0000"
                    + "\u0000\u0000fg\u0005>\u0000\u0000g\n\u0001\u0000\u0000\u0000hi\u0005&"
                    + "\u0000\u0000ij\u0003%\u0011\u0000jk\u0005;\u0000\u0000k\f\u0001\u0000"
                    + "\u0000\u0000lm\u0005&\u0000\u0000mn\u0005#\u0000\u0000np\u0001\u0000\u0000"
                    + "\u0000oq\u0003+\u0014\u0000po\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000"
                    + "\u0000rp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000st\u0001\u0000"
                    + "\u0000\u0000tu\u0005;\u0000\u0000u\u0082\u0001\u0000\u0000\u0000vw\u0005"
                    + "&\u0000\u0000wx\u0005#\u0000\u0000xy\u0005x\u0000\u0000y{\u0001\u0000"
                    + "\u0000\u0000z|\u0003)\u0013\u0000{z\u0001\u0000\u0000\u0000|}\u0001\u0000"
                    + "\u0000\u0000}{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u007f"
                    + "\u0001\u0000\u0000\u0000\u007f\u0080\u0005;\u0000\u0000\u0080\u0082\u0001"
                    + "\u0000\u0000\u0000\u0081l\u0001\u0000\u0000\u0000\u0081v\u0001\u0000\u0000"
                    + "\u0000\u0082\u000e\u0001\u0000\u0000\u0000\u0083\u0089\u0007\u0000\u0000"
                    + "\u0000\u0084\u0086\u0005\r\u0000\u0000\u0085\u0084\u0001\u0000\u0000\u0000"
                    + "\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000"
                    + "\u0087\u0089\u0005\n\u0000\u0000\u0088\u0083\u0001\u0000\u0000\u0000\u0088"
                    + "\u0085\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a"
                    + "\u0088\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b"
                    + "\u0010\u0001\u0000\u0000\u0000\u008c\u008d\u0005<\u0000\u0000\u008d\u008e"
                    + "\u0001\u0000\u0000\u0000\u008e\u008f\u0006\u0007\u0000\u0000\u008f\u0012"
                    + "\u0001\u0000\u0000\u0000\u0090\u0091\u0005<\u0000\u0000\u0091\u0092\u0005"
                    + "?\u0000\u0000\u0092\u0093\u0005x\u0000\u0000\u0093\u0094\u0005m\u0000"
                    + "\u0000\u0094\u0095\u0005l\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000"
                    + "\u0096\u0097\u0003\'\u0012\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098"
                    + "\u0099\u0006\b\u0000\u0000\u0099\u0014\u0001\u0000\u0000\u0000\u009a\u009b"
                    + "\u0005<\u0000\u0000\u009b\u009c\u0005?\u0000\u0000\u009c\u009d\u0001\u0000"
                    + "\u0000\u0000\u009d\u009e\u0003%\u0011\u0000\u009e\u009f\u0001\u0000\u0000"
                    + "\u0000\u009f\u00a0\u0006\t\u0001\u0000\u00a0\u00a1\u0006\t\u0002\u0000"
                    + "\u00a1\u0016\u0001\u0000\u0000\u0000\u00a2\u00a4\b\u0001\u0000\u0000\u00a3"
                    + "\u00a2\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5"
                    + "\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6"
                    + "\u0018\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005>\u0000\u0000\u00a8\u00a9"
                    + "\u0001\u0000\u0000\u0000\u00a9\u00aa\u0006\u000b\u0003\u0000\u00aa\u001a"
                    + "\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005?\u0000\u0000\u00ac\u00ad\u0005"
                    + ">\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae\u00af\u0006\f"
                    + "\u0003\u0000\u00af\u001c\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005/\u0000"
                    + "\u0000\u00b1\u00b2\u0005>\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000"
                    + "\u00b3\u00b4\u0006\r\u0003\u0000\u00b4\u001e\u0001\u0000\u0000\u0000\u00b5"
                    + "\u00b6\u0005/\u0000\u0000\u00b6 \u0001\u0000\u0000\u0000\u00b7\u00b8\u0005"
                    + "=\u0000\u0000\u00b8\"\u0001\u0000\u0000\u0000\u00b9\u00bd\u0005\"\u0000"
                    + "\u0000\u00ba\u00bc\b\u0002\u0000\u0000\u00bb\u00ba\u0001\u0000\u0000\u0000"
                    + "\u00bc\u00bf\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000"
                    + "\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u00c0\u0001\u0000\u0000\u0000"
                    + "\u00bf\u00bd\u0001\u0000\u0000\u0000\u00c0\u00ca\u0005\"\u0000\u0000\u00c1"
                    + "\u00c5\u0005\'\u0000\u0000\u00c2\u00c4\b\u0003\u0000\u0000\u00c3\u00c2"
                    + "\u0001\u0000\u0000\u0000\u00c4\u00c7\u0001\u0000\u0000\u0000\u00c5\u00c3"
                    + "\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\u00c8"
                    + "\u0001\u0000\u0000\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000\u00c8\u00ca"
                    + "\u0005\'\u0000\u0000\u00c9\u00b9\u0001\u0000\u0000\u0000\u00c9\u00c1\u0001"
                    + "\u0000\u0000\u0000\u00ca$\u0001\u0000\u0000\u0000\u00cb\u00cf\u0003/\u0016"
                    + "\u0000\u00cc\u00ce\u0003-\u0015\u0000\u00cd\u00cc\u0001\u0000\u0000\u0000"
                    + "\u00ce\u00d1\u0001\u0000\u0000\u0000\u00cf\u00cd\u0001\u0000\u0000\u0000"
                    + "\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0&\u0001\u0000\u0000\u0000\u00d1"
                    + "\u00cf\u0001\u0000\u0000\u0000\u00d2\u00d3\u0007\u0004\u0000\u0000\u00d3"
                    + "\u00d4\u0001\u0000\u0000\u0000\u00d4\u00d5\u0006\u0012\u0004\u0000\u00d5"
                    + "(\u0001\u0000\u0000\u0000\u00d6\u00d7\u0007\u0005\u0000\u0000\u00d7*\u0001"
                    + "\u0000\u0000\u0000\u00d8\u00d9\u0007\u0006\u0000\u0000\u00d9,\u0001\u0000"
                    + "\u0000\u0000\u00da\u00df\u0003/\u0016\u0000\u00db\u00df\u0007\u0007\u0000"
                    + "\u0000\u00dc\u00df\u0003+\u0014\u0000\u00dd\u00df\u0007\b\u0000\u0000"
                    + "\u00de\u00da\u0001\u0000\u0000\u0000\u00de\u00db\u0001\u0000\u0000\u0000"
                    + "\u00de\u00dc\u0001\u0000\u0000\u0000\u00de\u00dd\u0001\u0000\u0000\u0000"
                    + "\u00df.\u0001\u0000\u0000\u0000\u00e0\u00e2\u0007\t\u0000\u0000\u00e1"
                    + "\u00e0\u0001\u0000\u0000\u0000\u00e20\u0001\u0000\u0000\u0000\u00e3\u00e4"
                    + "\u0005?\u0000\u0000\u00e4\u00e5\u0005>\u0000\u0000\u00e5\u00e6\u0001\u0000"
                    + "\u0000\u0000\u00e6\u00e7\u0006\u0017\u0003\u0000\u00e72\u0001\u0000\u0000"
                    + "\u0000\u00e8\u00e9\t\u0000\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000\u0000"
                    + "\u00ea\u00eb\u0006\u0018\u0001\u0000\u00eb4\u0001\u0000\u0000\u0000\u0013"
                    + "\u0000\u0001\u0002=Vcr}\u0081\u0085\u0088\u008a\u00a5\u00bd\u00c5\u00c9"
                    + "\u00cf\u00de\u00e1\u0005\u0005\u0001\u0000\u0003\u0000\u0000\u0005\u0002"
                    + "\u0000\u0004\u0000\u0000\u0006\u0000\u0000";
    public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = makeLiteralNames();
    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);
    public static String[] channelNames = {"DEFAULT_TOKEN_CHANNEL", "HIDDEN"};
    public static String[] modeNames = {"DEFAULT_MODE", "INSIDE", "PROC_INSTR"};

    static {
        RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION);
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

    public XMLLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    private static String[] makeRuleNames() {
        return new String[]{
                "COMMENT",
                "COMMENT_OPEN",
                "CDATA",
                "DTD",
                "EntityRef",
                "CharRef",
                "SEA_WS",
                "OPEN",
                "XMLDeclOpen",
                "SPECIAL_OPEN",
                "TEXT",
                "CLOSE",
                "SPECIAL_CLOSE",
                "SLASH_CLOSE",
                "SLASH",
                "EQUALS",
                "STRING",
                "Name",
                "S",
                "HEXDIGIT",
                "DIGIT",
                "NameChar",
                "NameStartChar",
                "PI",
                "IGNORE"
        };
    }

    private static String[] makeLiteralNames() {
        return new String[]{
                null, null, "'<!--'", null, null, null, null, null, "'<'", null, null, "'>'", null,
                "'/>'", "'/'", "'='"
        };
    }

    private static String[] makeSymbolicNames() {
        return new String[]{
                null,
                "COMMENT",
                "COMMENT_OPEN",
                "CDATA",
                "DTD",
                "EntityRef",
                "CharRef",
                "SEA_WS",
                "OPEN",
                "XMLDeclOpen",
                "TEXT",
                "CLOSE",
                "SPECIAL_CLOSE",
                "SLASH_CLOSE",
                "SLASH",
                "EQUALS",
                "STRING",
                "Name",
                "S",
                "PI"
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
        return "XMLLexer.g4";
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
