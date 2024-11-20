package Ninja.coder.Ghostemane.code.marco;

import Ninja.coder.Ghostemane.code.tasks.AsyncTaskCompat;
import Ninja.coder.Ghostemane.code.tasks.app.ProgressDialogCompat;
import Ninja.coder.Ghostemane.code.utils.ObjectUtils;
import Ninja.coder.Ghostemane.code.utils.FileUtil;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class HsiZip extends AsyncTaskCompat<String, Object, Boolean> {

  private Context context;
  private ProgressDialogCompat progressDialog;
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
    MaterialShapeDrawable shap =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder().setAllCorners(CornerFamily.ROUNDED, 19f).build());
    shap.setFillColor(
        ColorStateList.valueOf(MaterialColors.getColor(context, ObjectUtils.Back, Color.BLACK)));
    shap.setStroke(1f, MaterialColors.getColor(context, ObjectUtils.TvColor, Color.RED));
    progressDialog = new ProgressDialogCompat(context);
    progressDialog.setTitle("در حال استخراج فایل");
    progressDialog.setMessage("لطفاً منتظر بمانید...");
    progressDialog.setIndeterminate(false);
    progressDialog.setMax(100);
    progressDialog.getWindow().getDecorView().setBackground(shap);
    progressDialog.setProgressStyle(ProgressDialogCompat.STYLE_HORIZONTAL);
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
    progressDialog.setProgress(progress);
    String filePath = (String) values[1];
    progressDialog.setMessage("در حال استخراج \n " + filePath.trim());
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
