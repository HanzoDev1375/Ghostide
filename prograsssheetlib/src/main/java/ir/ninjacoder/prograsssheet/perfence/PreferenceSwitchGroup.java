package ir.ninjacoder.prograsssheet.perfence;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.google.android.material.materialswitch.MaterialSwitch;
import ir.ninjacoder.prograsssheet.R;
import ir.ninjacoder.prograsssheet.databinding.LayoutSwitchPerfenceBinding;
import ir.ninjacoder.prograsssheet.enums.ModBackground;

public class PreferenceSwitchGroup extends RelativeLayout implements View.OnClickListener {

  public boolean value = false;
  private LayoutSwitchPerfenceBinding binding;
  private ModBackground mod = ModBackground.NONE;

  public PreferenceSwitchGroup(Context context) {
    super(context);
    initialize(context, null);
  }

  public PreferenceSwitchGroup(Context context, AttributeSet attrs) {
    super(context, attrs);
    initialize(context, attrs);
  }

  public PreferenceSwitchGroup(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    initialize(context, attrs);
  }

  public void initialize(Context context, AttributeSet attrs) {
    binding = LayoutSwitchPerfenceBinding.inflate(LayoutInflater.from(context));
    RelativeLayout.LayoutParams params =
        new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

    binding.getRoot().setLayoutParams(params);
    if (binding != null) {
      removeAllViews();
      addView(binding.getRoot());
    }
    setOnClickListener(this);
    showicon(false);
    if (attrs != null) {
      TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.PreferenceSwitchGroup);
      int modBackground = a.getInt(R.styleable.PreferenceSwitchGroup_modBackground, 0);
      a.recycle();

      switch (modBackground) {
        case 0:
          mod = ModBackground.NONE;
          break;
        case 1:
          mod = ModBackground.TOP;
          break;
        case 2:
          mod = ModBackground.MIDDLE;
          break;
        case 3:
          mod = ModBackground.BOTTOM;
          break;
      }
      updateBackground();
    }
  }

  public boolean getValue() {
    return value;
  }

  public void setIcon(int res) {
    binding.preferenceIcon.setImageResource(res);
    showicon(true);
  }

  public void setIcon(Drawable icon) {
    binding.preferenceIcon.setImageDrawable(icon);
    showicon(true);
  }

  public void setIcon(Bitmap icon) {
    binding.preferenceIcon.setImageBitmap(icon);
    showicon(true);
  }

  public void setIconPath(String path) {
    showicon(true);
    if (!path.isEmpty())
      Glide.with(binding.preferenceIcon.getContext()).load(path).into(binding.preferenceIcon);
  }

  public void setValue(boolean value) {
    this.value = value;
    binding.preferenceSwitch.setChecked(value);
  }

  @Override
  public void onClick(View view) {
    setValue(!value);
  }

  public void setDescription(String value) {
    binding.preferenceDescription.setText(value);
  }

  public void setTitle(String value) {
    binding.preferenceName.setText(value);
  }

  public void setSwitchChangedListener(
      CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
    binding.preferenceSwitch.setOnCheckedChangeListener(onCheckedChangeListener);
  }

  public void setBackgroundMod(ModBackground mod) {
    this.mod = mod;
    updateBackground();
  }

  public void updateBackground() {
    switch (mod) {
      case BOTTOM:
        setBackground(Shape.bottom(this));
        break;
      case TOP:
        setBackground(Shape.top(this));
        break;
      case MIDDLE:
        setBackground(Shape.middel(this));
        break;
      case NONE:
        setBackgroundColor(Color.TRANSPARENT);
        break;
    }
  }

  public MaterialSwitch getSwitch() {
    return binding.preferenceSwitch;
  }

  public void setIconColorFilter(int color) {
    binding.preferenceIcon.setColorFilter(color);
  }

  public TextView getTitle() {
    return binding.preferenceName;
  }

  public TextView getDescription() {
    return binding.preferenceDescription;
  }

  public ImageView getIcon() {
    return binding.preferenceIcon;
  }

  void showicon(boolean show) {
    binding.preferenceIcon.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
  }
}
