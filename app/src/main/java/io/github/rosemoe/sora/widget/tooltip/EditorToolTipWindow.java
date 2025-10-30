package io.github.rosemoe.sora.widget.tooltip;

import android.graphics.drawable.GradientDrawable;
import android.graphics.*;
import android.view.View;
import android.widget.*;
import androidx.annotation.NonNull;
import io.github.rosemoe.sora.event.EventReceiver;
import io.github.rosemoe.sora.event.SelectionChangeEvent;
import io.github.rosemoe.sora.event.Unsubscribe;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.EditorPopupWindow;
import io.github.rosemoe.sora.widget.EditorTouchEventHandler;
import io.github.rosemoe.sora.widget.EditorColorScheme;

public class EditorToolTipWindow extends EditorPopupWindow
    implements EventReceiver<SelectionChangeEvent> {

  private static final long DELAY = 200;
  private static final long AUTO_DISMISS_DELAY = 3000;
  private final CodeEditor mEditor;
  private TextView text;
  private final EditorTouchEventHandler mHandler;
  private Runnable delayedShowTask;
  private Runnable autoDismissTask;

  public EditorToolTipWindow(CodeEditor editor) {
    super(editor, FEATURE_SHOW_OUTSIDE_VIEW_ALLOWED);
    mEditor = editor;
    mHandler = editor.getEventHandler();
    text = new TextView(editor.getContext());
    setContentView(text);

    setSize(0, (int) (mEditor.getDpUnit() * 50));
    apply();

    editor.subscribeEvent(SelectionChangeEvent.class, this);

    setFocusable(true);
    setOutsideTouchable(true);
  }

  public void showText(String text) {
    this.text.setText(text);
  }

  @Override
  public void onReceive(SelectionChangeEvent event, Unsubscribe unsubscribe) {
    if (mHandler.hasAnyHeldHandle()) {
      return;
    }

    if (delayedShowTask != null) {
      mEditor.removeCallbacks(delayedShowTask);
      delayedShowTask = null;
    }

    if (event.isSelected()) {
      dismiss();
    } else {
      if (!isShowing()) {
        delayedShowTask =
            new Runnable() {
              @Override
              public void run() {
                if (!mHandler.hasAnyHeldHandle()
                    && !mEditor.getCursor().isSelected()
                    && mEditor.getScroller().isFinished()) {
                  displayWindow();
                }
              }
            };
        mEditor.postDelayed(delayedShowTask, DELAY);
      }
    }
  }

  private int selectTop(RectF rect) {
    int rowHeight = mEditor.getRowHeight();
    if (rect.top - rowHeight * 3 / 2F > getHeight()) {
      return (int) (rect.top - rowHeight * 3 / 2 - getHeight());
    } else {
      return (int) (rect.bottom + rowHeight / 2);
    }
  }

  public void displayWindow() {
    if (isShowing() || mEditor.getCursor().isSelected()) {
      return;
    }

    var cursor = mEditor.getCursor();
    var insertRect = mEditor.getInsertHandleDescriptor().position;
    int top = selectTop(insertRect);

    top = Math.max(0, Math.min(top, mEditor.getHeight() - getHeight() - 5));

    float handleX = mEditor.getOffset(cursor.getLeftLine(), cursor.getLeftColumn());

    int panelX = (int) handleX;
    setLocationAbsolutely(panelX, top);
    show();

    startAutoDismiss();
  }

  private void startAutoDismiss() {
    if (autoDismissTask != null) {
      mEditor.removeCallbacks(autoDismissTask);
    }

    autoDismissTask =
        new Runnable() {
          @Override
          public void run() {
            if (isShowing()) {
              dismiss();
            }
          }
        };
    mEditor.postDelayed(autoDismissTask, AUTO_DISMISS_DELAY);
  }

  private void updateBtnState() {
    text.measure(
        View.MeasureSpec.makeMeasureSpec(1000000, View.MeasureSpec.AT_MOST),
        View.MeasureSpec.makeMeasureSpec(100000, View.MeasureSpec.AT_MOST));
    setSize(Math.min(text.getMeasuredWidth(), (int) (mEditor.getDpUnit() * 230)), getHeight());
  }

  @Override
  public void show() {
    updateBtnState();
    super.show();
  }

  @Override
  public void dismiss() {
    super.dismiss();

    if (delayedShowTask != null) {
      mEditor.removeCallbacks(delayedShowTask);
      delayedShowTask = null;
    }

    if (autoDismissTask != null) {
      mEditor.removeCallbacks(autoDismissTask);
      autoDismissTask = null;
    }
  }

  private GradientDrawable post() {
    var gr = new GradientDrawable();
    gr.setColor(getThemeColor(EditorColorScheme.AUTO_COMP_PANEL_BG));
    gr.setStroke(2, getThemeColor(EditorColorScheme.AUTO_COMP_PANEL_CORNER));
    gr.setCornerRadius(45);
    return gr;
  }

  @NonNull
  protected EditorColorScheme getColorScheme() {
    return getEditor().getColorScheme();
  }

  protected int getThemeColor(int type) {
    return getColorScheme().getColor(type);
  }

  public void apply() {
    getPopup().setBackgroundDrawable(post());
  }
}
