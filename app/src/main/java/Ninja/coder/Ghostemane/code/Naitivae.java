package Ninja.coder.Ghostemane.code;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.Window;
import android.graphics.Color;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.os.Build;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

public class Naitivae {
  protected static final int Sdk = Build.VERSION.SDK_INT;
  protected static final int Code = Build.VERSION_CODES.LOLLIPOP;

  public static void init(Activity activity) {
    if (Sdk > Code) {
      Window code = activity.getWindow();
      code.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
      code.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
      code.setStatusBarColor(Color.parseColor("#FF2B2122"));
      code.setNavigationBarColor(Color.parseColor("#FF2B2122"));
    }
  }

  public static void init(Activity activity, String color) {

    /*
    * @param = getSdk app -> Android 5
    *
    * @param Code -> App Android mode ;
    *
    * @param String color -> Type Your Hex Color
    *

    */
    if (Sdk > Code) {
      Window code = activity.getWindow();
      code.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
      code.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
      code.setStatusBarColor(Color.parseColor(color));
      code.setNavigationBarColor(Color.parseColor(color));
    }
  }

  public static void backColor(Activity a) {
    /*
     * @param Context set Context
     * @param Auto set Color
     * @param test throw
     *
     *
     */
    if (a != null) a.getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF2B2122"));
  }

  public static void backColor(Activity a, String color) {
    /*
     * @param Context set Context
     * @param Auto set Color
     * @param test throw
     */
    if (a != null) a.getWindow().getDecorView().setBackgroundColor(Color.parseColor(color));
  }

  public static void FragmentModeAnim(DialogFragment dialogFragment, int Anim) {
    /*
     * @param level 1 Set DialogFragment
     * @param level 2 Set Cuostom Animator or Used default Animator android
     * default Animator android
     * android.R.anim.fede_in
     * Tanks im mohamoad
     */

    if (dialogFragment.getDialog() == null)
      dialogFragment.getDialog().getWindow().setWindowAnimations(Anim);
  }

  // Naitivae.FragmentStatusAndNativeView(this,"");

  public static void FragmentStatusAndNativeView(DialogFragment dialogFragment, String color) {
    /*
     * @param in code Using Custom Status bar and Native bar Color in Framgent
     * @param dont Use int Color me using color im Color.parse("#YourColor")
     */

    if (Sdk > Code) {
      Window code = dialogFragment.getActivity().getWindow();
      code.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
      code.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
      code.setStatusBarColor(Color.parseColor(color));
      code.setNavigationBarColor(Color.parseColor(color));
    }
  }

  public static void FragmentStatusAndNativeView(Fragment dialogFragment, String color) {
    /*
     * @param in code Using Custom Status bar and Native bar Color in Framgent
     * @param dont Use int Color me using color im Color.parse("#YourColor")
     */

    if (Sdk > Code) {
      Window code = dialogFragment.getActivity().getWindow();
      code.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
      code.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
      code.setStatusBarColor(Color.parseColor(color));
      code.setNavigationBarColor(Color.parseColor(color));
    }
  }
}
