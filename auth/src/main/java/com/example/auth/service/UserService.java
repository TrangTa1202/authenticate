package com.example.auth.service;

import com.example.auth.entity.User;

import java.util.List;

public interface UserService {
    User createUser (User user);
    List<User> loadUserByUsername(String username);
}
