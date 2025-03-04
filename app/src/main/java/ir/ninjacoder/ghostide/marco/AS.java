package ir.ninjacoder.ghostide.marco;

import ir.ninjacoder.ghostide.utils.ObjectUtils;
import android.content.Context;
import android.widget.TextView;
import com.mcal.apksigner.ApkSigner;
import ir.ninjacoder.prograsssheet.PrograssSheet;
import java.io.File;

public class AS {

  public static final String THEMEPATH = "/storage/emulated/0/GhostWebIDE/theme/";
  private static PrograssSheet compat;

  public static void runs(String input, CallBack back, Context context) {
    compat = new PrograssSheet(context);
    compat.setTitle("Singe File " + input.trim());
    compat.show();

    new Thread(
            () -> {
              var signer = new ApkSigner(new File(input), new File(getOutputFileName(input)));
              signer.setUseDefaultSignatureVersion(false);
              signer.setV1SigningEnabled(true);
              signer.setV2SigningEnabled(true);
              signer.setV3SigningEnabled(true);
              signer.setV4SigningEnabled(false);
              signer.signDebug();
              ObjectUtils.runOnUiThread(
                  () -> {
                    if (compat.isShowing()) compat.dismiss();
                    back.end();
                  });
            })
        .start();
  }

  private static String getOutputFileName(String inputFileName) {
    int extensionIndex = inputFileName.lastIndexOf(".");
    if (extensionIndex != -1) {
      return inputFileName.substring(0, extensionIndex) + "_signedbyGhostWeb.apk";
    } else {
      return inputFileName + "_signedbyGhostWeb.apk";
    }
  }

  @Deprecated
  public static void SAF(String directoryPath, String typeName, TextView view) {}

  public static interface CallBack {
    void end();
  }
}
