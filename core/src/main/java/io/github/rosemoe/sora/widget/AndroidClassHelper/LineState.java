package io.github.rosemoe.sora.widget.AndroidClassHelper;
import org.antlr.v4.runtime.Lexer;

public class LineState {
  public static final int NORMAL = 0;
  public static final int INCOMPLETE = 1;
  public int state;
  public boolean hasBraces;
  public int lexerMode;

  public LineState() {
    this.state = NORMAL;
    this.hasBraces = false;
    this.lexerMode = Lexer.DEFAULT_MODE;
  }
}
