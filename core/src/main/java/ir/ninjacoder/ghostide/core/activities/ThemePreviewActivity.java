package ir.ninjacoder.ghostide.core.activities;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.google.android.material.color.MaterialColors;
import com.google.android.material.tabs.TabLayout;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;
import android.view.WindowManager;
import io.github.rosemoe.sora.langs.jsx.JavaScriptJsxLanguage;
import io.github.rosemoe.sora.langs.php.PHPLanguage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.github.rosemoe.sora.langs.html.HTMLLanguage;
import io.github.rosemoe.sora.langs.java.JavaLanguage;
import io.github.rosemoe.sora.langs.javascript.JavaScriptLanguage;
import io.github.rosemoe.sora.langs.json.JsonLanguage;
import io.github.rosemoe.sora.langs.ninjalang.NinjaLang;
import io.github.rosemoe.sora.langs.python.PythonLang;
import io.github.rosemoe.sora.widget.CodeEditor;
import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.activities.BaseCompat;
import ir.ninjacoder.ghostide.core.databinding.ThemepreviewLayoutBinding;
import ir.ninjacoder.ghostide.core.model.LoadTheme;
import ir.ninjacoder.ghostide.core.utils.FileUtil;
import ir.ninjacoder.ghostide.core.utils.KeySet;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;
import ir.ninjacoder.ghostide.core.utils.ThemeUtils;
import ir.ninjacoder.ghostide.core.widget.BlurImage;

public class ThemePreviewActivity extends BaseCompat {

  private HashMap<String, Object> map = new HashMap<>();
  private ThemepreviewLayoutBinding bind;
  private LoadTheme loadTheme;

  @Override
  protected void onCreate(Bundle saveInStatous) {
    super.onCreate(saveInStatous);
    // TODO: Implement this method
    bind = ThemepreviewLayoutBinding.inflate(LayoutInflater.from(this));
    setContentView(bind.getRoot());
    map = new HashMap<>();
    bind.editor.setEditorLanguage(new JavaLanguage(bind.editor));
    if (getIntent().hasExtra("keyitem")) {
      setLoadTheme(getIntent().getStringExtra("keyitem"));
      Toast.makeText(getApplicationContext(), getIntent().getStringExtra("keyitem"), 2).show();
    }
    getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
    bind.fab.setIconResource(R.drawable.save);
    bind.fab.setOnClickListener(
        c -> {
          loadTheme = new LoadTheme();
          loadTheme.runinSheet(
              ThemePreviewActivity.this, bind.editor, getIntent().getStringExtra("keyitem"));
        });
  }

  void setLoadTheme(String themePath) {
    map =
        new Gson()
            .fromJson(
                FileUtil.readFile(themePath),
                new TypeToken<HashMap<String, Object>>() {}.getType());

    var theme = new ThemeUtils();
    theme.setThemeCodeEditor((CodeEditor) bind.editor, map, false, this);
    theme.setFabBackground(bind.fab, map);
    theme.setStatusNavColor(this, map, KeySet.navstatusbar, bind.getRoot(), bind.contents);
    bind.tabtest.setSelectedTabIndicatorColor(
        map.containsKey(KeySet.tabback)
            ? Color.parseColor(map.get(KeySet.tabback).toString())
            : MaterialColors.getColor(bind.tabtest, ObjectUtils.Back));
    bind.tabtest.setTabTextColors(
        ColorStateList.valueOf(
            map.containsKey(KeySet.tabtextcolor)
                ? Color.parseColor(map.get(KeySet.tabtextcolor).toString())
                : MaterialColors.getColor(bind.tabtest, ObjectUtils.TvColor)));

    BlurImage.setBlurInWallpaperMobile(this, 2, bind.previewWallpaper);
    bind.contents.setBackgroundColor(
        map.containsKey(KeySet.backgroundcolorlinear)
            ? Color.parseColor(map.get(KeySet.backgroundcolorlinear).toString())
            : MaterialColors.getColor(this, ObjectUtils.Back, 0));
    List<String> fakeitem = new ArrayList<>();
    fakeitem.add("main.java");
    fakeitem.add("main.py");
    fakeitem.add("main.html");
    fakeitem.add("main.js");
    fakeitem.add("main.sh");
    fakeitem.add("main.json");
    fakeitem.add("main.ninja");
    fakeitem.add("main.php");
  //  fakeitem.add("main.ts");
    fakeitem.forEach(
        it -> {
          bind.tabtest.addTab(bind.tabtest.newTab().setText(it));
        });
    if (bind.tabtest.getTabCount() > 0) {
      bind.editor.setText(getNewTextForItem(bind.tabtest.getTabAt(0).getText().toString()));
    }
    bind.tabtest.addOnTabSelectedListener(
        new TabLayout.OnTabSelectedListener() {

          @Override
          public void onTabReselected(TabLayout.Tab arg0) {
            PowerMenu powers =
                new PowerMenu.Builder(ThemePreviewActivity.this)
                    .addItem(new PowerMenuItem("close"))
                    .addItem(new PowerMenuItem("close other"))
                    .addItem(new PowerMenuItem("close all"))
                    .setIsMaterial(true)
                    .setShowBackground(false)
                    .setAutoDismiss(true)
                    .setMenuColor(
                        map.containsKey(KeySet.menuPosBackground)
                            ? Color.parseColor(map.get(KeySet.menuPosBackground).toString())
                            : MaterialColors.getColor(
                                ThemePreviewActivity.this, ObjectUtils.Back, 0))
                    .setTextColor(
                        map.containsKey(KeySet.menuPosTextColor)
                            ? Color.parseColor(map.get(KeySet.menuPosTextColor).toString())
                            : MaterialColors.getColor(
                                ThemePreviewActivity.this, ObjectUtils.TvColor, 0))
                    .setMenuRadius(15)
                    .setAnimation(MenuAnimation.FADE)
                    .build();
            powers.showAsDropDown(arg0.view);
          }

          @Override
          public void onTabSelected(TabLayout.Tab arg0) {
            bind.editor.setText(getNewTextForItem(arg0.getText().toString()));
          }

          @Override
          public void onTabUnselected(TabLayout.Tab arg0) {}
        });
  }

  private String getNewTextForItem(String item) {
    switch (item) {
      case "main.java":
        bind.editor.setEditorLanguage(new JavaLanguage(bind.editor));
        return """
               import java.io.File;
               import android.util.Log;

                public class MainActivity extends AppCompatActivity {

                    private File file;
                    private int id;
                    private boolean read;

                    @Override
                    protected void onCreate(Bundle _savedInstanceState) {
                        super.onCreate(_savedInstanceState);
                        setContentView(R.layout.main);
                    }
                    public void setFile() {
                      file = new File("/sdcard/");
                      if(file.isFile) Log.e("this not file","");
                    }
                }
                """;
      case "main.html":
        bind.editor.setEditorLanguage(new HTMLLanguage(bind.editor));
        return """
        <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Document</title>
                <style>

                        h1{
                            color:#fff029;
                            background-color: #000;
                            text-align: center;
                            padding:0px;
                            margin:0px;
                        }
                    </style>
            </head>
            <body>
                <h1>hello ninja coder</h1>
            </body>
            <script>
                function mains(){
                    console.log("hello word ");
                }
                mains()
            </script>
        </html>

          """;

      case "main.py":
        bind.editor.setEditorLanguage(new PythonLang(bind.editor));
        return """
                def main():
                    print('Hello, World!')

                if __name__ == "__main__":
                    main()
                """;
      case "main.js":
        bind.editor.setEditorLanguage(new JavaScriptLanguage((CodeEditor) bind.editor));
        return """
            let i = 0
            let b = 0

            function main() {
                i = 0
                b++
              console.log("hello")
            }
            export class Model {
            function it() {
                return 0;
              }
            }
                """;
      case "main.sh":
        bind.editor.setEditorLanguage(new NinjaLang());
        return """
                #! /bin/bash
                echo 'Hello, Ghosy ide!'
                """;
      case "main.json":
        bind.editor.setEditorLanguage(new JsonLanguage((CodeEditor) bind.editor));
        return """
                {
                    "build": {
                        "version": "1.0",
                        "name": "My App",
                        "hex": "#fffffff"
                    }
                }
                """;
      case "main.ninja":
        bind.editor.setEditorLanguage(new NinjaLang());
        return """
        program class main{
         val its!! = 0
         val bb!!

         fun it():it{
           pwd its.aslo{
            recrod::0
           }
         }

        }
        """;
      case "main.php":
        {
          bind.editor.setEditorLanguage(new PHPLanguage(bind.editor));
          return """
          <?php
           function ghost(){
             $item = 100;
             if(item >= 101){
               echo("ok");

             }

           }

          ?>

           """;
        }

      default:
        return item;
    }
  }
}
