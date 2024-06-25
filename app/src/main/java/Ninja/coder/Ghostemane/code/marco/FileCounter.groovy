package Ninja.coder.Ghostemane.code.marco

import Ninja.coder.Ghostemane.code.tasks.AsyncTaskCompat
import android.view.View
import android.widget.TextView

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.stream.Collectors

class FileCounter extends AsyncTaskCompat<String, Void, String> {
    private TextView textView

    FileCounter(TextView textView) {
        this.textView = textView
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute()
        textView.visibility = View.GONE
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            Path path = Paths.get(params[0])

            // Get list of all files and directories in the directory
            List<Path> fileList = Files.list(path).collect(Collectors.toList())

            if (fileList.isEmpty()) {
                // If no files or directories found, return "Folder : 0 Files: 0"
                return "Folder : 0 File : 0"
            } else {
                // Get the number of folders and files in the directory
                def folderCount = fileList.stream().parallel().filter(Files.&isDirectory).count()

                def fileCount = fileList.stream().parallel().filter(Files.&isRegularFile).count()

                return "Folder : $folderCount File : $fileCount"
            }
        } catch (IOException e) {
            e.printStackTrace()
        }

        return null
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result)
        textView.text = result

        textView.visibility = View.VISIBLE
    }
}