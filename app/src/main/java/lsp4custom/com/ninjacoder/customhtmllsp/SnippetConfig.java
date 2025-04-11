package lsp4custom.com.ninjacoder.customhtmllsp;
import ir.ninjacoder.ghostide.utils.FileUtil;
import java.util.Map;
import java.util.HashMap;
import java.io.File;
import com.google.gson.JsonArray;
import java.io.FileReader;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;

public class SnippetConfig {

  private static Map<String, String> snippetPaths = new HashMap<>();

  static {
    loadConfig();
  }

  private static void loadConfig() {
    try {
      File configFile = new File(FileUtil.HOMESNIPPET);
      JsonArray configArray = JsonParser.parseReader(new FileReader(configFile)).getAsJsonArray();

      for (int i = 0; i < configArray.size(); i++) {
        JsonObject item = configArray.get(i).getAsJsonObject();
        String language = item.get("language").getAsString();
        String path = item.get("jsonpath").getAsString();
        snippetPaths.put(language, path);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static String getPathForLanguage(String language) {
    return snippetPaths.get(language);
  }
}
