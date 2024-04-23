package com.tanjil.mywork.Utils

import android.Manifest
import android.content.Context


 class PermissionManager(val context: Context) {

    val required = arrayOf(
        Manifest.permission.READ_MEDIA_IMAGES,
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION)



}