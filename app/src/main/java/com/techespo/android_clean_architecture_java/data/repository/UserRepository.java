package com.techespo.android_clean_architecture_java.data.repository;

import android.support.annotation.NonNull;

import com.techespo.android_clean_architecture_java.data.repository.datasource.DataSource;
import com.techespo.android_clean_architecture_java.data.repository.datasource.UserDataSourceFactory;
import com.techespo.android_clean_architecture_java.data.repository.datasource.mapper.UserToUserEntityMapper;
import com.techespo.android_clean_architecture_java.domain.model.User;

import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton public class UserRepository implements Repository {
    private final UserToUserEntityMapper userToUserEntityMapper;
    private final DataSource dataSource;

    public UserRepository(@NonNull UserDataSourceFactory userDataSourceFactory,
                          @NonNull UserToUserEntityMapper userToUserEntityMapper) {
        this.userToUserEntityMapper = userToUserEntityMapper;
        this.dataSource = userDataSourceFactory.createDataSource();
    }

    @Override
    public Observable<User> user(String id) {
        return dataSource.userEntity(id).map(userToUserEntityMapper::reverseMap);
    }
}
