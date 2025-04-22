package io.github.rosemoe.sora.langs.yml;

// Generated from /storage/emulated/0/apk/YAMLLexer.g4 by ANTLR 4.13.1

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
public class YAMLLexer extends Lexer {
  static {
    RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION);
  }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
  public static final int STRING = 1,
      COMMENT = 2,
      TRUE = 3,
      FALSE = 4,
      NULL = 5,
      ANCHOR = 6,
      ALIAS = 7,
      NUMBER = 8,
      COLON = 9,
      DASH = 10,
      COMMA = 11,
      LBRACE = 12,
      RBRACE = 13,
      ID = 14,
      WS = 15;
  public static String[] channelNames = {"DEFAULT_TOKEN_CHANNEL", "HIDDEN"};

  public static String[] modeNames = {"DEFAULT_MODE"};

  private static String[] makeRuleNames() {
    return new String[] {
      "STRING", "COMMENT", "TRUE", "FALSE", "NULL", "ANCHOR", "ALIAS", "NUMBER", "COLON", "DASH",
      "COMMA", "LBRACE", "RBRACE", "ID", "WS"
    };
  }

  public static final String[] ruleNames = makeRuleNames();

  private static String[] makeLiteralNames() {
    return new String[] {
      null, null, null, "'true'", "'false'", null, null, null, null, "':'", "'-'", "','", "'{'",
      "'}'"
    };
  }

  private static final String[] _LITERAL_NAMES = makeLiteralNames();

  private static String[] makeSymbolicNames() {
    return new String[] {
      null, "STRING", "COMMENT", "TRUE", "FALSE", "NULL", "ANCHOR", "ALIAS", "NUMBER", "COLON",
      "DASH", "COMMA", "LBRACE", "RBRACE", "ID", "WS"
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

  public YAMLLexer(CharStream input) {
    super(input);
    _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
  }

  @Override
  public String getGrammarFileName() {
    return "YAMLLexer.g4";
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
      "\u0004\u0000\u000f\u0098\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"
          + "\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"
          + "\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"
          + "\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"
          + "\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"
          + "\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000$\b\u0000"
          + "\n\u0000\f\u0000\'\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"
          + "\u0001\u0000\u0005\u0000.\b\u0000\n\u0000\f\u00001\t\u0000\u0001\u0000"
          + "\u0003\u00004\b\u0000\u0001\u0001\u0001\u0001\u0005\u00018\b\u0001\n\u0001"
          + "\f\u0001;\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"
          + "\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"
          + "\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"
          + "\u0004\u0001\u0004\u0003\u0004O\b\u0004\u0001\u0005\u0001\u0005\u0001"
          + "\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0004\u0007X\b"
          + "\u0007\u000b\u0007\f\u0007Y\u0001\u0007\u0001\u0007\u0004\u0007^\b\u0007"
          + "\u000b\u0007\f\u0007_\u0003\u0007b\b\u0007\u0001\u0007\u0001\u0007\u0003"
          + "\u0007f\b\u0007\u0001\u0007\u0004\u0007i\b\u0007\u000b\u0007\f\u0007j"
          + "\u0003\u0007m\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"
          + "\u0004\u0007s\b\u0007\u000b\u0007\f\u0007t\u0001\u0007\u0001\u0007\u0001"
          + "\u0007\u0001\u0007\u0004\u0007{\b\u0007\u000b\u0007\f\u0007|\u0003\u0007"
          + "\u007f\b\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b"
          + "\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0005\r\u008d\b\r\n\r\f\r"
          + "\u0090\t\r\u0001\u000e\u0004\u000e\u0093\b\u000e\u000b\u000e\f\u000e\u0094"
          + "\u0001\u000e\u0001\u000e\u0000\u0000\u000f\u0001\u0001\u0003\u0002\u0005"
          + "\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n"
          + "\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u0001\u0000\u000b"
          + "\u0001\u0000\'\'\u0002\u0000\"\"\\\\\u0001\u0000\n\n\u0001\u000009\u0002"
          + "\u0000EEee\u0002\u0000++--\u0003\u000009AFaf\u0001\u000001\u0003\u0000"
          + "AZ__az\u0004\u000009AZ__az\u0003\u0000\t\n\r\r  \u00aa\u0000\u0001\u0001"
          + "\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"
          + "\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"
          + "\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"
          + "\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"
          + "\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"
          + "\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"
          + "\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"
          + "\u0000\u00013\u0001\u0000\u0000\u0000\u00035\u0001\u0000\u0000\u0000\u0005"
          + ">\u0001\u0000\u0000\u0000\u0007C\u0001\u0000\u0000\u0000\tN\u0001\u0000"
          + "\u0000\u0000\u000bP\u0001\u0000\u0000\u0000\rS\u0001\u0000\u0000\u0000"
          + "\u000f~\u0001\u0000\u0000\u0000\u0011\u0080\u0001\u0000\u0000\u0000\u0013"
          + "\u0082\u0001\u0000\u0000\u0000\u0015\u0084\u0001\u0000\u0000\u0000\u0017"
          + "\u0086\u0001\u0000\u0000\u0000\u0019\u0088\u0001\u0000\u0000\u0000\u001b"
          + "\u008a\u0001\u0000\u0000\u0000\u001d\u0092\u0001\u0000\u0000\u0000\u001f"
          + "%\u0005\'\u0000\u0000 !\u0005\'\u0000\u0000!$\u0005\'\u0000\u0000\"$\b"
          + "\u0000\u0000\u0000# \u0001\u0000\u0000\u0000#\"\u0001\u0000\u0000\u0000"
          + "$\'\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000"
          + "\u0000&(\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000(4\u0005\'"
          + "\u0000\u0000)/\u0005\"\u0000\u0000*+\u0005\\\u0000\u0000+.\t\u0000\u0000"
          + "\u0000,.\b\u0001\u0000\u0000-*\u0001\u0000\u0000\u0000-,\u0001\u0000\u0000"
          + "\u0000.1\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000\u0000/0\u0001\u0000"
          + "\u0000\u000002\u0001\u0000\u0000\u00001/\u0001\u0000\u0000\u000024\u0005"
          + "\"\u0000\u00003\u001f\u0001\u0000\u0000\u00003)\u0001\u0000\u0000\u0000"
          + "4\u0002\u0001\u0000\u0000\u000059\u0005#\u0000\u000068\b\u0002\u0000\u0000"
          + "76\u0001\u0000\u0000\u00008;\u0001\u0000\u0000\u000097\u0001\u0000\u0000"
          + "\u00009:\u0001\u0000\u0000\u0000:<\u0001\u0000\u0000\u0000;9\u0001\u0000"
          + "\u0000\u0000<=\u0006\u0001\u0000\u0000=\u0004\u0001\u0000\u0000\u0000"
          + ">?\u0005t\u0000\u0000?@\u0005r\u0000\u0000@A\u0005u\u0000\u0000AB\u0005"
          + "e\u0000\u0000B\u0006\u0001\u0000\u0000\u0000CD\u0005f\u0000\u0000DE\u0005"
          + "a\u0000\u0000EF\u0005l\u0000\u0000FG\u0005s\u0000\u0000GH\u0005e\u0000"
          + "\u0000H\b\u0001\u0000\u0000\u0000IJ\u0005n\u0000\u0000JK\u0005u\u0000"
          + "\u0000KL\u0005l\u0000\u0000LO\u0005l\u0000\u0000MO\u0005~\u0000\u0000"
          + "NI\u0001\u0000\u0000\u0000NM\u0001\u0000\u0000\u0000O\n\u0001\u0000\u0000"
          + "\u0000PQ\u0005&\u0000\u0000QR\u0003\u001b\r\u0000R\f\u0001\u0000\u0000"
          + "\u0000ST\u0005*\u0000\u0000TU\u0003\u001b\r\u0000U\u000e\u0001\u0000\u0000"
          + "\u0000VX\u0007\u0003\u0000\u0000WV\u0001\u0000\u0000\u0000XY\u0001\u0000"
          + "\u0000\u0000YW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Za\u0001"
          + "\u0000\u0000\u0000[]\u0005.\u0000\u0000\\^\u0007\u0003\u0000\u0000]\\"
          + "\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000"
          + "\u0000_`\u0001\u0000\u0000\u0000`b\u0001\u0000\u0000\u0000a[\u0001\u0000"
          + "\u0000\u0000ab\u0001\u0000\u0000\u0000bl\u0001\u0000\u0000\u0000ce\u0007"
          + "\u0004\u0000\u0000df\u0007\u0005\u0000\u0000ed\u0001\u0000\u0000\u0000"
          + "ef\u0001\u0000\u0000\u0000fh\u0001\u0000\u0000\u0000gi\u0007\u0003\u0000"
          + "\u0000hg\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000jh\u0001\u0000"
          + "\u0000\u0000jk\u0001\u0000\u0000\u0000km\u0001\u0000\u0000\u0000lc\u0001"
          + "\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000m\u007f\u0001\u0000\u0000"
          + "\u0000no\u00050\u0000\u0000op\u0005x\u0000\u0000pr\u0001\u0000\u0000\u0000"
          + "qs\u0007\u0006\u0000\u0000rq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000"
          + "\u0000tr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000u\u007f\u0001"
          + "\u0000\u0000\u0000vw\u00050\u0000\u0000wx\u0005b\u0000\u0000xz\u0001\u0000"
          + "\u0000\u0000y{\u0007\u0007\u0000\u0000zy\u0001\u0000\u0000\u0000{|\u0001"
          + "\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000"
          + "}\u007f\u0001\u0000\u0000\u0000~W\u0001\u0000\u0000\u0000~n\u0001\u0000"
          + "\u0000\u0000~v\u0001\u0000\u0000\u0000\u007f\u0010\u0001\u0000\u0000\u0000"
          + "\u0080\u0081\u0005:\u0000\u0000\u0081\u0012\u0001\u0000\u0000\u0000\u0082"
          + "\u0083\u0005-\u0000\u0000\u0083\u0014\u0001\u0000\u0000\u0000\u0084\u0085"
          + "\u0005,\u0000\u0000\u0085\u0016\u0001\u0000\u0000\u0000\u0086\u0087\u0005"
          + "{\u0000\u0000\u0087\u0018\u0001\u0000\u0000\u0000\u0088\u0089\u0005}\u0000"
          + "\u0000\u0089\u001a\u0001\u0000\u0000\u0000\u008a\u008e\u0007\b\u0000\u0000"
          + "\u008b\u008d\u0007\t\u0000\u0000\u008c\u008b\u0001\u0000\u0000\u0000\u008d"
          + "\u0090\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008e"
          + "\u008f\u0001\u0000\u0000\u0000\u008f\u001c\u0001\u0000\u0000\u0000\u0090"
          + "\u008e\u0001\u0000\u0000\u0000\u0091\u0093\u0007\n\u0000\u0000\u0092\u0091"
          + "\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094\u0092"
          + "\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0096"
          + "\u0001\u0000\u0000\u0000\u0096\u0097\u0006\u000e\u0000\u0000\u0097\u001e"
          + "\u0001\u0000\u0000\u0000\u0013\u0000#%-/39NY_aejlt|~\u008e\u0094\u0001"
          + "\u0006\u0000\u0000";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
