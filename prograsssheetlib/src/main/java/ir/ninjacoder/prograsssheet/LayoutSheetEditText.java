package ir.ninjacoder.prograsssheet;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.text.SpannableString;
import ir.ninjacoder.prograsssheet.interfaces.OnLineNumberEvent;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import android.text.style.UnderlineSpan;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.graphics.Color;
import android.text.style.ClickableSpan;
import android.text.method.LinkMovementMethod;
import androidx.annotation.StringRes;
import com.google.android.material.textfield.TextInputLayout;
import ir.ninjacoder.prograsssheet.databinding.LayoutEdittextSheetBinding;
import ir.ninjacoder.prograsssheet.enums.StateInputType;

public class LayoutSheetEditText implements TextWatcher {

  private Context context;
  private LayoutEdittextSheetBinding bind;
  private Sheet dialog;
  private SharedPreferences prf;
  private boolean isAnim = false;

  private StateInputType input = StateInputType.TEXT;

  public LayoutSheetEditText(Context context) {
    this.context = context;
    bind = LayoutEdittextSheetBinding.inflate(LayoutInflater.from(context));
    dialog = new Sheet(context);
    prf = context.getSharedPreferences("key", Context.MODE_PRIVATE);
    bind.etanim.addTextChangedListener(this);
    bind.etanim.setText(loadSaveText());
    var et = bind.etanim;
    switch (input) {
      case TEXT:
        et.setInputType(InputType.TYPE_CLASS_TEXT);
        break;
      case NUMBER:
        et.setInputType(InputType.TYPE_CLASS_NUMBER);
        break;
      case PASSWORD:
        et.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        break;
      case NUMBERDECIMAL:
        et.setInputType(InputType.TYPE_CLASS_DATETIME);
        break;
      case NUMBERSIGNED:
        et.setInputType(InputType.TYPE_NUMBER_FLAG_SIGNED);
        break;
      default:
        et.setInputType(InputType.TYPE_CLASS_TEXT);
    }
    setIsAnim(true);
    bind.btnok.setEnabled(isEmptyText() ? false : true);
  }

  public LayoutSheetEditText setTitle(@StringRes int title) {
    bind.title.setText(title);
    return this;
  }

  public LayoutSheetEditText setTitle(String title) {
    bind.title.setText(title);
    return this;
  }

  public LayoutSheetEditText setokClick(View.OnClickListener click) {
    bind.btnok.setOnClickListener(click);
    return this;
  }

  public LayoutSheetEditText setnoClick(View.OnClickListener click) {
    bind.btnno.setOnClickListener(click);
    return this;
  }

  public Button getButtonOk() {
    return bind.btnok;
  }

  public Button getButtonNo() {
    return bind.btnno;
  }

  public TextInputLayout getInputLayout() {
    return bind.editors;
  }

  public LayoutSheetEditText setText(String text) {
    bind.etanim.setText(text);
    return this;
  }

  public boolean isEmptyText() {
    return TextUtils.isEmpty(bind.etanim.getText().toString());
  }

  public String getText() {
    return bind.etanim.getText().toString();
  }

  public String getTitle() {
    return bind.title.getText().toString();
  }

  public LayoutSheetEditText show() {
    dialog.show();
    return this;
  }

  public void setSaveText(boolean save) {
    Editor editor = prf.edit();
    if (save) {
      editor.putString("key", bind.etanim.getText().toString());
      editor.apply();
    } else editor.clear();
  }

  String loadSaveText() {
    return prf.getString("key", "");
  }

  public LayoutSheetEditText dismiss() {
    if (dialog.isShowing()) dialog.dismiss();
    return this;
  }

  class Sheet extends CustomSheet {

    public Sheet(Context c) {
      super(c);
    }

    @Override
    public View getView() {
      return bind.getRoot();
    }
  }

  @Override
  public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}

  @Override
  public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
    if (prf != null) {
      setSaveText(true);
      startVibrationAnimation(bind.etanim);
      bind.btnok.setEnabled(isEmptyText() ? false : true);
    }
  }

  @Override
  public void afterTextChanged(Editable arg0) {}

  public StateInputType getInput() {
    return this.input;
  }

  public void setInput(StateInputType input) {
    this.input = input;
  }

  private void startVibrationAnimation(View view) {
    if (isAnim) {
      var shake = new TranslateAnimation(-5, 5, 0, 0);
      shake.setDuration(100);
      shake.setRepeatCount(2);
      shake.setRepeatMode(Animation.REVERSE);
      view.startAnimation(shake);
    }
  }

  public boolean getIsAnim() {
    return this.isAnim;
  }

  public void setIsAnim(boolean isAnim) {
    this.isAnim = isAnim;
  }

  public boolean isShow() {
    return dialog.isShowing();
  }

  public void applyClickableSpans(OnLineNumberEvent line) {
    String fullText = getText();
    var get = getInputLayout().getEditText();
    SpannableString spannableString = new SpannableString(fullText);
    Pattern pattern = Pattern.compile("\\w+\\.\\w+:\\d+");
    Matcher matcher = pattern.matcher(fullText);

    while (matcher.find()) {
      String matchedText = matcher.group();
      int start = matcher.start();
      int end = matcher.end();
      String lineNumber = matchedText.substring(matchedText.lastIndexOf(":") + 1);
      spannableString.setSpan(new UnderlineSpan(), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
      spannableString.setSpan(
          new ForegroundColorSpan(Color.RED), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
      ClickableSpan clickableSpan =
          new ClickableSpan() {
            @Override
            public void onClick(View widget) {
              // add line number form interface
              line.onLineNumber(Integer.parseInt(lineNumber));
            }
          };
      spannableString.setSpan(clickableSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }
    get.setText(spannableString);
    get.setMovementMethod(LinkMovementMethod.getInstance());
  }
}
