package ir.ninjacoder.prograsssheet.perfence;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import ir.ninjacoder.prograsssheet.R;
import ir.ninjacoder.prograsssheet.databinding.LayoutPerfenceGroupsBinding;
import ir.ninjacoder.prograsssheet.enums.ModBackground;
import java.util.List;

public class PerfenceLayoutSubTitle extends LinearLayout {
  private LayoutPerfenceGroupsBinding binding;
  private ModBackground mod = ModBackground.NONE;

  public PerfenceLayoutSubTitle(Context context) {
    super(context, null);
    init(null, context);
  }

  public PerfenceLayoutSubTitle(Context context, AttributeSet set) {
    super(context, set);
    init(set, context);
  }

  void init(AttributeSet attrs, Context context) {
    binding = LayoutPerfenceGroupsBinding.inflate(LayoutInflater.from(getContext()));
    if (binding != null) {
      removeAllViews();
      addView(binding.getRoot());
      LinearLayout.LayoutParams params =
          new LinearLayout.LayoutParams(
              LinearLayout.LayoutParams.MATCH_PARENT,
              LinearLayout.LayoutParams.WRAP_CONTENT);

      binding.getRoot().setLayoutParams(params);
      if (attrs != null) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.PreferenceSwitchGroup);
        int modBackground = a.getInt(R.styleable.PreferenceSwitchGroup_modBackground, 0);
        a.recycle();

        switch (modBackground) {
          case 0 -> mod = ModBackground.NONE;
          case 1 -> mod = ModBackground.TOP;
          case 2 -> mod = ModBackground.MIDDLE;
          case 3 -> mod = ModBackground.BOTTOM;
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

  public void setTextSetting(String title) {
    binding.preferenceTitle.setText(title);
    binding.description.setVisibility(INVISIBLE);
  }

  public void setBackgroundMod(ModBackground mod) {
    this.mod = mod;
    updateBackground();
  }

  public <T> Drawable get(List<T> list, int position) {
    if (list.size() == 1) {
      return Shape.bottom(this);
    } else if (position == 0) {
      return Shape.top(this);
    } else if (position == list.size() - 1) {
      return Shape.bottom(this);
    } else {
      return Shape.middel(this);
    }
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
