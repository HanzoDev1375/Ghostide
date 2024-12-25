package io.github.rosemoe.sora.widget.TextSummry;

import android.content.Context;
import android.view.View;
import io.github.rosemoe.sora.widget.CodeEditor;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import com.google.android.material.color.MaterialColors;
import com.skydoves.powermenu.MenuAnimation;
import ir.ninjacoder.ghostide.marco.HtmlTagView;
import io.github.rosemoe.sora.widget.Transilt;

import java.io.Serializable;

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
                        .addItem(new PowerMenuItem("Add to collection"))
                        .addItem(new PowerMenuItem("Translate"))
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
                    if (pos == 0) {
                        String pycomment = "\"\"\"";
                        editor.getCommentHelper().CustomComment(pycomment, pycomment);
                    } else if (pos == 1) {
                        new HtmlTagView().PythonTreeView(editor.getText().toString(), context, editor);

                    } else if (pos == 2) {

                    } else if (pos == 3) {
                        var mtools = new JavaTools();
                        mtools.shareText(editor);
                    } else if (pos == 4) {
                        Transilt.Start(editor);
                    }
                });
    }
}
