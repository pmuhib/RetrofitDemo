package com.example.retrofitdemo;

import android.app.Application;


import com.example.retrofitdemo.dragger.ApiComponent;
import com.example.retrofitdemo.dragger.ApisModule;
import com.example.retrofitdemo.dragger.DaggerApiComponent;


/**
 * Created by user on 3/27/2018.
 */

public class MyApplication extends Application {
    private ApiComponent mApiComponent;
    public static MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApiComponent= DaggerApiComponent.builder().apisModule(new ApisModule( "https://api.androidhive.info/" )).build();
    }

    public static MyApplication application()
    {
        return myApplication;
    }
    public  ApiComponent apiComponent()
    {
        return  this.mApiComponent;
    }

}
