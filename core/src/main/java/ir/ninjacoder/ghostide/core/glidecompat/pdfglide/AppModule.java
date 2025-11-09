package ir.ninjacoder.ghostide.core.glidecompat.pdfglide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.caverock.androidsvg.SVG;
import com.sdsmdg.harjot.vectormaster.VectorModel;
import com.sdsmdg.harjot.vectormaster.VectorModelLoaderFactory;

import java.io.InputStream;

import ir.ninjacoder.ghostide.core.glidecompat.glideapk.ApkIconLoaderModel;
import ir.ninjacoder.ghostide.core.glidecompat.glideapk.ApkIconModelLoader;
import ir.ninjacoder.ghostide.core.glidecompat.glidejavaparser.CustomImageLoader;
import ir.ninjacoder.ghostide.core.glidecompat.glidejavaparser.CustomImageRequest;
import ir.ninjacoder.ghostide.core.glidecompat.glideres.IconModelLoaderFactory;
import ir.ninjacoder.ghostide.core.glidecompat.glideres.IconRes;
import ir.ninjacoder.ghostide.core.glidecompat.glidesvg.SvgDecoder;
import ir.ninjacoder.ghostide.core.glidecompat.glidesvg.SvgDrawableTranscoder;
import ir.ninjacoder.ghostide.core.glidecompat.glidezip.ZipEntryModel;
import ir.ninjacoder.ghostide.core.glidecompat.glidezip.ZipEntryModelLoaderFactory;
import ir.ninjacoder.ghostide.core.glidecompat.musicglide.Mp3CoverLoaderFactory;
import ir.ninjacoder.ghostide.core.glidecompat.musicglide.Mp3CoverModel;
import ir.ninjacoder.ghostide.core.glidecompat.pdfglide.PdfModelView;

@GlideModule
public class AppModule extends AppGlideModule {
  @Override
  public void registerComponents(
      @NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
    // register your Builder in Module
    // String.class is input and Bitmap.class is the output of ThumbnailBuilder
    registry.prepend(PdfModelView.class, Bitmap.class, new ThumbnailBuilderFactory(context));
    registry.append(Mp3CoverModel.class, Bitmap.class, new Mp3CoverLoaderFactory());
    registry
        .register(SVG.class, PictureDrawable.class, new SvgDrawableTranscoder())
        .append(InputStream.class, SVG.class, new SvgDecoder());
    registry.append(
        ApkIconLoaderModel.class, Drawable.class, new ApkIconModelLoader.Factory(context));
    registry.prepend(IconRes.class, Drawable.class, new IconModelLoaderFactory(context));

    registry.prepend(
        CustomImageRequest.class, Drawable.class, new CustomImageLoader.Factory(context));
    registry.append(VectorModel.class, Drawable.class, new VectorModelLoaderFactory(context));
    registry.append(ZipEntryModel.class, InputStream.class, new ZipEntryModelLoaderFactory()); 
  }
}
