package ninjacoder.ghostide.androidtools.r8.android;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BackgroundUtil {

  public static void saveSystemWallpaper(Context context) {
    WallpaperManager wallpaperManager = WallpaperManager.getInstance(context);

    // دریافت Drawable پس‌زمینه سیستمی
    Drawable wallpaperDrawable = wallpaperManager.getDrawable();

    if (wallpaperDrawable != null) {
      // تبدیل Drawable به Bitmap
      Bitmap wallpaperBitmap =
          Bitmap.createBitmap(
              wallpaperDrawable.getIntrinsicWidth(),
              wallpaperDrawable.getIntrinsicHeight(),
              Bitmap.Config.ARGB_8888);

      // رسم Drawable بر روی Bitmap
      wallpaperDrawable.setBounds(0, 0, wallpaperBitmap.getWidth(), wallpaperBitmap.getHeight());
      wallpaperDrawable.draw(new Canvas(wallpaperBitmap));

      // ذخیره پس‌زمینه در مسیر دلخواه
      saveBitmapToFile(context, wallpaperBitmap);
    }
  }

  private static void saveBitmapToFile(Context context, Bitmap bitmap) {
    // مسیر ذخیره فایل
    String directoryPath =
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            .getAbsolutePath();
    String fileName = "system_wallpaper.png";
    File file = new File(directoryPath, fileName);

    FileOutputStream fos = null;
    try {
      fos = new FileOutputStream(file);
      bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
      fos.flush();
      fos.close();

      // اعلام موفقیت ذخیره سازی
      // می‌توانید از اینجا یک پیام Toast یا Log برای نمایش پیام استفاده کنید
      // Toast.makeText(context, "پس‌زمینه سیستمی با موفقیت ذخیره شد: " + file.getAbsolutePath(),
      // Toast.LENGTH_LONG).show();
    } catch (IOException e) {
      e.printStackTrace();
      // اعلام خطا در صورت شکست ذخیره سازی
      // می‌توانید از اینجا یک پیام Toast یا Log برای نمایش پیام استفاده کنید
      // Toast.makeText(context, "خطا در ذخیره سازی پس‌زمینه سیستمی", Toast.LENGTH_SHORT).show();
    } finally {
      try {
        if (fos != null) {
          fos.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
