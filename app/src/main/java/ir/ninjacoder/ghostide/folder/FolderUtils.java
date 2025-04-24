package ir.ninjacoder.ghostide.folder;

import android.content.Context;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FolderUtils {
  private static FolderUtils instance;
  private final Context context;
  private final Map<String, String> iconCache;
  private final Map<String, String> folderIconCache;
  private List<FileIcon> fileIcons;
  private List<FolderIcon> folderIcons;
  private String iconsBasePath;

  private FolderUtils(Context context) {
    this.context = context.getApplicationContext();
    this.iconCache = new HashMap<>();
    this.folderIconCache = new HashMap<>();
    this.iconsBasePath = "/storage/emulated/0/GhostWebIDE/appicon/";
  }

  public static synchronized FolderUtils getInstance(Context context) {
    if (instance == null) {
      instance = new FolderUtils(context);
    }
    return instance;
  }

  public void setIconsBasePath(String path) {
    this.iconsBasePath = path;
    iconCache.clear();
    folderIconCache.clear();
  }

  public void loadFileIcons(String jsonPath) {
    try {
      File iconsFile = new File(jsonPath);
      if (iconsFile.exists()) {
        Gson gson = new Gson();
        TypeToken<List<FileIcon>> typeToken = new TypeToken<List<FileIcon>>() {};
        fileIcons = gson.fromJson(new FileReader(iconsFile), typeToken.getType());
        Log.d("Utils", "File icons loaded: " + fileIcons.size());
      }
    } catch (Exception e) {
      Log.e("Utils", "Error loading file icons", e);
    }
  }

  public void loadFolderIcons(String jsonPath) {
    try {
      File iconsFile = new File(jsonPath);
      if (iconsFile.exists()) {
        Gson gson = new Gson();
        TypeToken<List<FolderIcon>> typeToken = new TypeToken<List<FolderIcon>>() {};
        folderIcons = gson.fromJson(new FileReader(iconsFile), typeToken.getType());
        Log.d("Utils", "Folder icons loaded: " + folderIcons.size());
      }
    } catch (Exception e) {
      Log.e("Utils", "Error loading folder icons", e);
    }
  }

  public String getFileIconPath(String fileName) {
    if (fileName == null) return null;
    if (iconCache.containsKey(fileName)) {
      return iconCache.get(fileName);
    }

    if (fileIcons == null || fileIcons.isEmpty()) {
      return iconsBasePath + "file.svg";
    }
    for (FileIcon icon : fileIcons) {
      if (icon.file_name != null && icon.file_name.contains(fileName)) {
        String iconPath = iconsBasePath + icon.name + ".svg";
        iconCache.put(fileName, iconPath);
        return iconPath;
      }
    }
    int lastDotIndex = fileName.lastIndexOf('.');
    if (lastDotIndex > 0) {
      String extension = fileName.substring(lastDotIndex + 1).toLowerCase();
      for (FileIcon icon : fileIcons) {
        if (icon.file_extensions != null && icon.file_extensions.contains(extension)) {
          String iconPath = iconsBasePath + icon.name + ".svg";
          iconCache.put(fileName, iconPath);
          return iconPath;
        }
      }
    }
    return iconsBasePath + "file.svg";
  }

  public String getFolderIconPath(String folderName) {
    if (folderName == null) return null;
    if (folderIconCache.containsKey(folderName)) {
      return folderIconCache.get(folderName);
    }

    if (folderIcons == null || folderIcons.isEmpty()) {
      return iconsBasePath + "folder.svg";
    }
    for (FolderIcon icon : folderIcons) {
      if (icon.folder_name != null && icon.folder_name.contains(folderName)) {
        String iconPath = iconsBasePath + icon.name + ".svg";
        folderIconCache.put(folderName, iconPath);
        return iconPath;
      }
    }
    return iconsBasePath + "folder.svg";
  }

  public static class FileIcon {
    @SerializedName("name")
    public String name;

    @SerializedName("file_extensions")
    public List<String> file_extensions;

    @SerializedName("file_name")
    public List<String> file_name;

    private String حسین;

    private String برو_به_حسین() {
      return حسین;
    }
  }

  public static class FolderIcon {

    @SerializedName("name")
    public String name;

    @SerializedName("folder_name")
    public List<String> folder_name;
  }
}
