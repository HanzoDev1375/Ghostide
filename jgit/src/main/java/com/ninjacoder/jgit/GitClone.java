package com.ninjacoder.jgit;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.ninjacoder.jgit.databinding.LayoutDialogGitnameBinding;
import com.ninjacoder.jgit.databinding.LayoutDialogProgressBinding;
import java.io.File;
import android.os.Environment;
import androidx.appcompat.app.AlertDialog;
import java.io.IOException;
import org.eclipse.jgit.api.Git;

public class GitClone {
  private String url = null;
  private LayoutDialogProgressBinding binding;
  protected LayoutDialogGitnameBinding gitname;
  private CallBacks call;

  public interface CallBacks {
    void onEndWork();
  }

  public void setCall(CallBacks call) {
    this.call = call;
  }

  public void clone(String folder, Context context) {
    gitname = LayoutDialogGitnameBinding.inflate(LayoutInflater.from(context));
    var dialog = new MaterialAlertDialogBuilder(context);
    dialog.setTitle("Enter repo Name");
    dialog.setView(gitname.getRoot());
    dialog.setPositiveButton(
        "clone",
        (it, __) -> {
          doClone(gitname.edi.getText().toString(), folder, context);
        });
    dialog.setNegativeButton(android.R.string.cancel, null);
    dialog.show();
  }

  private void doClone(String repo, String folder, Context context) {
    if (repo == null || repo.isEmpty()) {
      return;
    }

    url = repo.trim();
    if (!url.endsWith(".git")) {
      url += ".git";
    }

    binding = LayoutDialogProgressBinding.inflate(LayoutInflater.from(context));
    binding.message.setVisibility(View.VISIBLE);

    
    MaterialAlertDialogBuilder builder =
        new MaterialAlertDialogBuilder(context)
            .setTitle("Cloning Repository...")
            .setMessage("Clone in " + url)
            .setView(binding.getRoot())
            .setPositiveButton(android.R.string.cancel, null)
            .setCancelable(false);

    
    AlertDialog dialog = builder.create();
    dialog.show();

    String repoName = url.substring(url.lastIndexOf('/') + 1, url.lastIndexOf(".git"));
    File targetDir = new File(folder, repoName);

    GitCloneProgressMonitor progress =
        new GitCloneProgressMonitor(binding.progress, binding.message);

    
    Thread cloneThread =
        new Thread(
            () -> {
              try (Git git =
                  Git.cloneRepository()
                      .setURI(url)
                      .setDirectory(targetDir)
                      .setProgressMonitor(progress)
                      .call()) {

                
                runOnUiThread(
                    () -> {
                      dialog.dismiss();
                       call.onEndWork();
                    });

              } catch (Throwable err) {
                if (!progress.isCancelled()) {
                  err.printStackTrace();
                  runOnUiThread(
                      () -> {
                        
                        
                        new MaterialAlertDialogBuilder(context)
                            .setTitle("Clone Error")
                            .setMessage("Error cloning repository: " + err.getMessage())
                            .setPositiveButton(android.R.string.ok, null)
                            .show();
                      });
                }
              } finally {
                runOnUiThread(
                    () -> {
                      binding.progress.setVisibility(View.GONE);
                    });
              }
            });

    
    Button button = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
    button.setText(android.R.string.cancel);
    button.setOnClickListener(
        i -> {
          dialog.dismiss();
          progress.cancel();
          cloneThread.interrupt();
        });

    cloneThread.start(); 
  }

  
  private void runOnUiThread(Runnable action) {
    new Handler(Looper.getMainLooper()).post(action);
  }
}
