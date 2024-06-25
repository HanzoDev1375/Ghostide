package Ninja.coder.Ghostemane.code.widget;

import Ninja.coder.Ghostemane.code.utils.ColorAndroid12;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.color.MaterialColors;

public class SwitchCompatX extends SwitchCompat {

    public SwitchCompatX(Context x) {
        super(x);
    }

    public SwitchCompatX(Context x, AttributeSet a) {
        super(x, a);
        initAnim();
        InitChackColor();
    }

    @Override
    public void setChecked(boolean ch) {
        super.setChecked(ch);
        if (ch) {
            startAnim();
            ChackColor();
        } else {
            endAnim();
            NoChackColor();
        }
    }

    private void ChackColor() {
        if (ColorAndroid12.Android12)
            setThumbTintList(
                    ColorStateList.valueOf(MaterialColors.getColor(getContext(), ColorAndroid12.SubTitle, 0)));
        else setThumbTintList(ColorStateList.valueOf(Color.parseColor("#FF201B16")));
    }

    private void NoChackColor() {
        setBackgroundColor(android.R.color.transparent);
        if (ColorAndroid12.Android12)
            setThumbTintList(
                    ColorStateList.valueOf(MaterialColors.getColor(getContext(), ColorAndroid12.TvColor, 0)));
        else setThumbTintList(ColorStateList.valueOf(Color.parseColor("#FFFFDCBD")));
    }

    private void InitChackColor() {
        getTrackDrawable().setAlpha(0);
        setBackgroundColor(android.R.color.transparent);
        if (ColorAndroid12.Android12)
            setThumbTintList(
                    ColorStateList.valueOf(MaterialColors.getColor(getContext(), ColorAndroid12.TvColor, 0)));
        else setThumbTintList(ColorStateList.valueOf(Color.parseColor("#FFFFDCBD")));
    }

    @Override
    protected void onAnimationEnd() {
        super.onAnimationEnd();
        endAnim();
    }

    @Override
    protected void onAnimationStart() {
        super.onAnimationStart();
        startAnim();
    }

    public SwitchCompatX initAnim() {
        ObjectAnimator scaleX = new ObjectAnimator();
        scaleX.setTarget(this);
        scaleX.setPropertyName("scaleX");
        scaleX.setFloatValues(0.7f);
        scaleX.setDuration((int) 5);
        scaleX.start();

        ObjectAnimator scaleY = new ObjectAnimator();
        scaleY.setTarget(this);
        scaleY.setPropertyName("scaleY");
        scaleY.setFloatValues(0.7f);
        scaleY.setDuration((int) 5);
        scaleY.start();

        return this;
    }

    protected SwitchCompatX startAnim() {
        ObjectAnimator scaleX = new ObjectAnimator();
        scaleX.setTarget(this);
        scaleX.setPropertyName("scaleX");
        scaleX.setFloatValues((float) 1);
        scaleX.setDuration((int) 5);
        scaleX.start();
        ObjectAnimator scaleY = new ObjectAnimator();
        scaleY.setTarget(this);
        scaleY.setPropertyName("scaleY");
        scaleY.setFloatValues((float) 1);
        scaleY.setDuration((int) 5);
        scaleY.start();

        return this;
    }

    protected SwitchCompatX endAnim() {
        ObjectAnimator scaleX = new ObjectAnimator();
        scaleX.setTarget(this);
        scaleX.setPropertyName("scaleX");
        scaleX.setFloatValues(0.6f);
        scaleX.setDuration((int) 5);
        scaleX.start();

        ObjectAnimator scaleY = new ObjectAnimator();
        scaleY.setTarget(this);
        scaleY.setPropertyName("scaleY");
        scaleY.setFloatValues(0.6f);
        scaleY.setDuration((int) 5);
        scaleY.start();

        return this;
    }

    protected SwitchCompatX onLongSw() {
        setOnTouchListener(
                (v, event) -> {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN: {
                            ObjectAnimator scaleX = new ObjectAnimator();
                            scaleX.setTarget(this);
                            scaleX.setPropertyName("scaleX");
                            scaleX.setFloatValues(0.7f);
                            scaleX.setDuration((int) 5);
                            scaleX.start();
                            ObjectAnimator scaleY = new ObjectAnimator();
                            scaleY.setTarget(this);
                            scaleY.setPropertyName("scaleY");
                            scaleY.setFloatValues(0.7f);
                            scaleY.setDuration((int) 5);
                            scaleY.start();
                            break;
                        }
                        case MotionEvent.ACTION_UP: {
                            ObjectAnimator scaleX = new ObjectAnimator();
                            scaleX.setTarget(this);
                            scaleX.setPropertyName("scaleX");
                            scaleX.setFloatValues((float) 1);
                            scaleX.setDuration((int) 5);
                            scaleX.start();
                            ObjectAnimator scaleY = new ObjectAnimator();
                            scaleY.setTarget(this);
                            scaleY.setPropertyName("scaleY");
                            scaleY.setFloatValues((float) 1);
                            scaleY.setDuration((int) 5);
                            scaleY.start();

                            break;
                        }
                    }
                    return false;
                });
        return this;
    }
}
