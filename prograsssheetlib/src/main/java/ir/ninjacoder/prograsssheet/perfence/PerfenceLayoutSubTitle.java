package ir.ninjacoder.prograsssheet.perfence;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import ir.ninjacoder.prograsssheet.R;
import ir.ninjacoder.prograsssheet.databinding.LayoutPerfenceGroupsBinding;
import ir.ninjacoder.prograsssheet.enums.ModBackground;

public class PerfenceLayoutSubTitle extends LinearLayoutCompat {
  private LayoutPerfenceGroupsBinding binding;
  private ModBackground mod = ModBackground.NONE;

  public PerfenceLayoutSubTitle(Context context, AttributeSet set) {
    super(context, set);
    init(set,context);
  }

  void init(AttributeSet attrs,Context context) {
    binding = LayoutPerfenceGroupsBinding.inflate(LayoutInflater.from(getContext()));
    if (binding != null) {
      removeAllViews();
      addView(binding.getRoot());
      LinearLayoutCompat.LayoutParams params =
          new LinearLayoutCompat.LayoutParams(
              LinearLayoutCompat.LayoutParams.MATCH_PARENT,
              LinearLayoutCompat.LayoutParams.WRAP_CONTENT);

      binding.getRoot().setLayoutParams(params);
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
  }

  public void setTitle(String value) {
    binding.preferenceTitle.setText(value);
  }

  public void setDescription(String value) {
    binding.description.setText(value);
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
}
