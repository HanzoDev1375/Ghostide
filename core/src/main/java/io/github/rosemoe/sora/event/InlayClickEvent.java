package io.github.rosemoe.sora.event;

import io.github.rosemoe.sora.model.Inlay;
import io.github.rosemoe.sora.text.CharPosition;
import io.github.rosemoe.sora.widget.CodeEditor;
import android.view.MotionEvent;

public class InlayClickEvent extends Event {

  private final Inlay inlay;
  private final CharPosition position;
  private final MotionEvent causingEvent;

  public InlayClickEvent(CodeEditor editor, Inlay inlay, CharPosition position, MotionEvent event) {
    super(editor);
    this.inlay = inlay;
    this.position = position;
    this.causingEvent = event;
  }

  public Inlay getInlay() {
    return inlay;
  }

  public CharPosition getPosition() {
    return position;
  }

  public MotionEvent getCausingEvent() {
    return causingEvent;
  }

  public String getInlayText() {
    return inlay.getText();
  }

  public String getInlayId() {
    return inlay.getId();
  }
}
