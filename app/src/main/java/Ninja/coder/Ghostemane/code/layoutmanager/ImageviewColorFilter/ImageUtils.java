package Ninja.coder.Ghostemane.code.layoutmanager.ImageviewColorFilter;

import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.SeekBar;
import com.bumptech.glide.Glide;

public class ImageUtils {
    /*
     tnks for -> https://stackoverflow.com/questions/40583564/increase-or-decrease-image-brightness-works-very-slow-using-seekbar
    */
    public static void installEesyImageViewBrightness(ImageView img, SeekBar bar) {
        bar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        Bitmap originalBitmap = ((BitmapDrawable) img.getDrawable()).getBitmap();
                        Bitmap adjustedBitmap = doBrightness(originalBitmap, progress);

                        Glide.with(img.getContext()).load(adjustedBitmap).into(img);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        // Not needed for this implementation
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        // Not needed for this implementation
                    }
                });
    }

    public static Bitmap doBrightness(Bitmap src, int value) {
        // image size
        int width = src.getWidth();

        int height = src.getHeight();
        // create output bitmap
        Bitmap bmOut = Bitmap.createBitmap(width, height, src.getConfig());
        // color information
        int A, R, G, B;
        int pixel;

        // scan through all pixels
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                // get pixel color
                pixel = src.getPixel(x, y);
                A = Color.alpha(pixel);
                R = Color.red(pixel);
                G = Color.green(pixel);
                B = Color.blue(pixel);

                // increase/decrease each channel
                R += value;
                if (R > 255) {
                    R = 255;
                } else if (R < 0) {
                    R = 0;
                }

                G += value;
                if (G > 255) {
                    G = 255;
                } else if (G < 0) {
                    G = 0;
                }

                B += value;
                if (B > 255) {
                    B = 255;
                } else if (B < 0) {
                    B = 0;
                }

                // apply new pixel color to output bitmap
                bmOut.setPixel(x, y, Color.argb(A, R, G, B));
            }
        }

        // return final image
        return bmOut;
    }

    public static Bitmap changeBitmapContrastBrightness(
            Bitmap bmp, float contrast, float brightness) {
        ColorMatrix cm =
                new ColorMatrix(
                        new float[]{
                                contrast,
                                0,
                                0,
                                0,
                                brightness,
                                0,
                                contrast,
                                0,
                                0,
                                brightness,
                                0,
                                0,
                                contrast,
                                0,
                                brightness,
                                0,
                                0,
                                0,
                                1,
                                0
                        });

        Bitmap ret = Bitmap.createBitmap(bmp.getWidth(), bmp.getHeight(), bmp.getConfig());

        Canvas canvas = new Canvas(ret);

        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(cm));
        canvas.drawBitmap(bmp, 0, 0, paint);

        return ret;
    }
}
