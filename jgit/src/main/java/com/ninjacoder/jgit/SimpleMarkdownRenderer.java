package com.ninjacoder.jgit;

import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * این کلاس توسط من ایجاد نشده
 * کد منبع اصلی این کلاس سورا ادیتور و به زبان کاتلین است
 * من ان را با دیپ سیک ترجمه کردم به جاوا و باگ های ان را رفع کردم
 * کد منبع اصلی را اینجا تماشا کنید
 *{@link https://github.com/Rosemoe/sora-editor/blob/d0dfbc38535957deed45eefbd1fd333ead507924/editor-lsp/src/main/java/io/github/rosemoe/sora/lsp/editor/text/SimpleMarkdownRenderer.kt }
 */
public class SimpleMarkdownRenderer {

  private static final int SPAN_MODE = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;
  private static final Pattern unorderedPattern = Pattern.compile("^[\\*\\-+]\\s+.+");
  private static final Pattern orderedPattern = Pattern.compile("^(\\d+)\\.\\s+.+");
  private static final Pattern markerPattern = Pattern.compile("^(?:\\d+\\.|[\\*\\-+])\\s+");
  private static final Pattern brRegex = Pattern.compile("(?i)<br\\s*/?>");
  private static final Pattern headingRegex = Pattern.compile("(?is)<h([1-6])[^>]*>(.*?)</h\\1>");
  private static final Pattern blockquoteRegex =
      Pattern.compile("(?is)<blockquote[^>]*>(.*?)</blockquote>");
  private static final Pattern strongRegex = Pattern.compile("(?is)<strong[^>]*>(.*?)</strong>");
  private static final Pattern emRegex = Pattern.compile("(?is)<em[^>]*>(.*?)</em>");
  private static final Pattern codeRegex = Pattern.compile("(?is)<code[^>]*>(.*?)</code>");
  private static final Pattern preRegex = Pattern.compile("(?is)<pre[^>]*>(.*?)</pre>");
  private static final Pattern liRegex = Pattern.compile("(?is)<li[^>]*>(.*?)</li>");
  private static final Pattern linkRegex =
      Pattern.compile("(?is)<a[^>]+href\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>(.*?)</a>");
  private static final Pattern ulRegex = Pattern.compile("(?is)</?ul[^>]*>");
  private static final Pattern olRegex = Pattern.compile("(?is)</?ol[^>]*>");
  private static final Pattern pOpenRegex = Pattern.compile("(?is)<p[^>]*>");
  private static final Pattern pCloseRegex = Pattern.compile("(?is)</p>");
  private static final Pattern multiNewlineRegex = Pattern.compile("\n{3,}");
  private static final int leadingMargin = 24;
  private static final int indentMargin = 24;
  private static final String lineSeparator = "──────────";
  private static final float[] DEFAULT_HEADING_SCALE =
      new float[] {1.6f, 1.4f, 1.25f, 1.1f, 1.05f, 1.0f};

  public Spanned render(
      String markdown,
      int boldColor,
      int inlineCodeColor,
      int blockCodeColor,
      Typeface codeTypeface,
      Integer linkColor,
      float[] headingScale) {
    String normalized = normalize(markdown);
    List<Block> blocks = parseBlocks(normalized);
    return build(
        blocks, boldColor, inlineCodeColor, blockCodeColor, codeTypeface, linkColor, headingScale);
  }

  public Spanned render(
      String markdown,
      int boldColor,
      int inlineCodeColor,
      int blockCodeColor,
      Typeface codeTypeface) {
    return render(
        markdown,
        boldColor,
        inlineCodeColor,
        blockCodeColor,
        codeTypeface,
        null,
        DEFAULT_HEADING_SCALE);
  }

  private Spanned build(
      List<Block> blocks,
      int boldColor,
      int inlineCodeColor,
      int blockCodeColor,
      Typeface codeTypeface,
      Integer linkColor,
      float[] headingScale) {
    SpannableStringBuilder builder = new SpannableStringBuilder();
    boolean firstBlock = true;

    for (Block block : blocks) {
      if (builder.length() > 0) {
        if (!firstBlock) {
          builder.append("\n\n");
        }
      }

      if (block instanceof Block.Heading) {
        Block.Heading heading = (Block.Heading) block;
        int start = builder.length();
        appendInlines(
            builder, heading.inlines, boldColor, inlineCodeColor, codeTypeface, linkColor);
        int end = builder.length();
        builder.setSpan(new StyleSpan(Typeface.BOLD), start, end, SPAN_MODE);
        int scaleIndex = Math.max(0, Math.min(heading.level - 1, headingScale.length - 1));
        builder.setSpan(new RelativeSizeSpan(headingScale[scaleIndex]), start, end, SPAN_MODE);
      } else if (block instanceof Block.Paragraph) {
        Block.Paragraph paragraph = (Block.Paragraph) block;
        appendInlines(
            builder, paragraph.inlines, boldColor, inlineCodeColor, codeTypeface, linkColor);
      } else if (block instanceof Block.CodeBlock) {
        Block.CodeBlock codeBlock = (Block.CodeBlock) block;
        int start = builder.length();
        builder.append(codeBlock.content);
        int end = builder.length();
        if (end > start) {
          builder.setSpan(new TypefaceSpanCompat(codeTypeface), start, end, SPAN_MODE);
          builder.setSpan(new ForegroundColorSpan(blockCodeColor), start, end, SPAN_MODE);
        }
      } else if (block instanceof Block.ListBlock) {
        Block.ListBlock listBlock = (Block.ListBlock) block;
        int number = listBlock.startIndex;
        for (List<Inline> item : listBlock.items) {
          if (builder.length() > 0 && builder.charAt(builder.length() - 1) != '\n') {
            builder.append('\n');
          }
          int prefixStart = builder.length();
          String label;
          if (listBlock.ordered) {
            label = String.format(Locale.getDefault(), "%d. ", number);
            number++;
          } else {
            label = "• ";
          }
          builder.append(label);
          int prefixEnd = builder.length();
          int itemStart = builder.length();
          appendInlines(builder, item, boldColor, inlineCodeColor, codeTypeface, linkColor);
          int itemEnd = builder.length();
          builder.setSpan(
              new LeadingMarginSpan.Standard(leadingMargin, leadingMargin + indentMargin),
              prefixStart,
              itemEnd,
              SPAN_MODE);
          if (!listBlock.ordered) {
            builder.setSpan(new StyleSpan(Typeface.BOLD), prefixStart, prefixEnd, SPAN_MODE);
          }
        }
      } else if (block instanceof Block.Quote) {
        Block.Quote quote = (Block.Quote) block;
        int start = builder.length();
        builder.append('│');
        builder.append(' ');
        int contentStart = builder.length();
        appendInlines(builder, quote.inlines, boldColor, inlineCodeColor, codeTypeface, linkColor);
        int end = builder.length();
        builder.setSpan(new StyleSpan(Typeface.ITALIC), contentStart, end, SPAN_MODE);
        builder.setSpan(
            new LeadingMarginSpan.Standard(leadingMargin, leadingMargin + indentMargin),
            start,
            end,
            SPAN_MODE);
      } else if (block instanceof Block.HorizontalRule) {
        builder.append(lineSeparator);
      }
      firstBlock = false;
    }
    return builder;
  }

  private void appendInlines(
      SpannableStringBuilder builder,
      List<Inline> inlines,
      int boldColor,
      int inlineCodeColor,
      Typeface codeTypeface,
      Integer linkColor) {
    for (Inline inline : inlines) {
      if (inline instanceof Inline.Text) {
        Inline.Text text = (Inline.Text) inline;
        builder.append(text.value);
      } else if (inline instanceof Inline.Bold) {
        Inline.Bold bold = (Inline.Bold) inline;
        int start = builder.length();
        appendInlines(builder, bold.children, boldColor, inlineCodeColor, codeTypeface, linkColor);
        int end = builder.length();
        builder.setSpan(new StyleSpan(Typeface.BOLD), start, end, SPAN_MODE);
        builder.setSpan(new ForegroundColorSpan(boldColor), start, end, SPAN_MODE);
      } else if (inline instanceof Inline.Italic) {
        Inline.Italic italic = (Inline.Italic) inline;
        int start = builder.length();
        appendInlines(
            builder, italic.children, boldColor, inlineCodeColor, codeTypeface, linkColor);
        int end = builder.length();
        builder.setSpan(new StyleSpan(Typeface.ITALIC), start, end, SPAN_MODE);
      } else if (inline instanceof Inline.Code) {
        Inline.Code code = (Inline.Code) inline;
        int start = builder.length();
        builder.append(code.value);
        int end = builder.length();
        builder.setSpan(new TypefaceSpanCompat(codeTypeface), start, end, SPAN_MODE);
        builder.setSpan(new ForegroundColorSpan(inlineCodeColor), start, end, SPAN_MODE);
      } else if (inline instanceof Inline.Link) {
        Inline.Link link = (Inline.Link) inline;
        int start = builder.length();
        appendInlines(builder, link.label, boldColor, inlineCodeColor, codeTypeface, linkColor);
        int end = builder.length();
        builder.setSpan(new URLSpan(link.url), start, end, SPAN_MODE);
        if (linkColor != null) {
          builder.setSpan(new ForegroundColorSpan(linkColor), start, end, SPAN_MODE);
        }
      }
    }
  }

  private List<Block> parseBlocks(String text) {
    List<Block> blocks = new ArrayList<>();
    String[] lines = text.split("\n");
    int index = 0;
    while (index < lines.length) {
      String raw = lines[index];
      String line = raw.trim();
      if (line.isEmpty()) {
        index++;
        continue;
      }
      if (line.startsWith("```")) {
        BlockResult<Block.CodeBlock> result = parseCodeBlock(lines, index);
        blocks.add(result.block);
        index = result.nextIndex;
        continue;
      }
      if (isHeading(line)) {
        Block.Heading result = parseHeading(line);
        blocks.add(result);
        index++;
        continue;
      }
      if (isHorizontalRule(line)) {
        blocks.add(new Block.HorizontalRule());
        index++;
        continue;
      }
      if (isQuote(line)) {
        BlockResult<Block.Quote> result = parseQuote(lines, index);
        blocks.add(result.block);
        index = result.nextIndex;
        continue;
      }
      if (isList(line)) {
        BlockResult<Block.ListBlock> result = parseList(lines, index);
        blocks.add(result.block);
        index = result.nextIndex;
        continue;
      }
      BlockResult<Block.Paragraph> result = parseParagraph(lines, index);
      blocks.add(result.block);
      index = result.nextIndex;
    }
    return blocks;
  }

  private BlockResult<Block.CodeBlock> parseCodeBlock(String[] lines, int startIndex) {
    StringBuilder builder = new StringBuilder();
    int index = startIndex + 1;
    while (index < lines.length) {
      String line = lines[index];
      if (line.trim().startsWith("```")) {
        index++;
        break;
      }
      if (builder.length() > 0) {
        builder.append('\n');
      }
      builder.append(line);
      index++;
    }
    return new BlockResult<>(new Block.CodeBlock(builder.toString()), index);
  }

  private Block.Heading parseHeading(String line) {
    int level = 0;
    while (level < line.length() && line.charAt(level) == '#') {
      level++;
    }
    String content = line.substring(level).trim();
    List<Inline> inlines = parseInlines(content);
    return new Block.Heading(Math.max(1, Math.min(level, 6)), inlines);
  }

  private BlockResult<Block.Quote> parseQuote(String[] lines, int startIndex) {
    StringBuilder builder = new StringBuilder();
    int index = startIndex;
    while (index < lines.length) {
      String line = lines[index];
      if (!isQuote(line.trim())) {
        break;
      }
      String content = line.trim().substring(1).trim();
      if (builder.length() > 0) {
        builder.append('\n');
      }
      builder.append(content);
      index++;
    }
    return new BlockResult<>(new Block.Quote(parseInlines(builder.toString())), index);
  }

  private BlockResult<Block.ListBlock> parseList(String[] lines, int startIndex) {
    List<List<Inline>> items = new ArrayList<>();
    int index = startIndex;
    String firstLine = lines[index].trim();
    boolean ordered = isOrderedList(firstLine);
    int counter = extractListNumber(firstLine);

    while (index < lines.length) {
      String raw = lines[index];
      String trimmed = raw.trim();
      if (!isList(trimmed)) {
        break;
      }
      int markerEnd = listMarkerEnd(trimmed);
      StringBuilder contentBuilder = new StringBuilder(trimmed.substring(markerEnd).trim());
      index++;

      while (index < lines.length) {
        String cont = lines[index];
        if (cont.isEmpty()) {
          break;
        }
        if (cont.startsWith("    ") || cont.startsWith("\t")) {
          contentBuilder.append('\n');
          contentBuilder.append(cont.trim());
          index++;
          continue;
        }
        break;
      }
      items.add(parseInlines(contentBuilder.toString()));
    }

    if (!ordered) {
      counter = 1;
    }
    if (ordered && counter <= 0) {
      counter = 1;
    }
    return new BlockResult<>(new Block.ListBlock(ordered, items, counter), index);
  }

  private BlockResult<Block.Paragraph> parseParagraph(String[] lines, int startIndex) {
    StringBuilder builder = new StringBuilder();
    int index = startIndex;
    while (index < lines.length) {
      String line = lines[index];
      if (line.trim().isEmpty()) {
        break;
      }
      if (isBoundary(line.trim())) {
        break;
      }
      if (builder.length() > 0) {
        builder.append(' ');
      }
      builder.append(line.trim());
      index++;
    }
    return new BlockResult<>(new Block.Paragraph(parseInlines(builder.toString())), index);
  }

  private boolean isBoundary(String line) {
    if (line.isEmpty()) {
      return true;
    }
    if (line.startsWith("```")) {
      return true;
    }
    if (isHeading(line)) {
      return true;
    }
    if (isQuote(line)) {
      return true;
    }
    if (isHorizontalRule(line)) {
      return true;
    }
    return isList(line);
  }

  private List<Inline> parseInlines(String text) {
    List<Inline> nodes = new ArrayList<>();
    int index = 0;
    int length = text.length();

    while (index < length) {
      char current = text.charAt(index);
      if (current == '`') {
        int closing = text.indexOf('`', index + 1);
        if (closing > index) {
          String content = text.substring(index + 1, closing);
          nodes.add(new Inline.Code(content));
          index = closing + 1;
          continue;
        }
      }
      if (current == '*' || current == '_') {
        String delimiter =
            (index + 1 < length && text.charAt(index + 1) == current)
                ? String.valueOf(current) + current
                : String.valueOf(current);
        int closing = findClosing(text, delimiter, index);
        if (closing > index) {
          String inside = text.substring(index + delimiter.length(), closing);
          List<Inline> children = parseInlines(inside);
          if (delimiter.length() == 2) {
            nodes.add(new Inline.Bold(children));
          } else {
            nodes.add(new Inline.Italic(children));
          }
          index = closing + delimiter.length();
          continue;
        }
      }
      if (current == '[') {
        int closingBracket = findClosingBracket(text, index);
        if (closingBracket > index) {
          String label = text.substring(index + 1, closingBracket);
          int urlStart = closingBracket + 1;
          if (urlStart < length && text.charAt(urlStart) == '(') {
            int closingParen = findClosingParen(text, urlStart);
            if (closingParen > urlStart) {
              String url = text.substring(urlStart + 1, closingParen);
              List<Inline> children = parseInlines(label);
              nodes.add(new Inline.Link(children, url));
              index = closingParen + 1;
              continue;
            }
          }
        }
      }
      int nextIndex = nextSpecial(text, index);
      String content = text.substring(index, nextIndex);
      nodes.add(new Inline.Text(content));
      index = nextIndex;
    }
    return mergeText(nodes);
  }

  private int nextSpecial(String text, int start) {
    int index = start;
    while (index < text.length()) {
      char c = text.charAt(index);
      if (c == '`' || c == '*' || c == '_' || c == '[') {
        break;
      }
      index++;
    }
    return Math.max(index, start + 1);
  }

  private List<Inline> mergeText(List<Inline> nodes) {
    List<Inline> merged = new ArrayList<>();
    StringBuilder buffer = new StringBuilder();

    for (Inline node : nodes) {
      if (node instanceof Inline.Text) {
        buffer.append(((Inline.Text) node).value);
      } else {
        if (buffer.length() > 0) {
          merged.add(new Inline.Text(buffer.toString()));
          buffer.setLength(0);
        }
        merged.add(node);
      }
    }
    if (buffer.length() > 0) {
      merged.add(new Inline.Text(buffer.toString()));
    }

    List<Inline> result = new ArrayList<>();
    for (Inline inline : merged) {
      if (!(inline instanceof Inline.Text) || !((Inline.Text) inline).value.isEmpty()) {
        result.add(inline);
      }
    }
    return result;
  }

  private int findClosing(String text, String delimiter, int startIndex) {
    int index = startIndex + delimiter.length();
    while (index <= text.length() - delimiter.length()) {
      if (text.startsWith(delimiter, index)) {
        return index;
      }
      index++;
    }
    return -1;
  }

  private int findClosingBracket(String text, int startIndex) {
    int depth = 0;
    int index = startIndex;
    while (index < text.length()) {
      char c = text.charAt(index);
      if (c == '[') {
        depth++;
      } else if (c == ']') {
        depth--;
        if (depth == 0) {
          return index;
        }
      }
      index++;
    }
    return -1;
  }

  private int findClosingParen(String text, int startIndex) {
    int depth = 0;
    int index = startIndex;
    while (index < text.length()) {
      char c = text.charAt(index);
      if (c == '(') {
        depth++;
      } else if (c == ')') {
        depth--;
        if (depth == 0) {
          return index;
        }
      }
      index++;
    }
    return -1;
  }

  private boolean isHeading(String line) {
    if (!line.startsWith("#")) {
      return false;
    }
    int count = 0;
    while (count < line.length() && line.charAt(count) == '#') {
      count++;
    }
    if (count == line.length()) {
      return false;
    }
    return Character.isWhitespace(line.charAt(count));
  }

  private boolean isQuote(String line) {
    return line.startsWith(">");
  }

  private boolean isHorizontalRule(String line) {
    String trimmed = line.replace(" ", "");
    return trimmed.equals("***") || trimmed.equals("---") || trimmed.equals("___");
  }

  private boolean isList(String line) {
    return unorderedPattern.matcher(line).matches() || orderedPattern.matcher(line).matches();
  }

  private boolean isOrderedList(String line) {
    return orderedPattern.matcher(line).matches();
  }

  private int extractListNumber(String line) {
    Matcher matcher = orderedPattern.matcher(line);
    if (matcher.matches()) {
      try {
        return Integer.parseInt(matcher.group(1));
      } catch (NumberFormatException e) {
        return 1;
      }
    }
    return 1;
  }

  private int listMarkerEnd(String line) {
    Matcher matcher = markerPattern.matcher(line);
    if (matcher.find()) {
      return matcher.end();
    }
    return 0;
  }

  private String normalize(String input) {
    String text = input.replace("\r\n", "\n");
    text = text.replace("\r", "\n");
    text = brRegex.matcher(text).replaceAll("\n");

    text =
        replacePattern(
            text,
            headingRegex,
            new PatternReplacer() {
              @Override
              public String replace(Matcher matcher) {
                int level = Integer.parseInt(matcher.group(1));
                String body = matcher.group(2).trim();
                return "#".repeat(level) + " " + body;
              }
            });

    text =
        replacePattern(
            text,
            blockquoteRegex,
            new PatternReplacer() {
              @Override
              public String replace(Matcher matcher) {
                String body = matcher.group(1).trim();
                return "> " + body;
              }
            });

    text = strongRegex.matcher(text).replaceAll("**$1**");
    text = emRegex.matcher(text).replaceAll("*$1*");
    text = codeRegex.matcher(text).replaceAll("`$1`");

    text =
        replacePattern(
            text,
            preRegex,
            new PatternReplacer() {
              @Override
              public String replace(Matcher matcher) {
                String body = matcher.group(1);
                return "```\n" + body + "\n```";
              }
            });

    text =
        replacePattern(
            text,
            liRegex,
            new PatternReplacer() {
              @Override
              public String replace(Matcher matcher) {
                String body = matcher.group(1).trim();
                return "- " + body;
              }
            });

    text =
        replacePattern(
            text,
            linkRegex,
            new PatternReplacer() {
              @Override
              public String replace(Matcher matcher) {
                String href = matcher.group(1);
                String label = matcher.group(2);
                return "[" + label + "](" + href + ")";
              }
            });

    text = ulRegex.matcher(text).replaceAll("");
    text = olRegex.matcher(text).replaceAll("");
    text = pCloseRegex.matcher(text).replaceAll("\n\n");
    text = pOpenRegex.matcher(text).replaceAll("");
    text = text.replace("&nbsp;", " ");
    text = text.replace("&lt;", "<");
    text = text.replace("&gt;", ">");
    text = text.replace("&amp;", "&");
    text = multiNewlineRegex.matcher(text).replaceAll("\n\n");
    return text.trim();
  }

  private String replacePattern(String text, Pattern pattern, PatternReplacer replacer) {
    Matcher matcher = pattern.matcher(text);
    StringBuffer sb = new StringBuffer();
    while (matcher.find()) {
      matcher.appendReplacement(sb, replacer.replace(matcher));
    }
    matcher.appendTail(sb);
    return sb.toString();
  }

  private interface PatternReplacer {
    String replace(Matcher matcher);
  }

  private static class TypefaceSpanCompat extends MetricAffectingSpan {
    private final Typeface typeface;

    public TypefaceSpanCompat(Typeface typeface) {
      this.typeface = typeface;
    }

    @Override
    public void updateDrawState(TextPaint tp) {
      apply(tp);
    }

    @Override
    public void updateMeasureState(TextPaint tp) {
      apply(tp);
    }

    private void apply(TextPaint paint) {
      paint.setTypeface(typeface);
    }
  }

  // Block classes
  private abstract static class Block {
    static class Heading extends Block {
      final int level;
      final List<Inline> inlines;

      Heading(int level, List<Inline> inlines) {
        this.level = level;
        this.inlines = inlines;
      }
    }

    static class Paragraph extends Block {
      final List<Inline> inlines;

      Paragraph(List<Inline> inlines) {
        this.inlines = inlines;
      }
    }

    static class CodeBlock extends Block {
      final String content;

      CodeBlock(String content) {
        this.content = content;
      }
    }

    static class ListBlock extends Block {
      final boolean ordered;
      final List<List<Inline>> items;
      final int startIndex;

      ListBlock(boolean ordered, List<List<Inline>> items, int startIndex) {
        this.ordered = ordered;
        this.items = items;
        this.startIndex = startIndex;
      }
    }

    static class Quote extends Block {
      final List<Inline> inlines;

      Quote(List<Inline> inlines) {
        this.inlines = inlines;
      }
    }

    static class HorizontalRule extends Block {
      HorizontalRule() {}
    }
  }

  // Inline classes
  private abstract static class Inline {
    static class Text extends Inline {
      final String value;

      Text(String value) {
        this.value = value;
      }
    }

    static class Bold extends Inline {
      final List<Inline> children;

      Bold(List<Inline> children) {
        this.children = children;
      }
    }

    static class Italic extends Inline {
      final List<Inline> children;

      Italic(List<Inline> children) {
        this.children = children;
      }
    }

    static class Code extends Inline {
      final String value;

      Code(String value) {
        this.value = value;
      }
    }

    static class Link extends Inline {
      final List<Inline> label;
      final String url;

      Link(List<Inline> label, String url) {
        this.label = label;
        this.url = url;
      }
    }
  }

  // Helper class for block parsing results
  private static class BlockResult<T extends Block> {
    final T block;
    final int nextIndex;

    BlockResult(T block, int nextIndex) {
      this.block = block;
      this.nextIndex = nextIndex;
    }
  }
}
