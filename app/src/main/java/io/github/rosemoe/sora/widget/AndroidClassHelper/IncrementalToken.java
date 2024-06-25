package io.github.rosemoe.sora.widget.AndroidClassHelper;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenSource;

public class IncrementalToken implements Token {

  protected Token token;
  protected int type;
  protected int startIndex;
  protected boolean incomplete;

  public IncrementalToken(Token token) {
    this.token = token;
    this.type = token.getType();
    this.startIndex = token.getStartIndex();
    this.incomplete = false;
  }

  @Override
  public String getText() {
    return token.getText();
  }

  @Override
  public int getType() {
    return type;
  }

  @Override
  public int getLine() {
    return token.getLine();
  }

  @Override
  public int getCharPositionInLine() {
    return token.getCharPositionInLine();
  }

  @Override
  public int getChannel() {
    return token.getChannel();
  }

  @Override
  public int getTokenIndex() {
    return token.getTokenIndex();
  }

  @Override
  public int getStartIndex() {
    return startIndex;
  }

  @Override
  public int getStopIndex() {
    return token.getStopIndex();
  }

  @Override
  public TokenSource getTokenSource() {
    return token.getTokenSource();
  }

  @Override
  public CharStream getInputStream() {
    return token.getInputStream();
  }

  @Override
  public boolean equals(Object other) {
    return token.equals(other);
  }

  @Override
  public int hashCode() {
    return token.hashCode();
  }

  @Override
  public String toString() {
    return token.toString();
  }
}
