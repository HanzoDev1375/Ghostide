package ninjacoder.ghostide.androidtools.r8.android;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.android.tools.r8.D8;
import com.android.tools.r8.D8Command;
import com.android.tools.r8.Diagnostic;
import com.android.tools.r8.DiagnosticsHandler;
import com.android.tools.r8.OutputMode;
import com.android.tools.r8.CompilationMode;
import ir.ninjacoder.prograsssheet.PrograssSheet;
import java.nio.file.Paths;
public class R8Tools {
  public static final String ANDROIDJARPATH = "/storage/emulated/0/GhostWebIDE/android/android.jar";

  public void onlyCompile(
      String input, String output, int api, Context context, OnItemChange item) {
    var dialog = new PrograssSheet(context);
    dialog.setTitle("JAR to DEX using R8 tools");
    dialog.setCancelable(false);
    dialog.show();

    new Thread(
            () -> {
              try {

                var command =
                    D8Command.builder(new CustomDiagnosticsHandler(dialog))
                        .setMode(CompilationMode.RELEASE)
                        .addLibraryFiles(Paths.get(ANDROIDJARPATH))
                        .addProgramFiles(Paths.get(input))
                        .setMinApiLevel(api)
                        .setOutput(Paths.get(output), OutputMode.DexIndexed)
                        .build();

                D8.run(command);

                runOnUiThread(
                    () -> {
                      dialog.setTitle("Done");
                      dialog.dismiss();
                      item.onItemResult();
                    });

              } catch (Exception err) {
                runOnUiThread(
                    () -> {
                      dialog.setTitle("Error: " + err.getLocalizedMessage());
                    });
              }
            })
        .start();
  }

  private void runOnUiThread(Runnable runnable) {
    new Handler(Looper.getMainLooper()).post(runnable);
  }

  public interface OnItemChange {
    void onItemResult();
  }

  class CustomDiagnosticsHandler implements DiagnosticsHandler {
    private final PrograssSheet dialog;

    public CustomDiagnosticsHandler(PrograssSheet dialog) {
      this.dialog = dialog;
    }

    @Override
    public void info(Diagnostic diagnostic) {
      runOnUiThread(
          () -> {
            dialog.setTitle(diagnostic.getDiagnosticMessage());
          });
    }

    @Override
    public void warning(Diagnostic diagnostic) {
      runOnUiThread(
          () -> {
            dialog.setTitle("Warning: " + diagnostic.getDiagnosticMessage());
          });
    }

    @Override
    public void error(Diagnostic diagnostic) {
      runOnUiThread(
          () -> {
            dialog.setTitle("Error: " + diagnostic.getDiagnosticMessage());
          });
    }
  }
}
