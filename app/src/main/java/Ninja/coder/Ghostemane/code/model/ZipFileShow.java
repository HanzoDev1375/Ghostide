package Ninja.coder.Ghostemane.code.model;

import Ninja.coder.Ghostemane.code.adapter.ZipListFileShowAd;
import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import java.util.ArrayList;
import java.util.Collections;

import java.io.File;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.io.IOException;
import net.lingala.zip4j.progress.ProgressMonitor;

public class ZipFileShow {

  public static void showAsDialog(Context context, String Folder) {
    var tv = new RecyclerView(context);

    var param =
        new RecyclerView.LayoutParams(
            RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.MATCH_PARENT);
    tv.setLayoutParams(param);
    try {
      List<String> listModel = listContentsOfZipFile(Folder);
      tv.setAdapter(new ZipListFileShowAd(listModel));
      tv.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
    } catch (Exception err) {
      err.printStackTrace();
    }
    var dialog = new MaterialAlertDialogBuilder(context);
    dialog.setTitle("ZipFile Show");
    dialog.setView(tv);
    dialog.setPositiveButton(android.R.string.ok, null);
    dialog.show();
  }

  public static void zip(String input, String output, CallBackZip callbackzip) throws Exception {}

  public static void main(String[] args) {
    String inputFilePath = "input.txt";
    String outputZipFilePath = "output.zip";

    try {
      zip(
          inputFilePath,
          outputZipFilePath,
          new CallBackZip() {
            @Override
            public void PercentDone(int percentDone) {
              System.out.println("Percent Done: " + percentDone + "%");
            }

            @Override
            public void FileName(String fileName) {
              System.out.println("Current File: " + fileName);
            }

            @Override
            public void Done() {
              System.out.println("Compression Done!");
            }

            @Override
            public void Error(String message) {
              System.out.println("Error: " + message);
            }

            @Override
            public void Cancelled() {
              System.out.println("Compression Cancelled!");
            }
          });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static interface CallBackZip {
    public void PercentDone(int percentDone);

    public void FileName(String fileName);

    public void Done();

    public void Error(String message);

    public void Cancelled();
  }

  public static List<String> listContentsOfZipFile(String fileName) {
    List<String> contents = new ArrayList<>();
    ZipFile zipFile = null;
    File file = new File(fileName);
    try {
      zipFile = new ZipFile(file);
      Enumeration<? extends ZipEntry> entries = zipFile.entries();
      while (entries.hasMoreElements()) {
        ZipEntry entry = entries.nextElement();
        contents.add(entry.getName());
      }
      zipFile.close();
    } catch (IOException ioException) {
      System.out.println("Error opening zip file" + ioException);
    }
    return contents;
  }
}
