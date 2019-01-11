package com.techespo.android_clean_architecture_java.view.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.techespo.android_clean_architecture_java.data.repository.Repository;
import com.techespo.android_clean_architecture_java.data.repository.UserRepository;
import com.techespo.android_clean_architecture_java.domain.model.UserSearchResult;

import javax.inject.Inject;

public class UserProfileViewModel extends AndroidViewModel{
    @Inject
    Repository repository;

    @Inject
    UserRepository userRepository;

    public UserProfileViewModel(@NonNull Application application) {
        super(application);
    }
    private final MutableLiveData<UserSearchResult> userLiveData = new MutableLiveData<>();

    public LiveData<UserSearchResult> getUserLiveData() {
        return userLiveData;
    }

    public void userProfileData(@Nullable final String userID) {
        if (userID != null) {
            //userLiveData will be notified when the user is fetched
            final LiveData<UserSearchResult> userLiveDataNetwork = userRepository.user(userID);
            // TODO
            userLiveData.observe((LifecycleOwner) userLiveDataNetwork, new Observer<UserSearchResult>() {
                @Override
                public void onChanged(@Nullable UserSearchResult userSearchResult) {
                    userLiveData.postValue(userSearchResult);
                    System.out.print("This is dummy test data:"+userSearchResult.getUser().getName());
                }
            });
        }
    }

}
