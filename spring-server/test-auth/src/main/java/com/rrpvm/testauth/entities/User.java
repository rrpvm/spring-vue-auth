package com.rrpvm.testauth.entities;

import javax.persistence.*;

@Entity
@Table(name = "users", schema="public")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name="login")
    private String login;
    @Column(name="password")
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public User(Integer id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }
    public User(){};
}
