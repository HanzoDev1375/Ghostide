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
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.color.MaterialColors;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import ir.ninjacoder.prograsssheet.perfence.ListItemView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.activities.ApkViewActivity;

public class ApkListAdapter extends RecyclerView.Adapter<ApkListAdapter.ViewHolder> {

  private ApkViewActivity mActivity;
  private PackageManager packageManager;

  private ThreadFactory tFactory =
      r -> {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
      };

  private ArrayList<PackageInfo> list = new ArrayList<>();
  private ArrayList<PackageInfo> listOriginal = new ArrayList<>();
  private ExecutorService executorServiceNames = Executors.newFixedThreadPool(3, tFactory);
  private ExecutorService executorServiceIcons = Executors.newFixedThreadPool(3, tFactory);
  private Handler handler = new Handler(Looper.getMainLooper());

  private Map<String, String> cacheAppName =
      Collections.synchronizedMap(
          new LinkedHashMap<String, String>(10, 1.5f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
              return size() > 100;
            }
          });

  private Map<String, Drawable> cacheAppIcon =
      Collections.synchronizedMap(
          new LinkedHashMap<String, Drawable>(10, 1.5f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Drawable> eldest) {
              return size() > 50;
            }
          });

  private String searchPattern;
  private int namesToLoad = 0;

  public ApkListAdapter(ApkViewActivity activity) {
    this.packageManager = activity.getPackageManager();
    mActivity = activity;
    setHasStableIds(true);
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
    View view =
        LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
    return new ViewHolder(view, this);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int i) {
    PackageInfo item = list.get(i);
    holder.setPackageName(item.packageName, searchPattern);

    if (cacheAppIcon.containsKey(item.packageName) && cacheAppName.containsKey(item.packageName)) {
      holder.setAppName(cacheAppName.get(item.packageName), searchPattern);
      holder.imgIcon.setImageDrawable(cacheAppIcon.get(item.packageName));
    } else {
      holder.setAppName(item.packageName, searchPattern);
      holder.imgIcon.setImageDrawable(null);
      executorServiceIcons.submit(new GuiLoader(holder, item));
    }
    holder.listitemview.setBackground(holder.listitemview.get(list,i));
  }

  @Override
  public long getItemId(int position) {
    return list.get(position).packageName.hashCode();
  }

  public PackageInfo getItem(int pos) {
    return list.get(pos);
  }

  @Override
  public int getItemCount() {
    return list.size();
  }

  public void addItem(PackageInfo item) {
    namesToLoad++;
    executorServiceNames.submit(new AppNameLoader(item));
    listOriginal.add(item);
    filterListByPattern();
    notifyItemInserted(list.size() - 1);
  }

  public void clearItems() {
    list.clear();
    listOriginal.clear();
    notifyDataSetChanged();
  }

  public void setSearchPattern(String pattern) {
    searchPattern = pattern != null ? pattern.toLowerCase() : null;
    filterListByPattern();
    notifyDataSetChanged();
  }

  private void filterListByPattern() {
    list.clear();

    for (PackageInfo info : listOriginal) {
      boolean add = true;

      if (searchPattern != null && !searchPattern.isEmpty()) {
        if (!info.packageName.toLowerCase().contains(searchPattern)) {
          if (!cacheAppName.containsKey(info.packageName)
              || !cacheAppName.get(info.packageName).toLowerCase().contains(searchPattern)) {
            add = false;
          }
        }
      }

      if (add) list.add(info);
    }
  }

  public void sortByName() {
    Collections.sort(
        listOriginal,
        (p1, p2) -> {
          String name1 =
              cacheAppName.containsKey(p1.packageName)
                  ? cacheAppName.get(p1.packageName)
                  : p1.packageName;
          String name2 =
              cacheAppName.containsKey(p2.packageName)
                  ? cacheAppName.get(p2.packageName)
                  : p2.packageName;
          return name1.compareToIgnoreCase(name2);
        });
    filterListByPattern();
    notifyDataSetChanged();
  }

  public void sortByDate() {
    Collections.sort(listOriginal, (p1, p2) -> Long.compare(p2.lastUpdateTime, p1.lastUpdateTime));
    filterListByPattern();
    notifyDataSetChanged();
  }

  public void sortBySize() {
    filterListByPattern();
    notifyDataSetChanged();
  }

  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView imgIcon;
    private ApkListAdapter adapter;
    private TextView txtPackageName;
    private TextView txtAppName;
    private ListItemView listitemview;
    

    public ViewHolder(View v, ApkListAdapter adapter) {
      super(v);
      this.adapter = adapter;
      txtPackageName = v.findViewById(R.id.txtPackageName);
      imgIcon = v.findViewById(R.id.imgIcon);
      txtAppName = v.findViewById(R.id.txtAppName);
      listitemview = v.findViewById(R.id.listitemview);
      v.setOnClickListener(this);

      // انیمیشن کلیک
      v.setOnTouchListener(
          (view, event) -> {
            switch (event.getAction()) {
              case android.view.MotionEvent.ACTION_DOWN:
                view.animate().scaleX(0.97f).scaleY(0.97f).setDuration(100).start();
                break;
              case android.view.MotionEvent.ACTION_UP:
              case android.view.MotionEvent.ACTION_CANCEL:
                view.animate().scaleX(1f).scaleY(1f).setDuration(100).start();
                break;
            }
            return false;
          });
    }

    @Override
    public void onClick(View v) {
      PackageInfo info = adapter.getItem(getAdapterPosition());
      if (info == null) return;

      List<String> items = new ArrayList<>();
      items.add("Save APK");
      items.add("Share APK");
      items.add("App Info");

      try {
        Drawable icon = info.applicationInfo.loadIcon(v.getContext().getPackageManager());
        String appName = info.applicationInfo.loadLabel(packageManager).toString();

        new MaterialAlertDialogBuilder(v.getContext())
            .setTitle(appName)
            .setIcon(icon)
            .setAdapter(
                new ArrayAdapter<>(v.getContext(), android.R.layout.simple_list_item_1, items),
                (dialog, which) -> {
                  switch (which) {
                    case 0:
                      adapter.mActivity.doExtract(info);
                      break;
                    case 1:
                      adapter.mActivity.extractAndShare(info);
                      break;
                    case 2:
                      showAppInfo(v, info);
                      break;
                  }
                })
            .setPositiveButton(android.R.string.cancel, null)
            .show();
      } catch (Exception e) {
        e.printStackTrace();
        mActivity.showMessage("Error: " + e.getMessage());
      }
    }

    private void showAppInfo(View v, PackageInfo info) {
      StringBuilder builder = new StringBuilder();
      builder.append("Version Code: ").append(info.versionCode).append("\n\n");
      builder.append("Version Name: ").append(info.versionName).append("\n\n");
      builder.append("Target SDK: ").append(info.applicationInfo.targetSdkVersion).append("\n\n");
      builder.append("Min SDK: ").append(info.applicationInfo.minSdkVersion).append("\n\n");
      builder.append("Package: ").append(info.applicationInfo.packageName).append("\n\n");
      builder.append("Data Dir: ").append(info.applicationInfo.dataDir).append("\n\n");
      builder.append("Native Lib: ").append(info.applicationInfo.nativeLibraryDir);

      new MaterialAlertDialogBuilder(v.getContext())
          .setTitle("App Information")
          .setMessage(builder.toString())
          .setPositiveButton(android.R.string.ok, null)
          .show();
    }

    public void setAppName(String name, String highlight) {
      setAndHighlight(txtAppName, name, highlight);
    }

    public void setPackageName(String name, String highlight) {
      setAndHighlight(txtPackageName, name, highlight);
    }

    private void setAndHighlight(TextView view, String value, String pattern) {
      if (pattern == null || pattern.isEmpty() || value == null) {
        view.setText(value);
        return;
      }

      String lowerValue = value.toLowerCase();
      String lowerPattern = pattern.toLowerCase();
      int index = lowerValue.indexOf(lowerPattern);

      if (index >= 0) {
        Spannable span = new SpannableString(value);
        span.setSpan(
            new ForegroundColorSpan(
                MaterialColors.getColor(
                    view, com.google.android.material.R.attr.colorPrimaryContainer)),
            index,
            index + pattern.length(),
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        view.setText(span);
      } else {
        view.setText(value);
      }
    }
  }

  class AppNameLoader implements Runnable {
    private PackageInfo packageInfo;

    public AppNameLoader(PackageInfo info) {
      packageInfo = info;
    }

    @Override
    public void run() {
      try {
        String appName = packageInfo.applicationInfo.loadLabel(packageManager).toString();
        cacheAppName.put(packageInfo.packageName, appName);

        handler.post(
            () -> {
              namesToLoad--;
              if (namesToLoad == 0) {
                executorServiceNames.shutdown();
              }
            });
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  class GuiLoader implements Runnable {
    private ViewHolder viewHolder;
    private PackageInfo packageInfo;

    public GuiLoader(ViewHolder h, PackageInfo info) {
      viewHolder = h;
      packageInfo = info;
    }

    @Override
    public void run() {
      try {
        String appName =
            cacheAppName.containsKey(packageInfo.packageName)
                ? cacheAppName.get(packageInfo.packageName)
                : packageInfo.applicationInfo.loadLabel(packageManager).toString();

        Drawable icon = packageInfo.applicationInfo.loadIcon(packageManager);

        cacheAppName.put(packageInfo.packageName, appName);
        cacheAppIcon.put(packageInfo.packageName, icon);

        handler.post(
            () -> {
              if (viewHolder.getAdapterPosition() != RecyclerView.NO_POSITION) {
                viewHolder.setAppName(appName, searchPattern);
                viewHolder.imgIcon.setImageDrawable(icon);
              }
            });
      } catch (OutOfMemoryError ex) {
        cacheAppIcon.clear();
        cacheAppName.clear();
        System.gc();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
