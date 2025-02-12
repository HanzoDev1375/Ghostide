package io.github.rosemoe.sora.widget.tooltip;

import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;
import io.github.rosemoe.sora.widget.CodeEditor;

public class ToolItemPop {
  private CodeEditor editor;

  public ToolItemPop(CodeEditor editor) {
    this.editor = editor;
  }

  public void run(String text) {
    PowerMenu menu =
        new PowerMenu.Builder(editor.getContext())
            .addItem(new PowerMenuItem(text))
            .setIsMaterial(true)
            .setShowBackground(false)
            .setAutoDismiss(true)
            .setTextColor(Color.WHITE)
            .setMenuColor(Color.BLACK)
            .setMenuShadow(0.7f)
            .setAnimation(MenuAnimation.FADE)
            .setMenuRadius(30)
            .build();

    var line = editor.getCursor().getLeftLine();
    var column = editor.getCursor().getLeftColumn();
    int x = (int) ((editor.getOffset(line, column) - (menu.getContentViewWidth() / 2)));
    int y =
        (int) (editor.getRowHeight() * line)
            - editor.getOffsetY()
            - menu.getContentViewHeight()
            - 5;
    new Handler(Looper.getMainLooper()).postDelayed(() -> menu.dismiss(), 20000);
    menu.showAsDropDown(editor, x, y);
  }
}
