package io.github.rosemoe.sora.langs.antlrlang;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;

public abstract class LexerAdaptor extends Lexer {

  /** Generic type for OPTIONS, TOKENS and CHANNELS */
  private static final int PREQUEL_CONSTRUCT = -10;

  private static final int OPTIONS_CONSTRUCT = -11;

  /**
   * Track whether we are inside of a rule and whether it is lexical parser.
   * _currentRuleType==Token.INVALID_TYPE means that we are outside of a rule. At the first sign of
   * a rule name reference and _currentRuleType==invalid, we can assume that we are starting a
   * parser rule. Similarly, seeing a token reference when not already in rule means starting a
   * token rule. The terminating ';' of a rule, flips this back to invalid type.
   *
   * <p>This is not perfect logic but works. For example, "grammar T;" means that we start and stop
   * a lexical rule for the "T;". Dangerous but works.
   *
   * <p>The whole point of this state information is to distinguish between [..arg actions..] and
   * [charsets]. Char sets can only occur in lexical rules and arg actions cannot occur.
   */
  private int _currentRuleType = Token.INVALID_TYPE;

  private boolean insideOptionsBlock = false;

  public LexerAdaptor(CharStream input) {
    super(input);
  }

  public int getCurrentRuleType() {
    return _currentRuleType;
  }

  public void setCurrentRuleType(int ruleType) {
    this._currentRuleType = ruleType;
  }

  protected void handleBeginArgument() {
    if (inLexerRule()) {
      pushMode(ANTLRv4Lexer.LexerCharSet);
      more();
    } else {
      pushMode(ANTLRv4Lexer.Argument);
    }
  }

  protected void handleEndArgument() {
    popMode();
    if (_modeStack.size() > 0) {
      setType(ANTLRv4Lexer.ARGUMENT_CONTENT);
    }
  }

  protected void handleEndAction() {
    int oldMode = _mode;
    int newMode = popMode();
    boolean isActionWithinAction =
        _modeStack.size() > 0 && newMode == ANTLRv4Lexer.TargetLanguageAction && oldMode == newMode;

    if (isActionWithinAction) {
      setType(ANTLRv4Lexer.ACTION_CONTENT);
    }
  }

  @Override
  public Token emit() {
    if ((_type == ANTLRv4Lexer.OPTIONS
            || _type == ANTLRv4Lexer.TOKENS
            || _type == ANTLRv4Lexer.CHANNELS)
        && getCurrentRuleType()
            == Token.INVALID_TYPE) { // enter prequel construct ending with an RBRACE
      setCurrentRuleType(PREQUEL_CONSTRUCT);
    } else if (_type == ANTLRv4Lexer.OPTIONS && getCurrentRuleType() == ANTLRv4Lexer.TOKEN_REF) {
      setCurrentRuleType(OPTIONS_CONSTRUCT);
    } else if (_type == ANTLRv4Lexer.RBRACE
        && getCurrentRuleType() == PREQUEL_CONSTRUCT) { // exit prequel construct
      setCurrentRuleType(Token.INVALID_TYPE);
    } else if (_type == ANTLRv4Lexer.RBRACE
        && getCurrentRuleType() == OPTIONS_CONSTRUCT) { // exit options
      setCurrentRuleType(ANTLRv4Lexer.TOKEN_REF);
    } else if (_type == ANTLRv4Lexer.AT
        && getCurrentRuleType() == Token.INVALID_TYPE) { // enter action
      setCurrentRuleType(ANTLRv4Lexer.AT);
    } else if (_type == ANTLRv4Lexer.SEMI
        && getCurrentRuleType()
            == OPTIONS_CONSTRUCT) { // ';' in options { .... }. Don't change anything.
    } else if (_type == ANTLRv4Lexer.END_ACTION
        && getCurrentRuleType() == ANTLRv4Lexer.AT) { // exit action
      setCurrentRuleType(Token.INVALID_TYPE);
    } else if (_type == ANTLRv4Lexer.ID) {
      String firstChar = _input.getText(Interval.of(_tokenStartCharIndex, _tokenStartCharIndex));
      if (Character.isUpperCase(firstChar.charAt(0))) {
        _type = ANTLRv4Lexer.TOKEN_REF;
      } else {
        _type = ANTLRv4Lexer.RULE_REF;
      }

      if (getCurrentRuleType() == Token.INVALID_TYPE) { // if outside of rule def
        setCurrentRuleType(_type); // set to inside lexer or parser rule
      }
    } else if (_type == ANTLRv4Lexer.SEMI) { // exit rule def
      setCurrentRuleType(Token.INVALID_TYPE);
    }

    return super.emit();
  }

  private boolean inLexerRule() {
    return getCurrentRuleType() == ANTLRv4Lexer.TOKEN_REF;
  }

  @SuppressWarnings("unused")
  private boolean inParserRule() { // not used, but added for clarity
    return getCurrentRuleType() == ANTLRv4Lexer.RULE_REF;
  }

  @Override
  public void reset() {
    setCurrentRuleType(Token.INVALID_TYPE);
    insideOptionsBlock = false;
    super.reset();
  }
}
