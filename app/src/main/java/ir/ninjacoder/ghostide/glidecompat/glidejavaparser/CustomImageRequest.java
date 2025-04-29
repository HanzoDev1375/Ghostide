package ir.ninjacoder.ghostide.glidecompat.glidejavaparser;

import java.io.File;

public class CustomImageRequest {
  private final File javaFile;
  private final int defaultImageRes;
  private final JavaCodeAnalyzer analyzer;

  public CustomImageRequest(File javaFile, int defaultImageRes, JavaCodeAnalyzer analyzer) {
    this.javaFile = javaFile;
    this.defaultImageRes = defaultImageRes;
    this.analyzer = analyzer;
  }

  public File getJavaFile() {
    return javaFile;
  }

  public int getDefaultImageRes() {
    return defaultImageRes;
  }

  public JavaCodeAnalyzer getAnalyzer() {
    return analyzer;
  }
}
