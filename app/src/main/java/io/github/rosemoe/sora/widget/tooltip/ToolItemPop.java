package io.github.rosemoe.sora.widget.tooltip;

import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.google.android.material.color.MaterialColors;
import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;
import io.github.rosemoe.sora.widget.CodeEditor;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import ir.ninjacoder.ghostide.R;

public class ToolItemPop {
  private View editor;
  private PowerMenu menu;

  public ToolItemPop(View editor) {
    this.editor = editor;
    menu = new PowerMenu.Builder(editor.getContext()).setIsMaterial(true).build();
  }

  public void run(String text) {
    menu.addItem(new PowerMenuItem("value " + text, false, R.drawable.ic_add));
    menu.setShowBackground(false);
    menu.setAutoDismiss(true);
    menu.setTextColor(MaterialColors.getColor(editor.getContext(), ObjectUtils.TvColor, 0));
    menu.setMenuColor(MaterialColors.getColor(editor.getContext(), ObjectUtils.Back, 0));
    menu.setMenuShadow(0.7f);
    menu.setAnimation(MenuAnimation.FADE);
    menu.setMenuRadius(30);
  }

  public void show() {

    menu.showAsAnchorRightTop(editor);
  }

  public void dismiss() {
    menu.dismiss();
  }

  public void autodismiss() {
    new Handler(Looper.getMainLooper())
        .postDelayed(
            () -> {
              if (isShowing()) menu.dismiss();
            },
            1000);
  }

  public boolean isShowing() {
    return menu.isShowing();
  }
}
