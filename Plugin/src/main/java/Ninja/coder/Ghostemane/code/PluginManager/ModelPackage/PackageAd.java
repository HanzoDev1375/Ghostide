package Ninja.coder.Ghostemane.code.PluginManager.ModelPackage;

import Ninja.coder.Ghostemane.code.PluginManager.R;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PackageAd extends RecyclerView.Adapter<PackageAd.VH> {

  protected List<PackageModels> model;
  protected Context context;
  protected WorkPackageManager workmanager;
  protected OnClick click;

  public PackageAd(List<PackageModels> model, Context context, OnClick click) {
    this.model = model;
    this.context = context;
    workmanager = new WorkPackageManager();
    this.click = click;
  }

  static class VH extends RecyclerView.ViewHolder {

    TextView title;
    ImageView run, uinstall, edit, showicon;

    public VH(View view) {
      super(view);
      title = view.findViewById(R.id.title);
      run = view.findViewById(R.id.run);
      uinstall = view.findViewById(R.id.uinstall);
      edit = view.findViewById(R.id.edit);
      showicon = view.findViewById(R.id.showicon);
    }
  }

  @Override
  public VH onCreateViewHolder(ViewGroup arg0, int arg1) {
    return new VH(
        LayoutInflater.from(arg0.getContext()).inflate(R.layout.layout_rv_ad_list, arg0, false));
  }

  @Override
  public void onBindViewHolder(VH holder, int pos) {
    var get = model.get(pos);
    var views = holder.itemView;

    AppInfo appInfo = AppInfoFether.getAppInfo(context, get.getPackageName());

    holder.edit.setEnabled(workmanager.isAopNotFound(get.getPackageName(), context));
    holder.uinstall.setEnabled(workmanager.isAopNotFound(get.getPackageName(), context));
    holder.run.setEnabled(workmanager.isAopNotFound(get.getPackageName(), context));
    holder.title.setText("App is Install By " + appInfo.getName());
    if (get.getIsWorkable()) {
      holder.run.setOnClickListener(
          it -> {
            var intent = new Intent();
            intent.setComponent(new ComponentName(get.getPackageName(), get.getPackageComponet()));
            context.startActivity(intent);
          });
    }

    if (get.getIsUinstall()) {

      holder.uinstall.setOnClickListener(
          it -> {
            Uri packageURI = Uri.parse("package:".concat(get.getPackageName()));
            Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
            context.startActivity(uninstallIntent);
            notifyItemRemoved(holder.getAdapterPosition());
          });
    }

    holder.edit.setOnClickListener(it -> {});

    holder.uinstall.setColorFilter(Color.RED);
    holder.run.setColorFilter(Color.GREEN);
    holder.edit.setColorFilter(Color.YELLOW);
    holder.edit.setImageResource(R.drawable.edit_outlined_24px);
    holder.uinstall.setImageResource(R.drawable.it);
    holder.run.setImageResource(R.drawable.play_arrow_two_tone_24px);
    holder.showicon.setImageDrawable(appInfo.getIcon());
  }

  @Override
  public int getItemCount() {

    return model.size();
  }

  public interface OnClick {
    void Click(View view, int pos);
  }
}
