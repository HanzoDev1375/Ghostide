package ir.ninjacoder.ghostide.core.folder;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import ir.ninjacoder.ghostide.core.utils.FileUtil;

public class VueDetector {


    private static final String[] VUE_KEYWORDS = {
            "<template>",
            "<script>",
            "<style>",
            "export default {",
            "Vue.component('",
            "Vue.extend({",
            "Vue.mixin({",
            "Vue.directive('",
            "Vue.filter('",
            "$emit(",
            "$refs.",
            "this.$",
            "this.",
            "v-bind:",
            "v-model:",
            "v-on:"
    };

    protected static boolean isVueJsDirectory(String dirPath) {
        boolean hasPackageJson = isVueJsPackageJsonFile(dirPath + "/package.json");
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
                } else if (current.isFile() && current.getName().endsWith(".vue")) {
                    if (isVueJsFile(current.getAbsolutePath())) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {

        }

        return false;
    }

    protected static boolean isVueJsFile(String filePath) {

        if (FileUtil.getExternalStorageDir().concat(filePath).equals("vue")) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    for (String keyword : VUE_KEYWORDS) {
                        if (line.contains(keyword)) {
                            return true;
                        }
                    }
                }
            } catch (IOException e) {

            }
        }
        return false;
    }

    protected static boolean isVueJsPackageJsonFile(String filePath) {
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
                    hasAngular = dependencies.has("vue");
                }
                if (!hasAngular && devDependencies != null) {
                    hasAngular = devDependencies.has("vue");
                }
            }

            return hasDependencies && hasAngular;
        } catch (IOException | JSONException e) {

        }

        return false;
    }
}
