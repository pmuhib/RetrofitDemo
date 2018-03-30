package com.example.retrofitdemo.dragger;

import com.example.retrofitdemo.retrofit.RetrofitApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by user on 3/28/2018.
 */
@Module
public class MyModule {
    @Provides
    public RetrofitApi retrofitApi(Retrofit retrofit)
    {
        return retrofit.create(RetrofitApi.class);
    }
}
