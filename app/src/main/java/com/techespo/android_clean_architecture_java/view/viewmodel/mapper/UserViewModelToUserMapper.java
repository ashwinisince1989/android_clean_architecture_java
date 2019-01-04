package com.techespo.android_clean_architecture_java.view.viewmodel.mapper;

import com.techespo.android_clean_architecture_java.data.repository.datasource.mapper.Mapper;
import com.techespo.android_clean_architecture_java.domain.model.User;
import com.techespo.android_clean_architecture_java.view.viewmodel.UserViewModel;

import javax.inject.Inject;

public class UserViewModelToUserMapper extends Mapper<UserViewModel, User> {

    @Inject
    UserViewModelToUserMapper() {
    }

    @Override public User map(UserViewModel value) {
        throw new UnsupportedOperationException();
    }

    @Override public UserViewModel reverseMap(User value) {
        UserViewModel userViewModel = new UserViewModel();
        userViewModel.setAddress(value.getAddress());
        userViewModel.setName(value.getName());
        userViewModel.setEmail(value.getEmail());
        userViewModel.setMobile(value.getMobile());
        userViewModel.setId(value.getId());
        return userViewModel;
    }
}