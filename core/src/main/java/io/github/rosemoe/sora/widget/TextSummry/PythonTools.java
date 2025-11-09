package io.github.rosemoe.sora.widget.TextSummry;

import android.content.Context;
import android.view.View;

import com.google.android.material.color.MaterialColors;
import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;

import java.io.Serializable;

import io.github.rosemoe.sora.langs.python.formatter.PyUnImp;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.Transilt;
import ir.ninjacoder.ghostide.core.GhostIdeAppLoader;
import ir.ninjacoder.ghostide.core.marco.HtmlTagView;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;

public class PythonTools implements Serializable {

  private ToolItem item;

  public PythonTools() {
    item = new ToolItem();
  }

  public void Tool(Context context, View view, CodeEditor editor) {
    PowerMenu menu =
        new PowerMenu.Builder(context)
            .addItem(new PowerMenuItem("Comment line"))
            .addItem(new PowerMenuItem("Python Tree view"))
            .addItem(new PowerMenuItem("Share text"))
            .addItem(new PowerMenuItem("Translate"))
            .addItem(new PowerMenuItem("Removed unusing import"))
            .setIsMaterial(true)
            .build();
    menu.setMenuRadius(20f);
    menu.setShowBackground(false);
    menu.setAutoDismiss(true);
    menu.setTextSize(14);
    menu.setMenuColor(MaterialColors.getColor(context, ObjectUtils.Back, 0));
    menu.setTextColor(MaterialColors.getColor(context, ObjectUtils.TvColor, 0));
    menu.showAsAnchorRightBottom(view);
    menu.setAnimation(MenuAnimation.ELASTIC_CENTER);
    menu.setHeaderView(item.getCustomHader("Python Helper", context));
    menu.setOnMenuItemClickListener(
        (pos, __) -> {
          switch (pos) {
            case 0:
              String pycomment = "\"\"\"";
              editor.getCommentHelper().CustomComment(pycomment, pycomment);
              break;
            case 1:
              new HtmlTagView().PythonTreeView(editor.getTextAsString(), context, editor);
              break;
            case 2:
              var mtools = new JavaTools();
              mtools.shareText(editor);
              break;
            case 3:
              Transilt.Start(editor);
              break;
            case 4:
              editor.setText(
                  PyUnImp.runObject(GhostIdeAppLoader.getContext(), editor.getTextAsString()));
              break;
          }
        });
  }
}
