package com.android.settings.deviceinfo.firmwareversion;

import android.content.Context;
import android.text.TextUtils;

import androidx.preference.Preference;

import com.android.settings.R;
import com.android.settings.core.BasePreferenceController;

public class NexusMaintainerPreferenceController extends BasePreferenceController {

    private static final String TAG = "NexusMaintainerCtrl";

    public NexusMaintainerPreferenceController(Context context, String key) {
        super(context, key);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public CharSequence getSummary() {
        String maintainer = mContext.getResources().getString(R.string.nexus_maintainer);
        
        if (TextUtils.isEmpty(maintainer) || maintainer.equals("Unknown")) {
            return "Unknown";
        }
        
        return maintainer;
    }
}
