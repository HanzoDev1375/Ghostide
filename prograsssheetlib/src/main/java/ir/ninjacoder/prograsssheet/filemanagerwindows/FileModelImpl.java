package ir.ninjacoder.prograsssheet.filemanagerwindows;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.ColorRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.selection.StorageStrategy;
import com.blankj.utilcode.util.ThreadUtils;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import ir.ninjacoder.prograsssheet.R;
import ir.ninjacoder.prograsssheet.databinding.LayoutPopwindowsFileBinding;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileModelImpl implements TextWatcher {

  private boolean call = false;
  private List<FileModel> fileModel = new ArrayList<>();
  private BottomSheetDialog windows;
  private ExecutorService executor = Executors.newFixedThreadPool(4);
  private int color;
  private LayoutPopwindowsFileBinding bind;
  private static FileModelImpl impl;
  private FileModelAdapter adapter;
  private String currentPath;
  private Context context;

  private MultiSelectionPanel selectionPanel;

  private List<FileModel> clipboardFiles = new ArrayList<>();
  private boolean isCutOperation = false;

  public static FileModelImpl getIns() {
    if (impl == null) {
      impl = new FileModelImpl();
    }
    return impl;
  }

  void listDir(String path, List<FileModel> list) {
    File dir = new File(path);
    if (!dir.exists() || dir.isFile()) return;
    File[] listFiles = dir.listFiles();
    if (listFiles == null || listFiles.length <= 0) return;
    if (list == null) return;
    list.clear();
    for (File file : listFiles) {
      list.add(new FileModel(file.getAbsolutePath()));
    }
  }

  public void setContext(Context c) {
    this.context = c;
  }

  public void setBindPopWindows(String path, View v, FileHandlerModel event) {
    bind = LayoutPopwindowsFileBinding.inflate(LayoutInflater.from(v.getContext()));
    windows = new BottomSheetDialog(v.getContext());
    call = true;
    fileModel.clear();
    currentPath = path;
    windows.setContentView(bind.getRoot());
    windows.show();

    adapter = new FileModelAdapter(fileModel, event);
    bind.rvroot.setLayoutManager(
        new LinearLayoutManager(v.getContext(), RecyclerView.VERTICAL, false));
    bind.rvroot.setAdapter(adapter);
    SelectionTracker.Builder<Long> builder =
        new SelectionTracker.Builder<>(
            "file-selection-unique-id",
            bind.rvroot,
            new FileModelAdapter.MyItemKeyProvider(bind.rvroot),
            new FileModelAdapter.MyItemDetailsLookup(bind.rvroot),
            StorageStrategy.createLongStorage());

    SelectionTracker<Long> tracker = builder.build();
    adapter.setSelectionTracker(tracker);

    View panelView = bind.getRoot().findViewById(R.id.selectionPanel);
    if (panelView != null) {
      selectionPanel =
          new MultiSelectionPanel(
              panelView,
              adapter,
              new MultiSelectionPanel.PanelActionListener() {
                @Override
                public void onCopyClicked(List<FileModel> selectedFiles) {
                  clipboardFiles = new ArrayList<>(selectedFiles);
                  isCutOperation = false;
                  adapter.clearSelection();
                  selectionPanel.getIconCopy().setEnabled(false);
                  selectionPanel.getIconCut().setEnabled(false);
                  selectionPanel.getIconPaste().setColorFilter(Color.GREEN);
                  Toast.makeText(v.getContext(), "کپی شد", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCutClicked(List<FileModel> selectedFiles) {
                  clipboardFiles = new ArrayList<>(selectedFiles);
                  isCutOperation = true;
                  adapter.clearSelection();
                  selectionPanel.getIconCopy().setEnabled(false);
                  selectionPanel.getIconCut().setEnabled(false);
                  selectionPanel.getIconPaste().setColorFilter(Color.GREEN);
                  Toast.makeText(v.getContext(), "برش شد", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onDeleteClicked(List<FileModel> selectedFiles) {
                  performDelete(selectedFiles);
                  adapter.clearSelection();
                  selectionPanel.getIconCopy().setEnabled(true);
                  selectionPanel.getIconPaste().setEnabled(false);
                  selectionPanel.getIconCut().setEnabled(true);
                  selectionPanel.getIconPaste().clearColorFilter();
                }

                @Override
                public void onPasteClicked() {
                  selectionPanel.getIconCopy().setEnabled(true);
                  selectionPanel.getIconPaste().setEnabled(false);
                  selectionPanel.getIconCut().setEnabled(true);
                  selectionPanel.getIconPaste().clearColorFilter();
                  performPaste(currentPath);
                }

                @Override
                public void onCloseClicked() {
                  adapter.clearSelection();
                  selectionPanel.getIconCopy().setEnabled(true);
                  selectionPanel.getIconPaste().setEnabled(true);
                  selectionPanel.getIconCut().setEnabled(true);
                  selectionPanel.getIconPaste().clearColorFilter();
                }
              });
    }

    executor.execute(
        () -> {
          fileModel.clear();
          listDir(path, fileModel);

          Collections.sort(
              fileModel,
              (f1, f2) -> {
                if (f1 == f2) return 0;
                if (PathUtils.isDirectory(f1.getPath()) && PathUtils.isFile(f2.getPath()))
                  return -1;
                if (PathUtils.isFile(f1.getPath()) && PathUtils.isDirectory(f2.getPath())) return 1;
                return f1.getPath().compareToIgnoreCase(f2.getPath());
              });
          ThreadUtils.runOnUiThread(
              () -> {
                adapter.submitList(new ArrayList<>(fileModel));
                if (!fileModel.isEmpty()) {
                  bind.emptyviews.hide();
                } else {
                  bind.emptyviews.show();
                }
              });
        });
    bind.filterItem.addTextChangedListener(this);
  }

  private void performDelete(List<FileModel> filesToDelete) {
    executor.execute(
        () -> {
          for (FileModel model : filesToDelete) {
            File file = new File(model.getPath());
            if (file.exists()) {
              deleteRecursive(file);
            }
          }
          refreshList();
        });
  }

  private void deleteRecursive(File fileOrDirectory) {
    if (fileOrDirectory.isDirectory()) {
      for (File child : fileOrDirectory.listFiles()) {
        deleteRecursive(child);
      }
      update();
    }
    fileOrDirectory.delete();
  }

  private void performPaste(String destinationPath) {
    if (clipboardFiles.isEmpty()) return;
    File destDir = new File(destinationPath);
    if (!destDir.exists()) destDir.mkdirs();

    for (FileModel model : clipboardFiles) {
      File sourceFile = new File(model.getPath());
      File destFile = new File(destDir, sourceFile.getName());
      PathUtils.moveFileOrDirByGhostide(
          sourceFile.toString(),
          destFile.toString(),
          new PathUtils.OnFileChangeCall() {

            @Override
            public void onFileDone() {
              update();
            }

            @Override
            public void onFileError(String error) {}
          },
          isCutOperation,
          context);
    }

    if (isCutOperation) {
      clipboardFiles.clear();
    }

    refreshList();
  }

  private void refreshList() {
    if (bind != null) {
      bind.getRoot()
          .post(
              () -> {
                listDir(currentPath, fileModel);
                adapter.submitList(new ArrayList<>(fileModel));
                if (!fileModel.isEmpty()) {
                  bind.emptyviews.hide();
                } else {
                  bind.emptyviews.show();
                }
              });
    }
  }

  public void setPath(String path) {
    this.currentPath = path;
    if (call && bind != null) {
      executor.execute(
          () -> {
            fileModel.clear();
            Collections.sort(
                fileModel,
                (f1, f2) -> {
                  if (f1 == f2) return 0;
                  if (PathUtils.isDirectory(f1.getPath()) && PathUtils.isFile(f2.getPath()))
                    return -1;
                  if (PathUtils.isFile(f1.getPath()) && PathUtils.isDirectory(f2.getPath()))
                    return 1;
                  return f1.getPath().compareToIgnoreCase(f2.getPath());
                });
            listDir(path, fileModel);
            ThreadUtils.runOnUiThread(
                () -> {
                  adapter.submitList(new ArrayList<>(fileModel));
                  if (!fileModel.isEmpty()) {
                    bind.emptyviews.hide();
                  } else {
                    bind.emptyviews.show();
                  }
                });
          });
    }
  }

  public void dismiss() {
    if (windows != null) {
      windows.dismiss();
    }
  }

  public List<FileModel> getFileModel() {
    return this.fileModel;
  }

  public void setFileModel(List<FileModel> fileModel) {
    this.fileModel = fileModel;
  }

  public void stopThread() {
    executor.shutdown();
  }

  @Override
  protected void finalize() throws Throwable {
    super.finalize();
    stopThread();
  }

  @NonNull
  public int getColor() {
    return this.color;
  }

  public void setColor(@ColorRes int color) {
    this.color = color;
  }

  public void setLayoutBack(@NonNull View.OnClickListener c) {

    if (call) {
      bind.layoutBack.setOnClickListener(c);
      bind.layoutBack.setOnTouchListener(
          (v, mo) -> {
            if (mo.getAction() == MotionEvent.ACTION_UP) {
              v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start();
            } else if (mo.getAction() == MotionEvent.ACTION_DOWN) {
              v.animate().scaleX(1.3f).scaleY(1.3f).setDuration(100).start();
            }
            return false;
          });
    } else new IllegalArgumentException("You not call setBindPopWindows");
  }

  public void setIcon(@IdRes int id) {
    if (call) bind.icondata.setImageResource(id);
    else new IllegalArgumentException("You not call setBindPopWindows");
  }

  public void update() {
    if (call) adapter.submitList(new ArrayList<>(fileModel));
    else new IllegalArgumentException("You not call setBindPopWindows");
  }

  @Override
  public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}

  @Override
  public void onTextChanged(CharSequence s, int arg1, int arg2, int arg3) {
    if (s.length() > 0) {
      adapter.filter(s.toString());
    }
  }

  @Override
  public void afterTextChanged(Editable arg0) {}
}
