package ir.ninjacoder.ghostide.core.compressor;

import android.content.Context;
import android.util.Log;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.io.FileUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import ir.ninjacoder.ghostide.core.tasks.AsyncTaskCompat;
import ir.ninjacoder.prograsssheet.PrograssSheet;

public class TarGzExtractor {
  private Context context;
  private OnExtractionListener mListener;

  public TarGzExtractor(Context context, OnExtractionListener mListener) {
    this.context = context;
    this.mListener = mListener;
  }

  public void extract(File inputFile, File outputDirectory) {
    new ExtractTask(inputFile, outputDirectory).execute();
  }

  public interface OnExtractionListener {
    void onExtractionComplete();
  }

  protected class ExtractTask extends AsyncTaskCompat<Void, Object, Void> {
    PrograssSheet mProgressDialog = new PrograssSheet(context);
    private File mInputFile;
    private File mOutputDirectory;
    private long mTotalSize;

    ExtractTask(File inputFile, File outputDirectory) {
      mInputFile = inputFile;
      mOutputDirectory = outputDirectory;
      mTotalSize = mInputFile.length();
    }

    @Override
    protected void onPreExecute() {
      super.onPreExecute();
      mProgressDialog.setTitle("Extracting file " + mInputFile.getAbsoluteFile());
      mProgressDialog.show();
    }

    @Override
    protected Void doInBackground(Void... params) {
      try (FileInputStream fis = new FileInputStream(mInputFile);
          BufferedInputStream bis = new BufferedInputStream(fis);
          GzipCompressorInputStream gis = new GzipCompressorInputStream(bis);
          TarArchiveInputStream tis = new TarArchiveInputStream(gis)) {
        TarArchiveEntry entry;
        while ((entry = tis.getNextTarEntry()) != null) {
          File outputFile = new File(mOutputDirectory, entry.getName());
          if (entry.isDirectory()) {
            outputFile.mkdirs();
          } else {
            outputFile.getParentFile().mkdirs();
            try (OutputStream fos = FileUtils.openOutputStream(outputFile)) {
              byte[] buffer = new byte[4096];
              int length;
              long bytesRead = 0;
              while ((length = tis.read(buffer)) != -1) {
                fos.write(buffer, 0, length);
                bytesRead += length;
                int progress = (int) ((bytesRead * 100) / mTotalSize);
                publishProgress(progress, entry.getName());
              }
            }
          }
        }
      } catch (IOException e) {
        // Handle IO exception
        throw new RuntimeException(e.toString());
      }
      return null;
    }

    @Override
    protected void onProgressUpdate(Object... values) {
      super.onProgressUpdate(values);
      int progress = (int) values[0];
      String name = "";
      if (values.length >= 2) {
        name = values[1].toString();
        // use 'name' variable
      } else {
        Log.e("MyApp", "Error: 'values' array does not have at least two elements");
      }
      mProgressDialog.setPrograss(progress, false);
      mProgressDialog.setTitle("Extracting " + name);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
      super.onPostExecute(aVoid);
      mProgressDialog.dismiss();
      mListener.onExtractionComplete();
    }
  }
}
