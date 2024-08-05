package Ninja.coder.Ghostemane.code.marco.ideColors;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;
import io.github.rosemoe.sora.interfaces.EditorLanguage;
import io.github.rosemoe.sora.langs.antlrlang.ANTLRV4Lang;
import io.github.rosemoe.sora.langs.cpp.CppLanguage;
import io.github.rosemoe.sora.langs.css3.CSS3Language;
import io.github.rosemoe.sora.langs.dart.DartLang;
import io.github.rosemoe.sora.langs.groovy.lang.GroovyLanguage;
import io.github.rosemoe.sora.langs.html.HTMLLanguage;
import io.github.rosemoe.sora.langs.java.JavaLanguage;
import io.github.rosemoe.sora.langs.javascript.JavaScriptLanguage;
import io.github.rosemoe.sora.langs.json.JsonLanguage;
import io.github.rosemoe.sora.langs.kotlin.KotlinLanguage;
import io.github.rosemoe.sora.langs.ninjalang.NinjaLang;
import io.github.rosemoe.sora.langs.php.PHPLanguage;
import io.github.rosemoe.sora.langs.python.PythonLang;
import io.github.rosemoe.sora.langs.sass.SassLangCompat;
import io.github.rosemoe.sora.langs.smali.SMLang;
import io.github.rosemoe.sora.langs.typescript.TsLang;
import io.github.rosemoe.sora.langs.xml.XMLLanguage;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.langs.ghostthemelang.ghostlang.ghostlangs;

public class IdeColorCompat {
  private CodeEditor editor;

  public IdeColorCompat(CodeEditor editor) {
    this.editor = editor;
  }

  void DataColor(View views,TextView tv ,String color1, String color2, String color3) {
    var gradientDrawable = new GradientDrawable();
    int d = (int) views.getContext().getResources().getDisplayMetrics().density;
    int colors[] = {Color.parseColor(color1), Color.parseColor(color2), Color.parseColor(color3)};
    gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, colors);
    gradientDrawable.setCornerRadii(
        new float[] {d * 360, d * 360, d * 360, d * 360, d * 0, d * 0, d * 0, d * 0});
    views.setElevation(d * 5);
    views.setBackground(gradientDrawable);
    Shader shrder = new LinearGradient(0,0,0 + tv.getMeasuredWidth() ,0,colors,null,Shader.TileMode.CLAMP);
    tv.getPaint().setShader(shrder);
  }

  public void Colors(View view,TextView text) {
    if (editor.getEditorLanguage() instanceof CSS3Language) {
      DataColor(view,text, "#B3E5FC", "#4FC3F7", "#0288D1"); 
    } else if (editor.getEditorLanguage() instanceof ANTLRV4Lang) {
      DataColor(view,text, "#FFF9C4", "#FFE082", "#FFD54F"); 
    } else if (editor.getEditorLanguage() instanceof CppLanguage) {
      DataColor(view,text, "#FF8A80", "#FF5252", "#FF1744"); 
    } else if (editor.getEditorLanguage() instanceof DartLang) {
      DataColor(view,text, "#B2EBF2", "#80DEEA", "#4DD0E1"); 
    } else if (editor.getEditorLanguage() instanceof ghostlangs) {
      DataColor(view,text, "#E0E0E0", "#9E9E9E", "#616161");
    } else if (editor.getEditorLanguage() instanceof HTMLLanguage) {
      DataColor(view,text, "#FFCCBC", "#FF8A65", "#FF5722"); 
    } else if (editor.getEditorLanguage() instanceof GroovyLanguage) {
      DataColor(view,text, "#4DB6AC", "#26A69A", "#009688"); 
    } else if (editor.getEditorLanguage() instanceof JavaLanguage) {
      DataColor(view,text, "#FF8A80", "#FF5252", "#D32F2F"); 
    } else if (editor.getEditorLanguage() instanceof JavaScriptLanguage) {
      DataColor(view,text, "#FFD54F", "#FFA726", "#FF9800"); 
    } else if (editor.getEditorLanguage() instanceof JsonLanguage) {
      DataColor(view,text, "#AB47BC", "#9C27B0", "#8E24AA"); 
    } else if (editor.getEditorLanguage() instanceof KotlinLanguage) {
      DataColor(view,text, "#4DB6AC", "#26A69A", "#009688"); 
    } else if (editor.getEditorLanguage() instanceof NinjaLang) {
      DataColor(view,text, "#C8E6C9", "#81C784", "#388E3C"); 
    } else if (editor.getEditorLanguage() instanceof PHPLanguage) {
      DataColor(view,text, "#E0E0E0", "#9E9E9E", "#616161");
    } else if (editor.getEditorLanguage() instanceof PythonLang) {
      DataColor(view,text, "#FFD54F", "#FFA726", "#FF9800"); 
    } else if (editor.getEditorLanguage() instanceof SassLangCompat) {
      DataColor(view,text, "#F8BBD0", "#F06292", "#E91E63"); 
    } else if (editor.getEditorLanguage() instanceof SMLang) {
      DataColor(view,text, "#66BB6A", "#43A047", "#388E3C"); 
    } else if (editor.getEditorLanguage() instanceof TsLang) {
      DataColor(view,text, "#90CAF9", "#64B5F6", "#42A5F5"); 
    } else if (editor.getEditorLanguage() instanceof XMLLanguage) {
      DataColor(view,text, "#FFF176", "#FFEE58", "#FFEB3B"); 
    } else if(editor.getEditorLanguage() instanceof EditorLanguage){
      DataColor(view,text, "#7986CB", "#5C6BC0", "#3F51B5"); 
    }
  }
}
/*
{
android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
SketchUi.setColor(0x07FF8679);
SketchUi.setCornerRadius(d*360);
SketchUi.setStroke(d*8,0xFF9C27B0);
view.setElevation(d*5);
android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFF44336}), SketchUi, null);
view.setBackground(SketchUi_RD);
view.setClickable(true);
}
*/