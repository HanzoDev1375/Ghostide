package coyamo.visualxml.lib.ui.proxy;
/*
 * Copyright (C) 2007 The Android Open Source Project
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

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.FrameLayout;

//从源码复制
public class BlinkLayout extends FrameLayout {
    private static final int MESSAGE_BLINK = 0x42;
    private static final int BLINK_DELAY = 500;
    private final Handler mHandler;
    private boolean mBlink;
    private boolean mBlinkState;

    public BlinkLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == MESSAGE_BLINK) {
                    if (mBlink) {
                        mBlinkState = !mBlinkState;
                        makeBlink();
                    }
                    invalidate();
                    return true;
                }
                return false;
            }
        });
    }

    private void makeBlink() {
        Message message = mHandler.obtainMessage(MESSAGE_BLINK);
        mHandler.sendMessageDelayed(message, BLINK_DELAY);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        mBlink = true;
        mBlinkState = true;

        makeBlink();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        mBlink = false;
        mBlinkState = true;

        mHandler.removeMessages(MESSAGE_BLINK);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        if (mBlinkState) {
            super.dispatchDraw(canvas);
        }
    }
}
