package Ninja.coder.Ghostemane.code.utils;

import Ninja.coder.Ghostemane.code.ApplicationLoader;
import Ninja.coder.Ghostemane.code.marco.binder.bindchilder.GhostToast;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class DataUtil {

  public static int TOP = 1;
  public static int CENTER = 2;
  public static int BOTTOM = 3;

  public static void CustomToast(
      Context context,
      String message,
      int textColor,
      int textSize,
      int bgColor,
      int radius,
      int gravity) {
    Toast toast = Toast.makeText(context, message, 2);
    View view = toast.getView();
    TextView textView = view.findViewById(android.R.id.message);
    textView.setTextSize(textSize);
    textView.setTextColor(textColor);
    textView.setGravity(Gravity.CENTER);

    GradientDrawable gradientDrawable = new GradientDrawable();
    gradientDrawable.setColor(bgColor);
    gradientDrawable.setCornerRadius(radius);
    view.setBackground(gradientDrawable);
    view.setPadding(15, 10, 15, 10);
    view.setElevation(10);

    switch (gravity) {
      case 1:
        toast.setGravity(Gravity.TOP, 0, 150);
        break;

      case 2:
        toast.setGravity(Gravity.CENTER, 0, 0);
        break;

      case 3:
        toast.setGravity(Gravity.BOTTOM, 0, 150);
        break;
    }
    toast.show();
  }

  public static void CustomToastWithIcon(
      Context context,
      String message,
      int textColor,
      int textSize,
      int bgColor,
      int radius,
      int gravity,
      int icon) {
    Toast toast = Toast.makeText(context, message, 2);
    View view = toast.getView();
    TextView textView = (TextView) view.findViewById(android.R.id.message);
    textView.setTextSize(textSize);
    textView.setTextColor(textColor);
    textView.setCompoundDrawablesWithIntrinsicBounds(icon, 0, 0, 0);
    textView.setGravity(Gravity.CENTER);
    textView.setCompoundDrawablePadding(10);

    GradientDrawable gradientDrawable = new GradientDrawable();
    gradientDrawable.setColor(bgColor);
    gradientDrawable.setCornerRadius(radius);
    view.setBackground(gradientDrawable);
    view.setPadding(10, 10, 10, 10);
    view.setElevation(10);

    switch (gravity) {
      case 1:
        toast.setGravity(Gravity.TOP, 0, 150);
        break;

      case 2:
        toast.setGravity(Gravity.CENTER, 0, 0);
        break;

      case 3:
        toast.setGravity(Gravity.BOTTOM, 0, 150);
        break;
    }
    toast.show();
  }

  public static void sortListMap(
      final ArrayList<HashMap<String, Object>> listMap,
      final String key,
      final boolean isNumber,
      final boolean ascending) {
    Collections.sort(
        listMap,
        new Comparator<HashMap<String, Object>>() {
          public int compare(
              HashMap<String, Object> compareMap1, HashMap<String, Object> compareMap2) {
            if (isNumber) {
              int count1 = Integer.valueOf(compareMap1.get(key).toString());
              int count2 = Integer.valueOf(compareMap2.get(key).toString());
              if (ascending) {
                return count1 < count2 ? -1 : count1 < count2 ? 1 : 0;
              } else {
                return count1 > count2 ? -1 : count1 > count2 ? 1 : 0;
              }
            } else {
              if (ascending) {
                return (compareMap1.get(key).toString()).compareTo(compareMap2.get(key).toString());
              } else {
                return (compareMap2.get(key).toString()).compareTo(compareMap1.get(key).toString());
              }
            }
          }
        });
  }

  public static void CropImage(Activity activity, String path, int requestCode) {
    try {
      Intent intent = new Intent("com.android.camera.action.CROP");
      File file = new File(path);
      Uri contentUri = Uri.fromFile(file);
      intent.setDataAndType(contentUri, "image/*");
      intent.putExtra("crop", "true");
      intent.putExtra("aspectX", 1);
      intent.putExtra("aspectY", 1);
      intent.putExtra("outputX", 280);
      intent.putExtra("outputY", 280);
      intent.putExtra("return-data", false);
      activity.startActivityForResult(intent, requestCode);
    } catch (ActivityNotFoundException e) {
      Toast.makeText(activity, "Your device doesn't support the crop action!", Toast.LENGTH_SHORT)
          .show();
    }
  }

  public static boolean isConnected(Context context) {
    ConnectivityManager connectivityManager =
        (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
  }

  public static String copyFromInputStream(InputStream inputStream) {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    byte[] buf = new byte[1024];
    int i;
    try {
      while ((i = inputStream.read(buf)) != -1) {
        outputStream.write(buf, 0, i);
      }
      outputStream.close();
      inputStream.close();
    } catch (IOException e) {
    }

    return outputStream.toString();
  }

  public static void hideKeyboard(Context context) {}

  public static void showKeyboard(Context context) {}

  public static void showMessage(Context context, String s) {
    GhostToast.showToast(context,s);
  }
  
 public static void showMessage(String s) {
    Toast.makeText(ApplicationLoader.getContext(), s, Toast.LENGTH_SHORT).show();
  }
  
  public static int getLocationX(View view) {
    int location[] = new int[2];
    view.getLocationInWindow(location);
    return location[0];
  }

  public static int getLocationY(View view) {
    int location[] = new int[2];
    view.getLocationInWindow(location);
    return location[1];
  }

  public static int getRandom(int min, int max) {
    Random random = new Random();
    return random.nextInt(max - min + 1) + min;
  }

  public static ArrayList<Double> getCheckedItemPositionsToArray(ListView list) {
    ArrayList<Double> result = new ArrayList<Double>();
    SparseBooleanArray arr = list.getCheckedItemPositions();
    for (int iIdx = 0; iIdx < arr.size(); iIdx++) {
      if (arr.valueAt(iIdx)) result.add((double) arr.keyAt(iIdx));
    }
    return result;
  }

  public static float getDip(Context context, int input) {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, input, context.getResources().getDisplayMetrics());
  }

  public static int getDisplayWidthPixels(Context context) {
    return context.getResources().getDisplayMetrics().widthPixels;
  }

  public static int getDisplayHeightPixels(Context context) {
    return context.getResources().getDisplayMetrics().heightPixels;
  }

  public static void getAllKeysFromMap(Map<String, Object> map, ArrayList<String> output) {
    if (output == null) return;
    output.clear();
    if (map == null || map.size() < 1) return;
    for (Map.Entry<String, Object> entry : map.entrySet()) {
      output.add(entry.getKey());
    }
  }

  public static <K, V, T> void getAllkeyAsMap(Map<K, V> map, List<T> list) {
    if (list == null) return;
    list.clear();
    for (Map.Entry<K, V> entry : map.entrySet()) {
      list.add((T) entry.getKey());
    }
  }
}
