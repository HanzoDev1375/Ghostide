package com.sdsmdg.harjot.vectormaster;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.model.ModelLoader;
import android.graphics.drawable.Drawable;

public class VectorModelLoaderFactory implements ModelLoaderFactory<VectorModel, Drawable> {

  private final Context context;

  public VectorModelLoaderFactory(Context context) {
    this.context = context;
  }

  @NonNull
  @Override
  public ModelLoader<VectorModel, Drawable> build(@NonNull MultiModelLoaderFactory multiFactory) {
    return new VectorModelLoader(context);
  }

  @Override
  public void teardown() {}
}
