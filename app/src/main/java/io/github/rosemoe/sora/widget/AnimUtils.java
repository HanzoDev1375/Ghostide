package io.github.rosemoe.sora.widget;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.animation.ObjectAnimator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.content.res.ColorStateList;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimUtils {

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
    translateAnimation.setDuration(600);
    alphaAnimation.setDuration(300);
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
        new View.OnTouchListener() {
          @Override
          public boolean onTouch(View v, MotionEvent event) {
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
          }
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

  public static void O(View _view) {
    ScaleAnimation fade_in =
        new ScaleAnimation(
            0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
    fade_in.setDuration(300);
    fade_in.setFillAfter(true);
    _view.startAnimation(fade_in);
  }

  public static void param(TextView tv) {
    ObjectAnimator objectAnimator = ObjectAnimator.ofInt(tv, "zero", 0xFFFFD5AE, 0xFFAEFFF1);
    objectAnimator.setInterpolator(new LinearInterpolator());
    objectAnimator.setDuration(2000);
    objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
    objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
    objectAnimator.setEvaluator(new ArgbEvaluator());
    AnimatorSet animatorSet = new AnimatorSet();
    if (animatorSet.isRunning()) {
      animatorSet.play(objectAnimator);
      animatorSet.start();
    } else {
      animatorSet.pause();
    }
  }
}
