package ir.ninjacoder.ghostide.core.adapter;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import ir.ninjacoder.ghostide.core.R;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import ir.ninjacoder.ghostide.core.folder.FileIconHelper;
import ir.ninjacoder.ghostide.core.utils.DataUtil;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;
import ir.ninjacoder.prograsssheet.perfence.ListItemView;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ZipListFileShowAd extends RecyclerView.Adapter<ZipListFileShowAd.Holder> {

  private List<FileHeader> allFiles;
  private List<FileHeader> showFiles;
  private String currentPath = "";
  private Context context;
  private String zipFilePath;
  private OnFileActionListener actionListener;
  private boolean multiSelectMode = false;
  private String unzipDir;
  private Set<Integer> selectedItems = new HashSet<>();

  public interface OnFileActionListener {
    void onFileActionPerformed();

    void onSelectionModeChanged(boolean isMultiSelectMode, int selectedCount);

    void onFileExtracted(String fileName);
  }

  public interface OnListStateListener {
    void onListEmpty();

    void onGoBackRequested(boolean canGoBack);
  }

  private OnListStateListener listStateListener;

  public void setOnListStateListener(OnListStateListener listener) {
    this.listStateListener = listener;
  }

  public void setOnFileActionListener(OnFileActionListener listener) {
    this.actionListener = listener;
  }

  public ZipListFileShowAd(
      Context context, List<FileHeader> allFiles, String zipFilePath, String unzipDir) {
    this.context = context;
    this.allFiles = allFiles;
    this.zipFilePath = zipFilePath;
    this.unzipDir = unzipDir;
    this.showFiles = filterAndSortFiles(currentPath);
  }

  @Override
  public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_file, parent, false);
    return new Holder(v);
  }

  @Override
  public void onBindViewHolder(Holder h, int pos) {
    FileHeader fh = showFiles.get(pos);
    boolean isDir = isDirectory(fh);
    String displayName = getDisplayName(fh);

    h.name.setText(displayName);
    h.size.setText(isDir ? "Folder" : formatSize(fh.getUncompressedSize()));

    var icon = new FileIconHelper(displayName);
    icon.setDynamicFolderEnabled(true);
    icon.setEnvironmentEnabled(true);
    if (isDir) {
      h.icon.setImageResource(R.drawable.ic_material_folder);
    } else icon.bindIcon(h.icon);
    updateSelectionBackground(h, pos);
    h.root.setOnClickListener(null);
    h.root.setOnLongClickListener(null);
    h.root.setOnClickListener(v -> handleItemClick(pos, h, fh, isDir));
    h.root.setOnLongClickListener(v -> handleItemLongClick(pos, h, fh));
    h.root.setBackground(h.root.get(allFiles, pos));
    h.root.setStrokeColorMod(true);
    h.root.setStorkeSize(1);
  }

  private void updateSelectionBackground(Holder h, int pos) {
    var itemSelect = multiSelectMode && selectedItems.contains(pos);
    h.root.setItemSelect(itemSelect);
  }

  private void handleItemClick(int pos, Holder h, FileHeader fh, boolean isDir) {
    if (multiSelectMode) {
      toggleSelection(pos, h);
    } else {
      if (isDir) {
        currentPath = fh.getFileName();
        showFiles = filterAndSortFiles(currentPath);
        selectedItems.clear();
        if (multiSelectMode) {
          disableMultiSelectMode();
        }
        notifyDataSetChanged();
        if (actionListener != null) {
          actionListener.onFileActionPerformed();
        }
      }
    }
  }

  private boolean handleItemLongClick(int pos, Holder h, FileHeader fh) {
    if (!multiSelectMode) {
      showPopupMenu(h.itemView, fh, pos);
    } else {
      if (selectedItems.contains(pos)) {
        showPopupMenu(h.itemView, fh, pos);
      } else {
        toggleSelection(pos, h);
        showPopupMenu(h.itemView, fh, pos);
      }
    }
    return true;
  }

  private void showPopupMenu(View view, FileHeader fileHeader, int position) {
    PopupMenu popup = new PopupMenu(context, view);
    popup.inflate(R.menu.file_popup_menu);

    if (multiSelectMode) {
      MenuItem extractItem = popup.getMenu().findItem(R.id.action_extract);
      if (extractItem != null) {
        if (selectedItems.isEmpty()) {
          extractItem.setTitle("Extract");
        } else {
          extractItem.setTitle("Extract selected (" + selectedItems.size() + ")");
        }
      }

      MenuItem deleteItem = popup.getMenu().findItem(R.id.action_delete);
      if (deleteItem != null) {
        if (selectedItems.isEmpty()) {
          deleteItem.setTitle("Delete");
        } else {
          deleteItem.setTitle("Delete selected (" + selectedItems.size() + ")");
        }
      }

      MenuItem renameItem = popup.getMenu().findItem(R.id.action_rename);
      if (renameItem != null) {
        renameItem.setTitle("Rename");
        renameItem.setEnabled(selectedItems.size() == 1);
      }

      MenuItem selectItem = popup.getMenu().findItem(R.id.action_select_multiple);
      if (selectItem != null) {
        selectItem.setVisible(false);
      }
    }

    popup.setOnMenuItemClickListener(
        item -> {
          int itemId = item.getItemId();
          if (itemId == R.id.action_extract) {
            if (multiSelectMode && !selectedItems.isEmpty()) {
              extractSelectedItems();
            } else {
              extractFile(fileHeader);
            }
            return true;
          } else if (itemId == R.id.action_rename) {
            if (multiSelectMode && selectedItems.size() == 1) {
              renameSelectedItem();
            } else {
              showRenameDialog(fileHeader, position);
            }
            return true;
          } else if (itemId == R.id.action_delete) {
            if (multiSelectMode && !selectedItems.isEmpty()) {
              deleteSelectedItems();
            } else {
              showDeleteDialog(fileHeader, position);
            }
            return true;
          } else if (itemId == R.id.action_select_multiple) {
            if (!multiSelectMode) {
              enableMultiSelectMode();
              toggleSelection(position, null);
            }
            return true;
          }
          return false;
        });

    popup.show();
  }

  public void enableMultiSelectMode() {
    multiSelectMode = true;
    selectedItems.clear();
    notifyDataSetChanged();
    DataUtil.showMessage(context, "Multi-select mode enabled");
    if (actionListener != null) {
      actionListener.onSelectionModeChanged(true, 0);
    }
  }

  public void disableMultiSelectMode() {
    multiSelectMode = false;
    selectedItems.clear();
    notifyDataSetChanged();
    DataUtil.showMessage(context, "Multi-select mode disabled");
    if (actionListener != null) {
      actionListener.onSelectionModeChanged(false, 0);
    }
  }

  private void extractFile(FileHeader fileHeader) {
    var builder = new MaterialAlertDialogBuilder(context);
    builder.setTitle("Extract");
    builder.setMessage("Extract to internal storage?");

    builder.setPositiveButton(
        "Extract",
        (dialog, which) -> {
          new ExtractTask().execute(fileHeader);
        });

    builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
    builder.show();
  }

  private class ExtractTask extends AsyncTask<FileHeader, Void, Boolean> {
    private ProgressDialog progressDialog;
    private String fileName;

    @Override
    protected void onPreExecute() {
      progressDialog = new ProgressDialog(context);
      progressDialog.setMessage("Extracting...");
      progressDialog.setCancelable(false);
      progressDialog.show();
    }

    @Override
    protected Boolean doInBackground(FileHeader... fileHeaders) {
      try {
        FileHeader fileHeader = fileHeaders[0];
        fileName = getDisplayName(fileHeader);
        ZipFile zipFile = new ZipFile(zipFilePath);
        File destination = new File(unzipDir);
        if (!destination.exists()) {
          destination.mkdirs();
        }
        String filePathInZip = fileHeader.getFileName();
        if (filePathInZip.contains("/")) {
          zipFile.extractFile(filePathInZip, unzipDir);
        } else {
          zipFile.extractFile(fileHeader, unzipDir);
        }

        return true;
      } catch (Exception e) {
        e.printStackTrace();
        Log.e("ZipExtract", "Error extracting file: " + e.getMessage());
        return false;
      }
    }

    @Override
    protected void onPostExecute(Boolean success) {
      progressDialog.dismiss();
      if (success) {
        Toast.makeText(context, "Extracted: " + fileName, Toast.LENGTH_SHORT).show();
        if (actionListener != null) {
          actionListener.onFileExtracted(fileName);
        }
      } else {
        Toast.makeText(context, "Extraction failed", Toast.LENGTH_SHORT).show();
      }
    }
  }

  private void showRenameDialog(FileHeader fileHeader, int position) {
    var builder = new MaterialAlertDialogBuilder(context);
    builder.setTitle("Rename");

    final EditText input = new EditText(context);
    input.setInputType(InputType.TYPE_CLASS_TEXT);
    input.setText(getDisplayName(fileHeader));
    input.selectAll();

    builder.setView(input);

    builder.setPositiveButton(
        "Rename",
        (dialog, which) -> {
          String newName = input.getText().toString().trim();
          String currentName = getDisplayName(fileHeader);

          if (!newName.isEmpty() && !newName.equals(currentName)) {
            new RenameTask().execute(fileHeader, newName);
          }
        });

    builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
    builder.show();
  }

  private class RenameTask extends AsyncTask<Object, Void, Boolean> {
    private ProgressDialog progressDialog;

    @Override
    protected void onPreExecute() {
      progressDialog = new ProgressDialog(context);
      progressDialog.setMessage("Renaming...");
      progressDialog.setCancelable(false);
      progressDialog.show();
    }

    @Override
    protected Boolean doInBackground(Object... params) {
      try {
        FileHeader oldFileHeader = (FileHeader) params[0];
        String newName = (String) params[1];

        ZipFile zipFile = new ZipFile(zipFilePath);
        String oldFileName = oldFileHeader.getFileName();
        boolean isDirectory = isDirectory(oldFileHeader);

        String newFileName;
        if (currentPath.isEmpty()) {
          newFileName = newName + (isDirectory ? "/" : "");
        } else {
          newFileName = currentPath + newName + (isDirectory ? "/" : "");
        }

        if (isNameExists(newFileName)) {
          return false;
        }

        zipFile.renameFile(oldFileName, newFileName);
        return true;
      } catch (Exception e) {
        e.printStackTrace();
        return false;
      }
    }

    @Override
    protected void onPostExecute(Boolean success) {
      progressDialog.dismiss();
      if (success) {
        Toast.makeText(context, "Renamed successfully", Toast.LENGTH_SHORT).show();
        refreshFileList();
        if (actionListener != null) {
          actionListener.onFileActionPerformed();
        }
      } else {
        Toast.makeText(context, "Name already exists", Toast.LENGTH_SHORT).show();
      }
    }
  }

  private void showDeleteDialog(FileHeader fileHeader, int position) {
    var builder = new MaterialAlertDialogBuilder(context);
    builder.setTitle("Delete");
    builder.setMessage("Are you sure?");

    builder.setPositiveButton(
        "Delete",
        (dialog, which) -> {
          new DeleteTask().execute(fileHeader);
        });

    builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
    builder.show();
  }

  private class DeleteTask extends AsyncTask<FileHeader, Void, Boolean> {
    private ProgressDialog progressDialog;
    private String fileName;

    @Override
    protected void onPreExecute() {
      progressDialog = new ProgressDialog(context);
      progressDialog.setMessage("Deleting...");
      progressDialog.setCancelable(false);
      progressDialog.show();
    }

    @Override
    protected Boolean doInBackground(FileHeader... fileHeaders) {
      try {
        FileHeader fileHeader = fileHeaders[0];
        fileName = getDisplayName(fileHeader);

        ZipFile zipFile = new ZipFile(zipFilePath);
        zipFile.removeFile(fileHeader.getFileName());
        return true;
      } catch (Exception e) {
        e.printStackTrace();
        return false;
      }
    }

    @Override
    protected void onPostExecute(Boolean success) {
      progressDialog.dismiss();
      if (success) {
        Toast.makeText(context, "Deleted: " + fileName, Toast.LENGTH_SHORT).show();
        refreshFileList();
        if (actionListener != null) {
          actionListener.onFileActionPerformed();
        }
        if (showFiles.isEmpty() && listStateListener != null) {
          listStateListener.onListEmpty();
        }
      } else {
        Toast.makeText(context, "Delete failed", Toast.LENGTH_SHORT).show();
      }
    }
  }

  public boolean isMultiSelectMode() {
    return multiSelectMode;
  }

  public int getSelectedCount() {
    return selectedItems.size();
  }

  public void toggleSelection(int position, Holder holder) {
    if (position < 0 || position >= showFiles.size()) {
      return;
    }

    if (selectedItems.contains(position)) {
      selectedItems.remove(position);
    } else {
      selectedItems.add(position);
    }

    if (holder != null) {
      updateSelectionBackground(holder, position);
    } else {
      notifyItemChanged(position);
    }

    if (actionListener != null) {
      actionListener.onSelectionModeChanged(multiSelectMode, selectedItems.size());
    }

    if (selectedItems.isEmpty() && multiSelectMode) {
      disableMultiSelectMode();
    }
  }

  public void extractSelectedItems() {
    if (selectedItems.isEmpty()) {
      Toast.makeText(context, "No items selected", Toast.LENGTH_SHORT).show();
      return;
    }

    List<FileHeader> selected = new ArrayList<>();
    Set<Integer> validIndices = new HashSet<>();
    for (int position : selectedItems) {
      if (position >= 0 && position < showFiles.size()) {
        selected.add(showFiles.get(position));
        validIndices.add(position);
      }
    }

    selectedItems.clear();
    selectedItems.addAll(validIndices);

    if (selected.isEmpty()) {
      Toast.makeText(context, "No valid items selected", Toast.LENGTH_SHORT).show();
      return;
    }

    new ExtractMultipleTask().execute(selected);
  }

  private class ExtractMultipleTask extends AsyncTask<List<FileHeader>, Void, Boolean> {
    private ProgressDialog progressDialog;
    private int count;

    @Override
    protected void onPreExecute() {
      count = selectedItems.size();
      progressDialog = new ProgressDialog(context);
      progressDialog.setMessage("Extracting " + count + " items...");
      progressDialog.setCancelable(false);
      progressDialog.show();
    }

    @Override
    protected Boolean doInBackground(List<FileHeader>... lists) {
      try {
        List<FileHeader> fileHeaders = lists[0];
        ZipFile zipFile = new ZipFile(zipFilePath);

        File destination = new File(unzipDir);
        if (!destination.exists()) {
          destination.mkdirs();
        }

        for (FileHeader fileHeader : fileHeaders) {
          zipFile.extractFile(fileHeader.getFileName(), destination.getPath() + "/");
        }
        return true;
      } catch (Exception e) {
        e.printStackTrace();
        return false;
      }
    }

    @Override
    protected void onPostExecute(Boolean success) {
      progressDialog.dismiss();
      if (success) {
        Toast.makeText(context, "Extracted " + count + " items", Toast.LENGTH_SHORT).show();
        disableMultiSelectMode();
      } else {
        Toast.makeText(context, "Extraction failed", Toast.LENGTH_SHORT).show();
      }
    }
  }

  public void deleteSelectedItems() {
    if (selectedItems.isEmpty()) {
      Toast.makeText(context, "No items selected", Toast.LENGTH_SHORT).show();
      return;
    }

    var builder = new MaterialAlertDialogBuilder(context);
    builder.setTitle("Delete Multiple");
    builder.setMessage("Delete " + selectedItems.size() + " items?");

    builder.setPositiveButton(
        "Delete",
        (dialog, which) -> {
          List<FileHeader> selected = new ArrayList<>();
          for (int position : selectedItems) {
            if (position >= 0 && position < showFiles.size()) {
              selected.add(showFiles.get(position));
            }
          }
          new DeleteMultipleTask().execute(selected);
        });

    builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
    builder.show();
  }

  private class DeleteMultipleTask extends AsyncTask<List<FileHeader>, Void, Boolean> {
    private ProgressDialog progressDialog;
    private int count;

    @Override
    protected void onPreExecute() {
      count = selectedItems.size();
      progressDialog = new ProgressDialog(context);
      progressDialog.setMessage("Deleting " + count + " items...");
      progressDialog.setCancelable(false);
      progressDialog.show();
    }

    @Override
    protected Boolean doInBackground(List<FileHeader>... lists) {
      try {
        List<FileHeader> fileHeaders = lists[0];
        ZipFile zipFile = new ZipFile(zipFilePath);

        for (FileHeader fileHeader : fileHeaders) {
          zipFile.removeFile(fileHeader.getFileName());
        }
        return true;
      } catch (Exception e) {
        e.printStackTrace();
        return false;
      }
    }

    @Override
    protected void onPostExecute(Boolean success) {
      progressDialog.dismiss();
      if (success) {
        Toast.makeText(context, "Deleted " + count + " items", Toast.LENGTH_SHORT).show();
        refreshFileList();
        disableMultiSelectMode();
        if (showFiles.isEmpty() && listStateListener != null) {
          listStateListener.onListEmpty();
        }
      } else {
        Toast.makeText(context, "Delete failed", Toast.LENGTH_SHORT).show();
      }
    }
  }

  public void renameSelectedItem() {
    if (selectedItems.size() != 1) {
      Toast.makeText(context, "Select only one item", Toast.LENGTH_SHORT).show();
      return;
    }

    int position = selectedItems.iterator().next();
    if (position >= 0 && position < showFiles.size()) {
      FileHeader fileHeader = showFiles.get(position);
      showRenameDialog(fileHeader, position);
    } else {
      Toast.makeText(context, "Invalid selection", Toast.LENGTH_SHORT).show();
    }
  }

  private boolean isNameExists(String fileName) {
    for (FileHeader fh : allFiles) {
      if (fh.getFileName().equals(fileName)) {
        return true;
      }
    }
    return false;
  }

  private void refreshFileList() {
    try {
      ZipFile zipFile = new ZipFile(zipFilePath);
      allFiles = zipFile.getFileHeaders();
      showFiles = filterAndSortFiles(currentPath);

      selectedItems.clear();
      if (multiSelectMode && selectedItems.isEmpty()) {
        disableMultiSelectMode();
      }

      notifyDataSetChanged();
      if (showFiles.isEmpty() && listStateListener != null) {
        listStateListener.onListEmpty();
      }
    } catch (ZipException e) {
      e.printStackTrace();
    }
  }

  @Override
  public int getItemCount() {
    return showFiles.size();
  }

  public void updateAll(List<FileHeader> list) {
    allFiles = list;
    currentPath = "";
    showFiles = filterAndSortFiles(currentPath);

    selectedItems.clear();
    if (multiSelectMode && selectedItems.isEmpty()) {
      disableMultiSelectMode();
    }

    notifyDataSetChanged();
  }

  private List<FileHeader> filterAndSortFiles(String path) {
    List<FileHeader> filtered = filterFiles(path);
    sortFiles(filtered);
    return filtered;
  }

  private List<FileHeader> filterFiles(String path) {
    List<FileHeader> result = new ArrayList<>();
    Set<String> added = new HashSet<>();

    for (FileHeader fh : allFiles) {
      String fileName = fh.getFileName();

      if (!fileName.startsWith(path)) continue;

      String remaining = fileName.substring(path.length());
      if (remaining.isEmpty()) continue;

      int slash = remaining.indexOf('/');
      String displayName = slash == -1 ? remaining : remaining.substring(0, slash + 1);

      String key = path + displayName;
      if (!added.contains(key)) {
        FileHeader displayHeader = null;

        if (fileName.equals(key)) {
          displayHeader = fh;
        } else {
          for (FileHeader original : allFiles) {
            if (original.getFileName().startsWith(key)) {
              displayHeader = new FileHeader();
              displayHeader.setFileName(key);
              displayHeader.setDirectory(displayName.endsWith("/"));
              if (original.getUncompressedSize() > 0) {
                displayHeader.setUncompressedSize(original.getUncompressedSize());
              }
              break;
            }
          }
        }

        if (displayHeader != null) {
          result.add(displayHeader);
          added.add(key);
        }
      }
    }
    return result;
  }

  private void sortFiles(List<FileHeader> files) {
    files.sort(
        (f1, f2) -> {
          boolean isDir1 = isDirectory(f1);
          boolean isDir2 = isDirectory(f2);

          if (isDir1 == isDir2) {
            String name1 = getDisplayName(f1).toLowerCase();
            String name2 = getDisplayName(f2).toLowerCase();
            return name1.compareTo(name2);
          }
          return isDir1 ? -1 : 1;
        });
  }

  private boolean isDirectory(FileHeader fh) {
    return fh.isDirectory() || fh.getFileName().endsWith("/");
  }

  private String getDisplayName(FileHeader fh) {
    String fullName = fh.getFileName();
    String relative = fullName.substring(currentPath.length());

    if (relative.endsWith("/")) {
      relative = relative.substring(0, relative.length() - 1);
    }

    int slash = relative.indexOf('/');
    if (slash != -1) {
      relative = relative.substring(0, slash);
    }

    return relative.isEmpty() ? fullName : relative;
  }

  public boolean goBack() {
    if (currentPath.isEmpty()) return false;

    String temp = currentPath;
    if (temp.endsWith("/")) {
      temp = temp.substring(0, temp.length() - 1);
    }
    int lastSlash = temp.lastIndexOf('/');
    currentPath = lastSlash == -1 ? "" : temp.substring(0, lastSlash + 1);
    showFiles = filterAndSortFiles(currentPath);
    selectedItems.clear();
    if (multiSelectMode && selectedItems.isEmpty()) {
      disableMultiSelectMode();
    }

    notifyDataSetChanged();
    return true;
  }

  private String formatSize(long size) {
    if (size < 1024) return size + " B";
    if (size < 1024 * 1024) return (size / 1024) + " KB";
    return (size / (1024 * 1024)) + " MB";
  }

  public String getCurrentPath() {
    return currentPath;
  }

  public int getTotalItems() {
    return showFiles.size();
  }

  public int getFolderCount() {
    int count = 0;
    for (FileHeader fh : showFiles) {
      if (isDirectory(fh)) count++;
    }
    return count;
  }

  public int getFileCount() {
    return showFiles.size() - getFolderCount();
  }

  public static class Holder extends RecyclerView.ViewHolder {
    TextView name, size;
    ImageView icon;
    ListItemView root;

    Holder(View v) {
      super(v);
      name = v.findViewById(R.id.tvFileName);
      size = v.findViewById(R.id.tvFileSize);
      icon = v.findViewById(R.id.ivIcon);
      root = v.findViewById(R.id.root);
    }
  }
}
