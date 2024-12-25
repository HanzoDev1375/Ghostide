package ir.ninjacoder.ghostide.folder;

import android.os.Environment;
import org.apache.commons.io.FilenameUtils;

public class FileHelper {

    public static String[] ANDROID_DEFAULT_DIRS = {
            Environment.DIRECTORY_MUSIC,
            Environment.DIRECTORY_PODCASTS,
            Environment.DIRECTORY_RINGTONES,
            Environment.DIRECTORY_ALARMS,
            Environment.DIRECTORY_NOTIFICATIONS,
            Environment.DIRECTORY_PICTURES,
            Environment.DIRECTORY_MOVIES,
            Environment.DIRECTORY_DOWNLOADS,
            Environment.DIRECTORY_DCIM
    };
    public static String[] COMPRESS_FILES = {"7z", "rar", "tar", "zip"};
    public static String[] BITMAP_FILES = {"bmp", "jpg", "jpeg", "png", "gif", "tiff", "ico", "webp"};
    public static String[] VECTOR_FILES = {"ai", "eps", "svg"};
    public static String[] VIDEO_FILES = {
            "3gp", "avi", "flv", "m4v", "mkv", "mov", "mp4", "mpeg", "mpg", "ogv", "rmvb", "swf", "vob",
            "webm", "wmv"
    };
    public static String[] AUDIO_FILES = {
            "aac", "aiff", "alac", "amr", "ape", "au", "awb", "dct", "dss", "dvf", "flac", "gsm", "iklax",
            "ivs", "m4a", "m4b", "m4p", "m4r", "mid", "mmf", "mp2", "mp3", "mpc", "msv", "oga", "ogg",
            "opus", "ra", "rm", "sln", "tta", "vox", "wav", "wma", "wv"
    };
    public static String[] FONT_FILES = {"ttf", "ttc", "otf"};
    public static String[] MS_WORD_FILES = {"doc", "docs", "docx"};
    public static String[] MC_RELATED_FILES = {"mcaddon", "mcpack", "mcworld"};
    public String filePath;
    private FileEnvironmentHelper fileEnvHelper;

    public FileHelper(String filePath) {
        this.filePath = filePath;
        fileEnvHelper = new FileEnvironmentHelper(filePath);
    }

    public String getFileName() {
        return FileUtil.getFileNameOfPath(filePath);
    }

    public String getFileExtension() {
        if (!filePath.equals("")) {
            return FilenameUtils.getExtension(filePath.toLowerCase());
        }
        return null;
    }

    public String getFileExtension2() {
        if (!filePath.equals("")) {
            return FileUtil.getFileExtensionOfPath(filePath.toLowerCase());
        }
        return null;
    }

    public boolean equals(String str) {
        return getFileExtension().equals(str);
    }

    public boolean isFiles(String[] types) {
        for (String ext : types) {
            if (ext.equals(getFileExtension())) return true;
        }
        return false;
    }

    public boolean isAndroidDefaultDirectories(String folderName) {
        for (String dir : ANDROID_DEFAULT_DIRS) {
            if (folderName.equalsIgnoreCase(dir)) return true;
        }
        return false;
    }

    public boolean isCompressFiles() {
        if (getFileExtension2().endsWith("tar.xz")) return true;
        return isFiles(COMPRESS_FILES);
    }

    public boolean isBitmapFiles() {
        return isFiles(BITMAP_FILES);
    }

    public boolean isVectorFiles() {
        return isFiles(VECTOR_FILES);
    }

    public boolean isVideoFiles() {
        return isFiles(VIDEO_FILES);
    }

    public boolean isAudioFiles() {
        return isFiles(AUDIO_FILES);
    }

    public boolean isFontFiles() {
        return isFiles(FONT_FILES);
    }

    public boolean isMicrosoftWordFiles() {
        return isFiles(MS_WORD_FILES);
    }

    public boolean isGradleFiles() {
        if (getFileExtension2().endsWith("gradle.kts")) return true;
        else if (getFileName().equals("gradlew")) return true;
        else if (getFileName().equals("gradle.properties")) return true;
        else if (getFileName().equals("gradle-wrapper.properties")) return true;
        else if (getFileName().equals("settings.properties")) return true;
        return equals("gradle");
    }

    public boolean isYarnFiles() {
        return getFileName().equals("yarn.lock");
    }

    public boolean isTestJsFiles() {
        return getFileExtension2().endsWith("test.js");
    }

    public boolean isMinecraftRelatedFiles() {
        return isFiles(MC_RELATED_FILES);
    }
}
