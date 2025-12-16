package ir.ninjacoder.prograsssheet.perfence;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import static com.google.android.material.R.attr.*;

class Shape {
  public static Drawable normal(View v) {
    var shapeDrawable =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder()
                .setTopLeftCornerSize(19f)
                .setTopRightCornerSize(19f)
                .setBottomLeftCornerSize(19f)
                .setBottomRightCornerSize(19f)
                .build());
    shapeDrawable.setFillColor(
        ColorStateList.valueOf(MaterialColors.getColor(v, colorSurfaceContainer)));
    return createRippleDrawable(v, shapeDrawable);
  }

  public static Drawable bottom(View v) {
    var shapeDrawable =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder()
                .setTopLeftCornerSize(6f)
                .setTopRightCornerSize(6f)
                .setBottomLeftCornerSize(24f)
                .setBottomRightCornerSize(24f)
                .build());
    shapeDrawable.setFillColor(
        ColorStateList.valueOf(MaterialColors.getColor(v, colorSurfaceContainer)));
    return createRippleDrawable(v, shapeDrawable);
  }

  public static Drawable top(View v) {
    var tops =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder()
                .setTopLeftCornerSize(24f)
                .setTopRightCornerSize(24f)
                .setBottomLeftCornerSize(6f)
                .setBottomRightCornerSize(6f)
                .build());
    tops.setFillColor(ColorStateList.valueOf(MaterialColors.getColor(v, colorSurfaceContainer)));
    return createRippleDrawable(v, tops);
  }

  public static Drawable middel(View v) {
    var md =
        new MaterialShapeDrawable(ShapeAppearanceModel.builder().setAllCornerSizes(6f).build());
    md.setFillColor(ColorStateList.valueOf(MaterialColors.getColor(v, colorSurfaceContainer)));
    return createRippleDrawable(v, md);
  }

  static Drawable createRippleDrawable(View v, MaterialShapeDrawable backgroundDrawable) {
    int rippleColor = MaterialColors.getColor(v, colorOnSurface);
    return new RippleDrawable(ColorStateList.valueOf(rippleColor), backgroundDrawable, null);
  }
}
