package Ninja.coder.Ghostemane.code.marco.ninjaCompiler;

import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

public class NiC {

    public static void run(TextView textview) {
        var mHandler = new Handler(Looper.getMainLooper());
        final String[] texts =
                new String[]{"> Task : Start Build", "> Task : Start Compile", "> Task : Start Run"};
        final int[] currentIndex = {0};

        Thread thread =
                new Thread(
                        new Runnable() {
                            @Override
                            public void run() {
                                while (true) {
                                    try {
                                        Thread.sleep(2000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    mHandler.post(
                                            new Runnable() {
                                                @Override
                                                public void run() {
                                                    textview.setText(texts[currentIndex[0]]);
                                                    currentIndex[0] = (currentIndex[0] + 1) % texts.length;
                                                }
                                            });
                                }
                            }
                        });
        thread.start();
    }
}
