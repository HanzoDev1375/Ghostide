/**
 * Comment by ghost ide
 *
 * @author: Ninjacoder
 */
package ir.ninjacoder.ghostide.folder;

import android.widget.ImageView;
import android.widget.Toast;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import ir.ninjacoder.ghostide.R;
// افزودن کتابخانه Glide
import com.bumptech.glide.Glide;
import ir.ninjacoder.ghostide.glidecompat.GlideCompat;
import java.io.File;

public class FileIconHelperPath {

  private String filePath;

  private String mimeType;

  // تغییر از int به String برای ذخیره مسیر فایل
  private String fileIconPath;

  private boolean isDynamicFolderEnabled;

  private boolean isEnvironmentEnabled;

  private FileHelper fileHelper;

  private FileEnvironmentHelper fileEnvHelper;

  // ثابت برای مسیر آیکون‌ها
  public static final String ICON_PATH = "/storage/emulated/0/GhostWebIDE/appicon";

  public FileIconHelperPath(String filePath) {
    this.filePath = filePath;
    this.mimeType = "";
    check();
  }

  @Deprecated
  public FileIconHelperPath(String filePath, String mimeType) {
    this.filePath = filePath;
    this.mimeType = mimeType;
    check();
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  @Deprecated
  public String getMimeType() {
    return mimeType;
  }

  @Deprecated
  public void setMimeType(String mimeType) {
    this.mimeType = mimeType;
  }

  public String getFileIconPath() {
    // بازگشت مسیر فایل به جای شناسه آیتم
    return fileIconPath;
  }

  public boolean isDynamicFolderEnabled() {
    return isDynamicFolderEnabled;
  }

  public void setDynamicFolderEnabled(boolean isDynamicFolderEnabled) {
    this.isDynamicFolderEnabled = isDynamicFolderEnabled;
    check();
  }

  public boolean isEnvironmentEnabled() {
    return isEnvironmentEnabled;
  }

  public void setEnvironmentEnabled(boolean isEnvironmentEnabled) {
    this.isEnvironmentEnabled = isEnvironmentEnabled;
    check();
  }

  
  public void bind(ImageView imageView) {
    // بارگذاری تصویر با Glide از مسیر فایل
    Glide.with(imageView.getContext())
        .load(new File(fileIconPath))
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .error(R.drawable.ic_material_folder_log)
        .into(imageView);
  }

  private void check() {
    fileHelper = new FileHelper(filePath);
    fileEnvHelper = new FileEnvironmentHelper(filePath);
    File mfile = new File(filePath);
    if (mfile.isDirectory()) {
      try {
        if (mfile.getName().equals("Android")) {
          fileIconPath = ICON_PATH + "/ic_material_folder_android.png";
        } else {
          fileIconPath = ICON_PATH + "/ic_material_folder.png";
        }
        if (fileEnvHelper.isJavaDirectory())
          fileIconPath = ICON_PATH + "/ic_material_folder_java.png";
        else if (fileEnvHelper.isJavascriptDirectory())
          fileIconPath = ICON_PATH + "/ic_material_folder_javascript.png";
        else if (fileEnvHelper.isPhpDirectory())
          fileIconPath = ICON_PATH + "/ic_material_folder_php.png";
        else if (fileEnvHelper.isCssDirectory())
          fileIconPath = ICON_PATH + "/ic_material_folder_css.png";
        else if (fileEnvHelper.isMarkdownDirectory())
          fileIconPath = ICON_PATH + "/ic_material_folder_markdown.png";
        else if (fileEnvHelper.isLogDirectory())
          fileIconPath = ICON_PATH + "/ic_material_folder_log.png";
        else if (fileEnvHelper.isJsonDirectory())
          fileIconPath = ICON_PATH + "/ic_material_folder_json.png";
        else if (fileEnvHelper.isPythonDirectory())
          fileIconPath = ICON_PATH + "/ic_material_folder_python.png";
        else if (fileEnvHelper.isDownloadDirectory())
          fileIconPath = ICON_PATH + "/ic_material_folder_download.png";
        else if (fileEnvHelper.isDCIMDirectory() || fileEnvHelper.isPicturesDirectory())
          fileIconPath = ICON_PATH + "/ic_material_folder_images.png";
        else if (fileEnvHelper.isNotificationsDirectory())
          fileIconPath = ICON_PATH + "/ic_material_folder_audio.png";
        else if (fileEnvHelper.isMoviesDirectory())
          fileIconPath = ICON_PATH + "/ic_material_folder_video.png";
        else if (fileEnvHelper.isSrcDirectory())
          fileIconPath = ICON_PATH + "/ic_material_folder_src.png";
        else if (fileEnvHelper.isPublicDirectory())
          fileIconPath = ICON_PATH + "/ic_material_folder_public.png";
        else if (fileEnvHelper.isAppDirectory())
          fileIconPath = ICON_PATH + "/ic_material_folder_app.png";
        else if (fileEnvHelper.isIntelliJDirectory())
          fileIconPath = ICON_PATH + "/ic_material_folder_intellij.png";
        else if (fileEnvHelper.isGradleJDirectory())
          fileIconPath = ICON_PATH + "/ic_material_folder_gradle.png";
        else if (fileEnvHelper.isAppIcon())
          fileIconPath = ICON_PATH + "/vector_folder_ghostweb.png";
        else if (fileEnvHelper.isAndroidDirectory())
          fileIconPath = ICON_PATH + "/folder_android.png";
        else if (fileEnvHelper.isSassOrScssDirectory())
          fileIconPath = ICON_PATH + "/folder_sass.png";
        else if (fileEnvHelper.isWebDirectory()) fileIconPath = ICON_PATH + "/folder_views.png";
        else if (fileEnvHelper.isAntlr4Directory())
          fileIconPath = ICON_PATH + "/folder_ansible.png";
        else if (fileEnvHelper.isToolsDirectory()) fileIconPath = ICON_PATH + "/folder_tools.png";
        else if (fileEnvHelper.android().isAndroidDevDirectory())
          fileIconPath = ICON_PATH + "/ic_material_folder_android.png";
        else if (fileEnvHelper.angularjs().isAngularJsDirectory())
          fileIconPath = ICON_PATH + "/ic_material_folder_angular.png";
        else if (fileEnvHelper.vuejs().isVueJsDirectory())
          fileIconPath = ICON_PATH + "/ic_material_folder_vue.png";
        else if (fileEnvHelper.nodejs().isNodeJsDirectory())
          fileIconPath = ICON_PATH + "/ic_material_folder_node.png";
        else if (fileEnvHelper.react().isReactDirectory())
          fileIconPath = ICON_PATH + "/ic_material_folder_react_component.png";
        else if (fileEnvHelper.android().isAndroidDevDirectory())
          fileIconPath = ICON_PATH + "/ic_material_folder_android.png";
        else if (fileEnvHelper.git().isGitDirectory())
          fileIconPath = ICON_PATH + "/ic_material_folder_git.png";
      } catch (Exception err) {
        fileIconPath = ICON_PATH + "/ic_material_folder.png";
      }
    } else {
      setupFileIcons();
    }
  }

  public FileEnvironmentHelper getfileEnvHelper() {
    return fileEnvHelper;
  }

  private void setupFolderIcons() {
    // مسیر پیش‌فرض
    //   if (filePath.equals("")) fileIconPath = ICON_PATH + "/ic_material_folder.png";
    if (isDynamicFolderEnabled) {
      if (isEnvironmentEnabled) {
        if (fileEnvHelper.ghost().isGhostFile()) fileIconPath = ICON_PATH + "/app_icon.png";
        else if (fileEnvHelper.ghost().isAppLego())
          fileIconPath = ICON_PATH + "/vector_folder_ghostweb.png";
      } else {

      }
    } else {
      if (FileUtil.isFileHidden(filePath))
        fileIconPath = ICON_PATH + "/ic_material_folder_secure.png";
      else fileIconPath = ICON_PATH + "/ic_material_folder.png";
    }
  }

  private void setupFileIcons() {
    // مسیر پیش‌فرض
    fileIconPath = ICON_PATH + "/ic_material_document.png";
    if (fileHelper.isCompressFiles()) fileIconPath = ICON_PATH + "/ic_material_zip.png";
    else if (fileHelper.isBitmapFiles()) fileIconPath = ICON_PATH + "/ic_material_image.png";
    else if (fileHelper.isFontFiles()) fileIconPath = ICON_PATH + "/ic_material_font.png";
    else if (fileHelper.isMicrosoftWordFiles()) fileIconPath = ICON_PATH + "/ic_material_word.png";
    else if (fileHelper.isGradleFiles()) fileIconPath = ICON_PATH + "/ic_material_gradle.png";
    else if (fileHelper.isYarnFiles()) fileIconPath = ICON_PATH + "/ic_material_yarn.png";
    else if (fileHelper.isTestJsFiles()) fileIconPath = ICON_PATH + "/ic_material_test_js.png";
    else if (fileHelper.isMinecraftRelatedFiles())
      fileIconPath = ICON_PATH + "/ic_material_minecraft.png";
    else if (is("ppt")) fileIconPath = ICON_PATH + "/ic_material_powerpoint.png";
    else if (is("as")) fileIconPath = ICON_PATH + "/ic_material_actionscript.png";
    else if (is("bat")) fileIconPath = ICON_PATH + "/ic_material_console.png";
    else if (is("c") || is("h")) fileIconPath = ICON_PATH + "/ic_material_c.png";
    else if (is("cs")) fileIconPath = ICON_PATH + "/ic_material_csharp.png";
    else if (is("cpp") || is("cc") || is("h") || is("cxx"))
      fileIconPath = ICON_PATH + "/ic_material_cpp.png";
    else if (is("class")) fileIconPath = ICON_PATH + "/ic_material_javaclass.png";
    else if (is("css")) fileIconPath = ICON_PATH + "/ic_material_css.png";
    else if (is("dart")) fileIconPath = ICON_PATH + "/ic_material_dart.png";
    else if (is("diff")) fileIconPath = ICON_PATH + "/ic_material_diff.png";
    else if (is("go")) fileIconPath = ICON_PATH + "/ic_material_go.png";
    else if (is("groovy") || is("gvy") || is("gy") || is("gsh"))
      fileIconPath = ICON_PATH + "/ic_material_groovy.png";
    else if (is("htm") || is("html")) fileIconPath = ICON_PATH + "/ic_material_html.png";
    else if (is("jar")) fileIconPath = ICON_PATH + "/ic_material_jar.png";
    else if (is("java")) fileIconPath = ICON_PATH + "/ic_material_java.png";
    else if (is("js")) fileIconPath = ICON_PATH + "/ic_material_javascript.png";
    else if (is("json")) fileIconPath = ICON_PATH + "/ic_material_json.png";
    else if (is("kt")) fileIconPath = ICON_PATH + "/ic_material_kotlin.png";
    else if (is("less")) fileIconPath = ICON_PATH + "/ic_material_less.png";
    else if (is("log")) fileIconPath = ICON_PATH + "/ic_material_log.png";
    else if (is("lua")) fileIconPath = ICON_PATH + "/ic_material_lua.png";
    else if (is("md")) fileIconPath = ICON_PATH + "/ic_material_markdown.png";
    else if (is("php")) fileIconPath = ICON_PATH + "/ic_material_php.png";
    else if (is("py")) fileIconPath = ICON_PATH + "/ic_material_python.png";
    else if (is("pug")) fileIconPath = ICON_PATH + "/ic_material_pug.png";
    else if (is("properties")) fileIconPath = ICON_PATH + "/ic_material_settings.png";
    else if (is("sass") || is("scss")) fileIconPath = ICON_PATH + "/ic_material_sass.png";
    else if (is("sql")) fileIconPath = ICON_PATH + "/ic_material_database.png";
    else if (is("stylus")) fileIconPath = ICON_PATH + "/ic_material_stylus.png";
    else if (is("swift")) fileIconPath = ICON_PATH + "/ic_material_swift.png";
    else if (is("ts")) fileIconPath = ICON_PATH + "/ic_material_typescript.png";
    else if (is("vue")) fileIconPath = ICON_PATH + "/ic_material_vue.png";
    else if (is("xsl")) fileIconPath = ICON_PATH + "/ic_material_xml.png";
    else if (is("yml") || is("yaml")) fileIconPath = ICON_PATH + "/ic_material_yaml.png";
    else if (is("sh") || is("ps1")) fileIconPath = ICON_PATH + "/ic_material_powershell.png";
    else if (is("ghost")) fileIconPath = ICON_PATH + "/ghostfile.png";
  }

  private boolean is(String str) {
    return fileHelper.equals(str);
  }

  public boolean isFileHasKeyName(
      String filePath, String name, boolean isDir, boolean isIgnoreCase) {
    File file = new File(filePath);
    if (isDir) if (file.isDirectory()) return false;
    String fileName = file.getName();
    return isIgnoreCase ? fileName.equalsIgnoreCase(name) : fileName.equals(name);
  }
}
