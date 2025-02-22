package ir.ninjacoder.ghostide.model;

import com.google.gson.annotations.SerializedName;

public class ObjectClassName {
  @SerializedName("class_name")
  private String class_name;

  public String getClassName() {
    return class_name;
  }
}
