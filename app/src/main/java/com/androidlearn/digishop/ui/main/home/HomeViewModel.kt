package com.androidlearn.digishop.ui.main.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


import com.androidlearn.digishop.models.BaseModel
import com.androidlearn.digishop.network.ApiClient
import com.androidlearn.digishop.network.ApiClient.retrofit
import com.androidlearn.digishop.network.IService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeViewModel : ViewModel(){


    lateinit var mutable : MutableLiveData<BaseModel>


    fun getHome() : MutableLiveData<BaseModel> {

        mutable = MutableLiveData<BaseModel>()

        homeWebservice()


        return  mutable
    }

    fun homeWebservice() {

        val iService = retrofit.create(IService::class.java)

        iService.home().subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( object : io.reactivex.rxjava3.core.Observer<BaseModel> {
                override fun onSubscribe(d: Disposable?) {

                }

                override fun onNext(t: BaseModel?) {
                    mutable.value = t
                }

                override fun onError(e: Throwable?) {

                    mutable.value = null
                }

                override fun onComplete() {

                }


            })



    }





}