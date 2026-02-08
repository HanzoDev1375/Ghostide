package ir.ninjacoder.prograsssheet.perfence;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import ir.ninjacoder.prograsssheet.R;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.google.android.material.color.MaterialColors;
import java.util.ArrayList;
import java.util.List;
import static com.google.android.material.R.attr.*;

public class ListItemView extends LinearLayout {

  private int backgroundColor = colorSurfaceContainer;
  private int rippleColor = colorOnSurfaceVariant;
  private int primaryColor = colorPrimaryFixedDim;
  private ValueAnimator selectionAnimator;
  private ValueAnimator rippleAnimator;
  private float currentCornerRadius = 18f;
  private int currentBackgroundColor;
  private int currentRippleColor;
  private boolean isStrokeColor;
  private int storkeSize;
  private int storkeColor = primaryColor;

  public ListItemView(Context context) {
    super(context);
    init(null);
  }

  public ListItemView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init(attrs);
  }

  private void init(AttributeSet set) {
    primaryColor =
        MaterialColors.getColor(
            this, colorPrimaryFixedDim, getContext().getColor(android.R.color.holo_blue_light));
    currentRippleColor = getDefaultRippleColor();
    TypedArray a = getContext().obtainStyledAttributes(set, R.styleable.ListItemViews);
    if (set != null) {
      try {
        int strokesize = a.getDimensionPixelSize(R.styleable.ListItemViews_strokesize, 0);
        if (strokesize > 0) setStorkeSize(strokesize);
        int strcolor = a.getColor(R.styleable.ListItemViews_strokecolor, 0);
        if (strcolor != 0) setStorkeColor(strcolor);
        boolean strmod = a.getBoolean(R.styleable.ListItemViews_strokemod, false);
        setStrokeColorMod(strmod);
      } finally {
        a.recycle();
      }
    }
  }

  private int getDefaultRippleColor() {
    return MaterialColors.getColor(
        this, rippleColor, getContext().getColor(android.R.color.darker_gray));
  }

  private int getSelectedRippleColor() {
    return MaterialColors.getColor(this, colorPrimaryFixedDim, primaryColor);
  }

  public void setItemSelect(boolean select) {
    if (selectionAnimator != null && selectionAnimator.isRunning()) {
      selectionAnimator.cancel();
    }

    if (rippleAnimator != null && rippleAnimator.isRunning()) {
      rippleAnimator.cancel();
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
    cornerAnimator.addUpdateListener(
        animation -> {
          currentCornerRadius = (float) animation.getAnimatedValue();
          refreshBackground();
        });

    int startColor =
        MaterialColors.getColor(
            this, backgroundColor, getContext().getColor(android.R.color.white));
    int endColor = MaterialColors.getColor(this, colorPrimaryContainer, primaryColor);

    ValueAnimator colorAnimator = ValueAnimator.ofObject(new ArgbEvaluator(), startColor, endColor);
    colorAnimator.setDuration(300);
    colorAnimator.addUpdateListener(
        animation -> {
          currentBackgroundColor = (int) animation.getAnimatedValue();
          refreshBackground();
        });

    int startRippleColor = getDefaultRippleColor();
    int endRippleColor = getSelectedRippleColor();
    rippleAnimator = ValueAnimator.ofObject(new ArgbEvaluator(), startRippleColor, endRippleColor);
    rippleAnimator.setDuration(300);
    rippleAnimator.addUpdateListener(
        animation -> {
          currentRippleColor = (int) animation.getAnimatedValue();
          refreshBackground();
        });

    cornerAnimator.start();
    colorAnimator.start();
    rippleAnimator.start();
    selectionAnimator = colorAnimator;
  }

  private void startDeselectionAnimation() {
    ValueAnimator cornerAnimator = ValueAnimator.ofFloat(currentCornerRadius, 6f);
    cornerAnimator.setDuration(200);
    cornerAnimator.addUpdateListener(
        animation -> {
          currentCornerRadius = (float) animation.getAnimatedValue();
          refreshBackground();
        });

    ValueAnimator colorAnimator =
        ValueAnimator.ofObject(
            new ArgbEvaluator(),
            currentBackgroundColor,
            MaterialColors.getColor(
                this, backgroundColor, getContext().getColor(android.R.color.white)));
    colorAnimator.setDuration(300);
    colorAnimator.addUpdateListener(
        animation -> {
          currentBackgroundColor = (int) animation.getAnimatedValue();
          refreshBackground();
        });

    int endRippleColor = getDefaultRippleColor();
    rippleAnimator =
        ValueAnimator.ofObject(new ArgbEvaluator(), currentRippleColor, endRippleColor);
    rippleAnimator.setDuration(300);
    rippleAnimator.addUpdateListener(
        animation -> {
          currentRippleColor = (int) animation.getAnimatedValue();
          refreshBackground();
        });

    cornerAnimator.start();
    colorAnimator.start();
    rippleAnimator.start();

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
    GradientDrawable backgroundDrawable = new GradientDrawable();
    backgroundDrawable.setShape(GradientDrawable.RECTANGLE);
    float tl = currentCornerRadius == 18f ? topLeft : currentCornerRadius;
    float tr = currentCornerRadius == 18f ? topRight : currentCornerRadius;
    float bl = currentCornerRadius == 18f ? bottomLeft : currentCornerRadius;
    float br = currentCornerRadius == 18f ? bottomRight : currentCornerRadius;

    float[] radii =
        new float[] {
          dpToPx(tl), dpToPx(tl),
          dpToPx(tr), dpToPx(tr),
          dpToPx(br), dpToPx(br),
          dpToPx(bl), dpToPx(bl)
        };
    backgroundDrawable.setCornerRadii(radii);

    int backgroundColorValue =
        currentBackgroundColor != 0
            ? currentBackgroundColor
            : MaterialColors.getColor(
                this, backgroundColor, getContext().getColor(android.R.color.white));
    backgroundDrawable.setColor(backgroundColorValue);

    // اگر استروک نیاز نیست
    if (!isStrokeColor || storkeSize <= 0) {
      return getRi(backgroundDrawable);
    }

    // تشخیص نوع آیتم
    boolean isTopState = tl == 18f && tr == 18f && bl == 6f && br == 6f;
    boolean isBottomState = tl == 6f && tr == 6f && bl == 18f && br == 18f;
    boolean isMiddleState = tl == 6f && tr == 6f && bl == 6f && br == 6f;
    boolean isNormalState = tl == 18f && tr == 18f && bl == 18f && br == 18f;

    // ایجاد لیست drawableها
    List<Drawable> layers = new ArrayList<>();
    layers.add(backgroundDrawable); // لایه اصلی

    // ایجاد خطوط استروک
    if (isTopState) {
      // بالا + چپ + راست
      layers.add(createStrokeDrawable(true, true, false, false, radii)); // بالا
      layers.add(createStrokeDrawable(false, false, true, false, radii)); // چپ
      layers.add(createStrokeDrawable(false, false, false, true, radii)); // راست
    } else if (isMiddleState) {
      // فقط چپ + راست
      layers.add(createStrokeDrawable(false, false, true, false, radii)); // چپ
      layers.add(createStrokeDrawable(false, false, false, true, radii)); // راست
    } else if (isBottomState) {
      // پایین + چپ + راست
      layers.add(createStrokeDrawable(false, false, false, false, radii)); // پایین
      layers.add(createStrokeDrawable(false, false, true, false, radii)); // چپ
      layers.add(createStrokeDrawable(false, false, false, true, radii)); // راست
    }
    // normal state بدون استروک

    // اگر فقط background داریم
    if (layers.size() == 1) {
      return getRi(backgroundDrawable);
    }

    // ایجاد LayerDrawable
    LayerDrawable layerDrawable = new LayerDrawable(layers.toArray(new Drawable[0]));

    // تنظیم inset برای هر لایه خط
    for (int i = 1; i < layers.size(); i++) {
      GradientDrawable stroke = (GradientDrawable) layers.get(i);

      if (stroke.getShape() == GradientDrawable.LINE) {
        // برای خطوط عمودی (چپ/راست)
        if (stroke.getOrientation() == GradientDrawable.Orientation.LEFT_RIGHT) {
          layerDrawable.setLayerInset(i, storkeSize, 0, storkeSize, 0);
        }
        // برای خطوط افقی (بالا/پایین)
        else {
          layerDrawable.setLayerInset(i, 0, storkeSize, 0, storkeSize);
        }
      }
    }

    return getRi(layerDrawable);
  }

  // متد کمکی برای ایجاد خط استروک
  private GradientDrawable createStrokeDrawable(
      boolean isTop, boolean isBottom, boolean isLeft, boolean isRight, float[] radii) {
    GradientDrawable stroke = new GradientDrawable();

    if (isLeft || isRight) {
      // خط عمودی
      stroke.setShape(GradientDrawable.LINE);
      stroke.setOrientation(
          isLeft
              ? GradientDrawable.Orientation.LEFT_RIGHT
              : GradientDrawable.Orientation.RIGHT_LEFT);
      stroke.setSize(storkeSize, 0);
    } else {
      // خط افقی
      stroke.setShape(GradientDrawable.LINE);
      stroke.setOrientation(
          isTop
              ? GradientDrawable.Orientation.TOP_BOTTOM
              : GradientDrawable.Orientation.BOTTOM_TOP);
      stroke.setSize(0, storkeSize);
    }

    stroke.setColor(storkeColor);
    return stroke;
  }

  RippleDrawable getRi(Drawable backgroundDrawable) {
    int targetRippleColor;
    if (currentCornerRadius < 18f) {
      targetRippleColor = MaterialColors.getColor(this, colorPrimaryFixedDim, primaryColor);
    } else {
      targetRippleColor =
          MaterialColors.getColor(
              this, rippleColor, getContext().getColor(android.R.color.darker_gray));
    }

    if (currentRippleColor == 0) {
      currentRippleColor =
          MaterialColors.getColor(
              this, rippleColor, getContext().getColor(android.R.color.darker_gray));
    }

    RippleDrawable rippleDrawable =
        new RippleDrawable(ColorStateList.valueOf(currentRippleColor), backgroundDrawable, null);

    if (currentRippleColor != targetRippleColor) {
      if (rippleAnimator != null && rippleAnimator.isRunning()) {
        rippleAnimator.cancel();
      }
      rippleAnimator =
          ValueAnimator.ofObject(new ArgbEvaluator(), currentRippleColor, targetRippleColor);
      rippleAnimator.setDuration(300);
      rippleAnimator.addUpdateListener(
          animation -> {
            currentRippleColor = (int) animation.getAnimatedValue();
            rippleDrawable.setColor(ColorStateList.valueOf(currentRippleColor));
            invalidate();
          });
      rippleAnimator.start();
    }

    return rippleDrawable;
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
    currentRippleColor = getDefaultRippleColor();
    refreshBackground();
  }

  public void setPrimaryColor(int primaryColor) {
    this.primaryColor = primaryColor;
    refreshBackground();
  }

  public void refreshBackground() {
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
    if (rippleAnimator != null) {
      rippleAnimator.cancel();
      rippleAnimator = null;
    }
  }

  public boolean getIsStrokeColor() {
    return this.isStrokeColor;
  }

  public void setStrokeColorMod(boolean isStrokeColor) {
    this.isStrokeColor = isStrokeColor;
    refreshBackground();
  }

  public int getStorkeSize() {
    return this.storkeSize;
  }

  public void setStorkeSize(int storkeSize) {
    this.storkeSize = storkeSize;
    refreshBackground();
  }

  public int getStorkeColor() {
    return this.storkeColor;
  }

  public void setStorkeColor(int storkeColor) {
    this.storkeColor = storkeColor;
    refreshBackground();
  }
}
