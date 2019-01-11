package com.techespo.android_clean_architecture_java.data.net;

public final class ApiConstants {
    public static final String BASE_URL = "http://gateway.marvel.com";
    public static final String ENDPOINT = BASE_URL + "/v1/public/";
    public static final String QUERY_PARAM_TS = "ts";
    public static final String QUERY_PARAM_API_KEY = "apikey";
    public static final String QUERY_PARAM_HASH = "hash";

    private ApiConstants() {
    }
}
