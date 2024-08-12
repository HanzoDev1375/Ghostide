package dev.trindadedev.lib.ui.components.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import dev.trindadedev.lib.ui.components.R;

import com.google.android.material.materialswitch.MaterialSwitch;

public class PreferenceSwitch extends RelativeLayout implements View.OnClickListener {

    public boolean value = false;
    public TextView preferenceName;
    public TextView preferenceDescription;
    public MaterialSwitch preferenceSwitch;

    public PreferenceSwitch(Context context) {
        super(context);
        initialize(context, null);
    }

    public PreferenceSwitch(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context, attrs);
    }

    public PreferenceSwitch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context, attrs);
    }

    public void initialize(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.layout_preference_switch, this, true);

        preferenceName = findViewById(R.id.preference_name);
        preferenceDescription = findViewById(R.id.preference_description);
        preferenceSwitch = findViewById(R.id.preference_switch);

        setOnClickListener(this);

        if (attrs != null) {
            TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.PreferenceSwitch,
                0, 0);

            try {
                String title = a.getString(R.styleable.PreferenceSwitch_preferenceSwitchTitle);
                String description = a.getString(R.styleable.PreferenceSwitch_preferenceSwitchDescription);
                boolean defaultValue = a.getBoolean(R.styleable.PreferenceSwitch_preferenceSwitchDefaultValue, false);

                setTitle(title != null ? title : "");
                setDescription(description != null ? description : "");
                setValue(defaultValue);
            } finally {
                a.recycle();
            }
        }
    }

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
        preferenceSwitch.setChecked(value);
    }

    @Override
    public void onClick(View view) {
        setValue(!value);
    }

    public void setDescription(String value) {
        preferenceDescription.setText(value);
    }

    public void setTitle(String value) {
        preferenceName.setText(value);
    }

    public void setSwitchChangedListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        preferenceSwitch.setOnCheckedChangeListener(onCheckedChangeListener);
    }
}