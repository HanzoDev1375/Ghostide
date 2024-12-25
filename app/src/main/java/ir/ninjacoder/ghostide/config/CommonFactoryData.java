package ir.ninjacoder.ghostide.config;

import ir.ninjacoder.ghostide.adapter.FileManagerAd;
import ir.ninjacoder.ghostide.interfaces.OnClickFileSlideSheetCallBack;
import ir.ninjacoder.ghostide.utils.FileUtil;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.sidesheet.SideSheetDialog;
import com.ninjacoder.jgit.databinding.LayoutRvSlideBinding;
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
  private ArrayList<HashMap<String, Object>> listDir = new ArrayList<>();
  protected FileManagerAd fileManagerAd;
  private CodeEditor editor;
  private SideSheetDialog dialogConfig;
  private static final String TAG = "TAG";
  private LayoutRvSlideBinding binding;
  private OnClickFileSlideSheetCallBack listCallBack;

  public CommonFactoryData(Context context, CodeEditor editor) {
    this.context = context;
    this.editor = editor;

    binding = LayoutRvSlideBinding.inflate(LayoutInflater.from(context));
    installDialog();
  }

  public void setOnClickFileSlideSheetCallBack(OnClickFileSlideSheetCallBack listCallBack) {
    this.listCallBack = listCallBack;
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

    fileManagerAd = new FileManagerAd(listDir, context, this);
    binding.rvSlide.setAdapter(fileManagerAd);
    binding.rvSlide.setLayoutManager(
        new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
  }

  @Override
  public void onClick(View view, int pos) {
    // TODO: Implement this method
    var file = new File(listDir.get(pos).get("path").toString());
    if (file.isDirectory()) {
      setlistFile(file.getAbsolutePath());
    } else {
      if (isTextFile(file.toString()))
        if (listCallBack != null) {
          listCallBack.onClickEvent(listDir, pos);
        }
    }
  }

  void installDialog() {
    dialogConfig = new SideSheetDialog(context);

    dialogConfig.setContentView(binding.getRoot());
    dialogConfig.show();
  }

  @Override
  public void onLongClick(View view, int pos) {
    listCallBack.onLongClick(listDir, pos);
  }

  private boolean isTextFile(String path) {
    return path.endsWith(".css"); 
  }
}
