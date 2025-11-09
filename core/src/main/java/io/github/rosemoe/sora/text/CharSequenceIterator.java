package io.github.rosemoe.sora.text;

import androidx.annotation.NonNull;

import java.text.CharacterIterator;

/**
 * CharacterIterator implementation
 *
 * @author Rosemoe
 */
public class CharSequenceIterator implements CharacterIterator {

    private final CharSequence src;
    private int index;

    public CharSequenceIterator(@NonNull CharSequence source) {
        src = source;
    }

    @Override
    public char first() {
        index = 0;
        return current();
    }

    @Override
    public char last() {
        index = src.length() - 1;
        if (index < 0) {
            index = 0;
        }
        return current();
    }

    @Override
    public char current() {
        return index == getEndIndex() ? CharacterIterator.DONE : src.charAt(index);
    }

    @Override
    public char next() {
        index++;
        return current();
    }

    @Override
    public char previous() {
        index--;
        if (index < 0) {
            index = 0;
        }
        return current();
    }

    @Override
    public char setIndex(int i) {
        index = i;
        return current();
    }

    @Override
    public int getBeginIndex() {
        return 0;
    }

    @Override
    public int getEndIndex() {
        return src.length();
    }

    @Override
    public int getIndex() {
        return index;
    }

    @NonNull
    @Override
    public Object clone() {
        var another = new CharSequenceIterator(src);
        another.index = index;
        return another;
    }
}
