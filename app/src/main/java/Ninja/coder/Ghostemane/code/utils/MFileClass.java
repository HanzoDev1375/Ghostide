package Ninja.coder.Ghostemane.code.utils;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class MFileClass {

    //Important info
    //This class was made by Manguengue HE
    //Don't use this without giving credits for me
    //Manguengue HE


    //%%%%%%%%%% All methods %%%%%%%%%
    //FilesClass.glideThumb(context, imageview, path);
    //FilesClass.getDirOfFile(filePath);
    //FilesClass.openFileWith(file, context);
    ///String
    //MFilesClass.convertBytes(bytes);
    //FilesClass.copyDir(oldPath, newPath, context, deleteOldFiles);
    //FilesClass.delete(path, context);
    //FilesClass.scanUnscanedFile(file, context);

    public static void copyDir(final String oldPath, final String newPath, final Context _context, final boolean _deleteOldFiles) {
        File oldFile = new File(oldPath);
        File[] files = oldFile.listFiles();
        File newFile = new File(newPath);
        if (!newFile.exists()) {
            newFile.mkdirs();
        }
        for (File file : files) {
            if (file.isFile()) {
                FileUtil.copyFile(file.getPath(), newPath + "/" + file.getName());
                scanUnscanedFile(newPath + "/" + file.getName(), _context);
                if (_deleteOldFiles) {
                    delete(file.getPath(), _context);
                }
            } else {
                if (file.isDirectory()) {
                    copyDir(file.getPath(), newPath + "/" + file.getName(), _context, _deleteOldFiles);
                }
            }
        }
        delete(oldPath, _context);
    }

    public static void openFileWith(final String _file, final Context _context) {

        String[] projection = {
                MediaStore.Files.FileColumns._ID,
                MediaStore.Files.FileColumns.MIME_TYPE
        };
        android.database.Cursor cursor = _context.getContentResolver().query(
                MediaStore.Files.getContentUri("external"),
                projection,
                MediaStore.Files.FileColumns.DATA + "='" + _file + "'",
                null,
                null);

        if (cursor.getCount() == 0) {
            return;
        }
        cursor.moveToFirst();

        String mime = cursor.getString(1);
        cursor.close();

        //try {
        java.io.File file = new java.io.File(_file);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);

        intent.setDataAndType(Uri.fromFile(file), mime);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        _context.startActivity(intent);
        //} catch (Exception e) {
        //}

    }

    public static String convertBytes(final double _bytes) {
        String j = "";
        int unity = 1024;
        if (_bytes < unity) {
            j = new DecimalFormat("0.00").format(_bytes).concat("B");
        }
        if (_bytes > unity-- && _bytes <= unity * unity) {
            j = new DecimalFormat("0.00").format(_bytes / (unity)).concat("KB");
        }
        if (_bytes > unity * unity) {
            j = new DecimalFormat("0.00").format(_bytes / (unity * unity)).concat("MB");
        }
        if (_bytes > unity * unity * unity) {
            j = new DecimalFormat("0.00").format(_bytes / (unity * unity * unity)).concat("GB");
        }
        return j;
    }

    public static String getLastModifiedOfFile(final String _file, final String _format) {
        java.io.File file = new java.io.File(_file);
        long lastModified = file.lastModified();
        Date c = new Date(lastModified);
        String date = new SimpleDateFormat(_format).format(c.getTime());
        return date;
    }

    public static void delete(final String _path, final Context _context) {

        //======================================
        File file = new File(_path);
        if (file.isFile()) {
            String[] projection = {
                    MediaStore.Files.FileColumns._ID
            };
            android.database.Cursor cursor = _context.getContentResolver().query(
                    MediaStore.Files.getContentUri("external"),
                    projection,
                    MediaStore.Files.FileColumns.DATA + "='" + _path + "'",
                    null,
                    null);

            if (cursor.getCount() == 0) {
                return;
            }
            cursor.moveToFirst();

            String path = cursor.getString(0);
            long id = cursor.getInt(cursor.getColumnIndex(MediaStore.MediaColumns._ID));

            cursor.close();

            //Perform delete
            Uri uri = ContentUris.withAppendedId(
                    MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, id
            );
            _context.getContentResolver().delete(uri, null, null);

            if (FileUtil.isExistFile(_path)) {
                FileUtil.deleteFile(_path);
            }
        } else {

            File pathFile = new File(_path);
            File[] files = pathFile.listFiles();
            for (File currentFile : files) {
                if (currentFile.isFile()) {
                    delete(currentFile.getPath(), _context);
                } else {
                    if (file.isDirectory()) {
                        delete(currentFile.getPath(), _context);
                    }
                }
            }
            if (FileUtil.isExistFile(_path)) {
                FileUtil.deleteFile(_path);
            }

        }
    }

    public static void sortListPathsByDate(final ArrayList<String> _list) {
        //Passo1=================================
        ArrayList<HashMap<String, Object>> listMap = new ArrayList<>();
        HashMap<String, Object> cacheHashMap = new HashMap<>();

        for (int i = 0; i < (int) (_list.size()); i++) {
            cacheHashMap = new HashMap<>();
            cacheHashMap.put("path", _list.get((int) (i)));
            cacheHashMap.put("date", getLastModifiedOfFile(_list.get((int) (i)), "yyyy-MM-dd, HH:mm:ss"));
            listMap.add(cacheHashMap);
        }
        DataUtil.sortListMap(listMap, "date", false, false);
        _list.clear();
        for (int i = 0; i < (int) (listMap.size()); i++) {
            _list.add(listMap.get((int) i).get("path").toString());
        }
    }

    public static void sortListPathsBySize(final ArrayList<String> _list) {
        //Passo1=================================
        ArrayList<HashMap<String, Object>> listMap = new ArrayList<>();
        HashMap<String, Object> cacheHashMap = new HashMap<>();

        for (int i = 0; i < (int) (_list.size()); i++) {
            cacheHashMap = new HashMap<>();
            cacheHashMap.put("path", _list.get((int) (i)));
            cacheHashMap.put("size", String.valueOf((long) (FileUtil.getFileLength(_list.get((int) (i))))));

            listMap.add(cacheHashMap);
        }
        DataUtil.sortListMap(listMap, "size", false, false);
        _list.clear();
        for (int i = 0; i < (int) (listMap.size()); i++) {
            _list.add(listMap.get((int) i).get("path").toString());
        }
    }

    public static String getDateDifference(final String _path, final String _format) {
        //This method compares last modified of a file and current
        //date, and gets the difference between this dates. If the
        //difference is more then 7 days the method shows the last
        //modified file date without difference. So in the format
        //field you have to put the date format, this will be used
        //to display last modified date of file if the difference is >7.


        //Passo1=================================
        String result = "";

        Calendar c = Calendar.getInstance();
        double Day = Double.parseDouble(new SimpleDateFormat("D").format(c.getTime()));
        double lastDay = Double.parseDouble(getLastModifiedOfFile(_path, "D"));
        double Hour = Double.parseDouble(new SimpleDateFormat("HH").format(c.getTime()));
        double lastHour = Double.parseDouble(getLastModifiedOfFile(_path, "HH"));
        double Minute = Double.parseDouble(new SimpleDateFormat("mm").format(c.getTime()));
        double lastMinute = Double.parseDouble(getLastModifiedOfFile(_path, "mm"));

        //Passo2=================================
        if (Day == lastDay) {
            //Hora=================================
            if (Hour == lastHour) {
                //Minutos=================================
                if (Minute == lastMinute) {
                    result = "0 min ago";
                } else {
                    result = "".concat(String.valueOf((long) (Minute - lastMinute))).concat(" min(s) ago");
                }

            } else {
                result = "".concat(String.valueOf((long) (Hour - lastHour))).concat(" hour(s) ago");
            }

        } else {
            //Dia=================================
            result = MFileClass.getLastModifiedOfFile(_path, _format);
			/*
			if ((Day - lastDay) > 7) {
			result = FilesClass.getLastModifiedOfFile(_path, _format);
			}
			
			else {
			result = "".concat(String.valueOf((long)(Day - lastDay))).concat(" day(s) ago");
			}
			*/
        }
        return result;
    }

    public static void scanFile(final String _file, final Context _context) {
        java.io.File downloadFile = new java.io.File(_file);
        Intent _imageviewI = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        _imageviewI.setData(Uri.fromFile(downloadFile));
        _context.sendBroadcast(_imageviewI);

        try {
            android.media.MediaScannerConnection.scanFile(_context, new String[]{new java.io.File(_file).getPath()}, null, null);
        } catch (Exception e) {
        }
    }

    public static void scanUnscanedFile(final String _file, final Context _context) {
        long id = -1;
        String[] projection = {
                MediaStore.Files.FileColumns._ID
        };
        android.database.Cursor cursor = _context.getContentResolver().query(
                MediaStore.Files.getContentUri("external"),
                projection,
                MediaStore.Files.FileColumns.DATA + "='" + _file + "'",
                null,
                null);

        if (cursor.getCount() == 0) {
            scanFile(_file, _context);
            return;
        }
        cursor.moveToFirst();

        String path = cursor.getString(0);
        id = cursor.getInt(cursor.getColumnIndex(MediaStore.MediaColumns._ID));
        cursor.close();
        if (id == -1) {

        }
    }

}
