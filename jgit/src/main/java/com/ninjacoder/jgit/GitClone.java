package com.ninjacoder.jgit;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.chip.Chip;
import java.util.List;
import java.util.ArrayList;
import com.ninjacoder.jgit.databinding.LayoutDialogGitnameBinding;
import com.ninjacoder.jgit.databinding.LayoutDialogProgressBinding;
import java.io.File;
import android.os.Environment;
import androidx.appcompat.app.AlertDialog;
import java.io.IOException;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;

public class GitClone {
  private String url = null;
  private LayoutDialogProgressBinding binding;
  protected LayoutDialogGitnameBinding gitname;
  private CallBacks call;
 

  public interface CallBacks {
    void onEndWork();
  }

  // tnks for Android ide
  GitOption[] COMMON_GIT_OPTIONS = {
    new GitOption("--depth 1", "Shallow clone (faster)"),
    new GitOption("--single-branch", "Clone single branch only"),
    new GitOption("--recursive", "Clone with submodules"),
    new GitOption("--no-tags", "Don't fetch tags"),
    new GitOption("--bare", "Create bare repository")
  };

  public void setCall(CallBacks call) {
    this.call = call;
  }

  public void clone(String folder, Context context) {
    gitname = LayoutDialogGitnameBinding.inflate(LayoutInflater.from(context));
    for (GitOption option : COMMON_GIT_OPTIONS) {
      Chip chip = new Chip(context);
      chip.setText(option.getDescription());
      chip.setCheckable(true);
      chip.setCheckedIconVisible(true);
      chip.setTag(option.getFlag());
      gitname.chipGroup.addView(chip);
    }

    var dialog = new BottomSheetDialog(context);

    dialog.setContentView(gitname.getRoot());
    gitname.clonenow.setOnClickListener(
        (dd) -> {
          String url = gitname.etRepoUrl.getText().toString();
          String branch = gitname.etBranch.getText().toString();
          String customOptions = gitname.etCustomOptions.getText().toString();
          List<String> selectedOptions = new ArrayList<>();
          for (int i = 0; i < gitname.chipGroup.getChildCount(); i++) {
            Chip chip = (Chip) gitname.chipGroup.getChildAt(i);
            if (chip.isChecked()) {
              selectedOptions.add((String) chip.getTag());
            }
          }
          if (customOptions != null && !customOptions.trim().isEmpty()) {
            String[] customOpts = customOptions.split("\\s+");
            for (String opt : customOpts) {
              if (!opt.trim().isEmpty()) {
                selectedOptions.add(opt);
              }
            }
          }
          dialog.dismiss();
          doClone(url, branch, selectedOptions, folder, context);
        });
    gitname.btndismiss.setOnClickListener(f -> dialog.dismiss());
    dialog.show();
  }

  private void doClone(
      String repo, String branch, List<String> options, String folder, Context context) {
    if (repo == null || repo.isEmpty()) {
      Toast.makeText(context, "Repository URL is required", Toast.LENGTH_SHORT).show();
      return;
    }

    url = repo.trim();
    if (!url.endsWith(".git")) {
      url += ".git";
    }

    binding = LayoutDialogProgressBinding.inflate(LayoutInflater.from(context));
    binding.message.setVisibility(View.VISIBLE);

    var builder = new BottomSheetDialog(context);
    binding.message.setText("Clone in " + url);
    builder.setContentView(binding.getRoot());
    builder.setCancelable(false);

    builder.show();
    String repoName = url.substring(url.lastIndexOf('/') + 1, url.lastIndexOf(".git"));
    var targetDir = new File(folder, repoName);

    var progress = new GitCloneProgressMonitor(binding.progress, binding.message);
    var cloneThread =
        new Thread(
            () -> {
              try {
                CloneCommand cloneCommand =
                    Git.cloneRepository()
                        .setURI(url)
                        .setDirectory(targetDir)
                        .setProgressMonitor(progress);
                if (branch != null && !branch.trim().isEmpty()) {
                  cloneCommand.setBranch(branch.trim());
                }
                for (var option : options) {
                  switch (option) {
                    case "--depth 1":
                      cloneCommand.setDepth(1);
                      break;
                    case "--single-branch":
                      cloneCommand.setCloneAllBranches(false);
                      
                      break;
                    case "--recursive":
                      cloneCommand.setCloneSubmodules(true);
                      break;
                    case "--no-tags":
                      cloneCommand.setNoTags();
                      break;
                    case "--bare":
                      cloneCommand.setBare(true);
                      break;
                    default:
                      break;
                  }
                }

                try (Git git = cloneCommand.call()) {
                  runOnUiThread(
                      () -> {
                        builder.dismiss();
                        if (call != null) {
                          call.onEndWork();
                        }
                        Toast.makeText(
                                context, "Repository cloned successfully!", Toast.LENGTH_SHORT)
                            .show();
                      });
                }

              } catch (Throwable err) {
                if (!progress.isCancelled()) {
                  err.printStackTrace();
                  runOnUiThread(
                      () -> {
                        builder.dismiss();
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

    binding.btndissmiss.setText(android.R.string.cancel);
    binding.btndissmiss.setOnClickListener(
        i -> {
          builder.dismiss();
          progress.cancel();
          cloneThread.interrupt();
        });

    cloneThread.start();
  }

  private void runOnUiThread(Runnable action) {
    new Handler(Looper.getMainLooper()).post(action);
  }

  class GitOption {
    private final String flag;
    private final String description;

    public GitOption(String flag, String description) {
      this.flag = flag;
      this.description = description;
    }

    public String getFlag() {
      return flag;
    }

    public String getDescription() {
      return description;
    }
  }
}
