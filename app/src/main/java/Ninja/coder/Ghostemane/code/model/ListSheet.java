package Ninja.coder.Ghostemane.code.model;

import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.utils.ColorAndroid12;
import android.content.Context;
import android.graphics.PorterDuff;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.color.MaterialColors;

import java.io.File;
import java.util.ArrayList;

public class ListSheet {
  protected ListView listview;
  protected BottomSheetDialog dialog;
  private ArrayList<ItemSheet> item = new ArrayList<>();

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

    listview = new ListView(context);
    ListView.LayoutParams param =
        new ListView.LayoutParams(
            ListView.LayoutParams.MATCH_PARENT, ListView.LayoutParams.WRAP_CONTENT);
    listview.setLayoutParams(param);
    listview.setAdapter(new SheetAd(item));
    listview.setDividerHeight(0);

    listview.setPadding(7, 7, 7, 7);
    dialog = new BottomSheetDialog(context);
    dialog.setContentView(listview);

    if (dialog != null) {
      dialog.show();
    }
  }

  public void setOnItemClickLabe(OnItemClick itemClick) {
    if (itemClick != null) {
      listview.setOnItemClickListener(
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
    ArrayList<ItemSheet> helper = new ArrayList<>();

    public SheetAd(ArrayList<ItemSheet> helper) {
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
          MaterialColors.getColor(img, ColorAndroid12.colorOnSurface, 0), PorterDuff.Mode.SRC_IN);
      tv.setTextColor(MaterialColors.getColor(tv, ColorAndroid12.colorOnSurface, 0));

      return view;
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
