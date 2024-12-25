package ir.ninjacoder.ghostide.config;

import ir.ninjacoder.ghostide.databinding.LayoutSwitchPrfensBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.content.Context;
import android.util.AttributeSet;

public class SwitchMaterialPrf extends RelativeLayout implements View.OnClickListener {
  private boolean value = false;

  private LayoutSwitchPrfensBinding binding;

  public SwitchMaterialPrf(Context context) {
    super(context);
    init(context);
  }

  public SwitchMaterialPrf(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context);
  }

  public SwitchMaterialPrf(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context);
  }

  void init(Context c) {
    binding = LayoutSwitchPrfensBinding.inflate(LayoutInflater.from(c));

    setOnClickListener(this);
    addView(binding.getRoot());
  }

  @Override
  public void onClick(View view) {
    // TODO: Implement this method
    setValue(!value);
  }

  public boolean getValue() {
    return this.value;
  }

  public void setValue(boolean value) {
    this.value = value;
    binding.preferenceSwitch.setChecked(value);
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
}
