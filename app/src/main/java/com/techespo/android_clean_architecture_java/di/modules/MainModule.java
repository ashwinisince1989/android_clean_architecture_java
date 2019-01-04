package com.techespo.android_clean_architecture_java.di.modules;

import android.content.Context;

import com.techespo.android_clean_architecture_java.App;
import com.techespo.android_clean_architecture_java.data.repository.Repository;
import com.techespo.android_clean_architecture_java.data.repository.UserRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module public class MainModule {
    private App app;

    public MainModule(App app){
        this.app = app;
    }

    @Provides @Singleton
    Context  provideApplicationContext(){
        return app;
    }

    @Provides @Singleton
    Repository provideRepository(UserRepository userRepository){
        return userRepository;
    }

}
