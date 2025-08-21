package ninja.coder.appuploader.data;

import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.LayoutInflater;
import com.blankj.utilcode.util.ThreadUtils;
import com.downloader.databinding.LayoutSnippetViewBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.gson.JsonPrimitive;
import ir.ninjacoder.prograsssheet.CustomSheet;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import android.util.Log;
import android.widget.Toast;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.util.Map;
import com.google.gson.JsonSyntaxException;
import androidx.recyclerview.widget.RecyclerView;
import java.io.File;
import ninja.coder.models.CodesnippetModel;
import com.downloader.R;
import com.google.gson.stream.JsonReader;
import com.google.gson.Strictness;
import java.io.StringReader;

public class SnippetManagerImpl {
  private File file;
  private Context context;
  private SnippetsAdapter adapter;
  private String jsonString;
  private SnippetManager snippetManager;
  private LayoutSnippetViewBinding bin;
  protected Sheet sheet;

  public SnippetManagerImpl(File file, Context context) {
    this.file = file;
    this.context = context;
    bin = LayoutSnippetViewBinding.inflate(LayoutInflater.from(context));
    sheet = new Sheet(context);
    sheet.show();
    init();
  }

  void init() {
    bin.rvsnippet.setLayoutManager(new LinearLayoutManager(context));
    adapter = new SnippetsAdapter();
    bin.rvsnippet.setAdapter(adapter);
    snippetManager = new SnippetManager(file, context);
    loadSnippets();

    adapter.setOnSnippetClickListener(
        new SnippetsAdapter.OnSnippetClickListener() {
          @Override
          public void onEditClick(String key, CodesnippetModel snippet) {
            showEditDialog(key, snippet);
          }

          @Override
          public void onDeleteClick(String key) {
            snippetManager.deleteSnippet(key);
            loadSnippets();
            Toast.makeText(context, "reomved snippet", Toast.LENGTH_SHORT).show();
          }
        });
    bin.searchsnippet.setEnabled(true);
    bin.searchsnippet
        .getEditText()
        .addTextChangedListener(
            new TextWatcher() {

              @Override
              public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}

              @Override
              public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                if (adapter != null) {
                  adapter.filter(arg0.toString());
                }
              }

              @Override
              public void afterTextChanged(Editable arg0) {}
            });
    bin.fabadd.setOnClickListener(
        it -> {
          if (!snippetManager.getAllSnippets().isEmpty()) {
            showAddDialog();
          }
        });
  }

  void loadSnippets() {
    try (InputStream inputStream = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

      StringBuilder json = new StringBuilder();
      String line;
      while ((line = reader.readLine()) != null) {
        json.append(line).append('\n');
      }
      jsonString = json.toString();

      if (jsonString.trim().isEmpty()) {
        Log.e("JSONError", "Empty");
        runOnUiThread(() -> Toast.makeText(context, "فایل خالی است", Toast.LENGTH_SHORT).show());
        return;
      }
      JsonReader jsonReader = new JsonReader(new StringReader(jsonString));
      jsonReader.setStrictness(Strictness.LENIENT);

      Gson gson = new Gson();
      Type type = new TypeToken<Map<String, CodesnippetModel>>() {}.getType();
      Map<String, CodesnippetModel> snippets = gson.fromJson(jsonReader, type);

      if (snippets == null || snippets.isEmpty()) {
        Log.w("JSONError", "هیچ اسنیپت معتبری یافت نشد");
        runOnUiThread(
            () -> Toast.makeText(context, "هیچ اسنیپت معتبری یافت نشد", Toast.LENGTH_SHORT).show());
        return;
      }

      runOnUiThread(
          () -> {
            snippetManager.saveAllSnippets(snippets);
            adapter.setSnippets(snippets);
            Toast.makeText(
                    context, "تعداد " + snippets.size() + " اسنیپت بارگذاری شد", Toast.LENGTH_SHORT)
                .show();
          });

    } catch (Exception e) {
      Log.e("JSONError", "خطا در بارگذاری اسنیپت‌ها", e);
      runOnUiThread(
          () ->
              Toast.makeText(
                      context, "خطا در پردازش فایل JSON: " + e.getMessage(), Toast.LENGTH_LONG)
                  .show());
    }
  }

  void runOnUiThread(Runnable r) {
    ThreadUtils.runOnUiThread(r);
  }

  private void showAddDialog() {
    View view = LayoutInflater.from(context).inflate(R.layout.dialog_snippet, null);
    TextInputEditText etKey = view.findViewById(R.id.et_key);
    TextInputEditText etPrefix = view.findViewById(R.id.et_prefix);
    TextInputEditText etDescription = view.findViewById(R.id.et_description);
    TextInputEditText etBody = view.findViewById(R.id.et_body);

    new MaterialAlertDialogBuilder(context)
        .setView(view)
        .setTitle("Add Snippet")
        .setPositiveButton(
            "Save",
            (d, w) -> {
              try {
                String key = etKey.getText().toString();
                String bodyText = etBody.getText().toString();

                // تبدیل متن به JsonElement با مدیریت خطا
                JsonElement body;
                try {
                  body = JsonParser.parseString(bodyText);
                } catch (JsonSyntaxException e) {
                  // اگر JSON نامعتبر بود، به عنوان رشته ذخیره کنیم
                  body = new JsonPrimitive(bodyText);
                }

                var snippet =
                    new CodesnippetModel(
                        etDescription.getText().toString(), etPrefix.getText().toString(), body);
                snippetManager.addSnippet(key, snippet);
                loadSnippets();
              } catch (Exception e) {
                Toast.makeText(
                        context, "Error saving snippet: " + e.getMessage(), Toast.LENGTH_LONG)
                    .show();
              }
            })
        .setNegativeButton("Cancel", null)
        .show();
  }

  private void showEditDialog(String key, CodesnippetModel snippet) {
    View view = LayoutInflater.from(context).inflate(R.layout.dialog_snippet, null);
    TextInputEditText etKey = view.findViewById(R.id.et_key);
    TextInputEditText etPrefix = view.findViewById(R.id.et_prefix);
    TextInputEditText etDescription = view.findViewById(R.id.et_description);
    TextInputEditText etBody = view.findViewById(R.id.et_body);

    etKey.setText(key);
    etPrefix.setText(snippet.getPrefix());
    etDescription.setText(snippet.getDescription());

    // نمایش body با فرمت صحیح
    if (snippet.getBody() != null) {
      etBody.setText(
          snippet.getBody().isJsonPrimitive()
              ? snippet.getBody().getAsString()
              : snippet.getBody().toString());
    }

    etKey.setEnabled(false);

    new MaterialAlertDialogBuilder(context)
        .setView(view)
        .setTitle("Edit Snippet")
        .setPositiveButton(
            "Save",
            (d, w) -> {
              try {
                String bodyText = etBody.getText().toString();
                JsonElement body;

                try {
                  body = JsonParser.parseString(bodyText);
                } catch (JsonSyntaxException e) {
                  // اگر JSON نامعتبر بود، به عنوان رشته ذخیره کنیم
                  body = new JsonPrimitive(bodyText);
                }

                var updated =
                    new CodesnippetModel(
                        etDescription.getText().toString(), etPrefix.getText().toString(), body);
                snippetManager.editSnippet(key, updated);
                loadSnippets();
              } catch (Exception e) {
                Toast.makeText(
                        context, "Error updating snippet: " + e.getMessage(), Toast.LENGTH_LONG)
                    .show();
              }
            })
        .setNegativeButton("Cancel", null)
        .show();
  }

  class Sheet extends CustomSheet {
    public Sheet(Context c) {
      super(c);
    }

    @Override
    public View getView() {
      return bin.getRoot();
    }
  }
}
