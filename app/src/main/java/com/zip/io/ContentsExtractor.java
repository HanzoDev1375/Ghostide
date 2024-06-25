package com.balatong.zip.io;

import com.logger.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.balatong.zip.helper.StatsUtil;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

public class ContentsExtractor extends AsyncTask<Object, Object, Integer> {

    final public static String NEW_ENTRY = "NEW_ENTRY";
    final public static String OLD_ENTRY = "OLD_ENTRY";
    final public static String SET_PROGRESS_DIALOG = "SET_PROGRESS_DIALOG";
    final public static String ENTRY_NAME = "ENTRY_NAME";
    final public static String ENTRY_SIZE = "ENTRY_SIZE";
    final public static String BYTES_READ = "BYTES_READ";
    final public static String TOTAL_FILES = "TOTAL_FILES";
    final public static String TOTAL_SIZE = "TOTAL_SIZE";
    final private static int MAX_BYTES = 24 * 1024;
    private Logger logger = Logger.getLogger(ContentsExtractor.class.getName());
    private Context context;
    //	private Map<String, Object> zipEntries;
    private File file;

    public ContentsExtractor(File file, Context context) {
        this.file = file;
//		this.zipEntries = zipEntries;
        this.context = context;
    }

    @Override
    protected Integer doInBackground(Object... params) {
        long current = System.currentTimeMillis();
        Integer extracted = unzipContents((Map<String, Object>) params[0], (String) params[1]);
        logger.debug("Elapsed: " + (System.currentTimeMillis() - current) / 1000 + " secs.");
        return extracted;
    }

//	@Override
//	protected void onPreExecute() {
//		super.onPreExecute();
//		com.balatong.zip.logger.debug("Retrieving stats.");
//		StatsUtil statsUtil = StatsUtil.getInstance();
//		statsUtil.retrieveToBeExtractedStats(zipEntries);
//		LocalBroadcastManager.getInstance(context).sendBroadcast(wrapIntent(
//				ViewerActivity.VA_START_PROCESS_CONTENT, 
//				ViewerActivity.STATUS_TEXT, context.getResources().getString(R.string.extracting_files),
//				ViewerActivity.TITLE_TEXT, context.getResources().getString(R.string.extracting_files),
//				TOTAL_FILES, statsUtil.getNumToBeExtracted(),
//				TOTAL_SIZE, statsUtil.getTotalSizeToBeExtracted()
//		));			
//	}

    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);

    }

    @Override
    protected void onProgressUpdate(Object... values) {
        super.onProgressUpdate(values);

        if (NEW_ENTRY.equals(values[0])) {

        } else if (OLD_ENTRY.equals(values[0])) {

        } else if (SET_PROGRESS_DIALOG.equals(values[0])) {
            StatsUtil statsUtil = StatsUtil.getInstance();
            statsUtil.retrieveToBeExtractedStats((Map<String, Object>) values[1]);

        }
    }

    public Integer unzipContents(Map<String, Object> zipEntries, String extractPath) {
        logger.debug("Extracting to: " + extractPath);
        ZipFile zipFile = null;
        Integer extracted = 0;
        try {
            zipFile = new ZipFile(file);
            publishProgress(SET_PROGRESS_DIALOG, zipEntries);
            extracted = extractContents(zipEntries, zipFile, extractPath);
            return extracted;
        } catch (Exception e) {
            logger.error("Unable to extract files." + e.getMessage(), e);
            return extracted;
        } finally {
            try {
                zipFile.close();
            } catch (Exception e) {
            }
        }
    }

    private Integer extractContents(Map<String, Object> entries, ZipFile zipFile, String extractPath) throws IOException {
        File path = new File(extractPath);
        if (!path.exists())
            if (!path.mkdirs()) {
                String message = "Unable to create directory " + extractPath + ".";
                IOException e = new IOException(message);
                logger.error(message, e);
                throw e;
            }
        int extracted = 0;
        for (Map.Entry<String, Object> entry : entries.entrySet()) {
            if (entry.getValue() instanceof ZipEntry) {

                publishProgress(NEW_ENTRY, entry.getKey(), (int) ((ZipEntry) entry.getValue()).getSize());
                InputStream is = zipFile.getInputStream((ZipEntry) entry.getValue());
                writeFile(entry.getKey(), is, extractPath);
                is.close();
                extracted++;
            } else {
                if (!"..".equals(entry.getKey())) {
                    extracted += extractContents((Map<String, Object>) entry.getValue(), zipFile, extractPath + "/" + entry.getKey());
                }
            }
        }
        return extracted;
    }

    private void writeFile(String key, InputStream is, String extractPath) throws IOException {
        FileOutputStream fos = new FileOutputStream(extractPath + "/" + key);
        byte[] buffer = new byte[MAX_BYTES];
        int count = 0;
        while ((count = is.read(buffer, 0, MAX_BYTES)) > 0) {
            fos.write(buffer, 0, count);
            publishProgress(OLD_ENTRY, count);
        }
        fos.close();
        logger.debug("Written to file: " + extractPath + "/" + key + ".");
    }

    private Intent wrapIntent(String action, Object... extras) {
        Intent intent = new Intent();

        return intent;
    }


}
