package ir.ninjacoder.ghostide.filehelper;

import android.text.Editable;
import android.text.TextWatcher;
import com.google.android.material.textfield.TextInputLayout;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.lang.model.SourceVersion;

public class FileNio {

  public static void makeFile(String filePath) throws IOException {
    Files.createFile(Paths.get(filePath));
  }

  public static void makeFolder(String folderPath) throws IOException {
    Files.createDirectories(Paths.get(folderPath));
  }

  public static void removeFile(String filePath) throws IOException {
    Files.delete(Paths.get(filePath));
  }

  public static void copyFileOrFolder(String source, String destination) throws IOException {

    Path sourcePath = Paths.get(source);
    Path destinationPath = Paths.get(destination);
    Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
  }

  public static void moveFileOrFolder(String source, String destination) throws IOException {
    Path sourcePath = Paths.get(source);
    Path destinationPath = Paths.get(destination);
    Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
  }

  private static void verifyPackageName(Editable editable, TextInputLayout mPackageNameLayout) {
    String packageName = editable.toString();
    String[] packages = packageName.split("\\.");
    for (String name : packages) {
      if (name.isEmpty()) {
        mPackageNameLayout.setError("Package name part cannot be empty");
        return;
      }
      if (!SourceVersion.isName(name)) {
        mPackageNameLayout.setError("'" + name + "' is not a valid Java identifier");
        return;
      }
    }
    if (packages.length == 0) {
      mPackageNameLayout.setError("Please enter a package name");
    } else if (packages.length == 1) {
      mPackageNameLayout.setError("Please use a full package name (e.g. com.example)");
    } else if (packageName.endsWith(".")) {
      mPackageNameLayout.setError("Package name cannot end with a dot");
    } else if (packageName.contains(" ")) {
      mPackageNameLayout.setError("Package name cannot contain spaces");
    } else if (!packageName.matches("^[a-zA-Z0-9.]+$")) {
      mPackageNameLayout.setError("Package name can only contain letters, numbers and dots");
    } else {
      mPackageNameLayout.setErrorEnabled(false);
    }
  }

  public static void verifyPackageNameImpl(TextInputLayout layout) {
    layout
        .getEditText()
        .addTextChangedListener(
            new TextWatcher() {

              @Override
              public void afterTextChanged(Editable edit) {
                  verifyPackageName(edit,layout);
              }

              @Override
              public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}

              @Override
              public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}
            });
  }
}
