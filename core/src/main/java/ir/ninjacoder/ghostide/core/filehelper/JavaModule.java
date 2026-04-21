package ir.ninjacoder.ghostide.core.filehelper;

import ir.ninjacoder.ghostide.core.utils.FileUtil;

public class JavaModule {

  public void makeModuleClass(String className, String packageName, String outputDir) {
    String javaCode =
        "package "
            + packageName
            + ";\n\n"
            + "public class "
            + className
            + " {\n\n"
            + "    public static void main(String[] args) {\n"
            + "        System.out.println(\"Hello Ghost ide!\");\n"
            + "    }\n"
            + "}\n";

    String packagePath = packageName.replace(".", "/");
    String fullPath = outputDir + "/" + packagePath + "/" + className + ".java";
    FileUtil.makeDir(outputDir + "/" + packagePath);

    FileUtil.writeFile(fullPath, javaCode);
  }

  public void makeModuleInterface(String interfaceName, String packageName, String outputDir) {
    String javaCode =
        "package "
            + packageName
            + ";\n\n"
            + "public interface "
            + interfaceName
            + " {\n"
            + "    void run();\n"
            + "}\n";

    String packagePath = packageName.replace(".", "/");
    String fullPath = outputDir + "/" + packagePath + "/" + interfaceName + ".java";

    FileUtil.makeDir(outputDir + "/" + packagePath);
    FileUtil.writeFile(fullPath, javaCode);
  }

  public void makeModuleEnum(String enumName, String packageName, String outputDir) {
    String javaCode =
        "package "
            + packageName
            + ";\n\n"
            + "public enum "
            + enumName
            + " {\n"
            + "    VALUE1,\n"
            + "    VALUE2,\n"
            + "    VALUE3\n"
            + "}\n";

    String packagePath = packageName.replace(".", "/");
    String fullPath = outputDir + "/" + packagePath + "/" + enumName + ".java";

    FileUtil.makeDir(outputDir + "/" + packagePath);
    FileUtil.writeFile(fullPath, javaCode);
  }

  public void makeModuleAppCompatActivity(String className, String packageName, String outputDir) {
    String javaCode =
        "package "
            + packageName
            + ";\n\n"
            + "import android.os.Bundle;\n"
            + "import androidx.appcompat.app.AppCompatActivity;\n\n"
            + "public class "
            + className
            + " extends AppCompatActivity {\n\n"
            + "    @Override\n"
            + "    protected void onCreate(Bundle savedInstanceState) {\n"
            + "        super.onCreate(savedInstanceState);\n"
            + "        setContentView(R.layout.activity_main);\n"
            + "    }\n"
            + "}\n";

    String packagePath = packageName.replace(".", "/");
    String fullPath = outputDir + "/" + packagePath + "/" + className + ".java";

    FileUtil.makeDir(outputDir + "/" + packagePath);
    FileUtil.writeFile(fullPath, javaCode);
  }
}
