package Ninja.coder.Ghostemane.code.PluginManager.ModelPackage;

import Ninja.coder.Ghostemane.code.PluginManager.isField;
import Ninja.coder.Ghostemane.code.PluginManager.ismodule;
import android.content.Context;
import android.content.pm.PackageManager;
import static android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

@ismodule
public class WorkPackageManager {

  protected List<PackageModels> getList;

  public WorkPackageManager() {
    getList = new ArrayList<>();
  }

  public WorkPackageManager add(
      String packagename, String componetName, boolean isWork, boolean isUsinall) {
    getList.add(new PackageModels(packagename, componetName, isWork, isUsinall));
    return this;
  }

  public WorkPackageManager add(String packagename, String componetName, boolean uinstall) {
    add(packagename, componetName, true, uinstall);
    return this;
  }

  public WorkPackageManager add(String packagename, String componetName) {
    add(packagename, componetName, true, false);
    return this;
  }

  public List<PackageModels> getGetList() {
    return this.getList;
  }

  @isField
  public void setGetList(List<PackageModels> getList) {
    this.getList = getList;
  }

  @isField
  public boolean isAopNotFound(String packagename, Context context) {
    var pm = context.getPackageManager();
    try {
      pm.getPackageInfo(packagename, PackageManager.GET_ACTIVITIES);
      Log.d(
          "AppFound in ", pm.getPackageInfo(packagename, PackageManager.GET_ACTIVITIES).toString());
      return true;
    } catch (NameNotFoundException err) {
      Log.e("Error App Not Found", err.getLocalizedMessage());
      return false;
    }
  }
}
