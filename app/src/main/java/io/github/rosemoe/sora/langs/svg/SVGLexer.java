// Generated from /storage/emulated/0/AndroidIDEProjects/Ghost-web-ide/grammars-v4/SVG.g4 by ANTLR
// 4.13.1
package io.github.rosemoe.sora.langs.svg;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({
  "all",
  "warnings",
  "unchecked",
  "unused",
  "cast",
  "CheckReturnValue",
  "this-escape"
})
public class SVGLexer extends Lexer {
  static {
    RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION);
  }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
  public static final int T__0 = 1,
      T__1 = 2,
      T__2 = 3,
      T__3 = 4,
      T__4 = 5,
      T__5 = 6,
      T__6 = 7,
      STRING = 8,
      NAME = 9,
      WS = 10,
      SYIN = 11,
      SYMIN = 12,
      SYOU = 13,
      ASSES = 14,
      HEXCOLOR = 15,
      Comment = 16;
  public static String[] channelNames = {"DEFAULT_TOKEN_CHANNEL", "HIDDEN"};

  public static String[] modeNames = {"DEFAULT_MODE"};

  private static String[] makeRuleNames() {
    return new String[] {
      "T__0",
      "T__1",
      "T__2",
      "T__3",
      "T__4",
      "T__5",
      "T__6",
      "STRING",
      "NAME",
      "WS",
      "SYIN",
      "SYMIN",
      "SYOU",
      "ASSES",
      "HEXCOLOR",
      "Comment",
      "LetterOrDigit",
      "Letter",
      "HexDigit"
    };
  }

  public static final String[] ruleNames = makeRuleNames();

  private static String[] makeLiteralNames() {
    return new String[] {
      null,
      "'<svg'",
      "'</svg>'",
      "'<circle'",
      "'<rect'",
      "'<line'",
      "'<text'",
      "'</text>'",
      null,
      null,
      null,
      "'<'",
      "'>'",
      "'/>'",
      "'='"
    };
  }

  private static final String[] _LITERAL_NAMES = makeLiteralNames();

  private static String[] makeSymbolicNames() {
    return new String[] {
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      "STRING",
      "NAME",
      "WS",
      "SYIN",
      "SYMIN",
      "SYOU",
      "ASSES",
      "HEXCOLOR",
      "Comment"
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

  public SVGLexer(CharStream input) {
    super(input);
    _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
  }

  @Override
  public String getGrammarFileName() {
    return "SVG.g4";
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

  public static final String _serializedATN =
      "\u0004\u0000\u0010\u00a2\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"
          + "\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"
          + "\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"
          + "\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"
          + "\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"
          + "\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"
          + "\u0002\u0012\u0007\u0012\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"
          + "\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"
          + "\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"
          + "\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"
          + "\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"
          + "\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"
          + "\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"
          + "\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"
          + "\u0001\u0007\u0001\u0007\u0005\u0007X\b\u0007\n\u0007\f\u0007[\t\u0007"
          + "\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007`\b\u0007\n\u0007\f\u0007"
          + "c\t\u0007\u0001\u0007\u0003\u0007f\b\u0007\u0001\b\u0001\b\u0005\bj\b"
          + "\b\n\b\f\bm\t\b\u0001\t\u0004\tp\b\t\u000b\t\f\tq\u0001\t\u0001\t\u0001"
          + "\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001"
          + "\r\u0001\u000e\u0001\u000e\u0004\u000e\u0081\b\u000e\u000b\u000e\f\u000e"
          + "\u0082\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"
          + "\u000f\u0001\u000f\u0005\u000f\u008c\b\u000f\n\u000f\f\u000f\u008f\t\u000f"
          + "\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"
          + "\u0001\u0010\u0001\u0010\u0003\u0010\u0099\b\u0010\u0001\u0011\u0001\u0011"
          + "\u0001\u0011\u0001\u0011\u0003\u0011\u009f\b\u0011\u0001\u0012\u0001\u0012"
          + "\u0001\u008d\u0000\u0013\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"
          + "\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017"
          + "\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0000#\u0000%\u0000\u0001"
          + "\u0000\t\u0002\u0000\"\"<<\u0002\u0000\'\'<<\u0003\u0000\t\n\f\r  \u0001"
          + "\u000009\u0004\u0000$$AZ__az\u0002\u0000\u0000\u007f\u8000\ud800\u8000"
          + "\udbff\u0001\u0000\u8000\ud800\u8000\udbff\u0001\u0000\u8000\udc00\u8000"
          + "\udfff\u0003\u000009AFaf\u00a8\u0000\u0001\u0001\u0000\u0000\u0000\u0000"
          + "\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"
          + "\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"
          + "\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"
          + "\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"
          + "\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"
          + "\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"
          + "\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001"
          + "\u0000\u0000\u0000\u0001\'\u0001\u0000\u0000\u0000\u0003,\u0001\u0000"
          + "\u0000\u0000\u00053\u0001\u0000\u0000\u0000\u0007;\u0001\u0000\u0000\u0000"
          + "\tA\u0001\u0000\u0000\u0000\u000bG\u0001\u0000\u0000\u0000\rM\u0001\u0000"
          + "\u0000\u0000\u000fe\u0001\u0000\u0000\u0000\u0011g\u0001\u0000\u0000\u0000"
          + "\u0013o\u0001\u0000\u0000\u0000\u0015u\u0001\u0000\u0000\u0000\u0017w"
          + "\u0001\u0000\u0000\u0000\u0019y\u0001\u0000\u0000\u0000\u001b|\u0001\u0000"
          + "\u0000\u0000\u001d~\u0001\u0000\u0000\u0000\u001f\u0084\u0001\u0000\u0000"
          + "\u0000!\u0098\u0001\u0000\u0000\u0000#\u009e\u0001\u0000\u0000\u0000%"
          + "\u00a0\u0001\u0000\u0000\u0000\'(\u0005<\u0000\u0000()\u0005s\u0000\u0000"
          + ")*\u0005v\u0000\u0000*+\u0005g\u0000\u0000+\u0002\u0001\u0000\u0000\u0000"
          + ",-\u0005<\u0000\u0000-.\u0005/\u0000\u0000./\u0005s\u0000\u0000/0\u0005"
          + "v\u0000\u000001\u0005g\u0000\u000012\u0005>\u0000\u00002\u0004\u0001\u0000"
          + "\u0000\u000034\u0005<\u0000\u000045\u0005c\u0000\u000056\u0005i\u0000"
          + "\u000067\u0005r\u0000\u000078\u0005c\u0000\u000089\u0005l\u0000\u0000"
          + "9:\u0005e\u0000\u0000:\u0006\u0001\u0000\u0000\u0000;<\u0005<\u0000\u0000"
          + "<=\u0005r\u0000\u0000=>\u0005e\u0000\u0000>?\u0005c\u0000\u0000?@\u0005"
          + "t\u0000\u0000@\b\u0001\u0000\u0000\u0000AB\u0005<\u0000\u0000BC\u0005"
          + "l\u0000\u0000CD\u0005i\u0000\u0000DE\u0005n\u0000\u0000EF\u0005e\u0000"
          + "\u0000F\n\u0001\u0000\u0000\u0000GH\u0005<\u0000\u0000HI\u0005t\u0000"
          + "\u0000IJ\u0005e\u0000\u0000JK\u0005x\u0000\u0000KL\u0005t\u0000\u0000"
          + "L\f\u0001\u0000\u0000\u0000MN\u0005<\u0000\u0000NO\u0005/\u0000\u0000"
          + "OP\u0005t\u0000\u0000PQ\u0005e\u0000\u0000QR\u0005x\u0000\u0000RS\u0005"
          + "t\u0000\u0000ST\u0005>\u0000\u0000T\u000e\u0001\u0000\u0000\u0000UY\u0005"
          + "\"\u0000\u0000VX\b\u0000\u0000\u0000WV\u0001\u0000\u0000\u0000X[\u0001"
          + "\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000"
          + "Z\\\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000\\f\u0005\"\u0000"
          + "\u0000]a\u0005\'\u0000\u0000^`\b\u0001\u0000\u0000_^\u0001\u0000\u0000"
          + "\u0000`c\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000"
          + "\u0000\u0000bd\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000df\u0005"
          + "\'\u0000\u0000eU\u0001\u0000\u0000\u0000e]\u0001\u0000\u0000\u0000f\u0010"
          + "\u0001\u0000\u0000\u0000gk\u0003#\u0011\u0000hj\u0003!\u0010\u0000ih\u0001"
          + "\u0000\u0000\u0000jm\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000"
          + "kl\u0001\u0000\u0000\u0000l\u0012\u0001\u0000\u0000\u0000mk\u0001\u0000"
          + "\u0000\u0000np\u0007\u0002\u0000\u0000on\u0001\u0000\u0000\u0000pq\u0001"
          + "\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000"
          + "rs\u0001\u0000\u0000\u0000st\u0006\t\u0000\u0000t\u0014\u0001\u0000\u0000"
          + "\u0000uv\u0005<\u0000\u0000v\u0016\u0001\u0000\u0000\u0000wx\u0005>\u0000"
          + "\u0000x\u0018\u0001\u0000\u0000\u0000yz\u0005/\u0000\u0000z{\u0005>\u0000"
          + "\u0000{\u001a\u0001\u0000\u0000\u0000|}\u0005=\u0000\u0000}\u001c\u0001"
          + "\u0000\u0000\u0000~\u0080\u0005#\u0000\u0000\u007f\u0081\u0003%\u0012"
          + "\u0000\u0080\u007f\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000"
          + "\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000"
          + "\u0000\u0083\u001e\u0001\u0000\u0000\u0000\u0084\u0085\u0005<\u0000\u0000"
          + "\u0085\u0086\u0005-\u0000\u0000\u0086\u0087\u0005!\u0000\u0000\u0087\u0088"
          + "\u0005-\u0000\u0000\u0088\u0089\u0005 \u0000\u0000\u0089\u008d\u0001\u0000"
          + "\u0000\u0000\u008a\u008c\t\u0000\u0000\u0000\u008b\u008a\u0001\u0000\u0000"
          + "\u0000\u008c\u008f\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000"
          + "\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008e\u0090\u0001\u0000\u0000"
          + "\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u0090\u0091\u0005-\u0000\u0000"
          + "\u0091\u0092\u0005-\u0000\u0000\u0092\u0093\u0005>\u0000\u0000\u0093\u0094"
          + "\u0001\u0000\u0000\u0000\u0094\u0095\u0006\u000f\u0001\u0000\u0095 \u0001"
          + "\u0000\u0000\u0000\u0096\u0099\u0003#\u0011\u0000\u0097\u0099\u0007\u0003"
          + "\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0098\u0097\u0001\u0000"
          + "\u0000\u0000\u0099\"\u0001\u0000\u0000\u0000\u009a\u009f\u0007\u0004\u0000"
          + "\u0000\u009b\u009f\b\u0005\u0000\u0000\u009c\u009d\u0007\u0006\u0000\u0000"
          + "\u009d\u009f\u0007\u0007\u0000\u0000\u009e\u009a\u0001\u0000\u0000\u0000"
          + "\u009e\u009b\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000"
          + "\u009f$\u0001\u0000\u0000\u0000\u00a0\u00a1\u0007\b\u0000\u0000\u00a1"
          + "&\u0001\u0000\u0000\u0000\n\u0000Yaekq\u0082\u008d\u0098\u009e\u0002\u0000"
          + "\u0001\u0000\u0006\u0000\u0000";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
