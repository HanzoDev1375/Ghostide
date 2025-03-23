package ir.ninjacoder.prograsssheet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.google.android.material.tabs.TabLayout;

public class ScalableTabLayout extends TabLayout {

  public ScalableTabLayout(Context context) {
    super(context);
  }

  public ScalableTabLayout(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public ScalableTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    ViewGroup tabLayout = (ViewGroup) getChildAt(0);
    int childCount = tabLayout.getChildCount();
    if (childCount > 0) {
      int widthPixels = MeasureSpec.getSize(widthMeasureSpec);
      int tabMinWidth = widthPixels / childCount;
      int remainderPixels = widthPixels % childCount;
      for (int i = 0; i < childCount; i++) {
        ViewGroup tab = (ViewGroup) tabLayout.getChildAt(i);
        if (remainderPixels > 0) {
          tab.setMinimumWidth(tabMinWidth + 1);
          remainderPixels--;
        } else {
          tab.setMinimumWidth(tabMinWidth);
        }
      }
    }
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
  }
}
