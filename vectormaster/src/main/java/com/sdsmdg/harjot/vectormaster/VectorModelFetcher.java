package com.sdsmdg.harjot.vectormaster;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;

public class VectorModelFetcher implements DataFetcher<Drawable> {

  private final VectorModel model;
  private final Context context;

  public VectorModelFetcher(VectorModel model, Context context) {
    this.model = model;
    this.context = context;
  }

  @Override
  public void loadData(
      @NonNull Priority priority, @NonNull DataCallback<? super Drawable> callback) {
    try {
      VectorMasterDrawable drawable = new VectorMasterDrawable(context, model.getFile());
      if (drawable.isVector()) {
        callback.onDataReady(drawable);
      } else {
        callback.onLoadFailed(new Exception("Not a valid vector drawable."));
      }
    } catch (Exception e) {
      callback.onLoadFailed(e);
    }
  }

  @Override
  public void cleanup() {}

  @Override
  public void cancel() {}

  @NonNull
  @Override
  public Class<Drawable> getDataClass() {
    return Drawable.class;
  }

  @NonNull
  @Override
  public DataSource getDataSource() {
    return DataSource.LOCAL;
  }
}
