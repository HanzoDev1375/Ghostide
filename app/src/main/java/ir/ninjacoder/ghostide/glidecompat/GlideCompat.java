package ir.ninjacoder.ghostide.glidecompat;

import android.net.Uri;
import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import ir.ninjacoder.ghostide.R;
import ir.ninjacoder.ghostide.glidecompat.glideapk.ApkIconLoaderModel;
import ir.ninjacoder.ghostide.glidecompat.glidejavaparser.CustomImageRequest;
import ir.ninjacoder.ghostide.glidecompat.glidejavaparser.JavaParserAnalyzer;
import ir.ninjacoder.ghostide.glidecompat.musicglide.Mp3CoverModel;
import ir.ninjacoder.ghostide.glidecompat.pdfglide.PdfModelView;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.media.MediaMetadataRetriever;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.MultiTransformation;
import com.caverock.androidsvg.SVG;
import com.google.android.material.color.MaterialColors;
import com.sdsmdg.harjot.vectormaster.VectorMasterDrawable;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class GlideCompat {

  public static void GlideNormal(ImageView imageView, String path) {
    Glide.with(imageView.getContext())
        .load(new File(path))
        .placeholder(CircelPrograssBar())
        .error(R.drawable.ic_material_csharp)
        .transform(new RoundedCornersTransformation(RenderSize()))
        .into(imageView);
  }

  public static void GlideNormalUrl(ImageView imageView, String path) {
    Glide.with(imageView.getContext())
        .load(Uri.parse(path))
        .placeholder(CircelPrograssBar())
        .error(R.drawable.ic_material_csharp)
        // .transform(new RoundedCornersTransformation(RenderSize()))
        .into(imageView);
  }

  public static void GlideNormal(ImageView imageView, int path) {
    Glide.with(imageView.getContext())
        .load(path)
        .placeholder(CircelPrograssBar())
        .error(R.drawable.default_image)
        .transform(new RoundedCornersTransformation(RenderSize()))
        .into(imageView);
  }

  public static void GlideNormals(ImageView imageView, String path) {
    Glide.with(imageView.getContext())
        .load(new File(path))
        .placeholder(CircelPrograssBar())
        .transform(new RoundedCornersTransformation(0))
        .into(imageView);
  }

  public static void GlideLoadMp3(ImageView img, String path) {
    Glide.with(img.getContext())
        .load(new Mp3CoverModel(path))
        .placeholder(CircelPrograssBar())
        .error(R.drawable.ic_material_audio)
        .transform(new RoundedCornersTransformation(RenderSize()))
        .into(img);
  }

  public static void GlideNormal(ImageView imageView, File path) {
    Glide.with(imageView.getContext())
        .load(path)
        .placeholder(CircelPrograssBar())
        .error(R.drawable.keyboardlisnertalluserpost_4)
        .transform(new RoundedCornersTransformation(RenderSize()))
        .into(imageView);
  }

  public static void LoadMp4(ImageView imageView, String string) {
    Glide.with(imageView.getContext())
        .load(new File(string))
        .placeholder(CircelPrograssBar())
        .transform(new RoundedCornersTransformation(RenderSize()))
        .error(R.drawable.keyboardlisnertalluserpost_4)
        .into(imageView);
  }

  public static void LoadImage(ImageView imageView, String string, TextView textView) {
    Glide.with(imageView.getContext())
        .load(new File(string))
        .placeholder(CircelPrograssBar())
        .transform(new RoundedCornersTransformation(RenderSize()))
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
    CircularProgressDrawable app = new CircularProgressDrawable(GhostIdeAppLoader.getContext());
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

  public static void loadImgPdf(String path, ImageView img) {
    Glide.with(img.getContext())
        .load(new PdfModelView(path))
        .placeholder(CircelPrograssBar())
        .error(R.drawable.ic_material_pdf)
        .transform(new RoundedCornersTransformation(RenderSize()))
        .into(img);
  }

  public static void LoadVector(String path, ImageView c) {
    var vx = new VectorMasterDrawable(GhostIdeAppLoader.getContext(), new File(path));
    if (vx.isVector()) {
      vx.setColorFilter(MaterialColors.getColor(c, ObjectUtils.TvColor), PorterDuff.Mode.SRC_IN);
      Glide.with(c.getContext())
          .load(vx)
          .error(R.drawable.errorxml)
          .transform(new RoundedCornersTransformation(RenderSize()))
          .placeholder(CircelPrograssBar())
          .into(c);
    } else {
      c.setImageResource(R.drawable.errorxml);
    }
  }

  public static void LoadApkFile(String file, ImageView img) {
    try {
      Glide.with(img.getContext())
          .load(new ApkIconLoaderModel(file))
          .error(R.drawable.ic_material_android)
          .transform(new RoundedCornersTransformation(RenderSize()))
          .placeholder(CircelPrograssBar())
          .into(img);
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
          .into(img);
    } catch (Exception err) {
      img.setImageResource(R.drawable.ic_material_android);
    }
  }

  protected static int RenderSize() {
    return 25;
  }

  public static void LoadSvg(String path, ImageView c) {
    Glide.with(c.getContext())
        .load(path)
        .error(R.drawable.errorxml)
        .placeholder(CircelPrograssBar())
        .into(c);
  }

  public static void LoadIconTheme(String file, ImageView v) {
    Glide.with(v.getContext())
        .asBitmap()
        .load(getIconSwbFile(file, "icon.png"))
        .transform(new RoundedCornersTransformation(RenderSize()))
        .error(R.drawable.file)
        .priority(Priority.NORMAL)
        .into(v);
  }

  public static void setLoadJavaModel(ImageView img, File file) {
    CustomImageRequest request =
        new CustomImageRequest(
            file,
            R.drawable.ic_material_java,
            new JavaParserAnalyzer());
    Glide.with(img.getContext())
        .load(request)
        .placeholder(CircelPrograssBar())
        .error(R.drawable.ic_material_java)
        .into(img);
  }

  public static void LoadIconVsCode(String file, ImageView img) {
    var mypath = "extension/icon.png";

    Glide.with(img.getContext())
        .asBitmap()
        .load(getIconSwbFile(file, mypath))
        .transform(new RoundedCornersTransformation(RenderSize()))
        .error(R.drawable.file)
        .priority(Priority.NORMAL)
        .into(img);
  }

  public static Bitmap getIconSwbFile(String zipFilePath, String iconName) {
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
          .placeholder(CircelPrograssBar())
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
