package io.github.rosemoe.sora.widget.tooltip;

import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.View;
import com.google.android.material.color.MaterialColors;
import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;
import io.github.rosemoe.sora.event.ClickEvent;
import ir.ninjacoder.ghostide.IdeEditor;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import ir.ninjacoder.ghostide.R;

public class ToolItemPop {
  private IdeEditor editor;
  private PowerMenu menu;
  private Handler handler;

  public ToolItemPop(IdeEditor editor) {
    this.editor = editor;
    this.handler = new Handler(Looper.getMainLooper());
    menu = new PowerMenu.Builder(editor.getContext()).setIsMaterial(true).build();
    setupMenuStyle();
  }

  private void setupMenuStyle() {
    menu.setShowBackground(false);
    menu.setAutoDismiss(true);
    menu.setTextColor(MaterialColors.getColor(editor.getContext(), ObjectUtils.TvColor, 0));
    menu.setMenuColor(MaterialColors.getColor(editor.getContext(), ObjectUtils.Back, 0));
    menu.setMenuShadow(0.7f);
    menu.setAnimation(MenuAnimation.FADE);
    menu.setMenuRadius(30);
  }

  public void run(String text) {
    menu.clearItems();
    menu.addItem(new PowerMenuItem(text, false, R.drawable.ic_add));
  }

  public void show(int line, int column) {
    editor.subscribeEvent(
        ClickEvent.class,
        (f, d) -> {
          handler.post(
              () -> {
                try {

                  int x = (int) editor.getOffset(line, column);
                  int y = (int) (editor.getRowHeight() * line);
                  menu.showAtLocation(editor, Gravity.NO_GRAVITY, x, y);
                  autodismiss();

                } catch (Exception e) {
                  e.printStackTrace();
                }
              });
        });
  }

  public void dismiss() {
    handler.post(
        () -> {
          if (menu.isShowing()) {
            menu.dismiss();
          }
        });
  }

  public void autodismiss() {
    handler.postDelayed(
        () -> {
          if (menu.isShowing()) {
            menu.dismiss();
          }
        },
        3000);
  }

  public boolean isShowing() {
    return menu.isShowing();
  }
}
