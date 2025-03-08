package ir.ninjacoder.ghostide.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.ninjacoder.ghostide.R;
import ir.ninjacoder.ghostide.model.CursorIconModel;
import java.util.ArrayList;
import java.util.List;
import android.content.SharedPreferences.Editor;

public class CursorIconAd extends RecyclerView.Adapter<CursorIconAd.Holder> {
  private List<CursorIconModel> model;
  private Context context;
  private SharedPreferences prf;
  private OnItemClickVistor visit;

  public CursorIconAd(Context context, OnItemClickVistor visit) {
    this.context = context;
    this.visit = visit;
    prf = context.getSharedPreferences("keys", Context.MODE_PRIVATE);
    model = new ArrayList<>();
    add(R.drawable.ghostcallcurfa, R.drawable.ghostcallcurbl, "Ghost ", "Nife model");
    add(R.drawable.ghostcurfa, R.drawable.ghostcubl, "Ghost Red ", "Red model");
    add(R.drawable.handcurfa,R.drawable.handcurbl,"Blue Hand","Blue Hand drak");
    add(R.drawable.ktcurfa,R.drawable.ktcurbld,"God of war face","god of war nife");
    add(R.drawable.mousecurfa,R.drawable.mousecurbl,"Hand Drak ","Mouse Drak");
    add(R.drawable.ninjacurfa,R.drawable.ninjacurbl,"dantelo face","danleto wood");
    add(R.drawable.vacurfa,R.drawable.vacurbl,"Venom face","Venom D");
  }

  void add(int iconname, int headericon, String iconnamestr, String iconheadername) {
    model.add(new CursorIconModel(iconname, headericon, iconnamestr, iconheadername, false));
  }

  public interface OnItemClickVistor {

    void click(int pos);
  }

  public static class Holder extends RecyclerView.ViewHolder {
    private TextView mainname, headername;
    private ImageView iconname, headericon;
    

    public Holder(View view) {
      super(view);
      iconname = view.findViewById(R.id.iconmain);
      headericon = view.findViewById(R.id.iconstate);
      mainname = view.findViewById(R.id.maintext);
      headername = view.findViewById(R.id.nameheader);
    }
  }

  @Override
  public int getItemCount() {
    return model.size();
  }

  @Override
  public void onBindViewHolder(Holder holder, int pos) {
    var itempos = model.get(pos);
    holder.iconname.setImageResource(itempos.getIcon());
    holder.headericon.setImageResource(itempos.getHeadericon());
    holder.mainname.setText(itempos.getNameicon());
    holder.headername.setText(itempos.getIconhader());
    holder.itemView.setOnClickListener(
        v -> {
          visit.click(holder.getAdapterPosition());
          Editor editor = prf.edit();
          editor.putInt("name", itempos.getIcon());
          editor.putInt("header", itempos.getHeadericon());
          editor.apply();
        });
  }

  @Override
  public Holder onCreateViewHolder(ViewGroup arg0, int arg1) {
    return new Holder(
        LayoutInflater.from(arg0.getContext()).inflate(R.layout.cursor_layout_ad, arg0, false));
  }
}
