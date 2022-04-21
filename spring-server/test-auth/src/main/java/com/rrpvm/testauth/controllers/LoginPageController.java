package com.rrpvm.testauth.controllers;

import com.rrpvm.testauth.Model.JwtTokenRequest;
import com.rrpvm.testauth.Model.UserAuthorizationData;
import com.rrpvm.testauth.dao.UserDaoImpl;
import com.rrpvm.testauth.utilities.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080/")
@RequestMapping("/signin")
public class LoginPageController {
    private UserDaoImpl userDaoImpl;
    @Autowired
    private JwtTokenUtil jwtUtil;
    @PostMapping("")
    public String doAuthorization(@RequestBody UserAuthorizationData data){
        for(UserAuthorizationData user_data : userDaoImpl.getAuthDataList()){
           if(user_data.getLogin().equals(data.getLogin()) && user_data.getPassword().equals(data.getPassword())){
               return jwtUtil.generateToken(user_data);
           }
        }
        return "";
    }
    @RequestMapping("/forget")
    public String restorePass(){
        return new String("builder");
    }
    @PostMapping("/authenticate")
    @CrossOrigin(origins = "http://localhost:8080/login")
    public boolean authenticateUserByToken(@RequestBody JwtTokenRequest request){

        List<UserAuthorizationData> data = userDaoImpl.getAuthDataList();
        for(UserAuthorizationData user : data) {
            if (user.getLogin().equals(request.getUsername())) return jwtUtil.validateToken(request.getToken(), user);
        }
        return false;
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
