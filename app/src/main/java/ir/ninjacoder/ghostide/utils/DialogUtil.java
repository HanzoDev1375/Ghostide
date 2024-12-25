package ir.ninjacoder.ghostide.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

import android.widget.Button;
import androidx.appcompat.app.AlertDialog;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class DialogUtil<T> {

  private MaterialAlertDialogBuilder dialog;
  private AlertDialog alertDialog;

  public DialogUtil(Context context) {
    dialog = getDialog(context);
    alertDialog = dialog.create();
  }

  public DialogUtil(Context context, String title) {
    dialog = getDialog(context);
    alertDialog = dialog.create();
    setTitle(title);
    
  }

  public DialogUtil(Context context, String title, String message) {
    dialog = getDialog(context);
    alertDialog = dialog.create();
    setTitle(title);
    setMessage(message);
  }

  public void setTitle(String text) {
    dialog.setTitle(text);
  }

  public void setMessage(String text) {
    dialog.setMessage(text);
  }

  public void setCancelable(boolean canCancel) {
    dialog.setCancelable(canCancel);
  }

  public void setCancelable(boolean canCancel, boolean canCancelOutside) {
    dialog.setCancelable(canCancel);
    setCancelableTouchOutside(canCancelOutside);
  }

  public void setCancelableTouchOutside(boolean canCancel) {
    alertDialog.setCanceledOnTouchOutside(canCancel);
  }

  public void setPositiveButton(String text, DialogInterface.OnClickListener clickListener) {
    dialog.setPositiveButton(text, clickListener);
  }

  public void setPositiveButton(int textId, DialogInterface.OnClickListener clickListener) {
    dialog.setPositiveButton(textId, clickListener);
  }

  public void setNegativeButton(String text, DialogInterface.OnClickListener clickListener) {
    dialog.setNegativeButton(text, clickListener);
  }

  public void setNegativeButton(int textId, DialogInterface.OnClickListener clickListener) {
    dialog.setNegativeButton(textId, clickListener);
  }

  public void setNeutralButton(String text, DialogInterface.OnClickListener clickListener) {
    dialog.setNeutralButton(text, clickListener);
  }

  public void setNeutralButton(int textId, DialogInterface.OnClickListener clickListener) {
    dialog.setNeutralButton(textId, clickListener);
  }

  public void setView(int v) {
    dialog.setView(v);
  }

  public void setView(View v) {
    dialog.setView(v);
  }

  public void build() {
    create();
    show();
  }

  public void create() {
    alertDialog = dialog.create();
  }

  public void show() {
    alertDialog.show();
  }

  public void dismiss() {
    alertDialog.dismiss();
  }

  public void cancel() {
    alertDialog.cancel();
  }

  public MaterialAlertDialogBuilder getDialog(Context context) {
    return new MaterialAlertDialogBuilder(context);
  }

  public void setOnShowListener(DialogInterface.OnShowListener show) {
    alertDialog.setOnShowListener(show);
  }

  public View findViewById(int id) {
    return alertDialog.findViewById(id);
  }

  public <V extends View> V findViewByIdForV(int id) {
    if (alertDialog != null) {
      View view = alertDialog.findViewById(id);
      if (view != null) {
        return (V) view;
      }
    }
    return null;
  }

  public Button getButton(int b) {
    return alertDialog.getButton(b);
  }

  public void showAs() {
    if (alertDialog != null) {
      alertDialog.show();
    }
  }

  public AlertDialog getAlertDialog() {
    return alertDialog;
  }
}
