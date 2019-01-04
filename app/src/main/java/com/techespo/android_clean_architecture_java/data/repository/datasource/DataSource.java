package com.techespo.android_clean_architecture_java.data.repository.datasource;

import com.techespo.android_clean_architecture_java.data.entity.UserEntity;

import io.reactivex.Observable;

public interface DataSource {
    Observable<UserEntity> userEntity(final String id);
}
