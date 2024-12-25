package ir.ninjacoder.ghostide.adapter;

import ir.ninjacoder.ghostide.R;
import ir.ninjacoder.ghostide.compressor.SvgToPng;
import ir.ninjacoder.ghostide.filehelper.FileNio;
import ir.ninjacoder.ghostide.glidecompat.GlideCompat;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import ir.ninjacoder.ghostide.utils.FileUtil;
import ir.ninjacoder.ghostide.utils.VectorHelper;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.color.MaterialColors;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IconShopAd extends RecyclerView.Adapter<IconShopAd.VH> {
    protected List<File> files;
    protected List<File> filteredFiles;
    protected IconShopCallBack callback;
    protected Context context;
    protected File mfile;
    private String SVG_PATH_SU = "/storage/emulated/0/ghostweb/icon/svg";

    public IconShopAd(List<File> files, IconShopCallBack callback, Context context) {
        this.files = files;
        this.filteredFiles = files;
        this.callback = callback;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return files.size();
    }

    @Override
    public void onBindViewHolder(VH viewholder, int pos) {
        mfile = files.get(pos);
        GlideCompat.LoadSvg(files.get(pos).toString(), viewholder.icon);
        viewholder.nameIcon.setText(mfile.getName());
        View view = viewholder.itemView;
        viewholder.icon.setOnClickListener(
                v -> {
                    var menu =
                            new PowerMenu.Builder(context)
                                    .addItem(new PowerMenuItem("Case to Vector"))
                                    .addItem(new PowerMenuItem("Add svg to project"))
                                    .addItem(new PowerMenuItem("Case to png"))
                                    .setIsMaterial(true)
                                    .build();
                    menu.setMenuColor(MaterialColors.getColor(context, ObjectUtils.Back, 0));
                    menu.setMenuRadius(20f);
                    menu.setTextColor(MaterialColors.getColor(context, ObjectUtils.colorOnSurface, 0));
                    menu.setShowBackground(false);
                    menu.setAutoDismiss(true);
                    menu.setOnMenuItemClickListener(
                            (pos2, __) -> {
                                switch (pos2) {
                                    case 0 -> {
                                        getVectorIamge(files.get(pos).toString());
                                        break;
                                    }
                                    case 1 -> {
                                        copy(files.get(pos).toString());
                                        break;
                                    }
                                    case 2 -> {
                                        svgtopng(files.get(pos).toString());
                                        break;
                                    }
                                }
                            });
                    menu.showAsAnchorRightBottom(v);
                });
        viewholder.icon.setOnLongClickListener(
                c -> {
                    callback.OnItemLongClicket(pos, c);
                    return false;
                });
        viewholder.nameIcon.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        viewholder.nameIcon.setMarqueeRepeatLimit(-1);
        viewholder.nameIcon.setSingleLine(true);
        viewholder.nameIcon.setSelected(true);
        //    var param =
        //          new RecyclerView.LayoutParams(
        //              ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //      viewholder.itemView.setLayoutParams(param);
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parnt, int viewType) {
        var view = LayoutInflater.from(parnt.getContext()).inflate(R.layout.icon, parnt, false);
        var param =
                new RecyclerView.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(param);
        return new VH(view);
    }

    public void search(String query) {
        if (query.length() > 0) {
            List<File> result = new ArrayList<>();
            for (File file : this.files) {
                if (file.getName().toLowerCase().contains(query.toLowerCase())) {
                    result.add(file);
                }
            }

            this.filteredFiles = result;
            notifyDataSetChanged();
        } else {
            this.filteredFiles = this.files;
            notifyDataSetChanged();
        }
    }

    public String getItem(int pos) {
        return files.get(pos).toString();
    }

    public void getVectorIamge(String pos) {
        var output = "/sdcard/ghostweb/icon/vector/";
        FileUtil.makeDir(output);
        VectorHelper.iconPath = pos;
        VectorHelper.projectResourceDirectory = output;
        VectorHelper.v((Activity) context, () -> {
        });
    }

    public void copy(String path) {
        try {
            FileNio.copyFileOrFolder(SVG_PATH_SU, path);
        } catch (IOException E) {
            E.printStackTrace();
        }
    }

    public void svgtopng(String path) {
        File filePath = new File(path);
        File output = new File(SVG_PATH_SU);
        SvgToPng svgtoPng =
                new SvgToPng(
                        context,
                        filePath,
                        output,
                        new SvgToPng.OnConversionListener() {

                            @Override
                            public void onConversionError(String error) {
                            }

                            @Override
                            public void onConversionSuccess() {
                            }
                        });
        svgtoPng.execute();
    }

    public interface IconShopCallBack {
        public void OnItemClicket(int pos, View view);

        public void OnItemLongClicket(int pos, View view);
    }

    class VH extends RecyclerView.ViewHolder {
        private ImageView icon;
        private TextView nameIcon;

        public VH(View itemview) {
            super(itemview);

            icon = itemview.findViewById(R.id.icon_from_iconmode);
            nameIcon = itemview.findViewById(R.id.name_icon_fromiconmode);
        }
    }
}
