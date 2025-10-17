package ir.ninjacoder.ghostide;

import android.Manifest;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import androidx.core.content.ContextCompat;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import ir.ninjacoder.ghostide.Welcome.SplashWord;
import ir.ninjacoder.ghostide.activities.BaseCompat;
import ir.ninjacoder.ghostide.activities.FileManagerActivity;
import ir.ninjacoder.ghostide.databinding.MainBinding;
import ir.ninjacoder.ghostide.utils.AssetsSoft;
import ir.ninjacoder.ghostide.utils.FileUtil;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.*;
import com.hzy.lib7z.IExtractCallback;
import com.hzy.lib7z.Z7Extractor;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends BaseCompat {

    protected AssetsSoft soft;

    private MainBinding bind;

    private Intent gotopage = new Intent();
    
    private SharedPreferences setac, iconSpash;

    private static final int REQUEST_CODE_STORAGE_PERMISSION = 1000;

    private static final int REQUEST_CODE_MEDIA_IMAGES_PERMISSION = 1001;

    private static final int REQUEST_CODE_MANAGE_ALL_FILES = 1002;

    private static final int REQUEST_CODE_NOTIFICATION_PERMISSION = 1003;

    private boolean allPermissionsGranted = false;

    private boolean isWaitingForPermissionResult = false;

    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        bind = MainBinding.inflate(LayoutInflater.from(this));
        super.onCreate(_savedInstanceState);
        setContentView(bind.getRoot());
        initialize(_savedInstanceState);
    }

    private void initialize(Bundle _savedInstanceState) {
        iconSpash = getSharedPreferences("iconSpash", MODE_PRIVATE);
        setac = getSharedPreferences("setac", MODE_PRIVATE);
        runtimePermissions();
    }

    void runtimePermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (!Environment.isExternalStorageManager()) {
                isWaitingForPermissionResult = true;
                try {
                    Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                    Uri uri = Uri.fromParts("package", getPackageName(), null);
                    intent.setData(uri);
                    startActivityForResult(intent, REQUEST_CODE_MANAGE_ALL_FILES);
                } catch (Exception ex) {
                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                    startActivityForResult(intent, REQUEST_CODE_MANAGE_ALL_FILES);
                }
            } else {
                checkMediaImagesPermission();
            }
        } else {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED || ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                isWaitingForPermissionResult = true;
                ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE }, REQUEST_CODE_STORAGE_PERMISSION);
            } else {
                checkMediaImagesPermission();
            }
        }
    }

    private void checkMediaImagesPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_MEDIA_IMAGES) != PackageManager.PERMISSION_GRANTED) {
                isWaitingForPermissionResult = true;
                ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.READ_MEDIA_IMAGES }, REQUEST_CODE_MEDIA_IMAGES_PERMISSION);
            } else {
                checkNotificationPermission();
            }
        } else {
            checkNotificationPermission();
        }
    }

    private void checkNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                isWaitingForPermissionResult = true;
                ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.POST_NOTIFICATIONS }, REQUEST_CODE_NOTIFICATION_PERMISSION);
            } else {
                allPermissionsGranted = true;
                startAppProcess();
            }
        } else {
            if (NotificationManagerCompat.from(this).areNotificationsEnabled()) {
                allPermissionsGranted = true;
                startAppProcess();
            } else {
                Toast.makeText(this, "Please enable notifications for better experience", Toast.LENGTH_LONG).show();
                allPermissionsGranted = true;
                startAppProcess();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_MANAGE_ALL_FILES) {
            isWaitingForPermissionResult = false;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                if (Environment.isExternalStorageManager()) {
                    checkMediaImagesPermission();
                } else {
                    Toast.makeText(this, "Storage access is required for app functionality", Toast.LENGTH_LONG).show();
                    checkMediaImagesPermission();
                }
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        isWaitingForPermissionResult = false;
        switch(requestCode) {
            case REQUEST_CODE_STORAGE_PERMISSION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    checkMediaImagesPermission();
                } else {
                    Toast.makeText(this, "Storage permission is recommended for full functionality", Toast.LENGTH_LONG).show();
                    checkMediaImagesPermission();
                }
                break;
            case REQUEST_CODE_MEDIA_IMAGES_PERMISSION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    checkNotificationPermission();
                } else {
                    checkNotificationPermission();
                    Toast.makeText(this, "Some features may not work without media permission", Toast.LENGTH_SHORT).show();
                }
                break;
            case REQUEST_CODE_NOTIFICATION_PERMISSION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    allPermissionsGranted = true;
                    startAppProcess();
                } else {
                    allPermissionsGranted = true;
                    startAppProcess();
                    Toast.makeText(this, "Notifications are disabled. Some features may not work properly", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!isWaitingForPermissionResult && !allPermissionsGranted) {
            runtimePermissions();
        }
    }

    private void startAppProcess() {
        if (!allPermissionsGranted) {
            return;
        }
        tryToRunApp();
    }

    private void tryToRunApp() {
        ThemeChaker();
        var mypath = getFilesDir().getAbsolutePath() + "/" + "databins";
        var pythonPath = getFilesDir().getAbsolutePath() + File.separator + "env.sh";
        var phpPath = getFilesDir().getAbsolutePath() + File.separator + "lib" + File.separator + "libx265.so";
        if (!FileUtil.isExistFile("/storage/emulated/0/GhostWebIDE/plugins/config.json")) {
            FileUtil.writeFile("/storage/emulated/0/GhostWebIDE/plugins/config.json", "[\n    {\n        \"name\": \"name\",\n        \"dir\": \"dir\",\n        \"dev\": \"namedev\"\n    }\n]");
        }
        var ghostPath = FileUtil.THEME + "/GhostThemeapp.ghost";
        var iconPath = getFilesDir().getAbsoluteFile() + "/icon.png";
        if (!FileUtil.isExistFile(iconPath)) {
            AssetsSoft soft = new AssetsSoft();
            soft.copyOneFileFromAssets("icon.png", iconPath, this);
        }
        var cursorpath = FileUtil.HOME + "/cursor/cursor.json";
        if (!FileUtil.isExistFile(cursorpath)) {
            AssetsSoft soft = new AssetsSoft();
            soft.unzipFromAssets(this, "cursor.zip", "/storage/emulated/0/GhostWebIDE/cursor");
        }
        var pythonchecker = getFilesDir().getAbsolutePath() + File.separator + "python_checker.py";
        if (!FileUtil.isExistFile(pythonchecker)) {
            var soft = new AssetsSoft();
            soft.copyOneFileFromAssets("python_checker.py", getFilesDir().getAbsolutePath() + File.separator, this);
        }
        var pyauto = getFilesDir().getAbsolutePath() + File.separator + "autocomplete.py";
        if (!FileUtil.isExistFile(pyauto)) {
            var soft = new AssetsSoft();
            soft.unzipFromAssets(MainActivity.this, "pythondata.zip", getFilesDir().getAbsolutePath() + File.separator);
        }
        var snippetPath = FileUtil.HOMESNIPPET;
        if (!FileUtil.isExistFile(snippetPath)) {
            new AssetsSoft().unzipFromAssets(this, "snippet.zip", "/storage/emulated/0/GhostWebIDE/snippet/");
        }
        var ktPath = getCacheDir().getAbsolutePath() + File.separator + "kt" + File.separator + "kotlin-stdlib-1.0.0.jar";
        if (!FileUtil.isExistFile(ktPath)) {
            new AssetsSoft().unzipFromAssets(this, "kt.zip", getCacheDir().getAbsolutePath() + File.separator + "kt");
        }
        try {
            if (!FileUtil.isExistFile("/storage/emulated/0/GhostWebIDE/android/android.jar")) {
                var asster = getAssets();
                Z7Extractor.extractAsset(asster, "android.7z", "/storage/emulated/0/GhostWebIDE/android/", new IExtractCallback() {

                    @Override
                    public void onError(int arg0, String arg1) {
                    }

                    @Override
                    public void onGetFileNum(int arg0) {
                    }

                    @Override
                    public void onProgress(String arg0, long arg1) {
                    }

                    @Override
                    public void onStart() {
                    }

                    @Override
                    public void onSucceed() {
                        runOnUiThread(() -> {
                            Toast.makeText(MainActivity.this, "done", Toast.LENGTH_SHORT).show();
                            startApp();
                        });
                    }
                });
            } else {
                startApp();
            }
        } catch (Exception err) {
            Log.e("Error ", err.getLocalizedMessage());
            startApp();
        }
        if (!FileUtil.isExistFile(getFilesDir().getAbsolutePath() + File.separator + "php.ini")) {
            var softApi = new AssetsSoft();
            softApi.copyOneFileFromAssets("php.ini", getFilesDir().getAbsolutePath() + "/", this);
        } else {
            Log.e("File Copyed", AssetsSoft.class.getSimpleName());
        }
        if (iconSpash != null) {
            runOnUiThread(this::setIconSp);
        }
    }

    void startApp() {
        runOnUiThread(() -> {
            var mypath = getFilesDir().getAbsolutePath() + "/" + "databins";
            var pythonPath = getFilesDir().getAbsolutePath() + File.separator + "env.sh";
            var phpPath = getFilesDir().getAbsolutePath() + File.separator + "lib" + File.separator + "libx265.so";
            var ghostPath = "/storage/emulated/0/GhostWebIDE/theme/GhostThemeapp.ghost";
            if (!FileUtil.isExistFile(pythonPath) || !FileUtil.isExistFile(phpPath) || !FileUtil.isExistFile(mypath) || !FileUtil.isExistFile(ghostPath)) {
                startActivity(new Intent(getApplication(), SplashWord.class));
                finish();
            } else {
                new Handler(Looper.getMainLooper()).postDelayed(() -> {
                    gotopage.setClass(getApplicationContext(), FileManagerActivity.class);
                    gotopage.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(gotopage);
                    finish();
                }, 2000);
            }
        });
    }

    void setIconSp() {
        int data = iconSpash.getInt("iconSpash", 0);
        int iconSize = R.drawable.ghosticon_spash;
        switch(data) {
            case 0:
                iconSize = R.drawable.ghosticon_spash;
                break;
            case 1:
                iconSize = R.drawable.ghosticonblue;
                break;
            case 2:
                iconSize = R.drawable.ghosticonblack;
                break;
            case 3:
                iconSize = R.drawable.ghosticonred;
                break;
            case 4:
                iconSize = R.drawable.ghosticonyellow;
                break;
            case 5:
                iconSize = R.drawable.ghosticonpapermod;
                break;
            case 6:
                iconSize = R.drawable.ghosticongreenhell;
                break;
            case 7:
                iconSize = R.drawable.ghosticonbluemod;
                break;
            case 8:
                iconSize = R.drawable.ghosticons;
                break;
            case 9:
                iconSize = R.drawable.greendraw;
                break;
            case 10:
                iconSize = R.drawable.paperdraw;
                break;
            case 11:
                iconSize = R.drawable.reddraw;
                break;
        }
        bind.iconSp.setImageResource(iconSize);
    }

    public boolean areNotificationsEnabled() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            return ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED;
        } else {
            return NotificationManagerCompat.from(this).areNotificationsEnabled();
        }
    }
}
