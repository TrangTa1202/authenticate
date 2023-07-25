package com.example.crm.service.impl;

import com.example.crm.entity.User;
import com.example.crm.repository.UserRepository;
import com.example.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
