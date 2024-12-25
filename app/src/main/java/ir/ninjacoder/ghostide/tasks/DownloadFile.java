package ir.ninjacoder.ghostide.tasks;

import android.os.AsyncTask;
import android.os.Environment;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.regex.Pattern;

public class DownloadFile extends AsyncTask<Integer, Integer, Void> {
    long downloaded = 0;
    int index;
    long length = 0;
    int progress = 0;
    File destinationFile;
    String url;
    ProgressBar progressBar;
    TextView textView;
    private onDownloadListener listener;

    public DownloadFile(String url, String destinationPath) {
        this.url = url;
        destinationFile = new File(destinationPath);
        this.progress = 0;
    }

    public static File getFolderDownload() {
        File file = new File(Environment.getExternalStorageDirectory(), "Downloads");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static boolean find(String str, String str2) {
        return Pattern.compile(str2).matcher(str).find();
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
    }

    public DownloadFile attachTextProgress(TextView text) {
        this.textView = text;
        return this;
    }

    public DownloadFile attachProgress(ProgressBar progressBar) {
        this.progressBar = progressBar;
        progressBar.setMax(100);
        return this;
    }

    public Void doInBackground(Integer... numArr) {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        try {
            byte[] bArr = new byte[4096];
            this.index = numArr[0].intValue();

            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.url).openConnection();
            httpURLConnection.setConnectTimeout(10000);
            if (this.downloaded == 0) {
                httpURLConnection.connect();
                if (httpURLConnection.getHeaderField("Last-Modified") != null) {
                }
                this.length = httpURLConnection.getContentLength();

                if (httpURLConnection.getResponseCode() / 100 != 2) {
                }
            } else {
                httpURLConnection.setRequestProperty("Range", "bytes=" + this.downloaded + "-");
                httpURLConnection.setRequestProperty("If-Range", destinationFile.getName());
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() == 200) {
                    this.downloaded = 0L;
                } else if (httpURLConnection.getResponseCode() != 206) {
                    // download error
                }
                this.length = httpURLConnection.getContentLength();
            }
            if (httpURLConnection.getResponseCode() / 100 != 2) {
                // download problem
            }
            if (httpURLConnection.getContentLength() < 1) {
                // download problem
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(destinationFile, "rw");
            randomAccessFile.seek(this.downloaded);
            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                downloaded += read;
                int i = (int) ((downloaded * 100) / length);
                this.progress = i;
                publishProgress(Integer.valueOf(i));
                randomAccessFile.write(bArr, 0, read);
                bArr = bArr;
            }
            if (this.progress != 100) {
                return null;
            }
            randomAccessFile.close();
            inputStream.close();
            // download finish
            return null;
        } catch (Exception unused) {
            if (listener != null) {
                listener.onErrorListener(unused.getMessage());
            }
            return null;
        }
    }

    public void onProgressUpdate(Integer... numArr) {
        // update progress
        if (textView != null) {
            textView.setText(numArr[0] + "% [" + convertBytes(this.downloaded) + "/" + convertBytes(length) + "]");
        }
        if (progressBar != null) {
            progressBar.setProgress(numArr[0]);
        }
        if (listener != null) {
            listener.onProgressListener(numArr[0], convertBytes(length));
        }
    }

    public void onPostExecute(Void r7) {
        // 100%
        if (progressBar != null) {
            Toast.makeText(progressBar.getContext(), "Done !", Toast.LENGTH_SHORT).show();
        }
        if (listener != null) {
            listener.onCompleteListener();
        }
    }

    public String getFilename(String str) {
        String str2;
        String substring = str.substring(str.lastIndexOf("/") + 1);
        if (!find(substring, "\\.") || find(substring, "\\?") || substring.length() < 3) {
            str2 = "file";
            if (new File(getFolderDownload(), str2).exists()) {
                String str3 = str2 + 1;
                File file = new File(getFolderDownload(), str3);
                int i = 1;
                while (file.exists()) {
                    i++;
                    str3 = str2 + i;
                    file = new File(getFolderDownload(), str3);
                }
                return str3;
            }
        } else if (!new File(getFolderDownload(), substring).exists()) {
            return substring;
        } else {
            String extension = getExtension(substring);
            String substring2 = substring.substring(0, substring.lastIndexOf("."));
            str2 = substring2 + "(1)." + extension;
            File file2 = new File(getFolderDownload(), str2);
            int i2 = 1;
            while (file2.exists()) {
                i2++;
                str2 = substring2 + "(" + i2 + ")." + extension;
                file2 = new File(getFolderDownload(), str2);
            }
        }
        return str2;
    }

    public String getExtension(String str) {
        if (str.contains("."))
            return str.substring(str.lastIndexOf("."), str.length());
        else
            return "";
    }

    private String convertBytes(long bytesLength) {
        String size = "";
        double bytes = bytesLength;
        double kilobytes = (bytes / 1024);
        double megabytes = (kilobytes / 1024);
        double gigabytes = (megabytes / 1024);
        double result = Double.parseDouble(new DecimalFormat("##.##").format(megabytes));
        if (result < 1000) {
            size = result + " MG";
        } else {
            double result2 = Double.parseDouble(new DecimalFormat("##.##").format(gigabytes));
            size = result2 + " GB";
        }
        return size;
    }

    public DownloadFile setListener(onDownloadListener listener) {
        this.listener = listener;
        return this;
    }

    public interface onDownloadListener {
        void onProgressListener(int progress, String lengthFiles);

        void onCompleteListener();

        void onErrorListener(String errorMessage);
    }

}

