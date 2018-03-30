package com.example.retrofitdemo.retrofit;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 3/20/2018.
 */

public class RetrofitApiBuilder {
    public static RetrofitApi getBuilder()
    {
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .connectTimeout(10000, TimeUnit.SECONDS)
                .writeTimeout(10000,TimeUnit.SECONDS)
                .connectTimeout(10000,TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request=chain.request().newBuilder()
                                .addHeader("content-type","application/x-www-form-urlencoded")
                                .build();
                        return chain.proceed(request);
                    }
                }).build();
        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://api.androidhive.info/").addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient).build();
        return retrofit.create(RetrofitApi.class);
    }
}
