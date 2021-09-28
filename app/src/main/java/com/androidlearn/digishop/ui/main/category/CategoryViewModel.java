package com.androidlearn.digishop.ui.main.category;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.androidlearn.digishop.models.BaseModel;
import com.androidlearn.digishop.models.Category;
import com.androidlearn.digishop.models.Product;
import com.androidlearn.digishop.network.ApiClient;
import com.androidlearn.digishop.network.IService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function3;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryViewModel extends AndroidViewModel {


    MutableLiveData<List<Category>> categoryList;

    public CategoryViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<Category>> getCategory() {

        if(categoryList==null) {

            categoryList = new MutableLiveData<>();
            loadCategories();
        }

        return  categoryList;
    }

    public void loadCategories() {

        IService iService = ApiClient.INSTANCE.getRetrofit().create(IService.class);


        iService.getCategories().enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(Call<BaseModel> call, Response<BaseModel> response) {
                categoryList.setValue(response.body().getCategories());

            }

            @Override
            public void onFailure(Call<BaseModel> call, Throwable t) {
                categoryList.setValue(null);

            }
        });

        iService.categories().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseModel>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.rxjava3.annotations.NonNull BaseModel baseModel) {

                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


        Observable<BaseModel> observable1 = ApiClient.INSTANCE.getRetrofit().create(IService.class).home1();
        Observable<BaseModel> observable2 =  ApiClient.INSTANCE.getRetrofit().create(IService.class).home2();
        Observable<BaseModel> observable3 =  ApiClient.INSTANCE.getRetrofit().create(IService.class).home3();

        Observable<List<List<Product>>> result =
                Observable.zip(observable1.subscribeOn(Schedulers.io()), observable2.subscribeOn(Schedulers
                        .io()), observable3.subscribeOn(Schedulers.io()), new Function3<BaseModel, BaseModel, BaseModel,List<List<Product>>>() {
                    @Override
                    public List<List<Product>> apply(BaseModel type1, BaseModel type2, BaseModel type3) {
                        List<List<Product>> list = new ArrayList();
                        list.add(type1.getMakeup());
                        list.add(type1.getMobile());
                        list.add(type1.getMobile());
                        return list;
                    }
                });


        result.observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new Observer<List<List<Product>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("", "");
                    }

                    @Override
                    public void onNext(List<List<Product>> s) {
                        Log.d("", "s is the list with all the data");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("", e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("", "");
                    }
                });


    }





}
