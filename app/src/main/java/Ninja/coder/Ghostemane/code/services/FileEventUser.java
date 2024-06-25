package Ninja.coder.Ghostemane.code.services;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.widget.Toast;
import io.reactivex.rxjava3.disposables.Disposable;

public class FileEventUser extends Service {

    public String path = "";
    protected CallBack call;
    private Disposable disposable;

    public FileEventUser() {
    }

    public void setCallBack(CallBack call) {
        this.call = call;
    }

    @Override
    public IBinder onBind(Intent arg0) {
        // TODO: Implement this method
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // TODO: Implement this method
        Start();
    }

    protected void Start() {
        //    File sdCard = new File(FileDirActivity.POSNINJACODERMAIN);
        //    Observable<FileEvent> sdCardFileEvents = RxFileObserver.create(sdCard);
        //
        //    disposable =
        //        sdCardFileEvents
        //            .observeOn(Schedulers.io())
        //            .subscribe(
        //                fileEvent -> {
        //                  runOnUiThread(
        //                      () -> {
        //                        if (fileEvent.isDelete()) {
        //                          if (sdCard.isDirectory()) dialog("Directory is Delete");
        //                          else dialog("File is Delete");
        //                        } else if (fileEvent.isCreate()) {
        //                          dialog("File is Create");
        //                        }
        //                        Log.i("TAG", fileEvent.toString());
        //                      });
        //                });
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void dialog(String txt) {
        Toast.makeText(getApplicationContext(), txt, Toast.LENGTH_SHORT).show();
    }

    private void runOnUiThread(Runnable action) {
        Handler mainHandler = new Handler(Looper.getMainLooper());
        mainHandler.post(action);
    }

    public interface CallBack {
        public void onFileChange();
    }
}
