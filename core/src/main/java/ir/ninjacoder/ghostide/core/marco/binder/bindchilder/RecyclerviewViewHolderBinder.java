package ir.ninjacoder.ghostide.core.marco.binder.bindchilder;

import android.widget.ImageView;
import android.widget.TextView;
import ir.ninjacoder.ghostide.core.adapter.ViewType;
import ir.ninjacoder.ghostide.core.model.filemanager.FileManagerModel;
import ir.ninjacoder.ghostide.core.utils.MFileClass;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;
import android.graphics.Color;
import com.google.android.material.color.MaterialColors;
import ir.ninjacoder.ghostide.core.utils.FileUtil;
import ir.ninjacoder.ghostide.core.marco.FileCounter;
import ir.ninjacoder.ghostide.core.folder.FileIconHelperPath;
import ir.ninjacoder.ghostide.core.marco.binder.BinderRecyclerview1;
import ir.ninjacoder.ghostide.core.glidecompat.GlideCompat;
import ir.ninjacoder.ghostide.core.folder.FileIconHelper;
import ir.ninjacoder.ghostide.core.marco.binder.ThemeChkerErrorBinder;
import ir.ninjacoder.ghostide.core.git.JgitHelper;
import ir.ninjacoder.prograsssheet.listchild.Child;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecyclerviewViewHolderBinder {
  
  public static void bindHolder(
     List<FileManagerModel> files,
      TextView folderName,
      TextView tvTools,
      ImageView icon,
      ViewType viewType,
      int pos,
      List<Child> listChild) {

    File myfile = new File(files.get(pos).getFilePath());
    if (FileUtil.isDirectory(myfile.toString())) {
      if (viewType == ViewType.ROW) {
        icon.setPadding(8, 8, 8, 8);
        ObjectUtils.shp(icon);
      }
      FileCounter mfileC = new FileCounter(tvTools);
      mfileC.execute(myfile.toString());
    } else {
      getTime(myfile.toString(), tvTools);
      icon.setBackgroundColor(0);
      icon.setPadding(0, 0, 0, 0);
    }
    folderName.setText(myfile.getName());

    if (FileUtil.isExistFile(FileIconHelperPath.ICON_PATH + "/ic_material_folder.png")) {

      FileIconHelperPath fileIconPath = new FileIconHelperPath(myfile.toString());
      fileIconPath.bind(icon);

      if (BinderRecyclerview1.TaskVideo(myfile.toString())) {
        GlideCompat.GlideNormal(icon, myfile.toString());
      } else if (BinderRecyclerview1.PhotoView(myfile.toString())) {
        GlideCompat.GlideNormal(icon, myfile.toString());
      }

      if (myfile.toString().endsWith(".xml")) {
        GlideCompat.LoadVector(myfile.toString(), icon);

      } else if (myfile.toString().endsWith(".svg")) {
        GlideCompat.LoadSvg(myfile.toString(), icon);
      } else if (myfile.toString().endsWith(".apk")) {
        GlideCompat.LoadApkFile(myfile.toString(), icon);
      } else if (myfile.toString().endsWith(".AA")) {
        GlideCompat.LoadIconTheme(myfile.toString(), icon);
      } else if (myfile.toString().endsWith(".mp3")) {
        GlideCompat.GlideLoadMp3(icon, myfile.toString());
      } else if (myfile.toString().endsWith(".pdf")) {
        GlideCompat.loadImgPdf(myfile.toString(), icon);
      } else if (myfile.toString().endsWith(".pgb")) {
        GlideCompat.LoadPgbIcon(myfile.toString(), icon);
      }

    } else {
      FileIconHelper fileIconHelper = new FileIconHelper(myfile.toString());
      fileIconHelper.setDynamicFolderEnabled(true);
      fileIconHelper.setEnvironmentEnabled(true);
      fileIconHelper.bindIcon(icon);

      if (FileUtil.isDirectory(myfile.toString())) {
        tvTools.setText("");
      } else if (FileUtil.isExistFile(myfile.toString())) {
        icon.setPadding(0, 0, 0, 0);
        getTime(myfile.toString(), tvTools);
        icon.setBackgroundColor(0);
        if (BinderRecyclerview1.TaskVideo(myfile.toString())) {
          GlideCompat.GlideNormal(icon, myfile.toString());
        } else if (BinderRecyclerview1.PhotoView(myfile.toString())) {
          GlideCompat.GlideNormal(icon, myfile.toString());
        }
        if (myfile.toString().endsWith(".xml")) {
          GlideCompat.LoadVector(myfile.toString(), icon);
        } else if (myfile.toString().endsWith(".svg")) {
          GlideCompat.LoadSvg(myfile.toString(), icon);
        } else if (myfile.toString().endsWith(".apk")) {
          GlideCompat.LoadApkFile(myfile.toString(), icon);
        } else if (myfile.toString().endsWith(".AA")) {
          GlideCompat.LoadIconTheme(myfile.toString(), icon);
        } else if (myfile.toString().endsWith(".mp3")) {
          GlideCompat.GlideLoadMp3(icon, myfile.toString());
        } else if (myfile.toString().endsWith(".pdf")) {
          GlideCompat.loadImgPdf(myfile.toString(), icon);
        } else if (myfile.toString().endsWith(".snippet")) {
          icon.setColorFilter(Color.parseColor("#FBC82F"));
        } else if (myfile.toString().endsWith(".java")) {
          GlideCompat.setLoadJavaModel(icon, new File(myfile.toString()));
        } else if (myfile.toString().endsWith(".swb")) {
          GlideCompat.LoadIconVsCode(myfile.toString(), icon);
        } else if (myfile.toString().endsWith(".jsx")) {
          icon.setColorFilter(Color.parseColor("#ff9028"));
        } else if (myfile.toString().endsWith(".tsx")) {
          icon.setColorFilter(Color.parseColor("#FF5DC9DC"));
        } else if (myfile.toString().endsWith(".ghost")) {
          if (!ThemeChkerErrorBinder.runbinder(myfile.toString())) {
            icon.setColorFilter(Color.parseColor("#fff00000"));
          } else {
            icon.clearColorFilter();
          }
        } else if (myfile.toString().endsWith(".pgb")) {
          GlideCompat.LoadPgbIcon(myfile.toString(), icon);
        }
        // test
        JgitHelper.initbylazy(myfile, folderName);
        for (var iterbel : listChild) {
          if (myfile.toString().endsWith(iterbel.getTypeExz())) {
            GlideCompat.GlideNormal(icon, iterbel.getIconFile());
          }
        }
      }
    }
  }

  private static void getTime(String path, TextView view) {
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
}
