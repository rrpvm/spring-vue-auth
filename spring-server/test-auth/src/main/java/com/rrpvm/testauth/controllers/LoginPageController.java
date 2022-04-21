package com.rrpvm.testauth.controllers;

import com.rrpvm.testauth.Model.JwtTokenRequest;
import com.rrpvm.testauth.Model.UserAuthorizationData;
import com.rrpvm.testauth.dao.UserDaoImpl;
import com.rrpvm.testauth.utilities.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS;

@RestController
@CrossOrigin(origins = "http://localhost:8080/")
@RequestMapping("/signin")
public class LoginPageController {
    private UserDaoImpl userDaoImpl;
    @Autowired
    private JwtTokenUtil jwtUtil;

    @PostMapping("")
    public HttpEntity<String> doAuthorization(@RequestBody UserAuthorizationData data) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        for (UserAuthorizationData user_data : userDaoImpl.getAuthDataList()) {
            if (user_data.getLogin().equals(data.getLogin()) && user_data.getPassword().equals(data.getPassword())) {
                headers.add(ACCESS_CONTROL_EXPOSE_HEADERS," jwt");
                headers.add("jwt",jwtUtil.generateToken(user_data));
                return new HttpEntity<>("success", headers);
            }
        }
        return new HttpEntity<>("fail", headers);
    }
    @RequestMapping("/forget")
    public String restorePass() {
        return new String("builder");
    }

    @PostMapping("/authenticate")
    @CrossOrigin(origins = "http://localhost:8080/signin")
    @ResponseStatus(HttpStatus.OK)
    public void authenticateUserByToken(@RequestBody JwtTokenRequest request) {

        List<UserAuthorizationData> data = userDaoImpl.getAuthDataList();
        for (UserAuthorizationData user : data) {
            if (user.getLogin().equals(request.getUsername()))
                if (jwtUtil.validateToken(request.getToken(), user)) {
                    return;
                }
        }
        onAuthorizationFailed();
    }
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    private void onAuthorizationFailed(){
        System.out.println("failed");
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
