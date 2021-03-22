package com.mateuslima.mvpcats.data.network;

import com.mateuslima.mvpcats.data.network.result.CatResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CatService {

    @GET("search")
    Call<List<CatResult>> radomCats(@Query("limit") int limit);
}
