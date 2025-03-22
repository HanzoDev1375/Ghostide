package ir.ninjacoder.ghostide.databin;

import android.os.AsyncTask;

public class TranslateAPI {
  String resp = null;
  String url = null;
  String langFrom = null;
  String langTo = null;
  String word = null;
  private TranslateListener listener;

  public TranslateAPI(String langFrom, String langTo, String text) {
    this.langFrom = langFrom;
    this.langTo = langTo;
    this.word = text;
    Async async = new Async();
    async.execute();
  }

  public void setTranslateListener(TranslateAPI.TranslateListener listener) {
    this.listener = listener;
  }

  public interface TranslateListener {
    public void onSuccess(String translatedText);

    public void onFailure(String ErrorText);
  }

  private class Async extends AsyncTask<String, String, String> {
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
