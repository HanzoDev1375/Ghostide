package ir.ninjacoder.ghostide.utils;

import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.os.Build;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.hzy.lib7z.Z7Extractor;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class AssetsSoft {
  private static final int BUFFER_SIZE = 1024 * 10;
  private static final String TAG = "Decompress";
  private static int Version = Build.VERSION.SDK_INT;
  private static int JellyVersion = Build.VERSION_CODES.JELLY_BEAN;

  public void RoadFileTextinAsset(Activity a, String input, String output) {
    try {
      java.io.InputStream posIn = a.getAssets().open(output);
      int posSi = posIn.available();
      byte[] posBu = new byte[posSi];
      posIn.read(posBu);
      posIn.close();
      input = new String(posBu, "UTF-8");
    } catch (IOException e) {
      Toast.makeText(a, e.toString(), Toast.LENGTH_LONG).show();
    }
  }

  public void RoadFileInWebView(Activity activity, WebView webView, String impaster) {

    try {
      java.io.InputStream webViewIn = activity.getAssets().open(impaster);
      int webViewSi = webViewIn.available();
      byte[] webViewBu = new byte[webViewSi];
      webViewIn.read(webViewBu);
      webViewIn.close();
      final String webViewStr = new String(webViewBu, "UTF-8");
      WebSettings webViewSs = webView.getSettings();
      webViewSs.setJavaScriptEnabled(true);
      webViewSs.setJavaScriptCanOpenWindowsAutomatically(true);
      if (Version >= JellyVersion) {
        webViewSs.setAllowFileAccessFromFileURLs(true);
        webViewSs.setAllowUniversalAccessFromFileURLs(true);
      }
      webView.loadUrl("data:text/html ,<html>".concat(webViewStr.concat("<html>")));
    } catch (IOException e) {
      Toast.makeText(activity, e.toString(), Toast.LENGTH_LONG).show();
    }
  }

  public void copyAllFilesAssets(String assetsFolder, String outPath, Context a) {
    AssetManager assetManager = a.getAssets();
    String[] files = null;
    try {
      files = assetManager.list(assetsFolder);
    } catch (java.io.IOException e) {

    }
    if (files != null)
      for (String filename : files) {
        InputStream in = null;
        OutputStream out = null;
        try {
          in = assetManager.open(assetsFolder + "/" + filename);
          java.io.File outFile = new java.io.File(outPath, filename);
          if (!(outFile.exists())) { // File does not exist...
            out = new java.io.FileOutputStream(outFile);
            copyFileinAsster(in, out);
          }
        } catch (java.io.IOException e) {

        } finally {
          if (in != null) {
            try {
              in.close();
            } catch (java.io.IOException e) {
              // NOOP
            }
          }
          if (out != null) {
            try {
              out.close();
            } catch (java.io.IOException e) {
              // NOOP
            }
          }
        }
      }
  }

  protected void copyFileinAsster(java.io.InputStream in, java.io.OutputStream out)
      throws java.io.IOException {
    byte[] buffer = new byte[1024];
    int read;
    while ((read = in.read(buffer)) != -1) {
      out.write(buffer, 0, read);
    }
  }

  public void copyOneFileFromAssets(String assetFilename, String assetSavePath, Context activity) {
    try {
      int count;
      java.io.InputStream input = activity.getAssets().open(assetFilename);
      java.io.OutputStream output =
          new java.io.FileOutputStream(assetSavePath + "/" + assetFilename);
      byte data[] = new byte[1024];
      while ((count = input.read(data)) > 0) {
        output.write(data, 0, count);
      }
      output.flush();
      output.close();
      input.close();
      Toast.makeText(activity, "Done", Toast.LENGTH_LONG).show();
    } catch (IOException e) {
      Toast.makeText(activity, "Error " + e.toString(), Toast.LENGTH_LONG).show();
    }
  }

  public void unzipFromAssets(Context context, String zipFile, String destination) {
    try {
      if (destination == null || destination.length() == 0)
        destination = context.getFilesDir().getAbsolutePath();
      InputStream stream = context.getAssets().open(zipFile);
      Toast.makeText(context, "Done", Toast.LENGTH_LONG).show();
      unzip(stream, destination);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  protected void unzip(String zipFile, String location) {
    try {
      FileInputStream fin = new FileInputStream(zipFile);
      unzip(fin, location);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  protected void unzip(InputStream stream, String destination) {
    dirChecker(destination, "");
    byte[] buffer = new byte[BUFFER_SIZE];
    try {
      ZipInputStream zin = new ZipInputStream(stream);
      ZipEntry ze = null;

      while ((ze = zin.getNextEntry()) != null) {
        Log.v(TAG, "Unzipping " + ze.getName());

        if (ze.isDirectory()) {
          dirChecker(destination, ze.getName());
        } else {
          File f = new File(destination, ze.getName());
          if (!f.exists()) {
            boolean success = f.createNewFile();
            if (!success) {
              Log.w(TAG, "Failed to create file " + f.getName());
              continue;
            }
            FileOutputStream fout = new FileOutputStream(f);
            int count;
            while ((count = zin.read(buffer)) != -1) {
              fout.write(buffer, 0, count);
            }
            zin.closeEntry();
            fout.close();
          }
        }
      }
      zin.close();
    } catch (Exception e) {
      Log.e(TAG, "unzip", e);
    }
  }

  protected void dirChecker(String destination, String dir) {
    File f = new File(destination, dir);

    if (!f.isDirectory()) {
      boolean success = f.mkdirs();
      if (!success) {
        Log.w(TAG, "Failed to create folder " + f.getName());
      }
    }
  }

  public void unZipPython(Context c, String fileName) {

    try {
      InputStream temp7zStream = c.getAssets().open(fileName);
      File file = new File(c.getFilesDir().getAbsolutePath() + fileName);
      file.createNewFile();
      Files.copy(temp7zStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
      String api = file.getAbsolutePath();
      unzip(api, c.getFilesDir().getAbsolutePath());
      file.delete();
      temp7zStream.close();
      Toast.makeText(c, "Data unZipet....", 2).show();
    } catch (IOException err) {
      Toast.makeText(c, err.getMessage(), 2).show();
    }
  }

  public void unZipPython(Context c) {
    unZipPython(c, "/python.zip");
  }

  public void z() {
    try {
      InputStream temp7zStream = GhostIdeAppLoader.getContext().getAssets().open("python.7z");
      File file =
          new File(GhostIdeAppLoader.getContext().getFilesDir().getAbsolutePath() + "/python.7z");
      file.createNewFile();
      Files.copy(temp7zStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
      unzipCompat(
          file.getAbsolutePath(), GhostIdeAppLoader.getContext().getFilesDir().getAbsolutePath());
      file.delete();
      temp7zStream.close();
      // Toast.makeText(GhostIdeAppLoader.getContext(), "unZipet " + file.getName(), 2).show();
    } catch (IOException err) {
      Toast.makeText(GhostIdeAppLoader.getContext(), err.getMessage(), 2).show();
    }
  }

  public void php() {
    try {
      InputStream temp7zStream = GhostIdeAppLoader.getContext().getAssets().open("libs.7z");
      File file =
          new File(GhostIdeAppLoader.getContext().getFilesDir().getAbsolutePath() + "/libs.7z");
      file.createNewFile();
      Files.copy(temp7zStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
      unzipCompat(
          file.getAbsolutePath(), GhostIdeAppLoader.getContext().getFilesDir().getAbsolutePath());
      file.delete();
      temp7zStream.close();
      // Toast.makeText(GhostIdeAppLoader.getContext(), "unZipet " + file.getName(), 2).show();
    } catch (IOException err) {
      Toast.makeText(GhostIdeAppLoader.getContext(), err.getMessage(), 2).show();
    }
  }

  public void unZipGcc() {
    try {
      InputStream temp7zStream = GhostIdeAppLoader.getContext().getAssets().open("gcc.zip");
      File file =
          new File(GhostIdeAppLoader.getContext().getFilesDir().getAbsolutePath() + "/gcc.zip");
      file.createNewFile();
      Files.copy(temp7zStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
      unzip(file.getAbsolutePath(), GhostIdeAppLoader.getContext().getFilesDir().getAbsolutePath());
      file.delete();
      temp7zStream.close();
      //	Toast.makeText(GhostIdeAppLoader.getContext(), "unZipet " + file.getName(), 2).show();
    } catch (IOException err) {
      Toast.makeText(GhostIdeAppLoader.getContext(), err.getMessage(), 2).show();
    }
  }

  protected MaterialShapeDrawable db() {
    MaterialShapeDrawable mt =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder().setAllCorners(CornerFamily.CUT, 14f).build());
    mt.setFillColor(
        ColorStateList.valueOf(
            MaterialColors.getColor(GhostIdeAppLoader.getContext(), ObjectUtils.Back, 0)));
    mt.setStroke(
        1, MaterialColors.getColor(GhostIdeAppLoader.getContext(), ObjectUtils.TvColor, 0));
    return mt;
  }

  private void unzipCompat(String input, String output) {
    AlertDialog dialog =
        new MaterialAlertDialogBuilder(GhostIdeAppLoader.getContext())
            .setTitle("")
            .setPositiveButton("ok", null)
            .setCancelable(false)
            .create();

    dialog.show();

    new Thread(
            new Runnable() {
              @Override
              public void run() {
                Z7Extractor.extractFile(
                    input,
                    output,
                    new com.hzy.lib7z.IExtractCallback() {
                      @Override
                      public void onStart() {
                        dialog.setMessage("Runing..");
                      }

                      @Override
                      public void onGetFileNum(int arg0) {
                        dialog.setTitle(arg0);
                      }

                      @Override
                      public void onProgress(String arg0, long arg1) {
                        ((AppCompatActivity) GhostIdeAppLoader.getContext())
                            .runOnUiThread(
                                new Runnable() {
                                  @Override
                                  public void run() {
                                    //	bar.setProgress((int) arg1);
                                    //	tv.setText(arg0 + " " + arg1);
                                    dialog.setMessage(arg0);
                                  }
                                });
                      }

                      @Override
                      public void onError(int arg0, String arg1) {
                        dialog.setMessage(arg1);
                      }

                      @Override
                      public void onSucceed() {
                        ((AppCompatActivity) GhostIdeAppLoader.getContext())
                            .runOnUiThread(
                                new Runnable() {
                                  @Override
                                  public void run() {
                                    dialog.dismiss();
                                  }
                                });
                      }
                    });
              }
            })
        .start();
  }
}
