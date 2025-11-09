package ir.ninjacoder.ghostide.core.services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings;

import androidx.core.app.NotificationCompat;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.StopServiceReceiver;
import ir.ninjacoder.ghostide.core.tasks.DownloadFile;

public class DownloadService extends Service {


    public static boolean downloadAllowed = true;
    private Context mContext;
    private NotificationManager notificationManager;
    private int notificationId = (int) 9;
    private int NOTIFICATION_ID = 94;
    Runnable stoAll = new Runnable() {
        @Override
        public void run() {
            removeNotification(notificationId);
            removeNotification(NOTIFICATION_ID);
            stopForeground(true);
            stopSelf();
        }
    };

    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub
        mContext = this;
        startInForeground();
        String url = intent.getStringExtra("url");
        String path = intent.getStringExtra("path");

        download(url,
                path);

        return START_STICKY;
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        // TODO Auto-generated method stub
    }


    @Override
    public void onDestroy() {
        Runnable stoAll = new Runnable() {
            @Override
            public void run() {
                removeNotification(notificationId);
                removeNotification(NOTIFICATION_ID);
                stopForeground(true);
                stopSelf();
            }
        };
        super.onDestroy();
    }

    private void download(String url, final String filePath) {


        SimpleDateFormat hour = new SimpleDateFormat("HH");
        SimpleDateFormat minute = new SimpleDateFormat("mm");

        Date date = new Date();

        Calendar calnow = Calendar.getInstance();
        calnow.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hour.format(date)));
        calnow.set(Calendar.MINUTE, Integer.parseInt(minute.format(date)));

        notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);

        final NotificationCompat.Builder mBuilder = notificationCompat(notificationManager);


        NotificationCompat.Action action = new NotificationCompat.Action(R.drawable.app_icon,
                "stop",
                stopDownload());

        mBuilder.setSmallIcon(android.R.drawable.stat_sys_download)
                .setTicker("download")
                .setContentTitle("downloading file " + new File(filePath).getName())
                .setContentText("Download will starts...")
                .setAutoCancel(false)
                .setOngoing(true)
                .addAction(action);


        DownloadFile downloadFile = new DownloadFile(url, filePath)
                .setListener(new DownloadFile.onDownloadListener() {
                    @Override
                    public void onProgressListener(int progress, String lengthFile) {
                        if (downloadAllowed) {
                            // on Progress
                            mBuilder.setProgress((int) 100, (int) progress, false)
                                    .setAutoCancel(false)
                                    .setContentText("Downloading... " + String.valueOf(progress) + "% / " + lengthFile)
                                    .setOngoing(true)
                            ;
                            notificationManager.notify(notificationId, mBuilder.build());


                        } else {
                            new Handler().post(stoAll);
                        }


                    }

                    @Override
                    public void onCompleteListener() {
                        // onComplete
                        mBuilder.setSmallIcon(android.R.drawable.stat_sys_download_done)
                                .setTicker("download")
                                .setContentTitle("Download completed !")
                                .setContentText("Downloaded to :" + filePath)
                                .setAutoCancel(true)
                                .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                                .setOngoing(false);

                        removeNotification(notificationId);

                        stopForeground(true);

                        notificationManager.notify(notificationId, mBuilder.build());
                    }

                    @Override
                    public void onErrorListener(String errorMessage) {
                        mBuilder.setSmallIcon(android.R.drawable.stat_sys_download_done)
                                .setTicker("download")
                                .setContentTitle("Download Erro")
                                .setContentText("Error : " + errorMessage)
                                .setAutoCancel(true)
                                .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                                .setOngoing(false);

                        notificationManager.notify(notificationId, mBuilder.build());
                    }
                });
        downloadFile.execute(0);

    }


    public String getProgressDisplayLine(long currentBytes, long totalBytes) {
        return getBytesToMBString(currentBytes) + "/" + getBytesToMBString(totalBytes);
    }

    private String getBytesToMBString(long bytes) {
        return String.format(Locale.ENGLISH, "%.2fMb", bytes / (1024.00 * 1024.00));
    }

    private void startInForeground() {
        NotificationCompat.Builder contentIntent = new NotificationCompat.Builder(this, "default")
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setOngoing(true)
                .setAutoCancel(true)
                .setSmallIcon(android.R.drawable.stat_sys_download_done)
                .setContentTitle("Download service is running");

        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("default", "Pending", NotificationManager.IMPORTANCE_LOW);
            notificationChannel.setDescription("notification holder");
            notificationChannel.setSound(null, null);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
        startForeground(NOTIFICATION_ID, contentIntent.build());
    }

    private void removeNotification(int i) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            notificationManager.cancel(i);
        }
    }

    private NotificationCompat.Builder notificationCompat(NotificationManager notificationManager) {

        Random rand = new Random();

        final int notificationId = (int) rand.nextInt(9);
        String channelId = "channel-01";
        String channelName = "Channel Name";
        int importance = NotificationManager.IMPORTANCE_LOW;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel mChannel = new NotificationChannel(
                    channelId, channelName, importance);
            notificationManager.createNotificationChannel(mChannel);
        }
        return new androidx.core.app.NotificationCompat
                .Builder(this, channelId);
    }

    private PendingIntent stopDownload() {
        Intent receiverIntent = new Intent(getApplicationContext(), StopServiceReceiver.class);
        PendingIntent pendingStop = PendingIntent.getBroadcast(this, 0, receiverIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        return pendingStop;
    }

}