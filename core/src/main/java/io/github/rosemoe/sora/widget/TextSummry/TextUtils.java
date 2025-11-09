package io.github.rosemoe.sora.widget.TextSummry;

import android.graphics.Paint;
import android.widget.TextView;

import com.google.android.material.textview.MaterialTextView;


public class TextUtils {
    private TextView view;

    public TextUtils(MaterialTextView view) {
        this.view = view;
    }

    public void setKeyWordHtmlNotWork() {
        if (view.getText().toString().endsWith("acronym")) {
            view = getFlage();
        } else if (view.getText().toString().endsWith("applet")) {
            view = getFlage();
        } else if (view.getText().toString().endsWith("basefont")) {
            view = getFlage();
        } else if (view.getText().toString().endsWith("big")) {
            view = getFlage();
        } else if (view.getText().toString().endsWith("center")) {
            view = getFlage();
        } else if (view.getText().toString().endsWith("dir")) {
            view = getFlage();
        } else if (view.getText().toString().endsWith("font")) {
            view = getFlage();
        } else if (view.getText().toString().endsWith("frame")) {
            view = getFlage();
        } else if (view.getText().toString().endsWith("frameset")) {
            view = getFlage();
        } else if (view.getText().toString().endsWith("isindex")) {
            view = getFlage();
        } else if (view.getText().toString().endsWith("menu")) {
            view = getFlage();
        } else if (view.getText().toString().endsWith("noframes")) {
            view = getFlage();
        } else if (view.getText().toString().endsWith("s")) {
            view = getFlage();
        } else if (view.getText().toString().endsWith("strike")) {
            view = getFlage();
        } else if (view.getText().toString().endsWith("tt")) {
            view = getFlage();
        } else if (view.getText().toString().endsWith("u")) {
            view = getFlage();
        }
    }

    private TextView getFlage() {
        view.setPaintFlags(view.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        return view;
    }
}