package io.github.rosemoe.sora.widget.TextSummry;

import android.content.Context;
import android.view.View;

import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;

import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import ir.ninjacoder.ghostide.core.IdeEditor;
import ir.ninjacoder.ghostide.core.marco.HtmlTagView;

public class KotlinTools {
  private ToolItem item;

  public KotlinTools() {
    item = new ToolItem();
  }

  public void run(Context context, CodeEditor editor, View view) {
    PowerMenu menu =
        new PowerMenu.Builder(context)
            .addItem(new PowerMenuItem("Cooment"))
            .addItem(new PowerMenuItem("CommentLong"))
            .addItem(new PowerMenuItem("Kt treeview"))
            .setIsMaterial(true)
            .build();
    menu.setMenuRadius(20f);
    menu.setShowBackground(false);
    menu.setAutoDismiss(true);
    menu.setTextSize(14);
    menu.setDividerHeight(0);
    menu.setHeaderView(item.getCustomHader("Kt Helper", context));
    menu.setMenuColor(
        EditorColorUtil.get((IdeEditor) editor, EditorColorScheme.AUTO_COMP_PANEL_BG));
    menu.setTextColor(
        EditorColorUtil.get((IdeEditor) editor, EditorColorScheme.AUTO_COMP_PANEL_CORNER));
    menu.showAsAnchorRightBottom(view);
    menu.setAutoDismiss(true);
    menu.setAnimation(MenuAnimation.ELASTIC_CENTER);
    menu.setOnMenuItemClickListener(
        (pos, __) -> {
          if (pos == 0) {
            editor.getCommentHelper().CustomComment("/", "");
          } else if (pos == 1) {
            /**/
            editor.getCommentHelper().CustomComment("/*", "*/");
          } else if (pos == 2) {
            HtmlTagView ta = new HtmlTagView();
            ta.KtTreeView(editor.getText().toString(), context, (IdeEditor) editor);
          }
        });
  }
}
