package ir.ninjacoder.ghostide.core.model;

import com.google.gson.annotations.SerializedName;

public class ObjectClassName {
  @SerializedName("class_name")
  private String class_name;

  @SerializedName("full_package")
  private String full_package;

  public String getClassName() {
    return class_name;
  }

  public String getFull_package() {
    return full_package;
  }
}
