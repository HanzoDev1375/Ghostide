package ir.ninjacoder.ghostide.core.config;

import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.ninjacoder.ghostide.core.activities.FileManagerActivity;
import ir.ninjacoder.ghostide.core.adapter.ToolbarListFileAdapter;
import ir.ninjacoder.ghostide.core.marco.binder.bindchilder.GhostToast;
import ir.ninjacoder.ghostide.core.utils.FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TreeFileManager {
  private FileManagerActivity activity;
  private String TAG = "TreeFileManager";
  private RecyclerView recyclerview;
  private String path;
  private List<String> result = new ArrayList<>();
  private ToolbarListFileAdapter adapter;

  public TreeFileManager(FileManagerActivity activity, RecyclerView recyclerview, String path) {
    this.activity = activity;
    this.recyclerview = recyclerview;
    this.path = path;
    initAdapter();
    Log.w(TAG, "Start + " + TAG);
    updatePath(path);
  }

  public void updatePath(String newPath) {
    this.path = newPath;
    List<String> newResult = spiltPath(newPath);
    recyclerview.post(
        () -> {
          adapter.submitList(new ArrayList<>(newResult));
          Log.d(TAG, "Updated UI for: " + newPath + " | Size: " + newResult.size());

          if (newResult.size() > 0) {
            recyclerview.smoothScrollToPosition(newResult.size() - 1);
          }
        });
  }

  void initAdapter() {
    adapter =
        new ToolbarListFileAdapter(
            result,
            activity,
            new ToolbarListFileAdapter.CallBack() {
              @Override
              public void GoToDir(View view, int pos, String dir) {
               
              }

              @Override
              public void GoToTreeFile(View view, int pos, String dir) {}
            });
    recyclerview.setAdapter(adapter);
    recyclerview.setLayoutManager(
        new LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false));
  }

  private List<String> spiltPath(String filePath) {
    String separator = "/";
    String[] items = filePath.split(separator);
    List<String> fullPaths = new ArrayList<>();
    StringBuilder currentPath = new StringBuilder();
    for (String item : items) {
      if (!item.trim().isEmpty()) {
        if (currentPath.length() > 0) {
          currentPath.append(separator);
        }
        currentPath.append(item);
        fullPaths.add(currentPath.toString());
      }
    }
    return fullPaths;
  }
}
