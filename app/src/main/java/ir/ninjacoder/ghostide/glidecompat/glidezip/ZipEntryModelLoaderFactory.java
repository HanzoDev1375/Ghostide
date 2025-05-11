package ir.ninjacoder.ghostide.glidecompat.glidezip;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;

public class ZipEntryModelLoaderFactory implements ModelLoaderFactory<ZipEntryModel, InputStream> {

  @NonNull
  @Override
  public ModelLoader<ZipEntryModel, InputStream> build(
      @NonNull MultiModelLoaderFactory multiFactory) {
    return new ZipEntryModelLoader();
  }

  @Override
  public void teardown() {}
}
