package ir.ninjacoder.ghostide.core.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.activities.BaseCompat;
import ir.ninjacoder.ghostide.core.databinding.FilebookmarkBinding;
import ir.ninjacoder.ghostide.core.databinding.LayoutFilebookmarkBinding;
import ir.ninjacoder.ghostide.core.folder.FileIconHelper;
import ir.ninjacoder.ghostide.core.glidecompat.GlideCompat;
import ir.ninjacoder.ghostide.core.marco.binder.BinderRecyclerview1;
import ir.ninjacoder.ghostide.core.utils.AnimUtils;
import ir.ninjacoder.ghostide.core.utils.FileUtil;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;

public class FileBookmarkActivity extends BaseCompat {
  private String subtitle = "";
  private String Folder = "";
  private double position = 0;
  private String UPFolder = "";
  private ArrayList<HashMap<String, Object>> map = new ArrayList<>();
  private SharedPreferences book, shp;
  protected FilebookmarkBinding bin;

  @Override
  protected void onCreate(Bundle _savedInstanceState) {
    super.onCreate(_savedInstanceState);
    bin = FilebookmarkBinding.inflate(getLayoutInflater());
    setContentView(bin.getRoot());
    initialize(_savedInstanceState);
  }

  private void initialize(Bundle _savedInstanceState) {

    setSupportActionBar(bin.Toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setHomeButtonEnabled(true);
    bin.Toolbar.setNavigationOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View _v) {
            onBackPressed();
          }
        });

    book = getSharedPreferences("hsipsot4444", Activity.MODE_PRIVATE);
    shp = getSharedPreferences("path", Activity.MODE_PRIVATE);

    initializeLogic();
    bin.listviewBookmark.setVisibility(View.VISIBLE);
    bin.listviewBookmark.setEmptyView(bin.layoutBookmarkEmptyview);
    if (book.contains("hsipsot4444")) {
      map =
          new Gson()
              .fromJson(
                  book.getString("hsipsot4444", ""),
                  new TypeToken<ArrayList<HashMap<String, Object>>>() {}.getType());
      bin.listviewBookmark.setAdapter(new FileBookMarkAdapter(map));
      ((BaseAdapter) bin.listviewBookmark.getAdapter()).notifyDataSetChanged();
    }

    bin.listviewBookmark.setOnItemClickListener(
        new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
            final int _position = _param3;
            var utils = map.get(_position).get("list").toString();
            if (FileUtil.isDirectory(utils)) {
              Intent i = new Intent();
              i.putExtra("bookmarkDir", utils);
              i.setClass(getApplicationContext(), FileManagerActivity.class);
              if (i != null) {
                startActivity(i);
              }
            } else {
              var file = new File(map.get(_position).get("list").toString());
              Intent i = new Intent();
              /** using getParent from preview Path not files */
              i.putExtra("bookmarkDir", file.getParent());
              i.setClass(getApplicationContext(), FileManagerActivity.class);
              if (i != null) {
                startActivity(i);
              }
            }
          }
        });
    bin.listviewBookmark.setDividerHeight(0);
    bin.listviewBookmark.setOnItemLongClickListener(
        new AdapterView.OnItemLongClickListener() {
          @Override
          public boolean onItemLongClick(
              AdapterView<?> _param1, View _param2, int _param3, long _param4) {
            final int _position = _param3;
            map.remove(_position);
            book.edit().putString("hsipsot4444", new Gson().toJson(map)).apply();
            ((BaseAdapter) bin.listviewBookmark.getAdapter()).notifyDataSetChanged();

            return true;
          }
        });
  }

  private void initializeLogic() {
    ObjectUtils.setToolbarinit(bin.Toolbar);
    //  ObjectUtils.setTextColor(textview1);
  }

  public void _RefreshData() {
    bin.listviewBookmark.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    bin.listviewBookmark.setItemsCanFocus(false);
  }

  @Override
  protected void onResume() {
    super.onResume();
    // TODO: Implement this method
    if (!map.isEmpty()) ((BaseAdapter) bin.listviewBookmark.getAdapter()).notifyDataSetChanged();
  }

  public class FileBookMarkAdapter extends BaseAdapter {

    ArrayList<HashMap<String, Object>> _data;

    public FileBookMarkAdapter(ArrayList<HashMap<String, Object>> _arr) {
      _data = _arr;
    }

    @Override
    public int getCount() {
      return _data.size();
    }

    @Override
    public HashMap<String, Object> getItem(int _index) {
      return _data.get(_index);
    }

    @Override
    public long getItemId(int _index) {
      return _index;
    }

    @Override
    public View getView(final int _position, View _v, ViewGroup _container) {

      LayoutFilebookmarkBinding bin = LayoutFilebookmarkBinding.inflate(getLayoutInflater());
      ObjectUtils.shap(bin.imageview1);
      AnimUtils.Sacla(bin.getRoot());
      ObjectUtils.setTextColor(bin.textview1);
      File file = new File(map.get((int) _position).get("list").toString());
      FileIconHelper helper = new FileIconHelper(file.toString());
      helper.setDynamicFolderEnabled(true);
      helper.setEnvironmentEnabled(true);
      bin.imageview1.setImageResource(helper.getFileIcon());
      bin.textview1.setText(file.getName());
      if (file.isDirectory()) {

      } else {
        if (BinderRecyclerview1.TaskVideo(file.toString())) {
          GlideCompat.GlideNormal(bin.imageview1, file.toString());
        } else if (BinderRecyclerview1.PhotoView(file.toString())) {
          GlideCompat.GlideNormal(bin.imageview1, file.toString());
        }
        if (file.toString().endsWith(".xml")) {
          GlideCompat.LoadVector(file.toString(), bin.imageview1);
        } else if (file.toString().endsWith(".mp3")) {
          GlideCompat.GlideLoadMp3(bin.imageview1, file.toString());
        } else if (file.toString().endsWith(".svg")) {
          GlideCompat.LoadSvg(file.toString(), bin.imageview1);
        } else if (file.toString().endsWith(".pdf")) {
          try {
            GlideCompat.loadImgPdf(file.toString(), bin.imageview1);
          } catch (Exception err) {
            bin.imageview1.setImageResource(R.drawable.ic_material_pdf);
          }
        } else if (file.toString().endsWith(".apk")) {
          GlideCompat.LoadApkFile(file.toString(), bin.imageview1);
        } else if (file.toString().endsWith(".vsix")) {
          GlideCompat.LoadIconVsCode(file.toString(), bin.imageview1);
        }
      }
      return bin.getRoot();
    }
  }
}
