package io.github.rosemoe.sora.widget.TextSummry;

import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import ir.ninjacoder.ghostide.tasks.app.HtmlToCssGenerator;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import ir.ninjacoder.ghostide.IdeEditor;
import ir.ninjacoder.ghostide.marco.ColorView;
import ir.ninjacoder.ghostide.marco.HtmlTagView;
import android.content.Context;
import android.view.View;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;
import com.google.android.material.color.MaterialColors;
import com.skydoves.powermenu.MenuAnimation;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.Transilt;
import ir.ninjacoder.ghostide.widget.data.ColorChecker;
import java.io.File;
import java.io.Serializable;

public class HtmlTool implements Serializable {
  private ToolItem item;

  public HtmlTool() {
    item = new ToolItem();
  }

  public void Tool(Context context, View view, CodeEditor editor) {
    PowerMenu menu =
        new PowerMenu.Builder(context)
            .addItem(new PowerMenuItem("Comment line"))
            .addItem(new PowerMenuItem("Html Tag view"))
            .addItem(new PowerMenuItem("Add to collection"))
            .addItem(new PowerMenuItem("Share"))
            .addItem(new PowerMenuItem("Run Web site(beta)"))
            .addItem(new PowerMenuItem("Translate"))
            .addItem(new PowerMenuItem("Link viewer"))
            .addItem(new PowerMenuItem("Color preview "))
            .addItem(new PowerMenuItem("html convert id&class to css"))
            .setIsMaterial(true)
            .build();
    menu.setMenuRadius(20f);
    menu.setTextColor(0);
    menu.setShowBackground(false);
    menu.setAutoDismiss(true);
    menu.setTextSize(14);

    menu.setMenuColor(MaterialColors.getColor(context, ObjectUtils.Back, 0));
    menu.setTextColor(MaterialColors.getColor(context, ObjectUtils.TvColor, 0));
    menu.showAsAnchorRightBottom(view);
    menu.setAnimation(MenuAnimation.ELASTIC_CENTER);
    menu.setHeaderView(item.getCustomHader("Html Helper", context));
    menu.setOnMenuItemClickListener(
        (pos, __) -> {
          if (pos == 0) {
            editor.getCommentHelper().CustomComment("<!--", "-->");
          } else if (pos == 1) {
            HtmlTagView views = new HtmlTagView();
            views.Start(editor.getText().toString(), context, (IdeEditor) editor);
          } else if (pos == 2) {

          } else if (pos == 3) {
            var tooljava = new JavaTools();
            tooljava.shareText(editor);
          } else if (pos == 4) {
            item.ShareText(context, editor);
          } else if (pos == 5) {
            Transilt.Start(editor);
          } else if (pos == 6) {
            ColorView colorview = new ColorView();
            colorview.linkview(editor, context);
          } else if (pos == 7) {
            ColorView mview = new ColorView();
            mview.colorview(editor, context);
          } else if (pos == 8) {
            var it = GhostIdeAppLoader.getShap();
            if (it.contains("pos_path")) {
              File file = new File(it.getString("pos_path", ""));
              HtmlToCssGenerator.run(editor.getTextAsString(), file.getParent(), editor);
            }
          }
        });
  }
}
