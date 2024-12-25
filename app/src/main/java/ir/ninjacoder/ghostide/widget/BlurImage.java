package ir.ninjacoder.ghostide.widget;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;

public class BlurImage {
  public static void Start(View view, Context context, String filePath, float BlureMode) {
    try {
      FileInputStream stream = new FileInputStream(new File(filePath));
      byte[] bytes = new byte[stream.available()];
      stream.read(bytes);
      stream.close();
      Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
      Bitmap bitmapBlur =
          new BlurImage().blur(context, bitmap, BlureMode); // radius should be >0.0F && <= 25.0F
      if (view instanceof ImageView) {
        ImageView imageView = (ImageView) view;
        imageView.setImageBitmap(bitmapBlur);
      } else {
        Drawable drawable = new BitmapDrawable(context.getResources(),bitmapBlur);
        view.setBackgroundDrawable(drawable);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void setBlurInWallpaperMobile(Context context, float blurRadius, View view) {
    try {
      WallpaperManager wallpaperManager = WallpaperManager.getInstance(context);

      if (wallpaperManager == null) {
        return;
      }

      Drawable drawable = wallpaperManager.getDrawable();

      if (drawable == null) {
        return;
      }

      Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
      Bitmap bitMapBlur = new BlurImage().blur(context, bitmap, blurRadius);
      view.setBackground(new BitmapDrawable(context.getResources(), bitMapBlur));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
  
  public static void setBlurInWallpaperMobile(Context context, float blurRadius, ImageView view) {
    try {
      WallpaperManager wallpaperManager = WallpaperManager.getInstance(context);

      if (wallpaperManager == null) {
        return;
      }

      Drawable drawable = wallpaperManager.getDrawable();

      if (drawable == null) {
        return;
      }

      Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
      Bitmap bitMapBlur = new BlurImage().blur(context, bitmap, blurRadius);
      view.setImageDrawable(new BitmapDrawable(context.getResources(), bitMapBlur));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }


  public Bitmap blur(Context context, Bitmap image, float blurRadius) {
    if (null == image) return null;

    Bitmap outputBitmap = Bitmap.createBitmap(image);
    final RenderScript renderScript = RenderScript.create(context);
    Allocation tmpIn = Allocation.createFromBitmap(renderScript, image);
    Allocation tmpOut = Allocation.createFromBitmap(renderScript, outputBitmap);

    // Intrinsic Gausian blur filter
    ScriptIntrinsicBlur theIntrinsic =
        ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
    theIntrinsic.setRadius(blurRadius); // radius should be >0.0F && <= 25.0F
    theIntrinsic.setInput(tmpIn);
    theIntrinsic.forEach(tmpOut);
    tmpOut.copyTo(outputBitmap);
    return outputBitmap;
  }
}
