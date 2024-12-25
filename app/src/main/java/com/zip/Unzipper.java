package com.balatong.zip;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import com.balatong.zip.io.ContentsDeleter;
import com.balatong.zip.io.ContentsExtractor;
import com.balatong.zip.io.ContentsInserter;
import com.balatong.zip.io.CrcValidator;
import com.balatong.zip.io.FileReader;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
// import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import ir.ninjacoder.ghostide.R;

public class Unzipper {

    private Context context;
    // private static com.balatong.logger.Logger logger =
    // com.balatong.logger.Logger.getLogger(UnzipperService.class.getName());

    private Map<String, Object> zipEntries = new HashMap<String, Object>();

    private File file;

    //	private CrcValidator crcValidator;
    private UnzipListener listener;
    private FileReader fileReader;
    private FileReader.UnzipListener unzipListener =
            new FileReader.UnzipListener() {
                @Override
                public void onStart() {
                    if (listener != null) {
                        listener.onStart();
                    }
                }

                @Override
                public void onProgress() {
                    if (listener != null) {
                        listener.onProgress();
                    }
                }

                @Override
                public void onFinish(Map<String, Object> result) {
                    zipEntries = result;
                    if (listener != null) {
                        listener.onFinish(result);
                    }
                }

                @Override
                public void onError(String errorMessage) {
                    if (listener != null) {
                        listener.onError(errorMessage);
                    }
                }
            };

    public Unzipper(File zipFile, Context context) {
        file = zipFile;
        fileReader = new FileReader(context);
        fileReader.setUnzipListener(unzipListener);
        fileReader.execute(file);
        this.context = context;
    }

    public File getFile() {
        return file;
    }

    public void crcCheckZipFile() {
        crcCheck();
    }

    public void closeZipFile() {
        closeFile();
    }

    public Map<String, Object> getResult() {
        return getEntries();
    }

    public void extractZipEntries(Map<String, Object> checkedZipEntries, String extractPath) {
        ContentsExtractor extractor = new ContentsExtractor(file, context);
        extractor.execute(checkedZipEntries, extractPath);
    }

    public void addZipEntries(String currentDirectory, String addPath) {
        ContentsInserter updater = new ContentsInserter(file, context);
        updater.execute(currentDirectory, addPath);
    }

    public void deleteZipEntries(Map<String, Object> checkedZipEntries) {
        ContentsDeleter updater = new ContentsDeleter(file, context);
        updater.execute(checkedZipEntries);
    }

    private void crcCheck() {
        CrcValidator crcValidator = new CrcValidator(file, context);
        crcValidator.execute(getEntries());
    }

    private Intent wrapIntent(String action, Object... extras) {
        Intent intent = new Intent();

        return intent;
    }

    private Integer readFileZip() {
        ZipFile zipFile = null;
        ;
        try {
            // logger.info("Opening up " + file.getName() + ".");
            zipFile = new ZipFile(file);
        } catch (IOException e) {
            if (listener != null) {
                listener.onError(e.toString());
            }
            return 0;
        }

        try {
            Enumeration<? extends java.util.zip.ZipEntry> entries = zipFile.entries();
            int numFiles = 0;
            while (entries.hasMoreElements()) {
                java.util.zip.ZipEntry entry = entries.nextElement();
                buildStructure(entry);
                // publishProgress(numFiles++);
            }
            // logger.info("Read " + numFiles + " entries.");
            postBuildStructure();
            return numFiles;
        } catch (Exception e) {
            if (listener != null) {
                listener.onError(e.toString());
            }
            return 0;
        } finally {
            // logger.info("Closing " + zipFile.getName() + ".");
            try {
                if (zipFile != null) zipFile.close();
            } catch (IOException e) {
                if (listener != null) {
                    listener.onError(e.toString());
                }
            }
        }
    }

    private void buildStructure(java.util.zip.ZipEntry entry) {
        String name = entry.getName();
        //		com.balatong.zip.logger.debug("Reading N:" + name + " S:" + entry.getSize() + " CS:" +
        // entry.getCompressedSize() + " T:" + entry.getTime());
        boolean isFile = true;
        if (name.endsWith("/")) isFile = false;
        String[] paths = name.split("/");

        Map<String, Object> parent = zipEntries;
        for (int i = 0; i < paths.length - 1; i++) {
            if (parent.containsKey(paths[i])) {
                parent = (Map<String, Object>) parent.get(paths[i]);
            } else {
                Map<String, Object> child = new HashMap<String, Object>();
                parent.put(paths[i], child);
                parent = child;
            }
        }
        if (isFile) parent.put(paths[paths.length - 1], entry);
    }

    private void postBuildStructure() {
        Map<String, Object> parent = zipEntries;
        amendStructure(parent);
    }

    private void amendStructure(Map<String, Object> parent) {
        for (Map.Entry<String, Object> entry : parent.entrySet()) {
            if (entry.getValue() instanceof Map) {
                amendStructure((Map<String, Object>) entry.getValue());
                ((Map<String, Object>) entry.getValue()).put("..", parent);
            }
        }
    }

    public Map<String, Object> getEntries() {
        return zipEntries;
    }

    public void closeFile() {
    }

    public void setUnzipListener(UnzipListener unzipListener) {
        listener = unzipListener;
    }

    public interface UnzipListener {
        void onStart();

        void onProgress();

        void onFinish(Map<String, Object> result);

        void onError(String errorMessage);
    }
}
