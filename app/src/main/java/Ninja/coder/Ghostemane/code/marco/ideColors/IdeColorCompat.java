package Ninja.coder.Ghostemane.code.marco.ideColors;

import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.utils.ColorAndroid12;
import Ninja.coder.Ghostemane.code.utils.FileUtil;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.color.MaterialColors;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.util.HashMap;
import java.util.Map;
import ninja.coder.appuploader.utils.ShapeName;
import ninja.coder.appuploader.utils.ShapeUtils;

public class IdeColorCompat {
  private CodeEditor editor;
  

  public IdeColorCompat(CodeEditor editor) {
    this.editor = editor;
    
  }

  public void Colors(View view, TextView text) {
    
  }

  public void setIconLang(String path, ImageView icon) {
    icon.setColorFilter(
        MaterialColors.getColor(icon, ColorAndroid12.ColorNormal), PorterDuff.Mode.MULTIPLY);
    if (path.endsWith(".css")) {
      icon.setImageResource(R.drawable.ic_material_css);
    } else if (path.endsWith(".g4")) {
      icon.setImageResource(R.drawable.antlr4_24dp);
    } else if (path.endsWith(".cpp")) {
      icon.setImageResource(R.drawable.ic_material_cpp);
    } else if (path.endsWith(".dart")) {
      icon.setImageResource(R.drawable.ic_material_dart);
    } else if (path.endsWith(".ghost")) {
      icon.setImageResource(R.drawable.ghostfile);
    } else if (path.endsWith(".html")) {
      icon.setImageResource(R.drawable.ic_material_html);
    } else if (path.endsWith(".groovy")) {
      icon.setImageResource(R.drawable.ic_material_groovy);
    } else if (path.endsWith(".java")) {
      icon.setImageResource(R.drawable.ic_material_java);
    } else if (path.endsWith(".js")) {
      icon.setImageResource(R.drawable.ic_material_javascript);
    } else if (path.endsWith(".json")) {
      icon.setImageResource(R.drawable.ic_material_json);
    } else if (path.endsWith(".kt")) {
      icon.setImageResource(R.drawable.ic_material_kotlin);
    } else if (path.endsWith(".ninja")) {
      icon.setImageResource(R.drawable.vector_folder_ghostweb);
    } else if (path.endsWith(".php")) {
      icon.setImageResource(R.drawable.ic_material_php);
    } else if (path.endsWith(".py")) {
      icon.setImageResource(R.drawable.ic_material_python);
    } else if (path.endsWith(".smail")) {
      icon.setImageResource(R.drawable.console);
    } else if (path.endsWith(".sass") || path.endsWith(".scss")) {
      icon.setImageResource(R.drawable.ic_material_sass);
    } else if (path.endsWith(".ts")) {
      icon.setImageResource(R.drawable.ic_material_typescript);
    } else if (path.endsWith(".xml")) {
      icon.setImageResource(R.drawable.ic_material_xml);
    } else if (path.endsWith(".md")) {
      icon.setImageResource(R.drawable.ic_material_markdown);
    } else if (path.endsWith(".sql")) {
      icon.setImageResource(R.drawable.ic_material_database);
    }
  }
}
