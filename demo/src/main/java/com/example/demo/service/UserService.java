package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);

    List<User> findAllUsers();

    Optional<User> findUserById(String id);

    User updateUser(User user, String id);

    void deleteUser(String id);
}
