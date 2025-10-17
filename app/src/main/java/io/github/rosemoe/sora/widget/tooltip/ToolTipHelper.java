package io.github.rosemoe.sora.widget.tooltip;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.blankj.utilcode.util.SizeUtils;
import ir.ninjacoder.ghostide.R;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.EditorPopupWindow;

public class ToolTipHelper extends EditorPopupWindow {

  protected final TextView text;
  private CodeEditor editor;

  /**
   * Create a popup window for editor
   *
   * @param editor The editor
   * @see #FEATURE_SCROLL_AS_CONTENT
   * @see #FEATURE_SHOW_OUTSIDE_VIEW_ALLOWED
   * @see #FEATURE_HIDE_WHEN_FAST_SCROLL
   */
  public ToolTipHelper(@NonNull CodeEditor editor) {
    super(editor, getFeatureFlags());
    this.editor = editor;
    setContentView(onCreateContentView(editor.getContext()));
    this.text = onCreateTextView();
  }

  private static int getFeatureFlags() {
    return FEATURE_SCROLL_AS_CONTENT | FEATURE_SHOW_OUTSIDE_VIEW_ALLOWED;
  }

  protected View onCreateContentView(@NonNull Context context) {
    return this.text;
  }

  public void setText(String text1) {
    text.setText(text1);
  }

  public TextView onCreateTextView() {
    final var context = editor.getContext();
    final var dp4 = SizeUtils.dp2px(4);
    final var dp8 = dp4 * 2;

    final var text = new TextView(context);
    text.setBackground(createBackground());
    text.setTextColor(ContextCompat.getColor(context, R.color.Background_blue));
    text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
    text.setClickable(false);
    text.setFocusable(false);
    text.setPaddingRelative(dp8, dp4, dp8, dp4);
    text.setLayoutParams(
        new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    return text;
  }

  protected View getRootView() {
    return this.text;
  }

  public void displayWindow() {
    this.getRootView().measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
    setSize(this.getRootView().getMeasuredWidth(), this.getRootView().getMeasuredHeight());

    final var line = getEditor().getCursor().getLeftLine();
    final var column = getEditor().getCursor().getLeftColumn();
    int x = (int) ((getEditor().getOffset(line, column) - (getWidth() / 2)));
    int y = (int) (getEditor().getRowHeight() * line) - getEditor().getOffsetY() - getHeight() - 5;
    setLocationAbsolutely(x, y);
    show();
  }

  public Drawable createBackground() {
    GradientDrawable background = new GradientDrawable();
    background.setShape(GradientDrawable.RECTANGLE);
    background.setColor(0xff212121);
    background.setStroke(1, 0xffffffff);
    background.setCornerRadius(8);
    return background;
  }
}
