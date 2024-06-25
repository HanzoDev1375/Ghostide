package Ninja.coder.Ghostemane.code.marco;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileTree {
    public static void FilesTree(String files, Event event) {
        String userInput = files;
        event.StartEvent();
        String[] parts = userInput.split("\\.");
        parts[parts.length - 1] = parts[parts.length - 1].replace(".", "");
        String directoryPath = "";
        for (int i = 0; i < parts.length - 1; i++) {
            directoryPath += parts[i] + File.separator;
            event.WorkTotalEvent(i);
        }
        File fi = new File(directoryPath);
        fi.mkdirs();
        String filePath = directoryPath + parts[parts.length - 1];
        Path file = Paths.get(filePath);
        try {
            Files.createFile(file);
            event.FinishEvent();
        } catch (IOException e) {
            event.ErrorEvent(e);
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public static void FolderTree(String file, Event event) {
        String input = file;
        String[] packages = input.split("\\.");
        event.StartEvent();
        StringBuilder path = new StringBuilder();

        for (String pkg : packages) {
            try {
                path.append(pkg).append(File.separator);
                File directory = new File(path.toString());
                if (!directory.exists()) {
                    directory.mkdir();
                    event.WorkTotalEvent(0);
                    System.out.println("Created directory: " + directory.getAbsolutePath());
                    event.FinishEvent();
                }
            } catch (Exception e) {
                event.ErrorEvent(e);
            }
        }
    }

    public static interface Event {
        public void StartEvent();

        public void FinishEvent();

        public void ErrorEvent(Throwable t);

        public void WorkTotalEvent(int a);
    }

}