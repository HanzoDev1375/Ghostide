package ir.ninjacoder.ghostide.core.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Extractor {

  private String getOutFilename(PackageInfo info) {
    String basePath;
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
      basePath = Environment.DIRECTORY_DOWNLOADS + "/APKs/";
    } else {
      basePath = Environment.getExternalStorageDirectory() + "/APKs/";
    }

    return basePath + info.packageName + "_v" + info.versionName + ".apk";
  }

  public String extractWithoutRoot(PackageInfo info) throws Exception {
    File src = new File(info.applicationInfo.sourceDir);
    File dst;

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
      dst =
          new File(
              Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
              "APKs/" + info.packageName + "_v" + info.versionName + ".apk");
    } else {
      dst = new File(Environment.getExternalStorageDirectory(), getOutFilename(info));
    }

    dst = buildDstPath(dst);

    try {
      copyWithProgress(src, dst);
    } catch (IOException ex) {
      throw new Exception("Copy failed: " + ex.getMessage());
    }

    if (!dst.exists()) {
      throw new Exception("Cannot extract file [no root]");
    }

    return dst.getAbsolutePath();
  }

  private void copyWithProgress(File src, File dst) throws IOException {
    try (FileInputStream inStream = new FileInputStream(src);
        FileOutputStream outStream = new FileOutputStream(dst)) {

      FileChannel inChannel = inStream.getChannel();
      FileChannel outChannel = outStream.getChannel();

      long totalSize = inChannel.size();
      long transferred = 0;

      while (transferred < totalSize) {
        transferred +=
            inChannel.transferTo(transferred, Math.min(8192, totalSize - transferred), outChannel);
      }
    }
  }

  private File buildDstPath(File path) throws IOException {
    File parent = path.getParentFile();
    if (parent != null && !parent.exists()) {
      if (!parent.mkdirs()) {
        throw new IOException("Cannot create directory: " + parent.getAbsolutePath());
      }
    }

    if (!path.exists()) return path;

    String fname = path.getName();
    int index = fname.lastIndexOf(".");
    String ext = index > 0 ? fname.substring(index) : "";
    String name = index > 0 ? fname.substring(0, index) : fname;
    String timestamp =
        new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());

    File newPath = new File(path.getParentFile(), name + "_" + timestamp + ext);
    return newPath;
  }
}
