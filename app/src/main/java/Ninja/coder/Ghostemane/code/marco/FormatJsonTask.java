package Ninja.coder.Ghostemane.code.marco;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

public class FormatJsonTask extends AsyncTask<Void, Void, String> {

    private String code;
    private ProgressBar progressBar;
    private OnJsonFormattedListener listener;

    public FormatJsonTask(ProgressBar progressBar, String code, OnJsonFormattedListener listener) {
        this.progressBar = progressBar;
        this.code = code;
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected String doInBackground(Void... voids) {
        return formatJson(code);
    }

    @Override
    protected void onPostExecute(String formattedJson) {
        super.onPostExecute(formattedJson);
        progressBar.setVisibility(View.GONE);

        if (listener != null) {
            listener.onJsonFormatted(formattedJson);
        }
    }

    private String formatJson(String code) {

        return code;
    }

    public interface OnJsonFormattedListener {
        void onJsonFormatted(String formattedJson);
    }
}
