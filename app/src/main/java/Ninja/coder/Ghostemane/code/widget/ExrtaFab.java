package Ninja.coder.Ghostemane.code.widget;

import Ninja.coder.Ghostemane.code.R;
import android.content.Context;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class ExrtaFab extends ExtendedFloatingActionButton {

  public ExrtaFab(Context c) {
    super(c);
    init();
  }

  public ExrtaFab(Context c, AttributeSet v) {
    super(c, v);
    init();
  }

  public void init() {
    setIconResource(R.drawable.ic_fab_play);
    shrink();
    setBackground(ContextCompat.getDrawable(getContext(),R.drawable.compilerr));
    
  }

  public void setColorFilter(int color) {
    
  }

  public boolean isHide() {
    return getVisibility() == GONE ? true : false;
  }

  public boolean isShow() {
    return getVisibility() == VISIBLE ? true : false;
  }
}
