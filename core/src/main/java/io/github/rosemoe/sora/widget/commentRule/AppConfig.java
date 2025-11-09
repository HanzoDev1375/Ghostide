package io.github.rosemoe.sora.widget.commentRule;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import ir.ninjacoder.ghostide.core.utils.FileUtil;


public class AppConfig {
    protected static String filePath = "/storage/emulated/0/GhostWebIDE/settingApp/config.json";
    private Gson gson;
    private int tabSize;
    private boolean isShowFileDir;
    private boolean formatCode;
    private boolean ShowFiledir;
    private boolean ShowHomeNewAc;

    public AppConfig() {
        try {
            String tb = "[\n  {\n    \"formatCode\": true,\n    \"sizeTab\": 4,\n    \"ShowFiledir\": true,\n    \"CompileNinjaFile\": false,\n    \"ShowHomeNewAc\": false\n  }\n]";
            if (FileUtil.isExistFile(filePath)) {
                FileUtil.writeFile(filePath, tb);
            }
            File file = new File(filePath);
            ArrayList<String> str = new ArrayList<>();
            ArrayList<HashMap<String, Object>> map = new ArrayList<>();
            str.clear();
            map.clear();
            if (file.exists()) {
                int a = 0;
                for (int i = 0; i < str.size(); ++i) {
                    {
                        HashMap<String, Object> item = new HashMap<>();
                        item.put("formatCode", str.get(a));
                        map.add(item);
                    }
                    {
                        HashMap<String, Object> item = new HashMap<>();
                        item.put("sizeTab", str.get(a));
                        map.add(item);
                    }
                    {
                        HashMap<String, Object> item = new HashMap<>();
                        item.put("ShowFiledir", str.get(a));
                        map.add(item);
                    }
                    {
                        HashMap<String, Object> item = new HashMap<>();
                        item.put("CompileNinjaFile", str.get(a));
                        map.add(item);
                    }
                    {
                        HashMap<String, Object> item = new HashMap<>();
                        item.put("ShowHomeNewAc", str.get(a));
                        map.add(item);
                    }
                    map = new Gson().fromJson(new FileReader(file),
                            new TypeToken<ArrayList<HashMap<String, Object>>>() {
                            }.getType());
                    // اصلاح مقادیر متغیرها بر اساس متن در فایل json
                    tabSize = Integer.parseInt(map.get(i).get("sizeTab").toString());
                    formatCode = Boolean.parseBoolean(map.get(i).get("formatCode").toString());
                    isShowFileDir = Boolean.parseBoolean(map.get(i).get("ShowFiledir").toString());
                    ShowFiledir = Boolean.parseBoolean(map.get(i).get("ShowFiledir").toString());
                    ShowHomeNewAc = Boolean.parseBoolean(map.get(i).get("ShowHomeNewAc").toString());
                    Log.i("Read", map.toString());
                }

                a++;
            }
        } catch (FileNotFoundException err) {
            Log.e("File not found", err.getMessage());
        }
    }

    public int getTabSize() {
        return this.tabSize;
    }

    public void setTabSize(int tabSize) {
        this.tabSize = tabSize;
    }

    public boolean getIsShowFileDir() {
        return this.isShowFileDir;
    }

    public void setIsShowFileDir(boolean isShowFileDir) {
        this.isShowFileDir = isShowFileDir;
    }

    public boolean getFormatCode() {
        return this.formatCode;
    }

    public void setFormatCode(boolean formatCode) {
        this.formatCode = formatCode;
    }

    public boolean getShowFiledir() {
        return this.ShowFiledir;
    }

    public void setShowFiledir(boolean ShowFiledir) {
        this.ShowFiledir = ShowFiledir;
    }

    public boolean getShowHomeNewAc() {
        return this.ShowHomeNewAc;
    }

    public void setShowHomeNewAc(boolean ShowHomeNewAc) {
        this.ShowHomeNewAc = ShowHomeNewAc;
    }
}

    // public static boolean isAarch64() {
        // return Arrays.asList(Build.SUPPORTED_ABIS).contains("arm64-v8a");
    // }

    // public static boolean isArmv7a() {
        // return Arrays.asList(Build.SUPPORTED_ABIS).contains("armeabi-v7a");
    // }

