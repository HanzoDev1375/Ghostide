package com.ninjacoder.jgit.search;

import android.text.Editable;

public interface SearchCallBack{
  void onTextChange(String text);

  void onafterTextChanged(Editable edit, String code);
}
