package com.vesalukkarila.service;

import com.vesalukkarila.model.User;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserService {
    //atm faking to always to find a user from database
    public User findById(String id){
        String randomName = UUID.randomUUID().toString();
        return new User(id, randomName);
    }
}
