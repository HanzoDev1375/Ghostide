package ir.ninjacoder.prograsssheet.perfence;

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

  public ListItemView(Context context) {
    super(context);
  }

  public ListItemView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
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
    return createRippleBackground(4f, 4f, 18f, 18f);
  }

  Drawable top() {
    return createRippleBackground(18f, 18f, 4f, 4f);
  }

  Drawable middle() {
    return createRippleBackground(4f, 4f, 4f, 4f);
  }

  Drawable createRippleBackground(
      float topLeft, float topRight, float bottomLeft, float bottomRight) {
    try {
      // ایجاد GradientDrawable به عنوان شکل زمینه
      GradientDrawable backgroundDrawable = new GradientDrawable();
      backgroundDrawable.setShape(GradientDrawable.RECTANGLE);

      // تنظیم corner radii
      backgroundDrawable.setCornerRadii(
          new float[] {
            dpToPx(topLeft), dpToPx(topLeft),
            dpToPx(topRight), dpToPx(topRight),
            dpToPx(bottomRight), dpToPx(bottomRight),
            dpToPx(bottomLeft), dpToPx(bottomLeft)
          });
      int backgroundColorValue =
          MaterialColors.getColor(
              this, backgroundColor, getContext().getColor(android.R.color.white));
      backgroundDrawable.setColor(backgroundColorValue);
      int rippleColorValue =
          MaterialColors.getColor(
              this, rippleColor, getContext().getColor(android.R.color.darker_gray));

      return new RippleDrawable(ColorStateList.valueOf(rippleColorValue), backgroundDrawable, null);

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

  public void refreshBackground() {
    Drawable currentBackground = getBackground();
    if (currentBackground != null) {
      setBackground(currentBackground);
    }
    invalidate();
    requestLayout();
  }
}
