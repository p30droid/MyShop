package com.androidlearn.digishop.network

import com.androidlearn.digishop.models.BaseModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface IService {


    @GET("home.php")
    fun getHome() : Call<BaseModel>


    @FormUrlEncoded
    @POST("login.php")
    fun login(@Field("username") username : String , @Field("password") password : String ) : Call<ResponseBody>


}