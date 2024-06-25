package Ninja.coder.Ghostemane.code.utils;

import Ninja.coder.Ghostemane.code.ApplicationLoader;
import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.glidecompat.GlideCompat;
import Ninja.coder.Ghostemane.code.utils.ColorAndroid12;
import Ninja.coder.Ghostemane.code.widget.GhostWebMaterialDialog;
import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import com.caverock.androidsvg.SVG;
import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.materialswitch.MaterialSwitch;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class VectorHelper {
  public static String iconPath = "";
  public static String projectResourceDirectory = "";

  @RequiresApi(api = Build.VERSION_CODES.O)
  public static void v(Activity context, OnDone db) {
    GhostWebMaterialDialog builder = new GhostWebMaterialDialog(context);
    View inflate = context.getLayoutInflater().inflate(R.layout.create_vector_dialog, null);
    TextInputLayout textinput1 = (TextInputLayout) inflate.findViewById(R.id.textinputlayout1);
    TextInputLayout textinput2 = (TextInputLayout) inflate.findViewById(R.id.textinputlayout2);
    TextInputLayout textinput3 = (TextInputLayout) inflate.findViewById(R.id.textinputlayout3);
    TextInputLayout textinput4 = (TextInputLayout) inflate.findViewById(R.id.textinputlayout4);
    TextInputLayout textinput5 = (TextInputLayout) inflate.findViewById(R.id.textinputlayout5);
    TextInputEditText name = (TextInputEditText) inflate.findViewById(R.id.name);
    TextInputEditText height = (TextInputEditText) inflate.findViewById(R.id.height);
    TextInputEditText width = (TextInputEditText) inflate.findViewById(R.id.width);
    TextInputEditText color = (TextInputEditText) inflate.findViewById(R.id.color);
    TextInputEditText path = (TextInputEditText) inflate.findViewById(R.id.path);
    MaterialSwitch sw = inflate.findViewById(R.id.sw_color);
    sw.setChecked(false);
    sw.setText("Color Filter");
    ImageView icon = (ImageView) inflate.findViewById(R.id.icon);
    LinearLayout container = (LinearLayout) inflate.findViewById(R.id.container);
    LinearLayout round = (LinearLayout) inflate.findViewById(R.id.round);
    round.setBackgroundColor(0xffFFDCBD);
    path.setEnabled(true);
    path.setText(projectResourceDirectory);
    textinput4.setEndIconDrawable(R.drawable.mcolor1375);
    textinput4.setEndIconVisible(true);

    Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
    textinput4.setAnimation(animation);
    textinput4.setEndIconTintList(
        ColorStateList.valueOf(Color.parseColor(color.getText().toString())));
    textinput4.setEndIconOnClickListener(
        (v) -> {
          if (!color.getText().toString().trim().startsWith("#")) {
            Toast.makeText(context, "Invalid color code", Toast.LENGTH_SHORT).show();
          } else {
            try {

              ColorPickerDialogBuilder.with(context)
                  .setTitle("Choose color")
                  .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                  .showLightnessSlider(true)
                  .showColorEdit(true)
                  .showColorPreview(true)
                  .density(20)
                  .setOnColorSelectedListener(
                      (selectedColor) -> {
                        //	toast("onColorSelected: 0x" +
                        // Integer.toHexString(selectedColor));
                      })
                  .setPositiveButton(
                      "ok",
                      (dialog, selectedColor, allcolor) -> {
                        String rgs = Integer.toHexString(selectedColor);
                        color.setText("#".concat(rgs));
                        round.setBackgroundColor(selectedColor);
                        textinput4.setEndIconTintList(ColorStateList.valueOf(selectedColor));
                        ColorAndroid12.setColorFilter(icon, Color.parseColor("#".concat(rgs)));
                      })
                  .setNegativeButton("cancel", (d, c) -> {})
                  .build()
                  .show();

            } catch (Exception e) {
              //	Toast.makeText(context, e.toString(), 3000).show();
              DialogError(context, "Error", e);
            }
          }
        });
    builder.setView(inflate);
    width.setText(getWidthSvg(iconPath));
    height.setText(getHeightSvg(iconPath));
    if (iconPath.contains(".svg")) {
      name.setText(new File(iconPath).getName().replace(".svg", ""));
    } else if (iconPath.contains(".xml")) {
      name.setText(new File(iconPath).getName().replace(".xml", ""));
    }
    GlideCompat.LoadSvg(iconPath, icon);
    sw.setOnCheckedChangeListener(
        (btn, is) -> {
          if (is) {
            ColorAndroid12.setColorFilter(icon, Color.parseColor(color.getText().toString()));
          } else icon.setColorFilter(0);
        });

    icon.setImageDrawable(loadSvg(iconPath));
    builder.setPositiveButton(
        "convert",
        (d, w) -> {
          generateSvg2Vector(
              name.getText().toString().trim(),
              width.getText().toString().trim(),
              height.getText().toString().trim(),
              color.getText().toString().trim(),
              iconPath,
              projectResourceDirectory,
              context,
              sw);
          DialogDone(context, "Done", "Saved to " + iconPath.replace(".svg", ".xml"));
          db.done();
        });

    builder.setNegativeButton("Cancel", null);
    builder.show();
  }

  @RequiresApi(api = Build.VERSION_CODES.O)
  protected static void generateSvg2Vector(
      String name,
      String width,
      String height,
      String color,
      String source,
      String destination,
      Activity context,
      MaterialSwitch sw) {
    File svgPath = new File(source);
    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

    try {
      DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
      Document document = documentBuilder.parse(svgPath);
      NodeList nodeList = document.getElementsByTagName("path");

      StringBuilder vectorContent = new StringBuilder();
      vectorContent
          .append("<!--Convert By Ghostweb ide version ")
          .append(getVersion())
          .append(" -->")
          .append("\n\n<vector xmlns:android=\"http://schemas.android.com/apk/res/android\"\n")
          .append("    android:width=\"")
          .append(width)
          .append("dp\"\n")
          .append("    android:height=\"")
          .append(height)
          .append("dp\"\n")
          .append("    android:viewportWidth=\"")
          .append(width)
          .append("\"\n")
          .append("    android:viewportHeight=\"")
          .append(height)
          .append("\"\n");

      if (sw.isChecked()) {
        vectorContent.append("    android:tint=\"").append(color).append("\"\n");
      }

      vectorContent.append(">\n");

      for (int i = 0; i < nodeList.getLength(); i++) {
        Element element = (Element) nodeList.item(i);
        String pathData = element.getAttribute("d");
        String fillColor = element.getAttribute("fill");

        if (fillColor.isEmpty()) {
          String style = element.getAttribute("style");
          if (style.contains("fill:")) {
            String newFillColor = style.substring(style.indexOf("fill:") + "fill:".length());
            newFillColor = newFillColor.trim();
            if (newFillColor.contains(";")) {
              newFillColor = newFillColor.substring(0, newFillColor.indexOf(";"));
            }
            fillColor = newFillColor;
          }
        }

        vectorContent
            .append("  <path\n")
            .append("      android:pathData=\"")
            .append(pathData)
            .append("\"\n");

        if (!fillColor.isEmpty()) {
          vectorContent.append("      android:fillColor=\"").append(fillColor).append("\"\n");
        }

        vectorContent.append("  />\n");
      }

      vectorContent.append("</vector>\n");

      byte[] vectorText = vectorContent.toString().getBytes(StandardCharsets.UTF_8);

      Files.write(
          Paths.get(new File(projectResourceDirectory + name + ".xml").toURI()),
          vectorText,
          StandardOpenOption.CREATE,
          StandardOpenOption.TRUNCATE_EXISTING);

    } catch (Exception e) {
      DialogError(context, "Error", e);
    }
  }

  protected static boolean validate(
      EditText name, EditText height, EditText width, EditText color, EditText path) {
    if (name.getText().toString().trim().isEmpty()
        && name.getText().toString().trim().endsWith(".xml")
        && name.getText().toString().endsWith(".svg")) {
      return false;
    } else if (height.getText().toString().trim().isEmpty()) {
      return false;
    } else if (width.getText().toString().trim().isEmpty()) {
      return false;
    } else if (color.getText().toString().trim().isEmpty()) {
      return false;
    } else if (path.getText().toString().trim().isEmpty()) {
      return false;
    }
    return !name.getText().toString().contains(".xml")
        && !name.getText().toString().contains(".svg");
  }

  protected static Drawable loadSvg(String path) {
    Drawable drawable = null;
    try {
      FileInputStream fileInputStream = new FileInputStream(new File(path));
      SVG svg = SVG.getFromInputStream(fileInputStream);
      drawable = new PictureDrawable(svg.renderToPicture());
    } catch (Exception e) {

      //	Toast.makeText(getApplicationContext(), e.toString(), 3000).show();
    }
    return drawable;
  }

  protected static void DialogError(Activity activity, String title, Exception exception) {
    new MaterialAlertDialogBuilder(activity)
        .setTitle(title)
        .setMessage(exception.toString())
        .setPositiveButton("Exit", null)
        .show();
  }

  protected static void DialogDone(Activity activity, String title, String exception) {
    new MaterialAlertDialogBuilder(activity)
        .setTitle(title)
        .setMessage(exception)
        .setPositiveButton("ok", null)
        .show();
  }

  public static String getVersion() {
    try {
      PackageInfo info =
          ApplicationLoader.getContext()
              .getPackageManager()
              .getPackageInfo(ApplicationLoader.getContext().getPackageName(), 0);
      String v = info.versionName;
      return v;
    } catch (PackageManager.NameNotFoundException err) {
      return err.toString();
    }
  }

  public interface OnDone {
    void done();
  }

  private static String getWidthSvg(String path) {
    try {
      SVG svg = SVG.getFromInputStream(new FileInputStream(new File(path)));
      if (svg.getDocumentWidth() == -1) {
        return String.valueOf((long) Math.ceil(svg.getDocumentWidth()));
      }
    } catch (Exception err) {

    }
    return "32";
  }

  private static String getHeightSvg(String path) {
    try {
      SVG svg = SVG.getFromInputStream(new FileInputStream(new File(path)));
      if (svg.getDocumentHeight() == -1) {
        return String.valueOf((long) Math.ceil(svg.getDocumentHeight()));
      }
    } catch (Exception err) {

    }
    return "32";
  }
}
