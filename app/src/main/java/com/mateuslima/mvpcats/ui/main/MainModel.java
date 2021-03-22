package com.mateuslima.mvpcats.ui.main;


import com.mateuslima.mvpcats.data.network.ApiService;
import com.mateuslima.mvpcats.data.network.result.CatResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainModel implements MainContract.Model {

    @Override
    public void retrieveRadomCats(final RetrieveRadomCats retrieveRadomCats, int qty) {
        ApiService.getInstance().radomCats(qty).enqueue(new Callback<List<CatResult>>() {
            @Override
            public void onResponse(Call<List<CatResult>> call, Response<List<CatResult>> response) {
                if (response.isSuccessful()){
                    retrieveRadomCats.catsSuccess(response.body());
                }else{
                    retrieveRadomCats.catsError(String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<CatResult>> call, Throwable t) {
                retrieveRadomCats.catsError(t.toString());
            }
        });
    }
}
