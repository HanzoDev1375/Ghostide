package ir.ninjacoder.prograsssheet;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.blankj.utilcode.util.ThreadUtils;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import ir.ninjacoder.prograsssheet.enums.StateMod;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import java.io.File;
import java.io.IOException;

public class GTheme {
  private static String TAG = "GTheme";

  public interface OnCallBack {
    void call();
  }

  public static void install(Context context, String zipFilePath, OnCallBack call) {
    if (!zipFilePath.endsWith(".gtheme")) {
      return;
    }
    String password = "HanzoDev1375";
    File zipFileObj = new File(zipFilePath);
    String folderName = zipFileObj.getName().replace(".gtheme", "");
    String parentPath = zipFileObj.getParent();

    File destDir;
    if (parentPath != null) {
      destDir = new File(parentPath, folderName);
    } else {
      destDir = new File(context.getExternalFilesDir(null), folderName);
    }

    if (destDir.exists()) {
      deleteRecursive(destDir);
    }
    destDir.mkdirs();

    try {
      ZipFile zipFile = new ZipFile(zipFilePath);
      if (zipFile.isEncrypted()) {
        if (password == null || password.isEmpty()) {
          Log.e("ThemePacker", "Zip file is encrypted but no password provided.");
          return;
        }
        zipFile.setPassword(password.toCharArray());
      }
      zipFile.extractAll(destDir.getAbsolutePath());

      File wallpaperFile = findWallpaper(destDir);
      if (wallpaperFile != null) {
        String themePath = destDir.getAbsolutePath();
        String wallpaperPath = wallpaperFile.getAbsolutePath();
        new MaterialAlertDialogBuilder(context)
            .setTitle("Install Theme")
            .setMessage("Install theme ?")
            .setPositiveButton(
                android.R.string.ok,
                (v, f) -> {
                  saveToSharedPreferences(context, themePath, wallpaperPath);
                })
            .setNegativeButton(android.R.string.cancel, null)
            .show();
        if (call != null) {
          call.call();
        }
      } else {
        Log.w("ThemePacker", "Wallpaper not found in the theme package.");
      }
    } catch (IOException e) {
      e.printStackTrace();
      Log.e("ThemePacker", "Error extracting zip file: " + e.getMessage());
    }
  }

  private static File findWallpaper(File folder) {
    String[] validExtensions = {".jpg", ".png", ".webp", ".gif", ".jpeg"};
    File[] files = folder.listFiles();
    if (files == null) return null;
    for (File file : files) {
      if (file.isFile()) {
        String fileName = file.getName().toLowerCase();
        for (String ext : validExtensions) {
          if (fileName.endsWith(ext)) {

            return file;
          }
        }
      }
    }
    return null;
  }

  private static File findGhostFile(File folder) {
    File[] files = folder.listFiles();
    if (files == null) return null;
    for (File file : files) {
      if (file.isFile() && file.getName().toLowerCase().endsWith(".ghost")) {
        return file;
      }
    }
    return null;
  }

  private static void saveToSharedPreferences(
      Context context, String themeFolderPath, String wallpaperPath) {

    if (new File(wallpaperPath).getName().startsWith("preview")) {
      return;
    } else {
      SharedPreferences sharedPreferences =
          context.getSharedPreferences("getvb", Context.MODE_PRIVATE);
      sharedPreferences.edit().putString("dir", wallpaperPath).apply();
      Log.i(TAG, "wallpaper dir -> " + wallpaperPath);
    }
    File themeFolder = new File(themeFolderPath);
    File ghostFile = findGhostFile(themeFolder);

    if (ghostFile != null) {
      SharedPreferences thememanagersoft =
          context.getSharedPreferences("thememanagersoft", Context.MODE_PRIVATE);
      thememanagersoft.edit().putString("themes", ghostFile.getAbsolutePath()).apply();
      Log.i(TAG, "Theme soft path: " + ghostFile.getAbsolutePath());
    } else {
      Log.w(TAG, "No .ghost file found in theme folder!");
    }
  }

  private static void deleteRecursive(File fileOrDirectory) {
    if (fileOrDirectory.isDirectory()) {
      for (File child : fileOrDirectory.listFiles()) {
        deleteRecursive(child);
      }
    }
    fileOrDirectory.delete();
  }

  public static void pack(
      String folderPath, String outputZipPath, Context context, OnCallBack call) {
    String password = "HanzoDev1375";
    var sheet = new PrograssSheet(context);
    sheet.setMode(StateMod.PROGRASSH);
    sheet.setSubTitle("Loading...");
    sheet.setTitle("Loading...");
    sheet.show();

    new Thread(
            () -> {
              File sourceFolder = new File(folderPath);
              if (!sourceFolder.exists() || !sourceFolder.isDirectory()) {
                return;
              }
              String folderName = sourceFolder.getName();
              File finalZipFile = new File(outputZipPath, folderName + ".gtheme");

              try {
                ZipFile zipFile = new ZipFile(finalZipFile, password.toCharArray());

                File[] files = sourceFolder.listFiles();
                if (files != null) {
                  for (File file : files) {
                    ZipParameters parameters = new ZipParameters();
                    parameters.setCompressionMethod(CompressionMethod.DEFLATE);
                    parameters.setEncryptFiles(true);
                    parameters.setEncryptionMethod(EncryptionMethod.AES);
                    String fileName = file.getName().toLowerCase();
                    boolean isImage =
                        fileName.endsWith(".jpg")
                            || fileName.endsWith(".png")
                            || fileName.endsWith(".jpeg")
                            || fileName.endsWith(".gif")
                            || fileName.endsWith(".webp");

                    if (isImage) {
                      parameters.setCompressionLevel(CompressionLevel.NO_COMPRESSION);
                    } else {
                      parameters.setCompressionLevel(CompressionLevel.MAXIMUM);
                    }
                    zipFile.addFile(file, parameters);
                  }
                }

                ThreadUtils.runOnUiThread(
                    () -> {
                      call.call();
                      sheet.dismiss();
                    });

              } catch (IOException e) {
                e.printStackTrace();
                Log.e("ThemePacker", "Error creating zip: " + e.getMessage());
              }
            })
        .start();
  }
}
