package ir.ninjacoder.prograsssheet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public abstract class CustomSheet extends BottomSheetDialog {

  public CustomSheet(Context context) {
    super(context, R.style.ThemeOverlay_App_BottomSheetDialog);
    setContentView(getView());
    setupBottomSheetBehavior();
  }

  public abstract View getView();

  private void setupBottomSheetBehavior() {
    View bottomSheet = findViewById(com.google.android.material.R.id.design_bottom_sheet);
    if (bottomSheet != null) {
      BottomSheetBehavior<View> behavior = BottomSheetBehavior.from(bottomSheet);
      behavior.setPeekHeight(BottomSheetBehavior.PEEK_HEIGHT_AUTO);
      behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
      behavior.setSkipCollapsed(true);
    }
  }

  public void setSizeBottomSheet(int width, int height) {
    if (width == 0 || height == 0) return;
    getWindow().setLayout(width, height);
  }

  public int getMatchParent() {
    return ViewGroup.LayoutParams.MATCH_PARENT;
  }

  public int getWrapcontent() {
    return ViewGroup.LayoutParams.WRAP_CONTENT;
  }

  public void setFullScreen() {
    View bottomSheet = findViewById(com.google.android.material.R.id.design_bottom_sheet);
    if (bottomSheet != null) {
      BottomSheetBehavior<View> behavior = BottomSheetBehavior.from(bottomSheet);
      behavior.setState(BottomSheetBehavior.STATE_EXPANDED); // باز کردن کامل
      behavior.setSkipCollapsed(true); // جلوگیری از جمع‌شدن
      behavior.setPeekHeight(0); // ارتفاع اولیه را صفر کنید

      // تنظیم LayoutParams برای Match Parent
      ViewGroup.LayoutParams params = bottomSheet.getLayoutParams();
      params.height = ViewGroup.LayoutParams.MATCH_PARENT;
      bottomSheet.setLayoutParams(params);
    }
  }
}
