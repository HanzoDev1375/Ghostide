package ir.ninjacoder.prograsssheet.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
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
import ir.ninjacoder.prograsssheet.R;
import static ir.ninjacoder.prograsssheet.util.CalculationUtils.lerp;
import static ir.ninjacoder.prograsssheet.util.CalculationUtils.lerpInv;
import static ir.ninjacoder.prograsssheet.util.CalculationUtils.lerpInvSat;
import static ir.ninjacoder.prograsssheet.util.CalculationUtils.setAlphaComponent;

public class SquigglyProgress extends Drawable {

  private static final float TWO_PI = (float) (Math.PI * 2f);

  @VisibleForTesting static final int DISABLED_ALPHA = 77;

  private final Paint wavePaint = new Paint();
  private final Paint linePaint = new Paint();
  private final Path path = new Path();
  private float heightFraction = 0f;
  private ValueAnimator heightAnimator = null;
  private float phaseOffset = 0f;
  private long lastFrameTime = -1L;
  /* distance over which amplitude drops to zero, measured in wavelengths */
  private final float transitionPeriods = 1.5f;

  /* wave endpoint as percentage of bar when play position is zero */
  private final float minWaveEndpoint = 0f;

  /* wave endpoint as percentage of bar when play position matches wave endpoint */
  private final float matchedWaveEndpoint = 1f;

  // Horizontal length of the sine wave
  public float waveLength = 0f;

  // Height of each peak of the sine wave
  public float lineAmplitude = 0f;

  // Line speed in px per second
  public float phaseSpeed = 0f;

  // Progress stroke width, both for wave and solid line
  public float strokeWidth = 0f;

  public float getStrokeWidth() {
    return strokeWidth;
  }

  public void setdefaultSettring() {

    waveLength = 27f;
    lineAmplitude = 2.7f;
    phaseSpeed = 8f;
    setStrokeWidth(3.7f);
  }

  public void setStrokeWidth(float value) {
    if (strokeWidth == value) {
      return;
    }
    strokeWidth = value;
    wavePaint.setStrokeWidth(value);
    linePaint.setStrokeWidth(value);
  }

  // Enables a transition region where the amplitude of the wave is reduced linearly across it.
  public boolean transitionEnabled = true;

  public boolean isTransitionEnabled() {
    return transitionEnabled;
  }

  public void setTransitionEnabled(boolean value) {
    transitionEnabled = value;
    invalidateSelf();
  }

  public boolean animate = false;

  public boolean isAnimate() {
    return animate;
  }

  public void setAnimate(boolean value) {
    if (animate == value) {
      return;
    }
    animate = value;
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

  public SquigglyProgress() {
    wavePaint.setStrokeCap(Paint.Cap.ROUND);
    linePaint.setStrokeCap(Paint.Cap.ROUND);
    linePaint.setStyle(Paint.Style.STROKE);
    wavePaint.setStyle(Paint.Style.STROKE);
    linePaint.setAlpha(DISABLED_ALPHA);
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

    float progress = getLevel() / 10000f;
    float totalWidth = getBounds().width();
    float totalProgressPx = totalWidth * progress;
    float waveProgressPx;

    if (!transitionEnabled || progress > matchedWaveEndpoint) {
      waveProgressPx = totalWidth * progress;
    } else {
      waveProgressPx =
          totalWidth
              * lerp(
                  minWaveEndpoint, matchedWaveEndpoint, lerpInv(0f, matchedWaveEndpoint, progress));
    }

    // Build Wiggly Path
    float waveStart = -phaseOffset - waveLength / 2f;
    float waveEnd = transitionEnabled ? totalWidth : waveProgressPx;

    // helper interface for computeAmplitude function
    interface AmplitudeComputer {
      float compute(float x, float sign);
    }

    AmplitudeComputer computeAmplitude =
        (x, sign) -> {
          if (transitionEnabled) {
            float length = transitionPeriods * waveLength;
            float coeff = lerpInvSat(waveProgressPx + length / 2f, waveProgressPx - length / 2f, x);
            return sign * heightFraction * lineAmplitude * coeff;
          } else {
            return sign * heightFraction * lineAmplitude;
          }
        };

    // Reset path object to the start
    path.rewind();
    path.moveTo(waveStart, 0f);

    // Build the wave, incrementing by half the wavelength each time
    float currentX = waveStart;
    float waveSign = 1f;
    float currentAmp = computeAmplitude.compute(currentX, waveSign);
    float dist = waveLength / 2f;
    while (currentX < waveEnd) {
      waveSign = -waveSign;
      float nextX = currentX + dist;
      float midX = currentX + dist / 2;
      float nextAmp = computeAmplitude.compute(nextX, waveSign);
      path.cubicTo(midX, currentAmp, midX, nextAmp, nextX, nextAmp);
      currentAmp = nextAmp;
      currentX = nextX;
    }

    // translate to the start position of the progress bar for all draw commands
    float clipTop = lineAmplitude + strokeWidth;
    canvas.save();
    canvas.translate(getBounds().left, getBounds().centerY());

    // Draw path up to progress position
    canvas.save();
    canvas.clipRect(0f, -1f * clipTop, totalProgressPx, clipTop);
    canvas.drawPath(path, wavePaint);
    canvas.restore();

    if (transitionEnabled) {
      // If there's a smooth transition, we draw the rest of the
      // path in a different color (using different clip params)
      canvas.save();
      canvas.clipRect(totalProgressPx, -1f * clipTop, totalWidth, clipTop);
      canvas.drawPath(path, linePaint);
      canvas.restore();
    } else {
      // No transition, just draw a flat line to the end of the region.
      // The discontinuity is hidden by the progress bar thumb shape.
      canvas.drawLine(totalProgressPx, 0f, totalWidth, 0f, linePaint);
    }

    // Draw round line cap at the beginning of the wave
    float startAmp = (float) Math.cos(Math.abs(waveStart) / waveLength * TWO_PI);
    canvas.drawPoint(0f, startAmp * lineAmplitude * heightFraction, wavePaint);

    canvas.restore();
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
    updateColors(tintColor, getAlpha());
  }

  @Override
  protected boolean onLevelChange(int level) {
    return animate;
  }

  @Override
  public void setTintList(ColorStateList tint) {
    if (tint == null) {
      return;
    }
    updateColors(tint.getDefaultColor(), getAlpha());
  }

  private void updateColors(int tintColor, int alpha) {
    wavePaint.setColor(setAlphaComponent(tintColor, alpha));
    linePaint.setColor(setAlphaComponent(tintColor, (int) (DISABLED_ALPHA * (alpha / 255f))));
  }
}
