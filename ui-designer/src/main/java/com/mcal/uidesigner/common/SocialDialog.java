package com.mcal.uidesigner.common;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.mcal.uidesigner.R;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.List;

public class SocialDialog extends MessageBox {
    private final Runnable done;
    private final List<SocialListEntry> entries1;
    private final List<SocialListEntry> entries2;
    private final String message;
    private final String title;
    private boolean isExpanded;

    private SocialDialog(String title, String message, List<SocialListEntry> entries1, List<SocialListEntry> entries2, Runnable done) {
        this.title = title;
        this.message = message;
        this.done = done;
        this.entries1 = entries1;
        this.entries2 = entries2;
    }

    public static void showCommunityDialog(final Activity activity) {
        List<SocialListEntry> entries1 = new ArrayList<>();
        entries1.add(new SocialListEntry(R.drawable.ic_email, "Google+", () -> Social.openGooglePlusPage(activity, "101304250883271700981")));
        entries1.add(new SocialListEntry(R.drawable.ic_email, "Twitter", () -> Social.openTwitterPage(activity, "AndroidIDE")));
        entries1.add(new SocialListEntry(R.drawable.ic_email, "Facebook", () -> Social.openFacebookPage(activity, "239564276138537")));

        List<SocialListEntry> entries2 = new ArrayList<>(entries1);
        entries2.add(new SocialListEntry(R.drawable.ic_email, "G+ Community", () -> SocialDialog.openGooglePlusCommunity(activity)));
        entries2.add(new SocialListEntry(R.drawable.ic_email, "Google Group", () -> Social.openGoogleGroup(activity, "android-ide")));
        entries2.add(new SocialListEntry(R.drawable.ic_email, "Email", new Runnable() {
            @Override
            public void run() {
                Social.sendEmail(activity, "timscriptov@gmail.com", "App UI Designer Feedback", "With App UI Designer " + getVersionString() + " " + getOnMyDeviceString() + " (SDK " + Build.VERSION.SDK_INT + ")...\n\n[Write text here]");
            }

            private String getVersionString() {
                try {
                    return activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0).versionName;
                } catch (PackageManager.NameNotFoundException e) {
                    return "(version unknown)";
                }
            }

            @NonNull
            @Contract(pure = true)
            private String getOnMyDeviceString() {
                String model = Build.MODEL;
                if (model == null || model.length() > 40) {
                    return "";
                }
                return "on my " + model;
            }
        }));
        if (!AndroidHelper.isOuyaEdition()) {
            entries2.add(new SocialListEntry(R.drawable.ic_shop, activity.getResources().getString(R.string.dialog_community_rate), () -> Social.openPlayPage(activity, activity.getPackageName(), "community")));
        }
        entries1.add(new SocialListEntry(0, activity.getResources().getString(R.string.dialog_community_more)));
        MessageBox.showDialog(activity, new SocialDialog(activity.getResources().getString(R.string.dialog_community_title), activity.getResources().getString(R.string.dialog_community_message), entries1, entries2, null));
    }

    public static void openGooglePlusCommunity(Activity activity) {
        if (AndroidHelper.isOuyaEdition()) {
            Social.openGooglePlusPage(activity, "101304250883271700981");
        } else {
            Social.openGooglePlusCommunity(activity, "104927725094165066286");
        }
    }

    public static void showTrainerQuestionDialog(@NonNull final Activity activity, String title, String message, Runnable skip) {
        List<SocialListEntry> entries = new ArrayList<>();
        entries.add(new SocialListEntry(R.drawable.ic_email, activity.getResources().getString(R.string.dialog_community_ask), () -> SocialDialog.openGooglePlusCommunity(activity)));
        if (skip != null) {
            entries.add(new SocialListEntry(0, activity.getResources().getString(R.string.trainer_skip_lesson) + " ↷", skip, true));
        }
        entries.add(new SocialListEntry(0, activity.getResources().getString(R.string.dialog_community_continue) + " ≫"));
        MessageBox.showDialog(activity, new SocialDialog(title, message, entries, null, null));
    }

    public static void showRateDialog(@NonNull final Activity activity, String title, String message, final String pakage, final String linkId, Runnable done) {
        List<SocialListEntry> entries = new ArrayList<>();
        entries.add(new SocialListEntry(R.drawable.ic_shop, activity.getResources().getString(R.string.dialog_community_rate), () -> Social.openPlayPage(activity, pakage, linkId)));
        entries.add(new SocialListEntry(0, activity.getResources().getString(R.string.dialog_community_continue) + " ≫"));
        MessageBox.showDialog(activity, new SocialDialog(title, message, entries, null, done));
    }

    public static void showShareDialog(@NonNull final Activity activity, String title, final String text, final String link, Runnable done) {
        List<SocialListEntry> entries = new ArrayList<>();
        entries.add(new SocialListEntry(R.drawable.ic_email, "Google+", () -> Social.shareWithGooglePlus(activity, text, link)));
        entries.add(new SocialListEntry(R.drawable.ic_email, "Twitter", () -> Social.shareWithTwitter(activity, text, link)));
        entries.add(new SocialListEntry(R.drawable.ic_email, "Facebook", () -> Social.shareWithFacebook(activity, text, link)));
        entries.add(new SocialListEntry(0, activity.getResources().getString(R.string.dialog_community_continue) + " ≫"));
        MessageBox.showDialog(activity, new SocialDialog(title, "\"" + text + "\"", entries, null, done));
    }

    @Override
    protected Dialog buildDialog(final Activity activity) {
        LinearLayout layout = (LinearLayout) LayoutInflater.from(activity).inflate(R.layout.share_dialog, null);
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(activity);
        builder.setView(layout).setCancelable(true).setTitle(this.title);
        final AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(true);
        dialog.setOnCancelListener(dialog2 -> {
            if (done != null) {
                done.run();
            }
        });
        ((TextView) layout.findViewById(R.id.shareDialogMessage)).setText(this.message);
        final ListView listView = layout.findViewById(R.id.shareDialogList);
        listView.setAdapter(new ShareEntryAdapter(activity, this.entries1));
        listView.setOnItemClickListener((parent, view, position, id) -> {
            SocialListEntry entry = (SocialListEntry) parent.getItemAtPosition(position);
            if (entry.dismiss) {
                if (entries2 == null || isExpanded) {
                    dialog.dismiss();
                    if (done != null) {
                        done.run();
                    }
                } else {
                    isExpanded = true;
                    listView.setAdapter(new ShareEntryAdapter(activity, entries2));
                }
            }
            if (entry.runnable != null) {
                entry.runnable.run();
            }
        });
        return dialog;
    }

    private static class SocialListEntry {
        private final boolean dismiss;
        private final int icon;
        private final String label;
        private final Runnable runnable;

        public SocialListEntry(int icon, String label) {
            this.icon = icon;
            this.label = label;
            this.runnable = null;
            this.dismiss = true;
        }

        public SocialListEntry(int icon, String label, Runnable runnable) {
            this.icon = icon;
            this.label = label;
            this.runnable = runnable;
            this.dismiss = false;
        }

        public SocialListEntry(int icon, String label, Runnable runnable, boolean dismiss) {
            this.icon = icon;
            this.label = label;
            this.runnable = runnable;
            this.dismiss = dismiss;
        }
    }

    private static class ShareEntryAdapter extends ArrayAdapter<SocialListEntry> {
        public ShareEntryAdapter(Context context, List<SocialListEntry> entries) {
            super(context, R.layout.share_dialog_entry, entries);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            int i = View.GONE;
            View view = convertView;
            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(R.layout.share_dialog_entry, parent, false);
            }
            SocialListEntry entry = getItem(position);
            ((TextView) view.findViewById(R.id.shareDialogEntryText)).setText(entry.label);
            ImageView imageView = view.findViewById(R.id.shareDialogEntryImage);
            if (entry.icon != View.VISIBLE) {
                imageView.setImageResource(entry.icon);
            }
            if (entry.icon == View.VISIBLE) {
                i = View.INVISIBLE;
            }
            imageView.setVisibility(i);
            return view;
        }
    }
}
