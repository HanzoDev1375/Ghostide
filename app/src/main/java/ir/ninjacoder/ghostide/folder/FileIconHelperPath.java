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
  public static final String DEFAULT_FOLDER_ICON = ICON_PATH + "/ic_material_folder.png";
  public static final String ANDROID_FOLDER_ICON = ICON_PATH + "/ic_material_folder_android.png";
  public static final String DEFAULT_FILE_ICON = ICON_PATH + "/ic_file_default.png";

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
    folderUtils.setIconsBasePath("/storage/emulated/0/apk/icon/");

    // Load icons in background thread to avoid UI freeze

    folderUtils.loadFileIcons("/storage/emulated/0/apk/icon/file_icons.json");
    folderUtils.loadFolderIcons("/storage/emulated/0/apk/icon/folder_icons.json");
  }

  // ... [Keep all existing getters and setters unchanged] ...

  public void bind(ImageView imageView) {
    // Use GlideCompat if available, otherwise fall back to regular Glide
    try {
      File file = new File(fileIconPath);
      Glide.with(imageView.getContext())
          .load(fileIconPath)
          .diskCacheStrategy(DiskCacheStrategy.NONE)
          .error( R.drawable.ic_material_folder)
          .into(imageView);
    } catch (Exception e) {

    }
  }

  private void check() {
    fileHelper = new FileHelper(filePath);
    fileEnvHelper = new FileEnvironmentHelper(filePath);
    File mfile = new File(filePath);

    if (mfile.isDirectory()) {
      handleFolderIcon(mfile);
    } else {
      handleFileIcon(mfile);
    }
  }

  private void handleFolderIcon(File folder) {
    // First try to get dynamic folder icon
    fileIconPath = folderUtils.getFolderIconPath(folder.getName());
  }

  private void handleFileIcon(File file) {
    // First try to get dynamic file icon
    fileIconPath = folderUtils.getFileIconPath(file.getName());

    // If no dynamic icon found, use default icon
    if (fileIconPath == null) {
      fileIconPath = DEFAULT_FILE_ICON;
    }
  }
}
