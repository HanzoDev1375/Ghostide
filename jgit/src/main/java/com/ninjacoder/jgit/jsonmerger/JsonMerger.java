package com.ninjacoder.jgit.jsonmerger;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import androidx.annotation.NonNull;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ninjacoder.jgit.databinding.LayoutJsonmrgBinding;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonMerger {

  private static final Gson gson = new Gson();
  private static final JsonParser jsonParser = new JsonParser();

  @WorkerThread
  @NonNull
  private static JsonElement readJsonFile(@NonNull String filePath) throws IOException {
    File file = new File(filePath);
    if (!file.exists()) {
      throw new IOException("فایل وجود ندارد: " + filePath);
    }

    BufferedReader reader = new BufferedReader(new FileReader(file));
    JsonElement jsonElement = jsonParser.parse(reader);
    reader.close();
    return jsonElement;
  }

  @WorkerThread
  @NonNull
  private static JsonElement mergeJsonElements(
      @NonNull JsonElement element1, @NonNull JsonElement element2) {
    if (element1.isJsonArray() && element2.isJsonArray()) {
      return mergeArrays(element1.getAsJsonArray(), element2.getAsJsonArray());
    } else if (element1.isJsonObject() && element2.isJsonObject()) {
      return mergeObjects(element1.getAsJsonObject(), element2.getAsJsonObject());
    } else {
      JsonArray mergedArray = new JsonArray();
      mergedArray.add(element1);
      mergedArray.add(element2);
      return mergedArray;
    }
  }

  @WorkerThread
  @NonNull
  private static JsonArray mergeArrays(@NonNull JsonArray array1, @NonNull JsonArray array2) {
    JsonArray mergedArray = new JsonArray();
    for (JsonElement element : array1) mergedArray.add(element);
    for (JsonElement element : array2) mergedArray.add(element);
    return mergedArray;
  }

  @WorkerThread
  @NonNull
  private static JsonObject mergeObjects(@NonNull JsonObject obj1, @NonNull JsonObject obj2) {
    JsonObject mergedObject = new JsonObject();
    for (String key : obj1.keySet()) mergedObject.add(key, obj1.get(key));
    for (String key : obj2.keySet()) mergedObject.add(key, obj2.get(key));
    return mergedObject;
  }

  @WorkerThread
  private static boolean saveJsonToFile(
      @NonNull JsonElement jsonElement, @NonNull String outputPath) throws IOException {
    File outputFile = new File(outputPath);
    File parentDir = outputFile.getParentFile();
    if (parentDir != null && !parentDir.exists()) {
      if (!parentDir.mkdirs()) {
        throw new IOException("نمی‌توان پوشه ایجاد کرد: " + parentDir.getAbsolutePath());
      }
    }

    BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
    gson.toJson(jsonElement, writer);
    writer.close();
    return true;
  }

  @UiThread
  public static void mergeJsonFiles(
      @NonNull String file1Path,
      @NonNull String file2Path,
      @NonNull String outputPath,
      @NonNull MergeCallback callback) {

    new Thread(
            () -> {
              try {
                JsonElement jsonElement1 = readJsonFile(file1Path);
                JsonElement jsonElement2 = readJsonFile(file2Path);
                JsonElement mergedElement = mergeJsonElements(jsonElement1, jsonElement2);
                saveJsonToFile(mergedElement, outputPath);

                callback.onSuccess(outputPath);

              } catch (IOException e) {
                callback.onError("خطای IO: " + e.getMessage());
              } catch (Exception e) {
                callback.onError("خطای ناشناخته: " + e.getMessage());
              }
            })
        .start();
  }

  public static void binds(
      String path1, String path2, String result, Context ctx, MergeCallback call) {
    LayoutJsonmrgBinding bind = LayoutJsonmrgBinding.inflate(LayoutInflater.from(ctx));
    bind.jsoneone.setText(path1);
    bind.jsonrtwo.setText(path2);
    bind.outputresultname.setText(result.replace(".json", "_marged_.json"));
    new MaterialAlertDialogBuilder(ctx)
        .setView(bind.getRoot())
        .setPositiveButton(
            android.R.string.ok,
            (c, cd) -> {
              if (!isEmpty(bind.jsoneone)
                  || !isEmpty(bind.jsonrtwo)
                  || !isEmpty(bind.outputresultname)) {
                mergeJsonFiles(
                    bind.jsoneone.getText().toString(),
                    bind.jsonrtwo.getText().toString(),
                    bind.outputresultname.getText().toString(),
                    call);
              }
            })
        .show();
  }

  static boolean isEmpty(EditText rt) {
    return rt.getText().toString().isEmpty();
  }
}
