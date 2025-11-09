package ir.ninjacoder.ghostide.core.folder;

import android.net.Uri;
import android.os.Environment;

import java.io.File;

public class FileUtil {
    public static boolean isFileExist(String path) {
        return new File(path).exists();
    }

    public static boolean isFileHidden(String path) {
        return new File(path).isHidden();
    }

    public static boolean isDirectory(String path) {
        if (!isFileExist(path)) return false;
        return new File(path).isDirectory();
    }

    public static String getFileNameOfPath(String path) {
        return Uri.parse(path).getLastPathSegment();
    }

    public static String getFileExtensionOfPath(String path) {
        String ext = "";
        path = getFileNameOfPath(path);
        if (path != null && !path.isEmpty()) {
            int dot = path.indexOf('.');
            if ((dot >= 0) && (dot < path.length() - 1)) {
                ext = path.substring(dot + 1);
            }
        }
        return ext;
    }

    public static String getExternalStoragePath() {
        return Environment.getExternalStorageDirectory().getPath();
    }
}
