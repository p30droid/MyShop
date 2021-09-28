package com.androidlearn.digishop.config

import android.content.Context
import androidx.multidex.MultiDexApplication
import com.androidlearn.digishop.di.DaggerUserComponent
import com.androidlearn.digishop.di.UserComponent
import com.androidlearn.digishop.di.UserModule
import com.google.android.gms.ads.MobileAds

class AppConfig : MultiDexApplication() {


    var instance: AppConfig? = null


    @JvmName("getInstance1")
    fun getInstance(): AppConfig? {
        return instance
    }

    fun getContext(): Context? {
        return instance
    }


    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this)
        instance = this
    }


    fun getComponent(): UserComponent? {
        return DaggerUserComponent.builder()
            .userModule(UserModule()).build()
    }

}