package ir.ninjacoder.prograsssheet.perfence;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import static com.google.android.material.R.attr.*;
import java.util.List;

public class Shape {

  static Drawable state(
      View v, float topLeft, float topRight, float bottomLeft, float bottomRight) {
    MaterialShapeDrawable shapeDrawable =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder()
                .setTopLeftCornerSize(topLeft)
                .setTopRightCornerSize(topRight)
                .setBottomLeftCornerSize(bottomLeft)
                .setBottomRightCornerSize(bottomRight)
                .build());

    shapeDrawable.setFillColor(
        ColorStateList.valueOf(MaterialColors.getColor(v, colorSurfaceContainer)));

    return createRippleDrawable(v, shapeDrawable);
  }

  public static Drawable normal(View v) {
    return state(v, 19f, 19f, 19f, 19f);
  }

  public static Drawable bottom(View v) {
    return state(v, 6f, 6f, 24f, 24f);  
  }

  public static Drawable top(View v) {
    return state(v, 24f, 24f, 6f, 6f); 
  }

  public static Drawable middel(View v) {
    MaterialShapeDrawable md =
        new MaterialShapeDrawable(ShapeAppearanceModel.builder().setAllCornerSizes(6f).build());

    md.setFillColor(ColorStateList.valueOf(MaterialColors.getColor(v, colorSurfaceContainer)));

    return createRippleDrawable(v, md);
  }

  static Drawable createRippleDrawable(View v, MaterialShapeDrawable backgroundDrawable) {
    int rippleColor = MaterialColors.getColor(v, colorOnSurface);
    return new RippleDrawable(ColorStateList.valueOf(rippleColor), backgroundDrawable, null);
  }

  public static <T> Drawable getListBackground(List<T> list, int pos, View v) {
    if (list.size() == 1) {
      return bottom(v);
    } else if (pos == 0) {
      return top(v);
    } else if (pos == list.size() - 1) {
      return bottom(v);
    } else return middel(v);
  }
}
