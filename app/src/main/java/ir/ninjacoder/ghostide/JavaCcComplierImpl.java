package ir.ninjacoder.ghostide;

import ir.ninjacoder.ghostide.tasks.AsyncTaskCompat;
import android.content.Context;
import android.widget.Toast;

public class JavaCcComplierImpl {

  // dont adding #FileUtil.read adding file Path

  public static void main(String input, String output) {
    String[] item = {"-JDK_VERSION=1.8", "-OUTPUT_DIRECTORY=" + output, "-STATIC=false", input};
    new TaskCompileJavacc().execute(item);
    for (var it : item) {
      // Toast.makeText(GhostIdeAppLoader.getContext(),it,2).show();
    }
  }

  private static class TaskCompileJavacc extends AsyncTaskCompat<String, Void, Integer> {

    @Override
    protected Integer doInBackground(String[] params) {
      try {
        return JavaCcCompiler.mainProgram(params, GhostIdeAppLoader.getContext());
      } catch (Exception err) {
        return -1;
      }
    }

    @Override
    protected void onPostExecute(Integer result) {
      Context ctx = GhostIdeAppLoader.getContext();
      Toast.makeText(ctx, String.valueOf(result), 2).show();
    }
  }
}
