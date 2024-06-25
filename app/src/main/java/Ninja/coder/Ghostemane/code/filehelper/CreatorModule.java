package Ninja.coder.Ghostemane.code.filehelper;

import Ninja.coder.Ghostemane.code.R;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.TextInputLayout;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CreatorModule {
  protected Spinner spinner;
  protected String folder;
  protected OnCallBack call;
  protected TextInputLayout inputLayout, input_pk;
  protected List<String> str = new ArrayList<>();
  protected String stringsxml =
      "<resources>"
          + "\n <string name =\"app_name\">"
          + "myapp"
          + "</string>"
          + "\n"
          + "</resources>";
  private Context context;
  private AlertDialog dialog;

  public CreatorModule(Context context, String folder, OnCallBack call) {
    this.context = context;
    this.folder = folder;
    this.call = call;
    str.add("None");
    str.add("ModuleJava");
    str.add("ModuleAndroid");
    str.add("ModuleAndroidKts");
    dialog =
        new MaterialAlertDialogBuilder(context)
            .setTitle("CreatorModule")
            .setPositiveButton("ok", null)
            .setView(R.layout.__layout_java_module)
            .create();
    dialog.setOnShowListener(
        v -> {
          var btn = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
          inputLayout = dialog.findViewById(R.id.input_ma);
          spinner = dialog.findViewById(R.id.sp1_main);
          input_pk = dialog.findViewById(R.id.input_pack);
          spinner.setAdapter(
              new ArrayAdapter<String>(
                  context, android.R.layout.simple_spinner_dropdown_item, str));
          ((ArrayAdapter) spinner.getAdapter()).notifyDataSetChanged();
          var myShap = new ShapeAppearanceModel.Builder();
          myShap.setAllCorners(CornerFamily.CUT, 20f);
          inputLayout.setShapeAppearanceModel(myShap.build());
          input_pk.setShapeAppearanceModel(myShap.build());
          inputLayout.setHintEnabled(true);
          spinner.setDrawingCacheBackgroundColor(Color.BLUE);
          inputLayout.setHint("CreatorModule");
          input_pk.setHint("Name Your package");
          inputLayout
              .getEditText()
              .addTextChangedListener(
                  new TextWatcher() {

                    @Override
                    public void afterTextChanged(Editable arg0) {}

                    @Override
                    public void beforeTextChanged(
                        CharSequence arg0, int arg1, int arg2, int arg3) {}

                    @Override
                    public void onTextChanged(CharSequence s, int arg1, int arg2, int arg3) {
                      btn.setEnabled(s.toString().isEmpty() ? false : true);
                      spinner.setEnabled(s.toString().isEmpty() ? false : true);
                      input_pk.getEditText().setEnabled(s.toString().isEmpty() ? false : true);
                    }
                  });

          btn.setOnClickListener(
              vc -> {
                if (call != null) {
                  call.reload();
                }
                dialog.dismiss();
              });
          btn.setEnabled(str.size() == 0 ? true : false);
          spinner.setOnItemSelectedListener(
              new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> ad, View m, int pp, long vv) {

                  switch (pp) {
                    case 0:
                      break;
                    case 1:
                      makeModuleJava();
                      break;
                    case 2:
                      makeModuleAndroid();
                      break;
                    case 3:
                      makeModuleAndroidKts();
                      break;
                  }
                }

                @Override
                public void onNothingSelected(AdapterView<?> arg0) {}
              });
        });
    dialog.show();
  }

  public void makeModuleJava() {
    Path moduleFolder = Paths.get(folder, inputLayout.getEditText().getText().toString());
    try {
      Files.createDirectories(moduleFolder);

      String buildGradleContent =
          "plugins {\n"
              + "    id 'java-library'\n"
              + "}\n\n"
              + "dependencies {\n"
              + "    //add your dependencies\n"
              + "}\n\n"
              + "java {\n"
              + "    sourceCompatibility = JavaVersion.VERSION_17\n"
              + "    targetCompatibility = JavaVersion.VERSION_17\n"
              + "}\n";
      String androidManifestContent =
          "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
              + "<manifest xmlns:android=\"http://schemas.android.com/apk/res/android\">\n"
              + "</manifest>\n";
      String mainJavaContent =
          "package"
              + input_pk.getEditText().getText().toString()
              + ";"
              + "\n \n"
              + "public class Main {\n"
              + "    public static void main(String[] args) {\n"
              + "        // Your Java code here\n"
              + "    }\n"
              + "}\n";

      Files.write(moduleFolder.resolve("build.gradle"), buildGradleContent.getBytes());
      Files.write(moduleFolder.resolve(".gitignore"), "/build".getBytes());
      Files.createDirectories(
          moduleFolder.resolve(
              "src/main/java/"
                  + input_pk.getEditText().getText().toString().replace('.', '/')
                  + "/"));
      Files.write(
          moduleFolder.resolve(
              "src/main/java/"
                  + input_pk.getEditText().getText().toString().replace('.', '/')
                  + "Main.java"),
          mainJavaContent.getBytes());
      Files.write(
          moduleFolder.resolve("src/main/AndroidManifest.xml"), androidManifestContent.getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void makeModuleAndroid() {
    Path moduleFolder = Paths.get(folder, inputLayout.getEditText().getText().toString());
    try {
      Files.createDirectories(moduleFolder);
      var pak = input_pk.getEditText().getText().toString();
      String buildGradleContent =
          "plugins {\n"
              + "    id 'com.android.library'\n"
              + "}\n\n"
              + "android {\n"
              + "    compileSdk 34\n"
              + "    namespace "
              + "'"
              + pak
              + "'"
              + "\n"
              + "    defaultConfig {\n"
              + "        minSdkVersion 21\n"
              + "        targetSdkVersion 34\n"
              + "    }\n"
              + "    buildTypes {\n"
              + "        release {\n"
              + "            minifyEnabled false\n"
              + "        }\n"
              + "    }\n"
              + "    compileOptions {\n"
              + "        sourceCompatibility JavaVersion.VERSION_17\n"
              + "        targetCompatibility JavaVersion.VERSION_17\n"
              + "    }\n"
              + "}\n"
              + "dependencies {\n"
              + "    //add your dependencies\n"
              + "    implementation \"androidx.appcompat:appcompat:1.7.0-alpha03\"\n"
              + "    implementation \"androidx.constraintlayout:constraintlayout:2.1.4\"\n"
              + "    implementation \"com.google.android.material:material:1.12.0-alpha03\"\n"
              + "}\n";
      String androidManifestContent =
          "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n\n<manifest\n    xmlns:android=\"http://schemas.android.com/apk/res/android\"\n    xmlns:tools=\"http://schemas.android.com/tools\"\n    \n>\n</manifest>\n";
      String mainJavaContent =
          "package "
              + pak
              + ";\n\n\nimport androidx.appcompat.app.AppCompatActivity;\n import android.os.Bundle; \n \npublic class MainActivity extends AppCompatActivity {\n\n  @Override\n  protected void onCreate(Bundle _savedInstanceState) {\n    super.onCreate(_savedInstanceState);\n \n \n  }\n}\n";

      Files.write(moduleFolder.resolve("build.gradle"), buildGradleContent.getBytes());
      Files.write(moduleFolder.resolve(".gitignore"), "/build".getBytes());
      Files.createDirectories(
          moduleFolder.resolve(
              "src/main/java/"
                  + input_pk.getEditText().getText().toString().replace('.', '/')
                  + "/"));
      Files.write(
          moduleFolder.resolve(
              "src/main/java/"
                  + input_pk.getEditText().getText().toString().replace('.', '/')
                  + "/"
                  + "MainActivity.java"),
          mainJavaContent.getBytes());
      Files.write(moduleFolder.resolve("src/main/res/values/strings.xml"), stringsxml.getBytes());
      Files.write(
          moduleFolder.resolve("src/main/AndroidManifest.xml"), androidManifestContent.getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void makeModuleAndroidKts() {
    Path moduleFolder = Paths.get(folder, inputLayout.getEditText().getText().toString());
    try {
      Files.createDirectories(moduleFolder);
      var pak = input_pk.getEditText().getText().toString();
      String buildGradleContent =
          "plugins {\n"
              + "    id('com.android.library')\n"
              + "}\n\n"
              + "android {\n"
              + "    namespace "
              + "'"
              + pak
              + "'"
              + "\n"
              + "    compileSdk = 34\n"
              + "    defaultConfig {\n"
              + "        minSdk = 21\n"
              + "        targetSdk = 34\n"
              + "    }\n"
              + "    buildTypes {\n"
              + "        getByName(\"release\") {\n"
              + "            isMinifyEnabled = false\n"
              + "        }\n"
              + "    }\n"
              + "}\n"
              + "compileOptions {\n"
              + "    sourceCompatibility JavaVersion.VERSION_17\n"
              + "    targetCompatibility JavaVersion.VERSION_17\n"
              + "}\n"
              + "dependencies {\n"
              + "    //add your dependencies\n"
              + "    implementation(\"androidx.appcompat:appcompat:1.7.0-alpha03\")\n"
              + "    implementation(\"androidx.constraintlayout:constraintlayout:2.1.4\")\n"
              + "    implementation(\"com.google.android.material:material:1.12.0-alpha03\")\n"
              + "}\n";
      String androidManifestContent =
          "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n\n<manifest\n    xmlns:android=\"http://schemas.android.com/apk/res/android\"\n    xmlns:tools=\"http://schemas.android.com/tools\"\n    \n>\n</manifest>\n";
      String mainKotlinContent =
          "package "
              + pak
              + ";\n\n\nimport androidx.appcompat.app.AppCompatActivity;\n import android.os.Bundle \n\n class MainActivity : AppCompatActivity() {\n\n  override fun onCreate(savedInstanceState: Bundle?) {\n    super.onCreate(savedInstanceState)\n }\n}\n";

      Files.write(moduleFolder.resolve("build.gradle.kts"), buildGradleContent.getBytes());
      Files.write(moduleFolder.resolve(".gitignore"), "/build".getBytes());

      Files.createDirectories(
          moduleFolder.resolve(
              "src/main/java/"
                  + input_pk.getEditText().getText().toString().replace('.', '/')
                  + "/"));
      Files.write(
          moduleFolder.resolve(
              "src/main/java/"
                  + input_pk.getEditText().getText().toString().replace('.', '/')
                  + "/"
                  + "MainActivity.kt"),
          mainKotlinContent.getBytes());
      Files.write(
          moduleFolder.resolve("src/main/AndroidManifest.xml"), androidManifestContent.getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public interface OnCallBack {
    public void reload();
  }
}
