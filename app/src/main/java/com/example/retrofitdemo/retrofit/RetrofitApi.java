package com.example.retrofitdemo.retrofit;

import com.example.retrofitdemo.model.Responses;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by user on 3/20/2018.
 */

public interface RetrofitApi {
    @FormUrlEncoded
    @POST("contacts")
    Call<Responses> contacts(@Field("")String s);
}
