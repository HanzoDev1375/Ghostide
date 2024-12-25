package ir.ninjacoder.ghostide.utils;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.*;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.graphics.ColorUtils;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.blankj.utilcode.util.ThreadUtils;

import java.util.Timer;
import java.util.TimerTask;

public class AnimUtils {
  private static TimerTask timer;
  private static Timer _timer = new Timer();
  private static int ic = 0;

  public static void Bounce(View view) {
    ObjectAnimator anim = ObjectAnimator.ofFloat(view, "ScaleY", 0, 1);
    anim.setInterpolator(new BounceInterpolator());
    anim.setDuration(1000);
    anim.start();
  }

  public static void ResultCd(View view) {
    RotateAnimation rotateAnimation =
        new RotateAnimation(
            360, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
    rotateAnimation.setInterpolator(new AccelerateInterpolator());
    rotateAnimation.setDuration(3000);
    view.startAnimation(rotateAnimation);
  }

  public static void Amin01(View view) {
    TranslateAnimation translateAnimation = new TranslateAnimation(300, 0, 0, 0);
    Animation alphaAnimation = new AlphaAnimation(0, 1);
    translateAnimation.setDuration(300);
    alphaAnimation.setDuration(100);
    android.view.animation.AnimationSet animation = new AnimationSet(true);
    animation.addAnimation(translateAnimation);
    animation.addAnimation(alphaAnimation);
    view.setAnimation(animation);
  }

  public static void Amin02(View view) {
    Animation animation = new AlphaAnimation(0, 1);
    animation.setDuration(700);
    view.setAnimation(animation);
  }

  public static void Amin03(View view) {
    Animation animation =
        new ScaleAnimation(
            0f, 1f, 0, 1f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 1f);
    animation.setFillAfter(true);
    animation.setDuration(300);
    view.setAnimation(animation);
  }

  public static void Amin04(View view, Activity activity) {
    Animation animation;
    animation = AnimationUtils.loadAnimation(activity, android.R.anim.slide_in_left);
    animation.setDuration(300);
    view.startAnimation(animation);
    animation = null;
  }

  public static void Amin05(View view, Activity activity) {

    Animation animation;
    animation = AnimationUtils.loadAnimation(activity, android.R.anim.slide_out_right);

    animation.setDuration(300);
    view.startAnimation(animation);
    animation = null;
  }

  //  AnimUtils.Worker(imageview2);

  public static void Worker(View view) {

    view.setOnTouchListener(
        (v, event) -> {
          switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
              {
                ObjectAnimator scaleX = new ObjectAnimator();
                scaleX.setTarget(view);
                scaleX.setPropertyName("scaleX");
                scaleX.setFloatValues(0.9f);
                scaleX.setDuration((int) 5);
                scaleX.start();

                ObjectAnimator scaleY = new ObjectAnimator();
                scaleY.setTarget(view);
                scaleY.setPropertyName("scaleY");
                scaleY.setFloatValues(0.9f);
                scaleY.setDuration((int) 5);
                scaleY.start();
                break;
              }
            case MotionEvent.ACTION_UP:
              {
                ObjectAnimator scaleX = new ObjectAnimator();
                scaleX.setTarget(view);
                scaleX.setPropertyName("scaleX");
                scaleX.setFloatValues((float) 1);
                scaleX.setDuration((int) 5);
                scaleX.start();

                ObjectAnimator scaleY = new ObjectAnimator();
                scaleY.setTarget(view);
                scaleY.setPropertyName("scaleY");
                scaleY.setFloatValues((float) 1);
                scaleY.setDuration((int) 5);
                scaleY.start();

                break;
              }
          }
          return false;
        });
  }

  public static void TextAnim(Button tv, int[] colors) {

    ObjectAnimator objectAnimator = ObjectAnimator.ofInt(tv, "textColor", colors);
    objectAnimator.setInterpolator(new LinearInterpolator());
    objectAnimator.setDuration(2000);
    objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
    objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
    objectAnimator.setEvaluator(new ArgbEvaluator());
    AnimatorSet animatorSet = new AnimatorSet();
    animatorSet.play(objectAnimator);
    animatorSet.start();
  }

  public static void RightSwipe(View view, Activity activity, int b) {

    Animation RightSwipe = AnimationUtils.loadAnimation(activity, b);
    view.startAnimation(RightSwipe);
  }

  public static void Shake(View view) {
    ObjectAnimator obj = new ObjectAnimator();
    obj.setTarget(view);
    obj.setPropertyName("translationX");
    obj.setFloatValues(0, .10f, -25, .26f, 25, .42f, -25, .58f, 25, .74f, -25, .90f, 1, 0);
    obj.start();
  }

  public static void ImageFilter(ImageView img, int color1, int color2) {

    img.setImageTintList(
        new ColorStateList(
            new int[][] {{-android.R.attr.state_pressed}, {android.R.attr.state_pressed}},
            new int[] {color1, color2}));
  }

  public static void Sacla(View itemView) {
    float startScale = 1.15f;
    float endScale = 1f;
    int animationDuration = 300;
    ValueAnimator animator = ValueAnimator.ofFloat(startScale, endScale);
    animator.setDuration(animationDuration);
    animator.setInterpolator(new FastOutSlowInInterpolator());
    animator.addUpdateListener(
        animation -> {
          float value = (float) animation.getAnimatedValue();
          itemView.setScaleY(value);
          itemView.setScaleX(value);
        });
    animator.start();
  }

  /**
   * @param
   * @attr(set view by default)
   * @help() @Result
   * @see
   */
  static void _Animator(
      final View _view, final String _propertyName, final double _value, final double _duration) {
    ObjectAnimator anim = new ObjectAnimator();
    anim.setTarget(_view);
    anim.setPropertyName(_propertyName);
    anim.setFloatValues((float) _value);
    anim.setDuration((long) _duration);
    anim.start();
  }

  public static void ClickAnimation(final View view) {
    view.setOnTouchListener(
        (v, event) -> {
          switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
              {
                _Animator(view, "elevation", 5, 70);
                _Animator(view, "scaleX", 0.9d, 70);
                _Animator(view, "scaleY", 0.9, 70);
                timer =
                    new TimerTask() {
                      @Override
                      public void run() {
                        ThreadUtils.runOnUiThread(
                            () -> {
                              _Animator(view, "elevation", 1, 100);
                              _Animator(view, "scaleX", 0.88d, 100);
                              _Animator(view, "scaleY", 0.88d, 100);
                            });
                      }
                    };
                _timer.schedule(timer, 70);
                break;
              }
            case MotionEvent.ACTION_UP:
              {
                timer.cancel();
                _Animator(view, "elevation", 40, 100);
                _Animator(view, "scaleX", 1.1d, 100);
                _Animator(view, "scaleY", 1.1d, 100);
                timer =
                    new TimerTask() {
                      @Override
                      public void run() {
                        ThreadUtils.runOnUiThread(
                            () -> {
                              _Animator(view, "elevation", 25, 100);
                              _Animator(view, "scaleX", 1.0d, 100);
                              _Animator(view, "scaleY", 1.0d, 100);
                            });
                      }
                    };
                _timer.schedule(timer, 100);
                break;
              }
          }
          return false;
        });
  }

  public static void ImageSalca(ImageView views, int data1, int data2, OnIconChange onIconChange) {
    if (ic == 1) {
      views.setImageResource(data1);
      onIconChange.Start();
      ic--;
    } else {
      views.setImageResource(data2);
      onIconChange.End();
      ic++;
    }
  }

  public static void AutoColorSynchronizedfromTxt(int colors, TextView views) {
    if (ColorUtils.calculateLuminance(colors) > 0.5) {
      views.setTextColor(Color.BLACK);
    } else if (ColorUtils.calculateLuminance(colors) <= 0.5) {
      views.setTextColor(Color.WHITE);
    }
  }

  public static void AutoColorSynchronizedfromTxt(int colors, AppCompatTextView views) {
    if (ColorUtils.calculateLuminance(colors) > 0.5) {
      views.setTextColor(Color.BLACK);
    } else if (ColorUtils.calculateLuminance(colors) <= 0.5) {
      views.setTextColor(Color.WHITE);
    }
  }

  public static void AutoColorSynchronizedfromView(int colors, View views) {
    if (ColorUtils.calculateLuminance(colors) > 0.5) {
      views.setBackgroundColor(Color.BLACK);
    } else if (ColorUtils.calculateLuminance(colors) <= 0.5) {
      views.setBackgroundColor(Color.WHITE);
    }
  }

  public static interface OnIconChange {
    void Start();

    void End();
  }
}
