package ir.ninjacoder.ghostide.glidecompat.glideres;

import android.content.Context;

public class IconRes {
  private int resId;
  private Context context;

  public IconRes(int resId, Context context) {
    this.resId = resId;
    this.context = context;
  }

  public int getResId() {
    return this.resId;
  }

  public void setResId(int resId) {
    this.resId = resId;
  }

  public Context getContext() {
    return this.context;
  }

  public void setContext(Context context) {
    this.context = context;
  }
}
