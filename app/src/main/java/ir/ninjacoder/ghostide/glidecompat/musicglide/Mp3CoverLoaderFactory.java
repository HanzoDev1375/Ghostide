package ir.ninjacoder.ghostide.glidecompat.musicglide;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;

public class Mp3CoverLoaderFactory implements ModelLoaderFactory<Mp3CoverModel, Bitmap> {
  @NonNull
  @Override
  public ModelLoader<Mp3CoverModel, Bitmap> build(@NonNull MultiModelLoaderFactory multiFactory) {
    return new Mp3CoverModelLoader();
  }

  @Override
  public void teardown() {
    // منابع را پاکسازی کنید
  }
}
