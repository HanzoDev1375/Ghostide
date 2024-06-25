package io.github.rosemoe.sora.text;

import androidx.annotation.NonNull;

/**
 * A range made up of two {@link CharPosition} objects.
 *
 * @author Rosemoe
 */
public class TextRange {

    private CharPosition start;
    private CharPosition end;

    public TextRange(@NonNull CharPosition start, @NonNull CharPosition end) {
        this.start = start;
        this.end = end;
    }

    @NonNull
    public CharPosition getStart() {
        return start;
    }

    public void setStart(@NonNull CharPosition start) {
        this.start = start;
    }

    @NonNull
    public CharPosition getEnd() {
        return end;
    }

    public void setEnd(@NonNull CharPosition end) {
        this.end = end;
    }

    public int getStartIndex() {
        return start.index;
    }

    public int getEndIndex() {
        return end.index;
    }

    @Override
    public String toString() {
        return "TextRange{" + "start=" + start + ", end=" + end + '}';
    }
}
