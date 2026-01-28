package ir.ninjacoder.ghostide.core.config;

import ir.ninjacoder.ghostide.core.folder.FileIconHelper;

public class IconRes {
  
  public static int get(String path) {
    FileIconHelper fileIconHelper = new FileIconHelper(path);
    fileIconHelper.setDynamicFolderEnabled(true);
    fileIconHelper.setEnvironmentEnabled(true);
    return fileIconHelper.getFileIcon();
  }
}
