package com.techespo.android_clean_architecture_java.view.presenter;

import android.support.annotation.NonNull;

import com.techespo.android_clean_architecture_java.domain.usecase.GetUser;
import com.techespo.android_clean_architecture_java.view.viewmodel.UserProfileViewModel;

import javax.inject.Inject;

public class UserPresenter extends Presenter<UserPresenter.View> {

    private final GetUser getUser;
    //private final UserViewModelToUserMapper mapper;
    private String userId;

    @Inject
    public UserPresenter(@NonNull GetUser getUserById) {
        this.getUser = getUserById;
    }

    @SuppressWarnings("unchecked") @Override public void initialize() {
        super.initialize();
        getView().showLoading();
       /* getUser.searchUserById(userId);
        getUser.execute(new DisposableObserver<UserSearchResult>() {
            @Override public void onComplete() {
                getView().hideLoading();
            }

            @Override public void onError(Throwable e) {
                getView().hideLoading();
            }

            @Override public void onNext(UserSearchResult user) {
                UserProfileViewModel userProfileViewModel = mapper.reverseMap(user);
                getView().showUser(userProfileViewModel);
            }
        });*/
    }


    public void destroy() {
        //this.getUser.dispose();
        setView(null);
    }

    public interface View extends Presenter.View {
        void showUser(UserProfileViewModel userProfileViewModel);
    }
}
