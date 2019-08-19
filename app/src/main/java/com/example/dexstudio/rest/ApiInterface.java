package com.example.dexstudio.rest;

import com.example.dexstudio.model.UserDataResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("s/2iodh4vg0eortkl/facts")
    Call<UserDataResponse> getTopRatedMovies();

}
