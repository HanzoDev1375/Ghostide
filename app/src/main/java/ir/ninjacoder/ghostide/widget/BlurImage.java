package ir.ninjacoder.ghostide.widget;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import ir.ninjacoder.ghostide.glidecompat.GlideCompat;
import java.io.File;
import java.io.FileInputStream;

public class BlurImage {
    private static final String TAG = "BlurImage";
    
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
                Drawable drawable = new BitmapDrawable(context.getResources(), bitmapBlur);
                view.setBackgroundDrawable(drawable);
            }
        } catch (Exception e) {
            Log.e(TAG, "Error in Start method: " + e.getMessage());
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
        } catch (SecurityException e) {
            Log.w(TAG, "Permission denied for wallpaper access: " + e.getMessage());
            
            view.setBackgroundColor(0); 
        } catch (Exception e) {
            Log.e(TAG, "Error in setBlurInWallpaperMobile: " + e.getMessage());
            view.setBackgroundColor(0); 
        }
    }

    public static void setBlurInWallpaperMobile(Context context, float blurRadius, ImageView view) {
        try {
            SharedPreferences getvb = context.getSharedPreferences("getvb", Context.MODE_PRIVATE);
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
            
            String imagePath = getvb.getString("dir", "");
            if (imagePath.endsWith(".gif")) {
                Glide.with(context)
                        .asGif()
                        .load(imagePath)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .error(new BitmapDrawable(context.getResources(), bitMapBlur))
                        .into(view);
            } else {
                Glide.with(context)
                        .load(imagePath)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .error(new BitmapDrawable(context.getResources(), bitMapBlur))
                        .into(view);
            }
        } catch (SecurityException e) {
            Log.w(TAG, "Permission denied for wallpaper access: " + e.getMessage());
            // Fallback: استفاده از تصویر پیش‌فرض یا رنگ
            handleFallback(context, view);
        } catch (Exception e) {
            Log.e(TAG, "Error in setBlurInWallpaperMobile for ImageView: " + e.getMessage());
            handleFallback(context, view);
        }
    }

    private static void handleFallback(Context context, ImageView view) {
        try {
            SharedPreferences getvb = context.getSharedPreferences("getvb", Context.MODE_PRIVATE);
            String imagePath = getvb.getString("dir", "");
            
            if (imagePath != null && !imagePath.isEmpty()) {
                if (imagePath.endsWith(".gif")) {
                    Glide.with(context)
                            .asGif()
                            .load(imagePath)
                            .diskCacheStrategy(DiskCacheStrategy.NONE)
                            .into(view);
                } else {
                    Glide.with(context)
                            .load(imagePath)
                            .diskCacheStrategy(DiskCacheStrategy.NONE)
                            .into(view);
                }
            } else {
                view.setBackgroundColor(0);
            }
        } catch (Exception e) {
            Log.e(TAG, "Error in fallback handling: " + e.getMessage());
            view.setBackgroundColor(0);
        }
    }

    public Bitmap blur(Context context, Bitmap image, float blurRadius) {
        if (null == image) return null;

        try {
            Bitmap outputBitmap = Bitmap.createBitmap(image);
            final RenderScript renderScript = RenderScript.create(context);
            Allocation tmpIn = Allocation.createFromBitmap(renderScript, image);
            Allocation tmpOut = Allocation.createFromBitmap(renderScript, outputBitmap);

            // Intrinsic Gausian blur filter
            ScriptIntrinsicBlur theIntrinsic =
                    ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
            theIntrinsic.setRadius(Math.min(Math.max(blurRadius, 0.1f), 25.0f));
            theIntrinsic.setInput(tmpIn);
            theIntrinsic.forEach(tmpOut);
            tmpOut.copyTo(outputBitmap);
            renderScript.destroy();
            return outputBitmap;
        } catch (Exception e) {
            Log.e(TAG, "Error in blur method: " + e.getMessage());
            return image; 
        }
    }
}