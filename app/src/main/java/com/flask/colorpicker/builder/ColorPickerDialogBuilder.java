package com.flask.colorpicker.builder;

import Ninja.coder.Ghostemane.code.utils.ColorAndroid12;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import androidx.appcompat.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.text.InputFilter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorChangedListener;
import com.flask.colorpicker.OnColorSelectedListener;
import Ninja.coder.Ghostemane.code.R;
import com.flask.colorpicker.Utils;
import com.flask.colorpicker.renderer.ColorWheelRenderer;
import com.flask.colorpicker.slider.AlphaSlider;
import com.flask.colorpicker.slider.LightnessSlider;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class ColorPickerDialogBuilder {

    private MaterialAlertDialogBuilder di;
    private LinearLayout pickerContainer;
    private ColorPickerView colorPickerView;
    private LightnessSlider lightnessSlider;
    private AlphaSlider alphaSlider;
    private LinearLayout colorPreview;

    private boolean isLightnessSliderEnabled = true;
    private boolean isAlphaSliderEnabled = true;
    private boolean isBorderEnabled = true;
    private boolean isColorEditEnabled = false;
    private boolean isPreviewEnabled = false;
    private int pickerCount = 1;
    private int defaultMargin = 0;
    private int defaultMarginTop = 0;
    private Integer[] initialColor = new Integer[]{null, null, null, null, null};

    private ColorPickerDialogBuilder(Context context) {
        this(context, 0);
    }

    private ColorPickerDialogBuilder(Context context, int theme) {

        di = new MaterialAlertDialogBuilder(context);
        di.setBackground(ColorAndroid12.getColor(context, 20));
        pickerContainer = new LinearLayout(context);
        pickerContainer.setOrientation(LinearLayout.VERTICAL);
        pickerContainer.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        pickerContainer.setPadding(defaultMargin, defaultMarginTop, defaultMargin, 0);

        LinearLayout.LayoutParams layoutParamsForColorPickerView =
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0);
        layoutParamsForColorPickerView.weight = 1;
        colorPickerView = new ColorPickerView(context);

        pickerContainer.addView(colorPickerView, layoutParamsForColorPickerView);

        di.setView(pickerContainer);
    }

    public static ColorPickerDialogBuilder with(Context context) {
        return new ColorPickerDialogBuilder(context);
    }

    public static ColorPickerDialogBuilder with(Context context, int theme) {
        return new ColorPickerDialogBuilder(context, theme);
    }

    public ColorPickerDialogBuilder setTitle(String title) {
        di.setTitle(title);
        return this;
    }

    public ColorPickerDialogBuilder setTitle(int titleId) {
        di.setTitle(titleId);
        return this;
    }

    public ColorPickerDialogBuilder initialColor(int initialColor) {
        this.initialColor[0] = initialColor;
        return this;
    }

    public ColorPickerDialogBuilder initialColors(int[] initialColor) {
        for (int i = 0; i < initialColor.length && i < this.initialColor.length; i++) {
            this.initialColor[i] = initialColor[i];
        }
        return this;
    }

    public ColorPickerDialogBuilder wheelType(ColorPickerView.WHEEL_TYPE wheelType) {
        ColorWheelRenderer renderer = ColorWheelRendererBuilder.getRenderer(wheelType);
        colorPickerView.setRenderer(renderer);
        return this;
    }

    public ColorPickerDialogBuilder density(int density) {
        colorPickerView.setDensity(density);
        return this;
    }

    public ColorPickerDialogBuilder setOnColorChangedListener(
            OnColorChangedListener onColorChangedListener) {
        colorPickerView.addOnColorChangedListener(onColorChangedListener);
        return this;
    }

    public ColorPickerDialogBuilder setOnColorSelectedListener(
            OnColorSelectedListener onColorSelectedListener) {
        colorPickerView.addOnColorSelectedListener(onColorSelectedListener);
        return this;
    }

    public ColorPickerDialogBuilder setPositiveButton(
            CharSequence text, final ColorPickerClickListener onClickListener) {
        di.setPositiveButton(
                text,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        positiveButtonOnClick(dialog, onClickListener);
                    }
                });
        return this;
    }

    public ColorPickerDialogBuilder setPositiveButton(
            int textId, final ColorPickerClickListener onClickListener) {
        di.setPositiveButton(
                textId,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        positiveButtonOnClick(dialog, onClickListener);
                    }
                });
        return this;
    }

    public ColorPickerDialogBuilder setNegativeButton(
            CharSequence text, DialogInterface.OnClickListener onClickListener) {
        di.setNegativeButton(text, onClickListener);
        return this;
    }

    public ColorPickerDialogBuilder setNegativeButton(
            int textId, DialogInterface.OnClickListener onClickListener) {
        di.setNegativeButton(textId, onClickListener);
        return this;
    }

    public ColorPickerDialogBuilder noSliders() {
        isLightnessSliderEnabled = false;
        isAlphaSliderEnabled = false;
        return this;
    }

    public ColorPickerDialogBuilder alphaSliderOnly() {
        isLightnessSliderEnabled = false;
        isAlphaSliderEnabled = true;
        return this;
    }

    public ColorPickerDialogBuilder lightnessSliderOnly() {
        isLightnessSliderEnabled = true;
        isAlphaSliderEnabled = false;
        return this;
    }

    public ColorPickerDialogBuilder showAlphaSlider(boolean showAlpha) {
        isAlphaSliderEnabled = showAlpha;
        return this;
    }

    public ColorPickerDialogBuilder showLightnessSlider(boolean showLightness) {
        isLightnessSliderEnabled = showLightness;
        return this;
    }

    public ColorPickerDialogBuilder showBorder(boolean showBorder) {
        isBorderEnabled = showBorder;
        return this;
    }

    public ColorPickerDialogBuilder showColorEdit(boolean showEdit) {
        isColorEditEnabled = showEdit;
        return this;
    }

    public ColorPickerDialogBuilder setColorEditTextColor(int argb) {
        colorPickerView.setColorEditTextColor(argb);
        return this;
    }

    public ColorPickerDialogBuilder showColorPreview(boolean showPreview) {
        isPreviewEnabled = showPreview;
        if (!showPreview) pickerCount = 1;
        return this;
    }

    public ColorPickerDialogBuilder setPickerCount(int pickerCount) throws IndexOutOfBoundsException {
        if (pickerCount < 1 || pickerCount > 5)
            throw new IndexOutOfBoundsException("Picker Can Only Support 1-5 Colors");
        this.pickerCount = pickerCount;
        if (this.pickerCount > 1) this.isPreviewEnabled = true;
        return this;
    }

    public AlertDialog build() {
        Context context = di.getContext();
        colorPickerView.setInitialColors(initialColor, getStartOffset(initialColor));
        colorPickerView.setShowBorder(isBorderEnabled);

        if (isLightnessSliderEnabled) {
            LinearLayout.LayoutParams layoutParamsForLightnessBar =
                    new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 40);
            lightnessSlider = new LightnessSlider(context);
            lightnessSlider.setLayoutParams(layoutParamsForLightnessBar);
            layoutParamsForLightnessBar.topMargin = 3;
            layoutParamsForLightnessBar.bottomMargin = 3;
            pickerContainer.addView(lightnessSlider);
            colorPickerView.setLightnessSlider(lightnessSlider);
            lightnessSlider.setColor(getStartColor(initialColor));
            lightnessSlider.setShowBorder(isBorderEnabled);
        }
        if (isAlphaSliderEnabled) {
            LinearLayout.LayoutParams layoutParamsForAlphaBar =
                    new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 40);
            layoutParamsForAlphaBar.bottomMargin = 3;
            layoutParamsForAlphaBar.topMargin = 3;
            alphaSlider = new AlphaSlider(context);
            alphaSlider.setLayoutParams(layoutParamsForAlphaBar);
            pickerContainer.addView(alphaSlider);
            colorPickerView.setAlphaSlider(alphaSlider);
            alphaSlider.setColor(getStartColor(initialColor));
            alphaSlider.setShowBorder(isBorderEnabled);
        }
        if (isColorEditEnabled) {

            LayoutInflater ipm = LayoutInflater.from(context);
            LinearLayout mninjacoder = (LinearLayout) ipm.inflate(R.layout.hi100, null, false);
            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            mninjacoder.setLayoutParams(params);
            com.google.android.material.textfield.TextInputLayout inputLayout =
                    mninjacoder.findViewById(R.id.inputLayout);
            com.google.android.material.textfield.TextInputEditText colorEdit =
                    mninjacoder.findViewById(R.id.colorEdit);
            LinearLayout layout = mninjacoder.findViewById(R.id.layout);

            //	colorEdit = (EditText) View.inflate(context, R.layout.color_edit, null);

            colorEdit.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
            colorEdit.setSingleLine();
            colorEdit.setVisibility(View.GONE);
            // limit number of characters to hexColors
            int maxLength = isAlphaSliderEnabled ? 9 : 7;
            colorEdit.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});
            inputLayout.setBoxBackgroundMode(TextInputLayout.BOX_BACKGROUND_OUTLINE);

            inputLayout.setCounterEnabled(true);
            inputLayout.setErrorEnabled(true);
            inputLayout.setCounterMaxLength(9);
            inputLayout.setCounterTextColor(ColorStateList.valueOf(MaterialColors.getColor(inputLayout, ColorAndroid12.TvColor)));
            colorEdit.setHintTextColor(MaterialColors.getColor(colorEdit, ColorAndroid12.TvColor));
            colorEdit.setCursorVisible(false);

            // colorEdit.setHighlightColor(Color.parseColor("#FF8D86"));
            colorEdit.setTypeface(Typeface.SANS_SERIF);
            inputLayout.setBoxCornerRadii(50, 50, 50, 50);
            try {
                colorEdit.setTextColor(getStartColor(initialColor));
            } catch (Exception p) {
                colorEdit.setTextColor(0xFFFDA893);
            }

            inputLayout.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
            colorEdit.setText(Utils.getHexString(getStartColor(initialColor), isAlphaSliderEnabled));
            if (colorEdit.getText().toString().isEmpty()) {
                inputLayout.setError("رنگی انتخاب کنید");
            } else {
                inputLayout.setErrorEnabled(false);
            }
            colorPickerView.setColorEdit(colorEdit);

            pickerContainer.addView(mninjacoder);
        }
        if (isPreviewEnabled) {
            colorPreview = (LinearLayout) View.inflate(context, R.layout.color_preview, null);
            colorPreview.setVisibility(View.GONE);
            pickerContainer.addView(colorPreview);

            if (initialColor.length == 0) {
                ImageView colorImage = (ImageView) View.inflate(context, R.layout.color_selector, null);

            } else {
                for (int i = 0; i < initialColor.length && i < this.pickerCount; i++) {
                    if (initialColor[i] == null) break;

                    LinearLayout colorLayout =
                            (LinearLayout) View.inflate(context, R.layout.color_selector, null);
                    ImageView colorImage = (ImageView) colorLayout.findViewById(R.id.image_preview);
                    colorImage.setImageDrawable(new ColorDrawable(initialColor[i]));
                    MaterialShapeDrawable shapeDrawable =
                            new MaterialShapeDrawable(
                                    ShapeAppearanceModel.builder().setAllCorners(CornerFamily.CUT, 23f).build());
                    shapeDrawable.setFillColor(
                            ColorStateList.valueOf(MaterialColors.getColor(context, ColorAndroid12.Back, 0)));
                    shapeDrawable.setStroke(
                            2f,
                            ColorStateList.valueOf(MaterialColors.getColor(context, ColorAndroid12.TvColor, 0)));
                    colorImage.setBackground(shapeDrawable);
                    colorPreview.addView(colorLayout);
                }
            }
            colorPreview.setVisibility(View.VISIBLE);
            colorPickerView.setColorPreview(colorPreview, getStartOffset(initialColor));
        }

        return di.create();
    }

    private Integer getStartOffset(Integer[] colors) {
        Integer start = 0;
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == null) {
                return start;
            }
            start = (i + 1) / 2;
        }
        return start;
    }

    private int getStartColor(Integer[] colors) {
        Integer startColor = getStartOffset(colors);
        return startColor == null ? Color.TRANSPARENT : colors[startColor];
    }

    private void positiveButtonOnClick(
            DialogInterface dialog, ColorPickerClickListener onClickListener) {
        int selectedColor = colorPickerView.getSelectedColor();
        Integer[] allColors = colorPickerView.getAllColors();
        onClickListener.onClick(dialog, selectedColor, allColors);
    }
}
