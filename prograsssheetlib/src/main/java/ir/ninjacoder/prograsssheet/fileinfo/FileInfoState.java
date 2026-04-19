package ir.ninjacoder.prograsssheet.fileinfo;

import android.content.Context;
import android.util.Log;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class FileInfoState {
  private List<FileInfoModel> model = new ArrayList<>();

  public void logFileInfo(String filePath, Context context) {
    if (filePath == null || filePath.isEmpty()) {
      Log.e("FileStateInfo", "مسیر فایل مشخص نشده است");
      return;
    }

    File file = new File(filePath);

    if (!file.exists()) {
      Log.e("FileStateInfo", "فایل وجود ندارد: " + filePath);
      return;
    }
    var rv = new RecyclerView(context);
    rv.setLayoutManager(new LinearLayoutManager(context));
    rv.setAdapter(new FileInfoAdapter(model));
    rv.setPadding(9, 9, 9, 9);
    new MaterialAlertDialogBuilder(context)
        .setTitle("File info")
        .setView(rv)
        .setPositiveButton(android.R.string.cancel, null)
        .show();

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault());
    String fileName = file.getName();
    String fileSize = getFormattedFileSize(file.length());
    String fileDate = dateFormat.format(new Date(file.lastModified()));
    String filePathStr = file.getAbsolutePath();
    String fileType = getFileExtension(fileName);
    String permissions = getFilePermissions(file);
    String wrapperType = getWrapperType(file);
    add(fileName, "File Name");
    add(fileSize, "File size");
    add(fileDate, "File date");
    add(filePath, "Dir");
    add(fileType, "File type");
    add(permissions, "Permissions");
    add(wrapperType, "Wrapper");
  }

  private void add(String name, String hint) {
    model.add(new FileInfoModel(name, hint));
  }

  private String getFilePermissions(File file) {
    StringBuilder perms = new StringBuilder();

    if (file.canRead()) {
      perms.append("r");
    } else {
      perms.append("-");
    }

    if (file.canWrite()) {
      perms.append("w");
    } else {
      perms.append("-");
    }

    if (file.canExecute()) {
      perms.append("x");
    } else {
      perms.append("-");
    }

    if (file.isHidden()) {
      perms.append(" (hidden)");
    }

    if (file.isDirectory()) {
      return "d" + perms;
    }

    return "-" + perms;
  }

  private String getWrapperType(File file) {
    if (file.isDirectory()) {
      return "Directory";
    }

    if (file.isFile()) {
      String name = file.getName();
      int lastDot = name.lastIndexOf(".");

      if (lastDot > 0 && lastDot < name.length() - 1) {
        String ext = name.substring(lastDot + 1).toLowerCase();
        switch (ext) {
          case "html":
          case "htm":
          case "xhtml":
            return "HTML File";
          case "css":
          case "scss":
          case "sass":
          case "less":
          case "styl":
          case "stylus":
            return "CSS/Style Sheet";
          case "js":
          case "javascript":
          case "mjs":
          case "cjs":
            return "JavaScript File";
          case "java":
            return "Java file";
          case "ts":
          case "typescript":
            return "TypeScript File";
          case "jsx":
            return "React JSX File";
          case "tsx":
            return "React TSX File";
          case "vue":
            return "Vue.js File";
          case "svelte":
            return "Svelte File";
          case "json":
            return "JSON File";
          case "xml":
          case "xsd":
          case "xslt":
          case "dtd":
            return "XML File";
          case "yaml":
          case "yml":
            return "YAML File";
          case "kt":
          case "kts":
            return "Kotlin File";
          case "py":
          case "py3":
          case "pyw":
            return "Python File";
          case "php":
          case "php3":
          case "php4":
          case "php5":
          case "php7":
          case "php8":
            return "PHP File";
          case "rb":
          case "ruby":
            return "Ruby File";
          case "go":
          case "golang":
            return "Go File";
          case "rs":
            return "Rust File";
          case "c":
            return "C File";
          case "cpp":
          case "cc":
          case "cxx":
          case "c++":
            return "C++ File";
          case "h":
          case "hpp":
          case "hh":
            return "Header File";
          case "cs":
            return "C# File";
          case "swift":
            return "Swift File";
          case "dart":
            return "Dart File";
          case "lua":
            return "Lua File";
          case "pl":
          case "pm":
          case "perl":
            return "Perl File";
          case "ex":
          case "exs":
            return "Elixir File";
          case "erl":
          case "hrl":
            return "Erlang File";
          case "clj":
          case "cljs":
          case "cljc":
            return "Clojure File";
          case "scala":
          case "sc":
            return "Scala File";
          case "groovy":
          case "gvy":
          case "gy":
          case "gsh":
            return "Groovy File";
          case "nim":
            return "Nim File";
          case "cr":
          case "crystal":
            return "Crystal File";
          case "zig":
            return "Zig File";
          case "v":
            return "V Lang File";
          case "odin":
            return "Odin File";
          case "hare":
            return "Hare File";

            // Functional & Scripting
          case "hs":
          case "lhs":
            return "Haskell File";
          case "elm":
            return "Elm File";
          case "ghost":
            return "Theme Ghost for in Ghost ide App";
          case "f90":
          case "f95":
          case "f03":
          case "f08":
            return "Fortran File";
          case "r":
          case "rscript":
            return "R File";
          case "jl":
            return "Julia File";
          case "ml":
          case "mli":
            return "OCaml File";
          case "fs":
          case "fsx":
          case "fsi":
            return "F# File";
          case "vbs":
          case "vba":
            return "VBScript File";
          case "ps1":
          case "psm1":
          case "psd1":
            return "PowerShell File";
          case "sh":
          case "bash":
          case "zsh":
          case "fish":
            return "Shell Script";
          case "bat":
          case "cmd":
            return "Batch File";
          case "awk":
            return "AWK Script";
          case "sed":
            return "SED Script";
          case "tcl":
            return "Tcl File";
          case "lisp":
          case "lsp":
          case "cl":
            return "Lisp File";
          case "scm":
          case "ss":
            return "Scheme File";
          case "rkt":
            return "Racket File";
          case "sql":
            return "SQL File";
          case "sqlite":
            return "SQLite File";
          case "mongo":
          case "mongodb":
            return "MongoDB File";
          case "graphql":
          case "gql":
            return "GraphQL File";
          case "prisma":
            return "Prisma Schema";

            // Configuration & Data
          case "toml":
            return "TOML File";
          case "ini":
          case "cfg":
          case "conf":
          case "config":
            return "Config File";
          case "properties":
            return "Properties File";
          case "env":
            return "Env File";
          case "editorconfig":
            return "EditorConfig";
          case "gitignore":
          case "gitattributes":
            return "Git File";
          case "dockerfile":
            return "Dockerfile";
          case "makefile":
          case "mk":
            return "Makefile";
          case "cmake":
            return "CMake File";
          case "gradle":
            return "Gradle File";
          case "csv":
            return "CSV File";
          case "tsv":
            return "TSV File";

            // Markup & Documentation
          case "md":
          case "markdown":
            return "Markdown File";
          case "txt":
          case "text":
            return "Text File";
          case "rst":
            return "reStructuredText";
          case "adoc":
          case "asciidoc":
            return "AsciiDoc File";
          case "tex":
          case "latex":
            return "LaTeX File";
          case "org":
            return "Org Mode File";
          case "wiki":
            return "Wiki File";

            // Images
          case "png":
          case "jpg":
          case "jpeg":
          case "gif":
          case "bmp":
          case "webp":
          case "svg":
          case "ico":
          case "tiff":
          case "tif":
            return "Image File";

            // Videos
          case "mp4":
          case "mkv":
          case "avi":
          case "mov":
          case "flv":
          case "wmv":
          case "webm":
          case "m4v":
          case "3gp":
            return "Video File";

            // Audio
          case "mp3":
          case "wav":
          case "ogg":
          case "flac":
          case "m4a":
          case "aac":
          case "wma":
          case "opus":
            return "Audio File";

            // Archives
          case "zip":
          case "rar":
          case "7z":
          case "tar":
          case "gz":
          case "bz2":
          case "xz":
          case "zst":
            return "Archive File";

            // Executables & Packages
          case "apk":
            return "Android Package";
          case "jar":
            return "Java Archive";
          case "war":
            return "Web Archive";
          case "ear":
            return "Enterprise Archive";
          case "exe":
          case "msi":
            return "Windows Executable";
          case "deb":
          case "rpm":
            return "Linux Package";
          case "dmg":
          case "pkg":
            return "macOS Package";
          case "aab":
            return "Android App Bundle";
          case "ipa":
            return "iOS App Package";

            // Documents
          case "pdf":
            return "PDF Document";
          case "doc":
          case "docx":
            return "Word Document";
          case "xls":
          case "xlsx":
            return "Excel Document";
          case "ppt":
          case "pptx":
            return "PowerPoint Document";
          case "odt":
            return "OpenDocument Text";
          case "ods":
            return "OpenDocument Spreadsheet";
          case "odp":
            return "OpenDocument Presentation";
          case "epub":
            return "eBook File";
          case "mobi":
            return "Mobipocket eBook";

            // Fonts
          case "ttf":
          case "otf":
          case "woff":
          case "woff2":
          case "eot":
            return "Font File";

            // 3D Models
          case "obj":
          case "fbx":
          case "blend":
          case "stl":
          case "gltf":
          case "glb":
            return "3D Model File";

            // Certificates & Keys
          case "pem":
          case "crt":
          case "key":
          case "pub":
          case "cer":
          case "jks":
          case "keystore":
            return "Certificate/Key File";

            // Logs
          case "log":
            return "Log File";
          case "out":
            return "Output File";
          case "err":
            return "Error Log";

          default:
            return "Regular File";
        }
      }

      return "Regular File";
    }

    return "Unknown";
  }

  private String getFormattedFileSize(long size) {
    if (size <= 0) return "0 B";
    String[] units = {"B", "KB", "MB", "GB", "TB"};
    int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
    return String.format(
        Locale.getDefault(), "%.1f %s", size / Math.pow(1024, digitGroups), units[digitGroups]);
  }

  private String getFileExtension(String fileName) {
    int lastDot = fileName.lastIndexOf(".");
    if (lastDot > 0 && lastDot < fileName.length() - 1) {
      return fileName.substring(lastDot + 1);
    }
    return "unknown";
  }

  public List<FileInfoModel> getModel() {
    return this.model;
  }
}
