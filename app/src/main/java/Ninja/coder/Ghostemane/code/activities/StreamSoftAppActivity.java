package Ninja.coder.Ghostemane.code.activities;

import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.adapter.StreamAd;
import Ninja.coder.Ghostemane.code.model.ListitemModel;
import Ninja.coder.Ghostemane.code.terminal.TerminalActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.List;

public class StreamSoftAppActivity extends BaseCompat implements StreamAd.OnItemClick {
    protected MaterialCardView materialCard;
    protected ImageView iconApp;
    protected TextView titleApp;
    protected RecyclerView listview1;
    protected StreamAd ad;
    protected List<ListitemModel> model = new ArrayList<>();

    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        setContentView(R.layout.streamsoftapp);
        configId();
    }

    protected void configId() {
        materialCard = findViewById(R.id.stramCard);
        iconApp = findViewById(R.id.iconApp);
        titleApp = findViewById(R.id.titleApp);
        listview1 = findViewById(R.id.recyclerviewstream);
        bind();
        getOnBackPressedDispatcher()
                .addCallback(
                        this,
                        new OnBackPressedCallback(true) {
                            @Override
                            public void handleOnBackPressed() {
                                new MaterialAlertDialogBuilder(StreamSoftAppActivity.this)
                                        .setTitle("Exit")
                                        .setMessage("Are you Exit App?")
                                        .setPositiveButton("exit", (c, d) -> finishAffinity())
                                        .setNegativeButton("no", null).setCancelable(false)
                                        .show();
                            }
                        });
    }

    protected void bind() {
        titleApp.setTextSize(17);
        model.add(new ListitemModel("FileManager", R.drawable.folder3));
        model.add(new ListitemModel("Java codes", R.drawable.javanull));
        model.add(new ListitemModel("Setting", R.drawable.ic_settings_white));
        model.add(new ListitemModel("Terminal", R.drawable.keyboardlisnertalluserpost_4));
        model.add(new ListitemModel("exit", R.drawable.close));
        ad = new StreamAd(model, this);
        listview1.setAdapter(ad);
        listview1.setLayoutManager(new LinearLayoutManager(this));
    }

    protected void setClass(Class<?> cls) {
        Intent i = new Intent();
        i.setClass(this, cls);
        startActivity(i);
    }

    @Override
    public void onClick(int pos, View c) {
        switch (pos) {
            case 0:
                setClass(FileDirActivity.class);
                break;
            case 1:
                setClass(JavaManagerLayoutActivity.class);
                break;
            case 2:
                setClass(SettingAppActivity.class);
                break;
            case 3:
                setClass(TerminalActivity.class);
                break;
            case 4:
                finishAffinity();
                break;
        }
    }
}
