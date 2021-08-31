package com.androidlearn.digishop.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    val retrofit : Retrofit =
        Retrofit.Builder()
            .baseUrl("https://androidsupport.ir/pack/digiAndroid/")
            .addConverterFactory(GsonConverterFactory.create()).build()

}