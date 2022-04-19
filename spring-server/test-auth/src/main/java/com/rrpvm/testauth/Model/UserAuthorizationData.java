package com.rrpvm.testauth.Model;


import com.rrpvm.testauth.entities.User;

public class UserAuthorizationData {
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserAuthorizationData(String login, String password) {
        this.login = login;
        this.password = password;
    }
    public UserAuthorizationData(User user){
        this.login = user.getLogin();
        this.password = user.getPassword();
    }
}
