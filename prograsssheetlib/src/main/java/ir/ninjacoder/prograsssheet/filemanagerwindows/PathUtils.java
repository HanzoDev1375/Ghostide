package ir.ninjacoder.prograsssheet.filemanagerwindows;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.FileWriter;
import ir.ninjacoder.prograsssheet.PrograssSheet;
import ir.ninjacoder.prograsssheet.enums.StateMod;
import com.blankj.utilcode.util.ThreadUtils;
import java.text.DecimalFormat;
import androidx.annotation.MainThread;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PathUtils {
  private static void createNewFile(String path) {
    int lastSep = path.lastIndexOf(File.separator);
    if (lastSep > 0) {
      String dirPath = path.substring(0, lastSep);
      makeDir(dirPath);
    }

    File file = new File(path);

    try {
      if (!file.exists()) file.createNewFile();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String readFile(String path) {
    createNewFile(path);

    StringBuilder sb = new StringBuilder();
    FileReader fr = null;
    try {
      fr = new FileReader(new File(path));

      char[] buff = new char[1024];
      int length = 0;

      while ((length = fr.read(buff)) > 0) {
        sb.append(new String(buff, 0, length));
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (fr != null) {
        try {
          fr.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }

    return sb.toString();
  }

  public static void writeFile(String path, String str) {
    createNewFile(path);
    FileWriter fileWriter = null;

    try {
      fileWriter = new FileWriter(new File(path), false);
      fileWriter.write(str);
      fileWriter.flush();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (fileWriter != null) fileWriter.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  interface OnStateChange {
    void change(int count, String name);
  }

  public static boolean isFile(String path) {
    if (!isExistFile(path)) return false;
    return new File(path).isFile();
  }

  public static void copyFile(String sourcePath, String destPath) {
    if (!isExistFile(sourcePath)) return;
    createNewFile(destPath);

    FileInputStream fis = null;
    FileOutputStream fos = null;

    try {
      fis = new FileInputStream(sourcePath);
      fos = new FileOutputStream(destPath, false);

      byte[] buff = new byte[1024];
      int length = 0;

      while ((length = fis.read(buff)) > 0) {
        fos.write(buff, 0, length);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (fis != null) {
        try {
          fis.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (fos != null) {
        try {
          fos.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public static void copyDir(String oldPath, String newPath) {
    File oldFile = new File(oldPath);
    File[] files = oldFile.listFiles();
    File newFile = new File(newPath);
    if (!newFile.exists()) {
      newFile.mkdirs();
    }
    for (File file : files) {
      if (file.isFile()) {
        copyFile(file.getPath(), newPath + "/" + file.getName());
      } else if (file.isDirectory()) {
        copyDir(file.getPath(), newPath + "/" + file.getName());
      }
    }
  }

  private static long getFolderSize(File folder) {
    long size = 0;
    File[] files = folder.listFiles();
    if (files != null) {
      for (File file : files) {
        if (file.isFile()) {
          size += file.length();
        } else if (file.isDirectory()) {
          size += getFolderSize(file);
        }
      }
    }
    return size;
  }

  public static void moveFile(String sourcePath, String destPath) {
    copyFile(sourcePath, destPath);
    deleteFile(sourcePath);
  }

  public interface OnFileChangeCall {
    @MainThread
    void onFileDone();

    @MainThread
    void onFileError(String error);
  }

  static long totalSize, currentSize, processedSize;
  static String currentFileName;

  public static void copyAuto(
      String oldPath, String newPath, OnStateChange state, boolean movemod) {
    File oldFile = new File(oldPath);
    if (!oldFile.exists()) return;

    if (oldFile.isFile()) {
      String destFilePath;
      File newFile = new File(newPath);

      if (newFile.isDirectory() || newPath.endsWith("/")) {
        destFilePath = newPath + "/" + oldFile.getName();
      } else {
        destFilePath = newPath;
      }

      File destDir = new File(destFilePath).getParentFile();
      if (destDir != null && !destDir.exists()) {
        destDir.mkdirs();
      }

      copyFile(oldPath, destFilePath);

      if (state != null) {
        state.change((int) oldFile.length(), oldFile.getName());
      }

      if (movemod) {
        oldFile.delete();
      }

      return;
    }

    File[] files = oldFile.listFiles();
    if (files == null) {
      File newFile = new File(newPath);
      if (!newFile.exists()) {
        newFile.mkdirs();
      }
      return;
    }

    File newFile = new File(newPath);
    if (!newFile.exists()) {
      newFile.mkdirs();
    }

    totalSize = calculateSize(oldFile);
    processedSize = 0;

    for (File file : files) {
      String destPath = newPath + "/" + file.getName();

      if (file.isFile()) {
        copyFile(file.getPath(), destPath);

        if (state != null) {
          processedSize += file.length();
          state.change((int) file.length(), file.getName());
        }

        if (movemod) {
          file.delete();
        }

      } else if (file.isDirectory()) {
        copyAuto(
            file.getPath(),
            destPath,
            new OnStateChange() {
              @Override
              public void change(int count, String name) {
                if (state != null) {
                  processedSize += count;
                  state.change(count, name);
                }
              }
            },
            movemod);

        if (movemod) {
          file.delete();
        }
      }
    }
  }

  // main

  public static void moveFileOrDirByGhostide(
      String sourcePath, String destPath, OnFileChangeCall call, boolean copymod, Context context) {
    var sheet = new PrograssSheet(context);
    sheet.setMode(StateMod.PROGRASSV);
    String type = isDirectory(sourcePath) ? "Folder" : "File";
    sheet.setTitle((copymod ? "Copy " : "Move ") + type);
    sheet.setCancelable(false);
    sheet.showBottonLayout(true);
    sheet.show();

    // متغیرهای لوکال برای جلوگیری از تداخل در عملیات همزمان
    final long[] totalSize = {0};
    final long[] currentSize = {0L};
    final long[] lastUpdateTime = {0L}; // برای کنترل سرعت آپدیت UI

    var thread =
        new Thread(
            () -> {
              try {
                File sourceFile = new File(sourcePath);
                if (!sourceFile.exists()) {
                  throw new Exception("Source " + type + " does not exist");
                }

                totalSize[0] = calculateSize(sourceFile);
                copyAutoOptimized(
                    sourcePath,
                    destPath,
                    (count, name) -> {
                      currentSize[0] += count;

                      // محاسبه زمان برای جلوگیری از آپدیت‌های سریع و پشت سر هم
                      long now = System.currentTimeMillis();
                      if (now - lastUpdateTime[0] > 50) { // آپدیت هر ۵۰ میلی‌ثانیه
                        lastUpdateTime[0] = now;
                        int progress =
                            totalSize[0] > 0
                                ? (int) ((double) currentSize[0] / totalSize[0] * 100)
                                : 100;

                        ThreadUtils.runOnUiThread(
                            () -> {
                              sheet.setPrograss(progress, true);
                              sheet.setSubTitle((copymod ? "Copying: " : "Moving: ") + name);
                            });
                      }
                    },
                    !copymod);

                // آپدیت نهایی برای اطمینان از رسیدن به ۱۰۰٪
                ThreadUtils.runOnUiThread(
                    () -> {
                      sheet.setPrograss(100, true);
                      sheet.dismiss();
                      if (call != null) {
                        call.onFileDone();
                      }
                    });
              } catch (Exception err) {
                err.printStackTrace();
                ThreadUtils.runOnUiThread(
                    () -> {
                      sheet.dismiss();
                      if (call != null) {
                        call.onFileError(
                            err.getMessage() != null ? err.getMessage() : "Unknown error");
                      }
                    });
              }
            });
    thread.start();
    sheet.clickButton(
        v -> {
          if (thread != null && thread.isAlive()) {
            thread.interrupt();
            ThreadUtils.runOnUiThread(
                () -> {
                  sheet.dismiss();
                });
          }
        });
  }

  // متد کمکی برای کپی بهینه (مشابه copyAuto قبلی اما با تمیزی بیشتر)
  private static void copyAutoOptimized(
      String oldPath, String newPath, OnStateChange state, boolean movemod) {
    File oldFile = new File(oldPath);
    if (!oldFile.exists()) return;

    if (oldFile.isFile()) {
      String destFilePath;
      File newFile = new File(newPath);
      if (newFile.isDirectory() || newPath.endsWith("/")) {
        destFilePath = newPath + "/" + oldFile.getName();
      } else {
        destFilePath = newPath;
      }
      File destDir = new File(destFilePath).getParentFile();
      if (destDir != null && !destDir.exists()) {
        destDir.mkdirs();
      }
      copyFile(oldPath, destFilePath);
      if (state != null) {
        state.change((int) oldFile.length(), oldFile.getName());
      }
      if (movemod) {
        oldFile.delete();
      }
      return;
    }

    File[] files = oldFile.listFiles();
    if (files == null) {
      File newFile = new File(newPath);
      if (!newFile.exists()) {
        newFile.mkdirs();
      }
      return;
    }

    File newFile = new File(newPath);
    if (!newFile.exists()) {
      newFile.mkdirs();
    }

    for (File file : files) {
      String destPath = newPath + "/" + file.getName();
      if (file.isFile()) {
        copyFile(file.getPath(), destPath);
        if (state != null) {
          state.change((int) file.length(), file.getName());
        }
        if (movemod) {
          file.delete();
        }
      } else if (file.isDirectory()) {
        copyAutoOptimized(
            file.getPath(),
            destPath,
            new OnStateChange() {
              @Override
              public void change(int count, String name) {
                if (state != null) {
                  state.change(count, name);
                }
              }
            },
            movemod);
        if (movemod) {
          file.delete();
        }
      }
    }
  }

  public static long calculateSize(File file) {
    if (file.isFile()) {
      return file.length();
    }

    long size = 0;
    File[] files = file.listFiles();
    if (files != null) {
      for (File f : files) {
        size += calculateSize(f);
      }
    }
    return size;
  }

  private static long getTotalSize(File directory) {
    long totalSize = 0;
    File[] files = directory.listFiles();

    if (files != null) {
      for (File file : files) {
        if (file.isFile()) {
          totalSize += file.length();
        } else {
          totalSize += getTotalSize(file);
        }
      }
    }

    return totalSize;
  }

  public static String formatFileSize(long size) {
    if (size <= 0) return "0 B";
    final String[] units = new String[] {"B", "KB", "MB", "GB", "TB"};
    int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
    return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups))
        + " "
        + units[digitGroups];
  }

  public static void deleteFile(String path) {
    File file = new File(path);

    if (!file.exists()) return;

    if (file.isFile()) {
      file.delete();
      return;
    }

    File[] fileArr = file.listFiles();

    if (fileArr != null) {
      for (File subFile : fileArr) {
        if (subFile.isDirectory()) {
          deleteFile(subFile.getAbsolutePath());
        }

        if (subFile.isFile()) {
          subFile.delete();
        }
      }
    }

    file.delete();
  }

  public static boolean isExistFile(String path) {
    File file = new File(path);
    return file.exists();
  }

  public static void makeDir(String path) {
    if (!isExistFile(path)) {
      File file = new File(path);
      file.mkdirs();
    }
  }

  public static void listDir(String path, ArrayList<String> list) {
    File dir = new File(path);
    if (!dir.exists() || dir.isFile()) return;

    File[] listFiles = dir.listFiles();
    if (listFiles == null || listFiles.length <= 0) return;

    if (list == null) return;
    list.clear();
    for (File file : listFiles) {
      list.add(file.getAbsolutePath());
    }
  }

  public static void listDir(String path, List<String> list) {
    File dir = new File(path);
    if (!dir.exists() || dir.isFile()) return;

    File[] listFiles = dir.listFiles();
    if (listFiles == null || listFiles.length <= 0) return;

    if (list == null) return;
    list.clear();
    for (File file : listFiles) {
      list.add(file.getAbsolutePath());
    }
  }

  public static boolean isDirectory(String path) {
    if (!isExistFile(path)) return false;
    return new File(path).isDirectory();
  }
}
