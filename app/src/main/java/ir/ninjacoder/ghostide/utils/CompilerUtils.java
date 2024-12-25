package ir.ninjacoder.ghostide.utils;

import ir.ninjacoder.ghostide.databinding.ZlayoutShowresultcodeBinding;
import ir.ninjacoder.ghostide.enums.Mode;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.xiaoyv.ccompile.compiler.listener.ExecuteListener;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import com.xiaoyv.ccompile.compiler.listener.CompileCallback;
import com.xiaoyv.ccompile.CCppEngine;

/** Soon adding cxx compiler and run in sdk 34 or 35 */
public class CompilerUtils {
  private String path;
  private ZlayoutShowresultcodeBinding bind;
  private Mode mode = Mode.CXX;
  private Context context;

  public CompilerUtils(String path, Mode mode, Context context) {
    this.path = path;
    this.mode = mode;
    this.context = context;
    bind = ZlayoutShowresultcodeBinding.inflate(LayoutInflater.from(context));
    var sheet = new BottomSheetDialog(context);
    sheet.setContentView(bind.getRoot());
    sheet.show();
    init();
  }

  void init() {
    switch (mode) {
      case CXX:
        compileinCpp();
        break;
      case CLANG:
        compileinClang();
        break;
      case WEB:
        runInAsWeb();
        break;
      case NOMOD:
        break;
      default:
        compileinCpp();
        break;
    }
  }

  void runInAsWeb() {
    bind.web.getSettings().setAllowContentAccess(true);
    bind.web.getSettings().setAllowFileAccess(true);
    bind.web.getSettings().setJavaScriptEnabled(true);
    bind.web.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    bind.web.getSettings().setSupportZoom(true);

    String erudaPath = "file:///android_asset/eruda.js";
    String js =
        "(function(){"
            + "var script = document.createElement('script');"
            + "script.src = '"
            + erudaPath
            + "';"
            + "document.body.appendChild(script);"
            + "eruda.init({"
            + "\n"
            + "    defaults: {"
            + "\n"
            + "displaySize: 77,"
            + "\n"
            + "transparency: 1,"
            + "\n"
            + "theme: 'Material Darker'"
            + "\n"
            + "}"
            + "\n"
            + "});"
            + "})();";

    bind.web.loadUrl("file:///" + path);
    bind.web.setWebViewClient(
        new WebViewClient() {
          @Override
          public void onPageStarted(WebView arg0, String a, Bitmap map) {}

          @Override
          public void onPageFinished(WebView web, String url) {
            web.post(() -> web.loadUrl("javascript:" + js));
          }
        });
  }

  void compileinCpp() {
    File cFile = new File(path);
    List<File> files = new ArrayList<>();
    files.add(cFile);

    CCppEngine.getCppCompiler()
        .compile(
            files,
            new CompileCallback() {
              @Override
              public void onSuccess(String outPath) {
                File file = new File(outPath);

                CCppEngine.getCExecutor()
                    .exec(
                        file,
                        new ExecuteListener() {
                          @Override
                          public void onExecuteStart(java.lang.Process process) {}

                          @Override
                          public void printStderr(Throwable error) {

                            bind.myeditorresult.setText(error.getLocalizedMessage());
                          }

                          @Override
                          public void printStdout(CharSequence out) {

                            bind.myeditorresult.setText(out.toString());
                          }

                          @Override
                          public void onExecuteFinish(int waitFor, int exitValue) {}
                        });
              }

              @Override
              public void onError(String error) {}
            });
  }

  void compileinClang() {

    File cFile = new File(path);
    List<File> files = new ArrayList<>();
    files.add(cFile);

    CCppEngine.getCCompiler()
        .compile(
            files,
            new CompileCallback() {
              @Override
              public void onSuccess(String outPath) {
                File file = new File(outPath);

                CCppEngine.getCExecutor()
                    .exec(
                        file,
                        new ExecuteListener() {
                          @Override
                          public void onExecuteStart(java.lang.Process process) {}

                          @Override
                          public void printStderr(Throwable error) {
                            bind.myeditorresult.setText(error.getLocalizedMessage());
                          }

                          @Override
                          public void printStdout(CharSequence out) {

                            bind.myeditorresult.setText(out.toString());
                          }

                          @Override
                          public void onExecuteFinish(int waitFor, int exitValue) {}
                        });
              }

              @Override
              public void onError(String error) {}
            });
  }
}
