package com.androidlearn.digishop.config

import androidx.multidex.MultiDexApplication
import com.androidlearn.digishop.di.DaggerUserComponent
import com.androidlearn.digishop.di.UserComponent
import com.androidlearn.digishop.di.UserModule
import com.google.android.gms.ads.MobileAds

class AppConfig : MultiDexApplication() {


    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this)
    }


    fun getComponent(): UserComponent? {
        return DaggerUserComponent.builder()
            .userModule(UserModule()).build()
    }

}