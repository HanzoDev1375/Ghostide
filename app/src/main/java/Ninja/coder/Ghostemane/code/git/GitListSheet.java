package Ninja.coder.Ghostemane.code.git;

import Ninja.coder.Ghostemane.code.databinding.MakefolderBinding;
import Ninja.coder.Ghostemane.code.model.ListSheet;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;
import com.blankj.utilcode.util.ThreadUtils;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.ninjacoder.jgit.GitWrapper;
import java.io.File;
import java.io.IOException;

public class GitListSheet {
  protected ListSheet listItem;
  protected File fileDir;
  protected Context ctx;
  protected GitUtils utils;
  private MaterialAlertDialogBuilder dialog;
  private MakefolderBinding bin;

  public GitListSheet(File fileDir, Context ctx) {
    this.fileDir = fileDir;
    this.ctx = ctx;
    try {
      utils = new GitUtils(fileDir);
    } catch (IOException err) {
      err.printStackTrace();
    }
    setVaribaleGit();
  }

  void setVaribaleGit() {
    listItem = new ListSheet();
    listItem.setSheetDialog(ctx);
    listItem.addItem("Git init", 0, utils.isGitinit() || utils.isRep());
    listItem.addItem("Git CreateBranch");
    listItem.addItem("Git MergeBranch");
    listItem.addItem("Git CommitChanges");
    listItem.addItem("Git Pull");
    listItem.addItem("Git Push");
    listItem.addItem("Git AddAll");
    listItem.addItem("Git Status");
    listItem.addItem("GitLogs");
    listItem.addItem("Git add remote");
    listItem.addItem("Git Fetch ");

    listItem.setOnItemClickLabe(
        new ListSheet.OnItemClick() {

          @Override
          public void OnItemClick(int pos) {
            switch (pos) {
              case 0:
                {
                  listItem.getDismiss(true);
                  GitWrapper.init(ctx, fileDir);
                  break;
                }
              case 1:
                {
                  listItem.getDismiss(true);
                  MaterialDialogHelper(
                      new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                          GitWrapper.createBranch(
                              ctx, fileDir, bin.editor.getText().toString(), true);
                        }
                      });

                  break;
                }
              case 2:
                {
                  listItem.getDismiss(true);
                  MaterialDialogHelper(
                      (c, d) -> {
                        try {
                          utils.mergeBranch(bin.editor.getText().toString());
                        } catch (Exception err) {

                        }
                      });

                  break;
                }
              case 3:
                {
                  listItem.getDismiss(true);
                  GitWrapper.commit(ctx, fileDir);
                  break;
                }

              case 4:
                {
                  listItem.getDismiss(true);

                  GitWrapper.pull(ctx, fileDir);

                  break;
                }
              case 5:
                {
                  listItem.getDismiss(true);
                  GitWrapper.push(ctx, fileDir);
                  break;
                }
              case 6:
                {
                  GitWrapper.add(fileDir, ctx);
                  listItem.getDismiss(true);
                  break;
                }
              case 7:
                {
                  listItem.getDismiss(true);
                  ThreadUtils.runOnUiThread(
                      () -> {
                        try {

                          MaterialDialogHelper(null, GitWrapper.getCurrentBranch(fileDir));
                        } catch (Exception err) {

                        }
                      });

                  break;
                }
              case 8:
                {
                  listItem.getDismiss(true);
                  GitWrapper.gotoLog(ctx, fileDir);
                  break;
                }
              case 9:
                {
                  listItem.getDismiss(true);
                  GitWrapper.addRemote(ctx, fileDir);
                  break;
                }
              case 10:
                {
                  listItem.getDismiss(true);
                  GitWrapper.fetch(ctx, fileDir);
                  break;
                }
            }
          }
        });
  }

  void MaterialDialogHelper(DialogInterface.OnClickListener di) {
    MaterialDialogHelper(di, null);
  }

  void MaterialDialogHelper(DialogInterface.OnClickListener di, String msg) {
    bin = MakefolderBinding.inflate(LayoutInflater.from(ctx));
    dialog = new MaterialAlertDialogBuilder(ctx);
    dialog.setView(bin.getRoot());
    dialog.setTitle("Helper");
    bin.editor.setText(msg);
    dialog.setNegativeButton(android.R.string.ok, di);
    if (dialog != null) {
      dialog.show();
    }
  }
}
