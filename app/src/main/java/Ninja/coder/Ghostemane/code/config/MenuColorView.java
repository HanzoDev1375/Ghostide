package Ninja.coder.Ghostemane.code.config;

import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.allenliu.badgeview.BadgeView;
import com.google.android.material.transition.platform.MaterialSharedAxis;

public class MenuColorView {

  public static void show(BadgeView view) {
    view.setOnClickListener(
        i -> {
          if (view.getVisibility() == View.VISIBLE) {

            var colorDrawable = view.getBackground();

            var menu = new PopupWindow(view.getContext());
            var materialCardView = new LinearLayout(view.getContext());
            var param = new LinearLayout.LayoutParams(200, 200);
            materialCardView.setLayoutParams(param);
            menu.setContentView(materialCardView);
            MaterialSharedAxis Z = new MaterialSharedAxis(MaterialSharedAxis.Z, true);
            menu.setEnterTransition(Z);
            if (colorDrawable instanceof ColorDrawable) {
              int color = ((ColorDrawable) colorDrawable).getColor();
              materialCardView.setBackgroundColor(color);
            }
            menu.showAsDropDown(view);
            Handler handler = new Handler(Looper.getMainLooper());
            handler.postDelayed(menu::dismiss, 1000);
          }
        });
  }
}
