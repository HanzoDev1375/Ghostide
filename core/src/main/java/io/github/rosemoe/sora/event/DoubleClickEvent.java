package io.github.rosemoe.sora.event;

import android.view.MotionEvent;

import androidx.annotation.NonNull;

import io.github.rosemoe.sora.text.CharPosition;
import io.github.rosemoe.sora.widget.CodeEditor;

/**
 * Report double click in editor. This event can be intercepted.
 *
 * @author Ghost
 */
public class DoubleClickEvent extends Event {

  private final CharPosition pos;
  private final MotionEvent event;

  public DoubleClickEvent(@NonNull CodeEditor editor, CharPosition position, MotionEvent event) {
    super(editor);
    this.pos = position;
    this.event = event;
  }

  @Override
  public boolean canIntercept() {
    return true;
  }

  public int getLine() {
    return pos.line;
  }

  public int getColumn() {
    return pos.column;
  }

  public int getIndex() {
    return pos.index;
  }

  public float getX() {
    return event.getX();
  }

  public float getY() {
    return event.getY();
  }

  /** Get original event object from Android framework */
  public MotionEvent getCausingEvent() {
    return event;
  }
}
