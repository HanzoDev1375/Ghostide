package com.ninjacoder.jgit.childer;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.animation.ValueAnimator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import com.google.android.material.color.MaterialColors;
import com.ninjacoder.jgit.databinding.LayoutChildViewBinding;

public class LayoutChilder extends LinearLayout implements View.OnClickListener {

  private LayoutChildViewBinding binding;
  private boolean call;
  protected View vi;

  public LayoutChilder(Context c) {
    super(c);
    init(c);
  }

  public LayoutChilder(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context);
  }

  public LayoutChilder(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context);
  }

  void init(Context context) {
    binding = LayoutChildViewBinding.inflate(LayoutInflater.from(context));

    if (binding != null) {
      addView(binding.getRoot());
    }
  }

  @Override
  public void onClick(View view) {
    if (!call) {
      call = true;
    } else {
      call = false;
    }
    rotateChevron(!call, binding.arrowUpslide);
    installLazy(vi);
  }

  public void setViewChilder(View vi) {
    this.vi = vi;
    binding.arrowUpslide.setOnClickListener(this);
  }

  public void setTitleText(String sub) {
    binding.textview1.setText(sub);
  }

  public void setIcon(int icon) {
    binding.iconTool.setImageResource(icon);
  }

  public void setArrowIcon(int icon) {
    binding.arrowUpslide.setImageResource(icon);
  }

  public void setAllColorFilter(ColorFilter filter) {
    binding.arrowUpslide.setColorFilter(filter);
    binding.iconTool.setColorFilter(filter);
  }

  public void setAllColorFilter(int color) {
    binding.arrowUpslide.setColorFilter(
        MaterialColors.getColor(binding.arrowUpslide, color), PorterDuff.Mode.SRC_IN);
    binding.iconTool.setColorFilter(
        MaterialColors.getColor(binding.iconTool, color), PorterDuff.Mode.SRC_IN);
  }

  public void setTitleColor(int color) {
    binding.textview1.setTextColor(color);
  }

  public void setTitleColorByMA(int color) {
    binding.textview1.setTextColor(MaterialColors.getColor(binding.textview1, color));
  }

  public void expand(View v) {
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

  public void collapse(View v) {
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

  public boolean isExpanded(View v) {
    return v.getVisibility() == View.VISIBLE;
  }

  public boolean isCollapsed(View v) {
    return v.getVisibility() == View.GONE;
  }

  public void rotateChevron(boolean isOpen, ImageView chevronView) {
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

  void installLazy(View v) {
    if (!isCollapsed(v)) {
      collapse(v);
    } else {
      expand(v);
    }
  }
}
