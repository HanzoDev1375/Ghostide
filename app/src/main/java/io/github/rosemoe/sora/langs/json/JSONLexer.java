// Generated from
// /storage/emulated/0/AndroidIDEProjects/Ghost-web-ide2/app/src/main/java/io/github/rosemoe/sora/langs/json/JSON.g4 by ANTLR 4.13.2
package io.github.rosemoe.sora.langs.json;

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
public class JSONLexer extends Lexer {
  static {
    RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION);
  }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
  public static final int TRUE = 1,
      FALSE = 2,
      NULL = 3,
      COLON = 4,
      STRING = 5,
      LBRACE = 6,
      RBRACE = 7,
      LBRACKET = 8,
      RBRACKET = 9,
      COMMA = 10,
      NUMBER = 11,
      WS = 12;
  public static String[] channelNames = {"DEFAULT_TOKEN_CHANNEL", "HIDDEN"};

  public static String[] modeNames = {"DEFAULT_MODE"};

  private static String[] makeRuleNames() {
    return new String[] {
      "TRUE",
      "FALSE",
      "NULL",
      "COLON",
      "STRING",
      "LBRACE",
      "RBRACE",
      "LBRACKET",
      "RBRACKET",
      "COMMA",
      "ESC",
      "UNICODE",
      "HEX",
      "SAFECODEPOINT",
      "NUMBER",
      "INT",
      "EXP",
      "WS"
    };
  }

  public static final String[] ruleNames = makeRuleNames();

  private static String[] makeLiteralNames() {
    return new String[] {
      null, "'true'", "'false'", "'null'", "':'", null, "'{'", "'}'", "'['", "']'", "','"
    };
  }

  private static final String[] _LITERAL_NAMES = makeLiteralNames();

  private static String[] makeSymbolicNames() {
    return new String[] {
      null,
      "TRUE",
      "FALSE",
      "NULL",
      "COLON",
      "STRING",
      "LBRACE",
      "RBRACE",
      "LBRACKET",
      "RBRACKET",
      "COMMA",
      "NUMBER",
      "WS"
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

  public JSONLexer(CharStream input) {
    super(input);
    _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
  }

  @Override
  public String getGrammarFileName() {
    return "JSON.g4";
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
      "\u0004\u0000\f\u0080\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"
          + "\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"
          + "\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"
          + "\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"
          + "\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"
          + "\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001"
          + "\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"
          + "\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"
          + "\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"
          + "\u0004\u0001\u0004\u0001\u0004\u0005\u0004;\b\u0004\n\u0004\f\u0004>\t"
          + "\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001"
          + "\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n"
          + "\u0001\n\u0001\n\u0003\nO\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001"
          + "\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e"
          + "\u0003\u000e\\\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0004\u000e"
          + "a\b\u000e\u000b\u000e\f\u000eb\u0003\u000ee\b\u000e\u0001\u000e\u0003"
          + "\u000eh\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000fm\b\u000f"
          + "\n\u000f\f\u000fp\t\u000f\u0003\u000fr\b\u000f\u0001\u0010\u0001\u0010"
          + "\u0003\u0010v\b\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0004\u0011"
          + "{\b\u0011\u000b\u0011\f\u0011|\u0001\u0011\u0001\u0011\u0000\u0000\u0012"
          + "\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r"
          + "\u0007\u000f\b\u0011\t\u0013\n\u0015\u0000\u0017\u0000\u0019\u0000\u001b"
          + "\u0000\u001d\u000b\u001f\u0000!\u0000#\f\u0001\u0000\b\b\u0000\"\"//\\"
          + "\\bbffnnrrtt\u0003\u000009AFaf\u0003\u0000\u0000\u001f\"\"\\\\\u0001\u0000"
          + "09\u0001\u000019\u0002\u0000EEee\u0002\u0000++--\u0003\u0000\t\n\r\r "
          + " \u0084\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"
          + "\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000"
          + "\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"
          + "\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000"
          + "\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000"
          + "\u001d\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0001%\u0001"
          + "\u0000\u0000\u0000\u0003*\u0001\u0000\u0000\u0000\u00050\u0001\u0000\u0000"
          + "\u0000\u00075\u0001\u0000\u0000\u0000\t7\u0001\u0000\u0000\u0000\u000b"
          + "A\u0001\u0000\u0000\u0000\rC\u0001\u0000\u0000\u0000\u000fE\u0001\u0000"
          + "\u0000\u0000\u0011G\u0001\u0000\u0000\u0000\u0013I\u0001\u0000\u0000\u0000"
          + "\u0015K\u0001\u0000\u0000\u0000\u0017P\u0001\u0000\u0000\u0000\u0019V"
          + "\u0001\u0000\u0000\u0000\u001bX\u0001\u0000\u0000\u0000\u001d[\u0001\u0000"
          + "\u0000\u0000\u001fq\u0001\u0000\u0000\u0000!s\u0001\u0000\u0000\u0000"
          + "#z\u0001\u0000\u0000\u0000%&\u0005t\u0000\u0000&\'\u0005r\u0000\u0000"
          + "\'(\u0005u\u0000\u0000()\u0005e\u0000\u0000)\u0002\u0001\u0000\u0000\u0000"
          + "*+\u0005f\u0000\u0000+,\u0005a\u0000\u0000,-\u0005l\u0000\u0000-.\u0005"
          + "s\u0000\u0000./\u0005e\u0000\u0000/\u0004\u0001\u0000\u0000\u000001\u0005"
          + "n\u0000\u000012\u0005u\u0000\u000023\u0005l\u0000\u000034\u0005l\u0000"
          + "\u00004\u0006\u0001\u0000\u0000\u000056\u0005:\u0000\u00006\b\u0001\u0000"
          + "\u0000\u00007<\u0005\"\u0000\u00008;\u0003\u0015\n\u00009;\u0003\u001b"
          + "\r\u0000:8\u0001\u0000\u0000\u0000:9\u0001\u0000\u0000\u0000;>\u0001\u0000"
          + "\u0000\u0000<:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=?\u0001"
          + "\u0000\u0000\u0000><\u0001\u0000\u0000\u0000?@\u0005\"\u0000\u0000@\n"
          + "\u0001\u0000\u0000\u0000AB\u0005{\u0000\u0000B\f\u0001\u0000\u0000\u0000"
          + "CD\u0005}\u0000\u0000D\u000e\u0001\u0000\u0000\u0000EF\u0005[\u0000\u0000"
          + "F\u0010\u0001\u0000\u0000\u0000GH\u0005]\u0000\u0000H\u0012\u0001\u0000"
          + "\u0000\u0000IJ\u0005,\u0000\u0000J\u0014\u0001\u0000\u0000\u0000KN\u0005"
          + "\\\u0000\u0000LO\u0007\u0000\u0000\u0000MO\u0003\u0017\u000b\u0000NL\u0001"
          + "\u0000\u0000\u0000NM\u0001\u0000\u0000\u0000O\u0016\u0001\u0000\u0000"
          + "\u0000PQ\u0005u\u0000\u0000QR\u0003\u0019\f\u0000RS\u0003\u0019\f\u0000"
          + "ST\u0003\u0019\f\u0000TU\u0003\u0019\f\u0000U\u0018\u0001\u0000\u0000"
          + "\u0000VW\u0007\u0001\u0000\u0000W\u001a\u0001\u0000\u0000\u0000XY\b\u0002"
          + "\u0000\u0000Y\u001c\u0001\u0000\u0000\u0000Z\\\u0005-\u0000\u0000[Z\u0001"
          + "\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000"
          + "]d\u0003\u001f\u000f\u0000^`\u0005.\u0000\u0000_a\u0007\u0003\u0000\u0000"
          + "`_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000"
          + "\u0000bc\u0001\u0000\u0000\u0000ce\u0001\u0000\u0000\u0000d^\u0001\u0000"
          + "\u0000\u0000de\u0001\u0000\u0000\u0000eg\u0001\u0000\u0000\u0000fh\u0003"
          + "!\u0010\u0000gf\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000h\u001e"
          + "\u0001\u0000\u0000\u0000ir\u00050\u0000\u0000jn\u0007\u0004\u0000\u0000"
          + "km\u0007\u0003\u0000\u0000lk\u0001\u0000\u0000\u0000mp\u0001\u0000\u0000"
          + "\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000or\u0001\u0000"
          + "\u0000\u0000pn\u0001\u0000\u0000\u0000qi\u0001\u0000\u0000\u0000qj\u0001"
          + "\u0000\u0000\u0000r \u0001\u0000\u0000\u0000su\u0007\u0005\u0000\u0000"
          + "tv\u0007\u0006\u0000\u0000ut\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000"
          + "\u0000vw\u0001\u0000\u0000\u0000wx\u0003\u001f\u000f\u0000x\"\u0001\u0000"
          + "\u0000\u0000y{\u0007\u0007\u0000\u0000zy\u0001\u0000\u0000\u0000{|\u0001"
          + "\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000"
          + "}~\u0001\u0000\u0000\u0000~\u007f\u0006\u0011\u0000\u0000\u007f$\u0001"
          + "\u0000\u0000\u0000\f\u0000:<N[bdgnqu|\u0001\u0006\u0000\u0000";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
