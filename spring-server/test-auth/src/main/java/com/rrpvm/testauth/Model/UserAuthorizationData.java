package com.rrpvm.testauth.Model;


import com.rrpvm.testauth.entities.User;

public class UserAuthorizationData {
    private String login;
    private String password;
    private int id;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserAuthorizationData(String login, String password,int id) {
        this.login = login;
        this.password = password;
        this.id = id;
    }
    public UserAuthorizationData(User user){
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.id = user.getId();
    }
}
