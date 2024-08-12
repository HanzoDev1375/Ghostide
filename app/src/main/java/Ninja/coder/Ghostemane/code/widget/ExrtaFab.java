package Ninja.coder.Ghostemane.code.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.ShapeAppearanceModel;

public class ExrtaFab extends ExtendedFloatingActionButton {
  public ExrtaFab(Context c) {
    super(c);
  }

  public ExrtaFab(Context c, AttributeSet v) {
    super(c, v);
    shrink();
    ShapeAppearanceModel.Builder shap = new ShapeAppearanceModel.Builder();
    shap.setAllCorners(CornerFamily.ROUNDED, 50f);
    setShapeAppearanceModel(shap.build());
  }

  public boolean isHide() {
    return getVisibility() == GONE ? true : false;
  }

  public boolean isShow() {
    return getVisibility() == VISIBLE ? true : false;
  }
}
