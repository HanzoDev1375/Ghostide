package ir.ninjacoder.prograsssheet.filemanagerwindows;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.selection.ItemKeyProvider;
import androidx.recyclerview.selection.SelectionTracker;
import ir.ninjacoder.prograsssheet.R;
import ir.ninjacoder.prograsssheet.perfence.ListItemViewCard;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileModelAdapter extends RecyclerView.Adapter<FileModelAdapter.VH> {

  private List<FileModel> fileModel;
  private List<FileModel> fileModelOriginal;
  private FileHandlerModel event;
  private String currentQuery = "";

  private SelectionTracker<Long> selectionTracker;
  private SelectionListener selectionListener;

  public interface SelectionListener {
    void onSelectionChanged(int count);
  }

  public FileModelAdapter(List<FileModel> fileModel, FileHandlerModel event) {
    this.fileModel = fileModel;
    this.fileModelOriginal = new ArrayList<>(fileModel);
    this.event = event;
  }

  public void setSelectionTracker(SelectionTracker<Long> tracker) {
    this.selectionTracker = tracker;
    if (selectionTracker != null) {
      selectionTracker.addObserver(
          new SelectionTracker.SelectionObserver<Long>() {
            @Override
            public void onSelectionChanged() {
              super.onSelectionChanged();
              if (selectionListener != null) {
                selectionListener.onSelectionChanged(selectionTracker.getSelection().size());
              }
            }
          });
    }
  }

  public void setSelectionListener(SelectionListener listener) {
    this.selectionListener = listener;
  }

  @Override
  public VH onCreateViewHolder(ViewGroup parent, int viewType) {
    return new VH(
        LayoutInflater.from(parent.getContext())
            .inflate(R.layout.popup_filemodel_layout, parent, false));
  }

  @Override
  public void onBindViewHolder(VH holder, int pos) {
    var state = fileModel.get(pos);
    holder.bind(state, currentQuery);
  }

  @Override
  public int getItemCount() {
    return fileModel.size();
  }

  public List<FileModel> getSelectedFiles() {
    List<FileModel> selected = new ArrayList<>();
    if (selectionTracker != null) {
      for (Long id : selectionTracker.getSelection()) {
        int pos = id.intValue();
        if (pos >= 0 && pos < fileModel.size()) {
          selected.add(fileModel.get(pos));
        }
      }
    }
    return selected;
  }

  public void clearSelection() {
    if (selectionTracker != null) {
      selectionTracker.clearSelection();
    }
  }

  public void filter(String query) {
    this.currentQuery = query.toLowerCase();
    List<FileModel> filteredList = new ArrayList<>();
    if (query.isEmpty()) {
      filteredList.addAll(fileModelOriginal);
    } else {
      for (FileModel model : fileModelOriginal) {
        if (model.getPath().toLowerCase().contains(currentQuery)) {
          filteredList.add(model);
        }
      }
    }
    fileModel.clear();
    fileModel.addAll(filteredList);
    notifyDataSetChanged();
  }

  public void submitList(List<FileModel> list) {
    if (list == null) {
      list = new ArrayList<>();
    }
    this.fileModelOriginal = new ArrayList<>(list);
    this.fileModel = new ArrayList<>(list);
    if (!currentQuery.isEmpty()) {
      filter(currentQuery);
    } else {
      notifyDataSetChanged();
    }
  }

  public void add(FileModel model) {
    if (fileModel != null) {
      fileModel.add(model);
      fileModelOriginal.add(model);
      notifyItemInserted(fileModel.size() - 1);
    }
  }

  public void removeItem(FileModel item) {
    if (fileModel != null) {
      int position = fileModel.indexOf(item);
      if (position != -1) {
        fileModel.remove(position);
        fileModelOriginal.remove(item);
        notifyItemRemoved(position);
      }
    }
  }

  class VH extends RecyclerView.ViewHolder {
    private TextView textresult;
    private ImageView icon;
    private ListItemViewCard cardroot;

    public VH(View v) {
      super(v);
      textresult = v.findViewById(R.id.textresult);
      icon = v.findViewById(R.id.icon);
      cardroot = v.findViewById(R.id.cardroot);
    }

    ItemDetailsLookup.ItemDetails<Long> getItemDetails() {
      return new ItemDetailsLookup.ItemDetails<Long>() {
        @Override
        public int getPosition() {
          return getAdapterPosition();
        }

        @Nullable
        @Override
        public Long getSelectionKey() {
          return (long) getAdapterPosition();
        }
      };
    }

    void bind(FileModel file, String query) {
      File files = new File(file.getPath());
      String fileName = files.getName();

      if (query != null && !query.isEmpty()) {
        String fileNameLower = fileName.toLowerCase();
        int startIndex = fileNameLower.indexOf(query);
        if (startIndex != -1) {
          int endIndex = startIndex + query.length();
          SpannableString spannableString = new SpannableString(fileName);
          spannableString.setSpan(
              new BackgroundColorSpan(Color.parseColor("#FFFFE0B2")),
              startIndex,
              endIndex,
              Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
          spannableString.setSpan(
              new ForegroundColorSpan(Color.BLACK),
              startIndex,
              endIndex,
              Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
          textresult.setText(spannableString);
        } else {
          textresult.setText(fileName);
        }
      } else {
        textresult.setText(fileName);
      }

      boolean isSelected =
          selectionTracker != null && selectionTracker.isSelected((long) getAdapterPosition());
      cardroot.setSelectItem(isSelected, fileModel, getAdapterPosition());
      cardroot.setBackground(cardroot.getListBackground(fileModel, getAdapterPosition(), cardroot));

      itemView.setOnClickListener(
          v -> {
            int pos = getAdapterPosition();
            if (pos != RecyclerView.NO_POSITION) {
              if (selectionTracker != null && selectionTracker.hasSelection()) {
                Log.d("TAG", "SelectSize = " + selectionTracker.getSelection().size());
              } else {
                event.onFileClickHanlder(pos, file, v);
              }
            }
          });

      if (event != null) {
        event.onFileIconBind(file, icon);
      }
    }
  }

  public static class MyItemDetailsLookup extends ItemDetailsLookup<Long> {
    private final RecyclerView recyclerView;

    public MyItemDetailsLookup(RecyclerView recyclerView) {
      this.recyclerView = recyclerView;
    }

    @Nullable
    @Override
    public ItemDetails<Long> getItemDetails(@NonNull MotionEvent e) {
      View view = recyclerView.findChildViewUnder(e.getX(), e.getY());
      if (view != null) {
        RecyclerView.ViewHolder holder = recyclerView.getChildViewHolder(view);
        if (holder instanceof FileModelAdapter.VH) {
          return ((FileModelAdapter.VH) holder).getItemDetails();
        }
      }
      return null;
    }
  }

  public static class MyItemKeyProvider extends ItemKeyProvider<Long> {
    public MyItemKeyProvider(RecyclerView recyclerView) {
      super(SCOPE_MAPPED);
    }

    @Nullable
    @Override
    public Long getKey(int position) {
      return (long) position;
    }

    @Override
    public int getPosition(@NonNull Long key) {
      return key.intValue();
    }
  }
}
