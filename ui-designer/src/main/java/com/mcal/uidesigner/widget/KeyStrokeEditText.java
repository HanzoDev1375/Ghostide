package com.mcal.uidesigner.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;

import com.mcal.uidesigner.common.KeyStroke;
import com.mcal.uidesigner.common.KeyStrokeDetector;

public class KeyStrokeEditText extends AppCompatEditText {
    private KeyStrokeDetector keyStrokeDetector;
    private KeyStroke stroke;
    private final KeyStrokeDetector.KeyStrokeHandler keyStrokeHandler = keyStroke -> {
        setKeyStroke(keyStroke);
        return true;
    };

    public KeyStrokeEditText(Context context) {
        super(context);
        init();
    }

    public KeyStrokeEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public KeyStrokeEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        this.keyStrokeDetector = new KeyStrokeDetector(getContext());
    }

    @Override
    public InputConnection onCreateInputConnection(@NonNull EditorInfo outAttrs) {
        outAttrs.imeOptions = 1073741825;
        return this.keyStrokeDetector.createInputConnection(this, this.keyStrokeHandler);
    }

    @Override
    public boolean onCheckIsTextEditor() {
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (this.keyStrokeDetector.onKeyDown(keyCode, event, this.keyStrokeHandler)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (this.keyStrokeDetector.onKeyUp(keyCode, event, this.keyStrokeHandler)) {
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    public KeyStroke getKeyStroke() {
        return this.stroke;
    }

    public void setKeyStroke(@NonNull KeyStroke stroke) {
        this.stroke = stroke;
        setText(stroke.toString());
    }
}
