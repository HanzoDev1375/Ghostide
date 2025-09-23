package io.github.rosemoe.sora.widget.TextSummry;

import ir.ninjacoder.ghostide.IdeEditor;
import ir.ninjacoder.ghostide.config.CreatorComment;
import ir.ninjacoder.ghostide.config.GetterSetterGenerator;
import ir.ninjacoder.ghostide.config.JavaPaserUtils;
import ir.ninjacoder.ghostide.databinding.MakefolderBinding;
import ir.ninjacoder.ghostide.marco.ActivityToFragmentConverter;
import ir.ninjacoder.ghostide.marco.LicenseManagerImpl;
import ir.ninjacoder.ghostide.marco.MethodOverloaderDialog;
import ir.ninjacoder.ghostide.marco.editorface.ConstructorMaker;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.ImportDeclaration;
import io.github.rosemoe.sora.langs.java.JavaLanguage;
import io.github.rosemoe.sora.widget.SymbolChannel;
import io.github.rosemoe.sora.widget.Transilt;
import io.github.rosemoe.sora.widget.schemes.GhostThemeDark;
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
import java.util.List;

public class JavaTools {
  protected ToolItem item;
  protected HashMap<String, Object> mmap = new HashMap<>();
  protected ArrayList<HashMap<String, Object>> map = new ArrayList<>();
  protected ArrayList<String> listvariable = new ArrayList<>();

  public JavaTools() {
    item = new ToolItem();
  }

  public void runs(Context context, View view, CodeEditor editor, String langName) {
    var javaPaserTools = new JavaPaserUtils((IdeEditor) editor);
    PowerMenu menu =
        new PowerMenu.Builder(context)
            .addItem(new PowerMenuItem("Un Comment Long"))
            .addItem(new PowerMenuItem("Comment text"))
            .addItem(new PowerMenuItem("Long Comment"))
            .addItem(new PowerMenuItem("UnComment"))
            .addItem(new PowerMenuItem("Share Text"))
            .addItem(new PowerMenuItem("addNullCheck"))
            .addItem(new PowerMenuItem("addInstance"))
            .addItem(new PowerMenuItem("Translate"))
            .addItem(new PowerMenuItem("GetterSetter"))
            .addItem(new PowerMenuItem("String Fog Decoder"))
            .addItem(new PowerMenuItem("CommentCreator"))
            .addItem(new PowerMenuItem("ConstructorMaker"))
            .addItem(new PowerMenuItem("addThrows"))
            .addItem(new PowerMenuItem("addTrycatch"))
            .addItem(new PowerMenuItem("addIfStatement"))
            .addItem(new PowerMenuItem("fix import"))
            .addItem(new PowerMenuItem("Copy R"))
            .addItem(new PowerMenuItem("Activity to Fragment"))
            .addItem(new PowerMenuItem("MethodOverloader"))
            .setIsMaterial(true)
            .build();
    menu.setMenuRadius(20f);
    menu.setShowBackground(false);
    menu.setAutoDismiss(true);
    menu.setTextSize(14);
    menu.setDividerHeight(20);
    menu.setDivider(item.getDiverAuto(context));
    menu.setMenuColor(MaterialColors.getColor(context, ObjectUtils.Back, 0));
    menu.setTextColor(MaterialColors.getColor(context, ObjectUtils.TvColor, 0));
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
            javaPaserTools.addNullCheck();
          } else if (pos == 6) {
            javaPaserTools.addInstance();
          } else if (pos == 7) {
            Transilt.Start(editor);
          } else if (pos == 8) {
            GetterSetterGenerator.main(context, editor.getText().toString(), (IdeEditor) editor);
          } else if (pos == 9) {
            item.StringFog(editor);
          } else if (pos == 10) {
            makeComment(context, editor);
          } else if (pos == 11) {
            new ConstructorMaker(context, editor.getText().toString(), (IdeEditor) editor);
          } else if (pos == 12) {
            javaPaserTools.addThrowsToMethod();
          } else if (pos == 13) {
            javaPaserTools.addTrycatch();
          } else if (pos == 14) {
            javaPaserTools.addIfStatement();
          } else if (pos == 15) {
            editor.setText(JavaPaserUtils.processCode(editor.getText().toString()));
          } else if (pos == 16) {
            var its = new LicenseManagerImpl();
            its.run((IdeEditor) editor);
          } else if (pos == 17) {
            editor.setText(
                ActivityToFragmentConverter.convertActivityToFragment(editor.getTextAsString()));
          } else if (pos == 18) {
            var dialogs =
                new MethodOverloaderDialog(context, editor.getTextAsString(), (IdeEditor) editor);
            dialogs.analyzeAndShowOverloadDialog();
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

  public void installextractJavaClass(Context c, CodeEditor editor, String text) {
    var myeditor = new CodeEditor(c);
    LinearLayout.LayoutParams params =
        new LinearLayout.LayoutParams(
            new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
    myeditor.setLayoutParams(params);
    myeditor.setEditable(false);
    myeditor.setLineNumberEnabled(false);
    myeditor.setEditorLanguage(new JavaLanguage((IdeEditor) editor));
    myeditor.setColorScheme(new GhostThemeDark());
    extractJavaClass(text, myeditor);
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
        for (var a : cls.getDeclaredAnnotations()) {
          text += "\n\n" + a.toString();
        }

        text += "\n\n// Fields (if it's empty means there's nothing)";
        for (Field f : cls.getDeclaredFields()) {
          text += "\n\n" + f.toString();
        }

        text += "\n\n// Constructors (if it's empty means there's nothing)";
        for (var c : cls.getDeclaredConstructors()) {
          text += "\n\n" + c.toString();
        }

        text += "\n\n// Methods (if it's empty means there's nothing)";
        for (var m : cls.getDeclaredMethods()) {
          text += "\n\n" + m.toString();
        }

        text += "\n\n// Classes (if it's empty means there's nothing)";
        for (var c : cls.getDeclaredClasses()) {
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

  private List<String> finalAllImportByCode(String text) {
    List<String> list = new ArrayList<>();
    var cu = StaticJavaParser.parse(text);
    cu.findAll(ImportDeclaration.class)
        .forEach(
            it -> {
              list.add(it.getNameAsString());
            });

    return list;
  }

  void bindList(CodeEditor editor, Context context) {
    var listView = new ListView(context);
    List<String> itemFull = finalAllImportByCode(editor.getText().toString());
    listView.setAdapter(
        new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, itemFull));

    listView.setOnItemClickListener(
        (parent, view, position, __) -> {
          var get = itemFull.get(position);
          installextractJavaClass(context, editor, get);
        });

    var dialog = new MaterialAlertDialogBuilder(context);
    dialog.setTitle("Class View");
    dialog.setNegativeButton(android.R.string.cancel, null);
    dialog.setView(listView);
    dialog.show();
  }
}
