package com.androidlearn.digishop.ui.login

import android.util.Log
import com.androidlearn.digishop.models.BaseModel
import com.androidlearn.digishop.network.ApiClient
import com.androidlearn.digishop.network.IService
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginInteractor() {

    var iService: IService

    init {
        iService = ApiClient.retrofit.create(IService::class.java)
    }


    fun getLogin(username: String, password: String , listener : ILoginView<String>) {

        if(username.isEmpty()){

            listener.onUsernameError()

            return
        }

        if(password.isEmpty()){

            listener.onPasswordError()

            return
        }

        iService.login(username, password).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                Log.e("","");
                listener.onSuccess(response.body()!!.string())
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.e("","");
                listener.onFailureError("Error")
            }


        })


    }


}