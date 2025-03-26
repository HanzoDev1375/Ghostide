package ir.ninjacoder.ghostide.databin;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import io.github.rosemoe.sora.langs.xml.XMLLanguage;
import io.github.rosemoe.sora.widget.Sp1Adapter;
import ir.ninjacoder.ghostide.IdeEditor;
import java.util.Arrays;
import java.util.HashMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/** using new XmlTranslator(binding.editor).translateXml(); */
public class XmlTranslator {

  private IdeEditor outputEditText;
  private List<String> translatedStrings;
  private Context context;
  private Spinner spinner;
  private AlertDialog dialog;
  private ArrayList<HashMap<String, Object>> map;

  public static String[] arrf2 = {
    "auto", "af", "sq", "ar", "hy", "az", "eu", "be", "bn", "bg", "ca", "zh-CN", "hr", "cs", "da",
    "nl", "en", "et", "tl", "fi", "fr", "gl", "ka", "de", "el", "gu", "ht", "iw", "hi", "hu", "is",
    "id", "ga", "it", "ja", "kn", "ko", "la", "lv", "lt", "mk", "ms", "mt", "no", "fa", "pl", "pt",
    "ro", "ru", "sr", "sk", "sl", "es", "sw", "sv", "ta", "te", "th", "tr", "uk", "ur", "vi", "cy",
    "yi", "zh-CN", "zh-TW"
  };

  public XmlTranslator(IdeEditor outputEditText, Context context) {
    this.outputEditText = outputEditText;
    this.translatedStrings = new ArrayList<>();
    ArrayList<String> langs = new ArrayList<>(Arrays.asList(arrf2));
    map = new ArrayList<>();
    for (int i = 0; i < langs.size(); ++i) {
      HashMap<String, Object> obj = new HashMap<>();
      obj.put("key", langs.get(i));
      map.add(obj);
    }
    this.context = context;
    spinner = new Spinner(context);
    if (spinner != null) {
      spinner.setPadding(10, 10, 10, 10);
      spinner.setAdapter(new Sp1Adapter(map, context));
      if (spinner.getSelectedItemPosition() == 0) {

      } else {
        outputEditText.setText("");
      }
      dialog =
          new MaterialAlertDialogBuilder(context)
              .setTitle("XmlTranslator ")
              .setView(spinner)
              .setPositiveButton(android.R.string.ok, null)
              .create();
      dialog.setOnShowListener(
          show -> {
            Button button = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
            //     button.setEnabled(spinner.getSelectedItemPosition() == 0 ? true : false);

            button.setOnClickListener(i -> translateXml());
          });
      dialog.show();
    }
  }

  void translateXml() {

    String inputFilePath = outputEditText.getText().toString();

    String langFrom = "auto";
    String langTo = map.get(spinner.getSelectedItemPosition()).get("key").toString();

    try {
      Document doc = Jsoup.parse(inputFilePath, "UTF-8");
      Elements stringElements = doc.select("string");
      for (Element element : stringElements) {
        String key = element.attr("name");
        String value = element.text();

        translateAndAppend(key, value, langFrom, langTo);
      }

      Toast.makeText(context, "ترجمه کامل شد!", Toast.LENGTH_SHORT).show();
      dialog.dismiss();

    } catch (Exception e) {
      e.printStackTrace();
      Toast.makeText(context, "خطا در خواندن فایل XML", Toast.LENGTH_SHORT).show();
    }
  }

  private void translateAndAppend(String key, String value, String langFrom, String langTo) {

    TranslateAPI translateAPI = new TranslateAPI(langFrom, langTo, value);

    translateAPI.setTranslateListener(
        new TranslateAPI.TranslateListener() {
          @Override
          public void onSuccess(String translatedText) {

            translatedStrings.add(
                "    <string name=\"" + key + "\">" + translatedText + "</string>");

            updateEditText();
          }

          @Override
          public void onFailure(String ErrorText) {
            System.err.println("خطا در ترجمه: " + ErrorText);
            Toast.makeText(context, ErrorText, Toast.LENGTH_SHORT).show();
          }
        });
  }

  private void updateEditText() {

    StringBuilder translatedXml = new StringBuilder();
    translatedXml.append("<!-- translatedBy Ghost ide -->\n");
    translatedXml.append("<resources>\n");
    for (String translatedString : translatedStrings) {
      translatedXml.append(translatedString).append("\n");
    }
    translatedXml.append("</resources>");
   
    outputEditText.setText("");
    outputEditText.insertText(translatedXml.toString(),0);
   
  }

  public boolean isXmlLang() {
    if (outputEditText.getEditorLanguage() instanceof XMLLanguage) {
      return true;
    }
    return false;
  }
}
