package io.github.rosemoe.sora.event;

import android.view.MotionEvent;
import androidx.annotation.NonNull;
import io.github.rosemoe.sora.data.LinkSpan;
import io.github.rosemoe.sora.text.CharPosition;
import io.github.rosemoe.sora.widget.CodeEditor;

public class LinkClickEvent extends Event {
  private final LinkSpan link;
  private final CharPosition position;
  private final MotionEvent motionEvent;

  public LinkClickEvent(
      @NonNull CodeEditor editor, LinkSpan link, CharPosition position, MotionEvent motionEvent) {
    super(editor);
    this.link = link;
    this.position = position;
    this.motionEvent = motionEvent;
  }

  @Override
  public boolean canIntercept() {
    return true;
  }

  public LinkSpan getLink() {
    return link;
  }

  public String getUrl() {
    return link.getUrl();
  }

  public int getLine() {
    return position.line;
  }

  public int getColumn() {
    return position.column;
  }

  public CharPosition getPosition() {
    return position;
  }

  public MotionEvent getMotionEvent() {
    return motionEvent;
  }
}
