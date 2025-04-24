package ir.ninjacoder.ghostide.folder;

import android.widget.ImageView;
import android.widget.Toast;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import ir.ninjacoder.ghostide.R;
import com.bumptech.glide.Glide;
import ir.ninjacoder.ghostide.glidecompat.GlideCompat;
import java.io.File;

public class FileIconHelperPath {
  private String filePath;
  private String mimeType;
  private String fileIconPath;
  private boolean isDynamicFolderEnabled;
  private boolean isEnvironmentEnabled;
  private FileHelper fileHelper;
  private FileEnvironmentHelper fileEnvHelper;
  private FolderUtils folderUtils;

  // Constants for icon paths
  public static final String ICON_PATH = "/storage/emulated/0/GhostWebIDE/appicon";
  public static final String DEFAULT_FOLDER_ICON = ICON_PATH + "/folder.svg";
  public static final String ANDROID_FOLDER_ICON = ICON_PATH + "/ic_material_folder_android.png";
  public static final String DEFAULT_FILE_ICON = ICON_PATH + "/file.svg";

  public FileIconHelperPath(String filePath) {
    this.filePath = filePath;
    this.mimeType = "";
    initializeFolderUtils();
    check();
  }

  @Deprecated
  public FileIconHelperPath(String filePath, String mimeType) {
    this.filePath = filePath;
    this.mimeType = mimeType;
    initializeFolderUtils();
    check();
  }

  private void initializeFolderUtils() {
    folderUtils = FolderUtils.getInstance(GhostIdeAppLoader.getContext());
    folderUtils.setIconsBasePath("/storage/emulated/0/GhostWebIDE/appicon/");
    folderUtils.loadFileIcons("/storage/emulated/0/GhostWebIDE/appicon/file_icons.json");
    folderUtils.loadFolderIcons("/storage/emulated/0/GhostWebIDE/appicon/folder_icons.json");
  }


  public void bind(ImageView imageView) {
    try {
      File file = new File(fileIconPath);
      Glide.with(imageView.getContext())
          .load(fileIconPath)
          .diskCacheStrategy(DiskCacheStrategy.NONE)
          .error(R.drawable.ic_material_folder)
          .into(imageView);
    } catch (Exception e) {
      Toast.makeText(GhostIdeAppLoader.getContext(),e.getMessage(),2).show();
    }
  }

  private void check() {
    File mfile = new File(filePath);

    if (mfile.isDirectory()) {
      handleFolderIcon(mfile);
    } else {
      handleFileIcon(mfile);
    }
  }

  private void handleFolderIcon(File folder) {
    fileIconPath = folderUtils.getFolderIconPath(folder.getName());
  }

  private void handleFileIcon(File file) {
    fileIconPath = folderUtils.getFileIconPath(file.getName());
  }
}
