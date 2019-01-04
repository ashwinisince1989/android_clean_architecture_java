package com.techespo.android_clean_architecture_java;

import android.app.Application;

import com.techespo.android_clean_architecture_java.di.components.DaggerMainComponent;
import com.techespo.android_clean_architecture_java.di.components.MainComponent;
import com.techespo.android_clean_architecture_java.di.modules.MainModule;

public class App extends Application{

    private MainComponent mainComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector(){
        mainComponent = DaggerMainComponent.builder().mainModule(new MainModule(this)).build();
    }
    public MainComponent getMainComponent() {
        return mainComponent;
    }
}
