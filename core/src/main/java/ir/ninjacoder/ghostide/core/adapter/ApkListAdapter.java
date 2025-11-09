package ir.ninjacoder.ghostide.core.adapter;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.color.MaterialColors;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.activities.ApkViewActivity;

public class ApkListAdapter extends RecyclerView.Adapter<ApkListAdapter.ViewHolder> {
  public ApkViewActivity mActivity;
  public PackageManager packageManager;
  int names_to_load = 0;
  private ThreadFactory tFactory =
      new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
          Thread t = new Thread(r);
          t.setDaemon(true);
          return t;
        }
      };
  private ArrayList<PackageInfo> list = new ArrayList<PackageInfo>();
  private ArrayList<PackageInfo> list_original = new ArrayList<PackageInfo>();
  private ExecutorService executorServiceNames = Executors.newFixedThreadPool(3, tFactory);
  private ExecutorService executorServiceIcons = Executors.newFixedThreadPool(3, tFactory);
  private Handler handler = new Handler(Looper.getMainLooper());
  private Map<String, String> cache_appName =
      Collections.synchronizedMap(new LinkedHashMap<String, String>(10, 1.5f, true));
  private Map<String, Drawable> cache_appIcon =
      Collections.synchronizedMap(new LinkedHashMap<String, Drawable>(10, 1.5f, true));

  private String search_pattern;

  public ApkListAdapter(ApkViewActivity activity) {
    this.packageManager = activity.getPackageManager();
    mActivity = activity;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
    return new ViewHolder(
        LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false),
        this);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int i) {
    var item = list.get(i);
    holder.setPackageName(item.packageName, search_pattern);
    if (cache_appIcon.containsKey(item.packageName)
        && cache_appName.containsKey(item.packageName)) {
      holder.setAppName(cache_appName.get(item.packageName), search_pattern);
      holder.imgIcon.setImageDrawable(cache_appIcon.get(item.packageName));
    } else {
      holder.setAppName(item.packageName, search_pattern);
      holder.imgIcon.setImageDrawable(null);
      executorServiceIcons.submit(new GuiLoader(holder, item));
    }
  }

  public PackageInfo getItem(int pos) {
    return list.get(pos);
  }

  @Override
  public int getItemCount() {
    return list.size();
  }

  public void addItem(PackageInfo item) {
    names_to_load++;
    executorServiceNames.submit(new AppNameLoader(item));
    list_original.add(item);
    filterListByPattern();
    notifyDataSetChanged();
  }

  public void setSearchPattern(String pattern) {
    search_pattern = pattern.toLowerCase();
    filterListByPattern();
    this.notifyDataSetChanged();
  }

  private void filterListByPattern() {
    list.clear();
    for (var info : list_original) {
      boolean add = true;
      do {
        if (search_pattern == null || search_pattern.isEmpty()) {
          break; // empty search pattern: add everything
        }
        if (info.packageName.toLowerCase().contains(search_pattern)) {
          break; // search in package name
        }
        if (cache_appName.containsKey(info.packageName)
            && cache_appName.get(info.packageName).toLowerCase().contains(search_pattern)) {
          break; // search in application name
        }
        add = false;
      } while (false);

      if (add) list.add(info);
    }
  }

  class ViewHolder extends RecyclerView.ViewHolder implements OnClickListener {
    public ImageView imgIcon;
    private ApkListAdapter adapter;
    private TextView txtPackageName;
    private TextView txtAppName;

    public ViewHolder(View v, ApkListAdapter adapter) {
      super(v);
      this.adapter = adapter;
      txtPackageName = (TextView) v.findViewById(R.id.txtPackageName);
      imgIcon = (ImageView) v.findViewById(R.id.imgIcon);
      txtAppName = (TextView) v.findViewById(R.id.txtAppName);
      v.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
      var info = adapter.getItem(getAdapterPosition());
      List<String> items = new ArrayList<>();

      items.add("Save Apk");
      items.add("Share Apk");
      items.add("Info Apk");
      try {
        var icon = info.applicationInfo.loadIcon(v.getContext().getPackageManager());
        new MaterialAlertDialogBuilder(v.getContext())
            .setTitle(" " + info.applicationInfo.name)
            .setPositiveButton(android.R.string.cancel, null)
            .setIcon(icon)
            .setAdapter(
                new ArrayAdapter<>(v.getContext(), android.R.layout.simple_list_item_1, items),
                (dialog, which) -> {
                  switch (which) {
                    case 0:
                      adapter.mActivity.doExctract(info);
                      break;
                    case 1:
                      {
                        adapter.mActivity.ExctractAndShare(info);
                        break;
                      }
                    case 2:
                      {
                        var builder = new StringBuilder();
                        builder
                            .append("Version Code: ")
                            .append(info.versionCode)
                            .append("\n")
                            .append("Version Name: ")
                            .append(info.versionName)
                            .append("\n")
                            .append("Compile SDK: ")
                            .append(info.applicationInfo.compileSdkVersion)
                            .append("\n")
                            .append("Compile SDK Name: ")
                            .append(info.applicationInfo.compileSdkVersionCodename)
                            .append("\n")
                            .append("Package Name: ")
                            .append(info.applicationInfo.packageName)
                            .append("\n")
                            .append("Data Dir: ")
                            .append(info.applicationInfo.dataDir)
                            .append("\n")
                            .append("Target SDK: ")
                            .append(info.applicationInfo.targetSdkVersion)
                            .append("\n")
                            .append("Min Sdk: ")
                            .append(info.applicationInfo.minSdkVersion)
                            .append("\n")
                            .append("So File: ")
                            .append(info.applicationInfo.nativeLibraryDir)
                            .append("\n");

                        String allInfo = builder.toString();
                        new MaterialAlertDialogBuilder(v.getContext())
                            .setTitle("info apk " + info.applicationInfo.name)
                            .setMessage(allInfo)
                            .setPositiveButton(android.R.string.ok, null)
                            .show();
                      }
                    default:
                      break;
                  }
                })
            .show();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    public void setAppName(String name, String highlight) {
      setAndHighlight(txtAppName, name, highlight);
    }

    public void setPackageName(String name, String highlight) {
      setAndHighlight(txtPackageName, name, highlight);
    }

    private void setAndHighlight(TextView view, String value, String pattern) {
      view.setText(value);
      if (pattern == null || pattern.isEmpty()) return; // nothing to highlight
      value = value.toLowerCase();
      for (int offset = 0, index = value.indexOf(pattern, offset);
          index >= 0 && offset < value.length();
          index = value.indexOf(pattern, offset)) {
        Spannable span = new SpannableString(view.getText());
        span.setSpan(
            new ForegroundColorSpan(
                MaterialColors.getColor(
                    view, com.google.android.material.R.attr.colorPrimaryContainer)),
            index,
            index + pattern.length(),
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        view.setText(span);
        offset += index + pattern.length();
      }
    }
  }

  class AppNameLoader implements Runnable {
    private PackageInfo package_info;

    public AppNameLoader(PackageInfo info) {
      package_info = info;
    }

    @Override
    public void run() {
      cache_appName.put(
          package_info.packageName,
          (String) package_info.applicationInfo.loadLabel(packageManager));
      handler.post(
          new Runnable() {
            @Override
            public void run() {
              names_to_load--;
              if (names_to_load == 0) {
                // mActivity.hideProgressBar();
                executorServiceNames.shutdown();
              }
            }
          });
    }
  }

  class GuiLoader implements Runnable {
    private ViewHolder viewHolder;
    private PackageInfo package_info;

    public GuiLoader(ViewHolder h, PackageInfo info) {
      viewHolder = h;
      package_info = info;
    }

    @Override
    public void run() {
      boolean first = true;
      do {
        try {
          final String appName =
              cache_appName.containsKey(package_info.packageName)
                  ? cache_appName.get(package_info.packageName)
                  : (String) package_info.applicationInfo.loadLabel(packageManager);
          var icon = package_info.applicationInfo.loadIcon(packageManager);
          cache_appName.put(package_info.packageName, appName);
          cache_appIcon.put(package_info.packageName, icon);
          handler.post(
              new Runnable() {
                @Override
                public void run() {
                  viewHolder.setAppName(appName, search_pattern);
                  viewHolder.imgIcon.setImageDrawable(icon);
                }
              });

        } catch (OutOfMemoryError ex) {
          cache_appIcon.clear();
          cache_appName.clear();
          if (first) {
            first = false;
            continue;
          }
        }
        break;
      } while (true);
    }
  }
}
