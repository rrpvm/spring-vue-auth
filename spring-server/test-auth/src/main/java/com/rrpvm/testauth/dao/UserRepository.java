package com.rrpvm.testauth.dao;

import com.rrpvm.testauth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    
}
