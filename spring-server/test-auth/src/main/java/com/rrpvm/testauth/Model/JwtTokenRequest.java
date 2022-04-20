package com.rrpvm.testauth.Model;

public class JwtTokenRequest {
    private String token;
    private String username;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public JwtTokenRequest() {
    }

    public JwtTokenRequest(String token, String username) {
        this.token = token;
        this.username = username;
    }
}
