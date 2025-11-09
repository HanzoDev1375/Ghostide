package ir.ninjacoder.ghostide.core.keyboard;

import android.Manifest;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.materialswitch.MaterialSwitch;

import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.activities.BaseCompat;

public class Setting extends BaseCompat {

  protected SharedPreferences sh;
  private MaterialSwitch sw;
  private MaterialSwitch numbers;
  private MaterialSwitch keyboardheghit;
  private MaterialSwitch typeobject;
  private MaterialSwitch sound;
  private MaterialSwitch vib;
  protected MaterialToolbar toolbar;
  String[] requiredPermissions =
      new String[] {
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_CONTACTS
      };

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_setting);
    ActivityCompat.requestPermissions(this, requiredPermissions, 2020);
    sh = getSharedPreferences("k", MODE_PRIVATE);
    sw = findViewById(R.id.sw);
    numbers = findViewById(R.id.numbers);
    keyboardheghit = findViewById(R.id.keyboardheghit);
    typeobject = findViewById(R.id.typeobject);
    sound = findViewById(R.id.sound);
    vib = findViewById(R.id.vib);
    toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    toolbar.setTitle("keyBord");
    sh = PreferenceManager.getDefaultSharedPreferences(this);
    sh.edit().apply();
    sw.setChecked(sh.getBoolean("Preview", true));
    numbers.setChecked(sh.getBoolean("Number", true));
    keyboardheghit.setChecked(sh.getBoolean("Height", true));
    typeobject.setChecked(sh.getBoolean("mcapsr", false));
    sound.setChecked(sh.getBoolean("Sound", false));
    vib.setChecked(sh.getBoolean("Vibrator", false));
    sw.setOnCheckedChangeListener(
        (buttonView, isChecked) -> {
          sh.edit().putBoolean("Preview", isChecked).apply();
        });
    numbers.setOnCheckedChangeListener(
        (buttonView, isChecked) -> {
          sh.edit().putBoolean("Number", isChecked).apply();
        });
    keyboardheghit.setOnCheckedChangeListener(
        (buttonView, isChecked) -> {
          sh.edit().putBoolean("Height", isChecked).apply();
        });
    typeobject.setOnCheckedChangeListener(
        (buttonView, isChecked) -> {
          sh.edit().putBoolean("mcapsr", isChecked).apply();
        });
    sound.setOnCheckedChangeListener(
        (buttonView, isChecked) -> {
          sh.edit().putBoolean("Sound", isChecked).apply();
        });
    vib.setOnCheckedChangeListener(
        (buttonView, isChecked) -> {
          sh.edit().putBoolean("Vibrator", isChecked).apply();
        });
  }
}
