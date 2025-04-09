package lsp4custom.com.ninjacoder.customhtmllsp;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.Gson;
import io.github.rosemoe.sora.data.CompletionItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CodeSnippet {
  public String jsonPath;

  public CodeSnippet(String jsonPath) {
    this.jsonPath = jsonPath;
  }
  @Deprecated
  public void run(List<CompletionItem> list, String pr) {
    JsonObject jsonObject = JsonParser.parseString(jsonPath).getAsJsonObject();
    Gson gson = new Gson();
    List<CompletionItem> codeSnippets = new ArrayList<>();
    Set<Map.Entry<String, JsonElement>> jsonEntries = jsonObject.entrySet();
    List<CompletionItem> helper =
        jsonEntries.stream()
            .map(
                entry -> {
                  CompletionItem snippet = gson.fromJson(entry.getValue(), CompletionItem.class);
                  JsonObject jsonObj = entry.getValue().getAsJsonObject();
                  snippet.desc = jsonObj.get("description").getAsString();
                  snippet.label = jsonObj.get("prefix").getAsString();
                  snippet.commit = jsonObj.get("body").getAsString();
                  return snippet;
                })
            .collect(Collectors.toList());

    list.addAll(helper);
  }

  public static List<CompletionItem> runasList(String prefix, String jsonPath) {
    JsonObject jsonObject = JsonParser.parseString(jsonPath).getAsJsonObject();
    Gson gson = new Gson();
    Set<Map.Entry<String, JsonElement>> jsonEntries = jsonObject.entrySet();

    return jsonEntries.stream()
        .map(
            entry -> {
              JsonObject jsonObj = entry.getValue().getAsJsonObject();
              CompletionItem snippet = new CompletionItem();
              snippet.desc = jsonObj.get("description").getAsString();
              snippet.label = jsonObj.get("prefix").getAsString();
              snippet.commit = jsonObj.get("body").getAsString();
              return snippet;
            })
        .filter(item -> item.label.startsWith(prefix))
        .collect(Collectors.toList());
  }
}
