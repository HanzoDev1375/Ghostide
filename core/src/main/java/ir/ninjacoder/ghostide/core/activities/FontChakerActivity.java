package ir.ninjacoder.ghostide.core.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.activities.BaseCompat;
import ir.ninjacoder.ghostide.core.utils.DataUtil;
import ir.ninjacoder.ghostide.core.utils.FileUtil;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;

public class FontChakerActivity extends BaseCompat {

  private String Folder = "";
  private double index = 0;
  private String path = "";

  private ArrayList<String> list = new ArrayList<>();
  private ArrayList<String> folderList = new ArrayList<>();
  private ArrayList<String> fileList = new ArrayList<>();
  private ArrayList<HashMap<String, Object>> files = new ArrayList<>();

  private RecyclerView recyclerview1;
  private LinearLayout EmptyLayout;
  private ImageView imageview1;
  private TextView textview1;

  private SharedPreferences setfont;
  private Intent intent = new Intent();

  @Override
  protected void onCreate(Bundle _savedInstanceState) {
    super.onCreate(_savedInstanceState);
    setContentView(R.layout.fontchaker);
    viewbyid();
  }

  private void viewbyid() {
    recyclerview1 = findViewById(R.id.recyclerview1);
    EmptyLayout = findViewById(R.id.EmptyLayout);
    imageview1 = findViewById(R.id.imageview1);
    textview1 = findViewById(R.id.textview1);
    setfont = getSharedPreferences("setfont", Activity.MODE_PRIVATE);
  }

  private void initializeLogic() {
    Folder = "/storage/emulated/0/GhostWebIDE/font/";
    _getFiles("");
    ObjectUtils.setTextColor(textview1);
    ObjectUtils.setColorFilter(imageview1);
  }

  public void _getFiles(final String _path) {
    list.clear();
    files.clear();
    folderList.clear();
    fileList.clear();
    FileUtil.listDir(Folder, list);
    Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
    index = 0;
    for (int _repeat13 = 0; _repeat13 < (int) (list.size()); _repeat13++) {
      if (FileUtil.isDirectory(list.get((int) (index)))) {
        folderList.add(list.get((int) (index)));
      } else {
        fileList.add(list.get((int) (index)));
      }
      index++;
    }
    index = 0;
    for (int _repeat37 = 0; _repeat37 < (int) (folderList.size()); _repeat37++) {
      {
        HashMap<String, Object> _item = new HashMap<>();
        _item.put("path", folderList.get((int) (index)));
        files.add(_item);
      }

      index++;
    }
    index = 0;
    for (int _repeat54 = 0; _repeat54 < (int) (fileList.size()); _repeat54++) {
      {
        HashMap<String, Object> _item = new HashMap<>();
        _item.put("path", fileList.get((int) (index)));
        files.add(_item);
      }

      index++;
    }
//    if (list.size() == 0) {
//      recyclerview1.setVisibility(View.GONE);
//      EmptyLayout.setVisibility(View.VISIBLE);
//    } else {
//      EmptyLayout.setVisibility(View.GONE);
//      recyclerview1.setVisibility(View.VISIBLE);
//    }
    recyclerview1.setAdapter(new Recyclerview1Adapter(files));
    recyclerview1.setLayoutManager(new LinearLayoutManager(this));
  }

  public class Recyclerview1Adapter extends RecyclerView.Adapter<Recyclerview1Adapter.ViewHolder> {

    ArrayList<HashMap<String, Object>> _data;

    public Recyclerview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
      _data = _arr;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      LayoutInflater _inflater = getLayoutInflater();
      View _v = _inflater.inflate(R.layout.fontview1, null);
      RecyclerView.LayoutParams _lp =
          new RecyclerView.LayoutParams(
              ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
      _v.setLayoutParams(_lp);
      return new ViewHolder(_v);
    }

    @Override
    public void onBindViewHolder(ViewHolder _holder, final int _position) {
      View _view = _holder.itemView;

      final LinearLayout linear1 = _view.findViewById(R.id.linear1);
      final LinearLayout linear2 = _view.findViewById(R.id.linear2);
      final TextView textview1 = _view.findViewById(R.id.textview1);
      final TextView textview2 = _view.findViewById(R.id.textview2);

      path = _data.get((int) _position).get("path").toString();
      RecyclerView.LayoutParams _lp =
          new RecyclerView.LayoutParams(
              ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
      _view.setLayoutParams(_lp);
      if (FileUtil.isDirectory(path)) {

      } else {
        try {
          if (path.endsWith(".ttf")) {
            pass();
            typefaceinFile(textview1, new File(path));
            typefaceinFile(textview2, new File(path));
            textview2.setText(textview1.getText().toString().substring((int) (0), (int) (1)));
            textview1.setText("This Text for Test | متن تستی");
          }
        } catch (Exception e) {
          DataUtil.showMessage(getApplicationContext(), "Error");
        }
      }
      textview1.setTextColor(0xFFFFDCBD);
      textview2.setTextColor(0xFFC4A68A);
      linear2.setBackground(
          new GradientDrawable() {
            public GradientDrawable getIns(int a, int b) {
              this.setCornerRadius(a);
              this.setColor(b);
              return this;
            }
          }.getIns((int) 18, 0xFFFFDCBD));
      linear1.setOnClickListener(
          new View.OnClickListener() {
            @Override
            public void onClick(View _view) {
              setfont.edit().putString("mfont", path).commit();
              DataUtil.showMessage(getApplicationContext(), "فونت اعمال شد");
              var di =
                  new com.google.android.material.dialog.MaterialAlertDialogBuilder(
                      FontChakerActivity.this);

              di.setTitle("انجام شد!");
              di.setMessage("فونت اعمال شد ریست برنامه برای اجرای شدن فونت؟");
              di.setNeutralButton(
                  "بله",
                  (p, d) -> {
                    intent.setClass(getApplicationContext(), FileManagerActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                  });
              di.setCancelable(false);
              androidx.appcompat.app.AlertDialog dialog = di.show();
              final View view = dialog.getWindow().getDecorView();
              view.setScaleX(0f);
              view.setScaleY(0f);

              dialog.show();

              ClickEffcat(linear1);
            }
          });
    }

    @Override
    public int getItemCount() {
      return _data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
      public ViewHolder(View v) {
        super(v);
      }
    }
  }
}
