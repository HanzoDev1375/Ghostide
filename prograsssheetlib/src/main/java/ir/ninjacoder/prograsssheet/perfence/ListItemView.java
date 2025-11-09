package ir.ninjacoder.prograsssheet.perfence;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.List;
import static com.google.android.material.R.attr.*;

/**
 * ساخته شده توسط گوست من نمونه این کلاس را زدم تا درد سر گوگل متریال رو دور بزنم رنگ بندی خودکار
 * انجام میشه اما یک سری گتر و ستر هم زدم جای های دیگه میتونید کال کنید
 */
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
      return middel();
    }
  }

  Drawable normal() {
    return createRippleBackground(19f, 19f, 19f, 19f);
  }

  Drawable bottom() {
    return createRippleBackground(4f, 4f, 24f, 24f);
  }

  Drawable top() {
    return createRippleBackground(24f, 24f, 4f, 4f);
  }

  Drawable middel() {
    return createRippleBackground(4f, 4f, 4f, 4f);
  }

  Drawable createRippleBackground(
      float topLeft, float topRight, float bottomLeft, float bottomRight) {
    try {
      MaterialShapeDrawable backgroundDrawable =
          new MaterialShapeDrawable(
              ShapeAppearanceModel.builder()
                  .setTopLeftCornerSize(topLeft)
                  .setTopRightCornerSize(topRight)
                  .setBottomLeftCornerSize(bottomLeft)
                  .setBottomRightCornerSize(bottomRight)
                  .build());

      backgroundDrawable.setFillColor(
          ColorStateList.valueOf(MaterialColors.getColor(this, backgroundColor, 0)));

      return new RippleDrawable(
          ColorStateList.valueOf(MaterialColors.getColor(this, rippleColor, 0)),
          backgroundDrawable,
          null);
    } catch (Exception e) {
      return getContext().getDrawable(android.R.drawable.list_selector_background);
    }
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
    setBackground(getBackground());
    invalidate();
    requestLayout();
  }
}
