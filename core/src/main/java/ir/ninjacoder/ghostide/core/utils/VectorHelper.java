package ir.ninjacoder.ghostide.core.utils;

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
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import ir.ninjacoder.ghostide.core.GhostIdeAppLoader;
import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.glidecompat.GlideCompat;
import ir.ninjacoder.ghostide.core.widget.GhostWebMaterialDialog;

public class VectorHelper {
  public static String iconPath = "";
  public static String projectResourceDirectory = "";

  @RequiresApi(api = Build.VERSION_CODES.O)
  public static void v(Activity context, OnDone db) {
    GhostWebMaterialDialog builder = new GhostWebMaterialDialog(context);
    View inflate = context.getLayoutInflater().inflate(R.layout.create_vector_dialog, null);
     
    // Initialize UI components
    TextInputEditText name = inflate.findViewById(R.id.name);
    TextInputEditText height = inflate.findViewById(R.id.height);
    TextInputEditText width = inflate.findViewById(R.id.width);
    TextInputEditText color = inflate.findViewById(R.id.color);
    TextInputEditText path = inflate.findViewById(R.id.path);
    MaterialSwitch sw = inflate.findViewById(R.id.sw_color);
    ImageView icon = inflate.findViewById(R.id.icon);
    LinearLayout round = inflate.findViewById(R.id.round);

    // Setup UI
    round.setBackgroundColor(0xffFFDCBD);
    path.setEnabled(true);
    path.setText(projectResourceDirectory);

    TextInputLayout textinput4 = (TextInputLayout) ((View) color.getParent()).getParent();
    textinput4.setEndIconDrawable(R.drawable.mcolor1375);
    textinput4.setEndIconVisible(true);

    Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
    textinput4.setAnimation(animation);
    textinput4.setEndIconTintList(
        ColorStateList.valueOf(Color.parseColor(color.getText().toString())));

    textinput4.setEndIconOnClickListener(
        v -> {
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
                  .setOnColorSelectedListener(selectedColor -> {})
                  .setPositiveButton(
                      "ok",
                      (dialog, selectedColor, allcolor) -> {
                        String hexColor = String.format("#%06X", (0xFFFFFF & selectedColor));
                        color.setText(hexColor);
                        round.setBackgroundColor(selectedColor);
                        textinput4.setEndIconTintList(ColorStateList.valueOf(selectedColor));
                        ObjectUtils.setColorFilter(icon, selectedColor);
                      })
                  .setNegativeButton("cancel", (d, c) -> {})
                  .build()
                  .show();
            } catch (Exception e) {
              DialogError(context, "Error", e);
            }
          }
        });

    sw.setChecked(false);
    sw.setText("Color Filter");
    sw.setOnCheckedChangeListener(
        (btn, is) -> {
          if (is) {
            ObjectUtils.setColorFilter(icon, Color.parseColor(color.getText().toString()));
          } else {
            icon.setColorFilter(0);
          }
        });

    // Set initial values
    width.setText(getWidthSvg(iconPath));
    height.setText(getHeightSvg(iconPath));

    if (iconPath.contains(".svg")) {
      name.setText(new File(iconPath).getName().replace(".svg", ""));
    } else if (iconPath.contains(".xml")) {
      name.setText(new File(iconPath).getName().replace(".xml", ""));
    }

    // Load SVG preview
    GlideCompat.LoadSvg(iconPath, icon);
    icon.setImageDrawable(loadSvg(iconPath));

    // Set click listeners
    builder.setView(inflate);
    builder.setPositiveButton(
        "convert",
        (d, w) -> {
          if (validate(name, height, width, color, path)) {
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
          } else {
            Toast.makeText(context, "Invalid input values", Toast.LENGTH_SHORT).show();
          }
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

    try {
      File svgFile = new File(source);
      if (!svgFile.exists()) {
        Toast.makeText(context, "SVG file not found", Toast.LENGTH_SHORT).show();
        return;
      }

      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse(svgFile);

      StringBuilder vectorContent = new StringBuilder();
      vectorContent
          .append("<!--Convert By Ghostweb ide version ")
          .append(getVersion())
          .append(" -->\n\n")
          .append("<vector xmlns:android=\"http://schemas.android.com/apk/res/android\"\n")
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

      // Process root element and its children
      Element root = document.getDocumentElement();
      processSvgElement(root, vectorContent, 1);

      vectorContent.append("</vector>\n");

      // Write to file
      Files.write(
          Paths.get(destination, name + ".xml"),
          vectorContent.toString().getBytes(StandardCharsets.UTF_8),
          StandardOpenOption.CREATE,
          StandardOpenOption.TRUNCATE_EXISTING);
    } catch (Exception e) {
      DialogError(context, "Conversion Error", e);
    }
  }

  private static void processSvgElement(
      Element element, StringBuilder vectorContent, int indentLevel) {
    String tagName = element.getTagName().toLowerCase();
    String indent = "  ".repeat(indentLevel);

    switch (tagName) {
      case "g":
        processGroupElement(element, vectorContent, indentLevel, indent);
        break;
      case "path":
        processPathElement(element, vectorContent, indentLevel, indent);
        break;
      case "rect":
        processRectElement(element, vectorContent, indentLevel, indent);
        break;
      case "circle":
        processCircleElement(element, vectorContent, indentLevel, indent);
        break;
      case "ellipse":
        processEllipseElement(element, vectorContent, indentLevel, indent);
        break;
      case "line":
        processLineElement(element, vectorContent, indentLevel, indent);
        break;
      case "polygon":
        processPolygonElement(element, vectorContent, indentLevel, indent);
        break;
      case "polyline":
        processPolylineElement(element, vectorContent, indentLevel, indent);
        break;
      default:
        // Process children for unknown elements
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
          Node child = children.item(i);
          if (child.getNodeType() == Node.ELEMENT_NODE) {
            processSvgElement((Element) child, vectorContent, indentLevel);
          }
        }
        break;
    }
  }

  private static void processGroupElement(
      Element element, StringBuilder vectorContent, int indentLevel, String indent) {
    vectorContent.append(indent).append("<group\n");

    // Process attributes
    NamedNodeMap attrs = element.getAttributes();
    for (int i = 0; i < attrs.getLength(); i++) {
      Node attr = attrs.item(i);
      String androidAttr = getAndroidAttributeName(attr.getNodeName());
      if (androidAttr != null) {
        vectorContent
            .append(indent)
            .append("  ")
            .append(androidAttr)
            .append("=\"")
            .append(attr.getNodeValue())
            .append("\"\n");
      }
    }
    vectorContent.append(indent).append(">\n");

    // Process children
    NodeList children = element.getChildNodes();
    for (int i = 0; i < children.getLength(); i++) {
      Node child = children.item(i);
      if (child.getNodeType() == Node.ELEMENT_NODE) {
        processSvgElement((Element) child, vectorContent, indentLevel + 1);
      }
    }

    vectorContent.append(indent).append("</group>\n");
  }

  private static void processPathElement(
      Element element, StringBuilder vectorContent, int indentLevel, String indent) {
    vectorContent.append(indent).append("<path\n");

    // Add path data
    String pathData = element.getAttribute("d");
    if (pathData != null && !pathData.isEmpty()) {
      vectorContent.append(indent).append("  android:pathData=\"").append(pathData).append("\"\n");
    }

    // Process other attributes
    processCommonAttributes(element, vectorContent, indent);

    vectorContent.append(indent).append("/>\n");
  }

  private static void processRectElement(
      Element element, StringBuilder vectorContent, int indentLevel, String indent) {
    vectorContent.append(indent).append("<path\n");

    // Convert rect to path data
    String x = element.getAttribute("x");
    String y = element.getAttribute("y");
    String width = element.getAttribute("width");
    String height = element.getAttribute("height");
    String rx = element.getAttribute("rx");
    String ry = element.getAttribute("ry");

    String pathData;
    if (rx.isEmpty() && ry.isEmpty()) {
      // Simple rectangle without rounded corners
      pathData =
          String.format(
              "M%s,%s H%s V%s H%s Z",
              x,
              y,
              Float.parseFloat(x) + Float.parseFloat(width),
              Float.parseFloat(y) + Float.parseFloat(height),
              x);
    } else {
      // Rounded rectangle
      float cornerRadius = rx.isEmpty() ? Float.parseFloat(ry) : Float.parseFloat(rx);
      pathData =
          String.format(
              "M%s,%s h%s v%s h%s v%s Z",
              Float.parseFloat(x) + cornerRadius,
              y,
              Float.parseFloat(width) - 2 * cornerRadius,
              Float.parseFloat(height),
              -(Float.parseFloat(width) - 2 * cornerRadius),
              -Float.parseFloat(height));
    }

    vectorContent.append(indent).append("  android:pathData=\"").append(pathData).append("\"\n");

    // Process other attributes
    processCommonAttributes(element, vectorContent, indent);

    vectorContent.append(indent).append("/>\n");
  }

  private static void processCircleElement(
      Element element, StringBuilder vectorContent, int indentLevel, String indent) {
    vectorContent.append(indent).append("<path\n");

    // Convert circle to path data
    String cx = element.getAttribute("cx");
    String cy = element.getAttribute("cy");
    String r = element.getAttribute("r");

    String pathData =
        String.format(
            "M%s,%s a%s,%s 0 1,0 %s,0 a%s,%s 0 1,0 -%s,0",
            Float.parseFloat(cx) - Float.parseFloat(r),
            cy,
            r,
            r,
            2 * Float.parseFloat(r),
            r,
            r,
            2 * Float.parseFloat(r));

    vectorContent.append(indent).append("  android:pathData=\"").append(pathData).append("\"\n");

    // Process other attributes
    processCommonAttributes(element, vectorContent, indent);

    vectorContent.append(indent).append("/>\n");
  }

  private static void processEllipseElement(
      Element element, StringBuilder vectorContent, int indentLevel, String indent) {
    vectorContent.append(indent).append("<path\n");

    // Convert ellipse to path data
    String cx = element.getAttribute("cx");
    String cy = element.getAttribute("cy");
    String rx = element.getAttribute("rx");
    String ry = element.getAttribute("ry");

    String pathData =
        String.format(
            "M%s,%s a%s,%s 0 1,0 %s,0 a%s,%s 0 1,0 -%s,0",
            Float.parseFloat(cx) - Float.parseFloat(rx),
            cy,
            rx,
            ry,
            2 * Float.parseFloat(rx),
            rx,
            ry,
            2 * Float.parseFloat(rx));

    vectorContent.append(indent).append("  android:pathData=\"").append(pathData).append("\"\n");

    // Process other attributes
    processCommonAttributes(element, vectorContent, indent);

    vectorContent.append(indent).append("/>\n");
  }

  private static void processLineElement(
      Element element, StringBuilder vectorContent, int indentLevel, String indent) {
    vectorContent.append(indent).append("<path\n");

    // Convert line to path data
    String x1 = element.getAttribute("x1");
    String y1 = element.getAttribute("y1");
    String x2 = element.getAttribute("x2");
    String y2 = element.getAttribute("y2");

    String pathData = String.format("M%s,%s L%s,%s", x1, y1, x2, y2);

    vectorContent.append(indent).append("  android:pathData=\"").append(pathData).append("\"\n");

    // Process other attributes
    processCommonAttributes(element, vectorContent, indent);

    vectorContent.append(indent).append("/>\n");
  }

  private static void processPolygonElement(
      Element element, StringBuilder vectorContent, int indentLevel, String indent) {
    vectorContent.append(indent).append("<path\n");

    // Convert polygon to path data
    String points = element.getAttribute("points");
    String pathData = "M" + points + " Z";

    vectorContent.append(indent).append("  android:pathData=\"").append(pathData).append("\"\n");

    // Process other attributes
    processCommonAttributes(element, vectorContent, indent);

    vectorContent.append(indent).append("/>\n");
  }

  private static void processPolylineElement(
      Element element, StringBuilder vectorContent, int indentLevel, String indent) {
    vectorContent.append(indent).append("<path\n");

    // Convert polyline to path data
    String points = element.getAttribute("points");
    String pathData = "M" + points;

    vectorContent.append(indent).append("  android:pathData=\"").append(pathData).append("\"\n");

    // Process other attributes
    processCommonAttributes(element, vectorContent, indent);

    vectorContent.append(indent).append("/>\n");
  }

  private static void processCommonAttributes(
      Element element, StringBuilder vectorContent, String indent) {
    NamedNodeMap attrs = element.getAttributes();
    for (int i = 0; i < attrs.getLength(); i++) {
      Node attr = attrs.item(i);
      String attrName = attr.getNodeName();
      if (!attrName.equals("d")
          && !attrName.equals("points")
          && !attrName.equals("x")
          && !attrName.equals("y")
          && !attrName.equals("width")
          && !attrName.equals("height")
          && !attrName.equals("cx")
          && !attrName.equals("cy")
          && !attrName.equals("r")
          && !attrName.equals("rx")
          && !attrName.equals("ry")
          && !attrName.equals("x1")
          && !attrName.equals("y1")
          && !attrName.equals("x2")
          && !attrName.equals("y2")) {

        String androidAttr = getAndroidAttributeName(attrName);
        if (androidAttr != null) {
          vectorContent
              .append(indent)
              .append("  ")
              .append(androidAttr)
              .append("=\"")
              .append(attr.getNodeValue())
              .append("\"\n");
        }
      }
    }
  }

  // ... (بقیه متدهای کمکی مانند validate(), loadSvg(), DialogError(), DialogDone() ...)
  protected static boolean validate(
      EditText name, EditText height, EditText width, EditText color, EditText path) {
    if (name.getText().toString().trim().isEmpty()
        || name.getText().toString().contains(".xml")
        || name.getText().toString().contains(".svg")) {
      return false;
    }
    if (height.getText().toString().trim().isEmpty()) return false;
    if (width.getText().toString().trim().isEmpty()) return false;
    if (color.getText().toString().trim().isEmpty()) return false;
    return !path.getText().toString().trim().isEmpty();
  }

  protected static Drawable loadSvg(String path) {
    try {
      SVG svg = SVG.getFromInputStream(new FileInputStream(path));
      return new PictureDrawable(svg.renderToPicture());
    } catch (Exception e) {
      return null;
    }
  }

  protected static void DialogError(Activity activity, String title, Exception exception) {
    new MaterialAlertDialogBuilder(activity)
        .setTitle(title)
        .setMessage(exception.toString())
        .setPositiveButton("Exit", null)
        .show();
  }

  protected static void DialogDone(Activity activity, String title, String message) {
    new MaterialAlertDialogBuilder(activity)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton("OK", null)
        .show();
  }

  public static String getVersion() {
    try {
      PackageInfo info =
          GhostIdeAppLoader.getContext()
              .getPackageManager()
              .getPackageInfo(GhostIdeAppLoader.getContext().getPackageName(), 0);
      return info.versionName;
    } catch (PackageManager.NameNotFoundException err) {
      return "Unknown";
    }
  }

  private static String getWidthSvg(String path) {
    try {
      SVG svg = SVG.getFromInputStream(new FileInputStream(path));
      return svg.getDocumentWidth() != -1 ? String.valueOf((int) svg.getDocumentWidth()) : "32";
    } catch (Exception e) {
      return "32";
    }
  }

  private static String getHeightSvg(String path) {
    try {
      SVG svg = SVG.getFromInputStream(new FileInputStream(path));
      return svg.getDocumentHeight() != -1 ? String.valueOf((int) svg.getDocumentHeight()) : "32";
    } catch (Exception e) {
      return "32";
    }
  }

  private static String getAndroidAttributeName(String svgAttributeName) {
    switch (svgAttributeName) {
      case "fill":
        return "android:fillColor";
      case "stroke":
        return "android:strokeColor";
      case "stroke-width":
        return "android:strokeWidth";
      case "stroke-linecap":
        return "android:strokeLineCap";
      case "stroke-linejoin":
        return "android:strokeLineJoin";
      case "stroke-opacity":
        return "android:strokeAlpha";
      case "fill-opacity":
        return "android:fillAlpha";
      case "transform":
        return "android:transform";
      case "fill-rule":
        return "android:fillType";
      case "stroke-miterlimit":
        return "android:strokeMiterLimit";
      case "vector-effect":
        return "android:strokeLineJoin"; // Non-scaling stroke
      case "opacity":
        return "android:alpha";
      default:
        return null;
    }
  }

  public interface OnDone {
    void done();
  }
}
