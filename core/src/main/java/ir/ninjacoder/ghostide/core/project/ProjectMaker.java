package ir.ninjacoder.ghostide.core.project;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputLayout;
import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.compressor.SvgToPng;
import ir.ninjacoder.ghostide.core.databinding.LayoutSvgSizeFiledirBinding;
import ir.ninjacoder.ghostide.core.databinding.ProjectsBinding;
import ir.ninjacoder.ghostide.core.utils.DataUtil;
import ir.ninjacoder.ghostide.core.utils.Decompress;
import ir.ninjacoder.ghostide.core.utils.FileUtil;
import ir.ninjacoder.ghostide.core.utils.SvgShow;
import ir.ninjacoder.ghostide.core.widget.GhostWebMaterialDialog;
import ir.ninjacoder.prograsssheet.PrograssSheet;
import ir.ninjacoder.prograsssheet.enums.StateMod;
import ir.ninjacoder.prograsssheet.fileinfo.CoroutineManager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProjectMaker {

  public String projectPath;
  private Context context;
  private PrograssSheet unzip;
  private OnDoneWork work;

  public ProjectMaker(String projectPath, Context context, OnDoneWork work) {
    this.projectPath = projectPath;
    this.work = work;
    this.context = context;
  }

  public void setMakeHtmlProject() {
    ProjectsBinding bind = ProjectsBinding.inflate(LayoutInflater.from(context));
    AlertDialog dialog =
        new GhostWebMaterialDialog(context)
            .setView(bind.getRoot())
            .setTitle("Make project")
            .setMessage("Type project name and select libraries")
            .setCancelable(true)
            .setIcon(R.drawable.web)
            .setPositiveButton("Make project", null)
            .setNegativeButton(android.R.string.cancel, null)
            .create();

    dialog.setOnShowListener(
        var -> {
          EditText editor = bind.editor;
          MaterialCheckBox chBootstrap = bind.ch;
          MaterialCheckBox chKotlin = bind.ch2;
          MaterialCheckBox chTypeScript = bind.ch3;
          MaterialCheckBox chAngular = bind.ch4;
          TextInputLayout te = bind.te;
          HorizontalScrollView hs = bind.hs;
          Button positive = dialog.getButton(DialogInterface.BUTTON_POSITIVE);

          positive.setEnabled(false);
          te.setEndIconVisible(false);
          hs.setHorizontalScrollBarEnabled(false);
          hs.setVerticalScrollBarEnabled(false);
          hs.setOverScrollMode(ListView.OVER_SCROLL_NEVER);
          te.setEndIconDrawable(R.drawable.closehsi);
          te.setEndIconOnClickListener(v -> editor.setText(""));

          editor.addTextChangedListener(
              new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                  boolean hasText = !s.toString().trim().isEmpty();
                  positive.setEnabled(hasText);
                  te.setEndIconVisible(hasText);
                }

                @Override
                public void afterTextChanged(Editable s) {}
              });

          positive.setOnClickListener(
              v -> {
                String projectName = editor.getText().toString().trim();
                if (projectName.isEmpty()) {
                  DataUtil.showMessage(context, "Enter project name");
                  return;
                }
                dialog.dismiss();
                DataUtil.hideKeyboard(context);

                List<String> selectedLibs = new ArrayList<>();
                if (chBootstrap.isChecked()) selectedLibs.add("bootstrap5.2.2.zip");
                if (chKotlin.isChecked()) selectedLibs.add("kotlin1.7.20.zip");
                if (chTypeScript.isChecked()) selectedLibs.add("typescript4.8.4.zip");
                if (chAngular.isChecked()) selectedLibs.add("angular9.1.13.zip");

                startExtraction(projectName, selectedLibs);
              });
        });
    dialog.show();
  }

  private void startExtraction(String projectName, List<String> libraries) {
    String projectFullPath = projectPath + "/" + projectName;
    FileUtil.makeDir(projectFullPath);

    unzip = new PrograssSheet(context);
    unzip.setMode(StateMod.PROGRASSV);
    unzip.setTitle("Creating Project");
    unzip.setSubTitle("Extracting base project...");
    unzip.setCancelable(false);
    unzip.show();

    CoroutineManager.runOnIO(
        () -> {
          boolean baseSuccess = extractFromAssets("project.zip", projectFullPath);
          if (!baseSuccess) {
            CoroutineManager.runOnMain(
                () -> {
                  unzip.dismiss();
                  DataUtil.showMessage(context, "Failed to extract base project!");
                });
            return;
          }

          int totalLibs = libraries.size();
          int[] currentLib = {0};

          for (String lib : libraries) {
            currentLib[0]++;
            int progress = (currentLib[0] * 100) / totalLibs;
            String libName = lib.replace(".zip", "");

            CoroutineManager.runOnMain(
                () -> {
                  unzip.setPrograss(progress, true);
                  unzip.setSubTitle("Extracting " + libName + "...");
                });

            extractFromAssets(lib, projectFullPath);
          }

          CoroutineManager.runOnMain(
              () -> {
                unzip.dismiss();
                DataUtil.showMessage(context, "Project created successfully!");
                if (work != null) work.done();
              });
        });
  }

  private boolean extractFromAssets(String assetFileName, String outputPath) {
    try {
      String[] assets = context.getAssets().list("");
      boolean assetExists = false;
      for (String asset : assets) {
        if (asset.equals(assetFileName)) {
          assetExists = true;
          break;
        }
      }
      if (!assetExists) {
        createEmptyProject(outputPath);
        return true;
      }
      Decompress.unzipFromAssets(context, assetFileName, outputPath);
      return true;
    } catch (IOException e) {
      createEmptyProject(outputPath);
      return false;
    }
  }

  private void createEmptyProject(String projectPath) {
    String indexHtml =
        "<!DOCTYPE html>\n"
            + "<html lang=\"en\">\n"
            + "<head>\n"
            + "  <meta charset=\"UTF-8\">\n"
            + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
            + "  <title>My Project</title>\n"
            + "  <link rel=\"stylesheet\" href=\"css/style.css\">\n"
            + "</head>\n"
            + "<body>\n"
            + "  <h1>Hello, World!</h1>\n"
            + "  <script src=\"js/script.js\"></script>\n"
            + "</body>\n"
            + "</html>";
    FileUtil.writeFile(projectPath + "/index.html", indexHtml);

    FileUtil.makeDir(projectPath + "/css");
    FileUtil.makeDir(projectPath + "/js");
    FileUtil.makeDir(projectPath + "/images");

    String styleCss =
        "body {\n"
            + "  font-family: Arial, sans-serif;\n"
            + "  margin: 20px;\n"
            + "  background-color: #f5f5f5;\n"
            + "}\n"
            + "h1 {\n"
            + "  color: #333;\n"
            + "}";
    FileUtil.writeFile(projectPath + "/css/style.css", styleCss);

    String scriptJs =
        "document.addEventListener('DOMContentLoaded', function() {\n"
            + "  console.log('Project loaded!');\n"
            + "});";
    FileUtil.writeFile(projectPath + "/js/script.js", scriptJs);

    String readme =
        "# My Project\n\n"
            + "Created with Ghost IDE.\n\n"
            + "## Structure\n"
            + "```\n"
            + "├── index.html\n"
            + "├── css/\n"
            + "│   └── style.css\n"
            + "├── js/\n"
            + "│   └── script.js\n"
            + "└── images/\n"
            + "```";
    FileUtil.writeFile(projectPath + "/README.md", readme);
  }

  public void setDialogUnZipLibrary(String assetFile, String outputPath) {
    unzip = new PrograssSheet(context);
    unzip.setMode(StateMod.PROGRASSV);
    unzip.setTitle("Extracting...");
    unzip.setSubTitle(assetFile);
    unzip.setCancelable(false);
    unzip.show();

    CoroutineManager.runOnIO(
        () -> Decompress.unzipFromAssets(context, assetFile, outputPath),
        new CoroutineManager.ErrorCallback() {
          @Override
          public void onSuccess() {
            CoroutineManager.runOnMain(
                () -> {
                  unzip.dismiss();
                  if (work != null) work.done();
                });
          }

          @Override
          public void onError(Exception e) {
            CoroutineManager.runOnMain(
                () -> {
                  unzip.dismiss();
                  createEmptyProject(outputPath);
                  DataUtil.showMessage(context, "Extraction failed: " + e.getMessage());
                  if (work != null) work.done();
                });
          }
        });
  }

  public void setSvgToPngConvert(String svgPath, String pngPath) {
    LayoutSvgSizeFiledirBinding bind =
        LayoutSvgSizeFiledirBinding.inflate(LayoutInflater.from(context));
    AlertDialog dialog =
        new GhostWebMaterialDialog(context)
            .setView(bind.getRoot())
            .setTitle("SVG to PNG")
            .setCancelable(true)
            .setPositiveButton("Convert", null)
            .setNegativeButton(android.R.string.cancel, null)
            .create();

    dialog.setOnShowListener(
        var -> {
          Button positive = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
          EditText mwidth = bind.mwidth;
          EditText mheight = bind.mheight;
          EditText lastpng = bind.lastpng;
          EditText lastsvg = bind.lastsvg;
          ImageView img = bind.img;

          SvgShow.GetFileSvg(svgPath, img, context);
          lastsvg.setText(Uri.parse(svgPath).getLastPathSegment());
          lastpng.setText(Uri.parse(pngPath).getLastPathSegment());
          mwidth.setText("256");
          mheight.setText("256");

          positive.setOnClickListener(
              v -> {
                float width, height;
                try {
                  width = Float.parseFloat(mwidth.getText().toString());
                  height = Float.parseFloat(mheight.getText().toString());
                } catch (NumberFormatException e) {
                  DataUtil.showMessage(context, "Invalid dimensions!");
                  return;
                }
                dialog.dismiss();

                SvgToPng png =
                    new SvgToPng(
                        context,
                        new File(svgPath),
                        new File(pngPath),
                        new SvgToPng.OnConversionListener() {
                          @Override
                          public void onConversionSuccess() {
                            CoroutineManager.runOnMain(
                                () ->
                                    Toast.makeText(context, "PNG created!", Toast.LENGTH_SHORT)
                                        .show());
                            if (work != null) work.done();
                          }

                          @Override
                          public void onConversionError(String error) {
                            CoroutineManager.runOnMain(
                                () ->
                                    Toast.makeText(context, "Error: " + error, Toast.LENGTH_SHORT)
                                        .show());
                          }
                        });
                png.setHeight(height);
                png.setWidth(width);
                png.execute();
              });
        });
    dialog.show();
  }

  public interface OnDoneWork {
    void done();
  }
}
