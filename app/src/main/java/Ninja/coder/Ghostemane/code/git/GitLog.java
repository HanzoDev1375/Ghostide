package Ninja.coder.Ghostemane.code.git;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.io.File;


public class GitLog {
  public Context context;
  protected GitUtils repository;

  public GitLog(Context context) {
    this.context = context;
    
  }

  public void test() {
    
  }

  protected void DiffyViewer(TextView tv, String output) {
    String[] lines;
    Spannable spannable1 = new SpannableString(output);
    ForegroundColorSpan fgSpan = new ForegroundColorSpan(Color.parseColor("#ffffff"));
    BackgroundColorSpan bgSpan = new BackgroundColorSpan(Color.parseColor("#4caf50"));
    BackgroundColorSpan RbgSpan = new BackgroundColorSpan(Color.parseColor("#d81b69"));

    lines = output.split("\n");
    int x = 0;
    for (int i = 0; i < lines.length; i++) {
      if (lines[i].substring(0, 1).replaceAll("\\s", "").equals("+")) {
        int n = output.indexOf(lines[i]);
        x = n + 1;
        try {
          spannable1.setSpan(fgSpan, n, n + lines[i].length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
          spannable1.setSpan(bgSpan, n, n + lines[i].length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        } catch (Exception e) {
          e.printStackTrace();
        }
      } else if (lines[i].substring(0, 1).replaceAll("\\s", "").equals("-")) {
        int n = output.indexOf(lines[i]);
        x = n + 1;
        try {
          spannable1.setSpan(fgSpan, n, n + lines[i].length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
          spannable1.setSpan(bgSpan, n, n + lines[i].length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
    tv.setText(spannable1);
  }
}
