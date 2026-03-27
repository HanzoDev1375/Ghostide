package ir.ninjacoder.ghostide.core.navigator;

import ir.ninjacoder.ghostide.core.widget.ExrtaFab;
import ir.ninjacoder.prograsssheet.listchild.Child;
import java.util.List;

/*
 * <p> this class Work Reload is Lang files  </p>
 * <p> code by ninja coder </p>
 */

public class EditorRoaderFile {

  public static void RuningTask(ExrtaFab fab, String path, List<Child> listchild) {

    if (path.endsWith(".css")) {
      fab.postDelayed(fab::hide, 400);
    } else if (path.endsWith(".py")) {
      fab.postDelayed(fab::show, 400);
    } else if (path.endsWith(".cpp")
        || path.endsWith(".cxx")
        || path.endsWith(".cc")
        || path.endsWith(".h")
        || path.endsWith(".hpp")) {

      fab.postDelayed(fab::hide, 400);
    } else if (path.endsWith(".html")) {

      fab.postDelayed(fab::show, 400);
    } else if (path.endsWith(".js")) {

      fab.postDelayed(fab::show, 400);
    } else if (path.endsWith(".scss")) {
      fab.postDelayed(fab::show, 300);
    } else if (path.endsWith(".c")) {
      fab.postDelayed(fab::hide, 400);
    } else if (path.endsWith(".json")) {
      fab.postDelayed(fab::show, 400);
    } else if (path.endsWith(".java")) {
      fab.postDelayed(fab::show, 400);
    } else if (path.endsWith(".cs")) {
      fab.postDelayed(fab::hide, 400);
    } else if (path.endsWith(".xml")) {
      fab.postDelayed(fab::show, 400);
    } else if (path.endsWith(".ghost")) {
      fab.postDelayed(fab::hide, 400);
    } else if (path.endsWith(".ninja")) {
      fab.postDelayed(fab::hide, 400);
    } else if (path.endsWith(".sh")) {
      fab.postDelayed(fab::show, 400);
    } else if (path.endsWith(".svg")) {
      fab.postDelayed(fab::show, 400);
    } else if (path.endsWith(".md")) {
      fab.postDelayed(fab::show, 400);
    } else if (path.endsWith(".php")) {
      fab.postDelayed(fab::show, 400);
    } else if (path.endsWith(".go")) {
      fab.postDelayed(fab::hide, 400);
    } else if (path.endsWith(".txt")) {
      fab.postDelayed(fab::hide, 400);
    } else if (path.endsWith(".swift")) {
      fab.postDelayed(fab::hide, 400);
    } else if (path.endsWith(".rb") || path.endsWith(".rbw")) {
      fab.postDelayed(fab::hide, 400);
    } else if (path.endsWith(".dart")) {
      fab.postDelayed(fab::hide, 400);
    } else if (path.endsWith(".kt")) {
      fab.postDelayed(fab::show, 400);
    } else if (path.endsWith(".groovy") || path.endsWith(".gradle")) {
      fab.postDelayed(fab::hide, 400);
    } else if (path.endsWith(".smali")) {
      fab.postDelayed(fab::hide, 400);
    } else if (path.endsWith(".g4")) {
      fab.postDelayed(fab::show, 400);
    } else if (path.endsWith(".ts") || path.endsWith(".tsx")) {
      fab.postDelayed(fab::show, 400);
    } else if (path.endsWith(".properties")) {
      fab.postDelayed(fab::hide, 400);
    } else if (path.endsWith(".sql")) {
      fab.postDelayed(fab::hide, 400);
    } else if (path.endsWith(".jj")) {
      fab.postDelayed(fab::show, 400);
    } else if (path.endsWith(".frag")) {
      fab.postDelayed(fab::hide, 400);
    } else if (path.endsWith(".sass")) {
      fab.postDelayed(fab::show, 400);
    } else if (path.endsWith(".class")) {

      fab.postDelayed(fab::hide, 400);
    } else if (path.endsWith(".yml")) {
      fab.postDelayed(fab::hide, 400);
    } else if (path.endsWith(".jsx") || path.endsWith(".tsx")) {
      fab.postDelayed(fab::show, 400);
    } else if (path.endsWith(".less")) {
      fab.postDelayed(fab::show, 400);
    } else if (path.endsWith(".rs")) {
      fab.postDelayed(fab::hide, 400);
    } else if (path.endsWith(".zig")) {
      fab.postDelayed(fab::hide, 400);
    } else if (path.endsWith(".lua")) {
      fab.postDelayed(fab::hide, 400);
    } else {
      fab.postDelayed(fab::hide, 400);
    }
    for (var it : listchild) {
      if (path.endsWith(it.getTypeExz())) {
        if (it.getLanguageProvider() != null) it.getLanguageProvider().run();
        if (it.getShowfab() == true) {
          fab.show();
        } else fab.hide();
        return;
      }
    }
  }
}
