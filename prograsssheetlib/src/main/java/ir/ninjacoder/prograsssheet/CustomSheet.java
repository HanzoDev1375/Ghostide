package ir.ninjacoder.prograsssheet;

import android.content.Context;
import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public abstract class CustomSheet extends BottomSheetDialog {

  public CustomSheet(Context context) {
    super(context,R.style.ThemeOverlay_App_BottomSheetDialog);
    setContentView(getView());
  }

  public abstract View getView();
}
