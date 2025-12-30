package ir.ninjacoder.ghostide.core.config;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AppIconManager {

  public AppCompatActivity appcompat;
  public int position;

  public AppIconManager(AppCompatActivity appcompat, int position) {
    this.appcompat = appcompat;
    this.position = position;
  }

  public void setIconManager() {
    switch (position) {
      case 0:
        normal();
        break;
      case 1:
        blue();
        break;
      case 2:
        black();
        break;
      case 3:
        red();
        break;
      case 4:
        yellow();
        break;
      case 5:
        pop();
        break;
      case 6:
        greenHell();
        break;
      case 7:
        blueSky();
        break;
      case 8:
        ghost();
        break;
      case 9:
        mtgreen();
        break;
      case 10:
        mtpaper();
        break;
      case 11:
        mtred();
        break;
      case 12:
        fourseasons();
        break;
      case 13:
        ice();
        break;
      case 14:
        glass();
        break;
      case 15:
        fire();
        break;
    }
  }

  // Methods to enable/disable specific components based on icon color

  void red() {
    sub("MainActivityred");
    DataUtil.showMessage(appcompat, "ENABLED ICON - RED");
  }

  void fourseasons() {
    sub("MainActivityfourseasons");
  }

  void ice() {
    sub("MainActivityghosticonice");
  }

  void glass() {
    sub("MainActivityghosticonglass");
  }

  void fire() {
    sub("MainActivityghosticonfire");
  }

  void yellow() {
    sub("MainActivityyellow");
    DataUtil.showMessage(appcompat, "ENABLED ICON - YELLOW");
  }

  void pop() {
    sub("MainActivitypap");
    DataUtil.showMessage(appcompat, "ENABLED ICON - POP");
  }

  void greenHell() {
    sub("MainActivitygreenhell");
    DataUtil.showMessage(appcompat, "ENABLED ICON - GREENHELL");
  }

  void blueSky() {
    sub("MainActivitybluesky");
    DataUtil.showMessage(appcompat, "ENABLED ICON - BLUE SKY MOD");
  }

  void normal() {
    sub("MainActivity");
    DataUtil.showMessage(appcompat, "ENABLED ICON - DEFAULT");
  }

  void blue() {
    sub("MainActivityblue");
    DataUtil.showMessage(appcompat, "ENABLED ICON - BLUE");
  }

  void black() {
    sub("MainActivityblack");
    DataUtil.showMessage(appcompat, "ENABLED ICON - BLACK");
  }

  void ghost() {
    sub("MainActivityghost");
    DataUtil.showMessage(appcompat, "ENABLED ICON - GHOST");
  }

  void mtgreen() {
    sub("MainActivitygreenmt");
    DataUtil.showMessage(appcompat, "ENABLED ICON - Material Green");
  }

  void mtpaper() {
    sub("MainActivitypapmt");
    DataUtil.showMessage(appcompat, "ENABLED ICON - Material Papaer");
  }

  void mtred() {
    sub("MainActivityrednmt");
    DataUtil.showMessage(appcompat, "ENABLED ICON - Material Red");
  }

  void sub(String name) {
    disableAllComponentsExcept(name);
    enableComponent(name);
    restartApp();
  }
  private void disableAllComponentsExcept(String componentNameToEnable) {
    PackageManager manager = appcompat.getPackageManager();
    String[] componentNames = {
      "MainActivity",
      "MainActivityblue",
      "MainActivityblack",
      "MainActivityred",
      "MainActivityyellow",
      "MainActivitypap",
      "MainActivitygreenhell",
      "MainActivitybluesky",
      "MainActivityghost",
      "MainActivitygreenmt",
      "MainActivitypapmt",
      "MainActivityrednmt",
      "MainActivityghosticonfire",
      "MainActivityghosticonglass",
      "MainActivityghosticonice",
      "MainActivityfourseasons"
    };

    for (String componentName : componentNames) {
      if (!componentName.equals(componentNameToEnable)) {
        manager.setComponentEnabledSetting(
            new ComponentName(appcompat, "ir.ninjacoder.ghostide." + componentName),
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP);
      }
    }
  }

  private void enableComponent(String componentName) {
    PackageManager manager = appcompat.getPackageManager();
    manager.setComponentEnabledSetting(
        new ComponentName(appcompat, "ir.ninjacoder.ghostide." + componentName),
        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
        PackageManager.DONT_KILL_APP);
  }

  private void restartApp() {
    var pm = appcompat.getPackageManager();
    var intent = pm.getLaunchIntentForPackage(appcompat.getPackageName());
    if (intent != null) {
      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
      appcompat.startActivity(intent);
      appcompat.finish();
      Runtime.getRuntime().exit(0);
    }
  }

  // Inner class for displaying toast messages
  class DataUtil {
    public static void showMessage(AppCompatActivity app, String message) {
      Toast.makeText(app, message, Toast.LENGTH_SHORT).show();
    }
  }
}
