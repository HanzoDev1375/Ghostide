package ir.ninjacoder.ghostide.core.folder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class ReadmeDetector {

    private static final String README_FILENAMES_REGEX = "(?i)readme(-[a-z]{2})?(\\.\\w+)?";

    protected static boolean isReadmeFile(String filePath) {
        File file = new File(filePath);
        if (file.isDirectory()) {
            return false;
        }
        String fileName = file.getName();
        return fileName.matches(README_FILENAMES_REGEX);
    }

    protected static List<File> findReadmeFiles(String directoryPath) {
        File directory = new File(directoryPath);
        List<File> readmeFiles = new ArrayList<>();
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (isReadmeFile(file.getAbsolutePath())) {
                    readmeFiles.add(file);
                }
                if (file.isDirectory()) {
                    readmeFiles.addAll(findReadmeFiles(file.getAbsolutePath()));
                }
            }
        }
        return readmeFiles;
    }
}
