// Generated from ./PropertiesLexer.g4 by ANTLR 4.13.1
package io.github.rosemoe.sora.langs.properties;

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
public class PropertiesLexer extends Lexer {
  static {
    RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION);
  }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
  public static final int COMMENT = 1, NEWLINE = 2, DELIMITER = 3, CHARACTER = 4, SLASH = 5;
  public static final int INSIDE = 1, VALUE_MODE = 2;
  public static String[] channelNames = {"DEFAULT_TOKEN_CHANNEL", "HIDDEN"};

  public static String[] modeNames = {"DEFAULT_MODE", "INSIDE", "VALUE_MODE"};

  private static String[] makeRuleNames() {
    return new String[] {
      "COMMENT",
      "NEWLINE",
      "DELIMITER",
      "SLASH",
      "CHARACTER",
      "SLASH_DELIMITER",
      "SLASH_JOINT",
      "VALUE_TERM",
      "VALUE_SLASH",
      "VALUE_CHARACTER"
    };
  }

  public static final String[] ruleNames = makeRuleNames();

  private static String[] makeLiteralNames() {
    return new String[] {};
  }

  private static final String[] _LITERAL_NAMES = makeLiteralNames();

  private static String[] makeSymbolicNames() {
    return new String[] {null, "COMMENT", "NEWLINE", "DELIMITER", "CHARACTER", "SLASH"};
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

  public PropertiesLexer(CharStream input) {
    super(input);
    _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
  }

  @Override
  public String getGrammarFileName() {
    return "PropertiesLexer.g4";
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
      "\u0004\u0000\u0005L\u0006\uffff\uffff\u0006\uffff\uffff\u0006\uffff\uffff"
          + "\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002\u0007\u0002"
          + "\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005\u0007\u0005"
          + "\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007\b\u0002"
          + "\t\u0007\t\u0001\u0000\u0001\u0000\u0005\u0000\u001a\b\u0000\n\u0000\f"
          + "\u0000\u001d\t\u0000\u0001\u0001\u0004\u0001 \b\u0001\u000b\u0001\f\u0001"
          + "!\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"
          + "\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005"
          + "\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0003\u0006"
          + "5\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"
          + "\u0001\u0007\u0003\u0007=\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007"
          + "\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"
          + "\t\u0001\t\u0001\t\u0001\t\u0000\u0000\n\u0003\u0001\u0005\u0002\u0007"
          + "\u0003\t\u0005\u000b\u0004\r\u0000\u000f\u0000\u0011\u0000\u0013\u0000"
          + "\u0015\u0000\u0003\u0000\u0001\u0002\u0004\u0002\u0000!!##\u0002\u0000"
          + "\n\n\r\r\u0002\u0000::==\u0006\u0000\n\n\r\r!!##::==M\u0000\u0003\u0001"
          + "\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001"
          + "\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000"
          + "\u0000\u0000\u0001\r\u0001\u0000\u0000\u0000\u0001\u000f\u0001\u0000\u0000"
          + "\u0000\u0002\u0011\u0001\u0000\u0000\u0000\u0002\u0013\u0001\u0000\u0000"
          + "\u0000\u0002\u0015\u0001\u0000\u0000\u0000\u0003\u0017\u0001\u0000\u0000"
          + "\u0000\u0005\u001f\u0001\u0000\u0000\u0000\u0007#\u0001\u0000\u0000\u0000"
          + "\t\'\u0001\u0000\u0000\u0000\u000b,\u0001\u0000\u0000\u0000\r.\u0001\u0000"
          + "\u0000\u0000\u000f4\u0001\u0000\u0000\u0000\u0011<\u0001\u0000\u0000\u0000"
          + "\u0013C\u0001\u0000\u0000\u0000\u0015H\u0001\u0000\u0000\u0000\u0017\u001b"
          + "\u0007\u0000\u0000\u0000\u0018\u001a\b\u0001\u0000\u0000\u0019\u0018\u0001"
          + "\u0000\u0000\u0000\u001a\u001d\u0001\u0000\u0000\u0000\u001b\u0019\u0001"
          + "\u0000\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u0004\u0001"
          + "\u0000\u0000\u0000\u001d\u001b\u0001\u0000\u0000\u0000\u001e \u0007\u0001"
          + "\u0000\u0000\u001f\u001e\u0001\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000"
          + "!\u001f\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"\u0006\u0001"
          + "\u0000\u0000\u0000#$\u0007\u0002\u0000\u0000$%\u0001\u0000\u0000\u0000"
          + "%&\u0006\u0002\u0000\u0000&\b\u0001\u0000\u0000\u0000\'(\u0005\\\u0000"
          + "\u0000()\u0001\u0000\u0000\u0000)*\u0006\u0003\u0001\u0000*+\u0006\u0003"
          + "\u0002\u0000+\n\u0001\u0000\u0000\u0000,-\b\u0003\u0000\u0000-\f\u0001"
          + "\u0000\u0000\u0000./\b\u0001\u0000\u0000/0\u0001\u0000\u0000\u000001\u0006"
          + "\u0005\u0003\u000012\u0006\u0005\u0004\u00002\u000e\u0001\u0000\u0000"
          + "\u000035\u0005\r\u0000\u000043\u0001\u0000\u0000\u000045\u0001\u0000\u0000"
          + "\u000056\u0001\u0000\u0000\u000067\u0005\n\u0000\u000078\u0001\u0000\u0000"
          + "\u000089\u0006\u0006\u0003\u00009:\u0006\u0006\u0004\u0000:\u0010\u0001"
          + "\u0000\u0000\u0000;=\u0005\r\u0000\u0000<;\u0001\u0000\u0000\u0000<=\u0001"
          + "\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>?\u0005\n\u0000\u0000?@\u0001"
          + "\u0000\u0000\u0000@A\u0006\u0007\u0005\u0000AB\u0006\u0007\u0004\u0000"
          + "B\u0012\u0001\u0000\u0000\u0000CD\u0005\\\u0000\u0000DE\u0001\u0000\u0000"
          + "\u0000EF\u0006\b\u0001\u0000FG\u0006\b\u0002\u0000G\u0014\u0001\u0000"
          + "\u0000\u0000HI\b\u0001\u0000\u0000IJ\u0001\u0000\u0000\u0000JK\u0006\t"
          + "\u0003\u0000K\u0016\u0001\u0000\u0000\u0000\u0007\u0000\u0001\u0002\u001b"
          + "!4<\u0006\u0005\u0002\u0000\u0003\u0000\u0000\u0005\u0001\u0000\u0007"
          + "\u0004\u0000\u0004\u0000\u0000\u0007\u0002\u0000";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
