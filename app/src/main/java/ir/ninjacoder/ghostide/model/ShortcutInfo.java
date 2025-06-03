package ir.ninjacoder.ghostide.model;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import androidx.annotation.NonNull;

public abstract class ShortcutInfo implements Parcelable {
  private String mId;
  private CharSequence mName;
  private int mIcon;

  public ShortcutInfo() {}

  protected ShortcutInfo(Parcel in) {
    mName = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
    mIcon = in.readInt();
  }

  public String getId() {
    return mId;
  }

  public void setId(String id) {
    mId = id;
  }

  public CharSequence getName() {
    return mName;
  }

  public void setName(CharSequence name) {
    mName = name;
  }

  public int getIcon() {
    return mIcon;
  }

  public void setIcon(int icon) {
    mIcon = icon;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(@NonNull Parcel dest, int flags) {
    TextUtils.writeToParcel(mName, dest, flags);
    dest.writeInt(mIcon);
  }

  public abstract Intent toShortcutIntent(@NonNull Context context);
}
