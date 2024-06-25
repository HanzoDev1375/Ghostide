package Ninja.coder.Ghostemane.code.project;

import Ninja.coder.Ghostemane.code.utils.ColorAndroid12;
import Ninja.coder.Ghostemane.code.utils.FileUtil;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.android.tools.r8.D8;
import com.github.javaparser.StaticJavaParser;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import dalvik.system.DexClassLoader;
import ninjacoder.ghostide.androidtools.r8.android.JarPackager;

import java.io.*;
import java.util.ArrayList;

public class JavaCompilerBeta {

  protected static ProgressDialog pr;
  private static String dirPath = "/storage/emulated/0/GhostWebIDE/java/";

  public static void run(Context context, String inputs) {
    // Use JavaParser to parse the class name from inputs
    final String className = extractClassName(inputs, inputs);

    new AsyncTask<String, String, String>() {
      ProgressDialog pr;
      long ecjTime, dxTime;
      ArrayList<String> opt = new ArrayList<>();

      @Override
      protected void onPreExecute() {
        pr = new ProgressDialog(context);
        pr.setMessage("Running...");
        pr.setCancelable(false);
        pr.show();
      }

      @Override
      protected String doInBackground(String... params) {
        // Prepare files and directories
        FileUtil.deleteFile(FileUtil.getPackageDataDir(context).concat("/bin/"));
        FileUtil.makeDir(FileUtil.getPackageDataDir(context).concat("/bin/"));

        // Write inputs to a file named after the class name
        try {
          String fileName = className + ".java";
          FileUtil.writeFile(
              FileUtil.getPackageDataDir(context).concat("/bin/").concat(fileName), inputs);
        } catch (Exception e) {
          e.printStackTrace();
          return "Error writing Java file: " + e.getMessage();
        }

        // Copy cp.jar from assets to temp folder if it doesn't exist
        if (!FileUtil.isExistFile(FileUtil.getPackageDataDir(context).concat("/bin/cp.jar"))) {
          try (InputStream input = context.getAssets().open("cp.jar");
              OutputStream output =
                  new FileOutputStream(FileUtil.getPackageDataDir(context).concat("/bin/cp.jar"))) {
            byte[] buffer = new byte[input.available()];
            int length;
            while ((length = input.read(buffer)) != -1) {
              output.write(buffer, 0, length);
            }
          } catch (IOException e) {
            e.printStackTrace();
            return "Error copying cp.jar: " + e.getMessage();
          }
        }

        // Compile Java code using Eclipse Compiler for Java (ecj)
        long time = System.currentTimeMillis();
        publishProgress("Compiling Java...");
        opt.clear();
        opt.add("-1.8");
        opt.add("-nowarn");
        opt.add("-deprecation");
        opt.add("-d");
        opt.add(FileUtil.getPackageDataDir(context).concat("/bin/classes"));
        opt.add("-cp");
        opt.add(FileUtil.getPackageDataDir(context).concat("/bin/cp.jar"));
        opt.add("-proc:none");
        opt.add("-sourcepath");
        opt.add("ignore");
        opt.add(
            FileUtil.getPackageDataDir(context).concat("/bin/").concat(className).concat(".java"));

        StringBuilder compileErrors = new StringBuilder();

        PrintWriter printWriter =
            new PrintWriter(new StringWriter()) {
              @Override
              public void write(int p1) {
                compileErrors.append((char) p1);
              }
            };

        org.eclipse.jdt.internal.compiler.batch.Main main =
            new org.eclipse.jdt.internal.compiler.batch.Main(
                printWriter, printWriter, false, null, null);

        main.compile(opt.toArray(new String[0]));

        if (main.globalErrorsCount > 0) {
          return compileErrors.toString();
        }
        ecjTime = System.currentTimeMillis() - time;

        // Package compiled classes to a JAR file
        publishProgress("Packaging JAR...");
        try {
          new JarPackager(
                  FileUtil.getPackageDataDir(context).concat("/bin/classes/"),
                  FileUtil.getPackageDataDir(context).concat("/bin/classes.jar"))
              .create();
        } catch (Exception e) {
          return "Packaging JAR failed: " + e.toString();
        }

        // Convert JAR to Dex using D8 (Dexer for Android)
        time = System.currentTimeMillis();
        try {
          publishProgress("Dexing with D8...");
          opt.clear();
          opt.add("--output");
          opt.add(FileUtil.getPackageDataDir(context).concat("/bin/"));
          opt.add("--lib");
          opt.add(FileUtil.getPackageDataDir(context).concat("/bin/cp.jar"));
          opt.add(FileUtil.getPackageDataDir(context).concat("/bin/classes.jar"));
          D8.main(opt.toArray(new String[0]));
        } catch (Exception e) {
          return "Dex failed: " + e.toString();
        }
        dxTime = System.currentTimeMillis() - time;
        return "";
      }

      @Override
      protected void onProgressUpdate(String... values) {
        pr.setMessage(values[0]);
      }

      @Override
      protected void onPostExecute(String _result) {
        pr.dismiss();
        if (TextUtils.isEmpty(_result)) {
          final TextView tx = new TextView(context);
          tx.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
          tx.setTextSize(15);
          tx.setTextColor(ColorAndroid12.getColors(ColorAndroid12.TvColorFab));
          tx.setPadding(30, 30, 30, 30);
          tx.setTextIsSelectable(true);

          final ScrollView sc = new ScrollView(context);
          sc.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
          sc.addView(tx);

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
            String optimizedDir = context.getDir("odex", Context.MODE_PRIVATE).getAbsolutePath();

            DexClassLoader dcl =
                new DexClassLoader(
                    FileUtil.getPackageDataDir(context).concat("/bin/classes.dex"),
                    optimizedDir,
                    null,
                    context.getClassLoader());

            // Load the dynamically compiled class
            Class<?> calledClass = dcl.loadClass(className);

            // Find and invoke the 'main' method of the class
            java.lang.reflect.Method method = calledClass.getDeclaredMethod("main", String[].class);
            String[] param = {};

            Object result = method.invoke(null, new Object[] {param});
          } catch (java.lang.reflect.InvocationTargetException i) {
            dialog("Failed..", "Runtime error: " + i.getCause().toString(), context);
            return;
          } catch (Exception e) {
            dialog(
                "Failed..",
                "Couldn't execute the dex: "
                    + e.toString()
                    + "\n\nSystem logs:\n"
                    + _outstream.toString(),
                context);
            return;
          }

          // Show the result in a dialog
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
          dialog("Failed..", _result, context);
        }
      }
    }.execute(inputs); // Pass inputs to AsyncTask
  }

  public static void dialog(String title, String message, Context c) {
    new MaterialAlertDialogBuilder(c)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton("OK", null)
        .setNegativeButton("Cancel", null)
        .show();
  }

  // Method to extract class name from the input Java code using JavaParser
  private static String extractClassName(String javaCode, String name) {
    try {
      CompilationUnit cu = StaticJavaParser.parse(javaCode);

      return cu.getClassByName(name).orElseThrow().getNameAsString();
    } catch (Exception e) {
      e.printStackTrace();
      return "Main";
    }
  }
}
