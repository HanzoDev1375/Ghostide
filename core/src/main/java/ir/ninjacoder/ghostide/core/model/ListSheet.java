package ir.ninjacoder.ghostide.core.model;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.color.MaterialColors;
import com.ninjacoder.jgit.databinding.LayoutListsheetBinding;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.model.HeaderDecoration;
import ir.ninjacoder.ghostide.core.model.ItemSheet;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;

public class ListSheet {
  protected BottomSheetDialog dialog;
  private List<ItemSheet> item = new ArrayList<>();
  protected LayoutListsheetBinding binding;

  public static void bind(RecyclerView tv, String Folder) {
    TextView tvview = new TextView(tv.getContext());
    TextView folder = new TextView(tv.getContext());
    ViewGroup.LayoutParams parsm =
        new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    tvview.setLayoutParams(parsm);
    tvview.setGravity(Gravity.CENTER);
    folder.setLayoutParams(parsm);
    folder.setGravity(Gravity.CENTER);

    HeaderDecoration div = new HeaderDecoration(tvview, folder, new File(Folder));
    tv.addItemDecoration(div);
  }

  public void setSheetDialog(Context context) {
    binding = LayoutListsheetBinding.inflate(LayoutInflater.from(context));

    binding.list.setAdapter(new SheetAd(item));
    binding.list.setDividerHeight(0);
    dialog = new BottomSheetDialog(context);
    dialog.setContentView(binding.getRoot());

    if (dialog != null) {
      dialog.show();
    }
  }

  public void setOnItemClickLabe(OnItemClick itemClick) {
    if (itemClick != null) {
      binding.list.setOnItemClickListener(
          (adview, view, pos, lb) -> {
            itemClick.OnItemClick(pos);
          });
    }
  }

  public void addItem(String itemName, int IconName, boolean en) {
    item.add(new ItemSheet(itemName, IconName, en));
  }

  public void addItem(String itemName, int IconName) {
    item.add(new ItemSheet(itemName, IconName, true));
  }

  public void addItem(String itemName) {
    item.add(new ItemSheet(itemName, 0, true));
  }

  public interface OnItemClick {
    public void OnItemClick(int pos);
  }

  private class SheetAd extends BaseAdapter {
    List<ItemSheet> helper = new ArrayList<>();

    public SheetAd(List<ItemSheet> helper) {
      this.helper = helper;
    }

    @Override
    public int getCount() {
      // TODO: Implement this method
      return helper.size();
    }

    @Override
    public ItemSheet getItem(int itemz) {
      // TODO: Implement this method
      return helper.get(itemz);
    }

    @Override
    public long getItemId(int id) {
      // TODO: Implement this method
      return id;
    }

    @Override
    public View getView(int pos, View noview, ViewGroup parnt) {
      // TODO: Implement this method
      View view = LayoutInflater.from(parnt.getContext()).inflate(R.layout.aaa, parnt, false);
      ItemSheet sheet = helper.get(pos);
      ImageView img = view.findViewById(R.id.img);
      TextView tv = view.findViewById(R.id.tv);
      tv.setText(sheet.getName());
      if (img != null) {
        if (sheet.getIcon() == 0) {
          img.setVisibility(View.GONE);
        }
        img.setImageResource(sheet.getIcon());
      }
      tv.setEnabled(sheet.getEn() ? true : false);
      img.setColorFilter(
          MaterialColors.getColor(img, ObjectUtils.colorOnSurface, 0), PorterDuff.Mode.SRC_IN);
      tv.setTextColor(MaterialColors.getColor(tv, ObjectUtils.colorOnSurface, 0));

      return view;
    }
  }

  public void dissmiss() {
    if (dialog != null) {
      dialog.dismiss();
    }
  }

  public boolean getDismiss(boolean is) {
    if (is) {
      dialog.dismiss();
      return true;
    } else {
      return false;
    }
  }
}
