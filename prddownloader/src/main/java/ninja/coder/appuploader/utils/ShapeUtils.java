package ninja.coder.appuploader.utils;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

public class ShapeUtils {

  public Drawable getCustomShape(int color, ShapeName name) {
    switch (name) {
      case LINENORMAL:
        return getLineNormal(color);
      case LINEROUND:
        return getLineRound(color);

      default:
        return getLineRound(color);
    }
  }

  public Drawable getLineRound(int color) {
    return get(color, 30, 30, 2, 2);
  }

  public Drawable getLineNormal(int color) {
    return get(color, 0, 0, 0, 0);
  }

  Drawable get(int color, int left, int right, int bottomleft, int bottomright) {
    var shapeAppearanceModel =
        new ShapeAppearanceModel()
            .toBuilder()
                .setTopLeftCornerSize(left)
                .setTopRightCornerSize(right)
                .setBottomLeftCornerSize(bottomleft)
                .setBottomRightCornerSize(bottomright)
                .build();

    var shapeDrawable = new MaterialShapeDrawable(shapeAppearanceModel);
    shapeDrawable.setFillColor(ColorStateList.valueOf(color));

    return shapeDrawable;
  }
}
