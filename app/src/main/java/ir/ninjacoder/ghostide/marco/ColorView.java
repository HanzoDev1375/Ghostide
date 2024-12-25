package ir.ninjacoder.ghostide.marco;

import ir.ninjacoder.ghostide.R;
import ir.ninjacoder.ghostide.activities.BrowserActivity;
import ir.ninjacoder.ghostide.adapter.ColorRenderAdapter;
import ir.ninjacoder.ghostide.adapter.JavaASmailAd;
import ir.ninjacoder.ghostide.config.ChlidJavaList;

import ir.ninjacoder.ghostide.model.CodeNavigationInfo;
import ir.ninjacoder.ghostide.navigator.SmaliParser;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import ir.ninjacoder.ghostide.utils.FileUtil;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ClipboardUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.TextInputLayout;
import com.skydoves.powermenu.CustomPowerMenu;
import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.MenuBaseAdapter;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;
import io.github.rosemoe.sora.langs.java.JavaLanguage;
import io.github.rosemoe.sora.langs.smali.SMLang;
import io.github.rosemoe.sora.langs.xml.XMLLanguage;
import io.github.rosemoe.sora.widget.CodeEditor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is made by Ninja Kader for various navigation functions, from the sample color of XML
 * tags and ...
 */
public class ColorView {

  private ArrayList<HashMap<String, Object>> map = new ArrayList<>();

  public static void setPath(String path, Context context, OnDone dos, View mainview) {

    var menu =
        new PowerMenu.Builder(context)
            .addItem(new PowerMenuItem("Home Folder"))
            .addItem(new PowerMenuItem("Custom path"))
            .addItem(new PowerMenuItem("Download Folder"))
            .addItem(new PowerMenuItem("Movies Folder"))
            .addItem(new PowerMenuItem("Root Folder App"))
            .setIsMaterial(true)
            .build();
    menu.setAutoDismiss(true);
    menu.setTextColor(MaterialColors.getColor(context, ObjectUtils.colorOnSurface, 0));
    menu.setTextSize(15);
    menu.setAnimation(MenuAnimation.ELASTIC_CENTER);
    menu.setMenuRadius(20);
    menu.setShowBackground(false);
    menu.setMenuColor(MaterialColors.getColor(context, ObjectUtils.Back, 0));
    menu.showAsDropDown(mainview);
    menu.setOnMenuItemClickListener(
        (itemPos, cc) -> {
          int item = itemPos;
          switch (item) {
            case 0 -> {
              String get = path;
              get = "/storage/emulated/0/GhostWebIDE/";
              if (dos instanceof OnDone) {
                dos.done(get);
              }
              break;
            }
            case 1 -> {
              var views = LayoutInflater.from(context).inflate(R.layout.makefolder, null, false);
              TextInputLayout input = views.findViewById(R.id.top);
              EditText editText = views.findViewById(R.id.editor);
              editText.setText(path);
              AlertDialog dialog =
                  new MaterialAlertDialogBuilder(context)
                      .setTitle("Select Custom Path")
                      .setView(views)
                      .setPositiveButton("OK", null)
                      .create();

              dialog.setOnShowListener(
                  dialogInterface -> {
                    Button positiveButton = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
                    positiveButton.setOnClickListener(
                        v -> {
                          if (dos instanceof OnDone) {
                            dos.done(editText.getText().toString());
                            dialog.dismiss();
                          }
                        });
                    editText.requestFocus();
                  });

              dialog.show();
            }
            case 2 -> {
              String get = path;
              get = FileUtil.getDownloadFolder();
              if (dos instanceof OnDone) {
                dos.done(get);
              }
              break;
            }
            case 3 -> {
              String get = path;
              get = FileUtil.getDownloadFolder();
              if (dos instanceof OnDone) {
                dos.done(get);
              }
              break;
            }
            case 4 -> {
              new MaterialAlertDialogBuilder(context)
                  .setTitle(Html.fromHtml("<font color = \"gold\"> Warning </font>"))
                  .setMessage(
                      HtmlHelper.getFontName(
                          "red", "This is a sensitive access may damage your mobile"))
                  .setPositiveButton(
                      "ok",
                      (c, dd) -> {
                        String root = path;
                        root = context.getFilesDir().getAbsoluteFile() + File.separator;
                        if (dos instanceof OnDone) {
                          dos.done(root);
                        }
                      })
                  .show();

              break;
            }
          }
        });
  }

  private void linkview(
      CodeEditor editor, Context context, String regexCode, String title, String key) {
    var listview = new ListView(context);
    ListView.LayoutParams param =
        new ListView.LayoutParams(
            ListView.LayoutParams.MATCH_PARENT, ListView.LayoutParams.WRAP_CONTENT);
    AlertDialog dialog =
        new MaterialAlertDialogBuilder(context)
            .setTitle(title)
            .setView(listview)
            .setPositiveButton("dismiss", null)
            .create();
    dialog.setOnShowListener(
        c -> {
          List<String> httpsLinks = new ArrayList<>();

          Pattern pat = Pattern.compile(regexCode);
          Matcher mat = pat.matcher(editor.getText().toString());
          while (mat.find()) {
            httpsLinks.add(mat.group().trim());
          }
          for (var data : httpsLinks) {
            {
              HashMap<String, Object> mapz = new HashMap<>();
              mapz.put(key, data);
              map.add(mapz);
            }
          }
          Button btn = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
          if (btn != null) {
            btn.setOnClickListener(v -> dialog.dismiss());
          }
          /// adding adptor

          if (listview != null) {
            View view = LayoutInflater.from(context).inflate(R.layout.emptyview, null);
            listview.setEmptyView(view);
          }
          listview.setAdapter(new Listview1Adapter(map, context));
          ((BaseAdapter) listview.getAdapter()).notifyDataSetChanged();
          listview.setOnItemClickListener(
              (vi, view, pos, id) -> {
                try {
                  editor.getSearcher().search(map.get(pos).get(key).toString());
                  editor.getSearcher().gotoNext();
                  dialog.dismiss();
                } catch (Exception err) {
                  editor.getSearcher().stopSearch();
                }
              });
          listview.setOnItemLongClickListener(
              (adview, view, pos, lo) -> {
                ClipboardUtils.copyText(map.get(pos).get(key).toString());
                Toast.makeText(context, "Item Copyed " + map.get(pos).get(key).toString(), 2)
                    .show();

                Intent i = new Intent();
                i.setClass(context, BrowserActivity.class);
                i.putExtra("test", map.get(pos).get(key).toString());
                context.startActivity(i);

                return true;
              });
        });
    dialog.show();
  }

  public void linkview(CodeEditor editor, Context context) {
    linkview(
        editor,
        context,
        "https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)",
        "Link View",
        "linker");
  }

  public void StringXml(CodeEditor editor, Context context) {
    linkview(editor, context, "(?<=\\\\?>)([a-z]\\w+)(?=<)", "String res View", "Res");
  }

  public void colorview(CodeEditor editor, Context context) {
    // "#\\b([0-9a-fA-F]{3}|[0-9a-fA-F]{6}|[0-9a-fA-F]{8})\\b"
    var listview = new ListView(context);
    ListView.LayoutParams param =
        new ListView.LayoutParams(
            ListView.LayoutParams.MATCH_PARENT, ListView.LayoutParams.WRAP_CONTENT);
    AlertDialog dialog =
        new MaterialAlertDialogBuilder(context)
            .setTitle("Color preview")
            .setView(listview)
            .setPositiveButton("dismiss", null)
            .create();
    dialog.setOnShowListener(
        c -> {
          List<String> httpsLinks = new ArrayList<>();

          Pattern pat = Pattern.compile("#\\b([0-9a-fA-F]{6}|[0-9a-fA-F]{8})\\b");
          Matcher mat = pat.matcher(editor.getText().toString());
          while (mat.find()) {
            httpsLinks.add(mat.group().trim());
          }
          for (var data : httpsLinks) {
            {
              HashMap<String, Object> mapz = new HashMap<>();
              mapz.put("colorBind", data);
              map.add(mapz);
            }
          }
          Button btn = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
          if (btn != null) {
            btn.setOnClickListener(v -> dialog.dismiss());
          }
          /// adding adptor

          if (listview != null) {
            View view = LayoutInflater.from(context).inflate(R.layout.emptyview, null);
            listview.setEmptyView(view);
          }
          listview.setAdapter(new ColorRenderAdapter(map, context));
          ((BaseAdapter) listview.getAdapter()).notifyDataSetChanged();
          listview.setOnItemClickListener(
              (vi, view, pos, id) -> {
                try {
                  editor.getSearcher().search(map.get(pos).get("colorBind").toString());
                  editor.getSearcher().gotoNext();
                  dialog.dismiss();
                } catch (Exception err) {
                  editor.getSearcher().stopSearch();
                }
              });
          listview.setOnItemLongClickListener(
              (adview, view, pos, lo) -> {
                ClipboardUtils.copyText(map.get(pos).get("colorBind").toString());
                Toast.makeText(
                        context,
                        "Item Copyed " + map.get(pos).get("colorBind").toString(),
                        Toast.LENGTH_SHORT)
                    .show();

                return true;
              });
        });
    dialog.show();
  }

  private MaterialShapeDrawable getShape(View v) {
    MaterialShapeDrawable shapeDrawable =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder().setAllCorners(CornerFamily.ROUNDED, 18).build());
    shapeDrawable.setFillColor(
        ColorStateList.valueOf(MaterialColors.getColor(v, ObjectUtils.Back, 0)));
    return shapeDrawable;
  }

  public interface OnDone {
    public void done(String pat);
  }

  class Listview1Adapter extends BaseAdapter {

    ArrayList<HashMap<String, Object>> _data;
    Context context;

    public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr, Context context) {
      _data = _arr;
      this.context = context;
    }

    @Override
    public int getCount() {
      return _data.size();
    }

    @Override
    public HashMap<String, Object> getItem(int _index) {
      return _data.get(_index);
    }

    @Override
    public long getItemId(int _index) {
      return _index;
    }

    @Override
    public View getView(final int _position, View _v, ViewGroup _container) {

      View _view = LayoutInflater.from(context).inflate(R.layout.lbs, null);

      LinearLayout rooti = _view.findViewById(R.id.rooti);

      LinearLayout getTag = _view.findViewById(R.id.getTag);
      TextView titleview = _view.findViewById(R.id.titleview);
      TextView normaltext = _view.findViewById(R.id.normaltext);

      normaltext.setText(_data.get(_position).get("linker").toString());
      titleview.setText(normaltext.getText().toString().substring(0, 1));
      getTag.setBackground(getShape(getTag));
      titleview.setTextColor(MaterialColors.getColor(titleview, ObjectUtils.TvColor));
      normaltext.setTextColor(MaterialColors.getColor(normaltext, ObjectUtils.TvColor));

      return _view;
    }
  }

  public void runJavaAsSmail(Context context, String path, CodeEditor editor) {
    if (editor.getEditorLanguage() instanceof JavaLanguage) {
      try {
        RecyclerView rv = new RecyclerView(context);
        var param =
            new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        rv.setLayoutParams(param);
        
        ChlidJavaList javaList = new ChlidJavaList(editor.getText().toString());
        List<String> mylist = javaList.getAllMethod();
        List<String> myField = javaList.getAllFileds();
        List<String> MyEnum = javaList.getAllEnum();
        List<String> myVar = javaList.getAllVariable();
        List<String> vaset = new ArrayList<>();
        vaset.addAll(mylist);
        vaset.addAll(myField);
        vaset.addAll(MyEnum);
        vaset.addAll(myVar);
        var ad =
            new JavaASmailAd(
                vaset,
                new JavaASmailAd.OnClickItem() {

                  @Override
                  public void onClick(String info, View v, int pos) {
                    try {
                      editor.getSearcher().search(info);
                      editor.getSearcher().gotoNext();
                    } catch (Exception err) {
                      err.printStackTrace();
                    }
                  }
                });
        rv.setAdapter(ad);
        rv.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
        new MaterialAlertDialogBuilder(context)
            .setTitle("Nav Parser")
            .setMessage("Java and Smail Data Viewer")
            .setView(rv)
            .setPositiveButton(android.R.string.cancel, null)
            .show();
      } catch (Exception err) {
        err.printStackTrace();
      }
    } else if (editor.getEditorLanguage() instanceof XMLLanguage) {
      StringXml(editor, context);
    } else {
      new MaterialAlertDialogBuilder(context)
          .setTitle("Language is not supported")
          .setPositiveButton(android.R.string.cancel, null)
          .show();
    }
  }

  public void bindPowerMenuListFile(Context context, String path, View view) {
    File file = new File(path);
    File[] pathlist = file.listFiles();
    List<File> listFileAd = Arrays.asList(pathlist);
    var menu = new CustomPowerMenu.Builder(context, new FileManagerList(listFileAd)).build();
    menu.showAsDropDown(view);
  }

  public class FileManagerList extends MenuBaseAdapter<List<File>> {

    private final List<File> data;

    public FileManagerList(List<File> data) {
      super();
      this.data = new ArrayList<>(data);
    }

    @Override
    public View getView(int position, View v, ViewGroup viewGroup) {
      final Context context = viewGroup.getContext();
      LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
      View view = v;
      if (view == null) {
        view = inflater.inflate(R.layout.power_menu_listfiles, viewGroup, false);
      }

      final TextView tv_showfiledir = view.findViewById(R.id.tv_showfiledir);
      File file = data.get(position);
      tv_showfiledir.setText(file.getName());

      return view;
    }

    @Override
    public File getItem(int index) {
      return data.get(index);
    }

    @Override
    public int getCount() {
      return data.size();
    }
  }
}
