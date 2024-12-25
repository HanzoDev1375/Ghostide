package ir.ninjacoder.ghostide.project.Premiumversion;

import ir.ninjacoder.ghostide.ApplicationLoader;
import android.widget.LinearLayout;
import static android.widget.LinearLayout.LayoutParams.MATCH_PARENT;
import static android.widget.LinearLayout.LayoutParams.WRAP_CONTENT;
import com.google.android.material.textview.MaterialTextView;

public class Premium {
  public static boolean isPremium = false;
  public static boolean isUser = false;
  public static boolean isAdmin = false;
  public static boolean isShowBottomSheet = false;
  public static boolean isPaymenthasbeenmade = false;

  public static void ShowDialog() {
    var context = ApplicationLoader.getContext();
    LinearLayout layout = new LinearLayout(context, null);
    var allParam = new LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT);
    layout.setPadding(8, 8, 8, 8);
    layout.setOrientation(LinearLayout.VERTICAL);
    var viewtv = new MaterialTextView(context, null);
    var tvparam = new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT);
    viewtv.setLayoutParams(tvparam);
    
    if (layout != null) {
      layout.addView(viewtv);
    }
    
  }
}
