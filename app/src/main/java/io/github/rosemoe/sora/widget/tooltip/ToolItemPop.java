package io.github.rosemoe.sora.widget.tooltip;

import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import com.google.android.material.color.MaterialColors;
import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;
import io.github.rosemoe.sora.widget.CodeEditor;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import ir.ninjacoder.ghostide.R;
public class ToolItemPop {
  private CodeEditor editor;
  private PowerMenu menu;

  public ToolItemPop(CodeEditor editor) {
    this.editor = editor;
  }

  public void run(String text) {
    menu =
        new PowerMenu.Builder(editor.getContext())
            .addItem(new PowerMenuItem("value " + text,false,R.drawable.ic_add))
            .setIsMaterial(true)
            .setShowBackground(false)
            .setAutoDismiss(true)
            .setTextColor(MaterialColors.getColor(editor.getContext(), ObjectUtils.TvColor, 0))
            .setMenuColor(MaterialColors.getColor(editor.getContext(), ObjectUtils.Back, 0))
            .setMenuShadow(0.7f)
            .setAnimation(MenuAnimation.FADE)
            .setMenuRadius(30)
            .build();
  }

  public void show() {
    var line = editor.getCursor().getLeftLine();
    var column = editor.getCursor().getLeftColumn();
    int x = (int) ((editor.getOffset(line, column) - (menu.getContentViewWidth() / 2)));
    int y =
        (int) (editor.getRowHeight() * line)
            - editor.getOffsetY()
            - menu.getContentViewHeight()
            - 5;

    menu.showAsDropDown(editor, x, y);
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
