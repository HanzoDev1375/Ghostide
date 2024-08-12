package Ninja.coder.Ghostemane.code.layoutmanager;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.ShapeAppearanceModel;

public class btnCompat extends MaterialButton {
    public btnCompat(Context context) {
        super(context);
    }

    public btnCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
        setBackground();
    }

    protected btnCompat init() {
        ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder();
        if (builder != null) {
            builder.setAllCorners(CornerFamily.ROUNDED, 25f);
        }
        setShapeAppearanceModel(builder.build());
        ShapeAppearanceModel s = new ShapeAppearanceModel();
        return this;
    }

    protected btnCompat setBackground() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FF7DEBFC")));
            setTextColor(Color.parseColor("#FF131313"));
        } else {
            setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFFCB07D")));
            setTextColor(Color.parseColor("#FF121212"));
        }
        return this;
    }

}