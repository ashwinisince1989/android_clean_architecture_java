package com.techespo.android_clean_architecture_java.view.presenter;

import android.support.annotation.NonNull;

import com.techespo.android_clean_architecture_java.domain.model.User;
import com.techespo.android_clean_architecture_java.domain.usecase.GetUser;
import com.techespo.android_clean_architecture_java.view.viewmodel.UserViewModel;
import com.techespo.android_clean_architecture_java.view.viewmodel.mapper.UserViewModelToUserMapper;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

public class UserPresenter extends Presenter<UserPresenter.View> {

    private final GetUser getUser;
    private final UserViewModelToUserMapper mapper;
    private String userId;

    @Inject
    public UserPresenter(@NonNull GetUser getUserById,
                               @NonNull UserViewModelToUserMapper mapper) {
        this.getUser = getUserById;
        this.mapper = mapper;
    }

    @SuppressWarnings("unchecked") @Override public void initialize() {
        super.initialize();
        getView().showLoading();
        getUser.searchUserById(userId);
        getUser.execute(new DisposableObserver<User>() {
            @Override public void onComplete() {
                getView().hideLoading();
            }

            @Override public void onError(Throwable e) {
                getView().hideLoading();
            }

            @Override public void onNext(User user) {
                UserViewModel userViewModel = mapper.reverseMap(user);
                getView().showUser(userViewModel);
            }
        });
    }


    public void destroy() {
        this.getUser.dispose();
        setView(null);
    }

    public interface View extends Presenter.View {
        void showUser(UserViewModel userViewModel);
    }
}
