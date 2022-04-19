package com.rrpvm.testauth.controllers;

import com.rrpvm.testauth.Model.UserAuthorizationData;
import com.rrpvm.testauth.dao.UserDaoImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080/")
@RequestMapping("/login")
public class LoginPageController {
    private UserDaoImpl userDaoImpl;

    @PostMapping("")
    public String doAuthorization(@RequestBody UserAuthorizationData data){
        for(UserAuthorizationData user_data : userDaoImpl.getAuthDataList()){
           if(user_data.getLogin().equals(data.getLogin()) && user_data.getPassword().equals(data.getPassword())){
               return "success";
           }
        }
        return "fail";
    }
    @RequestMapping("/forget")
    public String restorePass(){
        return new String("builder");
    }
    public UserDaoImpl getDao() {
        return userDaoImpl;
    }

    public void setDao(UserDaoImpl dao) {
        this.userDaoImpl = dao;
    }

    public LoginPageController(UserDaoImpl dao) {
        this.userDaoImpl = dao;
    }
}
