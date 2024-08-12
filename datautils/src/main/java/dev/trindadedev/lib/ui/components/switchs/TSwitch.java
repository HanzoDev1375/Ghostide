package dev.trindadedev.lib.ui.components.switchs;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.SwitchCompat;

import dev.trindadedev.lib.ui.components.R;

public class TSwitch extends SwitchCompat {

    public TSwitch(Context context) {
        super(context);
        init(context, null);
    }

    public TSwitch(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TSwitch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setPadding(8, 8, 8, 8);
        setText("TSwitch");
        setTextSize(16);
        setThumbDrawable(context.getResources().getDrawable(R.drawable.ui_m3_switch_thumb));
        setTrackDrawable(context.getResources().getDrawable(R.drawable.ui_m3_switch_track));
        setTrackTintList(context.getResources().getColorStateList(R.color.sel_m3_switch_track));
        setThumbTintList(context.getResources().getColorStateList(R.color.sel_m3_switch_thumb));
    }
}