package io.github.rosemoe.sora.widget.commentRule;

import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import io.github.rosemoe.sora.text.TextStyle;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Enhanced BetterCommentHelper with Regex Support
 * 
 * @author ghost خود خوشتیپم
 * @version 2.0.0
 * @since 2026-04-23
 * 
 * This class is responsible for advanced comment processing and highlighting with support for:
 * - Simple text markers (String Mode)
 * - Regex patterns (Regex Mode)
 * - Whole word matching
 * - Rule prioritization
 * - Intelligent overlap resolution
 * 
 * Core capabilities:
 * 1. Single-line and multi-line comment processing
 * 2. Regex support for complex pattern matching
 * 3. Priority system for managing rule conflicts
 * 4. Full style customization (color, bold, italic, underline, strikethrough)
 * 
 * Usage example:
 * <pre>{@code
 * BetterCommentHelper helper = new BetterCommentHelper();
 * 
 * // Add a simple text rule
 * helper.addRule(new BetterCommentHelper.BetterCommentRule.Builder("TODO:")
 *     .color(EditorColorScheme.KEYWORD)
 *     .bold(true)
 *     .priority(10)
 *     .build());
 * 
 * // Add a regex rule
 * helper.addRule(new BetterCommentHelper.BetterCommentRule.Builder("@\\w+")
 *     .color(EditorColorScheme.ATTRIBUTE_NAME)
 *     .asRegex(true)
 *     .italic(true)
 *     .priority(8)
 *     .build());
 * 
 * // Process a comment
 * helper.processComment(result, line, startColumn, "// TODO: Fix this @ghost");
 * }</pre>
 */
public class BetterCommentHelper {

  /**
   * Rule definition for Better Comments feature
   * Each rule defines a pattern to match and the style to apply
   */
  public static class BetterCommentRule {
    /** The marker string or regex pattern */
    public final String marker;
    
    /** Compiled regex pattern (null if not in regex mode) */
    public final Pattern regexPattern;
    
    /** Whether this rule uses regex matching */
    public final boolean isRegex;
    
    /** Color ID from EditorColorScheme */
    public final int colorId;
    
    /** Bold text style flag */
    public final boolean bold;
    
    /** Italic text style flag */
    public final boolean italic;
    
    /** Underline text style flag */
    public final boolean underline;
    
    /** Strikethrough text style flag */
    public final boolean strikeThrough;
    
    /** Priority level - higher priority rules override lower ones on overlap */
    public final int priority;
    
    /** Match whole word only (string mode only) */
    public final boolean matchWholeWord;

    /**
     * Constructor for string mode rules (backward compatible)
     */
    public BetterCommentRule(
        String marker,
        int colorId,
        boolean bold,
        boolean italic,
        boolean underline,
        boolean strikeThrough,
        int priority) {
      this(marker, colorId, bold, italic, underline, strikeThrough, priority, false, false);
    }

    /**
     * Full constructor with all options
     * 
     * @param marker The marker string or regex pattern
     * @param colorId Color ID from EditorColorScheme
     * @param bold Apply bold style
     * @param italic Apply italic style
     * @param underline Apply underline style
     * @param strikeThrough Apply strikethrough style
     * @param priority Priority level (higher = more important)
     * @param isRegex Treat marker as regex pattern
     * @param matchWholeWord Match whole words only (string mode)
     */
    public BetterCommentRule(
        String marker,
        int colorId,
        boolean bold,
        boolean italic,
        boolean underline,
        boolean strikeThrough,
        int priority,
        boolean isRegex,
        boolean matchWholeWord) {
      this.marker = marker;
      this.isRegex = isRegex;
      this.colorId = colorId;
      this.bold = bold;
      this.italic = italic;
      this.underline = underline;
      this.strikeThrough = strikeThrough;
      this.priority = priority;
      this.matchWholeWord = matchWholeWord;
      
      if (isRegex) {
        this.regexPattern = Pattern.compile(marker);
      } else {
        this.regexPattern = null;
      }
    }

    /**
     * Builder pattern for easy rule creation
     */
    public static class Builder {
      private final String marker;
      private int colorId = EditorColorScheme.COMMENT;
      private boolean bold = false;
      private boolean italic = false;
      private boolean underline = false;
      private boolean strikeThrough = false;
      private int priority = 5;
      private boolean isRegex = false;
      private boolean matchWholeWord = false;

      /**
       * Create a new rule builder
       * @param marker The marker string or regex pattern
       */
      public Builder(String marker) {
        this.marker = marker;
      }

      /**
       * Set the color for this rule
       */
      public Builder color(int colorId) {
        this.colorId = colorId;
        return this;
      }

      /**
       * Apply bold style
       */
      public Builder bold(boolean bold) {
        this.bold = bold;
        return this;
      }

      /**
       * Apply italic style
       */
      public Builder italic(boolean italic) {
        this.italic = italic;
        return this;
      }

      /**
       * Apply underline style
       */
      public Builder underline(boolean underline) {
        this.underline = underline;
        return this;
      }

      /**
       * Apply strikethrough style
       */
      public Builder strikeThrough(boolean strikeThrough) {
        this.strikeThrough = strikeThrough;
        return this;
      }

      /**
       * Set rule priority
       */
      public Builder priority(int priority) {
        this.priority = priority;
        return this;
      }

      /**
       * Enable regex mode
       */
      public Builder asRegex(boolean isRegex) {
        this.isRegex = isRegex;
        return this;
      }

      /**
       * Match whole words only (string mode only)
       */
      public Builder matchWholeWord(boolean matchWholeWord) {
        this.matchWholeWord = matchWholeWord;
        return this;
      }

      /**
       * Build the rule instance
       */
      public BetterCommentRule build() {
        return new BetterCommentRule(
            marker, colorId, bold, italic, underline, 
            strikeThrough, priority, isRegex, matchWholeWord);
      }
    }
  }

  /**
   * Internal class to track marker match positions
   */
  private static class MarkerMatch {
    final int start;
    final int end;
    final BetterCommentRule rule;

    MarkerMatch(int start, int end, BetterCommentRule rule) {
      this.start = start;
      this.end = end;
      this.rule = rule;
    }
  }

  private final List<BetterCommentRule> rules = new ArrayList<>();
  private boolean enabled = true;
  private boolean regexModeEnabled = true;
  private int defaultCommentColor = EditorColorScheme.COMMENT;

  /**
   * Create a new BetterCommentHelper with default rules
   */
  public BetterCommentHelper() {
    setupDefaultRules();
    sortRules();
  }

  /**
   * Sort rules by priority (descending) and marker length (descending)
   */
  private void sortRules() {
    rules.sort((a, b) -> {
      if (a.priority != b.priority) {
        return Integer.compare(b.priority, a.priority);
      }
      return Integer.compare(b.marker.length(), a.marker.length());
    });
  }

  /**
   * Setup default better comment rules
   */
  private void setupDefaultRules() {
    // Priority 10 - Most important
    rules.add(
        new BetterCommentRule("TODO:", EditorColorScheme.KEYWORD, true, false, false, false, 10));
    rules.add(
        new BetterCommentRule(
            "FIXME:", EditorColorScheme.ATTRIBUTE_NAME, true, false, false, false, 10));
    rules.add(
        new BetterCommentRule("BUG:", EditorColorScheme.HTML_TAG, true, false, false, false, 10));
    rules.add(
        new BetterCommentRule("XXX:", EditorColorScheme.COLOR_ERROR, true, false, false, true, 10));
    rules.add(
        new BetterCommentRule(
            "WARNING:", EditorColorScheme.COLOR_WARNING, true, false, true, false, 10));

    // Priority 8
    rules.add(
        new BetterCommentRule("HACK:", EditorColorScheme.LITERAL, false, true, false, false, 8));

    // Priority 7
    rules.add(
        new BetterCommentRule("NOTE:", EditorColorScheme.KEYWORD, false, true, false, false, 7));

    // Priority 6
    rules.add(
        new BetterCommentRule(
            "INFO:", EditorColorScheme.LINE_NUMBER, false, false, false, false, 6));

    // Priority 5 - Symbol markers
    rules.add(
        new BetterCommentRule(
            "!!!", EditorColorScheme.ATTRIBUTE_NAME, true, false, false, false, 5));
    rules.add(
        new BetterCommentRule("???", EditorColorScheme.OPERATOR, false, true, false, false, 5));
    rules.add(
        new BetterCommentRule("***", EditorColorScheme.javafield, true, false, false, false, 5));
    rules.add(
        new BetterCommentRule("###", EditorColorScheme.KEYWORD, true, false, false, false, 5));

    // Priority 4 - Separators
    rules.add(
        new BetterCommentRule("----", EditorColorScheme.COMMENT, false, false, true, false, 4));
    rules.add(
        new BetterCommentRule("====", EditorColorScheme.KEYWORD, true, false, true, false, 4));
    rules.add(
        new BetterCommentRule("____", EditorColorScheme.LINE_NUMBER, false, false, true, false, 4));
  }

  /**
   * Enable or disable Better Comments feature
   */
  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  /**
   * Check if Better Comments is enabled
   */
  public boolean isEnabled() {
    return enabled;
  }

  /**
   * Enable or disable regex mode globally
   */
  public void setRegexModeEnabled(boolean enabled) {
    this.regexModeEnabled = enabled;
  }

  /**
   * Check if regex mode is enabled
   */
  public boolean isRegexModeEnabled() {
    return regexModeEnabled;
  }

  /**
   * Set default comment color
   */
  public void setDefaultCommentColor(int colorId) {
    this.defaultCommentColor = colorId;
  }

  /**
   * Add a new rule
   */
  public void addRule(BetterCommentRule rule) {
    rules.add(rule);
    sortRules();
  }

  /**
   * Remove a rule by its marker
   */
  public void removeRule(String marker) {
    rules.removeIf(r -> r.marker.equals(marker));
  }

  /**
   * Clear all rules
   */
  public void clearRules() {
    rules.clear();
  }

  /**
   * Get a copy of all rules
   */
  public List<BetterCommentRule> getRules() {
    return new ArrayList<>(rules);
  }

  /**
   * Process a comment line and apply better comment styles
   * Supports multiple markers in a single line
   * 
   * @param result The analysis result to add styles to
   * @param line Current line number
   * @param startColumn Starting column of the comment
   * @param commentText The full comment text content
   */
  public void processComment(
      TextAnalyzeResult result, int line, int startColumn, String commentText) {
    if (!enabled || rules.isEmpty() || commentText == null || commentText.isEmpty()) {
      return;
    }

    // Find all marker matches in this line
    List<MarkerMatch> matches = findAllMarkers(commentText);

    if (matches.isEmpty()) {
      // No markers found - use default comment style
      applyDefaultCommentStyle(result, line, startColumn, commentText.length());
      return;
    }

    // Sort matches by start position
    matches.sort(Comparator.comparingInt(m -> m.start));

    // Remove overlapping matches (keep higher priority ones)
    matches = removeOverlaps(matches);

    // Apply styles for each segment
    int currentPos = 0;
    for (MarkerMatch match : matches) {
      // Text before the marker - default comment style
      if (match.start > currentPos) {
        applyDefaultCommentStyle(result, line, startColumn + currentPos, match.start - currentPos);
      }

      // The marker itself - highlighted style
      applyMarkerStyle(
          result, line, startColumn + match.start, match.end - match.start, match.rule);

      currentPos = match.end;
    }

    // Remaining text after last marker - default comment style
    if (currentPos < commentText.length()) {
      applyDefaultCommentStyle(
          result, line, startColumn + currentPos, commentText.length() - currentPos);
    }
  }

  /**
   * Find all marker occurrences in the text
   * Supports both string and regex modes
   */
  private List<MarkerMatch> findAllMarkers(String text) {
    List<MarkerMatch> matches = new ArrayList<>();

    for (BetterCommentRule rule : rules) {
      if (rule.isRegex && regexModeEnabled) {
        // Regex mode
        Matcher matcher = rule.regexPattern.matcher(text);
        while (matcher.find()) {
          matches.add(new MarkerMatch(matcher.start(), matcher.end(), rule));
        }
      } else if (!rule.isRegex) {
        // String mode
        int index = 0;
        String searchText = text;
        
        while ((index = searchText.indexOf(rule.marker, index)) >= 0) {
          boolean shouldAdd = true;
          
          // Check whole word matching if enabled
          if (rule.matchWholeWord) {
            boolean wordStart = (index == 0) || !Character.isLetterOrDigit(text.charAt(index - 1));
            boolean wordEnd = (index + rule.marker.length() == text.length()) 
                || !Character.isLetterOrDigit(text.charAt(index + rule.marker.length()));
            shouldAdd = wordStart && wordEnd;
          }
          
          if (shouldAdd) {
            matches.add(new MarkerMatch(index, index + rule.marker.length(), rule));
          }
          index += rule.marker.length();
        }
      }
    }

    return matches;
  }

  /**
   * Remove overlapping markers, keeping the one with higher priority
   */
  private List<MarkerMatch> removeOverlaps(List<MarkerMatch> matches) {
    if (matches.size() <= 1) {
      return matches;
    }

    List<MarkerMatch> result = new ArrayList<>();
    MarkerMatch current = matches.get(0);

    for (int i = 1; i < matches.size(); i++) {
      MarkerMatch next = matches.get(i);

      if (next.start >= current.end) {
        // No overlap - keep current and move to next
        result.add(current);
        current = next;
      } else {
        // Overlap - keep the one with higher priority
        if (next.rule.priority > current.rule.priority) {
          current = next;
        }
        // If same priority, keep the longer marker or the current one
      }
    }

    result.add(current);
    return result;
  }

  /**
   * Apply default comment style (gray/italic)
   */
  private void applyDefaultCommentStyle(
      TextAnalyzeResult result, int line, int startColumn, int length) {
    if (length <= 0) return;

    long style =
        TextStyle.makeStyle(
            defaultCommentColor,
            0,
            false,
            true,
            false,
            false,
            false);

    for (int i = 0; i < length; i++) {
      result.addIfNeeded(line, startColumn + i, style);
    }
  }

  /**
   * Apply marker-specific style
   */
  private void applyMarkerStyle(
      TextAnalyzeResult result, int line, int startColumn, int length, BetterCommentRule rule) {
    if (length <= 0) return;

    long style =
        TextStyle.makeStyle(
            rule.colorId,
            0,
            rule.bold,
            rule.italic,
            rule.strikeThrough,
            rule.underline,
            false);

    for (int i = 0; i < length; i++) {
      result.addIfNeeded(line, startColumn + i, style);
    }
  }

  /**
   * Process entire comment block (handles multi-line comments)
   * 
   * @param result The analysis result
   * @param startLine Starting line number
   * @param startColumn Starting column of the comment
   * @param commentText The full comment text (may contain newlines)
   */
  public void processCommentBlock(
      TextAnalyzeResult result, int startLine, int startColumn, String commentText) {
    if (!enabled || rules.isEmpty() || commentText == null) {
      return;
    }

    String[] lines = commentText.split("\n", -1);

    for (int i = 0; i < lines.length; i++) {
      String lineText = lines[i];
      int lineStartColumn = (i == 0) ? startColumn : 0;
      processComment(result, startLine + i, lineStartColumn, lineText);
    }
  }

  /**
   * Get better comment information at a specific position
   * 
   * @param commentText The comment text
   * @param column The column position within the comment
   * @return BetterCommentInfo if a marker exists at position, null otherwise
   */
  public BetterCommentInfo getCommentAt(String commentText, int column) {
    if (!enabled || commentText == null) return null;

    List<MarkerMatch> matches = findAllMarkers(commentText);
    matches = removeOverlaps(matches);

    for (MarkerMatch match : matches) {
      if (column >= match.start && column < match.end) {
        return new BetterCommentInfo(match.rule.marker, match.rule.colorId, match.rule);
      }
    }
    return null;
  }

  /**
   * Information about a better comment at a specific position
   */
  public static class BetterCommentInfo {
    /** The marker text */
    public final String marker;
    
    /** The color ID for this marker */
    public final int colorId;
    
    /** The full rule definition */
    public final BetterCommentRule rule;

    public BetterCommentInfo(String marker, int colorId, BetterCommentRule rule) {
      this.marker = marker;
      this.colorId = colorId;
      this.rule = rule;
    }
  }

  /**
   * Add a regex-based rule easily
   * 
   * @param regexPattern The regex pattern to match
   * @param colorId Color from EditorColorScheme
   * @param priority Rule priority
   * @return This helper instance for chaining
   */
  public BetterCommentHelper addRegexRule(String regexPattern, int colorId, int priority) {
    addRule(new BetterCommentRule.Builder(regexPattern)
        .asRegex(true)
        .color(colorId)
        .priority(priority)
        .build());
    return this;
  }

  /**
   * Add a string-based rule easily
   * 
   * @param marker The text marker to match
   * @param colorId Color from EditorColorScheme
   * @param priority Rule priority
   * @return This helper instance for chaining
   */
  public BetterCommentHelper addStringRule(String marker, int colorId, int priority) {
    addRule(new BetterCommentRule.Builder(marker)
        .color(colorId)
        .priority(priority)
        .build());
    return this;
  }
}