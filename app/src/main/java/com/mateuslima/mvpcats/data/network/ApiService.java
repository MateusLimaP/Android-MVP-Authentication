package com.mateuslima.mvpcats.data.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static CatService instance;

    public static CatService getInstance(){
        if (instance == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.thecatapi.com/v1/images/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            instance = retrofit.create(CatService.class);
        }
        return instance;
    }
}
