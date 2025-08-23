package ir.ninjacoder.ghostide.project;

import ir.ninjacoder.ghostide.utils.FileUtil;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.android.tools.r8.D8;
import com.github.javaparser.StaticJavaParser;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.github.javaparser.ast.CompilationUnit;
import dalvik.system.InMemoryDexClassLoader;
import ir.ninjacoder.prograsssheet.PrograssSheet;
import java.util.Optional;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import ninjacoder.ghostide.androidtools.r8.android.JarPackager;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class JavaCompilerBeta {

  public static void run(Context context, String inputs) {
    final String className = extractFirstClassName(inputs);

    new AsyncTask<String, String, String>() {
      PrograssSheet pr;
      long ecjTime, dxTime;
      ArrayList<String> opt = new ArrayList<>();
      String binPath;

      @Override
      protected void onPreExecute() {
        pr = new PrograssSheet(context);
        pr.setTitle("Running...");
        pr.setCancelable(false);
        pr.show();

        // تعیین مسیر bin
        binPath = FileUtil.getRoot(context).concat("/bin/");
      }

      @Override
      protected String doInBackground(String... params) {
        // پاکسازی و ایجاد دایرکتوری‌ها
        FileUtil.deleteFile(binPath);
        FileUtil.makeDir(binPath);

        // نوشتن فایل جاوا
        try {
          String fileName = className + ".java";
          FileUtil.writeFile(binPath + fileName, inputs);
        } catch (Exception e) {
          return "Error writing Java file: " + e.getMessage();
        }

        // کپی cp.jar از assets
        if (!FileUtil.isExistFile(binPath + "cp.jar")) {
          try (InputStream input = context.getAssets().open("cp.jar");
              OutputStream output = new FileOutputStream(binPath + "cp.jar")) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = input.read(buffer)) != -1) {
              output.write(buffer, 0, length);
            }
          } catch (IOException e) {
            return "Error copying cp.jar: " + e.getMessage();
          }
        }

        // کامپایل با ECJ
        long time = System.currentTimeMillis();
        publishProgress("Compiling Java...");
        opt.clear();
        opt.add("-11");
        opt.add("-nowarn");
        opt.add("-deprecation");
        opt.add("-d");
        opt.add(binPath + "classes");
        opt.add("-cp");
        opt.add(binPath + "cp.jar");
        opt.add("-proc:none");
        opt.add("-sourcepath");
        opt.add("ignore");
        opt.add(binPath + className + ".java");

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
        main.compile(opt.toArray(new String[0]));

        if (main.globalErrorsCount > 0) {
          return compileErrors.toString();
        }
        ecjTime = System.currentTimeMillis() - time;

        // ایجاد JAR
        publishProgress("Packaging JAR...");
        try {
          new JarPackager(
                  FileUtil.getRoot(context).concat("/bin/classes/"),
                  FileUtil.getRoot(context).concat("/bin/classes.jar"))
              .create();
        } catch (Exception e) {
          return "Packaging JAR failed: " + e.toString();
        }

        // تبدیل به DEX با D8
        time = System.currentTimeMillis();
        try {
          publishProgress("Dexing with D8...");
          opt.clear();
          opt.add("--output");
          opt.add(FileUtil.getRoot(context).concat("/bin/"));
          opt.add("--lib");
          opt.add(FileUtil.getRoot(context).concat("/bin/cp.jar"));
          opt.add(FileUtil.getRoot(context).concat("/bin/classes.jar"));
          D8.main(opt.toArray(new String[0]));

          // گرفتن خروجی D8 برای دیباگ
          PrintStream originalOut = System.out;
          PrintStream originalErr = System.err;

          try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);
            System.setOut(ps);
            System.setErr(ps);
            String d8Output = baos.toString();
            if (!d8Output.isEmpty()) {
              FileUtil.writeFile(binPath + "d8_output.txt", d8Output);
            }
          } finally {
            System.setOut(originalOut);
            System.setErr(originalErr);
          }

        } catch (Exception e) {
          return "Dex failed: " + e.toString();
        }
        dxTime = System.currentTimeMillis() - time;
        return "";
      }

      @Override
      protected void onProgressUpdate(String... values) {
        pr.setTitle(values[0]);
      }

      @Override
      protected void onPostExecute(String _result) {
        pr.dismiss();

        // چک کردن وجود فایل‌های لازم
        File binDir = new File(binPath);
        if (!binDir.exists()) {
          dialog("Error", "bin directory doesn't exist: " + binPath, context);
          return;
        }

        // لیست فایل‌ها برای دیباگ
        StringBuilder filesList = new StringBuilder();
        File[] files = binDir.listFiles();
        if (files != null) {
          for (File file : files) {
            filesList.append(file.getName()).append(" (").append(file.length()).append(" bytes)\n");
          }
        }

        // چک کردن وجود classes.dex
        File dexFile = new File(binPath + "classes.dex");
        if (!dexFile.exists()) {
          String errorMsg =
              "DEX file not found!\n"
                  + "Path: "
                  + dexFile.getAbsolutePath()
                  + "\n\n"
                  + "Files in bin directory:\n"
                  + filesList.toString();

          dialog("DEX Error", errorMsg, context);
          return;
        }

        if (TextUtils.isEmpty(_result)) {
          final EditText tx = new EditText(context);
          tx.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
          tx.setPadding(30, 30, 30, 30);
          final ScrollView sc = new ScrollView(context);
          sc.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
          sc.addView(tx);
          tx.setBackgroundColor(0);

          OutputStream _outstream =
              new OutputStream() {
                @Override
                public void write(int b) {
                  tx.append(String.valueOf((char) b));
                }

                @Override
                public String toString() {
                  return tx.getText().toString();
                }
              };
          System.setOut(new PrintStream(_outstream));
          System.setErr(new PrintStream(_outstream));

          try {
            // خواندن فایل dex به صورت بایت‌آرایه
            byte[] dexBytes = new byte[(int) dexFile.length()];
            FileInputStream fis = new FileInputStream(dexFile);
            fis.read(dexBytes);
            fis.close();

            // استفاده از InMemoryDexClassLoader
            ByteBuffer dexBuffer = ByteBuffer.wrap(dexBytes);
            InMemoryDexClassLoader dcl =
                new InMemoryDexClassLoader(dexBuffer, context.getClassLoader());

            // لود کلاس و اجرای متد main
            Class<?> calledClass = dcl.loadClass(className);
            java.lang.reflect.Method method = calledClass.getDeclaredMethod("main", String[].class);
            String[] param = {};
            method.invoke(null, new Object[] {param});

          } catch (java.lang.reflect.InvocationTargetException i) {
            dialog("Runtime Error", "Runtime error: " + i.getCause().toString(), context);
            return;
          } catch (Exception e) {
            dialog("Execution Error", "Couldn't execute the dex: " + e.toString(), context);
            return;
          }

          // نمایش نتیجه
          new MaterialAlertDialogBuilder(context)
              .setTitle("Output (ecj:" + ecjTime + "ms | d8:" + dxTime + "ms)")
              .setView(sc)
              .setPositiveButton("OK", null)
              .setNegativeButton("Cancel", null)
              .setOnDismissListener(
                  new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {}
                  })
              .create()
              .show();
        } else {
          dialog("Compilation Failed", _result, context);
        }
      }
    }.execute(inputs);
  }

  public static void dialog(String title, String message, Context c) {
    new MaterialAlertDialogBuilder(c)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton("OK", null)
        .setNegativeButton("Cancel", null)
        .show();
  }

  public static String extractFirstClassName(String javaCode) {
    try {
      CompilationUnit cu = StaticJavaParser.parse(javaCode);
      Optional<ClassOrInterfaceDeclaration> firstClass =
          cu.findFirst(ClassOrInterfaceDeclaration.class);
      return firstClass.map(ClassOrInterfaceDeclaration::getNameAsString).orElse("Main");
    } catch (Exception e) {
      e.printStackTrace();
      return "Main";
    }
  }
}
