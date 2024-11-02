package Ninja.coder.Ghostemane.code.compressor;

import Ninja.coder.Ghostemane.code.utils.DataUtil;
import Ninja.coder.Ghostemane.code.utils.FileUtil;
import android.content.Context;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.sdsmdg.harjot.vectormaster.VectorMasterDrawable;
import com.sdsmdg.harjot.vectormaster.XmlToSvgConverter;
import java.io.File;
import java.io.FileInputStream;

public class XmlToSvg {

  private Context context;
  private String path;
  private String output;
  private CallBack call;

  public XmlToSvg(Context context, String path, CallBack call, String output) {
    this.context = context;
    this.path = path;
    this.call = call;
    this.output = output;

    run();
  }

  void run() {
    var vector = new VectorMasterDrawable(context);
    try {
      FileInputStream fileInput = new FileInputStream(path);
      vector.setInputStream(fileInput);
      if (vector.isVector()) {
        // تغییر مسیر برای ذخیره‌سازی فایل SVG در همان مسیر اصلی
        FileUtil.writeFile(
            path.replaceAll(".xml", ".svg"), // تغییر این خط
            XmlToSvgConverter.xml2svg(FileUtil.readFile(path)));
        call.onFinish();
        dialog(path.replaceAll(".xml", ".svg")); // تغییر این خط
      } else dialog("این تصویر وکتور نیست");
    } catch (Exception err) {
      dialog(err.getLocalizedMessage());
    }
  }

  public interface CallBack {
    void onFinish();
  }

  void dialog(String message) {
    var dialogs = new MaterialAlertDialogBuilder(context);
    dialogs.setMessage(message);
    dialogs.show();
  }
}
