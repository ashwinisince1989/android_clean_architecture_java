package com.techespo.android_clean_architecture_java.data.repository.datasource;

import android.content.Context;
import android.support.annotation.NonNull;

import com.techespo.android_clean_architecture_java.data.local.LocalImpl;
import com.techespo.android_clean_architecture_java.data.repository.datasource.mapper.UserEntityJsonMapper;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton public class UserDataSourceFactory { private final Context context;

    @Inject
    public UserDataSourceFactory(@NonNull Context context) {
        this.context = context;
    }

    public DataSource createDataSource() {
        UserEntityJsonMapper teamEntityJsonMapper = new UserEntityJsonMapper();
        LocalImpl local = new LocalImpl(context, teamEntityJsonMapper);
        return new UserLocalApiDataSource(local);
    }
}

