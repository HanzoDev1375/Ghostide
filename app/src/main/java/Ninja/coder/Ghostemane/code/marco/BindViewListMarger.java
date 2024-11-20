package Ninja.coder.Ghostemane.code.marco;

import Ninja.coder.Ghostemane.code.ApplicationLoader;
import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.folder.FileEnvironmentHelper;
import Ninja.coder.Ghostemane.code.utils.ObjectUtils;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.color.MaterialColors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@Deprecated

public class BindViewListMarger {
    // code by ninja coder

    private static FileEnvironmentHelper hp;

    public static void run(ImageView img, TextView tv) {
        var doctor = tv.getText().toString();
        hp = new FileEnvironmentHelper(doctor);
        if (doctor.startsWith("GhostWebIDE")) {
            // img.setImageResource(R.drawable.icon);
            tv.setTextColor(Color.parseColor("#ff5001"));
        } else if (doctor.matches("\\bAndroid\\b")) {
            // GlideCompat.GlideNormal(img,R.drawable.folderandroid);
            //   img.setImageResource(R.drawable.folderandroid);
            tv.setTextColor(Color.parseColor("#ff00cbf4"));
        } else if (doctor.matches("\\bDownload\\b")) {
            //img.setImageResource(R.drawable.folderdownload);
            // #FFECF400
            tv.setTextColor(Color.parseColor("#FFC14FFF"));
        } else if (doctor.startsWith(".gieieie")) {
            // img.setImageResource(R.drawable.foldergit);
            tv.setTextColor(Color.parseColor("#FFFF4F58"));
        } else if (doctor.startsWith(".vscode")) {
            //  img.setImageResource(R.drawable.foldervscode);
            tv.setTextColor(Color.parseColor("#FFAAFF4F"));
        } else if (doctor.matches("\\bghostweb\\b")) {
            tv.setTextColor(MaterialColors.getColor(tv, ObjectUtils.ColorFilter));
        } else if (doctor.matches("\\btheme\\b")) {
            tv.setTextColor(Color.parseColor("#ff5001"));
        } else if (doctor.startsWith("MT2")) {
            tv.setTextColor(Color.CYAN);
        } else if (doctor.matches("\\bAndroidIDEProjects\\b")) {
            tv.setTextColor(Color.parseColor("#ff7090"));
            // Start new langs
        } else if (hp.isGradleJDirectory()) {
            tv.setTextColor(Color.parseColor("#ff4240"));
        } else if (hp.isCssDirectory()) {
            tv.setTextColor(Color.parseColor("#ff9011"));
        } else if (hp.isFileHasKeyName(tv.getText().toString(), "ghost", false, true)) {
            tv.setText(Color.parseColor("#ff120000"));
        } else {

            img.setImageResource(R.drawable.folder);
            // ObjectUtils.setColorFilter(img);
        }
    }

    public static void dirPathIcon(ImageView view, String filePath) {
    }

    public static void runfromFile(TextView view) {
        if (ApplicationLoader.getVb().contains("HsiGamer")) {

            var token = view.getText().toString();

            if (token.endsWith(".html")) {
                change(
                        view,
                        new int[]{
                                Color.parseColor("#FFFF9090"),
                                Color.parseColor("#FFFF6464"),
                                Color.parseColor("#FFFF4A4A"),
                                Color.parseColor("#FFFF3333")
                        });
            } else if (token.endsWith(".css")) {
                change(
                        view,
                        new int[]{
                                Color.parseColor("#FF96E3FF"),
                                Color.parseColor("#FF70D9FF"),
                                Color.parseColor("#FF53D1FF"),
                                Color.parseColor("#FF2EC7FF")
                        });
            } else if (token.endsWith(".js")) {
                change(
                        view,
                        new int[]{
                                Color.parseColor("#FFFEEB7C"),
                                Color.parseColor("#FFFFE655"),
                                Color.parseColor("#FFFFE138"),
                                Color.parseColor("#FFFFDD1D")
                        });
            } else if (token.endsWith(".svg")) {
                change(
                        view,
                        new int[]{
                                Color.parseColor("#EF00A3D4"),
                                Color.parseColor("#FF008DA9"),
                                Color.parseColor("#FF5AFBD3"),
                                Color.parseColor("#FF00FFBF")
                        });

            } else if (token.endsWith(".py")) {

                change(
                        view,
                        new int[]{
                                Color.parseColor("#FF00BBFF"),
                                Color.parseColor("#FF0091C5"),
                                Color.parseColor("#FFFFDD00"),
                                Color.parseColor("#FFE5C700")
                        });

            } else if (token.endsWith(".jar")) {

                change(
                        view,
                        new int[]{
                                Color.parseColor("#FF62FF47"),
                                Color.parseColor("#FF2FFF0A"),
                                Color.parseColor("#FFFF680A"),
                                Color.parseColor("#FFFE6201")
                        });

            } else if (token.endsWith(".json")) {
                change(
                        view,
                        new int[]{
                                Color.parseColor("#FFC47CFA"),
                                Color.parseColor("#FFAC43FC"),
                                Color.parseColor("#FFA023FF"),
                                Color.parseColor("#FF9000FF")
                        });

            } else if (token.endsWith(".java")) {
                change(
                        view,
                        new int[]{
                                Color.parseColor("#FF62FF47"),
                                Color.parseColor("#FF2FFF0A"),
                                Color.parseColor("#FFFF680A"),
                                Color.parseColor("#FFFE6201")
                        });

            } else if (token.endsWith(".cpp")) {
                change(
                        view,
                        new int[]{
                                Color.parseColor("#FF89FAD0"),
                                Color.parseColor("#FF53FEBF"),
                                Color.parseColor("#FF1DFEAC"),
                                Color.parseColor("#FF00FFA2")
                        });

            } else if (token.endsWith(".c")) {
                change(
                        view,
                        new int[]{
                                Color.parseColor("#FF89FAD0"),
                                Color.parseColor("#FF53FEBF"),
                                Color.parseColor("#FF1DFEAC"),
                                Color.parseColor("#FF00EF97")
                        });

            } else if (token.endsWith(".ghost")) {
                change(
                        view,
                        new int[]{
                                Color.parseColor("#FF8E85F3"),
                                Color.parseColor("#FF796FDE"),
                                Color.parseColor("#FF756EC7"),
                                Color.parseColor("#FF5B54A4")
                        });

            } else if (token.endsWith(".xml")) {
                change(
                        view,
                        new int[]{
                                Color.parseColor("#FFD77272"),
                                Color.parseColor("#FFB75858"),
                                Color.parseColor("#FFB43838"),
                                Color.parseColor("#FFD62A2A")
                        });

            } else if (token.endsWith(".ninja")) {

                change(
                        view,
                        new int[]{
                                Color.parseColor("#FFFF9090"),
                                Color.parseColor("#FFFF6464"),
                                Color.parseColor("#FFFF4A4A"),
                                Color.parseColor("#FFFF3333")
                        });

            } else if (token.endsWith(".sh")) {
                change(
                        view,
                        new int[]{
                                Color.parseColor("#FFFFED7A"),
                                Color.parseColor("#FFF0D944"),
                                Color.parseColor("#FFFFEA5E"),
                                Color.parseColor("#FFDEC000")
                        });

            } else if (token.endsWith(".php")) {
                change(
                        view,
                        new int[]{
                                Color.parseColor("#FFFFED7A"),
                                Color.parseColor("#FFF0D944"),
                                Color.parseColor("#FFFFEA5E"),
                                Color.parseColor("#FFDEC000")
                        });

            } else if (token.endsWith(".apk")) {
                change(
                        view,
                        new int[]{
                                Color.parseColor("#FFF99BD7"),
                                Color.parseColor("#FFFE6FCA"),
                                Color.parseColor("#FFFF4BBD"),
                                Color.parseColor("#FFF01BA2")
                        });

            } else if (token.endsWith(".go")) {
                change(
                        view,
                        new int[]{
                                Color.parseColor("#FF9FBEFE"),
                                Color.parseColor("#FF709EFB"),
                                Color.parseColor("#FF4381FC"),
                                Color.parseColor("#FF1764FF")
                        });

            } else if (token.endsWith(".txt")) {
                change(
                        view,
                        new int[]{
                                Color.parseColor("#FF9FBEFE"),
                                Color.parseColor("#FF709EFB"),
                                Color.parseColor("#FF4381FC"),
                                Color.parseColor("#FF1764FF")
                        });

            } else if (token.endsWith(".pdf")) {
                change(
                        view,
                        new int[]{
                                Color.parseColor("#FF9FBEFE"),
                                Color.parseColor("#FF709EFB"),
                                Color.parseColor("#FF4381FC"),
                                Color.parseColor("#FF1764FF")
                        });

            } else if (token.endsWith(".dart")) {
                change(
                        view,
                        new int[]{
                                Color.parseColor("#FF9FBEFE"),
                                Color.parseColor("#FF709EFB"),
                                Color.parseColor("#FF4381FC"),
                                Color.parseColor("#FF0054FD")
                        });

            } else if (token.endsWith(".swift")) {
                change(
                        view,
                        new int[]{
                                Color.parseColor("#FFF3D19B"),
                                Color.parseColor("#FFF7CA83"),
                                Color.parseColor("#FFFFC569"),
                                Color.parseColor("#FFFFBB4D")
                        });

            } else if (token.endsWith(".ttf") || token.endsWith(".otf")) {
                change(
                        view,
                        new int[]{
                                Color.parseColor("#FFF3D19B"),
                                Color.parseColor("#FFF7CA83"),
                                Color.parseColor("#FFFFC569"),
                                Color.parseColor("#FFFFBB4D")
                        });

            } else if (token.endsWith(".aa")) {
                change(
                        view,
                        new int[]{
                                Color.parseColor("#FFB1BAC2"),
                                Color.parseColor("#FF8496A8"),
                                Color.parseColor("#FF959798"),
                                Color.parseColor("#FFCACDD0")
                        });

            } else if (token.endsWith(".gradle") || token.endsWith(".groovy")) {
                change(
                        view,
                        new int[]{
                                Color.parseColor("#FF9FE5F7"),
                                Color.parseColor("#FF66DCFA"),
                                Color.parseColor("#FF3AD8FF"),
                                Color.parseColor("#FF1BAED3")
                        });

            } else if (token.endsWith(".smali")) {
                change(
                        view,
                        new int[]{
                                Color.parseColor("#FFD8FFE7"),
                                Color.parseColor("#FFBEFCD6"),
                                Color.parseColor("#FF87FFB5"),
                                Color.parseColor("#FF69FFA3")
                        });

            } else if (token.endsWith(".g4")) {
                change(
                        view,
                        new int[]{
                                Color.parseColor("#FFFEBFAF"),
                                Color.parseColor("#FFFFAD98"),
                                Color.parseColor("#FFFE9C83"),
                                Color.parseColor("#FFFF8668")
                        });

            } else if (token.endsWith(".ts")) {
                change(
                        view,
                        new int[]{
                                Color.parseColor("#FF9B9CFE"),
                                Color.parseColor("#FF7A7CFF"),
                                Color.parseColor("#FF5C5FFF"),
                                Color.parseColor("#FF3135FF")
                        });

            } else {
                ObjectUtils.setTextColor(view);
            }
        } else {
            ObjectUtils.setTextColor(view);
        }
    }

    // Target api android 8+
    public static void hideFiles(String directoryPath) {
        Path directory = Paths.get(directoryPath);

        try {
            Files.newDirectoryStream(directory)
                    .forEach(
                            path -> {
                                try {
                                    if (!Files.isHidden(path) && !path.getFileName().toString().startsWith(".")) {
                                        Files.move(
                                                path,
                                                Paths.get(
                                                        path.getParent().toString(), "." + path.getFileName().toString()));
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Tnks to https://github.com/tushar09/Gradient-Textview

    /*
      using
      TextView tv = findViewById(R.id.tv);
    Tvg.change(tv, Color.parseColor("#800CDD"),  Color.parseColor("#3BA3F2"));
    Tvg.change((TextView) findViewById(R.id.tv2), new int[]{
            Color.parseColor("#F97C3C"),
            Color.parseColor("#FDB54E"),
            Color.parseColor("#64B678"),
            Color.parseColor("#478AEA"),
            Color.parseColor("#8446CC"),
    });
    Tvg.change((TextView) findViewById(R.id.tv3), new int[]{
            Color.parseColor("#F97C3C"),
            Color.parseColor("#FDB54E"),
            Color.parseColor("#64B678"),
            Color.parseColor("#478AEA"),
            Color.parseColor("#8446CC"),
    });
      */
    public static void change(TextView tv, int startColor, int endColor) {
        tv.setTextColor(startColor);
        Shader textShader =
                new LinearGradient(
                        0,
                        0,
                        tv.getPaint().measureText(tv.getText().toString()),
                        tv.getTextSize(),
                        new int[]{startColor, endColor},
                        new float[]{0, 1},
                        Shader.TileMode.CLAMP);
        tv.getPaint().setShader(textShader);
    }

    /**
     * Changes the textview's color to gradient
     *
     * @param tv     TextView to change the color
     * @param colors arrays of multiple colors to create the gradient
     */
    public static void change(TextView tv, int[] colors) {
        try {
            tv.setTextColor(colors[0]);
            Shader textShader =
                    new LinearGradient(
                            0,
                            0,
                            tv.getPaint().measureText(tv.getText().toString()),
                            tv.getTextSize(),
                            colors,
                            null,
                            Shader.TileMode.CLAMP);
            tv.getPaint().setShader(textShader);
        } catch (Exception e) {

        }
    }

    /**
     * Changes the list of textview's color to gradient
     *
     * @param tvs    List of Textviews which are need to be changed
     * @param colors arrays of multiple colors to create the gradient
     */
    public static void change(List<TextView> tvs, int[] colors) {
        try {
            for (TextView tv : tvs) {
                tv.setTextColor(colors[0]);
                Shader textShader =
                        new LinearGradient(
                                0,
                                0,
                                tv.getPaint().measureText(tv.getText().toString()),
                                tv.getTextSize(),
                                colors,
                                null,
                                Shader.TileMode.CLAMP);
                tv.getPaint().setShader(textShader);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Changes the list of textview's color to gradient
     *
     * @param tvs        List of Textviews which are need to be changed
     * @param startColor first color of gradient
     * @param endColor   end color of gradient
     */
    public static void change(List<TextView> tvs, int startColor, int endColor) {
        try {
            for (TextView tv : tvs) {
                tv.setTextColor(startColor);
                Shader textShader =
                        new LinearGradient(
                                0,
                                0,
                                tv.getPaint().measureText(tv.getText().toString()),
                                tv.getTextSize(),
                                new int[]{startColor, endColor},
                                new float[]{0, 1},
                                Shader.TileMode.CLAMP);
                tv.getPaint().setShader(textShader);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
