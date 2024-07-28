package com.example.login.repo;

import com.example.login.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepo extends JpaRepository<User,Long> {
    User findByUserName(String userName);
}
