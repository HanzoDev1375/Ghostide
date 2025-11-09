package ir.ninjacoder.ghostide.core.marco;

import android.content.Context;

import com.xiaoyv.ccompile.utils.ShellUtils;

import java.io.File;

public class CommentList {
  // this comment list to editor
  public String stopSearch = "//?";
  public String showPopWindows = "//!";
  public String saveAndExit = "***";
  public String showColorPi = "###";
  public String openSettingApp = ":::";

  public static String getRunPhpCommand(Context context, File phpFile) {
    StringBuilder command = new StringBuilder();

    String appLibDirPath = context.getApplicationInfo().nativeLibraryDir;
    String appFileDirPath = context.getFilesDir().getAbsolutePath();
    String phpLibDirPath = appFileDirPath + "/lib";
    String phpIniPath = new File(context.getFilesDir(), "php.ini").getPath();

    command
        .append("export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:")
        .append(phpLibDirPath)
        .append(" && \"")
        .append(appLibDirPath)
        .append("/libphp-8.2.8.so\" -f \"")
        .append(phpFile.getPath())
        .append("\" -c \"")
        .append(phpIniPath)
        .append("\" && echo '")
        .append(ShellUtils.shellRed)
        .append("[Enter to Exit]")
        .append("' && read junk && exit");

    return command.toString();
  }
}
