package ir.ninjacoder.ghostide.databin;

import android.content.Context;
import java.io.File;
import android.os.ParcelFileDescriptor;
import android.graphics.pdf.PdfRenderer;
import android.graphics.Bitmap;
import java.io.FileOutputStream;
import java.io.IOException;
import android.os.Handler;
import android.os.Looper;
import ir.ninjacoder.prograsssheet.PrograssSheet;
import ir.ninjacoder.prograsssheet.enums.StateMod;

public class PdfToPng {

  static int data = 0;

  public static void savePdfCoverToDirectory(
      String pdfFilePath, String outputDirectoryPath, Context c) {
    var dialog = new PrograssSheet(c);
    dialog.setMode(StateMod.PROGRASSV);
    dialog.setTitle("Loading...");
    dialog.setCancelable(false);
    dialog.show();
    new Thread(
            () -> {
              try {
                File pdfFile = new File(pdfFilePath);
                ParcelFileDescriptor parcelFileDescriptor =
                    ParcelFileDescriptor.open(pdfFile, ParcelFileDescriptor.MODE_READ_ONLY);
                PdfRenderer pdfRenderer = new PdfRenderer(parcelFileDescriptor);
                dialog.getPrograssBar().setMax(pdfRenderer.getPageCount());

                // Especifica o diretorio de saida
                File outputDirectory = new File(outputDirectoryPath);
                if (!outputDirectory.exists()) {
                  outputDirectory.mkdirs();
                }

                // Loop through all pages

                for (int i = 0; i < pdfRenderer.getPageCount(); i++) {
                  PdfRenderer.Page page = pdfRenderer.openPage(i);
                  data = i;
                  runUi(
                      new Runnable() {

                        @Override
                        public void run() {
                          dialog.setPrograss(data + 1, false);

                          dialog.setTitle("Save Page " + data + 1);
                        }
                      });
                  Bitmap bitmap =
                      Bitmap.createBitmap(
                          page.getWidth(), page.getHeight(), Bitmap.Config.ARGB_8888);
                  page.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);

                  File outputFile =
                      new File(outputDirectory, pdfFilePath + "page_" + (i + 1) + ".png");

                  try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
                  } catch (IOException e) {
                    e.printStackTrace();
                  }

                  page.close();
                }

                pdfRenderer.close();
                parcelFileDescriptor.close();
                dialog.dismiss();
              } catch (Exception e) {
                e.printStackTrace();
              }
            })
        .start();
  }

  static void runUi(Runnable r) {
    new Handler(Looper.getMainLooper()).post(r);
  }
}
