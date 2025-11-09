package ir.ninjacoder.ghostide.core.marco.binder.bindchilder;

public class ChilderRecyclerviewCompat {

    protected static String[] VIDEO_FILES = {
            "3gp", "avi", "flv", "m4v", "mkv", "mov", "mp4", "mpeg", "mpg", "ogv", "rmvb", "swf", "vob",
            "webm", "wmv"
    };

    protected static String[] AUDIO_FILES = {
            "aac", "aiff", "alac", "amr", "ape", "au", "awb", "dct", "dss", "dvf", "flac", "gsm", "iklax",
            "ivs", "m4a", "m4b", "m4p", "m4r", "mid", "mmf", "mp2", "mp3", "mpc", "msv", "oga", "ogg",
            "opus", "ra", "rm", "sln", "tta", "vox", "wav", "wma", "wv"
    };

    public static boolean getChildAudio(String path) {
        for (String last : AUDIO_FILES) {
            if (path.endsWith(".".concat(last))) {
                return true;
            }
        }
        return false;
    }

    public static String getVideoFormat() {

        for (var childeVideo : VIDEO_FILES) {
            return childeVideo;
        }
        return null;
    }
}
