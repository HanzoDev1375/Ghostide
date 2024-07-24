package Ninja.coder.Ghostemane.code.databin;

import Ninja.coder.Ghostemane.code.utils.FileUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.github.rosemoe.sora.data.CompletionItem;
import java.util.ArrayList;
import java.util.List;


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
