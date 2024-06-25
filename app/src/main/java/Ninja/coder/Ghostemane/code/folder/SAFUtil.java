package Ninja.coder.Ghostemane.code.folder;

import android.provider.DocumentsContract;

public class SAFUtil {
    public static boolean isDirectory(String mimeType) {
        return DocumentsContract.Document.MIME_TYPE_DIR.equals(mimeType);
    }
}
