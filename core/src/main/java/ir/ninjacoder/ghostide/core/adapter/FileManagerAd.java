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
import ir.ninjacoder.ghostide.core.marco.binder.bindchilder.RecyclerviewViewHolderBinder;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.utils.FileUtil;
import ir.ninjacoder.prograsssheet.listchild.Child;
import ir.ninjacoder.prograsssheet.perfence.ListItemView;
import ir.ninjacoder.ghostide.core.widget.component.fastscrollcompat.PopupTextProvider;

public class FileManagerAd extends RecyclerView.Adapter<FileManagerAd.VH>
    implements PopupTextProvider, Filterable {

  private Context context;
  private onClick click;
  private ViewType viewType = ViewType.ROW;
  private List<Child> listChild = new ArrayList<>();
  private List<HashMap<String, Object>> allFiles = new ArrayList<>();
  private List<HashMap<String, Object>> filteredFiles = new ArrayList<>();
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
      HashMap<String, Object> item = getItem(position);
    } else {
      bind(holder, position);
    }
  }

  private void bind(VH holder, int position) {
    if (position < 0 || position >= filteredFiles.size()) {
      Log.e("FileManagerAd", "Invalid position in bind: " + position);
      return;
    }
    HashMap<String, Object> item = filteredFiles.get(position);
    if (item == null) {
      return;
    }

    setSettingTextView(holder.folderName);

    File file = new File(item.get("path").toString());
    boolean isSearch = !TextUtils.isEmpty(currentFilter);
    holder.folderName.setText(file.getName());
    int allFilesPosition = getOriginalPosition(position);
    boolean isNew = item.containsKey("isNew") && (boolean) item.get("isNew");
    boolean isHighlighted =
        item.containsKey("isHighlighted") && (boolean) item.get("isHighlighted");
    if (allFilesPosition >= 0 && allFilesPosition < allFiles.size()) {
      try {
        RecyclerviewViewHolderBinder.bindHolder(
            allFiles,
            allFilesPosition,
            holder.folderName,
            holder.tvTools,
            holder.icon,
            viewType,
            isSearch,
            isNew);
      } catch (Exception e) {
        Log.e("FileManagerAd", "Error in binder: " + e.getMessage());
      }
    }

    holder.itemView.setClickable(true);
    if (isHighlighted) {
      holder.folderName.setTextColor(Color.parseColor("#2196F3"));
    } else if (isSearch) {
      ObjectUtils.setHighlightSearchText(holder.folderName, file.getName(), currentFilter);
    } else if (isNew) {
      holder.folderName.setTextColor(Color.parseColor("#4CAF50"));
    }
  }

  public void highlightFile(String path) {
    clearHighlights();

    for (int i = 0; i < allFiles.size(); i++) {
      HashMap<String, Object> item = allFiles.get(i);
      if (item.get("path").toString().equals(path)) {
        item.put("isHighlighted", true);
        allFiles.set(i, item);
        break;
      }
    }

    for (int i = 0; i < filteredFiles.size(); i++) {
      if (filteredFiles.get(i).get("path").toString().equals(path)) {
        filteredFiles.get(i).put("isHighlighted", true);
        notifyItemChanged(i);
        break;
      }
    }
  }

  public void clearHighlights() {
    for (HashMap<String, Object> item : allFiles) {
      item.remove("isHighlighted");
    }
    for (HashMap<String, Object> item : filteredFiles) {
      item.remove("isHighlighted");
    }
    notifyDataSetChanged();
  }

  public void markNewFile(String path) {
    for (int i = 0; i < allFiles.size(); i++) {
      HashMap<String, Object> item = allFiles.get(i);
      if (item.get("path").toString().equals(path)) {
        item.put("isNew", true);
        allFiles.set(i, item);
        break;
      }
    }
    for (int i = 0; i < filteredFiles.size(); i++) {
      if (filteredFiles.get(i).get("path").toString().equals(path)) {
        filteredFiles.get(i).put("isNew", true);
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
    HashMap<String, Object> item = filteredFiles.get(position);
    File file = new File(item.get("path").toString());
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

  public void submitList(List<HashMap<String, Object>> list) {
    if (list == null) {
      allFiles = new ArrayList<>();
    } else {
      allFiles = new ArrayList<>(list);
      sortList(allFiles);
    }

    if (!currentFilter.isEmpty()) {
      filter(currentFilter);
    } else {
      filteredFiles = new ArrayList<>(allFiles);
      notifyDataSetChanged();
    }
  }

  public interface onClick {
    void onClick(View view, int pos);

    void onLongClick(View view, int pos);
  }

  public class VH extends RecyclerView.ViewHolder {
    protected TextView folderName, tvTools;
    protected ListItemView roots;
    protected ImageView icon;

    public VH(View view) {
      super(view);
      folderName = view.findViewById(R.id.folderName);
      tvTools = view.findViewById(R.id.tvTools);
      roots = view.findViewById(R.id.roots);
      icon = view.findViewById(R.id.icon);

      roots.setOnClickListener(
          c -> {
            int pos = getBindingAdapterPosition();
            if (pos != RecyclerView.NO_POSITION && pos < filteredFiles.size()) {
              click.onClick(c, pos);
            }
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

  public HashMap<String, Object> getItem(int position) {
    if (position >= 0 && position < filteredFiles.size()) {
      return filteredFiles.get(position);
    }
    return null;
  }

  public void addNewFile(HashMap<String, Object> newItem) {
    allFiles.add(newItem);
    sortList(allFiles);

    if (!currentFilter.isEmpty()) {
      filter(currentFilter);
    } else {
      filteredFiles = new ArrayList<>(allFiles);
      notifyDataSetChanged();
      markNewFile(newItem.get("path").toString());
    }
  }

  private void sortList(List<HashMap<String, Object>> list) {
    Collections.sort(
        list,
        (o1, o2) -> {
          String path1 = o1.get("path").toString();
          String path2 = o2.get("path").toString();
          boolean isDir1 = FileUtil.isDirectory(path1);
          boolean isDir2 = FileUtil.isDirectory(path2);

          if (isDir1 && !isDir2) return -1;
          if (!isDir1 && isDir2) return 1;
          return path1.compareToIgnoreCase(path2);
        });
  }

  public List<HashMap<String, Object>> getCurrentList() {
    if (isFiltered()) {
      return new ArrayList<>(filteredFiles);
    } else {
      return new ArrayList<>(allFiles);
    }
  }

  public List<HashMap<String, Object>> getFilteredList() {
    return new ArrayList<>(filteredFiles);
  }

  public List<HashMap<String, Object>> getAllFilesList() {
    return new ArrayList<>(allFiles);
  }

  public int getOriginalPosition(int filteredPosition) {
    if (!isFiltered()) {

      return filteredPosition;
    }

    if (filteredPosition < 0 || filteredPosition >= filteredFiles.size()) {
      return -1;
    }

    HashMap<String, Object> filteredItem = filteredFiles.get(filteredPosition);
    String filteredPath = filteredItem.get("path").toString();

    for (int i = 0; i < allFiles.size(); i++) {
      if (allFiles.get(i).get("path").toString().equals(filteredPath)) {
        return i;
      }
    }

    return -1;
  }

  public void updateItem(int position, HashMap<String, Object> newItem) {
    if (position >= 0 && position < allFiles.size()) {
      allFiles.set(position, newItem);
      for (int i = 0; i < filteredFiles.size(); i++) {
        if (filteredFiles.get(i).get("path").equals(newItem.get("path"))) {
          filteredFiles.set(i, newItem);
          notifyItemChanged(i);
          break;
        }
      }
    }
  }

  public void removeItem(int position) {
    if (position >= 0 && position < allFiles.size()) {
      HashMap<String, Object> removedItem = allFiles.get(position);
      String removedPath = removedItem.get("path").toString();
      allFiles.remove(position);
      removeFromFilteredByPath(removedPath);
    }
  }

  public void removeItemByPath(String path) {
    for (int i = 0; i < allFiles.size(); i++) {
      if (allFiles.get(i).get("path").toString().equals(path)) {
        allFiles.remove(i);
        break;
      }
    }
    removeFromFilteredByPath(path);
  }

  private void removeFromFilteredByPath(String path) {
    for (int i = 0; i < filteredFiles.size(); i++) {
      if (filteredFiles.get(i).get("path").toString().equals(path)) {
        filteredFiles.remove(i);
        notifyItemRemoved(i);
        if (i < filteredFiles.size()) {
          notifyItemRangeChanged(i, filteredFiles.size() - i);
        }
        break;
      }
    }
  }

  public void addFiles(List<HashMap<String, Object>> files) {
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
        List<HashMap<String, Object>> filteredList = new ArrayList<>();

        if (constraint == null || constraint.length() == 0) {
          filteredList.addAll(allFiles);
        } else {
          String filterPattern = constraint.toString().toLowerCase().trim();

          for (HashMap<String, Object> item : allFiles) {
            String path = item.get("path").toString();
            File file = new File(path);
            String fileName = file.getName().toLowerCase();

            if (fileName.contains(filterPattern)) {
              filteredList.add(item);
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
          filteredFiles = (List<HashMap<String, Object>>) results.values;
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
    for (HashMap<String, Object> item : allFiles) {
      item.remove("isNew");
    }
    for (HashMap<String, Object> item : filteredFiles) {
      item.remove("isNew");
    }
    notifyDataSetChanged();
  }
}
