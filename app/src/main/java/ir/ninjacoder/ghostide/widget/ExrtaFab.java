package ir.ninjacoder.ghostide.widget;

import ir.ninjacoder.ghostide.R;
import android.content.Context;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import ir.ninjacoder.ghostide.utils.ObjectUtils;

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
	setBackground(ObjectUtils.getCookieShape());
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
