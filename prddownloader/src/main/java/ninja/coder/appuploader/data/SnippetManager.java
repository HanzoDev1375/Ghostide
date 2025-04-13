package ninja.coder.appuploader.data;

import android.content.Context;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonParseException;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import ninja.coder.models.CodesnippetModel;


public class SnippetManager {
  private Gson gson;
  private File snippetsFile;
  private Context c;
  private Map<String, CodesnippetModel> snippets;

  public SnippetManager(File snippetsFile, Context c) {
    this.gson =
        new GsonBuilder()
            .registerTypeAdapter(CodesnippetModel.class, new SnippetAdapter())
            .setPrettyPrinting()
            .create();
    this.snippetsFile = snippetsFile;
    this.snippets = new HashMap<>();
    this.c = c;
    loadSnippets();
  }

  private void loadSnippets() {
    if (snippetsFile.exists()) {
      try (FileReader reader = new FileReader(snippetsFile)) {
        Type type = new TypeToken<Map<String, CodesnippetModel>>() {}.getType();
        Map<String, CodesnippetModel> loaded = gson.fromJson(reader, type);
        if (loaded != null) {
          snippets = loaded;
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public void saveAllSnippets(Map<String, CodesnippetModel> snippets) {
    this.snippets = new HashMap<>(snippets);
    saveSnippets();
  }

  public void addSnippet(String key, CodesnippetModel snippet) {
    snippets.put(key, snippet);
    saveSnippets();
  }

  public void editSnippet(String key, CodesnippetModel updatedSnippet) {
    if (snippets.containsKey(key)) {
      snippets.put(key, updatedSnippet);
      saveSnippets();
    }
  }

  public void deleteSnippet(String key) {
    snippets.remove(key);
    saveSnippets();
  }

  private void saveSnippets() {
    try {
      if (!snippetsFile.getParentFile().exists()) {
        snippetsFile.getParentFile().mkdirs();
      }

      try (FileWriter writer = new FileWriter(snippetsFile)) {
        gson.toJson(snippets, writer);
        Toast.makeText(c, writer.toString(), 2).show();
        writer.flush();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Map<String, CodesnippetModel> getAllSnippets() {
    return new HashMap<>(snippets);
  }

  public CodesnippetModel getSnippet(String key) {
    return snippets.get(key);
  }

  private static class SnippetAdapter implements JsonDeserializer<CodesnippetModel> {
    @Override
    public CodesnippetModel deserialize(
        JsonElement json, Type typeOfT, JsonDeserializationContext context)
        throws JsonParseException {

      JsonObject jsonObject = json.getAsJsonObject();
      String description = jsonObject.get("description").getAsString();
      String prefix = jsonObject.get("prefix").getAsString();
      JsonElement body = jsonObject.get("body");

      return new CodesnippetModel(description, prefix, body);
    }
  }
}
