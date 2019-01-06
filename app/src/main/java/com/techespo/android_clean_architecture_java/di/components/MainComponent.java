package com.techespo.android_clean_architecture_java.di.components;

import android.content.Context;

import com.techespo.android_clean_architecture_java.di.modules.MainModule;
import com.techespo.android_clean_architecture_java.view.activity.HomeActivity;
import com.techespo.android_clean_architecture_java.view.activity.SplashActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton @Component(modules = MainModule.class)
public interface MainComponent {

    void inject(HomeActivity activity);

    //void inject(SplashActivity activity);

    Context context();
}
