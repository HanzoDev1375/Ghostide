package io.github.rosemoe.sora.widget.TextSummry;

import Ninja.coder.Ghostemane.code.utils.ColorAndroid12;
import com.google.android.material.color.MaterialColors;
import com.skydoves.powermenu.MenuAnimation;
import android.content.Context;
import android.view.View;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;
import io.github.rosemoe.sora.langs.css3.CSS3Language;
import io.github.rosemoe.sora.langs.dart.DartLang;
import io.github.rosemoe.sora.langs.ninjalang.NinjaLang;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.Transilt;

public class OtherLangs {
  private ToolItem item;

  public OtherLangs() {
    item = new ToolItem();
  }

  public void run(Context context, CodeEditor editor, View view) {
    var menu =
        new PowerMenu.Builder(context)
            .addItem(new PowerMenuItem("Share"))
            .addItem(new PowerMenuItem("Translate"))
            .addItem(new PowerMenuItem("Comment Normal"))
            .addItem(new PowerMenuItem("Comment Long"))
            .setIsMaterial(true)
            .build();
    menu.setMenuRadius(20f);
    menu.setShowBackground(false);
    menu.setAutoDismiss(true);
    menu.setTextSize(14);
    menu.setMenuColor(MaterialColors.getColor(context, ColorAndroid12.Back, 0));
    menu.setTextColor(MaterialColors.getColor(context, ColorAndroid12.TvColor, 0));
    menu.showAsAnchorRightBottom(view);
    menu.setAnimation(MenuAnimation.ELASTIC_CENTER);
    menu.setHeaderView(item.getCustomHader("Other Helper", context));
    menu.setOnMenuItemClickListener(
        (pos, v) -> {
          if (pos == 0) {
            item.ShareText(context, editor);
          } else if (pos == 1) {
            Transilt.Start(editor);
          } else if (pos == 2) {
            try {
              ChildCommentNormal(editor);
            } catch (Exception err) {
              err.printStackTrace();
            }
          } else if (pos == 3) {
            try {
              ChildCommentLong(editor);
            } catch (Exception err) {
              err.printStackTrace();
            }
          }
        });
  }

  protected void ChildCommentNormal(CodeEditor editor) {
    if (editor.getEditorLanguage() instanceof CSS3Language) {
      editor.getCommentHelper().CustomComment("//", "");
    } else if (editor.getEditorLanguage() instanceof DartLang) {
      editor.getCommentHelper().CustomComment("//", "");
    } else if (editor.getEditorLanguage() instanceof NinjaLang) {
      editor.getCommentHelper().CustomComment("//", "");
    }
  }

  /**
   * this code by date 2024 not work #seeClass 
   */
  
  @Deprecated
  protected void ChildCommentLong(CodeEditor editor) {
    if (editor.getEditorLanguage() instanceof CSS3Language) {
      editor.getCommentHelper().CustomComment("/*", "*/");
    } else if (editor.getEditorLanguage() instanceof DartLang) {
      editor.getCommentHelper().CustomComment("/*", "*/");
    } else if (editor.getEditorLanguage() instanceof NinjaLang) {
      editor.getCommentHelper().CustomComment("/*", "*/");
    }
  }
}
