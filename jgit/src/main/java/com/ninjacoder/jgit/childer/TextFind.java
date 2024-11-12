package com.ninjacoder.jgit.childer;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.ninjacoder.jgit.databinding.LayoutFindDataBinding;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.IOException;

public class TextFind {

  private TextFindListener listener;
  private Context context;
  protected ProgressDialog dialog;
  protected LayoutFindDataBinding binding;
  protected String path;

  public TextFind(TextFindListener listener, Context context, String path) {
    this.listener = listener;
    this.context = context;
    this.path = path;
    binding = LayoutFindDataBinding.inflate(LayoutInflater.from(context));
    var dialogs = new MaterialAlertDialogBuilder(context);
    dialogs.setTitle("TextFind");
    dialogs.setView(binding.getRoot());
    dialogs.setPositiveButton(
        android.R.string.ok,
        (__, ___) -> {
          if (binding.repmod.getEditText().getText().toString().length() > 0
              && binding.textfind.getEditText().getText().toString().length() > 0) {

            dialog = new ProgressDialog(context, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
            dialog.setMessage("Loading....");
            dialog.show();
            replaceTextInFiles(
                binding.textfind.getEditText().getText().toString(),
                binding.repmod.getEditText().getText().toString(),
                path,
                binding.boxregex.isChecked());

          } else {
            binding.repmod.setError("Body isEmpty");
            binding.textfind.setError("Body isEmpty");
          }
        });
    dialogs.setNegativeButton(android.R.string.cancel, null);
    if (dialogs != null) dialogs.show();
  }

  void runOnUi(Runnable run) {
    var handler = new Handler(Looper.getMainLooper());
    handler.post(run);
  }

  void replaceTextInFiles(
      String searchPattern, String replacePattern, String directoryPath, boolean useRegex) {
    new Thread(
            () -> {
              try {
                Path directory = Paths.get(directoryPath);
                if (!Files.isDirectory(directory)) {
                  listener.onError(directoryPath + " is not a valid directory path.");
                  return;
                }

                Charset charset = Charset.forName("UTF-8");
                Pattern pattern = useRegex ? Pattern.compile(searchPattern) : null;

                Files.walk(directory)
                    .filter(Files::isRegularFile)
                    .forEach(
                        file ->
                            processFile(
                                file, searchPattern, replacePattern, charset, pattern, useRegex));
                runOnUi(
                    () -> {
                      listener.onComplete();
                      if (dialog.isShowing()) dialog.dismiss();
                    });

              } catch (Exception e) {
                listener.onError("An error occurred: " + e.getMessage());
              }
            })
        .start();
  }

  private void processFile(
      Path file,
      String searchPattern,
      String replacePattern,
      Charset charset,
      Pattern pattern,
      boolean useRegex) {
    try {
      String fileText = new String(Files.readAllBytes(file), charset);
      boolean found = false;
      String replacementText;

      if (useRegex) {
        Matcher matcher = pattern.matcher(fileText);
        if (matcher.find()) {
          found = true;
          replacementText = matcher.replaceAll(replacePattern);
        } else {
          return;
        }
      } else {
        if (fileText.contains(searchPattern)) {
          found = true;
          replacementText = fileText.replace(searchPattern, replacePattern);
        } else {
          return;
        }
      }

      if (found) {
        Files.write(file, replacementText.getBytes(charset));
      }
    } catch (IOException e) {
      System.err.printf("Failed to replace text in file %s: %s%n", file, e);
    }
  }
}
