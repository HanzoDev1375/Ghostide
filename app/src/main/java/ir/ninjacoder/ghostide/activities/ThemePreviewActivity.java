package ir.ninjacoder.ghostide.activities;

import io.github.rosemoe.sora.langs.html.HTMLLanguage;
import ir.ninjacoder.ghostide.R;
import ir.ninjacoder.ghostide.databinding.ThemepreviewLayoutBinding;
import ir.ninjacoder.ghostide.marco.ideColors.IdeColorCompat;
import ir.ninjacoder.ghostide.model.LoadTheme;
import ir.ninjacoder.ghostide.utils.FileUtil;
import ir.ninjacoder.ghostide.utils.ThemeUtils;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import io.github.rosemoe.sora.langs.java.JavaLanguage;
import io.github.rosemoe.sora.langs.json.JsonLanguage;
import io.github.rosemoe.sora.langs.ninjalang.NinjaLang;
import io.github.rosemoe.sora.langs.python.PythonLang;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ThemePreviewActivity extends BaseCompat {

  private HashMap<String, Object> map;
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
    bind.rv1.setAdapter(new FakeAd());
    bind.rv1.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

    bind.fab.setText("Edit Theme");
    bind.editor.setEditable(false);
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
  }

  class FakeAd extends RecyclerView.Adapter<FakeAd.VH> {
    private List<String> fakeitem = new ArrayList<>();
    private int selectedPosition = 0;

    FakeAd() {
      fakeitem.add("Ninjacoder.java");
      fakeitem.add("Test.py");
      fakeitem.add("Index.html");
      fakeitem.add("Rubypy.py");
      fakeitem.add("termuxitem.sh");
      fakeitem.add("build.json");
      fakeitem.add("it.ninja");
    }

    class VH extends RecyclerView.ViewHolder {
      public VH(View view) {
        super(view);
      }
    }

    @Override
    public int getItemCount() {
      return fakeitem.size();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
      return new VH(
          LayoutInflater.from(parent.getContext()).inflate(R.layout.newlist, parent, false));
    }

    @Override
    public void onBindViewHolder(VH holder, int pos) {
      String binder = fakeitem.get(pos);
      View itemView = holder.itemView;
      LinearLayout selector = itemView.findViewById(R.id.selector);
      TextView tv = itemView.findViewById(R.id.textview1);
      ImageView imgview = itemView.findViewById(R.id.imageview2);
      tv.setText(binder);
      var theme = new ThemeUtils();
      map =
          new Gson()
              .fromJson(
                  FileUtil.readFile(getIntent().getStringExtra("keyitem")),
                  new TypeToken<HashMap<String, Object>>() {}.getType());
      tv.setTextColor(Color.parseColor(map.get("tabtextcolor").toString()));
      var shape =
          new MaterialShapeDrawable(
              ShapeAppearanceModel.builder()
                  .setTopLeftCorner(20, 20)
                  .setTopRightCorner(20, 20)
                  .build());
      shape.setFillColor(ColorStateList.valueOf(Color.parseColor(map.get("tabback").toString())));
      selector.setBackground(shape);
      if (selectedPosition == pos) {
        selector.setVisibility(View.VISIBLE);
        bind.editor.setText(getNewTextForItem(binder));
      } else {
        selector.setVisibility(View.GONE);
      }
      imgview.setVisibility(View.GONE);

      itemView.setOnClickListener(
          v -> {
            if (selectedPosition == pos) {
              selectedPosition = -1;
            } else {
              selectedPosition = pos;
              bind.editor.setText(getNewTextForItem(binder));
            }
            notifyDataSetChanged();
          });
    }

    private String getNewTextForItem(String item) {
      switch (item) {
        case "Ninjacoder.java":
          bind.editor.setEditorLanguage(new JavaLanguage(bind.editor));
          return """
               import java.io.File;
               import android.util.Log;

                public class NinjaCoder extends AppCompatActivity {

                    private File file;

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
        case "Index.html":
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

        case "Test.py":
          bind.editor.setEditorLanguage(new PythonLang(bind.editor));
          return """
                def main():
                    print('Hello, World!')

                if __name__ == "__main__":
                    main()
                """;
        case "Rubypy.py":
          bind.editor.setEditorLanguage(new PythonLang(bind.editor));
          return """
                puts 'Hello, Ruby!'
                """;
        case "termuxitem.sh":
          bind.editor.setEditorLanguage(new NinjaLang());
          return """
                #! /bin/bash
                echo 'Hello, Ghosy ide!'
                """;
        case "build.json":
          bind.editor.setEditorLanguage(new JsonLanguage());
          return """
                {
                    "build": {
                        "version": "1.0",
                        "name": "My App"
                    }
                }
                """;
        case "it.ninja":
          bind.editor.setEditorLanguage(new NinjaLang());
          return """
        program class it{
         val its!! = 0
         val bb!!

         fun it():it{
           pwd its.aslo{
            recrod::0
           }
         }

        }
        """;
        default:
          return item;
      }
    }
  }
}
