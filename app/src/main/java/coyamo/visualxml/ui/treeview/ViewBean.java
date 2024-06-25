package coyamo.visualxml.ui.treeview;

import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.SeekBar;
import android.widget.Space;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TabHost;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.VideoView;

import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import Ninja.coder.Ghostemane.code.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import coyamo.visualxml.lib.parser.ReadOnlyParser;
import coyamo.visualxml.lib.proxy.ProxyResources;
import coyamo.visualxml.lib.proxy.ViewCreator;
import tellh.com.recyclertreeview_lib.LayoutItemType;

public class ViewBean implements LayoutItemType {
    public static Map<String, Integer> imgMap = new HashMap<>();

    static {
        imgMap.put("_unknown", R.drawable.ic_palette_unknown_view);
        imgMap.put(TextView.class.getSimpleName(), R.drawable.ic_palette_text_view);
        imgMap.put(EditText.class.getSimpleName(), R.drawable.ic_palette_edit_text);
        imgMap.put(Button.class.getSimpleName(), R.drawable.ic_palette_button);
        imgMap.put(ImageButton.class.getSimpleName(), R.drawable.ic_palette_image_button);
        imgMap.put(ImageView.class.getSimpleName(), R.drawable.ic_palette_image_view);
        imgMap.put(VideoView.class.getSimpleName(), R.drawable.ic_palette_video_view);
        imgMap.put(AutoCompleteTextView.class.getSimpleName(), R.drawable.ic_palette_auto_complete_text_view);
        imgMap.put(MultiAutoCompleteTextView.class.getSimpleName(), R.drawable.ic_palette_multi_auto_complete_text_view);
        imgMap.put(CheckedTextView.class.getSimpleName(), R.drawable.ic_palette_checked_text_view);
        imgMap.put(CheckBox.class.getSimpleName(), R.drawable.ic_palette_check_box);
        imgMap.put(RadioButton.class.getSimpleName(), R.drawable.ic_palette_radio_button);
        imgMap.put(RadioGroup.class.getSimpleName(), R.drawable.ic_palette_radio_group);
        imgMap.put(ToggleButton.class.getSimpleName(), R.drawable.ic_palette_toggle_button);
        imgMap.put(Switch.class.getSimpleName(), R.drawable.ic_palette_switch);
        imgMap.put(View.class.getSimpleName(), R.drawable.ic_palette_view);
        imgMap.put(WebView.class.getSimpleName(), R.drawable.ic_palette_web_view);
        imgMap.put(CalendarView.class.getSimpleName(), R.drawable.ic_palette_calendar_view);
        imgMap.put(ProgressBar.class.getSimpleName(), R.drawable.ic_palette_progress_bar);
        imgMap.put(ProgressBar.class.getSimpleName(), R.drawable.ic_palette_progress_bar_horizontal);
        imgMap.put(ProgressBar.class.getSimpleName(), R.drawable.ic_palette_progress_bar_horizontal);
        imgMap.put(SeekBar.class.getSimpleName(), R.drawable.ic_palette_seek_bar);
        imgMap.put(RatingBar.class.getSimpleName(), R.drawable.ic_palette_rating_bar);
        imgMap.put(TextureView.class.getSimpleName(), R.drawable.ic_palette_texture_view);
        imgMap.put(SurfaceView.class.getSimpleName(), R.drawable.ic_palette_surface_view);
        imgMap.put(SearchView.class.getSimpleName(), R.drawable.ic_palette_search_view);
        //imgMap.put(LinearLayout.class.getSimpleName()+"_horz", R.drawable.ic_palette_linear_layout_horz);
        //imgMap.put(LinearLayout.class.getSimpleName()+"_vert", R.drawable.ic_palette_linear_layout_vert);
        imgMap.put(LinearLayout.class.getSimpleName(), R.drawable.ic_palette_linear_layout_horz);
        imgMap.put(LinearLayout.class.getSimpleName(), R.drawable.ic_palette_linear_layout_vert);
        imgMap.put(FrameLayout.class.getSimpleName(), R.drawable.ic_palette_frame_layout);
        imgMap.put(TableLayout.class.getSimpleName(), R.drawable.ic_palette_table_layout);
        imgMap.put(TableRow.class.getSimpleName(), R.drawable.ic_palette_table_row);
        imgMap.put(Space.class.getSimpleName(), R.drawable.ic_palette_space);
        imgMap.put(Spinner.class.getSimpleName(), R.drawable.ic_palette_spinner);
        imgMap.put(ScrollView.class.getSimpleName(), R.drawable.ic_palette_scroll_view);
        imgMap.put(HorizontalScrollView.class.getSimpleName(), R.drawable.ic_palette_horizontal_scroll_view);
        imgMap.put(ViewStub.class.getSimpleName(), R.drawable.ic_palette_view_stub);
        imgMap.put("include", R.drawable.ic_palette_include);
        imgMap.put(GridLayout.class.getSimpleName(), R.drawable.ic_palette_grid_layout);
        imgMap.put(GridView.class.getSimpleName(), R.drawable.ic_palette_grid_view);
        imgMap.put(RecyclerView.class.getSimpleName(), R.drawable.ic_palette_recycler_view);
        imgMap.put(ListView.class.getSimpleName(), R.drawable.ic_palette_list_view);
        imgMap.put(TabHost.class.getSimpleName(), R.drawable.ic_palette_tab_host);
        imgMap.put(RelativeLayout.class.getSimpleName(), R.drawable.ic_palette_relative_layout);
        imgMap.put(Chip.class.getSimpleName(), R.drawable.ic_palette_chip);
        imgMap.put(ChipGroup.class.getSimpleName(), R.drawable.ic_palette_chip_group);
        imgMap.put(FloatingActionButton.class.getSimpleName(), R.drawable.ic_palette_floating_action_button);
        imgMap.put(NestedScrollView.class.getSimpleName(), R.drawable.ic_palette_nested_scroll_view);
        imgMap.put(ViewPager.class.getSimpleName(), R.drawable.ic_palette_view_pager);
        imgMap.put(ViewPager2.class.getSimpleName(), R.drawable.ic_palette_view_pager);
        imgMap.put(CardView.class.getSimpleName(), R.drawable.ic_palette_card_view);
        imgMap.put(AppBarLayout.class.getSimpleName(), R.drawable.ic_palette_app_bar_layout);
        imgMap.put(NavigationView.class.getSimpleName(), R.drawable.ic_palette_navigation_view);
        imgMap.put(BottomNavigationView.class.getSimpleName(), R.drawable.ic_palette_bottom_navigation_view);

    }

    private boolean isViewGroup;
    private String id;
    private String tagName;
    private int arrowId = R.drawable.ic_arrow;

    private List<ViewInfo> infoList = new ArrayList<>();
    private View view;

    public ViewBean(View v, ReadOnlyParser parser) {
        view = v;
        String id = parser.getAttributeValueInAndroid("id");
        if (id != null) id = ProxyResources.parseReferName(id);
        setId(id);
        setTagName(ViewCreator.getNameFromTag(parser.getName()));

        for (int i = 0; i < parser.getAttributeCount(); i++) {
            infoList.add(new ViewInfo(parser.getAttributePrefix(i), parser.getAttributeName(i), parser.getAttributeValue(i)));
        }
    }

    public List<ViewInfo> getInfoList() {
        return infoList;
    }

    public View getView() {
        return view;
    }

    public int getImgId() {
        if (imgMap.containsKey(ViewCreator.getNameFromTag(tagName))) return imgMap.get(tagName);
        return imgMap.get("_unknown");
    }

    public boolean isViewGroup() {
        return isViewGroup;
    }

    public void setViewGroup(boolean viewGroup) {
        isViewGroup = viewGroup;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public int getLayoutId() {
        return R.layout.view_bean_item;
    }

    public int getArrowId() {
        return arrowId;
    }

    public static class ViewInfo {
        private String prefix;
        private String attributeName;
        private String attributeValue;

        public ViewInfo(String prefix, String attributeName, String attributeValue) {
            this.prefix = prefix;
            this.attributeName = attributeName;
            this.attributeValue = attributeValue;
        }

        public String getPrefix() {
            return prefix;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }

        public String getAttributeName() {
            return attributeName;
        }

        public void setAttributeName(String attributeName) {
            this.attributeName = attributeName;
        }

        public String getAttributeValue() {
            return attributeValue;
        }

        public void setAttributeValue(String attributeValue) {
            this.attributeValue = attributeValue;
        }
    }
}
