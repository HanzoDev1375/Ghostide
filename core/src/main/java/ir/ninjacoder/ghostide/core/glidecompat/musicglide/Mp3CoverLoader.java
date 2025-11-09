package ir.ninjacoder.ghostide.core.glidecompat.musicglide;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;

import androidx.annotation.NonNull;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;

import java.io.IOException;

public class Mp3CoverLoader implements DataFetcher<Bitmap> {
  private final Mp3CoverModel model;

  public Mp3CoverLoader(Mp3CoverModel model) {
    this.model = model;
  }

  @Override
  public void loadData(@NonNull Priority priority, @NonNull DataCallback<? super Bitmap> callback) {
    MediaMetadataRetriever retriever = new MediaMetadataRetriever();
    try {
      retriever.setDataSource(model.getFilePath());
      byte[] albumArt = retriever.getEmbeddedPicture();

      if (albumArt != null) {
        Bitmap bitmap = BitmapFactory.decodeByteArray(albumArt, 0, albumArt.length);
        callback.onDataReady(bitmap);
      } else {
        callback.onLoadFailed(new IOException("No cover art found in MP3 file"));
      }
    } catch (Exception e) {
      callback.onLoadFailed(e);
    } finally {
      try {
        retriever.release();
      } catch (IOException e) {
        // ignore release exception
      }
    }
  }

  @Override
  public void cleanup() {
    // منابع را پاکسازی کنید
  }

  @Override
  public void cancel() {
    // در صورت نیاز عملیات را لغو کنید
  }

  @NonNull
  @Override
  public Class<Bitmap> getDataClass() {
    return Bitmap.class;
  }

  @NonNull
  @Override
  public DataSource getDataSource() {
    return DataSource.LOCAL;
  }
}
