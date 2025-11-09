package ir.ninjacoder.ghostide.core.widget;

import android.content.Context;
import android.util.AttributeSet;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.ShapeAppearanceModel;

public class FabButton extends FloatingActionButton {
  public FabButton(Context t) {
    super(t);
  }

  public FabButton(Context context, AttributeSet a) {
    super(context, a);
    init();
  }

  private FabButton init() {
    ShapeAppearanceModel.Builder shapeAppearanceModel = new ShapeAppearanceModel.Builder();
    shapeAppearanceModel.setAllCorners(CornerFamily.ROUNDED, 50f);
    setShapeAppearanceModel(shapeAppearanceModel.build());
    return this;
  }
}
