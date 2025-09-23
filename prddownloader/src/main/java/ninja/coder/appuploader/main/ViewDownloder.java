package ninja.coder.appuploader.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.animation.ValueAnimator;
import android.animation.ArgbEvaluator;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.downloader.Error;
import com.downloader.OnDownloadListener;
import com.downloader.OnPauseListener;
import com.downloader.OnProgressListener;
import com.downloader.OnStartOrResumeListener;
import com.downloader.PRDownloader;
import com.downloader.Progress;
import com.downloader.Status;
import com.downloader.databinding.LayoutDownloderChildBinding;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;

public class ViewDownloder extends RelativeLayout {

  private HashMap<String, Object> gsonItem;
  protected LayoutDownloderChildBinding child;
  private OnClick onclick;
  private int id;

  public ViewDownloder(Context c) {
    super(c);
  }

  public ViewDownloder(Context c, AttributeSet set) {
    super(c, set);
    init();
  }

  void init() {

    removeAllViews();
    child = LayoutDownloderChildBinding.inflate(LayoutInflater.from(getContext()));
    var param = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
    int[] colors = {0xFF81C784, 0xFF5DB895, 0xFF53B2AA};
    var gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, colors);
    child.getRoot().setBackground(gradientDrawable);
    ValueAnimator colorAnimation = ValueAnimator.ofArgb(colors[0], colors[1]);
    colorAnimation.setDuration(2000);
    colorAnimation.setRepeatCount(ValueAnimator.INFINITE);
    colorAnimation.setRepeatMode(ValueAnimator.REVERSE);
    colorAnimation.setEvaluator(new ArgbEvaluator());
    colorAnimation.addUpdateListener(
        animator -> {
          int animatedValue = (int) animator.getAnimatedValue();
          gradientDrawable.setColors(new int[] {animatedValue, colors[1]});
        });
    colorAnimation.start();
    child.progrssdownload.setVisibility(View.GONE);
    addView(child.getRoot(), param);
  }

  public void setTitle(String title) {
    child.tvname.setText(title);
  }

  public void setSizeTitle(String text) {
    child.tvsize.setText(text);
  }

  public void setDownload(String url, String name) {

    child.iconfake.setVisibility(View.GONE);
    child.progrssdownload.setVisibility(View.VISIBLE);
    child.iconfake.setImageResource(android.R.drawable.arrow_down_float);
    if (Status.RUNNING == PRDownloader.getStatus(id)) {
      PRDownloader.pause(id);

      return;
    }
    if (Status.PAUSED == PRDownloader.getStatus(id)) {
      PRDownloader.resume(id);
      return;
    }
    child.getRoot().setEnabled(false);
    child.progrssdownload.setIndeterminate(true);

    File file = new File("/storage/emulated/0/GhostWebIDE/apk/" + name);
    if (file.exists()) {
      child.view.setVisibility(View.GONE);
      child.installApk.setVisibility(View.VISIBLE);
      child.installApk.setOnClickListener(
          it -> {
            installApk(file.toString());
          });
    } else {
      id =
          PRDownloader.download(url, "/storage/emulated/0/GhostWebIDE/apk/", name)
              .build()
              .setOnStartOrResumeListener(
                  new OnStartOrResumeListener() {

                    @Override
                    public void onStartOrResume() {
                      child.progrssdownload.setIndeterminate(false);
                      child.getRoot().setEnabled(true);
                    }
                  })
              .setOnPauseListener(
                  new OnPauseListener() {

                    @Override
                    public void onPause() {
                      child.progrssdownload.setIndeterminate(true);
                    }
                  })
              .setOnProgressListener(
                  new OnProgressListener() {
                    @Override
                    public void onProgress(Progress progress) {
                      child.progrssdownload.setVisibility(View.VISIBLE);
                      child.iconfake.setVisibility(View.GONE);
                      long progressPercent = progress.currentBytes * 100 / progress.totalBytes;
                      child.progrssdownload.setProgressCompat((int) progressPercent, false);
                      child.tvname.setText(
                          getProgressDisplayLine(progress.currentBytes, progress.totalBytes));
                      child.progrssdownload.setIndeterminate(false);
                    }
                  })
              .start(
                  new OnDownloadListener() {

                    @Override
                    public void onDownloadComplete() {
                      child.tvname.setText("endWork");
                      child.view.setVisibility(View.GONE);
                      child.installApk.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onError(Error error) {}
                  });
    }
  }

  public void setOnClick(OnClick onclick) {
    this.onclick = onclick;
    child.getRoot().setOnClickListener(c -> onclick.onClick(c));
  }

  public interface OnClick {
    void onClick(View v);
  }

  public String getProgressDisplayLine(long currentBytes, long totalBytes) {
    return getBytesToMBString(currentBytes) + "/" + getBytesToMBString(totalBytes);
  }

  private String getBytesToMBString(long bytes) {
    return String.format(Locale.ENGLISH, "%.2fMb", bytes / (1024.00 * 1024.00));
  }

  void installApk(String name) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
        && !getContext().getPackageManager().canRequestPackageInstalls()) {
      var intent = new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES);
      intent.setData(Uri.parse("package:" + "ir.ninjacoder.ghostide"));
      getContext().startActivity(intent);
    } else {
      ApkInstallerCompat compat =
          new ApkInstallerCompat(
              getContext(), new File("/storage/emulated/0/GhostWebIDE/apk/ghostidearm64.apk"));
      compat.execute();
    }
  }
}
