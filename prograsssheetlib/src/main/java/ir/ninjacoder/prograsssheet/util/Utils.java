package ir.ninjacoder.prograsssheet.util;
import android.os.Handler;
import android.os.Looper;

public class Utils {
  
  public static void runOnUiThread(Runnable run){
    var had = new Handler(Looper.getMainLooper());
    if(had!= null) {
    	had.post(run);
    }
  }
}
