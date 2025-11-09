package ir.ninjacoder.ghostide.core.glidecompat.glidezip;

import androidx.annotation.Nullable;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;

import java.io.InputStream;

import ir.ninjacoder.ghostide.core.glidecompat.glidezip.ZipEntryModel;

public class ZipEntryModelLoader implements ModelLoader<ZipEntryModel, InputStream> {

  @Nullable
  @Override
  public LoadData<InputStream> buildLoadData(
      ZipEntryModel model, int width, int height, Options options) {
    return new LoadData<>(new ObjectKey(model), new ZipEntryFetcher(model));
  }

  @Override
  public boolean handles(ZipEntryModel model) {
    return true;
  }
}
