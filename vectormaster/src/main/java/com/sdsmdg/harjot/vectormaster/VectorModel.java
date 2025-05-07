package com.sdsmdg.harjot.vectormaster;

import android.content.Context;
import java.io.File;

public class VectorModel {
  private final File file;
  private final Context context;

  public VectorModel(File file, Context context) {
    this.file = file;
    this.context = context;
  }

  public File getFile() {
    return this.file;
  }

  public Context getContext() {
    return this.context;
  }
}
