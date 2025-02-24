/*
 * Copyright (C) 2015 Martin Stone
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ir.ninjacoder.ghostide.keyboard;

import android.graphics.Color;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.widget.EditText;

class HexEdit {

    private static InputFilter[] withoutAlphaDigits = {new ColorPasteLengthFilter()};
    private static InputFilter[] withAlphaDigits = {new InputFilter.LengthFilter(8)};

    public static void setUpListeners(final EditText hexEdit, final ObservableColor observableColor) {

        class MultiObserver implements ColorObserver, TextWatcher {

            @Override
            public void updateColor(ObservableColor observableColor) {
                final String colorString = formatColor(observableColor.getColor());
                // Prevent onTextChanged getting called when we update text programmatically
                hexEdit.removeTextChangedListener(this);
                hexEdit.setText(colorString);
                hexEdit.addTextChangedListener(this);
            }

            private String formatColor(int color) {
                return shouldTrimAlphaDigits()
                        ? String.format("%06x", color & 0x00ffffff)
                        : String.format("%08x", color);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int color = parseHexColor(s);
                if (shouldTrimAlphaDigits()) color = color | 0xff000000;
                observableColor.updateColor(color, this);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

            private boolean shouldTrimAlphaDigits() {
                return hexEdit.getFilters() == withoutAlphaDigits;
            }
        }

        final MultiObserver multiObserver = new MultiObserver();
        hexEdit.addTextChangedListener(multiObserver);
        observableColor.addObserver(multiObserver);
        setShowAlphaDigits(hexEdit, true);
    }

    private static int parseHexColor(CharSequence s) {
        try {
            return (int) (Long.parseLong(s.toString(), 16) & 0xffffffffL);
        } catch (NumberFormatException e) {
            return Color.GRAY;
        }
    }

    public static void setShowAlphaDigits(final EditText hexEdit, boolean showAlphaDigits) {
        hexEdit.setFilters(showAlphaDigits ? withAlphaDigits : withoutAlphaDigits);
        hexEdit.setText(hexEdit.getText()); // trigger a reformat of text
    }


    private static class ColorPasteLengthFilter implements InputFilter {

        private static final int MAX_LENGTH = 6;
        private static final int PASTED_LEN = 8;
        private final InputFilter sixDigitFilter = new InputFilter.LengthFilter(MAX_LENGTH);

        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            // If 8 digits have been pasted, replacing all source, trim alpha digits.
            // Otherwise standard LengthFilter behavior.
            final int srcLength = end - start;
            final int dstSelLength = dend - dstart;
            if (srcLength == PASTED_LEN && dstSelLength == dest.length()) {
                // Discard alpha digits:
                return source.subSequence(PASTED_LEN - MAX_LENGTH, PASTED_LEN);
            } else {
                return sixDigitFilter.filter(source, start, end, dest, dstart, dend);
            }
        }
    }

}
