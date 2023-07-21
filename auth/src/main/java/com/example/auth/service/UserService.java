package com.example.auth.service;

import com.example.auth.entity.User;

import java.util.Optional;

public interface UserService {
    Integer saveUser(User user);
    Optional<User> findByUsername(String username);
}
