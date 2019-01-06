package com.techespo.android_clean_architecture_java.data.repository.datasource.mapper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.techespo.android_clean_architecture_java.data.entity.UserEntity;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

public class UserEntityJsonMapper {

    private final Gson gson;

    @Inject
    public UserEntityJsonMapper() {
        gson = new Gson();
    }

    public UserEntity transformTeamEntity(String teamJsonResponse) throws JsonSyntaxException {
        UserEntity teamEntity;
        try {
            Type typeTeamEntity = new TypeToken<UserEntity>() {
            }.getType();
            teamEntity = this.gson.fromJson(teamJsonResponse, typeTeamEntity);
            return teamEntity;
        } catch (JsonSyntaxException exception) {
            exception.printStackTrace();
            throw exception;
        }
    }

    public List<UserEntity> transformTeamEntityCollection(String teamListJsonResponse)
            throws JsonSyntaxException {
        List<UserEntity> teamEntityList;
        try {
            Type typeTeamEntityList = new TypeToken<List<UserEntity>>() {
            }.getType();
            teamEntityList = this.gson.fromJson(teamListJsonResponse, typeTeamEntityList);
            return teamEntityList;
        } catch (JsonSyntaxException exception) {
            exception.printStackTrace();
            throw exception;
        }
    }
}
