package Ninja.coder.Ghostemane.code.databin;

import Ninja.coder.Ghostemane.code.PluginManager.*;
import Ninja.coder.Ghostemane.code.PluginManager.PluginFactory;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.material.switchmaterial.SwitchMaterial;

@ismodule
public class TermuxUtils extends Plugin implements PluginFactory {

  private Context context;

  public TermuxUtils(Context context) {
    this.context = context;
    setCallBack(this);
    setName("TermixUtils");
  }

  public void setTermuxPackage(SharedPreferences sh, SwitchMaterial swi, String key) {
    if (sh != null) {
      swi.setChecked(sh.contains(key));
    }
  }

  public String getInstallPython3() {
    return "pkg upg \n pkg install python3";
  }

  public String getInstallRuby() {
    return "pkg upg \n pkg install ruby";
  }

  public String getPkgDir() {
    return "/data/data/com.termux/files/home/bin/pkg";
  }

  @Override
  public void getName(String name, boolean show) {
    // TODO: Implement this method
  }
}
