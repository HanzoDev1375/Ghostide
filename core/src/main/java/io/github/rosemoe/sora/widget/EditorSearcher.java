package io.github.rosemoe.sora.widget;

import android.app.ProgressDialog;
import android.widget.Toast;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.github.rosemoe.sora.event.ContentChangeEvent;
import io.github.rosemoe.sora.event.PublishSearchResultEvent;
import io.github.rosemoe.sora.text.Content;
import io.github.rosemoe.sora.text.PreserveCaseReplace;
import io.github.rosemoe.sora.text.TextUtils;
import io.github.rosemoe.sora.util.IntPair;
import io.github.rosemoe.sora.util.LongArrayList;
import io.github.rosemoe.sora.util.regex.RegexBackrefGrammar;
import io.github.rosemoe.sora.util.regex.RegexBackrefHelper;
import io.github.rosemoe.sora.util.regex.RegexBackrefParser;
import io.github.rosemoe.sora.util.regex.RegexBackrefToken;

public class EditorSearcher {

    private final CodeEditor editor;
    protected String currentPattern;
    protected SearchOptions searchOptions;
    protected ReplaceOptions replaceOptions;
    protected Thread currentThread;
    protected LongArrayList lastResults;
    private boolean cyclicJumping = true;

    EditorSearcher(@NonNull CodeEditor editor) {
        this.editor = editor;
        this.editor.subscribeEvent(
                ContentChangeEvent.class,
                ((event, unsubscribe) -> {
                    if (hasQuery()) {
                        executeMatch();
                    }
                }));
        replaceOptions = ReplaceOptions.DEFAULT;
    }

    public void setCyclicJumping(boolean cyclicJumping) {
        this.cyclicJumping = cyclicJumping;
    }

    public boolean isCyclicJumping() {
        return cyclicJumping;
    }

    public void setReplaceOptions(@NonNull ReplaceOptions replaceOptions) {
        this.replaceOptions = Objects.requireNonNull(replaceOptions);
    }

    public ReplaceOptions getReplaceOptions() {
        return replaceOptions;
    }

    public void search(@NonNull String pattern, @NonNull SearchOptions options) {
        if (pattern == null || pattern.isEmpty()) {
            throw new IllegalArgumentException("pattern length must be > 0");
        }
        
        if (options == null) {
            options = new SearchOptions(SearchOptions.TYPE_NORMAL, false);
        }
        
        if (options.type == SearchOptions.TYPE_REGULAR_EXPRESSION) {
            try {
                Pattern.compile(pattern);
            } catch (Exception e) {
                throw new IllegalArgumentException("Invalid regex pattern: " + e.getMessage());
            }
        }
        currentPattern = pattern;
        searchOptions = options;
        executeMatch();
        editor.postInvalidate();
    }

    public void search(String code) {
        search(code, new SearchOptions(SearchOptions.TYPE_NORMAL, false));
    }

    public void search(String code, boolean caseInsensitive) {
        search(code, new SearchOptions(SearchOptions.TYPE_NORMAL, caseInsensitive));
    }

    public void search(String code, @IntRange(from = 1, to = 3) int searchType, boolean caseInsensitive) {
        search(code, new SearchOptions(searchType, caseInsensitive));
    }

    private void executeMatch() {
        if (currentThread != null && currentThread.isAlive()) {
            currentThread.interrupt();
        }
        var runnable = new SearchRunnable(editor.getText(), searchOptions, currentPattern);
        currentThread = new Thread(runnable);
        currentThread.start();
    }

    public void stopSearch() {
        if (currentThread != null && currentThread.isAlive()) {
            currentThread.interrupt();
        }
        currentThread = null;
        lastResults = null;
        currentPattern = null;
        searchOptions = null;
        editor.dispatchEvent(new PublishSearchResultEvent(editor));
    }

    public boolean hasQuery() {
        return currentPattern != null;
    }

    private void checkState() {
        if (!hasQuery()) {
            throw new IllegalStateException("pattern not set");
        }
    }

    public int getCurrentMatchedPositionIndex() {
        checkState();
        var cur = editor.getCursor();
        if (!cur.isSelected()) {
            return -1;
        }
        var left = cur.getLeft();
        var right = cur.getRight();

        if (isResultValid()) {
            var res = lastResults;
            if (res == null) {
                return -1;
            }
            var packed = IntPair.pack(left, right);
            int index = res.lowerBound(packed);
            if (index < res.size() && res.get(index) == packed) {
                return index;
            }
        }
        return -1;
    }

    public int getMatchedPositionCount() {
        checkState();
        if (!isResultValid()) {
            return 0;
        }
        var result = lastResults;
        return result == null ? 0 : result.size();
    }

    public boolean gotoNext() {
        checkState();
        if (!isResultValid() || lastResults == null || lastResults.size() == 0) {
            return false;
        }

        var cursor = editor.getCursor();
        var currentPos = cursor.getRight();

        int nextIndex = -1;
        for (int i = 0; i < lastResults.size(); i++) {
            long region = lastResults.get(i);
            int start = IntPair.getFirst(region);
            if (start > currentPos) {
                nextIndex = i;
                break;
            }
        }

        if (nextIndex == -1) {
            if (cyclicJumping) {
                nextIndex = 0;
            } else {
                return false;
            }
        }

        return jumpToResult(nextIndex);
    }

    public boolean gotoLast() {
        return gotoPrevious();
    }

    public boolean gotoPrevious() {
        checkState();
        if (!isResultValid() || lastResults == null || lastResults.size() == 0) {
            return false;
        }

        var cursor = editor.getCursor();
        var currentPos = cursor.getLeft();

        int prevIndex = -1;
        for (int i = lastResults.size() - 1; i >= 0; i--) {
            long region = lastResults.get(i);
            int end = IntPair.getSecond(region);
            if (end < currentPos) {
                prevIndex = i;
                break;
            }
        }

        if (prevIndex == -1) {
            if (cyclicJumping) {
                prevIndex = lastResults.size() - 1;
            } else {
                return false;
            }
        }

        return jumpToResult(prevIndex);
    }

    private boolean jumpToResult(int index) {
        if (index < 0 || index >= lastResults.size()) {
            return false;
        }

        long region = lastResults.get(index);
        int start = IntPair.getFirst(region);
        int end = IntPair.getSecond(region);

        var startPos = editor.getText().getIndexer().getCharPosition(start);
        var endPos = editor.getText().getIndexer().getCharPosition(end);

        editor.setSelectionRegion(startPos.line, startPos.column, endPos.line, endPos.column);
        editor.ensureSelectionVisible();

        return true;
    }

    public boolean isMatchedPositionSelected() {
        return getCurrentMatchedPositionIndex() > -1;
    }

    public void replaceThis(@NonNull String replacement) {
        replaceCurrentMatch(replacement);
    }

    public void replaceCurrentMatch(@NonNull String replacement) {
        if (!editor.isEditable()) {
            return;
        }
        if (isMatchedPositionSelected()) {
            if (replacement.isEmpty()) {
                editor.deleteText();
            } else {
                if (searchOptions != null && searchOptions.type == SearchOptions.TYPE_REGULAR_EXPRESSION
                        && searchOptions.regexBackrefGrammar != null) {
                    var cursor = editor.getCursor();
                    var currentText = editor.getText().subSequence(cursor.getLeft(), cursor.getRight()).toString();
                    var pattern = Pattern.compile(
                            currentPattern,
                            (searchOptions.caseInsensitive ? Pattern.CASE_INSENSITIVE : 0)
                                    | Pattern.MULTILINE);
                    var matcher = pattern.matcher(currentText);
                    if (!matcher.find()) {
                        return;
                    }
                    replacement = RegexBackrefHelper.computeReplacement(
                            matcher, searchOptions.regexBackrefGrammar, replacement);
                }
                if (replaceOptions != null && replaceOptions.preserveCase) {
                    var cursor = editor.getCursor();
                    var currentText = editor.getText().subSequence(cursor.getLeft(), cursor.getRight()).toString();
                    replacement = PreserveCaseReplace.getReplacementSimple(currentText, replacement);
                }
                editor.commitText(replacement, false);
            }
        } else {
            gotoNext();
        }
    }

    public void replaceAll(@NonNull String replacement) {
        replaceAll(replacement, null);
    }

    public void replaceAll(@NonNull String replacement, @Nullable final Runnable whenSucceeded) {
        if (!editor.isEditable()) {
            return;
        }
        checkState();
        if (!isResultValid()) {
            Toast.makeText(editor.getContext(), "Editor Search has busy", Toast.LENGTH_SHORT).show();
            return;
        }
        var context = editor.getContext();
        final var dialog = ProgressDialog.show(context, "Replace All", "Loading...", true, false);
        final var res = lastResults;
        final var options = searchOptions;
        final var pattern = currentPattern;

        if (res == null) {
            dialog.dismiss();
            return;
        }

        new Thread(() -> {
            try {
                var sb = editor.getText().toStringBuilder();
                if (options != null && options.type == SearchOptions.TYPE_REGULAR_EXPRESSION
                        && options.regexBackrefGrammar != null) {
                    var regex = Pattern.compile(
                            pattern,
                            (options.caseInsensitive ? Pattern.CASE_INSENSITIVE : 0)
                                    | Pattern.MULTILINE);
                    Matcher matcher = null;
                    List<RegexBackrefToken> tokens = null;
                    int delta = 0;
                    var text = sb.toString();
                    for (int i = 0; i < res.size(); i++) {
                        var region = res.get(i);
                        var start = IntPair.getFirst(region);
                        var end = IntPair.getSecond(region);

                        var regionText = text.substring(start, end);
                        if (matcher == null) {
                            matcher = regex.matcher(regionText);
                        } else {
                            matcher.reset(regionText);
                        }
                        if (!matcher.find()) {
                            continue;
                        }
                        if (tokens == null) {
                            tokens = new RegexBackrefParser(options.regexBackrefGrammar)
                                    .parse(replacement, matcher.groupCount());
                        }
                        var computedReplacement = RegexBackrefHelper.computeReplacement(matcher, tokens);
                        var newLength = computedReplacement.length();
                        var oldLength = end - start;
                        if (replaceOptions != null && replaceOptions.preserveCase) {
                            computedReplacement = PreserveCaseReplace.getReplacementSimple(
                                    sb.substring(start + delta, end + delta), computedReplacement);
                        }
                        sb.replace(start + delta, end + delta, computedReplacement);
                        delta += newLength - oldLength;
                    }
                } else {
                    int newLength = replacement.length();
                    int delta = 0;
                    for (int i = 0; i < res.size(); i++) {
                        var region = res.get(i);
                        var start = IntPair.getFirst(region);
                        var end = IntPair.getSecond(region);
                        var oldLength = end - start;
                        var replaceText = replacement;
                        if (replaceOptions != null && replaceOptions.preserveCase) {
                            replaceText = PreserveCaseReplace.getReplacementSimple(
                                    sb.substring(start + delta, end + delta), replacement);
                        }
                        sb.replace(start + delta, end + delta, replaceText);
                        delta += newLength - oldLength;
                    }
                }
                editor.postInLifecycle(() -> {
                    var pos = editor.getCursor().left();
                    editor.getText().replace(
                            0, 0,
                            editor.getLineCount() - 1,
                            editor.getText().getColumnCount(editor.getLineCount() - 1),
                            sb);
                    editor.setSelectionAround(pos.line, pos.column);
                    dialog.dismiss();

                    if (whenSucceeded != null) {
                        whenSucceeded.run();
                    }
                });
            } catch (Exception e) {
                editor.postInLifecycle(() -> {
                    Toast.makeText(editor.getContext(), "Replace failed:" + e, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                });
            }
        }).start();
    }

    public boolean isResultValid() {
        return currentThread == null || !currentThread.isAlive();
    }

    public static class SearchOptions {

        public final boolean caseInsensitive;
        @IntRange(from = 1, to = 3)
        public final int type;
        public final RegexBackrefGrammar regexBackrefGrammar;

        public static final int TYPE_NORMAL = 1;
        public static final int TYPE_WHOLE_WORD = 2;
        public static final int TYPE_REGULAR_EXPRESSION = 3;

        public SearchOptions(boolean caseInsensitive, boolean useRegex) {
            this(useRegex ? TYPE_REGULAR_EXPRESSION : TYPE_NORMAL, caseInsensitive);
        }

        public SearchOptions(@IntRange(from = 1, to = 3) int type, boolean caseInsensitive) {
            this(type, caseInsensitive, null);
        }

        public SearchOptions(
                @IntRange(from = 1, to = 3) int type,
                boolean caseInsensitive,
                @Nullable RegexBackrefGrammar regexBackrefGrammar) {
            if (type < 1 || type > 3) {
                throw new IllegalArgumentException("invalid type");
            }
            this.type = type;
            this.caseInsensitive = caseInsensitive;
            this.regexBackrefGrammar = regexBackrefGrammar;
        }
    }

    public static class ReplaceOptions {

        public static final ReplaceOptions DEFAULT = new ReplaceOptions(false);
        public final boolean preserveCase;

        public ReplaceOptions(boolean preserveCase) {
            this.preserveCase = preserveCase;
        }
    }

    private final class SearchRunnable implements Runnable {

        private final StringBuilder text;
        private final String pattern;
        private final SearchOptions options;
        private Thread localThread;

        public SearchRunnable(@NonNull Content content, @NonNull SearchOptions options, @NonNull String pattern) {
            this.text = content.toStringBuilder();
            this.options = options;
            this.pattern = pattern;
        }

        private boolean checkNotCancelled() {
            return currentThread == localThread && !Thread.interrupted();
        }

        @Override
        public void run() {
            localThread = Thread.currentThread();
            var results = new LongArrayList();
            var textLength = text.length();
            var ignoreCase = options != null && options.caseInsensitive;

            if (options == null) {
                return;
            }

            switch (options.type) {
                case SearchOptions.TYPE_NORMAL:
                    normalSearch(results, textLength, ignoreCase);
                    break;

                case SearchOptions.TYPE_WHOLE_WORD:
                    String wordPattern = "\\b" + Pattern.quote(pattern) + "\\b";
                    regexSearch(results, wordPattern, ignoreCase);
                    break;

                case SearchOptions.TYPE_REGULAR_EXPRESSION:
                    regexSearch(results, pattern, ignoreCase);
                    break;
            }

            if (checkNotCancelled()) {
                editor.postInLifecycle(() -> {
                    if (currentThread == localThread) {
                        lastResults = results;
                        editor.invalidate();
                        editor.dispatchEvent(new PublishSearchResultEvent(editor));
                        currentThread = null;
                    }
                });
            }
        }

        private void normalSearch(LongArrayList results, int textLength, boolean ignoreCase) {
            int patternLength = pattern.length();
            int searchIndex = 0;

            while (searchIndex < textLength && checkNotCancelled()) {
                int foundIndex = -1;

                for (int i = searchIndex; i <= textLength - patternLength; i++) {
                    if (!checkNotCancelled()) {
                        break;
                    }

                    boolean matches = true;
                    for (int j = 0; j < patternLength; j++) {
                        char textChar = text.charAt(i + j);
                        char patternChar = pattern.charAt(j);

                        if (ignoreCase) {
                            if (Character.toLowerCase(textChar) != Character.toLowerCase(patternChar)) {
                                matches = false;
                                break;
                            }
                        } else {
                            if (textChar != patternChar) {
                                matches = false;
                                break;
                            }
                        }
                    }

                    if (matches) {
                        foundIndex = i;
                        break;
                    }
                }

                if (foundIndex != -1) {
                    results.add(IntPair.pack(foundIndex, foundIndex + patternLength));
                    searchIndex = foundIndex + patternLength;
                } else {
                    searchIndex = textLength;
                }
            }
        }

        private void regexSearch(LongArrayList results, String regexPattern, boolean ignoreCase) {
            try {
                int flags = (ignoreCase ? Pattern.CASE_INSENSITIVE : 0) | Pattern.MULTILINE;
                var regex = Pattern.compile(regexPattern, flags);
                var string = text.toString();
                var matcher = regex.matcher(string);

                int lastEnd = -1;
                while (matcher.find() && checkNotCancelled()) {
                    int start = matcher.start();
                    int end = matcher.end();

                    if (start < end && (lastEnd == -1 || start > lastEnd)) {
                        results.add(IntPair.pack(start, end));
                        lastEnd = end;
                    }

                    if (end == string.length()) {
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}