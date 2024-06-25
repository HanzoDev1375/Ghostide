package com.mcal.uidesigner.common;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.Contract;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class TextToSpeechHelper {
    private final Context context;
    private final Map<String, LanguageTTS> langTTS = new HashMap<>();
    private final Map<String, Map<String, String>> langOperatorWords = new HashMap<>();

    public TextToSpeechHelper(Context context) {
        this.context = context;
        langOperatorWords.put("en", new HashMap<>());
        langOperatorWords.get("en").put("println", "printline");
        langOperatorWords.get("en").put(";", "semicolon");
        langOperatorWords.get("en").put("<", "less than");
        langOperatorWords.get("en").put(">", "greater than");
        langOperatorWords.get("en").put("< =", "less than or equal");
        langOperatorWords.get("en").put("> =", "greater than or equal");
        langOperatorWords.get("en").put("==", "equal equal");
        langOperatorWords.get("en").put("!=", "not equal");
        langOperatorWords.get("en").put("--", "minus minus");
        langOperatorWords.get("en").put("++", "plus plus");
        langOperatorWords.get("en").put("+", "plus");
        langOperatorWords.get("en").put("-", "minus");
        langOperatorWords.get("en").put("*", "star");
        langOperatorWords.get("en").put("/", "slash");

        langOperatorWords.put("de", new HashMap<>());
        langOperatorWords.get("de").put("println", "printlein");
        langOperatorWords.get("de").put(";", "Strichpunkt");
        langOperatorWords.get("de").put("<", "kleiner als");
        langOperatorWords.get("de").put(">", "grösser als");
        langOperatorWords.get("de").put("< =", "kleiner gleich");
        langOperatorWords.get("de").put("> =", "grösser gleich");
        langOperatorWords.get("de").put("==", "gleich gleich");
        langOperatorWords.get("de").put("!=", "ungleich");
        langOperatorWords.get("de").put("--", "minus minus");
        langOperatorWords.get("de").put("++", "plus plus");
        langOperatorWords.get("de").put("+", "plus");
        langOperatorWords.get("de").put("-", "minus");
        langOperatorWords.get("de").put("*", "Stern");
        langOperatorWords.get("de").put("/", "Strich");

        langOperatorWords.put("ru", new HashMap<>());
        langOperatorWords.get("ru").put("println", "принтлайн");
        langOperatorWords.get("ru").put(";", "точка с запятой");
        langOperatorWords.get("ru").put("<", "меньше");
        langOperatorWords.get("ru").put(">", "больше");
        langOperatorWords.get("ru").put("< =", "меньше или равно");
        langOperatorWords.get("ru").put("> =", "больше или равно");
        langOperatorWords.get("ru").put("==", "равно равно");
        langOperatorWords.get("ru").put("!=", "не равно");
        langOperatorWords.get("ru").put("--", "минус минус");
        langOperatorWords.get("ru").put("++", "плюс плюс");
        langOperatorWords.get("ru").put("+", "плюс");
        langOperatorWords.get("ru").put("-", "минус");
        langOperatorWords.get("ru").put("*", "звёздочка");
        langOperatorWords.get("ru").put("/", "слеш");
    }

    public void shutdown() {
        for (LanguageTTS tts : langTTS.values()) {
            tts.shutdown();
        }
    }

    public void speak(String language, String html) {
        if (!langTTS.containsKey(language)) {
            langTTS.put(language, new LanguageTTS(language));
        }
        langTTS.get(language).speak(html);
    }


    public class LanguageTTS {
        private final String ttsLanguage;
        private boolean initialized;
        private TextToSpeech tts;
        private Locale ttsLocale;
        private String ttsText;

        public LanguageTTS(String language) {
            ttsLanguage = language;
            Locale[] arr = Locale.getAvailableLocales();
            int len = arr.length;
            int i = 0;
            while (true) {
                if (i >= len) {
                    break;
                }
                Locale l = arr[i];
                if (ttsLanguage.equals(l.getLanguage())) {
                    ttsLocale = l;
                    break;
                }
                i++;
            }
            if (ttsLocale != null) {
                tts = new TextToSpeech(context, p1 -> {
                    initialized = true;
                    if (tts != null) {
                        int isLanguageAvailable = tts.isLanguageAvailable(ttsLocale);
                        Log.d("LanguageTTS", ttsLocale + " TTS available: " + isLanguageAvailable);
                        if (isLanguageAvailable == -1) {
                            tts.shutdown();
                            tts = null;
                        } else if (isLanguageAvailable == -2) {
                            tts.shutdown();
                            tts = null;
                        } else {
                            tts.getDefaultEngine();
                            tts.setLanguage(ttsLocale);
                            if (ttsText != null) {
                                tts.speak(ttsText, 0, null);
                                ttsText = null;
                            }
                        }
                    }
                });
            }
        }

        public void shutdown() {
            if (tts != null) {
                tts.shutdown();
            }
        }

        public void speak(String html) {
            String text = cleanHtml(html);
            if (!initialized || tts == null) {
                ttsText = text;
            } else {
                tts.speak(text, 0, null);
            }
        }

        @NonNull
        private String cleanHtml(@NonNull String html) {
            String text = html.replace("&lt;", "<").replace("&gt;", ">").replace("&quot;", "");
            Map<String, String> words = langOperatorWords.get(ttsLanguage);
            if (words != null) {
                for (Map.Entry<String, String> entry : words.entrySet()) {
                    text = text.replace("<b>" + entry.getKey() + "</b>", entry.getValue()).replace(" " + entry.getKey() + " ", entry.getValue());
                }
            }
            return replaceUnderscores(text.replace("<b>a</b>", "A").replace("<b>b</b>", "B").replace("<b>c</b>", "C").replace("<b>i</b>", "I").replace("<b>j</b>", "J").replace("<b>k</b>", "K").replace("<b>android:", "<b>").replace("<i>", "").replace("</i>", "").replace("</b>", "").replace("<b>", ""));
        }

        @NonNull
        @Contract("_ -> new")
        private String replaceUnderscores(@NonNull String text) {
            char[] newText = text.toCharArray();
            for (int p = 1; p < newText.length - 1; p++) {
                if (newText[p] == '_' && Character.isLetterOrDigit(newText[p - 1]) && Character.isLetterOrDigit(newText[p + 1])) {
                    newText[p] = ' ';
                }
            }
            return new String(newText);
        }
    }
}
