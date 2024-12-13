package com.ninjacoder.jgit.fileslide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.sidesheet.SideSheetDialog;
import com.ninjacoder.jgit.databinding.LayoutRvSlideBinding;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SildeFileManger {

  private String path;
  private Context context;
  private OnItemCallBacks call;
  private int icon;
  private File file;
  protected List<SlideModel> model;
  protected List<File> fileList;
  private FileSlideAdapter filesilderad;
  protected LayoutRvSlideBinding rvbind;

  public SildeFileManger(String path, Context context, OnItemCallBacks call, int icon) {
    this.path = path;
    this.context = context;
    this.call = call;
    this.icon = icon;
    installData();
  }

  private void installData() {
    model = new ArrayList<>();
    SideSheetDialog sh = new SideSheetDialog(context);
    rvbind = LayoutRvSlideBinding.inflate(LayoutInflater.from(context));

    sh.setContentView(rvbind.getRoot());
    sh.show();
    reloadFile(path);

    rvbind.backclick.setOnClickListener(
        v -> {
          if (file != null && !file.getAbsolutePath().equals(path)) {
            reloadFile(file.getParent());
          } else Toast.makeText(context, "This root", 2).show();
        });
    filesilderad.setCallCustom(
        new Custom() {

          @Override
          public void click(File file, int pos, View v) {
            reloadFile(file.getAbsolutePath());
          }
        });
  }

  void reloadFile(String path) {
    file = new File(path);
    File[] files = file.listFiles();
    fileList = new ArrayList<>(Arrays.asList(files));

    fileList.forEach(
        i -> {
          model.add(new SlideModel(i, icon));
        });
    filesilderad = new FileSlideAdapter(model, call);
    rvbind.rvSlide.setAdapter(filesilderad);

    rvbind.rvSlide.setLayoutManager(new LinearLayoutManager(context));
  }
}
