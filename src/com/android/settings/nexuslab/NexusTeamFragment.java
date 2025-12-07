package com.android.settings.nexuslab;

import android.os.Bundle;
import com.android.settings.R;
import com.android.settings.dashboard.DashboardFragment;
import com.android.settings.search.BaseSearchIndexProvider;
import com.android.settingslib.search.SearchIndexable;

@SearchIndexable
public class NexusTeamFragment extends DashboardFragment {

    private static final String TAG = "NexusTeamFragment";

    @Override
    public int getMetricsCategory() {
        return -1;
    }

    @Override
    protected int getPreferenceScreenResId() {
        return R.xml.nexus_team;
    }

    @Override
    protected String getLogTag() {
        return TAG;
    }

    public static final BaseSearchIndexProvider SEARCH_INDEX_DATA_PROVIDER =
            new BaseSearchIndexProvider(R.xml.nexus_team);
}
