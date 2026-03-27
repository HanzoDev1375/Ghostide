package ir.ninjacoder.ghostide.core.mult;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import ir.ninjacoder.ghostide.core.model.filemanager.FileManagerModel;

public class MultiSelectionManager {
  private Set<Integer> selectedPositions = new HashSet<>();
  private OnSelectionChangedListener listener;
  private boolean isMultiSelectionEnabled = false;

  public interface OnSelectionChangedListener {
    void onSelectionChanged(int selectedCount, boolean isSelectionMode);
  }

  public void enableMultiSelection(boolean enable) {
    if (!enable) {
      clearSelection();
    }
    this.isMultiSelectionEnabled = enable;
  }

  public boolean isMultiSelectionEnabled() {
    return isMultiSelectionEnabled;
  }

  public void toggleSelection(int position) {
    if (!isMultiSelectionEnabled) {
      isMultiSelectionEnabled = true;
    }

    if (selectedPositions.contains(position)) {
      selectedPositions.remove(position);
    } else {
      selectedPositions.add(position);
    }
    notifySelectionChanged();
  }

  public void selectAll(int totalCount) {
    selectedPositions.clear();
    for (int i = 0; i < totalCount; i++) {
      selectedPositions.add(i);
    }
    notifySelectionChanged();
  }

  public void clearSelection() {
    selectedPositions.clear();
    isMultiSelectionEnabled = false;
    notifySelectionChanged();
  }

  public boolean isSelected(int position) {
    return selectedPositions.contains(position);
  }

  public boolean isInSelectionMode() {
    return isMultiSelectionEnabled && !selectedPositions.isEmpty();
  }

  public int getSelectedCount() {
    return selectedPositions.size();
  }

  public List<Integer> getSelectedPositions() {
    return new ArrayList<>(selectedPositions);
  }

  public List<String> getSelectedPaths(List<FileManagerModel> items) {
    List<String> paths = new ArrayList<>();
    for (int pos : selectedPositions) {
      if (pos >= 0 && pos < items.size()) {
        paths.add(items.get(pos).getFilePath());
      }
    }
    return paths;
  }

    private void notifySelectionChanged() {
    if (listener != null) {
      boolean isSelectionMode = isInSelectionMode();
      // فراخوانی لیسنر با وضعیت صحیح
      listener.onSelectionChanged(getSelectedCount(), isSelectionMode);
    }
  }

  public void setOnSelectionChangedListener(OnSelectionChangedListener listener) {
    this.listener = listener;
  }
}
