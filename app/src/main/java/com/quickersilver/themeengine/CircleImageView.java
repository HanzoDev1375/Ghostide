package com.quickersilver.themeengine;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.ColorRes;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

public class CircleImageView extends ShapeableImageView {

  private ValueAnimator shapeDrawableAnimator;

  public CircleImageView(Context context) {
    this(context, null);
  }

  public CircleImageView(Context context, AttributeSet attrs) {
    this(context, attrs, -1);
  }

  public CircleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    ShapeAppearanceModel shapeAppearanceModel =
        new ShapeAppearanceModel()
            .toBuilder()
                .setAllCornerSizes(
                    new CornerSize() {
                      @Override
                      public float getCornerSize(RectF bounds) {
                        return bounds.height() / 2;
                      }
                    })
                .build();
    setBackground(new MaterialShapeDrawable(shapeAppearanceModel));
  }

  @Override
  public void setBackgroundColor(int color) {
    ((MaterialShapeDrawable) getBackground()).setFillColor(ColorStateList.valueOf(color));
  }

  public void setBackgroundColorRes(@ColorRes int color) {
    setBackgroundColor(ResourcesCompat.getColor(getResources(), color, getContext().getTheme()));
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, widthMeasureSpec);
  }

  @SuppressLint("ClickableViewAccessibility")
  @Override
  public boolean onTouchEvent(MotionEvent event) {
    switch (event.getAction()) {
      case MotionEvent.ACTION_DOWN:
        shapeDrawableAnimator = ValueAnimator.ofFloat(2f, 4f);
        shapeDrawableAnimator.addUpdateListener(
            new ValueAnimator.AnimatorUpdateListener() {
              @Override
              public void onAnimationUpdate(ValueAnimator animation) {
                ((MaterialShapeDrawable) getBackground())
                    .setCornerSize(
                        new CornerSize() {
                          @Override
                          public float getCornerSize(RectF bounds) {
                            return bounds.height() / (float) animation.getAnimatedValue();
                          }
                        });
              }
            });
        shapeDrawableAnimator.start();
        break;
      case MotionEvent.ACTION_CANCEL:
      case MotionEvent.ACTION_UP:
        shapeDrawableAnimator.reverse();
        break;
    }
    return super.onTouchEvent(event);
  }
}
