package Ninja.coder.Ghostemane.code.PluginManager.ModelPackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import static android.content.pm.PackageManager.NameNotFoundException;

public class AppInfoFether {
  public static AppInfo getAppInfo(Context context, String packageName) {
    AppInfo appInfo = new AppInfo();
    try {
      var packageManager = context.getPackageManager();
      var applicationInfo = packageManager.getApplicationInfo(packageName, 0);

      // دریافت نام برنامه
      String appName = packageManager.getApplicationLabel(applicationInfo).toString();
      // دریافت آیکون برنامه
      Drawable appIcon = packageManager.getApplicationIcon(applicationInfo);

      appInfo.setName(appName);
      appInfo.setIcon(appIcon);
    } catch (NameNotFoundException e) {
      e.printStackTrace();
      appInfo.setName("Null");
      appInfo.setIcon(null);
    }
    return appInfo;
  }
}
