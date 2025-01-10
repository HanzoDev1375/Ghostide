package ninjacoder.ghostide.androidtools.r8.android;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

public class DataRowUtil {
  private Context context;

  public DataRowUtil(Context context) {
    this.context = context;
  }

  public int dp(float size) {
    return Math.round(context.getResources().getDisplayMetrics().density * size);
  }

  public void setMargins(
      View view, int startMargin, int topMargin, int endMargin, int bottomMargin) {
    ViewGroup.MarginLayoutParams layoutParams =
        (ViewGroup.MarginLayoutParams) view.getLayoutParams();
    layoutParams.setMargins(dp(startMargin), dp(topMargin), dp(endMargin), dp(bottomMargin));
  }

  public int dpToPx(float dp) {
    return Math.round(
        TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics()));
  }
}
