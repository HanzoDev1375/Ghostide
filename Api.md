### Ghost ide Api

- We created an API for you for your plugins
With this plugin, which will add new features in the future, you can add a series of features to the editor code. Source code Api

``` java

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
}


```
- From the methods and actions it is clear what you need to do

### Creating Api dex

- To register your plugin, you need to go to this file `/storage/emulated/0/GhostWebIDE/plugins/config.json`
Then create a plugin here [repository](https://github.com/HanzoDev1375/Ghost-ide-Plugin) 
And then download the sdk.jar file, then create your plugin with the class example declared in the repository

### How to use the plugin
- When you build the project, you can go to this path `app/build/intermediates/project_dex_archive/debug/dexBuilderDebug/out/ir/ninjacoder/plloader/Deom.dex`
And place the created plugin in this path with this Json input

``` json
 {
	 "dexpath":  "/storage/emulated/0/GhostWebIDE/plugins/dialog/DialogPlugin.dex",
     "dexname": "DialogPlugin",
	 "pkgname": "ir.ninjacoder.plloader"
 }
  

```
- Then now you can register your plugin file in `config.json`

``` json
 [
    {
    "name": "dialog",
    "dir": "/storage/emulated/0/ghostide/plugins/dialog/path.json",
    "dev": "ninjacoder"
    }
 ]

```

### Note

- It is not possible to call resources yet
It will be added in the future with the new Api