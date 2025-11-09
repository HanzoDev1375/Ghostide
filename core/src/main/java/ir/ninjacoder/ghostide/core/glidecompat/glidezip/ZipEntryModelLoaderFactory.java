package ir.ninjacoder.ghostide.core.glidecompat.glidezip;

import androidx.annotation.NonNull;

import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;

import java.io.InputStream;

import ir.ninjacoder.ghostide.core.glidecompat.glidezip.ZipEntryModel;
import ir.ninjacoder.ghostide.core.glidecompat.glidezip.ZipEntryModelLoader;

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
