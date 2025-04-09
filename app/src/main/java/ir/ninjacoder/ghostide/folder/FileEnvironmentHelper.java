package ir.ninjacoder.ghostide.folder;

import java.io.File;

public class FileEnvironmentHelper {

  private String filePath;

  public FileEnvironmentHelper(String filePath) {
    this.filePath = filePath;
  }

  public String getFilePath() {
    return filePath;
  }

  public ReadmeHelper readme() {
    return new ReadmeHelper(this);
  }

  public GitHelper git() {
    return new GitHelper(this);
  }

  public NodejsHelper nodejs() {
    return new NodejsHelper(this);
  }

  public AngularJsHelper angularjs() {
    return new AngularJsHelper(this);
  }

  public VueJsHelper vuejs() {
    return new VueJsHelper(this);
  }

  public ReactHelper react() {
    return new ReactHelper(this);
  }

  public GhostTheme ghost() {
    return new GhostTheme(this);
  }

  public AndroidDevHelper android() {
    return new AndroidDevHelper(this);
  }

  public NinjaProjectHelper ninjaprojects() {
    return new NinjaProjectHelper(this);
  }

  public boolean isNpmPackageJson() {
    return nodejs().isNodeJsPackageJsonFile()
        | angularjs().isAngularJsPackageJsonFile()
        | vuejs().isVueJsPackageJsonFile()
        | react().isReactPackageJsonFile();
  }

  public boolean isLicenseFile() {
    return isFileHasKeyRegex(filePath, "(?i)license(\\.(txt|md))?");
  }

  public boolean isdrawableFolder() {
    return isFolderKeyRegex(filePath, "(drawable-([a-zA-Z0-9-]+))|drawable");
  }

  public boolean isLayoutFolder() {
    return isFolderKeyRegex(filePath, "(layout-([a-zA-Z0-9-]+))|layout");
  }
  public boolean isValueIran(){
      return isFolderKeyRegex(filePath,"values-fa");
  }  
  public boolean isValueCustomName(String regexName){
      return isFolderKeyRegex(filePath,regexName);
  }  

  public boolean isSrcDirectory() {
    final String[] srcmodel = {"src", "srcs", "source", "sources", "code"};

    for (var it : srcmodel) {
      if (isFileHasKeyName(filePath, it, false, false)) return true;
    }
    return isFileHasKeyName(filePath, "src", false, true);
  }

  public boolean isPublicDirectory() {
    return isFileHasKeyName(filePath, "public", false, true);
  }

  public boolean isAppDirectory() {
    return isFileHasKeyName(filePath, "app", false, true);
  }

  public boolean isDownloadDirectory() {
    return isFileHasKeyName(filePath, "Download", false, false);
  }

  public boolean isDCIMDirectory() {
    return isFileHasKeyName(filePath, "DCIM", false, false);
  }

  public boolean isMoviesDirectory() {
    return isFileHasKeyName(filePath, "Movies", false, false);
  }

  public boolean isMusicDirectory() {
    return isFileHasKeyName(filePath, "Music", false, false);
  }

  public boolean isNotificationsDirectory() {
    return isFileHasKeyName(filePath, "Notifications", false, false);
  }

  public boolean isPicturesDirectory() {

    final String[] iconPath = {
      "_images",
      "_image",
      "_imgs",
      "_img",
      "images",
      "image",
      "imgs",
      "img",
      "icons",
      "icon",
      "icos",
      "ico",
      "figures",
      "figure",
      "figs",
      "fig",
      "screenshot",
      "screenshots",
      "screengrab",
      "screengrabs",
      "pic",
      "pics",
      "picture",
      "pictures"
    };
    for (var it : iconPath) {
      if (isFileHasKeyName(filePath, it, false, false)) {
        return true;
      }
    }
    return isFileHasKeyName(filePath, "Pictures", false, false);
  }

  public boolean isRingtonesDirectory() {
    return isFileHasKeyName(filePath, "Ringtones", false, false);
  }

  public boolean isPodcastsDirectory() {
    return isFileHasKeyName(filePath, "Podcasts", false, false);
  }

  public boolean isAlarmsDirectory() {
    return isFileHasKeyName(filePath, "Alarms", false, false);
  }

  public boolean isNinjaProjectx() {
    return isFileHasKeyName(filePath, "apps", false, false)
        || isFileHasKeyName(filePath, "ninjas", false, false);
  }

  public boolean isAppIcon() {
    return isFileHasKeyName(filePath, "GhostWebIDE", false, false)
        || isFileHasKeyName(filePath, "ghostweb", false, false);
  }

  public boolean isJavaDirectory() {
    return isFileHasKeyName(filePath, "java", false, true);
  }

  public boolean isJavascriptDirectory() {
    return isFileHasKeyName(filePath, "javascript", false, true)
        || isFileHasKeyName(filePath, "js", false, true);
  }

  public boolean isCssDirectory() {

    final String[] cssFolders = {"css", "stylesheet", "stylesheets", "style", "styles"};
    for (var it : cssFolders) {
      if (isFileHasKeyName(filePath, it)) return true;
    }
    return false;
  }

  public boolean isPhpDirectory() {
    return isFileHasKeyName(filePath, "php", false, true);
  }

  public boolean isPythonDirectory() {
    String[] pythonFolder = {"python", "__pycache__"};
    for (var it : pythonFolder) {
      if (isFileHasKeyName(filePath, it)) return true;
    }
    return false;
  }

  public boolean isJsonDirectory() {
    return isFileHasKeyName(filePath, "json", false, true);
  }

  public boolean isMarkdownDirectory() {
    return isFileHasKeyName(filePath, "markdown", false, true);
  }

  public boolean isLogDirectory() {
    return isFileHasKeyName(filePath, "log", false, true);
  }

  public boolean isIntelliJDirectory() {
    return isFileHasKeyName(filePath, ".idea", false, false);
  }

  public boolean isGradleJDirectory() {
    return isFileHasKeyName(filePath, "gradle", false, false);
  }

  public boolean isAndroidDirectory() {
    return isFileHasKeyName(filePath, "Android", false, true);
  }

  public boolean isSassOrScssDirectory() {
    return isFileHasKeyName(filePath, "sass", false, true)
        || isFileHasKeyName(filePath, "scss", false, true);
  }

  public boolean isWebDirectory() {
    final String[] webFolders = {
      "_site", "www", "wwwroot", "web", "website", "site", "browser", "browsers"
    };
    for (var it : webFolders) {
      if (isFileHasKeyName(filePath, it, false, false)) return true;
    }
    return isFileHasKeyName(filePath, "web", false, false);
  }

  public boolean isAntlr4Directory() {
    return isFileHasKeyName(filePath, "antlr", false, false)
        || isFileHasKeyName(filePath, "antlr4", false, false);
  }

  public boolean isToolsDirectory() {
    final String[] folderTheme = {"themes", "theme", "color", "colors", "design", "designs"};
    for (var it : folderTheme) {
      if (isFileHasKeyName(filePath, it, false, false)) return true;
    }
    return isFileHasKeyName(filePath, "theme", false, false);
  }

  public boolean isFileHasKeyRegex(String filePath, String regex) {
    File file = new File(filePath);
    if (file.isDirectory()) return false;
    String fileName = file.getName();
    return fileName.matches(regex);
  }

  public boolean isFolderKeyRegex(String filePath, String regex) {
    File file = new File(filePath);
    if (!file.isDirectory()) return false;
    var get = file.getName();
    return get.matches(regex);
  }

  public boolean isFileHasKeyName(
      String filePath, String name, boolean isDir, boolean isIgnoreCase) {
    File file = new File(filePath);
    if (isDir) if (file.isDirectory()) return false;
    String fileName = file.getName();
    return isIgnoreCase ? fileName.equalsIgnoreCase(name) : fileName.equals(name);
  }

  boolean isFileHasKeyName(String filePath, String name) {
    return isFileHasKeyName(filePath, name, false, false);
  }

  public static class ReadmeHelper {
    private FileEnvironmentHelper instance;

    public ReadmeHelper(FileEnvironmentHelper instance) {
      this.instance = instance;
    }

    public boolean isReadmeFile() {
      return ReadmeDetector.isReadmeFile(instance.filePath);
    }
  }

  public static class NodejsHelper {
    private FileEnvironmentHelper instance;

    public NodejsHelper(FileEnvironmentHelper instance) {
      this.instance = instance;
    }

    public boolean isNodeJsDirectory() {
      return NodejsDetector.isNodeJsDirectory(instance.filePath);
    }

    public boolean isNodeJsFile() {
      return NodejsDetector.isNodeJsFile(instance.filePath);
    }

    public boolean isNodeJsPackageJsonFile() {
      return NodejsDetector.isNodeJsPackageJsonFile(instance.filePath);
    }
  }

  public static class AngularJsHelper {
    private FileEnvironmentHelper instance;

    public AngularJsHelper(FileEnvironmentHelper instance) {
      this.instance = instance;
    }

    public boolean isAngularJsDirectory() {
      return AngularJsDetector.isAngularJsDirectory(instance.filePath);
    }

    public boolean isAngularJsFile() {
      return AngularJsDetector.isAngularJsFile(instance.filePath);
    }

    public boolean isAngularJsPackageJsonFile() {
      return AngularJsDetector.isAngularJsPackageJsonFile(instance.filePath);
    }
  }

  public static class VueJsHelper {
    private FileEnvironmentHelper instance;

    public VueJsHelper(FileEnvironmentHelper instance) {
      this.instance = instance;
    }

    public boolean isVueJsDirectory() {
      return VueDetector.isVueJsDirectory(instance.filePath);
    }

    public boolean isVueJsFile() {
      return VueDetector.isVueJsFile(instance.filePath);
    }

    public boolean isVueJsPackageJsonFile() {
      return VueDetector.isVueJsPackageJsonFile(instance.filePath);
    }
  }

  public static class ReactHelper {
    private FileEnvironmentHelper instance;

    public ReactHelper(FileEnvironmentHelper instance) {
      this.instance = instance;
    }

    public boolean isReactDirectory() {
      return ReactDetector.isReactDirectory(instance.filePath);
    }

    public boolean isReactFile() {
      return ReactDetector.isReactFile(instance.filePath);
    }

    public boolean isReactPackageJsonFile() {
      return ReactDetector.isReactPackageJsonFile(instance.filePath);
    }
  }

  public static class GitHelper {
    private FileEnvironmentHelper instance;

    public GitHelper(FileEnvironmentHelper instance) {
      this.instance = instance;
    }

    public boolean isGitDirectory() {
      return GitDetector.isGitDirectory(instance.filePath);
    }

    public boolean isGitIgnoreFile() {
      return GitDetector.isGitIgnoreFile(instance.filePath);
    }
  }

  public static class GhostTheme {
    protected FileEnvironmentHelper instance;

    public GhostTheme(FileEnvironmentHelper instance) {
      this.instance = instance;
    }

    public boolean isGhostFile() {
      return GhostDetector.isGhostFile(instance.filePath);
    }

    public boolean isAppLego() {
      return GhostDetector.isAppLoaderTheme(instance.filePath);
    }
  }

  public static class AndroidDevHelper {
    private FileEnvironmentHelper instance;

    public AndroidDevHelper(FileEnvironmentHelper instance) {
      this.instance = instance;
    }

    public boolean isAndroidDevDirectory() {
      return AndroidDevDetector.isAndroidDevDirectory(instance.filePath);
    }
  }

  public static class NinjaProjectHelper {
    private FileEnvironmentHelper ev;

    public NinjaProjectHelper(FileEnvironmentHelper ev) {
      this.ev = ev;
    }

    public boolean isNinjaDev() {
      return NinjaProjectDetector.isNinjaLang(ev.filePath);
    }
  }
}
