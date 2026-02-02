package ir.ninjacoder.prograsssheet.util;

import ir.ninjacoder.prograsssheet.R;
import android.view.View;
import android.os.*;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PlayerToggle extends FrameLayout {

  private boolean isPlaying = false;
  private AnimatedVectorDrawable layoutAvd, imageAvd;
  private ImageView imageView;

  private boolean isAnimating = false;
  private boolean isRotating = false;

  private Drawable ptr, rtp, str, rts;

  private final ExecutorService executor = Executors.newSingleThreadExecutor();
  private final Handler mainHandler = new Handler(Looper.getMainLooper());

  private ObjectAnimator rotateAnimation;
  private FrameLayout shapeLayout;

  private OnClickListener externalClickListener;

  private int currentShapeColor = 0xFFFFFFFF;
  private int currentIconColor = 0xFFFFFFFF;

  public PlayerToggle(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context);
  }

  public boolean isAnimating() {
    return isPlaying;
  }

  private void init(Context context) {
    shapeLayout = new FrameLayout(context);
    imageView = new ImageView(context);
    addView(shapeLayout);
    addView(imageView);
    int p = convertToPx(context, 30f);
    imageView.setPadding(p, p, p, p);

    FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) shapeLayout.getLayoutParams();
    params.setMargins(p / 4, p / 4, p / 4, p / 4);
    shapeLayout.setLayoutParams(params);
    shapeLayout.setScaleX(0.9f);
    shapeLayout.setScaleY(0.9f);
    imageView.setScaleX(0.9f);
    imageView.setScaleY(0.9f);

    rts = ContextCompat.getDrawable(context, R.drawable.round_square_avd);
    ptr = ContextCompat.getDrawable(context, R.drawable.pause_avd);
    str = ContextCompat.getDrawable(context, R.drawable.scallop_avd);
    rtp = ContextCompat.getDrawable(context, R.drawable.resume_avd);

    layoutAvd = (AnimatedVectorDrawable) rts.getConstantState().newDrawable().mutate();
    shapeLayout.setBackground(layoutAvd);

    imageAvd = (AnimatedVectorDrawable) rtp.getConstantState().newDrawable().mutate();
    imageView.setImageDrawable(imageAvd);

    super.setOnClickListener(
        v -> {
          if (!isRotating) {
            toggleAnimation();
            if (externalClickListener != null) {
              externalClickListener.onClick(v);
            }
          }
        });

    executor.execute(
        () -> {
          while (true) {
            boolean pressed = isPressed();
            mainHandler.post(
                () -> {
                  if (!isAnimating && pressed && getScaleX() != 0.9f) {
                    isAnimating = true;
                    animate()
                        .scaleX(0.9f)
                        .scaleY(0.9f)
                        .setDuration(100)
                        .withEndAction(() -> isAnimating = false)
                        .start();
                  }
                  if (!isAnimating && !pressed && getScaleX() != 1f) {
                    isAnimating = true;
                    animate()
                        .scaleX(1f)
                        .scaleY(1f)
                        .setDuration(100)
                        .withEndAction(() -> isAnimating = false)
                        .start();
                  }
                });
            try {
              Thread.sleep(30);
            } catch (InterruptedException e) {
              break;
            }
          }
        });
  }

  @Override
  public void setOnClickListener(OnClickListener l) {
    this.externalClickListener = l;
  }

  private void startContinuousRotation() {
    if (rotateAnimation != null && rotateAnimation.isRunning()) return;
    rotateAnimation = ObjectAnimator.ofFloat(shapeLayout, "rotation", 0f, 360f);
    rotateAnimation.setDuration(5000);
    rotateAnimation.setRepeatCount(ValueAnimator.INFINITE);
    rotateAnimation.setInterpolator(new LinearInterpolator());
    rotateAnimation.start();
  }

  private void stopRotation() {
    isPlaying = false;
    if (rotateAnimation != null && rotateAnimation.isRunning()) {
      rotateAnimation.cancel();
      rotateAnimation = null;
    }
    float currentRotation = shapeLayout.getRotation();
    float targetRotation = ((int) (currentRotation / 90) + 1) * 90;
    if (targetRotation > 360) targetRotation = 0;
    shapeLayout
        .animate()
        .rotation(targetRotation)
        .setDuration(600)
        .setInterpolator(new DecelerateInterpolator())
        .withEndAction(() -> isRotating = false)
        .start();
  }

  public void toggleAnimation() {
    isRotating = true;
    if (isPlaying) {
      stopAnimation();
    } else {
      startAnimation();
    }
    new Handler(Looper.getMainLooper())
        .postDelayed(
            () -> {
              isRotating = false;
            },
            300);
  }

  public void startAnimation() {
    isPlaying = true;
    layoutAvd = (AnimatedVectorDrawable) rts.getConstantState().newDrawable().mutate();
    layoutAvd.setTint(currentShapeColor);
    shapeLayout.setBackground(layoutAvd);

    imageAvd = (AnimatedVectorDrawable) rtp.getConstantState().newDrawable().mutate();
    imageAvd.setTint(currentIconColor);
    imageView.setImageDrawable(imageAvd);

    imageAvd.start();
    layoutAvd.start();
    startContinuousRotation();
  }

  public void stopAnimation() {
    isPlaying = false;
    stopRotation();

    layoutAvd = (AnimatedVectorDrawable) str.getConstantState().newDrawable().mutate();
    layoutAvd.setTint(currentShapeColor);
    shapeLayout.setBackground(layoutAvd);

    imageAvd = (AnimatedVectorDrawable) ptr.getConstantState().newDrawable().mutate();
    imageAvd.setTint(currentIconColor);
    imageView.setImageDrawable(imageAvd);

    layoutAvd.start();
    imageAvd.start();
  }

  public void setShapeColor(int color) {
    currentShapeColor = color;
    if (layoutAvd != null) layoutAvd.setTint(color);
    DrawableCompat.setTint(rts, color);
    DrawableCompat.setTint(str, color);
    ColorFilter filter = new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN);
    if (shapeLayout.getBackground() != null) shapeLayout.getBackground().setColorFilter(filter);
  }

  public void setIconColor(int color) {
    currentIconColor = color;
    if (imageAvd != null) imageAvd.setTint(color);
    DrawableCompat.setTint(rtp, color);
    DrawableCompat.setTint(ptr, color);
    ColorFilter filter = new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN);
    if (imageView.getDrawable() != null) imageView.getDrawable().setColorFilter(filter);
  }

  int convertToPx(Context context, float dp) {
    float density = context.getResources().getDisplayMetrics().density;
    return (int) (dp * density + 0.5f);
  }
}
