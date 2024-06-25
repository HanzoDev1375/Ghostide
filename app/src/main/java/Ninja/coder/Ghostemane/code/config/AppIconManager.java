package Ninja.coder.Ghostemane.code.config;

import android.content.ComponentName;
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
    }
  }

  // Methods to enable/disable specific components based on icon color

  void red() {
    disableAllComponentsExcept("MainActivityred");
    enableComponent("MainActivityred");
    DataUtil.showMessage(appcompat, "ENABLED ICON - RED");
  }

  void yellow() {
    disableAllComponentsExcept("MainActivityyellow");
    enableComponent("MainActivityyellow");
    DataUtil.showMessage(appcompat, "ENABLED ICON - YELLOW");
  }

  void pop() {
    disableAllComponentsExcept("MainActivitypap");
    enableComponent("MainActivitypap");
    DataUtil.showMessage(appcompat, "ENABLED ICON - POP");
  }

  void greenHell() {
    disableAllComponentsExcept("MainActivitygreenhell");
    enableComponent("MainActivitygreenhell");
    DataUtil.showMessage(appcompat, "ENABLED ICON - GREENHELL");
  }

  void blueSky() {
    disableAllComponentsExcept("MainActivitybluesky");
    enableComponent("MainActivitybluesky");
    DataUtil.showMessage(appcompat, "ENABLED ICON - BLUE SKY MOD");
  }

  void normal() {
    disableAllComponentsExcept("MainActivity");
    enableComponent("MainActivity");
    DataUtil.showMessage(appcompat, "ENABLED ICON - DEFAULT");
  }

  void blue() {
    disableAllComponentsExcept("MainActivityblue");
    enableComponent("MainActivityblue");
    DataUtil.showMessage(appcompat, "ENABLED ICON - BLUE");
  }

  void black() {
    disableAllComponentsExcept("MainActivityblack");
    enableComponent("MainActivityblack");
    DataUtil.showMessage(appcompat, "ENABLED ICON - BLACK");
  }

  // Helper methods

  private void disableAllComponentsExcept(String componentNameToEnable) {
    PackageManager manager = appcompat.getPackageManager();
    String[] componentNames = {
      "MainActivity", "MainActivityblue", "MainActivityblack", "MainActivityred",
      "MainActivityyellow", "MainActivitypap", "MainActivitygreenhell", "MainActivitybluesky"
    };

    for (String componentName : componentNames) {
      if (!componentName.equals(componentNameToEnable)) {
        manager.setComponentEnabledSetting(
            new ComponentName(appcompat, "Ninja.coder.Ghostemane.code." + componentName),
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP);
      }
    }
  }

  private void enableComponent(String componentName) {
    PackageManager manager = appcompat.getPackageManager();
    manager.setComponentEnabledSetting(
        new ComponentName(appcompat, "Ninja.coder.Ghostemane.code." + componentName),
        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
        PackageManager.DONT_KILL_APP);
  }

  // Inner class for displaying toast messages
  class DataUtil {
    public static void showMessage(AppCompatActivity app, String message) {
      Toast.makeText(app, message, Toast.LENGTH_SHORT).show();
    }
  }
}
