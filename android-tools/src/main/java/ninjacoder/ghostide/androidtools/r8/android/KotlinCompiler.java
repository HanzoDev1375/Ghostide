package ninjacoder.ghostide.androidtools.r8.android;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.widget.EditText;
import com.android.tools.r8.D8Command;
import com.android.tools.r8.OutputMode;
import com.android.tools.r8.CompilationMode;
import com.android.tools.r8.D8;
import dalvik.system.DexClassLoader;
import dalvik.system.DexFile;
import dalvik.system.InMemoryDexClassLoader;
import ir.ninjacoder.prograsssheet.PrograssSheet;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import org.jetbrains.kotlin.cli.common.arguments.K2JVMCompilerArguments;
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity;
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSourceLocation;
import org.jetbrains.kotlin.cli.common.messages.MessageCollector;
import org.jetbrains.kotlin.cli.jvm.K2JVMCompiler;
import org.jetbrains.kotlin.config.Services;
import org.jetbrains.kotlin.cli.common.ExitCode;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Enumeration;

public class KotlinCompiler {
  private EditText outputEditText;
  private Context context;
  private String kotlinLibsPath;
  private String androidJarPath = "/storage/emulated/0/GhostWebIDE/android/android.jar";
  private String workspaces;
  private PrograssSheet progressDialog;

  public interface OnDoneCompiler {
    void onCompile();
  }

  private OnDoneCompiler com;

  public KotlinCompiler(EditText outputEditText, Context context, OnDoneCompiler com) {
    this.outputEditText = outputEditText;
    this.context = context;
    this.com = com;
    kotlinLibsPath = context.getCacheDir().getAbsolutePath() + File.separator + "kt/";
    workspaces = context.getCacheDir().getAbsolutePath() + File.separator + "kt/";
  }

  public void compile(String filePath) {
    progressDialog = new PrograssSheet(context);
    progressDialog.setTitle("Kt compile...");
    progressDialog.setCancelable(false);
    progressDialog.show();

    new CompileTask().execute(filePath);
  }

  private class CompileTask extends AsyncTask<String, String, Boolean> {
    @Override
    protected Boolean doInBackground(String... params) {
      String filePath = params[0];
      long timeMillis = System.currentTimeMillis();

      try {
        // publishProgress("در حال آماده‌سازی محیط کار...");
        File workspace = new File(workspaces);

        if (!workspace.exists() && !workspace.mkdirs()) {
          publishProgress("Failed to create workspace directory");
          return false;
        }

        File mClassOutput = new File(workspace, "output");
        if (!mClassOutput.exists() && !mClassOutput.mkdirs()) {
          publishProgress("Failed to create output directory");
          return false;
        }

        File dexOutput = new File(workspace, "dex");
        if (!dexOutput.exists() && !dexOutput.mkdirs()) {
          // publishProgress("Failed to create dex directory");
          return false;
        }

        File inputFile = new File(filePath);
        if (!inputFile.exists()) {
          // publishProgress("Input file not found: " + filePath);
          return false;
        }

        // publishProgress("در حال کامپایل کد Kotlin...");
        String classpath = buildClasspath();

        List<String> arguments = new ArrayList<>();
        arguments.add(inputFile.getAbsolutePath());
        arguments.add("-cp");
        arguments.add(classpath);
        arguments.add("-d");
        arguments.add(mClassOutput.getAbsolutePath());
        arguments.add("-no-stdlib");

        K2JVMCompiler compiler = new K2JVMCompiler();
        K2JVMCompilerArguments args = new K2JVMCompilerArguments();
        compiler.parseArguments(arguments.toArray(new String[0]), args);

        args.setCompileJava(false);
        args.setIncludeRuntime(false);
        args.setNoJdk(false);
        args.setNoReflect(false);
        args.setNoStdlib(false);

        MessageCollector collector = new MessageCollectorImpl();
        ExitCode exitCode = compiler.exec(collector, Services.EMPTY, args);

        if (exitCode != ExitCode.OK || collector.hasErrors()) {
          publishProgress("Compilation failed:\n" + collector.toString());
          return false;
        } else {
          String successMessage =
              "Compiled successfully in " + (System.currentTimeMillis() - timeMillis) + " ms";
          //   publishProgress(successMessage + "\nOutput files at: " +
          // mClassOutput.getAbsolutePath());

          //  publishProgress("در حال تبدیل به DEX...");
          if (convertToDex(mClassOutput, dexOutput)) {
            publishProgress("DEX conversion successful");
            runDexCode(dexOutput);
            return true;
          } else {
            return false;
          }
        }
      } catch (Exception e) {
        publishProgress("Compilation error: " + e.getMessage());
        e.printStackTrace();
        return false;
      }
    }

    @Override
    protected void onProgressUpdate(String... values) {
      appendOutput(values[0]);
    }

    @Override
    protected void onPostExecute(Boolean success) {
      if (progressDialog != null && progressDialog.isShowing()) {
        progressDialog.dismiss();
        com.onCompile();
      }
    }

    private boolean convertToDex(File classOutputDir, File dexOutputDir) {
      try {
        File jarFile = new File(dexOutputDir, "classes.jar");
        createJarFile(classOutputDir, jarFile);

        boolean success =
            D8Converter.convertJarToDex(jarFile, dexOutputDir, new EditTextWrapper(outputEditText));

        if (success) {
          //   publishProgress("File DEX in: " + dexOutputDir.getAbsolutePath());
          return true;
        }
        return false;
      } catch (Exception e) {
        publishProgress("خطا: " + e.getMessage());
        return false;
      }
    }
  }

  private static class EditTextWrapper {
    private final EditText editText;

    public EditTextWrapper(EditText editText) {
      this.editText = editText;
    }

    public void append(final String text) {
      editText.post(
          new Runnable() {
            @Override
            public void run() {
              editText.append(text);
            }
          });
    }
  }

  private void createJarFile(File inputDir, File outputJar) throws IOException {
    try (FileOutputStream fos = new FileOutputStream(outputJar);
        java.util.zip.ZipOutputStream zos = new java.util.zip.ZipOutputStream(fos)) {

      for (File file : inputDir.listFiles()) {
        addToZipFile(file, "", zos);
      }
    }
  }

  private void addToZipFile(File file, String parentPath, java.util.zip.ZipOutputStream zos)
      throws IOException {
    String entryName = parentPath + file.getName();

    if (file.isDirectory()) {
      entryName += "/";
      java.util.zip.ZipEntry entry = new java.util.zip.ZipEntry(entryName);
      zos.putNextEntry(entry);
      zos.closeEntry();

      for (File child : file.listFiles()) {
        addToZipFile(child, entryName, zos);
      }
    } else {
      java.util.zip.ZipEntry entry = new java.util.zip.ZipEntry(entryName);
      zos.putNextEntry(entry);

      try (FileInputStream fis = new FileInputStream(file)) {
        byte[] buffer = new byte[1024];
        int length;
        while ((length = fis.read(buffer)) > 0) {
          zos.write(buffer, 0, length);
        }
      }
      zos.closeEntry();
    }
  }

  private void runDexCode(File dexOutputDir) {
    PrintStream originalOut = System.out;

    try {
      File dexFile = new File(dexOutputDir, "classes.dex");

      if (!dexFile.exists()) {
        appendOutput("Error: DEX file not found");
        return;
      }

      System.setOut(createEditTextPrintStream());

      // برای اندروید ۸ و بالاتر از InMemoryDexClassLoader استفاده کنید
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        try {
          byte[] dexBytes = java.nio.file.Files.readAllBytes(dexFile.toPath());
          ClassLoader classLoader =
              new InMemoryDexClassLoader(
                  ByteBuffer.wrap(dexBytes), context.getClassLoader());

          tryToRunMain(classLoader, "MainKt");
        } catch (Exception e) {
          appendOutput("InMemory loader error: " + e.getMessage());
        }
      } else {
        // برای نسخه‌های قدیمی‌تر از DexClassLoader
        try {
          DexClassLoader classLoader =
              new DexClassLoader(
                  dexFile.getAbsolutePath(),
                  context.getDir("outdex", Context.MODE_PRIVATE).getAbsolutePath(),
                  null,
                  context.getClassLoader());

          tryToRunMain(classLoader, "MainKt");
        } catch (Exception e) {
          appendOutput("DexClassLoader error: " + e.getMessage());
        }
      }

    } catch (Exception e) {
      appendOutput("Runtime error: " + e.getMessage());
    } finally {
      System.setOut(originalOut);
    }
  }

  private void tryToRunMain(ClassLoader classLoader, String className) {
    try {
      Class<?> compiledClass = classLoader.loadClass(className);
      try {
        Method mainMethod = compiledClass.getMethod("main");
        mainMethod.invoke(null);
        appendOutput(className);
      } catch (NoSuchMethodException e) {
        Method mainMethod = compiledClass.getMethod("main", String[].class);
        mainMethod.invoke(null, (Object) new String[] {});
        appendOutput(className);
      }
    } catch (ClassNotFoundException e) {
      appendOutput("Class " + className + " not found, trying alternatives...");
    } catch (Exception e) {
      appendOutput("Error executing " + className + ": " + e.getMessage());
    }
  }

  private PrintStream createEditTextPrintStream() {
    return new PrintStream(
        new OutputStream() {
          private StringBuilder buffer = new StringBuilder();

          @Override
          public void write(int b) {
            if (b == '\n') {
              String line = buffer.toString();
              outputEditText.post(() -> outputEditText.append(line + "\n"));
              buffer = new StringBuilder();
            } else {
              buffer.append((char) b);
            }
          }
        });
  }

  private String findMainClass(File dexFile) throws IOException {
    DexFile df = new DexFile(dexFile);
    Enumeration<String> classes = df.entries();
    DexClassLoader classLoader =
        new DexClassLoader(
            dexFile.getAbsolutePath(),
            context.getDir("outdex", Context.MODE_PRIVATE).getAbsolutePath(),
            null,
            context.getClassLoader());

    while (classes.hasMoreElements()) {
      String className = classes.nextElement();
      try {
        Class<?> clazz = classLoader.loadClass(className);

        // چک کردن وجود متد `main` (هم برای Kotlin و هم Java)
        try {
          // حالت Kotlin: متد main بدون آرگومان یا با آرگومان Array<String>
          Method mainMethod = clazz.getMethod("main");
          if (mainMethod != null) {
            return className;
          }
        } catch (NoSuchMethodException e1) {
          try {
            // حالت Java: متد main با آرگومان String[]
            Method mainMethod = clazz.getMethod("main", String[].class);
            if (mainMethod != null) {
              return className;
            }
          } catch (NoSuchMethodException e2) {
            // این کلاس متد main ندارد
          }
        }
      } catch (ClassNotFoundException e) {
        // اگر کلاس قابل بارگذاری نبود، ادامه بده
        continue;
      }
    }
    return null; // هیچ کلاس دارای main یافت نشد
  }

  private String buildClasspath() {
    String[] requiredLibs = {
      "kotlin-stdlib-1.8.0-RC.jar",
      "kotlin-stdlib-common-1.8.0-RC.jar",
      "kotlinx-coroutines-core-jvm-1.6.4.jar"
    };

    StringBuilder classpath = new StringBuilder();
    classpath.append(androidJarPath);

    for (String lib : requiredLibs) {
      File libFile = new File(kotlinLibsPath + lib);
      if (libFile.exists()) {
        classpath.append(":").append(libFile.getAbsolutePath());
      } else {
        appendOutput("Warning: Library not found: " + lib);
      }
    }

    return classpath.toString();
  }

  private void appendOutput(String text) {
    outputEditText.post(() -> outputEditText.append(text + "\n"));
  }

  private static class MessageCollectorImpl implements MessageCollector {
    private final List<CompilerMessage> messages = new ArrayList<>();

    @Override
    public void clear() {
      messages.clear();
    }

    @Override
    public boolean hasErrors() {
      for (CompilerMessage message : messages) {
        if (message.severity.isError()) {
          return true;
        }
      }
      return false;
    }

    @Override
    public void report(
        CompilerMessageSeverity severity, String message, CompilerMessageSourceLocation location) {
      messages.add(new CompilerMessage(severity, message, location));
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      for (CompilerMessage message : messages) {
        sb.append("[")
            .append(message.severity.name())
            .append("] ")
            .append(message.message)
            .append("\n");

        if (message.location != null) {
          sb.append(message.location.getPath())
              .append(":")
              .append(message.location.getLine())
              .append(":")
              .append(message.location.getColumn())
              .append("\n");
        }
      }
      return sb.toString();
    }
  }

  private static class CompilerMessage {
    final CompilerMessageSeverity severity;
    final String message;
    final CompilerMessageSourceLocation location;

    CompilerMessage(
        CompilerMessageSeverity severity, String message, CompilerMessageSourceLocation location) {
      this.severity = severity;
      this.message = message;
      this.location = location;
    }
  }

  static class D8Converter {
    public static boolean convertJarToDex(File inputJar, File outputDir, EditTextWrapper logView) {
      try {
        D8Command command =
            D8Command.builder()
                .addProgramFiles(inputJar.toPath())
                .setMode(CompilationMode.RELEASE)
                .setOutput(outputDir.toPath(), OutputMode.DexIndexed)
                .build();

        D8.run(command);
        //  logView.append("تبدیل به DEX موفقیت‌آمیز بود\n");

        File dexFile = new File(outputDir, "classes.dex");
        if (!dexFile.exists()) {
          logView.append("خطا: فایل DEX ایجاد نشد!\n");
          return false;
        }

        return true;
      } catch (Exception e) {
        logView.append("Error to convert to dex: " + e.getMessage() + "\n");
        return false;
      }
    }
  }
}
