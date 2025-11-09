package io.github.rosemoe.sora.langs.kotlin;

public final class ParseException extends RuntimeException {

  /** Please do not use the @Serial annotation because it is not supported in JDK 11. */
  private static final long serialVersionUID = 2475260797198183501L;

  /**
   * Constructor.
   *
   * @param message Error message.
   */
  public ParseException(final String message) {
    super(message);
  }
}
