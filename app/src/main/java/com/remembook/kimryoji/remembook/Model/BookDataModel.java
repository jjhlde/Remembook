package com.remembook.kimryoji.remembook.Model;

import com.remembook.kimryoji.remembook.Constans;
import com.remembook.kimryoji.remembook.Interface.DaumApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by KimRyoji on 2017-04-10.
 */

public class BookDataModel {

    private static BookDataModel instance;
    private BookDataModel(){};

    public static BookDataModel getInstance(){
        if(instance == null){
            instance = new BookDataModel();
        }
        return instance;
    }
    public DaumApiService getRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constans.getInstance().getAPI_URL())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DaumApiService service = retrofit.create(DaumApiService.class);
        return service;
    }

}

