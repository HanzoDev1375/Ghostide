package ir.ninjacoder.ghostide.core.marco.binder;

import ir.ninjacoder.ghostide.core.marco.binder.bindchilder.ChilderRecyclerviewCompat;

public class BinderRecyclerview1 {

  public static boolean TaskVideo(String path) {
    return path.endsWith(".mp4".toLowerCase())
        || path.endsWith(".mkv".toLowerCase())
        || path.endsWith(".avi".toLowerCase())
        || path.endsWith(".mov".toLowerCase())
        || path.endsWith(".wmv".toLowerCase())
        || path.endsWith(".flv".toLowerCase())
        || path.endsWith("." + ChilderRecyclerviewCompat.getVideoFormat().toLowerCase());
  }

  private static boolean archiveView(String path) {
    return path.endsWith(".tar")
        || path.endsWith(".rar")
        || path.endsWith(".zip")
        || path.endsWith(".tar.gz")
        || path.endsWith(".tar.xz")
        || path.endsWith(".7z");
  }

  public static boolean PhotoView(String path) {
    return (path.endsWith(".jpg".toLowerCase())
        || path.endsWith(".jpeg".toLowerCase())
        || path.endsWith(".png".toLowerCase())
        || path.endsWith(".gif".toLowerCase())
        || path.endsWith(".bmp".toLowerCase())
        || path.endsWith(".avif".toLowerCase())
        || path.endsWith(".webp".toLowerCase()));
  }
}
