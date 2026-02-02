package ir.ninjacoder.prograsssheet.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatImageView;

public class ButtonAnim extends AppCompatImageView {

  private boolean pressedInside = false;
  private boolean isEnabled = true;

  public ButtonAnim(Context c) {
    super(c);
    init();
  }

  public ButtonAnim(Context c, AttributeSet a) {
    super(c, a);
    init();
  }

  public ButtonAnim(Context c, AttributeSet a, int s) {
    super(c, a, s);
    init();
  }

  private void init() {
    setClickable(true);
  }

  @Override
  public boolean onTouchEvent(MotionEvent e) {
    switch (e.getActionMasked()) {
      case MotionEvent.ACTION_DOWN:
        pressedInside = true;
        animate().scaleX(0.9f).scaleY(0.9f).setDuration(80).start();
        return true;

      case MotionEvent.ACTION_UP:
        animate().scaleX(1f).scaleY(1f).setDuration(80).start();
        if (pressedInside && isInside(e) && isEnabled) performClick();
        pressedInside = false;
        return true;

      case MotionEvent.ACTION_CANCEL:
        pressedInside = false;
        animate().scaleX(1f).scaleY(1f).setDuration(80).start();
        return true;
    }
    return super.onTouchEvent(e);
  }

  private boolean isInside(MotionEvent e) {
    return e.getX() >= 0 && e.getX() <= getWidth() && e.getY() >= 0 && e.getY() <= getHeight();
  }

  public void setActive(boolean b) {
    setAlpha(b ? 1f : 0.3f);
    isEnabled = b;
  }
}
