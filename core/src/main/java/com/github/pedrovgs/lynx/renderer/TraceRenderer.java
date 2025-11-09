/*
 * Copyright (C) 2015 Pedro Vicente Gomez Sanchez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.pedrovgs.lynx.renderer;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.pedrovgs.lynx.LynxConfig;
import com.github.pedrovgs.lynx.model.Trace;
import com.github.pedrovgs.lynx.model.TraceLevel;
import com.google.android.material.card.MaterialCardView;
import com.pedrogomez.renderers.Renderer;

import ir.ninjacoder.ghostide.core.R;

/**
 * Base Renderer<Trace> used to show Trace objects inside a ListView using TraceLevel and Trace
 * message as main information to show. This Renderer<Trace> is used as the base of other
 * Renderers<Trace> and to show verbose TraceLevel traces.
 *
 * <p>To learn more about Renderers library take a look to the repository:
 * https://github.com/pedrovgs/Renderers
 *
 * @author Pedro Vicente Gomez Sanchez.
 */
class TraceRenderer extends Renderer<Trace> {

  private final LynxConfig lynxConfig;

  private TextView tv_trace;
  private LinearLayout linear1, viewHelper;
  private TextView logName;
  protected MaterialCardView mycard;

  TraceRenderer(LynxConfig lynxConfig) {
    this.lynxConfig = lynxConfig;
  }

  @Override
  protected View inflate(LayoutInflater inflater, ViewGroup parent) {
    return inflater.inflate(R.layout.trace_row, parent, false);
  }

  @Override
  protected void setUpView(View rootView) {
    tv_trace = (TextView) rootView.findViewById(R.id.tv_trace);
    // linear1 = (LinearLayout) rootView.findViewById(R.id.postView);
    logName = (TextView) rootView.findViewById(R.id.logName);
    viewHelper = (LinearLayout) rootView.findViewById(R.id.viewHelper);
    mycard = rootView.findViewById(R.id.mycard);
    tv_trace.setTypeface(Typeface.MONOSPACE);
    logName.setTypeface(Typeface.MONOSPACE);
    if (lynxConfig.hasTextSizeInPx()) {
      float textSize = lynxConfig.getTextSizeInPx();
      // tv_trace.setTextSize(textSize);
      logName.setTextSize(textSize);
    }
    tv_trace.setTextSize(18f);
  }

  @Override
  protected void hookListeners(View rootView) {
    // Empty
  }

  @Override
  public void render() {
    Trace trace = getContent();
    String traceMessage = trace.getMessage();

    Spannable traceRepresentation = getTraceVisualRepresentation(trace.getLevel(), traceMessage);
    tv_trace.setText(trace.getLevel().toString().substring(0, 1));
    //  tv_trace.setTextColor(getTraceColor());
    logName.setText(trace.getMessage().toString());
    logName.setTextColor(Color.WHITE);
    mycard.setStrokeWidth(1);
    var texts = trace.getLevel().toString().substring(0, 1);
    switch (texts) {
      case "E":
        viewHelper.setBackgroundColor(Color.parseColor("#FF3A0000"));
        // linear1.setBackgroundColor(Color.parseColor("#FF3A0000"));
        tv_trace.setTextColor(Color.WHITE);
        mycard.setStrokeColor(Color.parseColor("#FF0000"));
        break;
      case "V":
        viewHelper.setBackgroundColor(Color.parseColor("#FF040A0E"));
        //  linear1.setBackgroundColor(Color.parseColor("#FF040A0E"));
        tv_trace.setTextColor(Color.BLACK);
        mycard.setStrokeColor(Color.parseColor("#fF000000"));
        break;
      case "A":
        viewHelper.setBackgroundColor(Color.parseColor("#FF004410"));
        tv_trace.setTextColor(Color.BLACK);
        mycard.setStrokeColor(Color.parseColor("#FF00FF73"));
        break;
      case "I":
        viewHelper.setBackgroundColor(Color.parseColor("#FF582600"));
        //    linear1.setBackgroundColor(Color.parseColor("#FF582600"));
        tv_trace.setTextColor(Color.WHITE);
        mycard.setStrokeColor(Color.parseColor("#FFFFD900"));
        break;
      case "F":
        viewHelper.setBackgroundColor(Color.LTGRAY);
        tv_trace.setTextColor(Color.WHITE);
        mycard.setStrokeColor(Color.LTGRAY);
        break;
      case "W":
        viewHelper.setBackgroundColor(Color.parseColor("#FFFF7700"));
        //   linear1.setBackgroundColor(Color.parseColor("#FF584500"));
        tv_trace.setTextColor(Color.BLACK);
        mycard.setStrokeColor(Color.parseColor("#FFFF7700"));
        break;
      case "D":
        viewHelper.setBackgroundColor(Color.parseColor("#FF242953"));
        tv_trace.setTextColor(Color.WHITE);
        mycard.setStrokeColor(Color.parseColor("#FFFF00FF"));
        break;
    }
  }

  protected int getTraceColor() {
    return Color.parseColor("#FFB0B0B0");
  }

  private Spannable getTraceVisualRepresentation(TraceLevel level, String traceMessage) {
    traceMessage = " " + level.getValue() + "  " + traceMessage;
    Spannable traceRepresentation = new SpannableString(traceMessage);
    int traceColor = getTraceColor();
    traceRepresentation.setSpan(
        new BackgroundColorSpan(traceColor), 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    return traceRepresentation;
  }
  
}
