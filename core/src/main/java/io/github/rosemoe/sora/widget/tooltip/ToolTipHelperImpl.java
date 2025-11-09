package io.github.rosemoe.sora.widget.tooltip;

import android.view.View;

import io.github.rosemoe.sora.event.ClickEvent;
import io.github.rosemoe.sora.event.SelectionChangeEvent;
import io.github.rosemoe.sora.widget.CodeEditor;

public class ToolTipHelperImpl extends ToolTipHelper {

  private String currentMessage;

  public ToolTipHelperImpl(CodeEditor editor) {
    super(editor);

    // ثبت event handler ها در constructor
    editor.subscribeEvent(
        SelectionChangeEvent.class,
        (event, unsubscribe) -> {
          if (isShowing()) {
            dismiss();
          }
        });

    editor.subscribeEvent(
        ClickEvent.class,
        (event, unsubscribe) -> {
          if (currentMessage != null && !currentMessage.isEmpty()) {
            setText(currentMessage);
            displayWindow(event.getX(), event.getY());
            currentMessage = null; // پاک کردن پیام بعد از نمایش
          }
        });
  }

  public void showmsg(String message) {
    this.currentMessage = message;
    // پیام ذخیره می‌شود و در کلیک بعدی نمایش داده می‌شود
  }

  @Override
  public void displayWindow() {
    // این متد برای backward compatibility
    displayWindow(getEditor().getCursor().getLeftLine(), getEditor().getCursor().getLeftColumn());
  }

  public void displayWindow(float x, float y) {
    getRootView().measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
    setSize(getRootView().getMeasuredWidth(), getRootView().getMeasuredHeight());

    // محاسبه موقعیت بر اساس مختصات کلیک
    int popupX = (int) x - (getWidth() / 2);
    int popupY = (int) y - getHeight() - 20; // فاصله از مکان کلیک

    setLocationAbsolutely(popupX, popupY);
    show();
  }
}
