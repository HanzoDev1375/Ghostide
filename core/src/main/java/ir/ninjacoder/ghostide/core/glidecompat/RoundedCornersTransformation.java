package ir.ninjacoder.ghostide.core.glidecompat;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class RoundedCornersTransformation extends BitmapTransformation {
    private static final String ID = "com.example.RoundedCornersTransformation";
    private static final byte[] ID_BYTES = ID.getBytes(CHARSET);
    private int cornerRadius;
  

    public RoundedCornersTransformation(int cornerRadius) {
        this.cornerRadius = cornerRadius;
    }

    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        Bitmap transformed = TransformationUtils.centerCrop(pool, toTransform, outWidth, outHeight);
        Bitmap bitmap = pool.get(outWidth, outHeight, Bitmap.Config.ARGB_8888);

        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(outWidth, outHeight, Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(new BitmapShader(transformed, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));

        RectF rect = new RectF(0.0f, 0.0f, outWidth, outHeight);
        canvas.drawRoundRect(rect, cornerRadius, cornerRadius, paint);

        return bitmap;
    }

    @Override
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);

        byte[] radiusData = ByteBuffer.allocate(4).putInt(cornerRadius).array();
        messageDigest.update(radiusData);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof RoundedCornersTransformation) {
            RoundedCornersTransformation other = (RoundedCornersTransformation) o;
            return cornerRadius == other.cornerRadius;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return ID.hashCode() + cornerRadius * 10;
    }
}
