package ir.ninjacoder.ghostide.glidecompat.glidejavaparser;

import android.content.Context;
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
    if (result.isInterface()) {
      return ContextCompat.getDrawable(context, R.drawable.interface_dark);
    } else if (result.isClass()) {
      return ContextCompat.getDrawable(context, R.drawable.class_d);
    } else if (result.isAbstract()) {
      return ContextCompat.getDrawable(context, R.drawable.classabstract_dark);
    }else if(result.isEnum() ) {
    	return ContextCompat.getDrawable(context, R.drawable.enum_dark);
    } 
    return ContextCompat.getDrawable(context, request.getDefaultImageRes());
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
