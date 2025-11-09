package ir.ninjacoder.ghostide.core.config;

import android.content.Context;

public class RubyCommandCompat {

  // اجرای محیط آماده برای اجرای روبی (shell)
  public static String getBasicCommand(Context context) {
    String appFileDirPath = context.getFilesDir().getAbsolutePath();
    String rubyLibDirPath = appFileDirPath + "/usr/lib";
    String rubySoPath = rubyLibDirPath + "/libruby.so";

    return "export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:"
        + rubyLibDirPath
        + " && echo '[Ruby Ready: "
        + rubySoPath
        + "]'"
        + " && echo '[Enter to Start Shell]'"
        + " && read junk"
        + " && clear";
  }

  // اجرای اسکریپت Ruby از طریق یک شِل اسکریپت کمکی
  public static String getInterpreterCommand(Context context, String rubyScriptPath) {
    String appFileDirPath = context.getFilesDir().getAbsolutePath();
    String rubyLibDirPath = appFileDirPath + "/usr/lib";
    String shellScript = appFileDirPath + "/run_ruby.sh";

    // اسکریپت شل رو تولید می‌کنیم (اگه وجود نداشت)
    writeRubyShellScript(context);

    return "chmod +x \""
        + shellScript
        + "\""
        + " && export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:"
        + rubyLibDirPath
        + " && \""
        + shellScript
        + "\" \""
        + rubyScriptPath
        + "\""
        + " && echo '[Enter to Exit]' && read junk && exit";
  }

  // اجرای محیط روبی بدون فایل اسکریپت
  public static String getRubyShellCommand(Context context) {
    return getInterpreterCommand(context, "-");
  }

  // اسکریپت شل کمکی رو می‌سازه داخل files
  private static void writeRubyShellScript(Context context) {
    try {
      String shell =
          "#!/system/bin/sh\n"
              + "RUBYDIR=\""
              + context.getFilesDir().getAbsolutePath()
              + "/usr\"\n"
              + "LD_LIBRARY_PATH=\"$LD_LIBRARY_PATH:$RUBYDIR/lib\"\n"
              + "$RUBYDIR/bin/ruby \"$1\"\n";
      java.io.File file = new java.io.File(context.getFilesDir(), "run_ruby.sh");
      if (!file.exists()) {
        java.io.FileOutputStream fos = new java.io.FileOutputStream(file);
        fos.write(shell.getBytes());
        fos.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
