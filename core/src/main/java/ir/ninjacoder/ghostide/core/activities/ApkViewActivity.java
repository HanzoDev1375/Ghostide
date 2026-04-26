package ir.ninjacoder.ghostide.core.activities;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.adapter.ApkListAdapter;
import ir.ninjacoder.ghostide.core.adapter.Extractor;
import ir.ninjacoder.ghostide.core.marco.FileShareManager;

public class ApkViewActivity extends BaseCompat {

  private RecyclerView rv;
  private ApkListAdapter adptor;
  private Toolbar toolbar;
  private AppBarLayout appBar;
  private CoordinatorLayout coordinator;
  private SwipeRefreshLayout swipeRefresh;
  private ProgressBar progressBar;
  private FloatingActionButton fabFilter;

  private ExecutorService executorService;
  private Handler mainHandler;
  private List<PackageInfo> allPackages = new ArrayList<>();
  private boolean isLoading = false;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_apk_view);

    mainHandler = new Handler(Looper.getMainLooper());
    executorService = Executors.newSingleThreadExecutor();

    initViews();
    setupToolbar();
    setupRecyclerView();
    setupSwipeRefresh();
    setupFab();

    checkPermissions();
  }

  private void initViews() {
    appBar = findViewById(R.id.app_bar_apkview);
    toolbar = findViewById(R.id.toolbar_apkview_main);
    swipeRefresh = findViewById(R.id.swipe_refresh);
    progressBar = findViewById(R.id.progress_bar);
    fabFilter = findViewById(R.id.fab_filter);
    rv = findViewById(R.id.rv);
  }

  private void setupToolbar() {
    setSupportActionBar(toolbar);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    toolbar.setNavigationOnClickListener(v -> onBackPressed());
  }

  private void setupRecyclerView() {
    adptor = new ApkListAdapter(this);
    rv.setAdapter(adptor);
    rv.setLayoutManager(new LinearLayoutManager(this));
    rv.setItemAnimator(new DefaultItemAnimator());
    // اضافه کردن DividerItemDecoration
    // میتونید از MaterialDividerItemDecoration استفاده کنید
  }

  private void setupSwipeRefresh() {
    swipeRefresh.setColorSchemeResources(
        R.color.md_theme_primary, R.color.md_theme_secondary, R.color.md_theme_tertiary);

    swipeRefresh.setOnRefreshListener(
        () -> {
          refreshAppList();
        });
  }

  private void setupFab() {
    fabFilter.setOnClickListener(
        v -> {
          showSortOptions();
        });
  }

  private void checkPermissions() {
    if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
            == PackageManager.PERMISSION_DENIED
        || ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            == PackageManager.PERMISSION_DENIED) {
      ActivityCompat.requestPermissions(
          this,
          new String[] {
            Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE
          },
          1000);
    } else {
      loadAppList();
    }
  }

  @Override
  public void onRequestPermissionsResult(
      int requestCode, String[] permissions, int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    if (requestCode == 1000) {
      loadAppList();
    }
  }

  private void loadAppList() {
    if (isLoading) return;

    showLoading(true);
    isLoading = true;

    executorService.execute(
        () -> {
          try {
            List<PackageInfo> packages =
                getPackageManager().getInstalledPackages(PackageManager.GET_META_DATA);

            mainHandler.post(
                () -> {
                  allPackages.clear();
                  allPackages.addAll(packages);
                  adptor.clearItems();

                  for (PackageInfo packageInfo : packages) {
                    adptor.addItem(packageInfo);
                  }

                  showLoading(false);
                  isLoading = false;
                });
          } catch (Exception e) {
            mainHandler.post(
                () -> {
                  showLoading(false);
                  isLoading = false;
                  showMessage("Error loading apps: " + e.getMessage());
                });
          }
        });
  }

  private void refreshAppList() {
    executorService.execute(
        () -> {
          try {
            List<PackageInfo> packages =
                getPackageManager().getInstalledPackages(PackageManager.GET_META_DATA);

            mainHandler.post(
                () -> {
                  allPackages.clear();
                  allPackages.addAll(packages);
                  adptor.clearItems();

                  for (PackageInfo packageInfo : packages) {
                    adptor.addItem(packageInfo);
                  }

                  swipeRefresh.setRefreshing(false);
                  showMessage("App list refreshed");
                });
          } catch (Exception e) {
            mainHandler.post(
                () -> {
                  swipeRefresh.setRefreshing(false);
                  showMessage("Error refreshing: " + e.getMessage());
                });
          }
        });
  }

  private void showLoading(boolean show) {
    if (show) {
      progressBar.setVisibility(View.VISIBLE);
      rv.setVisibility(View.GONE);
    } else {
      progressBar.setVisibility(View.GONE);
      rv.setVisibility(View.VISIBLE);
    }
  }

  private void showSortOptions() {
    String[] options = {"Sort by Name", "Sort by Date", "Sort by Size"};

    new MaterialAlertDialogBuilder(this)
        .setTitle("Sort Apps")
        .setItems(
            options,
            (dialog, which) -> {
              switch (which) {
                case 0:
                  adptor.sortByName();
                  break;
                case 1:
                  adptor.sortByDate();
                  break;
                case 2:
                  adptor.sortBySize();
                  break;
              }
            })
        .setPositiveButton("Cancel", null)
        .show();
  }

  public void _shareApp(final String finalPath) {
    Intent shareApp = new Intent(Intent.ACTION_SEND);
    shareApp.setType("application/vnd.android.package-archive");
    shareApp.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(finalPath)));
    startActivity(Intent.createChooser(shareApp, "Share APK"));
  }

  public void showMessage(String s) {
    Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
  }

  public void doExtract(final PackageInfo info) {
    showLoading(true);

    executorService.execute(
        () -> {
          try {
            Extractor extractor = new Extractor();
            String dst = extractor.extractWithoutRoot(info);

            mainHandler.post(
                () -> {
                  showLoading(false);
                  Toast.makeText(ApkViewActivity.this, "APK saved to: " + dst, Toast.LENGTH_LONG)
                      .show();
                });
          } catch (Exception ex) {
            mainHandler.post(
                () -> {
                  showLoading(false);
                  Toast.makeText(
                          ApkViewActivity.this,
                          "Error extracting: " + ex.getMessage(),
                          Toast.LENGTH_SHORT)
                      .show();
                });
          }
        });
  }

  public void extractAndShare(PackageInfo info) {
    showLoading(true);

    executorService.execute(
        () -> {
          try {
            Extractor extractor = new Extractor();
            String path = extractor.extractWithoutRoot(info);

            mainHandler.post(
                () -> {
                  showLoading(false);
                  FileShareManager sha = new FileShareManager(ApkViewActivity.this);
                  sha.shareFile(new File(path));
                });
          } catch (Exception err) {
            mainHandler.post(
                () -> {
                  showLoading(false);
                  Toast.makeText(
                          ApkViewActivity.this,
                          "Error sharing: " + err.getMessage(),
                          Toast.LENGTH_SHORT)
                      .show();
                });
          }
        });
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main, menu);

    SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
    SearchView searchView =
        (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));

    if (searchView != null && searchManager != null) {
      searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
      searchView.setQueryHint("Search apps...");

      // استایل دادن به SearchView
      searchView.setOnQueryTextFocusChangeListener(
          (view, queryTextFocused) -> {
            if (!queryTextFocused && searchView.getQuery().length() < 1) {
              if (getSupportActionBar() != null) {
                getSupportActionBar().collapseActionView();
              }
            }
          });

      searchView.setOnQueryTextListener(
          new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
              adptor.setSearchPattern(s);
              return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
              adptor.setSearchPattern(s);
              return true;
            }
          });
    }

    return super.onCreateOptionsMenu(menu);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    if (executorService != null && !executorService.isShutdown()) {
      executorService.shutdown();
    }
    mainHandler.removeCallbacksAndMessages(null);
  }
}
