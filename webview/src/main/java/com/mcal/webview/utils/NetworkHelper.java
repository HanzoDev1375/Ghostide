package com.mcal.webview.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;

public class NetworkHelper {

  public static boolean isNetworkAvailable(Context context) {
    ConnectivityManager connectivityManager =
        (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
      NetworkCapabilities capabilities =
          connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
      if (capabilities == null) {
        return false;
      }
      return capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
          || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
          || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR);
    } else {
      if (connectivityManager.getActiveNetworkInfo() != null) {
        return connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();
      }
    }
    return false;
  }
}
