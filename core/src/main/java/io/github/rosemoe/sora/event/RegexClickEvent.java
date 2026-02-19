
package io.github.rosemoe.sora.event;

import io.github.rosemoe.sora.data.RegexSpan;
import io.github.rosemoe.sora.text.CharPosition;
import android.view.MotionEvent;
import io.github.rosemoe.sora.widget.CodeEditor;

public class RegexClickEvent extends Event {
  private final RegexSpan regexSpan;
  private final CharPosition position;
  private final MotionEvent causingEvent;

  public RegexClickEvent(
      CodeEditor editor, RegexSpan regexSpan, CharPosition position, MotionEvent causingEvent) {
    super(editor);
    this.regexSpan = regexSpan;
    this.position = position;
    this.causingEvent = causingEvent;
  }

  public RegexSpan getRegexSpan() {
    return regexSpan;
  }

  public CharPosition getPosition() {
    return position;
  }

  public MotionEvent getCausingEvent() {
    return causingEvent;
  }

  public String getMatchedText() {
    return regexSpan != null ? regexSpan.getMatchedText() : null;
  }
}
