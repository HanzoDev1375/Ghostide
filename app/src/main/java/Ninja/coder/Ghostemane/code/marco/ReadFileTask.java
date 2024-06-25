package Ninja.coder.Ghostemane.code.marco;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFileTask extends AsyncTask<String, Void, String> {
    private OnReadCompleteListener listener;
    private ProgressBar progressBar;

    public ReadFileTask(OnReadCompleteListener listener, ProgressBar progressBar) {
        this.listener = listener;
        this.progressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected String doInBackground(String... params) {
        StringBuilder sb = new StringBuilder();
        try {
            FileInputStream fis = new FileInputStream(params[0]);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        progressBar.setVisibility(View.GONE);
        if (listener != null) {
            listener.onComplete(result);
        }
    }

    public interface OnReadCompleteListener {
        void onComplete(String content);
    }
}