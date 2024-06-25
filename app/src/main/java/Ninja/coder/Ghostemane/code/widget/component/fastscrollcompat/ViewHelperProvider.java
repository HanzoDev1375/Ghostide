/*
 * Copyright (c) 2019 Hai Zhang <dreaming.in.code.zh@gmail.com>
 * All Rights Reserved.
 */

package Ninja.coder.Ghostemane.code.widget.component.fastscrollcompat;

import androidx.annotation.NonNull;

public interface ViewHelperProvider {

    @NonNull
    FastScroller.ViewHelper getViewHelper();
}
