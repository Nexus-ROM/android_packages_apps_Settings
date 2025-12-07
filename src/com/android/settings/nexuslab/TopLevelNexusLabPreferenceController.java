package com.android.settings.nexuslab;

import android.content.Context;

import com.android.settings.core.BasePreferenceController;

public class TopLevelNexusLabPreferenceController extends BasePreferenceController {

    public TopLevelNexusLabPreferenceController(Context context, String preferenceKey) {
        super(context, preferenceKey);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }
}
