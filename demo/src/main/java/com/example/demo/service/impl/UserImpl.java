package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User userCreated) {
//        User userCreated = new User(
//                user.getFirstName(),
//                user.getLastName(),
//                user.getPhoneNumber(),
//                user.getEmail(),
//                user.getPassword(),
//                user.getBirthday(),
//                user.getGender()
//        );
        userRepository.save(userCreated);
        return  userCreated;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUser(User user, String id) {
        User existingUser = userRepository.findById(id).get();
        existingUser.setFisrtName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setPhoneNumber(user.getPhoneNumber());
        existingUser.setBirthday(user.getBirthday());
        existingUser.setGender(user.getGender());
        User userSaved = userRepository.save(existingUser);
        return userSaved;
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
