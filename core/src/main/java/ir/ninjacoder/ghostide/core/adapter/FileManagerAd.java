package ir.ninjacoder.ghostide.core.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.color.MaterialColors;
import ir.ninjacoder.ghostide.core.marco.binder.BlurMaterialCardView;
import ir.ninjacoder.ghostide.core.marco.binder.bindchilder.RecyclerviewViewHolderBinder;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.utils.FileUtil;
import ir.ninjacoder.prograsssheet.listchild.Child;
import ir.ninjacoder.prograsssheet.perfence.ListItemView;
import ir.ninjacoder.ghostide.core.widget.component.fastscrollcompat.PopupTextProvider;
import ir.ninjacoder.ghostide.core.model.filemanager.FileManagerModel;
import ir.ninjacoder.ghostide.core.model.filemanager.FileState;

public class FileManagerAd extends RecyclerView.Adapter<FileManagerAd.VH>
    implements PopupTextProvider, Filterable {

  private Context context;
  private onClick click;
  private ViewType viewType = ViewType.ROW;
  private List<Child> listChild = new ArrayList<>();
  private List<FileManagerModel> allFiles = new ArrayList<>();
  private List<FileManagerModel> filteredFiles = new ArrayList<>();
  private String currentFilter = "";

  public FileManagerAd(Context context, onClick click, List<Child> listChild) {
    this.context = context;
    this.click = click;
    this.listChild = listChild;
    this.filteredFiles = new ArrayList<>();
  }

  @NonNull
  @Override
  public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view;
    if (this.viewType == ViewType.ROW) {
      view =
          LayoutInflater.from(parent.getContext()).inflate(R.layout.folder_remster, parent, false);
    } else {
      view =
          LayoutInflater.from(parent.getContext())
              .inflate(R.layout.folder_layout_grid, parent, false);
    }
    return new VH(view);
  }

  @Override
  public void onBindViewHolder(@NonNull VH holder, int position) {
    bind(holder, position);
  }

  @Override
  public void onBindViewHolder(@NonNull VH holder, int position, @NonNull List<Object> payloads) {
    if (payloads != null && !payloads.isEmpty() && payloads.contains("IS_NEW_CHANGED")) {
      FileManagerModel item = getItem(position);
    } else {
      bind(holder, position);
    }
  }

  private void bind(VH holder, int position) {
    if (position < 0 || position >= filteredFiles.size()) {
      Log.e("FileManagerAd", "Invalid position in bind: " + position);
      return;
    }

    FileManagerModel item = filteredFiles.get(position);
    if (item == null) {
      return;
    }

    setSettingTextView(holder.folderName);

    File file = new File(item.getFilePath());
    boolean isSearch = !TextUtils.isEmpty(currentFilter);
    holder.folderName.setText(file.getName());

    int allFilesPosition = getOriginalPosition(position);

    if (allFilesPosition >= 0 && allFilesPosition < allFiles.size()) {
      try {
        RecyclerviewViewHolderBinder.bindHolder(
            allFiles.get(allFilesPosition),
            holder.folderName,
            holder.tvTools,
            holder.icon,
            viewType);

      } catch (Exception e) {
        Log.e("FileManagerAd", "Error in binder: " + e.getMessage());
      }
    }

    holder.itemView.setClickable(true);
    if (item.getFilestate() != null) {
      switch (item.getFilestate()) {
        case RENAME:
          holder.folderName.setTextColor(FileState.RENAME.getColor());
          break;
        case ADD:
          holder.folderName.setTextColor(FileState.ADD.getColor());
          break;
        case SELECTBELITEM:
          holder.folderName.setTextColor(FileState.SELECTBELITEM.getColor());
          break;
        case SEARCH:
          if (isSearch) {
            ObjectUtils.setHighlightSearchText(holder.folderName, file.getName(), currentFilter);
          } else {
            holder.folderName.setTextColor(FileState.SEARCH.getColor());
          }
          break;
        case NORMAL:
        default:
          if (isSearch) {
            ObjectUtils.setHighlightSearchText(holder.folderName, file.getName(), currentFilter);
          } else {
            holder.folderName.setTextColor(
                MaterialColors.getColor(holder.folderName, ObjectUtils.colorOnSurface));
          }
          break;
      }
    } else {
      if (isSearch) {
        ObjectUtils.setHighlightSearchText(holder.folderName, file.getName(), currentFilter);
      } else {
        holder.folderName.setTextColor(
            MaterialColors.getColor(holder.folderName, ObjectUtils.colorOnSurface));
      }
    }

    if (viewType == ViewType.ROW) {
      holder.cardblur.setCardBackgroundColor(Color.TRANSPARENT);
      holder.cardblur.setRadius(0);
      holder.cardblur.setStrokeWidth(0);
      holder.cardblur.setCardElevation(0);
      holder.cardblur.setBackground(null);
      holder.cardblur.setBackgroundTintList(null);
      holder.cardblur.cancelBlur();
      holder.cardblur.setContentPadding(0, 0, 0, 0);
      holder.roots.setBackground(holder.roots.get(filteredFiles, position));
      holder.cardblur.setClickable(false);
      holder.cardblur.setFocusable(false);

    } else if (viewType == ViewType.GRID) {
      holder.cardblur.setClickable(true);
      holder.cardblur.setFocusable(true);
      String filePath = item.getFilePath();
      if (shouldApplyBlur(filePath)) {
        if (holder.getAdapterPosition() == position)
          holder.cardblur.setBlurFromImageView(holder.icon, filePath);
      } else {
        holder.cardblur.setBackground(null);
        holder.cardblur.cancelBlur();
      }
    }
  }

  public void highlightFile(String path) {
    clearHighlights();

    for (int i = 0; i < allFiles.size(); i++) {
      FileManagerModel item = allFiles.get(i);
      if (item.getFilePath().equals(path)) {
        item.setFilestate(FileState.SELECTBELITEM);
        allFiles.set(i, item);
        break;
      }
    }

    for (int i = 0; i < filteredFiles.size(); i++) {
      if (filteredFiles.get(i).getFilePath().equals(path)) {
        filteredFiles.get(i).setFilestate(FileState.SELECTBELITEM);
        notifyItemChanged(i);
        break;
      }
    }
  }

  public void clearHighlights() {
    for (FileManagerModel item : allFiles) {
      item.setFilestate(FileState.NORMAL);
    }
    for (FileManagerModel item : filteredFiles) {
      item.setFilestate(FileState.NORMAL);
    }
    notifyDataSetChanged();
  }

  public void highlightRename(String path) {
    clearHighlightRename();

    for (int i = 0; i < allFiles.size(); i++) {
      FileManagerModel item = allFiles.get(i);
      if (item.getFilePath().equals(path)) {
        item.setFilestate(FileState.RENAME);
        allFiles.set(i, item);
        break;
      }
    }

    for (int i = 0; i < filteredFiles.size(); i++) {
      if (filteredFiles.get(i).getFilePath().equals(path)) {
        filteredFiles.get(i).setFilestate(FileState.RENAME);
        notifyItemChanged(i);
        break;
      }
    }
  }

  public void clearHighlightRename() {
    for (FileManagerModel item : allFiles) {
      item.setFilestate(FileState.NORMAL);
    }
    for (FileManagerModel item : filteredFiles) {
      item.setFilestate(FileState.NORMAL);
    }
    notifyDataSetChanged();
  }

  public void markNewFile(String path) {
    for (int i = 0; i < allFiles.size(); i++) {
      FileManagerModel item = allFiles.get(i);
      if (item.getFilePath().equals(path)) {
        item.setFilestate(FileState.ADD);
        allFiles.set(i, item);
        break;
      }
    }
    for (int i = 0; i < filteredFiles.size(); i++) {
      if (filteredFiles.get(i).getFilePath().equals(path)) {
        filteredFiles.get(i).setFilestate(FileState.ADD);
        notifyItemChanged(i, "IS_NEW_CHANGED");
        break;
      }
    }
  }

  private void setSettingTextView(TextView tv) {
    if (tv != null) {
      tv.setEllipsize(TextUtils.TruncateAt.MARQUEE);
      tv.setMarqueeRepeatLimit(-1);
      tv.setSelected(true);
      tv.setSingleLine(true);
    }
  }

  @NonNull
  @Override
  public CharSequence getPopupText(int position) {
    if (position < 0 || position >= filteredFiles.size()) {
      return "";
    }
    FileManagerModel item = filteredFiles.get(position);
    File file = new File(item.getFilePath());
    String fileName = file.getName();
    if (fileName.length() > 0) {
      return fileName.substring(0, 1).toUpperCase();
    }
    return "";
  }

  public void setViewType(ViewType viewType) {
    this.viewType = viewType;
    notifyDataSetChanged();
  }

  public void submitList(List<FileManagerModel> list) {
    currentFilter = "";

    if (list == null) {
      allFiles = new ArrayList<>();
      filteredFiles = new ArrayList<>();
    } else {
      allFiles = new ArrayList<>(list);
      filteredFiles = new ArrayList<>(list);
    }

    notifyDataSetChanged();
  }

  public interface onClick {
    void onClick(View view, int pos);

    void onLongClick(View view, int pos);
  }

  public class VH extends RecyclerView.ViewHolder {
    protected TextView folderName, tvTools;
    protected ListItemView roots;
    protected ImageView icon;
    protected BlurMaterialCardView cardblur;

    public VH(View view) {
      super(view);
      folderName = view.findViewById(R.id.folderName);
      tvTools = view.findViewById(R.id.tvTools);
      roots = view.findViewById(R.id.roots);
      icon = view.findViewById(R.id.icon);
      cardblur = view.findViewById(R.id.cardblur);

      roots.setOnClickListener(
          c -> {
            int pos = getBindingAdapterPosition();
            if (pos == RecyclerView.NO_POSITION) return;
            click.onClick(c, pos);
            cardblur.cancelBlur();
          });

      roots.setOnLongClickListener(
          v -> {
            int pos = getBindingAdapterPosition();
            if (pos != RecyclerView.NO_POSITION && pos < filteredFiles.size()) {
              click.onLongClick(v, pos);
            }
            return true;
          });
    }
  }

  @Override
  public int getItemViewType(int position) {
    return viewType.getValue();
  }

  @Override
  public int getItemCount() {
    return filteredFiles.size();
  }

  public FileManagerModel getItem(int position) {
    if (position >= 0 && position < filteredFiles.size()) {
      return filteredFiles.get(position);
    }
    return null;
  }

  public void addNewFile(FileManagerModel newItem) {
    newItem.setFilestate(FileState.ADD);
    allFiles.add(newItem);
    sortList(allFiles);

    if (!currentFilter.isEmpty()) {
      filter(currentFilter);
    } else {
      filteredFiles = new ArrayList<>(allFiles);
      notifyDataSetChanged();
    }
  }

  private void sortList(List<FileManagerModel> list) {
    Collections.sort(
        list,
        (o1, o2) -> {
          String path1 = o1.getFilePath();
          String path2 = o2.getFilePath();
          boolean isDir1 = FileUtil.isDirectory(path1);
          boolean isDir2 = FileUtil.isDirectory(path2);

          if (isDir1 && !isDir2) return -1;
          if (!isDir1 && isDir2) return 1;
          return path1.compareToIgnoreCase(path2);
        });
  }

  public List<FileManagerModel> getCurrentList() {
    if (isFiltered()) {
      return new ArrayList<>(filteredFiles);
    } else {
      return new ArrayList<>(allFiles);
    }
  }

  public List<FileManagerModel> getFilteredList() {
    return new ArrayList<>(filteredFiles);
  }

  public List<FileManagerModel> getAllFilesList() {
    return new ArrayList<>(allFiles);
  }

  public int getOriginalPosition(int filteredPosition) {
    if (!isFiltered()) {
      return filteredPosition;
    }

    if (filteredPosition < 0 || filteredPosition >= filteredFiles.size()) {
      return -1;
    }

    FileManagerModel filteredItem = filteredFiles.get(filteredPosition);
    String filteredPath = filteredItem.getFilePath();

    for (int i = 0; i < allFiles.size(); i++) {
      if (allFiles.get(i).getFilePath().equals(filteredPath)) {
        return i;
      }
    }

    return -1;
  }

  public void updateItem(int position, FileManagerModel newItem) {
    if (position >= 0 && position < allFiles.size()) {
      allFiles.set(position, newItem);
      for (int i = 0; i < filteredFiles.size(); i++) {
        if (filteredFiles.get(i).getFilePath().equals(newItem.getFilePath())) {
          filteredFiles.set(i, newItem);
          notifyItemChanged(i);
          break;
        }
      }
    }
  }

  public void removeItem(int position) {
    if (position >= 0 && position < allFiles.size()) {
      FileManagerModel removedItem = allFiles.get(position);
      String removedPath = removedItem.getFilePath();
      allFiles.remove(position);
      removeFromFilteredByPath(removedPath);
    }
  }

  private boolean shouldApplyBlur(String filePath) {
    if (filePath == null) return false;

    String lowerPath = filePath.toLowerCase();
    return lowerPath.endsWith(".jpg")
        || lowerPath.endsWith(".jpeg")
        || lowerPath.endsWith(".png")
        || lowerPath.endsWith(".webp")
        || lowerPath.endsWith(".mp4");
  }

  public void removeItemByPath(String path) {
    for (int i = 0; i < allFiles.size(); i++) {
      if (allFiles.get(i).getFilePath().equals(path)) {
        allFiles.remove(i);
        break;
      }
    }
    removeFromFilteredByPath(path);
  }

  private void removeFromFilteredByPath(String path) {
    for (int i = 0; i < filteredFiles.size(); i++) {
      if (filteredFiles.get(i).getFilePath().equals(path)) {
        filteredFiles.remove(i);
        notifyItemRemoved(i);
        if (i < filteredFiles.size()) {
          notifyItemRangeChanged(i, filteredFiles.size() - i);
        }
        break;
      }
    }
  }

  public void addFiles(List<FileManagerModel> files) {
    for (FileManagerModel file : files) {
      file.setFilestate(FileState.ADD);
    }
    allFiles.addAll(files);
    sortList(allFiles);

    if (!currentFilter.isEmpty()) {
      filter(currentFilter);
    } else {
      filteredFiles = new ArrayList<>(allFiles);
      notifyDataSetChanged();
    }
  }

  @Override
  public Filter getFilter() {
    return new Filter() {
      @Override
      protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        List<FileManagerModel> filteredList = new ArrayList<>();

        if (constraint == null || constraint.length() == 0) {
          filteredList.addAll(allFiles);
        } else {
          String filterPattern = constraint.toString().toLowerCase().trim();

          for (FileManagerModel item : allFiles) {
            File file = new File(item.getFilePath());
            String fileName = file.getName().toLowerCase();

            if (fileName.contains(filterPattern)) {
              // هنگام جستجو، وضعیت فایل را به SEARCH تغییر دهید
              FileManagerModel filteredItem =
                  new FileManagerModel(item.getFilePath(), FileState.SEARCH);
              filteredList.add(filteredItem);
            }
          }
        }

        results.values = filteredList;
        results.count = filteredList.size();
        return results;
      }

      @Override
      protected void publishResults(CharSequence constraint, FilterResults results) {
        if (results.values != null) {
          filteredFiles = (List<FileManagerModel>) results.values;
        } else {
          filteredFiles = new ArrayList<>();
        }
        currentFilter = constraint != null ? constraint.toString() : "";
        notifyDataSetChanged();
      }
    };
  }

  public void filter(String text) {
    currentFilter = text != null ? text.trim() : "";
    getFilter().filter(currentFilter);
  }

  public void clearFilter() {
    filter("");
  }

  public boolean isFiltered() {
    return !currentFilter.isEmpty();
  }

  public void clearNewMarks() {
    for (FileManagerModel item : allFiles) {
      item.setFilestate(FileState.NORMAL);
    }
    for (FileManagerModel item : filteredFiles) {
      item.setFilestate(FileState.NORMAL);
    }
    notifyDataSetChanged();
  }

  public FileManagerModel getItemByPath(String path) {
    for (FileManagerModel item : allFiles) {
      if (item.getFilePath().equals(path)) {
        return item;
      }
    }
    return null;
  }

  @Override
  public void onViewRecycled(@NonNull VH holder) {
    super.onViewRecycled(holder);
    holder.cardblur.setBackground(null);
    holder.cardblur.cancelBlur();
  }
}
