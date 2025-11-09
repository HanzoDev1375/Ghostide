package ir.ninjacoder.ghostide.core.filehelper;
import ir.ninjacoder.ghostide.core.utils.FileUtil;

public class JavaModule {

  public void makeModuleClass(String className, String packageName, String output) {

    String javaCode =
        "package "
            + packageName
            + "\n\n"
            + "public class "
            + className
            + " { \n "
            + "public static void main(String[] ghost) { \n\n } \n}";
			
	FileUtil.writeFile(javaCode,output);
  }

  public void makeModuleInterface(String interfaceName, String packageName, String output) {
	  String javaCode =
        "package "
            + packageName
            + "\n\n"
            + "public inderface "
            + interfaceName
            + " { \n "
            + "public void run() { \n\n } \n}";
	FileUtil.writeFile(javaCode,output);
  }

  public void makeModuleEnum(String enums, String packageName, String output) {
	  String javaCode =
        "package "
            + packageName
            + "\n\n"
            + "public enum "
            + enums
            + " { \n "
            + "ID \n}";
	FileUtil.writeFile(javaCode,output);
  }

  public void makeModuleAppCompatActivity(String className, String packageName, String output) {}
}
