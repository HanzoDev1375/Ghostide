package Ninja.coder.Ghostemane.code.filehelper;

import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.activities.BaseCompat;
import Ninja.coder.Ghostemane.code.adapter.ProjectManagerAdapter;
import Ninja.coder.Ghostemane.code.model.ProjectModel;
import Ninja.coder.Ghostemane.code.utils.FileUtil;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class FactoryModelProject implements ProjectManagerAdapter.OnProjectClick {
    protected List<ProjectModel> itemModel = new ArrayList<>();
    protected ProjectManagerAdapter adaptor;
    protected JavaModule javaModule;
    protected String folder;
    protected ProjectCallBack call;
    private BaseCompat baseCompat;
    private RecyclerView rv;
    private AlertDialog dialogMain;

    public FactoryModelProject(BaseCompat baseCompat, String folder, ProjectCallBack call) {
        this.baseCompat = baseCompat;
        itemModel.add(new ProjectModel("html", R.drawable.htmlfile, true));
        itemModel.add(new ProjectModel("node js", R.drawable.js01, false));
        itemModel.add(new ProjectModel("cpp", R.drawable.cppfile, false));
        itemModel.add(new ProjectModel("java", R.drawable.javanull, false));
        bind();
        this.folder = folder;
        this.call = call;
        javaModule = new JavaModule();
    }

    protected void bind() {

        rv = new RecyclerView(baseCompat);
        ViewGroup.LayoutParams param =
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rv.setPadding(8, 8, 8, 8);
        rv.setLayoutParams(param);

        adaptor = new ProjectManagerAdapter(itemModel, this);
        rv.setAdapter(adaptor);
        rv.setLayoutManager(new GridLayoutManager(baseCompat, 2));
        dialogMain =
                new MaterialAlertDialogBuilder(baseCompat)
                        .setTitle("Project manager")
                        .setNegativeButton(android.R.string.cancel, null)
                        .setView(rv)
                        .create();
        dialogMain.show();
    }

    @Override
    public void onClick(View view, int pos) {
        switch (pos) {
            case 0:
                makeHtmlProject();
                break;

            case 1:
                makeNodeJsProject();
                break;
            case 2:
                makeCppProject();
                break;
            case 3: {
                makeJavaProject();
                dialogMain.dismiss();
                break;
            }
        }
    }

    protected void makeJavaProject() {
        AlertDialog dialog =
                new MaterialAlertDialogBuilder(baseCompat)
                        .setTitle("Make java Project")
                        .setView(R.layout.project_layout_factory)
                        .setPositiveButton(android.R.string.ok, null)
                        .create();
        dialog.setOnShowListener(
                __ -> {
                    TextInputLayout projectName = dialog.findViewById(R.id.input_projectName);
                    TextInputLayout packageName = dialog.findViewById(R.id.input_packagename);
                    var btn = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
                    var shap = new ShapeAppearanceModel.Builder();
                    shap.setAllCorners(CornerFamily.CUT, 20f);
                    packageName.setShapeAppearanceModel(shap.build());
                    projectName.setShapeAppearanceModel(shap.build());
                    packageName
                            .getEditText()
                            .addTextChangedListener(
                                    new TextWatcher() {

                                        @Override
                                        public void afterTextChanged(Editable arg0) {
                                        }

                                        @Override
                                        public void beforeTextChanged(
                                                CharSequence arg0, int arg1, int arg2, int arg3) {
                                        }

                                        @Override
                                        public void onTextChanged(CharSequence s, int arg1, int arg2, int arg3) {
                                            var regex = "^[a-z][a-z0-9_]*(\\.[a-z][a-z0-9_]*)*$";
                                            btn.setEnabled(!s.toString().matches(regex) ? false : true);
                                        }
                                    });
                    btn.setOnClickListener(
                            c -> {
                                FileUtil.makeDir(folder + projectName.getEditText().getText().toString());
                                javaModule.makeModuleClass(
                                        "Main", packageName.getEditText().getText().toString(), folder);
                                dialog.dismiss();
                                call.refrash();
                            });
                });
        dialog.show();
    }

    public void makeHtmlProject() {
    }

    public void makeNodeJsProject() {
    }

    public void makeCppProject() {
    }

    public interface ProjectCallBack {
        public void refrash();
    }
}
