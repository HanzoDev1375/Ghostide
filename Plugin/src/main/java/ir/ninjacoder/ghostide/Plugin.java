package ir.ninjacoder.ghostide.PluginManager;

import android.os.Build;
import androidx.annotation.NonNull;
import java.io.File;

@ismodule
public class Plugin {
  protected String name;
  protected boolean Enabel;
  protected String id;
  protected File file;
  protected PluginFactory f;
  public Plugin(){}

  public Plugin(String name, boolean Enabel, PluginFactory f) {
    this.name = name;
    this.Enabel = Enabel;
    this.f = f;
  }

  public Plugin(String name, String id, File file, PluginFactory f) {
    this.name = name;
    this.id = id;
    this.file = file;
    this.f = f;
  }

  public Plugin(String name, boolean Enabel, String id, File file, PluginFactory f) {
    this.name = name;
    this.Enabel = Enabel;
    this.id = id;
    this.file = file;
    this.f = f;
  }

  public Plugin(String name, boolean Enabel) {
    this.name = name;
    this.Enabel = Enabel;
  }

  @isField(api = Build.VERSION_CODES.KITKAT)
  public void setCallBack(PluginFactory f) {
    this.f = f;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
    f.getName(name, Enabel);
  }

  public boolean getEnabel() {
    return this.Enabel;
  }

  public void setEnabel(boolean Enabel) {
    this.Enabel = Enabel;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public File getFile() {
    return this.file;
  }

  public void setFile(File file) {
    this.file = file;
  }
}
