package ir.ninjacoder.ghostide.core.utils;

import android.view.View;
import android.widget.ProgressBar;

import com.blankj.utilcode.util.ThreadUtils;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import io.github.rosemoe.sora.widget.CodeEditor;

public class FileCompatApi28 {

  public static void readFile(String fileRead, ProgressBar bar, CodeEditor editText) {
    ShowBar(bar, true);

    ThreadUtils.executeByIo(
        new ThreadUtils.SimpleTask<String>() {
          @Override
          public String doInBackground() {

            try (RandomAccessFile raf = new RandomAccessFile(fileRead, "r")) {
              FileChannel channel = raf.getChannel();
              long fileSize = channel.size();
              MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, fileSize);

              int chunkSize = 1024 * 1024;
              byte[] chunk = new byte[chunkSize];
              int remaining;
              StringBuilder sb = new StringBuilder();

              for (int pos = 0; pos < fileSize; pos += chunkSize) {
                remaining = (int) Math.min(chunkSize, fileSize - pos);
                buffer.get(chunk, 0, remaining);
                sb.append(new String(chunk, 0, remaining));

                return sb.toString();
              }
            } catch (Exception e) {
              return e.getLocalizedMessage();
            }
            return "";
          }

          @Override
          public void onSuccess(String result) {
            ShowBar(bar, false);
            ThreadUtils.runOnUiThread(() -> editText.setText(result));
          }

          @Override
          public void onFail(Throwable throwable) {
            editText.setText(throwable.getLocalizedMessage());
            ShowBar(bar, false);
          }

          @Override
          public void onCancel() {}
        });
  }

  private static void ShowBar(ProgressBar bar, boolean show) {
    bar.setVisibility(show ? View.VISIBLE : View.GONE);
  }
}
