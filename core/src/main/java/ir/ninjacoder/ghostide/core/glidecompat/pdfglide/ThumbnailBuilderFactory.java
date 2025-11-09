package ir.ninjacoder.ghostide.core.glidecompat.pdfglide;

import android.content.Context;
import android.graphics.Bitmap;

import androidx.annotation.NonNull;

import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;

import ir.ninjacoder.ghostide.core.glidecompat.pdfglide.PdfModelView;

/** Second step create ThumbnailBuilderFactory */
public class ThumbnailBuilderFactory implements ModelLoaderFactory<PdfModelView, Bitmap> {
  /** {@link Context} that pass to {@link ThumbnailBuilder} class */
  private final Context mContext;

  public ThumbnailBuilderFactory(Context mContext) {
    this.mContext = mContext;
  }

  @NonNull
  @Override
  public ModelLoader<PdfModelView, Bitmap> build(@NonNull MultiModelLoaderFactory multiFactory) {
    return new ThumbnailBuilder(mContext);
  }

  @Override
  public void teardown() {
    // empty

  }
}
