package com.example.login.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.login.entity.User;
import com.example.login.repo.userRepo;

@Service
public class userservice {
    @Autowired
    private userRepo userRepo;
    public boolean Authenticate(String userName, String password) {
        User user = userRepo.findByUserName(userName);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

}
