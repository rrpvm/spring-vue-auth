package com.rrpvm.testauth.controllers;

import com.rrpvm.testauth.Model.UserAuthorizationData;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080/")
@RequestMapping("/login")
public class LoginPageController {

    @PostMapping("")
    public String doAuthorization(@RequestBody UserAuthorizationData data){
        System.out.println(data.getLogin());
        return "hello from server";
    }
}
