package Ninja.coder.Ghostemane.code.utils;

import Ninja.coder.Ghostemane.code.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.PictureDrawable;
import android.media.MediaMetadataRetriever;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SvgShow {

    protected static GradientDrawable getError = new GradientDrawable();

    public static String nopull(String v) {
        return v;
    }

    public static void GetFileSvg(String input, ImageView img, Context activity, TextView tv1) {
        try {
            File startDir = new File(input);
            FileInputStream fileInputStream = new FileInputStream(startDir);
            SVG svg = SVG.getFromInputStream(fileInputStream);
            final Drawable drawable = new PictureDrawable(svg.renderToPicture());
            Glide.with(activity)
                    .load(drawable)
                    .transition(
                            com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade(
                                    (int) 600))
                    //	.circleCrop()
                    .error(Ninja.coder.Ghostemane.code.R.drawable.close)
                    .diskCacheStrategy(com.bumptech.glide.load.engine.DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH)
                    .into(img);
            infoLog("load");
            if (svg.getDocumentWidth() != 1) {

                tv1.setText(
                        String.valueOf((long) Math.ceil(svg.getDocumentWidth()))
                                .concat(" x ")
                                .concat(String.valueOf((long) Math.ceil(svg.getDocumentHeight()))));
            }

        } catch (IOException | SVGParseException d) {
            d.printStackTrace();
        }
    }

    public static void GetFileSvg(String input, ImageView img, Context activity) {

        try {

            File startDir = new File(input);
            FileInputStream fileInputStream = new FileInputStream(startDir);

            SVG svg = SVG.getFromInputStream(fileInputStream);
            Drawable drawable = new PictureDrawable(svg.renderToPicture());
            Glide.with(activity)
                    .load(drawable)
                    .transition(
                            com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade(
                                    (int) 600))
                    .circleCrop()
                    .error(Ninja.coder.Ghostemane.code.R.drawable.close)
                    .diskCacheStrategy(com.bumptech.glide.load.engine.DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH)
                    .into(img);

        } catch (IOException | SVGParseException d) {
            d.printStackTrace();
        }
    }

    public static void GetAsster(Context context, ImageView img, String input, TextView tv) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ColorStateList.valueOf(Color.parseColor("#FF1F1B1C")));
        gradientDrawable.setStroke(1, ColorStateList.valueOf(Color.parseColor("#FFFFB49D")));
        gradientDrawable.setCornerRadius((float) 30);

        try {

            SVG ss = SVG.getFromAsset(context.getAssets(), input);
            Drawable d = new PictureDrawable(ss.renderToPicture());

            if (ss.getDocumentWidth() != 1) {

                tv.setText(
                        String.valueOf((long) Math.ceil(ss.getDocumentWidth()))
                                .concat(" x ")
                                .concat(String.valueOf((long) Math.ceil(ss.getDocumentHeight()))));
            }
            Glide.with(context).load(d).placeholder(gradientDrawable).into(img);

        } catch (Exception exn) {

            exn.printStackTrace();
        }
    }

    public static void GetAsster(Context context, ImageView img, String input) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ColorStateList.valueOf(Color.parseColor("#FF1F1B1C")));
        gradientDrawable.setStroke(1, ColorStateList.valueOf(Color.parseColor("#FFFFB49D")));
        gradientDrawable.setCornerRadius((float) 30);

        try {

            SVG ss = SVG.getFromAsset(context.getAssets(), input);
            Drawable d = new PictureDrawable(ss.renderToPicture());
            img.setImageDrawable(d);
            //	Glide.with(context).load(d).placeholder(gradientDrawable).into(img);

        } catch (Exception exn) {

            exn.printStackTrace();
        }
    }

    public static void GetRes(Context context, ImageView img, int b) {

        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#FF1F1B1C"));
        gradientDrawable.setStroke(1, ColorStateList.valueOf(Color.parseColor("#FFFFB49D")));
        gradientDrawable.setCornerRadius(21f);

        try {

            SVG svg = SVG.getFromResource(context.getResources(), b);
            Drawable dr = new PictureDrawable(svg.renderToPicture());
            Glide.with(context).load(dr).placeholder(gradientDrawable).into(img);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void Mp3ImageShow(
            String input, ImageView imageView, int ErrorImageTask, Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#FF1F1B1C"));
        gradientDrawable.setStroke(1, ColorStateList.valueOf(Color.parseColor("#FFFFB49D")));
        gradientDrawable.setCornerRadius(21f);

        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();

        mediaMetadataRetriever.setDataSource(input);

        byte[] data = mediaMetadataRetriever.getEmbeddedPicture();

        if (data != null) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
            Glide.with(context).load(bitmap).placeholder(gradientDrawable).into(imageView);

        } else {
            imageView.setImageResource(ErrorImageTask);
        }

        imageView.setAdjustViewBounds(true);
    }

    public static void Mp4Imageview(
            String input, ImageView imageView, int ErrorImageTask, Context context) {
        Bitmap thumb =
                android.media.ThumbnailUtils.createVideoThumbnail(
                        input, android.provider.MediaStore.Images.Thumbnails.MINI_KIND);
        final GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ColorStateList.valueOf(Color.parseColor("#FF1F1B1C")));
        gradientDrawable.setStroke(1, ColorStateList.valueOf(Color.parseColor("#FFFFB49D")));
        gradientDrawable.setCornerRadius(20);
        Glide.with(context)
                .load(thumb)
                .placeholder(gradientDrawable)
                .error(gradientDrawable)
                .into(imageView);
    }

    protected static void Logs(String inputsteam) {
        Log.e("Error" + inputsteam, "SvgFileNotFound");
    }

    protected static void infoLog(String inputsteam) {
        Log.i("info svg " + inputsteam, "not Show def size 24 x 24 up Level");
    }

    public static void ImageShowFormFile(Context context, String input, ImageView imageView) {
        GradientDrawable getPlaceHolder = new GradientDrawable();
        getPlaceHolder.setColor(ColorStateList.valueOf(Color.parseColor("#FF1F1B1C")));
        getPlaceHolder.setStroke(1, ColorStateList.valueOf(Color.parseColor("#FFFFB49D")));
        getPlaceHolder.setCornerRadius((float) 30);

        try {
            Glide.with(context).load(new File(input)).placeholder(getPlaceHolder).into(imageView);

        } catch (Exception full) {

            Toast.makeText(context, "ErrorImage not found".concat(full.toString()), Toast.LENGTH_LONG)
                    .show();
        }
    }

    public static void IconManagerGhostWeb(Activity activity, String StartDir, ImageView imageView) {
        try {
            File file = new File(StartDir);
            InputStream inputStream = new FileInputStream(file);
            SVG svg = SVG.getFromInputStream(inputStream);
            final double dd = svg.getDocumentWidth();
            final double pp = svg.getDocumentHeight();
            if (dd != -1) {
                Bitmap bitmap =
                        Bitmap.createBitmap((int) Math.ceil(dd), (int) Math.ceil(pp), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                canvas.drawColor(0xFFF44336, PorterDuff.Mode.SRC_IN);
                //	bmcanvas.drawRGB(255, 255, 255);
                svg.renderToCanvas(canvas);
                Glide.with(activity)
                        .load(bitmap)
                        .transition(
                                com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade(
                                        (int) 600))
                        //	.circleCrop()
                        .error(R.drawable.close)
                        .diskCacheStrategy(com.bumptech.glide.load.engine.DiskCacheStrategy.ALL)
                        .priority(Priority.HIGH)
                        .into(imageView);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected boolean voi(boolean bor) {
        for (int v = 0; 1 < v; v++) {
            Logs(String.valueOf((int) v));

            if (v >= 0) {
                Logs("cat");
            } else {
                Logs("Dog");
            }
        }
        return bor;
    }

    protected void PutPull(int b, int c, char v, boolean f) {
        f = false;
    }
}
