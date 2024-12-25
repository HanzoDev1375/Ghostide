package ir.ninjacoder.ghostide.utils;

import android.content.res.ColorStateList;
import android.graphics.Color;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;

/**
 * using in class from ghost web ide
 */

public class Android13Color {
    public static String colorAc = "#201B16";
    public static String colorBc = "#FFDCBD";

    public static int getTextColorLight(int color) {
        return MaterialColors.isColorLight(color) ? Color.BLACK : Color.WHITE;
    }

    public static MaterialShapeDrawable getBackground() {
        MaterialShapeDrawable shapeDrawable = new MaterialShapeDrawable(
                ShapeAppearanceModel.builder().setAllCorners(CornerFamily.ROUNDED, 20f).build());
        shapeDrawable.setFillColor(ColorStateList.valueOf(Color.parseColor(colorAc)));
        shapeDrawable.setStroke(2f, ColorStateList.valueOf(Color.parseColor(colorBc)));
        return shapeDrawable;
    }

    public static void a() {
        MaterialShapeUtils.setParentAbsoluteElevation(null);
    }
}
