package com.techespo.android_clean_architecture_java.data.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.techespo.android_clean_architecture_java.data.net.ApiServices;
import com.techespo.android_clean_architecture_java.domain.model.UserSearchResult;

import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton public class UserRepository implements Repository {

    /***********Android Architecture Component*********/
    private final ApiServices apiServices;

    public UserRepository(ApiServices apiServices) {
        this.apiServices = apiServices;
    }

    @Override
    public LiveData<UserSearchResult> user(String userId){

        final MutableLiveData<UserSearchResult> liveData = new MutableLiveData<>();
        apiServices.getUser(userId).enqueue(new Callback<UserSearchResult>() {
            @Override
            public void onResponse(Call<UserSearchResult> call, Response<UserSearchResult> response) {
                if(response.isSuccessful()){
                    liveData.setValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<UserSearchResult> call, Throwable t) {

            }
        });

        return liveData;
    }
}
