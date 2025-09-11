package ir.ninjacoder.ghostide.project;

import android.text.TextWatcher;
import ir.ninjacoder.ghostide.R;
import ir.ninjacoder.ghostide.compressor.SvgToPng;
import ir.ninjacoder.ghostide.databinding.LayoutSvgSizeFiledirBinding;
import ir.ninjacoder.ghostide.databinding.ProjectsBinding;
import ir.ninjacoder.ghostide.tasks.AsyncTaskCompat;
import ir.ninjacoder.ghostide.tasks.app.ProgressDialogCompat;
import ir.ninjacoder.ghostide.utils.Decompress;
import ir.ninjacoder.ghostide.utils.SvgShow;
import ir.ninjacoder.ghostide.widget.GhostWebMaterialDialog;
import android.net.Uri;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ListView;
import android.content.res.ColorStateList;
import android.graphics.Color;
import ir.ninjacoder.ghostide.utils.DataUtil;
import ir.ninjacoder.ghostide.utils.FileUtil;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputLayout;
import ir.ninjacoder.prograsssheet.PrograssSheet;
import java.io.File;

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
            .setMessage("type name project and setLibrary ")
            .setCancelable(true)
            .setIcon(R.drawable.web)
            .setPositiveButton("make project", null)
            .setNegativeButton(android.R.string.cancel, null)
            .create();
    dialog.setOnShowListener(
        (var) -> {
          EditText editor = bind.editor;
          MaterialCheckBox ch = bind.ch;
          MaterialCheckBox ch2 = bind.ch2;
          MaterialCheckBox ch3 = bind.ch3;
          MaterialCheckBox ch4 = bind.ch4;
          TextInputLayout te = bind.te;

          HorizontalScrollView hs = bind.hs;

          Button positive = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
          if (editor.getText().toString().isEmpty()) {
            positive.setEnabled(false);
            te.setEndIconVisible(false);
          } else {
            positive.setEnabled(true);
            te.setEndIconVisible(true);
          }
          editor.addTextChangedListener(
              new TextWatcher() {
                @Override
                public void onTextChanged(
                    CharSequence _param1, int _param2, int _param3, int _param4) {
                  final String _charSeq = _param1.toString();

                  if (editor.getText().toString().isEmpty()) {
                    positive.setEnabled(false);
                    te.setEndIconVisible(false);
                  } else {
                    te.setEndIconVisible(true);
                    positive.setEnabled(true);
                  }
                }

                @Override
                public void beforeTextChanged(
                    CharSequence _param1, int _param2, int _param3, int _param4) {}

                @Override
                public void afterTextChanged(android.text.Editable _param1) {}
              });
          hs.setHorizontalScrollBarEnabled(false);
          hs.setVerticalScrollBarEnabled(false);
          hs.setOverScrollMode(ListView.OVER_SCROLL_NEVER);
          te.setEndIconDrawable(R.drawable.closehsi);
          te.setEndIconVisible(false);
          te.setEndIconOnClickListener(
              v -> {
                editor.setText("");
              });
          positive.setOnClickListener(
              (vftrororocjj) -> {
                dialog.dismiss();
                DataUtil.hideKeyboard(context);
                if (editor.getText().toString().isEmpty()) {
                  DataUtil.showMessage(context, "Enter Name project");
                } else {
                  if (ch.isChecked() || (ch2.isChecked() || (ch3.isChecked() || ch4.isChecked()))) {
                    FileUtil.makeDir(projectPath.concat("/".concat(editor.getText().toString())));
                    setDialogUnZipLibrary(
                        "project.zip", projectPath.concat("/".concat(editor.getText().toString())));
                    // reLoadFile();
                    if (work instanceof OnDoneWork) {
                      work.done();
                    }
                  } else {
                    FileUtil.makeDir(projectPath.concat("/"));
                    setDialogUnZipLibrary("project.zip", projectPath);
                    // reLoadFile();
                    if (work instanceof OnDoneWork) {
                      work.done();
                    }
                  }
                  var handler = new Handler();
                  handler.postDelayed(
                      () -> {
                        if (ch.isChecked()) {
                          setDialogUnZipLibrary(
                              "bootstrap5.2.2.zip",
                              projectPath.concat("/".concat(editor.getText().toString())));
                          // reLoadFile();
                          if (work instanceof OnDoneWork) {
                            work.done();
                          }
                        }
                        if (ch2.isChecked()) {
                          setDialogUnZipLibrary(
                              "kotlin1.7.20.zip",
                              projectPath.concat("/".concat(editor.getText().toString())));
                          // reLoadFile();
                          if (work instanceof OnDoneWork) {
                            work.done();
                          }
                        }
                        if (ch3.isChecked()) {
                          setDialogUnZipLibrary(
                              "typescript4.8.4.zip",
                              projectPath.concat("/".concat(editor.getText().toString())));
                          // reLoadFile();
                          if (work instanceof OnDoneWork) {
                            work.done();
                          }
                        }
                        if (ch4.isChecked()) {
                          setDialogUnZipLibrary(
                              "angular9.1.13.zip",
                              projectPath.concat("/".concat(editor.getText().toString())));
                          // reLoadFile();
                          if (work instanceof OnDoneWork) {
                            work.done();
                          }
                        }
                      },
                      1000);
                }
              });
        });

    dialog.show();
  }

  public void setDialogUnZipLibrary(String _getInput, String _getOutput) {
    new AsyncTaskCompat<String, String, String>() {
      @Override
      protected void onPreExecute() {
        unzip = new PrograssSheet(context);
        unzip.setTitle  ("installLibrary");
        unzip.show();
      }

      @Override
      protected String doInBackground(String... params) {

        Decompress.unzipFromAssets(context, _getInput, _getOutput);
        return "";
      }

      @Override
      protected void onPostExecute(String _result) {
        unzip.dismiss();
      }
    }.execute("");
  }

  public void setSvgToPngConvert(final String _svg, final String _pngss) {
    LayoutSvgSizeFiledirBinding bind =
        LayoutSvgSizeFiledirBinding.inflate(LayoutInflater.from(context));
    AlertDialog dialog =
        new GhostWebMaterialDialog(context)
            .setView(bind.getRoot())
            .setTitle("Svg to Png")
            .setCancelable(true)
            .setPositiveButton("convert", null)
            .setNegativeButton(android.R.string.cancel, null)
            .create();
    dialog.setOnShowListener(
        (var) -> {
          Button positive = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
          EditText mwidth = bind.mwidth;
          EditText mheight = bind.mheight;
          EditText lastpng = bind.lastpng;
          EditText lastsvg = bind.lastsvg;
          ImageView img = bind.img;
          SvgShow.GetFileSvg(_svg, img, context);
          lastsvg.setText(Uri.parse(_svg).getLastPathSegment());
          lastpng.setText(Uri.parse(_svg.replace(".svg", ".png")).getLastPathSegment());
          positive.setOnClickListener(
              (vftrororocjj) -> {
                SvgToPng png =
                    new SvgToPng(
                        context,
                        new File(_svg),
                        new File(_pngss),
                        new SvgToPng.OnConversionListener() {
                          @Override
                          public void onConversionSuccess() {
                            if (work instanceof OnDoneWork) {
                              work.done();
                            }
                          }

                          @Override
                          public void onConversionError(String error) {
                            throw new RuntimeException(error);
                          }
                        });
                png.setHeight(Float.parseFloat(mwidth.getText().toString()));
                png.setWidth(Float.parseFloat(mwidth.getText().toString()));
                png.execute();

                dialog.dismiss();
              });
        });
    dialog.show();
  }

  public interface OnDoneWork {
    void done();
  }
}
