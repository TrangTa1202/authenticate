package com.example.auth.controller;

import com.example.auth.entity.User;
import com.example.auth.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser (@RequestBody User user) throws JsonProcessingException {
        User initUser = userService.createUser(user);
        return ResponseEntity.ok(initUser);
    }

    @GetMapping("/require_role_USER")
    public ResponseEntity<?> require_role_USER() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree("{\"Greeting\": \"You are USER\"}");
        return ResponseEntity.ok(jsonNode);
    }

    @GetMapping("/require_role_ADMIN")
    public ResponseEntity<?> require_role_ADMIN() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree("{\"Greeting\": \"You are ADMIN\"}");
        return ResponseEntity.ok(jsonNode);
    }
}
