package ir.ninjacoder.ghostide.project;

public class ProjectDataMaker {

  static String res() {
    return """
        import android.os.Bundle;
        import androidx.appcompat.app.AppCompatActivity;

        public class MainActivity extends AppCompatActivity {
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main); // TODO: add your layout
            }
        }
        """;
  }

  public static String makeJavaNormal(String packageName) {
    return "package " + packageName + ";\n" + res();
  }

  public static String makeKotlinClass(String packageName) {
    return "package "
        + packageName
        + "\n\n"
        + "import android.os.Bundle\n"
        + "import androidx.appcompat.app.AppCompatActivity\n\n"
        + "class MainActivity : AppCompatActivity() {\n"
        + "    override fun onCreate(savedInstanceState: Bundle?) {\n"
        + "        super.onCreate(savedInstanceState)\n"
        + "        setContentView(R.layout.activity_main) // TODO: add your layout\n"
        + "    }\n"
        + "}\n";
  }
  
}
