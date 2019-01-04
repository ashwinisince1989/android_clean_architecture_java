package com.techespo.android_clean_architecture_java.data.entity;

import com.google.gson.annotations.SerializedName;

public class UserEntity {
    @SerializedName("name") private String name;
    @SerializedName("id") private int id;
    @SerializedName("address") private String address;
    @SerializedName("email") private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @SerializedName("phone") private String phone;
}
