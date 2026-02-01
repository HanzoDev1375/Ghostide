package ir.ninjacoder.prograsssheet.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.animation.PathInterpolator;
import androidx.annotation.VisibleForTesting;


public class SquigglyProgress extends Drawable {

  @VisibleForTesting static final int DISABLED_ALPHA = 77;
  private static final float TWO_PI = (float) (Math.PI * 2);

  private final Paint wavePaint = new Paint();
  private final Paint linePaint = new Paint();
  private final Path path = new Path();
  private float heightFraction = 0f;
  private ValueAnimator heightAnimator;
  private float phaseOffset = 0f;
  private long lastFrameTime = -1L;

  private int mTintColor;

  private final float transitionPeriods = 1.5f;
  private final float minWaveEndpoint = 0f;
  private final float matchedWaveEndpoint = 1f;

  public float waveLength = 0f;
  public float lineAmplitude = 0f;
  public float phaseSpeed = 0f;

  private float strokeWidth = 0f;
  private boolean transitionEnabled = true;
  private boolean animate = false;

  public SquigglyProgress() {
    wavePaint.setStrokeCap(Paint.Cap.ROUND);
    linePaint.setStrokeCap(Paint.Cap.ROUND);
    linePaint.setStyle(Paint.Style.STROKE);
    wavePaint.setStyle(Paint.Style.STROKE);
    linePaint.setAlpha(DISABLED_ALPHA);
  }

  public void setStrokeWidth(float strokeWidth) {
    if (this.strokeWidth == strokeWidth) return;

    this.strokeWidth = strokeWidth;
    wavePaint.setStrokeWidth(strokeWidth);
    linePaint.setStrokeWidth(strokeWidth);
  }

  public void setTransitionEnabled(boolean transitionEnabled) {
    this.transitionEnabled = transitionEnabled;
    invalidateSelf();
  }

  public void setWaveLength(float waveLength) {
    this.waveLength = waveLength;
    invalidateSelf();
  }

  public void setLineAmplitude(float amplitude) {
    this.lineAmplitude = amplitude;
    invalidateSelf();
  }

  public void setPhaseSpeed(float phaseSpeed) {
    this.phaseSpeed = phaseSpeed;
    invalidateSelf();
  }

  public void setAnimate(boolean animate) {
    if (this.animate == animate) return;

    this.animate = animate;
    if (animate) {
      lastFrameTime = SystemClock.uptimeMillis();
    }

    if (heightAnimator != null) {
      heightAnimator.cancel();
    }

    heightAnimator = ValueAnimator.ofFloat(heightFraction, animate ? 1f : 0f);
    if (animate) {
      heightAnimator.setStartDelay(60);
      heightAnimator.setDuration(800);
      heightAnimator.setInterpolator(new PathInterpolator(0.05f, 0.7f, 0.1f, 1f));
    } else {
      heightAnimator.setDuration(550);
      heightAnimator.setInterpolator(new PathInterpolator(0f, 0f, 0f, 1f));
    }

    heightAnimator.addUpdateListener(
        animation -> {
          heightFraction = (float) animation.getAnimatedValue();
          invalidateSelf();
        });

    heightAnimator.addListener(
        new AnimatorListenerAdapter() {
          @Override
          public void onAnimationEnd(Animator animation) {
            heightAnimator = null;
          }
        });

    heightAnimator.start();
  }

  @Override
  public void draw(Canvas canvas) {
    if (animate) {
      invalidateSelf();
      long now = SystemClock.uptimeMillis();
      phaseOffset += (now - lastFrameTime) / 1000f * phaseSpeed;
      phaseOffset %= waveLength;
      lastFrameTime = now;
    }

    float progress = getLevel() / 10_000f;
    float totalWidth = getBounds().width();
    float totalProgressPx = totalWidth * progress;
    float waveProgressPx =
        totalWidth
            * (!transitionEnabled || progress > matchedWaveEndpoint
                ? progress
                : CalculationUtils.lerp(
                    minWaveEndpoint,
                    matchedWaveEndpoint,
                    CalculationUtils.lerpInv(0f, matchedWaveEndpoint, progress)));

    float waveStart = -phaseOffset - waveLength / 2f;
    float waveEnd = transitionEnabled ? totalWidth : waveProgressPx;

    path.rewind();
    path.moveTo(waveStart, 0f);

    float currentX = waveStart;
    float waveSign = 1f;
    float currentAmp = computeAmplitude(currentX, waveSign, waveProgressPx);
    float dist = waveLength / 2f;

    while (currentX < waveEnd) {
      waveSign = -waveSign;
      float nextX = currentX + dist;
      float midX = currentX + dist / 2;
      float nextAmp = computeAmplitude(nextX, waveSign, waveProgressPx);

      path.cubicTo(midX, currentAmp, midX, nextAmp, nextX, nextAmp);
      currentAmp = nextAmp;
      currentX = nextX;
    }

    float clipTop = lineAmplitude + strokeWidth;
    canvas.save();
    canvas.translate(getBounds().left, getBounds().centerY());

    canvas.save();
    canvas.clipRect(0f, -clipTop, totalProgressPx, clipTop);
    canvas.drawPath(path, wavePaint);
    canvas.restore();

    if (transitionEnabled) {
      canvas.save();
      canvas.clipRect(totalProgressPx, -clipTop, totalWidth, clipTop);
      canvas.drawPath(path, linePaint);
      canvas.restore();
    } else {
      canvas.drawLine(totalProgressPx, 0f, totalWidth, 0f, linePaint);
    }

    float startAmp = (float) Math.cos(Math.abs(waveStart) / waveLength * TWO_PI);
    canvas.drawPoint(0f, startAmp * lineAmplitude * heightFraction, wavePaint);

    canvas.restore();
  }

  private float computeAmplitude(float x, float sign, float waveProgressPx) {
    if (transitionEnabled) {
      float length = transitionPeriods * waveLength;
      float coeff =
          CalculationUtils.lerpInvSat(
              waveProgressPx + length / 2f, waveProgressPx - length / 2f, x);
      return sign * heightFraction * lineAmplitude * coeff;
    } else {
      return sign * heightFraction * lineAmplitude;
    }
  }

  @Override
  public int getOpacity() {
    return PixelFormat.TRANSLUCENT;
  }

  @Override
  public void setColorFilter(ColorFilter colorFilter) {
    wavePaint.setColorFilter(colorFilter);
    linePaint.setColorFilter(colorFilter);
  }

  @Override
  public void setAlpha(int alpha) {
    updateColors(wavePaint.getColor(), alpha);
  }

  @Override
  public int getAlpha() {
    return wavePaint.getAlpha();
  }

  @Override
  public void setTint(int tintColor) {
    mTintColor = tintColor;
    updateColors(tintColor, getAlpha());
  }

  public int getTint() {
    return mTintColor;
  }

  @Override
  protected boolean onLevelChange(int level) {
    return animate;
  }

  @Override
  public void setTintList(ColorStateList tint) {
    if (tint == null) return;
    updateColors(tint.getDefaultColor(), getAlpha());
  }

  private void updateColors(int tintColor, int alpha) {
    wavePaint.setColor(CalculationUtils.setAlphaComponent(tintColor, alpha));
    linePaint.setColor(
        CalculationUtils.setAlphaComponent(tintColor, (int) (DISABLED_ALPHA * (alpha / 255f))));
  }
}
