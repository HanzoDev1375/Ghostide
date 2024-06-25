package Ninja.coder.Ghostemane.code.config;

import Ninja.coder.Ghostemane.code.adapter.FileManagerAd;
import Ninja.coder.Ghostemane.code.utils.FileUtil;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CommonFactoryData implements FileManagerAd.onClick {
  protected Context context;
  private List<String> list = new ArrayList<>();
  private List<HashMap<String, Object>> listDir = new ArrayList<>();
  protected RecyclerView rv;
  protected FileManagerAd fileManagerAd;
  private CodeEditor editor;
  private AlertDialog dialogConfig;
  private static final String TAG = "TAG";

  public CommonFactoryData(Context context, CodeEditor editor) {
    this.context = context;
    this.editor = editor;
  }

  public void setlistFile(String path) {

    final class FileComparator implements Comparator<String> {
      public int compare(String f1, String f2) {
        if (f1 == f2) return 0;
        if (FileUtil.isDirectory(f1) && FileUtil.isFile(f2)) return -1;
        if (FileUtil.isFile(f1) && FileUtil.isDirectory(f2)) return 1;
        return f1.compareToIgnoreCase(f2);
      }
    }
    listDir.clear();
    FileUtil.listDir(path, list);
    Collections.sort(list, new FileComparator());
    var position = 0;
    for (int b = 0; b < (int) (list.size()); b++) {
      {
        HashMap<String, Object> _item = new HashMap<>();
        _item.put("path", list.get(position));
        listDir.add(_item);
      }
      position++;
    }

    rv = new RecyclerView(context);
    ViewGroup.LayoutParams p =
        new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    // for test
    rv.setLayoutParams(p);

    fileManagerAd = new FileManagerAd(listDir, context, this);
    rv.setAdapter(fileManagerAd);
    rv.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
    dialogConfig = new MaterialAlertDialogBuilder(context).setView(rv).create();
    dialogConfig.show();
  }

  @Override
  public void onClick(View view, int pos) {
    // TODO: Implement this method
    var file = new File(listDir.get(pos).get("path").toString());
    if (file.isDirectory()) {
        Log.d(TAG,"dont select onClick to path");
    } else {
      var symbol = editor.createNewSymbolChannel();
      symbol.insertSymbol(file.getName(), file.getName().length() == 0 ? 0 : 1);
      
      if (dialogConfig != null) {
        dialogConfig.dismiss();
      }
    }
  }

  @Override
  public void onLongClick(View view, int pos) {
    
  }
}
