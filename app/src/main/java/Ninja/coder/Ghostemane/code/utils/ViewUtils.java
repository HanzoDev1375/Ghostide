package Ninja.coder.Ghostemane.code.utils;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

/*
 * @return("Type Value Animator")
 * @param("Type Uinty")
 * Code by ninja coder
 */

public class ViewUtils {
  /*
   *@param (#setView -> view)
   */
  public static void expand(View v) {
    v.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    final int targetHeight = v.getMeasuredHeight();
    ValueAnimator valueAnimator = ValueAnimator.ofInt(0, targetHeight);
    valueAnimator.addUpdateListener(
        new ValueAnimator.AnimatorUpdateListener() {
          @Override
          public void onAnimationUpdate(ValueAnimator animation) {
            int height = (int) animation.getAnimatedValue();
            v.getLayoutParams().height = height;
            v.requestLayout();
          }
        });

    valueAnimator.setDuration(400);
    Animation animation = AnimationUtils.loadAnimation(v.getContext(), android.R.anim.fade_in);
    v.startAnimation(animation);
    v.getLayoutParams().height = targetHeight;
    v.setVisibility(View.VISIBLE);
    valueAnimator.start();
  }

  public static void collapse(View v) {
    final int initialHeight = v.getMeasuredHeight();

    ValueAnimator valueAnimator = ValueAnimator.ofInt(initialHeight, 0);
    valueAnimator.addUpdateListener(
        new ValueAnimator.AnimatorUpdateListener() {
          @Override
          public void onAnimationUpdate(ValueAnimator animation) {
            int height = (int) animation.getAnimatedValue();
            v.getLayoutParams().height = height;
            v.requestLayout();
          }
        });

    valueAnimator.setDuration(400);
    Animation animation = AnimationUtils.loadAnimation(v.getContext(), android.R.anim.fade_out);
    v.startAnimation(animation);
    v.getLayoutParams().height = 0;
    v.setVisibility(View.GONE);
    valueAnimator.start();
  }

  public static boolean isExpanded(View v) {
    return v.getVisibility() == View.VISIBLE;
  }

  public static boolean isCollapsed(View v) {
    return v.getVisibility() == View.GONE;
  }

  public static void rotateChevron(boolean isOpen, ImageView chevronView) {
    float startRotation = isOpen ? -90f : 0f;
    float endRotation = isOpen ? 0f : -90f;

    RotateAnimation rotateAnimation =
        new RotateAnimation(
            startRotation,
            endRotation,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f);
    rotateAnimation.setDuration(200);
    rotateAnimation.setFillAfter(true);
    chevronView.startAnimation(rotateAnimation);
  }

  public static void installLazy(View v) {
    if (!isCollapsed(v)) {
      collapse(v);
    } else {
      expand(v);
    }
  }

  // bug in app not code
}
