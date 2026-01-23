package ir.ninjacoder.ghostide.core.git;

import android.content.Context;
import java.io.File;

public class JgitHelperImpl {
  public static void run(String path, Context x) {
    JgitHelper helper = new JgitHelper(new File(path));
    helper.showAddFileDialog(x);
  }
}
