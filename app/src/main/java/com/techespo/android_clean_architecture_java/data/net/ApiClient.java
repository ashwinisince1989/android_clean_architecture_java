package com.techespo.android_clean_architecture_java.data.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Eno8 on 1/17/2018.
 */

public class ApiClient {

    private static Retrofit retrofitClient = null;

    public static Retrofit getCollinClient() {
        if (retrofitClient == null) {
            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(Boolean.class, new BooleanTypeAdapter());
            builder.registerTypeAdapter(boolean.class, new BooleanTypeAdapter());
            Gson gson = builder.create();
            retrofitClient = new Retrofit.Builder()
                    .baseUrl(ApiConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))

                    .build();
        }
        return retrofitClient;
    }
}
