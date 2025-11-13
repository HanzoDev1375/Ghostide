package ir.ninjacoder.ghostide.core.model;

import com.google.gson.annotations.SerializedName;

public class PlModel {

  @SerializedName("name")
  private String name;

  @SerializedName("dir")
  private String dir;

  @SerializedName("dev")
  private String dev;

  @SerializedName("isusing")
  private Boolean isusing;

  @SerializedName("type")
  private String type;

  public PlModel(String name, String dir, String dev, Boolean isusing, String type) {
    this.name = name;
    this.dir = dir;
    this.dev = dev;
    this.isusing = isusing;
    this.type = type;
  }

  public String getName() {
    return this.name;
  }

  public String getDir() {
    return this.dir;
  }

  public String getDev() {
    return this.dev;
  }

  public Boolean getIsusing() {
    return this.isusing;
  }

  public String getType() {
    return this.type;
  }

  @Override
  public String toString() {
    return "PlModel [name="
        + name
        + ", dir="
        + dir
        + ", dev="
        + dev
        + ", isusing="
        + isusing
        + ", type="
        + type
        + "]";
  }

  public void setIsusing(Boolean isusing) {
    this.isusing = isusing;
  }
}
