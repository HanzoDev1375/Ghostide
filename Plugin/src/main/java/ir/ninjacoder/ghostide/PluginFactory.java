package ir.ninjacoder.ghostide.PluginManager;

import android.os.Build;
import androidx.annotation.RequiresApi;

@ismodule
public interface PluginFactory {
  @isField(api = Build.VERSION_CODES.KITKAT)
  
  public void getName(String name, boolean show);
}
