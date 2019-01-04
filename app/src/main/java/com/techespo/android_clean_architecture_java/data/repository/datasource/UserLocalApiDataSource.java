package com.techespo.android_clean_architecture_java.data.repository.datasource;

import com.techespo.android_clean_architecture_java.data.entity.UserEntity;
import com.techespo.android_clean_architecture_java.data.local.LocalApi;

import java.util.List;

import io.reactivex.Observable;

public class UserLocalApiDataSource implements DataSource {
    private final LocalApi localApi;

    public UserLocalApiDataSource(LocalApi localApi) {
        this.localApi = localApi;
    }

    @Override public Observable<UserEntity> userEntity(String id) {
        return this.localApi.userEntity(id);
    }
}
