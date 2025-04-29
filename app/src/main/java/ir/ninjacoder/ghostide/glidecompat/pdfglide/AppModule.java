package ir.ninjacoder.ghostide.glidecompat.pdfglide;

import android.content.Context;
import android.graphics.Bitmap;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import ir.ninjacoder.ghostide.glidecompat.glideapk.ApkIconLoaderModel;
import android.graphics.drawable.Drawable;
import ir.ninjacoder.ghostide.glidecompat.glideapk.ApkIconModelLoader;
import ir.ninjacoder.ghostide.glidecompat.glidejavaparser.CustomImageLoader;
import ir.ninjacoder.ghostide.glidecompat.glidejavaparser.CustomImageRequest;
import ir.ninjacoder.ghostide.glidecompat.glideres.IconRes;
import ir.ninjacoder.ghostide.glidecompat.glideres.IconModelLoaderFactory;
import ir.ninjacoder.ghostide.glidecompat.musicglide.Mp3CoverLoaderFactory;
import ir.ninjacoder.ghostide.glidecompat.musicglide.Mp3CoverModel;
import java.io.InputStream;
import com.caverock.androidsvg.SVG;
import ir.ninjacoder.ghostide.glidecompat.glidesvg.SvgDecoder;
import android.graphics.drawable.PictureDrawable;
import ir.ninjacoder.ghostide.glidecompat.glidesvg.SvgDrawableTranscoder;

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

  }
}
