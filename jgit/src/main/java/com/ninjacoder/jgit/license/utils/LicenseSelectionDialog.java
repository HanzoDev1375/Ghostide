package com.ninjacoder.jgit.license.utils;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.LinearLayout;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.ninjacoder.jgit.license.enums.LicenseType;

public class LicenseSelectionDialog {

  public interface LicenseSelectionListener {
    void onLicenseSelected(LicenseType licenseType);
  }

  public static void show(Context context, LicenseSelectionListener listener) {

    Spinner spinner = new Spinner(context);
    ArrayAdapter<LicenseType> adapter =
        new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, LicenseType.values());
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(adapter);

    LinearLayout layout = new LinearLayout(context);
    layout.setOrientation(LinearLayout.VERTICAL);
    layout.setPadding(50, 30, 50, 30);
    layout.addView(spinner);

    var dialog =
        new MaterialAlertDialogBuilder(context)
            .setTitle("Select License")
            .setView(layout)
            .setPositiveButton(
                "OK",
                (d, which) -> {
                  if (listener != null) {
                    listener.onLicenseSelected((LicenseType) spinner.getSelectedItem());
                  }
                })
            .create();

    dialog.show();
  }
}
