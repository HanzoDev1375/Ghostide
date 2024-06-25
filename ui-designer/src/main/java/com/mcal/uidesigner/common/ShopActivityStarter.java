package com.mcal.uidesigner.common;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;

public class ShopActivityStarter {
    public static final String EXTRA_FEATURE = "EXTRA_FEATURE";
    public static final String EXTRA_LINKID = "EXTRA_LINKID";
    public static final String EXTRA_SHOW_DEBUGGER = "EXTRA_SHOW_DEBUGGER";
    public static final String EXTRA_SHOW_DESIGNER = "EXTRA_SHOW_DESIGNER";
    public static final String EXTRA_SHOW_PREMIUM = "EXTRA_SHOW_PREMIUM";
    public static final String EXTRA_SHOW_PRIME_MONTHLY = "EXTRA_SHOW_PRIME_MONTHLY";
    public static final String EXTRA_SHOW_PRIME_YEARLY = "EXTRA_SHOW_PRIME_YEARLY";

    public static void show(Activity parent, int requestCode, String featureText, String linkId, boolean showPrimeMonthly, boolean showPrimeYearly, boolean showPremium, boolean showDesigner, boolean showDebugger) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(parent, "com.mcal.ui.activities.ShopPopupActivity"));
        intent.putExtra(EXTRA_FEATURE, featureText);
        intent.putExtra(EXTRA_LINKID, linkId);
        intent.putExtra(EXTRA_SHOW_PRIME_MONTHLY, showPrimeMonthly);
        intent.putExtra(EXTRA_SHOW_PRIME_YEARLY, showPrimeYearly);
        intent.putExtra(EXTRA_SHOW_DESIGNER, showDesigner);
        intent.putExtra(EXTRA_SHOW_PREMIUM, showPremium);
        intent.putExtra(EXTRA_SHOW_DEBUGGER, showDebugger);
        if (requestCode == 0) {
            parent.startActivity(intent);
        } else {
            parent.startActivityForResult(intent, requestCode);
        }
    }
}
