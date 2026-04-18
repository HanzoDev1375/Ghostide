package ir.ninjacoder.ghostide.core.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.view.LayoutInflater;
import ir.ninjacoder.ghostide.core.activities.FileManagerActivity;
import ir.ninjacoder.ghostide.core.model.dataobject.ShortcutInfoImpl;
import ir.ninjacoder.ghostide.core.pl.PluginLoaderImpl;
import ir.ninjacoder.ghostide.core.editor.PluginCompressorPgb;
import ir.ninjacoder.ghostide.core.editor.PluginextractorFace;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.selection.ItemKeyProvider;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ClipboardUtils;
import com.google.android.material.color.MaterialColors;
import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.BackgroundColorSpan;
import android.util.Log;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.enums.FileConentChange;
import ir.ninjacoder.ghostide.core.marco.ColorView;
import ir.ninjacoder.ghostide.core.marco.FileShareManager;
import ir.ninjacoder.ghostide.core.marco.binder.bindchilder.GhostToast;
import ir.ninjacoder.ghostide.core.marco.binder.bindchilder.RecyclerviewViewHolderBinder;
import ir.ninjacoder.ghostide.core.marco.binder.BlurMaterialCardView;
import ir.ninjacoder.ghostide.core.model.filemanager.FileManagerModel;
import ir.ninjacoder.ghostide.core.model.filemanager.FileState;
import ir.ninjacoder.ghostide.core.mult.MultiSelectionAction;
import ir.ninjacoder.ghostide.core.utils.FileUtil;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;
import ir.ninjacoder.ghostide.core.widget.component.fastscrollcompat.PopupTextProvider;
import ir.ninjacoder.prograsssheet.GTheme;
import ir.ninjacoder.prograsssheet.listchild.Child;
import ir.ninjacoder.prograsssheet.perfence.ListItemView;

public class FileManagerAd extends RecyclerView.Adapter<FileManagerAd.VH>
    implements PopupTextProvider, Filterable {

  private Context context;
  private onClick click;
  private ViewType viewType = ViewType.ROW;
  private List<Child> listChild = new ArrayList<>();
  private List<FileManagerModel> allFiles = new ArrayList<>();
  private List<FileManagerModel> filteredFiles = new ArrayList<>();
  private String currentFilter = "";
  private Map<String, FileConentChange> fileContentStates = new HashMap<>();
  private OnFileOperationStateChangeListener stateChangeListener;

  // SelectionTracker for multi-selection
  private SelectionTracker<Long> selectionTracker;

  public interface OnMultiSelectionListener {
    void onSelectionChanged(int count);

    void onPerformAction(MultiSelectionAction action, List<String> selectedPaths);
  }

  public interface OnFileOperationStateChangeListener {
    void onStateChanged(FileConentChange newState);
  }

  public void setOnFileOperationStateChangeListener(OnFileOperationStateChangeListener listener) {
    this.stateChangeListener = listener;
  }

  public void setSelectionTracker(SelectionTracker<Long> selectionTracker) {
    this.selectionTracker = selectionTracker;
  }

  public SelectionTracker<Long> getSelectionTracker() {
    return selectionTracker;
  }

  public boolean isSelectionActive() {
    return selectionTracker != null && selectionTracker.hasSelection();
  }

  public int getSelectedCount() {
    return selectionTracker != null ? selectionTracker.getSelection().size() : 0;
  }

  public List<String> getSelectedPaths() {
    List<String> paths = new ArrayList<>();
    if (selectionTracker != null && selectionTracker.hasSelection()) {
      for (Long key : selectionTracker.getSelection()) {
        int pos = getPositionForKey(key);
        if (pos >= 0 && pos < filteredFiles.size()) {
          paths.add(filteredFiles.get(pos).getFilePath());
        }
      }
    }
    return paths;
  }

  public void clearSelection() {
    if (selectionTracker != null) {
      selectionTracker.clearSelection();
    }
  }

  public enum SearchMode {
    NORMAL,
    REGEX,
    REGEX_CASE_INSENSITIVE,
    REGEX_MULTILINE,
    REGEX_DOTALL,
    REGEX_UNICODE_CASE
  }

  private SearchMode currentSearchMode = SearchMode.NORMAL;

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
    boolean isSelected = selectionTracker != null && selectionTracker.isSelected((long) position);

    setSettingTextView(holder.folderName);
    if (selectionTracker != null) {
      // holder.iconMoreOptions.setEnabled(isSelected);
      holder.roots.setItemSelect(isSelected);
    }

    File file = new File(item.getFilePath());
    boolean isSearch = !TextUtils.isEmpty(currentFilter);
    holder.folderName.setText(file.getName());

    int allFilesPosition = getOriginalPosition(position);

    if (allFilesPosition >= 0 && allFilesPosition < allFiles.size()) {
      try {
        RecyclerviewViewHolderBinder.bindHolder(
            allFiles,
            holder.folderName,
            holder.tvTools,
            holder.icon,
            viewType,
            allFilesPosition,
            listChild);
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
        case ARCHIVES:
          holder.folderName.setTextColor(FileState.ARCHIVES.getColor());
          break;
        case SEARCH:
          if (isSearch) {
            setHighlightSearchText(
                holder.folderName, file.getName(), currentFilter, currentSearchMode);
          } else {
            holder.folderName.setTextColor(FileState.SEARCH.getColor());
          }
          break;
        case DELETED:
          holder.roots.startDisintegration(position);
          break;
        case NORMAL:
        default:
          if (isSearch) {
            setHighlightSearchText(
                holder.folderName, file.getName(), currentFilter, currentSearchMode);
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
      holder.cardblur.setCardBackgroundColor(null);
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
        if (holder.getAdapterPosition() == position) {
          holder.cardblur.setBlurFromImageView(holder.icon, filePath);
        }
      } else {
        holder.cardblur.setCardBackgroundColor(null);
        holder.cardblur.cancelBlur();
      }
    }
  }

  private int getPositionForKey(Long key) {
    int position = key.intValue();
    if (position >= 0 && position < filteredFiles.size()) {
      return position;
    }
    return RecyclerView.NO_POSITION;
  }

  public void highlightFile(String path, FileState state) {
    clearHighlights();

    for (int i = 0; i < allFiles.size(); i++) {
      FileManagerModel item = allFiles.get(i);
      if (item.getFilePath().equals(path)) {
        item.setFilestate(state);
        allFiles.set(i, item);
        break;
      }
    }

    for (int i = 0; i < filteredFiles.size(); i++) {
      if (filteredFiles.get(i).getFilePath().equals(path)) {
        filteredFiles.get(i).setFilestate(state);
        notifyItemChanged(i);
        break;
      }
    }
  }

  public void highlightFile(String path) {
    highlightFile(path, FileState.SELECTBELITEM);
  }

  public Context getContext() {
    return context;
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

    void onChildFile(int pos);
  }

  // ItemDetails class for SelectionTracker
  public class FileItemDetails extends ItemDetailsLookup.ItemDetails<Long> {
    private final int adapterPosition;
    private final Long selectionKey;

    public FileItemDetails(int adapterPosition, Long selectionKey) {
      this.adapterPosition = adapterPosition;
      this.selectionKey = selectionKey;
    }

    @Override
    public Long getSelectionKey() {
      return selectionKey;
    }

    @Override
    public int getPosition() {
      return adapterPosition;
    }
  }

  public FileItemDetailsLookup getFileItemDetailsLookup(RecyclerView recyclerView) {
    return new FileItemDetailsLookup(recyclerView);
  }

  public class FileItemDetailsLookup extends ItemDetailsLookup<Long> {
    private final RecyclerView recyclerView;

    public FileItemDetailsLookup(RecyclerView recyclerView) {
      this.recyclerView = recyclerView;
    }

    @Override
    public ItemDetails<Long> getItemDetails(MotionEvent e) {
      View view = recyclerView.findChildViewUnder(e.getX(), e.getY());
      if (view != null) {
        RecyclerView.ViewHolder holder = recyclerView.getChildViewHolder(view);
        if (holder instanceof VH) {
          int position = holder.getAdapterPosition();
          if (position != RecyclerView.NO_POSITION && position < filteredFiles.size()) {

            return new FileItemDetails(position, (long) position);
          }
        }
      }
      return null;
    }
  }

  public FileKeyProvider getFileKeyProvider() {
    return new FileKeyProvider();
  }

  // ItemKeyProvider implementation
  public class FileKeyProvider extends ItemKeyProvider<Long> {
    public FileKeyProvider() {
      super(SCOPE_MAPPED);
    }

    @Override
    public Long getKey(int position) {
      return (long) position;
    }

    @Override
    public int getPosition(@NonNull Long key) {
      return getPositionForKey(key);
    }
  }

  public class VH extends RecyclerView.ViewHolder {
    protected TextView folderName, tvTools;
    protected ListItemView roots;
    protected ImageView icon, iconMoreOptions;
    protected BlurMaterialCardView cardblur;

    public VH(View view) {
      super(view);
      folderName = view.findViewById(R.id.folderName);
      tvTools = view.findViewById(R.id.tvTools);
      roots = view.findViewById(R.id.roots);
      icon = view.findViewById(R.id.icon);
      cardblur = view.findViewById(R.id.cardblur);
      iconMoreOptions = view.findViewById(R.id.iconMoreOptions);

      if (click != null) {
        click.onChildFile(getAdapterPosition());
      }

      iconMoreOptions.setOnClickListener(v -> showPopupMenu(v, getAdapterPosition()));
      roots.setOnClickListener(
          v -> {
            int position = getAdapterPosition();
            if (position == RecyclerView.NO_POSITION) return;
            // If selection is active, toggle selection
            if (selectionTracker != null && selectionTracker.hasSelection()) {
              //  String key = getKeyForPosition(position);
              //   selectionTracker.toggleSelection(key);
            } else {
              click.onClick(v, position);
            }
          });
      roots.setOnLongClickListener(
          v -> {
            int position = getAdapterPosition();
            if (position == RecyclerView.NO_POSITION) return true;
            // Start selection mode if not already active
            if (selectionTracker == null || !selectionTracker.hasSelection()) {
              //   String key = getKeyForPosition(position);
              //  selectionTracker.startRangeSelection(position, position);
              click.onLongClick(v, position);
            } else {
              // String key = getKeyForPosition(position);
              // selectionTracker.toggleSelection(key);
              click.onLongClick(v, position);
            }
            return true;
          });
    }

    public ItemDetailsLookup.ItemDetails<Long> getItemDetails() {
      int position = getAdapterPosition();
      if (position == RecyclerView.NO_POSITION || position >= filteredFiles.size()) {
        return null;
      }
      return new FileItemDetails(position, (long) position);
    }
  }

  private void showPopupMenu(View v, int adapterPosition) {
    if (adapterPosition == RecyclerView.NO_POSITION || adapterPosition >= filteredFiles.size())
      return;

    String filePath = filteredFiles.get(adapterPosition).getFilePath();

    var menu =
        new PowerMenu.Builder(v.getContext())
            .setIsMaterial(true)
            .addItem(new PowerMenuItem("Copy name dir or file"))
            .addItem(new PowerMenuItem("Copy"))
            .addItem(new PowerMenuItem("Move"))
            .addItem(new PowerMenuItem("Rename"))
            .addItem(new PowerMenuItem("Removed"))
            .addItem(new PowerMenuItem("Share"))
            .addItem(new PowerMenuItem("Zip"))
            .addItem(new PowerMenuItem("Shortcut"))
            .addItem(new PowerMenuItem("Add to Bookmark"))
            .addItem(new PowerMenuItem("Add to Pgb"))
            .addItem(new PowerMenuItem("JavaRename"))
            .addItem(new PowerMenuItem("Backup theme"))
            .build();

    menu.setShowBackground(false);
    menu.setAnimation(MenuAnimation.FADE);
    menu.setMenuRadius(19f);
    menu.setTextColor(MaterialColors.getColor(v.getContext(), ObjectUtils.colorOnSurface, 0));
    menu.setMenuColor(MaterialColors.getColor(v.getContext(), ObjectUtils.colorSurface, 0));

    menu.setOnMenuItemClickListener(
        (pos, vm) -> {
          if (pos == 0) {
            ClipboardUtils.copyText(filePath);
            GhostToast.showSuccess(context, "Copying path in -> " + filePath);
            menu.dismiss();
          } else if (pos == 1) {
            fileContentStates.put(filePath, FileConentChange.COPYING);
            notifyItemChanged(adapterPosition);
            if (stateChangeListener != null) {
              stateChangeListener.onStateChanged(FileConentChange.COPYING);
            }
            menu.dismiss();
          } else if (pos == 2) {
            fileContentStates.put(filePath, FileConentChange.MOVEING);
            notifyItemChanged(adapterPosition);
            if (stateChangeListener != null) {
              stateChangeListener.onStateChanged(FileConentChange.MOVEING);
            }
            menu.dismiss();
          } else if (pos == 3) {
            ((FileManagerActivity) context).setRenameFile(adapterPosition);
            menu.dismiss();
          } else if (pos == 4) {
            ((FileManagerActivity) context).removedFiles(adapterPosition);
            menu.dismiss();
          } else if (pos == 5) {
            var fileShareManager = new FileShareManager(context);
            File file = new File(filteredFiles.get(adapterPosition).getFilePath());
            try {
              if (file.isFile()) fileShareManager.shareFile(file);
            } catch (Exception e) {
              e.printStackTrace();
            }
            menu.dismiss();
          } else if (pos == 6) {
            ((FileManagerActivity) context).MakeZipFileFromThreads(adapterPosition);
            menu.dismiss();
          } else if (pos == 7) {
            ShortcutInfoImpl impl =
                new ShortcutInfoImpl(context, filteredFiles.get(adapterPosition).getFilePath());
            impl.createFileShortcut(0, filteredFiles.get(adapterPosition).getFilePath(), () -> {});
            menu.dismiss();
          } else if (pos == 8) {
            ((FileManagerActivity) context).bookmark(adapterPosition);
            menu.dismiss();
          } else if (pos == 9) {
            pgbmaker(adapterPosition);
            menu.dismiss();
          } else if (pos == 10) {
            ColorView.renameJavaFileImpl(
                context,
                filteredFiles.get(adapterPosition).getFilePath(),
                ((FileManagerActivity) context).getFolder(),
                () -> {
                  ((FileManagerActivity) context).reLoadFile();
                });
          } else if (pos == 11) {
            var path = filteredFiles.get(adapterPosition).getFilePath();
            if (FileUtil.isDirectory(path)) {
              GTheme.pack(
                  path,
                  ((FileManagerActivity) context).getFolder() + "/",
                  context,
                  () -> {
                    ((FileManagerActivity) context).reLoadFile();
                  });
            }
          }
        });

    menu.showAsDropDown(v);
  }

  void pgbmaker(int pos) {
    String currentPgbPath = filteredFiles.get(pos).getFilePath();
    if (FileUtil.isExistFile(PluginLoaderImpl.DEFAULT_CONFIG_PATH)) {
      var plugin =
          new PluginCompressorPgb(
              new PluginextractorFace() {
                @Override
                public void onPluginExtractorDone() {
                  ((FileManagerActivity) context).reLoadFile();
                }

                @Override
                public void onPluginExtractorError() {}
              },
              context,
              currentPgbPath);
    } else {
      GhostToast.showError(context, "File -> config.json not found");
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
      removedItem.setFilestate(FileState.DELETED);
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
      var model = filteredFiles.get(i);
      if (model.getFilePath().equals(path)) {
        model.setFilestate(FileState.DELETED);
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

  public void setSearchMode(SearchMode mode) {
    this.currentSearchMode = mode;
    if (!TextUtils.isEmpty(currentFilter)) {
      filter(currentFilter);
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
          String filterPattern = constraint.toString();

          for (FileManagerModel item : allFiles) {
            File file = new File(item.getFilePath());
            String fileName = file.getName();
            boolean match = false;

            switch (currentSearchMode) {
              case REGEX:
                try {
                  Pattern pattern = Pattern.compile(filterPattern);
                  match = pattern.matcher(fileName).find();
                } catch (PatternSyntaxException e) {
                  match = false;
                }
                break;

              case REGEX_CASE_INSENSITIVE:
                try {
                  Pattern pattern = Pattern.compile(filterPattern, Pattern.CASE_INSENSITIVE);
                  match = pattern.matcher(fileName).find();
                } catch (PatternSyntaxException e) {
                  match = false;
                }
                break;

              case REGEX_MULTILINE:
                try {
                  Pattern pattern = Pattern.compile(filterPattern, Pattern.MULTILINE);
                  match = pattern.matcher(fileName).find();
                } catch (PatternSyntaxException e) {
                  match = false;
                }
                break;

              case REGEX_DOTALL:
                try {
                  Pattern pattern = Pattern.compile(filterPattern, Pattern.DOTALL);
                  match = pattern.matcher(fileName).find();
                } catch (PatternSyntaxException e) {
                  match = false;
                }
                break;

              case REGEX_UNICODE_CASE:
                try {
                  Pattern pattern = Pattern.compile(filterPattern, Pattern.UNICODE_CASE);
                  match = pattern.matcher(fileName).find();
                } catch (PatternSyntaxException e) {
                  match = false;
                }
                break;

              case NORMAL:
              default:
                match = fileName.toLowerCase().contains(filterPattern.toLowerCase());
                break;
            }

            if (match) {
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

  public SearchMode getCurrentSearchMode() {
    return currentSearchMode;
  }

  private void setHighlightSearchText(
      TextView textView, String fullText, String searchText, SearchMode searchMode) {
    if (searchText == null || searchText.isEmpty()) {
      textView.setText(fullText);
      return;
    }

    SpannableString spannableString = new SpannableString(fullText);

    if (searchMode == SearchMode.NORMAL) {
      String lowerFullText = fullText.toLowerCase();
      String lowerSearchText = searchText.toLowerCase();

      int startPos = 0;
      while ((startPos = lowerFullText.indexOf(lowerSearchText, startPos)) != -1) {
        int endPos = startPos + searchText.length();
        applyHighlight(spannableString, startPos, endPos);
        startPos = endPos;
      }
    } else {
      try {
        Pattern pattern = createPattern(searchText, searchMode);
        Matcher matcher = pattern.matcher(fullText);

        while (matcher.find()) {
          int startPos = matcher.start();
          int endPos = matcher.end();
          applyHighlight(spannableString, startPos, endPos);
        }
      } catch (PatternSyntaxException e) {
        Log.e("FileManagerAd", "Regex error: " + e.getMessage());
      }
    }

    textView.setText(spannableString);
  }

  private void applyHighlight(SpannableString spannableString, int start, int end) {
    spannableString.setSpan(
        new ForegroundColorSpan(Color.BLACK), start, end, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
    spannableString.setSpan(
        new BackgroundColorSpan(Color.parseColor("#FFFFE0B2")),
        start,
        end,
        SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
  }

  private Pattern createPattern(String searchText, SearchMode searchMode) {
    switch (searchMode) {
      case REGEX_CASE_INSENSITIVE:
        return Pattern.compile(searchText, Pattern.CASE_INSENSITIVE);
      case REGEX_MULTILINE:
        return Pattern.compile(searchText, Pattern.MULTILINE);
      case REGEX_DOTALL:
        return Pattern.compile(searchText, Pattern.DOTALL);
      case REGEX_UNICODE_CASE:
        return Pattern.compile(searchText, Pattern.UNICODE_CASE);
      case REGEX:
      default:
        return Pattern.compile(searchText);
    }
  }

  public FileConentChange getFileContentState(String filePath) {
    return fileContentStates.getOrDefault(filePath, FileConentChange.NONE);
  }

  public void setFileContentState(String filePath, FileConentChange state) {
    fileContentStates.put(filePath, state);
    for (int i = 0; i < filteredFiles.size(); i++) {
      if (filteredFiles.get(i).getFilePath().equals(filePath)) {
        notifyItemChanged(i);
        break;
      }
    }
  }

  public void clearFileContentState(String filePath) {
    fileContentStates.remove(filePath);
    for (int i = 0; i < filteredFiles.size(); i++) {
      if (filteredFiles.get(i).getFilePath().equals(filePath)) {
        notifyItemChanged(i);
        break;
      }
    }
  }

  public Map<String, FileConentChange> getFileContentStatesMap() {
    return this.fileContentStates;
  }
}
