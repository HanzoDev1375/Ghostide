package com.sdsmdg.harjot.vectormaster;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.SimpleResource;
import com.sdsmdg.harjot.vectormaster.VectorMasterDrawable;

import java.io.File;
import java.io.IOException;

public class VectorMasterDecoder implements ResourceDecoder<VectorModel, Drawable> {

  private Context context;
  int defaultImageResId;

  public VectorMasterDecoder(Context context, int defaultImageResId) {
    this.context = context;
    this.defaultImageResId = defaultImageResId;
  }

  @Override
  public boolean handles(VectorModel source, Options options) {
    return source.getFile().getName().endsWith(".xml");
  }

  @Override
  public Resource<Drawable> decode(VectorModel source, int width, int height, Options options)
      throws IOException {
    Context context = source.getContext();
    File file = source.getFile();
    VectorMasterDrawable drawable = new VectorMasterDrawable(context, file);
    drawable.setUseLegacyParser(false);
    if (drawable.isVector()) {
      return new SimpleResource<>(drawable);
    } else return getDefaultImageResource();
  }

  private Resource<Drawable> getDefaultImageResource() {
    Drawable defaultDrawable = context.getResources().getDrawable(defaultImageResId, null);
    return new SimpleResource<>(defaultDrawable);
  }
}
