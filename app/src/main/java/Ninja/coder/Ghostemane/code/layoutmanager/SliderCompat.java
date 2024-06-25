package Ninja.coder.Ghostemane.code.layoutmanager;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.slider.Slider;

public class SliderCompat extends Slider {
    public SliderCompat(Context context) {
        super(context);
    }

    public SliderCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SliderCompat(Context context, AttributeSet attributeSet, int defLine) {
        super(context, attributeSet, defLine);
    }

    private SliderCompat init() {
        setValueFrom(0f);
        setValueTo(24f);
        setStepSize(1f);
        setTrackHeight((int) 10);
        return this;
    }
}
