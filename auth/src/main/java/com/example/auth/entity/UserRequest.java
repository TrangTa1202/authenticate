package com.example.auth.entity;

import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String password;
}