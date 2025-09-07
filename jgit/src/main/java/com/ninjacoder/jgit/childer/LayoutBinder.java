package com.ninjacoder.jgit.childer;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

public class LayoutBinder {
  public static void of(View view, int color) {
    var shape =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder()
                .setTopLeftCorner(CornerFamily.ROUNDED, 54)
                .setTopRightCorner(CornerFamily.ROUNDED, 54)
                .build());
    shape.setFillColor(ColorStateList.valueOf(MaterialColors.getColor(view, color, 0)));
//	shape.setStroke(1,Color.CYAN); //test
    view.setBackground(shape);
  }
}
