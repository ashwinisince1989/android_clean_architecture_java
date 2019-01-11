package com.techespo.android_clean_architecture_java.data.repository;

import android.arch.lifecycle.LiveData;

import com.techespo.android_clean_architecture_java.domain.model.UserSearchResult;

public interface Repository {

    LiveData<UserSearchResult> user(final String id);
}
