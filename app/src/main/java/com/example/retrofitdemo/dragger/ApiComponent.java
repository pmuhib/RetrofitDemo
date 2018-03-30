package com.example.retrofitdemo.dragger;


import com.example.retrofitdemo.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by user on 3/27/2018.
 */
@Singleton
@Component(modules = {ApisModule.class})
public interface ApiComponent {
    void inject(MainActivity mainActivity);
}
