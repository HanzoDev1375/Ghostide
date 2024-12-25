package ir.ninjacoder.ghostide.layoutmanager;

import ir.ninjacoder.ghostide.utils.ObjectUtils;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.ShapeAppearanceModel;

public class CardKshow extends MaterialCardView {
    public CardKshow(Context context) {
        super(context);
        ShapeCustom();
    }

    public CardKshow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ShapeCustom();

    }

    public CardKshow(Context context, AttributeSet attributeSet, int def) {
        super(context, attributeSet, def);
        ShapeCustom();
    }

    public void ShapeCustom() {
        setStrokeWidth(1);
        if (ObjectUtils.Android12) {
            setCardBackgroundColor(ColorStateList.valueOf(MaterialColors.getColor(getContext(), ObjectUtils.Back, 0)));
            setStrokeColor(ColorStateList.valueOf(MaterialColors.getColor(getContext(), ObjectUtils.TvColor, 0)));
        } else {
            setCardBackgroundColor(ColorStateList.valueOf(Color.parseColor("#ff201B16")));
            setStrokeColor(ColorStateList.valueOf(Color.parseColor("#FFDCBD")));
        }
        var builder = new ShapeAppearanceModel.Builder();
        builder.setAllCorners(CornerFamily.ROUNDED, 30f);
        setShapeAppearanceModel(builder.build());

    }
}
