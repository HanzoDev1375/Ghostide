package com.ninjacoder.jgit;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

import java.io.File;

public class CheckoutTask extends GitTask {

    private static final String TAG = CheckoutTask.class.getSimpleName();

    CheckoutTask(Context context, File repo, String[] values) {
        super(context, repo, values);
        id = 2;
    }

    @Override
    protected Boolean doInBackground(String... strings) {
        try {
            Git git = GitWrapper.getGit(repo);
            if (git != null) {
                git.checkout()
                        .setCreateBranch(Boolean.valueOf(strings[0]))
                        .setName(strings[1])
                        .call();
            }
        } catch (GitAPIException e) {
            Log.e(TAG, e.toString());
            return false;
        }

        return true;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        if (aBoolean) {
            ((Activity) context).finish();
        }
    }
}
