package io.github.rosemoe.sora.widget.TextSummry;

import Ninja.coder.Ghostemane.code.IdeEditor;
import Ninja.coder.Ghostemane.code.config.CreatorComment;
import Ninja.coder.Ghostemane.code.config.GetterSetterGenerator;
import Ninja.coder.Ghostemane.code.databinding.MakefolderBinding;
import Ninja.coder.Ghostemane.code.utils.ColorAndroid12;
import android.widget.LinearLayout;
import io.github.rosemoe.sora.langs.java.JavaLanguage;
import io.github.rosemoe.sora.widget.SymbolChannel;
import io.github.rosemoe.sora.widget.Transilt;
import io.github.rosemoe.sora.widget.schemes.SchemeDarcula;
import java.lang.reflect.Field;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import android.view.LayoutInflater;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;
import io.github.rosemoe.sora.text.Cursor;
import io.github.rosemoe.sora.widget.CodeEditor;
import com.google.android.material.color.MaterialColors;

import java.util.ArrayList;
import java.util.HashMap;

public class JavaTools {
  protected ToolItem item;
  protected HashMap<String, Object> mmap = new HashMap<>();
  protected ArrayList<HashMap<String, Object>> map = new ArrayList<>();
  protected ArrayList<String> listvariable = new ArrayList<>();

  public JavaTools() {
    item = new ToolItem();
  }

  public void runs(Context context, View view, CodeEditor editor, String langName) {

    PowerMenu menu =
        new PowerMenu.Builder(context)
            .addItem(new PowerMenuItem("Un Comment Long"))
            .addItem(new PowerMenuItem("Comment text"))
            .addItem(new PowerMenuItem("Long Comment"))
            .addItem(new PowerMenuItem("UnComment"))
            .addItem(new PowerMenuItem("Share Text"))
            .addItem(new PowerMenuItem("Add to collection"))
            .addItem(new PowerMenuItem("ExtractJavaClass"))
            .addItem(new PowerMenuItem("Translate"))
            .addItem(new PowerMenuItem("Get and set"))
            .addItem(new PowerMenuItem("String Fog Decoder"))
            .addItem(new PowerMenuItem("CommentCreator"))
            .setIsMaterial(true)
            .build();
    menu.setMenuRadius(20f);
    menu.setShowBackground(false);
    menu.setAutoDismiss(true);
    menu.setTextSize(14);
    menu.setDividerHeight(20);
    menu.setDivider(item.getDiverAuto(context));
    menu.setMenuColor(MaterialColors.getColor(context, ColorAndroid12.Back, 0));
    menu.setTextColor(MaterialColors.getColor(context, ColorAndroid12.TvColor, 0));
    menu.showAsAnchorRightBottom(view);
    menu.setAutoDismiss(true);
    menu.setAnimation(MenuAnimation.ELASTIC_CENTER);
    //	menu.setHeaderView(item.getCustomHader("Html Helper", context));
    menu.setOnMenuItemClickListener(
        (pos, __) -> {
          if (pos == 0) {
            /* */
            editor.getCommentHelper().onComment("/*", "*/");
          } else if (pos == 1) {
            if (editor.getCursor().isSelected()) editor.getCommentHelper().CustomComment("//", "");
            else Toast.makeText(context, "SelectText", 2).show();
          } else if (pos == 2) {
            if (editor.getCursor().isSelected()) editor.getCommentHelper().MakeCommentJava();
            else Toast.makeText(context, "SelectText", 2).show();
          } else if (pos == 3) {
            editor.getCommentHelper().unComment();
          } else if (pos == 4) {
            shareText(editor);
          } else if (pos == 5) {

          } else if (pos == 6) {
            installextractJavaClass(context, editor);
          } else if (pos == 7) {
            Transilt.Start(editor);
          } else if (pos == 8) {
            GetterSetterGenerator.main(context,editor.getText().toString(),(IdeEditor)editor);
          } else if (pos == 9) {
            item.StringFog(editor);
          }else if(pos == 10){
            makeComment(context,editor);
          }
        });
  }

  public String getSelectedText(CodeEditor editor) {
    Cursor cursor = editor.getCursor();
    return editor
        .getText()
        .subContent(
            cursor.getLeftLine(),
            cursor.getLeftColumn(),
            cursor.getRightLine(),
            cursor.getRightColumn())
        .toString();
  }

  public void shareText(CodeEditor editor) {
    Intent sendIntent = new Intent();
    sendIntent.setAction(Intent.ACTION_SEND);
    sendIntent.putExtra(Intent.EXTRA_TEXT, getSelectedText(editor));
    sendIntent.setType("text/plain");
    Intent shareIntent = Intent.createChooser(sendIntent, null);
    editor.getContext().startActivity(shareIntent);
  }

  public void installextractJavaClass(Context c, CodeEditor editor) {
    var myeditor = new CodeEditor(c);
    LinearLayout.LayoutParams params =
        new LinearLayout.LayoutParams(
            new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
    myeditor.setLayoutParams(params);
    myeditor.setEditable(false);
    myeditor.setLineNumberEnabled(false);
    myeditor.setEditorLanguage(new JavaLanguage((IdeEditor)editor));
    myeditor.setColorScheme(new SchemeDarcula());
    extractJavaClass(editor.getSelectedText(), myeditor);
    var dialog = new MaterialAlertDialogBuilder(c);
    dialog.setTitle("Class View");
    dialog.setPositiveButton("ok", null);
    dialog.setView(myeditor);
    dialog.show();
  }

  public void extractJavaClass(String _className, CodeEditor editor) {
    try {
      Class cls = Class.forName(_className);
      if (cls != null) {
        String text = "// Extracted class: " + cls.getName();

        text += "\n\n// Annotations (if it's empty means there's nothing)";
        //        for (java.text.Annotation a : cls.getDeclaredAnnotations()) {
        //          text += "\n\n" + a.toString();
        //        }

        text += "\n\n// Fields (if it's empty means there's nothing)";
        for (Field f : cls.getDeclaredFields()) {
          text += "\n\n" + f.toString();
        }

        text += "\n\n// Constructors (if it's empty means there's nothing)";
        for (Constructor c : cls.getDeclaredConstructors()) {
          text += "\n\n" + c.toString();
        }

        text += "\n\n// Methods (if it's empty means there's nothing)";
        for (Method m : cls.getDeclaredMethods()) {
          text += "\n\n" + m.toString();
        }

        text += "\n\n// Classes (if it's empty means there's nothing)";
        for (Class c : cls.getDeclaredClasses()) {
          text += "\n\n" + c.toString();
        }

        editor.setText(text);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void makeComment(Context c, CodeEditor editors) {
    MakefolderBinding bind = MakefolderBinding.inflate(LayoutInflater.from(c));
    new MaterialAlertDialogBuilder(c)
        .setTitle("Type Your Comment")
        .setView(bind.getRoot())
        .setPositiveButton(
            android.R.string.ok,
            (C, CC) -> {
              if (editors.getEditorLanguage() instanceof JavaLanguage) {
                var code = CreatorComment.setCommentFromJava(bind.editor.getText().toString());
                SymbolChannel symbol = editors.createNewSymbolChannel();
                symbol.insertSymbol(code, code.length());
              }
            })
        .show();
  }
}
