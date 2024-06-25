package com.mcal.uidesigner.common;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.mcal.uidesigner.R;
import com.mcal.uidesigner.XmlLayoutDesignActivity;

import java.util.ArrayList;
import java.util.List;

public class PropertiesDialog extends MessageBox {
    private final List<PropertyCommand> enabledCommands = new ArrayList<>();
    private final String title;

    public PropertiesDialog(String title, @NonNull List<? extends PropertyCommand> commands) {
        this.title = title;
        for (PropertyCommand command : commands) {
            if (command.canRun()) {
                enabledCommands.add(command);
            }
        }
    }

    @Override
    protected Dialog buildDialog(Activity activity) {
        final ListView listView = new ListView(activity);
        listView.setAdapter(new PropertyCommandEntryAdapter(activity, enabledCommands));

        final MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(activity);
        dialog.setCancelable(true);
        dialog.setView(listView);
        dialog.setTitle(title);

        final AlertDialog alertDialog = dialog.create();
        alertDialog.setCanceledOnTouchOutside(true);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            alertDialog.dismiss();
            enabledCommands.get(position).run();
        });
        return alertDialog;
    }

    public interface PropertyCommand {
        boolean canRun();

        String getHelpUrl();

        int getIconAttr();

        String getName();

        void run();
    }

    private static class PropertyCommandEntryAdapter extends ArrayAdapter<PropertyCommand> {
        public PropertyCommandEntryAdapter(Context context, List<PropertyCommand> commands) {
            super(context, R.layout.propertydialog_entry, commands);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            int i = View.VISIBLE;
            View view = convertView;
            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(R.layout.propertydialog_entry, parent, false);
            }
            PropertyCommand command = getItem(position);
            ((TextView) view.findViewById(R.id.widgetmenuEntryName)).setText(Html.fromHtml(command.getName()));
            ((ImageView) view.findViewById(R.id.widgetmenuEntryImage)).setImageResource(AndroidHelper.obtainImageResourceId(getContext(), command.getIconAttr()));
            final String helpUrl = command.getHelpUrl();
            View helpView = view.findViewById(R.id.widgetmenuHelpButton);
            if (helpUrl == null) {
                i = View.GONE;
            }
            helpView.setVisibility(i);
            if (helpUrl != null) {
                helpView.setOnClickListener(v -> ((XmlLayoutDesignActivity) getContext()).showHelp(helpUrl));
            }
            return view;
        }
    }
}
