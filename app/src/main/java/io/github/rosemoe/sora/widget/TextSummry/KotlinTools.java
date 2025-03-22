package io.github.rosemoe.sora.widget.TextSummry;

import ir.ninjacoder.ghostide.utils.ObjectUtils;
import ir.ninjacoder.ghostide.IdeEditor;
import ir.ninjacoder.ghostide.marco.HtmlTagView;
import android.view.View;
import com.google.android.material.color.MaterialColors;
import com.skydoves.powermenu.MenuAnimation;
import android.content.Context;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;
import io.github.rosemoe.sora.widget.CodeEditor;

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
    menu.setMenuColor(MaterialColors.getColor(context, ObjectUtils.Back, 0));
    menu.setTextColor(MaterialColors.getColor(context, ObjectUtils.TvColor, 0));
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
