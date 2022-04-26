package com.rrpvm.testauth.controllers;

import com.rrpvm.testauth.Model.UserPublicData;
import com.rrpvm.testauth.dao.UserDaoImpl;
import com.rrpvm.testauth.exceptions.NotUserFound;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/profile")
public class ProfilePageController {
    private UserDaoImpl userDaoImpl;

    @RequestMapping(value = "/{id}", method = GET)
    @ResponseBody
    public UserPublicData getProfileData(@PathVariable int id) {
        UserPublicData rData = null;
        try {
            rData = new UserPublicData(userDaoImpl.getUserById(id));
        } catch (NotUserFound nuf) {
            System.out.println("idi naxuy");
        }
        return rData;
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
