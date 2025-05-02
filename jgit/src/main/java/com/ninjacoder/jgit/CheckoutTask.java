package com.ninjacoder.jgit;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

import java.io.File;

public class CheckoutTask extends GitTask {

  private static final String TAG = CheckoutTask.class.getSimpleName();
  private String[] values;
  CheckoutTask(Context context, File repo, String[] values) {
    super(context, repo, values);
    this.values = values;
    id = 2;
  }

  @Override
  protected Boolean doInBackground(String... strings) {
    try {
      Git git = GitWrapper.getGit(repo);
      if (git != null) {
        // بررسی معتبر بودن ورودی‌ها
        if (strings == null || strings.length < 2) {
          throw new IllegalArgumentException("ورودی‌های نامعتبر");
        }

        boolean createBranch = Boolean.parseBoolean(strings[0]);
        String branchName = strings[1];

        if (branchName == null || branchName.trim().isEmpty()) {
          throw new IllegalArgumentException("نام برنچ نمی‌تواند خالی باشد");
        }

        git.checkout().setCreateBranch(createBranch).setName(branchName).call();

        return true;
      }
    } catch (GitAPIException e) {
      Log.e(TAG, "خطا در checkout: " + e.toString());
      return false;
    } catch (IllegalArgumentException e) {
      Log.e(TAG, "خطا در ورودی: " + e.toString());
      return false;
    }

    return false;
  }

  @Override
  protected void onPostExecute(Boolean success) {
    super.onPostExecute(success);
    if (context instanceof Activity) {
      if (success) {
        Toast.makeText(context, values[1], Toast.LENGTH_SHORT).show();
      } else {
        Toast.makeText(context, values[2], Toast.LENGTH_SHORT).show();
      }
      ((Activity) context).finish();
    }
  }
}
