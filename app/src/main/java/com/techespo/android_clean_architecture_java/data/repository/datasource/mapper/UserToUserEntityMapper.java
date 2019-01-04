package com.techespo.android_clean_architecture_java.data.repository.datasource.mapper;

import com.techespo.android_clean_architecture_java.data.entity.UserEntity;
import com.techespo.android_clean_architecture_java.domain.model.User;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton public class UserToUserEntityMapper extends  Mapper<User,UserEntity>{
    @Inject
    public UserToUserEntityMapper() {
    }

    @Override
    public UserEntity map(User value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public User reverseMap(UserEntity value) {
        User user = new User();
        user.setAddress(value.getAddress());
        user.setName(value.getName());
        user.setId(value.getId());
        user.setMobile(value.getPhone());
        user.setEmail(value.getEmail());

        return user;
    }
}
