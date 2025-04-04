package ir.ninjacoder.ghostide.glidecompat.pdfglide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileOutputStream;

public class ThumbnailBuilder implements ModelLoader<PdfModelView, Bitmap> {

    private final Context mContext;

    public ThumbnailBuilder(Context mContext) {
        this.mContext = mContext;
    }

    @Nullable
    @Override
    public LoadData<Bitmap> buildLoadData(@NonNull PdfModelView input, int width, int height, @NonNull Options options) {
        return new LoadData<>(new ObjectKey(input.getPath()), new ThumbnailCreator(mContext, input.getPath()));
    }

    @Override
    public boolean handles(@NonNull PdfModelView input) {
        return input.getPath().endsWith(".pdf".toLowerCase());
    }

    private static class ThumbnailCreator implements DataFetcher<Bitmap> {

        private final String input;

        private final Context mContext;

        public ThumbnailCreator(Context mContext, String input) {
            this.input = input;
            this.mContext = mContext;
        }

        @Override
        public void loadData(@NonNull Priority priority, @NonNull DataCallback<? super Bitmap> callback) {
            try {
                File photoCacheDir = Glide.getPhotoCacheDir(mContext.getApplicationContext());
                File thumbnail = new File(photoCacheDir, Uri.parse(input).getLastPathSegment() + ".png");
                // check if file is already exist then there is no need to re create it
                if (!thumbnail.exists()) {
                    File file = new File(input);
                    ParcelFileDescriptor parcelFileDescriptor = ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY);
                    PdfRenderer pdfRenderer = new PdfRenderer(parcelFileDescriptor);
                    if (pdfRenderer.getPageCount() != 0) {
                        PdfRenderer.Page page = pdfRenderer.openPage(0);
                        Bitmap output = Bitmap.createBitmap(page.getWidth(), page.getHeight(), Bitmap.Config.ARGB_8888);
                        page.render(output, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);
                        page.close();
                        callback.onDataReady(output);
                        // now saving thumbnail on local disc
                        FileOutputStream fileOutputStream = new FileOutputStream(thumbnail);
                        output.compress(Bitmap.CompressFormat.PNG, 80, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    }
                    pdfRenderer.close();
                    parcelFileDescriptor.close();
                } else {
                    callback.onDataReady(BitmapFactory.decodeFile(thumbnail.getAbsolutePath()));
                }
            } catch (Exception e) {
                callback.onLoadFailed(e);
            }
        }

        @Override
        public void cleanup() {
            // empty
        }

        @Override
        public void cancel() {
            // empty
        }

        @NonNull
        @Override
        public Class<Bitmap> getDataClass() {
            // output data class
            return Bitmap.class;
        }

        @NonNull
        @Override
        public DataSource getDataSource() {
            // data source local or network base
            return DataSource.LOCAL;
        }
    }
}
