package ir.ninjacoder.prograsssheet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputLayout;
import ir.ninjacoder.prograsssheet.databinding.LayoutSheetRvBinding;

public class RecyclerViewSearchLayoutSheet {

  private Context context;
  private LayoutSheetRvBinding bind;
  private Sheet sheet;

  public RecyclerViewSearchLayoutSheet(Context context) {
    this.context = context;
    bind = LayoutSheetRvBinding.inflate(LayoutInflater.from(context));
    sheet = new Sheet(context);
  }

  public RecyclerViewSearchLayoutSheet show() {
    sheet.show();
    return this;
  }

  public RecyclerViewSearchLayoutSheet setTitle(String t) {
    bind.titleview.setText(t);
    return this;
  }

  public RecyclerViewSearchLayoutSheet setAdapter(RecyclerView.Adapter ad) {
    bind.rv.setAdapter(ad);
    return this;
  }

  public Button getButtonOk() {
    return bind.btnokrow;
  }

  public Button getButtonNo() {
    return bind.btnnorow;
  }

  public RecyclerView getRecyclerView() {
    return bind.rv;
  }

  public EditText getEditText() {
    return bind.input.getEditText();
  }

  public TextInputLayout getTextInputLayout() {
    return bind.input;
  }

  public RecyclerViewSearchLayoutSheet dismiss() {
    sheet.dismiss();
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
}
