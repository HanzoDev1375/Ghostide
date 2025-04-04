package ir.ninjacoder.ghostide.glidecompat.glideapk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;

public class ApkIconModelLoader implements ModelLoader<ApkIconLoaderModel, Drawable> {
  private final Context context;

  public ApkIconModelLoader(Context context) {
    this.context = context;
  }

  @Override
  public LoadData<Drawable> buildLoadData(
      @NonNull ApkIconLoaderModel model, int width, int height, @NonNull Options options) {
    return new LoadData<>(new ObjectKey(model.getApkPath()), new ApkIconFetcher(model, context));
  }

  @Override
  public boolean handles(@NonNull ApkIconLoaderModel model) {
    return model.getApkPath().endsWith(".apk");
  }

  public static class Factory implements ModelLoaderFactory<ApkIconLoaderModel, Drawable> {
    private final Context context;

    public Factory(Context context) {
      this.context = context;
    }

    @NonNull
    @Override
    public ModelLoader<ApkIconLoaderModel, Drawable> build(
        @NonNull MultiModelLoaderFactory multiFactory) {
      return new ApkIconModelLoader(context);
    }

    @Override
    public void teardown() {
      // هیچ عملیاتی نیاز نیست
    }
  }
}
