package com.techespo.android_clean_architecture_java.domain.model;

public class UserSearchResult {
    private final Exception exception;
    private final User user;

    public UserSearchResult(Exception exception) {
        this.exception = exception;
        this.user = null;
    }

    public UserSearchResult(User user){
        this.user = user;
        this.exception = null;
    }

    public Exception getException() {
        return exception;
    }

    public User getUser() {
        return user;
    }

    public boolean success(){
        return user != null;
    }

}
