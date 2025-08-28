package ir.ninjacoder.ghostide.project;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import dalvik.system.InMemoryDexClassLoader;
import ir.ninjacoder.ghostide.terminal.TerminalActivity;
import ir.ninjacoder.ghostide.utils.FileUtil;
import ir.ninjacoder.prograsssheet.PrograssSheet;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.android.tools.r8.D8;
import ninjacoder.ghostide.androidtools.r8.android.JarPackager;

public class JavaCompilerBeta {

  public static void run(Context context, File javaDir) {
    File[] javaFiles = javaDir.getParentFile().listFiles((dir, name) -> name.endsWith(".java"));
    if (javaFiles == null || javaFiles.length == 0) {
      dialog("Error", "No Java files found in: " + javaDir.getAbsolutePath(), context);
      return;
    }

    String className = extractFirstClassName(javaFiles[0]);

    new AsyncTask<Void, String, String>() {
      PrograssSheet pr;
      long ecjTime, dxTime;
      String binPath;
      List<String> logs = new ArrayList<>();
      String programOutput = "";

      @Override
      protected void onPreExecute() {
        pr = new PrograssSheet(context);
        pr.setTitle("Running...");
        pr.setCancelable(false);
        pr.show();

        binPath = FileUtil.getRoot(context).concat("/bin/");
        FileUtil.deleteFile(binPath);
        FileUtil.makeDir(binPath);
      }

      @Override
      protected String doInBackground(Void... voids) {
        try {
          // کپی cp.jar از assets
          File cpJar = new File(binPath + "cp.jar");
          if (!cpJar.exists()) {
            try (InputStream input = context.getAssets().open("cp.jar");
                OutputStream output = new FileOutputStream(cpJar)) {
              byte[] buffer = new byte[1024];
              int length;
              while ((length = input.read(buffer)) != -1) {
                output.write(buffer, 0, length);
              }
            }
          }

          // کپی فایل‌های جاوا به bin
          for (File f : javaFiles) {
            copyFile(f, new File(binPath + f.getName()));
          }

          // کامپایل همه فایل‌ها با هم
          publishProgress("Compiling Java...");
          long startEcj = System.currentTimeMillis();

          ArrayList<String> ecjArgs = new ArrayList<>();
          ecjArgs.add("-11");
          ecjArgs.add("-nowarn");
          ecjArgs.add("-deprecation");
          ecjArgs.add("-d");
          ecjArgs.add(binPath + "classes");
          ecjArgs.add("-cp");
          ecjArgs.add(binPath + "cp.jar");
          ecjArgs.add("-proc:none");
          ecjArgs.add("-sourcepath");
          ecjArgs.add("ignore");

          // اضافه کردن همه فایل‌های جاوا
          for (File f : javaFiles) {
            ecjArgs.add(binPath + f.getName());
          }

          StringBuilder compileErrors = new StringBuilder();
          PrintWriter printWriter =
              new PrintWriter(
                  new StringWriter() {
                    @Override
                    public void write(int c) {
                      compileErrors.append((char) c);
                    }
                  });

          org.eclipse.jdt.internal.compiler.batch.Main main =
              new org.eclipse.jdt.internal.compiler.batch.Main(
                  printWriter, printWriter, false, null, null);
          main.compile(ecjArgs.toArray(new String[0]));

          if (main.globalErrorsCount > 0) {
            logs.add("Compilation Errors:\n" + compileErrors.toString());
          } else {
            logs.add("All files compiled successfully.");
          }

          ecjTime = System.currentTimeMillis() - startEcj;

          // ساخت JAR
          publishProgress("Packaging JAR...");
          new JarPackager(binPath + "classes/", binPath + "classes.jar").create();

          // اجرای D8 برای تبدیل به DEX
          publishProgress("Dexing with D8...");
          ArrayList<String> d8Args = new ArrayList<>();
          d8Args.add("--output");
          d8Args.add(binPath);
          d8Args.add("--lib");
          d8Args.add(binPath + "cp.jar");

          List<File> classFiles = getClassFiles(new File(binPath + "classes/"));
          for (File f : classFiles) d8Args.add(f.getAbsolutePath());

          long startDx = System.currentTimeMillis();
          D8.main(d8Args.toArray(new String[0]));
          dxTime = System.currentTimeMillis() - startDx;

        } catch (Exception e) {
          return e.toString();
        }
        return "";
      }

      @Override
      protected void onProgressUpdate(String... values) {
        pr.setTitle(values[0]);
      }

      @Override
      protected void onPostExecute(String result) {
        pr.dismiss();

        StringBuilder allLogs = new StringBuilder();
        for (String log : logs) allLogs.append(log).append("\n\n");

        if (!result.isEmpty()) {
          dialog("Compilation Failed", result + "\n\n" + allLogs.toString(), context);
          return;
        }

        File dexFile = new File(binPath + "classes.dex");
        if (!dexFile.exists()) {
          dialog("DEX Error", "classes.dex not found!\n\n" + allLogs.toString(), context);
          return;
        }

        try {
          // اجرای کلاس اصلی با InMemoryDexClassLoader و گرفتن خروجی
          byte[] dexBytes = new byte[(int) dexFile.length()];
          try (FileInputStream fis = new FileInputStream(dexFile)) {
            fis.read(dexBytes);
          }
          ByteBuffer dexBuffer = ByteBuffer.wrap(dexBytes);
          InMemoryDexClassLoader dcl =
              new InMemoryDexClassLoader(dexBuffer, context.getClassLoader());
          Class<?> calledClass = dcl.loadClass(className);
          java.lang.reflect.Method method = calledClass.getDeclaredMethod("main", String[].class);

          // گرفتن خروجی برنامه
          ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
          PrintStream printStream = new PrintStream(outputStream);
          PrintStream originalOut = System.out;
          PrintStream originalErr = System.err;
          System.setOut(printStream);
          System.setErr(printStream);

          method.invoke(null, (Object) new String[] {});

          System.out.flush();
          System.err.flush();
          System.setOut(originalOut);
          System.setErr(originalErr);

          programOutput = outputStream.toString("UTF-8");

        } catch (Exception e) {
          dialog("Runtime Error", e.getLocalizedMessage() + "\n\n" + allLogs.toString(), context);
          return;
        }

        dialog(
            "Execution Finished (ecj:" + ecjTime + "ms | d8:" + dxTime + "ms)",
            programOutput + allLogs.toString(),
            context);
      }
    }.execute();
  }

  private static List<File> getClassFiles(File dir) {
    List<File> files = new ArrayList<>();
    File[] fileArr = dir.listFiles();
    if (fileArr == null) return files;
    for (File file : fileArr) {
      if (file.isDirectory()) files.addAll(getClassFiles(file));
      else if (file.getName().endsWith(".class")) files.add(file);
    }
    return files;
  }

  public static String extractFirstClassName(File javaFile) {
    try {
      CompilationUnit cu = StaticJavaParser.parse(javaFile);
      Optional<ClassOrInterfaceDeclaration> firstClass =
          cu.findFirst(ClassOrInterfaceDeclaration.class);
      return firstClass.map(ClassOrInterfaceDeclaration::getNameAsString).orElse("Main");
    } catch (Exception e) {
      e.printStackTrace();
      return "Main";
    }
  }

  public static void dialog(String title, String message, Context c) {
    Intent it = new Intent();
    it.setClass(c, TerminalActivity.class);
    it.putExtra("java", message);
    c.startActivity(it);
  }

  static void copyFile(File src, File dest) throws IOException {
    if (src == null || dest == null) {
      throw new IllegalArgumentException("Source or destination is null");
    }
    if (!src.exists()) {
      throw new IOException("Source file does not exist: " + src.getAbsolutePath());
    }
    File parent = dest.getParentFile();
    if (parent != null && !parent.exists() && !parent.mkdirs()) {
      throw new IOException("Failed to create parent directories: " + parent.getAbsolutePath());
    }
    if (dest.exists() && dest.isDirectory()) {
      dest = new File(dest, src.getName());
    }
    if (src.getCanonicalPath().equals(dest.getCanonicalPath())) {
      return;
    }
    FileInputStream in = null;
    FileOutputStream out = null;
    try {
      in = new FileInputStream(src);
      out = new FileOutputStream(dest, false);
      byte[] buffer = new byte[8192];
      int length;
      while ((length = in.read(buffer)) != -1) {
        out.write(buffer, 0, length);
      }
      out.getFD().sync();
    } finally {
      try {
        if (in != null) in.close();
      } catch (IOException ignore) {
      }
      try {
        if (out != null) out.close();
      } catch (IOException ignore) {
      }
    }
    dest.setLastModified(src.lastModified());
  }
}
