package com.ninjacoder.jgit.webstore;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
/**
 * model code by ghost ide
 */
@Keep
public class WebModel {

  @SerializedName("name")
  private String name;

  @SerializedName("url")
  private String url;

  @SerializedName("image")
  private String image;

  @SerializedName("orginalfile")
  private String orginalfile;

  @SerializedName("size")
  private String size;

  public String getName() {
    return this.name;
  }

  public String getUrl() {
    return this.url;
  }

  public String getImage() {
    return this.image;
  }

  public String getOrginalfile() {
    return this.orginalfile;
  }

  public String getSize() {
    return this.size;
  }

  @Override
  public String toString() {
    return "WebModel [name="
        + name
        + ", url="
        + url
        + ", image="
        + image
        + ", orginalfile="
        + orginalfile
        + ", size="
        + size
        + "]";
  }
}
