package ir.ninjacoder.ghostide.marco;

import ir.ninjacoder.ghostide.tasks.AsyncTaskCompat;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class HsiPost extends AsyncTaskCompat<String, Object, Boolean> {

    public static final int TYPE_FILE = 1;
    public static final int TYPE_FOLDER = 2;
    private long totalBytes = 0;
    private long compressedBytes = 0;
    private String compressedPath = "";

    private ArrayList<String> filesList = new ArrayList<>();

    private Context context;
    private ProgressDialog progressDialog;

    public HsiPost(Context context) {
        this.context = context;

    }

    public static Activity getActivity(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("درحال استخراج صبر ");
        progressDialog.setCancelable(false);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = 150;
        layoutParams.height = 100;
        progressDialog.getWindow().setAttributes(layoutParams);
        ProgressBar progressBar = progressDialog.findViewById(android.R.id.progress);
        if (progressBar != null) {
            progressBar.getProgressDrawable().setColorFilter(ObjectUtils.TvColor, PorterDuff.Mode.SRC_IN);
        }
        progressDialog.setMessage("Ziping..");
        Animation fadeOut = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                animation = AnimationUtils.loadAnimation(context, android.R.anim.fade_out);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        progressDialog.getWindow().getDecorView().startAnimation(fadeOut);

        TextView textView = progressDialog.findViewById(android.R.id.message);
        if (textView != null) {
            textView.setTextColor(Color.BLUE);
        }
        progressDialog.getWindow().setBackgroundDrawable(initColor());
        progressDialog.setButton(ProgressDialog.BUTTON_POSITIVE, "لغو عملیات", (dialog, which) -> {
            dialog.dismiss();
            HsiPost.this.cancel(true);
        });

        progressDialog.show();
    }

    @Override
    protected Boolean doInBackground(String... params) {
        String sourcePath = params[0];
        String zipPath = params[1];
        int type = Integer.parseInt(params[2]);

        // ساخت شیء ZipOutputStream
        ZipOutputStream zipOut = null;
        try {
            zipOut = new ZipOutputStream(new FileOutputStream(zipPath));
            if (type == TYPE_FILE) {
                File fileToZip = new File(sourcePath);

                // Compress file
                compressFile(fileToZip, zipOut);
                compressedPath = zipPath != null ? zipPath : ""; // Set compressed file path as 'compressedPath'
            } else if (type == TYPE_FOLDER) {
                File folderToZip = new File(sourcePath);

                // Calculate size of files inside folder
                totalBytes = calculateFolderSize(folderToZip);
                compressedBytes = 0;

                // Compress files inside folder
                compressFolder(folderToZip, zipOut, "", totalBytes, compressedBytes);
                compressedPath = zipPath != null ? zipPath : ""; // Set compressed folder path as 'compressedPath'
            }
            zipOut.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void compressFile(File file, ZipOutputStream zipOut) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        ZipEntry zipEntry = new ZipEntry(file.getName());
        zipOut.putNextEntry(zipEntry);
        byte[] buffer = new byte[4096];
        int readBytes;
        while ((readBytes = fis.read(buffer)) != -1) {
            zipOut.write(buffer, 0, readBytes);
            compressedBytes += readBytes;

            int progress = (int) ((compressedBytes * 100) / totalBytes);
            publishProgress(file.getAbsolutePath(), progress);

        }
        fis.close();
    }

    private long calculateFolderSize(File directory) {
        long length = 0;
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                length += file.length();
            } else {
                length += calculateFolderSize(file);
            }
        }
        return length;
    }

    private void compressFolder(File directory, ZipOutputStream zipOut, String path, long totalBytes,
                                long compressedBytes) throws IOException {
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                FileInputStream fis = new FileInputStream(file);
                ZipEntry zipEntry = new ZipEntry(path + file.getName());
                zipOut.putNextEntry(zipEntry);
                byte[] buffer = new byte[4096];
                int readBytes;
                while ((readBytes = fis.read(buffer)) != -1) {
                    zipOut.write(buffer, 0, readBytes);
                    compressedBytes += readBytes;
                    int progress = (int) ((compressedBytes * 100) / totalBytes);
                    publishProgress(file.getAbsolutePath(), progress);

                }
                fis.close();
                //		fileNames[fileNames.length - 1] = file.getName(); // Add the filename to the array
            } else {
                String subPath = path + file.getName() + "/";
                compressFolder(file, zipOut, subPath, totalBytes, compressedBytes);
            }
        }
    }

    @Override
    protected void onProgressUpdate(Object... progress) {
        String filepath = (String) progress[0];
        int percent = (int) progress[1];
        progressDialog.setMessage(filepath + "\n");
        progressDialog.setTitle("استخراج " + " -> " + percent);
        progressDialog.setProgress(percent);
    }

    @Override
    protected void onPostExecute(Boolean result) {
        super.onPostExecute(result);

        progressDialog.dismiss();
        if (result) {
            //	Toast.makeText(context, "فایل با موفقیت فشرده شد.\n", Toast.LENGTH_SHORT).show();
            Dialoginit(mr("UnZiped", Color.GREEN), mr("Done", Color.GREEN));
        } else {
            //	Toast.makeText(context, "خطا در فشرده‌سازی فایل.", Toast.LENGTH_SHORT).show();
            Dialoginit(mr("Error", Color.RED), mr("Error not Zip File", Color.GRAY));
        }
    }

    private GradientDrawable initColor() {
        GradientDrawable g = new GradientDrawable();
        g.setColor(ColorStateList.valueOf(ObjectUtils.Back));
        g.setStroke(1, ColorStateList.valueOf(ObjectUtils.TvColor));
        g.setCornerRadius(25f);
        return g;
    }

    private void Dialoginit(CharSequence title, CharSequence msg) {

        MaterialAlertDialogBuilder dialogBuilder = new MaterialAlertDialogBuilder(context);
        dialogBuilder.setTitle(title);
        dialogBuilder.setMessage(msg);
        dialogBuilder.setBackground(initColor());
        dialogBuilder.setPositiveButton("ok", null);
        dialogBuilder.show();

    }

    public String mr(String titles, int Colorz) {
        SpannableStringBuilder title = new SpannableStringBuilder(titles);
        title.setSpan(new ForegroundColorSpan(Colorz), 0, title.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return titles;
    }

}
