package ir.ninjacoder.ghostide.navigator;

import ir.ninjacoder.ghostide.model.CodeNavigationInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmaliParser {
  /**
   * This code was written by Mr. TimScriptov and was written at the request of the ninja in Ghost
   * Web. Thanks to Mr. Timscriptov
   */
  public List<CodeNavigationInfo> getMethodsAndFieldsList(String filePath, String text)
      throws IOException {
    List<CodeNavigationInfo> methodList = new ArrayList<>();
    BufferedReader br = new BufferedReader(new StringReader(text));
    String line;
    int lineIndex = 0;
    if (filePath.endsWith(".smali")) {
      while ((line = br.readLine()) != null) {
        if (line.startsWith(".method ")) {
          String prototype = line.substring(8);
          methodList.add(new CodeNavigationInfo(lineIndex, prototype, true));
        } else if (line.startsWith(".field ")) {
          String prototype = line.substring(7);
          methodList.add(new CodeNavigationInfo(lineIndex, prototype, false));
        }
        lineIndex++;
      }
    } else if (filePath.endsWith(".java")) {
      Matcher matcher;
      String mLine;
      while ((line = br.readLine()) != null) {
        mLine = line.trim();
        if (mLine.length() > 6
            && mLine.charAt(0) == 'p'
            && (mLine.charAt(1) == 'u' || mLine.charAt(1) == 'r')) {
          matcher =
              Pattern.compile(
                      "^[ \\t]*(?:(?:public|protected|private)\\s+)?(?:(static|final|native|synchronized|abstract|threadsafe|transient|<[?\\w\\[\\] ,&]+>|<[^<]*<[?\\w\\[\\] ,&]+>[^>]*>|<[^<]*<[^<]*<[?\\w\\[\\] ,&]+>[^>]*>[^>]*>)\\s+)*(?!return)\\b([\\w.]+)\\b(?:|<[?\\w\\[\\] ,&]+>|<[^<]*<[?\\w\\[\\] ,&]+>[^>]*>|<[^<]*<[^<]*<[?\\w\\[\\] ,&]+>[^>]*>[^>]*>)((?:\\[])*)\\s+\\b\\w+\\b\\s*\\(\\s*(?:\\b([\\w.]+)\\b(?:|<[?\\w\\[\\] ,&]+>|<[^<]*<[?\\w\\[\\] ,&]+>[^>]*>|<[^<]*<[^<]*<[?\\w\\[\\] ,&]+>[^>]*>[^>]*>)((?:\\[])*)(\\.\\.\\.)?\\s+(\\w+)\\b(?![>\\[])\\s*(?:,\\s+\\b([\\w.]+)\\b(?:|<[?\\w\\[\\] ,&]+>|<[^<]*<[?\\w\\[\\] ,&]+>[^>]*>|<[^<]*<[^<]*<[?\\w\\[\\] ,&]+>[^>]*>[^>]*>)((?:\\[])*)(\\.\\.\\.)?\\s+(\\w+)\\b(?![>\\[])\\s*)*)?\\s*\\)(?:\\s*throws [\\w.]+(\\s*,\\s*[\\w.]+))?\\s*[{;][ \\t]*$")
                  .matcher(mLine);
          if (matcher.matches()) {
            String prototype = matcher.group(0);
            if (prototype != null && (prototype.endsWith("{") || prototype.endsWith(";"))) {
              prototype = prototype.substring(0, prototype.length() - 1);
              methodList.add(new CodeNavigationInfo(lineIndex, prototype.trim(), true));
            }
          } else {
            matcher =
                Pattern.compile(
                        "\\s*(?:private|public|protected)?\\s*(?:static)?\\s*(?:final)?\\s*([\\w<>\\[\\] ?.]+|[\\w<>\\[\\], ?.]+)\\s+([\\w, +]+)\\s*=?\\s*(?:new)?\\s*(?:[\\w.]+)?\\s*\\(?\\s*;?")
                    .matcher(mLine);
            if (matcher.matches()) {
              String fieldName = matcher.group(2);
              if (fieldName != null) {
                String fieldType = matcher.group(1);
                if (fieldType != null) {
                  fieldName = fieldType + " " + fieldName;
                }
                methodList.add(new CodeNavigationInfo(lineIndex, fieldName.trim(), false));
              }
            }
          }
        }
        lineIndex++;
      }
    }
    if (!methodList.isEmpty()) {
      return methodList;
    }

    return new ArrayList<>();
  }
}
