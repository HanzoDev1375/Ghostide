package Ninja.coder.Ghostemane.code.folder;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

class AngularJsDetector {

    private static final String[] ANGULARJS_KEYWORDS = {
            "ng-app", "ng-controller", "ng-model", "ng-repeat", "ng-if", "ng-show", "ng-hide", "ng-click"
    };

    protected static boolean isAngularJsDirectory(String dirPath) {
        boolean hasPackageJson = isAngularJsPackageJsonFile(dirPath + "/package.json");
        if (!hasPackageJson) return false;

        try {
            File dir = new File(dirPath);
            Queue<File> queue = new LinkedList<>();
            queue.add(dir);

            while (!queue.isEmpty()) {
                File current = queue.poll();
                if (current.isDirectory()) {
                    File[] files = current.listFiles();
                    if (files != null) {
                        for (File file : files) {
                            queue.add(file);
                        }
                    }
                } else if (current.isFile() && current.getName().endsWith(".html")) {
                    if (isAngularJsFile(current.getAbsolutePath())) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {

        }

        return false;
    }

    protected static boolean isAngularJsFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String keyword : ANGULARJS_KEYWORDS) {
                    if (line.contains(keyword)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {

        }
        return false;
    }

    protected static boolean isAngularJsPackageJsonFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            var sb = new StringBuilder();
            var line = reader.readLine();
            while (line != null) {
                sb.append(line);
                line = reader.readLine();
            }

            var json = new JSONObject(sb.toString());

            var hasDependencies = json.has("dependencies") || json.has("devDependencies");
            var hasAngular = false;
            if (hasDependencies) {
                var dependencies = json.optJSONObject("dependencies");
                var devDependencies = json.optJSONObject("devDependencies");
                if (dependencies != null) {
                    hasAngular = dependencies.has("angular");
                }
                if (!hasAngular && devDependencies != null) {
                    hasAngular = devDependencies.has("angular");
                }
            }

            return hasDependencies && hasAngular;
        } catch (IOException | JSONException e) {

        }

        return false;
    }
}
