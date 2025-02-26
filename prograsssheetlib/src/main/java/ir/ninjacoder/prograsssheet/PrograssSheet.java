/**
 * Comment by ghost ide
 *
 * @author: Ninjacoder
 */
package ir.ninjacoder.prograsssheet;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.annotation.StringRes;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import ir.ninjacoder.prograsssheet.databinding.LayoutDialogsheetPrograssBinding;
import ir.ninjacoder.prograsssheet.enums.StateMod;

public class PrograssSheet {
  private Context context;
  private BottomSheetDialog dialog;
  private LayoutDialogsheetPrograssBinding bindig;
  private StateMod mod = StateMod.PROGRASSV;

  public PrograssSheet(Context context) {
    this.context = context;
    bindig = LayoutDialogsheetPrograssBinding.inflate(LayoutInflater.from(context));
    dialog = new BottomSheetDialog(context);
    dialog.setContentView(bindig.getRoot());
    bindig.bar.setTrackThickness(12);
    setMode(mod);
  }

  public PrograssSheet show() {
    if (dialog != null) dialog.show();
    return this;
  }

  public PrograssSheet setTitle(String text) {
    if (mod == StateMod.PROGRASSH) {
      bindig.sheettitle.setText(text);
    } else if(mod == StateMod.PROGRASSV) bindig.sheettitlev.setText(text);
    return this;
  }

  public PrograssSheet setTitle(@StringRes int text) {
    if (mod == StateMod.PROGRASSH) {
      bindig.sheettitle.setText(text);
    } else bindig.sheettitlev.setText(text);

    return this;
  }
  
  public PrograssSheet setTitleColor(int color){
    if(mod == StateMod.PROGRASSH) {
    	  bindig.sheettitle.setTextColor(color);
    }else bindig.sheettitlev.setTextColor(color);
    
    return this;
  }

  public PrograssSheet dismiss() {
    dialog.dismiss();

    return this;
  }

  public PrograssSheet setCancelable(boolean is) {
    dialog.setCancelable(is);
    return this;
  }

  public boolean isShowing() {
    return dialog.isShowing();
  }

  public PrograssSheet showBottonLayout(boolean r) {
    if (bindig.layoutbutton.getVisibility() == View.GONE) {
      bindig.layoutbutton.setVisibility(View.VISIBLE);
    }
    return this;
  }

  public PrograssSheet clickButton(View.OnClickListener click) {
    bindig.butttoncancel.setOnClickListener(click);

    return this;
  }

  public PrograssSheet setTextButton(String text) {
    bindig.butttoncancel.setText(text);
    return this;
  }

  public Button getButton() {
    return bindig.butttoncancel;
  }

  public CircularProgressIndicator getPrograssBar() {
    return bindig.bar;
  }

  public PrograssSheet setMode(StateMod mod) {
    this.mod = mod;
    if (mod == StateMod.PROGRASSH) {
      bindig.statgev.setVisibility(View.GONE);
      bindig.statgeh.setVisibility(View.VISIBLE);
    } else if (mod == StateMod.PROGRASSV) {
      bindig.statgev.setVisibility(View.VISIBLE);
      bindig.statgeh.setVisibility(View.GONE);
    }
    return this;
  }

  public StateMod getMod() {
    return mod;
  }

  public PrograssSheet setPrograss(int data, boolean item) {
    if (mod == StateMod.PROGRASSH) {
      bindig.bar.setProgressCompat(data, item);
    } else bindig.barv.setProgressCompat(data, item);

    return this;
  }

  public PrograssSheet setPrograssColor(int color) {
    if (mod == StateMod.PROGRASSH) {
      bindig.bar.setProgressTintList(ColorStateList.valueOf(color));
    } else bindig.barv.setProgressTintList(ColorStateList.valueOf(color));

    return this;
  }
}
