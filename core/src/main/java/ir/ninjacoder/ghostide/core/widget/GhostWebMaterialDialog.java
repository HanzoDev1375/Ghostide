package ir.ninjacoder.ghostide.core.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

public class GhostWebMaterialDialog extends MaterialAlertDialogBuilder {
    public GhostWebMaterialDialog(Context context) {
        super(context);
        //	init();
    }

    public GhostWebMaterialDialog init() {
        setBackground(getShap());

        return this;
    }

    protected MaterialShapeDrawable getShap() {
        MaterialShapeDrawable shp =
                new MaterialShapeDrawable(
                        ShapeAppearanceModel.builder().setAllCorners(CornerFamily.ROUNDED, 22f).build());
        shp.setFillColor(ColorStateList.valueOf(Color.parseColor("#2B2120")));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            shp.setElevation(1);
        }

        return shp;
    }
}
