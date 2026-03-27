package ir.ninjacoder.prograsssheet;

import io.noties.markwon.Markwon;
import io.noties.markwon.html.HtmlPlugin;
import ir.ninjacoder.prograsssheet.databinding.LayoutEdittextSheetBinding;
import android.content.Context;
import android.view.View;
import android.view.LayoutInflater;
import android.app.Activity;

public class ViewSheet {
  private LayoutEdittextSheetBinding bind;
  private Context context;
  private Sheet sheet;

  public ViewSheet(Context context) {
    this.context = context;
    bind = LayoutEdittextSheetBinding.inflate(LayoutInflater.from(context));
    sheet = new Sheet(context);
    sheet.show();
    bind.editors.setVisibility(View.INVISIBLE);
  }

  public ViewSheet setTitle(String title) {
    Markwon mark = Markwon.builder(context).usePlugin(HtmlPlugin.create()).build();
    mark.setMarkdown(bind.msg,title);
    return this;
  }

  public void setTitleColor(int color) {
    bind.title.setTextColor(color);
  }

  public void setMassges(String title) {
    bind.msg.setVisibility(View.VISIBLE);
    Markwon mark = Markwon.builder(context).usePlugin(HtmlPlugin.create()).build();
    mark.setMarkdown(bind.msg,title);
  }

  public void setOnButtonOkClick(View.OnClickListener c) {
    bind.btnok.setOnClickListener(c);
  }

  public void setOnButtonNoClick(View.OnClickListener c) {
    bind.btnno.setOnClickListener(c);
  }

  public boolean isShow() {
    return sheet.isShowing();
  }

  public void hide() {
    sheet.dismiss();
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
