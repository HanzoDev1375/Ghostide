package dev.trindadedev.lib.ui.components.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import dev.trindadedev.lib.ui.components.R;
import dev.trindadedev.lib.ui.components.databinding.LayoutPreferenceGroupBinding;

public class PreferenceGroup extends LinearLayout {
  private LayoutPreferenceGroupBinding bind;

  public PreferenceGroup(Context context) {
    this(context, null);
  }

  public PreferenceGroup(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public PreferenceGroup(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    bind = LayoutPreferenceGroupBinding.inflate(LayoutInflater.from(context));

    TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.PreferenceGroup);
    try {
      String title = typedArray.getString(R.styleable.PreferenceGroup_preferenceGroupTitle);
      if (title != null) {
        bind.preferenceGroupTitle.setText(title);
      }
    } finally {
      typedArray.recycle();
    }
    
    if(bind!=null) {
    	removeAllViews();
        addView(bind.getRoot());
    }
  }
  public void setOnClickListener(OnClickListener listener) {
    bind.getRoot().setOnClickListener(listener);
  }
}
