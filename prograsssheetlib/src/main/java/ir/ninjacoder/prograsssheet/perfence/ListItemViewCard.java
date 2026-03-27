package ir.ninjacoder.prograsssheet.perfence;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import android.content.res.ColorStateList;
import com.google.android.material.color.MaterialColors;
import android.graphics.drawable.RippleDrawable;
import java.util.List;
import static com.google.android.material.R.attr.*;

public class ListItemViewCard extends MaterialCardView {

  int colorSurfaces = colorSurface;
  int colorSecondaryContainers = colorSecondaryContainer;

  public ListItemViewCard(Context c) {
    super(c);
    init();
  }

  public ListItemViewCard(Context c, AttributeSet se) {
    super(c, se);
    init();
  }

  public void setSelectItem(boolean select,List<?> list , int pos) {
    if (select) {
      setStrokeWidth(5);
      setBackground(null);
      setStrokeColor(
          ColorStateList.valueOf(MaterialColors.getColor(this, colorSecondaryContainers)));
      setCardBackgroundColor(MaterialColors.getColor(this, colorOnSurface));
    } else {
      setStrokeWidth(0);
      setBackground(getListBackground(list,pos,this));
      setStrokeColor(null);
      setCardBackgroundColor(null);
    }
  }

  void init() {
    setCardBackgroundColor(null);
    setStrokeColor(null);
    setStrokeWidth(0);
  }

  Drawable state(View v, float topLeft, float topRight, float bottomLeft, float bottomRight) {
    MaterialShapeDrawable shapeDrawable =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder()
                .setTopLeftCornerSize(topLeft)
                .setTopRightCornerSize(topRight)
                .setBottomLeftCornerSize(bottomLeft)
                .setBottomRightCornerSize(bottomRight)
                .build());

    shapeDrawable.setFillColor(ColorStateList.valueOf(MaterialColors.getColor(v, colorSurfaces)));

    return createRippleDrawable(v, shapeDrawable);
  }

  Drawable normal(View v) {
    return state(v, 19f, 19f, 19f, 19f);
  }

  Drawable bottom(View v) {
    return state(v, 6f, 6f, 24f, 24f);
  }

  Drawable top(View v) {
    return state(v, 24f, 24f, 6f, 6f);
  }

  Drawable middel(View v) {
    MaterialShapeDrawable md =
        new MaterialShapeDrawable(ShapeAppearanceModel.builder().setAllCornerSizes(6f).build());
    md.setFillColor(ColorStateList.valueOf(MaterialColors.getColor(v, colorSurfaces)));
    return createRippleDrawable(v, md);
  }

  Drawable createRippleDrawable(View v, MaterialShapeDrawable backgroundDrawable) {
    int rippleColor = MaterialColors.getColor(v, colorOnSurface);
    return new RippleDrawable(ColorStateList.valueOf(rippleColor), backgroundDrawable, null);
  }

  public <T> Drawable getListBackground(List<T> list, int pos, View v) {
    if (list.size() == 1) {
      return bottom(v);
    } else if (pos == 0) {
      return top(v);
    } else if (pos == list.size() - 1) {
      return bottom(v);
    } else return middel(v);
  }
}
