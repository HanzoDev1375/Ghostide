package io.github.rosemoe.sora.widget;

import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;

/** Enhanced cursor animator with multiple animation modes */
public class CursorAnimator implements ValueAnimator.AnimatorUpdateListener {

  public enum AnimationMode {
    /** Classic smooth movement animation */
    SMOOTH,
    /** Animation with scaling effect */
    SCALE,
    /** Spring-like animation with overshoot effect */
    SPRING
  }

  protected final CodeEditor editor;
  protected ValueAnimator animatorX;
  protected ValueAnimator animatorY;
  protected ValueAnimator animatorBgBottom;
  protected ValueAnimator animatorBackground;
  protected ValueAnimator animatorScale;

  protected float startX, startY, startSize, startBottom;
  protected long lastAnimateTime;
  protected float currentScale = 1f;
  protected AnimationMode animationMode = AnimationMode.SPRING;

  public CursorAnimator(CodeEditor editor) {
    this.editor = editor;
    animatorX = new ValueAnimator();
    animatorY = new ValueAnimator();
    animatorBackground = new ValueAnimator();
    animatorBgBottom = new ValueAnimator();
    animatorScale = new ValueAnimator();
  }

  public void setAnimationMode(AnimationMode mode) {
    this.animationMode = mode;
  }

  public AnimationMode getAnimationMode() {
    return animationMode;
  }

  public void markStartPos() {
    var line = editor.getCursor().getLeftLine();
    float[] pos = editor.mLayout.getCharLayoutOffset(line, editor.getCursor().getLeftColumn());
    startX = editor.measureTextRegionOffset() + pos[1];
    startY = pos[0];
    startSize = editor.mLayout.getRowCountForLine(line) * editor.getRowHeight();
    startBottom =
        editor.mLayout.getCharLayoutOffset(line, editor.getText().getColumnCount(line))[0];
    currentScale = 1f;
  }

  public boolean isRunning() {
    return animatorX.isRunning()
        || animatorY.isRunning()
        || animatorBackground.isRunning()
        || animatorBgBottom.isRunning()
        || animatorScale.isRunning();
  }

  public void cancel() {
    animatorX.cancel();
    animatorY.cancel();
    animatorBackground.cancel();
    animatorBgBottom.cancel();
    animatorScale.cancel();
  }

  public void markEndPosAndStart() {
    if (!editor.isCursorAnimationEnabled()) {
      return;
    }

    if (isRunning()) {
      startX = (float) animatorX.getAnimatedValue();
      startY = (float) animatorY.getAnimatedValue();
      startSize = (float) animatorBackground.getAnimatedValue();
      startBottom = (float) animatorBgBottom.getAnimatedValue();
      cancel();
    }

    if (System.currentTimeMillis() - lastAnimateTime < 100) {
      return;
    }

    var line = editor.getCursor().getLeftLine();
    animatorX.removeAllUpdateListeners();
    float[] pos =
        editor.mLayout.getCharLayoutOffset(
            editor.getCursor().getLeftLine(), editor.getCursor().getLeftColumn());

    float targetX = pos[1] + editor.measureTextRegionOffset();
    float targetY = pos[0];

    // Common setup for position animators
    animatorX = ValueAnimator.ofFloat(startX, targetX);
    animatorY = ValueAnimator.ofFloat(startY, targetY);
    animatorBackground =
        ValueAnimator.ofFloat(
            startSize,
            editor.mLayout.getRowCountForLine(editor.getCursor().getLeftLine())
                * editor.getRowHeight());
    animatorBgBottom =
        ValueAnimator.ofFloat(
            startBottom,
            editor.mLayout.getCharLayoutOffset(line, editor.getText().getColumnCount(line))[0]);

    // Configure based on animation mode
    switch (animationMode) {
      case SCALE:
        configureScaleAnimation(targetX, targetY);
        break;
      case SPRING:
        configureSpringAnimation();
        break;
      case SMOOTH:
      default:
        configureSmoothAnimation();
        break;
    }

    animatorX.addUpdateListener(this);

    int duration = animationMode == AnimationMode.SPRING ? 220 : 160;
    animatorX.setDuration(duration);
    animatorY.setDuration(duration);
    animatorBackground.setDuration(duration);
    animatorBgBottom.setDuration(duration);

    animatorX.start();
    animatorY.start();
    animatorBackground.start();
    animatorBgBottom.start();

    if (animationMode == AnimationMode.SCALE) {
      animatorScale.start();
    }

    lastAnimateTime = System.currentTimeMillis();
  }

  private void configureSmoothAnimation() {
    animatorX.setInterpolator(new DecelerateInterpolator());
    animatorY.setInterpolator(new DecelerateInterpolator());
    animatorBackground.setInterpolator(new DecelerateInterpolator());
    animatorBgBottom.setInterpolator(new DecelerateInterpolator());
  }

  private void configureSpringAnimation() {
    animatorX.setInterpolator(new OvershootInterpolator(1.5f));
    animatorY.setInterpolator(new OvershootInterpolator(1.5f));
    animatorBackground.setInterpolator(new OvershootInterpolator(1.2f));
    animatorBgBottom.setInterpolator(new OvershootInterpolator(1.2f));
  }

  private void configureScaleAnimation(float targetX, float targetY) {
    float distance = (float) Math.hypot(targetX - startX, targetY - startY);
    float maxScale = Math.min(1.8f, 1f + distance / (editor.getRowHeight() * 2));

    animatorScale = ValueAnimator.ofFloat(1f, maxScale, 1f);
    animatorScale.setInterpolator(new DecelerateInterpolator());
    animatorScale.setDuration(200);
    animatorScale.addUpdateListener(
        animation -> {
          currentScale = (float) animation.getAnimatedValue();
        });

    animatorX.setInterpolator(new LinearInterpolator());
    animatorY.setInterpolator(new LinearInterpolator());
    animatorBackground.setInterpolator(new LinearInterpolator());
    animatorBgBottom.setInterpolator(new LinearInterpolator());
  }

  @Override
  public void onAnimationUpdate(ValueAnimator animation) {
    editor.postInvalidateOnAnimation();
  }
}
