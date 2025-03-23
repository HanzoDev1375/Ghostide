package ir.ninjacoder.prograsssheet;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import ir.ninjacoder.prograsssheet.databinding.LayoutEdittextSheetBinding;

public class ExitSheet {

  private LayoutEdittextSheetBinding bind;
  private Context context;
  private Sheet sheet;

  public ExitSheet(Context context) {
    this.context = context;
    bind = LayoutEdittextSheetBinding.inflate(LayoutInflater.from(context));
    sheet = new Sheet(context);
    sheet.show();
    bind.editors.setVisibility(View.INVISIBLE);
    bind.btnok.setOnClickListener(i -> ((Activity) context).finishAffinity());
    bind.btnno.setOnClickListener(i -> sheet.dismiss());
    bind.btnok.setText("exit");
    
  }

  public ExitSheet setTitle(String c) {
    bind.title.setText(c);
    return this;
  }

  class Sheet extends CustomSheet {
    Sheet(Context c) {
      super(c);
    }

    @Override
    public View getView() {
      return bind.getRoot();
    }
  }
}
