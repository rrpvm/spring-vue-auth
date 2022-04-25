package com.rrpvm.testauth.Model;

public class UserPublicData {
    private String username;

    public UserPublicData() {
    }

    public UserPublicData(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
