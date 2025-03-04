package ir.ninjacoder.ghostide.marco;

import ir.ninjacoder.ghostide.tasks.AsyncTaskCompat;
import android.content.Context;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import ir.ninjacoder.prograsssheet.PrograssSheet;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class HsiZip extends AsyncTaskCompat<String, Object, Boolean> {

  private Context context;
  private PrograssSheet progressDialog;
  private String destDirectory = "";
  private OnCallBack call;

  public HsiZip(Context context, OnCallBack call) {
    this.context = context;
    this.call = call;
  }

  public interface OnCallBack {
    public void onResult();

    public void onError();
  }

  @Override
  protected void onPreExecute() {
    super.onPreExecute();
    progressDialog = new PrograssSheet(context);
    progressDialog.setTitle("Loading...");
    progressDialog.setCancelable(false);
    progressDialog.show();

  }

  @Override
  protected Boolean doInBackground(String... params) {
    String zipFilePath = params[0];
    destDirectory = params[1];

    // ساخت شیء ZipInputStream
    ZipInputStream zipIn = null;
    try {
      zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
      long totalBytes = new File(zipFilePath).length();
      long extractedBytes = 0;
      byte[] buffer = new byte[4096];
      int readBytes;

      // خواندن و استخراج فایل‌ها از ZIP
      ZipEntry entry = zipIn.getNextEntry();
      while (entry != null) {
        String filePath = destDirectory + File.separator + entry.getName();
        if (!entry.isDirectory()) {
          extractFile(zipIn, filePath, buffer);
          extractedBytes += entry.getCompressedSize();
          int progress = (int) ((extractedBytes * 100) / totalBytes);
          publishProgress(progress, filePath);
        } else {
          File dir = new File(filePath);
          dir.mkdirs();
        }
        zipIn.closeEntry();
        entry = zipIn.getNextEntry();
      }
      zipIn.close();
      return true;
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }

  // استخراج فایل‌ها
  private void extractFile(ZipInputStream zipIn, String filePath, byte[] buffer)
      throws IOException {
    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
    int readBytes;
    while ((readBytes = zipIn.read(buffer)) != -1) {
      bos.write(buffer, 0, readBytes);
    }
    bos.flush();
    bos.close();
  }

  @Override
  protected void onProgressUpdate(Object... values) {
    int progress = (int) values[0];
    progressDialog.setPrograss(progress,false);
    String filePath = (String) values[1];
    progressDialog.setTitle("UnZip file -> " + filePath.trim());
  }

  @Override
  protected void onPostExecute(Boolean result) {
    progressDialog.dismiss();
    if (result) {
      // نمایش پیغام موفقیت
      Dialoginit("Done", "saved for " + destDirectory.toLowerCase().trim());
      call.onResult();
    } else {
      // نمایش پیغام خطا
      Dialoginit("Error", "");
      call.onError();
    }
  }

  private void Dialoginit(CharSequence title, CharSequence msg) {
    new MaterialAlertDialogBuilder(context)
        .setTitle(title)
        .setMessage(msg)
        .setPositiveButton("ok", null)
        .show();
  }
}
