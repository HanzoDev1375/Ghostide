package dev.trindadedev.lib.ui.components.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import dev.trindadedev.lib.ui.components.R;

public class TInput extends LinearLayout {

    public TextInputLayout textInputLayout;
    public TextInputEditText textInputEditText;

    public TInput(Context context) {
        this(context, null);
    }

    public TInput(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TInput(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.layout_tinput_textfield, this, true);
        textInputLayout = findViewById(R.id.text_input_layout);
        textInputEditText = findViewById(R.id.text_input_edittext);

        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TInput, defStyleAttr, 0);

            textInputLayout.setHint(typedArray.getString(R.styleable.TInput_hint));
            textInputLayout.setPlaceholderText(typedArray.getString(R.styleable.TInput_placeholderText));

            String textString = typedArray.getString(R.styleable.TInput_text);
            Editable editableText = !TextUtils.isEmpty(textString) ? Editable.Factory.getInstance().newEditable(textString) : null;
            textInputEditText.setText(editableText);

            int startIconDrawableRes = typedArray.getResourceId(R.styleable.TInput_startIconDrawable, 0);
            if (startIconDrawableRes != 0) {
                textInputLayout.setStartIconDrawable(ContextCompat.getDrawable(context, startIconDrawableRes));
            }

            typedArray.recycle();
        }
    }

    public CharSequence getHint() {
        return textInputLayout.getHint();
    }

    public void setHint(CharSequence hint) {
        textInputLayout.setHint(hint);
    }

    public CharSequence getPlaceholderText() {
        return textInputLayout.getPlaceholderText();
    }

    public void setPlaceholderText(CharSequence placeholderText) {
        textInputLayout.setPlaceholderText(placeholderText);
    }

    public int getStartIconDrawableRes() {
        // Não há maneira direta de obter o recurso drawable. Esta é uma limitação.
        return 0;
    }

    public void setStartIconDrawableRes(int drawableRes) {
        textInputLayout.setStartIconDrawable(ContextCompat.getDrawable(getContext(), drawableRes));
    }

    public CharSequence getText() {
        return textInputEditText.getText();
    }

    public void setText(CharSequence text) {
        textInputEditText.setText(text);
    }
}
