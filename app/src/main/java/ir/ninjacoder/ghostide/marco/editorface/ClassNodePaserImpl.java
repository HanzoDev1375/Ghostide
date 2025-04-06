package ir.ninjacoder.ghostide.marco.editorface;

import ir.ninjacoder.ghostide.databinding.MakefolderBinding;
import ir.ninjacoder.ghostide.interfaces.JavaParserCallBack;
import ir.ninjacoder.ghostide.marco.editorface.ClassNodePaser;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;

public class ClassNodePaserImpl {

  public enum ModeUser {
    MENU(0),
    DIALOG(1);

    private int value;

    ModeUser(int value) {
      this.value = value;
    }

    public int getValue() {
      return this.value;
    }
  }

  protected ClassNodePaser node;
  protected MakefolderBinding bind;
  protected String path;
  private Context context;
  private JavaParserCallBack paster;
  private View view;
  private ModeUser mode = ModeUser.DIALOG;

  public ClassNodePaserImpl(String path, Context context, JavaParserCallBack paster, View view) {
    this.path = path;
    this.context = context;
    this.paster = paster;
    this.view = view;
    switch (mode) {
      case DIALOG:
        dialog();
        break;
      case MENU:
        menu();
        break;
    }
  }

  void menu() {
    var menus =
        new PowerMenu.Builder(context)
            .addItem(new PowerMenuItem("PastJavaCode"))
            .setIsMaterial(true)
            .setTextColor(MaterialColors.getColor(context, ObjectUtils.TvColor, 0))
            .setShowBackground(false)
            .setMenuRadius(30f)
            .setMenuColor(MaterialColors.getColor(context, ObjectUtils.Back, 0))
            .setAutoDismiss(true)
            .build();
    menus.setOnMenuItemClickListener(
        (pos, __) -> {
          if (pos == 0) {
            // using custom mode for other dev

            dialog();
          }
        });
    menus.showAsDropDown(view);
  }

  void dialog() {
    bind = MakefolderBinding.inflate(LayoutInflater.from(context));
    var dialogSheet = new MaterialAlertDialogBuilder(context);
    dialogSheet.setTitle("PastJavaCode!");
    dialogSheet.setView(bind.getRoot());
    dialogSheet.setPositiveButton(
        android.R.string.ok,
        (it, __) -> {
          node = new ClassNodePaser(path, bind.editor.getText().toString());
          paster.past();
        });
    dialogSheet.setNegativeButton(android.R.string.cancel, null);
    dialogSheet.show();
  }

  public void setMode(ModeUser mode) {
    this.mode = mode;
  }
}
