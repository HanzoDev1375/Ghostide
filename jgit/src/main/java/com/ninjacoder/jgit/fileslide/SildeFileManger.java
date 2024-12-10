package com.ninjacoder.jgit.fileslide;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.sidesheet.SideSheetDialog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SildeFileManger {

  private String path;
  private Context context;
  private OnItemCallBacks call;
  private int icon;

  public SildeFileManger(String path, Context context,OnItemCallBacks call,int icon) {
    this.path = path;
    this.context = context;
    this.call = call;
    this.icon = icon;
    installData();
  }
  
  private void installData(){
    List<SlideModel> model = new ArrayList<>();
    SideSheetDialog sh = new SideSheetDialog(context);
    RecyclerView rv = new RecyclerView(context);
    sh.setContentView(rv);
    sh.show();
    var it = getListFile();
    it.forEach(i ->{
      model.add(new SlideModel(i,icon));
    });
    rv.setAdapter(new FileSlideAdapter(model,call));
    rv.setLayoutManager(new LinearLayoutManager(context));
  }

  private List<File> getListFile() {
    File file = new File(path);
    File[] arr = file.listFiles();
    List<File> mfile = new ArrayList<>(Arrays.asList(arr));
    return mfile;
  }
}
