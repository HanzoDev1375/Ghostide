
### Ghost IDE API

- We created an API for you for your plugins
With this plugin, which will add new features in the future, you can add a series of features to the editor code. Source code Api

```java
package ir.ninjacoder.ghostide.pl;

import io.github.rosemoe.sora.widget.CodeEditor;
import ir.ninjacoder.ghostide.activities.FileManagerActivity;
import ir.ninjacoder.ghostide.activities.CodeEditorActivity;

public interface PluginManagerCompat {

    void getEditor(CodeEditor editor);

    String setName();

    boolean hasuseing();

    void getFileManagerAc(FileManagerActivity activity);

    void getCodeEditorAc(CodeEditorActivity activity);
    
    String langModel();
}
```

توضیح متدها:

· getEditor(CodeEditor editor) - دریافت ادیتور کد
· setName() - نام پلاگین را برمیگرداند
· hasuseing() - وضعیت فعال/غیرفعال پلاگین
· getFileManagerAc(FileManagerActivity activity) - دریافت FileManagerActivity
· getCodeEditorAc(CodeEditorActivity activity) - دریافت CodeEditorActivity
· langModel() - نوع فایلهای پشتیبانی شده (مثلاً .html یا .html,.css)

Creating Api dex

· To register your plugin, you need to go to this file /storage/emulated/0/GhostWebIDE/plugins/config.json
  Then create your plugin based on thisrepository 
  And then download the sdk.jar file,then create your plugin with the class example declared in the repository

How to use the plugin

· When you build the project, you can go to this path app/build/intermediates/project_dex_archive/debug/dexBuilderDebug/out/ir/ninjacoder/plloader/Deom.dex
  And place the created plugin in this path with this Json input

```json
{
    "dexpath": "/storage/emulated/0/GhostWebIDE/plugins/dialog/DialogPlugin.dex",
    "dexname": "DialogPlugin",
    "pkgname": "ir.ninjacoder.plloader"
}
```

· Then now you can register your plugin file in config.json

```json
[
    {
        "name": "dialog",
        "dir": "/storage/emulated/0/GhostWebIDE/plugins/dialog/manifest.json",
        "dev": "ninjacoder",
        "isusing": true,
        "type": ".html,.css"
    }
]
```

پشتیبانی از چندین فرمت فایل:

شما میتوانید پلاگین خود را برای چندین نوع فایل تعریف کنید:

```json
{
    "type": ".html,.htm,.css"  // پشتیبانی از HTML و CSS
}
```

```json
{
    "type": ".java,.kt"  // پشتیبانی از Java و Kotlin
}
```

```json
{
    "type": ".js,.ts,.jsx"  // پشتیبانی از JavaScript و TypeScript
}
```

اولویتبندی:

1. اولویت اول: فیلد type در config.json
2. پشتیبان: متد langModel() در پلاگین

ساختار پلاگین:

``` java
public class MyPlugin implements PluginManagerCompat {
    
    @Override
    public void getEditor(CodeEditor editor) {
        // کار با ادیتور
    }
    
    @Override
    public String setName() {
        return "نام پلاگین من";
    }
    
    @Override
    public boolean hasuseing() {
        return true; // فعال
    }
    
    @Override
    public void getFileManagerAc(FileManagerActivity activity) {
        // کار با FileManager
    }
    
    @Override
    public void getCodeEditorAc(CodeEditorActivity activity) {
        // کار با CodeEditorActivity
    }
    
    @Override
    public String langModel() {
        return ".html,.css"; // پشتیبانی از HTML و CSS
    }
}
```

##Note

· It is not possible to call resources yet
  It will be added in the future with the new Api
  
  
## Custom Editor Lang

- To create a custom language plugin, first look at the [Child.class](https://github.com/HanzoDev1375/Ghostide/blob/main/prograsssheetlib/src/main/java/ir/ninjacoder/prograsssheet/listchild/Child.java) Then implement a new class for the PluginManagerCompat For more implementation details, see class [PluginManagerCompatImpl](https://github.com/HanzoDev1375/Ghostide/blob/main/app/src/main/java/ir/ninjacoder/ghostide/pl/PluginManagerCompatImpl.java)
- deom class 
```java
package ir.ninjacoder.plloader.mylang;

import android.util.Log;
import android.widget.Toast;
import io.github.rosemoe.sora.langs.dart.DartLang;
import io.github.rosemoe.sora.widget.CodeEditor;
import ir.ninjacoder.ghostide.IdeEditor;
import ir.ninjacoder.ghostide.activities.CodeEditorActivity;
import ir.ninjacoder.ghostide.activities.FileManagerActivity;
import ir.ninjacoder.ghostide.pl.PluginManagerCompat;
import ir.ninjacoder.prograsssheet.listchild.Child;

import java.lang.reflect.Method;

public class MyCustomLanguagePlugin implements PluginManagerCompat {

  private CodeEditor editor;

  @Override
  public void getCodeEditorAc(CodeEditorActivity activity) {
    try {
      Child child =
          new Child(
              true,
              () -> {
                Toast.makeText(activity, "زبان اعمال شد", Toast.LENGTH_SHORT).show();
                if (editor != null) {
                  editor.setEditorLanguage(new DartLang());
                }
              },
              1000);

      Method addChildMethod = activity.getClass().getDeclaredMethod("addChild", Child.class);
      addChildMethod.setAccessible(true);
      addChildMethod.invoke(activity, child);
    } catch (Exception e) {
      Log.e("MyCustomLanguagePlugin", "Error in getCodeEditorAc: " + e.getMessage(), e);
    }
  }

  @Override
  public void getEditor(CodeEditor editor) {
    this.editor = editor; //bind editor to call setEditorLanguage
  }

  @Override
  public void getFileManagerAc(FileManagerActivity activity) {
    try {
      Child child =
          new Child(langModel(), "/storage/emulated/0/GhostWebIDE/plugins/customlang/icon.png"); //icon your lang jpg png svg & vector not work sorry
      Method addChildMethod = activity.getClass().getDeclaredMethod("addChild", Child.class);
      addChildMethod.setAccessible(true);
      addChildMethod.invoke(activity, child);

    } catch (Exception e) {
      Log.e("MyCustomLanguagePlugin", "Error in getFileManagerAc: " + e.getMessage(), e);
    }
  }

  @Override
  public boolean hasuseing() {
    return true;
  }

  @Override
  public String setName() {
    return "My Language";
  }

  @Override
  public String langModel() {
    return ".myext"; //your type .css .java 
    // How to use Multitype? this ".js,.html,.c"
  }
}
```

