package com.sdsmdg.harjot.vectormaster;

import android.content.Context;
import com.bumptech.glide.load.Options;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;


public class VectorModelLoader implements ModelLoader<VectorModel, Drawable> {

    private final Context context;

    public VectorModelLoader(Context context) {
        this.context = context;
    }

    @Override
    public boolean handles(@NonNull VectorModel model) {
        return true;
    }

    @Nullable
    @Override
    public LoadData<Drawable> buildLoadData(@NonNull VectorModel model, int width, int height, @NonNull Options options) {
        return new LoadData<>(new ObjectKey(model), new VectorModelFetcher(model, context));
    }
}
