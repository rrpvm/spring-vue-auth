package com.rrpvm.testauth.controllers;

import com.rrpvm.testauth.Model.UserPublicData;
import com.rrpvm.testauth.dao.UserDaoImpl;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/profile")
public class ProfilePageController {
    private UserDaoImpl userDaoImpl;
    @RequestMapping(value = "/{id}", method = GET)
    @ResponseBody
    public UserPublicData getProfileData(@PathVariable int id){
    return new UserPublicData(userDaoImpl.getUserById(id));
    }

    public UserDaoImpl getUserDaoImpl() {
        return userDaoImpl;
    }

    public void setUserDaoImpl(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    public ProfilePageController(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }
}
