package io.github.rosemoe.sora.widget.TextSummry;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;

import io.github.rosemoe.sora.widget.EditorColorScheme;
import ir.ninjacoder.ghostide.core.IdeEditor;
import ir.ninjacoder.ghostide.core.utils.GradleDependencyManager;

public class GradleTools {

  Context context;

  IdeEditor editor;
  View view;

  public GradleTools(Context context, IdeEditor editor, View view) {
    this.context = context;
    this.editor = editor;
    this.view = view;
  }

  public GradleTools get() {
    var menu = new PowerMenu.Builder(context).setIsMaterial(true).build();
    menu.addItem(new PowerMenuItem("GradleDependencyManager"));
    menu.addItem(new PowerMenuItem("Task manager"));
    menu.addItem(new PowerMenuItem("My library"));
    menu.setShowBackground(false);
    menu.setMenuColor(getColor(EditorColorScheme.AUTO_COMP_PANEL_BG));
    menu.setTextColor(getColor(EditorColorScheme.AUTO_COMP_PANEL_CORNER));
    menu.setAnimation(MenuAnimation.FADE);
    menu.setOnMenuItemClickListener(
        (pos, item) -> {
          if (pos == 0) {
            var gr = new GradleDependencyManager(context, editor.getText().toString());
            gr.checkAllDependencies();
            gr.setCallBack(
                new GradleDependencyManager.DependencyUpdateListener() {
                  @Override
                  public void onUpToDate(String artifact, String currentVersion) {}

                  @Override
                  public void onUpdateSuccess(
                      String artifact, String newVersion, String updatedContent) {}

                  @Override
                  public void onError(String message) {}

                  @Override
                  public void onBulkUpdateSuccess(String updatedGradleContent) {
                    editor.setText(updatedGradleContent);
                  }
                });
          } else if (pos == 1) {
            Toast.makeText(context, "soon...", 2).show();
          } else if (pos == 2) {
            Toast.makeText(context, "soon...", 2).show();
          }
        });
    menu.showAsAnchorRightBottom(view);

    return this;
  }

  int getColor(int color) {
    return EditorColorUtil.get(editor,color);
  }
}
