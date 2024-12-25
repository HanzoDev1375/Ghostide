package ir.ninjacoder.ghostide.model;

import java.io.File;

public class Icons {

    private final File mRoot;

    public Icons(File root) {
        mRoot = root;
    }

    public File getRootFile() {
        return mRoot;
    }
}
