package Ninja.coder.Ghostemane.code.glidecompat;

import Ninja.coder.Ghostemane.code.ApplicationLoader;
import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.glidecompat.BlurTransformation;
import Ninja.coder.Ghostemane.code.utils.ColorAndroid12;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.graphics.pdf.PdfRenderer;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.*;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.blankj.utilcode.util.ThreadUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.caverock.androidsvg.SVG;
import com.google.android.material.color.MaterialColors;
import com.sdsmdg.harjot.vectormaster.VectorMasterDrawable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class GlideCompat {

  public static void GlideNormal(ImageView imageView, String path) {
    Glide.with(imageView.getContext())
        .load(new File(path))
        .placeholder(CircelPrograssBar())
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .priority(Priority.HIGH)
        .error(R.drawable.default_image)
        .transform(new RoundedCornersTransformation(RenderSize()))
        .into(imageView);
  }

  public static void GlideNormal(ImageView imageView, int path) {
    Glide.with(imageView.getContext())
        .load(path)
        .placeholder(CircelPrograssBar())
        .error(R.drawable.default_image)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .priority(Priority.HIGH)
        .transform(new RoundedCornersTransformation(RenderSize()))
        .into(imageView);
  }
  
    

  public static void GlideNormals(ImageView imageView, String path) {
    Glide.with(imageView.getContext())
        .load(new File(path))
        .placeholder(CircelPrograssBar())
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .priority(Priority.HIGH)
        .transform(new RoundedCornersTransformation(0))
        .into(imageView);
  }

  public static void GlideLoadMp3(ImageView img, String path) {
    Log.d("AlbumPic", "Path: " + path);

    new Thread(
            new Runnable() {
              @Override
              public void run() {
                try {
                  MediaMetadataRetriever retriever = new MediaMetadataRetriever();
                  retriever.setDataSource(path);
                  final byte[] art = retriever.getEmbeddedPicture();

                  ThreadUtils.runOnUiThread(
                      new Runnable() {
                        @Override
                        public void run() {
                          Log.d("AlbumPic", "Path: " + path);

                          if (art != null && art.length > 0) {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inSampleSize = 2; // Ajusta según sea necesario
                            Bitmap bitmap =
                                BitmapFactory.decodeByteArray(art, 0, art.length, options);
                            Glide.with(img.getContext())
                                .load(bitmap)
                                .placeholder(CircelPrograssBar())
                                .error(R.drawable.musico)
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .priority(Priority.HIGH)
                                .transform(new RoundedCornersTransformation(RenderSize()))
                                .into(img);
                          } else {
                            img.setImageResource(R.drawable.musico);
                          }
                        }
                      });
                } catch (final Exception e) {
                  ThreadUtils.runOnUiThread(
                      new Runnable() {
                        @Override
                        public void run() {
                          img.setImageResource(R.drawable.musico);
                        }
                      });
                }
              }
            })
        .start();
  }

  public static void GlideNormal(ImageView imageView, File path) {
    Glide.with(imageView.getContext())
        .load(path)
        .placeholder(CircelPrograssBar())
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .priority(Priority.HIGH)
        .error(R.drawable.keyboardlisnertalluserpost_4)
        .transform(new RoundedCornersTransformation(RenderSize()))
        .into(imageView);
  }

  public static void LoadMp4(ImageView imageView, String string) {
    Glide.with(imageView.getContext())
        .load(new File(string))
        .placeholder(CircelPrograssBar())
        .transform(new RoundedCornersTransformation(RenderSize()))
        .priority(Priority.HIGH)
        .error(R.drawable.keyboardlisnertalluserpost_4)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(imageView);
  }

  public static void LoadImage(ImageView imageView, String string, TextView textView) {
    Glide.with(imageView.getContext())
        .load(new File(string))
        .placeholder(CircelPrograssBar())
        .transform(new RoundedCornersTransformation(RenderSize()))
        .priority(Priority.HIGH)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .error(R.drawable.close)
        .into(imageView);
    getSizeImage(string, textView);
  }

  public static void LoadVideo(ImageView imageView, String string, TextView textView) {
    Glide.with(imageView.getContext())
        .load(string)
        .transform(new RoundedCornersTransformation(RenderSize()))
        .error(R.drawable.close)
        .placeholder(CircelPrograssBar())
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .priority(Priority.HIGH)
        .into(imageView);
    textView.setText(getVideoWhich(string).concat(",".concat(getVideohighlights(string))));
  }

  public static Drawable CircelPrograssBar() {
    int[] apl = {
      Color.parseColor("#FFFFB584"),
      Color.parseColor("#FFFF8884"),
      Color.parseColor("#FFDAFF84"),
      Color.parseColor("#FF84FFB1"),
      Color.parseColor("#FF84FFD8"),
      Color.parseColor("#FF84FDFF"),
      Color.parseColor("#FF84D4FF"),
      Color.parseColor("#FF8A84FF"),
      Color.parseColor("#FFB584FF"),
      Color.parseColor("#FFF984FF"),
      Color.parseColor("#FFFF84D6"),
      Color.parseColor("#FFFF84B3")
    };
    CircularProgressDrawable app = new CircularProgressDrawable(ApplicationLoader.getContext());
    app.setStrokeWidth(10f);
    app.setCenterRadius(20f);
    app.setColorSchemeColors(apl);
    app.start();
    return app;
  }

  protected static String getVideoWhich(String d) {
    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
    mediaMetadataRetriever.setDataSource(d);
    return mediaMetadataRetriever.extractMetadata(18);
  }

  protected static String getVideohighlights(String dataBase) {
    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
    mediaMetadataRetriever.setDataSource(dataBase);
    return mediaMetadataRetriever.extractMetadata(19);
  }

  private static final void getSizeImage(String string, TextView textView) {
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(string, options);
    int imageHeight = options.outHeight;
    int imageWidth = options.outWidth;
    textView.setText(String.valueOf(imageWidth).concat("x".concat(String.valueOf(imageHeight))));
  }

  public static void loadImgPdf(File file, ImageView imageView) throws IOException {
    FileInputStream inputStream = new FileInputStream(file);
    try {
      ParcelFileDescriptor fileDescriptor = ParcelFileDescriptor.dup(inputStream.getFD());
      Bitmap bitmap = pdfPageToBitmap(fileDescriptor);
      Glide.with(imageView.getContext())
          .load(bitmap)
          .transform(new RoundedCornersTransformation(RenderSize()))
          .placeholder(CircelPrograssBar())
          .diskCacheStrategy(DiskCacheStrategy.ALL)
          .priority(Priority.HIGH)
          .error(android.R.drawable.gallery_thumb)
          .into(imageView);
    } finally {
      inputStream.close();
    }
  }

  private static Bitmap pdfPageToBitmap(ParcelFileDescriptor fileDescriptor) throws IOException {
    PdfRenderer renderer = new PdfRenderer(fileDescriptor);
    PdfRenderer.Page page = renderer.openPage(0);
    // create a new bitmap with the same dimensions as the page
    Bitmap bitmap = Bitmap.createBitmap(page.getWidth(), page.getHeight(), Bitmap.Config.ARGB_8888);
    page.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);
    page.close();
    renderer.close();
    return bitmap;
  }

  public static void LoadVector(String path, ImageView c) {
    var vx = new VectorMasterDrawable(ApplicationLoader.getContext(), new File(path));
    if (vx.isVector()) {
      vx.setColorFilter(MaterialColors.getColor(c, ColorAndroid12.TvColor), PorterDuff.Mode.SRC_IN);
      Glide.with(c.getContext())
          .load(vx)
          .error(R.drawable.errorxml)
          .transform(new RoundedCornersTransformation(RenderSize()))
          .placeholder(CircelPrograssBar())
          .diskCacheStrategy(DiskCacheStrategy.ALL)
          .priority(Priority.HIGH)
          .into(c);
    } else {
      c.setImageResource(R.drawable.errorxml);
    }
  }

  public static void LoadApkFile(String file, ImageView img) {
    try {
      Glide.with(img.getContext())
          .load(getApkIcon(file, img.getContext()))
          .error(R.drawable.ic_material_android)
          .transform(new RoundedCornersTransformation(RenderSize()))
          .placeholder(CircelPrograssBar())
          .diskCacheStrategy(DiskCacheStrategy.ALL)
          .priority(Priority.HIGH)
          .into(img);
      //      packageInfo = null;
      //      packageManager = null;
    } catch (Exception err) {
      img.setImageResource(R.drawable.ic_material_android);
    }
  }

  public static void LoadApksFile(String file, ImageView img) {
    try {
      Glide.with(img.getContext())
          .load(getIconFromZip(file, img.getContext()))
          .error(R.drawable.ic_material_android)
          .transform(new RoundedCornersTransformation(RenderSize()))
          .placeholder(CircelPrograssBar())
          .diskCacheStrategy(DiskCacheStrategy.ALL)
          .priority(Priority.HIGH)
          .into(img);
    } catch (Exception err) {
      img.setImageResource(R.drawable.ic_material_android);
    }
  }

  public static void LoadSvg(String path, ImageView c) {
    Glide.with(c.getContext())
        .load(loadSvg(path))
        .error(R.drawable.errorxml)
        //       .transform(new RoundedCornersTransformation(RenderSize()))
        .placeholder(CircelPrograssBar())
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .priority(Priority.NORMAL)
        .into(c);
  }

  protected static int RenderSize() {
    return 25;
  }

  protected static Drawable loadSvg(String path) {
    Drawable drawable = null;
    try {
      FileInputStream fileInputStream = new FileInputStream(new File(path));
      SVG svg = SVG.getFromInputStream(fileInputStream);
      drawable = new PictureDrawable(svg.renderToPicture());

    } catch (Exception e) {
      e.printStackTrace();

      //	Toast.makeText(getApplicationContext(), e.toString(), 3000).show();
    }
    return drawable;
  }

  public static void LoadSwbIcon(String file, ImageView v) {
    Glide.with(v.getContext())
        .asBitmap()
        .load(getIconSwbFile(file, "resources/icons/icon.png"))
        .transform(new RoundedCornersTransformation(RenderSize()))
        .error(R.drawable.skproapp_orig)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .priority(Priority.NORMAL)
        .into(v);
  }

  public static Drawable getApkIcon(final String _path, Context context) {
    android.content.pm.PackageManager packageManager = context.getPackageManager();
    android.content.pm.PackageInfo packageInfo = packageManager.getPackageArchiveInfo(_path, 0);
    packageInfo.applicationInfo.sourceDir = _path;
    packageInfo.applicationInfo.publicSourceDir = _path;
    return (packageInfo.applicationInfo.loadIcon(packageManager));
  }

  public static void LoadIconVsCode(String file, ImageView img) {
    var mypath = "extension/icon.png";

    Glide.with(img.getContext())
        .asBitmap()
        .load(getIconSwbFile(file, mypath))
        .transform(new RoundedCornersTransformation(RenderSize()))
        .error(R.drawable.file)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .priority(Priority.NORMAL)
        .into(img);
  }

  protected static Bitmap getIconSwbFile(String zipFilePath, String iconName) {
    Bitmap icon = null;
    ZipFile zipFile = null;

    try {
      zipFile = new ZipFile(zipFilePath);

      ZipEntry entry = zipFile.getEntry(iconName);
      if (entry != null) {
        InputStream inputStream = zipFile.getInputStream(entry);
        icon = BitmapFactory.decodeStream(inputStream);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (zipFile != null) {
        try {
          zipFile.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
    return icon;
  }

  public static void LoadBlurImage(String path, ImageView v) {
    Glide.with(v.getContext())
        .load(path)
        .error(R.drawable.errorxml)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .priority(Priority.NORMAL)
        .transform(new MultiTransformation<>(new BlurTransformation(24)))
        .into(v);
  }

  public static void setDecodeImageForZipFile(String pathFile, String nameIcon, ImageView img) {
    Glide.with(img.getContext())
        .asBitmap()
        .load(decodeBitmapFromZip(pathFile, nameIcon))
        .transform(new RoundedCornersTransformation(RenderSize()))
        .error(R.drawable.ic_material_image)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .priority(Priority.NORMAL)
        .into(img);
  }

  public static void LoadSvgInAsster(String input, ImageView img) {
    try {
      SVG svg = SVG.getFromAsset(img.getContext().getAssets(), input);
      Drawable draw = new PictureDrawable(svg.renderToPicture());
      Glide.with(img.getContext())
          .load(draw)
          .transform(new RoundedCornersTransformation(RenderSize()))
          .error(R.drawable.ic_material_image)
          .diskCacheStrategy(DiskCacheStrategy.ALL)
          .priority(Priority.NORMAL)
          .into(img);
    } catch (Exception err) {

    }
  }

  private static Bitmap decodeBitmapFromZip(String zipFilePath, String entryName) {
    ZipFile zfile = null;
    ZipEntry entry = null;
    InputStream input = null;
    try {
      zfile = new ZipFile(zipFilePath);
      entry = zfile.getEntry(entryName);
      input = zfile.getInputStream(entry);

      Bitmap bitmap = BitmapFactory.decodeStream(input);

      return bitmap;
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (input != null) {
        try {
          input.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (zfile != null) {
        try {
          zfile.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

    return null;
  }

  protected static Drawable getIconFromZip(String zipFilePath, Context context) {
    Drawable icon = null;
    try {
      ZipFile zipFile = new ZipFile(zipFilePath);
      ZipEntry entry = zipFile.getEntry("base.apk");
      if (entry != null) {
        InputStream inputStream = zipFile.getInputStream(entry);
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        android.content.pm.PackageInfo packageInfo =
            packageManager.getPackageArchiveInfo(zipFilePath, PackageManager.GET_ACTIVITIES);
        if (packageInfo != null) {
          ApplicationInfo appInfo = packageInfo.applicationInfo;
          appInfo.sourceDir = zipFilePath;
          appInfo.publicSourceDir = zipFilePath;
          icon = appInfo.loadIcon(packageManager);
        }
        inputStream.close();
      }
      zipFile.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return icon;
  }
}
