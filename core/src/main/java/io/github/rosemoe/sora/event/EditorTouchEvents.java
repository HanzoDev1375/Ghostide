package io.github.rosemoe.sora.event;

import android.view.MotionEvent;
import io.github.rosemoe.sora.widget.CodeEditor;

public class EditorTouchEvents extends Event {
  private final CodeEditor editor;
  private final MotionEvent event;

  public EditorTouchEvents(CodeEditor editor, MotionEvent event) {
    super(editor);
    this.editor = editor;
    this.event = event;
  }

  @Override
  public boolean canIntercept() {
    return true;
  }

  public CodeEditor getEditor() {
    return this.editor;
  }

  public MotionEvent getEvent() {
    return this.event;
  }
}

/*
float x = event.getX();
        float y = event.getY();

        if (event.getAction() == MotionEvent.ACTION_DOWN && minimaps.contains(x, y)) {
            minimaps.handleTouch(x, y);
            return true;
        }
*/
