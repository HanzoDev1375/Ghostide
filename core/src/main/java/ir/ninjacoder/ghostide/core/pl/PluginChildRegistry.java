package ir.ninjacoder.ghostide.core.pl;

import java.util.ArrayList;
import java.util.List;

import ir.ninjacoder.prograsssheet.listchild.Child;

/** این کلاس برای نوشته شده تا شما بتوانید زیان های برنامه نویسی کاستوم خودتان را ایجاد کنید */
public class PluginChildRegistry {
  private static List<Child> fileManagerChildren = new ArrayList<>();
  private static List<Child> codeEditorChildren = new ArrayList<>();

  public static void registerFileManagerChild(Child child) {
    fileManagerChildren.add(child);
  }

  public static void registerCodeEditorChild(Child child) {
    codeEditorChildren.add(child);
  }

  public static List<Child> getFileManagerChildren() {
    return new ArrayList<>(fileManagerChildren);
  }

  public static List<Child> getCodeEditorChildren() {
    return new ArrayList<>(codeEditorChildren);
  }

  public static void clear() {
    fileManagerChildren.clear();
    codeEditorChildren.clear();
  }
}
