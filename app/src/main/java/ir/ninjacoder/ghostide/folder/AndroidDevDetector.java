package ir.ninjacoder.ghostide.folder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class AndroidDevDetector {

    protected static boolean isAndroidDevDirectory(String dirPath) {
        File file = new File(dirPath);
        if (!file.isDirectory()) {
            return false;
        }
        File appDir = new File(file, "app");
        File srcDir = new File(appDir, "src");
        File mainDir = new File(srcDir, "main");
        File manifestFile = new File(mainDir, "AndroidManifest.xml");
        return manifestFile.exists() && manifestFile.isFile();
    }

    protected static boolean isAndroidDevJavaFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists() || file.isDirectory()) {
            return false;
        }
        if (!filePath.endsWith(".java")) {
            return false;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                if (isAndroidDevJavaCode(line)) {
                    return true;
                }
                line = reader.readLine();
            }
        } catch (IOException e) {

        }
        return false;
    }

    protected static boolean isAndroidDevJavaCode(String codeLine) {
        Pattern pattern = Pattern.compile("import\\sandroid\\.");
        Matcher matcher = pattern.matcher(codeLine);
        return matcher.find();
    }

}