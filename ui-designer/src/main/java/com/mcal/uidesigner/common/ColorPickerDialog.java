package com.mcal.uidesigner.common;

import static com.mcal.uidesigner.utils.Utils.toHexColor;

import android.app.Activity;
import android.app.Dialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.mcal.uidesigner.R;
import com.mcal.uidesigner.view.ColorPickerView;

public class ColorPickerDialog extends MessageBox {
    private final ColorRunnable ok;
    private final String oldHexColor;
    private final String title;
    private boolean allowsNone;
    private int newColor;
    private String newHexColor;
    private boolean updatingColorPicker;
    private boolean updatingEditText;

    public ColorPickerDialog(String title, String hexColor, ColorRunnable ok) {
        if (hexColor == null) {
            oldHexColor = "#000000";
        } else {
            oldHexColor = hexColor;
        }
        newHexColor = oldHexColor;
        newColor = ColorPickerView.parseColor(newHexColor);
        this.ok = ok;
        allowsNone = true;
        this.title = title;
    }

    public ColorPickerDialog(String title, int color, ColorRunnable ok) {
        oldHexColor = toHexColor(color);
        newHexColor = oldHexColor;
        newColor = color;
        this.ok = ok;
        this.title = title;
    }

    @Override
    protected Dialog buildDialog(Activity activity) {
        final View layout = LayoutInflater.from(activity).inflate(R.layout.colorpicker, null);
        final ColorPickerView colorPickerView = layout.findViewById(R.id.colorpickerColorPickerView);
        final EditText editText = layout.findViewById(R.id.colorpickerEditText);
        colorPickerView.setOnColorChangedListener((color, hexColor) -> {
            if (!updatingEditText) {
                updatingColorPicker = true;
                editText.setText(hexColor);
                updatingColorPicker = false;
            }
            newHexColor = hexColor;
            newColor = color;
        });
        colorPickerView.setInitialColor(oldHexColor);
        colorPickerView.setCurrentColor(oldHexColor);
        editText.setText(oldHexColor);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence p1, int p2, int p3, int p4) {
            }

            @Override
            public void onTextChanged(CharSequence str, int p2, int p3, int p4) {
                if (!updatingColorPicker) {
                    updatingEditText = true;
                    colorPickerView.setCurrentColor(str.toString());
                    updatingEditText = false;
                }
            }

            @Override
            public void afterTextChanged(Editable p1) {
            }
        });
        final MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(activity);
        builder.setView(layout);
        builder.setCancelable(true);
        builder.setPositiveButton(android.R.string.ok, (dialog, id) -> {
            dialog.dismiss();
            ok.run(newColor, newHexColor);
        });
        builder.setNegativeButton(android.R.string.cancel, (dialog, which) -> dialog.cancel());
        if (allowsNone) {
            builder.setNeutralButton("None", (dialog, which) -> ok.run(0, null));
        }
        builder.setTitle(title);
        AlertDialog dialog = builder.create();
        dialog.getWindow().setSoftInputMode(2);
        return dialog;
    }

    public interface ColorRunnable {
        void run(int i, String str);
    }
}
