package ir.ninjacoder.prograsssheet.perfence;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.google.android.material.color.MaterialColors;
import java.util.List;
import static com.google.android.material.R.attr.*;

public class ListItemView extends LinearLayout {

  private int backgroundColor = colorSurfaceContainer;
  private int rippleColor = colorOnSurfaceVariant;
  private int primaryColor = colorPrimaryFixedDim;
  private ValueAnimator selectionAnimator;
  private float currentCornerRadius = 18f;
  private int currentBackgroundColor;

  public ListItemView(Context context) {
    super(context);
    init();
  }

  public ListItemView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  private void init() {
    primaryColor = MaterialColors.getColor(
        this, colorPrimaryFixedDim, getContext().getColor(android.R.color.holo_blue_light));
  }
  public void setItemSelect(boolean select) {
    if (selectionAnimator != null && selectionAnimator.isRunning()) {
      selectionAnimator.cancel();
    }
    
    if (select) {
      startSelectionAnimation();
    } else {
      startDeselectionAnimation();
    }
  }

  private void startSelectionAnimation() {
    ValueAnimator cornerAnimator = ValueAnimator.ofFloat(18f, 6f);
    cornerAnimator.setDuration(200);
    cornerAnimator.addUpdateListener(animation -> {
      currentCornerRadius = (float) animation.getAnimatedValue();
      refreshBackground();
    });
    int startColor = MaterialColors.getColor(
        this, backgroundColor, getContext().getColor(android.R.color.white));
    int endColor = MaterialColors.getColor(
        this, colorPrimaryContainer, primaryColor);
    
    ValueAnimator colorAnimator = ValueAnimator.ofObject(
        new ArgbEvaluator(), startColor, endColor);
    colorAnimator.setDuration(300);
    colorAnimator.addUpdateListener(animation -> {
      currentBackgroundColor = (int) animation.getAnimatedValue();
      refreshBackground();
    });
    cornerAnimator.start();
    colorAnimator.start();
    selectionAnimator = colorAnimator;
  }

  private void startDeselectionAnimation() {
    
    ValueAnimator cornerAnimator = ValueAnimator.ofFloat(currentCornerRadius, 18f);
    cornerAnimator.setDuration(200);
    cornerAnimator.addUpdateListener(animation -> {
      currentCornerRadius = (float) animation.getAnimatedValue();
      refreshBackground();
    });
    
    ValueAnimator colorAnimator = ValueAnimator.ofObject(
        new ArgbEvaluator(), currentBackgroundColor, 
        MaterialColors.getColor(this, backgroundColor, getContext().getColor(android.R.color.white)));
    colorAnimator.setDuration(300);
    colorAnimator.addUpdateListener(animation -> {
      currentBackgroundColor = (int) animation.getAnimatedValue();
      refreshBackground();
    });
    
    cornerAnimator.start();
    colorAnimator.start();
    
    selectionAnimator = colorAnimator;
  }

  public <T> Drawable get(List<T> list, int position) {
    if (list.size() == 1) {
      return normal();
    } else if (position == 0) {
      return top();
    } else if (position == list.size() - 1) {
      return bottom();
    } else {
      return middle();
    }
  }

  Drawable normal() {
    return createRippleBackground(18f, 18f, 18f, 18f);
  }

  Drawable bottom() {
    return createRippleBackground(6f, 6f, 18f, 18f);
  }

  Drawable top() {
    return createRippleBackground(18f, 18f, 6f, 6f);
  }

  Drawable middle() {
    return createRippleBackground(6f, 6f, 6f, 6f);
  }

  Drawable createRippleBackground(
      float topLeft, float topRight, float bottomLeft, float bottomRight) {
    try {
      GradientDrawable backgroundDrawable = new GradientDrawable();
      backgroundDrawable.setShape(GradientDrawable.RECTANGLE);
      float tl = currentCornerRadius == 18f ? topLeft : currentCornerRadius;
      float tr = currentCornerRadius == 18f ? topRight : currentCornerRadius;
      float bl = currentCornerRadius == 18f ? bottomLeft : currentCornerRadius;
      float br = currentCornerRadius == 18f ? bottomRight : currentCornerRadius;
      
      backgroundDrawable.setCornerRadii(
          new float[] {
            dpToPx(tl), dpToPx(tl),
            dpToPx(tr), dpToPx(tr),
            dpToPx(br), dpToPx(br),
            dpToPx(bl), dpToPx(bl)
          });
      
      int backgroundColorValue = currentBackgroundColor != 0 ? 
          currentBackgroundColor :
          MaterialColors.getColor(
              this, backgroundColor, getContext().getColor(android.R.color.white));
      backgroundDrawable.setColor(backgroundColorValue);
      int rippleColorValue = MaterialColors.getColor(
          this, rippleColor, getContext().getColor(android.R.color.darker_gray));
      if (currentCornerRadius < 18f) {
        rippleColorValue = MaterialColors.getColor(
            this, colorPrimaryFixedDim, primaryColor);
      }

      return new RippleDrawable(
          ColorStateList.valueOf(rippleColorValue), 
          backgroundDrawable, 
          null);

    } catch (Exception e) {
      return getContext().getDrawable(android.R.drawable.list_selector_background);
    }
  }

  private float dpToPx(float dp) {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, dp, getContext().getResources().getDisplayMetrics());
  }

  public void setBackgroundColor(int backgroundColor) {
    this.backgroundColor = backgroundColor;
    refreshBackground();
  }

  public void setRippleColor(int rippleColor) {
    this.rippleColor = rippleColor;
    refreshBackground();
  }

  public void setPrimaryColor(int primaryColor) {
    this.primaryColor = primaryColor;
    refreshBackground();
  }

  public void refreshBackground() {
    setBackground(null);
    Drawable newBackground = createRippleBackground(18f, 18f, 18f, 18f);
    setBackground(newBackground);
    invalidate();
    requestLayout();
  }
  
  @Override
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    if (selectionAnimator != null) {
      selectionAnimator.cancel();
      selectionAnimator = null;
    }
  }
}
