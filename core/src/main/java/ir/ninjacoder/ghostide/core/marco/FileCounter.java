package ir.ninjacoder.ghostide.core.marco;

import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import ir.ninjacoder.ghostide.core.tasks.AsyncTaskCompat;

public class FileCounter extends AsyncTaskCompat<String, Void, String> {
  private TextView textView;

  public FileCounter(TextView textView) {
    this.textView = textView;
  }

  @Override
  protected void onPreExecute() {
    super.onPreExecute();
    textView.setVisibility(View.GONE);
  }

  @Override
  protected String doInBackground(String... params) {
    try {
      Path path = Paths.get(params[0]);

      List<Path> fileList = Files.list(path).collect(Collectors.toList());

      if (fileList.isEmpty()) {

        return "Folder   : 0 File  : 0 Size  : 0 KB";
      } else {

        long folderCount = fileList.stream().parallel().filter(Files::isDirectory).count();
        long fileCount = fileList.stream().parallel().filter(Files::isRegularFile).count();

        long totalSize =
            fileList.stream()
                .parallel()
                .filter(Files::isRegularFile)
                .mapToLong(file -> file.toFile().length())
                .sum();

        String size = formatSize(totalSize);

        return "Folder  : " + folderCount + " File : " + fileCount + " Size : " + size;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }

  @Override
  protected void onPostExecute(String result) {
    super.onPostExecute(result);
    textView.setText(result);
    textView.setVisibility(View.VISIBLE);
  }

  private String formatSize(long bytes) {
    if (bytes < 1024) {
      return bytes + " B";
    } else if (bytes < 1024 * 1024) {
      return String.format("%.2f KB", bytes / 1024.0);
    } else if (bytes < 1024 * 1024 * 1024) {
      return String.format("%.2f MB", bytes / (1024.0 * 1024));
    } else {
      return String.format("%.2f GB", bytes / (1024.0 * 1024 * 1024));
    }
  }
}
