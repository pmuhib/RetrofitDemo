package com.example.retrofitdemo.dragger;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 3/27/2018.
 */
@Module
public class ApisModule {
    String mBaseUrl;

    public ApisModule(String mBaseUrl) {
        this.mBaseUrl = mBaseUrl;
    }
    @Provides
    @Singleton
    Gson providegson()
    {
        GsonBuilder gsonBuilder=new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkhttpClient()
    {
        return  new OkHttpClient().newBuilder().build();
    }
    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson,OkHttpClient okHttpClient)
    {
        Retrofit retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .build();
        return retrofit;
    }
}
