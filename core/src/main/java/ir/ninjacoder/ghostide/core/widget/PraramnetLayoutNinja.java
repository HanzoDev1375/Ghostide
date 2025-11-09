package ir.ninjacoder.ghostide.core.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.Toast;


public class PraramnetLayoutNinja extends LinearLayout {

    public PraramnetLayoutNinja(Context context) {
        super(context);
        init();
    }

    public PraramnetLayoutNinja(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PraramnetLayoutNinja(Context context, AttributeSet attributeSet, int labe) {
        super(context, attributeSet, labe);
        init();

    }

    protected void init() {
        sizelayout(getContext());
    }

    public void sizelayout(Context context) {
        try {
            setLayoutParams(new LayoutParams((int) (getDisplayHeightPixels(context)),
                    (int) (getDisplayWidthPixels(context))));
        } catch (Exception s) {
            Toast.makeText(context, s.toString(), Toast.LENGTH_LONG).show();
        }
    }

    protected int getDisplayWidthPixels(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    protected int getDisplayHeightPixels(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public PraramnetLayoutNinja setBack(ColorStateList list) {
        if (list != null)
            setBackgroundTintList(list);

        return this;
    }

    public PraramnetLayoutNinja layoutAnim(int hsi, float[] colorlist) {
        ValueAnimator anim = ValueAnimator.ofFloat(0, 1);
        anim.setDuration(hsi);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                colorlist[0] = 360 * animation.getAnimatedFraction();
                int runColor = Color.HSVToColor(colorlist);
                setBackgroundColor(runColor);
            }
        });
        anim.setRepeatCount(Animation.INFINITE);
        anim.start();
        return this;
    }

}