package ir.ninjacoder.ghostide.model;

import com.google.gson.annotations.SerializedName;

/**
 * ساخته شده توسط نینجا کدر این کلاس برای دریافت نسخه جدید مستقیم از گیت هاب هست لطفا تغییری در ان
 * ایجاد کنید نکنید اگر جاوا نمیدانید
 */
public class AppUpload {

  @SerializedName("appname")
  private String appName;

  @SerializedName("sizearm32")
  private String sizeArm32;

  @SerializedName("sizearm64")
  private String sizeArm64;

  @SerializedName("title")
  private String title;

  @SerializedName("linkarm32")
  private String linkArm32;

  @SerializedName("linkarm64")
  private String linkArm64;

  @SerializedName("showbar")
  private boolean showBar;

  // Getter برای هر فیلد
  public String getAppName() {
    return appName;
  }

  public String getSizeArm32() {
    return sizeArm32;
  }

  public String getSizeArm64() {
    return sizeArm64;
  }

  public String getTitle() {
    return title;
  }

  public String getLinkArm32() {
    return linkArm32;
  }

  public String getLinkArm64() {
    return linkArm64;
  }

  public boolean isShowBar() {
    return showBar;
  }
}
