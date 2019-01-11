package com.techespo.android_clean_architecture_java.data.net;

import com.techespo.android_clean_architecture_java.domain.model.UserSearchResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiServices {
    /**
     * @GET declares an HTTP GET request
     * @Path("user") annotation on the userId parameter marks it as a
     * replacement for the {user} placeholder in the @GET path
     */
    @GET("/users/{user}")
    Call <UserSearchResult> getUser(@Path("user") String userId);
}
