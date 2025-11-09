package com.zip.io;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.logger.Logger;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ContentsInserter extends AsyncTask<Object, Object, Integer> {

    final public static String NEW_ENTRY = "NEW_ENTRY";
    final public static String OLD_ENTRY = "OLD_ENTRY";
    final public static String SET_PROGRESS_DIALOG = "SET_PROGRESS_DIALOG";
    final public static String ENTRY_SIZE = "ENTRY_SIZE";
    final public static String BYTES_READ = "BYTES_READ";
    final public static String TOTAL_FILES = "TOTAL_FILES";
    final public static String TOTAL_SIZE = "TOTAL_SIZE";
    final private static int MAX_BYTES = 24 * 1024;
    private Logger logger = Logger.getLogger(ContentsInserter.class.getName());
    private File file;
    private Context context;

    public ContentsInserter(File file, Context context) {
        this.file = file;
        this.context = context;
    }

    @Override
    protected Integer doInBackground(Object... params) {
        String workingDirectory = (String) params[0];
        if (workingDirectory.startsWith("/"))
            workingDirectory = workingDirectory.substring(1);

        File paths[] = new File[params.length - 1];
        for (int i = 1; i < params.length; i++)
            paths[i - 1] = new File((String) params[i]);
        return insertEntries(workingDirectory, paths);
    }

//	@Override
//	protected void onPreExecute() {
//		super.onPreExecute();
//		com.balatong.zip.logger.debug("Retrieving stats.");
//		StatsUtil statsUtil = StatsUtil.getInstance();
//		statsUtil.retrieveToBeExtractedStats(zipEntries);
//		LocalBroadcastManager.getInstance(context).sendBroadcast(wrapIntent(
//				ViewerActivity.VA_START_PROCESS_CONTENT, 
//				ViewerActivity.STATUS_TEXT, context.getResources().getString(R.string.adding_file),
//				ViewerActivity.TITLE_TEXT, context.getResources().getString(R.string.adding_file),
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

        }
    }

    private Integer insertEntries(String workingDirectory, File... path) {
        File tempPath = new File("/sdcard/tmp");
        if (!tempPath.exists())
            if (!tempPath.mkdirs()) {
                String message = "Unable to create directory " + tempPath + ".";
                logger.debug(message);
                return 0;
            }

        ZipFile zipFile = null;
        ZipOutputStream zos = null;
        File tempFile = null;
        try {
            tempFile = File.createTempFile("zipper", null, tempPath);
            zipFile = new ZipFile(file);

            List<? extends ZipEntry> zipEntries = Collections.list(zipFile.entries());
            Map<String, ZipEntry> newZipEntries = createZipEntries(workingDirectory, path);
            publishProgress(SET_PROGRESS_DIALOG, zipEntries.size() + newZipEntries.size(), zipEntries.size() + newZipEntries.size());

            for (ZipEntry zipEntry : zipEntries) {
                logger.debug("Old entries: " + zipEntry.getName());
            }
            for (Map.Entry<String, ZipEntry> entry : newZipEntries.entrySet()) {
                logger.debug("New entries: " + entry.getKey() + " | " + entry.getValue().getName());
            }

            zos = new ZipOutputStream(new FileOutputStream(tempFile));
            for (ZipEntry zipEntry : zipEntries) {
                publishProgress(NEW_ENTRY, zipEntry.getName(), (int) zipEntry.getSize());
                InputStream is = zipFile.getInputStream(zipEntry);
                writeEntry(zipEntry, is, zos);
                is.close();
            }

            int writtenEntries = 0;

            for (Map.Entry<String, ZipEntry> entry : newZipEntries.entrySet()) {
                publishProgress(NEW_ENTRY, entry.getKey(), (int) ((ZipEntry) entry.getValue()).getSize());
                InputStream is = new FileInputStream(entry.getKey());
                writtenEntries += writeEntry(entry.getValue(), is, zos);
                is.close();
            }

            file.delete();
            tempFile.renameTo(file);
            return writtenEntries;
        } catch (IOException e) {
            logger.error("Unable to modify com.balatong.zip.zip file.", e);
            return 0;
        } finally {
            try {
                zos.close();
                zipFile.close();
            } catch (Exception e) {
            }
        }
    }

    private int writeEntry(ZipEntry zipEntry, InputStream is, ZipOutputStream zos) {
        ByteArrayOutputStream bos = null;
        try {
            bos = new ByteArrayOutputStream();

            if (zipEntry.isDirectory()) {
                zos.putNextEntry(zipEntry);
                return 1;
            }

            CRC32 crc32 = new CRC32();
            byte buffer[] = new byte[MAX_BYTES];
            int count = 0;
            int readTotal = 0;
            while ((count = is.read(buffer, 0, MAX_BYTES)) > 0) {
                bos.write(buffer, 0, count);
                crc32.update(buffer, 0, count);
                publishProgress(OLD_ENTRY, count);
                readTotal += count;
            }
            zipEntry.setCrc(crc32.getValue());
            zipEntry.setSize(readTotal);
            zipEntry.setTime(System.currentTimeMillis());
            zos.putNextEntry(zipEntry);
            zos.write(bos.toByteArray(), 0, bos.size());

            return 1;
        } catch (IOException e) {
            logger.error("Unable to write com.balatong.zip.zip entry: " + zipEntry.getName(), e);
            return 0;
        } finally {
            try {
                zos.closeEntry();
                bos.close();
            } catch (Exception e) {
            }
        }
    }

    private Map<String, ZipEntry> createZipEntries(String workingDirectory, File... paths) {
        Map<String, ZipEntry> newZipEntries = new HashMap<String, ZipEntry>();

        if (workingDirectory.startsWith("/"))
            workingDirectory = workingDirectory.substring(1);

        for (File addPath : paths) {
            if (!addPath.exists()) {
                return newZipEntries;
            }

            String fname = addPath.getName();
            if (addPath.isDirectory()) {
                newZipEntries.putAll(createZipEntries(
                        workingDirectory + "/" + fname,
                        addPath.listFiles()));
            } else {
                ZipEntry zipEntry = new ZipEntry(
                        "".equals(workingDirectory) ?
                                fname :
                                workingDirectory + "/" + fname);
                newZipEntries.put(addPath.getPath(), zipEntry);
            }
        }
        return newZipEntries;
    }

    private Intent wrapIntent(String action, Object... extras) {
        Intent intent = new Intent();

        return intent;
    }


}
