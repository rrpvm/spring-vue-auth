package com.rrpvm.testauth.dao;

import com.rrpvm.testauth.Model.UserAuthorizationData;
import com.rrpvm.testauth.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("userDaoImpl")
public class UserDaoImpl {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public User getUserById(Integer id){
        return userRepository.findById(id).get();
    }
    public List<UserAuthorizationData>getAuthDataList(){
        List<UserAuthorizationData> data = new ArrayList<UserAuthorizationData>();
        userRepository.findAll().forEach(usr -> data.add(new UserAuthorizationData(usr)));
        return data;
    }
    public int addUserToDataBase(UserAuthorizationData data){
        String query = "INSERT INTO users(login,password) VALUES (?,?)";
        int result =  jdbcTemplate.update(query,data.getLogin(),data.getPassword());
        return result;
    }
}
