package com.mcal.uidesigner.common;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Handler;

public class ProgressDialogHandler {
    private final Activity activity;
    private final String message;
    private final Handler handler = new Handler();
    private final int delay = 500;
    private ProgressDialog progressDialog;
    private Runnable showProgressAction;

    public ProgressDialogHandler(Activity activity, String message) {
        this.activity = activity;
        this.message = message;
    }

    public void openDialogDelayed() {
        closeDialog();
        showProgressAction = ProgressDialogHandler.this::showDialog;
        handler.postDelayed(showProgressAction, delay);
    }

    public void closeDialog() {
        if (showProgressAction != null) {
            handler.removeCallbacks(showProgressAction);
            showProgressAction = null;
        }
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    public void openDialog() {
        closeDialog();
        showDialog();
    }

    protected void onCancel() {
    }


    public void showDialog() {
        progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage(message);
        progressDialog.setOnCancelListener(dialog -> onCancel());
        progressDialog.getWindow().clearFlags(2);
        progressDialog.show();
    }
}
