package ir.ninjacoder.ghostide.glidecompat.glidejavaparser;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import com.bumptech.glide.Priority;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.load.data.DataFetcher;
import ir.ninjacoder.ghostide.R;

public class CustomImageDataFetcher implements DataFetcher<Drawable> {
  private final Context context;
  private final CustomImageRequest request;

  public CustomImageDataFetcher(Context context, CustomImageRequest request) {
    this.context = context;
    this.request = request;
  }

  @Override
  public void loadData(Priority priority, DataCallback<? super Drawable> callback) {
    try {
      JavaAnalysisResult result = request.getAnalyzer().analyze(request.getJavaFile());
      Drawable drawable = resolveImage(result);
      callback.onDataReady(drawable);
    } catch (Exception e) {
      callback.onLoadFailed(e);
    }
  }

  private Drawable resolveImage(JavaAnalysisResult result) {
    Drawable drawable;
    if (result.isAndroidViews()) {
      drawable = ContextCompat.getDrawable(context, R.drawable.androidviewclass);
    } else if (result.isJavaStandardClass()) {
      drawable = ContextCompat.getDrawable(context, R.drawable.javaclass);
    } else if (result.isJavaClass()) {
      drawable = ContextCompat.getDrawable(context, R.drawable.class_java);
    } else if (result.isAndroidClass()) {
      drawable = ContextCompat.getDrawable(context, R.drawable.class_android);
    } else if (result.isFragmentClass()) {
      drawable = ContextCompat.getDrawable(context, R.drawable.fragment_class);
    } else if (result.isGenericClass()) {
      drawable = ContextCompat.getDrawable(context, R.drawable.genericclass);
    } else if (result.isAbstractException()) {
      drawable = ContextCompat.getDrawable(context, R.drawable.abstractexceptiondark);
    } else if (result.isAbstract()) {
      drawable = ContextCompat.getDrawable(context, R.drawable.classabstract_dark);
    } else if (result.isInterface()) {
      drawable = ContextCompat.getDrawable(context, R.drawable.interface_dark);
    } else if (result.isInner()) {
      drawable = ContextCompat.getDrawable(context, R.drawable.modelclass_dark);
    } else if (result.isEnum()) {
      drawable = ContextCompat.getDrawable(context, R.drawable.enum_dark);
    } else if (result.isAnnotation()) {
      drawable = ContextCompat.getDrawable(context, R.drawable.annotationdark);
    } else if (result.isClass()) {
      drawable = ContextCompat.getDrawable(context, R.drawable.class_d);
    } else {
      drawable = ContextCompat.getDrawable(context, request.getDefaultImageRes());
    }

    return drawable;
  }

  @Override
  public void cleanup() {}

  @Override
  public void cancel() {}

  @Override
  public Class<Drawable> getDataClass() {
    return Drawable.class;
  }

  @Override
  public DataSource getDataSource() {
    return DataSource.LOCAL;
  }
}
