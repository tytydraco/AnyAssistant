package com.draco.anyassistant.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import androidx.preference.PreferenceManager
import com.draco.anyassistant.R
import com.draco.anyassistant.repositories.constants.SettingsConstants

class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context)
            val component = sharedPrefs.getString(context.getString(R.string.pref_saved_component_key), null) ?: return

            Settings.Secure.putString(
                context.contentResolver,
                SettingsConstants.ASSISTANT,
                component
            )
        }
    }
}