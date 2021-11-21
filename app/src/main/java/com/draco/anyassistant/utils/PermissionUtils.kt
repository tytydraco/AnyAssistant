package com.draco.anyassistant.utils

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

class PermissionUtils {
    companion object {
        /**
         * Return true if the permission is granted, false otherwise
         */
        fun isPermissionsGranted(context: Context, permission: String): Boolean =
            ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
    }
}