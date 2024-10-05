package com.ninjacoder.jgit;

import android.annotation.TargetApi;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@TargetApi(33)
public class PHPFormatter {

  public static String format(String unformattedCode) {
    String regexPattern =
        "\"(?:\\\\.|[^\"\\\\])*\"|'(?:\\\\.|[^'\\\\])*'|/\\*[\\s\\S]*?\\*/|//.*|#.*|\\{|\\}|;|#.*";
    Pattern regex = Pattern.compile(regexPattern);
    String code =
        regex
            .matcher(unformattedCode)
            .replaceAll(
                match -> {
                  String matchValue = match.group();
                  if (matchValue.startsWith("//") || matchValue.startsWith("#")) {
                    return matchValue;
                  } else if (matchValue.startsWith("/*") && matchValue.endsWith("*/")) {
                    if (!matchValue.contains("\n")) {
                      return "\n/*\n" + matchValue.substring(2, matchValue.length() - 2) + "\n*/\n";
                    } else {
                      return matchValue;
                    }
                  } else if (matchValue.equals("{")) {
                    return "\n{\n";
                  } else if (matchValue.equals("}")) {
                    return "\n}\n";
                  } else if (matchValue.equals(";")) {
                    return ";\n";
                  } else {
                    return matchValue;
                  }
                });

    String[] lines = code.split("\n");
    List<String> formattedLines = new ArrayList<>();

    int indentationLevel = 0;
    final int indentSize = 4;

    boolean isCommentLine = false;

    for (String line : lines) {
      // Check for comments
      Matcher commentMatcher =
          Pattern.compile("(\"(?:\\\\.|[^\"\\\\])*\"|'(?:\\\\.|[^'\\\\])*'|/\\*|\\*/|//.*|#.*)")
              .matcher(line);
      while (commentMatcher.find()) {
        String value = commentMatcher.group();
        if (value.equals("/*")) {
          isCommentLine = true;
        } else if (value.equals("*/")) {
          isCommentLine = false;
        }
      }

      StringBuilder formattedLine = new StringBuilder();

      if (isCommentLine) {
        formattedLine.append(line.trim());
      } else {
        Matcher segmentMatcher =
            Pattern.compile("(\"(?:\\\\.|[^\"\\\\])*\"|'(?:\\\\.|[^'\\\\])*'|//.*|#.*)")
                .matcher(line);
        List<String> segments = new ArrayList<>();

        while (segmentMatcher.find()) {
          segments.add(segmentMatcher.group());
        }

        int currentIndex = 0;
        for (String segment : segments) {
          int startIndex = line.indexOf(segment, currentIndex);
          if (startIndex > currentIndex) {
            String leadingSpaces = line.substring(currentIndex, startIndex);
            formattedLine.append(leadingSpaces.replaceAll("\\s+", " "));
          }
          formattedLine.append(segment);
          currentIndex = startIndex + segment.length();
        }

        if (currentIndex < line.length()) {
          String trailingSpaces = line.substring(currentIndex);
          formattedLine.append(trailingSpaces.replaceAll("\\s+", " "));
        }
      }

      formattedLines.add(formattedLine.toString());

      String trimmedLine = formattedLine.toString().trim();
      if (trimmedLine.isEmpty() && !isCommentLine) {
        formattedLines.remove(formattedLines.size() - 1);
      } else if (!trimmedLine.isEmpty()) {
        String indentation = " ".repeat(indentationLevel * indentSize);
        formattedLines.set(formattedLines.size() - 1, indentation + trimmedLine);

        if (trimmedLine.equals("{")) {
          indentationLevel++;
        } else if (trimmedLine.equals("}")) {
          if (indentationLevel > 0) indentationLevel--;
          indentation = " ".repeat(indentationLevel * indentSize);
          formattedLines.set(formattedLines.size() - 1, indentation + trimmedLine);
        }
      }
    }

    return String.join("\n", formattedLines);
  }
}
