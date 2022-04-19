package com.rrpvm.testauth.controllers;

import com.rrpvm.testauth.Model.UserAuthorizationData;
import com.rrpvm.testauth.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup")
@CrossOrigin("http://localhost:8080")
public class RegistrationPageController {
    @Autowired
    private UserDaoImpl userDaoImpl;

    @PostMapping("")
    public int doSignUp(@RequestBody UserAuthorizationData new_user_data){
        int queryResult = -1;//1 == success
        try{
            queryResult =  userDaoImpl.addUserToDataBase(new_user_data);
        }
        catch (org.springframework.dao.DuplicateKeyException e){
            return exceptionList.DUPLICATE.value;
        }
        catch (Exception e){
            System.out.println("another exception");
        }
        return queryResult;
    }
    private enum exceptionList{
        DUPLICATE(101);
        private int value;
        exceptionList(int value){
            this.value = value;
        }
        public int getValue(){
            return this.value;
        }
    }

}
