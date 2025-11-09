package com.zip.io;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


public class FileReader extends AsyncTask<File, Object, Map<String, Object>> {

    //private static Logger logger = Logger.getLogger(FileReader.class.getName());

    private Context context;
    private File file;
    private Map<String, Object> zipEntries = new HashMap<String, Object>();
    private UnzipListener listener;

    public FileReader(Context ctx) {
        this.context = ctx;
    }

    @Override
    protected Map<String, Object> doInBackground(File... file) {
        int numFiles = readFile(file[0]);
        return zipEntries;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (listener != null) {
            listener.onStart();
        }
    }

    @Override
    protected void onPostExecute(Map<String, Object> result) {
        super.onPostExecute(result);
        if (listener != null) {
            listener.onFinish(result);
        }
    }

    @Override
    protected void onProgressUpdate(Object... progress) {
        super.onProgressUpdate(progress);
        if (listener != null) {
            listener.onProgress();
        }
    }

    public Map<String, Object> getEntries() {
        return zipEntries;
    }

    private Integer readFile(File file) {
        this.file = file;
        ZipFile zipFile = null;
        ;
        try {
            //logger.info("Opening up " + file.getName() + ".");
            zipFile = new ZipFile(file);
        } catch (IOException e) {
            //logger.error("Unable to open " + file.getName() + ".", e);
            return 0;
        }

        try {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            int numFiles = 0;
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                buildStructure(entry);
                publishProgress(numFiles++);
            }
            //logger.info("Read " + numFiles + " entries.");
            postBuildStructure();
            return numFiles;
        } catch (Exception e) {
            //logger.error(e.getMessage(), e);
            return 0;
        } finally {
            //logger.info("Closing " + zipFile.getName() + ".");
            try {
                if (zipFile != null)
                    zipFile.close();
            } catch (IOException e) {
            }
        }
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

    private void buildStructure(ZipEntry entry) {
        String name = entry.getName();
//		com.balatong.zip.logger.debug("Reading N:" + name + " S:" + entry.getSize() + " CS:" + entry.getCompressedSize() + " T:" + entry.getTime());
        boolean isFile = true;
        if (name.endsWith("/"))
            isFile = false;
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
        if (isFile)
            parent.put(paths[paths.length - 1], entry);
    }

    private Intent wrapIntent(String action, Object... extras) {
        Intent intent = new Intent();

        return intent;
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
