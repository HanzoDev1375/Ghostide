package Ninja.coder.Ghostemane.code.folder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class GhostDetector {

    protected static boolean isGhostFile(String filePath) {
        File file = new File(filePath);
        if (file.isDirectory()) {
            return false;
        }
        String fileName = file.getName();
        return fileName.equals("GhostThemeapp.ghost");
    }

    protected static List<File> findGhostFiles(String directoryPath) {
        File directory = new File(directoryPath);
        List<File> readmeFiles = new ArrayList<>();
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (isGhostFile(file.getAbsolutePath())) {
                    readmeFiles.add(file);
                }
                if (file.isDirectory()) {
                    readmeFiles.addAll(findGhostFiles(file.getAbsolutePath()));
                }
            }
        }
        return readmeFiles;
    }

    protected static boolean isAppLoaderTheme(String dirPath) {
        File file = new File(dirPath);
        if (!file.isDirectory()) {
            return false;
        }
        File gitDir = new File(file, "GhostWebIDE");
        return gitDir.exists() && gitDir.isDirectory();
    }
}
