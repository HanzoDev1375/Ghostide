package io.github.rosemoe.sora.widget;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.*;
import android.view.*;

import com.blankj.utilcode.util.SnackbarUtils;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import ir.ninjacoder.ghostide.R;
import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;

import androidx.appcompat.app.AlertDialog;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.function.ToDoubleBiFunction;
import org.json.JSONException;
import org.json.JSONObject;

/*
 *  Code by Ninja coder And Hsham soft
 * make google Translitor Hsham
 * make ui and bing Editor ninja coder
 */

public class Transilt {
  private static ArrayList<HashMap<String, Object>> mao = new ArrayList<>();
  private static String[] arrf = {
    "خودکار",
    "آفریقایی",
    "آلبانیایی",
    "عربی",
    "ارمنی",
    "آذربایجانی",
    "باسک",
    "بلاروسی",
    "بنگالی",
    "بلغاری",
    "کاتالان",
    "چینی",
    "کروات",
    "چک",
    "دانمارکی",
    "هلندی",
    "انگلیسی",
    "استونیایی",
    "فیلیپینی",
    "فنلاندی",
    "فرانسوی",
    "گالیسیایی",
    "گرجستانی",
    "آلمانی",
    "یونانی",
    "گوجراتی",
    "هائیتی‌ای",
    "عبری",
    "هندی",
    "مجارستان",
    "ایسلندی",
    "اندونزیایی",
    "ایرلندی",
    "ایتالیایی",
    "ژاپنی",
    "کانادایی",
    "کره‌ای",
    "لاتین",
    "لتونیایی",
    "لیتوانیایی",
    "مقدونی",
    "مالایی",
    "مالتی",
    "نروژی",
    "فارسی",
    "لهستانی",
    "پرتغالی",
    "رومانیایی",
    "روسی",
    "صربستانی",
    "اسلواک",
    "اسلوونیایی",
    "اسپانیایی",
    "سواحیلی",
    "سوئدی",
    "تامیل",
    "تلوگو",
    "تایلندی",
    "ترکی",
    "اوکراینی",
    "اردو",
    "ویتنامی",
    "ولزی",
    "ییدیش",
    "چینی_ساده",
    "چینی_سنتی"
  };
  public static String[] arrf2 = {
    "auto", "af", "sq", "ar", "hy", "az", "eu", "be", "bn", "bg", "ca", "zh-CN", "hr", "cs", "da",
    "nl", "en", "et", "tl", "fi", "fr", "gl", "ka", "de", "el", "gu", "ht", "iw", "hi", "hu", "is",
    "id", "ga", "it", "ja", "kn", "ko", "la", "lv", "lt", "mk", "ms", "mt", "no", "fa", "pl", "pt",
    "ro", "ru", "sr", "sk", "sl", "es", "sw", "sv", "ta", "te", "th", "tr", "uk", "ur", "vi", "cy",
    "yi", "zh-CN", "zh-TW"
  };
  private static ArrayList<String> aa = new ArrayList<>(Arrays.asList(arrf));
  private static ArrayList<String> cc = new ArrayList<>(Arrays.asList(arrf2));

  public static void StartbyJsonObject(CodeEditor editor, String keyObject) {
    AlertDialog dialog =
        new MaterialAlertDialogBuilder(editor.getContext())
            .setTitle(getTitle())
            .setPositiveButton("ok", (ccc, ddd) -> {})
            .setView(R.layout.finalmotargem)
            .setNegativeButton("ترجمه", (xx, ff) -> {})
            .create();

    dialog.setOnShowListener(
        (var) -> {
          TextInputLayout input = (TextInputLayout) dialog.findViewById(R.id.input);
          TextInputEditText result = (TextInputEditText) dialog.findViewById(R.id.result);
          Spinner sp1 = (Spinner) dialog.findViewById(R.id.sp1);
          Spinner sp2 = (Spinner) dialog.findViewById(R.id.sp2);
          Button postViter = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
          Button inittor = dialog.getButton(DialogInterface.BUTTON_NEGATIVE);

          // فرض کنید jsonObject به شیء JSON شما اشاره کند
          JSONObject jsonObject = new JSONObject();
          // پر کردن jsonObject با داده‌ها
          try {
            // مقدار را از متن انتخاب شده دریافت کنید
            String selectedText = editor.getSelectedText();
            if (selectedText != null && !selectedText.isEmpty()) {
              jsonObject.put(keyObject, selectedText); // مقدار انتخاب شده به عنوان مقدار
            } else {
              Toast.makeText(editor.getContext(), "متنی انتخاب نشده است", Toast.LENGTH_SHORT)
                  .show();
              return; // اگر متنی انتخاب نشده باشد، عملیات متوقف خواهد شد
            }
          } catch (JSONException e) {
            e.printStackTrace();
          }

          // تنظیم آداپترهای اسپینرها و سایر عملیات
          sp1.setAdapter(new Sp1Adapter(mao, editor.getContext()));
          sp2.setAdapter(new Sp2Adapter(mao, editor.getContext()));

          postViter.setEnabled(!editor.getText().toString().isEmpty());

          postViter.setOnClickListener(
              view -> {
                dialog.dismiss();
                SnackbarUtils.with(view)
                    .setMessage(getMassges())
                    .setMessageColor(Color.BLUE)
                    .setBgColor(Color.BLACK)
                    .setDuration(200)
                    .show();
              });

          inittor.setOnClickListener(
              view -> {
                // دریافت مقدار از jsonObject با استفاده از کلید
                String valueToTranslate;
                try {
                  valueToTranslate = jsonObject.getString(keyObject); // مقدار مربوط به کلید
                } catch (JSONException e) {
                  Toast.makeText(editor.getContext(), "خطا در دریافت مقدار", Toast.LENGTH_SHORT)
                      .show();
                  return;
                }

                // ایجاد API ترجمه
                TranslateAPI translateAPI =
                    new TranslateAPI(
                        cc.get(sp1.getSelectedItemPosition()),
                        cc.get(sp2.getSelectedItemPosition()).toLowerCase(),
                        valueToTranslate // مقدار دریافت شده از JSON
                        );

                translateAPI.setTranslateListener(
                    new TranslateAPI.TranslateListener() {
                      @Override
                      public void onSuccess(String translatedText) {
                        result.setText(translatedText);
                      }

                      @Override
                      public void onFailure(String ErrorText) {
                        Toast.makeText(editor.getContext(), ErrorText, Toast.LENGTH_SHORT).show();
                      }
                    });
              });
        });

    dialog.show();
  }

  public static void Start(CodeEditor editor) {

    AlertDialog dialog =
        new MaterialAlertDialogBuilder(editor.getContext())
            .setTitle(getTitle())
            .setPositiveButton(
                "ok",
                (ccc, ddd) -> {
                  //	Toast.makeText(editor.getContext(), getMassges(), Toast.LENGTH_LONG).show();

                })
            .setView(R.layout.finalmotargem)
            .setNegativeButton("ترجمه", (xx, ff) -> {})
            .create();
    dialog.setOnShowListener(
        (var) -> {
          TextInputLayout input = (TextInputLayout) dialog.findViewById(R.id.input);
          TextInputEditText result = (TextInputEditText) dialog.findViewById(R.id.result);
          Spinner sp1 = (Spinner) dialog.findViewById(R.id.sp1);
          Spinner sp2 = (Spinner) dialog.findViewById(R.id.sp2);
          Button postViter = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
          Button inittor = dialog.getButton(DialogInterface.BUTTON_NEGATIVE);
          sp1.setHorizontalScrollBarEnabled(false);
          sp1.setVerticalScrollBarEnabled(false);
          sp2.setHorizontalScrollBarEnabled(false);
          sp2.setVerticalScrollBarEnabled(false);
          sp2.setScrollBarSize(0);
          sp1.setScrollBarSize(0);

          for (int a = 0; a < (int) (aa.size()); a++) {
            {
              HashMap<String, Object> _item = new HashMap<>();
              _item.put("key", aa.get((int) (a)));
              mao.add(_item);
            }
          }
          sp1.setAdapter(new Sp1Adapter(mao, editor.getContext()));
          sp2.setAdapter(new Sp2Adapter(mao, editor.getContext()));
          if (editor.getText().toString().isEmpty()) {
            postViter.setEnabled(false);
          } else {
            postViter.setEnabled(true);
          }
          postViter.setOnClickListener(
              view -> {
                dialog.dismiss();
                SnackbarUtils.with(view)
                    .setMessage(getMassges())
                    .setMessageColor(Color.BLUE)
                    .setBgColor(Color.BLACK)
                    .setDuration(200)
                    .show();
              });
          inittor.setOnClickListener(
              view -> {
                try {
                  TranslateAPI translateAPI =
                      new TranslateAPI(
                          cc.get((int) sp1.getSelectedItemPosition()),
                          cc.get((int) sp2.getSelectedItemPosition()).toLowerCase(),
                          editor.getSelectedText());
                  translateAPI.setTranslateListener(
                      new TranslateAPI.TranslateListener() {
                        @Override
                        public void onSuccess(String translatedText) {

                          result.setText(translatedText);
                        }

                        @Override
                        public void onFailure(String ErrorText) {
                          Toast.makeText(editor.getContext(), ErrorText, 2).show();
                          // SketchwareUtil.showMessage(getApplicationContext(), ErrorText);
                        }
                      });
                } catch (Exception err) {
                  Log.e("Error", err.getMessage());
                }
              });
        });
    View view = dialog.getWindow().getDecorView();
    view.setScaleX(0f);
    view.setScaleY(0f);
    ObjectAnimator alertAnim = new ObjectAnimator();
    ObjectAnimator alertAnim1 = new ObjectAnimator();
    alertAnim.setTarget(view);
    alertAnim.setPropertyName("scaleX");
    alertAnim.setFloatValues((float) (1));
    alertAnim.setDuration((int) (250));
    alertAnim.start();
    alertAnim1.setTarget(view);
    alertAnim1.setPropertyName("scaleY");
    alertAnim1.setFloatValues((float) (1));
    alertAnim1.setDuration((int) (250));
    alertAnim1.start();
    dialog.show();
  }

  protected static String getTitle() {
    return "GhostWeb Translator";
  }

  protected static String getMassges() {
    return "This feature will be available in the next versions online, we are working on it";
  }

  protected static MaterialShapeDrawable shapeDrawable() {
    final MaterialShapeDrawable s =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder().setAllCorners(CornerFamily.ROUNDED, 24f).build());
    s.setFillColor(ColorStateList.valueOf(Color.parseColor("#332A2C")));
    return s;
  }

  public static class TranslateAPI {
    String resp = null;
    String url = null;
    String langFrom = null;
    String langTo = null;
    String word = null;
    private TranslateAPI.TranslateListener listener;

    public TranslateAPI(String langFrom, String langTo, String text) {
      this.langFrom = langFrom;
      this.langTo = langTo;
      this.word = text;
      TranslateAPI.Async async = new TranslateAPI.Async();
      async.execute();
    }

    public void setTranslateListener(TranslateAPI.TranslateListener listener) {
      this.listener = listener;
    }

    public interface TranslateListener {
      public void onSuccess(String translatedText);

      public void onFailure(String ErrorText);
    }

    private class Async extends android.os.AsyncTask<String, String, String> {
      @Override
      protected String doInBackground(String... strings) {
        try {
          url =
              "https://translate.googleapis.com/translate_a/single?"
                  + "client=gtx&"
                  + "sl="
                  + langFrom
                  + "&tl="
                  + langTo
                  + "&dt=t&q="
                  + java.net.URLEncoder.encode(word, "UTF-8");
          java.net.URL obj = new java.net.URL(url);
          java.net.HttpURLConnection con = (java.net.HttpURLConnection) obj.openConnection();
          con.setRequestProperty("User-Agent", "Mozilla/5.0");
          java.io.BufferedReader in =
              new java.io.BufferedReader(new java.io.InputStreamReader(con.getInputStream()));
          String inputLine;
          StringBuffer response = new StringBuffer();
          while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
          }
          in.close();
          resp = response.toString();
        } catch (java.io.UnsupportedEncodingException e) {
          e.printStackTrace();
        } catch (java.net.MalformedURLException e) {
          e.printStackTrace();
        } catch (java.io.IOException e) {
          e.printStackTrace();
        } catch (Exception e) {
          e.printStackTrace();
        }
        return null;
      }

      @Override
      protected void onPreExecute() {
        super.onPreExecute();
      }

      @Override
      protected void onPostExecute(String s) {
        String temp = "";

        if (resp == null) {
          listener.onFailure("Network Error");
        } else {
          try {
            org.json.JSONArray main = new org.json.JSONArray(resp);
            org.json.JSONArray total = (org.json.JSONArray) main.get(0);
            for (int i = 0; i < total.length(); i++) {
              org.json.JSONArray currentLine = (org.json.JSONArray) total.get(i);
              temp = temp + currentLine.get(0).toString();
            }
            android.util.Log.d(android.content.ContentValues.TAG, "onPostExecute: " + temp);

            if (temp.length() > 2) {
              listener.onSuccess(temp);
            } else {
              listener.onFailure("Invalid Input String");
            }
          } catch (org.json.JSONException e) {
            listener.onFailure(e.getLocalizedMessage());
            e.printStackTrace();
          }
        }
        super.onPostExecute(s);
      }

      @Override
      protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
      }

      @Override
      protected void onCancelled(String s) {
        super.onCancelled(s);
      }
    }
  }
}
