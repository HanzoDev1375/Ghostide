package Ninja.coder.Ghostemane.code.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AssFile {
    public static String All = "";
    private static int vo = 0;

    public static void GetCut(Context context, String in, String out) {

        final ProgressDialog progressDialog = new ProgressDialog(context, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
        Thread copyingThread;

        final Handler mainHandler = new Handler(Looper.getMainLooper());
        GradientDrawable gg = new GradientDrawable();
        gg.setColor(Color.parseColor("#1F1B1C"));
        gg.setCornerRadius(14f);
        gg.setStroke(1, Color.parseColor("#FFB49D"));

        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        progressDialog.setTitle("CutFile ");
        progressDialog.setMessage("Move File please whait...");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.getWindow().setBackgroundDrawable(gg);
        progressDialog.show();

        copyingThread = new Thread(new Runnable() {
            @Override
            public void run() {

                File sourceFile = new File(in);
                File destFile = new File(out);
                FileInputStream fileInputStream;
                FileOutputStream fileOutputStream;
                long length = sourceFile.length();
                int bytesRead;
                int totalBytesRead = 0;
                byte[] buffer = new byte[4 * 1024]; // 4KB buffer
                try {
                    fileInputStream = new java.io.FileInputStream(sourceFile);
                    fileOutputStream = new java.io.FileOutputStream(destFile);

                    while (!Thread.currentThread().isInterrupted()
                            && (bytesRead = fileInputStream.read(buffer)) != -1) {

                        fileOutputStream.write(buffer, 0, bytesRead);

                        totalBytesRead += bytesRead;
                        progressDialog.setMax((int) sourceFile.length());
                        final int fin = (int) (totalBytesRead);

                        mainHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                progressDialog.setProgress(fin);

                            }

                        });
                        if (fin == progressDialog.getMax()) {
                            progressDialog.dismiss();
                            sourceFile.renameTo(destFile);
                            sourceFile.delete();
                        }
                    }

                } catch (Exception e) {
                    System.out.println("foo");
                }
            }

        });
        copyingThread.start();

    }

    public static void GetCopy(Context context, String input, String output) {

        final ProgressDialog progressDialog = new ProgressDialog(context, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
        Thread copyingThread;

        final Handler mainHandler = new Handler(Looper.getMainLooper());
        GradientDrawable gg = new GradientDrawable();
        gg.setColor(Color.parseColor("#1F1B1C"));
        gg.setCornerRadius(14f);
        gg.setStroke(1, Color.parseColor("#FFB49D"));

        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Copy File");
        progressDialog.setMessage("Copying File please....");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.getWindow().setBackgroundDrawable(gg);
        progressDialog.show();

        copyingThread = new Thread(new Runnable() {
            @Override
            public void run() {

                File sourceFile = new File(input);
                File destFile = new File(output);
                FileInputStream fileInputStream;
                FileOutputStream fileOutputStream;
                if (output.isEmpty()) {
                    Toast.makeText(context, "مسیر خالی است", Toast.LENGTH_LONG).show();
                } else {
                    long length = sourceFile.length();
                    int bytesRead;
                    int totalBytesRead = 0;
                    byte[] buffer = new byte[16 * 1024]; // 4KB buffer
                    try {
                        fileInputStream = new FileInputStream(sourceFile);
                        fileOutputStream = new FileOutputStream(destFile);

                        while (!Thread.currentThread().isInterrupted()
                                && (bytesRead = fileInputStream.read(buffer)) != -1) {

                            fileOutputStream.write(buffer, 0, bytesRead);

                            totalBytesRead += bytesRead;
                            progressDialog.setMax((int) sourceFile.length());
                            final int fin = (int) (totalBytesRead);

                            mainHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressDialog.setProgress(fin);

                                }

                            });
                            if (fin == progressDialog.getMax()) {
                                progressDialog.dismiss();
                            }
                        }

                    } catch (IOException e) {
                        Log.e("Error", e.toString());
                    }
                }
            }

        });
        copyingThread.start();

    }

}
