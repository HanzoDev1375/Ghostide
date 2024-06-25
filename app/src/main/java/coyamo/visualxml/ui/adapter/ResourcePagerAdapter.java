package coyamo.visualxml.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ResourcePagerAdapter extends PagerAdapter {
    private Context ctx;
    private List<ResourceListAdapter> adapters;
    private List<RecyclerView> views;
    private List<String> names;

    public ResourcePagerAdapter(Context ctx, List<String> names) {
        this.ctx = ctx;
        this.names = names;
        adapters = new ArrayList<>();
        views = new ArrayList<>();

        for (int i = 0; i < names.size(); i++) {
            ResourceListAdapter adapter = new ResourceListAdapter(ctx, i);
            RecyclerView rv = new RecyclerView(ctx);
            rv.setAdapter(adapter);
            rv.setLayoutManager(new LinearLayoutManager(ctx));
            adapters.add(adapter);
            views.add(rv);
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return names.get(position);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(views.get(position));
        return views.get(position);
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(views.get(position));
    }

    public void addData(int i) {
        adapters.get(i).addData();
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

}
