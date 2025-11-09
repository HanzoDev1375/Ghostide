package ir.ninjacoder.ghostide.core.marco;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.Arrays;
import java.util.List;

import ir.ninjacoder.codesnap.LangType;
import ir.ninjacoder.codesnap.colorhelper.ThemeManager;
import ir.ninjacoder.ghostide.core.IdeEditor;
import ir.ninjacoder.ghostide.core.databinding.CodesnaplayoutBinding;
import ir.ninjacoder.prograsssheet.CustomSheet;

public class CodeSnap {
  private Context context;
  private String path;
  private IdeEditor editor;
  protected Sheets sheet;
  private CodesnaplayoutBinding binding;

  public CodeSnap(Context context, String path, IdeEditor editor) {
    this.context = context;
    this.path = path;
    this.editor = editor;
    init();
  }

  void init() {
    binding = CodesnaplayoutBinding.inflate(LayoutInflater.from(context));
    sheet = new Sheets(context);
    sheet.show();
    binding.shot.setOnClickListener(
        v -> {
          binding.group.takeScreenshot();
        });

    binding.group.setText(editor.getSelectedText());
    List<ThemeManager> themeList = Arrays.asList(ThemeManager.values());

    ArrayAdapter<ThemeManager> adapter =
        new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, themeList);
    binding.sptheme.setAdapter(adapter);
    binding.group.setTheme(ThemeManager.DEFAULTTHEME);
    binding.sptheme.setOnItemSelectedListener(
        new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            ThemeManager selectedTheme = themeList.get(position);
            binding.group.setTheme(selectedTheme);
          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {}
        });
    if (path.endsWith(".java")) {
      binding.group.setType(LangType.JAVA);
    } else if (path.endsWith(".c")) {
      binding.group.setType(LangType.C);
    } else if (path.endsWith(".cpp")) {
      binding.group.setType(LangType.CPP);
    } else if (path.endsWith(".cs")) {
      binding.group.setType(LangType.CSHARP);
    } else if (path.endsWith(".css")) {
      binding.group.setType(LangType.CSS);
    } else if (path.endsWith(".js")) {
      binding.group.setType(LangType.JAVASCRIPT);
    } else if (path.endsWith(".kt") || path.endsWith(".kts")) {
      binding.group.setType(LangType.KOTLIN);
    } else if (path.endsWith(".py")) {
      binding.group.setType(LangType.PYTHON);
    } else if (path.endsWith(".php")) {
      binding.group.setType(LangType.PHP);
    } else if (path.endsWith(".html")) {
      binding.group.setType(LangType.HTML);
    } else if (path.endsWith(".gradle")) {
      binding.group.setType(LangType.GRADLE);
    } else if (path.endsWith(".rs")) {
      binding.group.setType(LangType.RUST);
    } else if (path.endsWith(".md")) {
      binding.group.setType(LangType.MARKDOWN);
    } else if (path.endsWith(".json")) {
      binding.group.setType(LangType.JSON);
    } else if (path.endsWith(".go")) {
      binding.group.setType(LangType.GO);
    } else if (path.endsWith(".yml")) {
      binding.group.setType(LangType.YAML);
    } else if (path.endsWith(".rb")) {
      binding.group.setType(LangType.RUBY);
    } else if (path.endsWith(".xml")) {
      binding.group.setType(LangType.XML);
    } else if (path.endsWith(".zig")) {
      binding.group.setType(LangType.ZIG);
    } else if (path.endsWith(".lua")) {
      binding.group.setType(LangType.LUA);
    } else binding.group.setType(LangType.NONE);
    
  }

  class Sheets extends CustomSheet {
    Sheets(Context c) {
      super(c);
    }

    @Override
    public View getView() {
      return binding.getRoot();
    }
  }
}
