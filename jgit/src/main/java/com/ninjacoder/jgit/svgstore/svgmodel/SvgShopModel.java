package com.ninjacoder.jgit.svgstore.svgmodel;

import com.google.gson.annotations.SerializedName;

public class SvgShopModel {
  @SerializedName("name")
  private final String name;

  @SerializedName("icon")
  private final String icon;

  public SvgShopModel(String name, String icon) {
    this.name = name;
    this.icon = icon;
  }

  public String getName() {
    return this.name;
  }

  public String getIcon() {
    return this.icon;
  }
}
