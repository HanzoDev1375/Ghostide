package Ninja.coder.Ghostemane.code.utils;

import android.content.Context;

import java.io.File;

public class Commands {
  public static String getBasicCommand(Context context) {
    String appLibDirPath = context.getApplicationInfo().nativeLibraryDir;
    String appFileDirPath = context.getFilesDir().getAbsolutePath();
    String pythonBuildDirPath = appFileDirPath + "/files/usr";
    String pythonLibDirPath = pythonBuildDirPath + "/lib";
    String pythonExecName = "libpython3.so";
    String aliasCommand =
        "alias python=\"" + pythonExecName + "\" && alias pip=\"" + pythonExecName + " -m pip \"";
    return "export PATH=$PATH:"
        + appLibDirPath
        + " && export PYTHONHOME="
        + pythonBuildDirPath
        + " && export PYTHONPATH="
        + appLibDirPath
        + " && export LD_LIBRARY_PATH=\"$LD_LIBRARY_PATH:\" && export LD_LIBRARY_PATH=\"$LD_LIBRARY_PATH"
        + pythonLibDirPath
        + "\" && "
        + aliasCommand
        + " &&  clear \r";
  }

  public static String getInterpreterCommand(Context context, String filePath) {
    String appLibDirPath = context.getApplicationInfo().nativeLibraryDir;
    String appFileDirPath = context.getFilesDir().getAbsolutePath();
    String pythonBuildDirPath = appFileDirPath + "/files/usr";
    String pythonLibDirPath = pythonBuildDirPath + "/lib";
    String pythonExecName = "libpython3.so";
    return "export PATH=$PATH:"
        + appLibDirPath
        + " && export PYTHONHOME="
        + pythonBuildDirPath
        + " && export LD_LIBRARY_PATH=\"$LD_LIBRARY_PATH:\" && export LD_LIBRARY_PATH=\"$LD_LIBRARY_PATH"
        + pythonLibDirPath
        + "\" && clear && "
        + pythonExecName
        + " "
        + filePath
        + "\r"
        + "\r exit";
  }

  public static String getPythonShellCommand(Context context) {
    String appLibDirPath = context.getApplicationInfo().nativeLibraryDir;
    String appFileDirPath = context.getFilesDir().getAbsolutePath();
    String pythonBuildDirPath = appFileDirPath + "/files/usr";
    String pythonLibDirPath = pythonBuildDirPath + "/lib";
    return "export PATH=$PATH:"
        + appLibDirPath
        + " && export PYTHONHOME="
        + pythonBuildDirPath
        + " && export PYTHONPATH="
        + appLibDirPath
        + " && export LD_LIBRARY_PATH=\"$LD_LIBRARY_PATH:\" && export LD_LIBRARY_PATH=\"$LD_LIBRARY_PATH"
        + pythonLibDirPath
        + "\" && clear && libpython3.so && echo '[Enter to Exit]' && read junk && exit";
  }

  public static String getRunCppCommand(Context context, File file) {
    String filePath = file.getAbsolutePath();
    String fileName = file.getName().replaceFirst("[.][^.]+$", "");
    String gccExecPath =
        "chmod +x /data/data/Ninja.coder.Ghostemane.code/files/c_compiler/gcc/bin/arm-linux-androideabi-g++";
    return "export PATH="
        + gccExecPath
        + ":$PATH"
        + " && clear && "
        + gccExecPath
        + " -o "
        + fileName
        + " "
        + filePath
        + " && "
        + "/system/bin/linker64 $(pwd)/"
        + fileName
        + " && rm "
        + fileName
        + " && read junk && exit\r";
  }
}
