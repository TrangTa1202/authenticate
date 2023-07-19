package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/user")
    public List<User> findAllUser() {
        return userService.findAllUsers();
    }

    @GetMapping("/user/{id}")
    public Optional<User> findById(@PathVariable("id") String id){
        return userService.findUserById(id);
    }

    @PatchMapping("/user/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") String id){
        return userService.updateUser(user, id);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(id);
    }
}
