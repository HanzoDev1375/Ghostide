package com.ninjacoder.jgit.diffviews;

import android.content.Context;
import android.graphics.Color;
import com.google.android.material.color.MaterialColors;
import com.ninjacoder.jgit.R;

public class DiffTheme {

  private int addedLineBg = Color.rgb(230, 255, 230);
  private int removedLineBg = Color.rgb(255, 230, 230);
  private int headerLineBg = Color.rgb(240, 240, 255);
  private int contextLineBg = Color.rgb(245, 245, 245);
  private int normalLineBg = Color.WHITE;
  private int lineNumberBg = Color.rgb(250, 250, 250);
  private int addedTextColor = Color.rgb(0, 100, 0);
  private int removedTextColor = Color.rgb(139, 0, 0);
  private int headerTextColor = Color.rgb(0, 0, 139);
  private int contextTextColor = Color.GRAY;
  private int normalTextColor = Color.BLACK;
  private int lineNumberTextColor = Color.GRAY;
  private int separatorColor = Color.LTGRAY;
  private int horizontalLineColor = Color.rgb(240, 240, 240);
  public int getAddedLineBg() {
    return addedLineBg;
  }

  public void setAddedLineBg(int color) {
    this.addedLineBg = color;
  }

  public int getRemovedLineBg() {
    return removedLineBg;
  }

  public void setRemovedLineBg(int color) {
    this.removedLineBg = color;
  }

  public int getHeaderLineBg() {
    return headerLineBg;
  }

  public void setHeaderLineBg(int color) {
    this.headerLineBg = color;
  }

  public int getContextLineBg() {
    return contextLineBg;
  }

  public void setContextLineBg(int color) {
    this.contextLineBg = color;
  }

  public int getNormalLineBg() {
    return normalLineBg;
  }

  public void setNormalLineBg(int color) {
    this.normalLineBg = color;
  }

  public int getLineNumberBg() {
    return lineNumberBg;
  }

  public void setLineNumberBg(int color) {
    this.lineNumberBg = color;
  }

  public int getAddedTextColor() {
    return addedTextColor;
  }

  public void setAddedTextColor(int color) {
    this.addedTextColor = color;
  }

  public int getRemovedTextColor() {
    return removedTextColor;
  }

  public void setRemovedTextColor(int color) {
    this.removedTextColor = color;
  }

  public int getHeaderTextColor() {
    return headerTextColor;
  }

  public void setHeaderTextColor(int color) {
    this.headerTextColor = color;
  }

  public int getContextTextColor() {
    return contextTextColor;
  }

  public void setContextTextColor(int color) {
    this.contextTextColor = color;
  }

  public int getNormalTextColor() {
    return normalTextColor;
  }

  public void setNormalTextColor(int color) {
    this.normalTextColor = color;
  }

  public int getLineNumberTextColor() {
    return lineNumberTextColor;
  }

  public void setLineNumberTextColor(int color) {
    this.lineNumberTextColor = color;
  }

  public int getSeparatorColor() {
    return separatorColor;
  }

  public void setSeparatorColor(int color) {
    this.separatorColor = color;
  }

  public int getHorizontalLineColor() {
    return horizontalLineColor;
  }

  public void setHorizontalLineColor(int color) {
    this.horizontalLineColor = color;
  }

  public void setDarkTheme() {
    normalLineBg = Color.rgb(30, 30, 30);
    addedLineBg = Color.rgb(0, 50, 0);
    removedLineBg = Color.rgb(50, 0, 0);
    headerLineBg = Color.rgb(0, 0, 50);
    contextLineBg = Color.rgb(40, 40, 40);
    lineNumberBg = Color.rgb(50, 50, 50);

    normalTextColor = Color.rgb(220, 220, 220);
    addedTextColor = Color.rgb(100, 255, 100);
    removedTextColor = Color.rgb(255, 100, 100);
    headerTextColor = Color.rgb(100, 100, 255);
    contextTextColor = Color.rgb(150, 150, 150);
    lineNumberTextColor = Color.rgb(180, 180, 180);

    separatorColor = Color.rgb(80, 80, 80);
    horizontalLineColor = Color.rgb(60, 60, 60);
  }

  public void setLightTheme() {
    normalLineBg = Color.WHITE;
    addedLineBg = Color.rgb(230, 255, 230);
    removedLineBg = Color.rgb(255, 230, 230);
    headerLineBg = Color.rgb(240, 240, 255);
    contextLineBg = Color.rgb(245, 245, 245);
    lineNumberBg = Color.rgb(250, 250, 250);

    normalTextColor = Color.BLACK;
    addedTextColor = Color.rgb(0, 100, 0);
    removedTextColor = Color.rgb(139, 0, 0);
    headerTextColor = Color.rgb(0, 0, 139);
    contextTextColor = Color.GRAY;
    lineNumberTextColor = Color.GRAY;

    separatorColor = Color.LTGRAY;
    horizontalLineColor = Color.rgb(240, 240, 240);
  }

  public void setMonokaiTheme() {
    normalLineBg = Color.rgb(39, 40, 34);
    addedLineBg = Color.rgb(56, 76, 42);
    removedLineBg = Color.rgb(76, 42, 42);
    headerLineBg = Color.rgb(42, 42, 76);
    contextLineBg = Color.rgb(50, 50, 48);
    lineNumberBg = Color.rgb(46, 48, 42);

    normalTextColor = Color.rgb(248, 248, 242);
    addedTextColor = Color.rgb(166, 226, 46);
    removedTextColor = Color.rgb(249, 38, 114);
    headerTextColor = Color.rgb(102, 217, 239);
    contextTextColor = Color.rgb(117, 113, 94);
    lineNumberTextColor = Color.rgb(144, 140, 135);

    separatorColor = Color.rgb(62, 62, 58);
    horizontalLineColor = Color.rgb(58, 58, 54);
  }

  public void setGitHubTheme() {
    normalLineBg = Color.WHITE;
    addedLineBg = Color.rgb(230, 255, 237);
    removedLineBg = Color.rgb(255, 238, 240);
    headerLineBg = Color.rgb(241, 248, 255);
    contextLineBg = Color.rgb(250, 251, 252);
    lineNumberBg = Color.rgb(246, 248, 250);

    normalTextColor = Color.rgb(36, 41, 46);
    addedTextColor = Color.rgb(34, 134, 58);
    removedTextColor = Color.rgb(203, 36, 49);
    headerTextColor = Color.rgb(0, 92, 197);
    contextTextColor = Color.rgb(88, 96, 105);
    lineNumberTextColor = Color.rgb(149, 157, 165);

    separatorColor = Color.rgb(225, 228, 232);
    horizontalLineColor = Color.rgb(234, 236, 239);
  }

  public void setDraculaTheme() {
    normalLineBg = Color.rgb(40, 42, 54);
    addedLineBg = Color.rgb(40, 60, 40);
    removedLineBg = Color.rgb(70, 40, 40);
    headerLineBg = Color.rgb(40, 40, 70);
    contextLineBg = Color.rgb(60, 60, 70);
    lineNumberBg = Color.rgb(50, 52, 64);

    normalTextColor = Color.rgb(248, 248, 242);
    addedTextColor = Color.rgb(80, 250, 123);
    removedTextColor = Color.rgb(255, 85, 85);
    headerTextColor = Color.rgb(139, 233, 253);
    contextTextColor = Color.rgb(98, 114, 164);
    lineNumberTextColor = Color.rgb(171, 178, 191);

    separatorColor = Color.rgb(68, 71, 90);
    horizontalLineColor = Color.rgb(58, 60, 76);
  }
  public void applyMaterial3(Context c ){
    normalLineBg = MaterialColors.getColor(c,R.attr.colorSurface,0);
    addedLineBg = Color.rgb(40, 60, 40);
    removedLineBg = Color.rgb(70, 40, 40);
    headerLineBg = Color.rgb(40, 40, 70);
    contextLineBg = Color.rgb(60, 60, 70);
    lineNumberBg = MaterialColors.getColor(c,R.attr.colorSurface,0);

    normalTextColor = MaterialColors.getColor(c,R.attr.colorOnSurface,0);
    addedTextColor = Color.rgb(80, 250, 123);
    removedTextColor = Color.rgb(255, 85, 85);
    headerTextColor = Color.rgb(139, 233, 253);
    contextTextColor = Color.rgb(98, 114, 164);
    lineNumberTextColor = Color.rgb(171, 178, 191);

    separatorColor = Color.TRANSPARENT;
    horizontalLineColor = Color.rgb(58, 60, 76);
  }
}
