package ir.ninjacoder.ghostide.marco;

import android.content.Context;
import android.util.Log;
import ir.ninjacoder.ghostide.interfaces.OnJadxCallBack;
import ir.ninjacoder.ghostide.tasks.AsyncTaskCompat;
import ir.ninjacoder.prograsssheet.PrograssSheet;
import ir.ninjacoder.prograsssheet.enums.StateMod;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jadx.api.JadxArgs;

import jadx.api.impl.NoOpCodeCache;
import jadx.api.security.JadxSecurityFlag;
import jadx.api.security.impl.JadxSecurity;

public class JadxDecompiler {

  private Context context;
  private String inputDexorApkFile;
  private String outputDir;
  private OnJadxCallBack call;

  public JadxDecompiler(
      Context context, String inputDexorApkFile, String outputDir, OnJadxCallBack call) {
    this.context = context;
    this.inputDexorApkFile = inputDexorApkFile;
    this.outputDir = outputDir;
    this.call = call;
    new DecompileTask(context, inputDexorApkFile, call, outputDir).execute();
  }

  @SuppressWarnings("deprecation")
  private static class DecompileTask extends AsyncTaskCompat<Void, Integer, String> {
    private Context context;
    private String apkFile;
    private PrograssSheet progressDialog;
    private OnJadxCallBack jadxcallBack;
    private String output;

    public DecompileTask(
        Context context, String apkFile, OnJadxCallBack jadxcallBack, String output) {
      this.context = context;
      this.apkFile = apkFile;
      this.output = output;
      this.jadxcallBack = jadxcallBack;
    }

    @Override
    protected void onPreExecute() {
      super.onPreExecute();
      progressDialog = new PrograssSheet(context);
      progressDialog.setMode(StateMod.PROGRASSV);
      progressDialog.setCancelable(false);
      progressDialog.show();
    }

    @Override
    protected String doInBackground(Void... voids) {
      try {
        File sampleFile = new File(apkFile);
        File outDir = new File(output);

        JadxArgs jadxArgs = new JadxArgs();
        jadxArgs.setInputFiles(List.of(sampleFile));
        jadxArgs.setOutDir(outDir);
        jadxArgs.setThreadsCount(1); // reduce memory usage
        jadxArgs.setCodeCache(NoOpCodeCache.INSTANCE); // code cache not needed

        // disable secure xml parser (some features not supported on Android)
        JadxSecurityFlag[] securityFlags = JadxSecurityFlag.values();
        Set<JadxSecurityFlag> updatedFlags =
            new HashSet<>(
                Arrays.asList(removeFlag(securityFlags, JadxSecurityFlag.SECURE_XML_PARSER)));
        jadxArgs.setSecurity(new JadxSecurity(updatedFlags));

        // (Optional) Class set tree loading can take too much time,
        // but disabling it can reduce result code quality
        jadxArgs.setLoadJadxClsSetFile(false);

        try (jadx.api.JadxDecompiler jadx = new jadx.api.JadxDecompiler(jadxArgs)) {
          jadx.load();
          jadx.save();
          jadx.save(
              1000,
              (i, total) -> {
                publishProgress((int) total);
              });

          // Publish progress
          //   publishProgress(fileCount);

          return "Decompilation Complete. Total Decompiled Files: ";
        }
      } catch (Throwable e) {
        return "Decompile error: " + e.getMessage();
      }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
      super.onProgressUpdate(values);
      progressDialog.setTitle("Decompiling... " + values[0] + " files processed.");
      progressDialog.setPrograss(values[0], false);
    }

    @Override
    protected void onPostExecute(String result) {
      super.onPostExecute(result);
      progressDialog.dismiss();
      jadxcallBack.reset(result != null ? true : false);
      Log.d("Decompile Result", result);
    }
  }

  private static JadxSecurityFlag[] removeFlag(
      JadxSecurityFlag[] flags, JadxSecurityFlag flagToRemove) {
    return Arrays.stream(flags)
        .filter(flag -> flag != flagToRemove)
        .toArray(JadxSecurityFlag[]::new);
  }
}
