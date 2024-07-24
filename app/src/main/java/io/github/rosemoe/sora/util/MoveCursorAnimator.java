package io.github.rosemoe.sora.util;

import android.animation.ValueAnimator;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.CursorAnimator;

public class MoveCursorAnimator extends CursorAnimator {

  private final CodeEditor editor;
  ValueAnimator animatorX;
  ValueAnimator animatorY;
  ValueAnimator animatorBgBottom;
  ValueAnimator animatorBackground;
  private float startX, startY, startSize, startBottom;
  private long lastAnimateTime;

  public MoveCursorAnimator(CodeEditor editor) {
    super(editor);
    this.editor = editor;
    animatorX = new ValueAnimator();
    animatorY = new ValueAnimator();
    animatorBackground = new ValueAnimator();
    animatorBgBottom = new ValueAnimator();
    
  }

  @Override
  public void markStartPos() {
    var line = editor.getCursor().getLeftLine();
    float[] pos = editor.mLayout.getCharLayoutOffset(line, editor.getCursor().getLeftColumn());
    startX = editor.measureTextRegionOffset() + pos[1];
    startY = pos[0];
    startSize = editor.mLayout.getRowCountForLine(line) * editor.getRowHeight();
    
    startBottom =
        editor.mLayout.getCharLayoutOffset(line, editor.getText().getColumnCount(line))[0];
  }

  @Override
  public boolean isRunning() {
    return animatorX.isRunning()
        || animatorY.isRunning()
        || animatorBackground.isRunning()
        || animatorBgBottom.isRunning();
  }

  public void cancel() {
    animatorX.cancel();
    animatorY.cancel();
    animatorBackground.cancel();
    animatorBgBottom.cancel();
  }

  @Override
  public void markEndPosAndStart() {
    if (!editor.isCursorAnimationEnabled()) {
      return;
    }
    if (isRunning()) {
      startX = (float) animatorX.getAnimatedValue();
      startY = (float) animatorY.getAnimatedValue();
      cancel();
    }
    var duration = 160;
    if (System.currentTimeMillis() - lastAnimateTime < 100) {
      return;
    }

    // موقعیت جدید مکان‌نما
    var line = editor.getCursor().getLeftLine();
    float[] pos = editor.mLayout.getCharLayoutOffset(line, editor.getCursor().getLeftColumn());

    // انیمیشن حرکت ترکیبی
    animatorX = ValueAnimator.ofFloat(startX, (pos[1] + editor.measureTextRegionOffset()));
    animatorY = ValueAnimator.ofFloat(startY, pos[0]);

    animatorX.addUpdateListener(this);
    animatorY.addUpdateListener(this);

    animatorX.setDuration(duration);
    animatorY.setDuration(duration);

    animatorX.start();
    animatorY.start();

    lastAnimateTime = System.currentTimeMillis();
  }

  @Override
  public void onAnimationUpdate(ValueAnimator animation) {
    editor.postInvalidateOnAnimation();
  }
}
