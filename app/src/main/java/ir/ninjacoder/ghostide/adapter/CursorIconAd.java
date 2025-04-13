package ir.ninjacoder.ghostide.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import ir.ninjacoder.ghostide.R;
import ir.ninjacoder.ghostide.utils.FileUtil;
import java.util.ArrayList;
import java.util.List;
import android.content.SharedPreferences.Editor;
import java.util.Map;

public class CursorIconAd extends RecyclerView.Adapter<CursorIconAd.Holder> {
  private Context context;
  private SharedPreferences prf;
  private OnItemClickVistor visit;
  private List<Map<String, String>> listModel = new ArrayList<>();
  ;
  String jsonPath = "/storage/emulated/0/GhostWebIDE/cursor/cursor.json";

  public CursorIconAd(Context context, OnItemClickVistor visit) {
    this.context = context;
    this.visit = visit;
    prf = context.getSharedPreferences("keys", Context.MODE_PRIVATE);

    listModel =
        new Gson()
            .fromJson(
                FileUtil.readFile(jsonPath),
                new TypeToken<List<Map<String, String>>>() {}.getType());
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
    return listModel.size();
  }

  @Override
  public void onBindViewHolder(Holder holder, int pos) {
    var itempos = listModel.get(pos);
    Glide.with(holder.iconname.getContext())
        .load(itempos.get("cursorstart"))
        .error(R.drawable.errorxml)
        .into(holder.iconname);
    Glide.with(holder.headericon.getContext())
        .load(itempos.get("cursorend"))
        .error(R.drawable.errorxml)
        .into(holder.headericon);
    holder.mainname.setText(itempos.get("namecursorstart"));
    holder.headername.setText(itempos.get("namecursorend"));
    holder.itemView.setOnClickListener(
        v -> {
          visit.click(holder.getAdapterPosition());
          Editor editor = prf.edit();
          editor.putString("name", itempos.get("cursorstart"));
          editor.putString("header", itempos.get("cursorend"));
          editor.apply();
        });
  }

  @Override
  public Holder onCreateViewHolder(ViewGroup arg0, int arg1) {
    return new Holder(
        LayoutInflater.from(arg0.getContext()).inflate(R.layout.cursor_layout_ad, arg0, false));
  }
}
