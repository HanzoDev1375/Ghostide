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
      "ESC",
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
      "\u0004\u0000\u0010\u008e\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"
          + "\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"
          + "\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"
          + "\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"
          + "\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"
          + "\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000"
          + "\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"
          + "\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"
          + "\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"
          + "\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"
          + "\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"
          + "\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"
          + "\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"
          + "\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007"
          + "U\b\u0007\n\u0007\f\u0007X\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"
          + "\b\u0001\b\u0001\t\u0001\t\u0005\ta\b\t\n\t\f\td\t\t\u0001\n\u0004\ng"
          + "\b\n\u000b\n\f\nh\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001"
          + "\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"
          + "\u0005\u000fx\b\u000f\n\u000f\f\u000f{\t\u000f\u0001\u0010\u0001\u0010"
          + "\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010"
          + "\u0084\b\u0010\n\u0010\f\u0010\u0087\t\u0010\u0001\u0010\u0001\u0010\u0001"
          + "\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0085\u0000\u0011\u0001"
          + "\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"
          + "\u000f\b\u0011\u0000\u0013\t\u0015\n\u0017\u000b\u0019\f\u001b\r\u001d"
          + "\u000e\u001f\u000f!\u0010\u0001\u0000\u0006\u0002\u0000\"\"\\\\\b\u0000"
          + "\"\"//\\\\bbffnnrrtt\u0003\u0000AZ__az\u0004\u000009AZ__az\u0003\u0000"
          + "\t\n\r\r  \u0003\u000009AFaf\u0092\u0000\u0001\u0001\u0000\u0000\u0000"
          + "\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"
          + "\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"
          + "\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"
          + "\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"
          + "\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"
          + "\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"
          + "\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"
          + "\u0000\u0000\u0000\u0001#\u0001\u0000\u0000\u0000\u0003(\u0001\u0000\u0000"
          + "\u0000\u0005/\u0001\u0000\u0000\u0000\u00077\u0001\u0000\u0000\u0000\t"
          + "=\u0001\u0000\u0000\u0000\u000bC\u0001\u0000\u0000\u0000\rI\u0001\u0000"
          + "\u0000\u0000\u000fQ\u0001\u0000\u0000\u0000\u0011[\u0001\u0000\u0000\u0000"
          + "\u0013^\u0001\u0000\u0000\u0000\u0015f\u0001\u0000\u0000\u0000\u0017l"
          + "\u0001\u0000\u0000\u0000\u0019n\u0001\u0000\u0000\u0000\u001bp\u0001\u0000"
          + "\u0000\u0000\u001ds\u0001\u0000\u0000\u0000\u001fu\u0001\u0000\u0000\u0000"
          + "!|\u0001\u0000\u0000\u0000#$\u0005<\u0000\u0000$%\u0005s\u0000\u0000%"
          + "&\u0005v\u0000\u0000&\'\u0005g\u0000\u0000\'\u0002\u0001\u0000\u0000\u0000"
          + "()\u0005<\u0000\u0000)*\u0005/\u0000\u0000*+\u0005s\u0000\u0000+,\u0005"
          + "v\u0000\u0000,-\u0005g\u0000\u0000-.\u0005>\u0000\u0000.\u0004\u0001\u0000"
          + "\u0000\u0000/0\u0005<\u0000\u000001\u0005c\u0000\u000012\u0005i\u0000"
          + "\u000023\u0005r\u0000\u000034\u0005c\u0000\u000045\u0005l\u0000\u0000"
          + "56\u0005e\u0000\u00006\u0006\u0001\u0000\u0000\u000078\u0005<\u0000\u0000"
          + "89\u0005r\u0000\u00009:\u0005e\u0000\u0000:;\u0005c\u0000\u0000;<\u0005"
          + "t\u0000\u0000<\b\u0001\u0000\u0000\u0000=>\u0005<\u0000\u0000>?\u0005"
          + "l\u0000\u0000?@\u0005i\u0000\u0000@A\u0005n\u0000\u0000AB\u0005e\u0000"
          + "\u0000B\n\u0001\u0000\u0000\u0000CD\u0005<\u0000\u0000DE\u0005t\u0000"
          + "\u0000EF\u0005e\u0000\u0000FG\u0005x\u0000\u0000GH\u0005t\u0000\u0000"
          + "H\f\u0001\u0000\u0000\u0000IJ\u0005<\u0000\u0000JK\u0005/\u0000\u0000"
          + "KL\u0005t\u0000\u0000LM\u0005e\u0000\u0000MN\u0005x\u0000\u0000NO\u0005"
          + "t\u0000\u0000OP\u0005>\u0000\u0000P\u000e\u0001\u0000\u0000\u0000QV\u0005"
          + "\"\u0000\u0000RU\u0003\u0011\b\u0000SU\b\u0000\u0000\u0000TR\u0001\u0000"
          + "\u0000\u0000TS\u0001\u0000\u0000\u0000UX\u0001\u0000\u0000\u0000VT\u0001"
          + "\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WY\u0001\u0000\u0000\u0000"
          + "XV\u0001\u0000\u0000\u0000YZ\u0005\"\u0000\u0000Z\u0010\u0001\u0000\u0000"
          + "\u0000[\\\u0005\\\u0000\u0000\\]\u0007\u0001\u0000\u0000]\u0012\u0001"
          + "\u0000\u0000\u0000^b\u0007\u0002\u0000\u0000_a\u0007\u0003\u0000\u0000"
          + "`_\u0001\u0000\u0000\u0000ad\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000"
          + "\u0000bc\u0001\u0000\u0000\u0000c\u0014\u0001\u0000\u0000\u0000db\u0001"
          + "\u0000\u0000\u0000eg\u0007\u0004\u0000\u0000fe\u0001\u0000\u0000\u0000"
          + "gh\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000"
          + "\u0000ij\u0001\u0000\u0000\u0000jk\u0006\n\u0000\u0000k\u0016\u0001\u0000"
          + "\u0000\u0000lm\u0005<\u0000\u0000m\u0018\u0001\u0000\u0000\u0000no\u0005"
          + ">\u0000\u0000o\u001a\u0001\u0000\u0000\u0000pq\u0005/\u0000\u0000qr\u0005"
          + ">\u0000\u0000r\u001c\u0001\u0000\u0000\u0000st\u0005=\u0000\u0000t\u001e"
          + "\u0001\u0000\u0000\u0000uy\u0005#\u0000\u0000vx\u0007\u0005\u0000\u0000"
          + "wv\u0001\u0000\u0000\u0000x{\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000"
          + "\u0000yz\u0001\u0000\u0000\u0000z \u0001\u0000\u0000\u0000{y\u0001\u0000"
          + "\u0000\u0000|}\u0005<\u0000\u0000}~\u0005-\u0000\u0000~\u007f\u0005!\u0000"
          + "\u0000\u007f\u0080\u0005-\u0000\u0000\u0080\u0081\u0005 \u0000\u0000\u0081"
          + "\u0085\u0001\u0000\u0000\u0000\u0082\u0084\t\u0000\u0000\u0000\u0083\u0082"
          + "\u0001\u0000\u0000\u0000\u0084\u0087\u0001\u0000\u0000\u0000\u0085\u0086"
          + "\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0086\u0088"
          + "\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0088\u0089"
          + "\u0005-\u0000\u0000\u0089\u008a\u0005-\u0000\u0000\u008a\u008b\u0005>"
          + "\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008d\u0006\u0010"
          + "\u0000\u0000\u008d\"\u0001\u0000\u0000\u0000\u0007\u0000TVbhy\u0085\u0001"
          + "\u0006\u0000\u0000";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
