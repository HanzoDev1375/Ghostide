package ir.ninjacoder.prograsssheet.perfence;

import android.content.Context;
import android.content.res.ColorStateList;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.card.MaterialCardView;
import android.util.AttributeSet;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

public class ShapeMaterialCardView extends MaterialCardView {
  public ShapeMaterialCardView(Context c) {
    super(c);
    init();
  }

  public ShapeMaterialCardView(Context c, AttributeSet s) {
    super(c, s);
    init();
  }

  void init() {
    ColorStateList cardBackground = getCardBackgroundColor();
    if (cardBackground != null) {
      int color = cardBackground.getDefaultColor();
      int alphaColor = ColorUtils.setAlphaComponent(color, 128);
      var shape =
          new MaterialShapeDrawable(
              ShapeAppearanceModel.builder().setAllCorners(99, CornerFamily.ROUNDED).build());
      shape.setFillColor(ColorStateList.valueOf(alphaColor));
      setBackground(shape);
    }
  }
}
