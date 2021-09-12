package com.androidlearn.digishop.ui.main.category;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.androidlearn.digishop.models.BaseModel;
import com.androidlearn.digishop.models.Category;
import com.androidlearn.digishop.network.ApiClient;
import com.androidlearn.digishop.network.IService;

import java.util.List;

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



    }





}
