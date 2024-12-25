package ir.ninjacoder.ghostide.marco;

import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

/**
 * @param Context context
 * @rem this?
 * @java check null ? : 0 ;
 * @kotiln chack = null
 * @user = ?
 * @java version 11
 */

public class PdfViewCompat {
    /**
     * @Java Chack 11
     */
    public static void runs(String token, ImageView imageView) {
        int pageNumber = 0;
        // تعریف ImageView

        var handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(() -> {
            try {
                // تعریف ParcelFileDescriptor
                ParcelFileDescriptor fileDescriptor = ParcelFileDescriptor.open(new File(token),
                        ParcelFileDescriptor.MODE_READ_ONLY);
                // تعریف PdfRenderer
                PdfRenderer pdfRenderer = new PdfRenderer(fileDescriptor);
                // دریافت صفحه مورد نظر از PdfRenderer به شکل Bitmap
                PdfRenderer.Page page = pdfRenderer.openPage((int) pageNumber);

                Bitmap bitmap = Bitmap.createBitmap(page.getWidth(), page.getHeight(), Bitmap.Config.ARGB_8888);
                page.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);
                page.close();
                // نمایش Bitmap در ImageView
                imageView.setImageBitmap(bitmap);
                // بستن PdfRenderer و ParcelFileDescriptor
                pdfRenderer.close();

                fileDescriptor.close();
            } catch (IOException i) {
                throw new RuntimeException(i.toString());
            }

        }, 200);
    }
}