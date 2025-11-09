package com.zip.io;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.logger.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.zip.CRC32;

public class DigestExtractor extends AsyncTask<File, Void, HashMap<String, String>> {

    public static final String MD5 = "MD5";
    public static final String SHA1 = "SHA1";
    public static final String CRC = "CRC";
    private Logger logger = Logger.getLogger(DigestExtractor.class.getName());
    private Context context;

    public DigestExtractor(Context context) {
        this.context = context;
    }

    @Override
    protected HashMap<String, String> doInBackground(File... params) {
        HashMap<String, String> digest = new HashMap<String, String>();

        File file = params[0];
        MessageDigest md5 = null;
        MessageDigest sha1 = null;
        CRC32 crc32 = null;
        InputStream is = null;

        try {
            md5 = MessageDigest.getInstance("MD5");
            sha1 = MessageDigest.getInstance("SHA1");
            crc32 = new CRC32();
            is = new FileInputStream(file);

            int count = 0;
            byte buffer[] = new byte[24 * 1024];
            while ((count = is.read(buffer)) > 0) {
                md5.update(buffer, 0, count);
                sha1.update(buffer, 0, count);
                crc32.update(buffer, 0, count);
            }

            StringBuilder md5Builder = new StringBuilder();
            for (byte b : md5.digest()) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 2) md5Builder.append(hex);
                else md5Builder.append("0" + hex);
                logger.debug(hex);
            }
            digest.put("MD5", md5Builder.toString());

            StringBuilder sha1Builder = new StringBuilder();
            for (byte b : sha1.digest()) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 2) sha1Builder.append(hex);
                else sha1Builder.append("0" + hex);
                logger.debug(hex);
            }
            digest.put("SHA1", sha1Builder.toString());

            digest.put("CRC", Long.toString(crc32.getValue()));

            return digest;
        } catch (Exception e) {
            digest.put("MD5", "Unable to read md5sum.");
            digest.put("SHA1", "Unable to read sha1sum.");
            digest.put("CRC", "Unable to read sha1sum.");
            return digest;
        } finally {
            try {
                is.close();
            } catch (Exception e) {
            }
        }
    }

    @Override
    protected void onPostExecute(HashMap<String, String> result) {
    }

    private Intent wrapIntent(String action, Object... extras) {
        Intent intent = new Intent();

        return intent;
    }
}
