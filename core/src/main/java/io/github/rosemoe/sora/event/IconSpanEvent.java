package io.github.rosemoe.sora.event;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import io.github.rosemoe.sora.text.CharPosition;
import android.view.MotionEvent;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.icon.IconSpan;

public class IconSpanEvent extends Event {
  private final IconSpan iconspan;

  private final MotionEvent motionEvent;

  public IconSpanEvent(@NonNull CodeEditor editor, IconSpan iconspan, MotionEvent motionEvent) {
    super(editor);
    this.iconspan = iconspan;
    this.motionEvent = motionEvent;
  }

  @Override
  public boolean canIntercept() {
    return true;
  }

  public Drawable getIcon() {
    return iconspan.getIcon();
  }

  public int getLine() {
    return iconspan.getLine();
  }

  public int getColumn() {
    return iconspan.getColumn();
  }

  public MotionEvent getMotionEvent() {
    return motionEvent;
  }
}
