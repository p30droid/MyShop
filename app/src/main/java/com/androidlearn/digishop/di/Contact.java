package com.androidlearn.digishop.di;

import android.util.Log;

import java.util.HashMap;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Contact {

    String email;

    public Contact() {
        email = "";
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void clearEmail() {
        email = "";
    }

    public static void help() {

        HashMap<String, String> map =new HashMap<>();
        map.put("first" , "hello");
        map.put("second" , "hello");
        map.put("third" , "hello");

        for (String key : map.keySet()) {

            String value =  key.toString();

        }

        Observable.just("One","two","third","fourth")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.e("","");

                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        Log.e("","");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("","");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("","");
                    }
                });

    }
}
