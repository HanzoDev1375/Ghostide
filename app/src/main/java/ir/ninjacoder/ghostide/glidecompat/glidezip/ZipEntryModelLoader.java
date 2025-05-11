package ir.ninjacoder.ghostide.glidecompat.glidezip;

import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;
import com.bumptech.glide.signature.ObjectKey;

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
