package io.github.rosemoe.sora.langs.sql;

import com.diogonunes.jcolor.AnsiFormat;
import com.diogonunes.jcolor.Attribute;
import io.github.rosemoe.sora.langs.sql.JSQLFormatter.OutputFormat;
import net.sf.jsqlparser.expression.OracleHint;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommentMap extends LinkedHashMap<Integer, Comment> {
  private static final Logger LOGGER = Logger.getLogger(CommentMap.class.getName());

  public static final Pattern COMMENT_PATTERN =
      Pattern.compile(
          "(?:'[^']*+')|(?:\\\"[^\\\"]*+\\\")"
              + "|(^/\\*[^*]*\\*+(?:[^/*][^*]*\\*+)*/\\s?\\n?|/\\*[^*]*\\*+(?:[^/*][^*]*\\*+)*/|--.*?\\r?[\\n])",
          Pattern.DOTALL | Pattern.MULTILINE | Pattern.UNIX_LINES);

  public static final Pattern LINE_END_COMMENT_PATTERN =
      Pattern.compile("(\\/\\*.*\\\\*\\/\\s?[\\,\\)]?\\n)");

  private static final Pattern STRING_PATTERN =
      Pattern.compile(
          "(?:'[^']*+')|(?:\\\"[^\\\"]*+\\\")",
          Pattern.DOTALL | Pattern.MULTILINE | Pattern.UNIX_LINES);

  private static final AnsiFormat ANSI_FORMAT_COMMENT =
      new AnsiFormat(Attribute.CLEAR(), Attribute.BRIGHT_BLACK_TEXT(), Attribute.ITALIC());

  private static StringBuilder appendComment(
      StringBuilder builder, OutputFormat format, String keyword, String before, String after) {
    switch (format) {
      case PLAIN:
        builder.append(before).append(keyword).append(after);
        break;
      case ANSI:
        builder.append(before).append(ANSI_FORMAT_COMMENT.format(keyword)).append(after);
        break;
      default:
        builder.append(before).append(keyword).append(after);
        break;
    }
    return builder;
  }

  @SuppressWarnings({"PMD.CyclomaticComplexity"})
  public CommentMap(String sqlStr) {
    Matcher matcher = COMMENT_PATTERN.matcher(sqlStr);
    while (matcher.find()) {
      String group = matcher.group(0);
      int start = matcher.start(0);
      int end = matcher.end(0);

      if (!STRING_PATTERN.matcher(group).matches()) {
        if (OracleHint.isHintMatch(group)) {
          LOGGER.log(Level.FINE, "Oracle hint {0}", group);
        } else {
          Comment comment = new Comment(start, group);
          if (start == 0 || sqlStr.charAt(start - 1) == '\n' && sqlStr.charAt(end - 1) == '\n') {
            comment.newLine = true;
            comment.extraNewLine = start > 1 && sqlStr.charAt(start - 2) == '\n';
          }
          put(comment.absolutePosition, comment);
        }
      }
    }

    int absolutePosition = 0;
    int relativePosition = 0;
    int totalCommentsLength = 0;

    for (Comment comment : values()) {
      while (absolutePosition < comment.absolutePosition) {
        char c = sqlStr.charAt(absolutePosition);
        if (!Character.isWhitespace(c)) {
          relativePosition++;
        }

        absolutePosition++;
      }
      comment.relativePosition = relativePosition - totalCommentsLength;
      totalCommentsLength += comment.text.replaceAll("\\s", "").length();

      LOGGER.log(
          Level.FINE,
          "Found comment {0} at Position {1} (absolute) {2} (relative).",
          new Object[] {comment.text, comment.absolutePosition, comment.relativePosition});
    }
  }

  @SuppressWarnings({"PMD.CyclomaticComplexity", "PMD.ExcessiveMethodLength"})
  public StringBuilder insertComments(
      StringBuilder sqlStrWithoutComments, OutputFormat outputFormat) {

    StringBuilder builder = new StringBuilder();

    Iterator<Comment> commentIterator = values().iterator();
    if (commentIterator.hasNext()) {
      Comment next = commentIterator.next();

      int relativePosition = 0;
      int ansiStarted = -1;
      boolean wasLastComment = false;

      for (int position = 0; position < sqlStrWithoutComments.length(); position++) {
        String c = sqlStrWithoutComments.substring(position, position + 1);

        if (ansiStarted < 0) {
          while (next.relativePosition <= relativePosition) {
            if (next.extraNewLine) {
              builder.append("\n");
            } else if (next.newLine
                && builder.length() > 1
                && builder.charAt(builder.length() - 1) != '\n') {
              builder.append("\n");
            } else if (!c.matches("\\w")) {
              builder.append(" ");
            }

            if (!next.newLine && next.text.startsWith("--")) {
              appendComment(
                  builder, outputFormat, next.text.trim().replaceFirst("--\\s?", "/* "), "", " */");
            } else {
              appendComment(builder, outputFormat, next.text, "", "");
            }

            if (commentIterator.hasNext()) {
              next = commentIterator.next();
            } else {
              wasLastComment = true;
              break;
            }
          }
        }

        if (wasLastComment) {
          String remaining = sqlStrWithoutComments.substring(position);
          if (next.newLine) {
            int nextBreak = remaining.indexOf('\n');
            if (nextBreak >= 0 && remaining.substring(0, nextBreak).trim().isEmpty()) {
              builder.append(remaining.substring(nextBreak + 1));
            } else {
              builder.append(remaining);
            }
          } else {
            builder.append(remaining);
          }
          break;
        }

        if (ansiStarted < 0
            && position + 2 <= sqlStrWithoutComments.length()
            && sqlStrWithoutComments.substring(position, position + 2).matches("\u001B\\[")) {
          ansiStarted = position;
        }

        if (ansiStarted >= 0
            && sqlStrWithoutComments
                .substring(ansiStarted, position + 1)
                .matches("\u001B\\[[;\\d]*[ -/]*[@-~]")) {
          ansiStarted = -1;
        }

        if (position > 0 && c.equals("\n")) {
          int lastBreak = builder.lastIndexOf("\n");
          if (lastBreak < 0 || builder.substring(lastBreak).trim().length() > 0) {
            builder.append(c);
          }
        } else {
          builder.append(c);
        }

        if (ansiStarted < 0) {
          relativePosition =
              sqlStrWithoutComments
                  .substring(0, position + 1)
                  .replaceAll("\u001B\\[[;\\d]*[ -/]*[@-~]|\\s", "")
                  .length();
        }
      }
    }

    Matcher matcher = LINE_END_COMMENT_PATTERN.matcher(builder);
    ArrayList<Object[]> matches = new ArrayList<>();

    int maxPosition = 0;
    while (matcher.find()) {
      int start = matcher.start(0);

      int lastLineBreak = builder.lastIndexOf("\n", start);
      int pos = start - lastLineBreak;
      maxPosition = Integer.max(maxPosition, pos);
      matches.add(new Object[] {start, pos});
    }

    int subIndent = maxPosition / 4 + (maxPosition % 4 > 0 ? 1 : 0);
    int totalInsertedChars = 0;
    for (Object[] match : matches) {
      int start = (int) match[0];
      int pos = (int) match[1];
      for (int j = pos; j < subIndent * 4; j++) {
        builder.insert(start + totalInsertedChars, " ");
        totalInsertedChars++;
      }
    }

    return builder;
  }

  public int getLength() {
    int length = 0;
    for (Comment c : values()) {
      length += c.text.length();
    }

    return length;
  }
}
