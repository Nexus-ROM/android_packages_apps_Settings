package com.android.settings.nexuslab;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;

import androidx.preference.Preference;
import androidx.preference.SwitchPreference;

import com.android.settings.R;
import com.android.settings.dashboard.DashboardFragment;
import com.android.settings.search.BaseSearchIndexProvider;
import com.android.settingslib.search.SearchIndexable;

@SearchIndexable
public class NexusLab extends DashboardFragment implements
        Preference.OnPreferenceChangeListener {

    private static final String TAG = "NexusLab";
    private static final String KEY_PIXEL_SPOOF = "pixel_spoof";

    private SwitchPreference mPixelSpoof;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        mPixelSpoof = (SwitchPreference) findPreference(KEY_PIXEL_SPOOF);
        if (mPixelSpoof != null) {
            mPixelSpoof.setChecked(Settings.System.getInt(getContentResolver(),
                    Settings.System.PIXEL_SPOOF_PHOTOS, 0) == 1);
            mPixelSpoof.setOnPreferenceChangeListener(this);
        }
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        if (preference == mPixelSpoof) {
            boolean value = (Boolean) newValue;
            Settings.System.putInt(getContentResolver(),
                    Settings.System.PIXEL_SPOOF_PHOTOS, value ? 1 : 0);
            return true;
        }
        return false;
    }

    @Override
    public int getMetricsCategory() {
        return -1;
    }

    @Override
    protected int getPreferenceScreenResId() {
        return R.xml.nexus_lab;
    }

    @Override
    protected String getLogTag() {
        return TAG;
    }

    public static final BaseSearchIndexProvider SEARCH_INDEX_DATA_PROVIDER =
            new BaseSearchIndexProvider(R.xml.nexus_lab);
}
