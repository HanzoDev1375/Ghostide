package Ninja.coder.Ghostemane.code.layoutmanager;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

public class Base10Indicator extends View {
    private int color;

    public Base10Indicator(Context context, int indicatorHeight, int color, int radius) {
        super(context);
        this.color = color;
        initialize(indicatorHeight, radius);
    }

    private void initialize(int indicatorHeight, int radius) {
        this.setBackground(getCube(radius));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                Utils.px2dp(getContext(), indicatorHeight), Utils.px2dp(getContext(), indicatorHeight));
        this.setLayoutParams(layoutParams);
    }

    private android.graphics.drawable.GradientDrawable getCube(int radius) {
        android.graphics.drawable.GradientDrawable drawable = new android.graphics.drawable.GradientDrawable();
        drawable.setShape(android.graphics.drawable.GradientDrawable.RECTANGLE);
        drawable.setColor(color);
        drawable.setCornerRadius(Utils.px2dp(getContext(), radius));
        return drawable;
    }
}