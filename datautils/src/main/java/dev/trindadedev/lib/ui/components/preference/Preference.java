package dev.trindadedev.lib.ui.components.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import dev.trindadedev.lib.ui.components.R;
import dev.trindadedev.lib.ui.components.databinding.LayoutPreferenceBinding;

public class Preference extends LinearLayout  {
  private LayoutPreferenceBinding bind;
  

  public Preference(Context context) {
    this(context, null);
  }

  public Preference(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
    init(context,attrs);
  }

  public Preference(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context, attrs);
  }

  private void init(Context context, AttributeSet attrs) {
     bind = LayoutPreferenceBinding.inflate(LayoutInflater.from(context));

    TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.Preference, 0, 0);

    try {
      String title = a.getString(R.styleable.Preference_preferenceTitle);
      String description = a.getString(R.styleable.Preference_preferenceDescription);
      bind.preferenceTitle.setText(title != null ? title : "");
      bind.preferenceDescription.setText(description != null ? description : "");
    } finally {
      a.recycle();
    }
    if(bind != null) {
      removeAllViews();
    	addView(bind.getRoot());
    }
  }


  public void setTitle(String value) {
    bind.preferenceTitle.setText(value);
  }

  public void setDescription(String value) {
    bind.preferenceDescription.setText(value);
  }
  
  public void setOnClickListener(OnClickListener c){
    bind.getRoot().setOnClickListener(c);
  }
  
}
