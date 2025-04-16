package ir.ninjacoder.ghostide.glidecompat.glidejavaparser;

import android.content.Context;
import com.bumptech.glide.load.Options;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;

public class CustomImageLoader implements ModelLoader<CustomImageRequest, Drawable> {
  private final Context context;

  public CustomImageLoader(Context context) {
    this.context = context;
  }

  @Override
  public LoadData<Drawable> buildLoadData(
      CustomImageRequest request, int width, int height, Options options) {
    return new LoadData<>(
        new ObjectKey(request.getJavaFile()), new CustomImageDataFetcher(context, request));
  }

  @Override
  public boolean handles(CustomImageRequest request) {
    return request.getJavaFile().getName().endsWith(".java");
  }

  public static class Factory implements ModelLoaderFactory<CustomImageRequest, Drawable> {
    private final Context context;

    public Factory(Context context) {
      this.context = context;
    }

    @Override
    public ModelLoader<CustomImageRequest, Drawable> build(MultiModelLoaderFactory multiFactory) {
      return new CustomImageLoader(context);
    }

    @Override
    public void teardown() {}
  }
}
