package com.example.auth.controller;

import com.example.auth.entity.User;
import com.example.auth.entity.UserRequest;
import com.example.auth.entity.UserResponse;
import com.example.auth.security.JWTUtil;
import com.example.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired(required = false)
    private AuthenticationManager authenticationManager;

    @PostMapping("/saveUser")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        Integer id = userService.saveUser(user);
        return ResponseEntity.ok("Create a user successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody UserRequest userRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userRequest.getUsername(), userRequest.getPassword()
        ));
        String token = jwtUtil.generateToken(userRequest.getUsername());

        return ResponseEntity.ok(new UserResponse(token, "Token generated successfully"));
    }

    @PostMapping("/getData")
    public ResponseEntity<String> testAfterLogin(Principal principal) {
        return ResponseEntity.ok("Accessing data after logging in. You are : " + principal.getName());
    }
}
