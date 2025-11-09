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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.color.MaterialColors;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.adapter.ViewType;
import ir.ninjacoder.ghostide.core.databin.FileMaker;
import ir.ninjacoder.ghostide.core.folder.FileHelper;
import ir.ninjacoder.ghostide.core.folder.FileIconHelper;
import ir.ninjacoder.ghostide.core.folder.FileIconHelperPath;
import ir.ninjacoder.ghostide.core.git.JgitHelper;
import ir.ninjacoder.ghostide.core.glidecompat.GlideCompat;
import ir.ninjacoder.ghostide.core.interfaces.FileCallBack;
import ir.ninjacoder.ghostide.core.marco.FileCounter;
import ir.ninjacoder.ghostide.core.marco.binder.BinderRecyclerview1;
import ir.ninjacoder.ghostide.core.marco.binder.ThemeChkerErrorBinder;
import ir.ninjacoder.ghostide.core.utils.AnimUtils;
import ir.ninjacoder.ghostide.core.utils.FileUtil;
import ir.ninjacoder.ghostide.core.utils.MFileClass;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;
import ir.ninjacoder.ghostide.core.widget.component.fastscrollcompat.PopupTextProvider;
import ir.ninjacoder.prograsssheet.perfence.ListItemView;

// fileListItem
public class FileManagerAd extends RecyclerView.Adapter<FileManagerAd.VH>
    implements PopupTextProvider {
  public static boolean Files = false;
  public static boolean Folder = false;
  protected Context context;
  protected onClick click;
  protected ViewType viewType = ViewType.ROW;
  protected HashMap<String, Object> name = new HashMap<>();
  private List<HashMap<String, Object>> files = new ArrayList<>();
  protected GridLayoutManager g;
  private SharedPreferences prf;
  private boolean isSelectionMode = false;

  public FileManagerAd(List<HashMap<String, Object>> files, Context context, onClick click) {
    this.context = context;
    this.files = files;
    this.click = click;
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
    return new VH(view);
  }

  @Override
  public void onBindViewHolder(VH viewHolder, int pos) {
    View view = viewHolder.itemView;
    AnimUtils.Sacla(viewHolder.itemView);
    setSettingTextView(viewHolder.folderName);
    var myfile = new File(files.get(pos).get("path").toString());
    viewHolder.folderName.setTextColor(
        MaterialColors.getColor(viewHolder.folderName, ObjectUtils.colorOnSurface, 0));
    viewHolder.tvTools.setTextColor(
        MaterialColors.getColor(viewHolder.tvTools, ObjectUtils.colorOnSurface, 0));
    if (FileUtil.isDirectory(myfile.toString())) {
      if (viewType == ViewType.ROW) {
        viewHolder.icon.setPadding(8, 8, 8, 8);
        ObjectUtils.shp(viewHolder.icon);
      }
      FileCounter mfileC = new FileCounter(viewHolder.tvTools);
      mfileC.execute(myfile.toString());
    } else {
      getTime(myfile.toString(), viewHolder.tvTools);
      viewHolder.icon.setBackgroundColor(0);
      viewHolder.icon.setPadding(0, 0, 0, 0);
    }
    viewHolder.folderName.setText(myfile.getName());

    if (FileUtil.isExistFile(FileIconHelperPath.ICON_PATH + "/ic_material_folder.png")) {

      FileIconHelperPath fileIconPath = new FileIconHelperPath(myfile.toString());
      fileIconPath.bind(viewHolder.icon);

      if (BinderRecyclerview1.TaskVideo(myfile.toString())) {
        GlideCompat.GlideNormal(viewHolder.icon, myfile.toString());
      } else if (BinderRecyclerview1.PhotoView(myfile.toString())) {
        GlideCompat.GlideNormal(viewHolder.icon, myfile.toString());
      }

      if (myfile.toString().endsWith(".xml")) {
        GlideCompat.LoadVector(myfile.toString(), viewHolder.icon);

      } else if (myfile.toString().endsWith(".svg")) {
        GlideCompat.LoadSvg(myfile.toString(), viewHolder.icon);
      } else if (myfile.toString().endsWith(".apk")) {
        GlideCompat.LoadApkFile(myfile.toString(), viewHolder.icon);
      } else if (myfile.toString().endsWith(".AA")) {
        GlideCompat.LoadIconTheme(myfile.toString(), viewHolder.icon);
      } else if (myfile.toString().endsWith(".mp3")) {
        GlideCompat.GlideLoadMp3(viewHolder.icon, myfile.toString());
      } else if (myfile.toString().endsWith(".pdf")) {
        GlideCompat.loadImgPdf(myfile.toString(), viewHolder.icon);
      }

    } else {
      FileIconHelper fileIconHelper = new FileIconHelper(myfile.toString());
      fileIconHelper.setDynamicFolderEnabled(true);
      fileIconHelper.setEnvironmentEnabled(true);
      fileIconHelper.bindIcon(viewHolder.icon);

      if (FileUtil.isDirectory(files.get(pos).get("path").toString())) {
        Folder = true;
        Files = false;

        viewHolder.tvTools.setText("");
      } else if (FileUtil.isExistFile(files.get(pos).get("path").toString())) {
        viewHolder.icon.setPadding(0, 0, 0, 0);
        getTime(myfile.toString(), viewHolder.tvTools);
        viewHolder.icon.setBackgroundColor(0);
        if (BinderRecyclerview1.TaskVideo(myfile.toString())) {
          GlideCompat.GlideNormal(viewHolder.icon, myfile.toString());
        } else if (BinderRecyclerview1.PhotoView(myfile.toString())) {
          GlideCompat.GlideNormal(viewHolder.icon, myfile.toString());
        }
        if (myfile.toString().endsWith(".xml")) {
          GlideCompat.LoadVector(myfile.toString(), viewHolder.icon);
        } else if (myfile.toString().endsWith(".svg")) {
          GlideCompat.LoadSvg(myfile.toString(), viewHolder.icon);
        } else if (myfile.toString().endsWith(".apk")) {
          GlideCompat.LoadApkFile(myfile.toString(), viewHolder.icon);
        } else if (myfile.toString().endsWith(".AA")) {
          GlideCompat.LoadIconTheme(myfile.toString(), viewHolder.icon);
        } else if (myfile.toString().endsWith(".mp3")) {
          GlideCompat.GlideLoadMp3(viewHolder.icon, myfile.toString());
        } else if (myfile.toString().endsWith(".pdf")) {
          GlideCompat.loadImgPdf(myfile.toString(), viewHolder.icon);
        } else if (myfile.toString().endsWith(".snippet")) {
          viewHolder.icon.setColorFilter(Color.parseColor("#FBC82F"));
        } else if (myfile.toString().endsWith(".java")) {
          GlideCompat.setLoadJavaModel(viewHolder.icon, new File(myfile.toString()));
        } else if (myfile.toString().endsWith(".swb")) {
          /**
           * We will use this method temporarily with this name, I will update it in the future, I
           * do not have time now
           */
          GlideCompat.LoadIconVsCode(myfile.toString(), viewHolder.icon);
        } else if (myfile.toString().endsWith(".jsx")) {
          viewHolder.icon.setColorFilter(Color.parseColor("#ff9028"));
        } else if (myfile.toString().endsWith(".tsx")) {
          viewHolder.icon.setColorFilter(Color.parseColor("#FF5DC9DC"));
        } else if (myfile.toString().endsWith(".ghost")) {
          if (!ThemeChkerErrorBinder.runbinder(myfile.toString())) {
            viewHolder.icon.setColorFilter(Color.parseColor("#fff00000"));
          } else {
            viewHolder.icon.clearColorFilter();
          }
        }
        // test
        JgitHelper.initbylazy(myfile, viewHolder.folderName);
        // test1

      }
    }
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

  public void setSettingTextView(TextView tv) {
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

  public void removedItem(int pos) {
    files.remove(pos);
    notifyItemRemoved(pos);
  }

  public void makeFile(String path) {
    var filemaker = new FileMaker(context);
    filemaker.setFolderName(path);
    filemaker.setCallBack(
        new FileCallBack() {

          @Override
          public void onError(String error) {
            Toast.makeText(context, error, 2).show();
          }

          @Override
          public void onDoneMakeFile(String toast) {
            // notifyDataSetChanged();
          }
        });
  }

  public void search(String query) {}

  private void getTime(String path, TextView view) {
    try {

      if (view != null) {
        view.setText(
            MFileClass.convertBytes(FileUtil.getFileLength(path))
                .concat(", ".concat(MFileClass.getLastModifiedOfFile(path, "HH:mm,dd/MM/yyyy"))));
      }
    } catch (Exception err) {
      err.printStackTrace();
    }
  }

  public String getMp3Format(String txt) {
    List<String> list = Arrays.asList(FileHelper.AUDIO_FILES);
    for (var item : list) {
      return item + txt;
    }
    return txt;
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
  }

  @Override
  public int getItemViewType(int pos) {
    return viewType.getValue();
  }

  public void setViewType(ViewType viewType) {
    this.viewType = viewType;
    notifyDataSetChanged();
  }
}
