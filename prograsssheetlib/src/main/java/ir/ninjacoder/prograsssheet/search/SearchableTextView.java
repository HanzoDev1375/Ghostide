package ir.ninjacoder.prograsssheet.search;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchableTextView extends TextView {

  private Paint highlightPaint;
  private Paint currentHighlightPaint;
  private float cornerRadius = 15f;
  private float padding = 8f;
  private int highlightBgColor = Color.parseColor("#FFFFB74B");
  private int highlightTextColor = Color.BLACK;
  private int currentMatchBgColor = highlightBgColor;
  private int currentMatchTextColor = highlightTextColor;
  private String searchQuery = "";
  private List<SearchMatch> searchMatches = new ArrayList<>();
  private int currentMatchIndex = -1;

  public SearchableTextView(Context context) {
    super(context);
    init();
  }

  public SearchableTextView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public SearchableTextView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  private void init() {
    highlightPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    highlightPaint.setStyle(Paint.Style.FILL);
    highlightPaint.setColor(highlightBgColor);
    currentHighlightPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    currentHighlightPaint.setStyle(Paint.Style.FILL);
    currentHighlightPaint.setColor(currentMatchBgColor);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    drawHighlights(canvas);
    drawColoredText(canvas);
  }

  private void drawHighlights(Canvas canvas) {
    if (searchMatches.isEmpty() || getLayout() == null) {
      super.onDraw(canvas);
      return;
    }
    Layout layout = getLayout();
    for (int i = 0; i < searchMatches.size(); i++) {
      SearchMatch match = searchMatches.get(i);
      Paint currentPaint = (i == currentMatchIndex) ? currentHighlightPaint : highlightPaint;
      drawHighlightForMatch(canvas, layout, match, currentPaint);
    }
  }

  private void drawHighlightForMatch(Canvas canvas, Layout layout, SearchMatch match, Paint paint) {
    int start = match.start;
    int end = match.end;
    String text = getText().toString();
    if (start < 0 || end > text.length() || start >= end) {
      return;
    }
    int startLine = layout.getLineForOffset(start);
    int endLine = layout.getLineForOffset(end);
    // محاسبه موقعیت عمودی با دقت بیشتر
    float topPadding = getTotalPaddingTop();
    float leftPadding = getTotalPaddingLeft();
    if (startLine == endLine) {
      // یک خط
      float startX = layout.getPrimaryHorizontal(start) + leftPadding;
      float endX = layout.getPrimaryHorizontal(end) + leftPadding;
      // محاسبه موقعیت عمودی دقیق
      float lineTop = layout.getLineTop(startLine) + topPadding;
      float lineBottom = layout.getLineBottom(startLine) + topPadding;
      float lineHeight = lineBottom - lineTop;
      RectF rect = new RectF(startX - padding, lineTop, endX + padding, lineBottom);
      canvas.drawRoundRect(rect, cornerRadius, cornerRadius, paint);
    } else {
      // خط اول
      float startX = layout.getPrimaryHorizontal(start) + leftPadding;
      float endX = layout.getLineRight(startLine) + leftPadding;
      float firstLineTop = layout.getLineTop(startLine) + topPadding;
      float firstLineBottom = layout.getLineBottom(startLine) + topPadding;
      RectF firstRect = new RectF(startX - padding, firstLineTop, endX + padding, firstLineBottom);
      canvas.drawRoundRect(firstRect, cornerRadius, cornerRadius, paint);
      // خطوط میانی
      for (int line = startLine + 1; line < endLine; line++) {
        float lineStartX = layout.getLineLeft(line) + leftPadding;
        float lineEndX = layout.getLineRight(line) + leftPadding;
        float midLineTop = layout.getLineTop(line) + topPadding;
        float midLineBottom = layout.getLineBottom(line) + topPadding;
        RectF midRect =
            new RectF(lineStartX - padding, midLineTop, lineEndX + padding, midLineBottom);
        canvas.drawRoundRect(midRect, cornerRadius, cornerRadius, paint);
      }
      // خط آخر
      float lastStartX = layout.getLineLeft(endLine) + leftPadding;
      float lastEndX = layout.getPrimaryHorizontal(end) + leftPadding;
      float lastLineTop = layout.getLineTop(endLine) + topPadding;
      float lastLineBottom = layout.getLineBottom(endLine) + topPadding;
      RectF lastRect =
          new RectF(lastStartX - padding, lastLineTop, lastEndX + padding, lastLineBottom);
      canvas.drawRoundRect(lastRect, cornerRadius, cornerRadius, paint);
    }
  }

  private void drawColoredText(Canvas canvas) {
    if (searchMatches.isEmpty() || getLayout() == null) {
      super.onDraw(canvas);
      return;
    }
    Layout layout = getLayout();
    String text = getText().toString();
    TextPaint textPaint = getPaint();
    int defaultTextColor = getCurrentTextColor();
    float leftPadding = getTotalPaddingLeft();
    float topPadding = getTotalPaddingTop();
    int lastEnd = 0;
    for (int i = 0; i < searchMatches.size(); i++) {
      SearchMatch match = searchMatches.get(i);
      // رسم متن قبل از match
      if (lastEnd < match.start) {
        drawTextSegment(
            canvas, layout, text, lastEnd, match.start, defaultTextColor, leftPadding, topPadding);
      }
      // رسم متن match با رنگ مخصوص
      int matchColor = (i == currentMatchIndex) ? currentMatchTextColor : highlightTextColor;
      drawTextSegment(
          canvas, layout, text, match.start, match.end, matchColor, leftPadding, topPadding);
      lastEnd = match.end;
    }
    // رسم باقی‌مانده متن
    if (lastEnd < text.length()) {
      drawTextSegment(
          canvas, layout, text, lastEnd, text.length(), defaultTextColor, leftPadding, topPadding);
    }
  }

  private void drawTextSegment(
      Canvas canvas,
      Layout layout,
      String text,
      int start,
      int end,
      int color,
      float leftPadding,
      float topPadding) {
    TextPaint textPaint = getPaint();
    int originalColor = textPaint.getColor();
    textPaint.setColor(color);
    int startLine = layout.getLineForOffset(start);
    int endLine = layout.getLineForOffset(end);
    for (int line = startLine; line <= endLine; line++) {
      int lineStart = layout.getLineStart(line);
      int lineEnd = layout.getLineEnd(line);
      int segmentStart = Math.max(start, lineStart);
      int segmentEnd = Math.min(end, lineEnd);
      if (segmentStart < segmentEnd) {
        float x = layout.getPrimaryHorizontal(segmentStart) + leftPadding;
        float y = layout.getLineBaseline(line) + topPadding;
        String segment = text.substring(segmentStart, segmentEnd);
        canvas.drawText(segment, x, y, textPaint);
      }
    }
    textPaint.setColor(originalColor);
  }

  public void search(String query, SearchTextHelper mod) {
    this.searchQuery = query;
    searchMatches.clear();
    currentMatchIndex = -1;
    if (query == null || query.isEmpty()) {
      invalidate();
      return;
    }
    String text = getText().toString();
    Pattern pattern = null;
    switch (mod) {
      case NORMAL:
        pattern = Pattern.compile(Pattern.quote(query), Pattern.LITERAL);
        break;
      case CASEMODE:
        pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);
        break;
      case REGEX:
        pattern = Pattern.compile(query);
        break;
      default:
        pattern = Pattern.compile(Pattern.quote(query));
        break;
    }

    Matcher matcher = pattern.matcher(text);
    while (matcher.find()) {
      searchMatches.add(new SearchMatch(matcher.start(), matcher.end()));
    }
    if (!searchMatches.isEmpty()) {
      currentMatchIndex = 0;
    }
    invalidate();
  }

  public void nextMatch() {
    if (searchMatches.isEmpty()) return;
    currentMatchIndex = (currentMatchIndex + 1) % searchMatches.size();
    scrollToMatch(currentMatchIndex);
    invalidate();
  }

  public void previousMatch() {
    if (searchMatches.isEmpty()) return;
    currentMatchIndex = (currentMatchIndex - 1 + searchMatches.size()) % searchMatches.size();
    scrollToMatch(currentMatchIndex);
    invalidate();
  }

  private void scrollToMatch(int index) {
    if (index < 0 || index >= searchMatches.size()) return;
    SearchMatch match = searchMatches.get(index);
    if (getLayout() != null) {
      int line = getLayout().getLineForOffset(match.start);
      int y = getLayout().getLineTop(line);
      scrollTo(0, y - getHeight() / 3);
    }
  }

  public void clearSearch() {
    searchMatches.clear();
    currentMatchIndex = -1;
    invalidate();
  }

  public int getMatchCount() {
    return searchMatches.size();
  }

  public int getCurrentMatchIndex() {
    return currentMatchIndex;
  }

  public void setHighlightColors(int bgColor, int textColor) {
    this.highlightBgColor = bgColor;
    this.highlightTextColor = textColor;
    if (highlightPaint != null) {
      highlightPaint.setColor(bgColor);
    }
    invalidate();
  }

  public void setCurrentMatchColors(int bgColor, int textColor) {
    this.currentMatchBgColor = bgColor;
    this.currentMatchTextColor = textColor;
    if (currentHighlightPaint != null) {
      currentHighlightPaint.setColor(bgColor);
    }
    invalidate();
  }

  public void setCornerRadius(float radius) {
    this.cornerRadius = radius;
    invalidate();
  }

  public void setHighlightPadding(float padding) {
    this.padding = padding;
    invalidate();
  }

  private static class SearchMatch {
    int start;
    int end;

    SearchMatch(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
}
