package io.github.rosemoe.sora.widget.commentRule;

import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import io.github.rosemoe.sora.text.TextStyle;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/** Helper class for Better Comments feature Supports highlighting special markers in comments */
public class BetterCommentHelper {

    public static class BetterCommentRule {
        public final String marker;
        public final int colorId;
        public final boolean bold;
        public final boolean italic;
        public final boolean underline;
        public final boolean strikeThrough;
        public final int priority; // higher = more important

        public BetterCommentRule(
                String marker,
                int colorId,
                boolean bold,
                boolean italic,
                boolean underline,
                boolean strikeThrough,
                int priority) {
            this.marker = marker;
            this.colorId = colorId;
            this.bold = bold;
            this.italic = italic;
            this.underline = underline;
            this.strikeThrough = strikeThrough;
            this.priority = priority;
        }

        // Constructor for backward compatibility
        public BetterCommentRule(
                String marker,
                int colorId,
                boolean bold,
                boolean italic,
                boolean underline,
                boolean strikeThrough) {
            this(marker, colorId, bold, italic, underline, strikeThrough, 5);
        }
    }

    // Internal class to track marker positions
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
    private int defaultCommentColor = EditorColorScheme.COMMENT;

    public BetterCommentHelper() {
        setupDefaultRules();
        sortRules();
    }

    private void sortRules() {
        rules.sort((a, b) -> {
            // Sort by priority (higher first), then by marker length (longer first)
            if (a.priority != b.priority) {
                return Integer.compare(b.priority, a.priority);
            }
            return Integer.compare(b.marker.length(), a.marker.length());
        });
    }

    private void setupDefaultRules() {
        // Priority 10 - Most important
        rules.add(new BetterCommentRule("TODO:", EditorColorScheme.KEYWORD, true, false, false, false, 10));
        rules.add(new BetterCommentRule("FIXME:", EditorColorScheme.ATTRIBUTE_NAME, true, false, false, false, 10));
        rules.add(new BetterCommentRule("BUG:", EditorColorScheme.HTML_TAG, true, false, false, false, 10));
        rules.add(new BetterCommentRule("XXX:", EditorColorScheme.COLOR_ERROR, true, false, false, true, 10));
        rules.add(new BetterCommentRule("WARNING:", EditorColorScheme.COLOR_WARNING, true, false, true, false, 10));

        // Priority 8
        rules.add(new BetterCommentRule("HACK:", EditorColorScheme.LITERAL, false, true, false, false, 8));

        // Priority 7
        rules.add(new BetterCommentRule("NOTE:", EditorColorScheme.KEYWORD, false, true, false, false, 7));

        // Priority 6
        rules.add(new BetterCommentRule("INFO:", EditorColorScheme.LINE_NUMBER, false, false, false, false, 6));

        // Priority 5 - Symbol markers
        rules.add(new BetterCommentRule("!!!", EditorColorScheme.ATTRIBUTE_NAME, true, false, false, false, 5));
        rules.add(new BetterCommentRule("???", EditorColorScheme.OPERATOR, false, true, false, false, 5));
        rules.add(new BetterCommentRule("***", EditorColorScheme.javafield, true, false, false, false, 5));
        rules.add(new BetterCommentRule("###", EditorColorScheme.KEYWORD, true, false, false, false, 5));

        // Priority 4 - Separators
        rules.add(new BetterCommentRule("----", EditorColorScheme.COMMENT, false, false, true, false, 4));
        rules.add(new BetterCommentRule("====", EditorColorScheme.KEYWORD, true, false, true, false, 4));
        rules.add(new BetterCommentRule("____", EditorColorScheme.LINE_NUMBER, false, false, true, false, 4));
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setDefaultCommentColor(int colorId) {
        this.defaultCommentColor = colorId;
    }

    public void addRule(BetterCommentRule rule) {
        rules.add(rule);
        sortRules();
    }

    public void removeRule(String marker) {
        rules.removeIf(r -> r.marker.equals(marker));
    }

    public void clearRules() {
        rules.clear();
    }

    public List<BetterCommentRule> getRules() {
        return new ArrayList<>(rules);
    }

    /**
     * Process a comment line and apply better comment styles
     * Now supports multiple markers in a single line!
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
            applyMarkerStyle(result, line, startColumn + match.start, match.end - match.start, match.rule);

            currentPos = match.end;
        }

        // Remaining text after last marker - default comment style
        if (currentPos < commentText.length()) {
            applyDefaultCommentStyle(result, line, startColumn + currentPos, commentText.length() - currentPos);
        }
    }

    /**
     * Find all marker occurrences in the text
     */
    private List<MarkerMatch> findAllMarkers(String text) {
        List<MarkerMatch> matches = new ArrayList<>();

        for (BetterCommentRule rule : rules) {
            int index = 0;
            while ((index = text.indexOf(rule.marker, index)) >= 0) {
                matches.add(new MarkerMatch(index, index + rule.marker.length(), rule));
                index += rule.marker.length();
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
                // If same priority, keep the current one
            }
        }

        result.add(current);
        return result;
    }

    /**
     * Apply default comment style (gray/italic)
     */
    private void applyDefaultCommentStyle(TextAnalyzeResult result, int line, int startColumn, int length) {
        if (length <= 0) return;

        long style = TextStyle.makeStyle(
                defaultCommentColor,
                0,
                false,  // bold
                true,   // italic - comments are usually italic
                false,  // strikeThrough
                false,  // underline
                false
        );

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

        long style = TextStyle.makeStyle(
                rule.colorId,
                0,
                rule.bold,
                rule.italic,
                rule.strikeThrough,
                rule.underline,
                false
        );

        for (int i = 0; i < length; i++) {
            result.addIfNeeded(line, startColumn + i, style);
        }
    }

    /**
     * Process entire comment block (handles multi-line comments)
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

    /** Get better comment info at position */
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

    public static class BetterCommentInfo {
        public final String marker;
        public final int colorId;
        public final BetterCommentRule rule;

        public BetterCommentInfo(String marker, int colorId, BetterCommentRule rule) {
            this.marker = marker;
            this.colorId = colorId;
            this.rule = rule;
        }
    }
}