package com.rrpvm.testauth.controllers;

import com.rrpvm.testauth.Model.UserAuthorizationData;
import com.rrpvm.testauth.dao.UserDaoImpl;
import com.rrpvm.testauth.utilities.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080/")
@RequestMapping("/login")
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
    public boolean authenticateUserByToken(@RequestBody String jwtToken,@RequestBody UserAuthorizationData userData){
        return jwtUtil.validateToken(jwtToken,userData);
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
