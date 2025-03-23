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

  public static Drawable bottom(View v) {
    MaterialShapeDrawable shapeDrawable =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder()
                .setTopLeftCornerSize(4f)
                .setTopRightCornerSize(4f)
                .setBottomLeftCornerSize(24f)
                .setBottomRightCornerSize(24f)
                .build());
    shapeDrawable.setFillColor(
        ColorStateList.valueOf(MaterialColors.getColor(v, colorSurfaceContainer)));
    return createRippleDrawable(v, shapeDrawable);
  }

  public static Drawable top(View v) {
    MaterialShapeDrawable tops =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder()
                .setTopLeftCornerSize(24f)
                .setTopRightCornerSize(24f)
                .setBottomLeftCornerSize(4f)
                .setBottomRightCornerSize(4f)
                .build());
    tops.setFillColor(ColorStateList.valueOf(MaterialColors.getColor(v, colorSurfaceContainer)));
    return createRippleDrawable(v, tops);
  }

  public static Drawable middel(View v) {
    MaterialShapeDrawable md =
        new MaterialShapeDrawable(ShapeAppearanceModel.builder().setAllCornerSizes(4f).build());
    md.setFillColor(ColorStateList.valueOf(MaterialColors.getColor(v, colorSurfaceContainer)));
    return createRippleDrawable(v, md);
  }

  private static Drawable createRippleDrawable(View v, MaterialShapeDrawable backgroundDrawable) {
    int rippleColor = MaterialColors.getColor(v, colorOnSurface);
    return new RippleDrawable(ColorStateList.valueOf(rippleColor), backgroundDrawable, null);
  }
}
