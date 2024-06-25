package com.mcal.uidesigner.common;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.mcal.uidesigner.databinding.DesignerSizedialogBinding;

public class SizePickerDialog extends MessageBox {
  private final Runnable neutral;
  private final ValueRunnable<String> ok;
  private final String oldValue;
  private final String title;
  private AlertDialog dialog;
  private boolean updatingText;
  private DesignerSizedialogBinding binding;

  public SizePickerDialog(
      String title, String oldValue, ValueRunnable<String> ok, Runnable neutral) {
    this.title = title;
    this.oldValue = oldValue;
    this.ok = ok;
    this.neutral = neutral;
  }

  @Override
  protected Dialog buildDialog(final Activity activity) {

    binding = DesignerSizedialogBinding.inflate(LayoutInflater.from(activity));
    TextInputEditText input = binding.designersizedialogEditText;
    input.setText(oldValue);
    SeekBar slider = binding.designersizedialogSeekBar;
    Button btn1 = binding.designersizedialogPlusButton;
    Button btn2 = binding.designersizedialogMinusButton;
    slider.setMax(100);
    updateSlider(slider, oldValue);
    slider.setOnSeekBarChangeListener(
        new SeekBar.OnSeekBarChangeListener() {
          @Override
          public void onProgressChanged(SeekBar p1, int p2, boolean p3) {
            if (!updatingText) {
              input.setText(getSliderValue(slider, input.getText().toString()));
            }
          }

          @Override
          public void onStartTrackingTouch(SeekBar p1) {}

          @Override
          public void onStopTrackingTouch(SeekBar p1) {}
        });
    input.addTextChangedListener(
        new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence p1, int p2, int p3, int p4) {}

          @Override
          public void onTextChanged(CharSequence p1, int p2, int p3, int p4) {
            updatingText = true;
            updateSlider(slider, input.getText().toString());
            updatingText = false;
          }

          @Override
          public void afterTextChanged(Editable p1) {}
        });

    btn1.setOnClickListener(
        p1 -> {
          input.setText(increase(input.getText().toString()));
          updateSlider(slider, input.getText().toString());
        });

    btn2.setOnClickListener(
        p1 -> {
          input.setText(decrease(input.getText().toString()));
          updateSlider(slider, input.getText().toString());
        });
    MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(activity);
    builder
        .setView(binding.getRoot())
        .setCancelable(true)
        .setPositiveButton(
            android.R.string.ok,
            (dialog, id) -> {
              ((InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE))
                  .hideSoftInputFromWindow(input.getWindowToken(), 0);
              dialog.dismiss();
              ok.run(input.getText().toString().trim());
            })
        .setNegativeButton(
            android.R.string.cancel,
            (dialog, id) -> {
              ((InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE))
                  .hideSoftInputFromWindow(input.getWindowToken(), 0);
              dialog.cancel();
            })
        .setNeutralButton(
            "None",
            (dialog, which) -> {
              ((InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE))
                  .hideSoftInputFromWindow(input.getWindowToken(), 0);
              neutral.run();
            });
    if (title != null) {
      builder.setTitle(title);
    }
    dialog = builder.create();
    input.setOnEditorActionListener(
        (v, actionId, event) -> {
          if (actionId == 6) {
            ((InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(input.getWindowToken(), 0);
            dialog.dismiss();
            ok.run(input.getText().toString().trim());
          }
          return false;
        });
    dialog.setCanceledOnTouchOutside(true);
    dialog.getWindow().setSoftInputMode(2);
    return dialog;
  }

  public String getSliderValue(SeekBar slider, String size) {
    String unit = getUnit(size);
    if (unit == null) {
      unit = "";
    }
    return slider.getProgress() + unit;
  }

  public void updateSlider(@NonNull SeekBar slider, String size) {
    slider.setProgress(Math.max(0, Math.min(100, getValue(size))));
  }

  public String increase(String size) {
    String unit = getUnit(size);
    if (unit != null) {
      return (getValue(size) + 1) + unit;
    }
    return size;
  }

  public String decrease(String size) {
    String unit = getUnit(size);
    if (unit != null) {
      return (getValue(size) - 1) + unit;
    }
    return size;
  }

  @Nullable
  private String getUnit(@NonNull String size) {
    if (size.length() == 0 || (!Character.isDigit(size.charAt(0)) && size.charAt(0) != '-')) {
      return null;
    }
    int p = 0;
    while (p < size.length() && (Character.isDigit(size.charAt(p)) || size.charAt(p) == '-')) {
      p++;
    }
    return size.substring(p);
  }

  private int getValue(@NonNull String size) {
    int p = 0;
    while (p < size.length() && (Character.isDigit(size.charAt(p)) || size.charAt(p) == '-')) {
      p++;
    }
    try {
      return Integer.parseInt(size.substring(0, p));
    } catch (NumberFormatException e) {
      return 0;
    }
  }
}
