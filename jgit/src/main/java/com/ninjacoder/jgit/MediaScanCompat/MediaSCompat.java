package com.ninjacoder.jgit.MediaScanCompat;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import android.database.Cursor;
import android.provider.MediaStore;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;



public class MediaSCompat {
  
  
  protected static final List<String> allMedia = new ArrayList<>();

  public static void trytoUsingCustom(String path, AppCompatActivity app) {
    StringBuilder builder = new StringBuilder();
    List<String> files = ScanImage(app);
    List<String> video = ScanVideo(app);
    List<String> audio = ScanAudio(app);
    builder.append(String.valueOf(files.size())).append(" Images").append("\n");
    builder.append(String.valueOf(video.size())).append(" Video").append("\n");
    builder.append(String.valueOf(audio.size())).append(" Audio").append("\n");
    builder.append(String.valueOf(allMedia.size())).append(" AllFiles").append("\n");

    path = builder.toString();
  }

  public static List<String> ScanImage(AppCompatActivity compat) {
    List<String> data = new ArrayList<>();
    String[] projectPath = {MediaStore.Images.Media.DATA};
    Cursor cursor =
        compat
            .getContentResolver()
            .query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, projectPath, null, null, null);
    if (cursor != null) {
      int index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
      while (cursor.moveToNext()) {
        data.add(cursor.getString(index));
        allMedia.add(cursor.getString(index));
      }
      cursor.close();
    }
    return data;
  }

  public static List<String> ScanVideo(AppCompatActivity compat) {
    List<String> data = new ArrayList<>();
    String[] projectPath = {MediaStore.Video.Media.DATA};
    Cursor cursor =
        compat
            .getContentResolver()
            .query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, projectPath, null, null, null);
    if (cursor != null) {
      int index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
      while (cursor.moveToNext()) {
        data.add(cursor.getString(index));
        allMedia.add(cursor.getString(index));
      }
      cursor.close();
    }
    return data;
  }

  public static List<String> ScanAudio(AppCompatActivity compat) {
    List<String> data = new ArrayList<>();
    String[] projectPath = {MediaStore.Audio.Media.DATA};
    Cursor cursor =
        compat
            .getContentResolver()
            .query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, projectPath, null, null, null);
    if (cursor != null) {
      int index = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA);
      while (cursor.moveToNext()) {
        data.add(cursor.getString(index));
        allMedia.add(cursor.getString(index));
      }
      cursor.close();
    }
    return data;
  }

  public String getVideoReleaseDate(Context context) {
    ContentResolver contentResolver = context.getContentResolver();
    String[] projection = {MediaStore.Video.Media.DATE_ADDED};
    String data = MediaStore.Video.Media.EXTERNAL_CONTENT_URI.toString();

    Cursor cursor = contentResolver.query(Uri.parse(data), projection, null, null, null);
    if (cursor != null) {
      try {
        if (cursor.moveToFirst()) {
          String releaseDate =
              cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATE_ADDED));
          return releaseDate;
        }
      } finally {
        cursor.close();
      }
    }
    return null;
  }
  
}
