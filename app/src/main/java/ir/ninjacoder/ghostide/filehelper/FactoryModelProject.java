package ir.ninjacoder.ghostide.filehelper;

import android.text.TextUtils;
import android.widget.CheckBox;
import com.blankj.utilcode.util.ResourceUtils;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import ir.ninjacoder.ghostide.R;
import ir.ninjacoder.ghostide.activities.BaseCompat;
import ir.ninjacoder.ghostide.adapter.ProjectManagerAdapter;
import ir.ninjacoder.ghostide.model.ProjectModel;
import ir.ninjacoder.ghostide.project.ProjectMaker;
import ir.ninjacoder.ghostide.utils.DataUtil;
import ir.ninjacoder.ghostide.utils.FileUtil;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class FactoryModelProject implements ProjectManagerAdapter.OnProjectClick {
  protected List<ProjectModel> itemModel = new ArrayList<>();
  protected ProjectManagerAdapter adaptor;
  protected JavaModule javaModule;
  protected String folder;
  protected ProjectCallBack call;
  private BaseCompat baseCompat;
  private RecyclerView rv;
  private BottomSheetDialog dialogMain;

  public FactoryModelProject(BaseCompat baseCompat, String folder, ProjectCallBack call) {
    this.baseCompat = baseCompat;

    itemModel.add(new ProjectModel("html", R.drawable.ic_material_html, true));
    itemModel.add(new ProjectModel("node js", R.drawable.ic_material_javascript, false));
    itemModel.add(new ProjectModel("cpp", R.drawable.ic_material_cpp, false));
    itemModel.add(new ProjectModel("java", R.drawable.ic_material_java, false));
    itemModel.add(new ProjectModel("php", R.drawable.ic_material_php, false));
    itemModel.add(new ProjectModel("ReactTypeScript", R.drawable.ic_material_react_ts, false));
    itemModel.add(new ProjectModel("ReactJs", R.drawable.ic_material_react, false));
    itemModel.add(new ProjectModel("Flutter", R.drawable.ic_material_dart, false));
    itemModel.add(new ProjectModel("Android", R.drawable.ic_material_android, false));
    bind();
    this.folder = folder;
    this.call = call;
    javaModule = new JavaModule();
  }

  protected void bind() {

    rv = new RecyclerView(baseCompat);
    ViewGroup.LayoutParams param =
        new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    rv.setPadding(8, 8, 8, 8);
    rv.setLayoutParams(param);

    adaptor = new ProjectManagerAdapter(itemModel, this);
    rv.setAdapter(adaptor);
    rv.setLayoutManager(new GridLayoutManager(baseCompat, 2));
    dialogMain = new BottomSheetDialog(baseCompat);
    dialogMain.setContentView(rv);
    dialogMain.show();
  }

  @Override
  public void onClick(View view, int pos) {
    switch (pos) {
      case 0:
        makeHtmlProject();
        dialogMain.dismiss();
        break;

      case 1:
        makeNodeJsProject();
        dialogMain.dismiss();
        break;
      case 2:
        makeCppProject();
        dialogMain.dismiss();
        break;
      case 3:
        {
          makeJavaProject();
          dialogMain.dismiss();
          break;
        }
      case 4:
        makePhpProject();
        dialogMain.dismiss();
        break;
      case 5:
        makeReactProject();
        dialogMain.dismiss();
        break;
      case 6:
        makeReactTypeScriptProject();
        dialogMain.dismiss();
        break;
      case 7:
        makeFlutterProject();
        dialogMain.dismiss();
        break;
      case 8:
        makeAndroidProject();
        dialogMain.dismiss();
        break;
    }
  }

  protected void makeJavaProject() {
    AlertDialog dialog =
        new MaterialAlertDialogBuilder(baseCompat)
            .setTitle("Make java Project")
            .setView(R.layout.project_layout_factory)
            .setPositiveButton(android.R.string.ok, null)
            .create();
    dialog.setOnShowListener(
        __ -> {
          TextInputLayout projectName = dialog.findViewById(R.id.input_projectName);
          TextInputLayout packageName = dialog.findViewById(R.id.input_packagename);
          projectName.setHint("project name");
          packageName.setHint("set package name");
          var btn = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
          var shap = new ShapeAppearanceModel.Builder();
          shap.setAllCorners(CornerFamily.ROUNDED, 20f);
          packageName.setShapeAppearanceModel(shap.build());
          projectName.setShapeAppearanceModel(shap.build());
          packageName
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
                      var regex = "^[a-z][a-z0-9_]*(\\.[a-z][a-z0-9_]*)*$";
                      btn.setEnabled(!s.toString().matches(regex) ? false : true);
                    }
                  });
          btn.setOnClickListener(
              c -> {
                FileUtil.makeDir(folder + projectName.getEditText().getText().toString());
                javaModule.makeModuleClass(
                    "Main", packageName.getEditText().getText().toString(), folder);
                dialog.dismiss();
                call.refrash();
              });
        });
    dialog.show();
  }

  public void makeHtmlProject() {
    var maker = new ProjectMaker(folder, baseCompat, () -> {});
    maker.setMakeHtmlProject();
  }

  public void makeNodeJsProject() {
    AlertDialog dialog =
        new MaterialAlertDialogBuilder(baseCompat)
            .setTitle("Make Node.js Project")
            .setView(R.layout.project_layout_factory)
            .setPositiveButton(android.R.string.ok, null)
            .create();
    dialog.setOnShowListener(
        __ -> {
          TextInputLayout projectName = dialog.findViewById(R.id.input_projectName);
          projectName.setHint("project name");
          dialog
              .findViewById(R.id.input_packagename)
              .setVisibility(View.GONE); // مخفی کردن فیلد package name

          var btn = dialog.getButton(DialogInterface.BUTTON_POSITIVE);

          btn.setOnClickListener(
              c -> {
                // گرفتن نام پروژه از کاربر
                String projectNameStr = projectName.getEditText().getText().toString().trim();
                if (projectNameStr.isEmpty()) {
                  DataUtil.showMessage(baseCompat, "Project name cannot be empty!");
                  return;
                }

                // ایجاد مسیر کامل پوشه پروژه
                String projectDir = folder + "/" + projectNameStr;
                FileUtil.makeDir(projectDir); // ایجاد پوشه پروژه

                // ایجاد پوشه‌های اصلی
                FileUtil.makeDir(projectDir + "/src");
                FileUtil.makeDir(projectDir + "/public");
                FileUtil.makeDir(projectDir + "/routes");
                FileUtil.makeDir(projectDir + "/models");
                FileUtil.makeDir(projectDir + "/views");

                // ایجاد فایل package.json
                String packageJsonContent =
                    "{\n"
                        + "  \"name\": \""
                        + projectNameStr
                        + "\",\n"
                        + "  \"version\": \"1.0.0\",\n"
                        + "  \"description\": \"\",\n"
                        + "  \"main\": \"src/app.js\",\n"
                        + "  \"scripts\": {\n"
                        + "    \"start\": \"node src/app.js\",\n"
                        + "    \"dev\": \"nodemon src/app.js\"\n"
                        + "  },\n"
                        + "  \"author\": \"\",\n"
                        + "  \"license\": \"ISC\",\n"
                        + "  \"dependencies\": {}\n"
                        + "}";
                FileUtil.writeFile(projectDir + "/package.json", packageJsonContent);

                // ایجاد فایل app.js
                String appJsContent =
                    "const express = require('express');\n"
                        + "const path = require('path');\n\n"
                        + "const app = express();\n\n"
                        + "// Middleware\n"
                        + "app.use(express.json());\n"
                        + "app.use(express.urlencoded({ extended: false }));\n"
                        + "app.use(express.static(path.join(__dirname, '../public')));\n\n"
                        + "// Routes\n"
                        + "app.get('/', (req, res) => {\n"
                        + "  res.send('Hello, World!');\n"
                        + "});\n\n"
                        + "// Start server\n"
                        + "const PORT = process.env.PORT || 3000;\n"
                        + "app.listen(PORT, () => {\n"
                        + "  console.log(`Server is running on port ${PORT}`);\n"
                        + "});";
                FileUtil.writeFile(projectDir + "/src/app.js", appJsContent);

                // ایجاد فایل .env
                String envContent = "PORT=3000\n";
                FileUtil.writeFile(projectDir + "/.env", envContent);

                // ایجاد فایل .gitignore
                String gitignoreContent = "node_modules/\n" + ".env\n" + "dist/\n" + "*.log\n";
                FileUtil.writeFile(projectDir + "/.gitignore", gitignoreContent);

                // ایجاد فایل README.md
                String readmeContent =
                    "# "
                        + projectNameStr
                        + "\n\n"
                        + "This is a Node.js project.\n\n"
                        + "Project create by Ghost ide "
                        + "## Getting Started\n\n"
                        + "1. Clone the repository.\n"
                        + "2. Run `npm install` to install dependencies.\n"
                        + "3. Run `npm start` to start the server.\n";
                FileUtil.writeFile(projectDir + "/README.md", readmeContent);

                // ایجاد فایل index.html در پوشه public
                String indexHtmlContent =
                    "<!DOCTYPE html>\n"
                        + "<html lang=\"en\">\n"
                        + "<head>\n"
                        + "  <meta charset=\"UTF-8\">\n"
                        + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                        + "  <title>"
                        + projectNameStr
                        + "</title>\n"
                        + "</head>\n"
                        + "<body>\n"
                        + "  <h1>Welcome to "
                        + projectNameStr
                        + "</h1>\n"
                        + "  <p>This is a sample HTML file.</p>\n"
                        + "</body>\n"
                        + "</html>";
                FileUtil.writeFile(projectDir + "/public/index.html", indexHtmlContent);

                dialog.dismiss();
                call.refrash(); // رفرش لیست پروژه‌ها
              });
        });
    dialog.show();
  }

  public void makeCppProject() {
    AlertDialog dialog =
        new MaterialAlertDialogBuilder(baseCompat)
            .setTitle("Make C++ Project")
            .setView(R.layout.project_layout_factory)
            .setPositiveButton(android.R.string.ok, null)
            .create();
    dialog.setOnShowListener(
        __ -> {
          TextInputLayout projectName = dialog.findViewById(R.id.input_projectName);
          projectName.setHint("project name");
          dialog
              .findViewById(R.id.input_packagename)
              .setVisibility(View.GONE); // مخفی کردن فیلد package name

          var btn = dialog.getButton(DialogInterface.BUTTON_POSITIVE);

          btn.setOnClickListener(
              c -> {
                // گرفتن نام پروژه از کاربر
                String projectNameStr = projectName.getEditText().getText().toString().trim();
                if (projectNameStr.isEmpty()) {
                  DataUtil.showMessage(baseCompat, "Project name cannot be empty!");
                  return;
                }

                // ایجاد مسیر کامل پوشه پروژه
                String projectDir = folder + "/" + projectNameStr;
                FileUtil.makeDir(projectDir); // ایجاد پوشه پروژه

                // ایجاد پوشه‌های اصلی
                FileUtil.makeDir(projectDir + "/src");
                FileUtil.makeDir(projectDir + "/include");
                FileUtil.makeDir(projectDir + "/lib");
                FileUtil.makeDir(projectDir + "/build");

                // ایجاد فایل CMakeLists.txt
                String cmakeContent =
                    "cmake_minimum_required(VERSION 3.10)\n\n"
                        + "project("
                        + projectNameStr
                        + ")\n\n"
                        + "set(CMAKE_CXX_STANDARD 14)\n\n"
                        + "include_directories(include)\n\n"
                        + "file(GLOB SOURCES \"src/*.cpp\")\n\n"
                        + "add_executable("
                        + projectNameStr
                        + " ${SOURCES})\n";
                FileUtil.writeFile(projectDir + "/CMakeLists.txt", cmakeContent);

                // ایجاد فایل main.cpp
                String mainCppContent =
                    "#include <iostream>\n\n"
                        + "int main() {\n"
                        + "    std::cout << \"Hello, World!\" << std::endl;\n"
                        + "    return 0;\n"
                        + "}";
                FileUtil.writeFile(projectDir + "/src/main.cpp", mainCppContent);

                // ایجاد فایل .gitignore
                String gitignoreContent = "build/\n" + "*.o\n" + "*.out\n" + "*.exe\n";
                FileUtil.writeFile(projectDir + "/.gitignore", gitignoreContent);

                // ایجاد فایل README.md
                String readmeContent =
                    "# "
                        + projectNameStr
                        + "\n\n"
                        + "This is a C++ project.\n\n"
                        + "## Getting Started\n\n"
                        + "1. Clone the repository.\n"
                        + "2. Create a build directory: `mkdir build && cd build`.\n"
                        + "3. Run CMake: `cmake ..`.\n"
                        + "4. Build the project: `make`.\n"
                        + "5. Run the executable: `./"
                        + projectNameStr
                        + "`.\n";
                FileUtil.writeFile(projectDir + "/README.md", readmeContent);

                dialog.dismiss();
                call.refrash(); // رفرش لیست پروژه‌ها
              });
        });
    dialog.show();
  }

  /// im not dev php this code deepseek
  public void makePhpProject() {
    AlertDialog dialog =
        new MaterialAlertDialogBuilder(baseCompat)
            .setTitle("Make PHP Project")
            .setView(R.layout.project_layout_factory)
            .setPositiveButton(android.R.string.ok, null)
            .create();
    dialog.setOnShowListener(
        __ -> {
          TextInputLayout projectName = dialog.findViewById(R.id.input_projectName);
          projectName.setHint("project name");
          dialog
              .findViewById(R.id.input_packagename)
              .setVisibility(View.GONE); // مخفی کردن فیلد package name

          var btn = dialog.getButton(DialogInterface.BUTTON_POSITIVE);

          btn.setOnClickListener(
              c -> {
                // گرفتن نام پروژه از کاربر
                String projectNameStr = projectName.getEditText().getText().toString().trim();
                if (projectNameStr.isEmpty()) {
                  DataUtil.showMessage(baseCompat, "Project name cannot be empty!");
                  return;
                }

                // ایجاد مسیر کامل پوشه پروژه
                String projectDir = folder + "/" + projectNameStr;
                FileUtil.makeDir(projectDir); // ایجاد پوشه پروژه

                // ایجاد پوشه‌های اصلی
                FileUtil.makeDir(projectDir + "/public");
                FileUtil.makeDir(projectDir + "/public/css");
                FileUtil.makeDir(projectDir + "/public/js");
                FileUtil.makeDir(projectDir + "/public/images");

                FileUtil.makeDir(projectDir + "/src");
                FileUtil.makeDir(projectDir + "/src/Controllers");
                FileUtil.makeDir(projectDir + "/src/Models");
                FileUtil.makeDir(projectDir + "/src/Views");
                FileUtil.makeDir(projectDir + "/src/Helpers");
                FileUtil.makeDir(projectDir + "/src/routes");

                FileUtil.makeDir(projectDir + "/config");
                FileUtil.makeDir(projectDir + "/storage");
                FileUtil.makeDir(projectDir + "/storage/logs");
                FileUtil.makeDir(projectDir + "/storage/cache");
                FileUtil.makeDir(projectDir + "/storage/uploads");

                FileUtil.makeDir(projectDir + "/vendor");
                FileUtil.makeDir(projectDir + "/tests");

                // ایجاد فایل index.php در پوشه public
                String indexPhpContent =
                    "<?php\n\n"
                        + "require __DIR__ . '/../vendor/autoload.php';\n\n"
                        + "echo \"Hello, World!\";\n";
                FileUtil.writeFile(projectDir + "/public/index.php", indexPhpContent);

                // ایجاد فایل web.php در پوشه src/routes
                String webRoutesContent =
                    "<?php\n\n"
                        + "use App\\Controllers\\HomeController;\n\n"
                        + "// Define your web routes here\n"
                        + "$router->get('/', [HomeController::class, 'index']);\n";
                FileUtil.writeFile(projectDir + "/src/routes/web.php", webRoutesContent);

                // ایجاد فایل api.php در پوشه src/routes
                String apiRoutesContent =
                    "<?php\n\n"
                        + "use App\\Controllers\\ApiController;\n\n"
                        + "// Define your API routes here\n"
                        + "$router->get('/api', [ApiController::class, 'index']);\n";
                FileUtil.writeFile(projectDir + "/src/routes/api.php", apiRoutesContent);

                // ایجاد فایل config.php در پوشه config
                String configPhpContent =
                    "<?php\n\n"
                        + "return [\n"
                        + "    'db_host' => 'localhost',\n"
                        + "    'db_name' => 'database_name',\n"
                        + "    'db_user' => 'root',\n"
                        + "    'db_pass' => 'password'\n"
                        + "];\n";
                FileUtil.writeFile(projectDir + "/config/config.php", configPhpContent);

                // ایجاد فایل .env
                String envContent =
                    "APP_ENV=local\n"
                        + "APP_KEY=\n"
                        + "DB_HOST=localhost\n"
                        + "DB_NAME=database_name\n"
                        + "DB_USER=root\n"
                        + "DB_PASS=password\n";
                FileUtil.writeFile(projectDir + "/.env", envContent);

                // ایجاد فایل composer.json
                String composerContent =
                    "{\n"
                        + "  \"name\": \""
                        + projectNameStr
                        + "\",\n"
                        + "  \"description\": \"A PHP project\",\n"
                        + "  \"type\": \"project\",\n"
                        + "  \"require\": {},\n"
                        + "  \"autoload\": {\n"
                        + "    \"psr-4\": {\n"
                        + "      \"App\\\\\": \"src/\"\n"
                        + "    }\n"
                        + "  }\n"
                        + "}";
                FileUtil.writeFile(projectDir + "/composer.json", composerContent);

                // ایجاد فایل .gitignore
                String gitignoreContent =
                    "vendor/\n"
                        + ".env\n"
                        + "storage/logs/*\n"
                        + "storage/cache/*\n"
                        + "storage/uploads/*\n";
                FileUtil.writeFile(projectDir + "/.gitignore", gitignoreContent);

                // ایجاد فایل README.md
                String readmeContent =
                    "# "
                        + projectNameStr
                        + "\n\n"
                        + "This is a PHP project.\n\n"
                        + "## Getting Started\n\n"
                        + "1. Clone the repository.\n"
                        + "2. Run `composer install` to install dependencies.\n"
                        + "3. Configure your database settings in `.env`.\n"
                        + "4. Point your web server to the `public` directory.\n";
                FileUtil.writeFile(projectDir + "/README.md", readmeContent);

                dialog.dismiss();
                call.refrash(); // رفرش لیست پروژه‌ها
              });
        });
    dialog.show();
  }

  public void makeFlutterProject() {
    AlertDialog dialog =
        new MaterialAlertDialogBuilder(baseCompat)
            .setTitle("Make Flutter Project")
            .setView(R.layout.project_layout_factory)
            .setPositiveButton(android.R.string.ok, null)
            .create();
    dialog.setOnShowListener(
        __ -> {
          TextInputLayout projectName = dialog.findViewById(R.id.input_projectName);
          TextInputLayout packageName = dialog.findViewById(R.id.input_packagename);
          projectName.setHint("project name");
          packageName.setHint("package name (e.g., com.example.app)");
          FileNio.verifyPackageNameImpl(packageName);
          var btn = dialog.getButton(DialogInterface.BUTTON_POSITIVE);

          btn.setOnClickListener(
              c -> {
                // گرفتن نام پروژه و پکیج‌نام از کاربر
                String projectNameStr = projectName.getEditText().getText().toString().trim();
                String packageNameStr = packageName.getEditText().getText().toString().trim();

                if (projectNameStr.isEmpty() || packageNameStr.isEmpty()) {
                  DataUtil.showMessage(
                      baseCompat, "Project name and package name cannot be empty!");
                  return;
                }

                // ایجاد مسیر کامل پوشه پروژه
                String projectDir = folder + "/" + projectNameStr;
                FileUtil.makeDir(projectDir); // ایجاد پوشه پروژه

                // ایجاد پوشه‌های اصلی
                FileUtil.makeDir(
                    projectDir + "/android/app/src/main/java/" + packageNameStr.replace(".", "/"));
                FileUtil.makeDir(projectDir + "/android/app/src/main/res");
                FileUtil.makeDir(projectDir + "/android/app/src/main/res/drawable");
                FileUtil.makeDir(projectDir + "/android/app/src/main/res/mipmap-hdpi");
                FileUtil.makeDir(projectDir + "/android/app/src/main/res/mipmap-mdpi");
                FileUtil.makeDir(projectDir + "/android/app/src/main/res/mipmap-xhdpi");
                FileUtil.makeDir(projectDir + "/android/app/src/main/res/mipmap-xxhdpi");
                FileUtil.makeDir(projectDir + "/android/app/src/main/res/mipmap-xxxhdpi");
                FileUtil.makeDir(projectDir + "/android/app/src/main/res/values");
                FileUtil.makeDir(projectDir + "/android/gradle/wrapper");
                FileUtil.makeDir(projectDir + "/lib/src");
                FileUtil.makeDir(projectDir + "/lib/src/controllers");
                FileUtil.makeDir(projectDir + "/lib/src/models");
                FileUtil.makeDir(projectDir + "/lib/src/views");
                FileUtil.makeDir(projectDir + "/lib/src/services");
                FileUtil.makeDir(projectDir + "/lib/src/utils");
                FileUtil.makeDir(projectDir + "/lib/src/routes");
                FileUtil.makeDir(projectDir + "/assets");
                FileUtil.makeDir(projectDir + "/assets/images");
                FileUtil.makeDir(projectDir + "/assets/fonts");
                FileUtil.makeDir(projectDir + "/test");
                FileUtil.makeDir(projectDir + "/web");
                String gradle_wrapper =
                    """
                distributionBase=GRADLE_USER_HOME
                distributionPath=wrapper/dists
                distributionUrl=https\\://services.gradle.org/distributions/gradle-8.2.1-bin.zip
                networkTimeout=10000
                zipStoreBase=GRADLE_USER_HOME
                zipStorePath=wrapper/dists

                """;

                ResourceUtils.copyFileFromAssets(
                    "gradle-wrapper.jar", projectDir + "/android/gradle/wrapper/");
                FileUtil.writeFile(
                    projectDir + "/android/gradle/wrapper/gradle-wrapper.properties",
                    gradle_wrapper);
                // ایجاد فایل main.dart
                String mainDartContent =
                    "import 'package:flutter/material.dart';\n"
                        + "import 'app.dart';\n\n"
                        + "void main() {\n"
                        + "  runApp(MyApp());\n"
                        + "}\n";
                FileUtil.writeFile(projectDir + "/lib/main.dart", mainDartContent);

                // ایجاد فایل app.dart
                String appDartContent =
                    "import 'package:flutter/material.dart';\n"
                        + "import 'src/routes/app_routes.dart';\n\n"
                        + "class MyApp extends StatelessWidget {\n"
                        + "  @override\n"
                        + "  Widget build(BuildContext context) {\n"
                        + "    return MaterialApp(\n"
                        + "      title: '"
                        + projectNameStr
                        + "',\n"
                        + "      theme: ThemeData(\n"
                        + "        primarySwatch: Colors.blue,\n"
                        + "      ),\n"
                        + "      initialRoute: '/',\n"
                        + "      routes: AppRoutes.routes,\n"
                        + "    );\n"
                        + "  }\n"
                        + "}\n";
                FileUtil.writeFile(projectDir + "/lib/app.dart", appDartContent);

                // ایجاد فایل app_routes.dart
                String appRoutesContent =
                    "import 'package:flutter/material.dart';\n"
                        + "import 'src/views/home_page.dart';\n\n"
                        + "class AppRoutes {\n"
                        + "  static final Map<String, WidgetBuilder> routes = {\n"
                        + "    '/': (context) => HomePage(),\n"
                        + "  };\n"
                        + "}\n";
                FileUtil.writeFile(
                    projectDir + "/lib/src/routes/app_routes.dart", appRoutesContent);

                // ایجاد فایل home_page.dart
                String homePageContent =
                    "import 'package:flutter/material.dart';\n\n"
                        + "class HomePage extends StatelessWidget {\n"
                        + "  @override\n"
                        + "  Widget build(BuildContext context) {\n"
                        + "    return Scaffold(\n"
                        + "      appBar: AppBar(\n"
                        + "        title: Text('Home'),\n"
                        + "      ),\n"
                        + "      body: Center(\n"
                        + "        child: Text('Hello, World!'),\n"
                        + "      ),\n"
                        + "    );\n"
                        + "  }\n"
                        + "}\n";
                FileUtil.writeFile(projectDir + "/lib/src/views/home_page.dart", homePageContent);

                // ایجاد فایل pubspec.yaml
                String pubspecContent =
                    "name: "
                        + projectNameStr.toLowerCase().replace(" ", "_")
                        + "\n"
                        + "description: A new Flutter project.\n\n"
                        + "publish_to: 'none'\n\n"
                        + "version: 1.0.0+1\n\n"
                        + "environment:\n"
                        + "  sdk: '>=2.19.0 <3.0.0'\n\n"
                        + "dependencies:\n"
                        + "  flutter:\n"
                        + "    sdk: flutter\n\n"
                        + "dev_dependencies:\n"
                        + "  flutter_test:\n"
                        + "    sdk: flutter\n\n"
                        + "flutter:\n"
                        + "  uses-material-design: true\n"
                        + "  assets:\n"
                        + "    - assets/images/\n"
                        + "  fonts:\n"
                        + "    - family: CustomFont\n"
                        + "      fonts:\n"
                        + "        - asset: assets/fonts/custom_font.ttf\n";
                FileUtil.writeFile(projectDir + "/pubspec.yaml", pubspecContent);

                // ایجاد فایل AndroidManifest.xml
                String androidManifestContent =
                    "<manifest xmlns:android=\"http://schemas.android.com/apk/res/android\"\n"
                        + "    package=\""
                        + packageNameStr
                        + "\">\n\n"
                        + "    <application\n"
                        + "        android:label=\""
                        + projectNameStr
                        + "\"\n"
                        + "        android:icon=\"@mipmap/ic_launcher\">\n"
                        + "        <activity\n"
                        + "            android:name=\".MainActivity\"\n"
                        + "            android:launchMode=\"singleTop\"\n"
                        + "            android:theme=\"@style/LaunchTheme\"\n"
                        + "            android:configChanges=\"orientation|keyboardHidden|keyboard|screenSize|smallestScreenSize|screenLayout|density|uiMode\"\n"
                        + "            android:hardwareAccelerated=\"true\"\n"
                        + "            android:windowSoftInputMode=\"adjustResize\">\n"
                        + "            <meta-data\n"
                        + "                android:name=\"io.flutter.embedding.android.NormalTheme\"\n"
                        + "                android:resource=\"@style/NormalTheme\"\n"
                        + "                />\n"
                        + "            <intent-filter>\n"
                        + "                <action android:name=\"android.intent.action.MAIN\"/>\n"
                        + "                <category android:name=\"android.intent.category.LAUNCHER\"/>\n"
                        + "            </intent-filter>\n"
                        + "        </activity>\n"
                        + "    </application>\n"
                        + "</manifest>\n";
                FileUtil.writeFile(
                    projectDir + "/android/app/src/main/AndroidManifest.xml",
                    androidManifestContent);

                // ایجاد فایل build.gradle (ماژول app)
                // ایجاد فایل build.gradle (ماژول app)
                String buildGradleContent =
                    "def localProperties = new Properties()\n"
                        + "def localPropertiesFile = rootProject.file('local.properties')\n"
                        + "if (localPropertiesFile.exists()) {\n"
                        + "    localPropertiesFile.withReader('UTF-8') { reader ->\n"
                        + "        localProperties.load(reader)\n"
                        + "    }\n"
                        + "}\n\n"
                        + "def flutterRoot = localProperties.getProperty('flutter.sdk')\n"
                        + "if (flutterRoot == null) {\n"
                        + "    throw new GradleException(\"Flutter SDK not found. Define location with flutter.sdk in the local.properties file.\")\n"
                        + "}\n\n"
                        + "apply plugin: 'com.android.application'\n"
                        + "apply plugin: 'kotlin-android'\n"
                        + "apply from: \"$flutterRoot/packages/flutter_tools/gradle/flutter.gradle\"\n\n"
                        + "android {\n"
                        + "    compileSdkVersion 33\n\n"
                        + "    defaultConfig {\n"
                        + "        applicationId \""
                        + packageNameStr
                        + "\"\n"
                        + "        minSdkVersion 21\n"
                        + "        targetSdkVersion 33\n"
                        + "        versionCode 1\n"
                        + "        versionName \"1.0.0\"\n"
                        + "    }\n\n"
                        + "    buildTypes {\n"
                        + "        release {\n"
                        + "            minifyEnabled false\n"
                        + "            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'\n"
                        + "        }\n"
                        + "    }\n"
                        + "}\n\n"
                        + "flutter {\n"
                        + "    source '../..'\n"
                        + "}\n";
                FileUtil.writeFile(projectDir + "/android/app/build.gradle", buildGradleContent);
                FileUtil.writeFile(projectDir + "/android/app/build.gradle", buildGradleContent);

                // ایجاد فایل MainActivity.kt
                String mainActivityContent =
                    "package "
                        + packageNameStr
                        + "\n\n"
                        + "import io.flutter.embedding.android.FlutterActivity\n\n"
                        + "class MainActivity: FlutterActivity() {\n"
                        + "}\n";
                FileUtil.writeFile(
                    projectDir
                        + "/android/app/src/main/java/"
                        + packageNameStr.replace(".", "/")
                        + "/MainActivity.kt",
                    mainActivityContent);

                // ایجاد فایل README.md
                String readmeContent =
                    "# "
                        + projectNameStr
                        + "\n\n"
                        + "This is a Flutter project.\n\n"
                        + "## Getting Started\n\n"
                        + "1. Clone the repository.\n"
                        + "2. Run `flutter pub get` to install dependencies.\n"
                        + "3. Run `flutter run` to start the app.\n";
                FileUtil.writeFile(projectDir + "/README.md", readmeContent);

                dialog.dismiss();
                call.refrash(); // رفرش لیست پروژه‌ها
              });
        });
    dialog.show();
  }

  public void makeReactProject() {
    AlertDialog dialog =
        new MaterialAlertDialogBuilder(baseCompat)
            .setTitle("Make React Project")
            .setView(R.layout.project_layout_factory)
            .setPositiveButton(android.R.string.ok, null)
            .create();
    dialog.setOnShowListener(
        __ -> {
          TextInputLayout projectName = dialog.findViewById(R.id.input_projectName);
          projectName.setHint("project name");
          dialog
              .findViewById(R.id.input_packagename)
              .setVisibility(View.GONE); // مخفی کردن فیلد package name

          var btn = dialog.getButton(DialogInterface.BUTTON_POSITIVE);

          btn.setOnClickListener(
              c -> {
                // گرفتن نام پروژه از کاربر
                String projectNameStr = projectName.getEditText().getText().toString().trim();
                if (projectNameStr.isEmpty()) {
                  DataUtil.showMessage(baseCompat, "Project name cannot be empty!");
                  return;
                }

                // ایجاد مسیر کامل پوشه پروژه
                String projectDir = folder + "/" + projectNameStr;
                FileUtil.makeDir(projectDir); // ایجاد پوشه پروژه

                // ایجاد پوشه‌های اصلی
                FileUtil.makeDir(projectDir + "/src");
                FileUtil.makeDir(projectDir + "/src/components");
                FileUtil.makeDir(projectDir + "/src/pages");
                FileUtil.makeDir(projectDir + "/src/assets");
                FileUtil.makeDir(projectDir + "/src/styles");
                FileUtil.makeDir(projectDir + "/src/utils");
                FileUtil.makeDir(projectDir + "/public");

                // ایجاد فایل package.json
                String packageJsonContent =
                    "{\n"
                        + "  \"name\": \""
                        + projectNameStr.toLowerCase().replace(" ", "-")
                        + "\",\n"
                        + "  \"version\": \"1.0.0\",\n"
                        + "  \"description\": \"A React project\",\n"
                        + "  \"scripts\": {\n"
                        + "    \"start\": \"react-scripts start\",\n"
                        + "    \"build\": \"react-scripts build\",\n"
                        + "    \"test\": \"react-scripts test\",\n"
                        + "    \"eject\": \"react-scripts eject\"\n"
                        + "  },\n"
                        + "  \"dependencies\": {\n"
                        + "    \"react\": \"^18.2.0\",\n"
                        + "    \"react-dom\": \"^18.2.0\",\n"
                        + "    \"react-scripts\": \"5.0.1\",\n"
                        + "    \"react-router-dom\": \"^6.0.0\",\n"
                        + "    \"axios\": \"^1.0.0\"\n"
                        + "  }\n"
                        + "}\n";
                FileUtil.writeFile(projectDir + "/package.json", packageJsonContent);

                // ایجاد فایل index.html در پوشه public
                String indexHtmlContent =
                    "<!DOCTYPE html>\n"
                        + "<html lang=\"en\">\n"
                        + "<head>\n"
                        + "  <meta charset=\"UTF-8\">\n"
                        + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                        + "  <title>"
                        + projectNameStr
                        + "</title>\n"
                        + "</head>\n"
                        + "<body>\n"
                        + "  <div id=\"root\"></div>\n"
                        + "</body>\n"
                        + "</html>\n";
                FileUtil.writeFile(projectDir + "/public/index.html", indexHtmlContent);

                // ایجاد فایل index.js در پوشه src
                String indexJsContent =
                    "import React from 'react';\n"
                        + "import ReactDOM from 'react-dom/client';\n"
                        + "import App from './App';\n"
                        + "import './styles/global.css';\n\n"
                        + "const root = ReactDOM.createRoot(document.getElementById('root'));\n"
                        + "root.render(<App />);\n";
                FileUtil.writeFile(projectDir + "/src/index.js", indexJsContent);

                // ایجاد فایل App.js در پوشه src
                String appJsContent =
                    "import React from 'react';\n"
                        + "import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';\n"
                        + "import HomePage from './pages/HomePage';\n"
                        + "import AboutPage from './pages/AboutPage';\n\n"
                        + "const App = () => {\n"
                        + "  return (\n"
                        + "    <Router>\n"
                        + "      <Routes>\n"
                        + "        <Route path=\"/\" element={<HomePage />} />\n"
                        + "        <Route path=\"/about\" element={<AboutPage />} />\n"
                        + "      </Routes>\n"
                        + "    </Router>\n"
                        + "  );\n"
                        + "};\n\n"
                        + "export default App;\n";
                FileUtil.writeFile(projectDir + "/src/App.js", appJsContent);

                // ایجاد فایل HomePage.js در پوشه src/pages
                String homePageContent =
                    "import React from 'react';\n\n"
                        + "const HomePage = () => {\n"
                        + "  return (\n"
                        + "    <div>\n"
                        + "      <h1>Home Page</h1>\n"
                        + "    </div>\n"
                        + "  );\n"
                        + "};\n\n"
                        + "export default HomePage;\n";
                FileUtil.writeFile(projectDir + "/src/pages/HomePage.js", homePageContent);

                // ایجاد فایل AboutPage.js در پوشه src/pages
                String aboutPageContent =
                    "import React from 'react';\n\n"
                        + "const AboutPage = () => {\n"
                        + "  return (\n"
                        + "    <div>\n"
                        + "      <h1>About Page</h1>\n"
                        + "    </div>\n"
                        + "  );\n"
                        + "};\n\n"
                        + "export default AboutPage;\n";
                FileUtil.writeFile(projectDir + "/src/pages/AboutPage.js", aboutPageContent);

                // ایجاد فایل global.css در پوشه src/styles
                String globalCssContent =
                    "body {\n" + "  margin: 0;\n" + "  font-family: Arial, sans-serif;\n" + "}\n";
                FileUtil.writeFile(projectDir + "/src/styles/global.css", globalCssContent);

                // ایجاد فایل README.md
                String readmeContent =
                    "# "
                        + projectNameStr
                        + "\n\n"
                        + "This is a React project.\n\n"
                        + "## Getting Started\n\n"
                        + "1. Clone the repository.\n"
                        + "2. Run `npm install` to install dependencies.\n"
                        + "3. Run `npm start` to start the development server.\n";
                FileUtil.writeFile(projectDir + "/README.md", readmeContent);

                dialog.dismiss();
                call.refrash(); // رفرش لیست پروژه‌ها
              });
        });
    dialog.show();
  }

  public void makeReactTypeScriptProject() {
    AlertDialog dialog =
        new MaterialAlertDialogBuilder(baseCompat)
            .setTitle("Make React TypeScript Project")
            .setView(R.layout.project_layout_factory)
            .setPositiveButton(android.R.string.ok, null)
            .create();
    dialog.setOnShowListener(
        __ -> {
          TextInputLayout projectName = dialog.findViewById(R.id.input_projectName);
          projectName.setHint("project name");
          dialog
              .findViewById(R.id.input_packagename)
              .setVisibility(View.GONE); // مخفی کردن فیلد package name

          var btn = dialog.getButton(DialogInterface.BUTTON_POSITIVE);

          btn.setOnClickListener(
              c -> {
                // گرفتن نام پروژه از کاربر
                String projectNameStr = projectName.getEditText().getText().toString().trim();
                if (projectNameStr.isEmpty()) {
                  DataUtil.showMessage(baseCompat, "Project name cannot be empty!");
                  return;
                }

                // ایجاد مسیر کامل پوشه پروژه
                String projectDir = folder + "/" + projectNameStr;
                FileUtil.makeDir(projectDir); // ایجاد پوشه پروژه

                // ایجاد پوشه‌های اصلی
                FileUtil.makeDir(projectDir + "/src");
                FileUtil.makeDir(projectDir + "/src/components");
                FileUtil.makeDir(projectDir + "/src/pages");
                FileUtil.makeDir(projectDir + "/src/assets");
                FileUtil.makeDir(projectDir + "/src/styles");
                FileUtil.makeDir(projectDir + "/src/utils");
                FileUtil.makeDir(projectDir + "/public");

                // ایجاد فایل package.json
                String packageJsonContent =
                    "{\n"
                        + "  \"name\": \""
                        + projectNameStr.toLowerCase().replace(" ", "-")
                        + "\",\n"
                        + "  \"version\": \"1.0.0\",\n"
                        + "  \"description\": \"A React TypeScript project\",\n"
                        + "  \"scripts\": {\n"
                        + "    \"start\": \"react-scripts start\",\n"
                        + "    \"build\": \"react-scripts build\",\n"
                        + "    \"test\": \"react-scripts test\",\n"
                        + "    \"eject\": \"react-scripts eject\"\n"
                        + "  },\n"
                        + "  \"dependencies\": {\n"
                        + "    \"react\": \"^18.2.0\",\n"
                        + "    \"react-dom\": \"^18.2.0\",\n"
                        + "    \"react-scripts\": \"5.0.1\",\n"
                        + "    \"typescript\": \"^5.0.0\",\n"
                        + "    \"@types/react\": \"^18.0.0\",\n"
                        + "    \"@types/react-dom\": \"^18.0.0\",\n"
                        + "    \"react-router-dom\": \"^6.0.0\",\n"
                        + "    \"axios\": \"^1.0.0\"\n"
                        + "  }\n"
                        + "}\n";
                FileUtil.writeFile(projectDir + "/package.json", packageJsonContent);

                // ایجاد فایل index.html در پوشه public
                String indexHtmlContent =
                    "<!DOCTYPE html>\n"
                        + "<html lang=\"en\">\n"
                        + "<head>\n"
                        + "  <meta charset=\"UTF-8\">\n"
                        + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                        + "  <title>"
                        + projectNameStr
                        + "</title>\n"
                        + "</head>\n"
                        + "<body>\n"
                        + "  <div id=\"root\"></div>\n"
                        + "</body>\n"
                        + "</html>\n";
                FileUtil.writeFile(projectDir + "/public/index.html", indexHtmlContent);

                // ایجاد فایل index.tsx در پوشه src
                String indexTsxContent =
                    "import React from 'react';\n"
                        + "import ReactDOM from 'react-dom/client';\n"
                        + "import App from './App';\n"
                        + "import './styles/global.css';\n\n"
                        + "const root = ReactDOM.createRoot(document.getElementById('root') as HTMLElement);\n"
                        + "root.render(<App />);\n";
                FileUtil.writeFile(projectDir + "/src/index.tsx", indexTsxContent);

                // ایجاد فایل App.tsx در پوشه src
                String appTsxContent =
                    "import React from 'react';\n"
                        + "import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';\n"
                        + "import HomePage from './pages/HomePage';\n"
                        + "import AboutPage from './pages/AboutPage';\n\n"
                        + "const App: React.FC = () => {\n"
                        + "  return (\n"
                        + "    <Router>\n"
                        + "      <Routes>\n"
                        + "        <Route path=\"/\" element={<HomePage />} />\n"
                        + "        <Route path=\"/about\" element={<AboutPage />} />\n"
                        + "      </Routes>\n"
                        + "    </Router>\n"
                        + "  );\n"
                        + "};\n\n"
                        + "export default App;\n";
                FileUtil.writeFile(projectDir + "/src/App.tsx", appTsxContent);

                // ایجاد فایل HomePage.tsx در پوشه src/pages
                String homePageContent =
                    "import React from 'react';\n\n"
                        + "const HomePage: React.FC = () => {\n"
                        + "  return (\n"
                        + "    <div>\n"
                        + "      <h1>Home Page</h1>\n"
                        + "    </div>\n"
                        + "  );\n"
                        + "};\n\n"
                        + "export default HomePage;\n";
                FileUtil.writeFile(projectDir + "/src/pages/HomePage.tsx", homePageContent);

                // ایجاد فایل AboutPage.tsx در پوشه src/pages
                String aboutPageContent =
                    "import React from 'react';\n\n"
                        + "const AboutPage: React.FC = () => {\n"
                        + "  return (\n"
                        + "    <div>\n"
                        + "      <h1>About Page</h1>\n"
                        + "    </div>\n"
                        + "  );\n"
                        + "};\n\n"
                        + "export default AboutPage;\n";
                FileUtil.writeFile(projectDir + "/src/pages/AboutPage.tsx", aboutPageContent);

                // ایجاد فایل global.css در پوشه src/styles
                String globalCssContent =
                    "body {\n" + "  margin: 0;\n" + "  font-family: Arial, sans-serif;\n" + "}\n";
                FileUtil.writeFile(projectDir + "/src/styles/global.css", globalCssContent);

                // ایجاد فایل tsconfig.json
                String tsconfigContent =
                    "{\n"
                        + "  \"compilerOptions\": {\n"
                        + "    \"target\": \"es5\",\n"
                        + "    \"lib\": [\"dom\", \"dom.iterable\", \"esnext\"],\n"
                        + "    \"allowJs\": true,\n"
                        + "    \"skipLibCheck\": true,\n"
                        + "    \"esModuleInterop\": true,\n"
                        + "    \"allowSyntheticDefaultImports\": true,\n"
                        + "    \"strict\": true,\n"
                        + "    \"forceConsistentCasingInFileNames\": true,\n"
                        + "    \"module\": \"esnext\",\n"
                        + "    \"moduleResolution\": \"node\",\n"
                        + "    \"resolveJsonModule\": true,\n"
                        + "    \"isolatedModules\": true,\n"
                        + "    \"noEmit\": true,\n"
                        + "    \"jsx\": \"react-jsx\"\n"
                        + "  },\n"
                        + "  \"include\": [\"src\"]\n"
                        + "}\n";
                FileUtil.writeFile(projectDir + "/tsconfig.json", tsconfigContent);
                String readmeContent =
                    "# "
                        + projectNameStr
                        + "\n\n"
                        + "This is a React TypeScript project.\n\n"
                        + "## Getting Started\n\n"
                        + "1. Clone the repository.\n"
                        + "2. Run `npm install` to install dependencies.\n"
                        + "3. Run `npm start` to start the development server.\n";
                FileUtil.writeFile(projectDir + "/README.md", readmeContent);

                dialog.dismiss();
                call.refrash();
              });
        });
    dialog.show();
  }

  public void makeAndroidProject() {
    AlertDialog dialog =
        new MaterialAlertDialogBuilder(baseCompat)
            .setTitle("Make Android Project")
            .setView(R.layout.project_layout_factory)
            .setPositiveButton(android.R.string.ok, null)
            .create();
    dialog.setOnShowListener(
        __ -> {
          TextInputLayout projectName = dialog.findViewById(R.id.input_projectName);
          TextInputLayout packageName = dialog.findViewById(R.id.input_packagename);
          projectName.setHint("project name");
          packageName.setHint("package name (e.g., com.example.app)");
          FileNio.verifyPackageNameImpl(packageName);
          CheckBox kotlinCheckBox = dialog.findViewById(R.id.boxmod);
          kotlinCheckBox.setVisibility(View.VISIBLE);
          kotlinCheckBox.setText("Use Kotlin");
          kotlinCheckBox.setChecked(true);

          var btn = dialog.getButton(DialogInterface.BUTTON_POSITIVE);

          btn.setOnClickListener(
              c -> {
                String projectNameStr = projectName.getEditText().getText().toString().trim();
                String packageNameStr = packageName.getEditText().getText().toString().trim();

                if (projectNameStr.isEmpty() || packageNameStr.isEmpty()) {
                  DataUtil.showMessage(
                      baseCompat, "Project name and package name cannot be empty!");
                  return;
                }

                boolean useKotlin = kotlinCheckBox.isChecked();

                String projectDir = folder + "/" + projectNameStr;
                FileUtil.makeDir(projectDir);

                FileUtil.makeDir(
                    projectDir + "/app/src/main/java/" + packageNameStr.replace(".", "/"));
                FileUtil.makeDir(projectDir + "/app/src/main/res");
                FileUtil.makeDir(projectDir + "/app/src/main/res/layout");
                FileUtil.makeDir(projectDir + "/app/src/main/res/values");
                FileUtil.makeDir(projectDir + "/app/src/main/res/drawable");
                FileUtil.makeDir(projectDir + "/gradle/wrapper");

                String buildGradleProjectContent =
                    "buildscript {\n"
                        + "    ext.kotlin_version = '1.8.0'\n"
                        + "    repositories {\n"
                        + "        google()\n"
                        + "        mavenCentral()\n"
                        + "    }\n"
                        + "    dependencies {\n"
                        + "        classpath 'com.android.tools.build:gradle:8.0.0'\n"
                        + (useKotlin
                            ? "        classpath \"org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version\"\n"
                            : "")
                        + "    }\n"
                        + "}\n\n"
                        + "allprojects {\n"
                        + "    repositories {\n"
                        + "        google()\n"
                        + "        mavenCentral()\n"
                        + "    }\n"
                        + "}\n\n"
                        + "task clean(type: Delete) {\n"
                        + "    delete rootProject.buildDir\n"
                        + "}\n";
                FileUtil.writeFile(projectDir + "/build.gradle", buildGradleProjectContent);

                String gradleWrapperPropertiesContent =
                    "distributionBase=GRADLE_USER_HOME\n"
                        + "distributionPath=wrapper/dists\n"
                        + "distributionUrl=https\\://services.gradle.org/distributions/gradle-8.0-bin.zip\n"
                        + "zipStoreBase=GRADLE_USER_HOME\n"
                        + "zipStorePath=wrapper/dists\n";
                FileUtil.writeFile(
                    projectDir + "/gradle/wrapper/gradle-wrapper.properties",
                    gradleWrapperPropertiesContent);
                ResourceUtils.copyFileFromAssets(
                    "gradle-wrapper.jar", projectDir + "/gradle/wrapper/gradle-wrapper.properties");

                String gradlePropertiesContent =
                    "org.gradle.jvmargs=-Xmx2048m -Dfile.encoding=UTF-8\n"
                        + "android.useAndroidX=true\n"
                        + "android.enableJetifier=true\n";
                FileUtil.writeFile(projectDir + "/gradle.properties", gradlePropertiesContent);
                ResourceUtils.copyFileFromAssets("gradlew", projectDir + "/");
                ResourceUtils.copyFileFromAssets("gradlew.bat", projectDir + "/");
                String gitignoreContent =
                    "*.iml\n"
                        + ".gradle\n"
                        + "/local.properties\n"
                        + "/.idea/caches\n"
                        + "/.idea/libraries\n"
                        + "/.idea/modules.xml\n"
                        + "/.idea/workspace.xml\n"
                        + "/.idea/navEditor.xml\n"
                        + "/.idea/assetWizardSettings.xml\n"
                        + ".DS_Store\n"
                        + "/build\n"
                        + "/captures\n"
                        + ".externalNativeBuild\n"
                        + ".cxx\n";
                FileUtil.writeFile(projectDir + "/.gitignore", gitignoreContent);

                String buildGradleAppContent =
                    "plugins {\n"
                        + "    id 'com.android.application'\n"
                        + (useKotlin ? "    id 'kotlin-android'\n" : "")
                        + "}\n\n"
                        + "android {\n"
                        + "    namespace '"
                        + packageNameStr
                        + "'\n"
                        + "    compileSdk 33\n\n"
                        + "    defaultConfig {\n"
                        + "        applicationId \""
                        + packageNameStr
                        + "\"\n"
                        + "        minSdk 21\n"
                        + "        targetSdk 33\n"
                        + "        versionCode 1\n"
                        + "        versionName \"1.0\"\n"
                        + "    }\n\n"
                        + "    buildTypes {\n"
                        + "        release {\n"
                        + "            minifyEnabled false\n"
                        + "            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'\n"
                        + "        }\n"
                        + "    }\n"
                        + "    compileOptions {\n"
                        + "        sourceCompatibility JavaVersion.VERSION_17\n"
                        + "        targetCompatibility JavaVersion.VERSION_17\n"
                        + "    }\n"
                        + (useKotlin
                            ? "    kotlinOptions {\n" + "        jvmTarget = '17'\n" + "    }\n"
                            : "")
                        + "}\n\n"
                        + "dependencies {\n"
                        + "    implementation 'androidx.appcompat:appcompat:1.6.1'\n"
                        + "    implementation 'com.google.android.material:material:1.9.0'\n"
                        + "    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'\n"
                        + (useKotlin ? "    implementation 'androidx.core:core-ktx:1.10.1'\n" : "")
                        + "}\n";
                FileUtil.writeFile(projectDir + "/app/build.gradle", buildGradleAppContent);

                String settingsGradleContent =
                    "pluginManagement {\n"
                        + "    repositories {\n"
                        + "        google()\n"
                        + "        mavenCentral()\n"
                        + "        gradlePluginPortal()\n"
                        + "    }\n"
                        + "}\n"
                        + "dependencyResolutionManagement {\n"
                        + "    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)\n"
                        + "    repositories {\n"
                        + "        google()\n"
                        + "        mavenCentral()\n"
                        + "    }\n"
                        + "}\n"
                        + "rootProject.name = \""
                        + projectNameStr
                        + "\"\n"
                        + "include ':app'\n";
                FileUtil.writeFile(projectDir + "/settings.gradle", settingsGradleContent);

                String androidManifestContent =
                    "<manifest xmlns:android=\"http://schemas.android.com/apk/res/android\"\n"
                        + "    package=\""
                        + packageNameStr
                        + "\">\n\n"
                        + "    <application\n"
                        + "        android:label=\""
                        + projectNameStr
                        + "\"\n"
                        + "        android:icon=\"@mipmap/ic_launcher\">\n"
                        + "        <activity\n"
                        + "            android:name=\".MainActivity\"\n"
                        + "            android:exported=\"true\">\n"
                        + "            <intent-filter>\n"
                        + "                <action android:name=\"android.intent.action.MAIN\" />\n"
                        + "                <category android:name=\"android.intent.category.LAUNCHER\" />\n"
                        + "            </intent-filter>\n"
                        + "        </activity>\n"
                        + "    </application>\n"
                        + "</manifest>\n";
                FileUtil.writeFile(
                    projectDir + "/app/src/main/AndroidManifest.xml", androidManifestContent);

                String mainActivityContent;
                if (useKotlin) {
                  mainActivityContent =
                      "package "
                          + packageNameStr
                          + "\n\n"
                          + "import android.os.Bundle\n"
                          + "import androidx.appcompat.app.AppCompatActivity\n\n"
                          + "class MainActivity : AppCompatActivity() {\n"
                          + "    override fun onCreate(savedInstanceState: Bundle?) {\n"
                          + "        super.onCreate(savedInstanceState)\n"
                          + "        setContentView(R.layout.activity_main)\n"
                          + "    }\n"
                          + "}\n";
                  FileUtil.writeFile(
                      projectDir
                          + "/app/src/main/java/"
                          + packageNameStr.replace(".", "/")
                          + "/MainActivity.kt",
                      mainActivityContent);
                } else {
                  mainActivityContent =
                      "package "
                          + packageNameStr
                          + ";\n\n"
                          + "import android.os.Bundle;\n"
                          + "import androidx.appcompat.app.AppCompatActivity;\n\n"
                          + "public class MainActivity extends AppCompatActivity {\n"
                          + "    @Override\n"
                          + "    protected void onCreate(Bundle savedInstanceState) {\n"
                          + "        super.onCreate(savedInstanceState);\n"
                          + "        setContentView(R.layout.activity_main);\n"
                          + "    }\n"
                          + "}\n";
                  FileUtil.writeFile(
                      projectDir
                          + "/app/src/main/java/"
                          + packageNameStr.replace(".", "/")
                          + "/MainActivity.java",
                      mainActivityContent);
                }

                String activityMainContent =
                    "<androidx.constraintlayout.widget.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n"
                        + "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n"
                        + "    xmlns:tools=\"http://schemas.android.com/tools\"\n"
                        + "    android:layout_width=\"match_parent\"\n"
                        + "    android:layout_height=\"match_parent\"\n"
                        + "    tools:context=\".MainActivity\">\n\n"
                        + "    <TextView\n"
                        + "        android:layout_width=\"wrap_content\"\n"
                        + "        android:layout_height=\"wrap_content\"\n"
                        + "        android:text=\"Hello, World!\"\n"
                        + "        app:layout_constraintBottom_toBottomOf=\"parent\"\n"
                        + "        app:layout_constraintEnd_toEndOf=\"parent\"\n"
                        + "        app:layout_constraintStart_toStartOf=\"parent\"\n"
                        + "        app:layout_constraintTop_toTopOf=\"parent\" />\n\n"
                        + "</androidx.constraintlayout.widget.ConstraintLayout>\n";
                FileUtil.writeFile(
                    projectDir + "/app/src/main/res/layout/activity_main.xml", activityMainContent);

                String stringsContent =
                    "<resources>\n"
                        + "    <string name=\"app_name\">"
                        + projectNameStr
                        + "</string>\n"
                        + "</resources>\n";
                FileUtil.writeFile(
                    projectDir + "/app/src/main/res/values/strings.xml", stringsContent);

                String readmeContent =
                    "# "
                        + projectNameStr
                        + "\n\n"
                        + "This is an Android project.\n\n"
                        + "## Getting Started\n\n"
                        + "1. Open the project in Android Studio.\n"
                        + "2. Sync the project with Gradle files.\n"
                        + "3. Run the app on an emulator or physical device.\n";
                FileUtil.writeFile(projectDir + "/README.md", readmeContent);

                dialog.dismiss();
                call.refrash();
              });
        });
    dialog.show();
  }

  public interface ProjectCallBack {
    public void refrash();
  }
}
