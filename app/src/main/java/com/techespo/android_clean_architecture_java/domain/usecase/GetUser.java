package com.techespo.android_clean_architecture_java.domain.usecase;

import com.techespo.android_clean_architecture_java.data.repository.Repository;
import com.techespo.android_clean_architecture_java.domain.model.User;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

public class GetUser extends UseCase<User> {

    private final Repository repository;
    private String id = "";

    @Inject
    public GetUser(@Named("executor_thread") Scheduler executorThread,
                             @Named("ui_thread") Scheduler uiThread, Repository repository) {
        super(executorThread, uiThread);
        this.repository = repository;
    }

    public void searchUserById(String id) {
        this.id = id;
    }

    @Override public Observable<User> createObservableUseCase() {
        return this.repository.user(id);
    }
}
