package ir.ninjacoder.ghostide.core.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ir.ninjacoder.ghostide.core.marco.binder.bindchilder.RecyclerviewViewHolderBinder;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.folder.FileHelper;
import ir.ninjacoder.ghostide.core.utils.AnimUtils;
import ir.ninjacoder.ghostide.core.utils.FileUtil;
import ir.ninjacoder.ghostide.core.utils.MFileClass;
import ir.ninjacoder.ghostide.core.widget.component.fastscrollcompat.PopupTextProvider;
import ir.ninjacoder.prograsssheet.listchild.Child;
import ir.ninjacoder.prograsssheet.perfence.ListItemView;

// fileListItem
public class FileManagerAd extends RecyclerView.Adapter<FileManagerAd.VH>
    implements PopupTextProvider {
  protected Context context;
  protected onClick click;
  private String newlyCreatedPath = null;
  protected ViewType viewType = ViewType.ROW;
  private List<HashMap<String, Object>> files = new ArrayList<>();
  private SharedPreferences prf;
  private VH viewHolder;
  private List<Child> listChild = new ArrayList<>();

  public FileManagerAd(
      List<HashMap<String, Object>> files, Context context, onClick click, List<Child> listChild) {
    this.context = context;
    this.files = files;
    this.click = click;
    this.listChild = listChild;
    prf = context.getSharedPreferences("iconpath", Context.MODE_PRIVATE);
  }

  @Override
  public int getItemCount() {
    return files.size();
  }

  @Override
  public VH onCreateViewHolder(ViewGroup parnt, int viewt) {
    View view = null;
    switch (viewType) {
      case ROW:
        {
          view =
              LayoutInflater.from(parnt.getContext())
                  .inflate(R.layout.folder_remster, parnt, false);
          break;
        }
      case GRID:
        {
          view =
              LayoutInflater.from(parnt.getContext())
                  .inflate(R.layout.folder_layout_grid, parnt, false);
          break;
        }
      default:
        view =
            LayoutInflater.from(parnt.getContext()).inflate(R.layout.folder_remster, parnt, false);
    }
    viewHolder = new VH(view);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(VH viewHolder, int pos) {}

  @Override
  public void onBindViewHolder(VH viewHolder, int pos, List<Object> payloads) {
    View view = viewHolder.itemView;
    setSettingTextView(viewHolder.folderName);
    var myfile = new File(files.get(pos).get("path").toString());
    Log.e("FileManagerAd", files.get(pos).get("path").toString());

    String currentPath;
    try {
      currentPath = myfile.getCanonicalPath();
    } catch (Exception e) {
      currentPath = myfile.getAbsolutePath();
    }
    if (!payloads.isEmpty() && payloads.contains("NEW_FILE")) {
      viewHolder.folderName.setTextColor(Color.parseColor("#4CAF50"));
      return;
    }
    RecyclerviewViewHolderBinder.bindHolder(
        files, pos, viewHolder.folderName, viewHolder.tvTools, viewHolder.icon, viewType);
    if (viewType == ViewType.ROW) viewHolder.roots.setBackground(viewHolder.roots.get(files, pos));
    viewHolder.itemView.setClickable(true);
  }

  @NonNull
  public HashMap<String, Object> getItem(int position) {
    return files.get(position);
  }

  @Override
  public long getItemId(int position) {
    HashMap<String, Object> mmap = getItem(position);
    return Objects.hash(mmap);
  }

  @Override
  @NonNull
  public CharSequence getPopupText(int position) {
    HashMap<String, Object> map = getItem(position);
    File file = new File(map.get("path").toString());
    return file.getName().substring(0, 1).toUpperCase();
  }

  void setSettingTextView(TextView tv) {
    if (tv != null) {
      tv.setEllipsize(TextUtils.TruncateAt.MARQUEE);
      tv.setMarqueeRepeatLimit(-1);
      tv.setSelected(true);
      tv.setSingleLine(true);
    }
  }

  public void addItem(int Position) {
    notifyItemInserted(Position);
  }

  public void markNewFile(String path) {
    try {
      this.newlyCreatedPath = new File(path).getCanonicalPath();

      for (int i = 0; i < files.size(); i++) {
        File f = new File(files.get(i).get("path").toString());
        if (f.getCanonicalPath().equals(newlyCreatedPath)) {
          notifyItemChanged(i, "NEW_FILE");
          break;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void removedItem(int pos) {
    files.remove(pos);
    notifyItemRemoved(pos);
  }

  public interface onClick {
    public void onClick(View view, int pos);

    public void onLongClick(View view, int pos);
  }

  public class VH extends RecyclerView.ViewHolder {
    protected TextView folderName, tvTools;
    protected ListItemView roots;
    protected ImageView icon;
    View getPos;

    public VH(View view) {
      super(view);
      getPos = view;
      folderName = view.findViewById(R.id.folderName);
      tvTools = view.findViewById(R.id.tvTools);
      roots = view.findViewById(R.id.roots);
      icon = view.findViewById(R.id.icon);

      roots.setOnClickListener(
          c -> {
            click.onClick(c, getBindingAdapterPosition());
            AnimUtils.ClickAnimation(itemView);
          });

      roots.setOnLongClickListener(
          v -> {
            click.onLongClick(v, getBindingAdapterPosition());
            return true;
          });
    }

    public TextView getFolderName() {
      return this.folderName;
    }

    public TextView getTvTools() {
      return this.tvTools;
    }

    public ListItemView getRoots() {
      return this.roots;
    }

    public ImageView getIcon() {
      return this.icon;
    }
  }

  @Override
  public int getItemViewType(int pos) {
    return viewType.getValue();
  }

  public void setViewType(ViewType viewType) {
    this.viewType = viewType;
    notifyDataSetChanged();
  }

  public VH getViewHolder() {
    return this.viewHolder;
  }
}
