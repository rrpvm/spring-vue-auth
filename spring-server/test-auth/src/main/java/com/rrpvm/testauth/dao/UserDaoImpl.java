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

    private List<User>cachedUserData;
    boolean dbChanged = true;//состояние,которое отражает измененность базы данных относительно уже сохраненной
    public User getUserById(Integer id){
        return userRepository.findById(id).get();
    }
    public List<UserAuthorizationData>getAuthDataList(){
        List<UserAuthorizationData> data = new ArrayList<UserAuthorizationData>();
        List<User>dbList = null;
        try{
            if(!dbChanged){
                dbList = cachedUserData;
            }
            else {
                dbList = preCacheUserData();
            }
            dbList.forEach(usr -> data.add(new UserAuthorizationData(usr)));
        }
        catch (NullPointerException exception){
        }
        return data;
    }
    public int addUserToDataBase(UserAuthorizationData data){
        String query = "INSERT INTO users(login,password) VALUES (?,?)";
        int result =  jdbcTemplate.update(query,data.getLogin(),data.getPassword());
        if(result > 0)dbChanged = true;
        return result;
    }
    private List<User> getCachedUserData() {
        return cachedUserData;
    }
    private List<User> preCacheUserData(){
        this.cachedUserData = userRepository.findAll();
        this.dbChanged = false;
        return this.cachedUserData;
    }
}
