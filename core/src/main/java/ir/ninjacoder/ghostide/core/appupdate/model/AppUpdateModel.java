package ir.ninjacoder.ghostide.core.appupdate.model;

import com.google.gson.annotations.SerializedName;

public class AppUpdateModel {
  @SerializedName("title")
  private String title;

  @SerializedName("massges")
  private String massges;

  @SerializedName("version")
  private String version;

  @SerializedName("sizearm32")
  private String sizearm32;

  @SerializedName("linkarm32")
  private String linkarm32;

  @SerializedName("sizearm64")
  private String sizearm64;

  @SerializedName("linkarm64")
  private String linkarm64;

  @SerializedName("appname")
  private String appname;

  public String getTitle() {
    return this.title;
  }

  public String getMassges() {
    return this.massges;
  }

  public String getVersion() {
    return this.version;
  }

  public String getSizearm32() {
    return this.sizearm32;
  }

  public String getLinkarm32() {
    return this.linkarm32;
  }

  public String getSizearm64() {
    return this.sizearm64;
  }

  public String getLinkarm64() {
    return this.linkarm64;
  }

  public String getAppname() {
    return this.appname;
  }
}
