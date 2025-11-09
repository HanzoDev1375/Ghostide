package ir.ninjacoder.ghostide.core.databin;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import io.github.rosemoe.sora.data.CompletionItem;
import ir.ninjacoder.ghostide.core.utils.FileUtil;


public class CodeSnippet {
  private Gson gson;
  private List<CompletionItem> listCompletionItem = new ArrayList<>();

  public void readSnippet(String path) {
    var token = new TypeToken<List<CompletionItem>>() {}.getType();
    gson = new Gson();
    listCompletionItem = gson.fromJson(FileUtil.readFile(path), token);

    for (CompletionItem item : listCompletionItem) {
      listCompletionItem.add(new CompletionItem(item.prefix, item.body, item.description));
    }
  }
  
  
}
