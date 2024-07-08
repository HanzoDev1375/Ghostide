package com.xiaoyv.ccompile;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.xiaoyv.ccompile.compiler.CCompiler;
import com.xiaoyv.ccompile.compiler.CppCompiler;
import com.xiaoyv.ccompile.executor.CCppExecutor;
import com.xiaoyv.ccompile.utils.ResourceUtils;
import com.xiaoyv.ccompile.utils.ShellUtils;
import com.xiaoyv.ccompile.utils.ThreadUtils;
import com.xiaoyv.ccompile.utils.Utils;
import com.xiaoyv.ccompile.utils.ZipUtils;

import java.io.File;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * C 编译引擎
 *
 * @author 王怀玉
 * @since 2020/5/14
 */
public class CCppEngine {
  private static final String C_COMPILER_DIR = "c_compiler";

  private static final String GCC_VERSION = "7.2.0";

  /** 安装编译器 */
  public static void install(Application application) {
    // 安装工具类
    Utils.init(application);

    if (checkIntent(application)) {
      return;
    }
    installIntent(application);
  }

  /** 安装 Intent */
  private static void installIntent(Application application) {
    // 安装 intent (格式化c 代码)
    File filesDir = application.getFilesDir();
    // 不存在则从Assets解压
    try {
      String dest =
          application.getFilesDir()
              + File.separator
              + C_COMPILER_DIR
              + File.separator
              + "install"
              + File.separator
              + "bin.zip";
      // 复制到存储
      ResourceUtils.copyFileFromAssets("c_compiler/bin.zip", dest);
      // 解压
      ZipUtils.unzipFile(dest, filesDir.getAbsolutePath() + File.separator + C_COMPILER_DIR);

      File intent =
          new File(
              filesDir.getAbsolutePath()
                  + File.separator
                  + C_COMPILER_DIR
                  + File.separator
                  + "indent");

      // 更改权限为可执行
      changeToExecutable(intent);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 安装 Gcc
   *
   * @param gccFile gccFile
   */
  public static void installGcc(
      Context context,
      @NonNull final File gccFile,
      @NonNull final OnInstallListener onInstallListener) {
    final String filesDir = context.getFilesDir().getAbsolutePath();
    ThreadUtils.getCachedPool()
        .execute(
            new Runnable() {
              @Override
              public void run() {
                try {
                  // 解压到 getFilesDir 的 gcc 目录
                  ZipUtils.unzipFile(
                      gccFile.getAbsolutePath(), filesDir + File.separator + C_COMPILER_DIR);

                  // 解压成功后更改权限
                  File binDir1 =
                      new File(
                          filesDir
                              + File.separator
                              + C_COMPILER_DIR
                              + File.separator
                              + "gcc"
                              + File.separator
                              + "bin");
                  File binDir2 =
                      new File(
                          filesDir
                              + File.separator
                              + C_COMPILER_DIR
                              + File.separator
                              + "gcc"
                              + File.separator
                              + "arm-linux-androideabi"
                              + File.separator
                              + "bin");
                  File binDir3 =
                      new File(
                          filesDir
                              + File.separator
                              + C_COMPILER_DIR
                              + File.separator
                              + "gcc"
                              + File.separator
                              + "libexec/gcc/arm-linux-androideabi/"
                              + GCC_VERSION);
                  // 检查文件
                  if (!binDir1.exists() || !binDir2.exists() || !binDir3.exists()) {
                    Utils.runOnUiThread(
                        new Runnable() {
                          @Override
                          public void run() {
                            onInstallListener.onError("GCCNotFound");
                          }
                        });
                    return;
                  }

                  File[] listFiles1 = binDir1.listFiles();
                  if (listFiles1 != null)
                    for (File f : listFiles1) {
                      if (f.isFile()) changeToExecutable(f);
                    }

                  File[] listFiles2 = binDir2.listFiles();
                  if (listFiles2 != null)
                    for (File f : listFiles2) {
                      if (f.isFile()) changeToExecutable(f);
                    }

                  File[] listFiles3 = binDir3.listFiles();
                  if (listFiles3 != null)
                    for (File f : listFiles3) {
                      if (f.isFile()) changeToExecutable(f);
                    }

                  Utils.runOnUiThread(
                      new Runnable() {
                        @Override
                        public void run() {
                          Log.e("aaaa", "6");
                          onInstallListener.onSuccess();
                        }
                      });
                } catch (final Exception e) {
                  e.printStackTrace();
                  Utils.runOnUiThread(
                      new Runnable() {
                        @Override
                        public void run() {
                          onInstallListener.onError(e.toString());
                        }
                      });
                }
              }
            });
  }

  /** 检测 GCC环境 */
  public static boolean checkGcc(Context context) {
    File gccFile =
        new File(
            context.getFilesDir().getAbsolutePath()
                + File.separator
                + C_COMPILER_DIR
                + File.separator
                + "gcc");
    return gccFile.exists() && gccFile.listFiles() != null;
  }

  /** 检测 Intent环境 */
  public static boolean checkIntent(Context context) {
    File intent =
        new File(
            context.getFilesDir().getAbsolutePath()
                + File.separator
                + C_COMPILER_DIR
                + File.separator
                + "indent");
    return intent.exists();
  }

  /** C 编译器 */
  private static volatile CCompiler cCompiler;

  public static CCompiler getCCompiler() {
    if (cCompiler == null) {
      synchronized (CCompiler.class) {
        if (cCompiler == null) {
          cCompiler = new CCompiler();
        }
      }
    }
    return cCompiler;
  }

  /** CPP 编译器 */
  private static volatile CppCompiler cppCompiler;

  public static CppCompiler getCppCompiler() {
    if (cppCompiler == null) {
      synchronized (CppCompiler.class) {
        if (cppCompiler == null) {
          cppCompiler = new CppCompiler();
        }
      }
    }
    return cppCompiler;
  }

  /** CPP 编译器 */
  private static volatile CCppExecutor cCppExecutor;

  public static CCppExecutor getCExecutor() {
    if (cCppExecutor == null) {
      synchronized (CCppExecutor.class) {
        if (cCppExecutor == null) {
          cCppExecutor = new CCppExecutor();
        }
      }
    }
    return cCppExecutor;
  }

  /** 获取编译器的目录 */
  public static String getCompilerDirPath(Context context) {
    return context.getFilesDir().getAbsolutePath() + File.separator + C_COMPILER_DIR;
  }

  /**
   * 更改某个文件为可执行
   *
   * @param file file
   */
  public static void changeToExecutable(File file) {
    ShellUtils.execCmd("chmod 777 " + file.getAbsolutePath(), false);
  }

  private static class InterceptorOutputStream extends PrintStream {
    private ArrayList<PrintStream> streams;

    InterceptorOutputStream(@NonNull OutputStream file, ArrayList<PrintStream> streams) {
      super(file, true);
      this.streams = streams;
    }

    public void add(PrintStream out) {
      this.streams.add(out);
    }

    public void remove(PrintStream out) {
      this.streams.remove(out);
    }

    @Override
    public void write(@NonNull byte[] buf, int off, int len) {
      super.write(buf, off, len);
      if (streams != null) {
        for (PrintStream printStream : streams) {
          printStream.write(buf, off, len);
        }
      }
    }
  }

  public interface OnInstallListener {
    void onSuccess();

    void onError(String error);
  }
}
