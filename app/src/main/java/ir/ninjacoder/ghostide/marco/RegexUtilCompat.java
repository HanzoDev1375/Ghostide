package ir.ninjacoder.ghostide.marco;

import java.util.regex.Pattern;

public class RegexUtilCompat {

  public static int isMULTILINE = Pattern.MULTILINE;

  public static int isCaseINSENSITIVE = Pattern.CASE_INSENSITIVE;

  public static boolean RegexSelect(String regexCode, String code, int data) {
    var pattern = Pattern.compile(regexCode, data);
    var matcher = pattern.matcher(code);
    while (matcher.find()) {
      return true;
    }
    return false;
  }

  public static boolean RegexSelect(String regexCode, String code) {
    var pattern = Pattern.compile(regexCode);
    var matcher = pattern.matcher(code);
    while (matcher.find()) {
      return true;
    }
    return false;
  }

  public static String MatchFromString(String regexCode, String code) {
    var pattern = Pattern.compile(regexCode);
    var match = pattern.matcher(code);
    while (match.find()) {
      return match.group();
    }
    return null;
  }

  public static String MatchFromString(String regexCode, String code, int group, int data) {
    var pattern = Pattern.compile(regexCode, data);
    var match = pattern.matcher(code);
    while (match.find()) {
      return match.group(group);
    }
    return null;
  }

  public static String MatchFromString(String regexCode, String code, int group) {
    var pattern = Pattern.compile(regexCode);
    var match = pattern.matcher(code);
    while (match.find()) {
      return match.group(group);
    }
    return null;
  }
}
