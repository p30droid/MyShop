package com.androidlearn.digishop.config

import androidx.multidex.MultiDexApplication
import com.google.android.gms.ads.MobileAds

class AppConfig : MultiDexApplication() {


    override fun onCreate() {
        super.onCreate()

        MobileAds.initialize(this)

    }

}