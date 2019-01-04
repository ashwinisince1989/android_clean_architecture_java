/*
 * Copyright (C) 2016 Erik Jhordan Rey.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.techespo.android_clean_architecture_java.data.local;

import android.content.Context;
import android.support.annotation.NonNull;

import com.techespo.android_clean_architecture_java.data.entity.UserEntity;
import com.techespo.android_clean_architecture_java.data.repository.datasource.mapper.UserEntityJsonMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import io.reactivex.Observable;

public class LocalImpl implements LocalApi {

  private final Context context;
  private final UserEntityJsonMapper teamEntityJsonMapper;

  public LocalImpl(@NonNull Context context, @NonNull UserEntityJsonMapper teamEntityJsonMapper) {
    this.context = context;
    this.teamEntityJsonMapper = teamEntityJsonMapper;
  }


  private String getResponseFromLocalJson() {
    final String EURO_DATA_FILE = "euro_data.json";
    String str = "";
    try {
      StringBuilder builder = new StringBuilder();
      InputStream json = context.getAssets().open(EURO_DATA_FILE);
      BufferedReader in = new BufferedReader(new InputStreamReader(json));

      while ((str = in.readLine()) != null) {
        builder.append(str);
      }
      in.close();
      str = builder.toString();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return str;
  }

  @Override
  public Observable<UserEntity> userEntity(String id) {
    return null;
  }
}
