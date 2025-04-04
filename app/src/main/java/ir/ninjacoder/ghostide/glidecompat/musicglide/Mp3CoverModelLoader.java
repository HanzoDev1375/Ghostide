package ir.ninjacoder.ghostide.glidecompat.musicglide;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.signature.ObjectKey;

import java.io.InputStream;

public class Mp3CoverModelLoader implements ModelLoader<Mp3CoverModel, Bitmap> {

  @Override
  public LoadData<Bitmap> buildLoadData(
      @NonNull Mp3CoverModel model, int width, int height, @NonNull Options options) {
    Key key = new ObjectKey(model.getFilePath());
    return new LoadData<>(key, new Mp3CoverLoader(model));
  }

  @Override
  public boolean handles(@NonNull Mp3CoverModel model) {
    return model.getFilePath().endsWith(".mp3");
  }
}
