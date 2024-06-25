package Ninja.coder.Ghostemane.code.widget.component;

import Ninja.coder.Ghostemane.code.utils.FileUtil;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@RequiresApi(15)
public class SwbData {
    private double a = 0.0d;
    private Context context;
    private String jsoj = "";
    private HashMap<String, Object> map = new HashMap<>();
    private String newId = "";
    private String path = "";
    private String s1 = "";
    private String s2 = "";
    private ArrayList<String> str = new ArrayList<>();
    private ArrayList<String> str1 = new ArrayList<>();
    private ArrayList<String> str2 = new ArrayList<>();
    private ArrayList<String> str4 = new ArrayList<>();
    private String tempN = "";

    public SwbData(Context context) {
        this.context = context;
    }

    protected void setUnZipData(String str3, String str5) {
        try {
            File file = new File(str5);
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str3));
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    zipInputStream.close();
                    return;
                }
                String name = nextEntry.getName();
                if (nextEntry.isDirectory()) {
                    mkdirs(file, name);
                } else {
                    String dirpart = dirpart(name);
                    if (dirpart != null) {
                        mkdirs(file, dirpart);
                    }
                    extractFile(zipInputStream, file, name);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void CopyDataFiles() {
        s1 = path.concat("data/");
        s2 = FileUtil.getExternalStorageDir().concat("/.sketchware/data/".concat(newId.concat("/")));
        try {
            copyDirectory(new File(s1), new File(s2));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (isLocalLibrary()) {
            Copylocallibrary();
        } else {
            setCopyResources();
        }
    }

    protected void Copylocallibrary() {
        FileUtil.listDir(path.concat("local_libs/"), str2);
        FileUtil.listDir(
                FileUtil.getExternalStorageDir().concat("/.sketchware/local_libs/libs/"), str4);
        a = 0.0d;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < str2.size()) {
                if (!Uri.parse(str2.get((int) a))
                        .getLastPathSegment()
                        .equals(new Gson().toJson((Object) str4))) {
                    s1 = str2.get((int) a);
                    s2 =
                            FileUtil.getExternalStorageDir()
                                    .concat(
                                            "/.sketchware/local_libs/libs/"
                                                    .concat(Uri.parse(str2.get((int) a)).getLastPathSegment().concat("/")));
                    try {
                        copyDirectory(new File(s1), new File(s2));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                a += 1.0d;
                if (((double) str2.size()) == a) {
                    setCopyResources();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    protected void setCopyProjectFile() {
        jsoj = DecodeResources("sketchwaresecure", path.concat("project"));
        map = new Gson().fromJson(jsoj, new TypeToken<HashMap<String, Object>>() {
        }.getType());
        map.remove("sc_id");
        map.put("sc_id", newId);
        tempN = new Gson().toJson((Object) map);
        FileUtil.makeDir(
                FileUtil.getExternalStorageDir()
                        .concat("/.sketchware/mysc/list/".concat(newId.concat("/"))));
        UNDecodeResources(
                "sketchwaresecure",
                FileUtil.getExternalStorageDir()
                        .concat("/.sketchware/mysc/list/".concat(newId.concat("/project"))));
        // add interface custom
    }

    protected void setCopyResources() {
        FileUtil.copyFile(
                path.concat("resources/icons/icon.png"),
                FileUtil.getExternalStorageDir()
                        .concat("/.sketchware/resources/icons/".concat(newId.concat("/icon.png"))));
        s1 = path.concat("resources/fonts/");
        s2 =
                FileUtil.getExternalStorageDir()
                        .concat("/.sketchware/resources/fonts/".concat(newId.concat("/")));
        try {
            copyDirectory(new File(s1), new File(s2));
        } catch (IOException e) {
            e.printStackTrace();
        }
        s1 = path.concat("resources/images/");
        s2 =
                FileUtil.getExternalStorageDir()
                        .concat("/.sketchware/resources/images/".concat(newId.concat("/")));
        try {
            copyDirectory(new File(s1), new File(s2));
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        s1 = path.concat("resources/sounds/");
        s2 =
                FileUtil.getExternalStorageDir()
                        .concat("/.sketchware/resources/sounds/".concat(newId.concat("/")));
        try {
            copyDirectory(new File(s1), new File(s2));
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        setCopyProjectFile();
    }

    @NonNull
    protected String DecodeResources(String str3, String str5) {
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] bytes = str3.getBytes();
            instance.init(2, new SecretKeySpec(bytes, "AES"), new IvParameterSpec(bytes));
            RandomAccessFile randomAccessFile = new RandomAccessFile(str5, "r");
            byte[] bArr = new byte[((int) randomAccessFile.length())];
            randomAccessFile.readFully(bArr);
            return new String(instance.doFinal(bArr));
        } catch (Exception e) {

            return "error occurred";
        }
    }

    @NonNull
    protected void UNDecodeResources(String str3, String str5) {
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] bytes = str3.getBytes();
            instance.init(1, new SecretKeySpec(bytes, "AES"), new IvParameterSpec(bytes));
            new FileOutputStream(str5).write(instance.doFinal(tempN.toString().getBytes()));
        } catch (Exception e) {

        }
    }

    protected String getIdProjectSwb() {
        FileUtil.listDir("/storage/emulated/0/.sketchware/mysc/list/", str);
        Collections.sort(str);
        Collections.reverse(str);
        ArrayList arrayList = new ArrayList();
        a = 0.0d;
        for (int i = 0; i < str.size(); i++) {
            str1.add(Uri.parse(str.get((int) a)).getLastPathSegment());
            a += 1.0d;
            if (((double) str.size()) == a) {
                a = 0.0d;
                for (int i2 = 0; i2 < str1.size(); i2++) {
                    arrayList.add(Integer.valueOf(Integer.parseInt(str1.get((int) a))));
                    a += 1.0d;
                    if (((double) str1.size()) == a) {
                        jsoj = Integer.toString(((Integer) Collections.max(arrayList)).intValue());
                    }
                }
            }
        }
        return String.valueOf((long) (Double.parseDouble(jsoj) + 1.0d));
    }

    public boolean isFinishingTask() {
        return newId != null
                && FileUtil.isExistFile(
                FileUtil.getExternalStorageDir()
                        .concat("/.sketchware/mysc/list/".concat(newId.concat("/project"))));
    }

    @NonNull
    public boolean isLocalLibrary() {
        return FileUtil.isDirectory(path.concat("local_libs/"));
    }

    private String dirpart(String str3) {
        int lastIndexOf = str3.lastIndexOf(File.separatorChar);
        if (lastIndexOf == -1) {
            return null;
        }
        return str3.substring(0, lastIndexOf);
    }

    @RequiresApi(14)
    private void extractFile(ZipInputStream zipInputStream, File file, String str3)
            throws IOException {
        byte[] bArr = new byte[4096];
        BufferedOutputStream bufferedOutputStream =
                new BufferedOutputStream(new FileOutputStream(new File(file, str3)));
        while (true) {
            int read = zipInputStream.read(bArr);
            if (read == -1) {
                bufferedOutputStream.close();
                return;
            }
            bufferedOutputStream.write(bArr, 0, read);
        }
    }

    private void mkdirs(File file, String str3) {
        File file2 = new File(file, str3);
        if (!file2.exists()) {
            file2.mkdirs();
        }
    }

    @NonNull
    public void selecteSWB(@NonNull String str3) {

        FileUtil.copyFile(
                str3,
                FileUtil.getPackageDataDir(context)
                        .concat("/swb_restore/zip/".concat(Uri.parse(str3).getLastPathSegment())));
        new File(
                FileUtil.getPackageDataDir(context)
                        .concat("/swb_restore/zip/".concat(Uri.parse(str3).getLastPathSegment())))
                .renameTo(
                        new File(
                                FileUtil.getPackageDataDir(context)
                                        .concat(
                                                "/swb_restore/zip/"
                                                        .concat(
                                                                Uri.parse(str3).getLastPathSegment().replace(".swb", ".zip")))));
        setUnZipData(
                FileUtil.getPackageDataDir(context)
                        .concat(
                                "/swb_restore/zip/"
                                        .concat(Uri.parse(str3).getLastPathSegment().replace(".swb", ".zip"))),
                FileUtil.getPackageDataDir(context).concat("/swb_restore/"));
        path = FileUtil.getPackageDataDir(context).concat("/swb_restore/");
        newId = getIdProjectSwb();
        CopyDataFiles();
    }

    @NonNull
    public void copyDirectory(File file, File file2) throws IOException {
        if (file.isDirectory()) {
            if (!file2.exists()) {
                file2.mkdir();
            }
            String[] list = file.list();
            for (int i = 0; i < list.length; i++) {
                copyDirectory(new File(file, list[i]), new File(file2, list[i]));
            }
            return;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read <= 0) {
                fileInputStream.close();
                fileOutputStream.close();
                return;
            }
            fileOutputStream.write(bArr, 0, read);
        }
    }

    @NonNull
    public void taskEnd() {
        while (isFinishingTask()) {
            FileUtil.deleteFile(FileUtil.getPackageDataDir(context).concat("/swb_restore/"));
            break;
        }
    }

    public void runOnUiThread(Runnable run) {
        var handler = new Handler(Looper.getMainLooper());
        handler.post(run);
    }

    public void init(String swbfile) {
        var dia = new MaterialAlertDialogBuilder(context);
        dia.setTitle("Swb Restore");
        dia.setMessage("Do you want to restore the project?");
        dia.setNegativeButton(android.R.string.cancel, null);

        dia.setPositiveButton(
                android.R.string.ok,
                (d, c) -> {
                    var dialog = new ProgressDialog(context, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
                    dialog.setTitle("SwbFile");
                    dialog.setMessage("Wait while installing....");
                    dialog.getWindow().setBackgroundDrawable(color());
                    if (dialog != null) {
                        dialog.show();
                    }
                    new Thread(
                            () -> {
                                selecteSWB(swbfile);
                                runOnUiThread(
                                        () -> {
                                            taskEnd();
                                            if (dialog != null) {
                                                dialog.dismiss();
                                            }
                                        });
                            })
                            .start();
                });
        if (dia != null) {
            dia.show();
        }
    }

    protected MaterialShapeDrawable color() {
        var shap =
                new MaterialShapeDrawable(
                        ShapeAppearanceModel.builder().setAllCorners(CornerFamily.ROUNDED, 30f).build());
        shap.setFillColor(
                ColorStateList.valueOf(
                        MaterialColors.getColor(context, com.google.android.material.R.attr.colorSurface, 0)));
        shap.setStroke(
                0.4f,
                ColorStateList.valueOf(
                        MaterialColors.getColor(
                                context, com.google.android.material.R.attr.colorOnSurface, 0)));
        return shap;
    }
}
