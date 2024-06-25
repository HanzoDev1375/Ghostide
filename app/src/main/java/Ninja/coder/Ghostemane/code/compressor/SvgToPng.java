package Ninja.coder.Ghostemane.code.compressor;

import Ninja.coder.Ghostemane.code.tasks.AsyncTaskCompat;
import Ninja.coder.Ghostemane.code.tasks.app.ProgressDialogCompat;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Picture;
import android.net.Uri;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class SvgToPng extends AsyncTaskCompat<Void, Void, Void> {
    private Context context;
    private File svgFile;
    private File pngFile;
    private ProgressDialogCompat progressDialog;
    private OnConversionListener listener;
    private float width = -1f;
    private float height = -1f;
    private int backgroundColor = Color.parseColor("#FF281D1B");

    public SvgToPng(Context context, File svgFile, File pngFile, OnConversionListener listener) {
        this.context = context;
        this.svgFile = svgFile;
        this.listener = listener;
        this.pngFile = pngFile;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setBackgroundColor(int color) {
        this.backgroundColor = color;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        MaterialShapeDrawable mshap = new MaterialShapeDrawable(
                ShapeAppearanceModel.builder().setAllCorners(CornerFamily.CUT, 20f).build());
        progressDialog = new ProgressDialogCompat(context, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
        progressDialog.setMessage("Converting SVG to PNG...");
        progressDialog.setCancelable(false);
        mshap.setFillColor(ColorStateList.valueOf(this.backgroundColor));
        mshap.setStroke(1f, Color.parseColor("#FFFFBB8E"));
        progressDialog.getWindow().getDecorView().setBackground(mshap);
        progressDialog.show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            convertToPng(context, svgFile, pngFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        if (listener != null) {
            if (pngFile.exists()) {
                listener.onConversionSuccess();
            } else {
                listener.onConversionError("Error converting SVG to PNG.");
            }
        }
    }

    public void convertToPng(Context context, File svgFile, File pngFile) throws SVGParseException, IOException {
        SVG svg = SVG.getFromInputStream(context.getContentResolver().openInputStream(Uri.fromFile(svgFile)));
        float svgWidth = svg.getDocumentWidth();
        float svgHeight = svg.getDocumentHeight();
        if (this.width > 0 && this.height > 0) {
            svgWidth = this.width;
            svgHeight = this.height;
        }
        Picture picture = svg.renderToPicture((int) svgWidth, (int) svgHeight);
        Bitmap bitmap = Bitmap.createBitmap(picture.getWidth(), picture.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawPicture(picture);
        try (FileOutputStream outputStream = new FileOutputStream(pngFile)) {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public interface OnConversionListener {
        void onConversionSuccess();

        void onConversionError(String error);
    }
}
