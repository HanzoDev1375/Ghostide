package Ninja.coder.Ghostemane.code.PluginManager;

import android.os.Build;


@ismodule
public class IntentHelper extends Plugin {
  /** this class helper to intent api ghost web ide */
  protected String name = "";

  @isField(api = Build.VERSION_CODES.KITKAT)
  public static String getFilePath = "FilePath";

  @isField(api = Build.VERSION_CODES.KITKAT)
  public static String getRunTerminal = "Terminal";

  public IntentHelper(String name) {
    this.name = name;
  }
}
