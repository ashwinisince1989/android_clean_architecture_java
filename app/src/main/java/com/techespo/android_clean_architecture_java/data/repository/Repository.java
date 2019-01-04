package com.techespo.android_clean_architecture_java.data.repository;

import com.techespo.android_clean_architecture_java.domain.model.User;

import io.reactivex.Observable;

public interface Repository {

    Observable<User> user(final String id);
}
