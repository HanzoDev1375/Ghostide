package io.github.rosemoe.sora.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;

/** Line icon line number code by ninja coder * */
public class LineIcon {
  public int iconRes;
  public int lineNumber;
  public int colorFilter;
  @Deprecated public String iconFilePath;
  public Bitmap bitmap;
  public boolean hasIconFilePath;

  public LineIcon(int lineNumber, int colorFilter, String iconFilePath, boolean hasIconFilePath) {
    this.lineNumber = lineNumber;
    this.colorFilter = colorFilter;
    this.iconFilePath = iconFilePath;
    this.hasIconFilePath = hasIconFilePath;
  }

  public LineIcon(int lineNumber, int colorFilter,@NonNull Bitmap bitmap, boolean hasIconFilePath) {
    this.lineNumber = lineNumber;
    this.colorFilter = colorFilter;
    this.iconFilePath = iconFilePath;
    this.bitmap = bitmap;
  }

  public LineIcon(int iconRes, int lineNumber) {
    this.iconRes = iconRes;
    this.lineNumber = lineNumber;
  }

  public int getIconRes() {
    return this.iconRes;
  }

  public int getLineNumber() {
    return this.lineNumber;
  }

  public int getColorFilter() {
    return this.colorFilter;
  }

  @Deprecated
  public String getIconFilePath() {
    return this.iconFilePath;
  }

  @Deprecated
  public boolean getHasIconFilePath() {
    return this.hasIconFilePath;
  }

  public Bitmap getBitmap() {
    return this.bitmap;
  }

  public void setBitmap(Bitmap bitmap) {
    this.bitmap = bitmap;
  }
}
