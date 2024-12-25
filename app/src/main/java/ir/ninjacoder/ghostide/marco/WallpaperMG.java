package ir.ninjacoder.ghostide.marco;

import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

/**
 * code by ninja coder
 * using Ghost web ide
 */

public class WallpaperMG {

    public static void home(AppCompatActivity compat, String path) {
        WallpaperManager manager = WallpaperManager.getInstance(compat);
        try {
            manager.setBitmap(BitmapFactory.decodeFile((path)));
        } catch (IOException e) {
            Toast.makeText(compat, e.getMessage(), 2).show();
        }
    }

    public static void lock(AppCompatActivity compat, String path) {
        WallpaperManager manager = WallpaperManager.getInstance(compat);
        try {
            manager.setBitmap(BitmapFactory.decodeFile(path), null, true, manager.FLAG_LOCK);
        } catch (IOException e) {
            Toast.makeText(compat, e.getMessage(), 2).show();
        }
    }

    /**
     * 	<uses-permission android:name="android.permission.SET_WALLPAPER" />
     <uses-permission android:name="android.permission.SET_WALLPAPER_COMPONENT" />
     <uses-permission android:name="android.permission.SET_WALLPAPER_HINTS" />
     */
}
