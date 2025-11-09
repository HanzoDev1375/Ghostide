package io.github.rosemoe.sora.langs.kotlin;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/** It throws {@link ParseException} when there is a syntax error. */
@SuppressWarnings("MissingCtor")
public final class ThrowableErrorListener extends BaseErrorListener {

  @Override
  @SuppressWarnings("LineLength")
  public void syntaxError(
      final Recognizer<?, ?> recognizer,
      final Object offendingSymbol,
      final int line,
      final int charPositionInLine,
      final String message,
      final RecognitionException exception) {
    final CommonToken offendingToken = (CommonToken) offendingSymbol;
    throw new ParseException(
        String.format(
            "Sorry, there was a parsing error.%nPlease make sure there is no syntax error in your code.%nIf you are sure that there is no syntax error, you probably found a bug in the parser rule.%nUnfortunately, we are using the parser rule developed by the Antlr4 community.%nThat means we may not be able to solve your issue.%nNonetheless, we will appreciate your bug report.%n%nHere is the details of the error:%nLine: %d%nCharacter Position in Line: %d%nOffending Token: %s%nMessage: %s",
            line, charPositionInLine, offendingToken.getText(), message));
  }
}
