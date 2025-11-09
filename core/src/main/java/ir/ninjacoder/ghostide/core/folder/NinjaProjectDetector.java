package ir.ninjacoder.ghostide.core.folder;

import java.io.File;

public class NinjaProjectDetector {

  protected static boolean isNinjaLang(String path) {
    var file = new File(path);
    if (!file.isDirectory()) {
      return false;
    }
    var apps = new File(file, "apps");
    var res = new File(apps, "res");
    var ninjas = new File(res, "ninjas");
    var protectedJson = new File(ninjas, "protectedJson.json");
    return protectedJson.exists() && protectedJson.isFile();
  }
}
