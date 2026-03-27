package ir.ninjacoder.ghostide.core.tasks;

import android.view.View;
import android.widget.ImageView;
import com.google.android.material.color.MaterialColors;
import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.activities.CodeEditorActivity;
import ir.ninjacoder.ghostide.core.config.IconRes;
import ir.ninjacoder.ghostide.core.marco.binder.bindchilder.GhostToast;
import ir.ninjacoder.ghostide.core.utils.FileUtil;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;
import ir.ninjacoder.prograsssheet.filemanagerwindows.FileHandlerModel;
import ir.ninjacoder.prograsssheet.filemanagerwindows.FileModel;
import ir.ninjacoder.prograsssheet.filemanagerwindows.FileModelImpl;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskItemCodeEditor {

  private static String currentDir;

  public static void bind(CodeEditorActivity activity, String dir, View v) {
    currentDir = dir;
    File file = new File(dir);
    if (file.isDirectory()) {
      var is = FileModelImpl.getIns();
      is.setContext(activity);
      is.setBindPopWindows(
          file.getAbsolutePath(),
          v,
          new FileHandlerModel() {
            @Override
            public void onFileClickHanlder(int pos, FileModel model, View v) {
              List<FileModel> listAll = is.getFileModel();
              var pathModel = model.getPath();
              // listAll.get(pos).getPath();
              if (FileUtil.isDirectory(pathModel)) {
                currentDir = pathModel;
                is.setPath(currentDir);
                return;
              }
              Set<String> codeEditorExtensions =
                  new HashSet<>(
                      Arrays.asList(
                          ".txt",
                          ".log",
                          ".java",
                          ".kt",
                          ".kotlin",
                          ".scala",
                          ".cpp",
                          ".cc",
                          ".cxx",
                          ".c++",
                          ".h",
                          ".hpp",
                          ".hxx",
                          ".hh",
                          ".inl",
                          ".tcc",
                          ".ipp",
                          ".c",
                          ".cs",
                          ".go",
                          ".rs",
                          ".zig",
                          ".frag",
                          ".py",
                          ".py3",
                          ".pyw",
                          ".pyi",
                          ".js",
                          ".mjs",
                          ".cjs",
                          ".jsx",
                          ".ts",
                          ".tsx",
                          ".php",
                          ".rb",
                          ".rbw",
                          ".lua",
                          ".swift",
                          ".dart",
                          ".r",
                          ".jl",
                          ".html",
                          ".htm",
                          ".xhtml",
                          ".shtml",
                          ".shtm",
                          ".css",
                          ".scss",
                          ".sass",
                          ".less",
                          ".json",
                          ".xml",
                          ".yaml",
                          ".yml",
                          ".toml",
                          ".ini",
                          ".cfg",
                          ".conf",
                          ".properties",
                          ".gradle",
                          ".gradle.kts",
                          ".groovy",
                          ".g4",
                          ".jj",
                          ".smali",
                          ".class",
                          ".dex",
                          ".ninja",
                          ".mk",
                          ".cmake",
                          ".md",
                          ".markdown",
                          ".rst",
                          ".adoc",
                          ".sh",
                          ".bash",
                          ".zsh",
                          ".fish",
                          ".ps1",
                          ".bat",
                          ".cmd",
                          ".ghost",
                          ".svg"));
              String localPath = model.getPath();
              if (codeEditorExtensions.stream().anyMatch(localPath::endsWith)) {
                activity.openFile(model.getPath());
                is.dismiss();
              } else GhostToast.showWarning(v.getContext(), "Extensions not found");
            }

            @Override
            public void onFileIconBind(FileModel model, ImageView ic) {
              if (model != null && model.getPath() != null) {
                ic.setImageResource(IconRes.get(model.getPath()));
              }
            }
          });

      if (is != null) {
        is.setColor(MaterialColors.getColor(activity, ObjectUtils.colorSurface, 0));
        is.setIcon(R.drawable.ic_bookmark_white);

        if (file.isDirectory()) {
          is.setLayoutBack(
              itv -> {
                if (currentDir != null && currentDir.contains("/")) {
                  int lastSlash = currentDir.lastIndexOf("/");
                  if (lastSlash > 0) {
                    currentDir = currentDir.substring(0, lastSlash);
                    is.setPath(currentDir);
                    is.update();
                  } else {
                    is.dismiss();
                  }
                } else {
                  is.dismiss();
                }
              });
        }
      }
    }
  }
}
